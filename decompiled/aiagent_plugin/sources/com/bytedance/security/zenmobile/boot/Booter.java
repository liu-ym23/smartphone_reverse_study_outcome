package com.bytedance.security.zenmobile.boot;

import android.content.Context;
import com.bytedance.security.zenmobile.Engine;
import com.bytedance.security.zenmobile.deidentify.Masker;
import com.bytedance.security.zenmobile.detect.Detector;
import com.bytedance.security.zenmobile.profile.LocalLoader;
import com.bytedance.security.zenmobile.utils.LogUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class Booter {
    public static final String TAG = "ZenMobile-Booter";

    public Booter() {
    }

    public static Engine boot(Context r3, com.bytedance.security.zenmobile.profile.ProfileConfig r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 == null) goto L12;
        if (r4 == null) goto L12;
        Detector r1 = new Detector(r5, new LocalLoader().getProfile(r5, r4.getProfileKey()), r4.isSkipFailureCompilation());
        if (r4.getDeidentifierConfig().getMode().equals("masker") == false) goto L11;
        Engine r0 = new Engine(r1, new Masker(r4.getDeidentifierConfig().getValue()));
        r0.setMaxDetectionLen(r4.getMaxDetectionLen());
        r0.setTruncationLen(r4.getTruncationLen());
        return r0;
    L11:
        throw new IllegalArgumentException("invalid de-identifier mode: " + r4.getDeidentifierConfig().getMode());
    L12:
        LogUtils.e(TAG, "Invalid input params.");
        return null;
    }

    public static Engine boot(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r3 != null) goto L7;
        LogUtils.e(TAG, "Invalid input params.");
        return null;
    L7:
        return boot(r3, com.bytedance.security.zenmobile.profile.ProfileConfig.defaultProfileConfig());
    }
}
