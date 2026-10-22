package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f129997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.k f129998b;

    public n(p r100, py.k r101) {
        this.f129997a = r100;
        this.f129998b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L9;
        this.f129997a.setBackground(new BitmapDrawable(this.f129997a.getResources(), r101));
        return;
    }
}
