package com.bytedance.apm6.service.e;

/* JADX INFO: compiled from: ICpuDataService.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.apm6.service.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ICpuDataService.java */
    public static class C0132a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f5450a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private double f5451b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f5452c;

        public C0132a(String r1, double r2, int r4) {
            this.f5450a = r1;
            this.f5451b = r2;
            this.f5452c = r4;
        }

        public double a() {
            return this.f5451b;
        }
    }

    double b();

    double c();
}
