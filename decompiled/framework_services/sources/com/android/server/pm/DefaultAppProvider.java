package com.android.server.pm;

import android.app.role.RoleManager;
import android.os.Binder;
import android.os.UserHandle;
import android.util.Slog;
import com.android.internal.util.CollectionUtils;
import com.android.server.FgThread;
import java.util.concurrent.Executor;
import java.util.function.Consumer;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes2.dex */
public class DefaultAppProvider {
    private final Supplier<RoleManager> mRoleManagerSupplier;
    private final Supplier<UserManagerInternal> mUserManagerInternalSupplier;

    public static /* synthetic */ void $r8$lambda$JzMEkagUaXGx3UqyflTl11c7Ig4(String r0, Boolean r1) {
        lambda$setDefaultBrowser$0(r0, r1);
    }

    public DefaultAppProvider(Supplier<RoleManager> roleManagerSupplier, Supplier<UserManagerInternal> userManagerInternalSupplier) {
        this.mRoleManagerSupplier = roleManagerSupplier;
        this.mUserManagerInternalSupplier = userManagerInternalSupplier;
    }

    public String getDefaultBrowser(int userId) {
        return getRoleHolder("android.app.role.BROWSER", userId);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDefaultBrowser(final String packageName, int userId) {
        RoleManager roleManager = this.mRoleManagerSupplier.get();
        if (roleManager != null) goto L5;
        return;
    L5:
        UserHandle user = UserHandle.of(userId);
        Executor executor = FgThread.getExecutor();
        Consumer<Boolean> callback = new DefaultAppProvider$$ExternalSyntheticLambda0(packageName);
        long identity = Binder.clearCallingIdentity();
        if (packageName == null) goto L27;
        roleManager.addRoleHolderAsUser("android.app.role.BROWSER", packageName, 0, user, executor, callback);     // Catch: Throwable -> L11
    L20:
        Binder.restoreCallingIdentity(identity);
        return;
    L11:
        th = th;
    L23:
        Binder.restoreCallingIdentity(identity);
        throw th;
    L27:
        roleManager.clearRoleHoldersAsUser("android.app.role.BROWSER", 0, user, executor, callback);     // Catch: Throwable -> L13
    L13:
        th = th;
        goto L23
    }

    private static /* synthetic */ void lambda$setDefaultBrowser$0(String packageName, Boolean successful) {
        if (successful.booleanValue() == true) goto L6;
        Slog.e(PackageManagerServiceMonitorEx.TAG, "Failed to set default browser to " + packageName);
        return;
    }

    public String getDefaultDialer(int userId) {
        return getRoleHolder("android.app.role.DIALER", userId);
    }

    public String getDefaultHome(int userId) {
        return getRoleHolder("android.app.role.HOME", this.mUserManagerInternalSupplier.get().getProfileParentId(userId));
    }

    public boolean setDefaultHome(String packageName, int userId, Executor executor, Consumer<Boolean> callback) {
        RoleManager roleManager = this.mRoleManagerSupplier.get();
        if (roleManager != null) goto L6;
        return false;
    L6:
        long identity = Binder.clearCallingIdentity();
        roleManager.addRoleHolderAsUser("android.app.role.HOME", packageName, 0, UserHandle.of(userId), executor, callback);     // Catch: Throwable -> L12
        Binder.restoreCallingIdentity(identity);
        return true;
    L12:
        th = move-exception;
        Throwable r11 = th;
    L16:
        Binder.restoreCallingIdentity(identity);
        throw r11;
    L14:
        th = move-exception;
        r11 = th;
        goto L16
    }

    private String getRoleHolder(String roleName, int userId) {
        RoleManager roleManager = this.mRoleManagerSupplier.get();
        if (roleManager != null) goto L6;
        return null;
    L6:
        long identity = Binder.clearCallingIdentity();
        String r3 = (String) CollectionUtils.firstOrNull(roleManager.getRoleHoldersAsUser(roleName, UserHandle.of(userId)));     // Catch: Throwable -> L10
        Binder.restoreCallingIdentity(identity);
        return r3;
    L10:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }
}
