package com.bytedance.android.live.wallet;

import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNameAuthCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f102656a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f102657b = null;

    static {
        int[] r100 = new int[TTCJPayRealNameAuthCallback.AuthResult.values().length];
        f102656a = r100;
        r100[TTCJPayRealNameAuthCallback.AuthResult.AUTH_SUCCESS.ordinal()] = 1;
        r100[TTCJPayRealNameAuthCallback.AuthResult.AUTH_ERROR.ordinal()] = 2;
        r100[TTCJPayRealNameAuthCallback.AuthResult.AUTH_CANCEL.ordinal()] = 3;
        r100[TTCJPayRealNameAuthCallback.AuthResult.LOGOUT_ACCOUNT.ordinal()] = 4;
        int[] r101 = new int[TTCJPayRealNamePasswordCallback.PasswordResult.values().length];
        f102657b = r101;
        r101[TTCJPayRealNamePasswordCallback.PasswordResult.SET_PASSWORD_SUCCESS.ordinal()] = 1;
        r101[TTCJPayRealNamePasswordCallback.PasswordResult.SET_PASSWORD_CANCEL.ordinal()] = 2;
    }
}
