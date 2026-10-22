package com.obric.agent.omnimodel;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.o.o;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: IOmniModelService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a implements IOmniModelService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<IOmniModelService.c> f15391a;

    public a() {
        this.f15391a = p.b(new IOmniModelService.c[]{new IOmniModelService.c("Seed 2.1 Lite", IOmniModelService.MODEL_LITE), new IOmniModelService.c("Seed 2.1 Turbo", IOmniModelService.MODEL_TURBO)});
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c parseEntryFromJson(String r1) {
        return IOmniModelService.b.a(this, r1);
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public String toExtValue(IOmniModelService.c r1) {
        return IOmniModelService.b.a(this, r1);
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public List<IOmniModelService.c> availableEntries() {
        return this.f15391a;
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public String defaultDisplayModel() {
        return ((IOmniModelService.c) ZeusTransformUtils.preCheckCast(p.k(this.f15391a), IOmniModelService.c.class, "com.obric.aiagent.plugin")).a();
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c defaultEntry() {
        return (IOmniModelService.c) ZeusTransformUtils.preCheckCast(p.k(this.f15391a), IOmniModelService.c.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c getEntryByDisplayModel(String r7) {
        String r8 = IOmniModelService.Companion.a(r7);
        Object r2 = null;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L6;
        r8 = null;
    L6:
        if (r8 == null) goto L8;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f15391a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        if (d.h.b.o.a(IOmniModelService.Companion.a(((IOmniModelService.c) ZeusTransformUtils.preCheckCast(r3, IOmniModelService.c.class, "com.obric.aiagent.plugin")).a()), r8) == false) goto L11;
        r2 = r3;
    L15:
        IOmniModelService.c r9 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r2, IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r9 == null) goto L18;
        return r9;
    L18:
        return defaultEntry();
    L8:
        return defaultEntry();
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public IOmniModelService.c getEntryByModel(String r6) {
        if (r6 == null) goto L20;
        Object r2 = null;
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r6 = null;
    L7:
        if (r6 == null) goto L20;
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f15391a, Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L11:
        if (r0.hasNext() == false) goto L15;
        Object r3 = r0.next();
        if (d.h.b.o.a(((IOmniModelService.c) ZeusTransformUtils.preCheckCast(r3, IOmniModelService.c.class, "com.obric.aiagent.plugin")).b(), r6) == false) goto L11;
        r2 = r3;
    L15:
        IOmniModelService.c r7 = (IOmniModelService.c) ZeusTransformUtils.preCheckCast(r2, IOmniModelService.c.class, "com.obric.aiagent.plugin");
        if (r7 == null) goto L18;
        return r7;
    L18:
        return defaultEntry();
    L20:
        return defaultEntry();
    }

    @Override // com.obric.agent.omnimodel.IOmniModelService
    public String eventTaskDefaultDisplayModel() {
        return defaultDisplayModel();
    }
}
