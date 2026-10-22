package com.obric.autogui.common.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: FeatureUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    public static final boolean a(String r6, Set<String> r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r7, Set.class, "com.obric.aiagent.plugin");
        o.e(r8, "whitelistPrefixes");
        if (r6 == null) goto L26;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L7;
    L9:
        Iterator r10 = r9.iterator();
    L11:
        if (r10.hasNext() == false) goto L8;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.aiagent.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L15;
        boolean r4 = true;
    L16:
        if (r4 == true) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L11;
        boolean r11 = true;
    L23:
        if (r11 == false) goto L26;
        return true;
    L18:
        if (d.o.o.b(r6, r3, false, 2, null) == false) goto L20;
        r5 = true;
        goto L21
    L15:
        r4 = false;
    L8:
        r11 = false;
        goto L23
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.aiagent.plugin")).isEmpty() == false) goto L9;
    L26:
        return false;
    }
}
