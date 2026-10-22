package G6;

import B9.Q;
import F9.G;
import F9.K;
import F9.L;
import F9.M;
import F9.O;
import F9.t;
import J9.i;
import V9.r;
import aa.InterfaceC0315b;
import com.fasterxml.jackson.databind.JsonNode;
import com.networknt.schema.SchemaException;
import com.networknt.schema.keyword.KeywordType;
import io.modelcontextprotocol.spec.HttpHeaders;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.internal.k;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import u3.j;
import w3.C2097b;
import z3.AbstractC2156a;
import z3.J;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public boolean f679a;
    public boolean b;
    public final Object c;
    public final Object d;
    public final Object e;
    public Object f;
    public Object g;

    public c(e eVar, Q q5, Ba.f fVar) {
        this.c = eVar;
        this.d = q5;
        this.e = fVar;
        this.f679a = true;
        this.b = true;
    }

    public IOException a(long j5, boolean z10, boolean z11, IOException iOException) {
        t tVar = (t) this.d;
        i iVar = (i) this.c;
        if (iOException != null) {
            g(iOException);
        }
        if (z11) {
            if (iOException != null) {
                tVar.getClass();
            } else {
                tVar.n(iVar, j5);
            }
        }
        if (z10) {
            if (iOException != null) {
                tVar.getClass();
            } else {
                tVar.r(iVar, j5);
            }
        }
        return iVar.h(this, z11, z10, iOException);
    }

    public J9.c b(G g, boolean z10) {
        this.f679a = z10;
        K k = g.d;
        k.c(k);
        long jContentLength = k.contentLength();
        ((t) this.d).o((i) this.c);
        return new J9.c(this, ((K9.e) this.f).g(g, jContentLength), jContentLength);
    }

    public u3.i c(j jVar, JsonNode jsonNode, u3.i iVar) {
        return ((u3.k) this.d).a(this, jVar, jsonNode, iVar, false);
    }

    public AbstractC2156a d(j jVar, String str, JsonNode jsonNode, u3.i iVar) {
        C2097b c2097b = (C2097b) this.c;
        c2097b.getClass();
        InterfaceC0315b interfaceC0315b = C2097b.g;
        try {
            z3.t tVar = (z3.t) c2097b.c.get(str);
            if (tVar == null) {
                ((u3.k) this.d).g.getClass();
                if (!str.equals(null) && (!this.b || !"nullable".equals(str))) {
                    KeywordType keywordType = KeywordType.n;
                    if (keywordType.f3054a.equals(str) && this.f679a) {
                        return keywordType.a(jVar, jsonNode, iVar, this);
                    }
                    c2097b.f.getClass();
                    InterfaceC0315b interfaceC0315b2 = z3.K.b;
                    z3.t tVar2 = (z3.t) J.f6944a.f6945a.computeIfAbsent(str, new reactor.util.retry.a(10));
                    if (tVar2 != null) {
                        tVar = tVar2;
                    }
                }
                return null;
            }
            return tVar.a(jVar, jsonNode, iVar, this);
        } catch (SchemaException e) {
            throw e;
        } catch (InvocationTargetException e6) {
            if (e6.getTargetException() instanceof SchemaException) {
                interfaceC0315b.error("Error:", e6);
                throw ((SchemaException) e6.getTargetException());
            }
            interfaceC0315b.h(str, "Could not load validator {}");
            throw new SchemaException(e6.getTargetException());
        } catch (Exception e9) {
            interfaceC0315b.h(str, "Could not load validator {}");
            throw new SchemaException(e9);
        }
    }

    public O e(M m) throws IOException {
        K9.e eVar = (K9.e) this.f;
        try {
            String strB = M.b(m, HttpHeaders.CONTENT_TYPE);
            long jF = eVar.f(m);
            return new O(strB, jF, new r(new J9.d(this, eVar.c(m), jF)), 1);
        } catch (IOException e) {
            ((t) this.d).getClass();
            g(e);
            throw e;
        }
    }

    public L f(boolean z10) throws IOException {
        try {
            L lE = ((K9.e) this.f).e(z10);
            if (lE == null) {
                return lE;
            }
            lE.m = this;
            return lE;
        } catch (IOException e) {
            ((t) this.d).getClass();
            g(e);
            throw e;
        }
    }

    public void g(IOException iOException) {
        this.b = true;
        ((J9.e) this.e).e(iOException);
        okhttp3.internal.connection.a aVarB = ((K9.e) this.f).b();
        i iVar = (i) this.c;
        synchronized (aVarB) {
            try {
                if (!(iOException instanceof StreamResetException)) {
                    if (!(aVarB.g != null) || (iOException instanceof ConnectionShutdownException)) {
                        aVarB.f5471j = true;
                        if (aVarB.m == 0) {
                            okhttp3.internal.connection.a.d(iVar.f897a, aVarB.b, iOException);
                            aVarB.l++;
                        }
                    }
                } else if (((StreamResetException) iOException).f5474a == ErrorCode.REFUSED_STREAM) {
                    int i = aVarB.n + 1;
                    aVarB.n = i;
                    if (i > 1) {
                        aVarB.f5471j = true;
                        aVarB.l++;
                    }
                } else if (((StreamResetException) iOException).f5474a != ErrorCode.CANCEL || !iVar.o) {
                    aVarB.f5471j = true;
                    aVarB.l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void h(float f, float f7) {
        Ba.f fVar = (Ba.f) this.e;
        if (this.f679a) {
            if (k.a((Float) this.f, f) && k.a((Float) this.g, f7)) {
                return;
            }
            try {
                ((e) this.c).invoke(Float.valueOf(f), Float.valueOf(f7));
                this.f = Float.valueOf(f);
                this.g = Float.valueOf(f7);
                return;
            } catch (Exception e) {
                this.f679a = false;
                this.f = null;
                this.g = null;
                fVar.invoke(e);
            }
        }
        if (!this.b || k.a((Float) this.f, f)) {
            return;
        }
        try {
            ((Q) this.d).invoke(Float.valueOf(f));
            this.f = Float.valueOf(f);
        } catch (Exception e6) {
            this.b = false;
            fVar.invoke(e6);
        }
    }

    public c(i iVar, t eventListener, J9.e finder, K9.e eVar) {
        k.f(eventListener, "eventListener");
        k.f(finder, "finder");
        this.c = iVar;
        this.d = eventListener;
        this.e = finder;
        this.f = eVar;
        this.g = eVar.b();
    }

    public c(C2097b c2097b, u3.k kVar) {
        this(c2097b, kVar, new ConcurrentHashMap(), new ConcurrentHashMap(), new ConcurrentHashMap());
    }

    public c(C2097b c2097b, u3.k kVar, ConcurrentMap concurrentMap, ConcurrentMap concurrentMap2, ConcurrentMap concurrentMap3) {
        if (c2097b != null) {
            HashMap map = c2097b.c;
            if (kVar != null) {
                this.c = c2097b;
                this.d = kVar;
                this.e = concurrentMap;
                this.f = concurrentMap2;
                this.g = concurrentMap3;
                if (map.containsKey("discriminator")) {
                    this.f679a = true;
                } else {
                    this.f679a = false;
                }
                if (map.containsKey("nullable")) {
                    this.b = true;
                    return;
                } else {
                    this.b = false;
                    return;
                }
            }
            throw new IllegalArgumentException("SchemaRegistry must not be null");
        }
        throw new IllegalArgumentException("Dialect must not be null");
    }
}
