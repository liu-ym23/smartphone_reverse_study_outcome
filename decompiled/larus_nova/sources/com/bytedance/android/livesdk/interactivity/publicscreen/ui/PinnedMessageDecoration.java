package com.bytedance.android.livesdk.interactivity.publicscreen.ui;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class PinnedMessageDecoration extends RecyclerView.ItemDecoration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.android.livesdk.interactivity.publicscreen.pin.c f140180a;

    public PinnedMessageDecoration() {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void onDrawOver(Canvas r100, RecyclerView r101, RecyclerView.State r102) {
        super.onDrawOver(r100, r101, r102);
        if (this.f140180a == null) goto L12;
        View r103 = r101.getChildAt(0);
        if (r103 != null) goto L7;
        return;
    L7:
        int r104 = u42.g.f548686a;
        Intrinsics.checkNotNullParameter(r103, "view");
        Object r105 = r103.getTag(R.id.ttlive_public_screen_pin_handler);
        if ((r105 instanceof u42.b) == true) goto L10;
        r105 = null;
    L10:
        com.bytedance.android.livesdk.interactivity.publicscreen.pin.c r106 = this.f140180a;
        r106.a((u42.b) r105);
        return;
    }
}
