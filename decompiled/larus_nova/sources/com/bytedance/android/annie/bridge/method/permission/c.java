package com.bytedance.android.annie.bridge.method.permission;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Pair;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.android.annie.log.LogLevel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b> f38773a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static LinkedHashSet<String> f38774b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ArrayList<String> f38775c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ArrayList<String> f38776d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static ArrayList<String> f38777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static ArrayList<String> f38778f;

    public static class a implements b {
        public a() {
        }
    }

    public interface b {
        Intent a(Context r100);

        Intent b(Context r100);

        Intent c(Context r100);
    }

    /* JADX INFO: renamed from: com.bytedance.android.annie.bridge.method.permission.c$c, reason: collision with other inner class name */
    public static final class C0729c extends a {
        public C0729c() {
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.c.b
        public final Intent a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intent r101 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            r101.addCategory("android.intent.category.DEFAULT");
            r101.putExtra("packageName", r100.getPackageName());
            return r101;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.c.b
        public final Intent b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            ComponentName r101 = new ComponentName("com.android.settings", "com.android.settings.applications.InstalledAppDetails");
            Intent r102 = new Intent();
            r102.setComponent(r101);
            r102.setData(Uri.fromParts("package", r100.getPackageName(), null));
            r102.setFlags(268435456);
            return r102;
        }

        @Override // com.bytedance.android.annie.bridge.method.permission.c.b
        public final Intent c(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intent r101 = new Intent("com.meizu.connectivitysettings.CONNECTIVITY_SETTINGS");
            r101.addFlags(268435456);
            r101.putExtra(":settings:show_fragment", "com.meizu.settings.location.MzLocationSettings");
            return r101;
        }
    }

    static {
        f38773a = MapsKt.mapOf(TuplesKt.to("meizu", new C0729c()));
    }

    public static List c() {
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = true;
        if (r100 < 33) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_VIDEO, BaseConstants.PERMISSION_READ_MEDIA_IMAGES});
    L9:
        if (r100 >= 29) goto L13;
        r101 = false;
    L13:
        if (r101 == false) goto L16;
        return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L16:
        return CollectionsKt.listOf(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
    L5:
        r102 = false;
        goto L6
    }

    public static List d() {
        if (Build.VERSION.SDK_INT < 33) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_VIDEO, BaseConstants.PERMISSION_READ_MEDIA_IMAGES});
    L9:
        return CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE");
    L5:
        r100 = false;
        goto L6
    }

    public static List f() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L9;
        return CollectionsKt.emptyList();
    L9:
        return CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE");
    L5:
        r100 = false;
        goto L6
    }

    public static Intent b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = Build.MANUFACTURER;
        b r102 = f38773a.get(r101.toLowerCase());
        if (r102 == null) goto L6;
        Intent r103 = r102.b(r100);
        if (r103 == null) goto L6;
        return r103;
    L6:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intent r104 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        r104.addFlags(268435456);
        r104.setData(Uri.fromParts("package", r100.getPackageName(), null));
        return r104;
    }

    public static boolean g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return NotificationManagerCompat.from(r100).areNotificationsEnabled();
    L5:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean h(int[] r100) {
        Intrinsics.checkNotNullParameter(r100, "grantResults");
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100[r102] < 0) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static boolean i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 28) goto L17;
        Object r101 = r100.getSystemService("location");
        if ((r101 instanceof LocationManager) == false) goto L7;
        LocationManager r102 = (LocationManager) r101;
    L8:
        if (r102 != null) goto L20;
        return false;
    L20:
        return r102.isLocationEnabled();
    L7:
        r102 = null;
        goto L8
    L17:
        if (Settings.Secure.getInt(r100.getContentResolver(), LocationMonitorConst.LOCATION_MODE) == 0) goto L21;
        return true;
    L21:
        return false;
    L14:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public static boolean a(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "permName");
        if (r100 != null) goto L6;
        return false;
    L6:
        if (ContextCompat.checkSelfPermission(r100, r101) == (-1)) goto L9;
        return true;
    L9:
        return false;
    }

    public static Pair e(Context r110, String... r210) {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        String[] r102 = r110.getPackageManager().getPackageInfo(r110.getPackageName(), 4096).requestedPermissions;     // Catch: PackageManager.NameNotFoundException -> L8
        if (r102 != null) goto L6;
        List r103 = CollectionsKt.emptyList();     // Catch: PackageManager.NameNotFoundException -> L8
    L76:
    L10:
        int r104 = r210.length;
        int r105 = 0;
        int r106 = 0;
    L11:
        if (r106 >= r104) goto L75;
        String r107 = r210[r106];
        String[] r108 = PermissionConstants.f38755a;
        if (r107 != null) goto L15;
        String[] r109 = new String[r105];
    L63:
        int r111 = r109.length;
        int r112 = 0;
    L64:
        if (r112 >= r111) goto L73;
        String r113 = r109[r112];
        if (r103.contains(r113) == false) goto L68;
        r100.add(r113);
    L70:
        if (a(r110, r107) == true) goto L72;
        r101.add(r107);
    L72:
        r112 = r112 + 1;
        goto L64
    L68:
        b8.a r114 = b8.a.f17992a;
        b8.a.a(new b8.b("PermissionUtils", LogLevel.ERROR, null, "U should add the permission of " + r107 + " in manifest.", 4), true);
        r101.add(r107);
        goto L70
    L73:
        r106 = r106 + 1;
        r105 = 0;
        goto L11
    L15:
        byte r115 = -1;
        switch(r107.hashCode()) {
            case -1596608551: goto L47;
            case -1166291365: goto L43;
            case 82233: goto L39;
            case 76105038: goto L35;
            case 215175251: goto L31;
            case 604302142: goto L27;
            case 1856013610: goto L23;
            case 1980544805: goto L19;
            default: goto L50;
        };
    L50:
        switch(r115) {
            case 0: goto L62;
            case 1: goto L61;
            case 2: goto L60;
            case 3: goto L57;
            case 4: goto L55;
            case 5: goto L54;
            case 6: goto L53;
            case 7: goto L52;
            default: goto L51;
        };
    L51:
        r109 = new String[1];
        r109[r105] = r107;
        goto L63
    L52:
        r109 = PermissionConstants.f38756b;
        goto L63
    L53:
        r109 = PermissionConstants.f38758d;
        goto L63
    L54:
        r109 = PermissionConstants.f38755a;
        goto L63
    L55:
        r109 = PermissionConstants.f38757c;
        goto L63
    L60:
        r109 = PermissionConstants.f38762h;
        goto L63
    L61:
        r109 = PermissionConstants.f38763i;
        goto L63
    L62:
        r109 = PermissionConstants.f38761g;
        goto L63
    L57:
        if (Build.VERSION.SDK_INT >= 26) goto L59;
        r109 = PermissionConstants.f38760f;
        goto L63
    L59:
        r109 = PermissionConstants.f38759e;
        goto L63
    L19:
        if (r107.equals("CAMERA") == false) goto L50;
        r115 = 7;
        goto L50
    L23:
        if (r107.equals("MICROPHONE") == false) goto L50;
        r115 = 6;
        goto L50
    L27:
        if (r107.equals("CALENDAR") == false) goto L50;
        r115 = 5;
        goto L50
    L31:
        if (r107.equals("CONTACTS") == false) goto L50;
        r115 = 4;
        goto L50
    L35:
        if (r107.equals("PHONE") == false) goto L50;
        r115 = 3;
        goto L50
    L39:
        if (r107.equals(CancelRetainContactInfoFunctions.SMS) == false) goto L50;
        r115 = 2;
        goto L50
    L43:
        if (r107.equals("STORAGE") == false) goto L50;
        r115 = 1;
        goto L50
    L47:
        if (r107.equals("SENSORS") == false) goto L50;
        r115 = 0;
        goto L50
    L75:
        return Pair.create(r100, r101);
    L6:
        r103 = CollectionsKt.listOf(Arrays.copyOf(r102, r102.length));     // Catch: PackageManager.NameNotFoundException -> L8
    L8:
        e = move-exception;
        e.printStackTrace();
        r103 = CollectionsKt.emptyList();
        goto L10
    }
}
