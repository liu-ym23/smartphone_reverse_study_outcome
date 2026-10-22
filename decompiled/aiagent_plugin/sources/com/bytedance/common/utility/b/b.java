package com.bytedance.common.utility.b;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SystemPropertiesProxy.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    b() {
    }

    public String a(String r6) {
        return (String) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName("android.os.SystemProperties", "com.obric.aiagent.plugin").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[]{String.class}).invoke(null, new Object[]{r6}), String.class, "com.obric.aiagent.plugin");
    }
}
