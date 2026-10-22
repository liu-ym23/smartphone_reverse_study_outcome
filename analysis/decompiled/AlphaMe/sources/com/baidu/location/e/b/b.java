package com.baidu.location.e.b;

import com.baidu.location.e.b.a;

/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f5824a = -1;

    /* renamed from: b, reason: collision with root package name */
    private static int f5825b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static int f5826c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f5827d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static int f5828e = -1;

    /* renamed from: f, reason: collision with root package name */
    private static int f5829f = -1;

    /* renamed from: com.baidu.location.e.b.b$1, reason: invalid class name */
    public class AnonymousClass1 {
    }

    /* renamed from: com.baidu.location.e.b.b$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5830a;

        static {
            int[] iArr = new int[EnumC0016b.values().length];
            f5830a = iArr;
            try {
                iArr[EnumC0016b.SUBWAY_STATIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5830a[EnumC0016b.TRAFFIC_STATUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5830a[EnumC0016b.VDR_INDOOR_SPEED_STATUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5830a[EnumC0016b.INDOOR_POI_DATA_STATUS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5830a[EnumC0016b.OUTDOOR_POI_DATA_STATUS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5830a[EnumC0016b.GPS_CHECKER_STATUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f5831a = new b(null);
    }

    /* renamed from: com.baidu.location.e.b.b$b, reason: collision with other inner class name */
    public enum EnumC0016b {
        SUBWAY_STATIC,
        TRAFFIC_STATUS,
        VDR_INDOOR_SPEED_STATUS,
        INDOOR_POI_DATA_STATUS,
        OUTDOOR_POI_DATA_STATUS,
        GPS_CHECKER_STATUS
    }

    private b() {
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f5831a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String a(EnumC0016b enumC0016b) {
        switch (AnonymousClass2.f5830a[enumC0016b.ordinal()]) {
            case 1:
                if (f5824a == 0) {
                    return a.e.f5821b;
                }
                return null;
            case 2:
                if (f5825b == 0) {
                    return a.f.f5823b;
                }
                return null;
            case 3:
                if (f5826c == 0) {
                    return a.c.f5817b;
                }
                return null;
            case 4:
                if (f5827d == 0) {
                    return a.b.f5814a;
                }
                return null;
            case 5:
                if (f5828e == 0) {
                    return a.d.f5818a;
                }
                return null;
            case 6:
                if (f5829f == 0) {
                    return a.C0015a.f5812a;
                }
                return null;
            default:
                return null;
        }
    }
}
