package com.obric.agent;

import com.obric.capabilitykit.entity.app.AlarmEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchEntityResult;
import com.obric.memorydata.sdk.entity.global.GlobalAssistantSearchResponse;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: GlobalSearchEntityOrderNormalizer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f14571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Comparator<AlarmEntity> f14572b = null;

    /* JADX INFO: renamed from: lambda$QzFo-zvD6Uu8NjB_LJysNSPpvsU, reason: not valid java name */
    public static /* synthetic */ Comparable m77lambda$QzFozvD6Uu8NjB_LJysNSPpvsU(AlarmEntity r0) {
        return b(r0);
    }

    public static /* synthetic */ Comparable lambda$sMXXsipnMRny1KG2NIPGmmzTBo8(AlarmEntity r0) {
        return a(r0);
    }

    private i() {
    }

    static {
        f14571a = new i();
        f14572b = d.b.a.a(new d.h.a.b[]{$$Lambda$i$sMXXsipnMRny1KG2NIPGmmzTBo8.INSTANCE, $$Lambda$i$QzFozvD6Uu8NjB_LJysNSPpvsU.INSTANCE});
    }

    private static final Comparable a(AlarmEntity r2) {
        d.h.b.o.e(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(r2.getStartTime(), Comparable.class, "com.obric.aiagent.plugin");
    }

    private static final Comparable b(AlarmEntity r2) {
        d.h.b.o.e(r2, "it");
        return (Comparable) ZeusTransformUtils.preCheckCast(Long.valueOf(r2.getCreateTime()), Comparable.class, "com.obric.aiagent.plugin");
    }

    public final void a(GlobalAssistantSearchResponse r5) {
        d.h.b.o.e(r5, "response");
        GlobalAssistantSearchEntityResult r0 = r5.getEntityResult();
        if (r0 != null) goto L5;
        return;
    L5:
        List<AppEntity> r4 = a(r0.getEntityList());
        if (d.h.b.o.a(r4, r0.getEntityList()) == false) goto L8;
        return;
    L8:
        r5.setEntityResult(GlobalAssistantSearchEntityResult.copy$default(r0, r4, 0, 2, null));
    }

    private final List<AppEntity> a(List<? extends AppEntity> r11) {
        List<AppEntity> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
        if (r10.size() >= 2) goto L5;
        return r10;
    L5:
        List<AppEntity> r12 = d.a.p.g((Collection) ZeusTransformUtils.preCheckCast(r10, Collection.class, "com.obric.aiagent.plugin"));
        int r3 = 0;
    L7:
        if (r3 >= r10.size()) goto L34;
        if (ZeusTransformUtils.instanceOf(r10.get(r3), AlarmEntity.class) == false) goto L10;
        int r4 = r3;
    L13:
        if (r4 >= r10.size()) goto L18;
        if (ZeusTransformUtils.instanceOf(r10.get(r4), AlarmEntity.class) == false) goto L18;
        r4 = r4 + 1;
    L18:
        if ((r4 - r3) < 2) goto L33;
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(r10.subList(r3, r4), Iterable.class, "com.obric.aiagent.plugin");
        Collection r6 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
        Iterator r7 = r5.iterator();
    L22:
        if (r7.hasNext() == false) goto L26;
        Object r8 = r7.next();
        if (ZeusTransformUtils.instanceOf(r8, AlarmEntity.class) == false) goto L22;
        r6.add(r8);
        goto L22
    L26:
        Iterator r9 = ((Iterable) ZeusTransformUtils.preCheckCast(d.a.p.a((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.aiagent.plugin"), Iterable.class, "com.obric.aiagent.plugin"), f14572b), Iterable.class, "com.obric.aiagent.plugin")).iterator();
        int r13 = 0;
    L28:
        if (r9.hasNext() == false) goto L33;
        Object r14 = r9.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L32;
        d.a.p.c();
    L32:
        r12.set(r13 + r3, (AlarmEntity) ZeusTransformUtils.preCheckCast(r14, AlarmEntity.class, "com.obric.aiagent.plugin"));
        r13 = r15;
    L33:
        r3 = r4;
        goto L7
    L10:
        r3 = r3 + 1;
        goto L7
    L34:
        return r12;
    }
}
