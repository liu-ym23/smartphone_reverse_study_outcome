package ad;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class r extends s {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f169a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FileDescriptor f170b;

    public r(FileDescriptor fileDescriptor, l lVar) {
        this.f169a = lVar;
        this.f170b = fileDescriptor;
    }

    @Override // ad.s
    public final l contentType() {
        return this.f169a;
    }

    @Override // ad.s
    public final boolean isOneShot() {
        return true;
    }

    @Override // ad.s
    public final void writeTo(sd.g sink) throws IOException {
        kotlin.jvm.internal.g.f(sink, "sink");
        FileInputStream fileInputStream = new FileInputStream(this.f170b);
        try {
            sink.c().u(jd.b.J(fileInputStream));
            fileInputStream.close();
        } finally {
        }
    }
}
