package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.app.PhotoFaceEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f32062a = null;

    static {
        f32062a = new n();
    }

    private n() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, PhotoFaceEntity.class) == false) goto L9;
        PhotoFaceEntity r1 = (PhotoFaceEntity) ZeusTransformUtils.preCheckCast(r2, PhotoFaceEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getName().hashCode() + 0;
        FileEntity r4 = r1.getAvatar();
        if (r4 != null) goto L7;
        return r3;
    L7:
        return (r3 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
