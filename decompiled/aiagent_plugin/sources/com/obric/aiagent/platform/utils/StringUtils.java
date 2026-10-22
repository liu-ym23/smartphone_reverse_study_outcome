package com.obric.aiagent.platform.utils;

import com.bytedance.security.zenmobile.io.SensitiveType;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.o.o;

/* JADX INFO: compiled from: StringUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StringUtils {
    public static final StringUtils INSTANCE = null;

    static {
        INSTANCE = new StringUtils();
    }

    private StringUtils() {
    }

    public final String orUnknown(String r2) {
        if (r2 != null) goto L4;
    L8:
        return SensitiveType.UNKNOWN;
    L4:
        if ((!o.d((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
        r2 = null;
    L7:
        if (r2 == null) goto L8;
        return r2;
    }
}
