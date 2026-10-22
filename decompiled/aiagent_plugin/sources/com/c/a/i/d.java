package com.c.a.i;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PermissionUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    public static boolean a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        if (r5 != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return false;
    L8:
        if (r5.checkPermission(r4, Process.myPid(), Process.myUid()) != 0) goto L12;
        return true;
    L12:
        return false;
    }
}
