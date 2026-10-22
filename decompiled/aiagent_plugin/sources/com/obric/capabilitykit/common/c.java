package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ICSProtocolEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f32044a = null;

    static {
        f32044a = new c();
    }

    private c() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, ICSProtocolEntity.class) == false) goto L9;
        ICSProtocolEntity r1 = (ICSProtocolEntity) ZeusTransformUtils.preCheckCast(r2, ICSProtocolEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getDoubaoUid().hashCode() + 0;
        String r4 = r1.getICal();
        if (r4 != null) goto L7;
        return r3;
    L7:
        return (r3 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
