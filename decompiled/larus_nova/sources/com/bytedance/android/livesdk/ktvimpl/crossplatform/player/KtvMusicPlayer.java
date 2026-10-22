package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.model.bean.SetBgmFunctionType;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.p;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.larus.nova.R;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class KtvMusicPlayer implements com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SetBgmFunctionType f143796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MusicPanel f143797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f143798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f143799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g f143800e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f143801f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f143802g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f143803h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f143804i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CompositeDisposable f143805j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final d f143806k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final j1 f143807l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMusicPlayer f143808a;

        public b(KtvMusicPlayer r100) {
            this.f143808a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void release() {
        this.f143797b = null;
        this.f143805j.clear();
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "resetMusic");
        a();
        a();
        a();
        g r100 = this.f143800e;
        r100.a();
        r100.f143816a.clear();
    }

    public final void a() {
        j1 r100 = this.f143807l;
        if (r100 == null) goto L14;
        cg6.a r101 = (cg6.a) r100.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r101 == null) goto L15;
        hg6.g r102 = r101.getRtcManager();
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

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void o() {
        Intrinsics.checkNotNullParameter("", "path");
        Intrinsics.checkNotNullParameter("", "name");
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void pause() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "pause");
        a();
        if (vm2.h.d() == false) goto L5;
        a();
    L5:
        UtilityKotlinExtentionsKt.b(this, AnonymousClass1.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void resume() {
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "resume");
        a();
        if (vm2.h.d() == false) goto L5;
        a();
    L5:
        UtilityKotlinExtentionsKt.b(this, C100951.INSTANCE);
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void n() {
        if (vm2.h.d() == false) goto L5;
        a();
        return;
    L5:
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void f() {
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void j() {
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final boolean m() {
        return this.f143799d;
    }

    public final void b(Map<String, com.bytedance.android.live.ktv.common.model.bean.f> r110) {
        if (r110.isEmpty() == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; map is empty");
        return;
    L7:
        if (this.f143801f == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; hasSetBGMMusicWithAllResource");
        this.f143806k.n().setValue(new LinkedHashMap());
        return;
    L10:
        MusicPanel r100 = this.f143806k.a();
        if (r100 != null) goto L13;
        return;
    L13:
        com.bytedance.android.live.ktv.common.model.bean.f r111 = r110.get(KtvUtilsKt.c(r100));
        if (r111 != null) goto L17;
        return;
    L17:
        if (r111.f69997a == DownloadResourceType.OTHER_RESOURCE) goto L19;
        return;
    L19:
        if (r111.f69998b == false) goto L21;
        return;
    L21:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r100) == false) goto L50;
        boolean r101 = true;
        if (this.f143802g == true) goto L34;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithMainResource ;; " + r111);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicWithMainResource ;; song_id == " + r100.f153577a.getMId());
        this.f143802g = true;
        Intrinsics.checkNotNullParameter(r100, "$this$isRealOriginFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r100.f153590n) == false) goto L27;
        a();
        boolean r102 = this.f143799d;
    L32:
        i(r102, false);
        goto L34
    L27:
        Intrinsics.checkNotNullParameter(r100, "$this$isRealAccompanimentFileExists");
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.l(r100.f153591o) == false) goto L30;
        a();
    L31:
        r102 = false;
        goto L32
    L30:
        mb0.f.o(r100);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "music file path not exists ");
        c("music_path_not_exist_source");
    L34:
        if (com.bytedance.android.live.ktv.common.util.KtvUtilsKt.q(r100) == false) goto L54;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; setBGMMusicWithAllResource ;; " + r111);
        this.f143806k.n().setValue(new LinkedHashMap());
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicWithAllResource ;; song_id == " + r100.f153577a.getMId() + " startTime " + this.f143798c);
        this.f143801f = true;
        long r103 = r100.c();
        int r112 = e.f143814a[r100.h().ordinal()];
        if (r112 != 1) goto L38;
        a();
        r101 = this.f143799d;
        pd2.d.L(pd2.d.f528658n, r103, "set_bgm");
    L49:
        i(r101, false);
        return;
    L38:
        if (r112 != 2) goto L40;
        a();
        pd2.d.L(pd2.d.f528658n, r103, "set_bgm");
        goto L49
    L40:
        if (r112 != 3) goto L42;
        a();
        pd2.d.L(pd2.d.f528658n, r103, "set_bgm");
    L46:
        r101 = false;
        goto L49
    L42:
        if (r112 != 4) goto L46;
        c("music_path_not_exist_source");
        f2.c(s1.B(R.string.ttlive_ktv_file_break_down), 0);
        pd2.d.v(LinkMonitorData.BusinessSetBgmFailed, MapsKt.mapOf(TuplesKt.to("reason", "both of origin and accompaniment are empty")));
        mb0.f.p(r100, "both of origin and accompaniment are empty");
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "both of origin and accompaniment are empty.");
        pd2.d.L(pd2.d.f528658n, r103, "error");
        goto L46
    L54:
        return;
    L50:
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("ktv_music_resource_download_opt_tag", "setBGMMusicIfNeed ;; curMusicPanel == " + r100 + " ;; curProgress== " + this.f143798c + " ;; isSupportOriginSwitchWithPath == " + com.bytedance.android.live.ktv.common.util.KtvUtilsKt.D(r100) + " ;; " + r111);
    }

    public final void c(String r100) {
        if (this.f143803h == false) goto L5;
        return;
    L5:
        if (this.f143804i == false) goto L7;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "resetMusic");
        a();
    L7:
        this.f143803h = true;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "on stop bgm");
        if (Intrinsics.areEqual(r100, "live_core_stop_music_callback_source") == false) goto L10;
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("KtvMusicPlayer", "livecore stop");
        int r101 = mb0.f.f512760a;
        mb0.f.d(this.f143797b);
    L10:
        this.f143798c = 0;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void g(double[] r100) {
        Intrinsics.checkNotNullParameter(r100, "scoreInfo");
        a();
        vm2.h.d();
        if (r100.length >= 21) goto L5;
        return;
    L5:
        KtvContext.Companion.getClass();
        KtvContext r101 = KtvContext.a.g();
        p r102 = r101.getRealTimeInfoModel().getValue();
        if (r102 != null) goto L8;
        return;
    L8:
        m<p> r103 = r101.getRealTimeInfoModel();
        r102.a(r100);
        r103.setValue(r102);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void k(JsonObject r110) {
        g r100 = this.f143800e;
        r100.getClass();
        Boolean r101 = null;
        if (r110 == null) goto L7;
        JsonElement r102 = r110.get("name");
        if (r102 == null) goto L7;
        String r103 = r102.getAsString();
    L8:
        if (r110 == null) goto L12;
        JsonElement r104 = r110.get("icon");
        if (r104 == null) goto L12;
        String r105 = r104.getAsString();
    L13:
        if (r110 == null) goto L17;
        JsonElement r106 = r110.get("title");
        if (r106 == null) goto L17;
        String r107 = r106.getAsString();
    L18:
        if (r110 == null) goto L22;
        JsonElement r108 = r110.get("conf");
        if (r108 == null) goto L22;
        String r109 = r108.getAsString();
    L23:
        if (r110 == null) goto L27;
        JsonElement r111 = r110.get("version");
        if (r111 == null) goto L27;
        Integer r112 = Integer.valueOf(r111.getAsInt());
    L28:
        if (r110 == null) goto L33;
        JsonElement r113 = r110.get("isSelected");
        if (r113 == null) goto L33;
        r101 = Boolean.valueOf(r113.getAsBoolean());
    L33:
        if (r103 != null) goto L35;
        String r114 = "";
    L36:
        if (r107 != null) goto L38;
        String r115 = "";
    L39:
        int r116 = qy.a.f535172a;
        if (r105 != null) goto L42;
        r105 = "";
    L42:
        py.k r117 = qy.a.a(r105);
        if (r109 != null) goto L45;
        r109 = "";
    L45:
        py.k r118 = qy.a.a(r109);
        if (r112 == null) goto L48;
        int r119 = r112.intValue();
    L49:
        if (r101 == null) goto L51;
        boolean r120 = r101.booleanValue();
    L52:
        com.bytedance.android.live.ktv.common.model.bean.h r121 = new com.bytedance.android.live.ktv.common.model.bean.h(r114, r115, r117, r118, r119, r120);
        com.bytedance.android.livesdk.ktvimpl.crossplatform.a.a("TuningEffectManager", "downloadTuningEffect tuningEffectItem: " + r121);
        k r122 = new k(r100, r121);
        if (r121.g() == false) goto L55;
        r122.a("");
        return;
    L55:
        RxUtilKt.c(Single.create(new h(r100, r121)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new i(r122), new j(r122)), r100.f143816a);
        return;
    L51:
        r120 = false;
        goto L52
    L48:
        r119 = -1;
        goto L49
    L38:
        r115 = r107;
        goto L39
    L35:
        r114 = r103;
    L27:
        r112 = null;
    L22:
        r109 = null;
    L17:
        r107 = null;
    L12:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void l(com.bytedance.android.livesdk.ktvimpl.crossplatform.player.a r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        MusicPanel r101 = this.f143806k.a();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f153577a.isSameKtvMusicByIdStr(r100.f143809a) == true) goto L8;
        return;
    L8:
        this.f143797b = r101;
        KtvMusic r102 = r101.f153577a;
        long r103 = r100.f143812d;
        Long r104 = r100.f143813e;
        if (r103 != 0) goto L11;
        KtvMusic.Companion.getClass();
        r103 = KtvMusic.a.c(r102);
    L11:
        if (r104 == null) goto L13;
        long r105 = r104.longValue();
    L14:
        Pair r106 = new Pair(Long.valueOf(r103), Long.valueOf(r105));
        ((Number) r106.component1()).longValue();
        ((Number) r106.component2()).longValue();
        a();
        return;
    L13:
        KtvMusic.Companion.getClass();
        r105 = KtvMusic.a.a(r102);
        goto L14
    }

    public KtvMusicPlayer(d r100, j1 r101) {
        Intrinsics.checkNotNullParameter(r100, "runContext");
        this.f143806k = r100;
        this.f143807l = r101;
        this.f143796a = SetBgmFunctionType.MULTI_KTV;
        Long r102 = (Long) KtvSettingHelper.H0.getValue();
        this.f143799d = KtvUtilsKt.b(true, 1);
        this.f143800e = new g(r101);
        CompositeDisposable r103 = new CompositeDisposable();
        this.f143805j = r103;
        new b(this);
        b(r100.n().getValue());
        Disposable r104 = r100.n().a().subscribe(new f(this));
        if (r104 == null) goto L6;
        RxUtilKt.c(r104, r103);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void i(boolean r100, boolean r101) {
        this.f143799d = r100;
        a();
        if (r101 == false) goto L9;
        com.bytedance.android.livesdk.sharedpref.e<Integer> r102 = com.bytedance.android.livesdk.sharedpref.c.f158269h;
        if (r100 == false) goto L7;
        int r103 = 1;
    L8:
        Integer r104 = Integer.valueOf(r103);
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r104);
        goto L9
    L7:
        r103 = 2;
    L9:
        MusicPanel r105 = this.f143797b;
        if (r105 != null) goto L12;
        return;
    L12:
        if (r105.f153577a == null) goto L16;
        a();
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void p(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "midiPath");
        Intrinsics.checkNotNullParameter(r101, "lyricsPath");
        a();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b
    public final void h(String r100, String r101, double r102) {
        Intrinsics.checkNotNullParameter(r100, "midiPath");
        Intrinsics.checkNotNullParameter(r101, "lyricsPath");
        Intrinsics.checkNotNullParameter(r100, "midiPath");
        Intrinsics.checkNotNullParameter(r101, "lyricsPath");
        p(r100, r101);
    }
}
