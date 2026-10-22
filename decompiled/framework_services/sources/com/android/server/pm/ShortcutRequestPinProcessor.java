package com.android.server.pm;

import android.appwidget.AppWidgetProviderInfo;
import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.IPinItemRequest;
import android.content.pm.LauncherApps;
import android.content.pm.ShortcutInfo;
import android.os.Bundle;
import android.os.UserHandle;
import android.util.Log;
import android.util.Pair;
import com.android.internal.util.Preconditions;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
class ShortcutRequestPinProcessor {
    private static final boolean DEBUG = false;
    private static final String TAG = "ShortcutService";
    private final Object mLock;
    private final ShortcutService mService;

    private static class PinAppWidgetRequestInner extends PinItemRequestInner {
        final AppWidgetProviderInfo mAppWidgetProviderInfo;
        final Bundle mExtras;

        /* synthetic */ PinAppWidgetRequestInner(ShortcutRequestPinProcessor r1, IntentSender r2, int r3, AppWidgetProviderInfo r4, Bundle r5, ShortcutRequestPinProcessorIA r6) {
            this(r1, r2, r3, r4, r5);
        }

        private PinAppWidgetRequestInner(ShortcutRequestPinProcessor processor, IntentSender resultIntent, int launcherUid, AppWidgetProviderInfo appWidgetProviderInfo, Bundle extras) {
            super(processor, resultIntent, launcherUid, null);
            this.mAppWidgetProviderInfo = appWidgetProviderInfo;
            this.mExtras = extras;
        }

        @Override // com.android.server.pm.ShortcutRequestPinProcessor.PinItemRequestInner
        public AppWidgetProviderInfo getAppWidgetProviderInfo() {
            return this.mAppWidgetProviderInfo;
        }

        @Override // com.android.server.pm.ShortcutRequestPinProcessor.PinItemRequestInner
        public Bundle getExtras() {
            return this.mExtras;
        }
    }

    private static abstract class PinItemRequestInner extends IPinItemRequest.Stub {
        private boolean mAccepted;
        private final int mLauncherUid;
        protected final ShortcutRequestPinProcessor mProcessor;
        private final IntentSender mResultIntent;

        /* synthetic */ PinItemRequestInner(ShortcutRequestPinProcessor r1, IntentSender r2, int r3, ShortcutRequestPinProcessorIA r4) {
            this(r1, r2, r3);
        }

        private PinItemRequestInner(ShortcutRequestPinProcessor processor, IntentSender resultIntent, int launcherUid) {
            this.mProcessor = processor;
            this.mResultIntent = resultIntent;
            this.mLauncherUid = launcherUid;
        }

        public ShortcutInfo getShortcutInfo() {
            return null;
        }

        public AppWidgetProviderInfo getAppWidgetProviderInfo() {
            return null;
        }

        public Bundle getExtras() {
            return null;
        }

        private boolean isCallerValid() {
            return this.mProcessor.isCallerUid(this.mLauncherUid);
        }

        public boolean isValid() {
            boolean r1 = false;
            if (isCallerValid() == true) goto L5;
            return false;
        L5:
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (this.mAccepted == true) goto L9;
            r1 = true;
        L9:
            monitor-exit(this);     // Catch: Throwable -> L11
            return r1;
        }

        public boolean accept(Bundle options) {
            if (isCallerValid() == false) goto L29;
            Intent extras = null;
            if (options != null) goto L30;
        L11:
            monitor-enter(this);
        L22:
            th = move-exception;
            throw th;
        L13:
            if (this.mAccepted == true) goto L25;
            this.mAccepted = true;     // Catch: Throwable -> L22
            monitor-exit(this);     // Catch: Throwable -> L22
            if (tryAccept() == false) goto L20;
            this.mProcessor.sendResultIntent(this.mResultIntent, extras);
            return true;
        L20:
            return false;
        L25:
            throw new IllegalStateException("accept() called already");     // Catch: Throwable -> L22
        L30:
            options.size();     // Catch: RuntimeException -> L8
            extras = new Intent().putExtras(options);     // Catch: RuntimeException -> L8
        L8:
            e = move-exception;
            throw new IllegalArgumentException("options cannot be unparceled", e);
        L29:
            throw new SecurityException("Calling uid mismatch");
        }

        protected boolean tryAccept() {
            return true;
        }
    }

    private static class PinShortcutRequestInner extends PinItemRequestInner {
        public final String launcherPackage;
        public final int launcherUserId;
        public final boolean preExisting;
        public final ShortcutInfo shortcutForLauncher;
        public final ShortcutInfo shortcutOriginal;

        /* synthetic */ PinShortcutRequestInner(ShortcutRequestPinProcessor r1, ShortcutInfo r2, ShortcutInfo r3, IntentSender r4, String r5, int r6, int r7, boolean r8, ShortcutRequestPinProcessorIA r9) {
            this(r1, r2, r3, r4, r5, r6, r7, r8);
        }

        private PinShortcutRequestInner(ShortcutRequestPinProcessor processor, ShortcutInfo shortcutOriginal, ShortcutInfo shortcutForLauncher, IntentSender resultIntent, String launcherPackage, int launcherUserId, int launcherUid, boolean preExisting) {
            super(processor, resultIntent, launcherUid, null);
            this.shortcutOriginal = shortcutOriginal;
            this.shortcutForLauncher = shortcutForLauncher;
            this.launcherPackage = launcherPackage;
            this.launcherUserId = launcherUserId;
            this.preExisting = preExisting;
        }

        @Override // com.android.server.pm.ShortcutRequestPinProcessor.PinItemRequestInner
        public ShortcutInfo getShortcutInfo() {
            return this.shortcutForLauncher;
        }

        @Override // com.android.server.pm.ShortcutRequestPinProcessor.PinItemRequestInner
        protected boolean tryAccept() {
            return this.mProcessor.directPinShortcut(this);
        }
    }

    public ShortcutRequestPinProcessor(ShortcutService service, Object lock) {
        this.mService = service;
        this.mLock = lock;
    }

    public boolean isRequestPinItemSupported(int callingUserId, int requestType) {
        if (getRequestPinConfirmationActivity(callingUserId, requestType) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean requestPinItemLocked(ShortcutInfo inShortcut, AppWidgetProviderInfo inAppWidget, Bundle extras, int userId, IntentSender resultIntent) {
        if (inShortcut == null) goto L5;
        int requestType = 1;
    L6:
        Pair<ComponentName, Integer> confirmActivity = getRequestPinConfirmationActivity(userId, requestType);
        if (confirmActivity != null) goto L10;
        Log.w(TAG, "Launcher doesn't support requestPinnedShortcut(). Shortcut not created.");
        return false;
    L10:
        int launcherUserId = ((Integer) confirmActivity.second).intValue();
        this.mService.throwIfUserLockedL(launcherUserId);
        if (inShortcut == null) goto L13;
        LauncherApps.PinItemRequest request = requestPinShortcutLocked(inShortcut, resultIntent, ((ComponentName) confirmActivity.first).getPackageName(), ((Integer) confirmActivity.second).intValue());
    L15:
        return startRequestConfirmActivity((ComponentName) confirmActivity.first, launcherUserId, request, requestType);
    L13:
        int launcherUid = this.mService.injectGetPackageUid(((ComponentName) confirmActivity.first).getPackageName(), launcherUserId);
        request = new LauncherApps.PinItemRequest(new PinAppWidgetRequestInner(this, resultIntent, launcherUid, inAppWidget, extras, null), 2);
        goto L15
    L5:
        requestType = 2;
        goto L6
    }

    public Intent createShortcutResultIntent(ShortcutInfo inShortcut, int userId) {
        int launcherUserId = this.mService.getParentOrSelfUserId(userId);
        String defaultLauncher = this.mService.getDefaultLauncher(launcherUserId);
        if (defaultLauncher != null) goto L6;
        Log.e(TAG, "Default launcher not found.");
        return null;
    L6:
        this.mService.throwIfUserLockedL(launcherUserId);
        LauncherApps.PinItemRequest request = requestPinShortcutLocked(inShortcut, null, defaultLauncher, launcherUserId);
        return new Intent().putExtra("android.content.pm.extra.PIN_ITEM_REQUEST", request);
    }

    private LauncherApps.PinItemRequest requestPinShortcutLocked(ShortcutInfo inShortcut, IntentSender resultIntentOriginal, String launcherPackage, int launcherUserId) {
        ShortcutPackage ps = this.mService.getPackageShortcutsForPublisherLocked(inShortcut.getPackage(), inShortcut.getUserId());
        ShortcutInfo existing = ps.findShortcutById(inShortcut.getId());
        boolean r0 = false;
        if (existing == null) goto L5;
        boolean existsAlready = true;
    L6:
        if (existsAlready == true) goto L8;
    L10:
        IntentSender resultIntentToSend = resultIntentOriginal;
        if (existsAlready == false) goto L21;
        validateExistingShortcut(existing);
        boolean isAlreadyPinned = this.mService.getLauncherShortcutsLocked(launcherPackage, existing.getUserId(), launcherUserId).hasPinned(existing);
        if (isAlreadyPinned == false) goto L16;
        sendResultIntent(resultIntentOriginal, null);
        resultIntentToSend = null;
    L16:
        ShortcutInfo shortcutForLauncher = existing.clone(27);
        if (isAlreadyPinned == true) goto L19;
        shortcutForLauncher.clearFlags(2);
    L19:
        IntentSender resultIntentToSend2 = resultIntentToSend;
    L24:
        PinShortcutRequestInner inner = new PinShortcutRequestInner(this, inShortcut, shortcutForLauncher, resultIntentToSend2, launcherPackage, launcherUserId, this.mService.injectGetPackageUid(launcherPackage, launcherUserId), existsAlready, null);
        return new LauncherApps.PinItemRequest(inner, 1);
    L21:
        if (inShortcut.getActivity() != null) goto L23;
        inShortcut.setActivity(this.mService.injectGetDefaultMainActivity(inShortcut.getPackage(), inShortcut.getUserId()));
    L23:
        this.mService.validateShortcutForPinRequest(inShortcut);
        inShortcut.resolveResourceStrings(this.mService.injectGetResourcesForApplicationAsUser(inShortcut.getPackage(), inShortcut.getUserId()));
        shortcutForLauncher = inShortcut.clone(26);
        resultIntentToSend2 = resultIntentToSend;
        goto L24
    L8:
        if (existing.isVisibleToPublisher() == false) goto L10;
        r0 = true;
        goto L10
    L5:
        existsAlready = false;
        goto L6
    }

    private void validateExistingShortcut(ShortcutInfo shortcutInfo) {
        Preconditions.checkArgument(shortcutInfo.isEnabled(), "Shortcut ID=" + shortcutInfo + " already exists but disabled.");
    }

    private boolean startRequestConfirmActivity(ComponentName activity, int launcherUserId, LauncherApps.PinItemRequest request, int requestType) {
        if (requestType != 1) goto L5;
        String action = "android.content.pm.action.CONFIRM_PIN_SHORTCUT";
    L6:
        Intent confirmIntent = new Intent(action);
        confirmIntent.setComponent(activity);
        confirmIntent.putExtra("android.content.pm.extra.PIN_ITEM_REQUEST", request);
        confirmIntent.addFlags(268468224);
        long token = this.mService.injectClearCallingIdentity();
    L16:
        e = move-exception;
        Log.e(TAG, "Unable to start activity " + activity, e);     // Catch: Throwable -> L14
        this.mService.injectRestoreCallingIdentity(token);
        return false;
    L14:
        th = move-exception;
        this.mService.injectRestoreCallingIdentity(token);
        throw th;
    L8:
        if (this.mService.getObricExt().startRequestConfirmActivity(confirmIntent, launcherUserId, request).booleanValue() == false) goto L11;
        this.mService.injectRestoreCallingIdentity(token);
        return true;
    L11:
        this.mService.mContext.startActivityAsUser(confirmIntent, UserHandle.of(launcherUserId));     // Catch: Throwable -> L14 RuntimeException -> L16
        this.mService.injectRestoreCallingIdentity(token);
        return true;
    L5:
        action = "android.content.pm.action.CONFIRM_PIN_APPWIDGET";
        goto L6
    }

    Pair<ComponentName, Integer> getRequestPinConfirmationActivity(int callingUserId, int requestType) {
        if (this.mService.areShortcutsSupportedOnHomeScreen(callingUserId) == true) goto L5;
        return null;
    L5:
        int launcherUserId = this.mService.getParentOrSelfUserId(callingUserId);
        String defaultLauncher = this.mService.getDefaultLauncher(launcherUserId);
        if (defaultLauncher != null) goto L9;
        Log.e(TAG, "Default launcher not found.");
        return null;
    L9:
        ComponentName activity = this.mService.injectGetPinConfirmationActivity(defaultLauncher, launcherUserId, requestType);
        if (activity != null) goto L13;
        return null;
    L13:
        return Pair.create(activity, Integer.valueOf(launcherUserId));
    }

    public void sendResultIntent(IntentSender intent, Intent extras) {
        this.mService.injectSendIntentSender(intent, extras);
    }

    public boolean isCallerUid(int uid) {
        if (uid != this.mService.injectBinderCallingUid()) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean directPinShortcut(PinShortcutRequestInner request) {
        ShortcutInfo original = request.shortcutOriginal;
        int appUserId = original.getUserId();
        String appPackageName = original.getPackage();
        int launcherUserId = request.launcherUserId;
        String launcherPackage = request.launcherPackage;
        String shortcutId = original.getId();
        Object r10 = this.mLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mService.isUserUnlockedL(appUserId) == false) goto L40;
        if (this.mService.isUserUnlockedL(request.launcherUserId) == false) goto L40;
        ShortcutLauncher launcher = this.mService.getLauncherShortcutsLocked(launcherPackage, appUserId, launcherUserId);     // Catch: Throwable -> L13
        launcher.attemptToRestoreIfNeededAndSave();     // Catch: Throwable -> L13
        if (launcher.hasPinned(original) == false) goto L15;
        monitor-exit(r10);     // Catch: Throwable -> L13
        return true;
    L15:
        ShortcutPackage ps = this.mService.getPackageShortcutsForPublisherLocked(appPackageName, appUserId);     // Catch: Throwable -> L13
        ShortcutInfo current = ps.findShortcutById(shortcutId);     // Catch: Throwable -> L13
        if (current != null) goto L21;
        this.mService.validateShortcutForPinRequest(original);     // Catch: Throwable -> L13 RuntimeException -> L19
    L23:
        if (current == null) goto L25;
    L28:
        launcher.addPinnedShortcut(appPackageName, appUserId, shortcutId, true);     // Catch: Throwable -> L13
        if (current != null) goto L31;
        ps.deleteDynamicWithId(shortcutId, false);     // Catch: Throwable -> L13
    L31:
        ps.adjustRanks();     // Catch: Throwable -> L13
        List<ShortcutInfo> changedShortcuts = Collections.singletonList(ps.findShortcutById(shortcutId));     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        this.mService.verifyStates();
        this.mService.packageShortcutsChanged(ps, changedShortcuts, null);
        return true;
    L25:
        if (original.getActivity() != null) goto L27;
        original.setActivity(this.mService.getDummyMainActivity(appPackageName));     // Catch: Throwable -> L13
    L27:
        ps.addOrReplaceDynamicShortcut(original);     // Catch: Throwable -> L13
        goto L28
    L21:
        validateExistingShortcut(current);     // Catch: Throwable -> L13 RuntimeException -> L19
    L19:
        e = move-exception;
        Log.w(TAG, "Unable to pin shortcut: " + e.getMessage());     // Catch: Throwable -> L13
        return false;
    L40:
        Log.w(TAG, "User is locked now.");     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return 0;
    }
}
