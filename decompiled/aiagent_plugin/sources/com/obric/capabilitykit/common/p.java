package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ProactiveMemoryEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f32063a = null;

    static {
        f32063a = new p();
    }

    private p() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, ProactiveMemoryEntity.class) == false) goto L12;
        ProactiveMemoryEntity r1 = (ProactiveMemoryEntity) ZeusTransformUtils.preCheckCast(r2, ProactiveMemoryEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getContent().hashCode() + 0;
        String r0 = r1.getTitle();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        Integer r4 = r1.getProductType();
        if (r4 != null) goto L10;
        return r3;
    L10:
        return (r3 * 31) + Integer.hashCode(r4.intValue());
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
