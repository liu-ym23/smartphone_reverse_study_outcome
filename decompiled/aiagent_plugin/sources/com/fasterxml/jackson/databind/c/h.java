package com.fasterxml.jackson.databind.c;

import com.fasterxml.jackson.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: compiled from: UnrecognizedPropertyException.java */
/* JADX INFO: loaded from: classes2.dex */
public class h extends g {
    public h(k r8, String r9, com.fasterxml.jackson.a.i r10, Class<?> r11, String r12, Collection<Object> r13) {
        super(r8, r9, r10, r11, r12, (Collection) ZeusTransformUtils.wrapperContextForParams(r13, Collection.class, "com.obric.aiagent.plugin"));
    }

    public static h a(k r9, Object r10, String r11, Collection<Object> r12) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r12, Collection.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, Class.class) == false) goto L5;
        Class<?> r13 = (Class) ZeusTransformUtils.preCheckCast(r10, Class.class, "com.obric.aiagent.plugin");
    L6:
        Class<?> r6 = r13;
        h r14 = new h(r9, String.format("Unrecognized field \"%s\" (class %s), not marked as ignorable", new Object[]{r11, r6.getName()}), r9.e(), r6, r11, r8);
        r14.a(r10, r11);
        return r14;
    L5:
        r13 = r10.getClass();
        goto L6
    }
}
