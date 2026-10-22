package com.obric.aiagent.assistant.idl.bean;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: OmniFeedbackAmount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f16269a = null;

    static {
        f16269a = new c();
    }

    private c() {
    }

    public final Integer a(Integer r4) {
        if (r4 == null) goto L12;
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r4, Number.class, "com.obric.aiagent.plugin")).intValue();
        boolean r1 = false;
        if (r0 >= 0) goto L7;
    L9:
        if (r1 == false) goto L12;
        return r4;
    L7:
        if (r0 >= 10000) goto L9;
        r1 = true;
    L12:
        return null;
    }

    public final List<String> a(List<String> r3, Integer r4) {
        List<String> r2 = b((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin"));
        Integer r5 = f16269a.a(r4);
        if (r5 == null) goto L9;
        List<String> r6 = p.a((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.aiagent.plugin"), "__omni_feedback_amount=" + ((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.aiagent.plugin")).intValue());
        if (r6 != null) goto L8;
        return r2;
    L8:
        return r6;
    L9:
        return r2;
    }

    public final Integer a(List<String> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        Integer r0 = null;
        if (r9 == null) goto L17;
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L6:
        if (r10.hasNext() == false) goto L10;
        Object r2 = r10.next();
        if (o.b((String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin"), "__omni_feedback_amount=", false, 2, null) == false) goto L6;
    L11:
        String r11 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.aiagent.plugin");
        if (r11 == null) goto L17;
        String r12 = o.a(r11, (CharSequence) ZeusTransformUtils.preCheckCast("__omni_feedback_amount=", CharSequence.class, "com.obric.aiagent.plugin"));
        if (r12 == null) goto L17;
        r0 = o.d(r12);
        goto L17
    L10:
        r2 = null;
    L17:
        return a(r0);
    }

    public final List<String> b(List<String> r8) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L5;
        r7 = p.b();
    L5:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.aiagent.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r11 = r9.iterator();
    L7:
        if (r11.hasNext() == false) goto L12;
        Object r1 = r11.next();
        if (o.b((String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.aiagent.plugin"), "__omni_feedback_amount=", false, 2, null) == true) goto L7;
        r10.add(r1);
        goto L7
    L12:
        return (List) ZeusTransformUtils.preCheckCast(r10, List.class, "com.obric.aiagent.plugin");
    }
}
