package com.bytedance.apm6.cpu.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: compiled from: CpuExceptionConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f5229b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private double f5230c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f5231d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private double f5232e;
    private Map<String, Double> f;
    private boolean g;
    private Map<String, Double> h;
    private Map<String, Double> i;
    private boolean j;
    private int k;
    private int l;
    private boolean m;

    public c() {
        this.f5228a = false;
        this.f5229b = false;
        this.f5230c = 3.0d;
        this.f5231d = 6.0d;
        this.f5232e = 0.05d;
        this.g = false;
        this.j = true;
        this.m = false;
    }

    public boolean a() {
        return this.f5228a;
    }

    public void a(boolean r1) {
        this.f5228a = r1;
    }

    public Map<String, Double> b() {
        return this.h;
    }

    public void a(Map<String, Double> r3) {
        this.h = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public Map<String, Double> c() {
        return this.i;
    }

    public void b(Map<String, Double> r3) {
        this.i = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public boolean d() {
        return this.f5229b;
    }

    public void b(boolean r1) {
        this.f5229b = r1;
    }

    public double e() {
        return this.f5230c;
    }

    public void a(double r1) {
        this.f5230c = r1;
    }

    public double f() {
        return this.f5232e;
    }

    public void b(double r1) {
        this.f5232e = r1;
    }

    public Map<String, Double> g() {
        return this.f;
    }

    public void c(Map<String, Double> r3) {
        this.f = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
    }

    public boolean h() {
        return this.g;
    }

    public void c(boolean r1) {
        this.g = r1;
    }

    public double i() {
        return this.f5231d;
    }

    public void c(double r1) {
        this.f5231d = r1;
    }

    public String toString() {
        return "CpuExceptionConfig{isOpen=" + this.f5228a + ", isCollectMainThread=" + this.f5229b + ", maxProcessBackCpuSpeed=" + this.f5230c + ", maxProcessForeCpuSpeed=" + this.f5231d + ", maxThreadCpuRate=" + this.f5232e + ", isCollectAllProcess=" + this.g + ", backSceneMaxSpeedMap=" + this.h + ", foreSceneMaxSpeedMap=" + this.i + '}';
    }

    public boolean j() {
        return this.j;
    }

    public void d(boolean r1) {
        this.j = r1;
    }

    public int k() {
        return this.k;
    }

    public void a(int r1) {
        this.k = r1;
    }

    public int l() {
        return this.l;
    }

    public void b(int r1) {
        this.l = r1;
    }

    public boolean m() {
        return this.m;
    }

    public void e(boolean r1) {
        this.m = r1;
    }
}
