package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f32066a = null;

    static {
        f32066a = new s();
    }

    private s() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, AlbumEntity.class) == false) goto L9;
        AlbumEntity r1 = (AlbumEntity) ZeusTransformUtils.preCheckCast(r2, AlbumEntity.class, "com.obric.aiagent.plugin");
        int r3 = r1.getName().hashCode() + 0;
        FileEntity r4 = r1.getCover();
        if (r4 != null) goto L7;
        return r3;
    L7:
        return (r3 * 31) + r4.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
