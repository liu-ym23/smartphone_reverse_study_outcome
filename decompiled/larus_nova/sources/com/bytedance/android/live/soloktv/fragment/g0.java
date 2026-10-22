package com.bytedance.android.live.soloktv.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class g0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SoloKtvPreviewFragment f101212a;

    public g0(SoloKtvPreviewFragment r100) {
        this.f101212a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        ImageView r102 = this.f101212a.f101173j;
        if (r102 == null) goto L6;
        r102.setImageDrawable(new BitmapDrawable(s1.getResources(), r101));
        return;
    }
}
