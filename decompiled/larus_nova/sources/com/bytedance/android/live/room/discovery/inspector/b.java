package com.bytedance.android.live.room.discovery.inspector;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficialInspectorWidget f99545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f99546b;

    public b(OfficialInspectorWidget r100, l r101) {
        this.f99545a = r100;
        this.f99546b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 == null) goto L23;
        ImageView r102 = this.f99545a.f99532b;
        if (r102 == null) goto L8;
        r102.setImageBitmap(r101);
    L8:
        Disposable r103 = this.f99545a.f99536f;
        if (r103 != null) goto L11;
    L12:
        Disposable r104 = this.f99545a.f99536f;
        if (r104 == null) goto L15;
        r104.dispose();
    L15:
        OfficialInspectorWidget r105 = this.f99545a;
        l r106 = this.f99546b;
        r105.getClass();
        if (r106.f99558a == false) goto L21;
        TextView r107 = r105.f99533c;
        if (r107 == null) goto L22;
        r107.post(new e(r105, r106));
        return;
    L22:
        return;
    L21:
        return;
    L11:
        if (r103.isDisposed() == true) goto L15;
    }
}
