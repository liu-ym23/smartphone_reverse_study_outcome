package com.bytedance.ai.model.clienttool;

import com.bytedance.ai.bridge.core.AIBridgeMethod;
import d3.a0;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements i3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f36839a = null;

    /* JADX INFO: renamed from: com.bytedance.ai.model.clienttool.a$a, reason: collision with other inner class name */
    public static final class C0707a {
    }

    public a() {
    }

    @Override // i3.b
    public final int getPriority() {
        return 0;
    }

    @Override // i3.b
    public final void reset() {
    }

    static {
        f36839a = SetsKt.setOf(new String[]{"replyLocalPlugin", "doubao.getAccountInfo", "doubao.getSetting", "doubao.getAppAuthorizeSetting", "doubao.getSystemInfo", "doubao.getSystemSetting", "doubao.request", "doubao.getLocation", "doubao.login", "doubao.getDeviceInfo", "doubao.reportEvent", "doubao.setStorage", "doubao.getStorage", "doubao.removeStorage", "doubao.clearStorage", "doubao.getStorageInfo"});
    }

    @Override // i3.b
    public final AIBridgeMethod.Error a(i3.a r100) {
        Intrinsics.checkNotNullParameter(r100, "invocation");
        a0 r101 = r100.f488078c.getContainerContext();
        if (r101 == null) goto L5;
        Integer r102 = r101.getAppSourceType();
    L6:
        com.bytedance.ai.utils.g r103 = com.bytedance.ai.utils.g.f37637a;
        StringBuilder r104 = new StringBuilder("intercept: appletId=");
        Object r105 = "unknown";
        if (r101 == null) goto L10;
        String r106 = r101.getAppletId();
        if (r106 == null) goto L10;
    L11:
        r104.append(r106);
        r104.append(", methodName=");
        r104.append(r100.f488076a);
        r104.append(", sourceType=");
        if (r102 == null) goto L15;
        r105 = r102;
    L15:
        r104.append(r105);
        r103.i("ClientToolJSBInterceptor", r104.toString());
        if (r102 != null) goto L19;
    L20:
        return null;
    L19:
        if (r102.intValue() != 2) goto L20;
        if (f36839a.contains(r100.f488076a) == false) goto L25;
        return null;
    L25:
        return new AIBridgeMethod.Error(-1, "method " + r100.f488076a + " is not allowed in Client Tool Runtime", null, f3.a.f475271l);
    L10:
        r106 = "unknown";
        goto L11
    L5:
        r102 = null;
        goto L6
    }
}
