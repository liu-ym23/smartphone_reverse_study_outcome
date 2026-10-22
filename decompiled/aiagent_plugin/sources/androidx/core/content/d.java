package androidx.core.content;

import android.content.Context;
import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PermissionChecker.java */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public static int a(Context r2, String r3, int r4, int r5, String r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (r7.checkPermission(r3, r4, r5) != (-1)) goto L5;
        return -1;
    L5:
        String r8 = androidx.core.app.c.a(r3);
        if (r8 != null) goto L8;
        return 0;
    L8:
        if (r6 != null) goto L16;
        String[] r9 = r7.getPackageManager().getPackagesForUid(r5);
        if (r9 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r9.length <= 0) goto L15;
        r6 = r9[0];
    L16:
        int r0 = Process.myUid();
        String r1 = r7.getPackageName();
        if (r0 == r5) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == false) goto L24;
        int r11 = androidx.core.app.c.a(r7, r5, r8, r6);
    L25:
        if (r11 == 0) goto L29;
        return -2;
    L29:
        return 0;
    L24:
        r11 = androidx.core.app.c.a(r7, r8, r6);
        goto L25
    L19:
        if (androidx.core.util.d.a(r1, r6) == false) goto L21;
        r10 = true;
        goto L22
    }

    public static int a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        return a(r5, r4, Process.myPid(), Process.myUid(), r5.getPackageName());
    }
}
