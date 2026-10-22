package com.android.server.notification;

import android.content.IntentFilter;
import android.content.pm.LauncherApps;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutServiceInternal;
import android.os.Binder;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.util.Slog;
import com.android.server.pm.PackageManagerService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class ShortcutHelper {
    private static final IntentFilter SHARING_FILTER = null;
    private static final String TAG = "ShortcutHelper";
    private final HashMap<String, HashMap<String, String>> mActiveShortcutBubbles;
    private LauncherApps mLauncherAppsService;
    private final LauncherApps.ShortcutChangeCallback mShortcutChangeCallback;
    private boolean mShortcutChangedCallbackRegistered;
    private final ShortcutListener mShortcutListener;
    private ShortcutServiceInternal mShortcutServiceInternal;
    private UserManager mUserManager;

    interface ShortcutListener {
        void onShortcutRemoved(String r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmActiveShortcutBubbles, reason: not valid java name */
    static /* bridge */ /* synthetic */ HashMap m6280$$Nest$fgetmActiveShortcutBubbles(ShortcutHelper r0) {
        return r0.mActiveShortcutBubbles;
    }

    /* JADX INFO: renamed from: -$$Nest$mgetPackageUserKey, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m6281$$Nest$mgetPackageUserKey(ShortcutHelper r0, String r1, UserHandle r2) {
        return r0.getPackageUserKey(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$monShortcutRemoved, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m6282$$Nest$monShortcutRemoved(ShortcutHelper r0, String r1, String r2) {
        r0.onShortcutRemoved(r1, r2);
    }

    static {
        SHARING_FILTER = new IntentFilter();
        SHARING_FILTER.addDataType("*/*");     // Catch: IntentFilter.MalformedMimeTypeException -> L5
        return;
    L5:
        e = move-exception;
        Slog.e(TAG, "Bad mime type", e);
    }

    ShortcutHelper(LauncherApps launcherApps, ShortcutListener listener, ShortcutServiceInternal shortcutServiceInternal, UserManager userManager) {
        this.mActiveShortcutBubbles = new HashMap();
        this.mShortcutChangeCallback = new AnonymousClass1(this);
        this.mLauncherAppsService = launcherApps;
        this.mShortcutListener = listener;
        this.mShortcutServiceInternal = shortcutServiceInternal;
        this.mUserManager = userManager;
    }

    void setLauncherApps(LauncherApps launcherApps) {
        this.mLauncherAppsService = launcherApps;
    }

    void setShortcutServiceInternal(ShortcutServiceInternal shortcutServiceInternal) {
        this.mShortcutServiceInternal = shortcutServiceInternal;
    }

    void setUserManager(UserManager userManager) {
        this.mUserManager = userManager;
    }

    public static boolean isConversationShortcut(ShortcutInfo shortcutInfo, ShortcutServiceInternal shortcutServiceInternal, int callingUserId) {
        if (shortcutInfo != null) goto L4;
        return false;
    L4:
        if (shortcutInfo.isLongLived() == true) goto L6;
        return false;
    L6:
        if (shortcutInfo.isEnabled() == false) goto L13;
        return true;
    L13:
        return false;
    }

    ShortcutInfo getValidShortcutInfo(String shortcutId, String packageName, UserHandle user) {
        if (this.mLauncherAppsService != null) goto L5;
    L30:
        return null;
    L5:
        if (this.mUserManager.isUserUnlocked(user) == false) goto L30;
        long token = Binder.clearCallingIdentity();
        if (shortcutId == null) goto L28;
        if (packageName == null) goto L28;
        if (user == null) goto L28;
        LauncherApps.ShortcutQuery query = new LauncherApps.ShortcutQuery();     // Catch: Throwable -> L17
        query.setPackage(packageName);     // Catch: Throwable -> L17
        query.setShortcutIds(Arrays.asList(new String[]{shortcutId}));     // Catch: Throwable -> L17
        query.setQueryFlags(3089);     // Catch: Throwable -> L17
        List<ShortcutInfo> shortcuts = this.mLauncherAppsService.getShortcuts(query, user);     // Catch: Throwable -> L17
        if (shortcuts != null) goto L15;
    L19:
        ShortcutInfo info = null;
    L20:
        if (isConversationShortcut(info, this.mShortcutServiceInternal, user.getIdentifier()) == false) goto L24;
        Binder.restoreCallingIdentity(token);
        return info;
    L24:
        Binder.restoreCallingIdentity(token);
        return null;
    L15:
        if (shortcuts.size() <= 0) goto L19;
        info = shortcuts.get(0);     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    L28:
        Binder.restoreCallingIdentity(token);
        return null;
    }

    void cacheShortcut(ShortcutInfo shortcutInfo, UserHandle user) {
        if (shortcutInfo.isLongLived() == true) goto L5;
        return;
    L5:
        if (shortcutInfo.isCached() == true) goto L9;
        this.mShortcutServiceInternal.cacheShortcuts(user.getIdentifier(), PackageManagerService.PLATFORM_PACKAGE_NAME, shortcutInfo.getPackage(), Collections.singletonList(shortcutInfo.getId()), shortcutInfo.getUserId(), 16384);
        return;
    }

    void maybeListenForShortcutChangesForBubbles(NotificationRecord r, boolean removedNotification) {
        if (r.getNotification().getBubbleMetadata() == null) goto L5;
        String shortcutId = r.getNotification().getBubbleMetadata().getShortcutId();
    L6:
        String packageUserKey = getPackageUserKey(r.getSbn().getPackageName(), r.getUser());
        if (removedNotification == false) goto L9;
    L18:
        HashMap<String, String> packageBubbles = this.mActiveShortcutBubbles.get(packageUserKey);
        if (packageBubbles != null) goto L21;
    L33:
        unregisterCallbackIfNeeded();
        return;
    L21:
        if (TextUtils.isEmpty(shortcutId) == true) goto L23;
        packageBubbles.remove(shortcutId);
    L31:
        if (packageBubbles.isEmpty() == false) goto L33;
        this.mActiveShortcutBubbles.remove(packageUserKey);
        goto L33
    L23:
        Set<String> shortcutIds = new HashSet(packageBubbles.keySet());
        Iterator<String> r4 = shortcutIds.iterator();
    L25:
        if (r4.hasNext() == false) goto L31;
        String pkgShortcutId = r4.next();
        String entryKey = packageBubbles.get(pkgShortcutId);
        if (r.getKey().equals(entryKey) == false) goto L25;
        packageBubbles.remove(pkgShortcutId);
        goto L25
    L9:
        if (TextUtils.isEmpty(shortcutId) == true) goto L18;
        if (r.getShortcutInfo() == null) goto L18;
        if (r.getShortcutInfo().getId().equals(shortcutId) == false) goto L18;
        HashMap<String, String> packageBubbles2 = this.mActiveShortcutBubbles.get(packageUserKey);
        if (packageBubbles2 != null) goto L17;
        packageBubbles2 = new HashMap();
    L17:
        packageBubbles2.put(shortcutId, r.getKey());
        this.mActiveShortcutBubbles.put(packageUserKey, packageBubbles2);
        registerCallbackIfNeeded();
        return;
    L5:
        shortcutId = null;
        goto L6
    }

    private String getPackageUserKey(String packageName, UserHandle user) {
        return packageName + "|" + user.getIdentifier();
    }

    private void onShortcutRemoved(String packageUserKey, String shortcutId) {
        HashMap<String, String> shortcutBubbles = this.mActiveShortcutBubbles.get(packageUserKey);
        ArrayList<String> bubbleKeysToRemove = new ArrayList();
        if (shortcutBubbles != null) goto L5;
        return;
    L5:
        if (shortcutBubbles.containsKey(shortcutId) == false) goto L9;
        bubbleKeysToRemove.add(shortcutBubbles.get(shortcutId));
        shortcutBubbles.remove(shortcutId);
        if (shortcutBubbles.isEmpty() == false) goto L9;
        this.mActiveShortcutBubbles.remove(packageUserKey);
        unregisterCallbackIfNeeded();
    L9:
        notifyNoMan(bubbleKeysToRemove);
    }

    private void registerCallbackIfNeeded() {
        if (this.mShortcutChangedCallbackRegistered == true) goto L6;
        this.mShortcutChangedCallbackRegistered = true;
        this.mShortcutServiceInternal.addShortcutChangeCallback(this.mShortcutChangeCallback);
        return;
    }

    private void unregisterCallbackIfNeeded() {
        if (this.mShortcutChangedCallbackRegistered == true) goto L5;
        return;
    L5:
        if (this.mActiveShortcutBubbles.isEmpty() == false) goto L9;
        this.mShortcutServiceInternal.removeShortcutChangeCallback(this.mShortcutChangeCallback);
        this.mShortcutChangedCallbackRegistered = false;
        return;
    }

    void destroy() {
        if (this.mShortcutChangedCallbackRegistered == false) goto L6;
        this.mShortcutServiceInternal.removeShortcutChangeCallback(this.mShortcutChangeCallback);
        this.mShortcutChangedCallbackRegistered = false;
        return;
    }

    private void notifyNoMan(List<String> bubbleKeysToRemove) {
        int i = 0;
    L4:
        if (i >= bubbleKeysToRemove.size()) goto L10;
        String bubbleKey = bubbleKeysToRemove.get(i);
        if (this.mShortcutListener == null) goto L8;
        this.mShortcutListener.onShortcutRemoved(bubbleKey);
    L8:
        i = i + 1;
        goto L4
    }
}
