package i5;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import com.google.protobuf.a1;
import com.stepos.agentbus.config.AgentBusConfig;
import com.stepos.agentbus.domain.queue.OfflineQueueDatabase_Impl;
import com.stepos.agentcache.core.ServiceContract;
import d7.e0;
import d7.z;
import f4.c2;
import f4.k1;
import f4.q1;
import f8.b0;
import f8.d0;
import f8.n0;
import fi.iki.elonen.NanoHTTPD;
import g1.y;
import h4.v;
import i8.r0;
import ia.g1;
import j9.x;
import java.io.File;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import la.u0;
import m.a0;
import n.j1;
import n.w;

/* loaded from: classes.dex */
public final class f implements v, j1, o0.e, r9.e, x8.m, x8.k, x8.l {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f4652f;

    /* renamed from: g, reason: collision with root package name */
    public Object f4653g;

    /* renamed from: h, reason: collision with root package name */
    public Object f4654h;

    /* renamed from: i, reason: collision with root package name */
    public Object f4655i;

    /* renamed from: j, reason: collision with root package name */
    public Object f4656j;

    public /* synthetic */ f(int i2, Object obj) {
        this.f4652f = i2;
        this.f4653g = obj;
    }

    public static final void u(f fVar, String str, p7.a aVar) {
        Log.i("ScreenStateMonitor", str);
        try {
            aVar.c();
        } catch (Throwable th) {
            Log.w("ScreenStateMonitor", str + " callback failed: " + th.getMessage(), th);
        }
    }

    public static void w(f fVar, d3.d dVar) {
        fVar.getClass();
        q7.k.e(dVar, "handler");
        if (((LinkedHashSet) fVar.f4655i).add(dVar)) {
            d3.g gVar = (d3.g) fVar.f4654h;
            gVar.getClass();
            if (dVar.f2809c == null) {
                gVar.f2818e.addFirst(dVar);
                dVar.f2809c = fVar;
                gVar.b();
            } else {
                throw new IllegalArgumentException(("Handler '" + dVar + "' is already registered with a dispatcher").toString());
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:18|(1:21)|22|(2:100|23)|(15:25|(1:27)(1:28)|(0)|31|35|(1:38)|39|98|40|(6:46|(0)|52|(1:55)|56|(2:58|59)(2:60|(2:62|63)(5:64|(4:67|(1:112)(3:109|71|113)|110|65)|107|72|(2:74|75)(3:76|77|(0)(0)))))|49|52|(0)|56|(0)(0))|30|31|35|(0)|39|98|40|(8:42|44|46|(0)|52|(0)|56|(0)(0))|49|52|(0)|56|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0143, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0144, code lost:
    
        r0 = w7.e0.n(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Path cross not found for [B:30:0x00d4, B:25:0x00c3], limit reached: 107 */
    /* JADX WARN: Path cross not found for [B:49:0x0141, B:42:0x012a], limit reached: 107 */
    /* JADX WARN: Path cross not found for [B:49:0x0141, B:46:0x013a], limit reached: 107 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x028e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02bc  */
    /* JADX WARN: Type inference failed for: r5v16, types: [java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x022b -> B:84:0x0237). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object A(byte[] r21, i7.c r22) {
        /*
            Method dump skipped, instructions count: 740
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.A(byte[], i7.c):java.lang.Object");
    }

    public void B(d3.f fVar, d3.b bVar) {
        d3.g gVar = (d3.g) this.f4654h;
        gVar.getClass();
        if (gVar.f2820g != 0) {
            return;
        }
        d3.d dVarC = gVar.c(-1);
        gVar.f2819f = dVarC;
        gVar.f2820g = -1;
        gVar.f2821h = fVar;
        if (bVar != null) {
            if (dVarC != null) {
                dVarC.d(bVar);
            }
            u0 u0Var = gVar.f2814a;
            d3.i iVar = new d3.i(bVar);
            u0Var.getClass();
            u0Var.g(null, iVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        if (r0 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0080, code lost:
    
        if (r0 == r1) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0082, code lost:
    
        return r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object C(long r8, long r10, i7.c r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof b1.a
            if (r0 == 0) goto L14
            r0 = r12
            b1.a r0 = (b1.a) r0
            int r1 = r0.f1459h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f1459h = r1
        L12:
            r12 = r0
            goto L1a
        L14:
            b1.a r0 = new b1.a
            r0.<init>(r7, r12)
            goto L12
        L1a:
            java.lang.Object r0 = r12.f1457f
            h7.a r1 = h7.a.f4212f
            int r2 = r12.f1459h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L38
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            w7.e0.N(r0)
            goto L83
        L2c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L34:
            w7.e0.N(r0)
            goto L61
        L38:
            w7.e0.N(r0)
            java.lang.Object r0 = r7.f4653g
            b1.e r0 = (b1.e) r0
            r2 = 0
            if (r0 == 0) goto L4d
            boolean r5 = r0.f6810s
            if (r5 == 0) goto L4d
            i1.x1 r0 = i1.l.j(r0)
            b1.e r0 = (b1.e) r0
            goto L4e
        L4d:
            r0 = r2
        L4e:
            r5 = 0
            if (r0 != 0) goto L66
            java.lang.Object r7 = r7.f4654h
            b1.e r7 = (b1.e) r7
            if (r7 == 0) goto L87
            r12.f1459h = r4
            java.lang.Object r0 = r7.m0(r8, r10, r12)
            if (r0 != r1) goto L61
            goto L82
        L61:
            d2.p r0 = (d2.p) r0
            long r5 = r0.f2801a
            goto L87
        L66:
            java.lang.Object r7 = r7.f4653g
            b1.e r7 = (b1.e) r7
            if (r7 == 0) goto L77
            boolean r0 = r7.f6810s
            if (r0 == 0) goto L77
            i1.x1 r7 = i1.l.j(r7)
            r2 = r7
            b1.e r2 = (b1.e) r2
        L77:
            r7 = r2
            if (r7 == 0) goto L87
            r12.f1459h = r3
            java.lang.Object r0 = r7.m0(r8, r10, r12)
            if (r0 != r1) goto L83
        L82:
            return r1
        L83:
            d2.p r0 = (d2.p) r0
            long r5 = r0.f2801a
        L87:
            d2.p r7 = new d2.p
            r7.<init>(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.C(long, long, i7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object D(long r5, i7.c r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof b1.b
            if (r0 == 0) goto L13
            r0 = r7
            b1.b r0 = (b1.b) r0
            int r1 = r0.f1462h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f1462h = r1
            goto L18
        L13:
            b1.b r0 = new b1.b
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f1460f
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f1462h
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            w7.e0.N(r7)
            goto L4f
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            w7.e0.N(r7)
            java.lang.Object r4 = r4.f4653g
            b1.e r4 = (b1.e) r4
            r7 = 0
            if (r4 == 0) goto L44
            boolean r2 = r4.f6810s
            if (r2 == 0) goto L44
            i1.x1 r4 = i1.l.j(r4)
            r7 = r4
            b1.e r7 = (b1.e) r7
        L44:
            if (r7 == 0) goto L54
            r0.f1462h = r3
            java.lang.Object r7 = r7.o0(r5, r0)
            if (r7 != r1) goto L4f
            return r1
        L4f:
            d2.p r7 = (d2.p) r7
            long r4 = r7.f2801a
            goto L56
        L54:
            r4 = 0
        L56:
            d2.p r6 = new d2.p
            r6.<init>(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.D(long, i7.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0060, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006f, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E(i7.c r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f4656j
            s2.z r0 = (s2.z) r0
            boolean r1 = r7 instanceof s2.g
            if (r1 == 0) goto L17
            r1 = r7
            s2.g r1 = (s2.g) r1
            int r2 = r1.f9367i
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.f9367i = r2
            goto L1c
        L17:
            s2.g r1 = new s2.g
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f9365g
            h7.a r2 = h7.a.f4212f
            int r3 = r1.f9367i
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3e
            if (r3 == r5) goto L38
            if (r3 != r4) goto L30
            i5.f r6 = r1.f9364f
            w7.e0.N(r7)
            goto L63
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            i5.f r6 = r1.f9364f
            w7.e0.N(r7)
            goto L72
        L3e:
            w7.e0.N(r7)
            java.lang.Object r7 = r6.f4655i
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L66
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L66
        L4e:
            s2.g0 r7 = r0.d()
            s2.j r3 = new s2.j
            r5 = 0
            r3.<init>(r0, r6, r5)
            r1.f9364f = r6
            r1.f9367i = r4
            java.lang.Object r7 = r7.b(r3, r1)
            if (r7 != r2) goto L63
            goto L71
        L63:
            s2.c r7 = (s2.c) r7
            goto L74
        L66:
            r1.f9364f = r6
            r1.f9367i = r5
            r7 = 0
            java.lang.Object r7 = s2.z.c(r0, r7, r1)
            if (r7 != r2) goto L72
        L71:
            return r2
        L72:
            s2.c r7 = (s2.c) r7
        L74:
            java.lang.Object r6 = r6.f4656j
            s2.z r6 = (s2.z) r6
            o4.d0 r6 = r6.f9470l
            r6.T(r7)
            c7.r r6 = c7.r.f1986a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.E(i7.c):java.lang.Object");
    }

    public synchronized ExecutorService F() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (((ThreadPoolExecutor) this.f4653g) == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String str = bb.b.f1665g + " Dispatcher";
                q7.k.e(str, "name");
                this.f4653g = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new bb.a(str, false));
            }
            threadPoolExecutor = (ThreadPoolExecutor) this.f4653g;
            q7.k.b(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public void G(ArrayDeque arrayDeque, Object obj) {
        synchronized (this) {
            if (!arrayDeque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        M();
    }

    public void H(eb.f fVar) {
        fVar.f3268g.decrementAndGet();
        G((ArrayDeque) this.f4655i, fVar);
    }

    public f8.e I(e9.b bVar, List list) {
        q7.k.e(bVar, "classId");
        return (f8.e) ((u9.e) this.f4656j).invoke(new b0(bVar, list));
    }

    public n.n J(long j2, n.n nVar, n.n nVar2) {
        if (((n.n) this.f4655i) == null) {
            this.f4655i = nVar.c();
        }
        n.n nVar3 = (n.n) this.f4655i;
        if (nVar3 == null) {
            q7.k.j("velocityVector");
            throw null;
        }
        int iB = nVar3.b();
        for (int i2 = 0; i2 < iB; i2++) {
            n.n nVar4 = (n.n) this.f4655i;
            if (nVar4 == null) {
                q7.k.j("velocityVector");
                throw null;
            }
            a7.d dVar = (a7.d) this.f4653g;
            nVar.getClass();
            long j4 = j2 / 1000000;
            a0 a0VarA = ((m.b0) dVar.f411g).a(nVar2.a(i2));
            long j10 = a0VarA.f6040c;
            nVar4.e(i2, (((Math.signum(a0VarA.f6038a) * m.b.a(j10 > 0 ? j4 / j10 : 1.0f).f6037b) * a0VarA.f6039b) / j10) * 1000.0f);
        }
        n.n nVar5 = (n.n) this.f4655i;
        if (nVar5 != null) {
            return nVar5;
        }
        q7.k.j("velocityVector");
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:127:0x020a -> B:128:0x020e). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object K(c5.b r21, i7.c r22) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.K(c5.b, i7.c):java.lang.Object");
    }

    public boolean L(t9.s sVar) {
        if (((t9.s) this.f4654h).equals(sVar)) {
            return true;
        }
        f fVar = (f) this.f4653g;
        return fVar != null ? fVar.L(sVar) : false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M() {
        /*
            r8 = this;
            byte[] r0 = bb.b.f1659a
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            monitor-enter(r8)
            java.lang.Object r1 = r8.f4654h     // Catch: java.lang.Throwable -> L49
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch: java.lang.Throwable -> L49
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = "readyAsyncCalls.iterator()"
            q7.k.d(r1, r2)     // Catch: java.lang.Throwable -> L49
        L15:
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L49
            if (r2 == 0) goto L4b
            java.lang.Object r2 = r1.next()     // Catch: java.lang.Throwable -> L49
            eb.f r2 = (eb.f) r2     // Catch: java.lang.Throwable -> L49
            java.lang.Object r3 = r8.f4655i     // Catch: java.lang.Throwable -> L49
            java.util.ArrayDeque r3 = (java.util.ArrayDeque) r3     // Catch: java.lang.Throwable -> L49
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L49
            r4 = 64
            if (r3 >= r4) goto L4b
            java.util.concurrent.atomic.AtomicInteger r3 = r2.f3268g     // Catch: java.lang.Throwable -> L49
            int r3 = r3.get()     // Catch: java.lang.Throwable -> L49
            r4 = 5
            if (r3 >= r4) goto L15
            r1.remove()     // Catch: java.lang.Throwable -> L49
            java.util.concurrent.atomic.AtomicInteger r3 = r2.f3268g     // Catch: java.lang.Throwable -> L49
            r3.incrementAndGet()     // Catch: java.lang.Throwable -> L49
            r0.add(r2)     // Catch: java.lang.Throwable -> L49
            java.lang.Object r3 = r8.f4655i     // Catch: java.lang.Throwable -> L49
            java.util.ArrayDeque r3 = (java.util.ArrayDeque) r3     // Catch: java.lang.Throwable -> L49
            r3.add(r2)     // Catch: java.lang.Throwable -> L49
            goto L15
        L49:
            r0 = move-exception
            goto La4
        L4b:
            monitor-enter(r8)     // Catch: java.lang.Throwable -> L49
            java.lang.Object r1 = r8.f4655i     // Catch: java.lang.Throwable -> La1
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch: java.lang.Throwable -> La1
            r1.size()     // Catch: java.lang.Throwable -> La1
            java.lang.Object r1 = r8.f4656j     // Catch: java.lang.Throwable -> La1
            java.util.ArrayDeque r1 = (java.util.ArrayDeque) r1     // Catch: java.lang.Throwable -> La1
            r1.size()     // Catch: java.lang.Throwable -> La1
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L49
            monitor-exit(r8)
            int r1 = r0.size()
            r2 = 0
        L61:
            if (r2 >= r1) goto La0
            java.lang.Object r3 = r0.get(r2)
            eb.f r3 = (eb.f) r3
            java.util.concurrent.ExecutorService r4 = r8.F()
            r3.getClass()
            eb.i r5 = r3.f3269h
            byte[] r6 = bb.b.f1659a
            java.util.concurrent.ThreadPoolExecutor r4 = (java.util.concurrent.ThreadPoolExecutor) r4     // Catch: java.util.concurrent.RejectedExecutionException -> L7a java.lang.Throwable -> L97
            r4.execute(r3)     // Catch: java.util.concurrent.RejectedExecutionException -> L7a java.lang.Throwable -> L97
            goto L94
        L7a:
            r4 = move-exception
            java.io.InterruptedIOException r6 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L97
            java.lang.String r7 = "executor rejected"
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L97
            r6.initCause(r4)     // Catch: java.lang.Throwable -> L97
            r5.k(r6)     // Catch: java.lang.Throwable -> L97
            ab.d r4 = r3.f3267f     // Catch: java.lang.Throwable -> L97
            r4.b(r5, r6)     // Catch: java.lang.Throwable -> L97
            ab.t r4 = r5.f3272f
            i5.f r4 = r4.f627f
            r4.H(r3)
        L94:
            int r2 = r2 + 1
            goto L61
        L97:
            r8 = move-exception
            ab.t r0 = r5.f3272f
            i5.f r0 = r0.f627f
            r0.H(r3)
            throw r8
        La0:
            return
        La1:
            r0 = move-exception
            monitor-exit(r8)     // Catch: java.lang.Throwable -> La1
            throw r0     // Catch: java.lang.Throwable -> L49
        La4:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.M():void");
    }

    public void N(a4.a aVar) throws GeneralSecurityException {
        aVar.getClass();
        a4.r rVar = new a4.r(a4.p.class, aVar.f167a);
        HashMap map = (HashMap) this.f4654h;
        if (!map.containsKey(rVar)) {
            map.put(rVar, aVar);
            return;
        }
        a4.a aVar2 = (a4.a) map.get(rVar);
        if (aVar2.equals(aVar) && aVar.equals(aVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + rVar);
    }

    public void O(a4.b bVar) throws GeneralSecurityException {
        a4.s sVar = new a4.s(bVar.f169a, a4.p.class);
        HashMap map = (HashMap) this.f4653g;
        if (!map.containsKey(sVar)) {
            map.put(sVar, bVar);
            return;
        }
        a4.b bVar2 = (a4.b) map.get(sVar);
        if (bVar2.equals(bVar) && bVar.equals(bVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + sVar);
    }

    public void P(a4.k kVar) throws GeneralSecurityException {
        kVar.getClass();
        a4.r rVar = new a4.r(a4.q.class, kVar.f184a);
        HashMap map = (HashMap) this.f4656j;
        if (!map.containsKey(rVar)) {
            map.put(rVar, kVar);
            return;
        }
        a4.k kVar2 = (a4.k) map.get(rVar);
        if (kVar2.equals(kVar) && kVar.equals(kVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + rVar);
    }

    public void Q(a4.l lVar) throws GeneralSecurityException {
        a4.s sVar = new a4.s(lVar.f185a, a4.q.class);
        HashMap map = (HashMap) this.f4655i;
        if (!map.containsKey(sVar)) {
            map.put(sVar, lVar);
            return;
        }
        a4.l lVar2 = (a4.l) map.get(sVar);
        if (lVar2.equals(lVar) && lVar.equals(lVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + sVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v10, types: [ra.b] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object R(i7.c r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof s2.d0
            if (r0 == 0) goto L13
            r0 = r9
            s2.d0 r0 = (s2.d0) r0
            int r1 = r0.f9352j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9352j = r1
            goto L18
        L13:
            s2.d0 r0 = new s2.d0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f9350h
            h7.a r1 = h7.a.f4212f
            int r2 = r0.f9352j
            r3 = 2
            r4 = 1
            c7.r r5 = c7.r.f1986a
            r6 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            ra.b r8 = r0.f9349g
            i5.f r0 = r0.f9348f
            w7.e0.N(r9)     // Catch: java.lang.Throwable -> L31
            goto L83
        L31:
            r9 = move-exception
            goto L94
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            ra.b r8 = r0.f9349g
            i5.f r2 = r0.f9348f
            w7.e0.N(r9)
            r9 = r8
            r8 = r2
            goto L64
        L45:
            w7.e0.N(r9)
            java.lang.Object r9 = r8.f4654h
            ia.s r9 = (ia.s) r9
            boolean r9 = r9.V()
            if (r9 == 0) goto L53
            return r5
        L53:
            java.lang.Object r9 = r8.f4653g
            ra.d r9 = (ra.d) r9
            r0.f9348f = r8
            r0.f9349g = r9
            r0.f9352j = r4
            java.lang.Object r2 = r9.c(r0, r6)
            if (r2 != r1) goto L64
            goto L80
        L64:
            java.lang.Object r2 = r8.f4654h     // Catch: java.lang.Throwable -> L90
            ia.s r2 = (ia.s) r2     // Catch: java.lang.Throwable -> L90
            boolean r2 = r2.V()     // Catch: java.lang.Throwable -> L90
            if (r2 == 0) goto L74
            ra.d r9 = (ra.d) r9
            r9.e(r6)
            return r5
        L74:
            r0.f9348f = r8     // Catch: java.lang.Throwable -> L90
            r0.f9349g = r9     // Catch: java.lang.Throwable -> L90
            r0.f9352j = r3     // Catch: java.lang.Throwable -> L90
            java.lang.Object r0 = r8.E(r0)     // Catch: java.lang.Throwable -> L90
            if (r0 != r1) goto L81
        L80:
            return r1
        L81:
            r0 = r8
            r8 = r9
        L83:
            java.lang.Object r9 = r0.f4654h     // Catch: java.lang.Throwable -> L31
            ia.s r9 = (ia.s) r9     // Catch: java.lang.Throwable -> L31
            r9.X(r5)     // Catch: java.lang.Throwable -> L31
            ra.d r8 = (ra.d) r8
            r8.e(r6)
            return r5
        L90:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L94:
            ra.d r8 = (ra.d) r8
            r8.e(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i5.f.R(i7.c):java.lang.Object");
    }

    public void S() {
        if (((u5.c) this.f4656j) != null) {
            return;
        }
        u5.c cVar = new u5.c(1, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        try {
            ib.c.J((Context) this.f4655i, cVar, intentFilter);
            this.f4656j = cVar;
        } catch (Throwable th) {
            Log.w("ScreenStateMonitor", "registerReceiver failed: " + th.getMessage(), th);
        }
    }

    public void T() {
        u5.c cVar = (u5.c) this.f4656j;
        if (cVar == null) {
            return;
        }
        this.f4656j = null;
        try {
            ((Context) this.f4655i).unregisterReceiver(cVar);
        } catch (Throwable th) {
            Log.w("ScreenStateMonitor", "unregisterReceiver failed: " + th.getMessage(), th);
        }
    }

    public a7.g U(int i2, e9.b bVar, k8.a aVar) {
        x8.o oVar = new x8.o(((x8.o) this.f4653g).f11273a + '@' + i2);
        nb.f fVar = (nb.f) this.f4656j;
        HashMap map = (HashMap) fVar.f6948h;
        List arrayList = (List) map.get(oVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(oVar, arrayList);
        }
        return ((a4.p) fVar.f6947g).B(bVar, aVar, arrayList);
    }

    public Boolean V(n7.o oVar, p5.m mVar) {
        List<String> listJ0;
        String str;
        String str2;
        boolean z4;
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f4656j;
        if (oVar instanceof p5.k) {
            listJ0 = a.a.S(((p5.k) oVar).f8472b);
        } else if (oVar instanceof p5.j) {
            listJ0 = null;
            p5.s sVar = (p5.s) concurrentHashMap.get(null);
            if (sVar != null && (str = sVar.f8486c.f8469a) != null) {
                listJ0 = a.a.S(str);
            }
            if (listJ0 == null) {
                listJ0 = z.f2978f;
            }
        } else {
            if (!(oVar instanceof p5.l)) {
                throw new a4.u();
            }
            Collection collectionValues = concurrentHashMap.values();
            q7.k.d(collectionValues, "<get-values>(...)");
            ArrayList arrayList = new ArrayList();
            for (Object obj : collectionValues) {
                if (((p5.s) obj).f8485b == ((p5.l) oVar).f8473b) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(d7.t.A0(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((p5.s) it.next()).f8486c.f8469a);
            }
            listJ0 = d7.r.J0(arrayList2);
        }
        if (listJ0.isEmpty()) {
            return Boolean.FALSE;
        }
        if (listJ0.isEmpty()) {
            z4 = false;
        } else {
            for (String str3 : listJ0) {
                p5.q qVar = (p5.q) this.f4654h;
                p7.a aVar = qVar.f8482d;
                ConcurrentHashMap concurrentHashMap2 = qVar.f8483e;
                q7.k.e(str3, "clientId");
                p5.p pVar = (p5.p) concurrentHashMap2.get(str3);
                if (pVar == null) {
                    str2 = str3;
                } else {
                    long j2 = pVar.f8477a;
                    long jLongValue = ((Number) aVar.c()).longValue();
                    if (pVar.f8478b >= qVar.f8480b) {
                        str2 = str3;
                        if (jLongValue - j2 < qVar.f8481c) {
                        }
                        k5.s.debug$default((k5.t) this.f4655i, "AndroidPeerLauncher", "bff wake throttled for package=".concat(str2), null, 4, null);
                    } else {
                        str2 = str3;
                    }
                    if (jLongValue - j2 < qVar.f8479a) {
                        k5.s.debug$default((k5.t) this.f4655i, "AndroidPeerLauncher", "bff wake throttled for package=".concat(str2), null, 4, null);
                    }
                }
                try {
                    Intent intent = new Intent("com.stepos.agentbus.ACTION_BFF_WAKE");
                    intent.setPackage(str2);
                    intent.putExtra("source", "agentbus");
                    String str4 = mVar.f8474a;
                    if (str4 != null) {
                        intent.putExtra(ServiceContract.RequiredKeys.TRACE_ID, str4);
                    }
                    ((Context) this.f4653g).sendBroadcast(intent);
                    concurrentHashMap2.compute(str2, new k4.f(new p5.n(((Number) aVar.c()).longValue()), 5));
                    k5.s.info$default((k5.t) this.f4655i, "AndroidPeerLauncher", "ACTION_BFF_WAKE broadcast sent to " + str2 + " traceId=" + mVar.f8474a, null, 4, null);
                    z4 = true;
                    break;
                } catch (Throwable th) {
                    k5.s.warn$default((k5.t) this.f4655i, "AndroidPeerLauncher", a1.a.k("ACTION_BFF_WAKE broadcast to ", str2, " failed: ", th.getMessage()), null, 4, null);
                }
            }
            z4 = false;
        }
        return Boolean.valueOf(z4);
    }

    @Override // x8.k
    public void b() {
        switch (this.f4652f) {
            case 25:
                ArrayList arrayList = (ArrayList) this.f4654h;
                if (!arrayList.isEmpty()) {
                    ((HashMap) ((nb.f) this.f4655i).f6948h).put((x8.o) this.f4653g, arrayList);
                    break;
                }
                break;
            case 26:
                ((a7.g) this.f4654h).b();
                ((ArrayList) ((f) this.f4655i).f4653g).add(new j9.a((g8.c) d7.r.f1((ArrayList) this.f4656j)));
                break;
            default:
                a7.g gVar = (a7.g) this.f4656j;
                e9.f fVar = (e9.f) this.f4655i;
                ArrayList arrayList2 = (ArrayList) this.f4653g;
                gVar.getClass();
                q7.k.e(arrayList2, "elements");
                if (fVar != null) {
                    r0 r0VarQ = nb.i.q(fVar, (f8.e) gVar.f421j);
                    if (r0VarQ == null) {
                        if (((a4.p) gVar.f420i).z((e9.b) gVar.f422k) && q7.k.a(fVar.b(), "value")) {
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it = arrayList2.iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (next instanceof j9.a) {
                                    arrayList3.add(next);
                                }
                            }
                            List list = (List) gVar.f423l;
                            Iterator it2 = arrayList3.iterator();
                            while (it2.hasNext()) {
                                list.add((g8.c) ((j9.a) it2.next()).f5408a);
                            }
                            break;
                        }
                    } else {
                        HashMap map = (HashMap) gVar.f419h;
                        List listD = ea.k.d(arrayList2);
                        v9.v type = r0VarQ.getType();
                        q7.k.d(type, "parameter.type");
                        map.put(fVar, new x(listD, type));
                        break;
                    }
                }
                break;
        }
    }

    @Override // n.h1
    public long c(n.n nVar, n.n nVar2, n.n nVar3) {
        Iterator it = nb.i.N(0, nVar.b()).iterator();
        long jMax = 0;
        while (true) {
            v7.c cVar = (v7.c) it;
            if (!cVar.f10528h) {
                return jMax;
            }
            int iNextInt = cVar.nextInt();
            jMax = Math.max(jMax, ((n.o) this.f4653g).get(iNextInt).d(nVar.a(iNextInt), nVar2.a(iNextInt), nVar3.a(iNextInt)));
        }
    }

    @Override // x8.l
    public x8.k d(e9.b bVar) {
        ArrayList arrayList = new ArrayList();
        return new f(((a4.p) this.f4654h).A(bVar, n0.f3487b, arrayList), this, arrayList);
    }

    @Override // x8.k
    public void e(e9.f fVar, Object obj) {
        ((a7.g) this.f4653g).e(fVar, obj);
    }

    @Override // h4.v
    public synchronized void f(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() != ((h4.f) this.f4656j).e()) {
            throw new InvalidAlgorithmParameterException("Invalid header length");
        }
        if (byteBuffer.get() != ((h4.f) this.f4656j).e()) {
            throw new GeneralSecurityException("Invalid ciphertext");
        }
        this.f4655i = new byte[7];
        byte[] bArr2 = new byte[((h4.f) this.f4656j).f4129a];
        byteBuffer.get(bArr2);
        byteBuffer.get((byte[]) this.f4655i);
        h4.f fVar = (h4.f) this.f4656j;
        this.f4653g = new SecretKeySpec(ib.c.p(fVar.f4132d, fVar.f4133e, bArr2, bArr, fVar.f4129a), "AES");
        this.f4654h = (Cipher) h4.m.f4149b.f4151a.a("AES/GCM/NoPadding");
    }

    @Override // x8.k
    public void g(e9.f fVar, e9.b bVar, e9.f fVar2) {
        ((a7.g) this.f4653g).g(fVar, bVar, fVar2);
    }

    @Override // x8.l
    public void h(e9.b bVar, e9.f fVar) {
        ((ArrayList) this.f4653g).add(new j9.i(bVar, fVar));
    }

    @Override // r9.e
    public r9.d i(e9.b bVar) {
        q7.k.e(bVar, "classId");
        z8.i iVar = (z8.i) ((LinkedHashMap) this.f4656j).get(bVar);
        if (iVar == null) {
            return null;
        }
        q6.b bVar2 = (q6.b) this.f4653g;
        a9.a aVar = (a9.a) this.f4654h;
        ((r9.z) this.f4655i).invoke(bVar);
        return new r9.d(bVar2, iVar, aVar, n0.f3487b);
    }

    @Override // x8.l
    public void j(j9.f fVar) {
        ((ArrayList) this.f4653g).add(new j9.s(new j9.q(fVar)));
    }

    @Override // x8.k
    public void k(e9.f fVar, j9.f fVar2) {
        ((a7.g) this.f4653g).k(fVar, fVar2);
    }

    @Override // x8.k
    public x8.l l(e9.f fVar) {
        return ((a7.g) this.f4653g).l(fVar);
    }

    @Override // x8.m
    public x8.k n(e9.b bVar, k8.a aVar) {
        return ((a4.p) ((nb.f) this.f4655i).f6947g).B(bVar, aVar, (ArrayList) this.f4654h);
    }

    @Override // n.h1
    public n.n o(n.n nVar, n.n nVar2, n.n nVar3) {
        if (((n.n) this.f4656j) == null) {
            this.f4656j = nVar3.c();
        }
        n.n nVar4 = (n.n) this.f4656j;
        if (nVar4 == null) {
            q7.k.j("endVelocityVector");
            throw null;
        }
        int iB = nVar4.b();
        for (int i2 = 0; i2 < iB; i2++) {
            n.n nVar5 = (n.n) this.f4656j;
            if (nVar5 == null) {
                q7.k.j("endVelocityVector");
                throw null;
            }
            nVar5.e(i2, ((n.o) this.f4653g).get(i2).e(nVar.a(i2), nVar2.a(i2), nVar3.a(i2)));
        }
        n.n nVar6 = (n.n) this.f4656j;
        if (nVar6 != null) {
            return nVar6;
        }
        q7.k.j("endVelocityVector");
        throw null;
    }

    @Override // x8.k
    public x8.k p(e9.b bVar, e9.f fVar) {
        return ((a7.g) this.f4653g).p(bVar, fVar);
    }

    @Override // h4.v
    public synchronized void q(ByteBuffer byteBuffer, int i2, boolean z4, ByteBuffer byteBuffer2) {
        ((Cipher) this.f4654h).init(2, (SecretKeySpec) this.f4653g, h4.f.i((byte[]) this.f4655i, i2, z4));
        ((Cipher) this.f4654h).doFinal(byteBuffer, byteBuffer2);
    }

    @Override // n.h1
    public n.n r(long j2, n.n nVar, n.n nVar2, n.n nVar3) {
        if (((n.n) this.f4655i) == null) {
            this.f4655i = nVar3.c();
        }
        n.n nVar4 = (n.n) this.f4655i;
        if (nVar4 == null) {
            q7.k.j("velocityVector");
            throw null;
        }
        int iB = nVar4.b();
        for (int i2 = 0; i2 < iB; i2++) {
            n.n nVar5 = (n.n) this.f4655i;
            if (nVar5 == null) {
                q7.k.j("velocityVector");
                throw null;
            }
            nVar5.e(i2, ((n.o) this.f4653g).get(i2).c(j2, nVar.a(i2), nVar2.a(i2), nVar3.a(i2)));
        }
        n.n nVar6 = (n.n) this.f4655i;
        if (nVar6 != null) {
            return nVar6;
        }
        q7.k.j("velocityVector");
        throw null;
    }

    @Override // n.h1
    public n.n s(long j2, n.n nVar, n.n nVar2, n.n nVar3) {
        if (((n.n) this.f4654h) == null) {
            this.f4654h = nVar.c();
        }
        n.n nVar4 = (n.n) this.f4654h;
        if (nVar4 == null) {
            q7.k.j("valueVector");
            throw null;
        }
        int iB = nVar4.b();
        for (int i2 = 0; i2 < iB; i2++) {
            n.n nVar5 = (n.n) this.f4654h;
            if (nVar5 == null) {
                q7.k.j("valueVector");
                throw null;
            }
            nVar5.e(i2, ((n.o) this.f4653g).get(i2).b(j2, nVar.a(i2), nVar2.a(i2), nVar3.a(i2)));
        }
        n.n nVar6 = (n.n) this.f4654h;
        if (nVar6 != null) {
            return nVar6;
        }
        q7.k.j("valueVector");
        throw null;
    }

    @Override // x8.l
    public void t(Object obj) {
        ((ArrayList) this.f4653g).add(a4.p.t((a4.p) this.f4654h, (e9.f) this.f4655i, obj));
    }

    public void x(d3.l lVar, int i2) {
        if (i2 != 1 && i2 != 0) {
            throw new IllegalArgumentException(n.f.c(i2, "Unsupported priority value: ").toString());
        }
        if (((LinkedHashSet) this.f4656j).add(lVar)) {
            ((d3.g) this.f4654h).a(this, lVar, i2);
        }
    }

    public void y(Object obj, Object obj2, q1 q1Var, boolean z4) throws GeneralSecurityException {
        byte[] bArrArray;
        if (((ConcurrentHashMap) this.f4654h) == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (obj == null && obj2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        }
        if (q1Var.C() != k1.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f4654h;
        Integer numValueOf = Integer.valueOf(q1Var.A());
        if (q1Var.B() == c2.RAW) {
            numValueOf = null;
        }
        t3.b bVarA = a4.j.f182b.a(a4.p.u(q1Var.z().A(), q1Var.z().B(), q1Var.z().z(), q1Var.B(), numValueOf));
        int iOrdinal = q1Var.B().ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(q1Var.A()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(q1Var.A()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(q1Var.A()).array();
        } else {
            bArrArray = t3.b.f9705a;
        }
        t3.k kVar = new t3.k(obj, obj2, bArrArray, q1Var.C(), q1Var.B(), q1Var.A(), q1Var.z().A(), bVarA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        byte[] bArr = kVar.f9719c;
        t3.l lVar = new t3.l(bArr != null ? Arrays.copyOf(bArr, bArr.length) : null);
        List list = (List) concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(kVar);
            concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList2));
        }
        if (z4) {
            if (((t3.k) this.f4655i) != null) {
                throw new IllegalStateException("you cannot set two primary primitives");
            }
            this.f4655i = kVar;
        }
    }

    public b4.m z() throws GeneralSecurityException {
        Integer num = (Integer) this.f4653g;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (((Integer) this.f4654h) == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (((b4.f) this.f4655i) == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (((b4.f) this.f4656j) == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", (Integer) this.f4653g));
        }
        Integer num2 = (Integer) this.f4654h;
        int iIntValue = num2.intValue();
        b4.f fVar = (b4.f) this.f4655i;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (fVar == b4.f.f1497g) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (fVar == b4.f.f1498h) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (fVar == b4.f.f1499i) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (fVar == b4.f.f1500j) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (fVar != b4.f.f1501k) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new b4.m(((Integer) this.f4653g).intValue(), ((Integer) this.f4654h).intValue(), (b4.f) this.f4656j, (b4.f) this.f4655i);
    }

    public /* synthetic */ f(Object obj, Object obj2, Object obj3, Object obj4, int i2) {
        this.f4652f = i2;
        this.f4653g = obj;
        this.f4654h = obj2;
        this.f4655i = obj3;
        this.f4656j = obj4;
    }

    public f(d5.l lVar, q6.b bVar, k5.g gVar, p5.c cVar) {
        this.f4652f = 10;
        q7.k.e(lVar, "pool");
        q7.k.e(bVar, "originIndex");
        q7.k.e(gVar, "logger");
        this.f4653g = lVar;
        this.f4654h = bVar;
        this.f4655i = gVar;
        this.f4656j = cVar;
    }

    public f(d5.l lVar, u4.l lVar2, k5.g gVar) {
        this.f4652f = 6;
        q7.k.e(lVar, "pool");
        this.f4653g = lVar;
        this.f4654h = lVar2;
        this.f4655i = gVar != null ? new u4.k(gVar) : null;
        this.f4656j = new ConcurrentHashMap();
    }

    public f(v4.a aVar, f fVar, na.d dVar, k5.g gVar) {
        this.f4652f = 2;
        q7.k.e(fVar, "downlinkRouter");
        q7.k.e(gVar, "logger");
        this.f4653g = aVar;
        this.f4654h = fVar;
        this.f4655i = dVar;
        this.f4656j = gVar;
    }

    public f(Context context, p5.q qVar, k5.g gVar) {
        this.f4652f = 28;
        q7.k.e(context, "context");
        q7.k.e(gVar, "logger");
        this.f4653g = context;
        this.f4654h = qVar;
        this.f4655i = gVar;
        this.f4656j = new ConcurrentHashMap();
    }

    public f(Context context, AgentBusConfig agentBusConfig, d5.l lVar, h5.g gVar, u uVar, a7.d dVar, k5.a aVar, k5.g gVar2) {
        this.f4652f = 21;
        q7.k.e(context, "context");
        q7.k.e(agentBusConfig, "config");
        q7.k.e(lVar, "pool");
        q7.k.e(gVar, "invocationMapper");
        q7.k.e(dVar, "internalBus");
        q7.k.e(aVar, "dispatchers");
        q7.k.e(gVar2, "logger");
        l lVar2 = new l(18);
        File filesDir = context.getFilesDir();
        q7.k.d(filesDir, "getFilesDir(...)");
        m5.j jVar = new m5.j(n7.l.O(filesDir, "logs"), agentBusConfig.getLogging().getTraceLog().getMaxFileSizeMb() * 1048576, agentBusConfig.getLogging().getTraceLog().getMaxFileCount(), aVar, gVar2, dVar);
        this.f4653g = jVar;
        File filesDir2 = context.getFilesDir();
        q7.k.d(filesDir2, "getFilesDir(...)");
        this.f4654h = new m5.h(n7.l.O(filesDir2, "logs"), agentBusConfig.getLogging().getAuditLog().getMaxFileSizeMb() * 1048576, agentBusConfig.getLogging().getAuditLog().getRetentionDays(), aVar, gVar2, dVar);
        String str = Build.SERIAL;
        this.f4655i = new h4.a(str == null ? "unknown" : str, lVar2, lVar, dVar, agentBusConfig.getMetrics().getAggregationIntervalMs(), aVar, gVar2);
        this.f4656j = new a3.b(lVar, gVar, uVar, lVar2, jVar, gVar2);
    }

    public f(Context context, p7.a aVar, p7.a aVar2) {
        this.f4652f = 20;
        q7.k.e(context, "context");
        this.f4653g = aVar;
        this.f4654h = aVar2;
        this.f4655i = context.getApplicationContext();
    }

    public f(u9.k kVar, f8.z zVar) {
        this.f4652f = 8;
        q7.k.e(zVar, "module");
        this.f4653g = kVar;
        this.f4654h = zVar;
        this.f4655i = kVar.b(new d0(this, 1));
        this.f4656j = kVar.b(new d0(this, 0));
    }

    public f(z8.d0 d0Var, q6.b bVar, a9.a aVar, r9.z zVar) {
        this.f4652f = 15;
        this.f4653g = bVar;
        this.f4654h = aVar;
        this.f4655i = zVar;
        List list = d0Var.f12100l;
        q7.k.d(list, "proto.class_List");
        int iS = e0.S(d7.t.A0(list, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS < 16 ? 16 : iS);
        for (Object obj : list) {
            linkedHashMap.put(nb.i.s((q6.b) this.f4653g, ((z8.i) obj).f12189j), obj);
        }
        this.f4656j = linkedHashMap;
    }

    public f(ia.b0 b0Var, r8.c cVar, s2.o oVar) {
        this.f4652f = 17;
        this.f4653g = b0Var;
        this.f4654h = oVar;
        this.f4655i = a.a.b(Integer.MAX_VALUE, 6, null);
        this.f4656j = new o4.d0(8);
        g1 g1Var = (g1) b0Var.k().o(ia.z.f5027g);
        if (g1Var != null) {
            g1Var.t(new y(20, cVar, this));
        }
    }

    public f(j1.y yVar, o0.h hVar) {
        this.f4652f = 14;
        this.f4653g = yVar;
        this.f4654h = hVar;
        AutofillManager autofillManager = (AutofillManager) yVar.getContext().getSystemService(AutofillManager.class);
        if (autofillManager != null) {
            this.f4655i = autofillManager;
            yVar.setImportantForAutofill(1);
            AutofillId autofillId = yVar.getAutofillId();
            if (autofillId != null) {
                this.f4656j = autofillId;
                return;
            }
            throw m.x.i("Required value was null.");
        }
        throw new IllegalStateException("Autofill service could not be located.");
    }

    public f(OfflineQueueDatabase_Impl offlineQueueDatabase_Impl) {
        this.f4652f = 0;
        this.f4653g = offlineQueueDatabase_Impl;
        int i2 = 0;
        this.f4654h = new c(offlineQueueDatabase_Impl, i2);
        this.f4655i = new d(offlineQueueDatabase_Impl, i2);
        this.f4656j = new d(offlineQueueDatabase_Impl, 1);
        new d(offlineQueueDatabase_Impl, 2);
    }

    public f(int i2) {
        this.f4652f = i2;
        switch (i2) {
            case 3:
                this.f4654h = new ArrayDeque();
                this.f4655i = new ArrayDeque();
                this.f4656j = new ArrayDeque();
                break;
            case 4:
                this.f4655i = new a8.c(2, this);
                break;
            case 5:
                break;
            case a1.DEPRECATED_FIELD_NUMBER /* 23 */:
                this.f4653g = new int[10];
                this.f4654h = new int[10];
                this.f4655i = new int[10];
                this.f4656j = new int[10];
                break;
            default:
                this.f4653g = new HashMap();
                this.f4654h = new HashMap();
                this.f4655i = new HashMap();
                this.f4656j = new HashMap();
                break;
        }
    }

    public f(a4.t tVar) {
        this.f4652f = 1;
        this.f4653g = new HashMap(tVar.f203a);
        this.f4654h = new HashMap(tVar.f204b);
        this.f4655i = new HashMap(tVar.f205c);
        this.f4656j = new HashMap(tVar.f206d);
    }

    public f(c.m mVar) {
        this.f4652f = 7;
        this.f4653g = mVar;
        this.f4654h = new d3.g();
        new LinkedHashSet();
        this.f4655i = new LinkedHashSet();
        this.f4656j = new LinkedHashSet();
    }

    public f(Typeface typeface, y2.b bVar) {
        int i2;
        int i10;
        int i11;
        int i12;
        this.f4652f = 24;
        this.f4656j = typeface;
        this.f4653g = bVar;
        this.f4655i = new x2.p(NanoHTTPD.HTTPSession.MAX_HEADER_SIZE);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i13 = iA + bVar.f3094f;
            i2 = ((ByteBuffer) bVar.f3097i).getInt(((ByteBuffer) bVar.f3097i).getInt(i13) + i13);
        } else {
            i2 = 0;
        }
        this.f4654h = new char[i2 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i14 = iA2 + bVar.f3094f;
            i10 = ((ByteBuffer) bVar.f3097i).getInt(((ByteBuffer) bVar.f3097i).getInt(i14) + i14);
        } else {
            i10 = 0;
        }
        for (int i15 = 0; i15 < i10; i15++) {
            x2.q qVar = new x2.q(this, i15);
            y2.a aVarB = qVar.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarB.f3097i).getInt(iA3 + aVarB.f3094f) : 0, (char[]) this.f4654h, i15 * 2);
            y2.a aVarB2 = qVar.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i16 = iA4 + aVarB2.f3094f;
                i11 = ((ByteBuffer) aVarB2.f3097i).getInt(((ByteBuffer) aVarB2.f3097i).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            if (i11 > 0) {
                x2.p pVar = (x2.p) this.f4655i;
                y2.a aVarB3 = qVar.b();
                int iA5 = aVarB3.a(16);
                if (iA5 != 0) {
                    int i17 = iA5 + aVarB3.f3094f;
                    i12 = ((ByteBuffer) aVarB3.f3097i).getInt(((ByteBuffer) aVarB3.f3097i).getInt(i17) + i17);
                } else {
                    i12 = 0;
                }
                pVar.a(qVar, 0, i12 - 1);
            } else {
                throw new IllegalArgumentException("invalid metadata codepoint length");
            }
        }
    }

    public f(nb.f fVar, x8.o oVar) {
        this.f4652f = 25;
        this.f4656j = fVar;
        this.f4652f = 25;
        this.f4655i = fVar;
        this.f4653g = oVar;
        this.f4654h = new ArrayList();
    }

    public f(a4.p pVar, e9.f fVar, a7.g gVar) {
        this.f4652f = 27;
        this.f4654h = pVar;
        this.f4655i = fVar;
        this.f4656j = gVar;
        this.f4653g = new ArrayList();
    }

    public f(a7.g gVar, f fVar, ArrayList arrayList) {
        this.f4652f = 26;
        this.f4654h = gVar;
        this.f4655i = fVar;
        this.f4656j = arrayList;
        this.f4653g = gVar;
    }

    public f(h4.f fVar) {
        this.f4652f = 9;
        this.f4656j = fVar;
    }

    public f(t9.i iVar) {
        this.f4652f = 19;
        this.f4656j = iVar;
        List list = iVar.f9802j.f12204y;
        q7.k.d(list, "classProto.enumEntryList");
        int iS = e0.S(d7.t.A0(list, 10));
        LinkedHashMap linkedHashMap = new LinkedHashMap(iS < 16 ? 16 : iS);
        for (Object obj : list) {
            linkedHashMap.put(nb.i.y((b9.f) iVar.f9809q.f9071g, ((z8.s) obj).f12359i), obj);
        }
        this.f4653g = linkedHashMap;
        t9.i iVar2 = (t9.i) this.f4656j;
        this.f4654h = ((r9.i) iVar2.f9809q.f9070f).f9047a.c(new y(24, this, iVar2));
        u9.k kVar = ((r9.i) ((t9.i) this.f4656j).f9809q.f9070f).f9047a;
        t9.h hVar = new t9.h(0, this);
        kVar.getClass();
        this.f4655i = new u9.i(kVar, hVar);
    }

    public f(Class cls) {
        this.f4652f = 18;
        this.f4654h = new ConcurrentHashMap();
        this.f4653g = cls;
        this.f4656j = d4.a.f2836b;
    }

    public f(s2.z zVar, List list) {
        this.f4652f = 16;
        this.f4656j = zVar;
        this.f4653g = new ra.d();
        this.f4654h = ia.d0.a();
        this.f4655i = d7.r.m1(list);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(w wVar) {
        this(12, new a7.d(24, wVar));
        this.f4652f = 12;
    }
}
