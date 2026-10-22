package io.modelcontextprotocol.client;

import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6123c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ List f6124f;

    public /* synthetic */ h(int i) {
        this.f6123c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f6123c;
        List list = this.f6124f;
        switch (i) {
            case 0:
                McpAsyncClient.lambda$new$5(list);
                break;
            case 1:
                McpAsyncClient.lambda$new$1(list);
                break;
            case 2:
                McpAsyncClient.lambda$new$7(list);
                break;
            default:
                McpAsyncClient.lambda$new$3(list);
                break;
        }
    }
}
