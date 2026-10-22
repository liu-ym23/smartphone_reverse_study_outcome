package com.bytedance.android.live.revlink.impl.multianchor.ui;

import android.view.View;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class t implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TeamPkItemView f94828a;

    public t(TeamPkItemView r100) {
        this.f94828a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        HSImageView r101 = this.f94828a.f94768g;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("imageChangeTeam");
    L6:
        if (r101.isSelected() == true) goto L24;
        TextView r102 = this.f94828a.f94769h;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("tvChangeTeam");
    L11:
        if (r102.isSelected() == true) goto L25;
        TeamPkItemView r103 = this.f94828a;
        a r104 = r103.f94770i;
        if (r104 != null) goto L16;
        return;
    L16:
        HSImageView r105 = r103.f94768g;
        if (r105 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("imageChangeTeam");
    L19:
        r105.setSelected(true);
        TextView r106 = this.f94828a.f94769h;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("tvChangeTeam");
    L22:
        r106.setSelected(true);
        r104.n50();
        return;
    L25:
        return;
    }
}
