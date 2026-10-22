package k0;

import b0.a2;
import i5.l;
import j1.k0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.a0;
import k.g0;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final a0 f5571a;

    /* renamed from: b, reason: collision with root package name */
    public a0 f5572b;

    public d(LinkedHashMap linkedHashMap) {
        a0 a0Var;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            a0Var = null;
        } else {
            a0Var = new a0(linkedHashMap.size());
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                a0Var.l(entry.getKey(), entry.getValue());
            }
        }
        this.f5571a = a0Var;
    }

    @Override // k0.c
    public final l a(String str, a2 a2Var) {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!ib.c.E(str.charAt(i2))) {
                a0 a0Var = this.f5572b;
                if (a0Var == null) {
                    long[] jArr = g0.f5491a;
                    a0Var = new a0();
                    this.f5572b = a0Var;
                }
                Object objG = a0Var.g(str);
                if (objG == null) {
                    objG = new ArrayList();
                    a0Var.l(str, objG);
                }
                ((List) objG).add(a2Var);
                return new l(a0Var, str, a2Var, 16);
            }
        }
        throw new IllegalArgumentException("Registered key is empty or blank");
    }

    @Override // k0.c
    public final boolean b(Object obj) {
        return k0.i(obj);
    }

    @Override // k0.c
    public final Object c(String str) {
        a0 a0Var = this.f5571a;
        List list = a0Var != null ? (List) a0Var.j(str) : null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() > 1 && a0Var != null) {
            List listSubList = list.subList(1, list.size());
            int iF = a0Var.f(str);
            if (iF < 0) {
                iF = ~iF;
            }
            Object[] objArr = a0Var.f5448c;
            Object obj = objArr[iF];
            a0Var.f5447b[iF] = str;
            objArr[iF] = listSubList;
        }
        return list.get(0);
    }
}
