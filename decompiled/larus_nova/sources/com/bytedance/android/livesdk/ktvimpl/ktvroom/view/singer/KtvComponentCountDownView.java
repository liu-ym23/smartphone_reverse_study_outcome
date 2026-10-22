package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/view/singer/KtvComponentCountDownView;", "Landroid/view/View;", "", DyPayConstant.KEY_START_TIME, "", "setStartTime", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentCountDownView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f145273a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RectF f145274b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Paint f145275c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f145276d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RectF[] f145277e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f145278f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f145279g;

    public KtvComponentCountDownView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KtvComponentCountDownView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final void a(long r100) {
        long r101 = this.f145273a;
        if (r100 <= r101) goto L7;
        this.f145274b.setEmpty();
        UtilityKotlinExtentionsKt.t(this);
        return;
    L7:
        if (r100 >= (r101 - ((long) 3000))) goto L9;
        return;
    L9:
        long r102 = r101 - 3000;
        float r103 = ((r100 - r102) * 1.0f) / (r101 - r102);
        RectF r104 = this.f145274b;
        int r105 = this.f145279g;
        r104.set(0.0f, 0.0f, r105 * r103, r105);
        invalidate();
    }

    @Override // android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        super.onDraw(r100);
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 > 2) goto L6;
        RectF r103 = this.f145277e[r102];
        float r104 = this.f145278f;
        r100.drawRoundRect(r103, r104, r104, this.f145276d);
        r102 = r102 + 1;
        goto L4
    L6:
        r100.save();
        r100.clipRect(this.f145274b);
        this.f145276d.setStrokeWidth(UtilityKotlinExtentionsKt.h(1.0f));
    L7:
        if (r101 > 2) goto L9;
        RectF r105 = this.f145277e[r101];
        float r106 = this.f145278f;
        r100.drawRoundRect(r105, r106, r106, this.f145276d);
        RectF r107 = this.f145277e[r101];
        float r108 = this.f145278f;
        r100.drawRoundRect(r107, r108, r108, this.f145275c);
        r101 = r101 + 1;
        goto L7
    L9:
        this.f145276d.setStrokeWidth(0.0f);
        r100.restore();
    }

    public final void setStartTime(long r100) {
        this.f145273a = r100;
        this.f145274b.setEmpty();
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.f145279g, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f145279g, 1073741824));
    }

    public KtvComponentCountDownView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        this.f145274b = new RectF();
        Paint r102 = new Paint();
        this.f145275c = r102;
        Paint r103 = new Paint();
        this.f145276d = r103;
        this.f145277e = new RectF[]{new RectF(UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(13.0f), UtilityKotlinExtentionsKt.h(16.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(7.0f), UtilityKotlinExtentionsKt.h(7.0f), UtilityKotlinExtentionsKt.h(10.0f), UtilityKotlinExtentionsKt.h(19.0f)), new RectF(UtilityKotlinExtentionsKt.h(1.0f), UtilityKotlinExtentionsKt.h(1.0f), UtilityKotlinExtentionsKt.h(4.0f), UtilityKotlinExtentionsKt.h(19.0f))};
        this.f145278f = s1.e(1.0f);
        this.f145279g = s1.f(21.0f);
        r102.setColor(s1.h(R.color.ttlive_color_lyrics_show));
        r102.setFakeBoldText(true);
        r103.setColor(s1.h(R.color.ttlive_ktv_lyrics_show_color));
        r103.setStyle(Paint.Style.FILL_AND_STROKE);
        r103.setFakeBoldText(true);
        r103.setShadowLayer(2.0f, 0.0f, 1.0f, s1.h(R.color.ttlive_ktv_lyrics_shadow_color));
    }

    public /* synthetic */ KtvComponentCountDownView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
