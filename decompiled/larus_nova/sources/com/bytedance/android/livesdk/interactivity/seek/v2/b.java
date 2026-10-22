package com.bytedance.android.livesdk.interactivity.seek.v2;

import android.content.Context;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.network.api.INetworkService;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livehostapi.foundation.IHostNetwork;
import com.bytedance.android.livesdk.chatroom.VSDataContext;
import com.bytedance.android.livesdk.crash.SourceType;
import com.bytedance.android.livesdk.utils.d4;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.LayerHostMediaLayout;
import com.ss.ttvideoengine.model.SubInfo;
import im2.n;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public class b implements q52.a {
    public final List<vlc.j> A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f140800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f140801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final im2.d f140802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f140803d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bc2.a f140804e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bc2.e f140805f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f140806g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final VideoContext f140807h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f140808i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f140809j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f f140810k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<com.ss.ugc.live.sdk.msg.dispatch.a> f140811l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f140812m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f140813n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final g f140814o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final e f140815p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f140816q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DataCenter f140817r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f140818s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f140819t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f140820u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f140821v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f140822w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f140823x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final long f140824y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<vlc.b> f140825z;

    public static final class a {
    }

    static {
    }

    public String f() {
        if (((Boolean) this.f140816q.getValue()).booleanValue() == false) goto L7;
        return "https://" + ((IHostNetwork) k.n(IHostNetwork.class)).getHostDomain() + "/webcast/im/fetch/traceable/";
    L7:
        return "https://" + ((IHostNetwork) k.n(IHostNetwork.class)).getHostDomain() + "/webcast/im/fetch/";
    }

    public HashMap<String, String> h() {
        IHostContext r100 = (IHostContext) k.n(IHostContext.class);
        HashMap<String, String> r101 = new HashMap(((INetworkService) k.n(INetworkService.class)).getCommonParams());
        r101.put("room_id", String.valueOf(this.f140818s));
        r101.put("rid", String.valueOf(this.f140818s));
        r101.put("aid", String.valueOf(r100.hostAppId()));
        r101.put("user_id", this.f140819t);
        r101.put(DownloadHelper.IDENTITY, this.f140800a);
        r101.put("live_id", String.valueOf(((IHostContext) k.n(IHostContext.class)).liveId()));
        String r102 = this.f140820u;
        if (r102 == null) goto L5;
        r101.put(ILiveRoomPlayFragmentConstant.EXTRA_LOG_ROOM_TAG, r102);
    L5:
        r101.put("episode_id", String.valueOf(this.f140822w));
        r101.put("episode_stage", String.valueOf(this.f140823x));
        r101.put("season_id", String.valueOf(this.f140824y));
        r101.put("get_history", "2");
        if (this.f140823x != EpisodeMod.EpisodeStageType.REPLAY) goto L13;
        DataCenter r103 = this.f140817r;
        Room r104 = z.f66431a;
        Intrinsics.checkNotNullParameter(r103, "$this$episode");
        EpisodeBasicInfo r105 = ((Episode) r103.get("data_vs_episode_data", z.f66432b)).episodeBasicInfo;
        if (r105 == null) goto L11;
        String r106 = String.valueOf(r105.getReplayCameraId());
        if (r106 == null) goto L11;
    L12:
        r101.put(VSConstants.VS_CAMERA_ID, r106);
    L11:
        r106 = "0";
    L13:
        VSDataContext.Companion.getClass();
        VSDataContext r107 = VSDataContext.a.a();
        if (r107 != null) goto L16;
    L29:
        boolean r108 = false;
    L30:
        if (r108 == false) goto L34;
        r101.put("system_type", "3");
        if (this.f140806g == false) goto L34;
        this.f140806g = false;
    L34:
        r101.putAll(this.f140801b);
        return r101;
    L16:
        if (r107.isVSVideo().getValue().booleanValue() == false) goto L29;
        if (this.f140806g == true) goto L28;
        VideoContext r109 = this.f140807h;
        if (r109 == null) goto L29;
        LayerHostMediaLayout r110 = r109.f455949c;
        if (r110 != null) goto L25;
        int r111 = 0;
    L27:
        if (r111 != 0) goto L29;
    L25:
        r111 = r110.getCurrentPosition();
    L28:
        r108 = true;
        goto L30
    }

    @Override // amc.e
    public final List<cmc.b<?>> e() {
        return CollectionsKt.emptyList();
    }

    @Override // amc.e
    public final amc.b b() {
        return this.f140813n;
    }

    @Override // amc.e
    public final com.ss.ugc.live.sdk.msg.b c() {
        return this.f140815p;
    }

    @Override // amc.e
    public final amc.i d() {
        return this.f140814o;
    }

    @Override // amc.e
    public final n g() {
        return this.f140803d;
    }

    @Override // amc.e
    public final vlc.c getLogger() {
        return this.f140804e;
    }

    @Override // amc.e
    public final bc2.e getMonitor() {
        return this.f140805f;
    }

    @Override // amc.e
    public final amc.g getNetworkConfig() {
        return this.f140810k;
    }

    @Override // amc.e
    public final long getRoomId() {
        return this.f140818s;
    }

    @Override // q52.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, EffectConfiguration.KEY_CURSOR);
        this.f140808i = r100;
    }

    public b(DataCenter r100, Context r101, long r102, String r103, boolean r104, long r105, int r110, long r111, List r112) {
        Intrinsics.checkNotNullParameter(r100, "dataCenter");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r103, "userId");
        this.f140817r = r100;
        this.f140818s = r102;
        this.f140819t = r103;
        this.f140820u = SubInfo.KEY_FORMAT;
        this.f140821v = r104;
        this.f140822w = r105;
        this.f140823x = r110;
        this.f140824y = r111;
        this.f140825z = r112;
        this.A = null;
        this.f140800a = SourceType.DEFAULT;
        this.f140801b = new HashMap();
        this.f140802c = new im2.d(false);
        this.f140803d = new n();
        this.f140804e = new bc2.a("Seek");
        this.f140805f = new bc2.e();
        this.f140806g = true;
        this.f140807h = VideoContext.n0(r101);
        this.f140808i = "0";
        this.f140809j = new c(this);
        this.f140810k = new f(this);
        this.f140811l = CollectionsKt.emptyList();
        this.f140812m = CollectionsKt.toSet(d4.m());
        this.f140813n = new d(this);
        this.f140814o = new g();
        this.f140815p = new e(this);
        this.f140816q = LazyKt.lazy(SeekMessageConfig$useTraceable$2.INSTANCE);
    }
}
