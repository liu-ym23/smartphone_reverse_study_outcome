package com.bytedance.android.livesdk.interactivity.like.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.bytedance.android.live.core.setting.q4;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.l61;
import com.bytedance.android.livesdk.interactivity.api.like.datacontext.DiggContext;
import com.bytedance.android.livesdk.interactivity.api.like.utils.UserInfoDiggBridge;
import com.bytedance.android.livesdk.message.model.ii;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.android.shopping.anchorv3.activities.vo.ActivityVO;
import com.bytedance.ee.bear.document.customheader.CustomHeaderConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.texturerender.TextureRenderKeys;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import j40.b1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class DiggCountFlipperLayout extends FrameLayout {
    public static final /* synthetic */ int E = 0;
    public final View A;
    public final String B;
    public final View C;
    public final u32.n D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f137812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f137813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public CompositeDisposable f137814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f137815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f137816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashMap<View, Boolean> f137817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TranslateAnimation f137818g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TranslateAnimation f137819h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f137820i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final l61 f137821j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f137822k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public c f137823l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f137824m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final TextView f137825n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final TextView f137826o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final TextView f137827p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f137828q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public b f137829r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final ArrayList<View> f137830s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayList<View> f137831t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList<View> f137832u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList<ArrayList<View>> f137833v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Function1<? super String, Unit> f137834w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final DataCenter f137835x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final View f137836y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final View f137837z;

    public static final class a {
    }

    public interface b {
        void a(int r100);
    }

    public static final class c extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0 f137839b;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            int r100 = n81.a.f518242a;
            n81.a.b("appointment time out, type = " + this.f137838a.B);
            DiggCountFlipperLayout r101 = this.f137838a;
            int r102 = DiggCountFlipperLayout.E;
            r101.f137824m = 3;
            this.f137839b.invoke();
            u32.n r103 = this.f137838a.D;
            if (r103 == null) goto L6;
            r103.b();
            return;
        }

        public c(DiggCountFlipperLayout r100, Function0 r101, long r102, long r103) {
            this.f137838a = r100;
            this.f137839b = r101;
            super(r102, r103);
        }
    }

    public static final class d extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137840a;

        @Override // android.os.CountDownTimer
        public final void onTick(long r100) {
        }

        @Override // android.os.CountDownTimer
        public final void onFinish() {
            String r100 = this.f137840a.B;
            int r101 = DiggCountFlipperLayout.E;
            if (Intrinsics.areEqual(r100, "flip_appointment_cert_digg") == false) goto L11;
            DiggCountFlipperLayout r102 = this.f137840a;
            int r103 = r102.f137824m;
            if (r103 != 2) goto L7;
            n81.a.b("digg time out, showAppointmentOrCert, appointmentCountdownTimerState == TIMER_STATE_RUNNING");
            r102.i(true, true, false);
            return;
        L7:
            if (r103 != 1) goto L9;
            n81.a.b("digg time out, showAppointmentOrCert, appointmentCountdownTimerState == TIMER_STATE_PENDING");
            r102.l();
            r102.i(true, true, false);
            return;
        L9:
            n81.a.b("digg time out, showAppointmentOrCert, show cert");
            r102.k(true, true, false);
            return;
        L11:
            if (Intrinsics.areEqual(this.f137840a.B, "flip_appointment_digg") == false) goto L18;
            DiggCountFlipperLayout r104 = this.f137840a;
            int r105 = r104.f137824m;
            if (r105 != 2) goto L15;
            n81.a.b("digg time out, showAppointmentOrDigg, appointmentCountdownTimerState == TIMER_STATE_RUNNING");
            r104.i(true, true, true);
            return;
        L15:
            if (r105 != 1) goto L17;
            n81.a.b("digg time out, showAppointmentOrDigg, appointmentCountdownTimerState == TIMER_STATE_PENDING");
            r104.l();
            r104.i(true, true, true);
            return;
        L17:
            n81.a.b("digg time out, showAppointmentOrDigg, do nothing");
            return;
        L18:
            this.f137840a.k(true, true, true);
        }

        public d(DiggCountFlipperLayout r100) {
            this.f137840a = r100;
            super(2000, 2000);
        }
    }

    public static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137841a;

        public e(DiggCountFlipperLayout r100) {
            this.f137841a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            this.f137841a.h();
        }
    }

    public static final class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f137842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137843b;

        public f(View r100, DiggCountFlipperLayout r101) {
            this.f137842a = r100;
            this.f137843b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiggCountFlipperLayout.c(this.f137843b, this.f137842a, 1);     // Catch: Throwable -> L4
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
        public final /* synthetic */ DiggCountFlipperLayout f137844a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f137845b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f137846c;

        public g(DiggCountFlipperLayout r100, View r101, int r102) {
            this.f137844a = r100;
            this.f137845b = r101;
            this.f137846c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            DiggCountFlipperLayout.c(this.f137844a, this.f137845b, this.f137846c);     // Catch: Throwable -> L4
            this.f137845b.setTag(R.id.ttlive_tag_user_info_tab_type, null);     // Catch: Throwable -> L4
            this.f137845b.setTag(R.id.ttlive_tag_user_info_tab_label_type, null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements com.bytedance.android.livesdk.interactivity.service.textrender.core.q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137847a;

        public h(DiggCountFlipperLayout r100) {
            this.f137847a = r100;
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
        public final void a(py.k r100) {
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
            Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        }

        @Override // com.bytedance.android.livesdk.interactivity.service.textrender.core.q
        public final void b(SpannableString r100, com.bytedance.android.livesdk.interactivity.service.textrender.core.q.a r101) {
            Intrinsics.checkNotNullParameter(r100, "spannable");
            Intrinsics.checkNotNullParameter(r101, "info");
            Intrinsics.checkNotNullParameter(r100, "spannable");
            Intrinsics.checkNotNullParameter(r101, "info");
            TextView r102 = this.f137847a.f137828q;
            if (r102 == null) goto L5;
            r102.setText(r100);
        L5:
            DiggCountFlipperLayout r103 = this.f137847a;
            u32.n r104 = r103.D;
            if (r104 == null) goto L9;
            r104.c(r103.f137828q, r100);
            return;
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137848a;

        public i(DiggCountFlipperLayout r100) {
            this.f137848a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            n81.a.b("user digg");
            this.f137848a.h();
        }
    }

    public static final class j<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DiggCountFlipperLayout f137849a;

        public j(DiggCountFlipperLayout r100) {
            this.f137849a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Long r101 = (Long) r100;
            n81.a.b("user digg");
            this.f137849a.h();
        }
    }

    static {
    }

    public final void h() {
        int r100 = this.f137816e;
        if (r100 == 0) goto L6;
        if (2 == r100) goto L6;
    L14:
        d r101 = this.f137815d;
        if (r101 == null) goto L18;
        r101.cancel();
        r101.start();
        return;
    L18:
        return;
    L6:
        if (Intrinsics.areEqual(this.B, "flip_appointment_cert_digg") == false) goto L12;
        int r102 = this.f137816e;
        if (r102 != 2) goto L10;
        j(true, false, true);
    L13:
        this.f137816e = 1;
        goto L14
    L10:
        if (r102 != 0) goto L13;
        j(true, true, false);
        goto L13
    L12:
        j(true, true, true);
        goto L13
    }

    public final void l() {
        if (this.f137824m == 1) goto L5;
        return;
    L5:
        n81.a.b("startAppointmentTimerIfPending, start pending timer");
        c r100 = this.f137823l;
        if (r100 == null) goto L8;
        r100.start();
    L8:
        this.f137824m = 2;
        u32.n r101 = this.D;
        if (r101 == null) goto L12;
        r101.g();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f137815d = new d(this);
        this.f137814c = new CompositeDisposable();
        TranslateAnimation r100 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 2, 1.0f, 1, 0.0f);
        r100.setDuration(300);
        r100.setFillAfter(true);
        this.f137818g = r100;
        TranslateAnimation r101 = new TranslateAnimation(0, 0.0f, 0, 0.0f, 1, 0.0f, 2, -1.0f);
        r101.setDuration(300);
        r101.setFillAfter(true);
        this.f137819h = r101;
        Iterator<View> r102 = this.f137830s.iterator();
    L3:
        ViewParent r103 = null;
        if (r102.hasNext() == false) goto L15;
        View r104 = r102.next();
        ViewParent r105 = r104.getParent();
        if ((r105 instanceof ViewGroup) == false) goto L9;
        r103 = r105;
    L9:
        ViewGroup r106 = (ViewGroup) r103;
        if (r106 == null) goto L12;
        r106.removeView(r104);
    L12:
        FrameLayout.LayoutParams r107 = new FrameLayout.LayoutParams(-2, -2);
        r107.gravity = 16;
        Unit r108 = Unit.INSTANCE;
        addView(r104, r107);
        if (Intrinsics.areEqual(this.B, "flip_extra") == false) goto L3;
        r104.setVisibility(8);
        goto L3
    L15:
        Iterator<View> r109 = this.f137832u.iterator();
    L17:
        if (r109.hasNext() == false) goto L25;
        View r110 = r109.next();
        ViewParent r111 = r110.getParent();
        if ((r111 instanceof ViewGroup) == true) goto L21;
        r111 = null;
    L21:
        ViewGroup r112 = (ViewGroup) r111;
        if (r112 == null) goto L24;
        r112.removeView(r110);
    L24:
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
        r113.gravity = 16;
        Unit r114 = Unit.INSTANCE;
        addView(r110, r113);
        goto L17
    L25:
        String r115 = this.B;
        if (Intrinsics.areEqual(r115, PlayerResolution.SDKKEY.ORIGIN) == false) goto L33;
        Iterator<View> r116 = this.f137831t.iterator();
    L29:
        if (r116.hasNext() == false) goto L31;
        r116.next().setVisibility(8);
        goto L29
    L31:
        k(false, true, true);
        return;
    L33:
        if (Intrinsics.areEqual(r115, "new") == false) goto L40;
        Iterator<View> r117 = this.f137830s.iterator();
    L36:
        if (r117.hasNext() == false) goto L38;
        r117.next().setVisibility(8);
        goto L36
    L38:
        j(false, true, true);
        return;
    L40:
        if (Intrinsics.areEqual(r115, "flip") == false) goto L43;
        ((ObservableSubscribeProxy) du2.a.b(0, 5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doFinally(new q(this)).map(new r(this)).as(AutoDispose.bind(this))).subscribe();
        return;
    L43:
        if (Intrinsics.areEqual(r115, "flip_active") == false) goto L55;
        DiggContext.a r118 = DiggContext.Companion;
        DataCenter r119 = this.f137835x;
        r118.getClass();
        DiggContext r120 = DiggContext.a.a(r119);
        if (r120 == null) goto L53;
        com.bytedance.live.datacontext.m<Long> r121 = r120.getDiggTime();
        if (r121 == null) goto L53;
        Observable<Long> r122 = r121.a();
        if (r122 == null) goto L53;
        Disposable r123 = r122.subscribe(new e(this));
        if (r123 == null) goto L53;
        d(r123);
    L53:
        k(false, true, true);
        return;
    L55:
        if (Intrinsics.areEqual(r115, "flip_extra") == false) goto L58;
        ((ObservableSubscribeProxy) du2.a.b(0, 5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).doFinally(new o(this)).map(new p(this, this.f137833v.size())).as(AutoDispose.bind(this))).subscribe();
        return;
    L58:
        if (Intrinsics.areEqual(r115, "flip_appointment_cert_digg") == false) goto L114;
        n81.a.b("flip type is FLIP_APPOINTMENT_CERT_DIGG");
        u32.n r124 = this.D;
        if (r124 == null) goto L62;
        TextView r125 = r124.e();
    L63:
        this.f137828q = r125;
        if (r125 == null) goto L73;
        ViewParent r126 = r125.getParent();
        if ((r126 instanceof ViewGroup) == false) goto L69;
        r103 = r126;
    L69:
        ViewGroup r127 = (ViewGroup) r103;
        if (r127 == null) goto L72;
        r127.removeView(r125);
    L72:
        FrameLayout.LayoutParams r128 = new FrameLayout.LayoutParams(-2, -2);
        r128.gravity = 16;
        Unit r129 = Unit.INSTANCE;
        addView(r125, r128);
        r125.setVisibility(8);
    L73:
        u32.n r130 = this.D;
        if (r130 == null) goto L76;
        boolean r131 = r130.a();
    L77:
        u32.n r132 = this.D;
        if (r132 == null) goto L80;
        long r133 = r132.d();
    L81:
        n81.a.b("configAppointmentCertDiggFlip, flipWhenInit = " + r131 + ", flipTime = " + r133);
        if (r131 == true) goto L84;
    L103:
        n81.a.b("configAppointmentCertDiggFlip, load no appointment");
        DiggContext.a r134 = DiggContext.Companion;
        DataCenter r135 = this.f137835x;
        r134.getClass();
        DiggContext r136 = DiggContext.a.a(r135);
        if (r136 == null) goto L112;
        com.bytedance.live.datacontext.m<Long> r137 = r136.getDiggTime();
        if (r137 == null) goto L112;
        Observable<Long> r138 = r137.a();
        if (r138 == null) goto L112;
        Disposable r139 = r138.subscribe(new m(this));
        if (r139 == null) goto L112;
        d(r139);
    L112:
        k(false, true, true);
        return;
    L84:
        if (r133 <= 0) goto L103;
        Iterator<View> r140 = this.f137830s.iterator();
    L87:
        if (r140.hasNext() == false) goto L89;
        r140.next().setVisibility(8);
        goto L87
    L89:
        Iterator<View> r141 = this.f137831t.iterator();
    L91:
        if (r141.hasNext() == false) goto L93;
        r141.next().setVisibility(8);
        goto L91
    L93:
        f(r133 * ((long) 1000), true, new DiggCountFlipperLayout$configAppointmentCertDiggFlip$4(this));
        DiggContext.a r142 = DiggContext.Companion;
        DataCenter r143 = this.f137835x;
        r142.getClass();
        DiggContext r144 = DiggContext.a.a(r143);
        if (r144 == null) goto L102;
        com.bytedance.live.datacontext.m<Long> r145 = r144.getDiggTime();
        if (r145 == null) goto L102;
        Observable<Long> r146 = r145.a();
        if (r146 == null) goto L102;
        Disposable r147 = r146.subscribe(new l(this));
        if (r147 == null) goto L102;
        d(r147);
    L102:
        i(false, true, true);
        return;
    L80:
        r133 = 0;
        goto L81
    L76:
        r131 = false;
        goto L77
    L62:
        r125 = null;
        goto L63
    L114:
        if (Intrinsics.areEqual(r115, "flip_appointment_digg") == false) goto L187;
        n81.a.b("flip type is FLIP_APPOINTMENT_DIGG");
        u32.n r148 = this.D;
        if (r148 == null) goto L118;
        TextView r149 = r148.e();
    L119:
        this.f137828q = r149;
        if (r149 == null) goto L129;
        ViewParent r150 = r149.getParent();
        if ((r150 instanceof ViewGroup) == false) goto L125;
        r103 = r150;
    L125:
        ViewGroup r151 = (ViewGroup) r103;
        if (r151 == null) goto L128;
        r151.removeView(r149);
    L128:
        FrameLayout.LayoutParams r152 = new FrameLayout.LayoutParams(-2, -2);
        r152.gravity = 16;
        Unit r153 = Unit.INSTANCE;
        addView(r149, r152);
        r149.setVisibility(8);
    L129:
        u32.n r154 = this.D;
        if (r154 == null) goto L132;
        boolean r155 = r154.a();
    L133:
        u32.n r156 = this.D;
        if (r156 == null) goto L136;
        long r157 = r156.d();
    L137:
        n81.a.b("configAppointmentCertDiggFlip, flipWhenInit = " + r155 + ", flipTime = " + r157);
        if (r155 == true) goto L140;
    L159:
        n81.a.b("configAppointmentCertDiggFlip, load no appointment");
        Iterator<View> r158 = this.f137830s.iterator();
    L161:
        if (r158.hasNext() == false) goto L163;
        r158.next().setVisibility(8);
        goto L161
    L163:
        j(false, true, true);
        return;
    L140:
        if (r157 <= 0) goto L159;
        Iterator<View> r159 = this.f137830s.iterator();
    L143:
        if (r159.hasNext() == false) goto L145;
        r159.next().setVisibility(8);
        goto L143
    L145:
        Iterator<View> r160 = this.f137831t.iterator();
    L147:
        if (r160.hasNext() == false) goto L149;
        r160.next().setVisibility(8);
        goto L147
    L149:
        f(r157 * ((long) 1000), true, new DiggCountFlipperLayout$configAppointmentDiggFlip$4(this));
        DiggContext.a r161 = DiggContext.Companion;
        DataCenter r162 = this.f137835x;
        r161.getClass();
        DiggContext r163 = DiggContext.a.a(r162);
        if (r163 == null) goto L158;
        com.bytedance.live.datacontext.m<Long> r164 = r163.getDiggTime();
        if (r164 == null) goto L158;
        Observable<Long> r165 = r164.a();
        if (r165 == null) goto L158;
        Disposable r166 = r165.subscribe(new n(this));
        if (r166 == null) goto L158;
        d(r166);
    L158:
        i(false, true, true);
        return;
    L136:
        r157 = 0;
        goto L137
    L132:
        r155 = false;
        goto L133
    L118:
        r149 = null;
        goto L119
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (b1.f497171a.getValue().a() == false) goto L19;
        Iterator<View> r100 = this.f137830s.iterator();
    L6:
        if (r100.hasNext() == false) goto L19;
        View r101 = r100.next();
        HashMap<View, Boolean> r102 = this.f137817f;
        if (r102 == null) goto L10;
        Boolean r103 = r102.get(r101);
    L11:
        if (r103 == null) goto L18;
        HashMap<View, Boolean> r104 = this.f137817f;
        if (r104 == null) goto L15;
        Boolean r105 = r104.get(r101);
    L17:
        if (Intrinsics.areEqual(r105, Boolean.FALSE) == false) goto L6;
    L15:
        r105 = null;
    L18:
        int r106 = com.bytedance.android.live.room.y.f100451a;
        com.bytedance.android.live.room.y.a(this.f137835x, this.f137814c, "sendTagShowLog", new f(r101, this));
        goto L6
    L10:
        r103 = null;
    L19:
        CompositeDisposable r107 = this.f137814c;
        if (r107 == null) goto L22;
        r107.dispose();
    L22:
        d r108 = this.f137815d;
        if (r108 == null) goto L25;
        r108.cancel();
    L25:
        this.f137815d = null;
        c r109 = this.f137823l;
        if (r109 == null) goto L28;
        r109.cancel();
    L28:
        this.f137823l = null;
    }

    public final DataCenter getDataCenter() {
        return this.f137835x;
    }

    public final int getFlipCount() {
        return this.f137813b;
    }

    public static final void a(DiggCountFlipperLayout r100) {
        if (r100.f137816e != 1) goto L5;
        n81.a.b("onAppointmentExpireWithCertDigg, is digging");
        return;
    L5:
        n81.a.b("onAppointmentExpireWithCertDigg, change to cert");
        r100.k(true, false, true);
    }

    public static final void b(DiggCountFlipperLayout r100) {
        if (r100.f137816e != 1) goto L5;
        n81.a.b("onAppointmentExpireWithCertDigg, is digging");
        return;
    L5:
        n81.a.b("onAppointmentExpireWithCertDigg, change to digg");
        r100.j(true, true, true);
    }

    public final void d(Disposable r100) {
        CompositeDisposable r101 = this.f137814c;
        if (r101 == null) goto L6;
        r101.add(r100);
        return;
    }

    public final void m(ii r110) {
        Intrinsics.checkNotNullParameter(r110, "message");
        if ((!Intrinsics.areEqual(this.B, "flip_appointment_cert_digg")) == false) goto L9;
        if ((!Intrinsics.areEqual(this.B, "flip_appointment_digg")) == false) goto L9;
        int r111 = n81.a.f518242a;
        n81.a.b("tryShowAppointmentMessage, flip type error, is " + this.B);
        return;
    L9:
        if (this.f137824m == 0) goto L12;
        int r112 = n81.a.f518242a;
        n81.a.b("tryShowAppointmentMessage, appointmentCountdownTimerState error, is " + this.f137824m);
        return;
    L12:
        Long r100 = r110.getDuration();
        long r101 = 0;
        if (r100 == null) goto L15;
        long r102 = r100.longValue();
    L17:
        if (r102 > 0) goto L20;
        int r103 = n81.a.f518242a;
        r102 = q4.f65392a.getValue().longValue();
    L20:
        int r104 = n81.a.f518242a;
        n81.a.b("tryShowAppointmentMessage, flipTime is " + r102);
        if (r102 <= 0) goto L71;
        Text r113 = r110.E();
        if (r113 == null) goto L25;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.f141015a.getClass();
        com.bytedance.android.livesdk.interactivity.service.textrender.core.r.f141035g.d(r113, null, new com.bytedance.android.livesdk.interactivity.service.textrender.core.y(0.0f), new h(this));
    L25:
        String r114 = this.B;
        int r105 = r114.hashCode();
        if (r105 == (-2118222249)) goto L37;
        if (r105 == (-1446375826)) goto L31;
        return;
    L31:
        if (r114.equals("flip_appointment_cert_digg") == true) goto L33;
        return;
    L33:
        if (this.f137816e != 1) goto L35;
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_CERT_DIGG, mState is STATE_DIGGING");
        f(r102 * ((long) 1000), false, new DiggCountFlipperLayout$tryShowAppointmentMessage$2(this));
        return;
    L35:
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_CERT_DIGG, mState is " + this.f137816e);
        f(r102 * ((long) 1000), true, new DiggCountFlipperLayout$tryShowAppointmentMessage$3(this));
        i(true, false, true);
        return;
    L37:
        if (r114.equals("flip_appointment_digg") == false) goto L75;
        DiggContext.a r115 = DiggContext.Companion;
        DataCenter r106 = this.f137835x;
        r115.getClass();
        DiggContext r116 = DiggContext.a.a(r106);
        if (r116 == null) goto L46;
        com.bytedance.live.datacontext.m<Long> r117 = r116.getDiggTime();
        if (r117 == null) goto L46;
        Long r118 = r117.getValue();
        if (r118 == null) goto L46;
        r101 = r118.longValue();
    L46:
        if ((System.currentTimeMillis() - r101) >= 2000) goto L48;
        boolean r119 = true;
    L49:
        if (r119 == false) goto L60;
        DiggContext r120 = DiggContext.a.a(this.f137835x);
        if (r120 == null) goto L59;
        com.bytedance.live.datacontext.m<Long> r121 = r120.getDiggTime();
        if (r121 == null) goto L59;
        Observable<Long> r122 = r121.a();
        if (r122 == null) goto L59;
        Disposable r123 = r122.subscribe(new i(this));
        if (r123 == null) goto L59;
        d(r123);
    L59:
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_DIGG, mState is STATE_DIGGING");
        f(r102 * ((long) 1000), false, new DiggCountFlipperLayout$tryShowAppointmentMessage$5(this));
        h();
        return;
    L60:
        DiggContext r124 = DiggContext.a.a(this.f137835x);
        if (r124 == null) goto L69;
        com.bytedance.live.datacontext.m<Long> r125 = r124.getDiggTime();
        if (r125 == null) goto L69;
        Observable<Long> r126 = r125.a();
        if (r126 == null) goto L69;
        Disposable r127 = r126.subscribe(new j(this));
        if (r127 == null) goto L69;
        d(r127);
    L69:
        n81.a.b("tryShowAppointmentMessage, type is FLIP_APPOINTMENT_DIGG, mState is Origin Digg");
        f(r102 * ((long) 1000), true, new DiggCountFlipperLayout$tryShowAppointmentMessage$7(this));
        i(true, true, true);
        return;
    L48:
        r119 = false;
        goto L49
    L75:
        return;
    L71:
        return;
    L15:
        r102 = 0;
        goto L17
    }

    public final void n(int r100) {
        TextView r101 = this.f137825n;
        if (r101 == null) goto L5;
        r101.setTextColor(r100);
    L5:
        TextView r102 = this.f137826o;
        if (r102 == null) goto L8;
        r102.setTextColor(r100);
    L8:
        TextView r103 = this.f137827p;
        if (r103 == null) goto L12;
        r103.setTextColor(r100);
        return;
    }

    public final void o(String r100) {
        Intrinsics.checkNotNullParameter(r100, "countString");
        this.f137820i = s1.C(R.string.ttlive_digg_current_room_digg_count, new Object[]{r100});
        if (this.f137821j.a() == false) goto L13;
        String r101 = this.f137820i;
        TextView r102 = this.f137825n;
        if (r102 == null) goto L7;
        CharSequence r103 = r102.getText();
    L9:
        if ((!Intrinsics.areEqual(r101, r103)) == false) goto L16;
        TextView r104 = this.f137825n;
        if (r104 == null) goto L16;
        r104.setText(this.f137820i);
    L16:
        TextView r105 = this.f137826o;
        if (r105 == null) goto L20;
        r105.setText(r100);
    L20:
        if (this.f137816e != 1) goto L25;
        Function1<? super String, Unit> r106 = this.f137834w;
        if (r106 == null) goto L26;
        Unit r107 = r106.invoke(this.f137820i);
        return;
    L26:
        return;
    L25:
        return;
    L7:
        r103 = null;
        goto L9
    L13:
        TextView r108 = this.f137825n;
        if (r108 == null) goto L16;
        r108.setText(this.f137820i);
        goto L16
    }

    public final void setAnchor(boolean r100) {
        this.f137812a = r100;
    }

    public final void setCanFlip(boolean r100) {
        this.f137822k = r100;
    }

    public final void setContentDescriptionAction(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        this.f137834w = r100;
    }

    public final void setFlipCount(b r100) {
        Intrinsics.checkNotNullParameter(r100, "flipListener");
        this.f137829r = r100;
    }

    public final void setFlipCount(int r100) {
        this.f137813b = r100;
    }

    public final void g(View r100, int r101) {
        int r102 = com.bytedance.android.live.room.y.f100451a;
        com.bytedance.android.live.room.y.a(this.f137835x, this.f137814c, "sendTagShowLog", new g(this, r100, r101));
    }

    public final void p(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "countStr");
        Intrinsics.checkNotNullParameter(r101, "descText");
        if ((this.f137813b % 2) != 1) goto L10;
        TextView r102 = this.f137826o;
        if (r102 == null) goto L7;
        r102.setText(r100);
        ALogger.d("Flip", "  diggCountView  : " + r100);
    L7:
        TextView r103 = this.f137827p;
        if (r103 == null) goto L24;
        r103.setText(r101);
        ALogger.d("Flip", "  diggDescriptionView  : " + r101);
        Unit r104 = Unit.INSTANCE;
        return;
    L24:
        return;
    L10:
        View r105 = this.f137837z;
        View r106 = null;
        if ((r105 instanceof TextView) == true) goto L13;
        r105 = null;
    L13:
        TextView r107 = (TextView) r105;
        if (r107 == null) goto L16;
        r107.setText(r100);
        ALogger.d("Flip", "  countView  : " + r100);
    L16:
        View r108 = this.A;
        if ((r108 instanceof TextView) == false) goto L20;
        r106 = r108;
    L20:
        TextView r109 = (TextView) r106;
        if (r109 == null) goto L26;
        r109.setText(r101);
        ALogger.d("Flip", "  descriptionView  : " + r101);
        Unit r110 = Unit.INSTANCE;
        return;
    }

    public static final void c(DiggCountFlipperLayout r100, View r110, int r111) {
        r100.getClass();
        Object r101 = r110.getTag(R.id.ttlive_tag_user_info_tab_type);
        Object r102 = r110.getTag(R.id.ttlive_tag_user_info_tab_label_type);
        Object r103 = r110.getTag(R.id.ttlive_tag_user_info_ecom_flag);
        Object r104 = r110.getTag(R.id.ttlive_tag_user_info_label_text);
        Object r105 = r110.getTag(R.id.ttlive_tag_user_info_track_params);
        boolean r106 = r101 instanceof String;
        if (r106 == false) goto L5;
    L10:
        com.bytedance.android.livesdk.log.g r107 = com.bytedance.android.livesdk.log.u.l();
        LinkedHashMap r108 = new LinkedHashMap();
        if (r106 == true) goto L13;
        Object r109 = null;
    L15:
        if (((String) r109) == null) goto L18;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE, r101);
    L18:
        if ((r102 instanceof Integer) == true) goto L20;
        Object r112 = null;
    L21:
        Integer r113 = (Integer) r112;
        if (r113 == null) goto L25;
        r113.intValue();
        r108.put("tag_name", r102.toString());
    L25:
        if ((r104 instanceof String) == true) goto L27;
        r104 = null;
    L27:
        String r114 = (String) r104;
        if (r114 == null) goto L31;
        r108.put("tag_detail", r114);
    L31:
        if ((r103 instanceof String) == true) goto L33;
        r103 = null;
    L33:
        String r115 = (String) r103;
        if (r115 == null) goto L37;
        r108.put(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, r115);
    L37:
        if ((r105 instanceof Map) == true) goto L39;
        r105 = null;
    L39:
        Map r116 = (Map) r105;
        if (r116 == null) goto L42;
        r108.putAll(r116);
    L42:
        r108.put("tag_order", String.valueOf(r111));
        Unit r117 = Unit.INSTANCE;
        r107.sendLog("livesdk_tag_show", r108, new Object[]{am2.x.class, Room.class});
        r100.f137817f.put(r110, Boolean.TRUE);
        return;
    L20:
        r112 = r102;
        goto L21
    L13:
        r109 = r101;
        goto L15
    L5:
        if ((r102 instanceof Integer) == true) goto L10;
        if ((r103 instanceof String) == true) goto L10;
        if ((r104 instanceof String) == true) goto L10;
    }

    public final void e(boolean r100, boolean r101, boolean r102) {
        if (Intrinsics.areEqual(this.B, "flip_appointment_cert_digg") == false) goto L37;
        if (r100 == true) goto L9;
        Iterator<T> r103 = this.f137831t.iterator();
    L7:
        if (r103.hasNext() == false) goto L13;
        View r104 = (View) r103.next();
        r104.clearAnimation();
        UtilityKotlinExtentionsKt.t(r104);
    L13:
        if (r101 == true) goto L18;
        Iterator<T> r105 = this.f137830s.iterator();
    L16:
        if (r105.hasNext() == false) goto L22;
        View r106 = (View) r105.next();
        r106.clearAnimation();
        UtilityKotlinExtentionsKt.t(r106);
    L22:
        if (r102 == true) goto L29;
        TextView r107 = this.f137828q;
        if (r107 == null) goto L26;
        r107.clearAnimation();
    L26:
        TextView r108 = this.f137828q;
        if (r108 == null) goto L38;
        UtilityKotlinExtentionsKt.t(r108);
        return;
    L38:
        return;
    L29:
        TextView r109 = this.f137828q;
        if (r109 == null) goto L40;
        UtilityKotlinExtentionsKt.w(r109);
        return;
    L40:
        return;
    L18:
        Iterator<T> r110 = this.f137830s.iterator();
    L20:
        if (r110.hasNext() == false) goto L22;
        UtilityKotlinExtentionsKt.w((View) r110.next());
        goto L20
    L9:
        Iterator<T> r111 = this.f137831t.iterator();
    L11:
        if (r111.hasNext() == false) goto L13;
        UtilityKotlinExtentionsKt.w((View) r111.next());
        goto L11
    }

    public final void f(long r100, boolean r110, Function0<Unit> r111) {
        c r101 = this.f137823l;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        this.f137823l = new c(this, r111, r100, r100);
        if (r110 == false) goto L13;
        n81.a.b("createAppointmentTimer, start");
        c r102 = this.f137823l;
        if (r102 == null) goto L10;
        r102.start();
    L10:
        this.f137824m = 2;
        u32.n r103 = this.D;
        if (r103 == null) goto L15;
        r103.g();
        return;
    L15:
        return;
    L13:
        n81.a.b("createAppointmentTimer, pending");
        this.f137824m = 1;
    }

    public final void i(boolean r100, boolean r101, boolean r102) {
        int r103 = n81.a.f518242a;
        n81.a.b("showAppointmentView, isNeedFlip = " + r100);
        if (r100 == false) goto L18;
        e(r101, r102, true);
        if (r101 == false) goto L10;
        Iterator<View> r104 = this.f137831t.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().startAnimation(this.f137819h);
    L10:
        if (r102 == false) goto L15;
        Iterator<View> r105 = this.f137830s.iterator();
    L13:
        if (r105.hasNext() == false) goto L15;
        r105.next().startAnimation(this.f137819h);
    L15:
        TextView r106 = this.f137828q;
        if (r106 == null) goto L18;
        r106.startAnimation(this.f137818g);
    L18:
        u32.n r107 = this.D;
        if (r107 == null) goto L21;
        r107.f(ActivityVO.APPOINTMENT);
    L21:
        TextView r108 = this.f137828q;
        if (r108 == null) goto L32;
        n81.b.f518243a.getClass();
        Object r109 = r108.getTag(R.id.ttlive_tag_user_info_tab_label_content_description_key);
        if ((r109 instanceof n81.b) == true) goto L26;
        r109 = null;
    L26:
        n81.b r110 = (n81.b) r109;
        if (r110 == null) goto L29;
        r110.onShow();
    L29:
        r108.setVisibility(0);
        if (b1.f497171a.getValue().a() == true) goto L32;
        g(r108, 1);
    L32:
        this.f137816e = 2;
    }

    public final void j(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L17;
        e(true, r101, r102);
        Iterator<View> r103 = this.f137831t.iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        r103.next().startAnimation(this.f137818g);
        goto L6
    L8:
        if (r101 == false) goto L13;
        Iterator<View> r104 = this.f137830s.iterator();
    L11:
        if (r104.hasNext() == false) goto L13;
        r104.next().startAnimation(this.f137819h);
    L13:
        if (r102 == false) goto L17;
        TextView r105 = this.f137828q;
        if (r105 == null) goto L17;
        r105.startAnimation(this.f137819h);
    L17:
        u32.n r106 = this.D;
        if (r106 == null) goto L20;
        r106.f("digg");
    L20:
        Iterator<View> r107 = this.f137831t.iterator();
    L22:
        if (r107.hasNext() == false) goto L34;
        View r108 = r107.next();
        n81.b.f518243a.getClass();
        Object r109 = r108.getTag(R.id.ttlive_tag_user_info_tab_label_content_description_key);
        if ((r109 instanceof n81.b) == true) goto L26;
        r109 = null;
    L26:
        n81.b r110 = (n81.b) r109;
        if (r110 == null) goto L29;
        r110.onShow();
    L29:
        r108.setVisibility(0);
        if (r100 == true) goto L32;
        int r111 = 1;
    L33:
        g(r108, r111);
        goto L22
    L32:
        r111 = 2;
        goto L33
    L34:
        this.f137816e = 1;
    }

    public final void k(boolean r100, boolean r101, boolean r102) {
        if (r100 == false) goto L18;
        e(r101, true, r102);
        if (r101 == false) goto L10;
        Iterator<View> r103 = this.f137831t.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        r103.next().startAnimation(this.f137819h);
    L10:
        if (r102 == false) goto L14;
        TextView r104 = this.f137828q;
        if (r104 == null) goto L14;
        r104.startAnimation(this.f137819h);
    L14:
        Iterator<View> r105 = this.f137830s.iterator();
    L16:
        if (r105.hasNext() == false) goto L18;
        r105.next().startAnimation(this.f137818g);
    L18:
        u32.n r106 = this.D;
        if (r106 == null) goto L21;
        r106.f(TextureRenderKeys.KEY_IS_CERT);
    L21:
        Iterator<View> r107 = this.f137830s.iterator();
    L23:
        if (r107.hasNext() == false) goto L33;
        View r108 = r107.next();
        n81.b.f518243a.getClass();
        Object r109 = r108.getTag(R.id.ttlive_tag_user_info_tab_label_content_description_key);
        if ((r109 instanceof n81.b) == true) goto L27;
        r109 = null;
    L27:
        n81.b r110 = (n81.b) r109;
        if (r110 == null) goto L30;
        r110.onShow();
    L30:
        r108.setVisibility(0);
        if (b1.f497171a.getValue().a() == true) goto L23;
        g(r108, 1);
        goto L23
    L33:
        this.f137816e = 0;
    }

    public DiggCountFlipperLayout(DataCenter r110, Context r111, View r210, View r211, View r212, String r213, View r214, u32.n r215, int r216) {
        if ((r216 & 4) == 0) goto L5;
        View r100 = null;
    L7:
        if ((r216 & 8) == 0) goto L9;
        View r101 = null;
    L11:
        if ((r216 & 16) == 0) goto L13;
        View r102 = null;
    L15:
        if ((r216 & 32) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r216 & 64) == 0) goto L21;
        View r112 = null;
    L23:
        if ((r216 & 128) == 0) goto L25;
        u32.n r104 = null;
    L26:
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "flipType");
        super(r111);
        this.f137835x = r110;
        this.f137836y = r100;
        this.f137837z = r101;
        this.A = r102;
        this.B = r103;
        this.C = r112;
        this.D = r104;
        Room r105 = ((IRoomService) jc1.k.n(IRoomService.class)).getCurrentRoom();
        if (r105 == null) goto L31;
        User r106 = r105.mo8271getOwner();
        if (r106 == null) goto L31;
        String r107 = r106.getIdStr();
    L32:
        this.f137812a = Intrinsics.areEqual(r107, ((IUserService) jc1.k.n(IUserService.class)).user().n());
        this.f137817f = new HashMap();
        this.f137820i = "";
        l61 r108 = LiveInfraSettingKeys.LIVE_ON_MEASURE_OPT_CONFIG.getValue();
        this.f137821j = r108;
        int r109 = (int) s1.e(66.0f);
        this.f137822k = true;
        if (r100 == null) goto L39;
        TextView r113 = new TextView(r111);
        r113.setVisibility(8);
        r113.setTextSize(1, 8.0f);
        r113.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        r113.setMaxLines(1);
        r113.setSingleLine(true);
        r113.setTag(R.id.ttlive_tag_user_info_tab_type, "like_cnt");
        n81.b.f518243a.getClass();
        r113.setTag(R.id.ttlive_tag_user_info_tab_label_content_description_key, new k(this));
        Unit r114 = Unit.INSTANCE;
        if (r108.a() == true) goto L38;
        r109 = -2;
    L38:
        FrameLayout.LayoutParams r115 = new FrameLayout.LayoutParams(r109, -2);
        r115.gravity = 16;
        addView(r113, r115);
    L40:
        this.f137825n = r113;
        if (r101 == null) goto L47;
        TextView r116 = new TextView(r111);
        r116.setVisibility(8);
        r116.setTextSize(1, 12.0f);
        if (this.f137812a == false) goto L45;
        r116.setTextColor(ColorProtector.parseColor(CustomHeaderConfig.COLOR_LIGHT));
    L46:
        r116.setMaxLines(1);
        r116.setSingleLine(true);
        r116.setTag(R.id.ttlive_tag_user_info_tab_type, "like_cnt");
        Unit r117 = Unit.INSTANCE;
        FrameLayout.LayoutParams r118 = new FrameLayout.LayoutParams(-2, -2);
        r118.gravity = 16;
        addView(r116, r118);
    L48:
        this.f137826o = r116;
        if (r102 == null) goto L62;
        TextView r119 = new TextView(r111);
        r119.setVisibility(8);
        r119.setTextSize(1, 10.0f);
        if (this.f137812a == false) goto L60;
        DiggContext r120 = com.bytedance.android.livesdk.interactivity.api.like.datacontext.a.a(RoomContext.a.c(RoomContext.Companion, r110, 0, 2));
        if (r120 == null) goto L59;
        com.bytedance.live.datacontext.m<Boolean> r121 = r120.getInDoubleLike();
        if (r121 == null) goto L59;
        if (r121.getValue().booleanValue() != true) goto L59;
        r119.setTextColor(UserInfoDiggBridge.f133285e);
    L61:
        r119.setMaxLines(1);
        r119.setSingleLine(true);
        r119.setText(R.string.ttlive_digg_current_room_digg_count_description);
        Unit r122 = Unit.INSTANCE;
        FrameLayout.LayoutParams r123 = new FrameLayout.LayoutParams(-2, -2);
        r123.gravity = 16;
        addView(r119, r123);
    L63:
        this.f137827p = r119;
        ArrayList<View> r124 = new ArrayList();
        if (r100 == null) goto L66;
        r124.add(r100);
    L66:
        if (r101 == null) goto L68;
        r124.add(r101);
    L68:
        if (r102 == null) goto L70;
        r124.add(r102);
    L70:
        Unit r125 = Unit.INSTANCE;
        this.f137830s = r124;
        ArrayList<View> r126 = new ArrayList();
        if (r113 == null) goto L73;
        r126.add(r113);
    L73:
        if (r116 == null) goto L75;
        r126.add(r116);
    L75:
        if (r119 == null) goto L77;
        r126.add(r119);
    L77:
        this.f137831t = r126;
        ArrayList<View> r127 = new ArrayList();
        if (r112 == null) goto L80;
        r127.add(r112);
    L80:
        this.f137832u = r127;
        ArrayList<ArrayList<View>> r128 = new ArrayList();
        if (r127.size() <= 0) goto L84;
        r128.add(r127);
    L84:
        if (r124.size() <= 0) goto L87;
        r128.add(r124);
    L87:
        if (r126.size() <= 0) goto L89;
        r128.add(r126);
    L89:
        this.f137833v = r128;
        return;
    L59:
        r119.setTextColor(ColorProtector.parseColor("#EAE9E9"));
        goto L61
    L60:
        r119.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        goto L61
    L62:
        r119 = null;
        goto L63
    L45:
        r116.setTextColor(ColorProtector.parseColor("#b3ffffff"));
        goto L46
    L47:
        r116 = null;
        goto L48
    L39:
        r113 = null;
    L31:
        r107 = null;
        goto L32
    L25:
        r104 = r215;
        goto L26
    L21:
        r112 = r214;
        goto L23
    L17:
        r103 = r213;
        goto L19
    L13:
        r102 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
