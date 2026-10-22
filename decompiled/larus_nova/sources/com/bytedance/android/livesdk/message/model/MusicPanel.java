package com.bytedance.android.livesdk.message.model;

import android.graphics.Rect;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class MusicPanel {
    public Boolean A;
    public HashMap<String, py.k> B;
    public RealTimeChorusInfo C;
    public boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KtvMusic f153577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f153578b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f153579c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f153580d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f153581e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MusicPanelSource f153582f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f153583g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f153584h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Integer, Integer> f153585i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Object> f153586j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f153587k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f153588l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f153589m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f153590n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f153591o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f153592p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f153593q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f153594r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f153595s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f153596t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f153597u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Rect f153598v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f153599w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Integer f153600x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f153601y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f153602z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MusicPanel$MusicPanelSource;", "", "KSONG", "INTERACTIVE_SONG", "KTV", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum MusicPanelSource extends Enum<MusicPanelSource> {
        public static final MusicPanelSource INTERACTIVE_SONG = null;
        public static final MusicPanelSource KSONG = null;
        public static final MusicPanelSource KTV = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MusicPanelSource[] f153603a = null;

        static {
            MusicPanelSource r100 = new MusicPanelSource("KSONG", 0);
            KSONG = r100;
            MusicPanelSource r101 = new MusicPanelSource("INTERACTIVE_SONG", 1);
            INTERACTIVE_SONG = r101;
            MusicPanelSource r102 = new MusicPanelSource("KTV", 2);
            KTV = r102;
            f153603a = new MusicPanelSource[]{r100, r101, r102};
        }

        public static MusicPanelSource valueOf(String r100) {
            return (MusicPanelSource) r27.a.a(MusicPanelSource.class, r100);
        }

        public static MusicPanelSource[] values() {
            return (MusicPanelSource[]) f153603a.clone();
        }

        public MusicPanelSource(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/MusicPanel$Track;", "", "ALL_SUPPORT", "ORIGIN_ONLY", "ACCOMPANIMENT_ONLY", UserProfileEvent.POSITION_NONE, "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Track extends Enum<Track> {
        public static final Track ACCOMPANIMENT_ONLY = null;
        public static final Track ALL_SUPPORT = null;
        public static final Track NONE = null;
        public static final Track ORIGIN_ONLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Track[] f153604a = null;

        static {
            Track r100 = new Track("ALL_SUPPORT", 0);
            ALL_SUPPORT = r100;
            Track r101 = new Track("ORIGIN_ONLY", 1);
            ORIGIN_ONLY = r101;
            Track r102 = new Track("ACCOMPANIMENT_ONLY", 2);
            ACCOMPANIMENT_ONLY = r102;
            Track r103 = new Track(UserProfileEvent.POSITION_NONE, 3);
            NONE = r103;
            f153604a = new Track[]{r100, r101, r102, r103};
        }

        public static Track valueOf(String r100) {
            return (Track) r27.a.a(Track.class, r100);
        }

        public static Track[] values() {
            return (Track[]) f153604a.clone();
        }

        public Track(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public MusicPanel() {
        this(null, 0, null, false, null, null, null, 1073741823);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof MusicPanel) == false) goto L66;
        MusicPanel r101 = (MusicPanel) r100;
        if (Intrinsics.areEqual(this.f153577a, r101.f153577a) == true) goto L8;
        return false;
    L8:
        if (this.f153578b == r101.f153578b) goto L10;
        return false;
    L10:
        if (this.f153579c == r101.f153579c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f153580d, r101.f153580d) == true) goto L14;
        return false;
    L14:
        if (this.f153581e == r101.f153581e) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f153582f, r101.f153582f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f153583g, r101.f153583g) == true) goto L20;
        return false;
    L20:
        if (this.f153584h == r101.f153584h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f153585i, r101.f153585i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f153586j, r101.f153586j) == true) goto L26;
        return false;
    L26:
        if (this.f153587k == r101.f153587k) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f153588l, r101.f153588l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f153589m, r101.f153589m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f153590n, r101.f153590n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f153591o, r101.f153591o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f153592p, r101.f153592p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f153593q, r101.f153593q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f153594r, r101.f153594r) == true) goto L42;
        return false;
    L42:
        if (this.f153595s == r101.f153595s) goto L44;
        return false;
    L44:
        if (this.f153596t == r101.f153596t) goto L46;
        return false;
    L46:
        if (this.f153597u == r101.f153597u) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f153598v, r101.f153598v) == true) goto L50;
        return false;
    L50:
        if (this.f153599w == r101.f153599w) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f153600x, r101.f153600x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f153601y, r101.f153601y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f153602z, r101.f153602z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L64;
        return false;
    L64:
        if (this.D == r101.D) goto L100;
        return false;
    L100:
        return true;
    L66:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r0v60, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v2, types: [int] */
    /* JADX WARN: Type inference failed for: r2v46, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v76 */
    /* JADX WARN: Type inference failed for: r2v77 */
    /* JADX WARN: Type inference failed for: r2v87 */
    /* JADX WARN: Type inference failed for: r2v90 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r2v95 */
    /* JADX WARN: Type inference failed for: r2v96 */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        KtvMusic r100 = this.f153577a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f153578b) * 31;
        boolean r104 = this.f153579c;
        ?? r105 = 1;
        ?? r106 = r104;
        if (r104 == false) goto L9;
        r106 = 1;
    L9:
        int r107 = (r103 + r106) * 31;
        String r108 = this.f153580d;
        if (r108 == null) goto L12;
        int r109 = r108.hashCode();
    L13:
        int r110 = (r107 + r109) * 31;
        boolean r111 = this.f153581e;
        ?? r112 = r111;
        if (r111 == false) goto L16;
        r112 = 1;
    L16:
        int r113 = (r110 + r112) * 31;
        MusicPanelSource r114 = this.f153582f;
        if (r114 == null) goto L19;
        int r115 = r114.hashCode();
    L20:
        int r116 = (r113 + r115) * 31;
        String r117 = this.f153583g;
        if (r117 == null) goto L23;
        int r118 = r117.hashCode();
    L24:
        int r119 = (r116 + r118) * 31;
        boolean r120 = this.f153584h;
        ?? r121 = r120;
        if (r120 == false) goto L27;
        r121 = 1;
    L27:
        int r122 = (r119 + r121) * 31;
        Map<Integer, Integer> r123 = this.f153585i;
        if (r123 == null) goto L30;
        int r124 = r123.hashCode();
    L31:
        int r125 = (r122 + r124) * 31;
        Map<String, Object> r126 = this.f153586j;
        if (r126 == null) goto L34;
        int r127 = r126.hashCode();
    L35:
        int r128 = (((r125 + r127) * 31) + this.f153587k) * 31;
        String r129 = this.f153588l;
        if (r129 == null) goto L38;
        int r130 = r129.hashCode();
    L39:
        int r131 = (r128 + r130) * 31;
        String r132 = this.f153589m;
        if (r132 == null) goto L42;
        int r133 = r132.hashCode();
    L43:
        int r134 = (r131 + r133) * 31;
        String r135 = this.f153590n;
        if (r135 == null) goto L46;
        int r136 = r135.hashCode();
    L47:
        int r137 = (r134 + r136) * 31;
        String r138 = this.f153591o;
        if (r138 == null) goto L50;
        int r139 = r138.hashCode();
    L51:
        int r140 = (r137 + r139) * 31;
        String r141 = this.f153592p;
        if (r141 == null) goto L54;
        int r142 = r141.hashCode();
    L55:
        int r143 = (r140 + r142) * 31;
        String r144 = this.f153593q;
        if (r144 == null) goto L58;
        int r145 = r144.hashCode();
    L59:
        int r146 = (r143 + r145) * 31;
        String r147 = this.f153594r;
        if (r147 == null) goto L62;
        int r148 = r147.hashCode();
    L63:
        int r149 = (((r146 + r148) * 31) + this.f153595s) * 31;
        boolean r150 = this.f153596t;
        ?? r151 = r150;
        if (r150 == false) goto L66;
        r151 = 1;
    L66:
        int r152 = (r149 + r151) * 31;
        boolean r153 = this.f153597u;
        ?? r154 = r153;
        if (r153 == false) goto L69;
        r154 = 1;
    L69:
        int r155 = (r152 + r154) * 31;
        Rect r156 = this.f153598v;
        if (r156 == null) goto L72;
        int r157 = r156.hashCode();
    L73:
        long r158 = this.f153599w;
        int r159 = (((r155 + r157) * 31) + ((int) (r158 ^ (r158 >>> 32)))) * 31;
        Integer r160 = this.f153600x;
        if (r160 == null) goto L76;
        int r161 = r160.hashCode();
    L77:
        int r162 = (r159 + r161) * 31;
        String r163 = this.f153601y;
        if (r163 == null) goto L80;
        int r164 = r163.hashCode();
    L81:
        int r165 = (r162 + r164) * 31;
        String r166 = this.f153602z;
        if (r166 == null) goto L84;
        int r167 = r166.hashCode();
    L85:
        int r168 = (r165 + r167) * 31;
        Boolean r169 = this.A;
        if (r169 == null) goto L88;
        int r170 = r169.hashCode();
    L89:
        int r171 = (r168 + r170) * 31;
        HashMap<String, py.k> r172 = this.B;
        if (r172 == null) goto L92;
        int r173 = r172.hashCode();
    L93:
        int r174 = (r171 + r173) * 31;
        RealTimeChorusInfo r175 = this.C;
        if (r175 == null) goto L96;
        r101 = r175.hashCode();
    L96:
        int r176 = (r174 + r101) * 31;
        boolean r177 = this.D;
        if (r177 == true) goto L101;
        r105 = r177;
    L101:
        return r176 + r105;
    L92:
        r173 = 0;
        goto L93
    L88:
        r170 = 0;
        goto L89
    L84:
        r167 = 0;
        goto L85
    L80:
        r164 = 0;
        goto L81
    L76:
        r161 = 0;
        goto L77
    L72:
        r157 = 0;
        goto L73
    L62:
        r148 = 0;
        goto L63
    L58:
        r145 = 0;
        goto L59
    L54:
        r142 = 0;
        goto L55
    L50:
        r139 = 0;
        goto L51
    L46:
        r136 = 0;
        goto L47
    L42:
        r133 = 0;
        goto L43
    L38:
        r130 = 0;
        goto L39
    L34:
        r127 = 0;
        goto L35
    L30:
        r124 = 0;
        goto L31
    L23:
        r118 = 0;
        goto L24
    L19:
        r115 = 0;
        goto L20
    L12:
        r109 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String b() {
        StringBuilder r100 = new StringBuilder("");
        List<Long> r101 = this.f153577a.getArtistIds();
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.size();
    L6:
        int r104 = r103 - 1;
        List<Long> r105 = this.f153577a.getArtistIds();
        if (r105 == null) goto L19;
        Iterator<T> r106 = r105.iterator();
    L10:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        int r108 = r102 + 1;
        if (r102 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        r100.append(((Number) r107).longValue());
        if (r102 >= r104) goto L17;
        r100.append("");
    L17:
        r102 = r108;
    L19:
        return r100.toString();
    L5:
        r103 = 0;
        goto L6
    }

    public final long c() {
        return this.f153577a.getMId();
    }

    public final OrderInfo d() {
        KtvMusic r100 = this.f153577a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getOrderInfoFlex();
    }

    public final String e() {
        KtvMusic r100 = this.f153577a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getMTitle();
    }

    public final InteractiveSongUserInfo f() {
        KtvMusic r100 = this.f153577a;
        if (r100 == null) goto L7;
        OrderInfo r101 = r100.getOrderInfoFlex();
        if (r101 == null) goto L7;
        return r101.getTopUser();
    L7:
        return null;
    }

    public final String g() {
        KtvMusic r100 = this.f153577a;
        if (r100 == null) goto L9;
        OrderInfo r101 = r100.getOrderInfoFlex();
        if (r101 == null) goto L9;
        InteractiveSongUserInfo r102 = r101.getTopUser();
        if (r102 == null) goto L9;
        return r102.getIdString();
    L9:
        return null;
    }

    public final Track h() {
        boolean r100 = true;
        if (this.f153590n.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L15;
        if (this.f153591o.length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L15;
        return Track.ALL_SUPPORT;
    L10:
        r102 = false;
    L15:
        if (this.f153590n.length() <= 0) goto L17;
        boolean r103 = true;
    L18:
        if (r103 == false) goto L22;
        return Track.ORIGIN_ONLY;
    L22:
        if (this.f153591o.length() > 0) goto L25;
        r100 = false;
    L25:
        if (r100 == false) goto L29;
        return Track.ACCOMPANIMENT_ONLY;
    L29:
        return Track.NONE;
    L17:
        r103 = false;
        goto L18
    L5:
        r101 = false;
        goto L6
    }

    public final String toString() {
        return "MusicPanel(id = " + this.f153577a.getMId() + " , title = " + this.f153577a.getMTitle() + ')';
    }

    public static MusicPanel a(MusicPanel r310) {
        KtvMusic r100 = r310.f153577a;
        int r101 = r310.f153578b;
        boolean r102 = r310.f153579c;
        String r103 = r310.f153580d;
        boolean r104 = r310.f153581e;
        MusicPanelSource r105 = r310.f153582f;
        String r106 = r310.f153583g;
        boolean r107 = r310.f153584h;
        Map<Integer, Integer> r108 = r310.f153585i;
        Map<String, Object> r110 = r310.f153586j;
        int r111 = r310.f153587k;
        String r112 = r310.f153588l;
        String r113 = r310.f153589m;
        String r114 = r310.f153590n;
        String r115 = r310.f153591o;
        String r116 = r310.f153592p;
        String r117 = r310.f153593q;
        String r109 = r310.f153594r;
        int r118 = r310.f153595s;
        boolean r119 = r310.f153596t;
        boolean r120 = r310.f153597u;
        Rect r121 = r310.f153598v;
        long r122 = r310.f153599w;
        Integer r123 = r310.f153600x;
        String r124 = r310.f153601y;
        String r125 = r310.f153602z;
        Boolean r126 = r310.A;
        HashMap<String, py.k> r127 = r310.B;
        RealTimeChorusInfo r128 = r310.C;
        boolean r129 = r310.D;
        r310.getClass();
        Intrinsics.checkNotNullParameter(r100, "music");
        Intrinsics.checkNotNullParameter(r103, "fromRequestType");
        Intrinsics.checkNotNullParameter(r105, "source");
        Intrinsics.checkNotNullParameter(r108, "progressRecorder");
        Intrinsics.checkNotNullParameter(r112, "lrcLocalPath");
        Intrinsics.checkNotNullParameter(r113, "songLocalPath");
        Intrinsics.checkNotNullParameter(r114, "fullTrackLocalPath");
        Intrinsics.checkNotNullParameter(r115, "accompanimentTrackLocalPath");
        Intrinsics.checkNotNullParameter(r116, "vocalLocalPath");
        Intrinsics.checkNotNullParameter(r117, "midiLocalPath");
        Intrinsics.checkNotNullParameter(r109, "videoLocalPath");
        Intrinsics.checkNotNullParameter(r121, "rectForVisible");
        return new MusicPanel(r100, r101, r102, r103, r104, r105, r106, r107, r108, r110, r111, r112, r113, r114, r115, r116, r117, r109, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129);
    }

    public final void i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f153588l = r100;
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f153593q = r100;
    }

    public /* synthetic */ MusicPanel(KtvMusic r710, int r711, String r712, boolean r810, MusicPanelSource r811, String r812, Map r813, int r814) {
        if ((r814 & 1) == 0) goto L5;
        KtvMusic r410 = new KtvMusic(0, null, null, null, 0, null, null, 0, 0.0f, null, null, null, null, null, null, null, false, null, null, null, null, null, null, 0, null, 0, null, null, 0, null, null, null, null, null, null, -1, 7, null);
    L7:
        if ((r814 & 2) == 0) goto L9;
        int r411 = 1;
    L11:
        if ((r814 & 8) == 0) goto L13;
        String r412 = "推荐";
    L15:
        if ((r814 & 16) == 0) goto L17;
        boolean r413 = false;
    L19:
        if ((r814 & 32) == 0) goto L21;
        MusicPanelSource r510 = MusicPanelSource.KSONG;
    L23:
        if ((r814 & 64) == 0) goto L25;
        String r511 = null;
    L27:
        if ((r814 & 256) == 0) goto L29;
        Map r512 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(0, 0), TuplesKt.to(1, 0), TuplesKt.to(2, 0), TuplesKt.to(3, 0)});
    L31:
        if ((r814 & 512) == 0) goto L33;
        Map r513 = null;
    L35:
        if ((r814 & 1024) == 0) goto L37;
        int r514 = 100;
    L39:
        if ((r814 & 2048) == 0) goto L41;
        String r515 = "";
    L43:
        if ((r814 & 4096) == 0) goto L45;
        String r516 = "";
    L47:
        if ((r814 & 8192) == 0) goto L49;
        String r517 = "";
    L51:
        if ((r814 & 16384) == 0) goto L53;
        String r518 = "";
    L55:
        if ((32768 & r814) == 0) goto L57;
        String r610 = "";
    L59:
        if ((65536 & r814) == 0) goto L61;
        String r611 = "";
    L63:
        if ((131072 & r814) == 0) goto L65;
        String r612 = "";
    L67:
        if ((2097152 & r814) == 0) goto L69;
        Rect r613 = new Rect(-1, -1, -1, -1);
    L71:
        if ((r814 & 4194304) == 0) goto L73;
        long r100 = -1;
    L74:
        this(r410, r411, false, r412, r413, r510, r511, false, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, 0, false, false, r613, r100, null, null, null, null, null, null, false);
        return;
    L73:
        r100 = 0;
        goto L74
    L69:
        r613 = null;
        goto L71
    L65:
        r612 = null;
        goto L67
    L61:
        r611 = null;
        goto L63
    L57:
        r610 = null;
        goto L59
    L53:
        r518 = null;
        goto L55
    L49:
        r517 = null;
        goto L51
    L45:
        r516 = null;
        goto L47
    L41:
        r515 = null;
        goto L43
    L37:
        r514 = 0;
        goto L39
    L33:
        r513 = r813;
        goto L35
    L29:
        r512 = null;
        goto L31
    L25:
        r511 = r812;
        goto L27
    L21:
        r510 = r811;
        goto L23
    L17:
        r413 = r810;
        goto L19
    L13:
        r412 = r712;
        goto L15
    L9:
        r411 = r711;
        goto L11
    L5:
        r410 = r710;
        goto L7
    }

    public MusicPanel(KtvMusic r110, int r111, boolean r112, String r113, boolean r114, MusicPanelSource r210, String r211, boolean r212, Map<Integer, Integer> r213, Map<String, ? extends Object> r214, int r215, String r216, String r217, String r218, String r219, String r310, String r311, String r312, int r313, boolean r314, boolean r315, Rect r316, long r317, Integer r318, String r410, String r411, Boolean r412, HashMap<String, py.k> r413, RealTimeChorusInfo r414, boolean r415) {
        Intrinsics.checkNotNullParameter(r110, "music");
        Intrinsics.checkNotNullParameter(r113, "fromRequestType");
        Intrinsics.checkNotNullParameter(r210, "source");
        Intrinsics.checkNotNullParameter(r213, "progressRecorder");
        Intrinsics.checkNotNullParameter(r216, "lrcLocalPath");
        Intrinsics.checkNotNullParameter(r217, "songLocalPath");
        Intrinsics.checkNotNullParameter(r218, "fullTrackLocalPath");
        Intrinsics.checkNotNullParameter(r219, "accompanimentTrackLocalPath");
        Intrinsics.checkNotNullParameter(r310, "vocalLocalPath");
        Intrinsics.checkNotNullParameter(r311, "midiLocalPath");
        Intrinsics.checkNotNullParameter(r312, "videoLocalPath");
        Intrinsics.checkNotNullParameter(r316, "rectForVisible");
        this.f153577a = r110;
        this.f153578b = r111;
        this.f153579c = r112;
        this.f153580d = r113;
        this.f153581e = r114;
        this.f153582f = r210;
        this.f153583g = r211;
        this.f153584h = r212;
        this.f153585i = r213;
        this.f153586j = r214;
        this.f153587k = r215;
        this.f153588l = r216;
        this.f153589m = r217;
        this.f153590n = r218;
        this.f153591o = r219;
        this.f153592p = r310;
        this.f153593q = r311;
        this.f153594r = r312;
        this.f153595s = r313;
        this.f153596t = r314;
        this.f153597u = r315;
        this.f153598v = r316;
        this.f153599w = r317;
        this.f153600x = r318;
        this.f153601y = r410;
        this.f153602z = r411;
        this.A = r412;
        this.B = r413;
        this.C = r414;
        this.D = r415;
    }
}
