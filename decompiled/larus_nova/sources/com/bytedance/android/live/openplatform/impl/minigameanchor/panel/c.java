package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.Button;
import com.bytedance.android.livesdk.utils.r2;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniGameFeaturePanelDialog f85268a;

    public c(MiniGameFeaturePanelDialog r100) {
        this.f85268a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        yq0.e r101 = (yq0.e) r100;
        if (r101.a() == true) goto L5;
    L9:
        Button r102 = (Button) this.f85268a.T90(R.id.lottery_btn);
        if (r102 == null) goto L15;
        r102.setVisibility(8);
        return;
    L15:
        return;
    L5:
        if (r2.a(r101.d()) == false) goto L9;
        Button r103 = (Button) this.f85268a.T90(R.id.lottery_btn);
        if (r103 == null) goto L13;
        r103.setVisibility(0);
        return;
    }
}
