package com.bytedance.apm6.disk.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: DiskConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f5292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f5293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f5295d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5296e;
    private int f;
    private int g;
    private long h;
    private List<String> i;
    private List<String> j;
    private List<String> k;
    private boolean l;

    public a() {
    }

    public void a(boolean r1) {
        this.l = r1;
    }

    public boolean a() {
        return this.l;
    }

    public long b() {
        return this.f5292a;
    }

    public void a(long r1) {
        this.f5292a = r1;
    }

    public long c() {
        return this.f5293b;
    }

    public void b(long r1) {
        this.f5293b = r1;
    }

    public long d() {
        return this.f5294c;
    }

    public void c(long r1) {
        this.f5294c = r1;
    }

    public void a(int r1) {
        this.f5295d = r1;
    }

    public int e() {
        return this.f5296e;
    }

    public void b(int r1) {
        this.f5296e = r1;
    }

    public int f() {
        return this.f;
    }

    public void c(int r1) {
        this.f = r1;
    }

    public int g() {
        return this.g;
    }

    public void d(int r1) {
        this.g = r1;
    }

    public void d(long r1) {
        this.h = r1;
    }

    public long h() {
        return this.h;
    }

    public List<String> i() {
        return this.i;
    }

    public void a(List<String> r3) {
        this.i = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public List<String> j() {
        return this.j;
    }

    public List<String> k() {
        return this.k;
    }

    public void b(List<String> r3) {
        this.j = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public void c(List<String> r3) {
        this.k = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public String toString() {
        return "DiskConfig{diskThresholdBytes=" + this.f5292a + ", folderThresholdBytes=" + this.f5293b + ", fileThresholdBytes=" + this.f5294c + ", reportMaxCount=" + this.f5295d + ", reportMaxOutdatedCount=" + this.f5296e + ", reportMaxTopCount=" + this.f + ", reportExceptionDirMaxCount=" + this.g + ", outdatedIntervalMs=" + this.h + ", customRelativePaths=" + this.i + ", ignoredRelativePaths=" + this.j + ", complianceRelativePaths=" + this.k + ", isSample=" + this.l + '}';
    }
}
