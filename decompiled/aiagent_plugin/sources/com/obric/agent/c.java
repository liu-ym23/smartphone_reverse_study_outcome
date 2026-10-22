package com.obric.agent;

import com.obric.capabilitykit.common.intent.BlockListTarget;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: ActionResultEntityCollector.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f14250a = null;

    static {
        f14250a = new c();
    }

    private c() {
    }

    public final List<AppEntity> a(Object r6) {
        if ((r6 instanceof Object[]) == false) goto L15;
        Object[] r5 = (Object[]) ZeusTransformUtils.preCheckCast(r6, Object[].class, "com.obric.aiagent.plugin");
        Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        int r2 = r5.length;
    L5:
        if (r0 >= r2) goto L25;
        Object r3 = r5[r0];
        if (ZeusTransformUtils.instanceOf(r3, AppEntity.class) == false) goto L9;
        AppEntity r4 = (AppEntity) ZeusTransformUtils.preCheckCast(r3, AppEntity.class, "com.obric.aiagent.plugin");
    L10:
        if (r4 == null) goto L12;
        r7.add(r4);
    L12:
        r0 = r0 + 1;
        goto L5
    L9:
        r4 = null;
        goto L10
    L25:
        return (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L15:
        if (ZeusTransformUtils.instanceOf(r6, AppEntity.class) == false) goto L18;
        return d.a.p.a(r6);
    L18:
        if (ZeusTransformUtils.instanceOf(r6, BlockListTarget.class) == false) goto L21;
        return a((AppEntity) ZeusTransformUtils.preCheckCast(((BlockListTarget) ZeusTransformUtils.preCheckCast(r6, BlockListTarget.class, "com.obric.aiagent.plugin")).getContact(), AppEntity.class, "com.obric.aiagent.plugin"), (AppEntity) ZeusTransformUtils.preCheckCast(((BlockListTarget) ZeusTransformUtils.preCheckCast(r6, BlockListTarget.class, "com.obric.aiagent.plugin")).getCallHistory(), AppEntity.class, "com.obric.aiagent.plugin"));
    L21:
        return d.a.p.b();
    }

    public final List<AppEntity> a(AppEntity r2, AppEntity r3) {
        return d.a.p.e(new AppEntity[]{r2, r3});
    }
}
