package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: compiled from: IgnoredPropertyException.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends g {
    public a(k r8, String r9, com.fasterxml.jackson.a.i r10, Class<?> r11, String r12, Collection<Object> r13) {
        super(r8, r9, r10, r11, r12, (Collection) ZeusTransformUtils.wrapperContextForParams(r13, Collection.class, "com.obric.aiagent.plugin"));
    }

    public static a a(k r9, Object r10, String r11, Collection<Object> r12) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Class.class) == false) goto L5;
        Class<?> r13 = (Class) ZeusTransformUtils.preCheckCast(r10, Class.class, "com.obric.aiagent.plugin");
    L6:
        Class<?> r6 = r13;
        a r14 = new a(r9, String.format("Ignored field \"%s\" (class %s) encountered; mapper configured not to allow this", new Object[]{r11, r6.getName()}), r9.e(), r6, r11, r8);
        r14.a(r10, r11);
        return r14;
    L5:
        r13 = r10.getClass();
        goto L6
    }
}
