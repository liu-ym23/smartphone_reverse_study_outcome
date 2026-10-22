package a1;

import a6.f0;
import a6.h1;
import a6.i0;
import android.graphics.Typeface;
import android.util.SparseArray;
import j0.q0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import k2.e1;
import k2.q1;
import k2.y0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w implements c7.u {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f74a;

    /* renamed from: b, reason: collision with root package name */
    public Object f75b;

    /* renamed from: c, reason: collision with root package name */
    public Object f76c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public Object f77e;

    public /* synthetic */ w(boolean z) {
        this.f74a = 8;
    }

    public static void j(w wVar, r6.l lVar, r6.l lVar2, int i8) {
        androidx.emoji2.text.m mVar;
        if ((i8 & 1) != 0) {
            lVar = null;
        }
        if ((i8 & 4) != 0) {
            lVar2 = null;
        }
        wVar.getClass();
        TimeZone timeZone = o6.f.f4330a;
        boolean zIsShutdown = ((ThreadPoolExecutor) wVar.g()).isShutdown();
        synchronized (wVar) {
            if (lVar2 != null) {
                try {
                    lVar2.f5153b.decrementAndGet();
                    if (!((ArrayDeque) wVar.d).remove(lVar2)) {
                        throw new IllegalStateException("Call wasn't in-flight!");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (lVar != null) {
                ((ArrayDeque) wVar.f76c).add(lVar);
            }
            if (lVar2 != null && (zIsShutdown || ((ArrayDeque) wVar.d).isEmpty())) {
                ((ArrayDeque) wVar.f77e).isEmpty();
            }
            if (zIsShutdown) {
                List listN0 = c5.m.N0((ArrayDeque) wVar.f76c);
                ((ArrayDeque) wVar.f76c).clear();
                mVar = new androidx.emoji2.text.m(listN0);
            } else {
                ArrayList arrayList = new ArrayList();
                Iterator it = ((ArrayDeque) wVar.f76c).iterator();
                kotlin.jvm.internal.p.d(it, "iterator(...)");
                while (it.hasNext()) {
                    r6.l lVar3 = (r6.l) it.next();
                    if (((ArrayDeque) wVar.d).size() >= 64) {
                        break;
                    }
                    if (lVar3.f5153b.get() < 5) {
                        it.remove();
                        lVar3.f5153b.incrementAndGet();
                        arrayList.add(lVar3);
                        ((ArrayDeque) wVar.d).add(lVar3);
                    }
                }
                mVar = new androidx.emoji2.text.m(arrayList);
            }
        }
        int size = ((List) mVar.f621a).size();
        for (int i9 = 0; i9 < size; i9++) {
            r6.l lVar4 = (r6.l) ((List) mVar.f621a).get(i9);
            if (lVar4 != lVar) {
                r6.o oVar = lVar4.f5154c;
            }
            if (zIsShutdown) {
                lVar4.getClass();
                InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                interruptedIOException.initCause(null);
                r6.o oVar2 = lVar4.f5154c;
                oVar2.h(interruptedIOException);
                lVar4.f5152a.p(oVar2, interruptedIOException);
            } else {
                ExecutorService executorServiceG = wVar.g();
                lVar4.getClass();
                r6.o oVar3 = lVar4.f5154c;
                kotlin.jvm.internal.p.e(oVar3.f5157a.f4096a, "<this>");
                try {
                    try {
                        ((ThreadPoolExecutor) executorServiceG).execute(lVar4);
                    } catch (RejectedExecutionException e9) {
                        InterruptedIOException interruptedIOException2 = new InterruptedIOException("executor rejected");
                        interruptedIOException2.initCause(e9);
                        r6.o oVar4 = lVar4.f5154c;
                        oVar4.h(interruptedIOException2);
                        lVar4.f5152a.p(oVar4, interruptedIOException2);
                        w wVar2 = oVar3.f5157a.f4096a;
                        wVar2.getClass();
                        j(wVar2, null, lVar4, 3);
                    }
                } catch (Throwable th2) {
                    w wVar3 = oVar3.f5157a.f4096a;
                    wVar3.getClass();
                    j(wVar3, null, lVar4, 3);
                    throw th2;
                }
            }
        }
    }

    public void a(Object obj, Object obj2, e1 e1Var, boolean z) throws GeneralSecurityException {
        byte[] bArrArray;
        if (((ConcurrentHashMap) this.f76c) == null) {
            throw new IllegalStateException("addPrimitive cannot be called after build");
        }
        if (obj == null && obj2 == null) {
            throw new GeneralSecurityException("at least one of the `fullPrimitive` or `primitive` must be set");
        }
        if (e1Var.D() != y0.ENABLED) {
            throw new GeneralSecurityException("only ENABLED key is allowed");
        }
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) this.f76c;
        Integer numValueOf = Integer.valueOf(e1Var.B());
        if (e1Var.C() == q1.RAW) {
            numValueOf = null;
        }
        y1.b bVarA = f2.j.f2563b.a(f2.p.b(e1Var.A().B(), e1Var.A().C(), e1Var.A().A(), e1Var.C(), numValueOf));
        int iOrdinal = e1Var.C().ordinal();
        if (iOrdinal == 1) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 1).putInt(e1Var.B()).array();
        } else if (iOrdinal == 2) {
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(e1Var.B()).array();
        } else if (iOrdinal != 3) {
            if (iOrdinal != 4) {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            bArrArray = ByteBuffer.allocate(5).put((byte) 0).putInt(e1Var.B()).array();
        } else {
            bArrArray = y1.b.f6311a;
        }
        y1.k kVar = new y1.k(obj, obj2, bArrArray, e1Var.D(), e1Var.C(), e1Var.B(), e1Var.A().B(), bVarA);
        ArrayList arrayList = new ArrayList();
        arrayList.add(kVar);
        byte[] bArr = kVar.f6324c;
        y1.l lVar = new y1.l(bArr != null ? Arrays.copyOf(bArr, bArr.length) : null);
        List list = (List) concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList));
        if (list != null) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(list);
            arrayList2.add(kVar);
            concurrentHashMap.put(lVar, Collections.unmodifiableList(arrayList2));
        }
        if (z) {
            if (((y1.k) this.d) != null) {
                throw new IllegalStateException("you cannot set two primary primitives");
            }
            this.d = kVar;
        }
    }

    public g2.j b() throws GeneralSecurityException {
        Integer num = (Integer) this.f75b;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (((Integer) this.f76c) == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (((g2.c) this.d) == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (((g2.c) this.f77e) == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", (Integer) this.f75b));
        }
        Integer num2 = (Integer) this.f76c;
        int iIntValue = num2.intValue();
        g2.c cVar = (g2.c) this.d;
        if (iIntValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (cVar == g2.c.f2919g) {
            if (iIntValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (cVar == g2.c.f2920h) {
            if (iIntValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (cVar == g2.c.f2921i) {
            if (iIntValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (cVar == g2.c.f2922j) {
            if (iIntValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (cVar != g2.c.f2923k) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (iIntValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new g2.j(((Integer) this.f75b).intValue(), ((Integer) this.f76c).intValue(), (g2.c) this.f77e, (g2.c) this.d);
    }

    @Override // c7.u
    public c7.t c() {
        return (d7.c) this.f77e;
    }

    @Override // c7.u
    public void cancel() throws IOException {
        ((Socket) this.f75b).close();
    }

    @Override // c7.u
    public c7.v d() {
        return (d7.d) this.d;
    }

    public void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) ((j.j) this.f76c).get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i8 = 0; i8 < size; i8++) {
                e(arrayList2.get(i8), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
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
    public java.lang.Object f(h5.c r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f77e
            j0.c0 r0 = (j0.c0) r0
            boolean r1 = r7 instanceof j0.g
            if (r1 == 0) goto L17
            r1 = r7
            j0.g r1 = (j0.g) r1
            int r2 = r1.d
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.d = r2
            goto L1c
        L17:
            j0.g r1 = new j0.g
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f3344b
            g5.a r2 = g5.a.f2984a
            int r3 = r1.d
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L3e
            if (r3 == r5) goto L38
            if (r3 != r4) goto L30
            a1.w r6 = r1.f3343a
            a.a.c0(r7)
            goto L63
        L30:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L38:
            a1.w r6 = r1.f3343a
            a.a.c0(r7)
            goto L72
        L3e:
            a.a.c0(r7)
            java.lang.Object r7 = r6.d
            java.util.List r7 = (java.util.List) r7
            if (r7 == 0) goto L66
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4e
            goto L66
        L4e:
            j0.u0 r7 = r0.g()
            j0.j r3 = new j0.j
            r5 = 0
            r3.<init>(r0, r6, r5)
            r1.f3343a = r6
            r1.d = r4
            java.lang.Object r7 = r7.b(r3, r1)
            if (r7 != r2) goto L63
            goto L71
        L63:
            j0.c r7 = (j0.c) r7
            goto L74
        L66:
            r1.f3343a = r6
            r1.d = r5
            r7 = 0
            java.lang.Object r7 = j0.c0.f(r0, r7, r1)
            if (r7 != r2) goto L72
        L71:
            return r2
        L72:
            j0.c r7 = (j0.c) r7
        L74:
            java.lang.Object r6 = r6.f77e
            j0.c0 r6 = (j0.c0) r6
            androidx.emoji2.text.m r6 = r6.f3327h
            r6.q(r7)
            b5.a0 r6 = b5.a0.f883a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.w.f(h5.c):java.lang.Object");
    }

    public synchronized ExecutorService g() {
        ThreadPoolExecutor threadPoolExecutor;
        try {
            if (((ThreadPoolExecutor) this.f75b) == null) {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                SynchronousQueue synchronousQueue = new SynchronousQueue();
                String name = o6.f.f4331b + " Dispatcher";
                kotlin.jvm.internal.p.e(name, "name");
                this.f75b = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, synchronousQueue, new o6.e(name, false));
            }
            threadPoolExecutor = (ThreadPoolExecutor) this.f75b;
            kotlin.jvm.internal.p.b(threadPoolExecutor);
        } catch (Throwable th) {
            throw th;
        }
        return threadPoolExecutor;
    }

    public void h(String str, String value) {
        kotlin.jvm.internal.p.e(value, "value");
        androidx.fragment.app.l lVar = (androidx.fragment.app.l) this.d;
        lVar.getClass();
        k4.v.T(str);
        k4.v.U(value, str);
        lVar.c(str);
        k4.v.p(lVar, str, value);
    }

    public void i(String method) {
        kotlin.jvm.internal.p.e(method, "method");
        if (method.length() <= 0) {
            throw new IllegalArgumentException("method.isEmpty() == true");
        }
        if (method.equals("POST") || method.equals("PUT") || method.equals("PATCH") || method.equals("PROPPATCH") || method.equals("QUERY") || method.equals("REPORT")) {
            throw new IllegalArgumentException(m0.f.d("method ", method, " must have a request body.").toString());
        }
        this.f76c = method;
    }

    public void k(f2.a aVar) throws GeneralSecurityException {
        aVar.getClass();
        f2.r rVar = new f2.r(f2.p.class, aVar.f2549a);
        HashMap map = (HashMap) this.f76c;
        if (!map.containsKey(rVar)) {
            map.put(rVar, aVar);
            return;
        }
        f2.a aVar2 = (f2.a) map.get(rVar);
        if (aVar2.equals(aVar) && aVar.equals(aVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + rVar);
    }

    public void l(f2.b bVar) throws GeneralSecurityException {
        f2.s sVar = new f2.s(bVar.f2551a, f2.p.class);
        HashMap map = (HashMap) this.f75b;
        if (!map.containsKey(sVar)) {
            map.put(sVar, bVar);
            return;
        }
        f2.b bVar2 = (f2.b) map.get(sVar);
        if (bVar2.equals(bVar) && bVar.equals(bVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + sVar);
    }

    public void m(f2.k kVar) throws GeneralSecurityException {
        kVar.getClass();
        f2.r rVar = new f2.r(f2.q.class, kVar.f2565a);
        HashMap map = (HashMap) this.f77e;
        if (!map.containsKey(rVar)) {
            map.put(rVar, kVar);
            return;
        }
        f2.k kVar2 = (f2.k) map.get(rVar);
        if (kVar2.equals(kVar) && kVar.equals(kVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: " + rVar);
    }

    public void n(f2.l lVar) throws GeneralSecurityException {
        f2.s sVar = new f2.s(lVar.f2566a, f2.q.class);
        HashMap map = (HashMap) this.d;
        if (!map.containsKey(sVar)) {
            map.put(sVar, lVar);
            return;
        }
        f2.l lVar2 = (f2.l) map.get(sVar);
        if (lVar2.equals(lVar) && lVar.equals(lVar2)) {
            return;
        }
        throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: " + sVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r8v10, types: [i6.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object o(h5.c r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof j0.p0
            if (r0 == 0) goto L13
            r0 = r9
            j0.p0 r0 = (j0.p0) r0
            int r1 = r0.f3411e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3411e = r1
            goto L18
        L13:
            j0.p0 r0 = new j0.p0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f3410c
            g5.a r1 = g5.a.f2984a
            int r2 = r0.f3411e
            r3 = 2
            r4 = 1
            b5.a0 r5 = b5.a0.f883a
            r6 = 0
            if (r2 == 0) goto L45
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            i6.a r8 = r0.f3409b
            a1.w r0 = r0.f3408a
            a.a.c0(r9)     // Catch: java.lang.Throwable -> L31
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
            i6.a r8 = r0.f3409b
            a1.w r2 = r0.f3408a
            a.a.c0(r9)
            r9 = r8
            r8 = r2
            goto L64
        L45:
            a.a.c0(r9)
            java.lang.Object r9 = r8.f76c
            a6.s r9 = (a6.s) r9
            boolean r9 = r9.Q()
            if (r9 == 0) goto L53
            return r5
        L53:
            java.lang.Object r9 = r8.f75b
            i6.c r9 = (i6.c) r9
            r0.f3408a = r8
            r0.f3409b = r9
            r0.f3411e = r4
            java.lang.Object r2 = r9.c(r0)
            if (r2 != r1) goto L64
            goto L80
        L64:
            java.lang.Object r2 = r8.f76c     // Catch: java.lang.Throwable -> L90
            a6.s r2 = (a6.s) r2     // Catch: java.lang.Throwable -> L90
            boolean r2 = r2.Q()     // Catch: java.lang.Throwable -> L90
            if (r2 == 0) goto L74
            i6.c r9 = (i6.c) r9
            r9.e(r6)
            return r5
        L74:
            r0.f3408a = r8     // Catch: java.lang.Throwable -> L90
            r0.f3409b = r9     // Catch: java.lang.Throwable -> L90
            r0.f3411e = r3     // Catch: java.lang.Throwable -> L90
            java.lang.Object r0 = r8.f(r0)     // Catch: java.lang.Throwable -> L90
            if (r0 != r1) goto L81
        L80:
            return r1
        L81:
            r0 = r8
            r8 = r9
        L83:
            java.lang.Object r9 = r0.f76c     // Catch: java.lang.Throwable -> L31
            a6.s r9 = (a6.s) r9     // Catch: java.lang.Throwable -> L31
            r9.S(r5)     // Catch: java.lang.Throwable -> L31
            i6.c r8 = (i6.c) r8
            r8.e(r6)
            return r5
        L90:
            r8 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
        L94:
            i6.c r8 = (i6.c) r8
            r8.e(r6)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.w.o(h5.c):java.lang.Object");
    }

    public String toString() {
        switch (this.f74a) {
            case 2:
                String string = ((Socket) this.f75b).toString();
                kotlin.jvm.internal.p.d(string, "toString(...)");
                return string;
            default:
                return super.toString();
        }
    }

    public w(int i8) {
        this.f74a = i8;
        switch (i8) {
            case 3:
                this.f75b = new HashMap();
                this.f76c = new HashMap();
                this.d = new HashMap();
                this.f77e = new HashMap();
                break;
            case 4:
                break;
            case 5:
            case 6:
            default:
                this.f75b = new j.e(0);
                this.d = new SparseArray();
                this.f77e = new j.g();
                this.f76c = new j.e(0);
                break;
            case 7:
                this.f76c = new ArrayDeque();
                this.d = new ArrayDeque();
                this.f77e = new ArrayDeque();
                break;
            case 8:
                this.f77e = o6.a.f4323a;
                this.f76c = "GET";
                this.d = new androidx.fragment.app.l(1);
                break;
            case 9:
                this.f75b = new d0.b(10);
                this.f76c = new j.j(0);
                this.d = new ArrayList();
                this.f77e = new HashSet();
                break;
        }
    }

    public w(f0 f0Var, j0.z zVar, c4.c cVar) {
        this.f74a = 6;
        this.f75b = f0Var;
        this.f76c = cVar;
        this.d = c6.j.a(Integer.MAX_VALUE, null, 6);
        this.f77e = new androidx.emoji2.text.m(12);
        h1 h1Var = (h1) f0Var.b().o(a6.c0.f143b);
        if (h1Var != null) {
            h1Var.A(new q0(zVar, this));
        }
    }

    public w(Socket socket) {
        this.f74a = 2;
        this.f75b = socket;
        this.f76c = new AtomicInteger();
        this.d = new d7.d(this);
        this.f77e = new d7.c(this);
    }

    public w(f2.t tVar) {
        this.f74a = 3;
        this.f75b = new HashMap(tVar.f2583a);
        this.f76c = new HashMap(tVar.f2584b);
        this.d = new HashMap(tVar.f2585c);
        this.f77e = new HashMap(tVar.d);
    }

    public w(Typeface typeface, o0.b bVar) {
        int i8;
        int i9;
        int i10;
        int i11;
        this.f74a = 1;
        this.f77e = typeface;
        this.f75b = bVar;
        this.d = new androidx.emoji2.text.w(1024);
        int iA = bVar.a(6);
        if (iA != 0) {
            int i12 = iA + bVar.f1830a;
            i8 = ((ByteBuffer) bVar.d).getInt(((ByteBuffer) bVar.d).getInt(i12) + i12);
        } else {
            i8 = 0;
        }
        this.f76c = new char[i8 * 2];
        int iA2 = bVar.a(6);
        if (iA2 != 0) {
            int i13 = iA2 + bVar.f1830a;
            i9 = ((ByteBuffer) bVar.d).getInt(((ByteBuffer) bVar.d).getInt(i13) + i13);
        } else {
            i9 = 0;
        }
        for (int i14 = 0; i14 < i9; i14++) {
            androidx.emoji2.text.z zVar = new androidx.emoji2.text.z(this, i14);
            o0.a aVarB = zVar.b();
            int iA3 = aVarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) aVarB.d).getInt(iA3 + aVarB.f1830a) : 0, (char[]) this.f76c, i14 * 2);
            o0.a aVarB2 = zVar.b();
            int iA4 = aVarB2.a(16);
            if (iA4 != 0) {
                int i15 = iA4 + aVarB2.f1830a;
                i10 = ((ByteBuffer) aVarB2.d).getInt(((ByteBuffer) aVarB2.d).getInt(i15) + i15);
            } else {
                i10 = 0;
            }
            a.a.g("invalid metadata codepoint length", i10 > 0);
            androidx.emoji2.text.w wVar = (androidx.emoji2.text.w) this.d;
            o0.a aVarB3 = zVar.b();
            int iA5 = aVarB3.a(16);
            if (iA5 != 0) {
                int i16 = iA5 + aVarB3.f1830a;
                i11 = ((ByteBuffer) aVarB3.d).getInt(((ByteBuffer) aVarB3.d).getInt(i16) + i16);
            } else {
                i11 = 0;
            }
            wVar.a(zVar, 0, i11 - 1);
        }
    }

    public w(Class cls) {
        this.f74a = 10;
        this.f76c = new ConcurrentHashMap();
        this.f75b = cls;
        this.f77e = i2.a.f3137b;
    }

    public w(j0.c0 c0Var, List list) {
        this.f74a = 5;
        this.f77e = c0Var;
        this.f75b = new i6.c();
        this.f76c = i0.a();
        this.d = c5.m.N0(list);
    }
}
