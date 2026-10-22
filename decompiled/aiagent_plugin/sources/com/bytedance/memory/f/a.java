package com.bytedance.memory.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: MemoryWidgetConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f8798b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8799c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8800d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private c f8801e;
    private b f;
    private String g;
    private int h;

    /* JADX INFO: renamed from: com.bytedance.memory.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MemoryWidgetConfig.java */
    public static class C0199a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f8802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f8803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f8804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private c f8805d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b f8806e;
        private int f;
        private int g;
        private String h;

        public C0199a() {
            this.f8803b = false;
            this.f8804c = 200;
            this.f = 90;
            this.g = 1;
        }

        public a a() {
            a r0 = new a();
            a.a(r0, this.f8802a);
            a.b(r0, this.f8803b);
            a.a(r0, this.f8804c);
            a.b(r0, this.f);
            a.c(r0, this.g);
            a.a(r0, this.f8805d);
            a.a(r0, this.f8806e);
            a.a(r0, this.h);
            return r0;
        }
    }

    /* JADX INFO: compiled from: MemoryWidgetConfig.java */
    public interface b {
        boolean a(File r1);
    }

    /* JADX INFO: compiled from: MemoryWidgetConfig.java */
    public interface c {
        boolean a(File r1, File r2);
    }

    public a() {
        this.f8798b = false;
        this.f8799c = 200;
        this.f8800d = 90;
        this.h = 1;
    }

    static /* synthetic */ int a(a r0, int r1) {
        r0.f8799c = r1;
        return r1;
    }

    static /* synthetic */ b a(a r2, b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        r2.f = r4;
        return r4;
    }

    static /* synthetic */ c a(a r2, c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.aiagent.plugin");
        r2.f8801e = r4;
        return r4;
    }

    static /* synthetic */ String a(a r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ boolean a(a r0, boolean r1) {
        r0.f8797a = r1;
        return r1;
    }

    static /* synthetic */ int b(a r0, int r1) {
        r0.f8800d = r1;
        return r1;
    }

    static /* synthetic */ boolean b(a r0, boolean r1) {
        r0.f8798b = r1;
        return r1;
    }

    static /* synthetic */ int c(a r0, int r1) {
        r0.h = r1;
        return r1;
    }

    public void a(int r1) {
        this.h = r1;
    }

    public int a() {
        return this.h;
    }

    public String b() {
        return this.g;
    }

    public boolean c() {
        return this.f8798b;
    }

    public void a(boolean r1) {
        this.f8798b = r1;
    }

    public void b(int r1) {
        this.f8799c = r1;
    }

    public void c(int r1) {
        this.f8800d = r1;
    }

    public boolean d() {
        return this.f8797a;
    }

    public int e() {
        return this.f8799c;
    }

    public int f() {
        return this.f8800d;
    }

    public c g() {
        return this.f8801e;
    }

    public b h() {
        return this.f;
    }

    public String toString() {
        return "MemoryWidgetConfig{ mIsDebug:" + this.f8797a + ", mClientAnalyse:" + this.f8798b + ", mMemoryRate:" + this.f8800d + ", mRunStrategy:" + this.h + ", mFilePath:" + this.g + ", mShrinkConfig:" + this.f8801e + ", mDumpShrinkConfig:" + this.f + " }";
    }

    public static C0199a i() {
        return new C0199a();
    }
}
