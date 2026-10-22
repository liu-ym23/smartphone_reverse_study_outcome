package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class PermissionChecker {
    public static final int PERMISSION_DENIED = -1;
    public static final int PERMISSION_DENIED_APP_OP = -2;
    public static final int PERMISSION_GRANTED = 0;

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int checkCallingOrSelfPermission(Context r100, String r101) {
        if (Binder.getCallingPid() != Process.myPid()) goto L5;
        String r102 = r100.getPackageName();
    L7:
        return checkPermission(r100, r101, Binder.getCallingPid(), Binder.getCallingUid(), r102);
    L5:
        r102 = null;
        goto L7
    }

    public static int checkSelfPermission(Context r100, String r101) {
        return checkPermission(r100, r101, Process.myPid(), Process.myUid(), r100.getPackageName());
    }

    public static int checkCallingPermission(Context r100, String r101, String r102) {
        if (Binder.getCallingPid() != Process.myPid()) goto L7;
        return -1;
    L7:
        return checkPermission(r100, r101, Binder.getCallingPid(), Binder.getCallingUid(), r102);
    }

    private static int androidx_core_content_PermissionChecker_android_content_Context_checkPermission(Context r110, String r111, int r210, int r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, Integer.valueOf(r210), Integer.valueOf(r211)};
        f06.b r112 = new f06.b("auto_cert_androidx_core_content_PermissionChecker_android_content_Context_checkPermission");
        g06.a r102 = ApiHookConfig.f245611b.get(102607);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(102607, "android/content/Context", "checkPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.checkPermission(r111, r210, r211);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static int checkPermission(Context r100, String r101, int r102, int r103, String r104) {
        if (androidx_core_content_PermissionChecker_android_content_Context_checkPermission(r100, r101, r102, r103) != (-1)) goto L5;
        return -1;
    L5:
        String r105 = AppOpsManagerCompat.permissionToOp(r101);
        if (r105 != null) goto L8;
        return 0;
    L8:
        if (r104 != null) goto L16;
        String[] r106 = r100.getPackageManager().getPackagesForUid(r103);
        if (r106 != null) goto L12;
    L15:
        return -1;
    L12:
        if (r106.length <= 0) goto L15;
        r104 = r106[0];
    L16:
        int r107 = Process.myUid();
        String r108 = r100.getPackageName();
        if (r107 == r103) goto L19;
    L21:
        boolean r109 = false;
    L22:
        if (r109 == false) goto L24;
        int r110 = AppOpsManagerCompat.checkOrNoteProxyOp(r100, r103, r105, r104);
    L25:
        if (r110 == 0) goto L29;
        return -2;
    L29:
        return 0;
    L24:
        r110 = AppOpsManagerCompat.noteProxyOpNoThrow(r100, r105, r104);
        goto L25
    L19:
        if (ObjectsCompat.equals(r108, r104) == false) goto L21;
        r109 = true;
        goto L22
    }
}
