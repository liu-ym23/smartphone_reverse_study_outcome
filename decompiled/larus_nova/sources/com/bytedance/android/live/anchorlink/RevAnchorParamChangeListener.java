package com.bytedance.android.live.anchorlink;

import com.bytedance.ies.sdk.widgets.KVData;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import gy.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/anchorlink/RevAnchorParamChangeListener;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "liveanchorlink-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RevAnchorParamChangeListener implements Observer<KVData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f58563a;

    public RevAnchorParamChangeListener(f r100) {
        this.f58563a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        KVData r101 = (KVData) r100;
        if (r101 == null) goto L5;
        String r102 = r101.getKey();
    L7:
        if (Intrinsics.areEqual(r102, "data_interact_anchor_param_change") == false) goto L15;
        if (r101 == null) goto L16;
        String r103 = (String) r101.getData();
        if (r103 == null) goto L17;
        f r104 = this.f58563a;
        if (r104 == null) goto L18;
        r104.J(r103);
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = null;
        goto L7
    }
}
