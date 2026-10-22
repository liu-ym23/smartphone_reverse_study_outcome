package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.internal.AdaptedFunctionReference;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class HttpTimeoutKt$HttpTimeout$2 extends AdaptedFunctionReference implements InterfaceC5063a<HttpTimeoutConfig> {
    public static final HttpTimeoutKt$HttpTimeout$2 INSTANCE = new HttpTimeoutKt$HttpTimeout$2();

    public HttpTimeoutKt$HttpTimeout$2() {
        super(0, HttpTimeoutConfig.class, "<init>", "<init>(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p9.InterfaceC5063a
    public final HttpTimeoutConfig invoke() {
        return new HttpTimeoutConfig(null, null, null, 7, null);
    }
}
