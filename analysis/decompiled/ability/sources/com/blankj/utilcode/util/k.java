package com.blankj.utilcode.util;

import java.util.HashMap;

/* loaded from: classes2.dex */
public abstract class k {
    public static e a() {
        e eVar;
        String str = "Utils";
        HashMap map = e.b;
        int i = 0;
        while (true) {
            if (i >= 5) {
                str = "spUtils";
                break;
            }
            if (!Character.isWhitespace("Utils".charAt(i))) {
                break;
            }
            i++;
        }
        HashMap map2 = e.b;
        e eVar2 = (e) map2.get(str);
        if (eVar2 != null) {
            return eVar2;
        }
        synchronized (e.class) {
            try {
                eVar = (e) map2.get(str);
                if (eVar == null) {
                    eVar = new e();
                    eVar.f2205a = S0.b.X0().getSharedPreferences(str, 0);
                    map2.put(str, eVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return eVar;
    }
}
