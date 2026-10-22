package com.android.ttcjpaysdk.kmp.base.pitaya;

import kotlin.Metadata;
import pd6.a;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/base/pitaya/IKmpCJPitayaService;", "Lcom/bytedance/kmp/spi/IKmpService;", "runPitayaTask", "", "businessName", "", "inputJson", "scene", "callback", "Lcom/android/ttcjpaysdk/kmp/base/pitaya/KmpPitayaTaskCallback;", "cj_base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IKmpCJPitayaService extends a {
    void runPitayaTask(String r100, String r101, String r102, KmpPitayaTaskCallback r103);
}
