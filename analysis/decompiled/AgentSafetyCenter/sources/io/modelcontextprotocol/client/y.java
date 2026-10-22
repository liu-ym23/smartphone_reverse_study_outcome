package io.modelcontextprotocol.client;

import io.modelcontextprotocol.spec.McpSchema;
import java.util.function.Consumer;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class y implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6226c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Consumer f6227f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ androidx.activity.b f6228g;

    public /* synthetic */ y(int i) {
        this.f6226c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6226c) {
            case 0:
                this.f6227f.accept((McpSchema.ProgressNotification) this.f6228g);
                break;
            default:
                this.f6227f.accept((McpSchema.LoggingMessageNotification) this.f6228g);
                break;
        }
    }
}
