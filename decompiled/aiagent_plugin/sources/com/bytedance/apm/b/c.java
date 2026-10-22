package com.bytedance.apm.b;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: DefaultAlogUploadStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements f {
    public c() {
    }

    @Override // com.bytedance.apm.b.f
    public List<String> a(Context r10, String r11, long r12, long r14) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        final long r7 = r12 * 1000;
        final long r5 = r14 * 1000;
        if (r7 <= r5) goto L5;
        return null;
    L5:
        if (r11 != null) goto L7;
        return null;
    L7:
        File r15 = new File(r11);
        if (r15.exists() == true) goto L10;
    L19:
        return null;
    L10:
        if (r15.isDirectory() == false) goto L19;
        final Pattern r4 = Pattern.compile("^\\d{4}_\\d{2}_\\d{2}_(\\d+)__\\S+__\\S+\\.alog\\.hot$");
        File[] r9 = r15.listFiles(new AnonymousClass1(this, r4, r5, r7));
        ArrayList r16 = new ArrayList();
        if (r9 != null) goto L15;
        return null;
    L15:
        int r17 = r9.length;
        int r18 = 0;
    L16:
        if (r18 >= r17) goto L18;
        r16.add(r9[r18].getAbsolutePath());
        r18 = r18 + 1;
        goto L16
    L18:
        return r16;
    }
}
