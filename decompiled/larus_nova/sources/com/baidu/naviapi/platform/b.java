package com.baidu.naviapi.platform;

/* JADX INFO: loaded from: classes39.dex */
public class b {
    public static double a(double r100, double r101, double r102, double r103) {
        double r104 = Math.toRadians(r101);
        double r105 = Math.toRadians(r103);
        double r106 = Math.toRadians(r100) - Math.toRadians(r102);
        return (Math.asin(Math.sqrt(Math.pow(Math.sin((r104 - r105) / 2.0d), 2.0d) + ((Math.cos(r104) * Math.cos(r105)) * Math.pow(Math.sin(r106 / 2.0d), 2.0d)))) * 2.0d) * 6378137.0d;
    }

    public static double b(double r100, double r101, double r102, double r103) {
        return Math.sqrt(Math.pow(r100 - r102, 2.0d) + Math.pow(r101 - r103, 2.0d));
    }
}
