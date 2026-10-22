package c84;

import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.bytedance.bdinstall.migrate.MigrateDetectorActivity;
import com.bytedance.bdinstall.o0;
import com.bytedance.bdinstall.t;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f22713e = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PackageManager f22714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ComponentName f22715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f22716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SharedPreferences f22717d;

    public a(Context r110, o0 r111) {
        Context r100 = r110.getApplicationContext();
        SharedPreferences r112 = i84.a.a(r110, r111);
        this.f22717d = r112;
        PackageManager r101 = r100.getPackageManager();
        this.f22714a = r101;
        ComponentName r102 = new ComponentName(r110, MigrateDetectorActivity.class);
        this.f22715b = r102;
        int r113 = f22713e;
        boolean r103 = false;
        if (r113 == (-1)) goto L28;
    L5:
        int r114 = r112.getInt("component_state", 0);
        StringBuilder r104 = new StringBuilder("MigrateDetector#isMigrateInternal cs=");
        String r105 = "UNKNOWN";
        if (r113 == 0) goto L12;
        if (r113 == 1) goto L11;
        if (r113 == 2) goto L10;
        String r106 = "UNKNOWN";
    L13:
        r104.append(r106);
        r104.append(" ss=");
        if (r114 == 0) goto L20;
        if (r114 == 1) goto L19;
        if (r114 != 2) goto L21;
        r105 = "STATE_DISABLED";
    L21:
        r104.append(r105);
        t.a(r104.toString());
        if (r113 != 0) goto L25;
        if (r114 != 2) goto L25;
        r103 = true;
    L25:
        this.f22716c = r103;
        t.a("MigrateDetector#constructor migrate=" + r103);
        return;
    L19:
        r105 = "STATE_ENABLED";
        goto L21
    L20:
        r105 = "STATE_DEFAULT";
        goto L21
    L10:
        r106 = "STATE_DISABLED";
        goto L13
    L11:
        r106 = "STATE_ENABLED";
        goto L13
    L12:
        r106 = "STATE_DEFAULT";
        goto L13
    L28:
        r113 = r101.getComponentEnabledSetting(r102);     // Catch: Exception -> L27
        f22713e = r113;     // Catch: Exception -> L27
        goto L5
    }

    public static void a(Context r100, o0 r101, String r102, boolean r103) {
        SharedPreferences.Editor r104 = i84.a.a(r100, r101).edit();
        r104.putString("old_did", r102);
        if (r103 == false) goto L5;
        r104.putBoolean("is_migrate", true);
    L6:
        r104.apply();
        return;
    L5:
        r104.remove("is_migrate");
        goto L6
    }
}
