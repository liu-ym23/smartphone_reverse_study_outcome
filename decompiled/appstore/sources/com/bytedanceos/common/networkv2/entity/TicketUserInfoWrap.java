package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class TicketUserInfoWrap {
    private AccountUserBean data;
    private int errno;

    public TicketUserInfoWrap() {
    }

    public AccountUserBean getData() {
        return this.data;
    }

    public int getErrno() {
        return this.errno;
    }

    public void setData(AccountUserBean r10) {
        this.data = r10;
    }

    public void setErrno(int r10) {
        this.errno = r10;
    }
}
