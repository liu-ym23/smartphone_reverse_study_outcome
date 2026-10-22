package com.android.server.inputmethod;

import java.util.function.Consumer;
import java.util.function.IntFunction;

/* JADX INFO: loaded from: classes2.dex */
final class UserDataRepository {
    private final IntFunction<InputMethodBindingController> mBindingControllerFactory;
    private final Object mMutationLock;
    private volatile ImmutableSparseArray<UserData> mUserData;
    private final IntFunction<ImeVisibilityStateComputer> mVisibilityStateComputerFactory;

    UserData getOrCreate(int userId) {
        UserData userData = this.mUserData.get(userId);
        if (userData == null) goto L5;
        return userData;
    L5:
        UserData newUserData = new UserData(userId, this.mBindingControllerFactory.apply(userId), this.mVisibilityStateComputerFactory.apply(userId));
        Object r2 = this.mMutationLock;
        monitor-enter(r2);
        this.mUserData = this.mUserData.cloneWithPutOrSelf(userId, newUserData);     // Catch: Throwable -> L10
        monitor-exit(r2);     // Catch: Throwable -> L10
        return newUserData;
    L10:
        th = move-exception;
        throw th;
    }

    void forAllUserData(Consumer<UserData> consumer) {
        this.mUserData.forEach(consumer);
    }

    UserDataRepository(IntFunction<InputMethodBindingController> bindingControllerFactory, IntFunction<ImeVisibilityStateComputer> visibilityStateComputerFactory) {
        this.mMutationLock = new Object();
        this.mUserData = ImmutableSparseArray.empty();
        this.mBindingControllerFactory = bindingControllerFactory;
        this.mVisibilityStateComputerFactory = visibilityStateComputerFactory;
    }

    void remove(int userId) {
        Object r0 = this.mMutationLock;
        monitor-enter(r0);
        this.mUserData = this.mUserData.cloneWithRemoveOrSelf(userId);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
