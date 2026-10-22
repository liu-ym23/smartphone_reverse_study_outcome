package io.ktor.client.plugins.cookies;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@InterfaceC4112d(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", l = {60}, m = "captureHeaderCookies$ktor_client_core")
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class HttpCookies$captureHeaderCookies$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpCookies this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$captureHeaderCookies$1(HttpCookies httpCookies, InterfaceC4014c<? super HttpCookies$captureHeaderCookies$1> interfaceC4014c) {
        super(interfaceC4014c);
        this.this$0 = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.captureHeaderCookies$ktor_client_core(null, this);
    }
}
