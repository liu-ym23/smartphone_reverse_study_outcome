package com.bytedance.android.gamecp.business.instantplay.view;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import com.bytedance.android.gamecp.common.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.gamecp.common.utils.y0;
import com.larus.home.impl.utils.c;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import vv.j;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/gamecp/business/instantplay/view/InstantPlayDebugFloatBall;", "Landroidx/appcompat/widget/AppCompatImageView;", "b", "gamecp-business_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InstantPlayDebugFloatBall extends AppCompatImageView {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static WeakReference<InstantPlayDebugFloatBall> f56129g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f56130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56131b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f56132c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f56133d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f56134e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j> f56135f;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InstantPlayDebugFloatBall f56136a;

        public a(InstantPlayDebugFloatBall r100) {
            this.f56136a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            final InstantPlayDebugFloatBall r101 = this.f56136a;
            WeakReference<InstantPlayDebugFloatBall> r102 = InstantPlayDebugFloatBall.f56129g;
            r101.getClass();
            final com.bytedance.android.gamecp.business.view.a.C0907a r103 = new com.bytedance.android.gamecp.business.view.a.C0907a(r101.getContext());
            Iterator<T> r104 = r101.f56135f.iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            final j r105 = (j) r104.next();
            String r106 = r105.gameName;
            Function2<Dialog, View, Unit> r107 = new InstantPlayDebugFloatBall$onFloatingBallClick$$inlined$forEach$lambda$1(r105, r101, r103);
            Intrinsics.checkNotNullParameter(r106, "itemText");
            Intrinsics.checkNotNullParameter(r107, "listener");
            r103.f56491a.f56496b.add(new com.bytedance.android.gamecp.business.view.a.b(r106, r107));
            goto L4
        L6:
            InstantPlayDebugFloatBall$onFloatingBallClick$2 r108 = InstantPlayDebugFloatBall$onFloatingBallClick$2.INSTANCE;
            Intrinsics.checkNotNullParameter(r108, "listener");
            com.bytedance.android.gamecp.business.view.a.c r109 = r103.f56491a;
            r109.f56497c = new com.bytedance.android.gamecp.business.view.a.b(new SpannableString(y0.i(R.string.gamecp_cancel)), r108);
            int r110 = y0.c(R.color.gamecp_game_0D161823);
            com.bytedance.android.gamecp.business.view.a.c r111 = r103.f56491a;
            r111.f56498d = r110;
            r111.f56502h = true;
            r103.a();
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean l() {
        if (this.f56134e == false) goto L5;
    L9:
        return false;
    L5:
        if (getX() != 0.0f) goto L7;
    L8:
        return true;
    L7:
        if (getX() != (this.f56131b - getWidth())) goto L9;
        goto L8
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        int r100 = (int) r110.getRawX();
        int r101 = (int) r110.getRawY();
        int r102 = r110.getAction() & 255;
        if (r102 == 0) goto L37;
        float r103 = 0.0f;
        if (r102 == 1) goto L32;
        if (r102 != 2) goto L45;
        if (this.f56130a > 0) goto L11;
    L13:
        boolean r104 = false;
    L14:
        this.f56134e = r104;
        int r105 = r100 - this.f56132c;
        int r106 = r101 - this.f56133d;
        if (((int) Math.sqrt((r105 * r105) + (r106 * r106))) != 0) goto L17;
        this.f56134e = false;
        goto L45
    L17:
        float r107 = getX() + r105;
        float r108 = getY() + r106;
        float r109 = 0;
        if (r107 >= r109) goto L21;
        r107 = 0.0f;
    L24:
        if (getY() < r109) goto L30;
        float r111 = getY() + getHeight();
        int r112 = this.f56130a;
        if (r111 <= r112) goto L29;
        r103 = r112 - getHeight();
        goto L30
    L29:
        r103 = r108;
    L30:
        setX(r107);
        setY(r103);
        this.f56132c = r100;
        this.f56133d = r101;
        goto L45
    L21:
        if (r107 <= (this.f56131b - getWidth())) goto L24;
        r107 = this.f56131b - getWidth();
        goto L24
    L11:
        if (this.f56131b == 0) goto L13;
        r104 = true;
    L45:
        if (l() == true) goto L47;
        return true;
    L47:
        if (super.onTouchEvent(r110) == true) goto L52;
        return false;
    L52:
        return true;
    L32:
        if (l() == true) goto L45;
        setPressed(false);
        if (r100 < (this.f56131b / 2)) goto L36;
        animate().setInterpolator(new DecelerateInterpolator()).setDuration(500).xBy((this.f56131b - getWidth()) - getX()).start();
        goto L45
    L36:
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this, "x", new float[]{getX(), 0.0f});
        r113.setInterpolator(new DecelerateInterpolator());
        r113.setDuration(500);
        r113.start();
        goto L45
    L37:
        setPressed(true);
        this.f56134e = false;
        getParent().requestDisallowInterceptTouchEvent(true);
        this.f56132c = r100;
        this.f56133d = r101;
        if (getParent() == null) goto L45;
        ViewParent r114 = getParent();
        if (r114 == null) goto L43;
        ViewGroup r115 = (ViewGroup) r114;
        this.f56130a = r115.getHeight();
        this.f56131b = r115.getWidth();
        goto L45
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public InstantPlayDebugFloatBall(Context r100, List<j> r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "gameList");
        super(r100);
        this.f56135f = r101;
        UtilityKotlinExtentionsKt.h(this);
        setImageDrawable(y0.e(R.drawable.gamecp_team_play_debug_icon));
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(j(r100, 40), j(r100, 40));
        r102.topMargin = j(r100, 200);
        r102.rightMargin = j(r100, 10);
        r102.gravity = GravityCompat.END;
        Window r103 = ((Activity) r100).getWindow();
        View r104 = null;
        if (r103 == null) goto L9;
        View r105 = r103.getDecorView();
        if (c.f346345e == false) goto L11;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == c.f346341a) goto L11;
        c.a(r106, "getDecorView");
    L11:
        if ((r105 instanceof ViewGroup) == false) goto L14;
        r104 = r105;
    L14:
        ViewGroup r107 = (ViewGroup) r104;
        if (r107 == null) goto L17;
        r107.addView(this, r102);
    L17:
        setOnClickListener(new a(this));
        return;
    L9:
        r105 = null;
        goto L11
    }

    public final int j(Context r100, int r101) {
        Resources r102 = r100.getResources();
        return (int) ((r101 * WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics()).density) + 0.5f);
    }
}
