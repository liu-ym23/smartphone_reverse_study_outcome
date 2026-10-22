package com.android.ttcjpaysdk.kmp.common.utils;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H'J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/utils/IKmpCJDeviceInfoService;", "Lcom/bytedance/kmp/spi/IKmpService;", "getDeviceInfoMapStr", "", "getFullDeviceInfoMapStr", "getRiskInfoStr", "merchantId", "getSDKInfoStr", "getUA", "getNetStatus", "getBioType", "getJailBreak", "currentDPI", "", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJDeviceInfoService extends pd6.a {
    int currentDPI();

    String getBioType();

    String getDeviceInfoMapStr();

    String getFullDeviceInfoMapStr();

    String getJailBreak();

    String getNetStatus();

    String getRiskInfoStr(String r100);

    String getSDKInfoStr();

    String getUA();
}
