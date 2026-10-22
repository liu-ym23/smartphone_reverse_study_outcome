package io.ktor.client.plugins;

import kotlin.Metadata;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;

@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* synthetic */ class HttpRequestRetryKt$HttpRequestRetry$1 extends FunctionReferenceImpl implements InterfaceC5063a<HttpRequestRetryConfig> {
    public static final HttpRequestRetryKt$HttpRequestRetry$1 INSTANCE = new HttpRequestRetryKt$HttpRequestRetry$1();

    public HttpRequestRetryKt$HttpRequestRetry$1() {
        super(0, HttpRequestRetryConfig.class, "<init>", "<init>()V", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p9.InterfaceC5063a
    public final HttpRequestRetryConfig invoke() {
        return new HttpRequestRetryConfig();
    }
}
