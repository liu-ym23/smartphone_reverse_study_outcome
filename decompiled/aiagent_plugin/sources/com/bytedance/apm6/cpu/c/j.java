package com.bytedance.apm6.cpu.c;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;

/* JADX INFO: compiled from: ThreadExceptionItem.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f5276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private double f5279d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5280e;
    private String f;
    private long g;
    private int h;

    public j() {
    }

    public int a() {
        return this.h;
    }

    public void a(int r1) {
        this.h = r1;
    }

    public String b() {
        return this.f5280e;
    }

    public void a(String r1) {
        this.f5280e = r1;
    }

    public long c() {
        return this.g;
    }

    public void a(long r1) {
        this.g = r1;
    }

    public String d() {
        return this.f;
    }

    public void b(String r1) {
        this.f = r1;
    }

    public double e() {
        return this.f5279d;
    }

    public void a(double r1) {
        this.f5279d = r1;
    }

    public int f() {
        return this.f5276a;
    }

    public void b(int r1) {
        this.f5276a = r1;
    }

    public String g() {
        return this.f5277b;
    }

    public void c(String r1) {
        this.f5277b = r1;
    }

    public long h() {
        return this.f5278c;
    }

    public void b(long r1) {
        this.f5278c = r1;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, j.class) == true) goto L8;
        return false;
    L8:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.aiagent.plugin");
        if (f() != r6.f()) goto L14;
        if (g().equals(r6.g()) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(f()), g()});
    }

    public String toString() {
        return "ThreadExceptionItem{threadId=" + this.f5276a + ", threadName='" + this.f5277b + "', threadCpuTime=" + this.f5278c + ", processCpuTime=" + this.g + ", cpuUsage=" + this.f5279d + ", weight=" + this.f5280e + ", nice=" + this.h + '}';
    }
}
