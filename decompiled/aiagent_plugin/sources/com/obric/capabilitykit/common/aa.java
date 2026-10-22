package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.BrowserBookmarkEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class aa implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aa f32032a = null;

    static {
        f32032a = new aa();
    }

    private aa() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, BrowserBookmarkEntity.class) == false) goto L7;
        BrowserBookmarkEntity r1 = (BrowserBookmarkEntity) ZeusTransformUtils.preCheckCast(r2, BrowserBookmarkEntity.class, "com.obric.aiagent.plugin");
        return ((r1.getTitle().hashCode() + 0) * 31) + r1.getWebUrl().hashCode();
    L7:
        throw new IllegalStateException("Check failed.".toString());
    }
}
