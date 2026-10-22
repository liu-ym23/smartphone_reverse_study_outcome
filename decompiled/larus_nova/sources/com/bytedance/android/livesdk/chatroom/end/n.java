package com.bytedance.android.livesdk.chatroom.end;

import android.view.ViewGroup;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: classes7.dex */
public final class n extends com.bytedance.android.live.core.utils.q0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveCoverStreamPlayView f106090a;

    public n(LiveCoverStreamPlayView r100) {
        this.f106090a = r100;
    }

    @Override // com.bytedance.android.live.core.utils.q0
    public final void h(py.k r100, int r101, int r102) {
        HSImageView r103 = this.f106090a.f105916e;
        if (r103 == null) goto L5;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
    L6:
        float r105 = r102 / r101;
        HSImageView r106 = this.f106090a.f105916e;
        if (r106 == null) goto L9;
        float r107 = r106.getWidth();
    L10:
        if (r104 == null) goto L12;
        r104.height = (int) (r107 * r105);
    L12:
        HSImageView r108 = this.f106090a.f105916e;
        if (r108 == null) goto L16;
        r108.setLayoutParams(r104);
        return;
    L16:
        return;
    L9:
        r107 = 0.0f;
        goto L10
    L5:
        r104 = null;
        goto L6
    }
}
