package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.WebsiteEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ab implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ab f32033a = null;

    static {
        f32033a = new ab();
    }

    private ab() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, WebsiteEntity.class) == false) goto L9;
        WebsiteEntity r1 = (WebsiteEntity) ZeusTransformUtils.preCheckCast(r2, WebsiteEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getWebUrl().hashCode() + 0;
        String r4 = r1.getTitle();
        if (r4 != null) goto L7;
        return r3;
    L7:
        return (r3 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
