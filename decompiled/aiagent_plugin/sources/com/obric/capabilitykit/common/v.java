package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.SimCardEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f32069a = null;

    static {
        f32069a = new v();
    }

    private v() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, SimCardEntity.class) == false) goto L15;
        SimCardEntity r1 = (SimCardEntity) ZeusTransformUtils.preCheckCast(r2, SimCardEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getSimSlot().hashCode() + 0;
        String r0 = r1.getSimCarrier();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        String r4 = r1.getPhoneNumber();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        String r5 = r1.getAnonymizedPhoneNumber();
        if (r5 != null) goto L13;
        return r3;
    L13:
        return (r3 * 31) + r5.hashCode();
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }
}
