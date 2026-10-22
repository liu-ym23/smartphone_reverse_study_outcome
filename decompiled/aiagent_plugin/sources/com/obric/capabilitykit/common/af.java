package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CountdownEntity;
import com.obric.capabilitykit.entity.enums.CountdownStatusEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class af implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final af f32037a = null;

    static {
        f32037a = new af();
    }

    private af() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r3) {
        d.h.b.o.e(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, CountdownEntity.class) == false) goto L12;
        CountdownEntity r2 = (CountdownEntity) ZeusTransformUtils.preCheckCast(r3, CountdownEntity.class, "com.obric.aiagent.plugin");
        int r4 = Long.hashCode(r2.getCountdownSeconds()) + 0;
        String r0 = r2.getLabel();
        if (r0 == null) goto L7;
        r4 = (r4 * 31) + r0.hashCode();
    L7:
        CountdownStatusEnum r5 = r2.getStatus();
        if (r5 != null) goto L10;
        return r4;
    L10:
        return (r4 * 31) + r5.name().hashCode();
    L12:
        throw new IllegalStateException("Check failed.".toString());
    }
}
