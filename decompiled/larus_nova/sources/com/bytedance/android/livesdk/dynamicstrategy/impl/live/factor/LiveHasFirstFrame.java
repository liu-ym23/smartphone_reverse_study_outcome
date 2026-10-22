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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveHasFirstFrame;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveHasFirstFrame extends DynamicFactor<Integer> implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f123096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DataCenter f123097c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_has_first_frame";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        int r100 = !((Boolean) this.f123097c.get("interaction_on_first_frame", Boolean.TRUE)).booleanValue() ? 1 : 0;
        this.f123096b = r100;
        return Integer.valueOf(r100);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.f123097c.observe("interaction_on_first_frame", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.f123097c.removeObserver("interaction_on_first_frame", this);
    }

    public LiveHasFirstFrame(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123097c = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101.getKey()) == true) goto L25;
        String r102 = r101.getKey();
        if (r102.hashCode() == 1922181771) goto L11;
        return;
    L11:
        if (r102.equals("interaction_on_first_frame") == false) goto L23;
        Integer r103 = Integer.valueOf(Intrinsics.areEqual((Boolean) r101.getData(), Boolean.TRUE) ? 1 : 0);
        if (r103.intValue() == this.f123096b) goto L15;
        boolean r104 = true;
    L16:
        if (r104 == true) goto L19;
        r103 = null;
    L19:
        if (r103 == null) goto L24;
        int r105 = r103.intValue();
        this.f123096b = r105;
        update(Integer.valueOf(r105));
        return;
    L24:
        return;
    L15:
        r104 = false;
        goto L16
    L23:
        return;
    }
}
