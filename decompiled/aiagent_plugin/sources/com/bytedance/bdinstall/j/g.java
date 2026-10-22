package com.bytedance.bdinstall.j;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: HardwareUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static String a(Context r2) {
        return Settings.Secure.getString(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getContentResolver(), SensitiveType.ANDROID_ID);
    L5:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
