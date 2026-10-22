package com.bytedance.android.live.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0014\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0017\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000e¨\u0006 "}, d2 = {"Lcom/bytedance/android/live/core/view/LightView;", "Landroid/view/View;", "", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Z", "getNeedDraw", "()Z", "setNeedDraw", "(Z)V", "needDraw", "Landroid/graphics/Paint;", "b", "Lkotlin/Lazy;", "getShadowBorderPaint", "()Landroid/graphics/Paint;", "shadowBorderPaint", "", "d", "getShadowContentLineHeight", "()F", "shadowContentLineHeight", "e", "getShadowContentPaint", "shadowContentPaint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LightView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f66528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f66529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f66530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f66531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f66532e;

    public LightView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LightView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getShadowBorderPaint() {
        return (Paint) this.f66529b.getValue();
    }

    private final float getShadowContentLineHeight() {
        return ((Number) this.f66531d.getValue()).floatValue();
    }

    private final Paint getShadowContentPaint() {
        return (Paint) this.f66532e.getValue();
    }

    @Override // android.view.View
    public final void dispatchDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
    }

    public final boolean getNeedDraw() {
        return this.f66528a;
    }

    @Override // android.view.View
    public final void draw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        if (this.f66528a == false) goto L19;
        int r100 = this.f66530c;
        int r101 = 0;
    L5:
        if (r101 >= r100) goto L13;
        if ((r101 % 2) != 0) goto L9;
        getShadowContentPaint().setColor(0);
    L10:
        if (r110 == null) goto L12;
        r110.drawRect(0.0f, r101 * getShadowContentLineHeight(), getWidth(), (r101 + 1) * getShadowContentLineHeight(), getShadowContentPaint());
    L12:
        r101 = r101 + 1;
        goto L5
    L9:
        getShadowContentPaint().setColor(ColorProtector.parseColor("#80F5D9DA"));
        goto L10
    L13:
        if (r110 == null) goto L20;
        r110.drawRect(0.0f, 0.0f, getWidth(), getHeight(), getShadowBorderPaint());
        return;
    L20:
        return;
    }

    public final void setNeedDraw(boolean r100) {
        this.f66528a = r100;
    }

    public LightView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f66529b = LazyKt.lazy(LightView$shadowBorderPaint$2.INSTANCE);
        this.f66530c = 10;
        this.f66531d = LazyKt.lazy(new LightView$shadowContentLineHeight$2(this));
        this.f66532e = LazyKt.lazy(LightView$shadowContentPaint$2.INSTANCE);
    }

    public /* synthetic */ LightView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
