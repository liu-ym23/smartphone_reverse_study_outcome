package io.modelcontextprotocol.server.transport;

import jakarta.servlet.http.HttpServlet;
import java.util.function.Supplier;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements Supplier {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6292c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ HttpServlet f6293f;

    public /* synthetic */ a(int i) {
        this.f6292c = i;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = this.f6292c;
        HttpServlet httpServlet = this.f6293f;
        switch (i) {
            case 0:
                return ((HttpServletSseServerTransportProvider) httpServlet).lambda$new$0();
            default:
                return ((HttpServletStreamableServerTransportProvider) httpServlet).lambda$new$0();
        }
    }
}
