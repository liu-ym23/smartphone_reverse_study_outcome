package com.bytedance.android.live.soloktv.record;

import android.app.Application;
import androidx.camera.video.AudioStats;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.util.KtvCommonConfigParams;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.android.live.soloktv.util.g;
import com.bytedance.android.live.soloktv.util.j;
import com.bytedance.android.livehostapi.foundation.IHostPlugin;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.bytedance.ies.audiorecord.api.BGMProgressListener;
import com.ss.bytedance.ies.audiorecord.api.IAudioRecordEventHandler;
import com.ss.bytedance.ies.audiorecord.api.IAudioRecorderService;
import com.ss.bytedance.ies.audiorecord.api.RecordInputCallback;
import com.ss.bytedance.ies.audiorecord.api.RecordSinkCallback;
import com.ss.bytedance.ies.audiorecord.api.model.AudioStreamFormat;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vm2.h;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001\u0011J\"\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0017J\b\u0010\u000f\u001a\u00020\nH\u0017J\b\u0010\u0010\u001a\u00020\nH\u0017¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/soloktv/record/SoloKtvRecordManager;", "Lcom/ss/bytedance/ies/audiorecord/api/IAudioRecordEventHandler;", "Lcom/ss/bytedance/ies/audiorecord/api/BGMProgressListener;", "Lcom/ss/bytedance/ies/audiorecord/api/RecordSinkCallback;", "Lcom/ss/bytedance/ies/audiorecord/api/RecordInputCallback;", "", "eventKey", "eventCode", "", "msg", "", "onHandleEvent", "", "progress", "onProgress", WidgetCostModule.TYPE_ON_START, "onStop", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SoloKtvRecordManager implements IAudioRecordEventHandler, BGMProgressListener, RecordSinkCallback, RecordInputCallback {
    public static final float H = 0.0f;
    public static final long I = 0;
    public final List<BGMProgressListener> A;
    public boolean B;
    public long C;
    public volatile boolean D;
    public volatile long E;
    public final String F;
    public final fb1.d G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f101426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MutableLiveData<Boolean> f101427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f101428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f101429d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f101430e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CompositeDisposable f101431f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f101432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f101433h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Disposable f101434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<Integer> f101435j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f101436k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f101437l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f101438m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f101439n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f101440o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f101441p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableLiveData<Boolean> f101442q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f101443r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f101444s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f101445t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public long f101446u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public double f101447v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f101448w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f101449x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public CopyOnWriteArrayList<eb1.d> f101450y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final c f101451z;

    public static final class a {
    }

    public final void a() {
        this.f101448w = null;
        this.f101449x = null;
        this.f101446u = 0;
        Iterator<T> r100 = this.A.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((BGMProgressListener) r100.next()).onProgress(0);
        goto L4
    L6:
        CopyOnWriteArrayList<eb1.d> r101 = this.f101450y;
        if (r101 == null) goto L9;
        r101.clear();
    L9:
        this.f101451z.f101453a.b().f().a();
        this.f101451z.f101453a.b().a().a();
    }

    public final MusicPanel c() {
        return (MusicPanel) this.f101438m.getValue();
    }

    public final void j() {
        this.D = true;
        this.f101446u = 0;
        StringBuilder r100 = new StringBuilder("stopBGM ;; music_id == ");
        MusicPanel r101 = c();
        String r102 = null;
        if (r101 == null) goto L7;
        KtvMusic r103 = r101.f153577a;
        if (r103 == null) goto L7;
        Long r104 = Long.valueOf(r103.getMId());
    L8:
        r100.append(r104);
        r100.append(" ;; music_name == ");
        MusicPanel r105 = c();
        if (r105 == null) goto L13;
        KtvMusic r106 = r105.f153577a;
        if (r106 == null) goto L13;
        r102 = r106.getMTitle();
    L13:
        r100.append(r102);
        ALogger.i("solo_ktv_download_opt_tag", r100.toString());
        return;
    L7:
        r104 = null;
        goto L8
    }

    @Override // com.ss.bytedance.ies.audiorecord.api.RecordInputCallback
    public final void onProcess(int r100) {
    }

    @Override // com.ss.bytedance.ies.audiorecord.api.RecordSinkCallback
    public final void onPushAudioBuffer(int r100) {
    }

    static {
        new AudioStreamFormat(48000, 2, 10004, 256000);
        H = 16.666666f;
        I = 2000;
    }

    public final void d() {
        Lazy r100 = KtvCommonConfigParams.f70602a;
        if (h.r().a() == true) goto L5;
        return;
    L5:
        if (this.f101440o == false) goto L11;
        MusicPanel r101 = c();
        if (r101 == null) goto L18;
        KtvMusic r102 = r101.f153577a;
        if (r102 == null) goto L19;
        r102.getMFullTrack();
        return;
    L19:
        return;
    L18:
        return;
    L11:
        MusicPanel r103 = c();
        if (r103 == null) goto L21;
        KtvMusic r104 = r103.f153577a;
        if (r104 == null) goto L22;
        r104.getMAccompanimentTrack();
        return;
    L22:
        return;
    }

    public final void e() {
        d r100 = this.f101430e;
        if (r100 == null) goto L7;
        b r101 = r100.a();
        if (r101 == null) goto L7;
        Integer r102 = r101.b();
    L8:
        if (r102 == null) goto L11;
        r102.intValue();
        return;
    L11:
        return;
    L7:
        r102 = null;
        goto L8
    }

    public final void k() {
        if (Intrinsics.areEqual(this.f101427b.getValue(), Boolean.TRUE) == false) goto L6;
        f(false);
        return;
    }

    public final void m() {
        String r100 = this.f101449x;
        if (r100 != null) goto L5;
        return;
    L5:
        String r101 = this.f101448w;
        if (r101 != null) goto L8;
        return;
    L8:
        Long r102 = this.f101432g;
        if (r102 == null) goto L86;
        long r103 = r102.longValue();
        Disposable r104 = this.f101434i;
        if (r104 != null) goto L13;
    L17:
        long r110 = this.f101446u - r103;
        if (h.c0().a() == true) goto L20;
        int r105 = 0;
    L28:
        eb1.a r111 = new eb1.a(r100, r101, r103, r110, r105);
        int r106 = com.bytedance.android.live.soloktv.util.d.f101601a;
        com.bytedance.android.live.soloktv.util.d.d(r111.c());
        CopyOnWriteArrayList<eb1.a> r107 = this.f101451z.f101453a.b().a().b();
        Intrinsics.checkNotNullParameter(r111, "$this$alignDuration");
        long r210 = com.bytedance.android.live.soloktv.util.d.d(r111.c());
        if (r210 <= r111.b()) goto L31;
        r111 = new eb1.a(r111.d(), r111.c(), r111.e(), r210, r111.a());
    L31:
        r107.add(r111);
        CopyOnWriteArrayList<eb1.d> r108 = this.f101451z.f101453a.b().f().b();
        int r109 = g.f101604a;
        CopyOnWriteArrayList<eb1.d> r112 = this.f101450y;
        if (r108 != null) goto L34;
    L82:
        r108 = r112;
    L83:
        if (r108 == null) goto L85;
        this.f101451z.f101453a.b().f().b().clear();
        this.f101451z.f101453a.b().f().b().addAll(r108);
    L85:
        SoloKtvContext.Companion.getClass();
        SoloKtvContext.a.a().setPlayDurationForLog(SoloKtvContext.a.a().getPlayDurationForLog() + r110);
        goto L86
    L34:
        if (r108.isEmpty() == true) goto L82;
        if (r112 == null) goto L83;
        if (r112.isEmpty() == true) goto L83;
        eb1.d r113 = (eb1.d) CollectionsKt.firstOrNull(r108);
        long r114 = 0;
        if (r113 == null) goto L43;
        long r115 = r113.a();
    L44:
        eb1.d r116 = (eb1.d) CollectionsKt.lastOrNull(r108);
        if (r116 == null) goto L47;
        long r117 = r116.a();
    L48:
        eb1.d r118 = (eb1.d) CollectionsKt.firstOrNull(r112);
        if (r118 == null) goto L51;
        long r119 = r118.a();
    L52:
        eb1.d r120 = (eb1.d) CollectionsKt.lastOrNull(r112);
        if (r120 == null) goto L56;
        r114 = r120.a();
    L56:
        if (r117 > r115) goto L58;
    L76:
        if (r117 > r115) goto L83;
        if (r114 > r119) goto L82;
        r108 = null;
        goto L83
    L58:
        if (r114 <= r119) goto L76;
        if (r119 < r117) goto L63;
        r108.addAll(r112);
        goto L83
    L63:
        if (r119 <= r115) goto L82;
        Iterator<eb1.d> r121 = r108.iterator();
        int r122 = 0;
    L66:
        if (r121.hasNext() == false) goto L74;
        if (r121.next().a() < r119) goto L70;
        boolean r123 = true;
    L71:
        if (r123 == true) goto L75;
        r122 = r122 + 1;
    L75:
        r108 = new CopyOnWriteArrayList(CollectionsKt.plus(r108.subList(0, r122), r112));
        goto L83
    L70:
        r123 = false;
        goto L71
    L74:
        r122 = -1;
        goto L75
    L51:
        r119 = 0;
        goto L52
    L47:
        r117 = 0;
        goto L48
    L43:
        r115 = 0;
        goto L44
    L20:
        if (((ArrayList) this.f101435j).isEmpty() == false) goto L22;
        int r124 = 0;
    L26:
        r105 = r124;
        goto L28
    L22:
        CollectionsKt.sort(this.f101435j);
        int r125 = ((ArrayList) this.f101435j).size();
        if ((r125 % 2) != 1) goto L25;
        r124 = ((Number) ListProtector.get(this.f101435j, (r125 - 1) / 2)).intValue();
        goto L26
    L25:
        int r126 = r125 / 2;
        r124 = (int) ((((double) (((Number) ListProtector.get(this.f101435j, r126 - 1)).intValue() + ((Number) ListProtector.get(this.f101435j, r126)).intValue())) + AudioStats.AUDIO_AMPLITUDE_NONE) / ((double) 2));
        goto L26
    L13:
        if (r104.isDisposed() == true) goto L17;
        Disposable r127 = this.f101434i;
        if (r127 == null) goto L17;
        r127.dispose();
    L86:
        this.f101449x = null;
        this.f101448w = null;
    }

    @Override // com.ss.bytedance.ies.audiorecord.api.BGMProgressListener
    public void onStart() {
        UtilityKotlinExtentionsKt.s(0, false, false, new C99801(this), 7);
    }

    @Override // com.ss.bytedance.ies.audiorecord.api.BGMProgressListener
    public void onStop() {
        UtilityKotlinExtentionsKt.s(0, false, false, new C99811(this), 7);
    }

    public final void l() {
        e();
        this.f101433h = false;
        m();
    }

    public final void b(long r100) {
        this.f101439n = r100;
        this.f101447v = AudioStats.AUDIO_AMPLITUDE_NONE;
        g(this.f101440o, Boolean.FALSE);
        n(this.f101444s);
        d();
        this.D = false;
        this.E = -1;
        j r101 = j.f101607a;
        MusicPanel r102 = c();
        r101.getClass();
        boolean r103 = j.b(r102, true);
        StringBuilder r104 = new StringBuilder("forwardStartBGM ;; enableOrigin == ");
        r104.append(r103);
        r104.append(" ;; progress == ");
        r104.append(this.f101446u);
        r104.append(" ;; music_id == ");
        MusicPanel r105 = c();
        String r106 = null;
        if (r105 == null) goto L7;
        KtvMusic r107 = r105.f153577a;
        if (r107 == null) goto L7;
        Long r108 = Long.valueOf(r107.getMId());
    L8:
        r104.append(r108);
        r104.append(" ;; music_name == ");
        MusicPanel r109 = c();
        if (r109 == null) goto L13;
        KtvMusic r110 = r109.f153577a;
        if (r110 == null) goto L13;
        r106 = r110.getMTitle();
    L13:
        r104.append(r106);
        ALogger.i("solo_ktv_download_opt_tag", r104.toString());
        return;
    L7:
        r108 = null;
        goto L8
    }

    public final void f(boolean r100) {
        if (r100 == false) goto L4;
        e();
    L4:
        ALogger.i("SoloKtvRecordManager", "setEarMonitorEnableInner ;; enable == " + r100);
        this.f101427b.setValue(Boolean.valueOf(r100));
    }

    public final void h(long r100) {
        this.f101447v = AudioStats.AUDIO_AMPLITUDE_NONE;
        g(this.f101440o, Boolean.FALSE);
        n(this.f101444s);
        d();
        this.D = false;
        this.E = -1;
        StringBuilder r101 = new StringBuilder("startBGM ;; progress == ");
        r101.append(this.f101446u);
        r101.append(" ;; music_id == ");
        MusicPanel r102 = c();
        String r103 = null;
        if (r102 == null) goto L7;
        KtvMusic r104 = r102.f153577a;
        if (r104 == null) goto L7;
        Long r105 = Long.valueOf(r104.getMId());
    L8:
        r101.append(r105);
        r101.append(" ;; music_name == ");
        MusicPanel r106 = c();
        if (r106 == null) goto L13;
        KtvMusic r107 = r106.f153577a;
        if (r107 == null) goto L13;
        r103 = r107.getMTitle();
    L13:
        r101.append(r103);
        ALogger.i("solo_ktv_download_opt_tag", r101.toString());
        this.f101439n = r100;
        return;
    L7:
        r105 = null;
        goto L8
    }

    public final void i(long r110) {
        this.f101427b.setValue(com.bytedance.android.livesdk.sharedpref.c.f158278k.getValue());
        p(this.f101443r);
        n(this.f101444s);
        o(this.f101445t);
        d r100 = this.f101430e;
        if (r100 == null) goto L9;
        b r101 = r100.a();
        if (r101 == null) goto L9;
        Integer r102 = r101.b();
        if (r102 == null) goto L9;
        int r103 = r102.intValue();
    L11:
        if (r103 > 0) goto L13;
    L13:
        this.f101432g = Long.valueOf(r110);
        String r111 = this.f101451z.f101453a.a();
        int r112 = com.bytedance.android.live.soloktv.util.d.f101601a;
        Application r113 = jc1.a.b();
        Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "draftId");
        File r114 = r113.getExternalCacheDir();
        if (r114 == null) goto L17;
        String r115 = r114.getAbsolutePath();
        if (r115 == null) goto L17;
    L18:
        String r104 = StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null);
        StringBuilder r105 = new StringBuilder(r115);
        String r116 = File.separator;
        r105.append(r116);
        r105.append("soloktv");
        r105.append(r116);
        r105.append("draft");
        r105.append(r116);
        r105.append(r111);
        r105.append(r116);
        r105.append("record_list");
        String r117 = r105.toString();
        PolarisFileWrapper r106 = new PolarisFileWrapper(r117);
        if (r106.exists() == true) goto L21;
        r106.mkdirs();
    L21:
        String r118 = (r117 + r116) + r104;
        PolarisFileWrapper r119 = new PolarisFileWrapper(r118);
        if (r119.exists() == false) goto L24;
        r119.delete();
    L24:
        r119.createNewFile();
        Pair r120 = new Pair(r104, r118);
        this.f101449x = (String) r120.getFirst();
        this.f101448w = (String) r120.getSecond();
        if (this.f101433h == false) goto L27;
        return;
    L27:
        if (h.c0().d() > 0) goto L29;
    L38:
        this.f101433h = true;
        return;
    L29:
        if (h.c0().a() == false) goto L38;
        Disposable r121 = this.f101434i;
        if (r121 != null) goto L33;
    L37:
        ((ArrayList) this.f101435j).clear();
        this.f101434i = Observable.interval(I, TimeUnit.MILLISECONDS).subscribe(new f(this));
        goto L38
    L33:
        if (r121.isDisposed() == true) goto L37;
        Disposable r122 = this.f101434i;
        if (r122 == null) goto L37;
        r122.dispose();
    L17:
        r115 = "";
    L9:
        r103 = 0;
        goto L11
    }

    public final void n(int r100) {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = com.bytedance.android.livesdk.sharedpref.c.f158282l0;
        Integer r102 = Integer.valueOf(r100);
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        this.f101444s = r100;
        this.f101451z.f101453a.b().q(r100 / 100.0f);
        ((Number) h.f556274y.getValue(null, h.f556082a[23])).floatValue();
    }

    public final void o(int r100) {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = com.bytedance.android.livesdk.sharedpref.c.f158255c0;
        Integer r102 = Integer.valueOf(r100);
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        this.f101445t = r100;
        boolean r103 = this.f101426a;
        this.f101451z.f101453a.b().x(r100 / 100.0f);
    }

    @Override // com.ss.bytedance.ies.audiorecord.api.BGMProgressListener
    public void onProgress(final long r100) {
        UtilityKotlinExtentionsKt.s(0, false, false, new C99791(this, r100), 7);
    }

    public final void p(int r100) {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r101 = com.bytedance.android.livesdk.sharedpref.c.f158270h0;
        Integer r102 = Integer.valueOf(r100);
        r101.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r101, r102);
        this.f101443r = r100;
        if (h.c0().d() <= 0) goto L5;
        Object r103 = h.c0();
    L6:
        r103.getClass();
        return;
    L5:
        r103 = h.M();
        goto L6
    }

    public SoloKtvRecordManager(String r100, fb1.d r101) {
        Intrinsics.checkNotNullParameter(r100, "audioServerConfig");
        Intrinsics.checkNotNullParameter(r101, "sourceCompositionModel");
        this.F = r100;
        this.G = r101;
        this.f101427b = new MutableLiveData();
        com.bytedance.android.livesdk.sharedpref.c.f158278k.getValue().booleanValue();
        this.f101431f = new CompositeDisposable();
        this.f101435j = new ArrayList();
        this.f101438m = LazyKt.lazy(SoloKtvRecordManager$curMusic$2.INSTANCE);
        j r102 = j.f101607a;
        MusicPanel r103 = c();
        r102.getClass();
        boolean r104 = false;
        this.f101440o = j.b(r103, false);
        if (j.i() == false) goto L5;
    L6:
        r104 = true;
    L7:
        this.f101442q = new MutableLiveData(Boolean.valueOf(r104));
        com.bytedance.android.livesdk.sharedpref.e<Integer> r105 = com.bytedance.android.livesdk.sharedpref.c.f158270h0;
        Integer r106 = r105.getValue();
        if (r106 != null) goto L11;
    L12:
        int r107 = r105.getValue().intValue();
    L14:
        this.f101443r = r107;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r108 = com.bytedance.android.livesdk.sharedpref.c.f158282l0;
        Integer r109 = r108.getValue();
        if (r109 != null) goto L18;
    L19:
        int r110 = r108.getValue().intValue();
    L21:
        this.f101444s = r110;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r111 = com.bytedance.android.livesdk.sharedpref.c.f158255c0;
        Integer r112 = r111.getValue();
        if (r112 != null) goto L25;
    L26:
        int r113 = r111.getValue().intValue();
    L28:
        this.f101445t = r113;
        this.A = new ArrayList();
        this.D = true;
        this.E = -1;
        IHostPlugin r114 = (IHostPlugin) k.f(IHostPlugin.class);
        if (r114 == null) goto L31;
        IAudioRecorderService r115 = (IAudioRecorderService) r114.getOrNull(IAudioRecorderService.class);
    L32:
        boolean r116 = ((Boolean) h.B2.getValue(null, h.f556082a[182(0xb6, float:2.55E-43)])).booleanValue();
        if (r115 == null) goto L35;
        r115.getAudioRecorder(r116, jc1.a.b());
    L35:
        int r117 = com.bytedance.android.live.soloktv.util.d.f101601a;
        c r118 = new c(StringsKt.replace$default(UUID.randomUUID().toString(), "-", "", false, 4, null), r101);
        this.f101451z = r118;
        SoloKtvContext.Companion.getClass();
        SoloKtvContext.a.a().setDataStore(r118);
        SoloKtvContext.a.a().setSoloKtvRecordManager(this);
        return;
    L31:
        r115 = null;
        goto L32
    L25:
        if (r112.intValue() != (-1)) goto L26;
        r113 = h.M().d();
        goto L28
    L18:
        if (r109.intValue() != (-1)) goto L19;
        r110 = h.M().h();
        goto L21
    L11:
        if (r106.intValue() != (-1)) goto L12;
        r107 = h.M().i();
        goto L14
    L5:
        if (com.bytedance.android.livesdk.sharedpref.c.U.getValue().booleanValue() == false) goto L7;
        goto L6
    }

    public final void g(boolean r100, Boolean r101) {
        this.f101440o = r100;
        Function1<? super Boolean, Unit> r102 = this.f101441p;
        if (r102 == null) goto L5;
        Unit r103 = r102.invoke(Boolean.valueOf(r100));
    L5:
        this.f101451z.f101453a.b().s(r100);
        Intrinsics.areEqual(r101, Boolean.TRUE);
    }

    @Override // com.ss.bytedance.ies.audiorecord.api.IAudioRecordEventHandler
    public void onHandleEvent(int r100, int r101, String r102) {
        if (r100 != 5201) goto L7;
        UtilityKotlinExtentionsKt.s(0, false, false, new AnonymousClass1(this), 7);
        return;
    }
}
