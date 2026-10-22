package com.bytedance.android.live.openplatform.impl.minigameanchor.panel;

import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: classes46.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MiniGameFeaturePanelDialog f85270a;

    public e(MiniGameFeaturePanelDialog r100) {
        this.f85270a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        yq0.d r101 = (yq0.d) r100;
        if (r101 == null) goto L14;
        TextView r102 = (TextView) this.f85270a.T90(R.id.show_count_tv);
        if (r102 == null) goto L7;
        r102.setText(MiniGameFeaturePanelDialog.U90(this.f85270a, r101.c()));
    L7:
        TextView r103 = (TextView) this.f85270a.T90(R.id.click_count_tv);
        if (r103 == null) goto L10;
        r103.setText(MiniGameFeaturePanelDialog.U90(this.f85270a, r101.a()));
    L10:
        TextView r104 = (TextView) this.f85270a.T90(R.id.play_count_tv);
        if (r104 == null) goto L15;
        r104.setText(MiniGameFeaturePanelDialog.U90(this.f85270a, r101.b()));
        return;
    L15:
        return;
    }
}
