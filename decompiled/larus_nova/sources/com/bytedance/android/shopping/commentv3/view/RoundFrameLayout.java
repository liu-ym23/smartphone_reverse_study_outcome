package com.bytedance.android.shopping.commentv3.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/view/RoundFrameLayout;", "Landroid/widget/FrameLayout;", "Landroid/graphics/Path;", "getPath", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RoundFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Path f172963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f172964b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f172965c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f172966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f172967e;

    public RoundFrameLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public RoundFrameLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Path getPath() {
        Path r100 = this.f172963a;
        if (r100 != null) goto L6;
        r100 = new Path();
    L6:
        if (this.f172963a != null) goto L8;
        this.f172963a = r100;
    L8:
        r100.reset();
        RectF r101 = new RectF(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        float r102 = this.f172964b;
        float r103 = this.f172965c;
        float r104 = this.f172966d;
        float r105 = this.f172967e;
        r100.addRoundRect(r101, new float[]{r102, r102, r103, r103, r104, r104, r105, r105}, Path.Direction.CW);
        return r100;
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        r100.save();
        r100.clipPath(getPath());
        super.draw(r100);
        r100.restore();
    }

    public RoundFrameLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ RoundFrameLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
