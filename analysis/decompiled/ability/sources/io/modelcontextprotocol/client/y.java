package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;

/* loaded from: classes2.dex */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4685a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ B7.a c;

    public /* synthetic */ y(Consumer consumer, B7.a aVar, int i) {
        this.f4685a = i;
        this.b = consumer;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4685a) {
            case 0:
                this.b.accept((McpSchema.ProgressNotification) this.c);
                break;
            default:
                this.b.accept((McpSchema.LoggingMessageNotification) this.c);
                break;
        }
    }
}
