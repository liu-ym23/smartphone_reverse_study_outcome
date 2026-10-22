package am2;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeVideo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ReplayPaidInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.episode.main.IMainEpisode;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeBaseInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.PrivilegeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.pay.TicketData;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class a0 {
    public static final /* synthetic */ int L = 0;
    public String A;
    public long B;
    public long C;
    public String D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public Long I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public boolean f4228J;
    public HashMap<String, String> K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f4229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f4232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f4233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f4234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f4235g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4236h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f4237i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f4238j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f4239k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f4240l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f4241m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f4242n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f4243o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f4244p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f4245q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f4246r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f4247s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f4248t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f4249u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public String f4250v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public String f4251w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f4252x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f4253y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f4254z;

    public static final class a {
        public static a0 a(Episode r110) {
            Intrinsics.checkNotNullParameter(r110, "episode");
            a0 r100 = new a0();
            String r101 = String.valueOf(r110.roomId);
            Intrinsics.checkNotNullParameter(r101, "<set-?>");
            r100.f4229a = r101;
            String r102 = String.valueOf(r110.getIdExt());
            Intrinsics.checkNotNullParameter(r102, "<set-?>");
            r100.f4230b = r102;
            String r103 = EpisodeExtKt.getOwnerIdString(r110);
            Intrinsics.checkNotNullParameter(r103, "<set-?>");
            r100.f4232d = r103;
            String r104 = r110.seasonId;
            String r105 = "";
            if (r104 != null) goto L5;
            r104 = "";
        L5:
            Intrinsics.checkNotNullParameter(r104, "<set-?>");
            r100.f4233e = r104;
            EpisodeBasicInfo r106 = r110.episodeBasicInfo;
            boolean r107 = false;
            if (r106 == null) goto L8;
            int r108 = r106.getReplayType();
        L9:
            r100.f4242n = r108;
            IMainEpisode r109 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            String r111 = "1";
            PrivilegeInfo r112 = null;
            if (r109 != null) goto L12;
        L19:
            String r113 = "";
        L20:
            Intrinsics.checkNotNullParameter(r113, "<set-?>");
            r100.f4249u = r113;
            IMainEpisode r114 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r114 != null) goto L23;
        L25:
            r111 = "";
        L26:
            Intrinsics.checkNotNullParameter(r111, "<set-?>");
            r100.f4250v = r111;
            IMainEpisode r115 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r115 != null) goto L29;
        L41:
            String r116 = "";
        L42:
            Intrinsics.checkNotNullParameter(r116, "<set-?>");
            r100.f4251w = r116;
            IMainEpisode r117 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r117 == null) goto L50;
            ReplayPaidInfo r118 = r117.getReplayPaidInfo();
            if (r118 == null) goto L50;
            if (r118.hasViewRight() == true) goto L50;
            boolean r119 = false;
        L51:
            r100.f4252x = r119;
            IMainEpisode r120 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r120 == null) goto L59;
            ReplayPaidInfo r121 = r120.getReplayPaidInfo();
            if (r121 == null) goto L59;
            if (r121.isDelivery() == true) goto L59;
            boolean r122 = false;
        L60:
            r100.f4253y = r122;
            EpisodeBasicInfo r123 = r110.episodeBasicInfo;
            if (r123 == null) goto L63;
            Long r124 = Long.valueOf(r123.getReplayCameraId());
        L64:
            String r125 = String.valueOf(r124);
            Intrinsics.checkNotNullParameter(r125, "<set-?>");
            r100.f4245q = r125;
            EpisodeBasicInfo r126 = r110.episodeBasicInfo;
            if (r126 == null) goto L67;
            Long r127 = Long.valueOf(r126.getReplayCameraId());
        L68:
            EpisodeBasicInfo r128 = r110.episodeBasicInfo;
            if (r128 == null) goto L71;
            Long r129 = Long.valueOf(r128.getOriginEpisodeId());
        L73:
            if (Intrinsics.areEqual(r127, r129) == false) goto L75;
            String r130 = "major";
        L76:
            Intrinsics.checkNotNullParameter(r130, "<set-?>");
            r100.f4246r = r130;
            String r131 = r110.title;
            if (r131 != null) goto L79;
            r131 = "";
        L79:
            Intrinsics.checkNotNullParameter(r131, "<set-?>");
            r100.f4247s = r131;
            EpisodeVideo r132 = r110.video;
            if (r132 == null) goto L83;
            String r133 = r132.getVid();
            if (r133 == null) goto L83;
        L84:
            Intrinsics.checkNotNullParameter(r133, "<set-?>");
            r100.f4244p = r133;
            if (r100.f4253y == true) goto L87;
        L96:
            String r134 = "try";
        L97:
            Intrinsics.checkNotNullParameter(r134, "<set-?>");
            r100.f4254z = r134;
            IMainEpisode r135 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r135 == null) goto L109;
            Map<Integer, PrivilegeInfo> r136 = r135.getPrivilegeInfo();
            if (r136 == null) goto L109;
            Iterator<PrivilegeInfo> r137 = r136.values().iterator();
            String r138 = "paid";
        L103:
            if (r137.hasNext() == false) goto L110;
            PrivilegeBaseInfo r139 = r137.next().paidLiveInfo;
            if (r139 == null) goto L103;
            if (r139.viewRight != 0) goto L103;
            r138 = "not_paid";
        L110:
            Intrinsics.checkNotNullParameter(r138, "<set-?>");
            r100.A = r138;
            IMainEpisode r140 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r140 == null) goto L120;
            ReplayPaidInfo r141 = r140.getReplayPaidInfo();
            if (r141 == null) goto L120;
            TicketData r142 = r141.getTicketData();
            if (r142 == null) goto L120;
            String r143 = r142.getTicketCategoryLogStr();
            if (r143 == null) goto L120;
            r105 = r143;
        L120:
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r100.D = r105;
            IMainEpisode r144 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            long r145 = 0;
            if (r144 == null) goto L127;
            ReplayPaidInfo r146 = r144.getReplayPaidInfo();
            if (r146 == null) goto L127;
            TicketData r147 = r146.getTicketData();
            if (r147 == null) goto L127;
            long r148 = r147.getTicketId();
        L128:
            r100.B = r148;
            EpisodeBasicInfo r149 = r110.episodeBasicInfo;
            if (r149 == null) goto L131;
            Long r150 = Long.valueOf(r149.getContentId());
        L132:
            r100.I = r150;
            IMainEpisode r151 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r151 == null) goto L135;
            r112 = r151.subscribeReplayInfo();
        L135:
            if (r112 == null) goto L137;
            r107 = true;
        L137:
            r100.f4228J = r107;
            IMainEpisode r152 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r152 == null) goto L142;
            ReplayPaidInfo r153 = r152.getReplayPaidInfo();
            if (r153 == null) goto L142;
            r145 = r153.getFreeDuration();
        L142:
            r100.C = r145;
            return r100;
        L131:
            r150 = null;
        L127:
            r148 = 0;
        L109:
            r138 = "none";
            goto L110
        L87:
            if (r100.f4252x == false) goto L96;
            IMainEpisode r154 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r154 == null) goto L95;
            ReplayPaidInfo r155 = r154.getReplayPaidInfo();
            if (r155 == null) goto L95;
            if (r155.getViewRight() != 9) goto L95;
            r134 = "vmember";
        L95:
            r134 = "regular";
        L83:
            r133 = "";
            goto L84
        L75:
            r130 = "others";
            goto L76
        L71:
            r129 = null;
            goto L73
        L67:
            r127 = null;
            goto L68
        L63:
            r124 = null;
        L59:
            r122 = true;
        L50:
            r119 = true;
            goto L51
        L29:
            if (r115.isPaidCameraReplay() != true) goto L41;
            IMainEpisode r156 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r156 == null) goto L39;
            ReplayPaidInfo r157 = r156.getReplayPaidInfo();
            if (r157 == null) goto L39;
            TicketData r158 = r157.getTicketData();
            if (r158 == null) goto L39;
            String r159 = r158.getPrice();
            if (r159 == null) goto L39;
            Long r160 = Long.valueOf((long) (CastFloatProtector.parseFloat(r159) * 100));
        L40:
            r116 = String.valueOf(r160);
        L39:
            r160 = null;
            goto L40
        L23:
            if (r114.isPaidCameraReplay() != true) goto L25;
        L12:
            if (r109.isPaidReplay() != true) goto L19;
            IMainEpisode r161 = (IMainEpisode) r110.castToOrNull(IMainEpisode.class);
            if (r161 == null) goto L16;
            PrivilegeInfo r162 = r161.subscribeReplayInfo();
        L17:
            if (r162 != null) goto L19;
            r113 = "1";
            goto L20
        L16:
            r162 = null;
            goto L17
        L8:
            r108 = 0;
            goto L9
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"am2/a0$b", "Lcom/google/gson/reflect/TypeToken;", "", "", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b extends TypeToken<Map<String, ? extends String>> {
        public b() {
        }
    }

    static {
    }

    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        if (TextUtils.isEmpty(this.f4248t) == true) goto L10;
        String r101 = Uri.decode(this.f4248t);
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS, r101);
        Map r102 = (Map) new Gson().fromJson(r101, new b().getType());     // Catch: Exception -> L9
        if (r102 == null) goto L10;
        r100.putAll(r102);     // Catch: Exception -> L9
    L10:
        HashMap<String, String> r103 = this.K;
        if (r103 == null) goto L13;
        r100.putAll(r103);
    L13:
        boolean r104 = false;
        if (this.f4229a.length() <= 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == false) goto L20;
        r100.put("room_id", this.f4229a);
    L20:
        if (this.f4230b.length() <= 0) goto L22;
        boolean r106 = true;
    L23:
        if (r106 == false) goto L26;
        r100.put("vs_episode_id", this.f4230b);
    L26:
        if (this.f4231c.length() <= 0) goto L28;
        boolean r107 = true;
    L29:
        if (r107 == false) goto L32;
        r100.put("vs_episode_stage", this.f4231c);
    L32:
        if (this.f4233e.length() <= 0) goto L34;
        boolean r108 = true;
    L35:
        if (r108 == false) goto L38;
        r100.put("vs_season_id", this.f4233e);
    L38:
        if (this.f4232d.length() <= 0) goto L40;
        boolean r109 = true;
    L41:
        if (r109 == false) goto L44;
        r100.put("anchor_id", this.f4232d);
    L44:
        if (this.f4235g.length() <= 0) goto L46;
        boolean r110 = true;
    L47:
        if (r110 == false) goto L50;
        r100.put("replay_enter_type", this.f4235g);
    L50:
        if (this.f4238j.length() <= 0) goto L52;
        boolean r111 = true;
    L53:
        if (r111 == false) goto L56;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LYNX_CARD_ORDER, this.f4238j);
    L56:
        if (this.f4239k.length() <= 0) goto L58;
        boolean r112 = true;
    L59:
        if (r112 == false) goto L62;
        r100.put("content_type", this.f4239k);
    L62:
        if (this.f4240l.length() <= 0) goto L64;
        boolean r113 = true;
    L65:
        if (r113 == false) goto L68;
        r100.put("token_form", this.f4240l);
    L68:
        if (this.f4241m.length() <= 0) goto L70;
        boolean r114 = true;
    L71:
        if (r114 == false) goto L73;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_LYNX_ROLLING_TYPE, this.f4241m);
    L73:
        boolean r115 = this.f4236h;
        if (r115 == false) goto L77;
        r100.put("enter_with_video_model", String.valueOf(r115));
    L77:
        if ("normal".length() <= 0) goto L79;
        boolean r116 = true;
    L80:
        if (r116 == false) goto L83;
        r100.put("vs_episode_sub_type", "normal");
    L83:
        if (this.f4237i.length() <= 0) goto L85;
        boolean r117 = true;
    L86:
        if (r117 == false) goto L88;
        r100.put("replay_bottom_bar_start_type", this.f4237i);
    L88:
        int r118 = this.f4234f;
        if (r118 < 0) goto L97;
        if (r118 != 0) goto L92;
    L95:
        String r119 = "landscape";
    L96:
        r100.put("vs_screen_type", r119);
        goto L97
    L92:
        if (r118 == 6) goto L95;
        r119 = "portrait";
    L97:
        int r120 = this.f4243o;
        String r121 = "0";
        if (r120 >= 0) goto L100;
    L104:
        int r122 = this.f4242n;
        if (r122 <= 0) goto L108;
        r100.put("replay_type", String.valueOf(r122));
    L108:
        if (this.f4252x == false) goto L110;
        Object r123 = "1";
    L111:
        r100.put("has_buy_ticket", r123);
        if (this.f4253y == false) goto L114;
        Object r124 = "1";
    L115:
        r100.put("has_full_right", r124);
        if (this.F == false) goto L118;
        Object r125 = "1";
    L119:
        r100.put("is_from_highlight_moment", r125);
        if (this.E == false) goto L122;
        Object r126 = "1";
    L123:
        r100.put("is_click_highlight", r126);
        if (this.G == false) goto L126;
        Object r127 = "1";
    L127:
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_IS_ECOM, r127);
        if (this.H == false) goto L130;
        Object r128 = "1";
    L131:
        r100.put("is_live_streaming", r128);
        if (TextUtils.isEmpty(this.f4249u) == true) goto L135;
        r100.put("is_paidlive", this.f4249u);
    L135:
        if (this.f4250v.length() <= 0) goto L137;
        boolean r129 = true;
    L138:
        if (r129 == false) goto L141;
        r100.put("is_paid_machine", this.f4250v);
    L141:
        if (this.f4251w.length() <= 0) goto L143;
        boolean r130 = true;
    L144:
        if (r130 == false) goto L147;
        r100.put("pay_num", this.f4251w);
    L147:
        if (this.f4245q.length() <= 0) goto L149;
        boolean r131 = true;
    L150:
        if (r131 == false) goto L153;
        r100.put("vs_machine_id", this.f4245q);
    L153:
        if (this.f4246r.length() <= 0) goto L155;
        boolean r132 = true;
    L156:
        if (r132 == false) goto L159;
        r100.put(PaidReplayConstants.KEY_VS_MACHINE_TYPE, this.f4246r);
    L159:
        if (this.f4247s.length() <= 0) goto L161;
        boolean r133 = true;
    L162:
        if (r133 == false) goto L165;
        r100.put("vs_machine_title", this.f4247s);
    L165:
        if (this.f4254z.length() <= 0) goto L167;
        boolean r134 = true;
    L168:
        if (r134 == false) goto L171;
        r100.put(ILiveRoomPlayFragmentConstant.EXTRA_WATCH_PAID_LIVE_STATUS, this.f4254z);
    L171:
        if (this.A.length() <= 0) goto L173;
        boolean r135 = true;
    L174:
        if (r135 == false) goto L177;
        r100.put("privilege_status", this.A);
    L177:
        if (this.f4244p.length() <= 0) goto L179;
        boolean r136 = true;
    L180:
        if (r136 == false) goto L183;
        r100.put("video_id", this.f4244p);
    L183:
        if (this.B == 0) goto L186;
        r100.put("ticket_id", "" + this.B);
    L186:
        if (this.C == 0) goto L189;
        r100.put("try_duration", "" + this.C);
    L189:
        if (this.D.length() <= 0) goto L191;
        r104 = true;
    L191:
        if (r104 == false) goto L193;
        r100.put("ticket_type", "" + this.D);
    L193:
        Long r137 = this.I;
        if (r137 == null) goto L197;
        r100.put("vs_content_id", String.valueOf(r137));
    L197:
        if (this.f4228J == false) goto L199;
        Object r138 = "1";
    L200:
        r100.put("is_vip_replay", r138);
        if (this.f4234f == 1) goto L204;
        r121 = "1";
    L204:
        r100.put("is_hor", r121);
        r100.put("is_vs", "1");
        return r100;
    L199:
        r138 = "0";
        goto L200
    L179:
        r136 = false;
        goto L180
    L173:
        r135 = false;
        goto L174
    L167:
        r134 = false;
        goto L168
    L161:
        r133 = false;
        goto L162
    L155:
        r132 = false;
        goto L156
    L149:
        r131 = false;
        goto L150
    L143:
        r130 = false;
        goto L144
    L137:
        r129 = false;
        goto L138
    L130:
        r128 = "0";
        goto L131
    L126:
        r127 = "0";
        goto L127
    L122:
        r126 = "0";
        goto L123
    L118:
        r125 = "0";
        goto L119
    L114:
        r124 = "0";
        goto L115
    L110:
        r123 = "0";
        goto L111
    L100:
        if (r120 != 2) goto L102;
        Object r139 = "1";
    L103:
        r100.put("vs_is_portrait_content", r139);
        goto L104
    L102:
        r139 = "0";
        goto L103
    L85:
        r117 = false;
        goto L86
    L79:
        r116 = false;
        goto L80
    L70:
        r114 = false;
        goto L71
    L64:
        r113 = false;
        goto L65
    L58:
        r112 = false;
        goto L59
    L52:
        r111 = false;
        goto L53
    L46:
        r110 = false;
        goto L47
    L40:
        r109 = false;
        goto L41
    L34:
        r108 = false;
        goto L35
    L28:
        r107 = false;
        goto L29
    L22:
        r106 = false;
        goto L23
    L16:
        r105 = false;
        goto L17
    }

    public a0() {
        this.f4229a = "";
        this.f4230b = "";
        this.f4231c = "replay";
        this.f4232d = "";
        this.f4233e = "";
        this.f4234f = 1;
        this.f4235g = "";
        this.f4237i = "";
        this.f4238j = "";
        this.f4239k = "";
        this.f4240l = "";
        this.f4241m = "";
        this.f4243o = -1;
        this.f4244p = "";
        this.f4245q = "";
        this.f4246r = "";
        this.f4247s = "";
        this.f4248t = "";
        this.f4249u = "";
        this.f4250v = "";
        this.f4251w = "";
        this.f4253y = true;
        this.f4254z = "try";
        this.A = "";
        this.D = "";
    }
}
