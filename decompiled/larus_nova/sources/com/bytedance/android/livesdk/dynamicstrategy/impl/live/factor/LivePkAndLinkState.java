package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LivePkAndLinkState;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePkAndLinkState extends DynamicFactor<Integer> implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123100b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_room_pk_status";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return Integer.valueOf(f(this.f123100b));
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.f123100b.observe("data_link_state", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.f123100b.removeObserver(this);
    }

    public LivePkAndLinkState(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123100b = r100;
    }

    public static int f(DataCenter r100) {
        Integer r101 = (Integer) r100.get("data_link_state", 0);
        if (gd0.v.a(r101.intValue(), 4) == false) goto L6;
    L7:
        return 1;
    L6:
        if (gd0.v.a(r101.intValue(), 64) == true) goto L7;
        return 0;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L6:
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.hashCode() == 872172481) goto L12;
        return;
    L12:
        if (r102.equals("data_link_state") == false) goto L15;
        update(Integer.valueOf(f(this.f123100b)));
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
