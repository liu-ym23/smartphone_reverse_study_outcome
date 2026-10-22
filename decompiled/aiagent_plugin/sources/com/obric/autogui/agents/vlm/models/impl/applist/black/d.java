package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: AppBlackListImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<e> f27352a;

    public d() {
        List<e> r0 = Collections.synchronizedList((List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin"));
        d.h.b.o.c(r0, "synchronizedList(...)");
        this.f27352a = r0;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.b
    public int a() {
        return this.f27352a.size();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.b
    public void a(e r3) {
        e r4 = (e) ZeusTransformUtils.wrapperContextForParams(r3, e.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "withItem");
        this.f27352a.add(r4);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.b
    public void b() {
        this.f27352a.clear();
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.b
    public e query(c r6) {
        d.h.b.o.e(r6, "blackListCriteria");
        List<e> r0 = this.f27352a;
        monitor-enter(r0);
        Iterator<e> r5 = this.f27352a.iterator();     // Catch: Throwable -> L18
        e r1 = null;
    L6:
        if (r5.hasNext() == false) goto L15;
        e r2 = (e) ZeusTransformUtils.preCheckCast(r5.next(), e.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L18
        if (r2.a(r6) == false) goto L6;
        if (r1 != null) goto L11;
        r1 = r2;
    L11:
        if (r1 == null) goto L6;
        if (r2.getType().ordinal() > r1.getType().ordinal()) goto L6;
        r1 = r2;
        goto L6
    L15:
        x r7 = x.f38692a;     // Catch: Throwable -> L18
        monitor-exit(r0);
        return r1;
    L18:
        th = move-exception;
        throw th;
    }
}
