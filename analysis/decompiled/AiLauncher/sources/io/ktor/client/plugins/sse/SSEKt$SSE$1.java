package io.ktor.client.plugins.sse;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class SSEKt$SSE$1 extends FunctionReferenceImpl implements InterfaceC5063a<SSEConfig> {
    public static final SSEKt$SSE$1 INSTANCE = new SSEKt$SSE$1();

    public SSEKt$SSE$1() {
        super(0, SSEConfig.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p9.InterfaceC5063a
    public final SSEConfig invoke() {
        return new SSEConfig();
    }
}
