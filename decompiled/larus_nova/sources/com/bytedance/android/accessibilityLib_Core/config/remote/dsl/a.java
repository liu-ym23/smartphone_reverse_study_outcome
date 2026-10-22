package com.bytedance.android.accessibilityLib_Core.config.remote.dsl;

import android.content.Context;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a {
    public static final boolean b(h r100) {
        if (r100 != null) goto L4;
    L8:
        return false;
    L4:
        if (r100.f38208a == (-1)) goto L8;
        if (r100.f38209b == (-1)) goto L8;
        return true;
    }

    public static final void a(h r100, Map<String, Integer> r110, Map<String, Integer> r111) {
        String r101 = r100.f38210c;     // Catch: Exception -> L27
        boolean r102 = false;
        if (r101 != null) goto L6;
    L9:
        boolean r103 = true;
    L11:
        if (r103 == true) goto L44;
        String r104 = r100.f38210c;     // Catch: Exception -> L27
        if (r104 != null) goto L15;
        Intrinsics.throwNpe();     // Catch: Exception -> L27
    L15:
        Integer r112 = r110.get(r104);     // Catch: Exception -> L27
        if (r112 == null) goto L19;
        int r113 = r112.intValue();     // Catch: Exception -> L27
    L21:
        if (r113 != (-1)) goto L23;
    L30:
        String r114 = r100.f38210c;     // Catch: Exception -> L27
        if (r114 != null) goto L33;
        Intrinsics.throwNpe();     // Catch: Exception -> L27
    L33:
        Integer r115 = r111.get(r114);     // Catch: Exception -> L27
        if (r115 == null) goto L36;
        int r116 = r115.intValue();     // Catch: Exception -> L27
    L37:
        if (r116 == (-1)) goto L44;
        if (r116 == r100.f38208a) goto L44;
        if (("autoReplace layoutIdName " + r100.f38210c + " from " + r100.f38208a + " to " + r116) == null) goto L43;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L27
    L43:
        r100.f38208a = r116;     // Catch: Exception -> L27
        goto L44
    L36:
        r116 = -1;
        goto L37
    L23:
        if (r113 == r100.f38208a) goto L30;
        if (("autoReplace layoutIdName " + r100.f38210c + " from " + r100.f38208a + " to " + r113) == null) goto L29;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L27
    L29:
        r100.f38208a = r113;     // Catch: Exception -> L27
        goto L30
    L19:
        r113 = -1;
    L44:
        String r117 = r100.f38211d;     // Catch: Exception -> L27
        if (r117 != null) goto L47;
    L48:
        r102 = true;
    L49:
        if (r102 == true) goto L64;
        String r118 = r100.f38211d;     // Catch: Exception -> L27
        if (r118 != null) goto L53;
        Intrinsics.throwNpe();     // Catch: Exception -> L27
    L53:
        Integer r119 = r111.get(r118);     // Catch: Exception -> L27
        if (r119 == null) goto L56;
        int r120 = r119.intValue();     // Catch: Exception -> L27
    L57:
        if (r120 == (-1)) goto L64;
        if (r120 == r100.f38209b) goto L64;
        if (("autoReplace viewIdName " + r100.f38211d + " from " + r100.f38209b + " to " + r120) == null) goto L63;
        Context r121 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L27
    L63:
        r100.f38209b = r120;     // Catch: Exception -> L27
        goto L64
    L56:
        r120 = -1;
    L64:
        Unit r107 = Unit.INSTANCE;     // Catch: Exception -> L27
        return;
    L47:
        if (r117.length() != 0) goto L49;
    L6:
        if (r101.length() == 0) goto L9;
        r103 = false;
    L27:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L69;
        Context r108 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L69:
        Unit r109 = Unit.INSTANCE;
    }
}
