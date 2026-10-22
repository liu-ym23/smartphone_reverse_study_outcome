package io.modelcontextprotocol.client.transport;

import java.io.IOException;
import java.util.function.Function;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ StdioClientTransport f6183c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Function f6184f;

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        this.f6183c.lambda$connect$1(this.f6184f);
    }
}
