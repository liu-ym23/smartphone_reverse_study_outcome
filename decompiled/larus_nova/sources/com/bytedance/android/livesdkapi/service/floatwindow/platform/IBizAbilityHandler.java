package com.bytedance.android.livesdkapi.service.floatwindow.platform;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/IBizAbilityHandler;", "", "adjustIconLayout", "", "getBizAbilityCenter", "Lcom/bytedance/android/livesdkapi/service/floatwindow/platform/LiveBizWindowAbilityCenter;", "resumeIconLayout", "setBizAbilityCenter", "abilityCenter", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IBizAbilityHandler {
    void adjustIconLayout();

    LiveBizWindowAbilityCenter getBizAbilityCenter();

    void resumeIconLayout();

    void setBizAbilityCenter(LiveBizWindowAbilityCenter r100);
}
