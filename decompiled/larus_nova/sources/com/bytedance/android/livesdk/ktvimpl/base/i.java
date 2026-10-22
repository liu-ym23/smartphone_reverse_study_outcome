package com.bytedance.android.livesdk.ktvimpl.base;

import android.os.SystemClock;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceBusiness;
import com.bytedance.android.live.liveinteract.api.trace.MultiTraceData$TraceEvent;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.realtimechorus.RealTimeChorusBusinessContext;
import com.bytedance.android.livesdk.message.model.AudioInfo;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.OrderInfo;
import com.bytedance.android.livesdk.message.model.b8;
import com.bytedance.android.livesdk.utils.MultiLinkSettingHelper;
import com.bytedance.android.livesdk.utils.z0;
import com.larus.nova.R;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes10.dex */
public final class i {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Map<Integer, String> f142515t = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f142516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f142517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f142518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CompositeDisposable f142519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f142520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MusicPanel f142521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PublishSubject<fd2.a> f142522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Long f142523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Long f142524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f142525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final KtvContext f142526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Disposable f142527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f142528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f142529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f142530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public SetBgmFunctionType f142531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f142532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f142533r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final oe2.b f142534s;

    public static final class a {
    }

    public static final class b {
    }

    static {
        f142515t = MapsKt.mapOf(new Pair[]{TuplesKt.to(-4, "FF_DECODE_STREAM_ERROR_FORMAT_INVALID"), TuplesKt.to(-5, "FF_DECODE_STREAM_ERROR_OPEN_FILE_FAILED"), TuplesKt.to(-6, "FF_DECODE_STREAM_ERROR_DECODE_ERROR"), TuplesKt.to(-7, "FF_DECODE_STREAM_ERROR_READ_PACKET_ERROR")});
    }

    public static void m() {
        KtvContext.Companion.getClass();
        if (KtvContext.a.g().getHasBgm().getValue().booleanValue() == false) goto L6;
        KtvContext.a.g().getHasBgm().setValue(Boolean.FALSE);
        return;
    }

    public final void a() {
        Disposable r100 = this.f142527l;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        r100.dispose();
        return;
    }

    public final void d() {
        oe2.b r100 = this.f142534s;
        if (r100 == null) goto L7;
        com.bytedance.android.live.pushstream.d r101 = r100.h(com.bytedance.android.live.ktv.common.util.j.i());
        if (r101 == null) goto L7;
        r101.u();
    L7:
        com.bytedance.android.live.pushstream.d r102 = this.f142533r;
        if (r102 == null) goto L11;
        r102.u();
        return;
    }

    public final Long e() {
        if (this.f142521f != null) goto L5;
        return null;
    L5:
        long r100 = 0;
        if (this.f142532q != 0) goto L9;
        return this.f142523h;
    L9:
        if (this.f142528m == false) goto L12;
        return this.f142523h;
    L12:
        if (MultiLinkSettingHelper.a() == true) goto L14;
    L16:
        Long r101 = this.f142523h;
        if (r101 == null) goto L20;
        r100 = r101.longValue();
    L20:
        return Long.valueOf((r100 + SystemClock.elapsedRealtime()) - this.f142532q);
    L14:
        if ((SystemClock.elapsedRealtime() - this.f142532q) <= (this.f142520e + 20)) goto L16;
        return this.f142523h;
    }

    public final Long f() {
        if (this.f142521f != null) goto L6;
        return null;
    L6:
        return this.f142524i;
    }

    public final Long h() {
        if (this.f142521f != null) goto L6;
        return 0L;
    L6:
        return this.f142525j;
    }

    public final void j() {
        this.f142519d.clear();
    }

    public final void u() {
        boolean r100 = !this.f142528m;
        this.f142528m = r100;
        if (r100 == false) goto L7;
        d();
        if (vm2.h.d() == false) goto L11;
        d();
        return;
    L11:
        return;
    L7:
        d();
        if (vm2.h.d() == false) goto L13;
        d();
        return;
    }

    public final long b() {
        Long r100 = e();
        Long r101 = h();
        if (r100 == null) goto L6;
        if (r101 == null) goto L6;
        long r102 = r101.longValue();
        Long r103 = Long.valueOf(r100.longValue() - r102);
    L7:
        if (r103 != null) goto L11;
        return 0;
    L11:
        return r103.longValue();
    L6:
        r103 = null;
        goto L7
    }

    public final float c() {
        Long r100 = f();
        if (r100 != null) goto L5;
    L13:
        return 0.0f;
    L5:
        if (r100.longValue() <= 0) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        return b() / r100.longValue();
    L7:
        r101 = false;
        goto L8
    }

    public final void l() {
        m();
        if (this.f142521f == null) goto L5;
        r(null);
    L5:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = KSongTuningPanelHelperKt.d();
        if (r100 == null) goto L8;
        r100.B(false);
    L8:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r101 = KSongTuningPanelHelperKt.d();
        if (r101 == null) goto L12;
        r101.f0();
    L12:
        if (vm2.h.l() == false) goto L14;
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
    L14:
        d();
        d();
        a();
    }

    public final void s() {
        ALogger.i(bb0.b.b(), "stop, invoke class :".concat(i.class.getSimpleName()));
        this.f142528m = true;
        d();
        if (vm2.h.d() == false) goto L5;
        d();
    L5:
        r(null);
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
        d();
        d();
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r100 = KSongTuningPanelHelperKt.d();
        if (r100 == null) goto L8;
        r100.C();
    L8:
        a();
        if (((Boolean) KtvSettingHelper.f70609b1.getValue()).booleanValue() == false) goto L12;
        m();
        return;
    }

    public final void g(double[] r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
        d();     // Catch: Exception -> L7
        if (r100.length < 21) goto L12;
        KtvContext.Companion.getClass();     // Catch: Exception -> L7
        KtvContext r101 = KtvContext.a.g();     // Catch: Exception -> L7
        com.bytedance.live.datacontext.m<p> r102 = r101.getRealTimeInfoModel();     // Catch: Exception -> L7
        p r103 = r101.getRealTimeInfoModel().getValue();     // Catch: Exception -> L7
        r103.a(r100);     // Catch: Exception -> L7
        r102.setValue(r103);     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        ALogger.e("KtvCoreController", "getScoreInfo error", e);
    }

    public final boolean i(long r100) {
        long r101 = 0;
        if (r100 < 0) goto L15;
        Long r102 = f();
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L8:
        Long r104 = h();
        if (r104 == null) goto L12;
        r101 = r104.longValue();
    L12:
        if (r100 > (r103 + r101)) goto L17;
        return true;
    L17:
        return false;
    L7:
        r103 = 0;
        goto L8
    L15:
        return false;
    }

    public final void k(Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r100) {
        if (r100.isEmpty() == false) goto L7;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; map is empty");
        return;
    L7:
        if (this.f142516a == false) goto L10;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; hasSetBGMMusicWithAllResource");
        KtvContext.Companion.getClass();
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(new LinkedHashMap());
        return;
    L10:
        com.bytedance.android.live.ktv.common.model.bean.f r101 = r100.get(KtvUtilsKt.c(this.f142521f));
        if (r101 != null) goto L14;
        return;
    L14:
        if (r101.f69997a == DownloadResourceType.OTHER_RESOURCE) goto L16;
        return;
    L16:
        if (r101.f69998b == false) goto L18;
        return;
    L18:
        if (this.f142521f != null) goto L20;
    L29:
        StringBuilder r102 = new StringBuilder("setBGMMusicIfNeed ;; curMusicPanel == ");
        r102.append(this.f142521f);
        r102.append(" ;; curProgress== ");
        r102.append(e());
        r102.append(" ;; isSupportOriginSwitchWithPath == ");
        MusicPanel r103 = this.f142521f;
        if (r103 == null) goto L32;
        Boolean r104 = Boolean.valueOf(com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r103));
    L33:
        r102.append(r104);
        r102.append(" ;; ");
        r102.append(r101);
        ALogger.i("ktv_music_resource_download_opt_tag", r102.toString());
        return;
    L32:
        r104 = null;
        goto L33
    L20:
        if (e() == null) goto L29;
        MusicPanel r105 = this.f142521f;
        Intrinsics.checkNotNull(r105);
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r105) == false) goto L29;
        if (this.f142517b == true) goto L26;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithMainResource ;; " + r101);
        MusicPanel r106 = this.f142521f;
        Intrinsics.checkNotNull(r106);
        q(r106);
    L26:
        MusicPanel r107 = this.f142521f;
        Intrinsics.checkNotNull(r107);
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r107) == false) goto L37;
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithAllResource ;; " + r101);
        KtvContext.Companion.getClass();
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(new LinkedHashMap());
        MusicPanel r108 = this.f142521f;
        Intrinsics.checkNotNull(r108);
        Long r109 = e();
        Intrinsics.checkNotNull(r109);
        p(r108, r109.longValue(), this.f142518c);
        return;
    }

    public final void n(long r100) {
        if (i(r100) == true) goto L8;
        ALogger.i("KtvCoreController", "seekLyricPos: progress is invalid, progress: " + r100 + ", durationMs: " + f());
        if (KtvSettingHelper.y() == false) goto L8;
        return;
    L8:
        if (vm2.h.d() == false) goto L10;
        d();
        return;
    L10:
        d();
    }

    public final void q(MusicPanel r100) {
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicWithMainResource ;; song_id == " + r100.f153577a.getMId());
        this.f142517b = true;
        Lazy r101 = com.bytedance.android.live.ktv.common.util.KtvUtilsKt.f70681a;
        Intrinsics.checkNotNullParameter(r100, "$this$isRealOriginFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r100.f153590n) == false) goto L5;
        d();
        boolean r102 = true;
    L12:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r103 = KSongTuningPanelHelperKt.d();
        if (r103 == null) goto L16;
        r103.q(r102, true);
        return;
    L16:
        return;
    L5:
        Intrinsics.checkNotNullParameter(r100, "$this$isRealAccompanimentFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r100.f153591o) == false) goto L8;
        d();
    L11:
        r102 = false;
        goto L12
    L8:
        int r104 = mb0.f.f512760a;
        mb0.f.o(r100);
        ALogger.i("ktv_music_resource_download_opt_tag", "music file path not exists ");
        if (((Boolean) vm2.h.f556084a1.getValue(null, vm2.h.f556082a[103(0x67, float:1.44E-43)])).booleanValue() == false) goto L11;
        t("music_path_not_exist_source");
        goto L11
    }

    public final void r(MusicPanel r100) {
        this.f142521f = r100;
        ec0.a r101 = KSongTuningPanelHelperKt.e();
        if (r101 == null) goto L5;
        r101.m(this.f142521f);
    L5:
        KtvContext.Companion.getClass();
        com.bytedance.live.datacontext.n<KtvMusic> r102 = KtvContext.a.g().getCurrentSongOfSelf();
        if (r100 == null) goto L8;
        KtvMusic r103 = r100.f153577a;
    L9:
        r102.setValue(r103);
        return;
    L8:
        r103 = null;
        goto L9
    }

    public final void t(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if (this.f142529n == true) goto L33;
        Long r101 = null;
        if (((Boolean) vm2.h.f556100c1.getValue(null, vm2.h.f556082a[105(0x69, float:1.47E-43)])).booleanValue() == true) goto L7;
    L9:
        this.f142523h = null;
        this.f142529n = true;
        ALogger.i(bb0.b.b(), "on stop bgm, invoke class :".concat(i.class.getSimpleName()));
        this.f142522g.onNext(fd2.a.d.f476461a);
        MusicPanel r102 = this.f142521f;
        if (r102 == null) goto L27;
        pd2.d r103 = pd2.d.f528658n;
        String r104 = this.f142531p.name();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r102, "musicPanel");
        Intrinsics.checkNotNullParameter(r104, "funcType");
        JSONObject r105 = new JSONObject();
        KtvMusic r106 = r102.f153577a;
        if (r106 == null) goto L14;
        r101 = Long.valueOf(r106.getMId());
    L14:
        JSONObject r107 = mb0.b.p(r105, r101.longValue());
        KtvMusic r108 = r102.f153577a;
        String r109 = "";
        if (r108 == null) goto L18;
        String r110 = r108.getMTitle();
        if (r110 == null) goto L18;
    L19:
        JSONObject r111 = mb0.b.q(r107, r110);
        List<String> r112 = r102.f153577a.getMLyricUrlList();
        if (r112 == null) goto L25;
        String r113 = (String) CollectionsKt.firstOrNull(r112);
        if (r113 == null) goto L25;
        r109 = r113;
    L25:
        JSONObject r114 = mb0.b.o(r111, r109);
        BaseMonitor.add(r114, "function_type", r104);
        pd2.d.w(LinkMonitorData.BusinessPlayerStopCalled, r114);
    L18:
        r110 = "";
    L27:
        if (Intrinsics.areEqual(r100, "live_core_stop_music_callback_source") == false) goto L29;
        ALogger.i("logKtvMainPath", "livecore stop, invoke class :".concat(i.class.getSimpleName()));
        int r115 = mb0.f.f512760a;
        mb0.f.d(this.f142521f);
    L29:
        this.f142523h = 0L;
        a();
        if (((Boolean) KtvSettingHelper.f70609b1.getValue()).booleanValue() == false) goto L34;
        m();
        return;
    L34:
        return;
    L7:
        if (this.f142530o == false) goto L9;
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
        goto L9
    }

    public i(com.bytedance.android.live.pushstream.d r100, oe2.b r101) {
        this.f142533r = r100;
        this.f142534s = r101;
        CompositeDisposable r102 = new CompositeDisposable();
        this.f142519d = r102;
        int r103 = ge2.a.f481015a;
        float r104 = z0.b(true);
        boolean r105 = false;
        if (r104 > 0) goto L5;
    L7:
        if (r105 == false) goto L9;
        int r106 = ((Number) KtvSettingHelper.T0.getValue()).intValue();
    L17:
        this.f142520e = r106;
        ALogger.i("logKtvMainPath", "init ktv core controller, invoke class :".concat(i.class.getSimpleName()));
        d();
        LinkMonitorData r107 = LinkMonitorData.BusinessAudioFilterManagerNull;
        boolean r108 = pd2.d.f528646b;
        pd2.d.w(r107, new JSONObject());
        KtvContext.Companion.getClass();
        k(KtvContext.a.g().getMusicDownloadResourceMap().getValue());
        Disposable r109 = KtvContext.a.g().getMusicDownloadResourceMap().a().subscribe(new k(this));
        if (r109 == null) goto L20;
        RxUtilKt.c(r109, r102);
    L20:
        this.f142522g = PublishSubject.create();
        this.f142526k = KtvContext.a.g();
        this.f142528m = true;
        this.f142531p = SetBgmFunctionType.KSONG;
        return;
    L9:
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L14;
        if (vm2.h.a0() == false) goto L14;
    L15:
        r106 = ((Number) KtvSettingHelper.S0.getValue()).intValue();
    L14:
        if (KtvContext.a.j() == true) goto L15;
        r106 = ((Number) KtvSettingHelper.T0.getValue()).intValue();
        goto L17
    L5:
        if (r104 >= ((Number) vm2.h.f556102c3.getValue(null, vm2.h.f556082a[209(0xd1, float:2.93E-43)])).floatValue()) goto L7;
        r105 = true;
        goto L7
    }

    public final void p(MusicPanel r100, long r101, int r102) {
        ALogger.i("ktv_music_resource_download_opt_tag", "setBGMMusicWithAllResource ;; song_id == " + r100.f153577a.getMId() + " startTime " + r101);
        this.f142516a = true;
        long r103 = r100.c();
        int r104 = j.f142535a[r100.h().ordinal()];
        boolean r105 = false;
        if (r104 != 1) goto L5;
        d();
        if (r102 == 0) goto L22;
        if (r102 != 1) goto L22;
        r105 = true;
    L22:
        pd2.d.L(pd2.d.f528658n, r103, "set_bgm");
    L23:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r106 = KSongTuningPanelHelperKt.d();
        if (r106 == null) goto L27;
        r106.q(r105, true);
        return;
    L27:
        return;
    L5:
        if (r104 != 2) goto L7;
        d();
        pd2.d.L(pd2.d.f528658n, r103, "set_bgm");
        r105 = true;
        goto L23
    L7:
        if (r104 != 3) goto L9;
        d();
        pd2.d.L(pd2.d.f528658n, r103, "set_bgm");
        goto L23
    L9:
        if (r104 != 4) goto L23;
        if (((Boolean) vm2.h.f556084a1.getValue(null, vm2.h.f556082a[103(0x67, float:1.44E-43)])).booleanValue() == false) goto L14;
        t("music_path_not_exist_source");
    L15:
        f2.c(s1.B(R.string.ttlive_ktv_file_break_down), 0);
        pd2.d.v(LinkMonitorData.BusinessSetBgmFailed, MapsKt.mapOf(TuplesKt.to("reason", "both of origin and accompaniment are empty")));
        int r107 = mb0.f.f512760a;
        mb0.f.p(r100, "both of origin and accompaniment are empty");
        ALogger.i("KtvCoreController", "both of origin and accompaniment are empty.");
        pd2.d.L(pd2.d.f528658n, r103, "error");
        goto L23
    L14:
        s();
        goto L15
    }

    public final void o(MusicPanel r210, SetBgmFunctionType r211, int r212, long r213, Long r310, boolean r311) {
        Intrinsics.checkNotNullParameter(r210, "panel");
        Intrinsics.checkNotNullParameter(r211, "functionType");
        if (r213 != 0) goto L5;
        KtvMusic.a r100 = KtvMusic.Companion;
        KtvMusic r101 = r210.f153577a;
        r100.getClass();
        long r102 = KtvMusic.a.c(r101);
    L6:
        if (r310 != null) goto L8;
        KtvMusic.a r103 = KtvMusic.Companion;
        KtvMusic r104 = r210.f153577a;
        r103.getClass();
        long r105 = KtvMusic.a.a(r104);
    L9:
        Pair r110 = new Pair(Long.valueOf(r102), Long.valueOf(r105));
        long r106 = ((Number) r110.component1()).longValue();
        long r107 = ((Number) r110.component2()).longValue();
        StringBuilder r111 = new StringBuilder("setBGMMusic ;; track_name == ");
        r111.append(r210.h().name());
        r111.append(" kSongTuningCore == null :");
        if (KSongTuningPanelHelperKt.d() != null) goto L12;
        boolean r112 = true;
    L13:
        r111.append(r112);
        String r113 = r111.toString();
        ALogger.i(bb0.b.b(), "KtvCoreController :" + r113 + ", invoke class :" + i.class.getSimpleName());
        d();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getEchoStateCheckEvent().post(new Object());
        KtvContext.a.g().getHasBgm().setValue(Boolean.TRUE);
        pd2.d r114 = pd2.d.f528658n;
        String r115 = r211.name();
        r114.getClass();
        Intrinsics.checkNotNullParameter(r210, "musicPanel");
        Intrinsics.checkNotNullParameter(r115, "funcType");
        JSONObject r108 = new JSONObject();
        KtvMusic r109 = r210.f153577a;
        String r116 = null;
        if (r109 == null) goto L16;
        Long r117 = Long.valueOf(r109.getMId());
    L17:
        JSONObject r118 = mb0.b.p(r108, r117.longValue());
        KtvMusic r119 = r210.f153577a;
        String r120 = "";
        if (r119 == null) goto L21;
        String r121 = r119.getMTitle();
        if (r121 == null) goto L21;
    L22:
        JSONObject r122 = mb0.b.q(r118, r121);
        List<String> r123 = r210.f153577a.getMLyricUrlList();
        if (r123 == null) goto L26;
        String r124 = (String) CollectionsKt.firstOrNull(r123);
        if (r124 == null) goto L26;
    L27:
        JSONObject r125 = mb0.b.o(r122, r124);
        BaseMonitor.add(r125, "full_track_local_path", r210.f153590n);
        AudioInfo r126 = r210.f153577a.getMFullTrack();
        if (r126 == null) goto L31;
        String r127 = r126.getMUrl();
        if (r127 == null) goto L31;
    L32:
        BaseMonitor.add(r125, "full_track_url", r127);
        BaseMonitor.add(r125, "accompaniment_track_local_path", r210.f153591o);
        AudioInfo r128 = r210.f153577a.getMAccompanimentTrack();
        if (r128 == null) goto L38;
        String r129 = r128.getMUrl();
        if (r129 == null) goto L38;
        r120 = r129;
    L38:
        BaseMonitor.add(r125, "accompaniment_track_url", r120);
        BaseMonitor.add(r125, "lyrics_local_path", r210.f153588l);
        BaseMonitor.add(r125, "midi_local_path", r210.f153593q);
        BaseMonitor.add(r125, "midi_url", r210.f153577a.getMidiUrl());
        BaseMonitor.add(r125, "function_type", r115);
        pd2.d.w(LinkMonitorData.BusinessPlayMusicSetBgmMusic, r125);
        int r130 = mb0.f.f512760a;
        String r131 = r211.name();
        d();
        Intrinsics.checkNotNullParameter(r210, "musicPanel");
        Intrinsics.checkNotNullParameter(r131, "funcType");
        JSONObject r132 = new JSONObject();
        mb0.f.b(r210, r132);
        r132.put(GXTemplateKey.GAIAX_TRACK, r210.h());
        r132.put("track_mode", r212);
        r132.put("function_type", r131);
        r132.put("AudioFilterIsNull", true);
        int r133 = rd0.a.f537202a;
        rd0.a.b(MultiTraceData$TraceBusiness.KTV, MultiTraceData$TraceEvent.MusicPlayFlow, "setBgmMusic", 0, null, r132, 88);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r134 = KSongTuningPanelHelperKt.d();
        if (r134 == null) goto L41;
        r134.s();
    L41:
        this.f142532q = 0;
        if (r311 == false) goto L44;
        d();
    L45:
        r(r210);
        this.f142518c = r212;
        this.f142529n = false;
        this.f142530o = false;
        this.f142531p = r211;
        this.f142525j = Long.valueOf(r106);
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r135 = KSongTuningPanelHelperKt.d();
        if ((r135 instanceof com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) == true) goto L48;
        r135 = null;
    L48:
        com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a r136 = (com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.ability.a) r135;
        if (r136 == null) goto L51;
        r136.l(System.currentTimeMillis());
    L51:
        this.f142523h = Long.valueOf(r106);
        String r137 = "setBGMMusic,track:" + r210.h();
        JSONObject r138 = new JSONObject();
        r138.put("extra", r137);
        r138.put("fullTrackLocalPath", r210.f153590n);
        r138.put("accompanimentTrackLocalPath", r210.f153591o);
        r138.put("lrcLocalPath", r210.f153588l);
        r138.put("midiLocalPath", r210.f153593q);
        r138.put("state", r210.f153578b);
        r138.put(NativeDownloadModel.JsonKey.ID, r210.f153577a.getMId());
        r138.put("mTitle", r210.f153577a.getMTitle());
        OrderInfo r139 = r210.f153577a.getOrderInfo();
        if (r139 == null) goto L56;
        Intrinsics.checkNotNullParameter(r139, "$this$topUserFlex");
        b8 r140 = r139.getTopUser();
        if (r140 == null) goto L56;
        r116 = r140.getNickNameFlex();
    L56:
        r138.put("to_nickName", r116);
        r138.put("source", r210.f153582f);
        ALogger.i(bb0.b.b(), r138.toString());
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r141 = KSongTuningPanelHelperKt.d();
        if (r141 == null) goto L59;
        r141.f0();
    L59:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r142 = KSongTuningPanelHelperKt.d();
        float r143 = 0.0f;
        if (r142 == null) goto L66;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r144 = KSongTuningPanelHelperKt.d();
        if (r144 == null) goto L64;
        float r145 = r144.e();
    L65:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a.C1143a.b(r142, r145, 4);
        goto L66
    L64:
        r145 = 0.0f;
    L66:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r146 = KSongTuningPanelHelperKt.d();
        if (r146 == null) goto L73;
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r147 = KSongTuningPanelHelperKt.d();
        if (r147 == null) goto L71;
        r143 = r147.A();
    L71:
        r146.G(r143);
    L73:
        if (vm2.h.d() == false) goto L75;
        d();
    L78:
        StringBuilder r148 = new StringBuilder("setBGMMusic trackMode null ;; ");
        d();
        r148.append(this.f142533r);
        String r149 = r148.toString();
        ALogger.i(bb0.b.b(), "KtvCoreController :" + r149 + ", invoke class :" + i.class.getSimpleName());
        ALogger.i("KtvCoreController", "resetBGMMusic");
        d();
        this.f142516a = false;
        this.f142517b = false;
        q(r210);
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r210) == false) goto L81;
        p(r210, r106, r212);
    L81:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r150 = KSongTuningPanelHelperKt.d();
        if (r150 == null) goto L84;
        r150.E();
    L84:
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r151 = KSongTuningPanelHelperKt.d();
        if (r151 == null) goto L88;
        r151.c();
    L88:
        if (this.f142528m == false) goto L90;
        u();
    L90:
        long r152 = (long) 1000.0f;
        Long r153 = Long.valueOf(r107 * r152);
        long r154 = r210.f153577a.getMDuration() * r152;
        d();
        if (r153 == null) goto L93;
        r154 = r153.longValue();
    L93:
        this.f142524i = Long.valueOf(r154);
        return;
    L75:
        RealTimeChorusBusinessContext.Companion.getClass();
        if (RealTimeChorusBusinessContext.a.g() == false) goto L78;
        d();
        goto L78
    L44:
        d();
    L31:
        r127 = "";
    L26:
        r124 = "";
    L21:
        r121 = "";
        goto L22
    L16:
        r117 = null;
        goto L17
    L12:
        r112 = false;
        goto L13
    L8:
        r105 = r310.longValue();
        goto L9
    L5:
        r102 = r213;
        goto L6
    }
}
