package com.baidu.mapapi.utils;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import com.baidu.platform.comapi.location.CoordinateType;

/* JADX INFO: loaded from: classes39.dex */
public class CoordinateConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f31701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private CoordType f31702b;

    public static final enum CoordType extends Enum<CoordType> {
        private static final /* synthetic */ CoordType[] $VALUES = null;
        public static final CoordType BD09LL = null;
        public static final CoordType BD09MC = null;
        public static final CoordType COMMON = null;
        public static final CoordType GPS = null;

        static {
            CoordType r100 = new CoordType("GPS", 0);
            GPS = r100;
            CoordType r101 = new CoordType("COMMON", 1);
            COMMON = r101;
            CoordType r102 = new CoordType("BD09LL", 2);
            BD09LL = r102;
            CoordType r103 = new CoordType("BD09MC", 3);
            BD09MC = r103;
            $VALUES = new CoordType[]{r100, r101, r102, r103};
        }

        public static CoordType[] values() {
            return (CoordType[]) $VALUES.clone();
        }

        public static CoordType valueOf(String r100) {
            return (CoordType) r27.a.a(CoordType.class, r100);
        }

        private CoordType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31703a = null;

        static {
            int[] r100 = new int[CoordType.values().length];
            f31703a = r100;
            r100[CoordType.COMMON.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f31703a[CoordType.GPS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f31703a[CoordType.BD09LL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f31703a[CoordType.BD09MC.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public LatLng convert() {
        if (this.f31701a != null) goto L6;
        return null;
    L6:
        if (this.f31702b != null) goto L8;
        this.f31702b = CoordType.GPS;
    L8:
        int r100 = a.f31703a[this.f31702b.ordinal()];
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        return null;
    L18:
        return b(this.f31701a);
    L20:
        return a(this.f31701a);
    L22:
        return d(this.f31701a);
    L24:
        return c(this.f31701a);
    }

    public CoordinateConverter() {
    }

    private static LatLng a(LatLng r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return CoordTrans.baiduToGcj(r100);
    }

    private static LatLng b(LatLng r100) {
        return a(r100, CoordinateType.BD09MC);
    }

    private static LatLng c(LatLng r100) {
        return a(r100, "gcj02");
    }

    private static LatLng d(LatLng r100) {
        return a(r100, "wgs84");
    }

    public CoordinateConverter coord(LatLng r100) {
        this.f31701a = r100;
        return this;
    }

    public CoordinateConverter from(CoordType r100) {
        this.f31702b = r100;
        return this;
    }

    private static LatLng a(LatLng r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return CoordUtil.Coordinate_encryptEx((float) r100.longitude, (float) r100.latitude, r101);
    }
}
