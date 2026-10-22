package g4;

import com.google.android.material.datepicker.C0900c;
import com.stepos.ability.mcpserver.model.McpResponse;
import com.stepos.ability.mcpserver.model.McpServerConfig;
import i4.C1554b;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.Semaphore;
import k4.h;
import k4.w;
import k4.z;
import kotlin.jvm.internal.k;
import z7.AbstractC2188i;
import z7.InterfaceC2187h;

/* renamed from: g4.e, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1458e extends AbstractC2188i {

    /* renamed from: j, reason: collision with root package name */
    public final McpServerConfig f4481j;
    public final com.stepos.ability.mcpserver.endpoint.a k;
    public final z l;
    public final h m;
    public final w n;
    public final C1554b o;
    public final Semaphore p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1458e(McpServerConfig config, int i, com.stepos.ability.mcpserver.endpoint.a router, z serverNonce, h authenticator, w rateLimiter, C1554b monitor) {
        super(config.getBindHost(), i);
        k.f(config, "config");
        k.f(router, "router");
        k.f(serverNonce, "serverNonce");
        k.f(authenticator, "authenticator");
        k.f(rateLimiter, "rateLimiter");
        k.f(monitor, "monitor");
        this.f4481j = config;
        this.k = router;
        this.l = serverNonce;
        this.m = authenticator;
        this.n = rateLimiter;
        this.o = monitor;
        this.p = new Semaphore(config.getMaxConcurrency());
        this.e = new C0900c(config.getMaxConnections(), monitor);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008f  */
    @Override // z7.AbstractC2188i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fi.iki.elonen.a e(z7.C2185f r19) throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.C1458e.e(z7.f):fi.iki.elonen.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01fe A[Catch: all -> 0x01d7, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01d7, blocks: (B:70:0x01b6, B:72:0x01bf, B:75:0x01da, B:77:0x01e4, B:82:0x01f9, B:85:0x01fe), top: B:150:0x01b6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final fi.iki.elonen.a i(z7.C2185f r20, k4.t r21) {
        /*
            Method dump skipped, instructions count: 922
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.C1458e.i(z7.f, k4.t):fi.iki.elonen.a");
    }

    public final fi.iki.elonen.a j(InterfaceC2187h interfaceC2187h, McpResponse mcpResponse) throws UnsupportedEncodingException {
        String strC = P3.a.c(mcpResponse);
        if (strC == null) {
            strC = "{}";
        }
        fi.iki.elonen.a aVarC = AbstractC2188i.c(interfaceC2187h, "application/json", strC);
        aVarC.b(this.l.f4820a);
        return aVarC;
    }
}
