package h3;

import java.io.IOException;
import k3.InterfaceC0680B;

/* renamed from: h3.c, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0594c extends k3.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0595d f12878a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0594c(InterfaceC0680B interfaceC0680B, C0595d c0595d) {
        super(interfaceC0680B);
        this.f12878a = c0595d;
    }

    @Override // k3.o, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f12878a.f12883a.close();
        super.close();
    }
}
