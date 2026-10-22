package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.Nulls;
import java.io.Serializable;

/* JADX INFO: compiled from: PropertyMetadata.java */
/* JADX INFO: loaded from: classes2.dex */
public class w implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f13125a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w f13126b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final w f13127c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final Boolean f13128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final String f13129e;
    protected final Integer f;
    protected final String g;
    protected final transient a h;
    protected Nulls i;
    protected Nulls j;

    /* JADX INFO: compiled from: PropertyMetadata.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.fasterxml.jackson.databind.e.j f13130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f13131b;

        public a(com.fasterxml.jackson.databind.e.j r1, boolean r2) {
            this.f13130a = r1;
            this.f13131b = r2;
        }

        public static a a(com.fasterxml.jackson.databind.e.j r2) {
            return new a(r2, true);
        }

        public static a b(com.fasterxml.jackson.databind.e.j r2) {
            return new a(r2, false);
        }

        public static a c(com.fasterxml.jackson.databind.e.j r2) {
            return new a(r2, false);
        }
    }

    static {
        f13125a = new w(Boolean.TRUE, null, null, null, null, null, null);
        f13126b = new w(Boolean.FALSE, null, null, null, null, null, null);
        f13127c = new w(null, null, null, null, null, null, null);
    }

    public w(Boolean r1, String r2, Integer r3, String r4, a r5, Nulls r6, Nulls r7) {
        this.f13128d = r1;
        this.f13129e = r2;
        this.f = r3;
        if (r4 != null) goto L5;
    L6:
        r4 = null;
    L7:
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.j = r7;
        return;
    L5:
        if (r4.isEmpty() == false) goto L7;
        goto L6
    }

    public static w a(Boolean r9, String r10, Integer r11, String r12) {
        if (r10 != null) goto L15;
        if (r11 != null) goto L15;
        if (r12 != null) goto L15;
        if (r9 != null) goto L10;
        return f13127c;
    L10:
        if (r9.booleanValue() == false) goto L13;
        return f13125a;
    L13:
        return f13126b;
    L15:
        return new w(r9, r10, r11, r12, null, null, null);
    }

    public w a(String r10) {
        return new w(this.f13128d, r10, this.f, this.g, this.h, this.i, this.j);
    }

    public w a(a r10) {
        return new w(this.f13128d, this.f13129e, this.f, this.g, r10, this.i, this.j);
    }

    public w a(Nulls r10, Nulls r11) {
        return new w(this.f13128d, this.f13129e, this.f, this.g, this.h, r10, r11);
    }

    public boolean a() {
        Boolean r0 = this.f13128d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.booleanValue() == false) goto L7;
        return true;
    }

    public Integer b() {
        return this.f;
    }

    public boolean c() {
        if (this.f == null) goto L5;
        return true;
    L5:
        return false;
    }

    public a d() {
        return this.h;
    }

    public Nulls e() {
        return this.i;
    }

    public Nulls f() {
        return this.j;
    }
}
