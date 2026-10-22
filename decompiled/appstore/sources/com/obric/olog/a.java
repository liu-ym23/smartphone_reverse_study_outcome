package com.obric.olog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f12207a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f12208b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12209c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12210d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f12211e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f12212f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12213g;

    /* JADX INFO: renamed from: com.obric.olog.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0189a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Context f12214a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f12215b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f12216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f12217d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f12218e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f12219f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f12220g;

        public b(Context r10) {
            this.f12215b = false;
            this.f12216c = 3;
            this.f12217d = true;
            this.f12220g = 14;
            if (r10 == null) goto L14;
            Context r11 = r10.getApplicationContext();
            if (r11 == null) goto L7;
            r10 = r11;
        L7:
            this.f12214a = r10;
            if (b() == false) goto L10;
            int r12 = 31457280;
        L11:
            this.f12219f = r12;
            return;
        L10:
            r12 = 20971520;
            goto L11
        L14:
            throw new RuntimeException("context must not be null");
        }

        public a a() {
            a r10 = new a(null);
            r10.h(this.f12214a);
            r10.m(this.f12215b);
            r10.i(this.f12216c);
            r10.n(this.f12217d);
            r10.j(this.f12218e);
            r10.l(this.f12219f);
            r10.k(this.f12220g);
            return r10;
        }

        public final boolean b() {
            return Build.TYPE.equals("userdebug");
        }
    }

    public /* synthetic */ a(C0189a r10) {
        this();
    }

    public Context a() {
        return this.f12207a;
    }

    public int b() {
        return this.f12209c;
    }

    public String c() {
        return this.f12211e;
    }

    public int d() {
        return this.f12213g;
    }

    public int e() {
        return this.f12212f;
    }

    public boolean f() {
        return this.f12208b;
    }

    public boolean g() {
        return this.f12210d;
    }

    public void h(Context r10) {
        this.f12207a = r10;
    }

    public void i(int r10) {
        this.f12209c = r10;
    }

    public void j(String r10) {
        this.f12211e = r10;
    }

    public void k(int r10) {
        this.f12213g = r10;
    }

    public void l(int r10) {
        this.f12212f = r10;
    }

    public void m(boolean r10) {
        this.f12208b = r10;
    }

    public void n(boolean r10) {
        this.f12210d = r10;
    }

    public a() {
        this.f12208b = false;
        this.f12209c = 3;
        this.f12210d = true;
        this.f12213g = 14;
    }
}
