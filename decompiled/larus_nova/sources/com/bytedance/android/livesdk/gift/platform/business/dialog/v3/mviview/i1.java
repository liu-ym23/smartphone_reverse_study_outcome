package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.s1;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class i1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GiftOnlineReceiverMVIView f127943a;

    public i1(GiftOnlineReceiverMVIView r100) {
        this.f127943a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Bitmap r101 = (Bitmap) r100;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.isRecycled() == true) goto L11;
        ViewGroup r102 = this.f127943a.f127672p;
        if (r102 == null) goto L12;
        r102.setBackground(new BitmapDrawable(s1.getResources(), r101));
        return;
    L12:
        return;
    }
}
