package com.bytedance.api.location;

import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import r27.a;

/* JADX INFO: loaded from: classes14.dex */
public final class ByteLocationClientOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f190161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LocationOption f190162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile int f190163c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f190164d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LocationMode f190165e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f190166f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f190167g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f190168h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LocationExtraBean f190169i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f190170j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f190171k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f190172l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f190173m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Object f190174n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public long f190175o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public LocationTraceLogger f190176p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f190177q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public BDLocationExtraDataServer f190178r;

    public static final enum LocationMode extends Enum<LocationMode> {
        public static final LocationMode Battery_Saving = null;
        public static final LocationMode Device_Sensors = null;
        public static final LocationMode Hight_Accuracy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LocationMode[] f190179a = null;

        static {
            LocationMode r100 = new LocationMode("Battery_Saving", 0);
            Battery_Saving = r100;
            LocationMode r101 = new LocationMode("Device_Sensors", 1);
            Device_Sensors = r101;
            LocationMode r102 = new LocationMode("Hight_Accuracy", 2);
            Hight_Accuracy = r102;
            f190179a = new LocationMode[]{r100, r101, r102};
        }

        public static LocationMode[] values() {
            return (LocationMode[]) f190179a.clone();
        }

        public static LocationMode valueOf(String r100) {
            return (LocationMode) a.a(LocationMode.class, r100);
        }

        public LocationMode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String a() {
        int r100 = this.f190163c;
        if (r100 != 0) goto L5;
        return "init";
    L5:
        if (r100 != 1) goto L7;
        return "requesting_network";
    L7:
        if (r100 != 2) goto L9;
        return "requesting_gps";
    L9:
        if (r100 != 3) goto L11;
        return "requesting_both";
    L11:
        if (r100 != 5) goto L13;
        return "cancel";
    L13:
        if (r100 != 6) goto L15;
        return "end";
    L15:
        return String.valueOf(this.f190163c);
    }

    public ByteLocationClientOption(LocationOption r100) {
        this.f190163c = 0;
        this.f190164d = 0;
        this.f190165e = LocationMode.Battery_Saving;
        this.f190166f = 10000;
        this.f190171k = 1;
        this.f190172l = true;
        this.f190162b = r100;
    }
}
