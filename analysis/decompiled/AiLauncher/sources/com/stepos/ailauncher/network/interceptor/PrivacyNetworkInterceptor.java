package com.stepos.ailauncher.network.interceptor;

import com.stepos.ailauncher.common.privacy.b;
import h8.C4148a;
import java.io.IOException;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import kotlin.jvm.internal.y;
import tb.C5530C;
import tb.v;
import tb.w;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/stepos/ailauncher/network/interceptor/PrivacyNetworkInterceptor;", "Ltb/w;", "<init>", "()V", "Ltb/w$a;", "chain", "Ltb/C;", "intercept", "(Ltb/w$a;)Ltb/C;", "Companion", "network_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrivacyNetworkInterceptor implements w {
    private static final String TAG = "PrivacyNetwork";

    @Override // tb.w
    public C5530C intercept(w.a chain) throws IOException {
        p.i(chain, "chain");
        if (b.INSTANCE.b()) {
            return chain.i(chain.getRequest());
        }
        v url = chain.getRequest().getUrl();
        y yVar = y.f34840a;
        String str = String.format("blocked before privacy consent: %s %s", Arrays.copyOf(new Object[]{chain.getRequest().getMethod(), url}, 2));
        p.h(str, "format(...)");
        C4148a.u(TAG, str, false, 4, null);
        throw new IOException("Network blocked: privacy not granted (" + url + ")");
    }
}
