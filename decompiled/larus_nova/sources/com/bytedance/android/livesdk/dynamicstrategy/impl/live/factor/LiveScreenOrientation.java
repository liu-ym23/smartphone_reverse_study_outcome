package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.text.TextUtils;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveScreenOrientation;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveScreenOrientation extends DynamicFactor<Integer> implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f123132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f123133c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_screen_orientation";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        int r100 = !((Boolean) this.f123133c.get("data_is_portrait", Boolean.TRUE)).booleanValue() ? 1 : 0;
        this.f123132b = r100;
        return Integer.valueOf(r100);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.f123133c.observe("data_is_portrait", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.f123133c.removeObserver("data_is_portrait", this);
    }

    public LiveScreenOrientation(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123133c = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == false) goto L8;
        return;
    L8:
        if (TextUtils.equals(r101.getKey(), "data_is_portrait") == false) goto L14;
        Boolean r102 = Boolean.TRUE;
        int r103 = !Intrinsics.areEqual((Boolean) r101.getData(r102), r102) ? 1 : 0;
        if (r103 == this.f123132b) goto L15;
        this.f123132b = r103;
        update(Integer.valueOf(r103));
        return;
    L15:
        return;
    }
}
