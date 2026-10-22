package qd;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import sd.r;
import sd.z;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11653a;

    /* renamed from: b, reason: collision with root package name */
    public final sd.e f11654b;

    /* renamed from: c, reason: collision with root package name */
    public final Inflater f11655c;

    /* renamed from: d, reason: collision with root package name */
    public final r f11656d;

    public c(boolean z) {
        this.f11653a = z;
        sd.e eVar = new sd.e();
        this.f11654b = eVar;
        Inflater inflater = new Inflater(true);
        this.f11655c = inflater;
        this.f11656d = new r(new z(eVar), inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f11656d.close();
    }
}
