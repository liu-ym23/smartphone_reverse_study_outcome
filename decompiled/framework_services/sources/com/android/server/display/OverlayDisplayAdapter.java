package com.android.server.display;

import android.R;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Slog;
import android.view.Display;
import android.view.DisplayShape;
import android.view.Gravity;
import android.view.Surface;
import android.view.SurfaceControl;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.IndentingPrintWriter;
import com.android.server.display.feature.DisplayManagerFlags;
import com.android.server.display.mode.DisplayModeDirector;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
final class OverlayDisplayAdapter extends DisplayAdapter {
    static final boolean DEBUG = false;
    private static final Pattern DISPLAY_PATTERN = null;
    private static final String DISPLAY_SPLITTER = ";";
    private static final String FLAG_SPLITTER = ",";
    private static final String GRAVITY_BOTTOM_LEFT = "gravity_bottom_left";
    private static final String GRAVITY_BOTTOM_RIGHT = "gravity_bottom_right";
    private static final String GRAVITY_TOP_LEFT = "gravity_top_left";
    private static final String GRAVITY_TOP_RIGHT = "gravity_top_right";
    private static final int MAX_HEIGHT = 4096;
    private static final int MAX_WIDTH = 4096;
    private static final int MIN_HEIGHT = 100;
    private static final int MIN_WIDTH = 100;
    private static final Pattern MODE_PATTERN = null;
    private static final String MODE_SPLITTER = "\\|";
    private static final String OVERLAY_DISPLAY_FLAG_DISABLE_WINDOW_INTERACTION = "disable_window_interaction";
    private static final String OVERLAY_DISPLAY_FLAG_FIXED_CONTENT_MODE = "fixed_content_mode";
    private static final String OVERLAY_DISPLAY_FLAG_OWN_CONTENT_ONLY = "own_content_only";
    private static final String OVERLAY_DISPLAY_FLAG_SECURE = "secure";
    private static final String OVERLAY_DISPLAY_FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS = "should_show_system_decorations";
    static final String TAG = "OverlayDisplayAdapter";
    private static final String UNIQUE_ID_PREFIX = "overlay:";
    private String mCurrentOverlaySetting;
    private final ArrayList<OverlayDisplayHandle> mOverlays;
    private final Handler mUiHandler;

    private abstract class OverlayDisplayDevice extends DisplayDevice {
        private int mActiveMode;
        private final int mDefaultMode;
        private final long mDisplayPresentationDeadlineNanos;
        private final OverlayFlags mFlags;
        private DisplayDeviceInfo mInfo;
        private final Display.Mode[] mModes;
        private final String mName;
        private final List<OverlayMode> mRawModes;
        private final float mRefreshRate;
        private int mState;
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        final /* synthetic */ OverlayDisplayAdapter this$0;

        public abstract void onModeChangedLocked(int r1);

        OverlayDisplayDevice(OverlayDisplayAdapter r17, IBinder displayToken, String name, List<OverlayMode> modes, int activeMode, int defaultMode, float refreshRate, long presentationDeadlineNanos, OverlayFlags flags, int state, SurfaceTexture surfaceTexture, int number) {
            this.this$0 = r17;
            super(r17, displayToken, OverlayDisplayAdapter.UNIQUE_ID_PREFIX + number, r17.getContext());
            this.mName = name;
            this.mRefreshRate = refreshRate;
            this.mDisplayPresentationDeadlineNanos = presentationDeadlineNanos;
            this.mFlags = flags;
            this.mState = state;
            this.mSurfaceTexture = surfaceTexture;
            this.mRawModes = modes;
            this.mModes = new Display.Mode[modes.size()];
            int i = 0;
        L4:
            if (i >= modes.size()) goto L6;
            OverlayMode mode = modes.get(i);
            this.mModes[i] = DisplayAdapter.createMode(mode.mWidth, mode.mHeight, refreshRate);
            i = i + 1;
            goto L4
        L6:
            this.mActiveMode = activeMode;
            this.mDefaultMode = defaultMode;
        }

        public void destroyLocked() {
            this.mSurfaceTexture = null;
            if (this.mSurface == null) goto L5;
            this.mSurface.release();
            this.mSurface = null;
        L5:
            DisplayControl.destroyVirtualDisplay(getDisplayTokenLocked());
        }

        @Override // com.android.server.display.DisplayDevice
        public boolean hasStableUniqueId() {
            return false;
        }

        @Override // com.android.server.display.DisplayDevice
        public void configureSurfaceLocked(SurfaceControl.Transaction t) {
            if (this.mSurfaceTexture != null) goto L5;
            return;
        L5:
            if (this.mSurface != null) goto L7;
            this.mSurface = new Surface(this.mSurfaceTexture);
        L7:
            setSurfaceLocked(t, this.mSurface);
        }

        public void setStateLocked(int state) {
            this.mState = state;
            this.mInfo = null;
        }

        @Override // com.android.server.display.DisplayDevice
        public DisplayDeviceInfo getDisplayDeviceInfoLocked() {
            if (this.mInfo != null) goto L24;
            Display.Mode mode = this.mModes[this.mActiveMode];
            OverlayMode rawMode = this.mRawModes.get(this.mActiveMode);
            this.mInfo = new DisplayDeviceInfo();
            this.mInfo.name = this.mName;
            this.mInfo.uniqueId = getUniqueId();
            this.mInfo.width = mode.getPhysicalWidth();
            this.mInfo.height = mode.getPhysicalHeight();
            this.mInfo.modeId = mode.getModeId();
            this.mInfo.renderFrameRate = mode.getRefreshRate();
            this.mInfo.defaultModeId = this.mModes[0].getModeId();
            this.mInfo.supportedModes = this.mModes;
            this.mInfo.densityDpi = rawMode.mDensityDpi;
            this.mInfo.xDpi = rawMode.mDensityDpi;
            this.mInfo.yDpi = rawMode.mDensityDpi;
            this.mInfo.presentationDeadlineNanos = this.mDisplayPresentationDeadlineNanos + (1000000000 / ((long) ((int) this.mRefreshRate)));
            this.mInfo.flags = 64;
            if (this.mFlags.mSecure == false) goto L8;
            this.mInfo.flags |= 4;
        L8:
            if (this.mFlags.mOwnContentOnly == false) goto L11;
            this.mInfo.flags |= 128;
        L11:
            if (this.mFlags.mShouldShowSystemDecorations == false) goto L14;
            this.mInfo.flags |= 4096;
        L14:
            if (this.this$0.getFeatureFlags().isDisplayContentModeManagementEnabled() == true) goto L16;
        L22:
            this.mInfo.type = 4;
            this.mInfo.touch = 3;
            this.mInfo.state = this.mState;
            this.mInfo.flags |= 8192;
            this.mInfo.displayShape = DisplayShape.createDefaultDisplayShape(this.mInfo.width, this.mInfo.height, false);
            goto L24
        L16:
            if (this.mFlags.mFixedContentMode == true) goto L22;
            if (this.mFlags.mOwnContentOnly == true) goto L22;
            if (this.mFlags.mShouldShowSystemDecorations == true) goto L22;
            this.mInfo.flags |= 1048576;
        L24:
            return this.mInfo;
        }

        @Override // com.android.server.display.DisplayDevice
        public void setDesiredDisplayModeSpecsLocked(DisplayModeDirector.DesiredDisplayModeSpecs displayModeSpecs) {
            int id = displayModeSpecs.baseModeId;
            int index = -1;
            if (id != 0) goto L5;
            index = 0;
        L13:
            if (index != (-1)) goto L16;
            Slog.w(OverlayDisplayAdapter.TAG, "Unable to locate mode " + id + ", reverting to default.");
            index = this.mDefaultMode;
        L16:
            if (this.mActiveMode != index) goto L18;
            return;
        L18:
            this.mActiveMode = index;
            this.mInfo = null;
            this.this$0.sendDisplayDeviceEventLocked(this, 2);
            onModeChangedLocked(index);
            return;
        L5:
            int i = 0;
        L7:
            if (i >= this.mModes.length) goto L13;
            if (this.mModes[i].getModeId() == id) goto L10;
            i = i + 1;
            goto L7
        L10:
            index = i;
            goto L13
        }
    }

    private final class OverlayDisplayHandle implements OverlayDisplayWindow.Listener {
        private static final int DEFAULT_MODE_INDEX = 0;
        private int mActiveMode;
        private OverlayDisplayDevice mDevice;
        private final Runnable mDismissRunnable;
        private final OverlayFlags mFlags;
        private final int mGravity;
        private final List<OverlayMode> mModes;
        private final String mName;
        private final int mNumber;
        private final Runnable mResizeRunnable;
        private final Runnable mShowRunnable;
        private OverlayDisplayWindow mWindow;
        final /* synthetic */ OverlayDisplayAdapter this$0;

        /* JADX INFO: renamed from: -$$Nest$fgetmActiveMode, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3855$$Nest$fgetmActiveMode(OverlayDisplayHandle r0) {
            return r0.mActiveMode;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmFlags, reason: not valid java name */
        static /* bridge */ /* synthetic */ OverlayFlags m3856$$Nest$fgetmFlags(OverlayDisplayHandle r0) {
            return r0.mFlags;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmGravity, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m3857$$Nest$fgetmGravity(OverlayDisplayHandle r0) {
            return r0.mGravity;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmModes, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m3858$$Nest$fgetmModes(OverlayDisplayHandle r0) {
            return r0.mModes;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m3859$$Nest$fgetmName(OverlayDisplayHandle r0) {
            return r0.mName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ OverlayDisplayWindow m3860$$Nest$fgetmWindow(OverlayDisplayHandle r0) {
            return r0.mWindow;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmWindow, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3861$$Nest$fputmWindow(OverlayDisplayHandle r0, OverlayDisplayWindow r1) {
            r0.mWindow = r1;
        }

        /* JADX INFO: renamed from: -$$Nest$monActiveModeChangedLocked, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m3862$$Nest$monActiveModeChangedLocked(OverlayDisplayHandle r0, int r1) {
            r0.onActiveModeChangedLocked(r1);
        }

        OverlayDisplayHandle(OverlayDisplayAdapter r1, String name, List<OverlayMode> modes, int gravity, OverlayFlags flags, int number) {
            this.this$0 = r1;
            this.mShowRunnable = new AnonymousClass2(this);
            this.mDismissRunnable = new AnonymousClass3(this);
            this.mResizeRunnable = new AnonymousClass4(this);
            this.mName = name;
            this.mModes = modes;
            this.mGravity = gravity;
            this.mFlags = flags;
            this.mNumber = number;
            this.mActiveMode = 0;
            showLocked();
        }

        private void showLocked() {
            OverlayDisplayAdapter.m3852$$Nest$fgetmUiHandler(this.this$0).post(this.mShowRunnable);
        }

        public void dismissLocked() {
            OverlayDisplayAdapter.m3852$$Nest$fgetmUiHandler(this.this$0).removeCallbacks(this.mShowRunnable);
            OverlayDisplayAdapter.m3852$$Nest$fgetmUiHandler(this.this$0).post(this.mDismissRunnable);
        }

        private void onActiveModeChangedLocked(int index) {
            OverlayDisplayAdapter.m3852$$Nest$fgetmUiHandler(this.this$0).removeCallbacks(this.mResizeRunnable);
            this.mActiveMode = index;
            if (this.mWindow == null) goto L6;
            OverlayDisplayAdapter.m3852$$Nest$fgetmUiHandler(this.this$0).post(this.mResizeRunnable);
            return;
        }

        @Override // com.android.server.display.OverlayDisplayWindow.Listener
        public void onWindowCreated(final SurfaceTexture surfaceTexture, final float refreshRate, final long presentationDeadlineNanos, final int state) {
            DisplayManagerService.SyncRoot r14 = this.this$0.getSyncRoot();
            monitor-enter(r14);
            final IBinder displayToken = DisplayControl.createVirtualDisplay(this.mName, this.mFlags.mSecure);     // Catch: Throwable -> L7
            final String r3 = this.mName;     // Catch: Throwable -> L7
            final List<OverlayMode> r4 = this.mModes;     // Catch: Throwable -> L7
            final int r5 = this.mActiveMode;     // Catch: Throwable -> L7
            final OverlayFlags r10 = this.mFlags;     // Catch: Throwable -> L7
            final int r13 = this.mNumber;     // Catch: Throwable -> L7
            final int r6 = 0;
            this.mDevice = new AnonymousClass1(this, displayToken, r3, r4, r5, r6, refreshRate, presentationDeadlineNanos, r10, state, surfaceTexture, r13);     // Catch: Throwable -> L7
            this.this$0.sendDisplayDeviceEventLocked(this.mDevice, 1);     // Catch: Throwable -> L7
            monitor-exit(r14);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.display.OverlayDisplayWindow.Listener
        public void onWindowDestroyed() {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mDevice == null) goto L9;
            this.mDevice.destroyLocked();     // Catch: Throwable -> L7
            this.this$0.sendDisplayDeviceEventLocked(this.mDevice, 3);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        @Override // com.android.server.display.OverlayDisplayWindow.Listener
        public void onStateChanged(int state) {
            DisplayManagerService.SyncRoot r0 = this.this$0.getSyncRoot();
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mDevice == null) goto L9;
            this.mDevice.setStateLocked(state);     // Catch: Throwable -> L7
            this.this$0.sendDisplayDeviceEventLocked(this.mDevice, 2);     // Catch: Throwable -> L7
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        public void dumpLocked(PrintWriter pw) {
            pw.println("  " + this.mName + ":");
            StringBuilder r0 = new StringBuilder();
            r0.append("    mModes=");
            r0.append(Arrays.toString(this.mModes.toArray()));
            pw.println(r0.toString());
            pw.println("    mActiveMode=" + this.mActiveMode);
            pw.println("    mGravity=" + this.mGravity);
            pw.println("    mFlags=" + this.mFlags);
            pw.println("    mNumber=" + this.mNumber);
            if (this.mWindow == null) goto L6;
            IndentingPrintWriter ipw = new IndentingPrintWriter(pw, "    ");
            ipw.increaseIndent();
            DumpUtils.dumpAsync(OverlayDisplayAdapter.m3852$$Nest$fgetmUiHandler(this.this$0), this.mWindow, ipw, "", 200);
            return;
        }
    }

    private static final class OverlayFlags {
        final boolean mDisableWindowInteraction;
        final boolean mFixedContentMode;
        final int mGravity;
        final boolean mOwnContentOnly;
        final boolean mSecure;
        final boolean mShouldShowSystemDecorations;

        OverlayFlags(boolean secure, boolean ownContentOnly, boolean shouldShowSystemDecorations, boolean fixedContentMode, boolean disableWindowInteraction, int gravity) {
            this.mSecure = secure;
            this.mOwnContentOnly = ownContentOnly;
            this.mShouldShowSystemDecorations = shouldShowSystemDecorations;
            this.mFixedContentMode = fixedContentMode;
            this.mDisableWindowInteraction = disableWindowInteraction;
            this.mGravity = gravity;
        }

        static OverlayFlags parseFlags(String flagString) {
            if (TextUtils.isEmpty(flagString) == true) goto L5;
            String[] r6 = flagString.split(OverlayDisplayAdapter.FLAG_SPLITTER);
            int r8 = r6.length;
            int r9 = 0;
            boolean secure = false;
            boolean ownContentOnly = false;
            boolean shouldShowSystemDecorations = false;
            boolean fixedContentMode = false;
            boolean disableWindowInteraction = false;
            int gravity = 0;
        L7:
            if (r9 >= r8) goto L26;
            String flag = r6[r9];
            if (OverlayDisplayAdapter.OVERLAY_DISPLAY_FLAG_SECURE.equals(flag) == false) goto L12;
            secure = true;
        L24:
            r9 = r9 + 1;
            goto L7
        L12:
            if (OverlayDisplayAdapter.OVERLAY_DISPLAY_FLAG_OWN_CONTENT_ONLY.equals(flag) == false) goto L15;
            ownContentOnly = true;
            goto L24
        L15:
            if (OverlayDisplayAdapter.OVERLAY_DISPLAY_FLAG_SHOULD_SHOW_SYSTEM_DECORATIONS.equals(flag) == false) goto L18;
            shouldShowSystemDecorations = true;
            goto L24
        L18:
            if (OverlayDisplayAdapter.OVERLAY_DISPLAY_FLAG_FIXED_CONTENT_MODE.equals(flag) == false) goto L21;
            fixedContentMode = true;
            goto L24
        L21:
            if (OverlayDisplayAdapter.OVERLAY_DISPLAY_FLAG_DISABLE_WINDOW_INTERACTION.equals(flag) == false) goto L23;
            disableWindowInteraction = true;
            goto L24
        L23:
            gravity = OverlayDisplayAdapter.m3854$$Nest$smparseOverlayGravity(flag);
            goto L24
        L26:
            return new OverlayFlags(secure, ownContentOnly, shouldShowSystemDecorations, fixedContentMode, disableWindowInteraction, gravity);
        L5:
            return new OverlayFlags(false, false, false, false, false, 0);
        }

        public String toString() {
            return "{secure=" + this.mSecure + ", ownContentOnly=" + this.mOwnContentOnly + ", shouldShowSystemDecorations=" + this.mShouldShowSystemDecorations + ", fixedContentMode=" + this.mFixedContentMode + ", disableWindowInteraction=" + this.mDisableWindowInteraction + ", gravity" + Gravity.toString(this.mGravity) + "}";
        }
    }

    private static final class OverlayMode {
        final int mDensityDpi;
        final int mHeight;
        final int mWidth;

        OverlayMode(int width, int height, int densityDpi) {
            this.mWidth = width;
            this.mHeight = height;
            this.mDensityDpi = densityDpi;
        }

        public String toString() {
            return "{width=" + this.mWidth + ", height=" + this.mHeight + ", densityDpi=" + this.mDensityDpi + "}";
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUiHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m3852$$Nest$fgetmUiHandler(OverlayDisplayAdapter r0) {
        return r0.mUiHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateOverlayDisplayDevices, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m3853$$Nest$mupdateOverlayDisplayDevices(OverlayDisplayAdapter r0) {
        r0.updateOverlayDisplayDevices();
    }

    /* JADX INFO: renamed from: -$$Nest$smparseOverlayGravity, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m3854$$Nest$smparseOverlayGravity(String r0) {
        return parseOverlayGravity(r0);
    }

    static {
        DISPLAY_PATTERN = Pattern.compile("([^,]+)(,[,_a-z]+)*");
        MODE_PATTERN = Pattern.compile("(\\d+)x(\\d+)/(\\d+)");
    }

    public OverlayDisplayAdapter(DisplayManagerService.SyncRoot syncRoot, Context context, Handler handler, DisplayAdapter.Listener listener, Handler uiHandler, DisplayManagerFlags featureFlags) {
        super(syncRoot, context, handler, listener, TAG, featureFlags);
        this.mOverlays = new ArrayList();
        this.mCurrentOverlaySetting = "";
        this.mUiHandler = uiHandler;
    }

    @Override // com.android.server.display.DisplayAdapter
    public void dumpLocked(PrintWriter pw) {
        super.dumpLocked(pw);
        pw.println("mCurrentOverlaySetting=" + this.mCurrentOverlaySetting);
        pw.println("mOverlays: size=" + this.mOverlays.size());
        Iterator<OverlayDisplayHandle> r0 = this.mOverlays.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        OverlayDisplayHandle overlay = r0.next();
        overlay.dumpLocked(pw);
        goto L4
    }

    @Override // com.android.server.display.DisplayAdapter
    public void registerLocked() {
        super.registerLocked();
        getHandler().post(new AnonymousClass1(this));
    }

    private void updateOverlayDisplayDevices() {
        DisplayManagerService.SyncRoot r0 = getSyncRoot();
        monitor-enter(r0);
        updateOverlayDisplayDevicesLocked();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateOverlayDisplayDevicesLocked() {
        OverlayDisplayAdapter r1 = this;
        String value = Settings.Global.getString(r1.getContext().getContentResolver(), "overlay_display_devices");
        if (value != null) goto L5;
        String value2 = "";
    L7:
        if (value2.equals(r1.mCurrentOverlaySetting) == false) goto L9;
        return;
    L9:
        r1.mCurrentOverlaySetting = value2;
        if (r1.mOverlays.isEmpty() == true) goto L16;
        Slog.i(TAG, "Dismissing all overlay display devices.");
        Iterator<OverlayDisplayHandle> r0 = r1.mOverlays.iterator();
    L13:
        if (r0.hasNext() == false) goto L15;
        OverlayDisplayHandle overlay = r0.next();
        overlay.dismissLocked();
        goto L13
    L15:
        r1.mOverlays.clear();
    L16:
        String[] r9 = value2.split(DISPLAY_SPLITTER);
        int r10 = r9.length;
        int count = 0;
        int r12 = 0;
    L17:
        if (r12 >= r10) goto L70;
        String part = r9[r12];
        Matcher displayMatcher = DISPLAY_PATTERN.matcher(part);
        if (displayMatcher.matches() == true) goto L21;
        int count2 = count;
    L67:
        Slog.w(TAG, "Malformed overlay display devices setting: " + value2);
        count = count2;
    L68:
        r12 = r12 + 1;
        r1 = this;
        r9 = r9;
        goto L17
    L21:
        if (count >= 4) goto L22;
        String modeString = displayMatcher.group(1);
        String flagString = displayMatcher.group(2);
        ArrayList<OverlayMode> modes = new ArrayList();
        String[] r6 = modeString.split(MODE_SPLITTER);
        int r11 = r6.length;
        int r4 = 0;
    L24:
        if (r4 >= r11) goto L58;
        String mode = r6[r4];
        int count3 = count;
        Matcher modeMatcher = MODE_PATTERN.matcher(mode);
        if (modeMatcher.matches() == false) goto L55;
        int r20 = r4;
        int width = Integer.parseInt(modeMatcher.group(1), 10);     // Catch: NumberFormatException -> L52
        String[] r17 = r6;
        int height = Integer.parseInt(modeMatcher.group(2), 10);     // Catch: NumberFormatException -> L49
        int densityDpi = Integer.parseInt(modeMatcher.group(3), 10);     // Catch: NumberFormatException -> L45
        if (width >= 100) goto L35;
    L47:
        Slog.w(TAG, "Ignoring out-of-range overlay display mode: " + mode);     // Catch: NumberFormatException -> L45
        goto L57
    L35:
        if (width > 4096) goto L47;
        if (height < 100) goto L47;
        if (height > 4096) goto L47;
        if (densityDpi < 120) goto L47;
        if (densityDpi > 640) goto L47;
        modes.add(new OverlayMode(width, height, densityDpi));     // Catch: NumberFormatException -> L45
    L57:
        r4 = r20 + 1;
        r6 = r17;
        count = count3;
    L53:
        r17 = r6;
        goto L57
    L55:
        r20 = r4;
        r17 = r6;
        if (mode.isEmpty() == false) goto L57;
        goto L57
    L58:
        count2 = count;
        if (modes.isEmpty() == true) goto L67;
        int count4 = count2 + 1;
        String name = r1.getContext().getResources().getString(R.string.etws_primary_default_message_tsunami, new Object[]{Integer.valueOf(count4)});
        OverlayFlags flags = OverlayFlags.parseFlags(flagString);
        int gravity = flags.mGravity;
        if (flags.mGravity != 0) goto L63;
        int gravity2 = chooseOverlayGravity(count4);
        int gravity3 = gravity2;
    L64:
        Slog.i(TAG, "Showing overlay display device #" + count4 + ": name=" + name + ", modes=" + Arrays.toString(modes.toArray()) + ", flags=" + flags);
        r9 = r9;
        r1.mOverlays.add(new OverlayDisplayHandle(r1, name, modes, gravity3, flags, count4));
        count = count4;
        goto L68
    L63:
        gravity3 = gravity;
        goto L64
    L22:
        Slog.w(TAG, "Too many overlay display devices specified: " + value2);
        return;
    L70:
        return;
    L5:
        value2 = value;
        goto L7
    }

    private static int chooseOverlayGravity(int overlayNumber) {
        switch(overlayNumber) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L3;
        };
    L3:
        return 83;
    L5:
        return 53;
    L7:
        return 85;
    L9:
        return 51;
    }

    private static int parseOverlayGravity(String overlayGravity) {
        switch(overlayGravity.hashCode()) {
            case -1930045095: goto L15;
            case 752196482: goto L12;
            case 1848915457: goto L9;
            case 2015767850: goto L6;
            default: goto L17;
        };
    L17:
        byte r0 = -1;
    L18:
        switch(r0) {
            case 0: goto L23;
            case 1: goto L22;
            case 2: goto L21;
            case 3: goto L20;
            default: goto L28;
        };
    L20:
        return 83;
    L21:
        return 85;
    L22:
        return 53;
    L23:
        return 51;
    L28:
        return 0;
    L6:
        if (overlayGravity.equals(GRAVITY_BOTTOM_LEFT) == false) goto L17;
        r0 = 3;
        goto L18
    L9:
        if (overlayGravity.equals(GRAVITY_TOP_RIGHT) == false) goto L17;
        r0 = 1;
        goto L18
    L12:
        if (overlayGravity.equals(GRAVITY_TOP_LEFT) == false) goto L17;
        r0 = 0;
        goto L18
    L15:
        if (overlayGravity.equals(GRAVITY_BOTTOM_RIGHT) == false) goto L17;
        r0 = 2;
        goto L18
    }
}
