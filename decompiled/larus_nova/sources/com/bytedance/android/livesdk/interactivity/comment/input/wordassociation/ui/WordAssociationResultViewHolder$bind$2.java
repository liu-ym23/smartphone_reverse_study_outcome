package com.bytedance.android.livesdk.interactivity.comment.input.wordassociation.ui;

import ak6.g;
import c32.d;
import com.bytedance.android.livesdk.utils.x0;
import kotlin.jvm.internal.Intrinsics;
import qb2.e;

/* JADX INFO: loaded from: classes9.dex */
public final class WordAssociationResultViewHolder$bind$2 implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WordAssociationResultViewHolder f135219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f135220b;

    @Override // qb2.e
    public final void a(g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        Intrinsics.checkNotNullParameter(r100, "rendResult");
    }

    @Override // qb2.e
    public final void b(final g r100) {
        Intrinsics.checkNotNullParameter(r100, "rendResult");
        this.f135219a.f135212a.setText(r100.f4074a);
        this.f135219a.itemView.setOnClickListener(x0.a(new WordAssociationResultViewHolder$bind$2$onSpanRendFinish$1(this, r100)));
    }

    public WordAssociationResultViewHolder$bind$2(WordAssociationResultViewHolder r100, d r101) {
        this.f135219a = r100;
        this.f135220b = r101;
    }
}
