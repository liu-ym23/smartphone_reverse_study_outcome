package com.android.server.usb;

import android.content.Context;
import android.content.pm.UserInfo;
import android.os.UserHandle;
import android.os.UserManager;
import android.util.SparseArray;
import com.android.internal.util.dump.DualDumpOutputStream;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class UsbSettingsManager {
    private static final boolean DEBUG = false;
    private static final String LOG_TAG = null;
    private final Context mContext;
    private final SparseArray<UsbProfileGroupSettingsManager> mSettingsByProfileGroup;
    private final SparseArray<UsbUserSettingsManager> mSettingsByUser;
    private UsbHandlerManager mUsbHandlerManager;
    final UsbService mUsbService;
    private UserManager mUserManager;

    static {
        LOG_TAG = UsbSettingsManager.class.getSimpleName();
    }

    UsbSettingsManager(Context context, UsbService usbService) {
        this.mSettingsByUser = new SparseArray();
        this.mSettingsByProfileGroup = new SparseArray();
        this.mContext = context;
        this.mUsbService = usbService;
        this.mUserManager = (UserManager) context.getSystemService("user");
        this.mUsbHandlerManager = new UsbHandlerManager(context);
    }

    public UsbUserSettingsManager getSettingsForUser(int userId) {
        SparseArray<UsbUserSettingsManager> r0 = this.mSettingsByUser;
        monitor-enter(r0);
        UsbUserSettingsManager settings = this.mSettingsByUser.get(userId);     // Catch: Throwable -> L7
        if (settings != null) goto L9;
        settings = new UsbUserSettingsManager(this.mContext, UserHandle.of(userId));     // Catch: Throwable -> L7
        this.mSettingsByUser.put(userId, settings);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return settings;
    L7:
        th = move-exception;
        throw th;
    }

    UsbProfileGroupSettingsManager getSettingsForProfileGroup(UserHandle user) {
        UserInfo parentUserInfo = this.mUserManager.getProfileParent(user.getIdentifier());
        if (parentUserInfo == null) goto L5;
        UserHandle parentUser = parentUserInfo.getUserHandle();
    L6:
        SparseArray<UsbProfileGroupSettingsManager> r2 = this.mSettingsByProfileGroup;
        monitor-enter(r2);
        UsbProfileGroupSettingsManager settings = this.mSettingsByProfileGroup.get(parentUser.getIdentifier());     // Catch: Throwable -> L11
        if (settings != null) goto L13;
        settings = new UsbProfileGroupSettingsManager(this.mContext, parentUser, this, this.mUsbHandlerManager);     // Catch: Throwable -> L11
        this.mSettingsByProfileGroup.put(parentUser.getIdentifier(), settings);     // Catch: Throwable -> L11
    L13:
        monitor-exit(r2);     // Catch: Throwable -> L11
        return settings;
    L11:
        th = move-exception;
        throw th;
    L5:
        parentUser = user;
        goto L6
    }

    void remove(UserHandle userToRemove) {
        SparseArray<UsbUserSettingsManager> r0 = this.mSettingsByUser;
        monitor-enter(r0);
        this.mSettingsByUser.remove(userToRemove.getIdentifier());     // Catch: Throwable -> L20
        monitor-exit(r0);     // Catch: Throwable -> L20
        SparseArray<UsbProfileGroupSettingsManager> r1 = this.mSettingsByProfileGroup;
        monitor-enter(r1);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mSettingsByProfileGroup.indexOfKey(userToRemove.getIdentifier()) < 0) goto L13;
        this.mSettingsByProfileGroup.get(userToRemove.getIdentifier()).unregisterReceivers();     // Catch: Throwable -> L11
        this.mSettingsByProfileGroup.remove(userToRemove.getIdentifier());     // Catch: Throwable -> L11
    L16:
        monitor-exit(r1);     // Catch: Throwable -> L11
        return;
    L13:
        int numProfileGroups = this.mSettingsByProfileGroup.size();     // Catch: Throwable -> L11
        int i = 0;
    L14:
        if (i >= numProfileGroups) goto L16;
        this.mSettingsByProfileGroup.valueAt(i).removeUser(userToRemove);     // Catch: Throwable -> L11
        i = i + 1;     // Catch: Throwable -> L11
    L20:
        th = move-exception;
        throw th;
    }

    void dump(DualDumpOutputStream dump, String idName, long id) {
        long token = dump.start(idName, id);
        SparseArray<UsbUserSettingsManager> r2 = this.mSettingsByUser;
        monitor-enter(r2);
        List<UserInfo> users = this.mUserManager.getUsers();     // Catch: Throwable -> L7
        int numUsers = users.size();     // Catch: Throwable -> L7
        int i = 0;
    L5:
        if (i >= numUsers) goto L10;
        getSettingsForUser(users.get(i).id).dump(dump, "user_settings", 2246267895809L);     // Catch: Throwable -> L7
        i = i + 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r2);     // Catch: Throwable -> L7
        SparseArray<UsbProfileGroupSettingsManager> r3 = this.mSettingsByProfileGroup;
        monitor-enter(r3);
        int numProfileGroups = this.mSettingsByProfileGroup.size();     // Catch: Throwable -> L16
        int i2 = 0;
    L14:
        if (i2 >= numProfileGroups) goto L19;
        this.mSettingsByProfileGroup.valueAt(i2).dump(dump, "profile_group_settings", 2246267895810L);     // Catch: Throwable -> L16
        i2 = i2 + 1;     // Catch: Throwable -> L16
        goto L14
    L19:
        monitor-exit(r3);     // Catch: Throwable -> L16
        dump.end(token);
        return;
    L16:
        th = move-exception;
        throw th;
    L7:
        th = move-exception;
        throw th;
    }
}
