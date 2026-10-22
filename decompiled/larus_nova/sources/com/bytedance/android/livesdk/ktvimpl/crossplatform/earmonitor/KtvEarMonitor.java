package com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.m1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.config.f50;
import com.bytedance.android.livesdk.config.lf1;
import com.bytedance.android.livesdk.config.v40;
import com.bytedance.android.livesdk.config.x8;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import hg6.g;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvEarMonitor implements com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f143772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f143773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f143774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f143775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f143776e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f143777f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j1 f143778g;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvEarMonitor f143779a;

        public b(KtvEarMonitor r100) {
            this.f143779a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            this.f143779a.n(((Boolean) r100).booleanValue());
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvEarMonitor f143780a;

        public c(KtvEarMonitor r100) {
            this.f143780a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            KtvEarMonitor r102 = this.f143780a;
            o r103 = m.i();
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r104 = r103.X1();
            if (r104 == null) goto L9;
            Boolean r105 = r104.getValue();
            if (r105 == null) goto L9;
            boolean r106 = r105.booleanValue();
        L10:
            r102.n(r106);
            return;
        L9:
            r106 = false;
            goto L10
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvEarMonitor f143781a;

        public d(KtvEarMonitor r100) {
            this.f143781a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Boolean r101 = (Boolean) r100;
            KtvEarMonitor r102 = this.f143781a;
            o r103 = m.i();
            if (r103 == null) goto L9;
            com.bytedance.live.datacontext.m<Boolean> r104 = r103.X1();
            if (r104 == null) goto L9;
            Boolean r105 = r104.getValue();
            if (r105 == null) goto L9;
            boolean r106 = r105.booleanValue();
        L10:
            r102.n(r106);
            return;
        L9:
            r106 = false;
            goto L10
        }
    }

    public static final class e extends vb6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvEarMonitor f143782a;

        @Override // vb6.a, yb6.b, yb6.i
        public final void s1() {
            com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "onPreReleaseLiveClient");
            this.f143782a.e();
            com.bytedance.android.live.pushstream.d r100 = this.f143782a.i();
            if (r100 == null) goto L6;
            r100.h1(this.f143782a.f143777f);
            return;
        }

        @Override // vb6.a, yb6.b, yb6.i
        public final void t1() {
            com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "onReleaseLiveClient");
            this.f143782a.f143775d.set(false);
        }

        public e(KtvEarMonitor r100) {
            this.f143782a = r100;
        }
    }

    public static final class f implements h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvEarMonitor f143783a;

        public f(KtvEarMonitor r100) {
            this.f143783a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void e() {
        p(false, false);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final boolean a() {
        return com.bytedance.android.livesdk.sharedpref.c.f158275j.getValue().booleanValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void b() {
        StringBuilder r100 = new StringBuilder("supportHardWareEcho: ktv_hardware_echo_ab=");
        x8 r101 = x8.f121582a;
        r100.append(r101.getValue());
        r100.append(" ;;audioFilterManager?.isSupportHardWareEarMonitor=false");
        g();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", r100.toString());
        if (r101.getValue().booleanValue() == false) goto L6;
        g();
        return;
    }

    public final void g() {
        j1 r100 = this.f143778g;
        if (r100 == null) goto L14;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r101 == null) goto L15;
        g r102 = r101.getRtcManager();
        if (r102 == null) goto L16;
        ec6.b r103 = r102.R();
        if (r103 == null) goto L17;
        com.bytedance.android.live.pushstream.d r104 = gc6.b.a(r103);
        if (r104 == null) goto L18;
        r104.u();
        return;
    L18:
        return;
    L17:
        return;
    L16:
        return;
    L15:
        return;
    }

    public final boolean h() {
        Boolean r100 = this.f143774c.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public final com.bytedance.android.live.pushstream.d i() {
        j1 r100 = this.f143778g;
        if (r100 == null) goto L11;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r101 == null) goto L11;
        g r102 = r101.getRtcManager();
        if (r102 == null) goto L11;
        ec6.b r103 = r102.R();
        if (r103 == null) goto L11;
        return gc6.b.a(r103);
    L11:
        return null;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void init() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "init");
        o r100 = m.i();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r101 = r100.X1();
        if (r101 == null) goto L9;
        Boolean r102 = r101.getValue();
        if (r102 == null) goto L9;
        boolean r103 = r102.booleanValue();
    L10:
        n(r103);
        o r104 = m.i();
        if (r104 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r105 = r104.X1();
        if (r105 == null) goto L19;
        Observable<Boolean> r106 = r105.a();
        if (r106 == null) goto L19;
        Disposable r107 = r106.subscribe(new b(this));
        if (r107 == null) goto L19;
        RxUtilKt.c(r107, this.f143772a);
    L19:
        o r108 = m.i();
        if (r108 == null) goto L28;
        com.bytedance.live.datacontext.m<Boolean> r109 = r108.n2();
        if (r109 == null) goto L28;
        Observable<Boolean> r110 = r109.a();
        if (r110 == null) goto L28;
        Disposable r111 = r110.subscribe(new c(this));
        if (r111 == null) goto L28;
        RxUtilKt.c(r111, this.f143772a);
    L28:
        o r112 = m.i();
        if (r112 == null) goto L37;
        com.bytedance.live.datacontext.m<Boolean> r113 = r112.N2();
        if (r113 == null) goto L37;
        Observable<Boolean> r114 = r113.a();
        if (r114 == null) goto L37;
        Disposable r115 = r114.subscribe(new d(this));
        if (r115 == null) goto L37;
        RxUtilKt.c(r115, this.f143772a);
    L37:
        j1 r116 = this.f143778g;
        if (r116 == null) goto L45;
        cg6.a r117 = (cg6.a) r116.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r117 == null) goto L46;
        vb6.g r118 = r117.O5();
        if (r118 == null) goto L47;
        r118.X0(this.f143776e, true);
        return;
    L47:
        return;
    L46:
        return;
    L45:
        return;
    L9:
        r103 = false;
        goto L10
    }

    public final boolean j() {
        return com.bytedance.android.livesdk.sharedpref.c.N.getValue().booleanValue();
    }

    public final boolean l() {
        return ((lf1) KtvSettingHelper.F.getValue()).c();
    }

    public final void q() {
        StringBuilder r100 = new StringBuilder("supportSoftWareEcho: setting=");
        f50 r101 = f50.f120177a;
        r100.append(r101.getValue().booleanValue());
        r100.append(" ;; enable_ktv_software_echo=false");
        g();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", r100.toString());
        if (r101.getValue().booleanValue() == false) goto L6;
        g();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void release() {
        j1 r100 = this.f143778g;
        if (r100 == null) goto L9;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r101 == null) goto L9;
        vb6.g r102 = r101.O5();
        if (r102 == null) goto L9;
        r102.a1(this.f143776e);
    L9:
        com.bytedance.android.live.pushstream.d r103 = i();
        if (r103 == null) goto L12;
        r103.h1(this.f143777f);
    L12:
        this.f143772a.clear();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "release");
    }

    public final boolean k() {
        if (m1.b() == false) goto L5;
    L10:
        boolean r100 = true;
    L11:
        boolean r101 = new PolarisFileWrapper("/my_product/etc/permissions/oplus.product.feature_ktv.xml").exists();
        Context r102 = s1.getContext();
        String r103 = null;
        if (r102 == null) goto L14;
        Object r104 = r102.getSystemService("audio");
    L16:
        if ((r104 instanceof AudioManager) == true) goto L18;
        r104 = null;
    L18:
        AudioManager r105 = (AudioManager) r104;
        if (r105 == null) goto L21;
        r103 = r105.getParameters("OPLUS_AUDIO_GET_KARAOKE_V2_SUPPORT");
    L21:
        boolean r106 = Intrinsics.areEqual(r103, "true");
        Context r107 = s1.getContext();
        if (r107 == null) goto L28;
        PackageManager r108 = r107.getPackageManager();
        if (r108 == null) goto L28;
        if (r108.hasSystemFeature("oplus.software.audio.karaoke_v2.support") != true) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == true) goto L34;
        if (r106 == true) goto L34;
        if (r101 == true) goto L34;
        boolean r110 = false;
    L35:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "isOppoDevice == " + r100 + "  ;; isSupportOppoEcho = " + r110 + " ;; hasEchoModeFeature == " + r109 + " ;; hasOppoKaraokeV2Support == " + r106 + " ;; isOppoEchoFileExists == " + r101);
        if (r100 == false) goto L42;
        if (r110 == true) goto L39;
        return false;
    L39:
        if (this.f143773b.booleanValue() == false) goto L44;
        return true;
    L44:
        return false;
    L42:
        return false;
    L34:
        r110 = true;
    L28:
        r109 = false;
        goto L29
    L14:
        r104 = null;
        goto L16
    L5:
        if (m1.a() == true) goto L10;
        if (m1.c() == true) goto L10;
        r100 = false;
        goto L11
    }

    public final void m() {
        b();
        q();
    }

    public final void o() {
        b();
        q();
    }

    public KtvEarMonitor(j1 r100) {
        this.f143778g = r100;
        this.f143772a = new CompositeDisposable();
        this.f143773b = v40.f121419a.getValue();
        com.bytedance.android.livesdk.sharedpref.c.f158275j.getValue().booleanValue();
        this.f143774c = new MutableLiveData();
        this.f143775d = new AtomicBoolean(false);
        this.f143776e = new e(this);
        this.f143777f = new f(this);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void c(final boolean r100) {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "setSoundCardMode: enable=" + r100);
        UtilityKotlinExtentionsKt.b(this, new KtvEarMonitor$setSoundCardMode$1(r100));
        com.bytedance.android.live.pushstream.d r101 = i();
        if (r101 == null) goto L8;
        d0 r102 = r101.getLiveCore();
        if (r102 == null) goto L9;
        r102.h();
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.a
    public final void f(boolean r100) {
        if (this.f143775d.get() == true) goto L8;
        g();
        com.bytedance.android.live.pushstream.d r101 = i();
        if (r101 == null) goto L7;
        r101.I0(this.f143777f);
    L7:
        g();
        b();
        return;
    L8:
        b();
        q();
        Boolean r102 = com.bytedance.android.livesdk.sharedpref.c.f158275j.getValue();
        if (r102 == null) goto L12;
        r102.booleanValue();
    L12:
        if (this.f143775d.get() == true) goto L16;
        g();
        return;
    }

    public final void n(final boolean r100) {
        this.f143774c.setValue(Boolean.valueOf(r100));
        UtilityKotlinExtentionsKt.b(this, new KtvEarMonitor$onWiredStateChange$1(r100));
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvEarMonitor", "onWiredStateChange: " + r100);
    }

    public final void p(boolean r100, boolean r101) {
        b();
        q();
        if (r101 == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.c.f158275j;
        Boolean r103 = Boolean.valueOf(r100);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        return;
    }
}
