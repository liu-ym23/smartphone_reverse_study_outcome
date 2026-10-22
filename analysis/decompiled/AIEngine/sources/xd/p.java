package xd;

import ad.j;
import ad.m;
import java.util.ArrayList;
import java.util.regex.Pattern;
import okhttp3.f;
import okhttp3.g;
import okhttp3.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f13860l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: m, reason: collision with root package name */
    public static final Pattern f13861m = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* renamed from: a, reason: collision with root package name */
    public final String f13862a;

    /* renamed from: b, reason: collision with root package name */
    public final okhttp3.g f13863b;

    /* renamed from: c, reason: collision with root package name */
    public String f13864c;

    /* renamed from: d, reason: collision with root package name */
    public g.a f13865d;

    /* renamed from: e, reason: collision with root package name */
    public final h.a f13866e = new h.a();

    /* renamed from: f, reason: collision with root package name */
    public final f.a f13867f;

    /* renamed from: g, reason: collision with root package name */
    public ad.l f13868g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final m.a f13869i;

    /* renamed from: j, reason: collision with root package name */
    public final j.a f13870j;

    /* renamed from: k, reason: collision with root package name */
    public ad.s f13871k;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a extends ad.s {

        /* renamed from: a, reason: collision with root package name */
        public final ad.s f13872a;

        /* renamed from: b, reason: collision with root package name */
        public final ad.l f13873b;

        public a(ad.s sVar, ad.l lVar) {
            this.f13872a = sVar;
            this.f13873b = lVar;
        }

        @Override // ad.s
        public final long contentLength() {
            return this.f13872a.contentLength();
        }

        @Override // ad.s
        public final ad.l contentType() {
            return this.f13873b;
        }

        @Override // ad.s
        public final void writeTo(sd.g gVar) {
            this.f13872a.writeTo(gVar);
        }
    }

    public p(String str, okhttp3.g gVar, String str2, okhttp3.f fVar, ad.l lVar, boolean z, boolean z3, boolean z10) {
        this.f13862a = str;
        this.f13863b = gVar;
        this.f13864c = str2;
        this.f13868g = lVar;
        this.h = z;
        if (fVar != null) {
            this.f13867f = fVar.e();
        } else {
            this.f13867f = new f.a();
        }
        if (z3) {
            this.f13870j = new j.a(0);
            return;
        }
        if (z10) {
            m.a aVar = new m.a();
            this.f13869i = aVar;
            ad.l type = ad.m.f105f;
            kotlin.jvm.internal.g.f(type, "type");
            if (type.f101b.equals("multipart")) {
                aVar.f113b = type;
            } else {
                throw new IllegalArgumentException(("multipart != " + type).toString());
            }
        }
    }

    public final void a(String name, String str, boolean z) {
        j.a aVar = this.f13870j;
        if (!z) {
            aVar.a(name, str);
            return;
        }
        aVar.getClass();
        kotlin.jvm.internal.g.f(name, "name");
        aVar.f98a.add(pd.a.b(name, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, 83));
        aVar.f99b.add(pd.a.b(str, 0, 0, " !\"#$&'()+,/:;<=>?@[\\]^`{|}~", true, false, true, false, 83));
    }

    public final void b(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.f13867f.a(str, str2);
            return;
        }
        try {
            kotlin.jvm.internal.g.f(str2, "<this>");
            this.f13868g = bd.d.a(str2);
        } catch (IllegalArgumentException e10) {
            throw new IllegalArgumentException(ai.onnxruntime.a.k("Malformed content type: ", str2), e10);
        }
    }

    public final void c(okhttp3.f fVar, ad.s body) {
        m.a aVar = this.f13869i;
        aVar.getClass();
        kotlin.jvm.internal.g.f(body, "body");
        if (fVar.a("Content-Type") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Type");
        }
        if (fVar.a("Content-Length") != null) {
            throw new IllegalArgumentException("Unexpected header: Content-Length");
        }
        aVar.f114c.add(new m.b(fVar, body));
    }

    public final void d(String encodedName, String str, boolean z) {
        String str2 = this.f13864c;
        if (str2 != null) {
            okhttp3.g gVar = this.f13863b;
            g.a aVarG = gVar.g(str2);
            this.f13865d = aVarG;
            if (aVarG == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + gVar + ", Relative: " + this.f13864c);
            }
            this.f13864c = null;
        }
        if (!z) {
            this.f13865d.a(encodedName, str);
            return;
        }
        g.a aVar = this.f13865d;
        aVar.getClass();
        kotlin.jvm.internal.g.f(encodedName, "encodedName");
        if (aVar.f10991g == null) {
            aVar.f10991g = new ArrayList();
        }
        ArrayList arrayList = aVar.f10991g;
        kotlin.jvm.internal.g.c(arrayList);
        arrayList.add(pd.a.a(encodedName, " \"'<>#&=", 0, 0, 83));
        ArrayList arrayList2 = aVar.f10991g;
        kotlin.jvm.internal.g.c(arrayList2);
        arrayList2.add(str != null ? pd.a.a(str, " \"'<>#&=", 0, 0, 83) : null);
    }
}
