package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class ai implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ai f32041a = null;

    static {
        f32041a = new ai();
    }

    private ai() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r3) {
        d.h.b.o.e(r3, "instance");
        if (ZeusTransformUtils.instanceOf(r3, FileEntity.class) == false) goto L9;
        FileEntity r2 = (FileEntity) ZeusTransformUtils.preCheckCast(r3, FileEntity.class, "com.obric.aiagent.plugin");
        int r4 = ((((((r2.getFileName().hashCode() + 0) * 31) + Long.hashCode(r2.getFileSize())) * 31) + r2.getContentUrl().hashCode()) * 31) + r2.getFileType().name().hashCode();
        String r5 = r2.getMimeType();
        if (r5 != null) goto L7;
        return r4;
    L7:
        return (r4 * 31) + r5.hashCode();
    L9:
        throw new IllegalStateException("Check failed.".toString());
    }
}
