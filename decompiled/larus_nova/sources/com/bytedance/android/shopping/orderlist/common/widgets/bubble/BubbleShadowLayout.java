package com.bytedance.android.shopping.orderlist.common.widgets.bubble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.ec.core.utils.q;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/common/widgets/bubble/BubbleShadowLayout;", "Landroid/view/View;", "", "color", "", "setShadowColor", "", "radius", "setShadowRadius", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleShadowLayout extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f179993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f179994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f179995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RectF f179996d;

    public BubbleShadowLayout(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BubbleShadowLayout(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a() {
        this.f179995c.setAntiAlias(true);
        this.f179995c.setColor(0);
        this.f179995c.setShadowLayer(this.f179994b, 0.0f, 0.0f, this.f179993a);
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        r100.drawRect(this.f179996d, this.f179995c);
    }

    public final void setShadowColor(int r100) {
        this.f179993a = r100;
        a();
        invalidate();
    }

    public final void setShadowRadius(float r100) {
        this.f179994b = r100;
        a();
        invalidate();
    }

    public BubbleShadowLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f179993a = ColorProtector.parseColor("#1A000000");
        this.f179994b = q.a(12);
        this.f179995c = new Paint();
        this.f179996d = new RectF();
        setLayerType(1, null);
        setWillNotDraw(false);
        a();
    }

    public /* synthetic */ BubbleShadowLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        super.onLayout(r100, r101, r102, r103, r104);
        float r105 = r101;
        float r106 = this.f179994b;
        this.f179996d.set(r105 + r106, r102 + r106, r103 - r106, r104 - r106);
    }
}
