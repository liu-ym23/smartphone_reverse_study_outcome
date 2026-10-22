package com.fasterxml.jackson.databind;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: compiled from: ObjectWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public class v implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final com.fasterxml.jackson.a.p f13111a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final aa f13112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.k f13113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final com.fasterxml.jackson.databind.j.r f13114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected final com.fasterxml.jackson.a.f f13115e;
    protected final a f;
    protected final b g;

    /* JADX INFO: compiled from: ObjectWriter.java */
    public static final class a implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13116a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.fasterxml.jackson.a.p f13117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.fasterxml.jackson.a.d f13118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final com.fasterxml.jackson.a.d.c f13119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final com.fasterxml.jackson.a.q f13120e;

        static {
            f13116a = new a(null, null, null, null);
        }

        public a(com.fasterxml.jackson.a.p r3, com.fasterxml.jackson.a.d r4, com.fasterxml.jackson.a.d.c r5, com.fasterxml.jackson.a.q r6) {
            com.fasterxml.jackson.a.p r7 = (com.fasterxml.jackson.a.p) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.a.p.class, "com.obric.aiagent.plugin");
            com.fasterxml.jackson.a.d r8 = (com.fasterxml.jackson.a.d) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.a.d.class, "com.obric.aiagent.plugin");
            com.fasterxml.jackson.a.q r9 = (com.fasterxml.jackson.a.q) ZeusTransformUtils.wrapperContextForParams(r6, com.fasterxml.jackson.a.q.class, "com.obric.aiagent.plugin");
            this.f13117b = r7;
            this.f13118c = r8;
            this.f13119d = r5;
            this.f13120e = r9;
        }

        public a a(com.fasterxml.jackson.a.p r4) {
            com.fasterxml.jackson.a.p r5 = (com.fasterxml.jackson.a.p) ZeusTransformUtils.wrapperContextForParams(r4, com.fasterxml.jackson.a.p.class, "com.obric.aiagent.plugin");
            if (r5 != null) goto L6;
            r5 = v.f13111a;
        L6:
            if (r5 != this.f13117b) goto L9;
            return this;
        L9:
            return new a(r5, this.f13118c, this.f13119d, this.f13120e);
        }

        public void a(com.fasterxml.jackson.a.h r4) {
            com.fasterxml.jackson.a.p r0 = this.f13117b;
            if (r0 != null) goto L5;
        L11:
            com.fasterxml.jackson.a.d.c r1 = this.f13119d;
            if (r1 == null) goto L14;
            r4.a(r1);
        L14:
            com.fasterxml.jackson.a.d r2 = this.f13118c;
            if (r2 == null) goto L17;
            r4.a(r2);
        L17:
            com.fasterxml.jackson.a.q r3 = this.f13120e;
            if (r3 == null) goto L21;
            r4.a(r3);
            return;
        L21:
            return;
        L5:
            if (r0 != v.f13111a) goto L8;
            r4.a(null);
            goto L11
        L8:
            if (ZeusTransformUtils.instanceOf(r0, com.fasterxml.jackson.a.h.f.class) == false) goto L10;
            r0 = (com.fasterxml.jackson.a.p) ZeusTransformUtils.preCheckCast(((com.fasterxml.jackson.a.h.f) ZeusTransformUtils.preCheckCast(r0, com.fasterxml.jackson.a.h.f.class, "com.obric.aiagent.plugin")).b(), com.fasterxml.jackson.a.p.class, "com.obric.aiagent.plugin");
        L10:
            r4.a(r0);
            goto L11
        }
    }

    /* JADX INFO: compiled from: ObjectWriter.java */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f13121a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final k f13122b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final p<Object> f13123c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.fasterxml.jackson.databind.h.h f13124d;

        static {
            f13121a = new b(null, null, null);
        }

        private b(k r1, p<Object> r2, com.fasterxml.jackson.databind.h.h r3) {
            this.f13122b = r1;
            this.f13123c = r2;
            this.f13124d = r3;
        }

        public void a(com.fasterxml.jackson.a.h r7, Object r8, com.fasterxml.jackson.databind.j.k r9) {
            com.fasterxml.jackson.databind.h.h r5 = this.f13124d;
            if (r5 == null) goto L5;
            r9.a(r7, r8, this.f13122b, this.f13123c, r5);
            return;
        L5:
            p<Object> r0 = this.f13123c;
            if (r0 == null) goto L8;
            r9.a(r7, r8, this.f13122b, r0);
            return;
        L8:
            k r6 = this.f13122b;
            if (r6 == null) goto L11;
            r9.a(r7, r8, r6);
            return;
        L11:
            r9.a(r7, r8);
        }
    }

    static {
        f13111a = new com.fasterxml.jackson.a.h.l();
    }

    public v(t r1, aa r2) {
        this.f13112b = r2;
        this.f13113c = r1.k;
        this.f13114d = r1.l;
        this.f13115e = r1.f13103c;
        this.f = a.f13116a;
        this.g = b.f13121a;
    }

    public v(v r1, aa r2, a r3, b r4) {
        this.f13112b = r2;
        this.f13113c = r1.f13113c;
        this.f13114d = r1.f13114d;
        this.f13115e = r1.f13115e;
        this.f = r3;
        this.g = r4;
    }

    public v a(a r3, b r4) {
        if (this.f != r3) goto L8;
        if (this.g != r4) goto L8;
        return this;
    L8:
        return new v(this, this.f13112b, r3, r4);
    }

    public v a() {
        return a(this.f13112b.c());
    }

    public v a(com.fasterxml.jackson.a.p r3) {
        com.fasterxml.jackson.a.p r4 = (com.fasterxml.jackson.a.p) ZeusTransformUtils.wrapperContextForParams(r3, com.fasterxml.jackson.a.p.class, "com.obric.aiagent.plugin");
        return a(this.f.a(r4), this.g);
    }

    public com.fasterxml.jackson.a.h a(Writer r2) {
        a(DownloadFileUtils.MODE_WRITE, r2);
        return a(this.f13115e.a(r2));
    }

    public String a(Object r3) {
        com.fasterxml.jackson.a.d.l r0 = new com.fasterxml.jackson.a.d.l(this.f13115e.f());
        a(a(r0), r3);     // Catch: IOException -> L6 com.fasterxml.jackson.a.l -> L9
    L5:
        return r0.a();
    L9:
        e = move-exception;
        throw e;
    L6:
        e = move-exception;
        throw m.a(e);
    }

    public com.fasterxml.jackson.databind.j.k b() {
        return this.f13113c.a(this.f13112b, this.f13114d);
    }

    public final void a(com.fasterxml.jackson.a.h r3, Object r4) {
        if (this.f13112b.a(ab.h) == true) goto L5;
    L14:
        this.g.a(r3, r4, b());     // Catch: Exception -> L11
        r3.close();
        return;
    L11:
        e = move-exception;
        com.fasterxml.jackson.databind.l.h.a(r3, e);
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, Closeable.class) == false) goto L14;
        b(r3, r4);
    }

    private final void b(com.fasterxml.jackson.a.h r3, Object r4) {
        Closeable r0 = (Closeable) ZeusTransformUtils.preCheckCast(r4, Closeable.class, "com.obric.aiagent.plugin");
        this.g.a(r3, r4, b());     // Catch: Exception -> L10
        r0.close();     // Catch: Exception -> L8
        r3.close();
        return;
    L8:
        e = e;
        r0 = null;
    L11:
        com.fasterxml.jackson.databind.l.h.a(r3, r0, e);
        return;
    L10:
        e = e;
        goto L11
    }

    public final com.fasterxml.jackson.a.h a(com.fasterxml.jackson.a.h r2) {
        this.f13112b.a(r2);
        this.f.a(r2);
        return r2;
    }

    public final void a(String r2, Object r3) {
        if (r3 == null) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format("argument \"%s\" is null", new Object[]{r2}));
    }
}
