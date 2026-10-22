package com.bytedance.android.live.profit.fansclub;

import com.bytedance.android.live.soloktv.SoloKtvContext;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class FansClubEntranceParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Page f87233a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f87234b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f87235c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f87236d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f87237e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Entrance f87238f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f87239g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f87240h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f87241i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/FansClubEntranceParams$Entrance;", "", "Unspecified", "UserInfoFansClubWidget", "SubscribeEmojiPanel", "PersonalProfile", "UserInfoEcomFansClubWidget", "PkFullFeedView", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Entrance extends Enum<Entrance> {
        public static final Entrance PersonalProfile = null;
        public static final Entrance PkFullFeedView = null;
        public static final Entrance SubscribeEmojiPanel = null;
        public static final Entrance Unspecified = null;
        public static final Entrance UserInfoEcomFansClubWidget = null;
        public static final Entrance UserInfoFansClubWidget = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Entrance[] f87242a = null;

        static {
            Entrance r100 = new Entrance("Unspecified", 0);
            Unspecified = r100;
            Entrance r101 = new Entrance("UserInfoFansClubWidget", 1);
            UserInfoFansClubWidget = r101;
            Entrance r102 = new Entrance("SubscribeEmojiPanel", 2);
            SubscribeEmojiPanel = r102;
            Entrance r103 = new Entrance("PersonalProfile", 3);
            PersonalProfile = r103;
            Entrance r104 = new Entrance("UserInfoEcomFansClubWidget", 4);
            UserInfoEcomFansClubWidget = r104;
            Entrance r105 = new Entrance("PkFullFeedView", 5);
            PkFullFeedView = r105;
            f87242a = new Entrance[]{r100, r101, r102, r103, r104, r105};
        }

        public static Entrance valueOf(String r100) {
            return (Entrance) r27.a.a(Entrance.class, r100);
        }

        public static Entrance[] values() {
            return (Entrance[]) f87242a.clone();
        }

        public Entrance(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/profit/fansclub/FansClubEntranceParams$Page;", "", "Default", "VIP", "FansClub", "FansGroup", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum Page extends Enum<Page> {
        public static final Page Default = null;
        public static final Page FansClub = null;
        public static final Page FansGroup = null;
        public static final Page VIP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Page[] f87243a = null;

        static {
            Page r100 = new Page("Default", 0);
            Default = r100;
            Page r101 = new Page("VIP", 1);
            VIP = r101;
            Page r102 = new Page("FansClub", 2);
            FansClub = r102;
            Page r103 = new Page("FansGroup", 3);
            FansGroup = r103;
            f87243a = new Page[]{r100, r101, r102, r103};
        }

        public static Page valueOf(String r100) {
            return (Page) r27.a.a(Page.class, r100);
        }

        public static Page[] values() {
            return (Page[]) f87243a.clone();
        }

        public Page(String r100, int r101) {
            super(r100, r101);
        }
    }

    public /* synthetic */ FansClubEntranceParams(Page r110, boolean r111, String r112, String r113, Entrance r114, boolean r115, String r210, int r211) {
        if ((r211 & 2) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r211 & 4) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r211 & 8) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r211 & 16) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r211 & 32) == 0) goto L21;
        Entrance r104 = Entrance.Unspecified;
    L23:
        if ((r211 & 64) == 0) goto L25;
        boolean r116 = false;
    L27:
        if ((r211 & 128) == 0) goto L29;
        String r117 = "";
    L31:
        if ((r211 & 256) == 0) goto L33;
        String r118 = null;
    L34:
        this(r110, r100, r101, r102, r103, r104, r116, r117, r118);
        return;
    L33:
        r118 = r210;
        goto L34
    L29:
        r117 = null;
        goto L31
    L25:
        r116 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = null;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public FansClubEntranceParams(Page r100, boolean r101, String r102, String r103, String r104, Entrance r105, boolean r106, String r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, "page");
        Intrinsics.checkNotNullParameter(r102, "requestPage");
        Intrinsics.checkNotNullParameter(r103, "eventModule");
        Intrinsics.checkNotNullParameter(r104, ReportConstant.COMMON_ACTION_TYPE);
        Intrinsics.checkNotNullParameter(r105, SoloKtvContext.SOLO_PAGE_ENTRANCE);
        Intrinsics.checkNotNullParameter(r107, "joinActionFrom");
        this.f87233a = r100;
        this.f87234b = r101;
        this.f87235c = r102;
        this.f87236d = r103;
        this.f87237e = r104;
        this.f87238f = r105;
        this.f87239g = r106;
        this.f87240h = r107;
        this.f87241i = r110;
    }
}
