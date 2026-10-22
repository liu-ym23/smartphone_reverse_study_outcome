package com.bytedance.apm.agent.instrumentation;

import F9.A;
import F9.E;
import F9.F;
import F9.s;
import S.a;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class OkHttp3Instrumentation {
    public static F build(E e) {
        ArrayList arrayList;
        e.getClass();
        F f = new F(e);
        try {
            arrayList = e.c;
        } catch (Exception unused) {
        }
        if (arrayList == null || arrayList.size() <= 0) {
            e.a(new a());
        } else {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (((A) it.next()) instanceof a) {
                    break;
                }
            }
            e.a(new a());
        }
        s sVar = f.e;
        if (sVar instanceof U.a) {
            return new F(e);
        }
        e.e = new U.a(sVar);
        return new F(e);
    }

    public static F init() {
        E e = new E();
        e.a(new a());
        e.e = new U.a(null);
        return new F(e);
    }
}
