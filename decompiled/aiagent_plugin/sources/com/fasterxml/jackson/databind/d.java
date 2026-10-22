package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

/* JADX INFO: compiled from: BeanProperty.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d extends com.fasterxml.jackson.databind.l.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonFormat.Value f12557a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final JsonInclude.Value f12558b = null;

    /* JADX INFO: compiled from: BeanProperty.java */
    public static class a implements d {
        @Override // com.fasterxml.jackson.databind.d, com.fasterxml.jackson.databind.l.r
        public String a() {
            return "";
        }

        @Override // com.fasterxml.jackson.databind.d
        public JsonInclude.Value b(com.fasterxml.jackson.databind.a.m<?> r1, Class<?> r2) {
            return null;
        }

        @Override // com.fasterxml.jackson.databind.d
        public com.fasterxml.jackson.databind.e.j d() {
            return null;
        }

        public a() {
        }

        @Override // com.fasterxml.jackson.databind.d
        public x b() {
            return x.f13133b;
        }

        @Override // com.fasterxml.jackson.databind.d
        public k getType() {
            return com.fasterxml.jackson.databind.k.o.c();
        }

        @Override // com.fasterxml.jackson.databind.d
        public w c() {
            return w.f13127c;
        }

        @Override // com.fasterxml.jackson.databind.d
        public JsonFormat.Value a(com.fasterxml.jackson.databind.a.m<?> r1, Class<?> r2) {
            return JsonFormat.Value.empty();
        }
    }

    /* JADX INFO: compiled from: BeanProperty.java */
    public static class b implements d, Serializable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final x f12559c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final k f12560d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected final x f12561e;
        protected final w f;
        protected final com.fasterxml.jackson.databind.e.j g;

        public b(x r1, k r2, x r3, com.fasterxml.jackson.databind.e.j r4, w r5) {
            this.f12559c = r1;
            this.f12560d = r2;
            this.f12561e = r3;
            this.f = r5;
            this.g = r4;
        }

        @Override // com.fasterxml.jackson.databind.d
        public JsonFormat.Value a(com.fasterxml.jackson.databind.a.m<?> r1, Class<?> r2) {
            JsonFormat.Value r3 = r1.f(r2);
            com.fasterxml.jackson.databind.b r4 = r1.j();
            if (r4 == null) goto L12;
            com.fasterxml.jackson.databind.e.j r0 = this.g;
            if (r0 == null) goto L12;
            JsonFormat.Value r5 = r4.f(r0);
            if (r5 != null) goto L11;
            return r3;
        L11:
            return r3.withOverrides(r5);
        L12:
            return r3;
        }

        @Override // com.fasterxml.jackson.databind.d
        public JsonInclude.Value b(com.fasterxml.jackson.databind.a.m<?> r2, Class<?> r3) {
            JsonInclude.Value r4 = r2.a(r3, this.f12560d.e());
            com.fasterxml.jackson.databind.b r5 = r2.j();
            if (r5 == null) goto L12;
            com.fasterxml.jackson.databind.e.j r1 = this.g;
            if (r1 == null) goto L12;
            JsonInclude.Value r6 = r5.s(r1);
            if (r6 != null) goto L11;
            return r4;
        L11:
            return r4.withOverrides(r6);
        L12:
            return r4;
        }

        @Override // com.fasterxml.jackson.databind.d, com.fasterxml.jackson.databind.l.r
        public String a() {
            return this.f12559c.b();
        }

        @Override // com.fasterxml.jackson.databind.d
        public x b() {
            return this.f12559c;
        }

        @Override // com.fasterxml.jackson.databind.d
        public k getType() {
            return this.f12560d;
        }

        public x e() {
            return this.f12561e;
        }

        @Override // com.fasterxml.jackson.databind.d
        public w c() {
            return this.f;
        }

        @Override // com.fasterxml.jackson.databind.d
        public com.fasterxml.jackson.databind.e.j d() {
            return this.g;
        }
    }

    JsonFormat.Value a(com.fasterxml.jackson.databind.a.m<?> r1, Class<?> r2);

    @Override // com.fasterxml.jackson.databind.l.r
    String a();

    JsonInclude.Value b(com.fasterxml.jackson.databind.a.m<?> r1, Class<?> r2);

    x b();

    w c();

    com.fasterxml.jackson.databind.e.j d();

    k getType();

    static {
        f12557a = new JsonFormat.Value();
        f12558b = JsonInclude.Value.empty();
    }
}
