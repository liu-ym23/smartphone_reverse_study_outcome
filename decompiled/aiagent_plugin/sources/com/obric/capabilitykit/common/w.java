package com.obric.capabilitykit.common;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.AppInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes3.dex */
public final class w implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f32070a = null;

    static {
        f32070a = new w();
    }

    private w() {
    }

    @Override // com.obric.capabilitykit.common.d
    public int a(AppEntity r2) {
        d.h.b.o.e(r2, "instance");
        if (ZeusTransformUtils.instanceOf(r2, AppInfoEntity.class) == false) goto L15;
        AppInfoEntity r1 = (AppInfoEntity) ZeusTransformUtils.preCheckCast(r2, AppInfoEntity.class, "com.obric.aiagent.plugin");
        int r3 = ((((((r1.getAppName().hashCode() + 0) * 31) + r1.getAppPackageName().hashCode()) * 31) + Integer.hashCode(r1.getAppStatus())) * 31) + Boolean.hashCode(r1.isExactMatch());
        String r0 = r1.getIcon();
        if (r0 == null) goto L7;
        r3 = (r3 * 31) + r0.hashCode();
    L7:
        String r4 = r1.getOpenStoreDetailDeeplink();
        if (r4 == null) goto L10;
        r3 = (r3 * 31) + r4.hashCode();
    L10:
        String r5 = r1.getPackageSize();
        if (r5 != null) goto L13;
        return r3;
    L13:
        return (r3 * 31) + r5.hashCode();
    L15:
        throw new IllegalStateException("Check failed.".toString());
    }
}
