package com.bytedance.android.livesdk.interactivity.chatchannel.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/chatchannel/widget/ChannelRingView;", "Landroid/view/View;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelRingView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f134508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f134509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f134510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f134511d;

    public ChannelRingView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ChannelRingView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        this.f134509b = (getWidth() / 2) - (this.f134508a / 2);
        r100.drawCircle(getWidth() / 2, getWidth() / 2, this.f134509b, this.f134511d);
    }

    public ChannelRingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f134510c = 1.0f;
        Paint r103 = new Paint(1);
        this.f134511d = r103;
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.ring_color, R.attr.ring_width});
        float r105 = r104.getDimensionPixelSize(1, s1.f(2.0f));
        this.f134508a = r105;
        int r106 = r104.getColor(0, ColorProtector.parseColor("#161823"));
        r103.setStyle(Paint.Style.STROKE);
        r103.setStrokeWidth(r105 * this.f134510c);
        r103.setColor(r106);
        r103.setAntiAlias(true);
    }

    public /* synthetic */ ChannelRingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
