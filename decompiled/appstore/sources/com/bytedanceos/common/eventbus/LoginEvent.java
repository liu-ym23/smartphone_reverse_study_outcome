package com.bytedanceos.common.eventbus;

/* JADX INFO: loaded from: classes2.dex */
public class LoginEvent extends BaseEvent {
    private boolean isLogin;

    public LoginEvent(boolean r10) {
        this.isLogin = r10;
    }

    public boolean isLogin() {
        return this.isLogin;
    }

    public void setLogin(boolean r10) {
        this.isLogin = r10;
    }
}
