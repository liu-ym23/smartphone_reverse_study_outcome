package com.bytedance.android.livesdk.widget;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bytedance.android.live.core.tetris.layout.ViewPools;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progressbar.IProgressCastService;
import com.bytedance.android.livesdk.chatroom.progressbar.ui.PlayerSeekBar;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class LiveThumbProcessViewHolder {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f161097p = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f161098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f161099b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f161100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f161101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f161102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f161103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f161104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CompositeDisposable f161105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Animator f161106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Animator f161107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f161108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.progressbar.b f161109l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ViewGroup f161110m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final IProgressCastService f161111n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final DataCenter f161112o;

    public static final class a {
    }

    static {
    }

    public final PlayerSeekBar e() {
        return (PlayerSeekBar) this.f161104g.getValue();
    }

    public static final TextView a(LiveThumbProcessViewHolder r100) {
        return (TextView) r100.f161101d.getValue();
    }

    public static final TextView b(LiveThumbProcessViewHolder r100) {
        return (TextView) r100.f161100c.getValue();
    }

    public static final boolean c(LiveThumbProcessViewHolder r100) {
        IProgressCastService r101 = r100.f161111n;
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.isByteMatchCasting(r100.f161112o) != true) goto L7;
        return true;
    }

    public final void d(Disposable r100) {
        this.f161105h.add(r100);
    }

    public final <T extends View> T g(int r100) {
        View r101 = this.f161098a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L6:
        return (T) r101.findViewById(r100);
    }

    public final View f(int r100, Context r101) {
        if ((r101 instanceof AppCompatActivity) == false) goto L6;
        return ViewPools.a((AppCompatActivity) r101).b(r100, null, true);
    L6:
        return LayoutInflater.from(r101).inflate(r100, this.f161110m, false);
    }

    public LiveThumbProcessViewHolder(Context r100, final PlayerProgressServiceContext r101, ViewGroup r102, IProgressCastService r103, int r104, DataCenter r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "mVSProgressContext");
        Intrinsics.checkNotNullParameter(r102, "parent");
        this.f161110m = r102;
        this.f161111n = r103;
        this.f161112o = r105;
        this.f161099b = LazyKt.lazy(new LiveThumbProcessViewHolder$centerView$2(this));
        this.f161100c = LazyKt.lazy(new LiveThumbProcessViewHolder$tvThumbTitle$2(this));
        this.f161101d = LazyKt.lazy(new LiveThumbProcessViewHolder$tvCurTime$2(this));
        this.f161102e = LazyKt.lazy(new LiveThumbProcessViewHolder$tvTotalTime$2(this));
        this.f161103f = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LiveThumbProcessViewHolder$thumbHotLabelView$2(this));
        this.f161104g = LazyKt.lazy(new LiveThumbProcessViewHolder$portraitThumbProgress$2(this));
        this.f161105h = new CompositeDisposable();
        this.f161108k = "null";
        if (r103 == null) goto L5;
        com.bytedance.android.livesdk.chatroom.progressbar.b r106 = r103.getProgressCastStreamShiftService();
    L6:
        this.f161109l = r106;
        if (r104 != 1) goto L9;
        View r107 = f(R.layout.ttlive_live_thumb_process_portrait_view, r100);
    L16:
        this.f161098a = r107;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L19:
        r102.addView(r107, 0);
        PlayerSeekBar r108 = e();
        if (r108 == null) goto L22;
        r108.setThumbShow(false);
        r108.setTouchAble(false);
    L22:
        d(r101.getCurrentDisplayTime().a().subscribe(new j1(r101, this)));
        d(i80.a.a(r101.getTotalTime(), new LiveThumbProcessViewHolder$initView$$inlined$apply$lambda$2(this)));
        d(r101.getTotalTime().a().subscribe(new k1(this)));
        d(i80.a.a(r101.getThumbTitle(), new LiveThumbProcessViewHolder$initView$$inlined$apply$lambda$4(r101, this)));
        if (r106 == null) goto L31;
        com.bytedance.live.datacontext.m<Long> r109 = r106.a();
        if (r109 == null) goto L31;
        Observable<Long> r110 = r109.a();
        if (r110 == null) goto L31;
        Disposable r111 = r110.subscribe(new l1(this));
        if (r111 == null) goto L31;
        d(r111);
    L31:
        if (r106 == null) goto L39;
        com.bytedance.live.datacontext.m<Long> r112 = r106.getTotalTime();
        if (r112 == null) goto L39;
        Observable<Long> r113 = r112.a();
        if (r113 == null) goto L39;
        Disposable r114 = r113.subscribe(new m1(this));
        if (r114 == null) goto L39;
        d(r114);
    L39:
        View r115 = this.f161098a;
        if (r115 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    L42:
        UtilityKotlinExtentionsKt.t(r115);
        return;
    L9:
        if (r104 != 2) goto L11;
        r107 = f(R.layout.ttlive_match_thumb_process_portrait_view, r100);
        goto L16
    L11:
        if (r104 == 3) goto L13;
        r107 = LayoutInflater.from(r100).inflate(R.layout.ttlive_live_thumb_process_portrait_view, r102, false);
        goto L16
    L13:
        r107 = f(R.layout.ttlive_live_thumb_process_portrait_view_common, r100);
        goto L16
    L5:
        r106 = null;
        goto L6
    }
}
