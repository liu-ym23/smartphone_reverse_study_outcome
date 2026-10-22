package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.UserProfileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class z implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f32073a = null;

    static {
        f32073a = new z();
    }

    private z() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, UserProfileEntity.class) == false) goto L7;
        UserProfileEntity r1 = (UserProfileEntity) ZeusTransformUtils.preCheckCast(r2, UserProfileEntity.class, "com.obric.aiagent.plugin");
        return ((((r1.getProfileKey().hashCode() + 0) * 31) + r1.getProfileValue().hashCode()) * 31) + Boolean.hashCode(r1.isFromAutoLearn());
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
