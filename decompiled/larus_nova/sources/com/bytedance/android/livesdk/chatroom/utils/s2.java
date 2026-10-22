package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class s2<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a4 f114618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f114619b;

    public s2(SkinLoader$loopLoadImg$2 r100, View r101) {
        this.f114618a = r100;
        this.f114619b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 != null) goto L5;
    L11:
        a4 r102 = this.f114618a;
        if (r102 == null) goto L16;
        r102.b(SkinLoadResultType.ERROR, "bitmap is null");
        return;
    L16:
        return;
    L5:
        if (r101.isRecycled() == true) goto L11;
        a4 r103 = this.f114618a;
        if (r103 == null) goto L10;
        r103.b(SkinLoadResultType.SUCCESS, "");
    L10:
        this.f114619b.setBackground(new BitmapDrawable(r101));
    }
}
