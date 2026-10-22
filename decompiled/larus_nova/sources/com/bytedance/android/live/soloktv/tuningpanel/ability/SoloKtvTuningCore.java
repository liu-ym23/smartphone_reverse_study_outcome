package com.bytedance.android.live.soloktv.tuningpanel.ability;

import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.m1;
import com.bytedance.android.live.ktv.common.model.bean.h;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningButtonType;
import com.bytedance.android.live.ktv.common.tuningpanel.model.TuningVolumeType;
import com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view.e;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.record.SoloKtvRecordManager;
import com.bytedance.android.live.soloktv.util.j;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.n;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes7.dex */
public final class SoloKtvTuningCore implements com.bytedance.android.live.ktv.common.tuningpanel.ability.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f101547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f101548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f101549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f101550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData<List<h>> f101551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f101552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.android.live.soloktv.tuningpanel.ability.d f101553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f101554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference<Context> f101555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final SoloKtvRecordManager f101556j;

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MutableLiveData<Boolean> f101557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MutableLiveData<Boolean> f101558b;

        public a() {
            this.f101557a = new MutableLiveData();
            this.f101558b = new MutableLiveData();
        }
    }

    public static final class b {
    }

    public interface c {
        void a(int r100, boolean r101);
    }

    public static final class d implements cc0.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SoloKtvTuningCore f101559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f101560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f101561c;

        @Override // cc0.c
        public final void a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "filePath");
            if (this.f101559a.l(false) == false) goto L22;
            ALogger.i("SoloKtvTuningCore", "changeTuningEffect ;; filePath = " + r100);
            if ((!Intrinsics.areEqual(r100, "")) == false) goto L9;
            SoloKtvRecordManager r101 = this.f101559a.f101556j;
            if (r101 == null) goto L12;
            this.f101560b.getClass();
            r101.f101451z.f101453a.b().v(this.f101560b);
            r101.f101451z.f101453a.b().w(r100);
            r101.e();
        L12:
            this.f101559a.f101553g.a(this.f101560b, this.f101561c);
            SoloKtvTuningCore r102 = this.f101559a;
            h r103 = this.f101560b;
            List<h> r104 = r102.f101551e.getValue();
            if (r104 != null) goto L15;
            r104 = new ArrayList();
        L15:
            Iterator<T> r105 = r104.iterator();
        L17:
            if (r105.hasNext() == false) goto L19;
            h r106 = (h) r105.next();
            r106.f69999a = Intrinsics.areEqual(r106.d(), r103.d());
            goto L17
        L19:
            r102.f101551e.setValue(r104);
            return;
        L9:
            SoloKtvRecordManager r107 = this.f101559a.f101556j;
            if (r107 == null) goto L12;
            r107.e();
            goto L12
        }

        public d(SoloKtvTuningCore r100, h r101, boolean r102) {
            this.f101559a = r100;
            this.f101560b = r101;
            this.f101561c = r102;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final int D() {
        return 0;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void E() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void L() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final int M() {
        return 100;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean O() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void P() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final int U() {
        return 100;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final float V() {
        return 0.0f;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final float X() {
        return 0.0f;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean Z() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void b0() {
        if (l(false) == true) goto L5;
        B(false);
        return;
    L5:
        z(this.f101551e.getValue());
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void c() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void e0(float r100) {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void f0() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean isInRealTimeChorus() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void j(float r100) {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean n() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void onPageCreate() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void onPageResume() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void onPageStop() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean p() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean r() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void s() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final int u() {
        return 0;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean v() {
        return false;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void y() {
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final float A() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 != null) goto L7;
        return 30.0f;
    L7:
        return r100.f101444s;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void C() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 == null) goto L6;
        r100.k();
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final MutableLiveData<Boolean> F() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f101427b;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final Boolean I() {
        return this.f101548b.f101557a.getValue();
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean R() {
        j r100 = j.f101607a;
        MusicPanel r101 = (MusicPanel) this.f101549c.getValue();
        r100.getClass();
        return j.a(r101);
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean a() {
        if (this.f101556j != null) goto L7;
        return false;
    L7:
        return com.bytedance.android.livesdk.sharedpref.c.f158278k.getValue().booleanValue();
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void b() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 == null) goto L6;
        r100.e();
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final float e() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 != null) goto L7;
        return 100.0f;
    L7:
        return r100.f101443r;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final float f() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 != null) goto L7;
        return 50.0f;
    L7:
        return r100.f101445t;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void i() {
        SoloKtvRecordManager r100 = this.f101556j;
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.f101426a != true) goto L7;
    L8:
        if (r101 == false) goto L11;
        b();
        return;
    L11:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void o() {
        com.bytedance.android.live.soloktv.tuningpanel.ability.d r100 = this.f101553g;
        ((CompositeDisposable) r100.f70506d.getValue()).clear();
        DownloadTask r101 = r100.f70507e;
        if (r101 == null) goto L6;
        r101.mainThreadListener(null);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final int N() {
        return vm2.h.M().f();
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void clearData() {
        C();
        o();
        this.f101552f.clear();
        ALogger.i("SoloKtvTuningCore", "onDestroy ;; hashCode == " + hashCode());
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean h() {
        if (m1.b() == false) goto L5;
    L10:
        boolean r100 = true;
    L11:
        boolean r101 = new PolarisFileWrapper("/my_product/etc/permissions/oplus.product.feature_ktv.xml").exists();
        Context r102 = this.f101555i.get();
        if (r102 == null) goto L18;
        PackageManager r103 = r102.getPackageManager();
        if (r103 == null) goto L18;
        if (r103.hasSystemFeature("oplus.software.audio.karaoke_v2.support") != true) goto L18;
        boolean r104 = true;
    L19:
        Context r105 = this.f101555i.get();
        String r106 = null;
        if (r105 == null) goto L22;
        Object r107 = r105.getSystemService("audio");
    L24:
        if ((r107 instanceof AudioManager) == true) goto L26;
        r107 = null;
    L26:
        AudioManager r108 = (AudioManager) r107;
        if (r108 == null) goto L29;
        r106 = r108.getParameters("OPLUS_AUDIO_GET_KARAOKE_V2_SUPPORT");
    L29:
        boolean r109 = Intrinsics.areEqual(r106, "true");
        if (r104 == true) goto L35;
        if (r109 == true) goto L35;
        if (r101 == true) goto L35;
        boolean r110 = false;
    L36:
        ALogger.i("SoloKtvTuningCore", "isOppoDevice == " + r100 + " ;; isSupportOppoEcho = " + r110 + " ;; hasEchoModeFeature == " + r104 + " ;; hasOppoKaraokeV2Support == " + r109 + " ;; isOppoEchoFileExists == " + r101);
        if (r100 == false) goto L43;
        if (r110 == true) goto L40;
        return false;
    L40:
        if (this.f101547a == false) goto L45;
        return true;
    L45:
        return false;
    L43:
        return false;
    L35:
        r110 = true;
        goto L36
    L22:
        r107 = null;
    L18:
        r104 = false;
        goto L19
    L5:
        if (m1.a() == true) goto L10;
        if (m1.c() == true) goto L10;
        r100 = false;
        goto L11
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final int w() {
        return vm2.h.M().g();
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void B(boolean r100) {
        ALogger.i("SoloKtvTuningCore", "closeTuningEffect");
        SoloKtvRecordManager r101 = this.f101556j;
        if (r101 == null) goto L6;
        r101.e();
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void G(float r100) {
        SoloKtvRecordManager r101 = this.f101556j;
        if (r101 == null) goto L6;
        r101.n((int) r100);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void K(boolean r100) {
        this.f101548b.f101557a.setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void S(boolean r100) {
        q(r100, false);
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void Y(boolean r100) {
        SoloKtvRecordManager r101 = this.f101556j;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.f101428c == false) goto L8;
        r101.f101429d = Boolean.valueOf(r100);
    L8:
        if (r101.f101426a == false) goto L10;
        r101.f(r100);
        return;
    L10:
        r101.f101427b.setValue(Boolean.valueOf(r100));
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void c0(double r100) {
        SoloKtvRecordManager r101 = this.f101556j;
        if (r101 == null) goto L6;
        double r102 = r101.f101447v + r100;
        r101.f101447v = r102;
        r101.f101447v = RangesKt.coerceAtMost(r102, 4.0d);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final boolean d(TuningVolumeType r100) {
        Intrinsics.checkNotNullParameter(r100, "volumeType");
        Intrinsics.checkNotNullParameter(r100, "volumeType");
        return true;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void g(float r100) {
        SoloKtvRecordManager r101 = this.f101556j;
        if (r101 == null) goto L6;
        r101.o((int) r100);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void g0(double r100) {
        SoloKtvRecordManager r101 = this.f101556j;
        if (r101 == null) goto L6;
        double r102 = r101.f101447v - r100;
        r101.f101447v = r102;
        r101.f101447v = RangesKt.coerceAtLeast(r102, -4.0d);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void k(boolean r100) {
        if ((!Intrinsics.areEqual(this.f101548b.f101557a.getValue(), Boolean.TRUE)) == false) goto L7;
        if (r100 == false) goto L9;
        f2.b(R.string.ttlive_ktv_tuning_effect_disable_no_wired, 0);
        return;
    L9:
        return;
    L7:
        i();
    }

    public final boolean l(boolean r100) {
        ALogger.i("SoloKtvTuningCore", "isTuningEffectAvailable ;; wiredState == " + this.f101548b.f101557a.getValue());
        if (KtvSettingHelper.g().c() == true) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == true) goto L12;
        if (r100 == false) goto L11;
        f2.b(R.string.ttlive_ktv_tuning_effect_disable_no_wired, 0);
    L11:
        return false;
    L12:
        return true;
    L5:
        if (Intrinsics.areEqual(this.f101548b.f101557a.getValue(), Boolean.TRUE) == false) goto L7;
        r101 = true;
        goto L8
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void setTuningEffect(String r100) {
        Intrinsics.checkNotNullParameter(r100, "effectName");
        Intrinsics.checkNotNullParameter(r100, "effectName");
    }

    public final void z(List<h> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if ((!r100.isEmpty()) != true) goto L10;
        h r101 = this.f101553g.c();
        if (r101 == null) goto L11;
        Q(r101, false);
        return;
    L11:
        return;
    }

    public SoloKtvTuningCore(WeakReference<Context> r100, SoloKtvRecordManager r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f101555i = r100;
        this.f101556j = r101;
        this.f101547a = ((Boolean) vm2.h.L0.getValue(null, vm2.h.f556082a[88])).booleanValue();
        this.f101548b = new a();
        this.f101549c = LazyKt.lazy(SoloKtvTuningCore$curMusic$2.INSTANCE);
        this.f101551e = new MutableLiveData();
        this.f101552f = new CompositeDisposable();
        this.f101553g = new com.bytedance.android.live.soloktv.tuningpanel.ability.d();
        this.f101554h = LazyKt.lazy(new SoloKtvTuningCore$loadTuningEffectCallback$2(this));
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void Q(h r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "targetEffect");
        if (l(r111) == true) goto L5;
        return;
    L5:
        ya1.a r100 = ya1.a.f567014a;
        String r101 = r110.d();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "name");
        if (r111 == false) goto L22;
        SoloKtvContext.Companion.getClass();
        n<MusicPanel> r102 = SoloKtvContext.a.a().getCurMusicPanel();
        if (r102 == null) goto L22;
        MusicPanel r103 = r102.getValue();
        if (r103 == null) goto L22;
        cb1.a r104 = cb1.a.f22994a;
        long r105 = r103.f153577a.getMId();
        String r106 = r103.f153577a.getMTitle();
        if (r106 != null) goto L14;
        r106 = "";
    L14:
        String r107 = r103.f153577a.getMAuthor();
        if (r107 != null) goto L17;
        r107 = "";
    L17:
        String r108 = r103.f153580d;
        String r109 = SoloKtvContext.a.a().getFromSource();
        if (r109 != null) goto L20;
        String r112 = "";
    L21:
        String r113 = r106;
        cb1.a.F(r105, r113, r107, r108, r112, "solo_ktv", r110.e());
        goto L22
    L20:
        r112 = r109;
    L22:
        this.f101553g.b(r110, new d(this, r110, r111));
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void a0(LifecycleOwner r100, Observer<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f101548b.f101558b.observe(r100, r101);
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void q(boolean r100, boolean r101) {
        if (r100 != R()) goto L5;
        return;
    L5:
        c r102 = this.f101550d;
        if (r102 == null) goto L9;
        r102.a(TuningButtonType.ORIGIN_ITEM.getValue(), r100);
        return;
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void t(LifecycleOwner r100, Observer<Boolean> r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f101548b.f101557a.observe(r100, r101);
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void x(LifecycleOwner r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        Intrinsics.checkNotNullParameter(r101, "observer");
        this.f101551e.observe(r100, r101);
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void H(boolean r100, String r101, Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "callback");
    }

    @Override // com.bytedance.android.live.ktv.common.tuningpanel.ability.a
    public final void m(float r100, boolean r101, boolean r102) {
        SoloKtvRecordManager r103 = this.f101556j;
        if (r103 == null) goto L6;
        r103.p((int) r100);
        return;
    }
}
