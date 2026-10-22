package io.modelcontextprotocol.server.transport;

import jakarta.servlet.http.HttpServlet;
import java.util.function.Supplier;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4719a;
    public final /* synthetic */ HttpServlet b;

    public /* synthetic */ a(HttpServlet httpServlet, int i) {
        this.f4719a = i;
        this.b = httpServlet;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f4719a;
        HttpServlet httpServlet = this.b;
        switch (i) {
            case 0:
                return ((HttpServletSseServerTransportProvider) httpServlet).lambda$new$0();
            default:
                return ((HttpServletStreamableServerTransportProvider) httpServlet).lambda$new$0();
        }
    }
}
