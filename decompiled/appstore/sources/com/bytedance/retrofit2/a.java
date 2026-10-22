package com.bytedance.retrofit2;

import com.bytedance.retrofit2.http.Streaming;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.mime.TypedOutput;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Converter.a {

    /* JADX INFO: renamed from: com.bytedance.retrofit2.a$a, reason: collision with other inner class name */
    public static final class C0099a implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0099a f7937a = null;

        static {
            f7937a = new C0099a();
        }

        public C0099a() {
        }

        public TypedInput a(TypedInput r10) {
            if (r10 != null) goto L4;
        L15:
            return r10;
        L4:
            if ((r10 instanceof h6.f) == true) goto L15;
            String r11 = r10.mimeType();
            InputStream r12 = r10.in();
            h6.f r13 = new h6.f(r11, f6.g.s(r12), new String[0]);     // Catch: Throwable -> L11
            if (r12 != null) goto L22;
        L10:
            return r13;
        L22:
            r12.close();     // Catch: IOException -> L16
        L11:
            th = move-exception;
            if (r12 != null) goto L20;
        L14:
            throw th;
        L20:
            r12.close();     // Catch: IOException -> L17
            goto L14
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((TypedInput) r10);
        }
    }

    public static final class b implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7938a = null;

        static {
            f7938a = new b();
        }

        public b() {
        }

        public g6.a a(g6.a r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((g6.a) r10);
        }
    }

    public static final class c implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f7939a = null;

        static {
            f7939a = new c();
        }

        public c() {
        }

        @Override // com.bytedance.retrofit2.Converter
        public Object convert(Object r10) {
            return r10;
        }
    }

    public static final class d implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7940a = null;

        static {
            f7940a = new d();
        }

        public d() {
        }

        public TypedOutput a(TypedOutput r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((TypedOutput) r10);
        }
    }

    public static final class e implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7941a = null;

        static {
            f7941a = new e();
        }

        public e() {
        }

        public TypedInput a(TypedInput r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((TypedInput) r10);
        }
    }

    public static final class f implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f7942a = null;

        static {
            f7942a = new f();
        }

        public f() {
        }

        public String a(String r10) {
            return r10;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((String) r10);
        }
    }

    public static final class g implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f7943a = null;

        static {
            f7943a = new g();
        }

        public g() {
        }

        public String a(TypedInput r10) {
            if ((r10 instanceof h6.f) == false) goto L9;
            String r11 = "UTF-8";
            if (r10.mimeType() == null) goto L8;
            r11 = h6.d.a(r10.mimeType(), "UTF-8");
        L8:
            return new String(((h6.f) r10).b(), r11);
        L9:
            return null;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((TypedInput) r10);
        }
    }

    public static final class h implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f7944a = null;

        static {
            f7944a = new h();
        }

        public h() {
        }

        public String a(Object r10) {
            return String.valueOf(r10);
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a(r10);
        }
    }

    public static final class i implements Converter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final i f7945a = null;

        static {
            f7945a = new i();
        }

        public i() {
        }

        public Void a(TypedInput r10) {
            InputStream r11 = r10.in();
            if (r11 == null) goto L7;
            r11.close();
            return null;
        L7:
            return null;
        }

        @Override // com.bytedance.retrofit2.Converter
        public /* bridge */ /* synthetic */ Object convert(Object r10) {
            return a((TypedInput) r10);
        }
    }

    public a() {
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter a(Type r10, Annotation[] r11, com.bytedance.retrofit2.f r12) {
        if (r10 == g6.a.class) goto L5;
        return null;
    L5:
        return b.f7938a;
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter b(Type r10, Annotation[] r11, com.bytedance.retrofit2.f r12) {
        if (r10 == Object.class) goto L5;
        return null;
    L5:
        return c.f7939a;
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter c(Type r10, Annotation[] r11, Annotation[] r12, com.bytedance.retrofit2.f r13) {
        if (TypedOutput.class.isAssignableFrom(f6.g.j(r10)) == true) goto L5;
        return null;
    L5:
        return d.f7940a;
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter d(Type r10, Annotation[] r11, com.bytedance.retrofit2.f r12) {
        if (r10 != TypedInput.class) goto L11;
        if (f6.g.o(r11, Streaming.class) == false) goto L9;
        return e.f7941a;
    L9:
        return C0099a.f7937a;
    L11:
        if (r10 != String.class) goto L15;
        return g.f7943a;
    L15:
        if (r10 == Void.class) goto L17;
        return null;
    L17:
        return i.f7945a;
    }

    @Override // com.bytedance.retrofit2.Converter.a
    public Converter e(Type r10, Annotation[] r11, com.bytedance.retrofit2.f r12) {
        if (r10 == String.class) goto L5;
        return null;
    L5:
        return f.f7942a;
    }
}
