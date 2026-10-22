package com.android.ttcjpaysdk.kmp.base.env;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\bH&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\u0003H&J\b\u0010\u000e\u001a\u00020\u0003H&¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/env/IKmpCJEnvService;", "Lcom/bytedance/kmp/spi/IKmpService;", "getHostAid", "", "getDeviceId", "get3DigitSDKVersion", "get4DigitSDKVersion", "isBoeEnv", "", "isLocalTest", "isShowBadgeEnv", "getCustomCookie", "isSaasEnv", "getCurrentSaasScene", "getAccessToken", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJEnvService extends a {
    String get3DigitSDKVersion();

    String get4DigitSDKVersion();

    String getAccessToken();

    String getCurrentSaasScene();

    String getCustomCookie();

    String getDeviceId();

    String getHostAid();

    boolean isBoeEnv();

    boolean isLocalTest();

    boolean isSaasEnv();

    boolean isShowBadgeEnv();
}
