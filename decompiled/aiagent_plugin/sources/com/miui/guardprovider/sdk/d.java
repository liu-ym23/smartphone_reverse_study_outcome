package com.miui.guardprovider.sdk;

import android.content.pm.PackageInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: compiled from: ScanStateCallback.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d {
    default void a(int r1, String r2) {
    }

    default void a(String r1) {
    }

    default void a(String r1, PackageInfo r2, List<com.miui.guardprovider.c> r3) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }
}
