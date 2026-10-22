package com.bytedance.android.livesdkapi.wallet;

/* JADX INFO: loaded from: classes12.dex */
public class AuthResultEvent {
    public static final String ALIPAY = "alipay";
    public static final String BANK = "credit_card";
    public static final String BANKCARD = "bankcard";
    public static final String WEIXIN = "weixin";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Exception f162659e;
    private String platform;
    private boolean result;
    private boolean shouldShowToast;

    public Exception getException() {
        return this.f162659e;
    }

    public String getPlatform() {
        return this.platform;
    }

    public boolean getResult() {
        return this.result;
    }

    public boolean isShouldShowToast() {
        return this.shouldShowToast;
    }

    public AuthResultEvent(boolean r100, String r101, boolean r102) {
        this.result = r100;
        this.platform = r101;
        this.shouldShowToast = r102;
    }

    public AuthResultEvent(boolean r100, String r101, Exception r102) {
        this(r100, r101, false);
        this.f162659e = r102;
    }
}
