package w5;

import F9.A;
import com.stepos.net.token.TokenProvider;
import com.stepos.taskrobot.llmapi.stepfun.g;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.k;
import n5.C1741a;

/* renamed from: w5.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2103c implements A {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6851a;
    public final Object b;
    public final Object c;

    public C2103c(String headerName) {
        this.f6851a = 2;
        C1741a c1741a = new C1741a(8);
        k.f(headerName, "headerName");
        this.b = headerName;
        this.c = c1741a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00a2  */
    @Override // F9.A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final F9.M intercept(F9.z r7) {
        /*
            Method dump skipped, instructions count: 372
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.C2103c.intercept(F9.z):F9.M");
    }

    public C2103c(Map headers, TokenProvider tokenProvider) {
        this.f6851a = 0;
        k.f(headers, "headers");
        this.b = headers;
        this.c = tokenProvider;
    }

    public C2103c(g gVar) {
        this.f6851a = 1;
        this.b = gVar;
        this.c = new ConcurrentHashMap();
    }
}
