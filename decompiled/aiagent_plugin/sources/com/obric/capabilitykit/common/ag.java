package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.DoubaoAccountEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ag implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ag f32038a = null;

    static {
        f32038a = new ag();
    }

    private ag() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, DoubaoAccountEntity.class) == false) goto L7;
        return ((DoubaoAccountEntity) ZeusTransformUtils.preCheckCast(r2, DoubaoAccountEntity.class, "com.obric.aiagent.plugin")).getDoubaoUid().hashCode() + 0;
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
