package com.bytedance.apm6.cpu.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: CpuCacheItem.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0128a f5183a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double f5184b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f5185c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f5186d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f5187e;
    private String f;
    private long g;
    private int h;

    /* JADX INFO: renamed from: com.bytedance.apm6.cpu.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CpuCacheItem.java */
    public static final enum EnumC0128a extends Enum<EnumC0128a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0128a f5188a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0128a f5189b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0128a f5190c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0128a[] f5191d = null;

        private EnumC0128a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0128a valueOf(String r2) {
            return (EnumC0128a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0128a.class, r2), EnumC0128a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0128a[] values() {
            return (EnumC0128a[]) ZeusTransformUtils.preCheckCast(f5191d.clone(), EnumC0128a[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC0128a r0 = new EnumC0128a("MIX", 0);
            f5188a = r0;
            EnumC0128a r1 = new EnumC0128a("FRONT", 1);
            f5189b = r1;
            EnumC0128a r3 = new EnumC0128a("BACK", 2);
            f5190c = r3;
            f5191d = new EnumC0128a[]{r0, r1, r3};
        }
    }

    public a(EnumC0128a r2, long r3) {
        this.h = 0;
        this.f5183a = r2;
        this.g = r3;
        this.h = 0;
    }

    public a a(String r1) {
        this.f = r1;
        return this;
    }

    public EnumC0128a getType() {
        return this.f5183a;
    }

    public double a() {
        return this.f5184b;
    }

    public double b() {
        return this.f5185c;
    }

    public double c() {
        return this.f5186d;
    }

    public double d() {
        return this.f5187e;
    }

    public String e() {
        return this.f;
    }

    public long f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public void h() {
        this.h++;
    }

    public void a(double r3) {
        if (r3 >= 0.0d) goto L5;
        return;
    L5:
        this.f5184b += r3;
    }

    public void b(double r3) {
        if (this.f5185c >= r3) goto L6;
        this.f5185c = r3;
        return;
    }

    public void c(double r3) {
        if (r3 >= 0.0d) goto L5;
        return;
    L5:
        this.f5186d += r3;
    }

    public void d(double r3) {
        if (this.f5187e >= r3) goto L6;
        this.f5187e = r3;
        return;
    }

    public String toString() {
        return "CpuCacheItem{type=" + this.f5183a + ", metricRate=" + this.f5184b + ", metricMaxRate=" + this.f5185c + ", metricCpuStats=" + this.f5186d + ", metricMaxCpuStats=" + this.f5187e + ", sceneString='" + this.f + "', firstTs=" + this.g + ", times=" + this.h + '}';
    }
}
