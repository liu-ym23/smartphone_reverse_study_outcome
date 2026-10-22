package okhttp3;

import ad.t;
import bd.i;
import java.io.Closeable;
import okhttp3.f;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Response implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final h f10888a;

    /* renamed from: b, reason: collision with root package name */
    public final Protocol f10889b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10890c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10891d;

    /* renamed from: e, reason: collision with root package name */
    public final Handshake f10892e;
    public final f h;

    /* renamed from: j, reason: collision with root package name */
    public final t f10893j;

    /* renamed from: k, reason: collision with root package name */
    public final Response f10894k;

    /* renamed from: l, reason: collision with root package name */
    public final Response f10895l;

    /* renamed from: m, reason: collision with root package name */
    public final Response f10896m;

    /* renamed from: n, reason: collision with root package name */
    public final long f10897n;

    /* renamed from: o, reason: collision with root package name */
    public final long f10898o;

    /* renamed from: p, reason: collision with root package name */
    public final ed.d f10899p;

    /* renamed from: q, reason: collision with root package name */
    public final zb.a<f> f10900q;
    public final boolean r;

    public Response(h request, Protocol protocol, String message, int i10, Handshake handshake, f fVar, t body, Response response, Response response2, Response response3, long j10, long j11, ed.d dVar, zb.a<f> trailersFn) {
        kotlin.jvm.internal.g.f(request, "request");
        kotlin.jvm.internal.g.f(protocol, "protocol");
        kotlin.jvm.internal.g.f(message, "message");
        kotlin.jvm.internal.g.f(body, "body");
        kotlin.jvm.internal.g.f(trailersFn, "trailersFn");
        this.f10888a = request;
        this.f10889b = protocol;
        this.f10890c = message;
        this.f10891d = i10;
        this.f10892e = handshake;
        this.h = fVar;
        this.f10893j = body;
        this.f10894k = response;
        this.f10895l = response2;
        this.f10896m = response3;
        this.f10897n = j10;
        this.f10898o = j11;
        this.f10899p = dVar;
        this.f10900q = trailersFn;
        boolean z = false;
        if (200 <= i10 && i10 < 300) {
            z = true;
        }
        this.r = z;
    }

    public static String a(String name, Response response) {
        kotlin.jvm.internal.g.f(name, "name");
        String strA = response.h.a(name);
        if (strA == null) {
            return null;
        }
        return strA;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f10893j.close();
    }

    public final String toString() {
        return "Response{protocol=" + this.f10889b + ", code=" + this.f10891d + ", message=" + this.f10890c + ", url=" + this.f10888a.f10992a + '}';
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public h f10901a;

        /* renamed from: b, reason: collision with root package name */
        public Protocol f10902b;

        /* renamed from: c, reason: collision with root package name */
        public int f10903c;

        /* renamed from: d, reason: collision with root package name */
        public String f10904d;

        /* renamed from: e, reason: collision with root package name */
        public Handshake f10905e;

        /* renamed from: f, reason: collision with root package name */
        public f.a f10906f;

        /* renamed from: g, reason: collision with root package name */
        public t f10907g;
        public Response h;

        /* renamed from: i, reason: collision with root package name */
        public Response f10908i;

        /* renamed from: j, reason: collision with root package name */
        public Response f10909j;

        /* renamed from: k, reason: collision with root package name */
        public long f10910k;

        /* renamed from: l, reason: collision with root package name */
        public long f10911l;

        /* renamed from: m, reason: collision with root package name */
        public ed.d f10912m;

        /* renamed from: n, reason: collision with root package name */
        public zb.a<f> f10913n;

        public Builder() {
            this.f10903c = -1;
            this.f10907g = i.f3233d;
            this.f10913n = Response$Builder$trailersFn$1.f10915a;
            this.f10906f = new f.a();
        }

        public final Response a() {
            int i10 = this.f10903c;
            if (i10 < 0) {
                throw new IllegalStateException(("code < 0: " + this.f10903c).toString());
            }
            h hVar = this.f10901a;
            if (hVar == null) {
                throw new IllegalStateException("request == null");
            }
            Protocol protocol = this.f10902b;
            if (protocol == null) {
                throw new IllegalStateException("protocol == null");
            }
            String str = this.f10904d;
            if (str != null) {
                return new Response(hVar, protocol, str, i10, this.f10905e, this.f10906f.b(), this.f10907g, this.h, this.f10908i, this.f10909j, this.f10910k, this.f10911l, this.f10912m, this.f10913n);
            }
            throw new IllegalStateException("message == null");
        }

        public final void b(final ed.d dVar) {
            this.f10912m = dVar;
            this.f10913n = new zb.a<f>() { // from class: okhttp3.Response$Builder$initExchange$1
                {
                    super(0);
                }

                @Override // zb.a
                public final f invoke() {
                    return dVar.f8636d.i();
                }
            };
        }

        public Builder(Response response) {
            kotlin.jvm.internal.g.f(response, "response");
            this.f10903c = -1;
            this.f10907g = i.f3233d;
            this.f10913n = Response$Builder$trailersFn$1.f10915a;
            this.f10901a = response.f10888a;
            this.f10902b = response.f10889b;
            this.f10903c = response.f10891d;
            this.f10904d = response.f10890c;
            this.f10905e = response.f10892e;
            this.f10906f = response.h.e();
            this.f10907g = response.f10893j;
            this.h = response.f10894k;
            this.f10908i = response.f10895l;
            this.f10909j = response.f10896m;
            this.f10910k = response.f10897n;
            this.f10911l = response.f10898o;
            this.f10912m = response.f10899p;
            this.f10913n = response.f10900q;
        }
    }
}
