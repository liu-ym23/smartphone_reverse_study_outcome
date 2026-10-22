package com.bytedance.crash.dumper;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: GfxInfo.java */
/* JADX INFO: loaded from: classes.dex */
public class i {
    public static void a(File r9) {
        FileOutputStream r0 = null;
        Class r1 = ZeusTransformUtils.forName("android.view.WindowManagerGlobal", "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        Object r2 = r1.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        Method r3 = r1.getDeclaredMethod("dumpGfxInfo", new Class[]{FileDescriptor.class, String[].class});     // Catch: Throwable -> L9
        r3.setAccessible(true);     // Catch: Throwable -> L9
        FileOutputStream r4 = new FileOutputStream(new File(r9, "gfxinfo.txt"));     // Catch: Throwable -> L9
        r3.invoke(r2, new Object[]{r4.getFD(), new String[0]});     // Catch: Throwable -> L6
        com.bytedance.crash.o.i.a(r4);
        return;
    L6:
        r0 = r4;
    L7:
        com.bytedance.crash.o.i.a(r0);
    }
}
