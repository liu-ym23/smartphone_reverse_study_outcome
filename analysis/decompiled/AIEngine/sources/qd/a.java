package qd;

import java.io.Closeable;
import java.util.zip.Deflater;
import sd.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11648a;

    /* renamed from: b, reason: collision with root package name */
    public final sd.e f11649b;

    /* renamed from: c, reason: collision with root package name */
    public final Deflater f11650c;

    /* renamed from: d, reason: collision with root package name */
    public final i f11651d;

    public a(boolean z) {
        this.f11648a = z;
        sd.e eVar = new sd.e();
        this.f11649b = eVar;
        Deflater deflater = new Deflater(-1, true);
        this.f11650c = deflater;
        this.f11651d = new i(jd.b.i(eVar), deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f11651d.close();
    }
}
