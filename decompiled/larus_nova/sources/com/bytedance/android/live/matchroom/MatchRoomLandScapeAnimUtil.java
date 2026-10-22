package com.bytedance.android.live.matchroom;

import am2.x;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.app.Dialog;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.LinearInterpolator;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.s1;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import j40.a1;
import j40.e1;
import j40.i4;
import j40.y0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import zg1.w0;

/* JADX INFO: loaded from: classes46.dex */
public final class MatchRoomLandScapeAnimUtil {
    public static float A;
    public static float B;
    public static float C;
    public static final g D = null;
    public static final MatchRoomLandScapeAnimUtil E = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f82832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LinkedHashMap<String, com.bytedance.android.live.matchroom.a> f82833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f82834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static PublishSubject<Integer> f82835d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static AnimatorSet f82836e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static com.bytedance.android.live.matchroom.a f82837f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final PublishSubject<Object> f82838g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final PublishSubject<Object> f82839h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static Boolean f82840i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Disposable f82841j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f82842k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static WeakReference<com.bytedance.android.live.matchroom.d> f82843l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Lazy f82844m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy f82845n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f82846o = 0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final d f82847p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static WeakReference<View> f82848q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static com.bytedance.android.live.matchroom.e f82849r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Rect f82850s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static long f82851t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static WeakReference<FragmentActivity> f82852u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static float f82853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static float f82854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Lazy f82855x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static boolean f82856y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Map<String, com.bytedance.android.live.matchroom.g> f82857z = null;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f82858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f82859b;

        public a(boolean r100, View r101) {
            this.f82858a = r100;
            this.f82859b = r101;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L21;
            float r102 = ((Float) r101).floatValue();
            if (Float.isNaN(r102) == false) goto L7;
            return;
        L7:
            if (Float.isInfinite(r102) == true) goto L23;
            boolean r103 = MatchRoomLandScapeAnimUtil.f82832a;
            WeakReference<com.bytedance.android.live.matchroom.d> r104 = MatchRoomLandScapeAnimUtil.f82843l;
            if (r104 == null) goto L18;
            com.bytedance.android.live.matchroom.d r105 = r104.get();
            if (r105 == null) goto L18;
            if (this.f82858a == true) goto L16;
            r105 = null;
        L16:
            if (r105 == null) goto L18;
            r105.c(r102, r102);
            return;
        L18:
            this.f82859b.setScaleX(r102);
            this.f82859b.setScaleY(r102);
            Unit r106 = Unit.INSTANCE;
            return;
        L23:
            return;
        L21:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f82860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f82861b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f82862c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            ALogger.i("MatchRoomAnimUtil", "onAnimationCancel isCancel:" + this.f82860a);
            this.f82860a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f82860a == true) goto L20;
            boolean r101 = MatchRoomLandScapeAnimUtil.f82832a;
            if (this.f82861b == false) goto L7;
            int r102 = 2;
        L8:
            MatchRoomLandScapeAnimUtil.u(r102);
            if (this.f82861b == true) goto L17;
            WeakReference<View> r103 = MatchRoomLandScapeAnimUtil.f82848q;
            if (r103 == null) goto L15;
            View r104 = r103.get();
            if (r104 == null) goto L15;
            r104.getGlobalVisibleRect(MatchRoomLandScapeAnimUtil.f82850s);
        L15:
            ALogger.i("MatchRoomAnimUtil", "onAnimationEnd refresh playerContainerShowStateRect:[" + MatchRoomLandScapeAnimUtil.f82850s + ']');
        L17:
            if (MatchRoomLandScapeAnimUtil.f82834c != 0) goto L20;
            this.f82862c.setClipToOutline(false);
            goto L20
        L7:
            r102 = 0;
        L20:
            if (a1.f497165a.getValue().m() == false) goto L23;
            xs2.b.a().post(new zt2.a(!this.f82861b));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            boolean r101 = MatchRoomLandScapeAnimUtil.f82832a;
            if (this.f82861b == false) goto L5;
            int r102 = 1;
        L6:
            MatchRoomLandScapeAnimUtil.u(r102);
            this.f82862c.setOutlineProvider(new o());
            this.f82862c.setClipToOutline(true);
            return;
        L5:
            r102 = 3;
            goto L6
        }

        public b(boolean r100, View r101, String r102) {
            this.f82861b = r100;
            this.f82862c = r101;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f82863a = null;

        static {
            f82863a = new c();
        }

        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            Object r101 = r100.getAnimatedValue();
            if (r101 == null) goto L13;
            float r102 = ((Float) r101).floatValue();
            if (Float.isNaN(r102) == true) goto L14;
            boolean r103 = MatchRoomLandScapeAnimUtil.f82832a;
            WeakReference<com.bytedance.android.live.matchroom.d> r104 = MatchRoomLandScapeAnimUtil.f82843l;
            if (r104 == null) goto L15;
            com.bytedance.android.live.matchroom.d r105 = r104.get();
            if (r105 == null) goto L16;
            r105.a(r102);
            return;
        L16:
            return;
        L15:
            return;
        L14:
            return;
        L13:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class d<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f82864a = null;

        static {
            f82864a = new d();
        }

        public d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r100) {
            if (Intrinsics.areEqual((Boolean) r100, Boolean.TRUE) == false) goto L5;
            MatchRoomLandScapeAnimUtil.f82838g.onNext(new Object());
            return;
        L5:
            MatchRoomLandScapeAnimUtil.f82839h.onNext(new Object());
        }
    }

    public static final class e implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f82865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f82866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f82867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f82868d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f82865a = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            if (this.f82865a == true) goto L6;
            this.f82866b.setClipToOutline(true);
            ALogger.i("MatchRoomAnimUtil", "show end clipToOutline[true] onAnimationEnd for " + ((String) this.f82867c.getKey()));
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f82866b.setClipToOutline(true);
        }

        public e(View r100, Map.Entry r101, List r102) {
            this.f82866b = r100;
            this.f82867c = r101;
            this.f82868d = r102;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f82869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f82870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ View f82871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Dialog f82872d;

        public f(String r100, int r101, View r102, Dialog r103) {
            this.f82869a = r100;
            this.f82870b = r101;
            this.f82871c = r102;
            this.f82872d = r103;
        }

        public final void a() {
            com.bytedance.android.live.matchroom.e r100 = MatchRoomLandScapeAnimUtil.f82849r;
            if (r100 == null) goto L5;
            r100.a(true);
        L5:
            xs2.b.a().post(new zt2.a(false));
            if (MatchRoomLandScapeAnimUtil.f82856y == true) goto L8;
        L10:
            boolean r101 = false;
        L11:
            xs2.b.a().post(new w0(false, r101));
            int r102 = this.f82870b;
            if (r102 > 0) goto L15;
            r102 = this.f82871c.getMeasuredWidth();
        L15:
            float r103 = r102 * 1.0f;
            Animator r104 = MatchRoomLandScapeAnimUtil.h(this.f82871c, true, r103, 0.0f, this.f82869a);
            ObjectAnimator r105 = ObjectAnimator.ofFloat(this.f82871c, "alpha", new float[]{0.0f, 1.0f});
            r105.setDuration(400);
            r105.setInterpolator(new LinearInterpolator());
            com.bytedance.android.live.matchroom.a r106 = new com.bytedance.android.live.matchroom.a();
            String r107 = this.f82869a;
            Intrinsics.checkNotNullParameter(r107, "<set-?>");
            r106.f82874a = r107;
            r106.f82875b = (int) r103;
            this.f82872d.hashCode();
            if (MatchRoomLandScapeAnimUtil.f82833b.get(r106.f82874a) == null) goto L18;
            ALogger.i("MatchRoomAnimUtil", "---- addDialog2Map: map already has key:" + r106.f82874a + ", replace ----");
        L18:
            MatchRoomLandScapeAnimUtil.f82833b.put(r106.f82874a, r106);
            ALogger.i("MatchRoomAnimUtil", "---- addDialog2Map: add [" + r106.f82874a + "] to map, now size:" + MatchRoomLandScapeAnimUtil.f82833b.size() + " ----");
            if (a1.f497165a.getValue().f() == false) goto L34;
            LinkedHashMap<String, com.bytedance.android.live.matchroom.a> r108 = MatchRoomLandScapeAnimUtil.f82833b;
            if (r108 == null) goto L34;
            if (r108.size() <= 0) goto L34;
            Iterator<Map.Entry<String, com.bytedance.android.live.matchroom.a>> r109 = MatchRoomLandScapeAnimUtil.f82833b.entrySet().iterator();
            boolean r110 = true;
        L26:
            if (r109.hasNext() == false) goto L35;
            Map.Entry<String, com.bytedance.android.live.matchroom.a> r111 = r109.next();
            if (r111 == null) goto L26;
            if (r111.getValue() == null) goto L26;
            if (r111.getValue().f82875b <= r106.f82875b) goto L26;
            r110 = false;
        L35:
            if (r110 == false) goto L37;
            ALogger.i("MatchRoomAnimUtil", "showdialog canShowAnim 11111");
            boolean r112 = MatchRoomLandScapeAnimUtil.f82832a;
            MatchRoomLandScapeAnimUtil.m(r106, CollectionsKt.listOf(new Animator[]{r104, r105}));
            return;
        L37:
            ALogger.i("MatchRoomAnimUtil", "showdialog enablePlayerScaleBugfixV2 22222222");
            if (a1.f497165a.getValue().g() == false) goto L51;
            List r113 = CollectionsKt.listOf(new Animator[]{r104, r105});
            boolean r114 = MatchRoomLandScapeAnimUtil.f82832a;
            AnimatorSet r115 = new AnimatorSet();
            MatchRoomLandScapeAnimUtil.f82836e = r115;
            r115.playTogether(r113);
            MatchRoomLandScapeAnimUtil.f82836e.start();
            ALogger.i("MatchRoomAnimUtil", "showdialog enablePlayerScaleBugfixV2 333333");
            return;
        L51:
            return;
        L34:
            r110 = true;
            goto L35
        L8:
            if (y0.f497325a.getValue().booleanValue() == false) goto L10;
            r101 = true;
            goto L11
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements ViewTreeObserver.OnWindowFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f82873a = null;

        static {
            f82873a = new g();
        }

        public g() {
        }

        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public final void onWindowFocusChanged(boolean r100) {
            if (MatchRoomLandScapeAnimUtil.f82832a == true) goto L5;
            return;
        L5:
            ALogger.i("MatchRoomAnimUtil", "window focus change, current:" + r100);
            MatchRoomLandScapeAnimUtil.f82840i = Boolean.valueOf(r100);
            if (r100 == true) goto L8;
            return;
        L8:
            if (MatchRoomLandScapeAnimUtil.f82834c == 0) goto L12;
            MatchRoomLandScapeAnimUtil.b();
            return;
        }
    }

    public MatchRoomLandScapeAnimUtil() {
    }

    public static String A(int r100) {
        if (r100 != 0) goto L4;
        return "ANIM_STATE_HIDE";
    L4:
        if (r100 != 1) goto L6;
        return "ANIM_STATE_RUNNING_SHOW";
    L6:
        if (r100 != 2) goto L8;
        return "ANIM_STATE_SHOW";
    L8:
        if (r100 == 3) goto L10;
        return "UNKNOWN";
    L10:
        return "ANIM_STATE_RUNNING_HIDE";
    }

    static {
        E = new MatchRoomLandScapeAnimUtil();
        f82833b = new LinkedHashMap();
        f82835d = PublishSubject.create();
        f82836e = new AnimatorSet();
        f82838g = PublishSubject.create();
        f82839h = PublishSubject.create();
        f82844m = LazyKt.lazy(MatchRoomLandScapeAnimUtil$landDialogDefaultWidth$2.INSTANCE);
        f82845n = LazyKt.lazy(MatchRoomLandScapeAnimUtil$animStatePaddingRight$2.INSTANCE);
        f82846o = s1.f(34.0f);
        f82847p = d.f82864a;
        f82850s = new Rect();
        f82853v = 1.0f;
        f82854w = 1.0f;
        f82855x = LazyKt.lazy(MatchRoomLandScapeAnimUtil$pictureTypeOpt$2.INSTANCE);
        f82857z = new LinkedHashMap();
        A = 1.0f;
        D = g.f82873a;
    }

    public static final void b() {
        MatchRoomLandScapeAnimUtil r100 = E;
        ALogger.w("MatchRoomAnimUtil", "start focusFallBack Count, currentWindowFocusState = " + f82840i + ", mState = " + A(f82834c) + ", fallBackCount = " + f82842k);
        if (Intrinsics.areEqual(f82840i, Boolean.FALSE) == true) goto L5;
    L10:
        Boolean r101 = f82840i;
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == false) goto L19;
        if (f82834c != 0) goto L19;
        Disposable r103 = f82841j;
        if (r103 == null) goto L17;
        r103.dispose();
    L17:
        f82842k = 0;
        return;
    L19:
        if (Intrinsics.areEqual(f82840i, r102) == true) goto L21;
        return;
    L21:
        if (f82834c == 0) goto L30;
        int r104 = f82842k;
        if (r104 < 3) goto L25;
        ALogger.e("MatchRoomAnimUtil", "startFallBackCount do fallback !!!!");
        l(r100, null, false, null, 15);
        f82833b.clear();
        f82842k = 0;
        n("dialog_hide_fallback", "");
        return;
    L25:
        f82842k = r104 + 1;
        f82841j = Observable.timer(2000, TimeUnit.MILLISECONDS).compose(RxUtil.rxSchedulerHelper()).subscribe(n.f82902a);
        return;
    L30:
        return;
    L5:
        if (f82834c == 0) goto L10;
        Disposable r105 = f82841j;
        if (r105 == null) goto L9;
        r105.dispose();
    L9:
        f82842k = 0;
    }

    public static boolean d() {
        if (a1.f497165a.getValue().f() == false) goto L8;
        int r100 = f82834c;
        if (r100 != 1) goto L10;
        ALogger.i("MatchRoomAnimUtil", "try dismissDialog while current state:".concat(A(r100)));
        return true;
    L10:
        return false;
    L8:
        return false;
    }

    public static void o() {
        if (f82832a == true) goto L5;
        return;
    L5:
        if (f82834c != 2) goto L23;
        WeakReference<View> r100 = f82848q;
        if (r100 == null) goto L19;
        View r101 = r100.get();
        if (r101 == null) goto L20;
        ALogger.i("MatchRoomAnimUtil", "receive onPlayerFirstFrameRefresh");
        Rect r102 = f82850s;
        int r103 = r102.right - r102.left;
        int r104 = r101.getRight() - r101.getLeft();
        if (Math.abs(r103 - r104) <= 10) goto L16;
        int r105 = (r104 - r103) / 2;
        r102.left -= r105;
        r102.right += r105;
        com.bytedance.android.live.matchroom.a r106 = f82837f;
        if (r106 == null) goto L21;
        m(r106, CollectionsKt.emptyList());
        ALogger.i("MatchRoomAnimUtil", "player position change after firstFrame(" + r103 + " -> " + r104 + "), reset and doDialogShowAnim");
        return;
    L21:
        return;
    L16:
        ALogger.i("MatchRoomAnimUtil", "player position not change, skip");
        return;
    L20:
        return;
    L19:
        return;
    }

    public static void r() {
        WeakReference<com.bytedance.android.live.matchroom.d> r100 = f82843l;
        if (r100 == null) goto L12;
        com.bytedance.android.live.matchroom.d r101 = r100.get();
        if (r101 == null) goto L7;
        r101.reset();
    L7:
        WeakReference<View> r102 = f82848q;
        if (r102 == null) goto L17;
        View r103 = r102.get();
        if (r103 == null) goto L17;
        r103.setAlpha(1.0f);
    L17:
        Iterator r104 = ((LinkedHashMap) f82857z).entrySet().iterator();
    L19:
        if (r104.hasNext() == false) goto L26;
        com.bytedance.android.live.matchroom.g r105 = (com.bytedance.android.live.matchroom.g) ((Map.Entry) r104.next()).getValue();
        WeakReference<View> r106 = r105.f82877a;
        if (r106 == null) goto L23;
        View r107 = r106.get();
    L24:
        if (r107 == null) goto L19;
        r107.setScaleX(r105.f82879c);
        r107.setScaleY(r105.f82879c);
        r107.setTranslationX(r105.f82878b);
        goto L19
    L23:
        r107 = null;
        goto L24
    L26:
        return;
    L12:
        WeakReference<View> r108 = f82848q;
        if (r108 == null) goto L17;
        View r109 = r108.get();
        if (r109 == null) goto L17;
        r109.setAlpha(1.0f);
        r109.setTranslationX(0.0f);
        r109.setTranslationY(0.0f);
        r109.setScaleX(1.0f);
        r109.setScaleY(1.0f);
        goto L17
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void p(long r100) {
        if (f82851t != r100) goto L5;
    L8:
        ALogger.w("MatchRoomAnimUtil", "release");
        if (e1.f497189a.getValue().booleanValue() == true) goto L11;
        t(false);
        r();
    L14:
        u(0);
        f82848q = null;
        ((LinkedHashMap) f82857z).clear();
        f82836e.cancel();
        f82836e = new AnimatorSet();
        f82833b.clear();
        f82849r = null;
        com.bytedance.android.livesdk.f.d().f123392a.removeObserver(f82847p);
        if (i4.f497241a.getValue().booleanValue() == false) goto L31;
        WeakReference<FragmentActivity> r101 = f82852u;
        if (r101 == null) goto L27;
        FragmentActivity r102 = r101.get();
        if (r102 == null) goto L27;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L27;
        View r104 = a(r103);
        if (r104 == null) goto L27;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L27;
        r105.removeOnWindowFocusChangeListener(D);
    L27:
        Disposable r106 = f82841j;
        if (r106 == null) goto L32;
        r106.dispose();
        return;
    L32:
        return;
    L31:
        return;
    L11:
        if (f82832a == false) goto L14;
        t(false);
        goto L14
    L5:
        if (r100 == 0) goto L8;
        ALogger.i("MatchRoomAnimUtil", "releaseRoomId :  nowRoomid = " + f82851t + " ___ needreleaseRoomid = " + r100);
    }

    public static void q(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f82833b.get(r100) != null) goto L6;
        ALogger.i("MatchRoomAnimUtil", "---- removeDialogFromMap: " + r100 + " has already remove, skip ---- ");
        return;
    L6:
        f82833b.remove(r100);
        ALogger.i("MatchRoomAnimUtil", "---- removeDialogFromMap: remove [" + r100 + "], now size:" + f82833b.size() + " ---- ");
    }

    public static void s(FragmentActivity r100) {
        f82852u = new WeakReference(r100);
        if (i4.f497241a.getValue().booleanValue() == false) goto L16;
        WeakReference<FragmentActivity> r101 = f82852u;
        if (r101 == null) goto L17;
        FragmentActivity r102 = r101.get();
        if (r102 == null) goto L18;
        Window r103 = r102.getWindow();
        if (r103 == null) goto L19;
        View r104 = a(r103);
        if (r104 == null) goto L20;
        ViewTreeObserver r105 = r104.getViewTreeObserver();
        if (r105 == null) goto L21;
        r105.addOnWindowFocusChangeListener(D);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }

    public static void t(boolean r100) {
        if (f82832a == r100) goto L6;
        if (r100 == false) goto L6;
        f82835d = PublishSubject.create();
    L6:
        f82832a = r100;
        if (r100 == false) goto L9;
        f82833b.clear();
        f82833b = new LinkedHashMap();
        f82842k = 0;
    L9:
        if (r100 == true) goto L12;
        r();
        f82842k = 0;
        return;
    }

    public static void u(int r100) {
        ALogger.i("MatchRoomAnimUtil", "mState Change from " + A(f82834c) + " to " + A(r100));
        f82834c = r100;
        if (r100 != 0) goto L5;
        f82833b.clear();
        ALogger.i("MatchRoomAnimUtil", "---- clear dialogMap cuz state Change ----");
    L5:
        f82835d.onNext(Integer.valueOf(f82834c));
    }

    public static void v(View r100) {
        WeakReference<View> r101 = f82848q;
        Integer r102 = null;
        if (r101 != null) goto L5;
    L11:
        f82848q = new WeakReference(r100);
        StringBuilder r103 = new StringBuilder("setPlayerContainer : ");
        if (r100 == null) goto L14;
        r102 = Integer.valueOf(r100.hashCode());
    L14:
        r103.append(r102);
        ALogger.i("MatchRoomAnimUtil", r103.toString());
        return;
    L5:
        if (r101.get() == null) goto L11;
        StringBuilder r104 = new StringBuilder("setPlayerContainer : skip set ");
        if (r100 == null) goto L10;
        r102 = Integer.valueOf(r100.hashCode());
    L10:
        r104.append(r102);
        ALogger.i("MatchRoomAnimUtil", r104.toString());
    }

    public static void w(com.bytedance.android.live.matchroom.e r100) {
        Integer r101 = null;
        if (f82849r != null) goto L8;
        f82849r = r100;
        StringBuilder r102 = new StringBuilder("setScaleCallback : ");
        com.bytedance.android.live.matchroom.e r103 = f82849r;
        if (r103 == null) goto L7;
        r101 = Integer.valueOf(r103.hashCode());
    L7:
        r102.append(r101);
        ALogger.i("MatchRoomAnimUtil", r102.toString());
        return;
    L8:
        StringBuilder r104 = new StringBuilder("setScaleCallback : skip set ");
        com.bytedance.android.live.matchroom.e r105 = f82849r;
        if (r105 == null) goto L11;
        r101 = Integer.valueOf(r105.hashCode());
    L11:
        r104.append(r101);
        ALogger.i("MatchRoomAnimUtil", r104.toString());
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r100, "key");
        k(r100, false, null);
    }

    public static void m(com.bytedance.android.live.matchroom.a r110, List r210) {
        f82837f = r110;
        WeakReference<View> r100 = f82848q;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        ArrayList r102 = new ArrayList();
        r102.addAll(r210);
        int r103 = r110.f82875b;
        if (r103 > 0) goto L10;
        r103 = ((Number) f82844m.getValue()).intValue();
    L10:
        WeakReference<FragmentActivity> r104 = f82852u;
        if (r104 == null) goto L19;
        FragmentActivity r105 = r104.get();
        if (r105 == null) goto L19;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L19;
        View r107 = a(r106);
        if (r107 == null) goto L19;
        int r108 = r107.getWidth();
    L20:
        int r109 = (r108 - r103) - ((Number) f82845n.getValue()).intValue();
        int r111 = f82846o;
        int r112 = r109 - r111;
        if (r101 != null) goto L23;
        n("show_dialog_null", r110.f82874a);
        ALogger.e("MatchRoomAnimUtil", "doDialogShowAnim failed, null playerView");
    L23:
        if (r101 != null) goto L25;
    L73:
        ALogger.i("MatchRoomAnimUtil", "start doDialogShowAnim,size = " + r102.size());
        if (f82834c == 0) goto L76;
        ALogger.i("MatchRoomAnimUtil", "just before showAnim: now state:" + A(f82834c) + ",cancel lastAnimator");
        f82836e.cancel();
    L76:
        AnimatorSet r113 = new AnimatorSet();
        f82836e = r113;
        r113.playTogether(r102);
        f82836e.start();
        n("show_dialog", r110.f82874a);
        return;
    L25:
        if (r101.getScaleX() < 1.0f) goto L28;
        A = r101.getScaleX();
        B = r101.getTranslationX();
        C = r101.getTranslationY();
    L28:
        if (f82834c != 0) goto L30;
        Rect r114 = f82850s;
        r101.getGlobalVisibleRect(r114);
        ALogger.i("MatchRoomAnimUtil", "doDialogShowAnim refresh playerContainerShowStateRect:[" + r114 + ']');
    L30:
        Ref.IntRef r115 = new Ref.IntRef();
        int r116 = r101.getMeasuredWidth();
        r115.element = r116;
        if (r116 != 0) goto L35;
        int r117 = r101.getWidth();
        r115.element = r117;
        if (r117 != 0) goto L35;
        Rect r118 = f82850s;
        r115.element = r118.right - r118.left;
    L35:
        float r119 = r112;
        float r120 = (r119 / 2.0f) + r111;
        Rect r121 = f82850s;
        float r122 = r120 - ((r121.width() / 2) + r121.left);
        float r123 = (r119 * 1.0f) / r115.element;
        ALogger.i("MatchRoomAnimUtil", "doDialogShowAnim, before crateAnimator\nanim params:fullWidth = " + r108 + ", transSize = " + r103 + ", originalWidth = " + r115.element + ", targetWidth = " + r112 + ", playerRect:" + r121 + "\ntranslationXDest = " + r122 + ", targetScale = " + r123);
        float r124 = r101.getTranslationX();
        String r125 = r110.f82874a;
        if (r125 != null) goto L38;
        String r126 = "";
    L39:
        Animator r127 = g(r101, true, r124, r122, true, r126);
        Animator r128 = i(r101, true, r101.getTranslationY(), 0.0f);
        if (((Boolean) f82855x.getValue()).booleanValue() == false) goto L42;
        boolean r129 = true;
        Animator r130 = e(r101, true, r101.getScaleX(), r123, r101.getScaleY(), r123);
        Animator r131 = r128;
        Animator r132 = r130;
    L43:
        r102.add(r127);
        r102.add(r131);
        r102.add(r132);
        Map<String, com.bytedance.android.live.matchroom.g> r133 = f82857z;
        if ((r133.isEmpty() ^ r129) == false) goto L73;
        Iterator r134 = ((LinkedHashMap) r133).entrySet().iterator();
    L47:
        if (r134.hasNext() == false) goto L73;
        Map.Entry r135 = (Map.Entry) r134.next();
        com.bytedance.android.live.matchroom.g r136 = (com.bytedance.android.live.matchroom.g) r135.getValue();
        WeakReference<View> r137 = r136.f82877a;
        if (r137 == null) goto L51;
        View r138 = r137.get();
    L52:
        if (r138 == null) goto L47;
        if (f82834c != 0) goto L57;
        r136.f82878b = r138.getTranslationX();
        r136.f82879c = r138.getScaleX();
    L57:
        if (r136.f82880d == false) goto L59;
        float r139 = ((r112 + 5) * 1.0f) / r115.element;
    L60:
        float r140 = r138.getTranslationX();
        String r141 = r110.f82874a;
        if (r141 != null) goto L63;
        r141 = "";
    L63:
        Animator r142 = h(r138, r129, r140, r122, r141);
        Animator r143 = f(r138, r129, r138.getScaleX(), r139, false);
        if (r136.f82880d == true) goto L68;
        if (r136.f82881e == true) goto L68;
    L72:
        r102.add(r142);
        r102.add(r143);
        ALogger.i("MatchRoomAnimUtil", "add animator for " + ((String) r135.getKey()));
    L68:
        if (r136.f82881e == false) goto L70;
        r138.setOutlineProvider(new o());
    L71:
        ALogger.i("MatchRoomAnimUtil", "add outlineProvider for " + ((String) r135.getKey()));
        r142.addListener(new e(r138, r135, r102));
        goto L72
    L70:
        r138.setOutlineProvider(new com.bytedance.android.live.matchroom.f(f82850s));
        goto L71
    L59:
        r139 = r123;
        goto L60
    L51:
        r138 = null;
        goto L52
    L42:
        r131 = r128;
        r129 = true;
        r132 = f(r101, true, r101.getScaleX(), r123, true);
        goto L43
    L38:
        r126 = r125;
    L19:
        r108 = s1.y();
        goto L20
    L5:
        r101 = null;
        goto L6
    }

    public static void n(String r100, String r101) {
        qm0.b r102 = om0.c.g();
        if (r102 == null) goto L6;
        r102.sendLog("livesdk_match_land_anim_state_change", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", r100), TuplesKt.to("dialogKey", r101)}), new Object[]{new x(), s80.a.f540946a});
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void x(String r100, Dialog r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f82832a == true) goto L6;
        return;
    L6:
        if (f82834c == 0) goto L8;
        ALogger.i("MatchRoomAnimUtil", "showDialog: now state:" + A(f82834c) + ",cancel lastAnimator");
        f82836e.cancel();
    L8:
        if (r101 == 0) goto L23;
        int r103 = -1;
        if ((r101 instanceof com.bytedance.android.live.matchroom.b) == false) goto L12;
        int r104 = ((com.bytedance.android.live.matchroom.b) r101).getActualContentWidth();
    L13:
        if (r104 > 0) goto L21;
        if (r102 != null) goto L17;
    L18:
        if (r102 == null) goto L20;
        r103 = r102.intValue();
    L20:
        r104 = r103;
        goto L21
    L17:
        if (r102.intValue() != (-1)) goto L18;
    L21:
        z(r100, r101, r104);
        return;
    L12:
        r104 = -1;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y(String r100, DialogFragment r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (f82832a == true) goto L6;
        return;
    L6:
        if (f82834c == 0) goto L8;
        ALogger.i("MatchRoomAnimUtil", "show dialogFragment: now state:" + A(f82834c) + ",cancel lastAnimator");
        f82836e.cancel();
    L8:
        if (r101 != 0) goto L10;
        return;
    L10:
        if (r101.getDialog() == null) goto L26;
        int r103 = -1;
        if ((r101 instanceof com.bytedance.android.live.matchroom.b) == false) goto L14;
        int r104 = ((com.bytedance.android.live.matchroom.b) r101).getActualContentWidth();
    L15:
        if (r104 > 0) goto L23;
        if (r102 != null) goto L19;
    L20:
        if (r102 == null) goto L22;
        r103 = r102.intValue();
    L22:
        r104 = r103;
        goto L23
    L19:
        if (r102.intValue() != (-1)) goto L20;
    L23:
        z(r100, r101.getDialog(), r104);
        return;
    L14:
        r104 = -1;
        goto L15
    }

    public static void z(String r100, Dialog r101, int r102) {
        ALogger.i("MatchRoomAnimUtil", "showdialog " + r100);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getWindow() == null) goto L19;
        Window r103 = r101.getWindow();
        if (r103 == null) goto L9;
        View r104 = a(r103);
    L10:
        Window r105 = r101.getWindow();
        if (r105 == null) goto L13;
        r105.setWindowAnimations(R.style.ttlive_match_landscape_end_dialog);
    L13:
        if (r104 == null) goto L15;
        r104.setAlpha(0.0f);
    L15:
        if (r104 == null) goto L20;
        r104.post(new f(r100, r102, r104, r101));
        return;
    L20:
        return;
    L9:
        r104 = null;
        goto L10
    }

    public final void k(String r100, boolean r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 1111 ----  " + r100);
        if (f82832a == true) goto L5;
        return;
    L5:
        q(r100);
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 11111111111111 ---- ");
        if (a1.f497165a.getValue().h() == false) goto L13;
        if (d() == true) goto L10;
    L15:
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 1111222222211111 ---- ");
        int r103 = f82834c;
        if (r103 == 2) goto L18;
        ALogger.i("MatchRoomAnimUtil", "try dismissDialog while current state:".concat(A(r103)));
        if (f82834c == 0) goto L27;
        f82836e.cancel();
        l(this, r100, r101, r102, 1);
        return;
    L27:
        return;
    L18:
        if ((!f82833b.isEmpty()) == false) goto L21;
        ALogger.i("MatchRoomAnimUtil", "try dismissDialog while some dialog still showing, skip");
        return;
    L21:
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 2222 ---- ");
        l(this, r100, r101, r102, 1);
        return;
    L10:
        if (f82833b.size() <= 0) goto L15;
        return;
    L13:
        if (d() == false) goto L15;
    }

    public static Animator i(View r100, boolean r101, float r102, float r103) {
        WeakReference<com.bytedance.android.live.matchroom.d> r104 = f82843l;
        if (r104 == null) goto L5;
        com.bytedance.android.live.matchroom.d r105 = r104.get();
    L7:
        if (r105 == null) goto L13;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r106.setDuration(400);
        if (r101 == false) goto L11;
        TimeInterpolator r107 = new om3.c();
    L12:
        r106.setInterpolator(r107);
        r106.addUpdateListener(j.f82894a);
        ValueAnimator r108 = r106;
    L18:
        return r108;
    L11:
        r107 = new om3.d();
        goto L12
    L13:
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r102, r103});
        r109.setDuration(400);
        if (r101 == false) goto L16;
        TimeInterpolator r110 = new om3.c();
    L17:
        r109.setInterpolator(r110);
        r108 = r109;
        goto L18
    L16:
        r110 = new om3.d();
        goto L17
    L5:
        r105 = null;
        goto L7
    }

    public static Animator f(View r100, boolean r101, float r102, float r103, boolean r104) {
        ValueAnimator r105 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r105.setDuration(400);
        if (r101 == false) goto L5;
        TimeInterpolator r106 = new om3.c();
    L6:
        r105.setInterpolator(r106);
        r105.addUpdateListener(new a(r104, r100));
        return r105;
    L5:
        r106 = new om3.d();
        goto L6
    }

    public static /* synthetic */ Animator h(View r100, boolean r101, float r102, float r103, String r110) {
        return g(r100, r101, r102, r103, false, r110);
    }

    public static void l(MatchRoomLandScapeAnimUtil r210, String r211, boolean r212, Function0 r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        List r100 = CollectionsKt.emptyList();
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r214 & 4) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r214 & 8) == 0) goto L17;
        Function0 r103 = null;
    L18:
        r210.getClass();
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 444 ---- ");
        if (f82856y == true) goto L21;
    L23:
        boolean r104 = false;
    L24:
        xs2.b.a().post(new w0(true, r104));
        WeakReference<View> r105 = f82848q;
        if (r105 == null) goto L27;
        View r106 = r105.get();
    L28:
        ArrayList r110 = new ArrayList();
        r110.addAll(r100);
        if (r106 != null) goto L34;
        if (r101 != null) goto L32;
        String r107 = "";
    L33:
        n("hide_dialog_null", r107);
        ALogger.e("MatchRoomAnimUtil", "doDialogHideAnim failed, null playerView");
        goto L34
    L32:
        r107 = r101;
    L34:
        ALogger.i("MatchRoomAnimUtil", "---- dismissDialog 333 ---- ");
        if (r106 == null) goto L64;
        float r111 = r106.getScaleX();
        float r112 = r106.getTranslationX();
        float r113 = r106.getTranslationY();
        float r114 = B;
        if (r101 != null) goto L39;
        String r115 = "";
    L40:
        Animator r116 = g(r106, false, r112, r114, true, r115);
        Animator r108 = i(r106, false, r113, C);
        if (((Boolean) f82855x.getValue()).booleanValue() == false) goto L43;
        Animator r109 = e(r106, false, r106.getScaleX(), f82853v, r106.getScaleY(), f82854w);
    L44:
        r110.add(r116);
        r110.add(r108);
        r110.add(r109);
        Map<String, com.bytedance.android.live.matchroom.g> r117 = f82857z;
        if ((!r117.isEmpty()) == false) goto L64;
        Iterator r118 = ((LinkedHashMap) r117).entrySet().iterator();
    L48:
        if (r118.hasNext() == false) goto L64;
        Map.Entry r119 = (Map.Entry) r118.next();
        com.bytedance.android.live.matchroom.g r120 = (com.bytedance.android.live.matchroom.g) r119.getValue();
        WeakReference<View> r121 = r120.f82877a;
        if (r121 == null) goto L52;
        View r122 = r121.get();
    L53:
        if (r122 == null) goto L48;
        float r123 = r122.getTranslationX();
        float r124 = r120.f82878b;
        if (r101 != null) goto L57;
        String r125 = "";
    L58:
        Animator r126 = h(r122, false, r123, r124, r125);
        Animator r127 = f(r122, false, r122.getScaleX(), r120.f82879c, false);
        if (r120.f82880d == false) goto L61;
    L62:
        r126.addListener(new k(r122, r119, r110));
    L63:
        r110.add(r126);
        r110.add(r127);
        ALogger.i("MatchRoomAnimUtil", "add animator for " + ((String) r119.getKey()));
        goto L48
    L61:
        if (r120.f82881e == false) goto L63;
    L57:
        r125 = r101;
        goto L58
    L52:
        r122 = null;
        goto L53
    L43:
        r109 = f(r106, false, r111, A, true);
        goto L44
    L39:
        r115 = r101;
    L64:
        ALogger.i("MatchRoomAnimUtil", "start doDialogHideAnim,size = " + r110.size());
        AnimatorSet r128 = new AnimatorSet();
        f82836e = r128;
        r128.playTogether(r110);
        if (r102 == false) goto L67;
        f82836e.addListener(new l(r102, r106));
    L67:
        f82836e.addListener(new m(r103));
        f82836e.start();
        if (r101 != null) goto L70;
        r101 = "";
    L70:
        n("hide_dialog", r101);
        com.bytedance.android.live.matchroom.e r129 = f82849r;
        if (r129 == null) goto L74;
        r129.a(false);
    L74:
        if (a1.f497165a.getValue().m() == true) goto L82;
        xs2.b.a().post(new zt2.a(true));
        return;
    L82:
        return;
    L27:
        r106 = null;
        goto L28
    L21:
        if (y0.f497325a.getValue().booleanValue() == false) goto L23;
        r104 = true;
        goto L24
    L17:
        r103 = r213;
        goto L18
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = null;
        goto L7
    }

    public static void c(String r100, View r110, boolean r111, boolean r112, boolean r113, int r114) {
        if ((r114 & 4) == 0) goto L6;
        r111 = false;
    L6:
        if ((r114 & 8) == 0) goto L8;
        boolean r101 = false;
    L10:
        if ((r114 & 16) == 0) goto L12;
        boolean r102 = false;
    L13:
        Intrinsics.checkNotNullParameter(r100, "key");
        ALogger.i("MatchRoomAnimUtil", "start addOtherContainer for ".concat(r100));
        Map<String, com.bytedance.android.live.matchroom.g> r115 = f82857z;
        com.bytedance.android.live.matchroom.g r116 = new com.bytedance.android.live.matchroom.g();
        WeakReference<View> r117 = new WeakReference(r110);
        r116.f82877a = r117;
        r116.f82880d = r111;
        r116.f82881e = r102;
        if (f82832a == true) goto L16;
    L26:
        Unit r118 = Unit.INSTANCE;
        r115.put(r100, r116);
        return;
    L16:
        if (f82834c != 2) goto L26;
        View r119 = r117.get();
        if (r119 == null) goto L29;
        WeakReference<View> r120 = f82848q;
        if (r120 == null) goto L28;
        View r103 = r120.get();
        if (r103 == null) goto L30;
        r119.post(new h(r116, r119, r103, r110, r102, r101));
        goto L26
    L30:
        return;
    L28:
        return;
    L29:
        return;
    L12:
        r102 = r113;
        goto L13
    L8:
        r101 = r112;
        goto L10
    }

    public static Animator e(View r100, boolean r101, float r102, float r110, float r111, float r112) {
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r103.setDuration(400);
        if (r101 == false) goto L5;
        TimeInterpolator r104 = new om3.c();
    L6:
        r103.setInterpolator(r104);
        r103.addUpdateListener(new i(r102, r110, r111, r112, r100));
        return r103;
    L5:
        r104 = new om3.d();
        goto L6
    }

    public static Animator g(View r100, boolean r101, float r102, float r103, boolean r110, String r111) {
        if (r110 == false) goto L14;
        WeakReference<com.bytedance.android.live.matchroom.d> r104 = f82843l;
        if (r104 == null) goto L7;
        com.bytedance.android.live.matchroom.d r105 = r104.get();
    L8:
        if (r105 == null) goto L14;
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{r102, r103});
        r106.setDuration(400);
        if (r101 == false) goto L12;
        TimeInterpolator r107 = new om3.c();
    L13:
        r106.setInterpolator(r107);
        r106.addUpdateListener(c.f82863a);
        ValueAnimator r108 = r106;
    L19:
        if (r110 == false) goto L21;
        r108.addListener(new b(r101, r100, r111));
    L21:
        return r108;
    L12:
        r107 = new om3.d();
        goto L13
    L7:
        r105 = null;
    L14:
        ObjectAnimator r109 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_X, new float[]{r102, r103});
        r109.setDuration(400);
        if (r101 == false) goto L17;
        TimeInterpolator r112 = new om3.c();
    L18:
        r109.setInterpolator(r112);
        r108 = r109;
        goto L19
    L17:
        r112 = new om3.d();
        goto L18
    }
}
