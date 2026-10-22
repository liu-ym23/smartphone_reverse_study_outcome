package com.bytedance.android.live.base.model.user;

/* JADX INFO: loaded from: classes45.dex */
public class UserEvent {
    private IBaseUser.Status status;
    private IBaseUser user;

    public boolean isLogOut() {
        if (this.status != IBaseUser.Status.Logout) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isLogin() {
        if (this.status != IBaseUser.Status.Login) goto L5;
        return true;
    L5:
        return false;
    }

    public IBaseUser.Status getStatus() {
        return this.status;
    }

    public IBaseUser getUser() {
        return this.user;
    }

    public UserEvent(IBaseUser.Status r100, IBaseUser r101) {
        this.status = r100;
        this.user = r101;
    }
}
