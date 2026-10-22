package com.bytedance.android.livesdk.interactivity.comment.input;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import kotlin.Pair;

/* JADX INFO: loaded from: classes9.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OGCFixedCommentAdapter f135166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OGCFixedCommentViewHolder f135167b;

    public g(OGCFixedCommentAdapter r100, OGCFixedCommentViewHolder r101) {
        this.f135166a = r100;
        this.f135167b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (this.f135167b.getAdapterPosition() <= (this.f135166a.getItemCount() - 1)) goto L5;
        return;
    L5:
        if (this.f135167b.getAdapterPosition() < 0) goto L11;
        Pair r101 = (Pair) ListProtector.get(this.f135166a.f135047a, this.f135167b.getAdapterPosition());
        if (((Number) r101.getFirst()).intValue() != 1) goto L12;
        this.f135166a.f135052f.a((String) r101.getSecond());
        OGCFixedCommentAdapter r102 = this.f135166a;
        this.f135167b.getAdapterPosition();
        r102.getClass();
        return;
    L12:
        return;
    }
}
