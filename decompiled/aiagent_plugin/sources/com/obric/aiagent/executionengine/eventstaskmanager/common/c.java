package com.obric.aiagent.executionengine.eventstaskmanager.common;

import android.app.Application;
import com.obric.aiagent.platform.depend.IAppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PermissionUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final boolean a(String r7) {
        o.e(r7, "packageName");
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().checkSignatures(r7, IAppContext.Companion.getPackageName()) != 0) goto L5;
        boolean r0 = true;
    L7:
        if (((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(IAppContext.Companion.getApplication(), "com.obric.aiagent.plugin"), Application.class, "com.obric.aiagent.plugin")).getPackageManager().checkSignatures(r7, "android") != 0) goto L9;
        boolean r1 = true;
    L10:
        if (r0 == true) goto L13;
        if (r1 == true) goto L13;
        com.obric.aiagent.executionengine.eventstaskmanager.b.b.f16676a.a("PermissionUtils", "checkPermission: 包名 " + r7 + " 签名校验失败");
    L13:
        if (r0 == true) goto L18;
        if (r1 == false) goto L17;
        return true;
    L17:
        return false;
    L18:
        return true;
    L9:
        r1 = false;
        goto L10
    L5:
        r0 = false;
        goto L7
    }
}
