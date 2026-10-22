package com.bytedance.android.livesdk.gift.platform.business.effect.giftview;

import android.graphics.Bitmap;
import android.text.Spannable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes9.dex */
public final class m implements yr2.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f129406a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f129407b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Bitmap[] f129408c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ VideoGiftView f129409d;

    @Override // yr2.a
    public final void a(py.k r100) {
    }

    @Override // yr2.a
    public final void b(Spannable r100, yr2.a.C8374a r101) {
        if (this.f129409d.getContext() != null) goto L5;
        return;
    L5:
        TextView r102 = new TextView(this.f129409d.getContext());
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(this.f129406a, this.f129407b);
        r103.gravity = 17;
        r102.setLayoutParams(r103);
        r102.setMaxLines(1);
        r102.setText(r100);
        r102.setGravity(17);
        r102.setDrawingCacheEnabled(true);
        r102.measure(View.MeasureSpec.makeMeasureSpec(this.f129406a, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f129407b, 1073741824));
        r102.layout(0, 0, r102.getMeasuredWidth(), r102.getMeasuredHeight());
        this.f129408c[0] = Bitmap.createBitmap(r102.getDrawingCache());
        r102.destroyDrawingCache();
    }

    public m(VideoGiftView r100, int r101, int r102, Bitmap[] r103) {
        this.f129409d = r100;
        this.f129406a = r101;
        this.f129407b = r102;
        this.f129408c = r103;
    }
}
