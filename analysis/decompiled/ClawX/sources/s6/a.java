package s6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.internal.p;
import n6.n;
import n6.q;
import n6.s;
import n6.u;
import r6.o;
import r6.r;
import r6.v;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements n {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5241a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f5242b;

    public a(n6.b cookieJar) {
        p.e(cookieJar, "cookieJar");
        this.f5242b = cookieJar;
    }

    public static int d(u uVar, int i8) throws NumberFormatException {
        String strF = uVar.f4150f.f("Retry-After");
        if (strF == null) {
            strF = null;
        }
        if (strF == null) {
            return i8;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        p.d(patternCompile, "compile(...)");
        if (!patternCompile.matcher(strF).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strF);
        p.d(numValueOf, "valueOf(...)");
        return numValueOf.intValue();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v27 r6.r, still in use, count: 2, list:
          (r0v27 r6.r) from 0x0078: MOVE (r19v0 r6.r) = (r0v27 r6.r) (LINE:121)
          (r0v27 r6.r) from 0x0065: MOVE (r19v3 r6.r) = (r0v27 r6.r) (LINE:102)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:91)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:57)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // n6.n
    public final n6.u a(s6.h r35) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.a.a(s6.h):n6.u");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public n6.s b(n6.u r12, r6.g r13) throws java.net.ProtocolException {
        /*
            Method dump skipped, instructions count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s6.a.b(n6.u, r6.g):n6.s");
    }

    public boolean c(IOException iOException, o oVar, s sVar) {
        boolean z = iOException instanceof u6.a;
        if (!((q) this.f5242b).f4099e) {
            return false;
        }
        if ((!z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException)) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || !z) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        r6.g gVar = oVar.f5172r;
        if (gVar == null || !gVar.d) {
            return false;
        }
        r6.h hVar = oVar.f5162g;
        p.b(hVar);
        v vVarB = hVar.b();
        r6.g gVar2 = oVar.f5172r;
        return ((r) vVarB).a(gVar2 != null ? gVar2.b() : null);
    }

    public a(q qVar) {
        this.f5242b = qVar;
    }
}
