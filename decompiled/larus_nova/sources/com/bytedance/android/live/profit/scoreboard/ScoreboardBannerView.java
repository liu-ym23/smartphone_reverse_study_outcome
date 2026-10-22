package com.bytedance.android.live.profit.scoreboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0003\u0003\u0012\u0013B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0003\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;", "getDragCallback", "()Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;", "setDragCallback", "(Lcom/bytedance/android/live/profit/scoreboard/ScoreboardBannerView$c;)V", "dragCallback", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "c", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ScoreboardBannerView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f88801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f88802b;

    public static final class a {
    }

    public final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f88803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j80.d f88804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public j80.d f88805c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ScoreboardBannerView f88806d;

        public b(ScoreboardBannerView r100) {
            this.f88806d = r100;
            this.f88803a = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
            this.f88804b = new j80.d(0.0f, 0.0f);
            this.f88805c = new j80.d(0.0f, 0.0f);
        }
    }

    public interface c {
        void a();

        void b(j80.d r100);

        void onDragStart();
    }

    static {
    }

    public ScoreboardBannerView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ScoreboardBannerView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    public final c getDragCallback() {
        return this.f88801a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "ev");
        b r101 = this.f88802b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 != 0) goto L5;
        r101.f88805c = j80.b.c(r100);
    L17:
        boolean r103 = false;
    L18:
        if (r103 == false) goto L21;
        return true;
    L21:
        return super.onInterceptTouchEvent(r100);
    L5:
        if (r102 != 2) goto L17;
        if (j80.c.a(j80.b.c(r100), r101.f88805c) < r101.f88803a) goto L17;
        r101.f88804b = j80.b.c(r100);
        r101.f88806d.requestDisallowInterceptTouchEvent(true);
        c r104 = r101.f88806d.getDragCallback();
        if (r104 == null) goto L12;
        r104.onDragStart();
    L12:
        c r105 = r101.f88806d.getDragCallback();
        if (r105 == null) goto L15;
        r105.b(j80.c.b(j80.b.c(r100), r101.f88805c));
    L15:
        r103 = true;
        goto L18
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        b r101 = this.f88802b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "event");
        int r102 = r100.getAction();
        if (r102 == 0) goto L20;
        if (r102 != 1) goto L6;
        c r103 = r101.f88806d.getDragCallback();
        if (r103 == null) goto L19;
        r103.a();
    L19:
        r101.f88806d.performClick();
    L23:
        boolean r104 = true;
    L24:
        if (r104 == false) goto L27;
        return true;
    L27:
        return super.onTouchEvent(r100);
    L6:
        if (r102 != 2) goto L8;
        j80.d r105 = j80.c.b(j80.b.c(r100), r101.f88804b);
        r101.f88804b = j80.b.c(r100);
        c r106 = r101.f88806d.getDragCallback();
        if (r106 == null) goto L23;
        r106.b(r105);
        goto L23
    L8:
        if (r102 == 3) goto L10;
        r104 = false;
        goto L24
    L10:
        c r107 = r101.f88806d.getDragCallback();
        if (r107 == null) goto L23;
        r107.a();
        goto L23
    L20:
        r101.f88804b = j80.b.c(r100);
        r101.f88806d.requestDisallowInterceptTouchEvent(true);
        c r108 = r101.f88806d.getDragCallback();
        if (r108 == null) goto L23;
        r108.onDragStart();
        goto L23
    }

    public final void setDragCallback(c r100) {
        this.f88801a = r100;
    }

    public ScoreboardBannerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f88802b = new b(this);
    }

    public /* synthetic */ ScoreboardBannerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
