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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveOrientationChanged;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveOrientationChanged extends DynamicFactor<Integer> implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123099b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        return 0;
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_orientation_changed";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
        this.f123099b.observe("data_screen_change_status", this);
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
        this.f123099b.removeObserver("data_screen_change_status", this);
    }

    public LiveOrientationChanged(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123099b = r100;
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
        if (TextUtils.equals(r101.getKey(), "data_screen_change_status") == false) goto L16;
        int r102 = 0;
        Integer r103 = (Integer) r101.getData(0);
        if (r103 == null) goto L12;
        r102 = r103.intValue();
    L12:
        if (r102 <= 0) goto L17;
        update(1);
        return;
    L17:
        return;
    }
}
