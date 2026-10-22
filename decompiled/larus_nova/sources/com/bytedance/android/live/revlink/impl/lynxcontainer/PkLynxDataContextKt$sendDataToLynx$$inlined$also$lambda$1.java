package com.bytedance.android.live.revlink.impl.lynxcontainer;

import androidx.lifecycle.MediatorLiveData;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;
import kotlin.Pair;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00028\u00000\u0001j\b\u0012\u0004\u0012\u00028\u0000`\u0002¨\u0006\u0003¸\u0006\u0000"}, d2 = {"com/bytedance/android/live/revlink/impl/lynxcontainer/PkLynxDataContextKt$sendDataToLynx$1$1", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1 implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f92667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f92668b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        JSONObject r101 = new JSONObject();
        r101.put("type", this.f92668b);
        if ((r100 instanceof String) == false) goto L7;
        r101.put("data", r100);
    L8:
        this.f92667a.setValue(new Pair(this.f92668b, r101));
        return;
    L7:
        r101.put("data", GsonProtectorUtils.toJson(l97.a.f508113a, r100));
        goto L8
    }

    public PkLynxDataContextKt$sendDataToLynx$$inlined$also$lambda$1(MediatorLiveData r100, String r101) {
        this.f92667a = r100;
        this.f92668b = r101;
    }
}
