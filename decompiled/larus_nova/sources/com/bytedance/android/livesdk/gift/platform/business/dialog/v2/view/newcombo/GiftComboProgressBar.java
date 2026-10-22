package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.col.s.ce;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR)\u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\n8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v2/view/newcombo/GiftComboProgressBar;", "Landroid/view/View;", "", ce.f26395j, "J", "getCountDownTime", "()J", "setCountDownTime", "(J)V", "countDownTime", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "Lkotlin/Pair;", "", "y", "Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "getShowCountDown", "()Lcom/bytedance/ies/sdk/widgets/NextLiveData;", "showCountDown", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftComboProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f126780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f126781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f126782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f126783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f126784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final RectF f126785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f126786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public AnimatorSet f126787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f126788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f126789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Paint f126790k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f126791l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public float f126792m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Point f126793n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public float f126794o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f126795p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f126796q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Animator f126797r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f126798s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Animator f126799t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Paint f126800u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f126801v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f126802w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final NextLiveData<Boolean> f126803x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final NextLiveData<Pair<Boolean, Boolean>> f126804y;

    public static final class a {
    }

    static {
    }

    public final long getCountDownTime() {
        return this.f126789j;
    }

    public final NextLiveData<Pair<Boolean, Boolean>> getShowCountDown() {
        return this.f126804y;
    }

    @Override // android.view.View
    public final void onDraw(Canvas r110) {
        Intrinsics.checkNotNullParameter(r110, "canvas");
        super.onDraw(r110);
        int r100 = r110.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        float r101 = this.f126784e * this.f126786g;
        Point r102 = this.f126793n;
        if (r102 == null) goto L5;
        r110.rotate(this.f126783d, r102.x, r102.y);
    L5:
        RectF r103 = this.f126785f;
        Paint r104 = this.f126790k;
        if (r103 == null) goto L12;
        if (r104 == null) goto L12;
        r104.setStrokeWidth(this.f126792m);
        Paint r105 = this.f126790k;
        if (r105 == null) goto L11;
        r105.setStrokeCap(Paint.Cap.ROUND);
    L11:
        r110.drawArc(r103, 0.0f, this.f126784e, false, r104);
    L12:
        RectF r106 = this.f126785f;
        Paint r107 = this.f126780a;
        if (r106 == null) goto L16;
        if (r107 == null) goto L16;
        r110.drawArc(r106, r101, this.f126784e - r101, false, r107);
    L16:
        RectF r108 = this.f126785f;
        Paint r109 = this.f126800u;
        if (r108 == null) goto L20;
        if (r109 == null) goto L20;
        r109.setAlpha((int) (this.f126798s * 255));
        float r111 = this.f126802w * 155.0f;
        r110.drawArc(r108, r111 + 155.0f, -r111, false, r109);
        r110.drawArc(r108, 155.0f - r111, this.f126802w * 155.0f, false, r109);
    L20:
        int r112 = (int) (this.f126784e / this.f126796q);
        Point r113 = this.f126793n;
        Paint r114 = this.f126790k;
        if (r113 == null) goto L37;
        if (r114 == null) goto L37;
        r114.setStrokeWidth(this.f126795p);
        Paint r115 = this.f126790k;
        if (r115 == null) goto L26;
        r115.setStrokeCap(Paint.Cap.BUTT);
    L26:
        Paint r116 = this.f126790k;
        if (r116 == null) goto L29;
        r116.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
    L29:
        if (r112 < 0) goto L34;
        int r117 = 0;
    L31:
        float r118 = this.f126794o + r113.x;
        float r119 = r113.y;
        r110.drawLine(r118, r119, r118 + this.f126792m, r119, r114);
        r110.rotate(this.f126796q, r113.x, r113.y);
        if (r117 == r112) goto L34;
        r117 = r117 + 1;
    L34:
        Paint r120 = this.f126790k;
        if (r120 == null) goto L37;
        r120.setXfermode(null);
    L37:
        r110.restoreToCount(r100);
    }

    public final void setCountDownTime(long r100) {
        this.f126789j = r100;
    }

    public GiftComboProgressBar(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "attrs");
        super(r100, r101);
        this.f126789j = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        this.f126803x = new NextLiveData();
        final NextLiveData<Pair<Boolean, Boolean>> r102 = new NextLiveData();
        UtilityKotlinExtentionsKt.s(0, false, false, new GiftComboProgressBar$showCountDown$1$1(r102), 7);
        Unit r103 = Unit.INSTANCE;
        this.f126804y = r102;
        this.f126785f = new RectF();
        this.f126793n = new Point();
        this.f126781b = s1.j(R.dimen.ttlive_gift_combo_progress_width);
        this.f126782c = s1.h(R.color.ttlive_big_combo_new_style_bg);
        this.f126792m = s1.j(R.dimen.ttlive_gift_combo_progress_bg_width);
        this.f126791l = s1.h(R.color.ttlive_big_combo_new_style_progress_bg);
        this.f126783d = -65.0f;
        this.f126784e = 310.0f;
        this.f126795p = 4.0f;
        s1.h(R.color.ttlive_big_combo_new_style_progress_bg);
        this.f126796q = 10;
        this.f126801v = s1.h(R.color.ttlive_big_combo_gradient_color);
        Paint r104 = new Paint();
        this.f126780a = r104;
        r104.setColor(this.f126782c);
        Paint r105 = this.f126780a;
        if (r105 == null) goto L5;
        r105.setAntiAlias(true);
    L5:
        Paint r106 = this.f126780a;
        if (r106 == null) goto L8;
        r106.setStyle(Paint.Style.STROKE);
    L8:
        Paint r107 = this.f126780a;
        if (r107 == null) goto L11;
        r107.setStrokeWidth(this.f126781b);
    L11:
        Paint r108 = this.f126780a;
        if (r108 == null) goto L14;
        r108.setStrokeCap(Paint.Cap.ROUND);
    L14:
        Paint r109 = new Paint();
        this.f126790k = r109;
        r109.setAntiAlias(true);
        Paint r110 = this.f126790k;
        if (r110 == null) goto L17;
        r110.setColor(this.f126791l);
    L17:
        Paint r111 = this.f126790k;
        if (r111 == null) goto L20;
        r111.setStyle(Paint.Style.STROKE);
    L20:
        Paint r112 = this.f126790k;
        if (r112 == null) goto L23;
        r112.setStrokeWidth(this.f126792m);
    L23:
        Paint r113 = this.f126790k;
        if (r113 == null) goto L26;
        r113.setStrokeCap(Paint.Cap.ROUND);
    L26:
        Paint r114 = new Paint();
        this.f126800u = r114;
        r114.setColor(this.f126801v);
        Paint r115 = this.f126800u;
        if (r115 == null) goto L29;
        r115.setAntiAlias(true);
    L29:
        Paint r116 = this.f126800u;
        if (r116 == null) goto L32;
        r116.setStyle(Paint.Style.STROKE);
    L32:
        Paint r117 = this.f126800u;
        if (r117 == null) goto L35;
        r117.setStrokeWidth(this.f126781b);
    L35:
        Paint r118 = this.f126800u;
        if (r118 == null) goto L39;
        r118.setStrokeCap(Paint.Cap.ROUND);
        return;
    }

    @Override // android.view.View
    public final void onMeasure(int r100, int r101) {
        super.onMeasure(r100, r101);
        int r102 = com.bytedance.android.live.revenue.common.i.b(150);
        int r103 = View.MeasureSpec.getMode(r100);
        int r104 = View.MeasureSpec.getSize(r100);
        if (r103 == Integer.MIN_VALUE) goto L7;
        if (r103 != 1073741824) goto L8;
        r102 = r104;
    L8:
        int r105 = com.bytedance.android.live.revenue.common.i.b(150);
        int r106 = View.MeasureSpec.getMode(r101);
        int r107 = View.MeasureSpec.getSize(r101);
        if (r106 == Integer.MIN_VALUE) goto L13;
        if (r106 != 1073741824) goto L14;
        r105 = r107;
    L14:
        setMeasuredDimension(r102, r105);
        return;
    L13:
        r105 = RangesKt.coerceAtMost(r105, r107);
        goto L14
    L7:
        r102 = RangesKt.coerceAtMost(r102, r104);
        goto L8
    }

    @Override // android.view.View
    public final void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        float r104 = Math.max(this.f126781b, this.f126792m);
        int r105 = ((int) r104) * 2;
        float r106 = Math.min(((r100 - getPaddingLeft()) - getPaddingRight()) - r105, ((r101 - getPaddingTop()) - getPaddingBottom()) - r105) / 2;
        this.f126794o = r106;
        Point r107 = this.f126793n;
        if (r107 == null) goto L5;
        r107.x = r100 / 2;
    L5:
        if (r107 == null) goto L7;
        r107.y = r101 / 2;
    L7:
        if (r107 == null) goto L18;
        RectF r108 = this.f126785f;
        if (r108 == null) goto L11;
        r108.left = (r107.x - r106) - (r104 / 2);
    L11:
        if (r108 == null) goto L13;
        r108.top = (r107.y - r106) - (r104 / 2);
    L13:
        if (r108 == null) goto L15;
        r108.right = (r107.x + r106) + (r104 / 2);
    L15:
        if (r108 == null) goto L19;
        r108.bottom = (r107.y + r106) + (r104 / 2);
        return;
    L19:
        return;
    }
}
