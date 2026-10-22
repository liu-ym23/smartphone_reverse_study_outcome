package com.bytedance.android.livesdk.chatroom.widget;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class m extends com.bytedance.android.live.core.utils.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f119136a;

    public m(ImageView r100) {
        this.f119136a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        ViewGroup.LayoutParams r103 = this.f119136a.getLayoutParams();
        int r104 = com.bytedance.android.live.core.utils.s1.j(R.dimen.ttlive_common_guide_secondary_icon_width);
        if (r103 == null) goto L5;
        r103.height = r104;
    L5:
        if (r103 == null) goto L7;
        r103.width = (r101 / r102) * r104;
    L7:
        this.f119136a.setLayoutParams(r103);
    }
}
