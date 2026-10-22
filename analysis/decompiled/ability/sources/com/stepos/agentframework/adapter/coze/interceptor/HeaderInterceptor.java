package com.stepos.agentframework.adapter.coze.interceptor;

import F9.A;
import F9.M;
import F9.z;
import K1.a;
import K9.g;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u00028\u0006X\u0086D¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/adapter/coze/interceptor/HeaderInterceptor;", "LF9/A;", "", "secretKey", AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "LF9/z;", "chain", "LF9/M;", "intercept", "(LF9/z;)LF9/M;", "Ljava/lang/String;", "getSecretKey", "()Ljava/lang/String;", "setSecretKey", "BEARER", "getBEARER", "coze_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HeaderInterceptor implements A {
    private final String BEARER;
    private String secretKey;

    public HeaderInterceptor(String secretKey) {
        k.f(secretKey, "secretKey");
        this.secretKey = secretKey;
        this.BEARER = " Bearer";
    }

    public final String getBEARER() {
        return this.BEARER;
    }

    public final String getSecretKey() {
        return this.secretKey;
    }

    @Override // F9.A
    public M intercept(z chain) throws IOException {
        k.f(chain, "chain");
        g gVar = (g) chain;
        a aVarB = gVar.e.b();
        aVarB.g("Authorization", this.BEARER + " " + this.secretKey);
        aVarB.g(HttpHeaders.CACHE_CONTROL, "no-cache");
        aVarB.g("Accept", "*/*");
        return gVar.b(aVarB.d());
    }

    public final void setSecretKey(String str) {
        k.f(str, "<set-?>");
        this.secretKey = str;
    }
}
