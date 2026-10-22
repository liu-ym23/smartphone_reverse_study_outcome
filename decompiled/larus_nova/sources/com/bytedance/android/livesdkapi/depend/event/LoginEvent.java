package com.bytedance.android.livesdkapi.depend.event;

import android.os.Bundle;
import java.util.HashMap;

/* JADX INFO: loaded from: classes12.dex */
public class LoginEvent {
    private boolean mCheckFirstAuth;
    private Bundle mExtra;
    private int mFromType;
    private boolean mHasBanned;
    private int mLoginDialogTextId;
    private String mSource;
    private HashMap<String, String> mV3Args;

    public Bundle getExtra() {
        return this.mExtra;
    }

    public int getFromType() {
        return this.mFromType;
    }

    public int getLoginDialogTextId() {
        return this.mLoginDialogTextId;
    }

    public String getSource() {
        return this.mSource;
    }

    public HashMap<String, String> getV3Args() {
        return this.mV3Args;
    }

    public boolean isCheckFirstAuth() {
        return this.mCheckFirstAuth;
    }

    public boolean isHasBanned() {
        return this.mHasBanned;
    }

    public void setCheckFirstAuth(boolean r100) {
        this.mCheckFirstAuth = r100;
    }

    public void setExtra(Bundle r100) {
        this.mExtra = r100;
    }

    public void setFromType(int r100) {
        this.mFromType = r100;
    }

    public void setHasBanned(boolean r100) {
        this.mHasBanned = r100;
    }

    public void setSource(String r100) {
        this.mSource = r100;
    }

    public void setV3Args(HashMap<String, String> r100) {
        this.mV3Args = r100;
    }

    public LoginEvent(boolean r100, boolean r101) {
        this(r100, r101, -1);
    }

    public LoginEvent(boolean r100, boolean r101, int r102) {
        this.mCheckFirstAuth = r100;
        this.mHasBanned = r101;
        this.mLoginDialogTextId = r102;
    }

    public LoginEvent(boolean r100, boolean r101, int r102, int r103) {
        this(r100, r101, r102);
        this.mFromType = r103;
    }

    public LoginEvent(boolean r100, boolean r101, int r102, int r103, String r104) {
        this(r100, r101, r102, r103);
        this.mSource = r104;
    }

    public LoginEvent(boolean r100, boolean r101, int r102, int r103, String r104, HashMap<String, String> r105) {
        this(r100, r101, r102, r103);
        this.mSource = r104;
        this.mV3Args = r105;
    }
}
