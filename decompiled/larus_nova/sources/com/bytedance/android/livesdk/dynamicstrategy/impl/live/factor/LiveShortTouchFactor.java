package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/dynamicstrategy/impl/live/factor/LiveShortTouchFactor;", "Lcom/bytedance/android/livesdk/dynamicstrategy/api/DynamicFactor;", "", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "dynamicstrategy-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LiveShortTouchFactor extends DynamicFactor<Integer> implements Observer<KVData> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataCenter f123134b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public String c() {
        return "";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public void e() {
    }

    public Integer f() {
        return 0;
    }

    public void g(KVData r100) {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public /* bridge */ /* synthetic */ Integer b() {
        return f();
    }

    public LiveShortTouchFactor(DataCenter r100) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        this.f123134b = r100;
    }

    public /* bridge */ /* synthetic */ void onChanged(Object r100) {
        g((KVData) r100);
    }

    public final void h(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        DataCenter r102 = this.f123134b;
        if (r102 == null) goto L12;
        IRoom r103 = (IRoom) r102.get("data_room");
        if (r103 == null) goto L13;
        List<String> r104 = r103.getStrategyFeatWhitelist();
        if (r104 != null) goto L9;
        return;
    L9:
        if (r104.contains(r100) != true) goto L15;
        update(Integer.valueOf(r101));
        return;
    L15:
        return;
    L13:
        return;
    }
}
