package ae7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3113a = 0;

    static {
    }

    public static List a() {
        return ArraysKt.toList(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"});
    }

    public static String[] b() {
        Application r100 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r100 == null) goto L10;
        if (Build.VERSION.SDK_INT < 33) goto L10;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L10;
        return new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_AUDIO, BaseConstants.PERMISSION_READ_MEDIA_VIDEO};
    L10:
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public static String[] c() {
        Application r100 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r100 == null) goto L10;
        if (Build.VERSION.SDK_INT < 33) goto L10;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L10;
        return new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_AUDIO, BaseConstants.PERMISSION_READ_MEDIA_VIDEO};
    L10:
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public static String[] d() {
        Application r100 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r100 == null) goto L10;
        if (Build.VERSION.SDK_INT < 33) goto L10;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L10;
        return new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO};
    L10:
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public static String[] e() {
        Application r100 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r100 == null) goto L10;
        if (Build.VERSION.SDK_INT < 33) goto L10;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L10;
        return new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES};
    L10:
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public static String[] f() {
        Application r100 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r100 == null) goto L10;
        if (Build.VERSION.SDK_INT < 33) goto L10;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L10;
        return new String[]{BaseConstants.PERMISSION_READ_MEDIA_VIDEO};
    L10:
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
    }

    public static boolean g() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean q() {
        Application r100 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;
        if (r100 != null) goto L5;
    L9:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L9;
        return true;
    }

    public static boolean h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") != (-1)) goto L5;
    L7:
        return false;
    L5:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L7;
        return true;
    }

    public static boolean i(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r101 = new StringBuilder("sdk version : ");
        int r102 = Build.VERSION.SDK_INT;
        r101.append(r102);
        id7.c.a(r101.toString());
        if (r102 < 33) goto L12;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L12;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L9;
    L15:
        return true;
    L9:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") != (-1)) goto L15;
    L16:
        return false;
    L12:
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_COARSE_LOCATION") == (-1)) goto L16;
        if (ContextCompat.checkSelfPermission(r100, "android.permission.ACCESS_FINE_LOCATION") == (-1)) goto L16;
        goto L15
    }

    public static boolean j(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 33) goto L8;
        if (r100.getApplicationInfo().targetSdkVersion < 33) goto L8;
        return n(r100, a());
    L8:
        return m(r100, a());
    }

    public static boolean k(Context r100) {
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

    public static boolean l(Context r100, String r101) {
        if (ContextCompat.checkSelfPermission(r100, r101) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean m(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        Activity r102 = (Activity) r100;
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        String r104 = (String) r103.next();
        if (r104 == null) goto L4;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r102, r104) == true) goto L4;
        return true;
    L11:
        return false;
    }

    public static boolean n(Context r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, ComplianceResult.JsonKey.PERMISSIONS);
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r100;
    L7:
        if (r102 != null) goto L9;
        return false;
    L9:
        Iterator r103 = r101.iterator();
    L11:
        if (r103.hasNext() == false) goto L17;
        String r104 = (String) r103.next();
        if (r104 == null) goto L11;
        if (ActivityCompat.shouldShowRequestPermissionRationale(r102, r104) == false) goto L11;
        return false;
    L17:
        return true;
    L5:
        r102 = null;
        goto L7
    }

    public static boolean o(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "accessLevel");
        int r100 = r111.hashCode();
        if (r100 == (-1406475221)) goto L58;
        if (r100 == (-1120887831)) goto L32;
        if (r100 == (-867683742)) goto L10;
    L59:
        return false;
    L10:
        if (r111.equals("readOnly") == false) goto L59;
        if (q() == false) goto L26;
        if (l(r110, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L20;
        if (l(r110, BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L20;
        return true;
    L20:
        if (Build.VERSION.SDK_INT >= 34) goto L22;
    L24:
        return false;
    L22:
        if (l(r110, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L24;
        return true;
    L26:
        if (g() == false) goto L30;
        return l(r110, "android.permission.READ_EXTERNAL_STORAGE");
    L30:
        return l(r110, "android.permission.READ_EXTERNAL_STORAGE");
    L32:
        if (r111.equals("readWrite") == false) goto L59;
        if (q() == false) goto L48;
        if (l(r110, BaseConstants.PERMISSION_READ_MEDIA_IMAGES) == false) goto L42;
        if (l(r110, BaseConstants.PERMISSION_READ_MEDIA_VIDEO) == false) goto L42;
        return true;
    L42:
        if (Build.VERSION.SDK_INT >= 34) goto L44;
    L46:
        return false;
    L44:
        if (l(r110, "android.permission.READ_MEDIA_VISUAL_USER_SELECTED") == false) goto L46;
        return true;
    L48:
        if (g() == false) goto L52;
        return l(r110, "android.permission.READ_EXTERNAL_STORAGE");
    L52:
        if (l(r110, "android.permission.READ_EXTERNAL_STORAGE") == true) goto L54;
        return false;
    L54:
        if (l(r110, "android.permission.WRITE_EXTERNAL_STORAGE") == false) goto L69;
        return true;
    L69:
        return false;
    L58:
        if (r111.equals("writeOnly") == false) goto L59;
        if (q() == false) goto L64;
        return true;
    L64:
        if (g() == false) goto L67;
        return true;
    L67:
        return l(r110, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean p(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "accessLevel");
        int r100 = r111.hashCode();
        if (r100 == (-1406475221)) goto L50;
        if (r100 == (-1120887831)) goto L30;
        if (r100 == (-867683742)) goto L10;
    L51:
        return true;
    L10:
        if (r111.equals("readOnly") == false) goto L51;
        if (q() == false) goto L24;
        if (m(r110, CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO})) == false) goto L18;
        return true;
    L18:
        if (Build.VERSION.SDK_INT >= 34) goto L20;
    L22:
        return false;
    L20:
        if (m(r110, CollectionsKt.listOf("android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) == false) goto L22;
        return true;
    L24:
        if (g() == false) goto L28;
        return m(r110, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
    L28:
        return m(r110, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
    L30:
        if (r111.equals("readWrite") == false) goto L51;
        if (q() == false) goto L44;
        if (m(r110, CollectionsKt.listOf(new String[]{BaseConstants.PERMISSION_READ_MEDIA_IMAGES, BaseConstants.PERMISSION_READ_MEDIA_VIDEO})) == false) goto L38;
        return true;
    L38:
        if (Build.VERSION.SDK_INT >= 34) goto L40;
    L42:
        return false;
    L40:
        if (m(r110, CollectionsKt.listOf("android.permission.READ_MEDIA_VISUAL_USER_SELECTED")) == false) goto L42;
        return true;
    L44:
        if (g() == false) goto L48;
        return m(r110, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"));
    L48:
        return m(r110, CollectionsKt.listOf(new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"}));
    L50:
        if (r111.equals("writeOnly") == false) goto L51;
        if (q() == false) goto L56;
        return false;
    L56:
        if (g() == false) goto L59;
        return false;
    L59:
        return m(r110, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE"));
    }
}
