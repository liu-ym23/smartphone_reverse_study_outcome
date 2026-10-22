package com.bytedance.ai.applet.base.log;

import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h {
    public static final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Map r100 = f.a();
        if (r100.isEmpty() == false) goto L6;
        return r110;
    L6:
        return "[" + CollectionsKt.joinToString$default(r100.entrySet(), " ", null, null, 0, null, new g(), 30, null) + "] " + r110;
    }
}
