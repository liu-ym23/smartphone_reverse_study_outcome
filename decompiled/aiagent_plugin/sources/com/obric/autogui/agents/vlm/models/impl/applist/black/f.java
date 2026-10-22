package com.obric.autogui.agents.vlm.models.impl.applist.black;

import com.obric.autogui.common.api.AOSystemTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;

/* JADX INFO: compiled from: AppBlackListItemImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e.a f27358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f27359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<String> f27360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f27361d;

    public f(e.a r3, String r4, Collection<String> r5) {
        Collection<String> r6 = (Collection) ZeusTransformUtils.wrapperContextForParams(r5, Collection.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "type");
        d.h.b.o.e(r4, "packageName");
        this.f27358a = r3;
        this.f27359b = r4;
        this.f27360c = r6;
        this.f27361d = AOSystemTools.INSTANCE.nowTimeMillis();
    }

    public /* synthetic */ f(e.a r2, String r3, Collection r4, int r5, d.h.b.h r6) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
        if ((r5 & 4) == 0) goto L5;
        r7 = null;
    L5:
        this(r2, r3, r7);
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.e
    public e.a getType() {
        return this.f27358a;
    }

    public String a() {
        return this.f27359b;
    }

    @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.e
    public boolean a(c r4) {
        d.h.b.o.e(r4, "appBlackListCriteria");
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.a(), CharSequence.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return false;
    L12:
        return d.h.b.o.a(r4.a(), a());
    L5:
        if (d.o.o.d(r0) == true) goto L8;
        r1 = false;
        goto L9
    }
}
