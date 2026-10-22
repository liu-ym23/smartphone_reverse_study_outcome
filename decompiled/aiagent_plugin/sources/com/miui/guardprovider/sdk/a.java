package com.miui.guardprovider.sdk;

import android.content.Context;
import com.miui.guardprovider.aidl.ScanResultInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: ManagerUtils.java */
/* JADX INFO: loaded from: classes2.dex */
final class a {
    static boolean a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r4.getPackageManager().resolveService(com.miui.guardprovider.b.f13912a, 0) != null) goto L6;
        return false;
    L6:
        if (r4.checkSelfPermission("com.miui.guardprovider.permission.VirusScanNG") != 0) goto L9;
        return true;
    L9:
        return false;
    }

    static List<com.miui.guardprovider.c> a(List<ScanResultInfo> r2) {
        List r3 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        return null;
    L7:
        return (List) ZeusTransformUtils.preCheckCast(r3.stream().map($$Lambda$y4ZsVCg7d3JXqWiGi32ATPuLto.INSTANCE).sorted().collect(Collectors.toList()), List.class, "com.obric.aiagent.plugin");
    }
}
