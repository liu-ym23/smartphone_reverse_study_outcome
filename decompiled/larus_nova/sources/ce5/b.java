package ce5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {
    static {
    }

    public static boolean a(String r100) {
        a r101 = new a();     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r101, "<this>");     // Catch: Exception -> L5
        boolean r102 = r101.f23449d.isEnable(r100);     // Catch: Exception -> L5
        tt5.a.h("UserComponentAbilityExtensions", "isEnable: " + r100 + " = " + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        tt5.a.d("UserComponentAbilityExtensions", "isEnable fail, component run error: " + e);
        return false;
    }
}
