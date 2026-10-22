package com.bytedance.android.shopping.api.mall.common.homepage.card.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/common/ECRoundedCornerImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECRoundedCornerImageView extends ImageView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f170291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f170292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f170293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f170294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Path f170295e;

    public ECRoundedCornerImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ECRoundedCornerImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f170295e != null) goto L6;
        super.dispatchDraw(r100);
        return;
    L6:
        r100.save();
        Path r101 = this.f170295e;
        if (r101 == null) goto L9;
        r100.clipPath(r101);
    L9:
        super.dispatchDraw(r100);
        r100.restore();
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        if (this.f170295e != null) goto L6;
        super.draw(r100);
        return;
    L6:
        r100.save();
        Path r101 = this.f170295e;
        if (r101 == null) goto L9;
        r100.clipPath(r101);
    L9:
        super.draw(r100);
        r100.restore();
    }

    public final void a(float r100, float r101) {
        this.f170291a = 0.0f;
        this.f170292b = 0.0f;
        this.f170293c = r100;
        this.f170294d = r101;
        if (r100 != 0.0f) goto L8;
        if (r101 != 0.0f) goto L8;
        this.f170295e = null;
    L16:
        invalidate();
        return;
    L8:
        if (this.f170295e != null) goto L10;
        this.f170295e = new Path();
    L10:
        Path r102 = this.f170295e;
        if (r102 == null) goto L13;
        r102.reset();
    L13:
        RectF r103 = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        float r104 = this.f170291a;
        float r105 = this.f170292b;
        float r106 = this.f170293c;
        float r107 = this.f170294d;
        float[] r108 = {r104, r104, r105, r105, r106, r106, r107, r107};
        Path r109 = this.f170295e;
        if (r109 == null) goto L16;
        r109.addRoundRect(r103, r108, Path.Direction.CW);
        goto L16
    }

    public ECRoundedCornerImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ ECRoundedCornerImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
