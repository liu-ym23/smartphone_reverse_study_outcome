package com.c.a.e.b.a;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;

/* JADX INFO: compiled from: PrefFileGenerator.java */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static File a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        String r1 = r10.getApplicationInfo().dataDir + "/shared_prefs";
        String r11 = r10.getApplicationInfo().dataDir + "/spFiles";
        String r2 = r11 + File.separator + "/tmp";
        File r3 = new File(r1);
        if (r3.exists() == false) goto L18;
        File[] r4 = r3.listFiles();
        int r5 = r4.length;
        int r6 = 0;
    L5:
        if (r6 >= r5) goto L18;
        File r7 = r4[r6];
        String r8 = r7.getName();
        if (r8.endsWith(".xml") == false) goto L11;
        if (com.c.a.i.b.a(r7.getAbsolutePath(), r2, r8) == true) goto L11;
        return null;
    L11:
        r6 = r6 + 1;
    L18:
        com.c.a.i.b.b(r2, r11 + File.separator + "sp.zip");     // Catch: Exception -> L15
        com.c.a.i.b.a(r2);
        return new File(r11 + File.separator + "sp.zip");
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}
