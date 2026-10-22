package i9;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.lifecycle.h0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import nc.k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: d, reason: collision with root package name */
    public static final f8.b f5839d = new f8.b(10);

    /* renamed from: e, reason: collision with root package name */
    public static volatile b0 f5840e;

    /* renamed from: a, reason: collision with root package name */
    public final Context f5841a;

    /* renamed from: b, reason: collision with root package name */
    public final y3.e f5842b = t.o.k("thirty_day_period_start_ms");

    /* renamed from: c, reason: collision with root package name */
    public final nc.g f5843c;

    public b0(Context context) {
        this.f5841a = context;
        nc.g data = ((v3.f) ((stepos.support.v7.app.f) e()).f12315f).getData();
        nc.c cVarE = k0.e(new h0(this, (nb.c) null, 9));
        z zVar = new z(this, null);
        nc.c0 c0Var = new nc.c0(0);
        c0Var.f8829f = data;
        c0Var.f8830g = cVarE;
        c0Var.f8831h = zVar;
        VarHandle.storeStoreFence();
        this.f5843c = k0.g(c0Var);
    }

    public static Set r(String str) {
        if (str != null) {
            if (str.length() <= 0) {
                str = null;
            }
            if (str != null) {
                List listO0 = hc.h.o0(str, new String[]{"\u001e"});
                ArrayList arrayList = new ArrayList();
                for (Object obj : listO0) {
                    if (((String) obj).length() > 0) {
                        arrayList.add(obj);
                    }
                }
                TreeSet treeSet = new TreeSet();
                kb.l.K0(arrayList, treeSet);
                return treeSet;
            }
        }
        return kb.u.f7406c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c0, code lost:
    
        if (j(r10, r0) == r1) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(java.util.Collection r9, pb.c r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof i9.k
            if (r0 == 0) goto L13
            r0 = r10
            i9.k r0 = (i9.k) r0
            int r1 = r0.f5875h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5875h = r1
            goto L18
        L13:
            i9.k r0 = new i9.k
            r0.<init>(r8, r10)
        L18:
            java.lang.Object r10 = r0.f5873f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5875h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2f
            java.util.Collection r8 = r0.f5872c
            java.util.Collection r8 = (java.util.Collection) r8
            id.c.I(r10)
            goto Lc3
        L2f:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            r8 = 0
            return r8
        L36:
            java.util.Collection r9 = r0.f5872c
            java.util.Collection r9 = (java.util.Collection) r9
            id.c.I(r10)
            goto L5d
        L3e:
            id.c.I(r10)
            v3.f r10 = r8.e()
            stepos.support.v7.app.f r10 = (stepos.support.v7.app.f) r10
            java.lang.Object r10 = r10.f12315f
            v3.f r10 = (v3.f) r10
            nc.g r10 = r10.getData()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            r0.f5872c = r2
            r0.f5875h = r4
            java.lang.Object r10 = nc.k0.i(r10, r0)
            if (r10 != r1) goto L5d
            goto Lc2
        L5d:
            y3.b r10 = (y3.b) r10
            y3.e r2 = i9.j.f5868a
            java.lang.Object r10 = r10.c(r2)
            java.lang.String r10 = (java.lang.String) r10
            java.util.Set r10 = r(r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r2 = new java.util.ArrayList
            r4 = 10
            int r4 = kb.m.m0(r9, r4)
            r2.<init>(r4)
            java.util.Iterator r9 = r9.iterator()
        L7c:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L8c
            java.lang.Object r4 = r9.next()
            java.lang.String r4 = (java.lang.String) r4
            k0.a.A(r4, r2)
            goto L7c
        L8c:
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            int r4 = r2.size()
            r5 = 0
        L96:
            if (r5 >= r4) goto Lab
            java.lang.Object r6 = r2.get(r5)
            int r5 = r5 + 1
            r7 = r6
            java.lang.String r7 = (java.lang.String) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L96
            r9.add(r6)
            goto L96
        Lab:
            java.util.LinkedHashSet r9 = kb.b0.R(r10, r9)
            java.util.TreeSet r10 = new java.util.TreeSet
            r10.<init>()
            kb.l.K0(r9, r10)
            r9 = 0
            r0.f5872c = r9
            r0.f5875h = r3
            java.lang.Object r8 = r8.j(r10, r0)
            if (r8 != r1) goto Lc3
        Lc2:
            return r1
        Lc3:
            jb.v r8 = jb.v.f6774a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.a(java.util.Collection, pb.c):java.lang.Object");
    }

    public final d0 b(y3.b bVar) throws PackageManager.NameNotFoundException {
        ContentResolver contentResolver = this.f5841a.getContentResolver();
        contentResolver.getClass();
        jb.g gVarQ = a.a.Q(contentResolver);
        boolean zBooleanValue = ((Boolean) gVarQ.f6759c).booleanValue();
        b bVar2 = (b) gVarQ.f6760f;
        Long lP = a.a.P(contentResolver);
        SortedSet sortedSetG = g(r((String) bVar.c(j.f5868a)));
        Long l2 = (Long) bVar.c(j.f5869b);
        return new d0(zBooleanValue, bVar2, lP, sortedSetG, l2 != null ? l2.longValue() : System.currentTimeMillis());
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0073, code lost:
    
        if (r9 != r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(long r7, pb.c r9) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r6 = this;
            boolean r0 = r9 instanceof i9.l
            if (r0 == 0) goto L13
            r0 = r9
            i9.l r0 = (i9.l) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.i = r1
            goto L18
        L13:
            i9.l r0 = new i9.l
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.f5878g
            ob.a r1 = ob.a.f9351c
            int r2 = r0.i
            r3 = 3
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L42
            if (r2 == r4) goto L3c
            if (r2 == r5) goto L36
            if (r2 != r3) goto L2f
            i9.b0 r6 = r0.f5877f
            id.c.I(r9)
            goto L76
        L2f:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L36:
            long r7 = r0.f5876c
            id.c.I(r9)
            goto L5b
        L3c:
            long r7 = r0.f5876c
            id.c.I(r9)
            goto L50
        L42:
            id.c.I(r9)
            r0.f5876c = r7
            r0.i = r4
            java.lang.Object r9 = r6.f(r7, r0)
            if (r9 != r1) goto L50
            goto L75
        L50:
            r0.f5876c = r7
            r0.i = r5
            java.lang.Object r9 = r6.k(r0)
            if (r9 != r1) goto L5b
            goto L75
        L5b:
            v3.f r9 = r6.e()
            stepos.support.v7.app.f r9 = (stepos.support.v7.app.f) r9
            java.lang.Object r9 = r9.f12315f
            v3.f r9 = (v3.f) r9
            nc.g r9 = r9.getData()
            r0.f5877f = r6
            r0.f5876c = r7
            r0.i = r3
            java.lang.Object r9 = nc.k0.i(r9, r0)
            if (r9 != r1) goto L76
        L75:
            return r1
        L76:
            y3.b r9 = (y3.b) r9
            i9.d0 r6 = r6.b(r9)
            i9.g r7 = new i9.g
            boolean r8 = r6.f5850a
            if (r8 == 0) goto L8f
            java.util.Set r8 = r6.f5853d
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r8 = kb.l.L0(r8)
            java.util.List r8 = kb.l.H0(r8)
            goto L91
        L8f:
            kb.s r8 = kb.s.f7404c
        L91:
            long r0 = r6.f5854e
            r7.<init>()
            r7.f5861a = r8
            r7.f5862b = r0
            java.lang.invoke.VarHandle.storeStoreFence()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.c(long, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(long r9, pb.c r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof i9.m
            if (r0 == 0) goto L13
            r0 = r11
            i9.m r0 = (i9.m) r0
            int r1 = r0.f5883h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5883h = r1
            goto L18
        L13:
            i9.m r0 = new i9.m
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.f5881f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5883h
            jb.v r3 = jb.v.f6774a
            r4 = 0
            r5 = 2
            r6 = 1
            if (r2 == 0) goto L39
            if (r2 == r6) goto L33
            if (r2 != r5) goto L2d
            id.c.I(r11)
            return r3
        L2d:
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r8)
            return r4
        L33:
            long r9 = r0.f5880c
            id.c.I(r11)
            goto L62
        L39:
            id.c.I(r11)
            f8.b r11 = i9.b.f5833f
            java.lang.String r11 = "TASK_EXECUTION"
            r2 = 0
            boolean r11 = ac.a.l0(r2, r11, r4)
            if (r11 != 0) goto L4e
            java.lang.String r11 = "ScrPerceptGlobal"
            java.lang.String r7 = "writeGlobalPolicy via AppPlatform failed"
            android.util.Log.w(r11, r7)
        L4e:
            v3.f r11 = r8.e()
            i9.n r7 = new i9.n
            r7.<init>(r9, r4, r2)
            r0.f5880c = r9
            r0.f5883h = r6
            java.lang.Object r11 = t.m0.h(r11, r7, r0)
            if (r11 != r1) goto L62
            goto L76
        L62:
            android.content.Context r11 = r8.f5841a
            h5.r r11 = h5.r.b(r11)
            java.lang.String r2 = "screen_perception_thirty_days_expire"
            r11.a(r2)
            r0.f5880c = r9
            r0.f5883h = r5
            r8.l(r9)
            if (r3 != r1) goto L77
        L76:
            return r1
        L77:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.d(long, pb.c):java.lang.Object");
    }

    public final v3.f e() {
        return c0.f5847b.a(this.f5841a, c0.f5846a[0]);
    }

    public final Object f(long j10, pb.c cVar) {
        Long lP;
        Object objD;
        ContentResolver contentResolver = this.f5841a.getContentResolver();
        contentResolver.getClass();
        jb.g gVarQ = a.a.Q(contentResolver);
        return (((Boolean) gVarQ.f6759c).booleanValue() && ((b) gVarQ.f6760f) == b.f5835h && (lP = a.a.P(contentResolver)) != null && j10 >= lP.longValue() && (objD = d(j10, cVar)) == ob.a.f9351c) ? objD : jb.v.f6774a;
    }

    public final SortedSet g(Set set) throws PackageManager.NameNotFoundException {
        ArrayList arrayList = new ArrayList();
        for (Object obj : set) {
            String str = (String) obj;
            Context context = this.f5841a;
            str.getClass();
            try {
                context.getPackageManager().getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(0L));
                arrayList.add(obj);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        TreeSet treeSet = new TreeSet();
        kb.l.K0(arrayList, treeSet);
        return treeSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(pb.c r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof i9.p
            if (r0 == 0) goto L13
            r0 = r10
            i9.p r0 = (i9.p) r0
            int r1 = r0.f5891g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5891g = r1
            goto L18
        L13:
            i9.p r0 = new i9.p
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f5889c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5891g
            r3 = 3
            r4 = 1
            jb.v r5 = jb.v.f6774a
            r6 = 2
            r7 = 0
            if (r2 == 0) goto L3e
            if (r2 == r4) goto L3a
            if (r2 == r6) goto L36
            if (r2 != r3) goto L30
            id.c.I(r10)
            return r5
        L30:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r9)
            return r7
        L36:
            id.c.I(r10)
            return r5
        L3a:
            id.c.I(r10)
            goto L58
        L3e:
            id.c.I(r10)
            v3.f r10 = r9.e()
            stepos.support.v7.app.f r10 = (stepos.support.v7.app.f) r10
            java.lang.Object r10 = r10.f12315f
            v3.f r10 = (v3.f) r10
            nc.g r10 = r10.getData()
            r0.f5891g = r4
            java.lang.Object r10 = nc.k0.i(r10, r0)
            if (r10 != r1) goto L58
            goto Lbd
        L58:
            y3.b r10 = (y3.b) r10
            y3.e r2 = i9.j.f5870c
            java.lang.Object r2 = r10.c(r2)
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r2 = yb.k.a(r2, r8)
            if (r2 == 0) goto L69
            goto Lbe
        L69:
            y3.e r2 = i9.i.f5866a
            java.lang.Object r2 = r10.c(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            y3.e r8 = i9.i.f5867b
            java.lang.Object r10 = r10.c(r8)
            java.lang.String r10 = (java.lang.String) r10
            r8 = 0
            if (r2 != 0) goto L90
            if (r10 != 0) goto L90
            v3.f r9 = r9.e()
            i9.q r10 = new i9.q
            r10.<init>(r6, r7, r8)
            r0.f5891g = r6
            java.lang.Object r9 = t.m0.h(r9, r10, r0)
            if (r9 != r1) goto Lbe
            goto Lbd
        L90:
            if (r10 != 0) goto L96
            f8.b r10 = i9.b.f5833f
            java.lang.String r10 = "TASK_EXECUTION"
        L96:
            if (r2 == 0) goto L9c
            boolean r8 = r2.booleanValue()
        L9c:
            boolean r10 = ac.a.l0(r8, r10, r7)
            if (r10 != 0) goto La9
            java.lang.String r2 = "ScrPerceptGlobal"
            java.lang.String r8 = "writeGlobalPolicy via AppPlatform failed"
            android.util.Log.w(r2, r8)
        La9:
            if (r10 != 0) goto Lac
            goto Lbe
        Lac:
            v3.f r9 = r9.e()
            i9.q r10 = new i9.q
            r10.<init>(r6, r7, r4)
            r0.f5891g = r3
            java.lang.Object r9 = t.m0.h(r9, r10, r0)
            if (r9 != r1) goto Lbe
        Lbd:
            return r1
        Lbe:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.h(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x014b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(pb.c r17) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.i(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(java.util.SortedSet r14, pb.c r15) {
        /*
            r13 = this;
            boolean r1 = r15 instanceof i9.s
            if (r1 == 0) goto L14
            r1 = r15
            i9.s r1 = (i9.s) r1
            int r2 = r1.f5904h
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r2 & r3
            if (r5 == 0) goto L14
            int r2 = r2 - r3
            r1.f5904h = r2
        L12:
            r7 = r1
            goto L1a
        L14:
            i9.s r1 = new i9.s
            r1.<init>(r13, r15)
            goto L12
        L1a:
            java.lang.Object r0 = r7.f5902f
            ob.a r8 = ob.a.f9351c
            int r1 = r7.f5904h
            jb.v r9 = jb.v.f6774a
            r10 = 2
            r11 = 1
            if (r1 == 0) goto L3b
            if (r1 == r11) goto L35
            if (r1 != r10) goto L2e
            id.c.I(r0)
            return r9
        L2e:
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r0)
            r0 = 0
            return r0
        L35:
            long r1 = r7.f5901c
            id.c.I(r0)
            goto L5b
        L3b:
            id.c.I(r0)
            long r2 = java.lang.System.currentTimeMillis()
            v3.f r12 = r13.e()
            i9.t r0 = new i9.t
            r6 = 0
            r1 = 0
            r4 = r13
            r5 = r14
            r0.<init>(r1, r2, r4, r5, r6)
            r7.f5901c = r2
            r7.f5904h = r11
            java.lang.Object r0 = t.m0.h(r12, r0, r7)
            if (r0 != r8) goto L5a
            goto L64
        L5a:
            r1 = r2
        L5b:
            r7.f5901c = r1
            r7.f5904h = r10
            r13.l(r1)
            if (r9 != r8) goto L65
        L64:
            return r8
        L65:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.j(java.util.SortedSet, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object k(pb.c r7) throws android.content.pm.PackageManager.NameNotFoundException {
        /*
            r6 = this;
            boolean r0 = r7 instanceof i9.u
            if (r0 == 0) goto L13
            r0 = r7
            i9.u r0 = (i9.u) r0
            int r1 = r0.f5911g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5911g = r1
            goto L18
        L13:
            i9.u r0 = new i9.u
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f5909c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5911g
            jb.v r3 = jb.v.f6774a
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L37
            if (r2 == r5) goto L33
            if (r2 != r4) goto L2c
            id.c.I(r7)
            return r3
        L2c:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r6)
            r6 = 0
            return r6
        L33:
            id.c.I(r7)
            goto L51
        L37:
            id.c.I(r7)
            v3.f r7 = r6.e()
            stepos.support.v7.app.f r7 = (stepos.support.v7.app.f) r7
            java.lang.Object r7 = r7.f12315f
            v3.f r7 = (v3.f) r7
            nc.g r7 = r7.getData()
            r0.f5911g = r5
            java.lang.Object r7 = nc.k0.i(r7, r0)
            if (r7 != r1) goto L51
            goto L71
        L51:
            y3.b r7 = (y3.b) r7
            y3.e r2 = i9.j.f5868a
            java.lang.Object r7 = r7.c(r2)
            java.lang.String r7 = (java.lang.String) r7
            java.util.Set r7 = r(r7)
            java.util.SortedSet r2 = r6.g(r7)
            boolean r7 = r2.equals(r7)
            if (r7 != 0) goto L72
            r0.f5911g = r4
            java.lang.Object r6 = r6.j(r2, r0)
            if (r6 != r1) goto L72
        L71:
            return r1
        L72:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.k(pb.c):java.lang.Object");
    }

    public final void l(long j10) {
        Context applicationContext = this.f5841a.getApplicationContext();
        Intent intent = new Intent("com.stepos.agentsafetycenter.action.SCREEN_PERCEPTION_SETTINGS_CHANGED");
        intent.putExtra("schema_version", 2);
        intent.putExtra("updated_at_epoch_ms", j10);
        applicationContext.sendBroadcast(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007b, code lost:
    
        if (j(r6, r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r6, pb.c r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof i9.v
            if (r0 == 0) goto L13
            r0 = r7
            i9.v r0 = (i9.v) r0
            int r1 = r0.f5915h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5915h = r1
            goto L18
        L13:
            i9.v r0 = new i9.v
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f5913f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5915h
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 == r4) goto L31
            if (r2 != r3) goto L2a
            id.c.I(r7)
            goto L7e
        L2a:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r5)
            r5 = 0
            return r5
        L31:
            java.lang.String r6 = r0.f5912c
            id.c.I(r7)
            goto L53
        L37:
            id.c.I(r7)
            v3.f r7 = r5.e()
            stepos.support.v7.app.f r7 = (stepos.support.v7.app.f) r7
            java.lang.Object r7 = r7.f12315f
            v3.f r7 = (v3.f) r7
            nc.g r7 = r7.getData()
            r0.f5912c = r6
            r0.f5915h = r4
            java.lang.Object r7 = nc.k0.i(r7, r0)
            if (r7 != r1) goto L53
            goto L7d
        L53:
            y3.b r7 = (y3.b) r7
            y3.e r2 = i9.j.f5868a
            java.lang.Object r7 = r7.c(r2)
            java.lang.String r7 = (java.lang.String) r7
            java.util.Set r7 = r(r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Set r7 = kb.l.N0(r7)
            r7.remove(r6)
            java.util.TreeSet r6 = new java.util.TreeSet
            r6.<init>()
            kb.l.K0(r7, r6)
            r7 = 0
            r0.f5912c = r7
            r0.f5915h = r3
            java.lang.Object r5 = r5.j(r6, r0)
            if (r5 != r1) goto L7e
        L7d:
            return r1
        L7e:
            jb.v r5 = jb.v.f6774a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.m(java.lang.String, pb.c):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004b, code lost:
    
        if (q(r0) == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object n(pb.c r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof i9.w
            if (r0 == 0) goto L13
            r0 = r8
            i9.w r0 = (i9.w) r0
            int r1 = r0.f5918g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5918g = r1
            goto L18
        L13:
            i9.w r0 = new i9.w
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f5916c
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5918g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L35
            if (r2 == r4) goto L31
            if (r2 != r3) goto L2a
            id.c.I(r8)
            goto L4e
        L2a:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r7)
            r7 = 0
            return r7
        L31:
            id.c.I(r8)
            goto L45
        L35:
            id.c.I(r8)
            long r5 = java.lang.System.currentTimeMillis()
            r0.f5918g = r4
            java.lang.Object r8 = r7.f(r5, r0)
            if (r8 != r1) goto L45
            goto L4d
        L45:
            r0.f5918g = r3
            java.lang.Object r7 = r7.q(r0)
            if (r7 != r1) goto L4e
        L4d:
            return r1
        L4e:
            jb.v r7 = jb.v.f6774a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.n(pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object o(i9.b r18, pb.c r19) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.o(i9.b, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(boolean r13, pb.c r14) {
        /*
            r12 = this;
            boolean r0 = r14 instanceof i9.y
            if (r0 == 0) goto L13
            r0 = r14
            i9.y r0 = (i9.y) r0
            int r1 = r0.f5929k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5929k = r1
            goto L18
        L13:
            i9.y r0 = new i9.y
            r0.<init>(r12, r14)
        L18:
            java.lang.Object r14 = r0.i
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5929k
            r3 = 2
            android.content.Context r4 = r12.f5841a
            r5 = 1
            jb.v r6 = jb.v.f6774a
            r7 = 0
            if (r2 == 0) goto L43
            if (r2 == r5) goto L35
            if (r2 != r3) goto L2f
            id.c.I(r14)
            return r6
        L2f:
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r12)
            return r7
        L35:
            boolean r13 = r0.f5926g
            long r7 = r0.f5927h
            boolean r2 = r0.f5925f
            boolean r5 = r0.f5924c
            id.c.I(r14)
            r14 = r13
            r13 = r5
            goto L99
        L43:
            id.c.I(r14)
            android.content.ContentResolver r14 = r4.getContentResolver()
            r14.getClass()
            jb.g r2 = a.a.Q(r14)
            java.lang.Object r2 = r2.f6759c
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            long r8 = java.lang.System.currentTimeMillis()
            if (r13 != r2) goto L60
            goto Lc9
        L60:
            java.lang.String r10 = "TASK_EXECUTION"
            if (r13 == 0) goto L6b
            f8.b r14 = i9.b.f5833f
            boolean r14 = a.a.c0(r4, r5, r10, r7)
            goto L7b
        L6b:
            i9.h r14 = a.a.R(r14)
            if (r14 == 0) goto L74
            java.lang.String r10 = r14.f5864b
            goto L76
        L74:
            f8.b r14 = i9.b.f5833f
        L76:
            r14 = 0
            boolean r14 = a.a.c0(r4, r14, r10, r7)
        L7b:
            if (r14 != 0) goto L7e
            goto Lc9
        L7e:
            v3.f r10 = r12.e()
            i9.n r11 = new i9.n
            r11.<init>(r8, r7, r3)
            r0.f5924c = r13
            r0.f5925f = r2
            r0.f5927h = r8
            r0.f5926g = r14
            r0.f5929k = r5
            java.lang.Object r5 = t.m0.h(r10, r11, r0)
            if (r5 != r1) goto L98
            goto Lc8
        L98:
            r7 = r8
        L99:
            h5.r r4 = h5.r.b(r4)
            java.lang.String r5 = "screen_perception_thirty_days_expire"
            r4.a(r5)
            if (r13 == 0) goto La7
            java.lang.String r4 = "on"
            goto La9
        La7:
            java.lang.String r4 = "off"
        La9:
            java.lang.String r5 = "switch_status"
            java.util.Map r4 = java.util.Collections.singletonMap(r5, r4)
            r4.getClass()
            java.lang.String r5 = "toggle_smart_perception_switch"
            java.lang.String r9 = "smart_perception_manage"
            td.h.P(r5, r9, r4)
            r0.f5924c = r13
            r0.f5925f = r2
            r0.f5927h = r7
            r0.f5926g = r14
            r0.f5929k = r3
            r12.l(r7)
            if (r6 != r1) goto Lc9
        Lc8:
            return r1
        Lc9:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.p(boolean, pb.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(pb.c r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof i9.a0
            if (r0 == 0) goto L13
            r0 = r12
            i9.a0 r0 = (i9.a0) r0
            int r1 = r0.f5832h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5832h = r1
            goto L18
        L13:
            i9.a0 r0 = new i9.a0
            r0.<init>(r11, r12)
        L18:
            java.lang.Object r12 = r0.f5830f
            ob.a r1 = ob.a.f9351c
            int r2 = r0.f5832h
            r3 = 1
            jb.v r4 = jb.v.f6774a
            java.lang.String r7 = "screen_perception_thirty_days_expire"
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2d
            h5.r r11 = r0.f5829c
            id.c.I(r12)
            goto L81
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            od.f.e(r11)
            r11 = 0
            return r11
        L34:
            id.c.I(r12)
            android.content.Context r12 = r11.f5841a
            android.content.ContentResolver r2 = r12.getContentResolver()
            r2.getClass()
            jb.g r5 = a.a.Q(r2)
            java.lang.Object r6 = r5.f6759c
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            java.lang.Object r5 = r5.f6760f
            i9.b r5 = (i9.b) r5
            h5.r r12 = h5.r.b(r12)
            if (r6 == 0) goto L5a
            i9.b r6 = i9.b.f5835h
            if (r5 == r6) goto L5c
        L5a:
            r6 = r12
            goto Lad
        L5c:
            java.lang.Long r2 = a.a.P(r2)
            if (r2 == 0) goto La8
            long r5 = r2.longValue()
            long r8 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r8
            r8 = 0
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 > 0) goto L85
            long r5 = java.lang.System.currentTimeMillis()
            r0.f5829c = r12
            r0.f5832h = r3
            java.lang.Object r11 = r11.f(r5, r0)
            if (r11 != r1) goto L80
            return r1
        L80:
            r11 = r12
        L81:
            r11.a(r7)
            return r4
        L85:
            g5.v r11 = new g5.v
            java.lang.Class<com.stepos.agentsafetycenter.screenperception.ScreenPerceptionThirtyDayExpireWorker> r0 = com.stepos.agentsafetycenter.screenperception.ScreenPerceptionThirtyDayExpireWorker.class
            r11.<init>(r0)
            g5.e0 r11 = r11.e(r5)
            g5.v r11 = (g5.v) r11
            g5.f0 r11 = r11.a()
            g5.w r11 = (g5.w) r11
            java.util.List r9 = ac.a.E(r11)
            h5.n r5 = new h5.n
            r10 = 0
            r8 = 1
            r6 = r12
            r5.<init>(r6, r7, r8, r9, r10)
            r5.a()
            return r4
        La8:
            r6 = r12
            r6.a(r7)
            return r4
        Lad:
            r6.a(r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: i9.b0.q(pb.c):java.lang.Object");
    }
}
