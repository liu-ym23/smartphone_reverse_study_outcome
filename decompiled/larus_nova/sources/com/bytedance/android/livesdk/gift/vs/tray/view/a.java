package com.bytedance.android.livesdk.gift.vs.tray.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.revenue.common.RevBitmapTranslateUtils;
import com.larus.nova.R;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ VSGiftTrayAnimationView f132567a;

    public a(VSGiftTrayAnimationView r100) {
        this.f132567a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        int r102 = (int) s1.e(40.0f);
        if (r101 != null) goto L5;
        Bitmap r103 = VSGiftTrayAnimationView.c(BitmapFactory.decodeResource(this.f132567a.getResources(), R.drawable.ttlive_ic_default_gift), r102, r102);
    L9:
        if (r103 != null) goto L11;
        return;
    L11:
        if (r103.isRecycled() == true) goto L16;
        VSGiftTrayAnimationView.b(this.f132567a).a(r103);
        return;
    L16:
        return;
    L5:
        Bitmap r104 = RevBitmapTranslateUtils.a(r101);
        if (r104 == null) goto L8;
        this.f132567a.getClass();
        r103 = VSGiftTrayAnimationView.c(r104, r102, r102);
        goto L9
    L8:
        r103 = null;
        goto L9
    }
}
