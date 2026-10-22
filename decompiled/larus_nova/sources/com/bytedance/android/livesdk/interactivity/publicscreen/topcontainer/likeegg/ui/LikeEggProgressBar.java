package com.bytedance.android.livesdk.interactivity.publicscreen.topcontainer.likeegg.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0017B'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002R\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/topcontainer/likeegg/ui/LikeEggProgressBar;", "Landroid/view/View;", "", "progressColor", "", "setProgressColor", "backgroundColor", "setProgressBackgroundColor", "progress", "setProgress", "Landroid/graphics/Paint;", "c", "Lkotlin/Lazy;", "getMBackgroundPaint", "()Landroid/graphics/Paint;", "mBackgroundPaint", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LikeEggProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f139978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f139979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f139980c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f139981d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f139982e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f139983f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Path f139984g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final RectF f139985h;

    public static final class a {
    }

    static {
    }

    public LikeEggProgressBar(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LikeEggProgressBar(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    private final Paint getMBackgroundPaint() {
        return (Paint) this.f139980c.getValue();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        float r101 = 2;
        float r102 = this.f139982e / r101;
        this.f139983f.set(r102, r102, getMeasuredWidth() - r102, getMeasuredHeight() - r102);
        r100.drawRoundRect(this.f139983f, (getMeasuredHeight() / r101) - r102, (getMeasuredHeight() / r101) - r102, this.f139978a);
        float r103 = this.f139982e;
        float r104 = getMeasuredWidth() - this.f139982e;
        float r105 = getMeasuredHeight() - this.f139982e;
        float r106 = getMeasuredHeight() / r101;
        float r107 = this.f139982e;
        float r108 = r106 - r107;
        float r109 = ((this.f139981d / 10000) * (r104 - r103)) + r107;
        float r110 = r109 - (r101 * r108);
        this.f139983f.set(r103, r103, r104, r105);
        r100.drawRoundRect(this.f139983f, r108, r108, getMBackgroundPaint());
        if (this.f139981d <= 0) goto L5;
        float r111 = r103 - 1;
        this.f139985h.set(r110, r111, r109, r105);
        Path r112 = this.f139984g;
        r112.reset();
        r112.moveTo(Math.min(r110, r103), r111);
        r112.lineTo(r109, r111);
        r112.arcTo(this.f139985h, 270.0f, 180.0f);
        r112.lineTo(Math.min(r110, r103), r105);
        r112.close();
        r100.save();
        r100.clipPath(this.f139984g);
        r100.drawRoundRect(this.f139983f, r108, r108, this.f139979b);
        r100.restore();
    L5:
        super.onDraw(r100);
    }

    public final void setProgress(int r100) {
        this.f139981d = r100;
        invalidate();
    }

    public final void setProgressBackgroundColor(int r100) {
        getMBackgroundPaint().setColor(r100);
        invalidate();
    }

    public final void setProgressColor(int r100) {
        this.f139979b.setColor(r100);
        invalidate();
    }

    public LikeEggProgressBar(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setLayerType(1, null);
        Paint r103 = new Paint();
        r103.setColor(ColorProtector.parseColor("#4DFFE5F1"));
        r103.setAntiAlias(true);
        r103.setStyle(Paint.Style.STROKE);
        float r104 = 1;
        r103.setStrokeWidth(UtilityKotlinExtentionsKt.h(r104));
        Unit r105 = Unit.INSTANCE;
        this.f139978a = r103;
        Paint r106 = new Paint();
        r106.setColor(ColorProtector.parseColor("#99FF3055"));
        r106.setAntiAlias(true);
        r106.setStyle(Paint.Style.FILL);
        this.f139979b = r106;
        this.f139980c = LazyKt.lazy(LikeEggProgressBar$mBackgroundPaint$2.INSTANCE);
        this.f139982e = UtilityKotlinExtentionsKt.h(r104);
        this.f139983f = new RectF();
        this.f139984g = new Path();
        this.f139985h = new RectF();
    }

    public /* synthetic */ LikeEggProgressBar(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
