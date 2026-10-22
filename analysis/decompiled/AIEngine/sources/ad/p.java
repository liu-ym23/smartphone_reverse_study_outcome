package ad;

import java.io.FileNotFoundException;
import java.io.IOException;
import sd.e0;
import sd.x;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class p extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f165a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ sd.l f166b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ x f167c;

    public p(x xVar, sd.l lVar, l lVar2) {
        this.f165a = lVar2;
        this.f166b = lVar;
        this.f167c = xVar;
    }

    @Override // ad.s
    public final long contentLength() throws FileNotFoundException {
        sd.l lVar = this.f166b;
        x xVar = this.f167c;
        sd.k kVarA = lVar.a(xVar);
        if (kVarA == null) {
            throw new FileNotFoundException("no such file: " + xVar);
        }
        Long l10 = kVarA.f11954c;
        if (l10 != null) {
            return l10.longValue();
        }
        return -1L;
    }

    @Override // ad.s
    public final l contentType() {
        return this.f165a;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) throws IOException {
        kotlin.jvm.internal.g.f(sink, "sink");
        e0 e0VarC = this.f166b.c(this.f167c);
        try {
            sink.u(e0VarC);
            e0VarC.close();
        } finally {
        }
    }
}
