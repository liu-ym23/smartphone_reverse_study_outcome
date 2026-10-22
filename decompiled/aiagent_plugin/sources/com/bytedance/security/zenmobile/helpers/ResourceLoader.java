package com.bytedance.security.zenmobile.helpers;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes.dex */
public class ResourceLoader {
    public ResourceLoader() {
    }

    public static byte[] loadBytes(Context r5, String r6) {
        InputStream r7 = ((Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin")).getAssets().open(r6);
        if (r7 == null) goto L11;
        ByteArrayOutputStream r8 = new ByteArrayOutputStream();
        byte[] r1 = new byte[1024];
    L5:
        int r3 = r7.read(r1, 0, 1024);
        if (r3 == (-1)) goto L9;
        r8.write(r1, 0, r3);
        goto L5
    L9:
        return r8.toByteArray();
    L11:
        throw new IllegalArgumentException("file not found: " + r6);
    }

    public static String loadString(Context r2, String r3) {
        return new String(loadBytes((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), r3), StandardCharsets.UTF_8);
    }
}
