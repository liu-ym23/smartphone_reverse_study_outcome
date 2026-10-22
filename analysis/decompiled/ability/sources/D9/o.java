package D9;

import B9.T;
import C9.AbstractC0200b;
import C9.B;
import C9.x;
import D7.N;
import android.os.RemoteException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.EmptySet;
import z9.AbstractC2202d;

/* loaded from: classes4.dex */
public class o extends a {
    public final x f;
    public final z9.g g;
    public int h;
    public boolean i;

    public /* synthetic */ o(AbstractC0200b abstractC0200b, x xVar, String str, int i) {
        this(abstractC0200b, xVar, (i & 4) != 0 ? null : str, (z9.g) null);
    }

    @Override // D9.a
    public C9.l b(String tag) {
        kotlin.jvm.internal.k.f(tag, "tag");
        return (C9.l) kotlin.collections.a.N(tag, q());
    }

    @Override // D9.a, A9.e
    public final A9.c beginStructure(z9.g descriptor) {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        z9.g gVar = this.g;
        if (descriptor != gVar) {
            return super.beginStructure(descriptor);
        }
        C9.l lVarC = c();
        String strH = gVar.h();
        if (lVarC instanceof x) {
            String str = this.d;
            return new o(this.c, (x) lVarC, str, gVar);
        }
        StringBuilder sb = new StringBuilder("Expected ");
        kotlin.jvm.internal.n nVar = kotlin.jvm.internal.m.f4928a;
        sb.append(nVar.b(x.class).m());
        sb.append(", but had ");
        sb.append(nVar.b(lVarC.getClass()).m());
        sb.append(" as the serialized body of ");
        sb.append(strH);
        sb.append(" at element: ");
        sb.append(s());
        throw j.d(sb.toString(), lVarC.toString(), -1);
    }

    @Override // A9.c
    public int decodeElementIndex(z9.g descriptor) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        while (this.h < descriptor.d()) {
            int i = this.h;
            this.h = i + 1;
            String strP = p(descriptor, i);
            int i6 = this.h - 1;
            this.i = false;
            boolean zContainsKey = q().containsKey(strP);
            AbstractC0200b abstractC0200b = this.c;
            if (!zContainsKey) {
                boolean z10 = (abstractC0200b.f321a.e || descriptor.i(i6) || !descriptor.g(i6).b()) ? false : true;
                this.i = z10;
                if (!z10) {
                    continue;
                }
            }
            if (this.e.g) {
                boolean zI = descriptor.i(i6);
                z9.g gVarG = descriptor.g(i6);
                if (!zI || gVarG.b() || !(b(strP) instanceof C9.u)) {
                    if (kotlin.jvm.internal.k.b(gVarG.getKind(), z9.j.c) && (!gVarG.b() || !(b(strP) instanceof C9.u))) {
                        C9.l lVarB = b(strP);
                        String strB = null;
                        B b = lVarB instanceof B ? (B) lVarB : null;
                        if (b != null) {
                            B9.B b5 = C9.m.f329a;
                            if (!(b instanceof C9.u)) {
                                strB = b.b();
                            }
                        }
                        if (strB != null) {
                            int i10 = j.i(gVarG, abstractC0200b, strB);
                            boolean z11 = !abstractC0200b.f321a.e && gVarG.b();
                            if (i10 != -3 || (!zI && !z11)) {
                            }
                        }
                    }
                }
            }
            return i6;
        }
        return -1;
    }

    @Override // D9.a, A9.e
    public final boolean decodeNotNullMark() {
        return !this.i && super.decodeNotNullMark();
    }

    @Override // D9.a, A9.c
    public void endStructure(z9.g descriptor) {
        Set setL;
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        AbstractC0200b abstractC0200b = this.c;
        if (j.k(abstractC0200b, descriptor) || (descriptor.getKind() instanceof AbstractC2202d)) {
            return;
        }
        j.n(abstractC0200b, descriptor);
        if (this.e.i) {
            Set setB = T.b(descriptor);
            Map map = (Map) abstractC0200b.c.c(descriptor, j.f440a);
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = EmptySet.f4895a;
            }
            setL = N.L(setB, setKeySet);
        } else {
            setL = T.b(descriptor);
        }
        for (String str : q().f335a.keySet()) {
            if (!setL.contains(str) && !kotlin.jvm.internal.k.b(str, this.d)) {
                StringBuilder sbV = B7.a.v("Encountered an unknown key '", str, "' at element: ");
                sbV.append(s());
                sbV.append("\nUse 'ignoreUnknownKeys = true' in 'Json {}' builder or '@JsonIgnoreUnknownKeys' annotation to ignore unknown keys.\nJSON input: ");
                sbV.append((Object) j.m(q().toString(), -1));
                throw j.c(-1, sbV.toString());
            }
        }
    }

    @Override // D9.a
    public String o(z9.g descriptor, int i) throws IllegalStateException, NoSuchAlgorithmException, InvalidKeyException, RemoteException {
        Object next;
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        AbstractC0200b abstractC0200b = this.c;
        j.n(abstractC0200b, descriptor);
        String strE = descriptor.e(i);
        if (this.e.i && !q().f335a.keySet().contains(strE)) {
            kotlin.jvm.internal.k.f(abstractC0200b, "<this>");
            O0.a aVar = abstractC0200b.c;
            A6.i iVar = new A6.i(5, descriptor, abstractC0200b);
            aVar.getClass();
            k kVar = j.f440a;
            Object objC = aVar.c(descriptor, kVar);
            if (objC == null) {
                objC = iVar.invoke();
                ConcurrentHashMap concurrentHashMap = aVar.f1031a;
                Object concurrentHashMap2 = concurrentHashMap.get(descriptor);
                if (concurrentHashMap2 == null) {
                    concurrentHashMap2 = new ConcurrentHashMap(2);
                    concurrentHashMap.put(descriptor, concurrentHashMap2);
                }
                ((Map) concurrentHashMap2).put(kVar, objC);
            }
            Map map = (Map) objC;
            Iterator it = q().f335a.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                Integer num = (Integer) map.get((String) next);
                if (num != null && num.intValue() == i) {
                    break;
                }
            }
            String str = (String) next;
            if (str != null) {
                return str;
            }
        }
        return strE;
    }

    @Override // D9.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public x q() {
        return this.f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(AbstractC0200b json, x value, String str, z9.g gVar) {
        super(json, str);
        kotlin.jvm.internal.k.f(json, "json");
        kotlin.jvm.internal.k.f(value, "value");
        this.f = value;
        this.g = gVar;
    }
}
