package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.graphics.Bitmap;
import android.view.View;
import com.bytedance.android.ec.core.utils.y;

/* JADX INFO: loaded from: classes13.dex */
public final class b<T> implements y.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f168802a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f168803b;

    public b(View r100, View r101) {
        this.f168802a = r100;
        this.f168803b = r101;
    }

    @Override // com.bytedance.android.ec.core.utils.y.c
    public final void accept(Object r100) {
        this.f168802a.post(new a(this, (Bitmap) r100));
    }
}
