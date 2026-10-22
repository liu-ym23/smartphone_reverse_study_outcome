package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSGiftTrayAnimationView f132568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f132569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ImageView f132570c;

    public b(VSGiftTrayAnimationView r100, ImageView r101) {
        this.f132568a = r100;
        this.f132569b = true;
        this.f132570c = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (this.f132569b == false) goto L8;
        Bitmap r102 = RevBitmapTranslateUtils.b(r101);
    L9:
        if (r102 != null) goto L11;
        return;
    L11:
        if (r102.isRecycled() == true) goto L20;
        ImageView r103 = this.f132570c;
        if (r103 == null) goto L16;
        r103.setImageBitmap(r102);
    L16:
        this.f132568a.invalidate();
        return;
    L20:
        return;
    L8:
        r102 = RevBitmapTranslateUtils.a(r101);
        goto L9
    }
}
