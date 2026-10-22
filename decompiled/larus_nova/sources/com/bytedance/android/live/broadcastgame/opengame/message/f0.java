package com.bytedance.android.live.broadcastgame.opengame.message;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class f0 extends k {
    public final boolean A;
    public String B;
    public final boolean C;
    public final boolean D;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f60200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f60201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f60202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f60203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f60204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f60205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f60206l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f60207m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f60208n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f60209o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f60210p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f60211q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f60212r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final boolean f60213s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f60214t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f60215u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final e0 f60216v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map<String, String> f60217w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f60218x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Boolean f60219y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final JSONObject f60220z;

    public static final class a {
    }

    static {
    }

    public f0() {
        throw null;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.message.k
    public final JSONObject a() {
        JSONObject r100 = super.a();
        r100.put("schema", this.f60202h);
        r100.put("mode", this.f60205k);
        r100.put("developer", this.f60210p);
        r100.put("current_game_identifer", this.f60206l);
        r100.put("current_game_version", this.f60201g);
        r100.put("business_type", this.f60211q);
        r100.put(BdpAppEventConstant.PARAMS_GAME_CATEGORY, this.f60208n);
        return r100.put("hide_user_entrance", this.f60218x);
    }

    public f0(long r210, String r310, long r311, long r312, String r313, String r314, String r315, String r316, long r410, String r411, int r412, String r413, boolean r414, String r415, int r416, int r417, boolean r418, boolean r510, int r511, Map r512, boolean r513, Boolean r514, JSONObject r515, boolean r516, String r517, boolean r518, boolean r519, int r610) {
        long r100 = 0;
        if ((r610 & 4) == 0) goto L5;
        long r101 = 0;
    L7:
        if ((r610 & 8) == 0) goto L9;
        long r102 = 0;
    L11:
        if ((r610 & 64) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r610 & 128) == 0) goto L17;
        String r110 = "";
    L19:
        if ((r610 & 256) != 0) goto L23;
        r100 = r410;
    L23:
        if ((r610 & 512) == 0) goto L25;
        String r111 = "";
    L27:
        if ((r610 & 1024) == 0) goto L29;
        int r112 = 0;
    L31:
        if ((r610 & 2048) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r610 & 4096) == 0) goto L37;
        boolean r114 = false;
    L38:
        boolean r317 = r114;
        if ((r610 & 8192) == 0) goto L41;
        String r115 = "";
    L42:
        String r318 = r113;
        if ((r610 & 16384) == 0) goto L45;
        int r116 = 0;
    L47:
        if ((r610 & 32768) == 0) goto L49;
        int r117 = 1;
    L51:
        if ((r610 & 65536) == 0) goto L53;
        boolean r118 = false;
    L55:
        if ((r610 & 131072) == 0) goto L57;
        boolean r119 = false;
    L59:
        if ((r610 & 262144) == 0) goto L61;
        int r211 = 0;
    L63:
        if ((r610 & 4194304) == 0) goto L65;
        Map r212 = null;
    L67:
        if ((r610 & 16777216) == 0) goto L69;
        boolean r213 = false;
    L71:
        if ((r610 & 33554432) == 0) goto L73;
        Boolean r214 = null;
    L75:
        if ((r610 & 67108864) == 0) goto L77;
        JSONObject r215 = null;
    L79:
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L81;
        boolean r216 = false;
    L83:
        if ((r610 & 268435456) == 0) goto L85;
        String r217 = null;
    L87:
        if ((r610 & 536870912) == 0) goto L89;
        boolean r218 = false;
    L91:
        if ((r610 & 1073741824) == 0) goto L93;
        boolean r120 = false;
    L94:
        Intrinsics.checkNotNullParameter(r310, "appVersion");
        Intrinsics.checkNotNullParameter(r313, "appId");
        Intrinsics.checkNotNullParameter(r314, "schema");
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r110, "iconUrl");
        Intrinsics.checkNotNullParameter(r111, "gameIdentifier");
        Intrinsics.checkNotNullParameter(r115, "developer");
        super(r313, r101, r102, r102);
        this.f60200f = r210;
        this.f60201g = r310;
        this.f60202h = r314;
        this.f60203i = r103;
        this.f60204j = r110;
        this.f60205k = r100;
        this.f60206l = r111;
        this.f60207m = r112;
        this.f60208n = r318;
        this.f60209o = r317;
        this.f60210p = r115;
        this.f60211q = r116;
        this.f60212r = r117;
        this.f60213s = r118;
        this.f60214t = r119;
        this.f60215u = r211;
        this.f60216v = null;
        this.f60217w = r212;
        this.f60218x = r213;
        this.f60219y = r214;
        this.f60220z = r215;
        this.A = r216;
        this.B = r217;
        this.C = r218;
        this.D = r120;
        return;
    L93:
        r120 = r519;
        goto L94
    L89:
        r218 = r518;
        goto L91
    L85:
        r217 = r517;
        goto L87
    L81:
        r216 = r516;
        goto L83
    L77:
        r215 = r515;
        goto L79
    L73:
        r214 = r514;
        goto L75
    L69:
        r213 = r513;
        goto L71
    L65:
        r212 = r512;
        goto L67
    L61:
        r211 = r511;
        goto L63
    L57:
        r119 = r510;
        goto L59
    L53:
        r118 = r418;
        goto L55
    L49:
        r117 = r417;
        goto L51
    L45:
        r116 = r416;
        goto L47
    L41:
        r115 = r415;
        goto L42
    L37:
        r114 = r414;
        goto L38
    L33:
        r113 = r413;
        goto L35
    L29:
        r112 = r412;
        goto L31
    L25:
        r111 = r411;
        goto L27
    L17:
        r110 = r316;
        goto L19
    L13:
        r103 = r315;
        goto L15
    L9:
        r102 = r312;
        goto L11
    L5:
        r101 = r311;
        goto L7
    }
}
