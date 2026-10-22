package h3;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.Logger;
import k3.C0683E;
import k3.C0689d;
import k3.InterfaceC0695j;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class W extends Z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12832a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ M f12833b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f12834c;

    public W(M m4, Object obj, int i4) {
        this.f12832a = i4;
        this.f12833b = m4;
        this.f12834c = obj;
    }

    @Override // h3.Z
    public final long contentLength() {
        int i4 = this.f12832a;
        Object obj = this.f12834c;
        switch (i4) {
            case 0:
                return ((File) obj).length();
            default:
                return ((k3.l) obj).c();
        }
    }

    @Override // h3.Z
    public final M contentType() {
        return this.f12833b;
    }

    @Override // h3.Z
    public final void writeTo(InterfaceC0695j sink) {
        int i4 = this.f12832a;
        Object obj = this.f12834c;
        switch (i4) {
            case 0:
                Intrinsics.checkNotNullParameter(sink, "sink");
                File file = (File) obj;
                Logger logger = k3.s.f13375a;
                Intrinsics.checkNotNullParameter(file, "<this>");
                C0689d c0689d = new C0689d(new FileInputStream(file), C0683E.NONE);
                try {
                    sink.A(c0689d);
                    CloseableKt.closeFinally(c0689d, null);
                    return;
                } finally {
                }
            default:
                Intrinsics.checkNotNullParameter(sink, "sink");
                sink.r((k3.l) obj);
                return;
        }
    }
}
