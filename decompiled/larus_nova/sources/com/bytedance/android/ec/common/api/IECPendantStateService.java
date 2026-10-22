package com.bytedance.android.ec.common.api;

import cf.f;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/ec/common/api/IECPendantStateService;", "", "", "key", "Lcf/f;", "listener", "", "addPendantStateListener", "getPendantStateListener", "removePendantStateListener", "ec-common-api_release"}, k = 1, mv = {1, 4, 3})
public interface IECPendantStateService {
    void addPendantStateListener(String r100, f r101);

    f getPendantStateListener(String r100);

    f removePendantStateListener(String r100);
}
