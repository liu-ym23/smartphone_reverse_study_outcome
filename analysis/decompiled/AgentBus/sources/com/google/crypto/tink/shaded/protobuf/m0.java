package com.google.crypto.tink.shaded.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class m0 {
    public static void a(Object obj, Object obj2) {
        l0 l0Var = (l0) obj;
        if (obj2 != null) {
            throw new ClassCastException();
        }
        if (l0Var.isEmpty()) {
            return;
        }
        Iterator it = l0Var.entrySet().iterator();
        if (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            entry.getKey();
            entry.getValue();
            throw null;
        }
    }

    public static l0 b(Object obj, Object obj2) {
        l0 l0VarC = (l0) obj;
        l0 l0Var = (l0) obj2;
        if (!l0Var.isEmpty()) {
            if (!l0VarC.f2241f) {
                l0VarC = l0VarC.c();
            }
            l0VarC.b();
            if (!l0Var.isEmpty()) {
                l0VarC.putAll(l0Var);
            }
        }
        return l0VarC;
    }
}
