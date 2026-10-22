package com.bytedance.android.livesdk.widget;

import com.bytedance.android.livesdkapi.roomplayer.SwitchResolutionResult;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes11.dex */
public final class d2<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ResolutionServiceWidget f161688a;

    public d2(ResolutionServiceWidget r100) {
        this.f161688a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        SwitchResolutionResult r101 = (SwitchResolutionResult) r100;
        DataCenter r102 = this.f161688a.dataCenter;
        if (r102 == null) goto L7;
        Boolean r103 = (Boolean) r102.get("action_switch_live_resolution", Boolean.FALSE);
        if (r103 == null) goto L7;
        boolean r104 = r103.booleanValue();
    L8:
        if (r104 == true) goto L10;
        return;
    L10:
        if (r101.isSuccess() == true) goto L20;
        DataCenter r105 = this.f161688a.dataCenter;
        if (r105 == null) goto L14;
        r105.put("cmd_switch_resolution_fail", 0);
    L14:
        DataCenter r106 = this.f161688a.dataCenter;
        if (r106 == null) goto L17;
        r106.put("action_switch_live_resolution", Boolean.FALSE);
    L17:
        com.bytedance.android.live.core.utils.f2.c(com.bytedance.android.live.core.utils.s1.B(R.string.ttlive_live_switch_quality_failed_tip), 0);
        return;
    L20:
        return;
    L7:
        r104 = false;
        goto L8
    }
}
