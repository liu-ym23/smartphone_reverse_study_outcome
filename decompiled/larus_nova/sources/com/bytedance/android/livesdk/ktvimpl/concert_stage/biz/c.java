package com.bytedance.android.livesdk.ktvimpl.concert_stage.biz;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.m1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.config.f50;
import com.bytedance.android.livesdk.config.v40;
import com.bytedance.android.livesdk.config.x8;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.DynamicConcertStatusChangeEventType;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.JsonObject;
import io.reactivex.disposables.CompositeDisposable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;
import uf2.h0;

/* JADX INFO: loaded from: classes10.dex */
public final class c implements gd2.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f143729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f143730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MutableLiveData<Boolean> f143731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f143732d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f143733e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final C2248c f143734f;

    public static final class a {
    }

    public static final class b extends vb6.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f143735a;

        @Override // vb6.a, yb6.b, yb6.i
        public final void s1() {
            w.b("ConcertEarMonitor", "onPreReleaseLiveClient");
            this.f143735a.g(false, false);
            this.f143735a.getClass();
            com.bytedance.android.live.pushstream.d r100 = c.k();
            if (r100 == null) goto L6;
            r100.h1(this.f143735a.f143734f);
            return;
        }

        @Override // vb6.a, yb6.b, yb6.i
        public final void t1() {
            w.b("ConcertEarMonitor", "onReleaseLiveClient");
            this.f143735a.f143732d.set(false);
        }

        public b(c r100) {
            this.f143735a = r100;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.ktvimpl.concert_stage.biz.c$c, reason: collision with other inner class name */
    public static final class C2248c implements h0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f143736a;

        public C2248c(c r100) {
            this.f143736a = r100;
        }
    }

    static {
    }

    @Override // gd2.d
    public final void d() {
    }

    public static com.bytedance.android.live.pushstream.d k() {
        ConcertStageDataContext r100 = ConcertStageDataContext.Companion.getContext();
        if (r100 == null) goto L9;
        com.bytedance.live.datacontext.j<js1.a> r101 = r100.getLinkComponent();
        if (r101 == null) goto L9;
        js1.a r102 = r101.getValue();
        if (r102 == null) goto L9;
        return r102.b();
    L9:
        return null;
    }

    public static void m() {
        StringBuilder r100 = new StringBuilder("supportSoftWareEcho: setting=");
        f50 r101 = f50.f120177a;
        r100.append(r101.getValue().booleanValue());
        r100.append(" ;; enable_ktv_software_echo=false");
        j();
        w.b("ConcertEarMonitor", r100.toString());
        if (r101.getValue().booleanValue() == false) goto L6;
        j();
        return;
    }

    @Override // gd2.d
    public final boolean a() {
        return com.bytedance.android.livesdk.sharedpref.c.f158275j.getValue().booleanValue();
    }

    @Override // gd2.d
    public final void b() {
        StringBuilder r100 = new StringBuilder("supportHardWareEcho: ktv_hardware_echo_ab=");
        x8 r101 = x8.f121582a;
        r100.append(r101.getValue());
        r100.append(" ;;audioFilterManager?.isSupportHardWareEarMonitor=false");
        j();
        w.b("ConcertEarMonitor", r100.toString());
        if (r101.getValue().booleanValue() == false) goto L6;
        j();
        return;
    }

    @Override // gd2.d
    public final boolean f() {
        Boolean r100 = this.f143731c.getValue();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    public c() {
        this.f143729a = new CompositeDisposable();
        this.f143730b = v40.f121419a.getValue();
        com.bytedance.android.livesdk.sharedpref.c.f158275j.getValue().booleanValue();
        this.f143731c = new MutableLiveData();
        this.f143732d = new AtomicBoolean(false);
        this.f143733e = new b(this);
        this.f143734f = new C2248c(this);
    }

    public static void j() {
        com.bytedance.android.live.pushstream.d r100 = k();
        if (r100 == null) goto L6;
        r100.u();
        return;
    }

    @Override // gd2.d
    public final void e() {
        b();
        m();
    }

    @Override // gd2.d
    public final boolean h() {
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
        w.b("ConcertEarMonitor", "isOppoDevice == " + r100 + "  ;; isSupportOppoEcho = " + r110 + " ;; hasEchoModeFeature == " + r109 + " ;; hasOppoKaraokeV2Support == " + r106 + " ;; isOppoEchoFileExists == " + r101);
        if (r100 == false) goto L42;
        if (r110 == true) goto L39;
        return false;
    L39:
        if (this.f143730b.booleanValue() == false) goto L44;
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

    @Override // gd2.d
    public final void i() {
        b();
        m();
    }

    @Override // gd2.d
    public final void c(boolean r100) {
        w.b("ConcertEarMonitor", "setSoundCardMode: enable=" + r100);
        gd2.f r101 = ConcertStageDataContext.Companion.a();
        if (r101 == null) goto L5;
        DynamicConcertStatusChangeEventType r102 = DynamicConcertStatusChangeEventType.onExternalSoundCard;
        JsonObject r103 = new JsonObject();
        r103.addProperty("open", Integer.valueOf(r100 ? 1 : 0));
        Unit r104 = Unit.INSTANCE;
        r101.e(new hd2.b(r102, r103));
    L5:
        com.bytedance.android.live.pushstream.d r105 = k();
        if (r105 == null) goto L11;
        d0 r106 = r105.getLiveCore();
        if (r106 == null) goto L12;
        r106.h();
        return;
    L12:
        return;
    }

    public final void l(boolean r100) {
        this.f143731c.setValue(Boolean.valueOf(r100));
        gd2.f r101 = ConcertStageDataContext.Companion.a();
        if (r101 == null) goto L5;
        DynamicConcertStatusChangeEventType r102 = DynamicConcertStatusChangeEventType.onHeadSetChange;
        JsonObject r103 = new JsonObject();
        r103.addProperty("open", Integer.valueOf(r100 ? 1 : 0));
        Unit r104 = Unit.INSTANCE;
        r101.e(new hd2.b(r102, r103));
    L5:
        w.b("ConcertEarMonitor", "onWiredStateChange: " + r100);
    }

    @Override // gd2.d
    public final void g(boolean r100, boolean r101) {
        b();
        m();
        if (r101 == false) goto L6;
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = com.bytedance.android.livesdk.sharedpref.c.f158275j;
        Boolean r103 = Boolean.valueOf(r100);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        return;
    }
}
