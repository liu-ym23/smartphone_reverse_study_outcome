package c30;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import androidx.core.app.NotificationManagerCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f22265a = 0;

    public c() {
    }

    static {
    }

    public static final void a(Context r100) {
        if (r100 == null) goto L35;
        boolean r101 = true;
        Intent r102 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", UriProtector.parse("package:" + r100.getPackageName()));     // Catch: Exception -> L15
        r102.addFlags(268435456);     // Catch: Exception -> L15
        List<ResolveInfo> r103 = r100.getPackageManager().queryIntentActivities(r102, 65536);     // Catch: Exception -> L15
        if (r103 != null) goto L8;
    L10:
        boolean r104 = false;
    L11:
        if (r104 == false) goto L16;
        r100.startActivity(r102);     // Catch: Exception -> L15
        boolean r105 = true;
    L17:
        if (r105 == true) goto L36;
        Intent r106 = new Intent("android.settings.APPLICATION_SETTINGS");     // Catch: Exception -> L29
        r106.addFlags(268435456);     // Catch: Exception -> L29
        List<ResolveInfo> r107 = r100.getPackageManager().queryIntentActivities(r106, 65536);     // Catch: Exception -> L29
        if (r107 != null) goto L22;
    L24:
        r101 = false;
    L25:
        if (r101 == false) goto L34;
        r100.startActivity(r106);     // Catch: Exception -> L29
        return;
    L34:
        return;
    L22:
        if (r107.size() <= 0) goto L24;
    L37:
        return;
    L36:
        return;
    L8:
        if (r103.size() <= 0) goto L10;
        r104 = true;
    L16:
        r105 = false;
        goto L17
    }

    public static boolean b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return NotificationManagerCompat.from(r100).areNotificationsEnabled();
    L5:
        return false;
    }
}
