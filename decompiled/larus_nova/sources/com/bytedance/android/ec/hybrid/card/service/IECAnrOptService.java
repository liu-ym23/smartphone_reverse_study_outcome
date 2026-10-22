package com.bytedance.android.ec.hybrid.card.service;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/hybrid/card/service/IECAnrOptService;", "", "getOptBugFixEnable", "", "getOptDegradeForAnrEnable", "getOptPdpLogScanInterval", "", "isDegradeForAnr", "scene", "", "ec-hybrid_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IECAnrOptService {
    boolean getOptBugFixEnable();

    boolean getOptDegradeForAnrEnable();

    int getOptPdpLogScanInterval();

    boolean isDegradeForAnr(String r100);
}
