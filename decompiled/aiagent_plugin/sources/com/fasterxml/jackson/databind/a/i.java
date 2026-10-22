package com.fasterxml.jackson.databind.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;

/* JADX INFO: compiled from: ConstructorDetector.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f12214a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i f12215b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i f12216c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i f12217d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final a f12218e;
    protected final boolean f;
    protected final boolean g;

    /* JADX INFO: compiled from: ConstructorDetector.java */
    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12219a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f12220b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f12221c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f12222d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f12223e = null;

        private a(String r1, int r2) {
            super(r1, r2);
        }

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f12223e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("DELEGATING", 0);
            f12219a = r0;
            a r1 = new a("PROPERTIES", 1);
            f12220b = r1;
            a r3 = new a("HEURISTIC", 2);
            f12221c = r3;
            a r5 = new a("REQUIRE_MODE", 3);
            f12222d = r5;
            f12223e = new a[]{r0, r1, r3, r5};
        }
    }

    static {
        f12214a = new i(a.f12221c);
        f12215b = new i(a.f12220b);
        f12216c = new i(a.f12219a);
        f12217d = new i(a.f12222d);
    }

    public i(a r1, boolean r2, boolean r3) {
        this.f12218e = r1;
        this.f = r2;
        this.g = r3;
    }

    public i(a r2) {
        this(r2, false, false);
    }

    public a a() {
        return this.f12218e;
    }

    public boolean b() {
        return this.f;
    }

    public boolean c() {
        if (this.f12218e != a.f12219a) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.f12218e != a.f12220b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(Class<?> r3) {
        if (this.f == false) goto L6;
        return false;
    L6:
        if (this.g == false) goto L8;
        return true;
    L8:
        if (com.fasterxml.jackson.databind.l.h.o(r3) == true) goto L10;
        return true;
    L10:
        if (Throwable.class.isAssignableFrom(r3) == true) goto L15;
        return false;
    L15:
        return true;
    }
}
