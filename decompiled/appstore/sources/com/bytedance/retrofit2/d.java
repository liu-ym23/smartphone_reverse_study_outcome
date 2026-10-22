package com.bytedance.retrofit2;

import com.bytedance.retrofit2.http.ext.QueryParamObject;
import com.bytedance.retrofit2.mime.TypedOutput;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes.dex */
public abstract class d {

    public class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7960a;

        public a(d r10) {
            this.f7960a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (Iterable) r11);
        }

        public void d(f6.d r10, Iterable r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            Object r13 = r12.next();
            this.f7960a.a(r10, r13);
            goto L6
        }
    }

    public class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7961a;

        public b(d r10) {
            this.f7961a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            int r12 = Array.getLength(r11);
            int r13 = 0;
        L5:
            if (r13 >= r12) goto L7;
            this.f7961a.a(r10, Array.get(r11, r13));
            r13 = r13 + 1;
            goto L5
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7962a;

        public c(Converter r10) {
            this.f7962a = (Converter) f6.g.a(r10, "converter == null");
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L9;
            return;
        L9:
            r10.l(Boolean.parseBoolean((String) this.f7962a.convert(r11)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to AddCommonParam", e);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.retrofit2.d$d, reason: collision with other inner class name */
    public static final class C0102d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7963a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7964b;

        public C0102d(boolean r10, Converter r11) {
            this.f7963a = r10;
            this.f7964b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 == null) goto L4;
            r10.m((TypedOutput) this.f7964b.convert(r11));
            return;
        L11:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to TypedOutput", e);
        L4:
            if (this.f7963a == false) goto L7;
            return;
        L7:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f7965a = null;

        static {
            f7965a = new e();
        }

        public e() {
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (RequestBody) r11);
        }

        public void d(f6.d r10, RequestBody r11) {
            if (r11 == null) goto L6;
            r10.n(r11);
            r10.t();
            return;
        L6:
            throw new IllegalArgumentException("Body parameter value must not be null.");
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Headers f7966a;

        public f(Headers r10) {
            this.f7966a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (RequestBody) r11);
        }

        public void d(f6.d r10, RequestBody r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.e(this.f7966a, r11);
            r10.t();
        }
    }

    public static final class g extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7967a;

        public g(String r10) {
            this.f7967a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(f6.d r10, Map r11) {
            if (r11 == null) goto L18;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            RequestBody r15 = (RequestBody) r13.getValue();
            if (r15 == null) goto L12;
            r10.e(Headers.g(new String[]{HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + r14 + "\"", "Content-Transfer-Encoding", this.f7967a}), r15);
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            r10.t();
            return;
        L18:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    public static final class h extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f7968a = null;

        static {
            f7968a = new h();
        }

        public h() {
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (okhttp3.h.b) r11);
        }

        public void d(f6.d r10, okhttp3.h.b r11) {
            if (r11 == null) goto L4;
            r10.f(r11);
        L4:
            r10.t();
        }
    }

    public static final class i extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7969a;

        public i(Converter r10) {
            this.f7969a = (Converter) f6.g.a(r10, "converter == null");
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L9;
            return;
        L9:
            r10.o(this.f7969a.convert(r11));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to ExtraInfo", e);
        }
    }

    public static final class j extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7972c;

        public j(String r10, Converter r11, boolean r12) {
            this.f7970a = (String) f6.g.a(r10, "name == null");
            this.f7971b = r11;
            this.f7972c = r12;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.a(this.f7970a, (String) this.f7971b.convert(r11), this.f7972c);
        }
    }

    public static final class k extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7974b;

        public k(Converter r10, boolean r11) {
            this.f7973a = r10;
            this.f7974b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(f6.d r10, Map r11) {
            if (r11 == null) goto L17;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            Object r15 = r13.getValue();
            if (r15 == null) goto L12;
            r10.a(r14, (String) this.f7973a.convert(r15), this.f7974b);
            goto L5
        L12:
            throw new IllegalArgumentException("Field map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Field map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Field map was null.");
        }
    }

    public static final class l extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7975a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7976b;

        public l(String r10, Converter r11) {
            this.f7975a = (String) f6.g.a(r10, "name == null");
            this.f7976b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.b(this.f7975a, (String) this.f7976b.convert(r11));
        }
    }

    public static final class m extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7977a;

        public m(Converter r10) {
            this.f7977a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (List) r11);
        }

        public void d(f6.d r10, List r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L8;
            Object r13 = r12.next();
            g6.a r14 = (g6.a) this.f7977a.convert(r13);
            r10.b(r14.a(), r14.b());
            goto L6
        }
    }

    public static final class n extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7978a;

        public n(Converter r10) {
            this.f7978a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(f6.d r10, Map r11) {
            if (r11 == null) goto L17;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            Object r15 = r13.getValue();
            if (r15 == null) goto L12;
            r10.b(r14, (String) this.f7978a.convert(r15));
            goto L5
        L12:
            throw new IllegalArgumentException("Header map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Header map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Header map was null.");
        }
    }

    public static final class o extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7979a;

        public o(Converter r10) {
            this.f7979a = (Converter) f6.g.a(r10, "converter == null");
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L9;
            return;
        L9:
            r10.p(Integer.parseInt((String) this.f7979a.convert(r11)));     // Catch: IOException -> L6
            return;
        L6:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to MaxLength", e);
        }
    }

    public static final class p extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7980a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7981b;

        public p(String r10, Converter r11) {
            this.f7980a = (String) f6.g.a(r10, "name == null");
            this.f7981b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 == null) goto L6;
            r10.q(this.f7980a, (String) this.f7981b.convert(r11));
            return;
        L6:
            throw new IllegalArgumentException("Method parameter \"" + this.f7980a + "\" value must not be null.");
        }
    }

    public static final class q extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7983b;

        public q(String r10, Converter r11) {
            this.f7982a = r10;
            this.f7983b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L10;
            return;
        L10:
            r10.c(this.f7982a, (TypedOutput) this.f7983b.convert(r11));
            return;
        L7:
            e = move-exception;
            throw new RuntimeException("Unable to convert " + r11 + " to RequestBody", e);
        }
    }

    public static final class r extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7985b;

        public r(Converter r10, String r11) {
            this.f7984a = r10;
            this.f7985b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(f6.d r10, Map r11) {
            if (r11 == null) goto L17;
            Iterator r12 = r11.entrySet().iterator();
        L5:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            Object r15 = r13.getValue();
            if (r15 == null) goto L12;
            r10.d(r14, this.f7985b, (TypedOutput) this.f7984a.convert(r15));
            goto L5
        L12:
            throw new IllegalArgumentException("Part map contained null value for key '" + r14 + "'.");
        L14:
            throw new IllegalArgumentException("Part map contained null key.");
        L15:
            return;
        L17:
            throw new IllegalArgumentException("Part map was null.");
        }
    }

    public static final class s extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7986a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7987b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7988c;

        public s(String r10, Converter r11, boolean r12) {
            this.f7986a = (String) f6.g.a(r10, "name == null");
            this.f7987b = r11;
            this.f7988c = r12;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 == null) goto L6;
            r10.g(this.f7986a, (String) this.f7987b.convert(r11), this.f7988c);
            return;
        L6:
            throw new IllegalArgumentException("Path parameter \"" + this.f7986a + "\" value must not be null.");
        }
    }

    public static final class t extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Converter f7990b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f7991c;

        public t(String r10, Converter r11, boolean r12) {
            this.f7989a = (String) f6.g.a(r10, "name == null");
            this.f7990b = r11;
            this.f7991c = r12;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.h(this.f7989a, (String) this.f7990b.convert(r11), this.f7991c);
        }
    }

    public static final class u extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7993b;

        public u(Converter r10, boolean r11) {
            this.f7992a = r10;
            this.f7993b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public /* bridge */ /* synthetic */ void a(f6.d r10, Object r11) {
            d(r10, (Map) r11);
        }

        public void d(f6.d r10, Map r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            Iterator r12 = r11.entrySet().iterator();
        L6:
            if (r12.hasNext() == false) goto L15;
            Map.Entry r13 = (Map.Entry) r12.next();
            String r14 = (String) r13.getKey();
            if (r14 == null) goto L14;
            Object r15 = r13.getValue();
            if (r15 == null) goto L6;
            r10.h(r14, (String) this.f7992a.convert(r15), this.f7993b);
            goto L6
        L14:
            throw new IllegalArgumentException("Query map contained null key.");
        }
    }

    public static final class v extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Converter f7994a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7995b;

        public v(Converter r10, boolean r11) {
            this.f7994a = r10;
            this.f7995b = r11;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L4;
            return;
        L4:
            r10.h((String) this.f7994a.convert(r11), null, this.f7995b);
        }
    }

    public static final class w extends d {
        public w() {
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            if (r11 != null) goto L5;
            return;
        L5:
            if ((r11 instanceof QueryParamObject) == false) goto L9;
            r10.r(((QueryParamObject) r11).toQuery());
            return;
        L9:
            throw new RuntimeException("wrong type:" + r11.getClass() + ",not implement QueryParamObject");
        }
    }

    public static final class x extends d {
        public x() {
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            r10.s(r11);
        }
    }

    public static final class y extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class f7996a;

        public y(Class r10) {
            this.f7996a = r10;
        }

        @Override // com.bytedance.retrofit2.d
        public void a(f6.d r10, Object r11) {
            r10.i(this.f7996a, r11);
        }
    }

    public d() {
    }

    public abstract void a(f6.d r10, Object r11);

    public final d b() {
        return new b(this);
    }

    public final d c() {
        return new a(this);
    }
}
