package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ad implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ad f32035a = null;

    static {
        f32035a = new ad();
    }

    private ad() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, CloudDocumentEntity.class) == false) goto L7;
        CloudDocumentEntity r1 = (CloudDocumentEntity) ZeusTransformUtils.preCheckCast(r2, CloudDocumentEntity.class, "com.obric.aiagent.plugin");
        return ((r1.getTitle().hashCode() + 0) * 31) + r1.getUrl().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
