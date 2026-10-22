package com.obric.assistant.dm.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: DMService.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends com.obric.assistant.dm.api.a implements com.obric.assistant.dm.api.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f22476a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<com.obric.assistant.dm.api.a> f22477b = null;

    private b() {
    }

    static {
        f22476a = new b();
        f22477b = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.assistant.dm.api.c
    public void a(com.obric.assistant.dm.api.a r1) {
        o.e(r1, "listener");
        f22477b.add(r1);
    }

    @Override // com.obric.assistant.dm.api.a
    public void a() {
        Iterator<com.obric.assistant.dm.api.a> r3 = f22477b.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.assistant.dm.api.a) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.assistant.dm.api.a.class, "com.obric.aiagent.plugin")).a();
        goto L4
    }
}
