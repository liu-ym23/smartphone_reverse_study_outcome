package com.bytedance.crash.o;

import android.content.Context;
import com.bytedance.crash.ac;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: SoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class w {
    public static boolean a(String r3) {
        System.loadLibrary(r3);     // Catch: Throwable -> L5
        return true;
    L5:
        com.bytedance.librarian.a.a(r3, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(ac.b(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L8
        return true;
    L8:
        return false;
    }
}
