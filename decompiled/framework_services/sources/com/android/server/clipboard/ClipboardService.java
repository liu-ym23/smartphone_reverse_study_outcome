package com.android.server.clipboard;

import android.R;
import android.app.ActivityManagerInternal;
import android.app.AppOpsManager;
import android.app.IUriGrantsManager;
import android.app.KeyguardManager;
import android.app.UriGrantsManager;
import android.companion.virtual.VirtualDeviceManager;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.IClipboard;
import android.content.IObricClipboardManager;
import android.content.IOnPrimaryClipChangedListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManagerInternal;
import android.content.pm.UserInfo;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IUserManager;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.UserHandle;
import android.os.UserManager;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IntArray;
import android.util.Pair;
import android.util.SafetyProtectionUtils;
import android.util.Slog;
import android.util.SparseArrayMap;
import android.util.SparseBooleanArray;
import android.view.Display;
import android.view.autofill.AutofillManagerInternal;
import android.view.textclassifier.TextClassificationContext;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.view.textclassifier.TextClassifierEvent;
import android.view.textclassifier.TextLinks;
import android.widget.Toast;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import com.android.server.UiThread;
import com.android.server.companion.virtual.VirtualDeviceManagerInternal;
import com.android.server.contentcapture.ContentCaptureManagerInternal;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.uri.UriGrantsManagerInternal;
import com.android.server.wm.ActivityTaskManagerInternal;
import com.android.server.wm.WindowManagerInternal;
import com.obric.utils.ObricImplFactory;
import com.zte.redmagic.game.FilerCatcherHelper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public class ClipboardService extends SystemService {
    private static final int[] CLIP_DATA_TYPES_UNKNOWN = null;
    public static final long DEFAULT_CLIPBOARD_TIMEOUT_MILLIS = 3600000;
    private static final int DEFAULT_MAX_CLASSIFICATION_LENGTH = 400;
    public static final String PROPERTY_AUTO_CLEAR_ENABLED = "auto_clear_enabled";
    public static final String PROPERTY_AUTO_CLEAR_TIMEOUT = "auto_clear_timeout";
    private static final String PROPERTY_MAX_CLASSIFICATION_LENGTH = "max_classification_length";
    private static final String TAG = "ClipboardService";
    private boolean mAllowVirtualDeviceSilos;
    private final ActivityManagerInternal mAmInternal;
    private final AppOpsManager mAppOps;
    private final AutofillManagerInternal mAutofillInternal;
    private final Consumer<ClipData> mClipboardMonitor;
    private final SparseArrayMap<Integer, Clipboard> mClipboards;
    private final ContentCaptureManagerInternal mContentCaptureInternal;
    private FilerCatcherHelper mFilerCatcherHelper;
    final Object mLock;
    private int mMaxClassificationLength;
    private IObricClipboardService mObricExt;
    private final IBinder mPermissionOwner;
    private final PackageManager mPm;
    private boolean mShowAccessNotifications;
    private final IUriGrantsManager mUgm;
    private final UriGrantsManagerInternal mUgmInternal;
    final IUserManager mUm;
    final VirtualDeviceManager mVdm;
    private final VirtualDeviceManagerInternal mVdmInternal;
    private VirtualDeviceManager.VirtualDeviceListener mVirtualDeviceListener;
    private BroadcastReceiver mVirtualDeviceRemovedReceiver;
    private final WindowManagerInternal mWm;
    private final Handler mWorkerHandler;

    static class Clipboard {
        final HashSet<String> activePermissionOwners;
        public final int deviceId;
        final SparseBooleanArray mNotifiedTextClassifierUids;
        final SparseBooleanArray mNotifiedUids;
        String mPrimaryClipPackage;
        TextClassifier mTextClassifier;
        boolean needIsolate;
        ClipData primaryClip;
        final RemoteCallbackList<IOnPrimaryClipChangedListener> primaryClipListeners;
        int primaryClipUid;
        public final int userId;

        Clipboard(int userId, int deviceId) {
            this.needIsolate = false;
            this.primaryClipListeners = new RemoteCallbackList();
            this.primaryClipUid = 9999;
            this.mNotifiedUids = new SparseBooleanArray();
            this.mNotifiedTextClassifierUids = new SparseBooleanArray();
            this.activePermissionOwners = new HashSet();
            this.userId = userId;
            this.deviceId = deviceId;
        }
    }

    public class ClipboardImpl extends IClipboard.Stub {
        private final Handler mClipboardClearHandler;
        final /* synthetic */ ClipboardService this$0;

        private class ClipboardClearHandler extends Handler {
            public static final int MSG_CLEAR = 101;
            final /* synthetic */ ClipboardImpl this$1;

            ClipboardClearHandler(ClipboardImpl r1, Looper looper) {
                this.this$1 = r1;
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                switch(msg.what) {
                    case 101: goto L5;
                    default: goto L4;
                };
            L4:
                Slog.wtf(ClipboardService.TAG, "ClipboardClearHandler received unknown message " + msg.what);
                return;
            L5:
                int userId = msg.arg1;
                int intendingUid = msg.arg2;
                int intendingDeviceId = ((Integer) ((Pair) msg.obj).second).intValue();
                Object r3 = this.this$1.this$0.mLock;
                monitor-enter(r3);
                Clipboard clipboard = this.this$1.this$0.getClipboardLocked(userId, intendingDeviceId);     // Catch: Throwable -> L12
                if (clipboard != null) goto L10;
            L14:
                monitor-exit(r3);     // Catch: Throwable -> L12
                return;
            L10:
                if (clipboard.primaryClip == null) goto L14;
                FrameworkStatsLog.write(FrameworkStatsLog.CLIPBOARD_CLEARED, 1);     // Catch: Throwable -> L12
                ClipboardService.m2881$$Nest$msetPrimaryClipInternalLocked(this.this$1.this$0, null, intendingUid, intendingDeviceId, null);     // Catch: Throwable -> L12
            L12:
                th = move-exception;
                throw th;
            }
        }

        public ClipboardImpl(ClipboardService this$0) {
            this.this$0 = this$0;
            this.mClipboardClearHandler = new ClipboardClearHandler(this, ClipboardService.m2870$$Nest$fgetmWorkerHandler(this.this$0).getLooper());
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            return super.onTransact(code, data, reply, flags);
        L4:
            e = move-exception;
            if ((e instanceof SecurityException) == true) goto L8;
            Slog.wtf("clipboard", "Exception: ", e);
        L8:
            throw e;
        }

        public void setPrimaryClip(ClipData clip, String callingPackage, String attributionTag, int userId, int deviceId) {
            checkAndSetPrimaryClip(clip, callingPackage, attributionTag, userId, deviceId, callingPackage);
            if (ClipboardService.m2867$$Nest$fgetmFilerCatcherHelper(this.this$0) != null) goto L5;
            ClipboardService.m2871$$Nest$fputmFilerCatcherHelper(this.this$0, new FilerCatcherHelper(this.this$0.getContext()));
        L5:
            ClipboardService.m2867$$Nest$fgetmFilerCatcherHelper(this.this$0).startFiberCatcherService(clip, callingPackage);
        }

        public void setPrimaryClipAsPackage(ClipData clip, String callingPackage, String attributionTag, int userId, int deviceId, String sourcePackage) {
            setPrimaryClipAsPackage_enforcePermission();
            checkAndSetPrimaryClip(clip, callingPackage, attributionTag, userId, deviceId, sourcePackage);
        }

        public boolean areClipboardAccessNotificationsEnabledForUser(int userId) {
            int result = this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MANAGE_CLIPBOARD_ACCESS_NOTIFICATION");
            if (result != 0) goto L15;
            long callingId = Binder.clearCallingIdentity();
            if (Settings.Secure.getIntForUser(this.this$0.getContext().getContentResolver(), "clipboard_show_access_notifications", getDefaultClipboardAccessNotificationsSetting(), userId) == 0) goto L8;
            boolean r3 = true;
        L9:
            Binder.restoreCallingIdentity(callingId);
            return r3;
        L8:
            r3 = false;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L15:
            throw new SecurityException("areClipboardAccessNotificationsEnable requires permission MANAGE_CLIPBOARD_ACCESS_NOTIFICATION");
        }

        public void setClipboardAccessNotificationsEnabledForUser(boolean enable, int userId) {
            int result = this.this$0.getContext().checkCallingOrSelfPermission("android.permission.MANAGE_CLIPBOARD_ACCESS_NOTIFICATION");
            if (result != 0) goto L15;
            long callingId = Binder.clearCallingIdentity();
            int r5 = 0;
            ContentResolver resolver = this.this$0.getContext().createContextAsUser(UserHandle.of(userId), 0).getContentResolver();     // Catch: Throwable -> L11
            if (enable == false) goto L8;
            r5 = 1;
        L8:
            Settings.Secure.putInt(resolver, "clipboard_show_access_notifications", r5);     // Catch: Throwable -> L11
            Binder.restoreCallingIdentity(callingId);
            return;
        L11:
            th = move-exception;
            Binder.restoreCallingIdentity(callingId);
            throw th;
        L15:
            throw new SecurityException("areClipboardAccessNotificationsEnable requires permission MANAGE_CLIPBOARD_ACCESS_NOTIFICATION");
        }

        private int getDefaultClipboardAccessNotificationsSetting() {
            if (DeviceConfig.getBoolean("clipboard", "show_access_notifications", false) == false) goto L7;
            return 1;
        L7:
            return 0;
        }

        private void checkAndSetPrimaryClip(ClipData clip, String callingPackage, String attributionTag, int userId, int deviceId, String sourcePackage) {
            if (clip == null) goto L18;
            if (clip.getItemCount() <= 0) goto L18;
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            if (ClipboardService.m2874$$Nest$mclipboardAccessAllowed(this.this$0, 30, callingPackage, attributionTag, intendingUid, intendingUserId, intendingDeviceId) == true) goto L8;
            return;
        L8:
            ClipboardService.m2873$$Nest$mcheckDataOwner(this.this$0, clip, intendingUid);
            Object r10 = this.this$0.mLock;
            monitor-enter(r10);
            scheduleAutoClear(userId, intendingUid, intendingDeviceId);     // Catch: Throwable -> L13
            ClipboardService.m2881$$Nest$msetPrimaryClipInternalLocked(this.this$0, clip, intendingUid, intendingDeviceId, sourcePackage);     // Catch: Throwable -> L13
            monitor-exit(r10);     // Catch: Throwable -> L13
            return;
        L13:
            th = move-exception;
            throw th;
        L18:
            throw new IllegalArgumentException("No items");
        }

        private void scheduleAutoClear(int userId, int intendingUid, int intendingDeviceId) {
            long oldIdentity = Binder.clearCallingIdentity();
        L7:
            th = move-exception;
            Binder.restoreCallingIdentity(oldIdentity);
            throw th;
        L4:
            if (DeviceConfig.getBoolean("clipboard", ClipboardService.PROPERTY_AUTO_CLEAR_ENABLED, true) == false) goto L9;
            Pair<Integer, Integer> userIdDeviceId = new Pair(Integer.valueOf(userId), Integer.valueOf(intendingDeviceId));     // Catch: Throwable -> L7
            this.mClipboardClearHandler.removeEqualMessages(101, userIdDeviceId);     // Catch: Throwable -> L7
            Message clearMessage = Message.obtain(this.mClipboardClearHandler, 101, userId, intendingUid, userIdDeviceId);     // Catch: Throwable -> L7
            this.mClipboardClearHandler.sendMessageDelayed(clearMessage, getTimeoutForAutoClear());     // Catch: Throwable -> L7
        L9:
            Binder.restoreCallingIdentity(oldIdentity);
        }

        private long getTimeoutForAutoClear() {
            return DeviceConfig.getLong("clipboard", ClipboardService.PROPERTY_AUTO_CLEAR_TIMEOUT, 3600000);
        }

        public void clearPrimaryClip(String callingPackage, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            if (ClipboardService.m2874$$Nest$mclipboardAccessAllowed(this.this$0, 30, callingPackage, attributionTag, intendingUid, intendingUserId, intendingDeviceId) == true) goto L6;
            return;
        L6:
            if (ClipboardService.m2869$$Nest$fgetmWm(this.this$0).getObricWindowManagerInternal().shouldClipBoardIsolate() == true) goto L8;
        L12:
            Object r9 = this.this$0.mLock;
            monitor-enter(r9);
            this.mClipboardClearHandler.removeEqualMessages(101, new Pair(Integer.valueOf(userId), Integer.valueOf(deviceId)));     // Catch: Throwable -> L17
            ClipboardService.m2881$$Nest$msetPrimaryClipInternalLocked(this.this$0, null, intendingUid, intendingDeviceId, callingPackage);     // Catch: Throwable -> L17
            monitor-exit(r9);     // Catch: Throwable -> L17
            return;
        L17:
            th = move-exception;
            throw th;
        L8:
            if (ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).isClipboardIsolated() == false) goto L10;
            return;
        L10:
            if (ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).isAppLaunchInOautoDisplay(ClipboardService.m2869$$Nest$fgetmWm(this.this$0).getObricWindowManagerInternal()) == false) goto L12;
        }

        public ClipData getPrimaryClip(String pkg, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(pkg, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            if (ClipboardService.m2869$$Nest$fgetmWm(this.this$0).getObricWindowManagerInternal().shouldClipBoardIsolate() == true) goto L5;
        L8:
            boolean r10 = ClipboardService.m2874$$Nest$mclipboardAccessAllowed(this.this$0, 29, pkg, attributionTag, intendingUid, intendingUserId, intendingDeviceId);
            String pkg2 = pkg;
            intendingUid = intendingUid;
            intendingUserId = intendingUserId;
            if (r10 == false) goto L49;
        L11:
            if (ClipboardService.m2878$$Nest$misDeviceLocked(this.this$0, intendingUserId, deviceId, pkg2) == true) goto L49;
            Object r11 = this.this$0.mLock;
            monitor-enter(r11);
            ClipboardService.m2872$$Nest$maddActiveOwnerLocked(this.this$0, intendingUid, intendingDeviceId, pkg2);     // Catch: Throwable -> L40 SecurityException -> L42
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L40
            if (ClipboardService.m2869$$Nest$fgetmWm(this.this$0).getObricWindowManagerInternal().shouldClipBoardIsolate() == true) goto L50;
        L26:
            Clipboard clipboard2 = clipboard;
        L27:
            if (clipboard2 != null) goto L30;
            monitor-exit(r11);     // Catch: Throwable -> L23
            return null;
        L23:
            th = th;
        L46:
            monitor-exit(r11);     // Catch: Throwable -> L35
            throw th;
        L30:
            ClipboardService.m2882$$Nest$mshowAccessNotificationLocked(this.this$0, pkg2, intendingUid, intendingUserId, clipboard2, deviceId);     // Catch: Throwable -> L35
            ClipboardService.m2879$$Nest$mnotifyTextClassifierLocked(this.this$0, clipboard2, pkg2, intendingUid);     // Catch: Throwable -> L35
            if (clipboard2.primaryClip == null) goto L37;
            ClipboardService.m2880$$Nest$mscheduleWriteClipDataStats(this.this$0, clipboard2.primaryClip, clipboard2.primaryClipUid, intendingUid);     // Catch: Throwable -> L35
            scheduleAutoClear(userId, intendingUid, intendingDeviceId);     // Catch: Throwable -> L35
        L37:
            ClipData r13 = clipboard2.primaryClip;     // Catch: Throwable -> L35
            monitor-exit(r11);     // Catch: Throwable -> L35
            return r13;
        L50:
            if (ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).isClipboardIsolated() == false) goto L21;
        L25:
            Clipboard clipboard3 = ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).getClipboardLockedInOautoDisplay(userId, deviceId);     // Catch: Throwable -> L23
            ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).setClipboardIsolate(false);     // Catch: Throwable -> L23
            clipboard2 = clipboard3;
            goto L27
        L21:
            if (ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).isAppLaunchInOautoDisplay(ClipboardService.m2869$$Nest$fgetmWm(this.this$0).getObricWindowManagerInternal()) == false) goto L26;
        L40:
            th = th;
        L35:
            th = th;
        L43:
            Slog.i(ClipboardService.TAG, "Could not grant permission to primary clip. Clearing clipboard.");     // Catch: Throwable -> L35
            ClipboardService.m2881$$Nest$msetPrimaryClipInternalLocked(this.this$0, null, intendingUid, intendingDeviceId, pkg2);     // Catch: Throwable -> L35
            return null;
        L49:
            return null;
        L5:
            if (ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).isClipboardIsolated() == false) goto L8;
            pkg2 = pkg;
            goto L11
        }

        public ClipDescription getPrimaryClipDescription(String callingPackage, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            boolean r10 = ClipboardService.m2875$$Nest$mclipboardAccessAllowed(this.this$0, 29, callingPackage, attributionTag, intendingUid, intendingUserId, intendingDeviceId, false);
            ClipDescription r11 = null;
            if (r10 == true) goto L5;
        L21:
            return null;
        L5:
            if (ClipboardService.m2878$$Nest$misDeviceLocked(this.this$0, intendingUserId, deviceId, callingPackage) == true) goto L21;
            Object r12 = this.this$0.mLock;
            monitor-enter(r12);
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L14
            if (clipboard != null) goto L12;
        L17:
            monitor-exit(r12);     // Catch: Throwable -> L14
            return r11;
        L12:
            if (clipboard.primaryClip == null) goto L17;
            r11 = clipboard.primaryClip.getDescription();     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            throw th;
        }

        public boolean hasPrimaryClip(String callingPackage, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            boolean r10 = ClipboardService.m2875$$Nest$mclipboardAccessAllowed(this.this$0, 29, callingPackage, attributionTag, intendingUid, intendingUserId, intendingDeviceId, false);
            boolean r11 = false;
            if (r10 == true) goto L5;
        L20:
            return false;
        L5:
            if (ClipboardService.m2878$$Nest$misDeviceLocked(this.this$0, intendingUserId, deviceId, callingPackage) == true) goto L20;
            Object r12 = this.this$0.mLock;
            monitor-enter(r12);
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L14
            if (clipboard != null) goto L12;
        L16:
            monitor-exit(r12);     // Catch: Throwable -> L14
            return r11;
        L12:
            if (clipboard.primaryClip == null) goto L16;
            r11 = true;
        L14:
            th = move-exception;
            throw th;
        }

        public void addPrimaryClipChangedListener(IOnPrimaryClipChangedListener listener, String callingPackage, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            if (intendingDeviceId != (-1)) goto L6;
            Slog.i(ClipboardService.TAG, "addPrimaryClipChangedListener invalid deviceId for userId:" + userId + " uid:" + intendingUid + " callingPackage:" + callingPackage + " requestedDeviceId:" + deviceId);
            return;
        L6:
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L12
            if (clipboard != null) goto L14;
            monitor-exit(r3);     // Catch: Throwable -> L12
            return;
        L14:
            clipboard.primaryClipListeners.register(listener, new ListenerInfo(this.this$0, intendingUid, callingPackage, attributionTag));     // Catch: Throwable -> L12
            monitor-exit(r3);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        public void removePrimaryClipChangedListener(IOnPrimaryClipChangedListener listener, String callingPackage, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = ClipboardService.m2877$$Nest$mgetIntendingUserId(this.this$0, callingPackage, userId);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            if (intendingDeviceId != (-1)) goto L6;
            Slog.i(ClipboardService.TAG, "removePrimaryClipChangedListener invalid deviceId for userId:" + userId + " uid:" + intendingUid + " callingPackage:" + callingPackage);
            return;
        L6:
            Object r3 = this.this$0.mLock;
            monitor-enter(r3);
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L11
            if (clipboard == null) goto L13;
            clipboard.primaryClipListeners.unregister(listener);     // Catch: Throwable -> L11
        L13:
            monitor-exit(r3);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public boolean hasClipboardText(String callingPackage, String attributionTag, int userId, int deviceId) {
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            boolean r10 = ClipboardService.m2875$$Nest$mclipboardAccessAllowed(this.this$0, 29, callingPackage, attributionTag, intendingUid, intendingUserId, intendingDeviceId, false);
            boolean r11 = false;
            if (r10 == true) goto L5;
        L26:
            return false;
        L5:
            if (ClipboardService.m2878$$Nest$misDeviceLocked(this.this$0, intendingUserId, deviceId, callingPackage) == true) goto L26;
            Object r12 = this.this$0.mLock;
            monitor-enter(r12);
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L18
            if (clipboard != null) goto L12;
        L22:
            monitor-exit(r12);     // Catch: Throwable -> L18
            return false;
        L12:
            if (clipboard.primaryClip == null) goto L22;
            CharSequence text = clipboard.primaryClip.getItemAt(0).getText();     // Catch: Throwable -> L18
            if (text != null) goto L16;
        L20:
            monitor-exit(r12);     // Catch: Throwable -> L18
            return r11;
        L16:
            if (text.length() <= 0) goto L20;
            r11 = true;
        L18:
            th = move-exception;
            throw th;
        }

        public String getPrimaryClipSource(String callingPackage, String attributionTag, int userId, int deviceId) {
            getPrimaryClipSource_enforcePermission();
            int intendingUid = this.this$0.getIntendingUid(callingPackage, userId);
            int intendingUserId = UserHandle.getUserId(intendingUid);
            int intendingDeviceId = ClipboardService.m2876$$Nest$mgetIntendingDeviceId(this.this$0, deviceId, intendingUid);
            if (ClipboardService.m2875$$Nest$mclipboardAccessAllowed(this.this$0, 29, callingPackage, attributionTag, intendingUid, intendingUserId, intendingDeviceId, false) == true) goto L5;
        L22:
            return null;
        L5:
            if (ClipboardService.m2878$$Nest$misDeviceLocked(this.this$0, intendingUserId, deviceId, callingPackage) == true) goto L22;
            Object r10 = this.this$0.mLock;
            monitor-enter(r10);
            Clipboard clipboard = this.this$0.getClipboardLocked(intendingUserId, intendingDeviceId);     // Catch: Throwable -> L16
            if (clipboard != null) goto L12;
        L18:
            monitor-exit(r10);     // Catch: Throwable -> L16
            return null;
        L12:
            if (clipboard.primaryClip == null) goto L18;
            String r11 = clipboard.mPrimaryClipPackage;     // Catch: Throwable -> L16
            monitor-exit(r10);     // Catch: Throwable -> L16
            return r11;
        L16:
            th = move-exception;
            throw th;
        }

        public IObricClipboardManager getIObricExt() {
            return ClipboardService.m2868$$Nest$fgetmObricExt(this.this$0).getIObricExt();
        }
    }

    class ListenerInfo {
        final String mAttributionTag;
        final String mPackageName;
        final int mUid;

        ListenerInfo(ClipboardService this$0, int uid, String packageName, String attributionTag) {
            this.mUid = uid;
            this.mPackageName = packageName;
            this.mAttributionTag = attributionTag;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-iVajhu1BdDLwVL21Gia1rYVqHs, reason: not valid java name */
    public static /* synthetic */ void m2863$r8$lambda$iVajhu1BdDLwVL21Gia1rYVqHs(ClipData r0) {
        lambda$new$2(r0);
    }

    public static /* synthetic */ void $r8$lambda$5ztocsQ0UcPtrhccM09yKp3YwrI(ClipboardService r0, ClipData r1) {
        r0.lambda$new$0(r1);
    }

    public static /* synthetic */ void $r8$lambda$7KoTDMHoMReNv9FaUWUQ84N8AqY(ClipboardService r0, ClipData r1, Integer r2) {
        r0.lambda$new$1(r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$i-TpVE8l_CLZQqJ0xPbAIb9y5rw, reason: not valid java name */
    public static /* synthetic */ void m2864$r8$lambda$iTpVE8l_CLZQqJ0xPbAIb9y5rw(String r0, Clipboard r1, TextClassifier r2) {
        lambda$notifyTextClassifierLocked$6(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$jJFv3zAvb_A-0-b2Lx2yX-CeeW8, reason: not valid java name */
    public static /* synthetic */ void m2865$r8$lambda$jJFv3zAvb_A0b2Lx2yXCeeW8(ClipboardService r0, String r1, int r2, ArraySet r3) {
        r0.lambda$showAccessNotificationLocked$5(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$kjkWPqxIFXcn85FolUIVmCDrYVA(ClipboardService r0, CharSequence r1, ClipData r2, TextClassifier r3, int r4, int r5) {
        r0.lambda$startClassificationLocked$4(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$y1KAIyB809nPOPX3NCfiDWMeAGE(ClipboardService r0, DeviceConfig.Properties r1) {
        r0.lambda$new$3(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmClipboards, reason: not valid java name */
    static /* bridge */ /* synthetic */ SparseArrayMap m2866$$Nest$fgetmClipboards(ClipboardService r0) {
        return r0.mClipboards;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmFilerCatcherHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ FilerCatcherHelper m2867$$Nest$fgetmFilerCatcherHelper(ClipboardService r0) {
        return r0.mFilerCatcherHelper;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmObricExt, reason: not valid java name */
    static /* bridge */ /* synthetic */ IObricClipboardService m2868$$Nest$fgetmObricExt(ClipboardService r0) {
        return r0.mObricExt;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWm, reason: not valid java name */
    static /* bridge */ /* synthetic */ WindowManagerInternal m2869$$Nest$fgetmWm(ClipboardService r0) {
        return r0.mWm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWorkerHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m2870$$Nest$fgetmWorkerHandler(ClipboardService r0) {
        return r0.mWorkerHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmFilerCatcherHelper, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2871$$Nest$fputmFilerCatcherHelper(ClipboardService r0, FilerCatcherHelper r1) {
        r0.mFilerCatcherHelper = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$maddActiveOwnerLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2872$$Nest$maddActiveOwnerLocked(ClipboardService r0, int r1, int r2, String r3) {
        r0.addActiveOwnerLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mcheckDataOwner, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2873$$Nest$mcheckDataOwner(ClipboardService r0, ClipData r1, int r2) {
        r0.checkDataOwner(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mclipboardAccessAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2874$$Nest$mclipboardAccessAllowed(ClipboardService r0, int r1, String r2, String r3, int r4, int r5, int r6) {
        return r0.clipboardAccessAllowed(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: -$$Nest$mclipboardAccessAllowed, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2875$$Nest$mclipboardAccessAllowed(ClipboardService r0, int r1, String r2, String r3, int r4, int r5, int r6, boolean r7) {
        return r0.clipboardAccessAllowed(r1, r2, r3, r4, r5, r6, r7);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetIntendingDeviceId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2876$$Nest$mgetIntendingDeviceId(ClipboardService r0, int r1, int r2) {
        return r0.getIntendingDeviceId(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$mgetIntendingUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m2877$$Nest$mgetIntendingUserId(ClipboardService r0, String r1, int r2) {
        return r0.getIntendingUserId(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$misDeviceLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m2878$$Nest$misDeviceLocked(ClipboardService r0, int r1, int r2, String r3) {
        return r0.isDeviceLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mnotifyTextClassifierLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2879$$Nest$mnotifyTextClassifierLocked(ClipboardService r0, Clipboard r1, String r2, int r3) {
        r0.notifyTextClassifierLocked(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleWriteClipDataStats, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2880$$Nest$mscheduleWriteClipDataStats(ClipboardService r0, ClipData r1, int r2, int r3) {
        r0.scheduleWriteClipDataStats(r1, r2, r3);
    }

    /* JADX INFO: renamed from: -$$Nest$msetPrimaryClipInternalLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2881$$Nest$msetPrimaryClipInternalLocked(ClipboardService r0, ClipData r1, int r2, int r3, String r4) {
        r0.setPrimaryClipInternalLocked(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: -$$Nest$mshowAccessNotificationLocked, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m2882$$Nest$mshowAccessNotificationLocked(ClipboardService r0, String r1, int r2, int r3, Clipboard r4, int r5) {
        r0.showAccessNotificationLocked(r1, r2, r3, r4, r5);
    }

    static {
        CLIP_DATA_TYPES_UNKNOWN = new int[]{0};
    }

    public ClipboardService(Context context) {
        super(context);
        this.mClipboards = new SparseArrayMap();
        this.mShowAccessNotifications = false;
        this.mAllowVirtualDeviceSilos = true;
        this.mMaxClassificationLength = 400;
        this.mLock = new Object();
        this.mObricExt = (IObricClipboardService) ObricImplFactory.getImpl(IObricClipboardService.class, new Object[]{this});
        this.mAmInternal = (ActivityManagerInternal) LocalServices.getService(ActivityManagerInternal.class);
        this.mUgm = UriGrantsManager.getService();
        this.mUgmInternal = (UriGrantsManagerInternal) LocalServices.getService(UriGrantsManagerInternal.class);
        this.mWm = (WindowManagerInternal) LocalServices.getService(WindowManagerInternal.class);
        this.mVdmInternal = (VirtualDeviceManagerInternal) LocalServices.getService(VirtualDeviceManagerInternal.class);
        if (this.mVdmInternal != null) goto L5;
        VirtualDeviceManager r0 = null;
    L6:
        this.mVdm = r0;
        this.mPm = getContext().getPackageManager();
        this.mUm = ServiceManager.getService("user");
        this.mAppOps = (AppOpsManager) getContext().getSystemService("appops");
        this.mContentCaptureInternal = (ContentCaptureManagerInternal) LocalServices.getService(ContentCaptureManagerInternal.class);
        this.mAutofillInternal = (AutofillManagerInternal) LocalServices.getService(AutofillManagerInternal.class);
        IBinder permOwner = this.mUgmInternal.newUriPermissionOwner("clipboard");
        this.mPermissionOwner = permOwner;
        if (Build.IS_EMULATOR == false) goto L10;
        this.mClipboardMonitor = new EmulatorClipboardMonitor(new ClipboardService$$ExternalSyntheticLambda2(this));
    L13:
        updateConfig();
        DeviceConfig.addOnPropertiesChangedListener("clipboard", getContext().getMainExecutor(), new ClipboardService$$ExternalSyntheticLambda5(this));
        HandlerThread workerThread = new HandlerThread(TAG);
        workerThread.start();
        this.mWorkerHandler = workerThread.getThreadHandler();
        return;
    L10:
        if (Build.IS_ARC == false) goto L12;
        this.mClipboardMonitor = new ArcClipboardMonitor(new ClipboardService$$ExternalSyntheticLambda3(this));
        goto L13
    L12:
        this.mClipboardMonitor = new ClipboardService$$ExternalSyntheticLambda4();
        goto L13
    L5:
        r0 = (VirtualDeviceManager) getContext().getSystemService(VirtualDeviceManager.class);
        goto L6
    }

    private /* synthetic */ void lambda$new$0(ClipData clip) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Clipboard clipboard = getClipboardLocked(0, 0);     // Catch: Throwable -> L8
        if (clipboard == null) goto L10;
        setPrimaryClipInternalLocked(clipboard, clip, 1000, null);     // Catch: Throwable -> L8
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private /* synthetic */ void lambda$new$1(ClipData clip, Integer uid) {
        setPrimaryClipInternal(clip, uid.intValue());
    }

    private static /* synthetic */ void lambda$new$2(ClipData clip) {
    }

    private /* synthetic */ void lambda$new$3(DeviceConfig.Properties properties) {
        updateConfig();
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        publishBinderService("clipboard", new ClipboardImpl(this));
        registerVirtualDeviceListener();
    }

    private void registerVirtualDeviceListener() {
        if (this.mVdm != null) goto L5;
        return;
    L5:
        if (this.mVirtualDeviceListener != null) goto L10;
        this.mVirtualDeviceListener = new AnonymousClass1(this);
        this.mVdm.registerVirtualDeviceListener(getContext().getMainExecutor(), this.mVirtualDeviceListener);
        return;
    }

    @Override // com.android.server.SystemService
    public void onUserStopped(SystemService.TargetUser user) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mClipboards.delete(user.getUserIdentifier());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void updateConfig() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mShowAccessNotifications = DeviceConfig.getBoolean("clipboard", "show_access_notifications", false);     // Catch: Throwable -> L7
        this.mAllowVirtualDeviceSilos = DeviceConfig.getBoolean("clipboard", "allow_virtualdevice_silos", true);     // Catch: Throwable -> L7
        this.mMaxClassificationLength = DeviceConfig.getInt("clipboard", PROPERTY_MAX_CLASSIFICATION_LENGTH, 400);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private boolean isInternalSysWindowAppWithWindowFocus(String callingPackage) {
        if (this.mPm.checkPermission("android.permission.INTERNAL_SYSTEM_WINDOW", callingPackage) == 0) goto L5;
        return false;
    L5:
        if (this.mWm.isUidFocused(Binder.getCallingUid()) == false) goto L10;
        return true;
    L10:
        return false;
    }

    private int getIntendingUserId(String packageName, int userId) {
        int callingUid = Binder.getCallingUid();
        int callingUserId = UserHandle.getUserId(callingUid);
        if (UserManager.supportsMultipleUsers() == false) goto L9;
        if (callingUserId == userId) goto L9;
        int intendingUserId = this.mAmInternal.handleIncomingUser(Binder.getCallingPid(), Binder.getCallingUid(), userId, false, 2, "checkClipboardServiceCallingUser", packageName);
        return intendingUserId;
    L9:
        return callingUserId;
    }

    int getIntendingUid(String packageName, int userId) {
        return UserHandle.getUid(getIntendingUserId(packageName, userId), UserHandle.getAppId(Binder.getCallingUid()));
    }

    private int getIntendingDeviceId(int requestedDeviceId, int uid) {
        if (this.mVdmInternal != null) goto L5;
        return 0;
    L5:
        ArraySet<Integer> virtualDeviceIds = this.mVdmInternal.getDeviceIdsForUid(uid);
        Object r2 = this.mLock;
        monitor-enter(r2);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (this.mAllowVirtualDeviceSilos == false) goto L10;
    L16:
        monitor-exit(r2);     // Catch: Throwable -> L14
        boolean allDevicesHaveDefaultClipboard = true;
        Iterator<Integer> r3 = virtualDeviceIds.iterator();
    L19:
        if (r3.hasNext() == false) goto L24;
        int deviceId = r3.next().intValue();
        if (deviceUsesDefaultClipboard(deviceId) == true) goto L19;
        allDevicesHaveDefaultClipboard = false;
    L24:
        if (requestedDeviceId != 0) goto L30;
        if (allDevicesHaveDefaultClipboard == false) goto L28;
        return 0;
    L28:
        return -1;
    L30:
        if (deviceUsesDefaultClipboard(requestedDeviceId) == false) goto L32;
        int clipboardDeviceId = 0;
    L34:
        if (this.mVdmInternal.getDeviceOwnerUid(requestedDeviceId) != uid) goto L36;
    L45:
        return clipboardDeviceId;
    L36:
        if (virtualDeviceIds.contains(Integer.valueOf(requestedDeviceId)) == true) goto L45;
        if (clipboardDeviceId != 0) goto L40;
        if (allDevicesHaveDefaultClipboard == true) goto L45;
    L40:
        int fallbackDeviceId = virtualDeviceIds.valueAt(0).intValue();
        if (deviceUsesDefaultClipboard(fallbackDeviceId) == false) goto L44;
        return 0;
    L44:
        return fallbackDeviceId;
    L32:
        clipboardDeviceId = requestedDeviceId;
        goto L34
    L10:
        if (virtualDeviceIds.isEmpty() == false) goto L12;
        if (requestedDeviceId == 0) goto L16;
    L12:
        monitor-exit(r2);     // Catch: Throwable -> L14
        return -1;
    }

    private boolean deviceUsesDefaultClipboard(int deviceId) {
        if (deviceId != 0) goto L5;
    L12:
        return true;
    L5:
        if (this.mVdm == null) goto L12;
        if (this.mVdm.getDevicePolicy(deviceId, 4) == 1) goto L13;
        return false;
    L13:
        return true;
    }

    Clipboard getClipboardLocked(int userId, int deviceId) {
        Clipboard clipboard = (Clipboard) this.mClipboards.get(userId, Integer.valueOf(deviceId));
        if (clipboard == null) goto L23;
        return clipboard;
    L23:
    L9:
        e = move-exception;
        Slog.e(TAG, "RemoteException calling UserManager: " + e);
        return null;
    L6:
        if (this.mUm.isUserRunning(userId) == true) goto L12;
        Slog.w(TAG, "getClipboardLocked called with not running userId " + userId);     // Catch: RemoteException -> L9
        return null;
    L12:
        if (deviceId != 0) goto L14;
    L19:
        Clipboard clipboard2 = new Clipboard(userId, deviceId);
        this.mClipboards.add(userId, Integer.valueOf(deviceId), clipboard2);
        return clipboard2;
    L14:
        if (this.mVdm == null) goto L19;
        if (this.mVdm.isValidVirtualDeviceId(deviceId) == true) goto L19;
        Slog.w(TAG, "getClipboardLocked called with invalid (possibly released) deviceId " + deviceId);
        return null;
    }

    List<UserInfo> getRelatedProfiles(int userId) {
        long origId = Binder.clearCallingIdentity();
        List<UserInfo> related = this.mUm.getProfiles(userId, true);     // Catch: Throwable -> L6 RemoteException -> L8
        Binder.restoreCallingIdentity(origId);
        return related;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(origId);
        throw th;
    L8:
        e = move-exception;
        Slog.e(TAG, "Remote Exception calling UserManager: " + e);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(origId);
        return null;
    }

    private boolean hasRestriction(String restriction, int userId) {
        return this.mUm.hasUserRestriction(restriction, userId);
    L4:
        e = move-exception;
        Slog.e(TAG, "Remote Exception calling UserManager.getUserRestrictions: ", e);
        return true;
    }

    void setPrimaryClipInternal(ClipData clip, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setPrimaryClipInternalLocked(clip, uid, 0, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void setPrimaryClipInternalLocked(ClipData clip, int uid, int deviceId, String sourcePackage) {
        if (deviceId != 0) goto L4;
        this.mClipboardMonitor.accept(clip);
    L4:
        int userId = UserHandle.getUserId(uid);
        Clipboard clipboard = getClipboardLocked(userId, deviceId);
        if (this.mObricExt.isClipDataFromOauto(clip) == true) goto L7;
    L9:
        if (clipboard != null) goto L11;
        return;
    L11:
        setPrimaryClipInternalLocked(clipboard, clip, uid, sourcePackage);
        List<UserInfo> related = getRelatedProfiles(userId);
        if (related == null) goto L34;
        int size = related.size();
        if (size <= 1) goto L41;
        boolean canCopy = !hasRestriction("no_cross_profile_copy_paste", userId);
        if (canCopy == true) goto L18;
        clip = null;
    L24:
        int i = 0;
    L25:
        if (i >= size) goto L42;
        int id = related.get(i).id;
        if (id == userId) goto L33;
        boolean canCopyIntoProfile = !hasRestriction("no_sharing_into_profile", id);
        if (canCopyIntoProfile == false) goto L33;
        Clipboard relatedClipboard = getClipboardLocked(id, deviceId);
        if (relatedClipboard == null) goto L33;
        setPrimaryClipInternalNoClassifyLocked(relatedClipboard, clip, uid, sourcePackage);
    L33:
        i = i + 1;
        goto L25
    L42:
        return;
    L18:
        if (clip == null) goto L24;
        clip = new ClipData(clip);
        int i2 = clip.getItemCount() - 1;
    L21:
        if (i2 < 0) goto L23;
        clip.setItemAt(i2, new ClipData.Item(clip.getItemAt(i2)));
        i2 = i2 - 1;
        goto L21
    L23:
        clip.fixUrisLight(userId);
        goto L24
    L41:
        return;
    L34:
        return;
    L7:
        if (this.mWm.getObricWindowManagerInternal().shouldClipBoardIsolate() == false) goto L9;
        clipboard = this.mObricExt.getClipboardLockedInOautoDisplay(userId, deviceId);
        goto L9
    }

    void setPrimaryClipInternal(Clipboard clipboard, ClipData clip, int uid) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        setPrimaryClipInternalLocked(clipboard, clip, uid, null);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void setPrimaryClipInternalLocked(Clipboard clipboard, ClipData clip, int uid, String sourcePackage) {
        int userId = UserHandle.getUserId(uid);
        if (clip == null) goto L5;
        startClassificationLocked(clip, userId, clipboard.deviceId);
    L5:
        setPrimaryClipInternalNoClassifyLocked(clipboard, clip, uid, sourcePackage);
    }

    private void setPrimaryClipInternalNoClassifyLocked(Clipboard clipboard, ClipData clip, int uid, String sourcePackage) {
        revokeUris(clipboard);
        clipboard.activePermissionOwners.clear();
        if (clip == null) goto L5;
    L7:
        clipboard.primaryClip = clip;
        clipboard.mNotifiedUids.clear();
        clipboard.mNotifiedTextClassifierUids.clear();
        if (clip == null) goto L10;
        clipboard.primaryClipUid = uid;
        clipboard.mPrimaryClipPackage = sourcePackage;
    L11:
        if (clip == null) goto L15;
        ClipDescription description = clip.getDescription();
        if (description == null) goto L15;
        description.setTimestamp(System.currentTimeMillis());
    L15:
        sendClipChangedBroadcast(clipboard);
        return;
    L10:
        clipboard.primaryClipUid = 9999;
        clipboard.mPrimaryClipPackage = null;
        goto L11
    L5:
        if (clipboard.primaryClip != null) goto L7;
    }

    void sendClipChangedBroadcast(Clipboard clipboard) {
        long ident = Binder.clearCallingIdentity();
        int n = clipboard.primaryClipListeners.beginBroadcast();
        int i = 0;
    L3:
        if (i >= n) goto L18;
        ListenerInfo li = (ListenerInfo) clipboard.primaryClipListeners.getBroadcastCookie(i);     // Catch: Throwable -> L7 Throwable -> L9
        if (clipboard.needIsolate == false) goto L12;
        clipboard.primaryClipListeners.getBroadcastItem(i).dispatchPrimaryClipChanged();     // Catch: Throwable -> L7 Throwable -> L9
        goto L17
    L12:
        if (clipboardAccessAllowed(29, li.mPackageName, li.mAttributionTag, li.mUid, UserHandle.getUserId(li.mUid), clipboard.deviceId) == false) goto L17;
        clipboard.primaryClipListeners.getBroadcastItem(i).dispatchPrimaryClipChanged();     // Catch: Throwable -> L7 Throwable -> L9
        goto L17
    L7:
        th = move-exception;
        clipboard.primaryClipListeners.finishBroadcast();
        Binder.restoreCallingIdentity(ident);
        throw th;
    L17:
        i = i + 1;
        goto L3
    L18:
        clipboard.primaryClipListeners.finishBroadcast();
        Binder.restoreCallingIdentity(ident);
    }

    private void startClassificationLocked(final ClipData clip, final int userId, final int deviceId) {
        if (clip.getItemCount() != 0) goto L5;
        CharSequence r0 = null;
    L6:
        final CharSequence text = r0;
        if (TextUtils.isEmpty(text) == true) goto L23;
        if (text.length() > this.mMaxClassificationLength) goto L23;
        long ident = Binder.clearCallingIdentity();
        final TextClassifier classifier = createTextClassificationManagerAsUser(userId).createTextClassificationSession(new TextClassificationContext.Builder(getContext().getPackageName(), "clipboard").build());     // Catch: Throwable -> L19
        Binder.restoreCallingIdentity(ident);
        if (text.length() <= classifier.getMaxGenerateLinksTextLength()) goto L17;
        clip.getDescription().setClassificationStatus(2);
        return;
    L17:
        this.mWorkerHandler.post(new ClipboardService$$ExternalSyntheticLambda1(this, text, clip, classifier, userId, deviceId));
        return;
    L19:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L23:
        clip.getDescription().setClassificationStatus(2);
        return;
    L5:
        r0 = clip.getItemAt(0).getText();
        goto L6
    }

    private /* synthetic */ void lambda$startClassificationLocked$4(CharSequence text, ClipData clip, TextClassifier classifier, int userId, int deviceId) {
        doClassification(text, clip, classifier, userId, deviceId);
    }

    private void doClassification(CharSequence text, ClipData clip, TextClassifier classifier, int userId, int deviceId) {
        TextLinks.Request request = new TextLinks.Request.Builder(text).build();
        TextLinks links = classifier.generateLinks(request);
        ArrayMap<String, Float> confidences = new ArrayMap();
        Iterator<TextLinks.TextLink> r0 = links.getLinks().iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        TextLinks.TextLink link = r0.next();
        int i = 0;
    L7:
        if (i >= link.getEntityCount()) goto L4;
        String entity = link.getEntity(i);
        float conf = link.getConfidenceScore(entity);
        if (conf <= confidences.getOrDefault(entity, Float.valueOf(0.0f)).floatValue()) goto L11;
        confidences.put(entity, Float.valueOf(conf));
    L11:
        i = i + 1;
        goto L7
    L13:
        Object r9 = this.mLock;
        monitor-enter(r9);
        Clipboard clipboard = getClipboardLocked(userId, deviceId);     // Catch: Throwable -> L19
        if (clipboard != null) goto L23;
        monitor-exit(r9);     // Catch: Throwable -> L19
        return;
    L23:
        if (clipboard.primaryClip != clip) goto L46;
        applyClassificationAndSendBroadcastLocked(clipboard, confidences, links, classifier);     // Catch: Throwable -> L37
        List<UserInfo> related = getRelatedProfiles(userId);     // Catch: Throwable -> L37
        if (related == null) goto L46;
        int size = related.size();     // Catch: Throwable -> L37
        int i2 = 0;
    L27:
        if (i2 >= size) goto L46;
        int id = related.get(i2).id;     // Catch: Throwable -> L37
        if (id == userId) goto L41;
        boolean canCopyIntoProfile = !hasRestriction("no_sharing_into_profile", id);     // Catch: Throwable -> L37
        if (canCopyIntoProfile == false) goto L40;
        Clipboard relatedClipboard = getClipboardLocked(id, deviceId);     // Catch: Throwable -> L37
        if (relatedClipboard == null) goto L39;
        Clipboard clipboard2 = clipboard;
        if (hasTextLocked(relatedClipboard, text) == false) goto L42;
        applyClassificationAndSendBroadcastLocked(relatedClipboard, confidences, links, classifier);     // Catch: Throwable -> L37
    L42:
        i2 = i2 + 1;     // Catch: Throwable -> L37
        clipboard = clipboard2;
        goto L27
    L39:
        clipboard2 = clipboard;
        goto L42
    L40:
        clipboard2 = clipboard;
        goto L42
    L41:
        clipboard2 = clipboard;
    L46:
        monitor-exit(r9);     // Catch: Throwable -> L37
        return;
    L19:
        th = th;
    L48:
        monitor-exit(r9);     // Catch: Throwable -> L37
        throw th;
    L37:
        th = th;
        goto L48
    }

    private void applyClassificationAndSendBroadcastLocked(Clipboard clipboard, ArrayMap<String, Float> confidences, TextLinks links, TextClassifier classifier) {
        clipboard.mTextClassifier = classifier;
        clipboard.primaryClip.getDescription().setConfidenceScores(confidences);
        if (links.getLinks().isEmpty() == true) goto L5;
        clipboard.primaryClip.getItemAt(0).setTextLinks(links);
    L5:
        sendClipChangedBroadcast(clipboard);
    }

    private boolean hasTextLocked(Clipboard clipboard, CharSequence text) {
        if (clipboard.primaryClip != null) goto L5;
        return false;
    L5:
        if (clipboard.primaryClip.getItemCount() > 0) goto L7;
        return false;
    L7:
        if (text.equals(clipboard.primaryClip.getItemAt(0).getText()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    private boolean isDeviceLocked(int userId, int deviceId) {
        long token = Binder.clearCallingIdentity();
        KeyguardManager keyguardManager = (KeyguardManager) getContext().getSystemService(KeyguardManager.class);     // Catch: Throwable -> L8
        if (keyguardManager == null) goto L10;
        if (keyguardManager.isDeviceLocked(userId, deviceId) == false) goto L10;
        boolean r3 = true;
    L11:
        Binder.restoreCallingIdentity(token);
        return r3;
    L10:
        r3 = false;
    L8:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    private boolean isDeviceLocked(int userId, int deviceId, String pkg) {
        if (pkg == null) goto L8;
        if (this.mWm.getObricWindowManagerInternal().isPkgRunWithOAuto(pkg) == false) goto L8;
        Slog.i(TAG, "skip lock check in OAuto : pkg:" + pkg);
        return false;
    L8:
        return isDeviceLocked(userId, deviceId);
    }

    private void checkUriOwner(Uri uri, int sourceUid) {
        if (uri == null) goto L19;
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L24;
        long ident = Binder.clearCallingIdentity();
        this.mUgmInternal.checkGrantUriPermission(sourceUid, null, ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(sourceUid)));     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(ident);
        return;
    L12:
        th = move-exception;
        Throwable r11 = th;
    L16:
        Binder.restoreCallingIdentity(ident);
        throw r11;
    L14:
        th = move-exception;
        r11 = th;
        goto L16
    L24:
        return;
    }

    private void checkItemOwner(ClipData.Item item, int uid) {
        if (item.getUri() == null) goto L5;
        checkUriOwner(item.getUri(), uid);
    L5:
        Intent intent = item.getIntent();
        if (intent != null) goto L8;
        return;
    L8:
        if (intent.getData() == null) goto L12;
        checkUriOwner(intent.getData(), uid);
        return;
    }

    private void checkDataOwner(ClipData data, int uid) {
        int N = data.getItemCount();
        int i = 0;
    L3:
        if (i >= N) goto L6;
        checkItemOwner(data.getItemAt(i), uid);
        i = i + 1;
        goto L3
    }

    private void grantUriPermission(Uri uri, int sourceUid, String targetPkg, int targetUserId) {
        if (uri == null) goto L23;
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L28;
        long ident = Binder.clearCallingIdentity();
        goto L10
    L24:
        this.mUgm.grantUriPermissionFromOwner(this.mPermissionOwner, sourceUid, targetPkg, ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(sourceUid)), targetUserId);     // Catch: Throwable -> L11 RemoteException -> L13
    L11:
        th = move-exception;
        Throwable r13 = th;
    L19:
        Binder.restoreCallingIdentity(ident);
        throw r13;
    L15:
        th = move-exception;
        r13 = th;
    L10:
        Binder.restoreCallingIdentity(ident);
        return;
    L28:
        return;
    }

    private void grantItemPermission(ClipData.Item item, int sourceUid, String targetPkg, int targetUserId) {
        if (item.getUri() == null) goto L5;
        grantUriPermission(item.getUri(), sourceUid, targetPkg, targetUserId);
    L5:
        Intent intent = item.getIntent();
        if (intent != null) goto L8;
        return;
    L8:
        if (intent.getData() == null) goto L12;
        grantUriPermission(intent.getData(), sourceUid, targetPkg, targetUserId);
        return;
    }

    private void addActiveOwnerLocked(int uid, int deviceId, String pkg) {
        PackageManagerInternal pm = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        int targetUserHandle = UserHandle.getCallingUserId();
        long oldIdentity = Binder.clearCallingIdentity();
        if (uid == 0) goto L13;
        int uid2 = uid;
        String pkg2 = pkg;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(oldIdentity);
        throw th;
    L6:
        if (pm.isSameApp(pkg2, 0, uid2, targetUserHandle) == true) goto L14;
        Slog.i(TAG, "Calling uid " + uid2 + " does not own package " + pkg2);     // Catch: Throwable -> L10
        throw new SecurityException("Calling uid " + uid2 + " does not own package " + pkg2);     // Catch: Throwable -> L10
    L14:
        Binder.restoreCallingIdentity(oldIdentity);
        Clipboard clipboard = getClipboardLocked(UserHandle.getUserId(uid2), deviceId);
        if (clipboard != null) goto L17;
        return;
    L17:
        if (clipboard.primaryClip != null) goto L19;
        return;
    L19:
        if (clipboard.activePermissionOwners.contains(pkg2) == true) goto L30;
        int N = clipboard.primaryClip.getItemCount();
        int i = 0;
    L21:
        if (i >= N) goto L23;
        grantItemPermission(clipboard.primaryClip.getItemAt(i), clipboard.primaryClipUid, pkg2, UserHandle.getUserId(uid2));
        i = i + 1;
        goto L21
    L23:
        clipboard.activePermissionOwners.add(pkg2);
        return;
    L30:
        return;
    L13:
        uid2 = uid;
        pkg2 = pkg;
        goto L14
    }

    private void revokeUriPermission(Uri uri, int sourceUid) {
        if (uri != null) goto L4;
        return;
    L4:
        if (ActivityTaskManagerInternal.ASSIST_KEY_CONTENT.equals(uri.getScheme()) == false) goto L16;
        long ident = Binder.clearCallingIdentity();
        this.mUgmInternal.revokeUriPermissionFromOwner(this.mPermissionOwner, ContentProvider.getUriWithoutUserId(uri), 1, ContentProvider.getUserIdFromUri(uri, UserHandle.getUserId(sourceUid)));     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(ident);
        return;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    }

    private void revokeItemPermission(ClipData.Item item, int sourceUid) {
        if (item.getUri() == null) goto L5;
        revokeUriPermission(item.getUri(), sourceUid);
    L5:
        Intent intent = item.getIntent();
        if (intent != null) goto L8;
        return;
    L8:
        if (intent.getData() == null) goto L12;
        revokeUriPermission(intent.getData(), sourceUid);
        return;
    }

    private void revokeUris(Clipboard clipboard) {
        if (clipboard.primaryClip != null) goto L5;
        return;
    L5:
        int N = clipboard.primaryClip.getItemCount();
        int i = 0;
    L6:
        if (i >= N) goto L9;
        revokeItemPermission(clipboard.primaryClip.getItemAt(i), clipboard.primaryClipUid);
        i = i + 1;
        goto L6
    }

    private boolean clipboardAccessAllowed(int op, String callingPackage, String attributionTag, int uid, int userId, int intendingDeviceId) {
        return clipboardAccessAllowed(op, callingPackage, attributionTag, uid, userId, intendingDeviceId, true);
    }

    private boolean clipboardAccessAllowed(int op, String callingPackage, String attributionTag, int uid, int userId, int intendingDeviceId, boolean shouldNoteOp) {
        this.mAppOps.checkPackage(uid, callingPackage);
        if (intendingDeviceId != (-1)) goto L7;
        Slog.w(TAG, "Clipboard access denied to " + uid + SliceClientPermissions.SliceAuthority.DELIMITER + callingPackage + " due to invalid device id");
        return false;
    L7:
        if (this.mPm.checkPermission("android.permission.READ_CLIPBOARD_IN_BACKGROUND", callingPackage) != 0) goto L9;
        boolean allowed = true;
    L11:
        switch(op) {
            case 29: goto L15;
            case 30: goto L14;
            default: goto L13;
        };
    L14:
        boolean allowed2 = true;
    L44:
        if (allowed2 == true) goto L47;
        Slog.e(TAG, "Denying clipboard access to " + callingPackage + ", application is not in focus nor is it a system service for user " + userId);
        return false;
    L47:
        if (shouldNoteOp == false) goto L49;
        int appOpsResult = this.mAppOps.noteOp(op, uid, callingPackage, attributionTag, null);
    L50:
        if (appOpsResult == 0) goto L52;
        return false;
    L52:
        return true;
    L49:
        appOpsResult = this.mAppOps.checkOp(op, uid, callingPackage);
        goto L50
    L15:
        if (allowed == false) goto L17;
    L26:
        if (allowed == false) goto L28;
    L30:
        if (allowed == false) goto L32;
    L34:
        if (allowed == true) goto L43;
        if (intendingDeviceId == 0) goto L43;
        if (this.mVdmInternal != null) goto L39;
    L41:
        boolean r5 = false;
    L42:
        boolean allowed3 = r5;
        allowed2 = allowed3;
        goto L44
    L39:
        if (this.mVdmInternal.getDeviceOwnerUid(intendingDeviceId) != uid) goto L41;
        r5 = true;
    L43:
        allowed2 = allowed;
        goto L44
    L32:
        if (this.mAutofillInternal == null) goto L34;
        allowed = this.mAutofillInternal.isAugmentedAutofillServiceForUser(uid, userId);
        goto L34
    L28:
        if (this.mContentCaptureInternal == null) goto L30;
        allowed = this.mContentCaptureInternal.isContentCaptureServiceForUser(uid, userId);
        goto L30
    L17:
        if (isDefaultDeviceAndUidFocused(intendingDeviceId, uid) == false) goto L19;
    L24:
        boolean r6 = true;
    L25:
        allowed = r6;
        goto L26
    L19:
        if (isVirtualDeviceAndUidFocused(intendingDeviceId, uid) == true) goto L24;
        if (isInternalSysWindowAppWithWindowFocus(callingPackage) == true) goto L24;
        r6 = false;
        goto L25
    L13:
        throw new IllegalArgumentException("Unknown clipboard appop " + op);
    L9:
        allowed = isDefaultIme(userId, callingPackage);
        goto L11
    }

    private boolean isDefaultDeviceAndUidFocused(int intendingDeviceId, int uid) {
        if (intendingDeviceId == 0) goto L4;
    L6:
        return false;
    L4:
        if (this.mWm.isUidFocused(uid) == false) goto L6;
        return true;
    }

    private boolean isVirtualDeviceAndUidFocused(int intendingDeviceId, int uid) {
        if (intendingDeviceId != 0) goto L5;
    L13:
        return false;
    L5:
        if (this.mVdm == null) goto L13;
        int topFocusedDisplayId = this.mWm.getTopFocusedDisplayId();
        int focusedDeviceId = this.mVdm.getDeviceIdForDisplayId(topFocusedDisplayId);
        if (focusedDeviceId == intendingDeviceId) goto L10;
        return false;
    L10:
        if (this.mWm.isUidFocused(uid) == false) goto L15;
        return true;
    L15:
        return false;
    }

    private boolean isDefaultIme(int userId, String packageName) {
        String defaultIme = Settings.Secure.getStringForUser(getContext().getContentResolver(), "default_input_method", userId);
        if (TextUtils.isEmpty(defaultIme) == true) goto L9;
        ComponentName imeComponent = ComponentName.unflattenFromString(defaultIme);
        if (imeComponent != null) goto L7;
        return false;
    L7:
        String imePkg = imeComponent.getPackageName();
        return imePkg.equals(packageName);
    L9:
        return false;
    }

    private void showAccessNotificationLocked(final String r4, int r5, final int r6, Clipboard r7, int r8) {
        if (r7.primaryClip != null) goto L6;
        return;
    L6:
        if (Settings.Secure.getInt(getContext().getContentResolver(), "clipboard_show_access_notifications", this.mShowAccessNotifications ? 1 : 0) != 0) goto L9;
        return;
    L9:
        if (UserHandle.isSameApp(r5, r7.primaryClipUid) == false) goto L12;
        return;
    L12:
        if (isDefaultIme(r6, r4) == false) goto L15;
        return;
    L15:
        if (this.mContentCaptureInternal == null) goto L20;
        if (this.mContentCaptureInternal.isContentCaptureServiceForUser(r5, r6) == false) goto L20;
        return;
    L20:
        if (this.mAutofillInternal == null) goto L25;
        if (this.mAutofillInternal.isAugmentedAutofillServiceForUser(r5, r6) == false) goto L25;
        return;
    L25:
        if (this.mPm.checkPermission("android.permission.SUPPRESS_CLIPBOARD_ACCESS_NOTIFICATION", r4) != 0) goto L28;
        return;
    L28:
        if (r7.deviceId == 0) goto L35;
        if (this.mVdmInternal == null) goto L35;
        if (this.mVdmInternal.getDeviceOwnerUid(r7.deviceId) != r5) goto L35;
        return;
    L35:
        if (r7.mNotifiedUids.get(r5) == false) goto L37;
        return;
    L37:
        final ArraySet<Context> r0 = getToastContexts(r7, r8);
        Binder.withCleanCallingIdentity(new ClipboardService$$ExternalSyntheticLambda6(this, r4, r6, r0));
        r7.mNotifiedUids.put(r5, true);
    }

    private /* synthetic */ void lambda$showAccessNotificationLocked$5(String callingPackage, int userId, ArraySet toastContexts) throws Exception {
        CharSequence callingAppLabel = this.mPm.getApplicationLabel(this.mPm.getApplicationInfoAsUser(callingPackage, 0, userId));     // Catch: PackageManager.NameNotFoundException -> L8
        String message = getContext().getString(R.string.permdesc_writeSettings, new Object[]{callingAppLabel});     // Catch: PackageManager.NameNotFoundException -> L8
        Slog.i(TAG, message);     // Catch: PackageManager.NameNotFoundException -> L8
        int i = 0;
    L3:
        if (i >= toastContexts.size()) goto L18;
        Context toastContext = (Context) toastContexts.valueAt(i);     // Catch: PackageManager.NameNotFoundException -> L8
        if (SafetyProtectionUtils.shouldShowSafetyProtectionResources(getContext()) == false) goto L10;
        Drawable safetyProtectionIcon = getContext().getDrawable(R.drawable.ic_safety_protection);     // Catch: PackageManager.NameNotFoundException -> L8
        Toast toastToShow = Toast.makeCustomToastWithIcon(toastContext, UiThread.get().getLooper(), message, 1, safetyProtectionIcon);     // Catch: PackageManager.NameNotFoundException -> L8
    L11:
        toastToShow.show();     // Catch: PackageManager.NameNotFoundException -> L8
        i = i + 1;
        goto L3
    L10:
        toastToShow = Toast.makeText(toastContext, UiThread.get().getLooper(), message, 1);     // Catch: PackageManager.NameNotFoundException -> L8
        goto L11
    L18:
        return;
    }

    private ArraySet<Context> getToastContexts(Clipboard clipboard, int accessDeviceId) throws IllegalStateException {
        ArraySet<Context> contexts = new ArraySet();
        if (clipboard.deviceId == 0) goto L5;
        if (accessDeviceId == 0) goto L5;
    L6:
        if (accessDeviceId != 0) goto L10;
        if (clipboard.deviceId != 0) goto L10;
    L11:
        return contexts;
    L10:
        if (this.mVdmInternal == null) goto L11;
        DisplayManager displayManager = (DisplayManager) getContext().getSystemService(DisplayManager.class);
        ArraySet<Integer> displayIds = this.mVdmInternal.getDisplayIdsForDevice(accessDeviceId);
        int topFocusedDisplayId = this.mWm.getTopFocusedDisplayId();
        if (displayIds.contains(Integer.valueOf(topFocusedDisplayId)) == false) goto L18;
        Display display = displayManager.getDisplay(topFocusedDisplayId);
        if (display == null) goto L18;
        contexts.add(getContext().createDisplayContext(display));
        return contexts;
    L18:
        int i = 0;
    L20:
        if (i >= displayIds.size()) goto L26;
        Display display2 = displayManager.getDisplay(displayIds.valueAt(i).intValue());
        if (display2 == null) goto L24;
        contexts.add(getContext().createDisplayContext(display2));
    L24:
        i = i + 1;
        goto L20
    L26:
        if (contexts.isEmpty() == false) goto L28;
        Slog.e(TAG, "getToastContexts Couldn't find any VirtualDisplays for VirtualDevice " + accessDeviceId);
        contexts.add(getContext());
    L28:
        return contexts;
    L5:
        contexts.add(getContext());
        goto L6
    }

    private static boolean isText(ClipData data) {
        if (data.getItemCount() <= 1) goto L5;
        return false;
    L5:
        ClipData.Item item = data.getItemAt(0);
        if (TextUtils.isEmpty(item.getText()) == false) goto L8;
        return false;
    L8:
        if (item.getUri() == null) goto L10;
        return false;
    L10:
        if (item.getIntent() == null) goto L13;
        return false;
    L13:
        return true;
    }

    private void notifyTextClassifierLocked(final Clipboard clipboard, final String callingPackage, int callingUid) {
        if (clipboard.primaryClip != null) goto L5;
        return;
    L5:
        ClipData.Item item = clipboard.primaryClip.getItemAt(0);
        if (item != null) goto L9;
        return;
    L9:
        if (isText(clipboard.primaryClip) == true) goto L11;
        return;
    L11:
        final TextClassifier textClassifier = clipboard.mTextClassifier;
        if (textClassifier != null) goto L15;
        return;
    L15:
        if (this.mWm.isUidFocused(callingUid) == true) goto L18;
        return;
    L18:
        if (clipboard.mNotifiedTextClassifierUids.get(callingUid) == false) goto L20;
        return;
    L20:
        clipboard.mNotifiedTextClassifierUids.put(callingUid, true);
        Binder.withCleanCallingIdentity(new ClipboardService$$ExternalSyntheticLambda0(callingPackage, clipboard, textClassifier));
    }

    private static /* synthetic */ void lambda$notifyTextClassifierLocked$6(String callingPackage, Clipboard clipboard, TextClassifier textClassifier) throws Exception {
        TextClassifierEvent.TextLinkifyEvent pasteEvent = ((TextClassifierEvent.TextLinkifyEvent.Builder) ((TextClassifierEvent.TextLinkifyEvent.Builder) new TextClassifierEvent.TextLinkifyEvent.Builder(22).setEventContext(new TextClassificationContext.Builder(callingPackage, "clipboard").build())).setExtras(Bundle.forPair("source_package", clipboard.mPrimaryClipPackage))).build();
        textClassifier.onTextClassifierEvent(pasteEvent);
    }

    private TextClassificationManager createTextClassificationManagerAsUser(int userId) {
        Context context = getContext().createContextAsUser(UserHandle.of(userId), 0);
        return (TextClassificationManager) context.getSystemService(TextClassificationManager.class);
    }

    private static int mimeTypeToClipDataType(String mimeType) {
        switch(mimeType.hashCode()) {
            case -2081372539: goto L27;
            case -1882575103: goto L24;
            case -1353317361: goto L21;
            case -1082243251: goto L18;
            case -1032783713: goto L15;
            case -39850682: goto L12;
            case 817335912: goto L9;
            case 1178484637: goto L6;
            default: goto L29;
        };
    L29:
        byte r0 = -1;
    L30:
        switch(r0) {
            case 0: goto L38;
            case 1: goto L37;
            case 2: goto L36;
            case 3: goto L35;
            case 4: goto L34;
            case 5: goto L33;
            case 6: goto L32;
            default: goto L31;
        };
    L31:
        return 0;
    L32:
        return 7;
    L33:
        return 6;
    L34:
        return 5;
    L35:
        return 4;
    L36:
        return 3;
    L37:
        return 2;
    L38:
        return 1;
    L6:
        if (mimeType.equals("application/octet-stream") == false) goto L29;
        r0 = 7;
        goto L30
    L9:
        if (mimeType.equals("text/plain") == false) goto L29;
        r0 = 0;
        goto L30
    L12:
        if (mimeType.equals("application/vnd.android.shortcut") == false) goto L29;
        r0 = 5;
        goto L30
    L15:
        if (mimeType.equals("text/vnd.android.intent") == false) goto L29;
        r0 = 3;
        goto L30
    L18:
        if (mimeType.equals("text/html") == false) goto L29;
        r0 = 1;
        goto L30
    L21:
        if (mimeType.equals("application/vnd.android.activity") == false) goto L29;
        r0 = 4;
        goto L30
    L24:
        if (mimeType.equals("text/uri-list") == false) goto L29;
        r0 = 2;
        goto L30
    L27:
        if (mimeType.equals("application/vnd.android.task") == false) goto L29;
        r0 = 6;
        goto L30
    }

    private void scheduleWriteClipDataStats(ClipData clipData, int sourceUid, int intendingUid) {
    }

    private /* synthetic */ void lambda$scheduleWriteClipDataStats$7(int sourceUid, int intendingUid, IntArray mimeTypes, int secondsSinceSet) {
        FrameworkStatsLog.write(FrameworkStatsLog.CLIPBOARD_GET_EVENT_REPORTED, sourceUid, intendingUid, this.mAmInternal.getUidProcessState(intendingUid), mimeTypes.toArray(), secondsSinceSet);
    }

    private /* synthetic */ void lambda$scheduleWriteClipDataStats$8(int sourceUid, int intendingUid) {
        FrameworkStatsLog.write(FrameworkStatsLog.CLIPBOARD_GET_EVENT_REPORTED, sourceUid, intendingUid, this.mAmInternal.getUidProcessState(intendingUid), CLIP_DATA_TYPES_UNKNOWN, 0);
    }
}
