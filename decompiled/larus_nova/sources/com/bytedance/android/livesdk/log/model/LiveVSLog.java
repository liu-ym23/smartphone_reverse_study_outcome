package com.bytedance.android.livesdk.log.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.android.livesdk.chatroom.model.EnterRoomExtra;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.EpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IBaseEpisodeMod;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.paid.PaidReplayConstants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/log/model/LiveVSLog;", "Landroid/os/Parcelable;", "b", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveVSLog implements Parcelable {
    public static final Parcelable.Creator<LiveVSLog> CREATOR = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static boolean f153391p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String[] f153392q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final b f153393r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f153394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f153395b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f153396c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f153397d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f153398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f153399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f153400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f153401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f153402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f153403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f153404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f153405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f153406m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f153407n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f153408o;

    public static final class a implements Parcelable.Creator<LiveVSLog> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final LiveVSLog createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            Intrinsics.checkNotNullParameter(r110, "parcel");
            String r100 = r110.readString();
            if (r100 != null) goto L5;
            String r101 = "";
        L6:
            String r102 = r110.readString();
            if (r102 != null) goto L9;
            String r103 = "";
        L10:
            String r104 = r110.readString();
            if (r104 != null) goto L13;
            String r105 = "";
        L14:
            String r106 = r110.readString();
            if (r106 != null) goto L17;
            String r107 = "";
        L18:
            String r108 = r110.readString();
            if (r108 != null) goto L21;
            String r109 = "";
        L22:
            String r111 = r110.readString();
            if (r111 != null) goto L25;
            String r112 = "";
        L26:
            int r113 = r110.readInt();
            int r114 = r110.readInt();
            int r115 = r110.readInt();
            String r116 = r110.readString();
            if (r116 != null) goto L29;
            String r117 = "";
        L30:
            String r118 = r110.readString();
            if (r118 != null) goto L33;
            String r119 = "";
        L34:
            long r120 = r110.readLong();
            String r121 = r110.readString();
            if (r121 != null) goto L37;
            r121 = "";
        L37:
            LiveVSLog r122 = new LiveVSLog(r101, r103, r105, r107, r109, r112, r113, r114, r115, r117, r119, r120, r121);
            boolean r123 = false;
            if (r110.readByte() == ((byte) 0)) goto L40;
            r123 = true;
        L40:
            r122.f153394a = r123;
            r122.f153395b = r110.readInt();
            return r122;
        L33:
            r119 = r118;
            goto L34
        L29:
            r117 = r116;
            goto L30
        L25:
            r112 = r111;
            goto L26
        L21:
            r109 = r108;
            goto L22
        L17:
            r107 = r106;
            goto L18
        L13:
            r105 = r104;
            goto L14
        L9:
            r103 = r102;
            goto L10
        L5:
            r101 = r100;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final LiveVSLog[] newArray(int r100) {
            return new LiveVSLog[r100];
        }
    }

    public static final class b {
        public b() {
        }

        public static LiveVSLog a(Room r100) {
            Intrinsics.checkNotNullParameter(r100, "room");
            LiveVSLog r101 = new LiveVSLog(null, null, null, null, 0, 8191);
            EpisodeExtraInfo r102 = r100.getEpisodeExtra2();
            long r103 = -1;
            if (r102 == null) goto L5;
            long r104 = r102.getId();
        L6:
            String r105 = String.valueOf(r104);
            Intrinsics.checkNotNullParameter(r105, "<set-?>");
            r101.f153398e = r105;
            EpisodeExtraInfo r106 = r100.getEpisodeExtra2();
            String r107 = "";
            if (r106 == null) goto L10;
            String r108 = r106.getItemId();
            if (r108 == null) goto L10;
        L11:
            Intrinsics.checkNotNullParameter(r108, "<set-?>");
            r101.f153396c = r108;
            String r109 = String.valueOf(r100.f162599id);
            Intrinsics.checkNotNullParameter(r109, "<set-?>");
            r101.f153397d = r109;
            EpisodeExtraInfo r110 = r100.getEpisodeExtra2();
            if (r110 == null) goto L19;
            Long r111 = r110.getSeasonId();
            if (r111 == null) goto L19;
            String r112 = String.valueOf(r111.longValue());
            if (r112 == null) goto L19;
            r107 = r112;
        L19:
            Intrinsics.checkNotNullParameter(r107, "<set-?>");
            r101.f153399f = r107;
            EpisodeExtraInfo r113 = r100.getEpisodeExtra2();
            if (r113 == null) goto L22;
            r103 = r113.getId();
        L22:
            String r114 = String.valueOf(r103);
            Intrinsics.checkNotNullParameter(r114, "<set-?>");
            r101.f153398e = r114;
            EpisodeExtraInfo r115 = r100.getEpisodeExtra2();
            int r116 = -1;
            if (r115 == null) goto L27;
            IBaseEpisodeMod r117 = r115.getMod();
            if (r117 == null) goto L27;
            int r118 = r117.getEpisodeStage();
        L28:
            r101.f153402i = r118;
            LiveVSLog.f153393r.getClass();
            r101.f153404k = b(r100);
            EpisodeExtraInfo r119 = r100.getEpisodeExtra2();
            if (r119 == null) goto L31;
            boolean r120 = r119.isInteractConfigExist();
        L32:
            r101.f153394a = r120;
            EpisodeExtraInfo r121 = r100.getEpisodeExtra2();
            if (r121 == null) goto L37;
            IBaseEpisodeMod r122 = r121.getMod();
            if (r122 == null) goto L37;
            r116 = r122.getEpisodeSubType();
        L37:
            r101.f153395b = r116;
            return r101;
        L31:
            r120 = false;
        L27:
            r118 = -1;
        L10:
            r108 = "";
            goto L11
        L5:
            r104 = -1;
            goto L6
        }

        public static int b(IRoom r100) {
            int r101 = 0;
            if (r100 != null) goto L5;
            return 0;
        L5:
            int r102 = 1;
            Integer r103 = null;
            if (LiveVSLog.f153391p == false) goto L23;
            IBaseStreamUrl r104 = r100.getStreamUrl();
            if (r104 == null) goto L10;
            r103 = Integer.valueOf(r104.getStreamOrientation());
        L10:
            if (r103 != null) goto L13;
        L15:
            if (r103 != null) goto L18;
        L21:
            if (r100.isVrRoom() == false) goto L53;
            return 2;
        L53:
            return r101;
        L18:
            if (r103.intValue() != 2) goto L21;
            r101 = 1;
            goto L21
        L13:
            if (r103.intValue() != 1) goto L15;
            r101 = 2;
            goto L21
        L23:
            IEpisodeExtraInfo r105 = r100.getEpisodeComponentData();
            if (r105 == null) goto L45;
            if (r105.getStyle() != 0) goto L45;
            IEpisodeExtraInfo r106 = r100.getEpisodeComponentData();
            if (r106 == null) goto L45;
            IBaseStreamUrl r107 = r100.getStreamUrl();
            if (r107 == null) goto L32;
            r103 = Integer.valueOf(r107.getStreamOrientation());
        L32:
            if (r103 != null) goto L35;
        L37:
            if (r103 != null) goto L40;
        L42:
            r102 = 0;
        L43:
            r106.setStyle(r102);
            goto L45
        L40:
            if (r103.intValue() != 2) goto L42;
        L35:
            if (r103.intValue() != 1) goto L37;
            r102 = 2;
        L45:
            if (r100.isVrRoom() == false) goto L49;
            IEpisodeExtraInfo r108 = r100.getEpisodeComponentData();
            if (r108 == null) goto L49;
            r108.setStyle(2);
        L49:
            IEpisodeExtraInfo r109 = r100.getEpisodeComponentData();
            if (r109 != null) goto L52;
            return 0;
        L52:
            return r109.getStyle();
        }

        public static void c(LiveVSLog r100, Map r101) {
            if (r101 != null) goto L4;
            return;
        L4:
            String[] r102 = LiveVSLog.f153392q;
            int r103 = r102.length;
            int r104 = 0;
        L5:
            if (r104 >= r103) goto L7;
            r101.remove(r102[r104]);
            r104 = r104 + 1;
            goto L5
        L7:
            if (r100 != null) goto L9;
            return;
        L9:
            r101.putAll(r100.a());
        }
    }

    public LiveVSLog() {
        this(null, null, null, null, 0, 8191);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    static {
        f153393r = new b();
        CREATOR = new a();
        f153392q = new String[]{"vs_episode_id", "vs_ep_group_id", "vs_season_id", "vs_episode_stage", "vs_is_portraid_content", "vs_from_episode_id", "vs_is_chatroom", "is_vs", "vs_is_auto_play", "vs_from_others_homepage_uid", "vs_machine_id", "vs_episode_sub_type", PaidReplayConstants.KEY_VS_MACHINE_TYPE, "from_vs_machine_id", "from_vs_machine_type"};
    }

    public final Map<String, String> a() {
        HashMap r100 = new HashMap();
        boolean r101 = false;
        if (this.f153398e.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        r100.put("vs_episode_id", this.f153398e);
    L9:
        if (this.f153396c.length() <= 0) goto L11;
        boolean r103 = true;
    L12:
        if (r103 == false) goto L15;
        r100.put("vs_ep_group_id", this.f153396c);
    L15:
        if (this.f153399f.length() <= 0) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L20;
        r100.put("vs_season_id", this.f153399f);
    L20:
        int r105 = this.f153402i;
        int r106 = EpisodeMod.EpisodeStageType.LIVE;
        String r107 = EnterRoomExtra.VS_TYPE_PREMIERE;
        String r108 = "";
        if (r105 != r106) goto L24;
        String r109 = "live";
    L31:
        if (r109.length() <= 0) goto L33;
        boolean r110 = true;
    L34:
        if (r110 == false) goto L46;
        int r111 = this.f153402i;
        if (r111 != EpisodeMod.EpisodeStageType.LIVE) goto L39;
        r107 = "live";
    L45:
        r100.put("vs_episode_stage", r107);
        goto L46
    L39:
        if (r111 != EpisodeMod.EpisodeStageType.RECORD) goto L42;
        r107 = "record";
        goto L45
    L42:
        if (r111 == EpisodeMod.EpisodeStageType.PREMIERE) goto L45;
        r107 = "";
    L46:
        int r112 = this.f153404k;
        if (r112 < 0) goto L54;
        if (r112 != 2) goto L51;
        Object r113 = "1";
    L52:
        r100.put("vs_is_portraid_content", r113);
        goto L54
    L51:
        r113 = "0";
    L54:
        if (this.f153401h.length() <= 0) goto L56;
        boolean r114 = true;
    L57:
        if (r114 == false) goto L60;
        r100.put("vs_from_episode_id", this.f153401h);
    L60:
        if (this.f153400g.length() <= 0) goto L62;
        boolean r115 = true;
    L63:
        if (r115 == false) goto L66;
        r100.put("video_id", this.f153400g);
    L66:
        if (this.f153405l.length() <= 0) goto L68;
        boolean r116 = true;
    L69:
        if (r116 == false) goto L72;
        r100.put("vs_from_others_homepage_uid", this.f153405l);
    L72:
        if (this.f153406m.length() <= 0) goto L74;
        boolean r117 = true;
    L75:
        if (r117 == false) goto L77;
        r100.put("previous_page", this.f153406m);
    L77:
        r100.put("is_vs", "1");
        r100.put("vs_is_auto_play", "0");
        if (this.f153394a == false) goto L80;
        r100.put("vs_interact_config_exist", "1");
    L81:
        int r118 = this.f153395b;
        if (r118 != EpisodeMod.EpisodeSubType.GUIDE) goto L85;
        String r119 = "pilot_file";
    L92:
        if (r119.length() <= 0) goto L94;
        r101 = true;
    L94:
        if (r101 == false) goto L105;
        int r120 = this.f153395b;
        if (r120 != EpisodeMod.EpisodeSubType.GUIDE) goto L99;
        r108 = "pilot_file";
    L104:
        r100.put("vs_episode_sub_type", r108);
        goto L105
    L99:
        if (r120 != EpisodeMod.EpisodeSubType.NORMAL) goto L102;
        r108 = "normal";
        goto L104
    L102:
        if (r120 != EpisodeMod.EpisodeSubType.UNKNOWN) goto L104;
        r108 = "unknown";
    L105:
        return r100;
    L85:
        if (r118 != EpisodeMod.EpisodeSubType.NORMAL) goto L88;
        r119 = "normal";
        goto L92
    L88:
        if (r118 != EpisodeMod.EpisodeSubType.UNKNOWN) goto L90;
        r119 = "unknown";
        goto L92
    L90:
        r119 = "";
        goto L92
    L80:
        r100.put("vs_interact_config_exist", "0");
        goto L81
    L74:
        r117 = false;
        goto L75
    L68:
        r116 = false;
        goto L69
    L62:
        r115 = false;
        goto L63
    L56:
        r114 = false;
        goto L57
    L33:
        r110 = false;
        goto L34
    L24:
        if (r105 != EpisodeMod.EpisodeStageType.RECORD) goto L27;
        r109 = "record";
        goto L31
    L27:
        if (r105 != EpisodeMod.EpisodeStageType.PREMIERE) goto L29;
        r109 = EnterRoomExtra.VS_TYPE_PREMIERE;
        goto L31
    L29:
        r109 = "";
        goto L31
    L17:
        r104 = false;
        goto L18
    L11:
        r103 = false;
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        r100.writeString(this.f153396c);
        r100.writeString(this.f153397d);
        r100.writeString(this.f153398e);
        r100.writeString(this.f153399f);
        r100.writeString(this.f153400g);
        r100.writeString(this.f153401h);
        r100.writeInt(this.f153402i);
        r100.writeInt(this.f153403j);
        r100.writeInt(this.f153404k);
        r100.writeString(this.f153405l);
        r100.writeString(this.f153406m);
        r100.writeLong(this.f153407n);
        r100.writeString(this.f153408o);
        r100.writeByte(this.f153394a ? 1 : 0);
        r100.writeInt(this.f153395b);
    }

    public /* synthetic */ LiveVSLog(String r110, String r210, String r211, String r212, int r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        String r105 = "";
    L27:
        if ((r214 & 64) == 0) goto L29;
        int r106 = -1;
    L30:
        int r111 = 0;
        if ((r214 & 128) == 0) goto L33;
        int r112 = -1;
    L35:
        if ((r214 & 256) == 0) goto L38;
        r111 = -1;
    L38:
        if ((r214 & 512) == 0) goto L40;
        String r113 = "";
    L42:
        if ((r214 & 1024) == 0) goto L44;
        String r114 = "";
    L46:
        if ((r214 & 4096) == 0) goto L48;
        String r115 = "";
    L49:
        this(r100, r101, r102, r103, r104, r105, r106, r112, r111, r113, r114, 0, r115);
        return;
    L48:
        r115 = null;
        goto L49
    L44:
        r114 = null;
        goto L46
    L40:
        r113 = null;
        goto L42
    L33:
        r112 = 0;
        goto L35
    L29:
        r106 = r213;
        goto L30
    L25:
        r105 = null;
        goto L27
    L21:
        r104 = null;
        goto L23
    L17:
        r103 = r212;
        goto L19
    L13:
        r102 = r211;
        goto L15
    L9:
        r101 = r210;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public LiveVSLog(String r100, String r101, String r102, String r103, String r104, String r105, int r106, int r107, int r110, String r111, String r112, long r113, String r114) {
        Intrinsics.checkNotNullParameter(r100, "episodeGroupId");
        Intrinsics.checkNotNullParameter(r101, "roomId");
        Intrinsics.checkNotNullParameter(r102, "episodeId");
        Intrinsics.checkNotNullParameter(r103, "seasonId");
        Intrinsics.checkNotNullParameter(r104, "videoId");
        Intrinsics.checkNotNullParameter(r105, "fromEpisodeId");
        Intrinsics.checkNotNullParameter(r111, "fromOtherHomepageUid");
        Intrinsics.checkNotNullParameter(r112, "previousPage");
        Intrinsics.checkNotNullParameter(r114, "cameraType");
        this.f153396c = r100;
        this.f153397d = r101;
        this.f153398e = r102;
        this.f153399f = r103;
        this.f153400g = r104;
        this.f153401h = r105;
        this.f153402i = r106;
        this.f153403j = r107;
        this.f153404k = r110;
        this.f153405l = r111;
        this.f153406m = r112;
        this.f153407n = r113;
        this.f153408o = r114;
        this.f153395b = -1;
    }
}
