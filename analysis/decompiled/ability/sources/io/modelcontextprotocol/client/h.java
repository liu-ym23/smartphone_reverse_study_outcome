package io.modelcontextprotocol.client;

import java.util.List;

/* loaded from: classes2.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4637a;
    public final /* synthetic */ List b;

    public /* synthetic */ h(List list, int i) {
        this.f4637a = i;
        this.b = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f4637a;
        List list = this.b;
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
