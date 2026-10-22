package com.bytedance.android.shopping.searchsimilar.view;

import android.graphics.Bitmap;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.android.ec.core.utils.y;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SimilarProductCardView f182550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpannableStringBuilder f182551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f182552c;

    public b(SimilarProductCardView r100, SpannableStringBuilder r101, String r102) {
        this.f182550a = r100;
        this.f182551b = r101;
        this.f182552c = r102;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        TextView r102 = this.f182550a.f182521c;
        if (r102 == null) goto L6;
        r102.post(new a(this, r101));
        return;
    }
}
