package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.ss.android.cert.manager.constants.EventConstant;
import n4a.c4;
import n4a.e4;
import n4a.h4;
import n4a.j4;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes28.dex */
public class CoordinateConverter {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f26761b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f26762c = 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f26763d = 2;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static int f26764e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static int f26765f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f26766g = 16;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static int f26767h = 32;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static int f26768i = 64;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    DPoint f26769a;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f26770j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CoordType f26771k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private DPoint f26772l;

    /* JADX INFO: renamed from: com.amap.api.location.CoordinateConverter$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f26773a = null;

        static {
            int[] r100 = new int[CoordType.values().length];
            f26773a = r100;
            r100[CoordType.BAIDU.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f26773a[CoordType.MAPBAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f26773a[CoordType.MAPABC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f26773a[CoordType.SOSOMAP.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f26773a[CoordType.ALIYUN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f26773a[CoordType.GOOGLE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f26773a[CoordType.GPS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public static final enum CoordType extends Enum<CoordType> {
        public static final CoordType ALIYUN = null;
        public static final CoordType BAIDU = null;
        public static final CoordType GOOGLE = null;
        public static final CoordType GPS = null;
        public static final CoordType MAPABC = null;
        public static final CoordType MAPBAR = null;
        public static final CoordType SOSOMAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ CoordType[] f26774a = null;

        static {
            CoordType r100 = new CoordType("BAIDU", 0);
            BAIDU = r100;
            CoordType r101 = new CoordType("MAPBAR", 1);
            MAPBAR = r101;
            CoordType r102 = new CoordType("MAPABC", 2);
            MAPABC = r102;
            CoordType r103 = new CoordType("SOSOMAP", 3);
            SOSOMAP = r103;
            CoordType r104 = new CoordType("ALIYUN", 4);
            ALIYUN = r104;
            CoordType r105 = new CoordType("GOOGLE", 5);
            GOOGLE = r105;
            CoordType r110 = new CoordType("GPS", 6);
            GPS = r110;
            f26774a = new CoordType[]{r100, r101, r102, r103, r104, r105, r110};
        }

        private CoordType(String r100, int r101) {
            super(r100, r101);
        }

        public static CoordType valueOf(String r100) {
            return (CoordType) a.a(CoordType.class, r100);
        }

        public static CoordType[] values() {
            return (CoordType[]) f26774a.clone();
        }
    }

    public CoordinateConverter(Context r100) {
        this.f26771k = null;
        this.f26772l = null;
        this.f26769a = null;
        this.f26770j = r100;
    }

    public static float calculateLineDistance(DPoint r100, DPoint r101) {
        return j4.b(r100, r101);
    L4:
        return 0.0f;
    }

    public static boolean isAMapDataAvailable(double r100, double r101) {
        return c4.h(r100, r101);
    }

    public synchronized DPoint convert() throws Exception {
        monitor-enter(this);
    L68:
        th = move-exception;
        throw th;
    L4:
        if (this.f26771k == null) goto L67;
        DPoint r100 = this.f26772l;     // Catch: Throwable -> L68
        if (r100 == null) goto L65;
        if (r100.getLongitude() > 180.0d) goto L63;
        if (this.f26772l.getLongitude() < (-180.0d)) goto L63;
        if (this.f26772l.getLatitude() > 90.0d) goto L61;
        if (this.f26772l.getLatitude() < (-90.0d)) goto L61;
        boolean r101 = true;
        String r102 = null;
        switch(AnonymousClass1.f26773a[this.f26771k.ordinal()]) {
            case 1: goto L48;
            case 2: goto L44;
            case 3: goto L39;
            case 4: goto L34;
            case 5: goto L29;
            case 6: goto L24;
            case 7: goto L18;
            default: goto L51;
        };     // Catch: Throwable -> L68
    L18:
        int r103 = f26761b;     // Catch: Throwable -> L68
        int r104 = f26768i;     // Catch: Throwable -> L68
        if ((r103 & r104) != 0) goto L21;
        r102 = GeocodeSearch.GPS;
        f26761b = r103 | r104;     // Catch: Throwable -> L68
    L22:
        DPoint r105 = e4.b(this.f26770j, this.f26772l);     // Catch: Throwable -> L68
    L23:
        this.f26769a = r105;     // Catch: Throwable -> L68
    L52:
        if (r101 == false) goto L57;
        JSONObject r106 = new JSONObject();     // Catch: Throwable -> L68
        if (TextUtils.isEmpty(r102) == true) goto L56;
        r106.put("amap_loc_coordinate", r102);     // Catch: Throwable -> L68
    L56:
        h4.i(this.f26770j, "O021", r106);     // Catch: Throwable -> L68
    L57:
        DPoint r107 = this.f26769a;     // Catch: Throwable -> L68
        monitor-exit(this);
        return r107;
    L21:
        r101 = false;
        goto L22
    L24:
        int r108 = f26761b;     // Catch: Throwable -> L68
        int r109 = f26767h;     // Catch: Throwable -> L68
        if ((r108 & r109) != 0) goto L27;
        r102 = "google";
        f26761b = r108 | r109;     // Catch: Throwable -> L68
    L28:
        r105 = this.f26772l;     // Catch: Throwable -> L68
        goto L23
    L27:
        r101 = false;
        goto L28
    L29:
        int r110 = f26761b;     // Catch: Throwable -> L68
        int r111 = f26766g;     // Catch: Throwable -> L68
        if ((r110 & r111) != 0) goto L32;
        r102 = EventConstant.Value.ALIYUN;
        f26761b = r110 | r111;     // Catch: Throwable -> L68
    L33:
        r105 = this.f26772l;     // Catch: Throwable -> L68
        goto L23
    L32:
        r101 = false;
        goto L33
    L34:
        int r112 = f26761b;     // Catch: Throwable -> L68
        int r113 = f26765f;     // Catch: Throwable -> L68
        if ((r112 & r113) != 0) goto L37;
        r102 = "sosomap";
        f26761b = r112 | r113;     // Catch: Throwable -> L68
    L38:
        r105 = this.f26772l;     // Catch: Throwable -> L68
        goto L23
    L37:
        r101 = false;
        goto L38
    L39:
        int r114 = f26761b;     // Catch: Throwable -> L68
        int r115 = f26764e;     // Catch: Throwable -> L68
        if ((r114 & r115) != 0) goto L42;
        r102 = "mapabc";
        f26761b = r114 | r115;     // Catch: Throwable -> L68
    L43:
        r105 = this.f26772l;     // Catch: Throwable -> L68
        goto L23
    L42:
        r101 = false;
        goto L43
    L44:
        this.f26769a = e4.e(this.f26770j, this.f26772l);     // Catch: Throwable -> L68
        int r116 = f26761b;     // Catch: Throwable -> L68
        int r117 = f26763d;     // Catch: Throwable -> L68
        if ((r116 & r117) != 0) goto L51;
        r102 = "mapbar";
    L47:
        f26761b = r116 | r117;     // Catch: Throwable -> L68
        goto L52
    L48:
        this.f26769a = e4.c(this.f26772l);     // Catch: Throwable -> L68
        r116 = f26761b;     // Catch: Throwable -> L68
        r117 = f26762c;     // Catch: Throwable -> L68
        if ((r116 & r117) != 0) goto L51;
        r102 = "baidu";
    L51:
        r101 = false;
    L61:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L68
    L63:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L68
    L65:
        throw new IllegalArgumentException("转换坐标源不能为空");     // Catch: Throwable -> L68
    L67:
        throw new IllegalArgumentException("转换坐标类型不能为空");     // Catch: Throwable -> L68
    }

    public synchronized CoordinateConverter coord(DPoint r100) throws Exception {
        monitor-enter(this);
        if (r100 == null) goto L22;
        if (r100.getLongitude() > 180.0d) goto L18;
        if (r100.getLongitude() < (-180.0d)) goto L18;
        if (r100.getLatitude() > 90.0d) goto L16;
        if (r100.getLatitude() < (-90.0d)) goto L16;
        this.f26772l = r100;     // Catch: Throwable -> L19
        monitor-exit(this);
        return this;
    L16:
        throw new IllegalArgumentException("请传入合理纬度");     // Catch: Throwable -> L19
    L18:
        throw new IllegalArgumentException("请传入合理经度");     // Catch: Throwable -> L19
    L22:
        throw new IllegalArgumentException("传入经纬度对象为空");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public synchronized CoordinateConverter from(CoordType r100) {
        monitor-enter(this);
        this.f26771k = r100;     // Catch: Throwable -> L6
        monitor-exit(this);
        return this;
    L6:
        th = move-exception;
        throw th;
    }
}
