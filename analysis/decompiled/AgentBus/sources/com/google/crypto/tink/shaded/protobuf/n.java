package com.google.crypto.tink.shaded.protobuf;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static volatile n f2251a;

    /* renamed from: b, reason: collision with root package name */
    public static final n f2252b;

    static {
        n nVar = new n();
        Map map = Collections.EMPTY_MAP;
        f2252b = nVar;
    }

    public static n a() {
        n nVar;
        n nVar2 = f2251a;
        if (nVar2 != null) {
            return nVar2;
        }
        synchronized (n.class) {
            try {
                nVar = f2251a;
                if (nVar == null) {
                    Class cls = m.f2243a;
                    n nVar3 = null;
                    if (cls != null) {
                        try {
                            nVar3 = (n) cls.getDeclaredMethod("getEmptyRegistry", null).invoke(null, null);
                        } catch (Exception unused) {
                        }
                    }
                    nVar = nVar3 != null ? nVar3 : f2252b;
                    f2251a = nVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return nVar;
    }
}
