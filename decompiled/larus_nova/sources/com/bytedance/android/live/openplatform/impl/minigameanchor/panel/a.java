package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.Button;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniGameFeaturePanelDialog f85266a;

    public a(MiniGameFeaturePanelDialog r100) {
        this.f85266a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L7;
        Button r101 = (Button) this.f85266a.T90(R.id.speak_card_btn);
        if (r101 == null) goto L11;
        r101.setVisibility(0);
        return;
    L11:
        return;
    L7:
        Button r102 = (Button) this.f85266a.T90(R.id.speak_card_btn);
        if (r102 == null) goto L13;
        r102.setVisibility(8);
        return;
    }
}
