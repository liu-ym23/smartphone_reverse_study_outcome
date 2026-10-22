package com.bytedance.android.livesdk.vscore_impl.component.multicamera.linkedroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdkapi.depend.model.live.episode.VSCameraInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/vscore_impl/component/multicamera/linkedroom/ui/MultiCameraListHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MultiCameraListHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f159698q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f159699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f159700b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f159701c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LottieAnimationView f159702d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f159703e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TextView f159704f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HSImageView f159705g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final View f159706h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextView f159707i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f159708j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final DataCenter f159709k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ITabView.Scene f159710l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f159711m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public VSCameraInfo f159712n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f159713o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final a f159714p;

    public interface a {
        void K(VSCameraInfo r100, int r101);

        DataCenter getDataCenter();

        ITabView.Scene getScene();

        Function0<Unit> i();
    }

    public static final class b {
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159715a;

        public c(MultiCameraListHolder r100) {
            this.f159715a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a(this.f159715a.f159700b, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159716a;

        public d(MultiCameraListHolder r100) {
            this.f159716a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a(this.f159716a.f159703e, true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159717a;

        public e(MultiCameraListHolder r100) {
            this.f159717a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f159717a.f159702d.playAnimation();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159718a;

        public f(MultiCameraListHolder r100) {
            this.f159718a = r100;
        }

        public final void a() {
            UtilityKotlinExtentionsKt.w(this.f159718a.f159701c);
            UtilityKotlinExtentionsKt.w(this.f159718a.f159702d);
            if (r3.l(this.f159718a.itemView.getContext()) == false) goto L11;
            Context r100 = this.f159718a.itemView.getContext();
            VSCameraInfo r101 = this.f159718a.f159712n;
            if (r101 == null) goto L8;
            String r102 = r101.title;
            if (r102 == null) goto L8;
        L9:
            r3.q(r100, "已选中，".concat(r102));
            return;
        L8:
            r102 = "";
            goto L9
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

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159719a;

        public g(MultiCameraListHolder r100) {
            this.f159719a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f159719a.f159706h;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            UtilityKotlinExtentionsKt.w(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public static final class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159720a;

        public h(MultiCameraListHolder r100) {
            this.f159720a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f159720a.itemView;     // Catch: Throwable -> L15
            if (r100 == null) goto L5;
            r100.requestFocus();     // Catch: Throwable -> L15
        L5:
            View r101 = this.f159720a.itemView;     // Catch: Throwable -> L15
            if (r101 == null) goto L8;
            r101.setImportantForAccessibility(1);     // Catch: Throwable -> L15
        L8:
            View r102 = this.f159720a.itemView;     // Catch: Throwable -> L15
            if (r102 == null) goto L11;
            r102.performAccessibilityAction(64, null);     // Catch: Throwable -> L15
        L11:
            View r103 = this.f159720a.itemView;     // Catch: Throwable -> L15
            if (r103 == null) goto L18;
            r103.sendAccessibilityEvent(32768);     // Catch: Throwable -> L15
            return;
        L18:
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159721a;

        public i(MultiCameraListHolder r100) {
            this.f159721a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a(this.f159721a.f159700b, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159722a;

        public j(MultiCameraListHolder r100) {
            this.f159722a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            o.a(this.f159722a.f159703e, false);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159723a;

        public k(MultiCameraListHolder r100) {
            this.f159723a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f159723a.f159702d.cancelAnimation();     // Catch: Throwable -> L4
            UtilityKotlinExtentionsKt.t(this.f159723a.f159701c);     // Catch: Throwable -> L4
            UtilityKotlinExtentionsKt.t(this.f159723a.f159702d);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MultiCameraListHolder f159724a;

        public l(MultiCameraListHolder r100) {
            this.f159724a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f159724a.f159706h;     // Catch: Throwable -> L6
            if (r100 == null) goto L9;
            UtilityKotlinExtentionsKt.t(r100);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    static {
    }

    public final void T3(boolean r100) {
        View r101 = this.itemView;
        VSCameraInfo r102 = this.f159712n;
        if (r102 == null) goto L5;
        String r103 = r102.title;
    L6:
        r3.d(r101, r103, true, true);
        if (r100 == false) goto L28;
        this.f159700b.animate().alpha(1.0f).setDuration(200).withStartAction(new c(this)).start();
        TextView r104 = this.f159703e;
        if (r104 == null) goto L19;
        ViewPropertyAnimator r105 = r104.animate();
        if (r105 == null) goto L19;
        ViewPropertyAnimator r106 = r105.alpha(1.0f);
        if (r106 == null) goto L19;
        ViewPropertyAnimator r107 = r106.setDuration(200);
        if (r107 == null) goto L19;
        ViewPropertyAnimator r108 = r107.withStartAction(new d(this));
        if (r108 == null) goto L19;
        r108.start();
    L19:
        this.f159701c.animate().alpha(1.0f).setDuration(200).withStartAction(new e(this)).withEndAction(new f(this));
        View r109 = this.f159706h;
        if (r109 == null) goto L46;
        ViewPropertyAnimator r110 = r109.animate();
        if (r110 == null) goto L46;
        ViewPropertyAnimator r111 = r110.alpha(1.0f);
        if (r111 == null) goto L46;
        ViewPropertyAnimator r112 = r111.setDuration(200);
        if (r112 == null) goto L46;
        r112.withStartAction(new g(this));
    L46:
        this.f159711m = true;
        return;
    L28:
        this.f159700b.setAlpha(1.0f);
        TextView r113 = this.f159703e;
        if (r113 == null) goto L31;
        r113.setAlpha(1.0f);
    L31:
        ViewGroup r114 = this.f159701c;
        if (r114 == null) goto L34;
        r114.setAlpha(1.0f);
    L34:
        o.a(this.f159700b, true);
        TextView r115 = this.f159703e;
        if (r115 == null) goto L37;
        o.a(r115, true);
    L37:
        this.f159702d.playAnimation();
        UtilityKotlinExtentionsKt.w(this.f159701c);
        UtilityKotlinExtentionsKt.w(this.f159702d);
        View r116 = this.f159706h;
        if (r116 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r116);
    L40:
        View r117 = this.f159706h;
        if (r117 == null) goto L43;
        r117.setAlpha(1.0f);
    L43:
        View r118 = this.itemView;
        if (r118 == null) goto L46;
        r118.postDelayed(new h(this), 300);
        goto L46
    L5:
        r103 = null;
        goto L6
    }

    public final void U3(boolean r100) {
        View r101 = this.itemView;
        VSCameraInfo r102 = this.f159712n;
        if (r102 == null) goto L6;
        String r103 = r102.title;
        if (r103 == null) goto L6;
    L7:
        r3.d(r101, r103, false, true);
        float r104 = 0.75f;
        if (r100 == false) goto L33;
        ViewPropertyAnimator r105 = this.f159700b.animate();
        if (this.f159710l == ITabView.Scene.SCENE_PORTRAIT_HORIZONTAL) goto L13;
        r104 = 0.9f;
    L13:
        r105.alpha(r104).setDuration(200).withStartAction(new i(this)).start();
        TextView r106 = this.f159703e;
        if (r106 == null) goto L24;
        ViewPropertyAnimator r107 = r106.animate();
        if (r107 == null) goto L24;
        ViewPropertyAnimator r108 = r107.alpha(0.5f);
        if (r108 == null) goto L24;
        ViewPropertyAnimator r109 = r108.setDuration(200);
        if (r109 == null) goto L24;
        ViewPropertyAnimator r110 = r109.withStartAction(new j(this));
        if (r110 == null) goto L24;
        r110.start();
    L24:
        this.f159701c.animate().alpha(0.0f).setDuration(200).withEndAction(new k(this));
        View r111 = this.f159706h;
        if (r111 == null) goto L46;
        ViewPropertyAnimator r112 = r111.animate();
        if (r112 == null) goto L46;
        ViewPropertyAnimator r113 = r112.alpha(0.0f);
        if (r113 == null) goto L46;
        ViewPropertyAnimator r114 = r113.setDuration(200);
        if (r114 == null) goto L46;
        r114.withEndAction(new l(this));
    L46:
        this.f159711m = false;
        return;
    L33:
        TextView r115 = this.f159700b;
        if (this.f159710l == ITabView.Scene.SCENE_PORTRAIT_HORIZONTAL) goto L37;
        r104 = 0.9f;
    L37:
        r115.setAlpha(r104);
        TextView r116 = this.f159703e;
        if (r116 == null) goto L40;
        r116.setAlpha(0.5f);
    L40:
        o.a(this.f159700b, false);
        TextView r117 = this.f159703e;
        if (r117 == null) goto L43;
        o.a(r117, false);
    L43:
        this.f159702d.cancelAnimation();
        UtilityKotlinExtentionsKt.t(this.f159701c);
        UtilityKotlinExtentionsKt.t(this.f159702d);
        View r118 = this.f159706h;
        if (r118 == null) goto L46;
        UtilityKotlinExtentionsKt.t(r118);
    L6:
        r103 = "";
        goto L7
    }

    public MultiCameraListHolder(View r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "callback");
        super(r100);
        this.f159714p = r101;
        this.f159699a = (HSImageView) r100.findViewById(R.id.cover);
        this.f159700b = (TextView) r100.findViewById(R.id.title);
        ViewGroup r102 = (ViewGroup) r100.findViewById(R.id.playing_container);
        this.f159701c = r102;
        LottieAnimationView r103 = (LottieAnimationView) r100.findViewById(R.id.living_view);
        Object r104 = pm1.h.f529822d.c(vr1.i.class);
        Intrinsics.checkNotNull(r104);
        ((vr1.i) r104).R(r103);
        Unit r105 = Unit.INSTANCE;
        this.f159702d = r103;
        HSImageView r106 = null;
        if (r.d().isSaas() == true) goto L5;
        TextView r107 = (TextView) r100.findViewById(R.id.price);
    L6:
        this.f159703e = r107;
        if (r.d().isSaas() == true) goto L9;
        TextView r108 = (TextView) r100.findViewById(R.id.paid_tips);
    L10:
        this.f159704f = r108;
        if (r.d().isSaas() == true) goto L13;
        r106 = (HSImageView) r100.findViewById(R.id.vr_icon);
    L13:
        this.f159705g = r106;
        DataCenter r109 = r101.getDataCenter();
        this.f159709k = r109;
        ITabView.Scene r110 = r101.getScene();
        this.f159710l = r110;
        if (r110.enableCameraSelectBg() == false) goto L19;
        if (lu2.b.j(com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r109)) == false) goto L19;
        this.f159706h = r100.findViewById(R.id.select_bg);
    L19:
        if (r110.enablePaidCameraBuyButton() == false) goto L21;
        this.f159707i = (TextView) r100.findViewById(R.id.btn_buy_ticket);
        this.f159708j = r100.findViewById(R.id.area_buy_ticket);
    L21:
        if (r102 != null) goto L23;
        return;
    L23:
        if (r110 != ITabView.Scene.SCENE_PAD_LANDSCAPE) goto L25;
        int r111 = R.drawable.ttlive_bg_matchroom_camera_playing_pad;
    L26:
        r102.setBackgroundResource(r111);
        return;
    L25:
        r111 = R.drawable.ttlive_bg_matchroom_camera_playing;
        goto L26
    L9:
        r108 = null;
        goto L10
    L5:
        r107 = null;
        goto L6
    }
}
