package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.annotation.RestrictTo;
import androidx.core.app.c;
import androidx.core.util.b;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class PermissionChecker {

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface PermissionResult {
    }

    public static int a(Context r10, String r11, int r12, int r13, String r14) {
        if (r10.checkPermission(r11, r12, r13) != (-1)) goto L5;
        return -1;
    L5:
        String r15 = c.c(r11);
        if (r15 != null) goto L8;
        return 0;
    L8:
        if (r14 != null) goto L16;
        String[] r16 = r10.getPackageManager().getPackagesForUid(r13);
        if (r16 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r16.length <= 0) goto L15;
        r14 = r16[0];
    L16:
        int r17 = Process.myUid();
        String r18 = r10.getPackageName();
        if (r17 == r13) goto L19;
    L21:
        int r19 = c.b(r10, r15, r14);
    L22:
        if (r19 == 0) goto L26;
        return -2;
    L26:
        return 0;
    L19:
        if (b.a(r18, r14) == false) goto L21;
        r19 = c.a(r10, r13, r15, r14);
        goto L22
    }

    public static int b(Context r10, String r11) {
        return a(r10, r11, Process.myPid(), Process.myUid(), r10.getPackageName());
    }
}
