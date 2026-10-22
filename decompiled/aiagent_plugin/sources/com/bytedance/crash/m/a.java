package com.bytedance.crash.m;

import android.content.Context;
import com.bytedance.crash.config.e;
import com.bytedance.crash.i;
import com.bytedance.crash.o.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: NpthSoData.java */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static boolean a(String r4, File r5, Context r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        File r0 = new File(r5, "lib" + r4 + ".so.tmp");
        String r8 = b.a(r7, r4, r0);
        if (r8 == null) goto L7;
        r.a(r4 + " unpack error: " + r8);
        return false;
    L7:
        return r0.renameTo(new File(r5, "lib" + r4 + ".so"));
    }

    public static boolean a() {
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(i.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        if (new File(r0.getApplicationInfo().nativeLibraryDir, "libnpth_dumper.so").exists() == false) goto L8;
        return true;
    L8:
        String r2 = String.valueOf(4020254);
        File r5 = new File(e.c(), r2);
        if (r5.exists() == true) goto L12;
        r5.mkdirs();
    L12:
        if (new File(r5, "libnpth_dumper.so").exists() == false) goto L15;
        return true;
    L15:
        if (a("c++_shared", r5, r0) == true) goto L17;
        return false;
    L17:
        if (a("npth_unwind", r5, r0) == true) goto L19;
        return false;
    L19:
        if (a("npth_dumper", r5, r0) == true) goto L21;
        return false;
    L21:
        return true;
    }
}
