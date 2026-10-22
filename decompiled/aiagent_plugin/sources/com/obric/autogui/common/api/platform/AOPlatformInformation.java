package com.obric.autogui.common.api.platform;

import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AOPlatformInformation.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AOPlatformInformation {

    /* JADX INFO: compiled from: AOPlatformInformation.kt */
    public static final class DefaultImpls {
        public static String getBrand(AOPlatformInformation r2) {
            AOPlatformInformation r3 = (AOPlatformInformation) ZeusTransformUtils.wrapperContextForParams(r2, AOPlatformInformation.class, "com.obric.aiagent.plugin");
            String r4 = Build.BRAND;
            o.c(r4, "BRAND");
            return r4;
        }
    }

    String getBrand();

    int getFrameworkApiVersion();

    String getName();

    String getProject();

    String getRomVersion();
}
