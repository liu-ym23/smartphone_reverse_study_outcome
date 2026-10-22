package com.bytedance.ai.debugscene;

import com.bytedance.ai.debug.AIDebugCommand;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class n1 {
    public static final String a(AIDebugCommand r100, String r101) {
        String r102 = r100.f36183c.get(r101);
        if (r102 != null) goto L7;
        return null;
    L7:
        return StringsKt.trim(r102).toString();
    }

    public static final boolean b(AIDebugCommand r100, String r101, boolean r102) {
        String r103 = r100.f36183c.get(r101);
        if (r103 != null) goto L6;
        return r102;
    L6:
        if (StringsKt.equals(r103, "true", true) == false) goto L8;
        return true;
    L8:
        if (Intrinsics.areEqual(r103, "1") == true) goto L13;
        return false;
    L13:
        return true;
    }
}
