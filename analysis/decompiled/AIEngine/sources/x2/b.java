package x2;

import com.fasterxml.jackson.core.JsonEncoding;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object f13713a;

    /* renamed from: b, reason: collision with root package name */
    public JsonEncoding f13714b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13715c;

    /* renamed from: d, reason: collision with root package name */
    public final a3.a f13716d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f13717e;

    /* renamed from: f, reason: collision with root package name */
    public byte[] f13718f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f13719g;
    public char[] h;

    /* renamed from: i, reason: collision with root package name */
    public char[] f13720i;

    /* renamed from: j, reason: collision with root package name */
    public char[] f13721j;

    public b(a3.a aVar, Object obj, boolean z) {
        this.f13716d = aVar;
        this.f13713a = obj;
        this.f13715c = z;
    }

    public static void a(Object obj) {
        if (obj != null) {
            throw new IllegalStateException("Trying to call same allocXxx() method second time");
        }
    }

    public final byte[] b() {
        a(this.f13719g);
        byte[] bArrA = this.f13716d.a(3);
        this.f13719g = bArrA;
        return bArrA;
    }

    public final void c(byte[] bArr) {
        byte[] bArr2 = this.f13719g;
        if (bArr != bArr2 && bArr.length < bArr2.length) {
            throw new IllegalArgumentException("Trying to release buffer smaller than original");
        }
        this.f13719g = null;
        this.f13716d.f10a.set(3, bArr);
    }

    public final void d(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = this.f13717e;
            if (bArr != bArr2 && bArr.length < bArr2.length) {
                throw new IllegalArgumentException("Trying to release buffer smaller than original");
            }
            this.f13717e = null;
            this.f13716d.f10a.set(0, bArr);
        }
    }
}
