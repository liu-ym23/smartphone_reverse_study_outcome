package com.bytedance.android.livesdk.interactivity.comment.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends NinePatchDrawable implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Rect f136297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f136298b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f136299c;

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void a() {
        this.f136299c = -1;
        invalidateSelf();
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final Drawable getDrawable() {
        return this;
    }

    @Override // android.graphics.drawable.NinePatchDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter r100) {
    }

    @Override // com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void b(int r100) {
        this.f136299c = r100;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.NinePatchDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        this.f136297a.set(getBounds());
        int r101 = this.f136299c;
        if (r101 < 0) goto L5;
        Rect r102 = this.f136297a;
        this.f136298b = r102.right;
        r102.right = r102.left + r101;
        setBounds(r102);
    L5:
        super.draw(r100);
        r100.restore();
        Rect r103 = getBounds();
        r103.right = this.f136298b;
    }

    @Override // android.graphics.drawable.NinePatchDrawable, android.graphics.drawable.Drawable, com.bytedance.android.livesdk.interactivity.comment.view.c
    public final void setAlpha(int r100) {
        getPaint().setAlpha(r100);
        invalidateSelf();
    }

    public b(Bitmap r100, byte[] r101, Rect r110) {
        Intrinsics.checkNotNullParameter(r100, SimplayerImageStrategy.RESULT_BITMAP);
        Intrinsics.checkNotNullParameter(r101, MonitorConstants.CHUNK);
        Intrinsics.checkNotNullParameter(r110, GXTemplateKey.FLEXBOX_PADDING);
        super(s1.getResources(), r100, r101, r110, null);
        this.f136297a = new Rect();
        this.f136299c = -1;
    }
}
