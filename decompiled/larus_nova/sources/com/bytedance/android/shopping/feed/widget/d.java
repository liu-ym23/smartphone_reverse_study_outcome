package com.bytedance.android.shopping.feed.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: loaded from: classes13.dex */
public final class d extends LayerDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Drawable f176012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Drawable f176013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f176014c;

    public final void a(float r100) {
        if (r100 < 0) goto L16;
        float r101 = 1;
        if (r100 > r101) goto L19;
        Drawable r102 = this.f176012a;
        if (r102 == null) goto L11;
        r102.setAlpha((int) ((r101 - r100) * 255));
    L11:
        if (this.f176014c == true) goto L17;
        Drawable r103 = this.f176013b;
        if (r103 == null) goto L18;
        r103.setAlpha((int) (r100 * 255));
        return;
    L18:
        return;
    L17:
        return;
    L19:
        return;
    }

    public d(Drawable r100, Drawable r101) {
        super(new Drawable[]{r101, r100});
        this.f176012a = r100;
        this.f176013b = r101;
        this.f176014c = true;
        a(0.0f);
    }
}
