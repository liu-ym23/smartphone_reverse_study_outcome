package ch7;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.appdownloader.util.RomUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23799a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Intent> f23800b = null;

    public b() {
    }

    static {
        f23799a = new b();
        f23800b = new ArrayList();
    }

    public static void a(FragmentActivity r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r101 = (ArrayList) f23800b;
        if (r101.size() != 0) goto L13;
        String r102 = r100.getPackageName();
        Intent r103 = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionManagerActivity"));
        r103.putExtra("pkg_name", r102);
        if (r100.getApplicationInfo().labelRes == 0) goto L7;
        CharSequence r104 = r100.getResources().getString(r100.getApplicationInfo().labelRes);
    L8:
        r103.putExtra("app_name", r104);
        r103.putExtra("class_name", b.class.getName());
        r101.add(r103);
        Intent r105 = new Intent().setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.permission.PermissionAppAllPermissionActivity"));
        r105.putExtra("packageName", r102);
        r101.add(r105);
        Intent r106 = new Intent().setComponent(new ComponentName(RomUtils.PACKAGE_INSTALLER_GOOGLE, "com.android.packageinstaller.permission.ui.ManagePermissionsActivity"));
        if (Build.VERSION.SDK_INT < 24) goto L11;
        r106.putExtra("android.intent.extra.PACKAGE_NAME", r102);
    L11:
        r101.add(r106);
        return;
    L7:
        r104 = r100.getPackageManager().getApplicationLabel(r100.getApplicationInfo());
        goto L8
    }
}
