package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.LifeLogEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f32045a = null;

    static {
        f32045a = new e();
    }

    private e() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, LifeLogEntity.class) == false) goto L7;
        LifeLogEntity r1 = (LifeLogEntity) ZeusTransformUtils.preCheckCast(r2, LifeLogEntity.class, "com.obric.aiagent.plugin");
        return ((r1.getTitle().hashCode() + 0) * 31) + r1.getContent().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
