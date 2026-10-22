package com.android.server.input;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.hardware.input.InputDeviceIdentifier;
import android.hardware.input.InputManager;
import android.hardware.input.KeyboardLayout;
import android.hardware.input.KeyboardLayoutSelectionResult;
import android.icu.lang.UScript;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.os.Looper;
import android.os.Message;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.util.Slog;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.KeyCharacterMap;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.R;
import com.android.internal.inputmethod.InputMethodSubtypeHandle;
import com.android.internal.util.XmlUtils;
import com.android.server.LocalServices;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.inputmethod.InputMethodManagerInternal;
import com.android.server.pm.Settings;
import com.android.server.slice.SliceClientPermissions;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import libcore.io.Streams;

/* JADX INFO: loaded from: classes2.dex */
class KeyboardLayoutManager implements InputManager.InputDeviceListener {
    private static final boolean DEBUG = false;
    private static final String GLOBAL_OVERRIDE_KEY = "GLOBAL_OVERRIDE_KEY";
    private static final int MSG_RELOAD_KEYBOARD_LAYOUTS = 2;
    private static final int MSG_UPDATE_EXISTING_DEVICES = 1;
    private static final int MSG_UPDATE_KEYBOARD_LAYOUTS = 3;
    private static final String TAG = "KeyboardLayoutManager";
    private HashSet<String> mAvailableLayouts;
    private final SparseArray<KeyboardConfiguration> mConfiguredKeyboards;
    private final Context mContext;
    private ImeInfo mCurrentImeInfo;
    private final PersistentDataStore mDataStore;
    private final Handler mHandler;
    private final Object mImeInfoLock;
    private final Map<String, KeyboardLayoutSelectionResult> mKeyboardLayoutCache;
    private final NativeInputManagerService mNative;

    public static class ImeInfo {
        InputMethodSubtype mImeSubtype;
        InputMethodSubtypeHandle mImeSubtypeHandle;
        int mUserId;

        ImeInfo(int userId, InputMethodSubtypeHandle imeSubtypeHandle, InputMethodSubtype imeSubtype) {
            this.mUserId = userId;
            this.mImeSubtypeHandle = imeSubtypeHandle;
            this.mImeSubtype = imeSubtype;
        }

        ImeInfo(int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype) {
            this(userId, InputMethodSubtypeHandle.of(imeInfo, imeSubtype), imeSubtype);
        }
    }

    private static class KeyboardConfiguration {
        private Set<String> mConfiguredLayouts;
        private final int mDeviceId;

        /* JADX INFO: renamed from: -$$Nest$mgetConfiguredLayouts, reason: not valid java name */
        static /* bridge */ /* synthetic */ Set m4586$$Nest$mgetConfiguredLayouts(KeyboardConfiguration r0) {
            return r0.getConfiguredLayouts();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetDeviceId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m4587$$Nest$mgetDeviceId(KeyboardConfiguration r0) {
            return r0.getDeviceId();
        }

        /* JADX INFO: renamed from: -$$Nest$mhasConfiguredLayouts, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m4588$$Nest$mhasConfiguredLayouts(KeyboardConfiguration r0) {
            return r0.hasConfiguredLayouts();
        }

        /* JADX INFO: renamed from: -$$Nest$msetConfiguredLayouts, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m4589$$Nest$msetConfiguredLayouts(KeyboardConfiguration r0, Set r1) {
            r0.setConfiguredLayouts(r1);
        }

        /* synthetic */ KeyboardConfiguration(int r1, KeyboardLayoutManagerIA r2) {
            this(r1);
        }

        private KeyboardConfiguration(int deviceId) {
            this.mDeviceId = deviceId;
        }

        private int getDeviceId() {
            return this.mDeviceId;
        }

        private boolean hasConfiguredLayouts() {
            if (this.mConfiguredLayouts != null) goto L5;
        L7:
            return false;
        L5:
            if (this.mConfiguredLayouts.isEmpty() == true) goto L7;
            return true;
        }

        private Set<String> getConfiguredLayouts() {
            return this.mConfiguredLayouts;
        }

        private void setConfiguredLayouts(Set<String> configuredLayouts) {
            this.mConfiguredLayouts = configuredLayouts;
        }
    }

    private static class KeyboardIdentifier {
        private final InputDeviceIdentifier mIdentifier;
        private final String mLanguageTag;
        private final String mLayoutType;

        /* JADX INFO: renamed from: -$$Nest$fgetmIdentifier, reason: not valid java name */
        static /* bridge */ /* synthetic */ InputDeviceIdentifier m4590$$Nest$fgetmIdentifier(KeyboardIdentifier r0) {
            return r0.mIdentifier;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLanguageTag, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4591$$Nest$fgetmLanguageTag(KeyboardIdentifier r0) {
            return r0.mLanguageTag;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmLayoutType, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m4592$$Nest$fgetmLayoutType(KeyboardIdentifier r0) {
            return r0.mLayoutType;
        }

        /* synthetic */ KeyboardIdentifier(InputDeviceIdentifier r1, String r2, String r3, KeyboardLayoutManagerIA r4) {
            this(r1, r2, r3);
        }

        /* synthetic */ KeyboardIdentifier(InputDevice r1, KeyboardLayoutManagerIA r2) {
            this(r1);
        }

        private KeyboardIdentifier(InputDeviceIdentifier inputDeviceIdentifier) {
            this(inputDeviceIdentifier, null, null);
        }

        private KeyboardIdentifier(InputDevice inputDevice) {
            this(inputDevice.getIdentifier(), inputDevice.getKeyboardLanguageTag(), inputDevice.getKeyboardLayoutType());
        }

        private KeyboardIdentifier(InputDeviceIdentifier identifier, String languageTag, String layoutType) {
            identifier.getClass();
            identifier.getDescriptor().getClass();
            this.mIdentifier = identifier;
            this.mLanguageTag = languageTag;
            this.mLayoutType = layoutType;
        }

        public int hashCode() {
            return Objects.hashCode(toString());
        }

        public String toString() {
            if (this.mIdentifier.getVendorId() == 0) goto L5;
        L8:
            StringBuilder key = new StringBuilder();
            key.append("vendor:");
            key.append(this.mIdentifier.getVendorId());
            key.append(",product:");
            key.append(this.mIdentifier.getProductId());
            if (TextUtils.isEmpty(this.mLanguageTag) == true) goto L12;
            key.append(",languageTag:");
            key.append(this.mLanguageTag);
        L12:
            if (TextUtils.isEmpty(this.mLayoutType) == true) goto L15;
            key.append(",layoutType:");
            key.append(this.mLayoutType);
        L15:
            return key.toString();
        L5:
            if (this.mIdentifier.getProductId() != 0) goto L8;
            return this.mIdentifier.getDescriptor();
        }
    }

    private static final class KeyboardLayoutDescriptor {
        public String keyboardLayoutName;
        public String packageName;
        public String receiverName;

        private KeyboardLayoutDescriptor() {
        }

        public static String format(String packageName, String receiverName, String keyboardName) {
            return packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiverName + SliceClientPermissions.SliceAuthority.DELIMITER + keyboardName;
        }

        public static KeyboardLayoutDescriptor parse(String descriptor) {
            int pos = descriptor.indexOf(47);
            if (pos >= 0) goto L5;
        L15:
            return null;
        L5:
            if ((pos + 1) == descriptor.length()) goto L15;
            int pos2 = descriptor.indexOf(47, pos + 1);
            if (pos2 >= (pos + 2)) goto L10;
        L14:
            return null;
        L10:
            if ((pos2 + 1) == descriptor.length()) goto L14;
            KeyboardLayoutDescriptor result = new KeyboardLayoutDescriptor();
            result.packageName = descriptor.substring(0, pos);
            result.receiverName = descriptor.substring(pos + 1, pos2);
            result.keyboardLayoutName = descriptor.substring(pos2 + 1);
            return result;
        }
    }

    private interface KeyboardLayoutVisitor {
        void visitKeyboardLayout(Resources r1, int r2, KeyboardLayout r3);
    }

    private static class LayoutKey {
        private final ImeInfo mImeInfo;
        private final KeyboardIdentifier mKeyboardIdentifier;

        /* synthetic */ LayoutKey(KeyboardIdentifier r1, ImeInfo r2, KeyboardLayoutManagerIA r3) {
            this(r1, r2);
        }

        private LayoutKey(KeyboardIdentifier keyboardIdentifier, ImeInfo imeInfo) {
            this.mKeyboardIdentifier = keyboardIdentifier;
            this.mImeInfo = imeInfo;
        }

        public int hashCode() {
            return Objects.hashCode(toString());
        }

        public String toString() {
            if (this.mImeInfo == null) goto L5;
            this.mImeInfo.mImeSubtypeHandle.getClass();
            return "layoutDescriptor:" + this.mKeyboardIdentifier + ",userId:" + this.mImeInfo.mUserId + ",subtypeHandle:" + this.mImeInfo.mImeSubtypeHandle.toStringHandle();
        L5:
            return this.mKeyboardIdentifier.toString();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0iY-rg5rUX2ZaLI0oVrWwXSKQmk, reason: not valid java name */
    public static /* synthetic */ void m4581$r8$lambda$0iYrg5rUX2ZaLI0oVrWwXSKQmk(HashSet r0, Resources r1, int r2, KeyboardLayout r3) {
        lambda$updateKeyboardLayouts$0(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$7iQj0jjk-eFw6kYeLWA-b0HrEv8, reason: not valid java name */
    public static /* synthetic */ void m4582$r8$lambda$7iQj0jjkeFw6kYeLWAb0HrEv8(String[] r0, Resources r1, int r2, KeyboardLayout r3) {
        lambda$getKeyboardLayoutOverlay$4(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$JJmyN_gbx7JdjQc5Ly0u88rG3wU(String[] r0, Resources r1, int r2, KeyboardLayout r3) {
        lambda$getKeyCharacterMap$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$ZQJeHlJ93XeknKBRAs6ih8Jm3J0(ArrayList r0, Resources r1, int r2, KeyboardLayout r3) {
        lambda$getKeyboardLayouts$1(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$y-LzIDNoOFY2WLN0_gSck9p-JRA, reason: not valid java name */
    public static /* synthetic */ boolean m4583$r8$lambda$yLzIDNoOFY2WLN0_gSck9pJRA(KeyboardLayoutManager r0, Message r1) {
        return r0.handleMessage(r1);
    }

    public static /* synthetic */ void $r8$lambda$yIVDCH8D_p14_UbLsOp9Rf_yMsQ(KeyboardLayout[] r0, Resources r1, int r2, KeyboardLayout r3) {
        lambda$getKeyboardLayout$2(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateKeyboardLayouts, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m4584$$Nest$mupdateKeyboardLayouts(KeyboardLayoutManager r0) {
        r0.updateKeyboardLayouts();
    }

    /* JADX INFO: renamed from: -$$Nest$smisLayoutCompatibleWithLanguageTag, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m4585$$Nest$smisLayoutCompatibleWithLanguageTag(KeyboardLayout r0, String r1) {
        return isLayoutCompatibleWithLanguageTag(r0, r1);
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    KeyboardLayoutManager(Context context, NativeInputManagerService nativeService, PersistentDataStore dataStore, Looper looper) {
        this.mConfiguredKeyboards = new SparseArray();
        this.mKeyboardLayoutCache = new ArrayMap();
        this.mAvailableLayouts = new HashSet();
        this.mImeInfoLock = new Object();
        this.mContext = context;
        this.mNative = nativeService;
        this.mDataStore = dataStore;
        this.mHandler = new Handler(looper, new KeyboardLayoutManager$$ExternalSyntheticLambda4(this), true);
    }

    public void systemRunning() {
        IntentFilter filter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        filter.addAction("android.intent.action.PACKAGE_REMOVED");
        filter.addAction("android.intent.action.PACKAGE_CHANGED");
        filter.addAction("android.intent.action.PACKAGE_REPLACED");
        filter.addDataScheme(Settings.ATTR_PACKAGE);
        this.mContext.registerReceiver(new AnonymousClass1(this), filter, null, this.mHandler);
        this.mHandler.sendEmptyMessage(3);
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        inputManager.getClass();
        inputManager.registerInputDeviceListener(this, this.mHandler);
        Message msg = Message.obtain(this.mHandler, 1, inputManager.getInputDeviceIds());
        this.mHandler.sendMessage(msg);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceAdded(int deviceId) {
        onInputDeviceChangedInternal(deviceId, true);
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceRemoved(int deviceId) {
        this.mConfiguredKeyboards.remove(deviceId);
        maybeUpdateNotification();
    }

    @Override // android.hardware.input.InputManager.InputDeviceListener
    public void onInputDeviceChanged(int deviceId) {
        onInputDeviceChangedInternal(deviceId, false);
    }

    private void onInputDeviceChangedInternal(int deviceId, boolean shouldLogConfiguration) {
        InputDevice inputDevice = getInputDevice(deviceId);
        if (inputDevice != null) goto L5;
        return;
    L5:
        if (inputDevice.isVirtual() == false) goto L7;
        return;
    L7:
        if (inputDevice.isFullKeyboard() == false) goto L58;
        KeyboardLayoutManagerIA r2 = null;
        KeyboardIdentifier keyboardIdentifier = new KeyboardIdentifier(inputDevice, r2);
        KeyboardConfiguration config = this.mConfiguredKeyboards.get(deviceId);
        if (config != null) goto L12;
        config = new KeyboardConfiguration(deviceId, r2);
        this.mConfiguredKeyboards.put(deviceId, config);
    L12:
        boolean needToShowNotification = false;
        Set<String> selectedLayouts = new HashSet();
        List<ImeInfo> imeInfoList = getImeInfoListForLayoutMapping();
        List<KeyboardLayoutSelectionResult> resultList = new ArrayList();
        boolean hasMissingLayout = false;
        Iterator<ImeInfo> r8 = imeInfoList.iterator();
    L14:
        if (r8.hasNext() == false) goto L21;
        ImeInfo imeInfo = r8.next();
        KeyboardLayoutSelectionResult result = getKeyboardLayoutForInputDeviceInternal(keyboardIdentifier, imeInfo);
        if (result.getLayoutDescriptor() == null) goto L18;
        selectedLayouts.add(result.getLayoutDescriptor());
    L19:
        resultList.add(result);
        goto L14
    L18:
        hasMissingLayout = true;
        goto L19
    L21:
        if (DEBUG == false) goto L23;
        Slog.d(TAG, "Layouts selected for input device: " + keyboardIdentifier + " -> selectedLayouts: " + selectedLayouts);
    L23:
        if (hasMissingLayout == false) goto L25;
        selectedLayouts.clear();
    L25:
        KeyboardConfiguration.m4589$$Nest$msetConfiguredLayouts(config, selectedLayouts);
        PersistentDataStore r9 = this.mDataStore;
        monitor-enter(r9);
        String key = keyboardIdentifier.toString();     // Catch: Throwable -> L37
        if (this.mDataStore.setSelectedKeyboardLayouts(key, selectedLayouts) == false) goto L30;
        needToShowNotification = true;
    L30:
        if (shouldLogConfiguration == true) goto L32;
    L39:
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L44
        monitor-exit(r9);     // Catch: Throwable -> L44
        if (needToShowNotification == false) goto L56;
        maybeUpdateNotification();
        return;
    L56:
        return;
    L32:
        if (this.mDataStore.hasInputDeviceEntry(key) == true) goto L34;
        boolean r10 = true;
    L35:
        logKeyboardConfigurationEvent(inputDevice, imeInfoList, resultList, r10);     // Catch: Throwable -> L37
    L34:
        r10 = false;
    L44:
        th = move-exception;
        throw th;
    L37:
        th = move-exception;
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L44
        throw th;     // Catch: Throwable -> L44
    }

    private void updateKeyboardLayouts() {
        final HashSet<String> availableKeyboardLayouts = new HashSet();
        visitAllKeyboardLayouts(new KeyboardLayoutManager$$ExternalSyntheticLambda5(availableKeyboardLayouts));
        if (this.mAvailableLayouts.equals(availableKeyboardLayouts) == false) goto L5;
        return;
    L5:
        this.mAvailableLayouts = availableKeyboardLayouts;
        PersistentDataStore r1 = this.mDataStore;
        monitor-enter(r1);
        this.mDataStore.removeUninstalledKeyboardLayouts(availableKeyboardLayouts);     // Catch: Throwable -> L21
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L19
        monitor-exit(r1);     // Catch: Throwable -> L19
        Map<String, KeyboardLayoutSelectionResult> r2 = this.mKeyboardLayoutCache;
        monitor-enter(r2);
        this.mKeyboardLayoutCache.clear();     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        reloadKeyboardLayouts();
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        th = move-exception;
        throw th;
    L21:
        th = move-exception;
        this.mDataStore.saveIfNeeded();     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    }

    private static /* synthetic */ void lambda$updateKeyboardLayouts$0(HashSet availableKeyboardLayouts, Resources resources, int keyboardLayoutResId, KeyboardLayout layout) {
        availableKeyboardLayouts.add(layout.getDescriptor());
    }

    public KeyboardLayout[] getKeyboardLayouts() {
        final ArrayList<KeyboardLayout> list = new ArrayList();
        visitAllKeyboardLayouts(new KeyboardLayoutManager$$ExternalSyntheticLambda2(list));
        return (KeyboardLayout[]) list.toArray(new KeyboardLayout[0]);
    }

    private static /* synthetic */ void lambda$getKeyboardLayouts$1(ArrayList list, Resources resources, int keyboardLayoutResId, KeyboardLayout layout) {
        list.add(layout);
    }

    public KeyboardLayout getKeyboardLayout(String keyboardLayoutDescriptor) {
        keyboardLayoutDescriptor.getClass();
        final KeyboardLayout[] result = new KeyboardLayout[1];
        visitKeyboardLayout(keyboardLayoutDescriptor, new KeyboardLayoutManager$$ExternalSyntheticLambda0(result));
        if (result[0] != null) goto L6;
        Slog.w(TAG, "Could not get keyboard layout with descriptor '" + keyboardLayoutDescriptor + "'.");
    L6:
        return result[0];
    }

    private static /* synthetic */ void lambda$getKeyboardLayout$2(KeyboardLayout[] result, Resources resources, int keyboardLayoutResId, KeyboardLayout layout) {
        result[0] = layout;
    }

    public KeyCharacterMap getKeyCharacterMap(String layoutDescriptor) {
        final String[] overlay = new String[1];
        visitKeyboardLayout(layoutDescriptor, new KeyboardLayoutManager$$ExternalSyntheticLambda3(overlay));
        if (TextUtils.isEmpty(overlay[0]) == false) goto L7;
        return KeyCharacterMap.load(-1);
    L7:
        return KeyCharacterMap.load(layoutDescriptor, overlay[0]);
    }

    private static /* synthetic */ void lambda$getKeyCharacterMap$3(String[] overlay, Resources resources, int keyboardLayoutResId, KeyboardLayout layout) {
        InputStreamReader stream = new InputStreamReader(resources.openRawResource(keyboardLayoutResId));     // Catch: Throwable -> L6
        overlay[0] = Streams.readFully(stream);     // Catch: Throwable -> L8
        stream.close();     // Catch: Throwable -> L6 Throwable -> L6
        return;
    L8:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L6 Throwable -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6 Throwable -> L6
        goto L13
    }

    private void visitAllKeyboardLayouts(KeyboardLayoutVisitor visitor) {
        PackageManager pm = this.mContext.getPackageManager();
        Intent intent = new Intent("android.hardware.input.action.QUERY_KEYBOARD_LAYOUTS");
        Iterator r7 = pm.queryBroadcastReceiversAsUser(intent, 786560, 0).iterator();
    L4:
        if (r7.hasNext() == false) goto L12;
        ResolveInfo resolveInfo = (ResolveInfo) r7.next();
        if (resolveInfo == null) goto L4;
        if (resolveInfo.activityInfo == null) goto L4;
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        int priority = resolveInfo.priority;
        visitKeyboardLayoutsInPackage(pm, activityInfo, null, priority, visitor);
        goto L4
    }

    private void visitKeyboardLayout(String keyboardLayoutDescriptor, KeyboardLayoutVisitor visitor) {
        KeyboardLayoutDescriptor d = KeyboardLayoutDescriptor.parse(keyboardLayoutDescriptor);
        if (d == null) goto L14;
        PackageManager pm = this.mContext.getPackageManager();
        ActivityInfo receiver = pm.getReceiverInfo(new ComponentName(d.packageName, d.receiverName), 786560);     // Catch: PackageManager.NameNotFoundException -> L11
        visitKeyboardLayoutsInPackage(pm, receiver, d.keyboardLayoutName, 0, visitor);     // Catch: PackageManager.NameNotFoundException -> L9
        return;
    L21:
        return;
    L19:
        return;
    }

    private void visitKeyboardLayoutsInPackage(PackageManager pm, ActivityInfo receiver, String keyboardName, int requestedPriority, KeyboardLayoutVisitor visitor) {
        Bundle metaData = receiver.metaData;
        if (metaData != null) goto L5;
        return;
    L5:
        int configResId = metaData.getInt("android.hardware.input.metadata.KEYBOARD_LAYOUTS");
        if (configResId != 0) goto L9;
        Slog.w(TAG, "Missing meta-data 'android.hardware.input.metadata.KEYBOARD_LAYOUTS' on receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name);
        return;
    L9:
        CharSequence receiverLabel = receiver.loadLabel(pm);
        if (receiverLabel == null) goto L12;
        String r0 = receiverLabel.toString();
    L13:
        String collection = r0;
        int r9 = 1;
        if ((receiver.applicationInfo.flags & 1) == 0) goto L16;
        int priority = requestedPriority;
    L96:
        Resources resources = pm.getResourcesForApplication(receiver.applicationInfo);     // Catch: Exception -> L82
        XmlResourceParser parser = resources.getXml(configResId);     // Catch: Exception -> L82
        XmlUtils.beginDocument(parser, "keyboard-layouts");     // Catch: Throwable -> L69
    L20:
        XmlUtils.nextElement(parser);     // Catch: Throwable -> L69
        String element = parser.getName();     // Catch: Throwable -> L69
        if (element != null) goto L28;
        parser.close();     // Catch: Exception -> L25
        return;
    L25:
        ex = e;
    L84:
        Slog.w(TAG, "Could not parse keyboard layout resource from receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name, ex);
        return;
    L28:
        if (element.equals("keyboard-layout") == false) goto L71;
        TypedArray a = resources.obtainAttributes(parser, R.styleable.KeyboardLayout);     // Catch: Throwable -> L69
        String name = a.getString(r9);     // Catch: Throwable -> L65
        String label = a.getString(0);     // Catch: Throwable -> L65
        int keyboardLayoutResId = a.getResourceId(2, 0);     // Catch: Throwable -> L65
        String languageTags = a.getString(3);     // Catch: Throwable -> L65
        LocaleList locales = getLocalesFromLanguageTags(languageTags);     // Catch: Throwable -> L65
        int layoutType = a.getInt(4, 0);     // Catch: Throwable -> L58
        int vid = a.getInt(6, -1);     // Catch: Throwable -> L58
        int pid = a.getInt(5, -1);     // Catch: Throwable -> L58
        if (name == null) goto L90;
        if (label == null) goto L90;
        if (keyboardLayoutResId == 0) goto L90;
        String descriptor = KeyboardLayoutDescriptor.format(receiver.packageName, receiver.name, name);     // Catch: Throwable -> L58
        if (keyboardName == 0) goto L107;
        if (name.equals(keyboardName) == true) goto L107;
        resources = resources;
        parser = parser;
        a = a;
    L88:
        a.recycle();     // Catch: Throwable -> L63
    L72:
        resources = resources;
        parser = parser;
        metaData = metaData;
        configResId = configResId;
        r9 = 1;
    L63:
        th = move-exception;
        Throwable r1 = th;
    L73:
        if (parser != null) goto L102;
        throw r1;     // Catch: Exception -> L78
    L78:
        ex = e;
        goto L84
    L102:
        parser.close();     // Catch: Throwable -> L76
    L112:
        throw r1;     // Catch: Exception -> L78
    L76:
        th = move-exception;
        r1.addSuppressed(th);     // Catch: Exception -> L78
        throw r1;     // Catch: Exception -> L78
    L44:
        th = th;
        parser = parser;
        a = a;
    L67:
        a.recycle();     // Catch: Throwable -> L63
        throw th;     // Catch: Throwable -> L63
    L107:
        resources = resources;
        parser = parser;
        a = a;
        KeyboardLayout layout = new KeyboardLayout(descriptor, label, collection, priority, locales, layoutType, vid, pid);     // Catch: Throwable -> L54
        visitor.visitKeyboardLayout(resources, keyboardLayoutResId, layout);     // Catch: Throwable -> L52
    L54:
        th = th;
    L56:
        th = th;
        parser = parser;
        a = a;
    L90:
        Slog.w(TAG, "Missing required 'name', 'label' or 'keyboardLayout' attributes in keyboard layout resource from receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name);     // Catch: Throwable -> L52
    L52:
        th = th;
    L58:
        th = th;
        parser = parser;
        a = a;
    L65:
        th = th;
        parser = parser;
        a = a;
        goto L67
    L71:
        resources = resources;
        parser = parser;
        Slog.w(TAG, "Skipping unrecognized element '" + element + "' in keyboard layout resource from receiver " + receiver.packageName + SliceClientPermissions.SliceAuthority.DELIMITER + receiver.name);     // Catch: Throwable -> L63
    L69:
        th = move-exception;
        parser = parser;
        r1 = th;
    L82:
        ex = e;
        goto L84
    L16:
        priority = 0;
        goto L96
    L12:
        r0 = "";
        goto L13
    }

    private static LocaleList getLocalesFromLanguageTags(String languageTags) {
        if (TextUtils.isEmpty(languageTags) == false) goto L7;
        return LocaleList.getEmptyLocaleList();
    L7:
        return LocaleList.forLanguageTags(languageTags.replace('|', ','));
    }

    public String[] getKeyboardLayoutOverlay(InputDeviceIdentifier identifier, String languageTag, String layoutType) {
        Object r0 = this.mImeInfoLock;
        monitor-enter(r0);
        String keyboardLayoutDescriptor = getKeyboardLayoutForInputDeviceInternal(new KeyboardIdentifier(identifier, languageTag, layoutType, null), this.mCurrentImeInfo).getLayoutDescriptor();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        if (keyboardLayoutDescriptor != null) goto L8;
        return null;
    L8:
        final String[] result = new String[2];
        visitKeyboardLayout(keyboardLayoutDescriptor, new KeyboardLayoutManager$$ExternalSyntheticLambda1(result));
        if (result[0] != null) goto L12;
        Slog.w(TAG, "Could not get keyboard layout with descriptor '" + keyboardLayoutDescriptor + "'.");
        return null;
    L12:
        return result;
    L13:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ void lambda$getKeyboardLayoutOverlay$4(String[] result, Resources resources, int keyboardLayoutResId, KeyboardLayout layout) {
        InputStreamReader stream = new InputStreamReader(resources.openRawResource(keyboardLayoutResId));     // Catch: Throwable -> L6
        result[0] = layout.getDescriptor();     // Catch: Throwable -> L8
        result[1] = Streams.readFully(stream);     // Catch: Throwable -> L8
        stream.close();     // Catch: Throwable -> L6 Throwable -> L6
        return;
    L8:
        th = move-exception;
        stream.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L6 Throwable -> L6
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L6 Throwable -> L6
        goto L13
    }

    public KeyboardLayoutSelectionResult getKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype) {
        InputDevice inputDevice = getInputDevice(identifier);
        if (inputDevice == null) goto L14;
        if (inputDevice.isVirtual() == true) goto L14;
        if (inputDevice.isFullKeyboard() == false) goto L14;
        KeyboardIdentifier keyboardIdentifier = new KeyboardIdentifier(inputDevice, null);
        KeyboardLayoutSelectionResult result = getKeyboardLayoutForInputDeviceInternal(keyboardIdentifier, new ImeInfo(userId, imeInfo, imeSubtype));
        if (DEBUG == false) goto L12;
        Slog.d(TAG, "getKeyboardLayoutForInputDevice() " + identifier.toString() + ", userId : " + userId + ", subtype = " + imeSubtype + " -> " + result);
    L12:
        return result;
    L14:
        return KeyboardLayoutSelectionResult.FAILED;
    }

    public void setKeyboardLayoutOverrideForInputDevice(InputDeviceIdentifier identifier, String keyboardLayoutDescriptor) {
        InputDevice inputDevice = getInputDevice(identifier);
        if (inputDevice != null) goto L5;
        return;
    L5:
        if (inputDevice.isVirtual() == false) goto L7;
        return;
    L7:
        if (inputDevice.isFullKeyboard() == false) goto L13;
        KeyboardIdentifier keyboardIdentifier = new KeyboardIdentifier(inputDevice, null);
        setKeyboardLayoutForInputDeviceInternal(keyboardIdentifier, GLOBAL_OVERRIDE_KEY, keyboardLayoutDescriptor);
        return;
    }

    public void setKeyboardLayoutForInputDevice(InputDeviceIdentifier identifier, int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype, String keyboardLayoutDescriptor) {
        InputDevice inputDevice = getInputDevice(identifier);
        if (inputDevice != null) goto L5;
        return;
    L5:
        if (inputDevice.isVirtual() == false) goto L7;
        return;
    L7:
        if (inputDevice.isFullKeyboard() == false) goto L13;
        KeyboardLayoutManagerIA r2 = null;
        KeyboardIdentifier keyboardIdentifier = new KeyboardIdentifier(inputDevice, r2);
        String datastoreKey = new LayoutKey(keyboardIdentifier, new ImeInfo(userId, imeInfo, imeSubtype), r2).toString();
        setKeyboardLayoutForInputDeviceInternal(keyboardIdentifier, datastoreKey, keyboardLayoutDescriptor);
        return;
    }

    private void setKeyboardLayoutForInputDeviceInternal(KeyboardIdentifier identifier, String datastoreKey, String keyboardLayoutDescriptor) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r7.getClass()
            com.android.server.input.PersistentDataStore r0 = r4.mDataStore
            monitor-enter(r0)
            com.android.server.input.PersistentDataStore r1 = r4.mDataStore     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L3e
            boolean r1 = r1.setKeyboardLayout(r2, r6, r7)     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L46
            boolean r1 = com.android.server.input.KeyboardLayoutManager.DEBUG     // Catch: java.lang.Throwable -> L3e
            if (r1 == 0) goto L40
            java.lang.String r1 = "KeyboardLayoutManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3e
            r2.<init>()     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = "setKeyboardLayoutForInputDevice() "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3e
            r2.append(r5)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = " key: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3e
            r2.append(r6)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r3 = " keyboardLayoutDescriptor: "
            r2.append(r3)     // Catch: java.lang.Throwable -> L3e
            r2.append(r7)     // Catch: java.lang.Throwable -> L3e
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L3e
            android.util.Slog.d(r1, r2)     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r1 = move-exception
            goto L50
        L40:
            android.os.Handler r1 = r4.mHandler     // Catch: java.lang.Throwable -> L3e
            r2 = 2
            r1.sendEmptyMessage(r2)     // Catch: java.lang.Throwable -> L3e
        L46:
            com.android.server.input.PersistentDataStore r1 = r4.mDataStore     // Catch: java.lang.Throwable -> L4e
            r1.saveIfNeeded()     // Catch: java.lang.Throwable -> L4e
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            return
        L4e:
            r1 = move-exception
            goto L57
        L50:
            com.android.server.input.PersistentDataStore r2 = r4.mDataStore     // Catch: java.lang.Throwable -> L4e
            r2.saveIfNeeded()     // Catch: java.lang.Throwable -> L4e
            throw r1     // Catch: java.lang.Throwable -> L4e
        L57:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.server.input.KeyboardLayoutManager.setKeyboardLayoutForInputDeviceInternal(com.android.server.input.KeyboardLayoutManager$KeyboardIdentifier, java.lang.String, java.lang.String):void");
    }

    public KeyboardLayout[] getKeyboardLayoutListForInputDevice(InputDeviceIdentifier identifier, int userId, InputMethodInfo imeInfo, InputMethodSubtype imeSubtype) {
        InputDevice inputDevice = getInputDevice(identifier);
        if (inputDevice == null) goto L12;
        if (inputDevice.isVirtual() == true) goto L12;
        if (inputDevice.isFullKeyboard() == false) goto L12;
        return getKeyboardLayoutListForInputDeviceInternal(new KeyboardIdentifier(inputDevice, null), new ImeInfo(userId, imeInfo, imeSubtype));
    L12:
        return new KeyboardLayout[0];
    }

    private KeyboardLayout[] getKeyboardLayoutListForInputDeviceInternal(final KeyboardIdentifier keyboardIdentifier, ImeInfo imeInfo) {
        String layoutKey = new LayoutKey(keyboardIdentifier, imeInfo, null).toString();
        PersistentDataStore r2 = this.mDataStore;
        monitor-enter(r2);
        final String userSelectedLayout = this.mDataStore.getKeyboardLayout(keyboardIdentifier.toString(), layoutKey);     // Catch: Throwable -> L19
        monitor-exit(r2);     // Catch: Throwable -> L19
        final ArrayList<KeyboardLayout> potentialLayouts = new ArrayList();
        if (imeInfo != null) goto L9;
    L16:
        final String imeLanguageTag = "";
    L17:
        visitAllKeyboardLayouts(new AnonymousClass2(this, keyboardIdentifier, potentialLayouts, imeLanguageTag, userSelectedLayout));
        Collections.sort(potentialLayouts);
        return (KeyboardLayout[]) potentialLayouts.toArray(new KeyboardLayout[0]);
    L9:
        if (imeInfo.mImeSubtype == null) goto L16;
        ULocale imeLocale = imeInfo.mImeSubtype.getPhysicalKeyboardHintLanguageTag();
        if (imeLocale == null) goto L14;
        String r3 = imeLocale.toLanguageTag();
    L15:
        imeLanguageTag = r3;
        goto L17
    L14:
        r3 = imeInfo.mImeSubtype.getCanonicalizedLanguageTag();
    L19:
        th = th;
    L27:
        throw th;
    L23:
        th = th;
        goto L27
    }

    public void onInputMethodSubtypeChanged(int userId, InputMethodSubtypeHandle subtypeHandle, InputMethodSubtype subtype) {
        if (subtypeHandle == null) goto L4;
        Object r0 = this.mImeInfoLock;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L10:
        if (this.mCurrentImeInfo == null) goto L18;
        if (subtypeHandle.equals(this.mCurrentImeInfo.mImeSubtypeHandle) == false) goto L18;
        if (this.mCurrentImeInfo.mUserId != userId) goto L18;
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L18:
        this.mCurrentImeInfo = new ImeInfo(userId, subtypeHandle, subtype);     // Catch: Throwable -> L16
        this.mHandler.sendEmptyMessage(2);     // Catch: Throwable -> L16
        if (DEBUG == false) goto L21;
        Slog.d(TAG, "InputMethodSubtype changed: userId=" + userId + " subtypeHandle=" + subtypeHandle);     // Catch: Throwable -> L16
        goto L21
    L4:
        if (DEBUG == false) goto L27;
        Slog.d(TAG, "No InputMethod is running, ignoring change");
        return;
    }

    private KeyboardLayoutSelectionResult getKeyboardLayoutForInputDeviceInternal(KeyboardIdentifier keyboardIdentifier, ImeInfo imeInfo) {
        String layoutKey = new LayoutKey(keyboardIdentifier, imeInfo, null).toString();
        PersistentDataStore r1 = this.mDataStore;
        monitor-enter(r1);
        String layout = this.mDataStore.getKeyboardLayout(keyboardIdentifier.toString(), layoutKey);     // Catch: Throwable -> L9
        if (layout == null) goto L11;
        KeyboardLayoutSelectionResult r3 = new KeyboardLayoutSelectionResult(layout, 1);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r3;
    L11:
        String layout2 = this.mDataStore.getKeyboardLayout(keyboardIdentifier.toString(), GLOBAL_OVERRIDE_KEY);     // Catch: Throwable -> L9
        if (layout2 == null) goto L17;
        KeyboardLayoutSelectionResult r2 = new KeyboardLayoutSelectionResult(layout2, 2);     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return r2;
    L17:
        monitor-exit(r1);     // Catch: Throwable -> L9
        Map<String, KeyboardLayoutSelectionResult> r4 = this.mKeyboardLayoutCache;
        monitor-enter(r4);
    L25:
        th = move-exception;
        throw th;
    L21:
        if (this.mKeyboardLayoutCache.containsKey(layoutKey) == false) goto L27;
        KeyboardLayoutSelectionResult r5 = this.mKeyboardLayoutCache.get(layoutKey);     // Catch: Throwable -> L25
        monitor-exit(r4);     // Catch: Throwable -> L25
        return r5;
    L27:
        KeyboardLayout[] layoutList = getKeyboardLayoutListForInputDeviceInternal(keyboardIdentifier, imeInfo);     // Catch: Throwable -> L25
        KeyboardLayoutSelectionResult result = getDefaultKeyboardLayoutBasedOnImeInfo(keyboardIdentifier, imeInfo, layoutList);     // Catch: Throwable -> L25
        this.mKeyboardLayoutCache.put(layoutKey, result);     // Catch: Throwable -> L25
        monitor-exit(r4);     // Catch: Throwable -> L25
        return result;
    L9:
        th = move-exception;
        throw th;
    }

    private static KeyboardLayoutSelectionResult getDefaultKeyboardLayoutBasedOnImeInfo(KeyboardIdentifier keyboardIdentifier, ImeInfo imeInfo, KeyboardLayout[] layoutList) {
        Arrays.sort(layoutList);
        int r0 = layoutList.length;
        int r1 = 0;
    L4:
        if (r1 >= r0) goto L15;
        KeyboardLayout layout = layoutList[r1];
        if (layout.getVendorId() != KeyboardIdentifier.m4590$$Nest$fgetmIdentifier(keyboardIdentifier).getVendorId()) goto L14;
        if (layout.getProductId() != KeyboardIdentifier.m4590$$Nest$fgetmIdentifier(keyboardIdentifier).getProductId()) goto L14;
        if (DEBUG == false) goto L13;
        Slog.d(TAG, "getDefaultKeyboardLayoutBasedOnImeInfo() : Layout found based on vendor and product Ids. " + keyboardIdentifier + " : " + layout.getDescriptor());
    L13:
        return new KeyboardLayoutSelectionResult(layout.getDescriptor(), 2);
    L14:
        r1 = r1 + 1;
        goto L4
    L15:
        String inputLanguageTag = KeyboardIdentifier.m4591$$Nest$fgetmLanguageTag(keyboardIdentifier);
        if (inputLanguageTag == null) goto L24;
        String layoutDesc = getMatchingLayoutForProvidedLanguageTagAndLayoutType(layoutList, inputLanguageTag, KeyboardIdentifier.m4592$$Nest$fgetmLayoutType(keyboardIdentifier));
        if (layoutDesc == null) goto L24;
        if (DEBUG == false) goto L23;
        Slog.d(TAG, "getDefaultKeyboardLayoutBasedOnImeInfo() : Layout found based on HW information (Language tag and Layout type). " + keyboardIdentifier + " : " + layoutDesc);
    L23:
        return new KeyboardLayoutSelectionResult(layoutDesc, 2);
    L24:
        if (imeInfo == null) goto L43;
        if (imeInfo.mImeSubtypeHandle == null) goto L43;
        if (imeInfo.mImeSubtype == null) goto L43;
        InputMethodSubtype subtype = imeInfo.mImeSubtype;
        ULocale pkLocale = subtype.getPhysicalKeyboardHintLanguageTag();
        if (pkLocale == null) goto L33;
        String pkLanguageTag = pkLocale.toLanguageTag();
    L34:
        String layoutDesc2 = getMatchingLayoutForProvidedLanguageTagAndLayoutType(layoutList, pkLanguageTag, subtype.getPhysicalKeyboardHintLayoutType());
        if (DEBUG == false) goto L37;
        Slog.d(TAG, "getDefaultKeyboardLayoutBasedOnImeInfo() : Layout found based on IME locale matching. " + keyboardIdentifier + " : " + layoutDesc2);
    L37:
        if (layoutDesc2 == null) goto L41;
        return new KeyboardLayoutSelectionResult(layoutDesc2, 3);
    L41:
        return KeyboardLayoutSelectionResult.FAILED;
    L33:
        pkLanguageTag = subtype.getCanonicalizedLanguageTag();
    L43:
        return KeyboardLayoutSelectionResult.FAILED;
    }

    private static String getMatchingLayoutForProvidedLanguageTagAndLayoutType(KeyboardLayout[] layoutList, String languageTag, String layoutType) {
        if (layoutType != null) goto L4;
    L5:
        layoutType = "undefined";
    L6:
        List<KeyboardLayout> layoutsFilteredByLayoutType = new ArrayList();
        int r1 = layoutList.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L12;
        KeyboardLayout layout = layoutList[r2];
        if (layout.getLayoutType().equals(layoutType) == false) goto L11;
        layoutsFilteredByLayoutType.add(layout);
    L11:
        r2 = r2 + 1;
        goto L7
    L12:
        String layoutDesc = getMatchingLayoutForProvidedLanguageTag(layoutsFilteredByLayoutType, languageTag);
        if (layoutDesc == null) goto L16;
        return layoutDesc;
    L16:
        return getMatchingLayoutForProvidedLanguageTag(Arrays.asList(layoutList), languageTag);
    L4:
        if (KeyboardLayout.isLayoutTypeValid(layoutType) == true) goto L6;
        goto L5
    }

    private static String getMatchingLayoutForProvidedLanguageTag(List<KeyboardLayout> layoutList, String languageTag) {
        Locale locale = Locale.forLanguageTag(languageTag);
        String bestMatchingLayout = null;
        float bestMatchingLayoutScore = 0.0f;
        Iterator<KeyboardLayout> r3 = layoutList.iterator();
    L4:
        if (r3.hasNext() == false) goto L31;
        KeyboardLayout layout = r3.next();
        LocaleList locales = layout.getLocales();
        int i = 0;
    L7:
        if (i >= locales.size()) goto L4;
        Locale l = locales.get(i);
        if (l == null) goto L29;
        if (l.getLanguage().equals(locale.getLanguage()) == false) goto L29;
        float layoutScore = 1.0f;
        if (l.getCountry().equals(locale.getCountry()) == false) goto L18;
        layoutScore = 1.0f + 1.0f;
    L21:
        if (l.getVariant().equals(locale.getVariant()) == false) goto L24;
        layoutScore = layoutScore + 1.0f;
    L27:
        if (layoutScore <= bestMatchingLayoutScore) goto L29;
        bestMatchingLayoutScore = layoutScore;
        bestMatchingLayout = layout.getDescriptor();
        goto L29
    L24:
        if (TextUtils.isEmpty(l.getVariant()) == false) goto L27;
        layoutScore = (float) (((double) layoutScore) + 0.5d);
        goto L27
    L18:
        if (TextUtils.isEmpty(l.getCountry()) == false) goto L21;
        layoutScore = (float) (((double) 1.0f) + 0.5d);
    L29:
        i = i + 1;
        goto L7
    L31:
        return bestMatchingLayout;
    }

    private void reloadKeyboardLayouts() {
        if (DEBUG == false) goto L5;
        Slog.d(TAG, "Reloading keyboard layouts.");
    L5:
        this.mNative.reloadKeyboardLayouts();
    }

    private void maybeUpdateNotification() {
        List<KeyboardConfiguration> configurations = new ArrayList();
        int i = 0;
    L4:
        if (i >= this.mConfiguredKeyboards.size()) goto L14;
        int deviceId = this.mConfiguredKeyboards.keyAt(i);
        KeyboardConfiguration config = this.mConfiguredKeyboards.valueAt(i);
        if (isVirtualDevice(deviceId) == true) goto L13;
        if (KeyboardConfiguration.m4588$$Nest$mhasConfiguredLayouts(config) == false) goto L10;
        configurations.add(config);
        goto L13
    L10:
        showMissingKeyboardLayoutNotification();
        return;
    L13:
        i = i + 1;
        goto L4
    L14:
        int i2 = configurations.size();
        if (i2 != 0) goto L18;
        hideKeyboardLayoutNotification();
        return;
    L18:
        showConfiguredKeyboardLayoutNotification(configurations);
    }

    private void showMissingKeyboardLayoutNotification() {
        Resources r = this.mContext.getResources();
        String missingKeyboardLayoutNotificationContent = r.getString(android.R.string.user_creation_account_exists);
        if (this.mConfiguredKeyboards.size() != 1) goto L8;
        InputDevice device = getInputDevice(this.mConfiguredKeyboards.keyAt(0));
        if (device != null) goto L7;
        return;
    L7:
        showKeyboardLayoutNotification(r.getString(android.R.string.user_creation_adding, new Object[]{device.getName()}), missingKeyboardLayoutNotificationContent, device);
        return;
    L8:
        showKeyboardLayoutNotification(r.getString(android.R.string.user_owner_app_label), missingKeyboardLayoutNotificationContent, null);
    }

    private void showKeyboardLayoutNotification(String intentTitle, String intentContent, InputDevice targetDevice) {
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        if (notificationManager != null) goto L5;
        return;
    L5:
        Intent intent = new Intent("android.settings.HARD_KEYBOARD_SETTINGS");
        if (targetDevice == null) goto L8;
        intent.putExtra("input_device_identifier", targetDevice.getIdentifier());
        intent.putExtra("com.android.settings.inputmethod.EXTRA_ENTRYPOINT", 0);
    L8:
        intent.setFlags(337641472);
        PendingIntent keyboardLayoutIntent = PendingIntent.getActivityAsUser(this.mContext, 0, intent, 67108864, null, UserHandle.CURRENT);
        Notification notification = new Notification.Builder(this.mContext, "PHYSICAL_KEYBOARD").setContentTitle(intentTitle).setContentText(intentContent).setContentIntent(keyboardLayoutIntent).setSmallIcon(android.R.drawable.pointer_wait_62).setColor(this.mContext.getColor(android.R.color.system_notification_accent_color)).setAutoCancel(true).build();
        notificationManager.notifyAsUser(null, 19, notification, UserHandle.ALL);
    }

    private void hideKeyboardLayoutNotification() {
        NotificationManager notificationManager = (NotificationManager) this.mContext.getSystemService(NotificationManager.class);
        if (notificationManager != null) goto L5;
        return;
    L5:
        notificationManager.cancelAsUser(null, 19, UserHandle.ALL);
    }

    private void showConfiguredKeyboardLayoutNotification(List<KeyboardConfiguration> configurations) {
        Resources r = this.mContext.getResources();
        if (configurations.size() == 1) goto L6;
        showKeyboardLayoutNotification(r.getString(android.R.string.lockscreen_password_wrong), r.getString(android.R.string.lockscreen_network_locked_message), null);
        return;
    L6:
        KeyboardConfiguration config = configurations.get(0);
        InputDevice inputDevice = getInputDevice(KeyboardConfiguration.m4587$$Nest$mgetDeviceId(config));
        if (inputDevice != null) goto L9;
        return;
    L9:
        if (KeyboardConfiguration.m4588$$Nest$mhasConfiguredLayouts(config) == false) goto L23;
        List<String> layoutNames = new ArrayList();
        Iterator r4 = KeyboardConfiguration.m4586$$Nest$mgetConfiguredLayouts(config).iterator();
    L13:
        if (r4.hasNext() == false) goto L18;
        String layoutDesc = (String) r4.next();
        KeyboardLayout kl = getKeyboardLayout(layoutDesc);
        if (kl == null) goto L16;
        layoutNames.add(kl.getLabel());
        goto L13
    L16:
        return;
    L18:
        showKeyboardLayoutNotification(r.getString(android.R.string.lockscreen_pattern_instructions, new Object[]{inputDevice.getName()}), createConfiguredNotificationText(this.mContext, layoutNames), inputDevice);
        return;
    }

    private String createConfiguredNotificationText(Context context, List<String> layoutNames) {
        Resources r = context.getResources();
        Collections.sort(layoutNames);
        switch(layoutNames.size()) {
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            default: goto L5;
        };
    L5:
        return r.getString(android.R.string.lockscreen_missing_sim_message_short, new Object[]{layoutNames.get(0), layoutNames.get(1), layoutNames.get(2)});
    L7:
        return r.getString(android.R.string.lockscreen_pattern_wrong, new Object[]{layoutNames.get(0), layoutNames.get(1), layoutNames.get(2)});
    L9:
        return r.getString(android.R.string.lockscreen_permanent_disabled_sim_instructions, new Object[]{layoutNames.get(0), layoutNames.get(1)});
    L11:
        return r.getString(android.R.string.lockscreen_pattern_correct, new Object[]{layoutNames.get(0)});
    }

    private void logKeyboardConfigurationEvent(InputDevice inputDevice, List<ImeInfo> imeInfoList, List<KeyboardLayoutSelectionResult> resultList, boolean isFirstConfiguration) {
        if (imeInfoList.isEmpty() == false) goto L5;
        return;
    L5:
        if (resultList.isEmpty() == true) goto L26;
        KeyboardMetricsCollector.KeyboardConfigurationEvent.Builder configurationEventBuilder = new KeyboardMetricsCollector.KeyboardConfigurationEvent.Builder(inputDevice).setIsFirstTimeConfiguration(isFirstConfiguration);
        int i = 0;
    L9:
        if (i >= imeInfoList.size()) goto L18;
        KeyboardLayoutSelectionResult result = resultList.get(i);
        String layoutName = null;
        int layoutSelectionCriteria = 4;
        if (result == null) goto L17;
        if (result.getLayoutDescriptor() == null) goto L17;
        layoutSelectionCriteria = result.getSelectionCriteria();
        KeyboardLayoutDescriptor d = KeyboardLayoutDescriptor.parse(result.getLayoutDescriptor());
        if (d == null) goto L17;
        layoutName = d.keyboardLayoutName;
    L17:
        configurationEventBuilder.addLayoutSelection(imeInfoList.get(i).mImeSubtype, layoutName, layoutSelectionCriteria);
        i = i + 1;
        goto L9
    L18:
        KeyboardMetricsCollector.logKeyboardConfiguredAtom(configurationEventBuilder.build());
        return;
    }

    private boolean handleMessage(Message msg) {
        int r1 = 0;
        switch(msg.what) {
            case 1: goto L9;
            case 2: goto L7;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        return false;
    L5:
        updateKeyboardLayouts();
        return true;
    L7:
        reloadKeyboardLayouts();
        return true;
    L9:
        int[] r0 = (int[]) msg.obj;
        int r3 = r0.length;
    L10:
        if (r1 >= r3) goto L12;
        int deviceId = r0[r1];
        onInputDeviceAdded(deviceId);
        r1 = r1 + 1;
        goto L10
    L12:
        return true;
    }

    private InputDevice getInputDevice(int deviceId) {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        if (inputManager != null) goto L7;
        return null;
    L7:
        return inputManager.getInputDevice(deviceId);
    }

    private InputDevice getInputDevice(InputDeviceIdentifier identifier) {
        InputManager inputManager = (InputManager) this.mContext.getSystemService(InputManager.class);
        if (inputManager != null) goto L7;
        return null;
    L7:
        return inputManager.getInputDeviceByDescriptor(identifier.getDescriptor());
    }

    public List<ImeInfo> getImeInfoListForLayoutMapping() {
        List<ImeInfo> imeInfoList = new ArrayList();
        UserManager userManager = (UserManager) this.mContext.getSystemService(UserManager.class);
        userManager.getClass();
        InputMethodManagerInternal inputMethodManagerInternal = InputMethodManagerInternal.get();
        Iterator r4 = userManager.getUserHandles(true).iterator();
    L4:
        if (r4.hasNext() == false) goto L17;
        UserHandle userHandle = (UserHandle) r4.next();
        int userId = userHandle.getIdentifier();
        Iterator<InputMethodInfo> r7 = inputMethodManagerInternal.getEnabledInputMethodListAsUser(userId).iterator();
    L7:
        if (r7.hasNext() == false) goto L4;
        InputMethodInfo imeInfo = r7.next();
        List<InputMethodSubtype> imeSubtypes = inputMethodManagerInternal.getEnabledInputMethodSubtypeListAsUser(imeInfo.getId(), true, userId);
        Iterator<InputMethodSubtype> r10 = imeSubtypes.iterator();
    L10:
        if (r10.hasNext() == false) goto L7;
        InputMethodSubtype imeSubtype = r10.next();
        if (imeSubtype.isSuitableForPhysicalKeyboardLayoutMapping() == false) goto L10;
        imeInfoList.add(new ImeInfo(userId, imeInfo, imeSubtype));
        goto L10
    L17:
        return imeInfoList;
    }

    private static boolean isLayoutCompatibleWithLanguageTag(KeyboardLayout layout, String languageTag) {
        LocaleList layoutLocales = layout.getLocales();
        if (layoutLocales.isEmpty() == false) goto L5;
    L19:
        return true;
    L5:
        if (TextUtils.isEmpty(languageTag) == true) goto L19;
        int[] scriptsFromLanguageTag = getScriptCodes(Locale.forLanguageTag(languageTag));
        if (scriptsFromLanguageTag.length != 0) goto L10;
        return true;
    L10:
        int i = 0;
    L12:
        if (i >= layoutLocales.size()) goto L17;
        Locale locale = layoutLocales.get(i);
        int[] scripts = getScriptCodes(locale);
        if (haveCommonValue(scripts, scriptsFromLanguageTag) == true) goto L15;
        i = i + 1;
        goto L12
    L15:
        return true;
    L17:
        return false;
    }

    public boolean isVirtualDevice(int deviceId) {
        VirtualDeviceManagerInternal vdm = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        if (vdm != null) goto L5;
    L7:
        return false;
    L5:
        if (vdm.isInputDeviceOwnedByVirtualDevice(deviceId) == false) goto L7;
        return true;
    }

    private static int[] getScriptCodes(Locale locale) {
        if (locale != null) goto L7;
        return new int[0];
    L7:
        if (TextUtils.isEmpty(locale.getScript()) == true) goto L12;
        int scriptCode = UScript.getCodeFromName(locale.getScript());
        if (scriptCode == (-1)) goto L12;
        return new int[]{scriptCode};
    L12:
        int[] scripts = UScript.getCode(locale);
        if (scripts == null) goto L16;
        return scripts;
    L16:
        return new int[0];
    }

    private static boolean haveCommonValue(int[] arr1, int[] arr2) {
        int r0 = arr1.length;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L13;
        int a1 = arr1[r2];
        int r4 = arr2.length;
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L12;
        int a2 = arr2[r5];
        if (a1 == a2) goto L9;
        r5 = r5 + 1;
        goto L6
    L9:
        return true;
    L12:
        r2 = r2 + 1;
        goto L3
    L13:
        return false;
    }
}
