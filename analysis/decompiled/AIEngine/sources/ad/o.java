package ad;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import sd.f0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class o extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f163a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ File f164b;

    public o(l lVar, File file) {
        this.f163a = lVar;
        this.f164b = file;
    }

    @Override // ad.s
    public final long contentLength() {
        return this.f164b.length();
    }

    @Override // ad.s
    public final l contentType() {
        return this.f163a;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) {
        kotlin.jvm.internal.g.f(sink, "sink");
        Logger logger = sd.v.f11978a;
        File file = this.f164b;
        kotlin.jvm.internal.g.f(file, "<this>");
        sd.d dVar = new sd.d(new FileInputStream(file), f0.f11935d);
        try {
            sink.u(dVar);
            dVar.close();
        } finally {
        }
    }
}
