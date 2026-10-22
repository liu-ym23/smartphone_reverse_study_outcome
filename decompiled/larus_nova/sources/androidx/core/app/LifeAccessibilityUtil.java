package androidx.core.app;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import f06.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
public class LifeAccessibilityUtil {
    private static final String SCREEN_READER_INTENT_ACTION = "android.accessibilityservice.AccessibilityService";
    private static final String SCREEN_READER_INTENT_CATEGORY = "android.accessibilityservice.category.FEEDBACK_SPOKEN";

    public interface AccessibilityDelegateCallBack {
        void onInitializeAccessibilityNodeInfo(View r100, AccessibilityNodeInfoCompat r101);
    }

    public LifeAccessibilityUtil() {
    }

    public static boolean isAccessibilityEnabled(Context r100) {
        if (r100 != null) goto L11;
        return false;
    L11:
        boolean r101 = ((AccessibilityManager) r100.getSystemService("accessibility")).isEnabled();     // Catch: Throwable -> L10
        boolean r102 = isScreenReaderActive(r100);     // Catch: Throwable -> L10
        if (r101 == false) goto L13;
        if (r102 == false) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    L15:
        return false;
    }

    private static boolean isScreenReaderActive(Context r100) {
        Intent r101 = new Intent(SCREEN_READER_INTENT_ACTION);
        r101.addCategory(SCREEN_READER_INTENT_CATEGORY);
        boolean r102 = false;
        List<ResolveInfo> r103 = r100.getPackageManager().queryIntentServices(r101, 0);
        if (r103 != null) goto L5;
    L35:
        return false;
    L5:
        if (r103.size() <= 0) goto L35;
        if (Build.VERSION.SDK_INT < 26) goto L23;
        Iterator<ResolveInfo> r104 = r103.iterator();
        boolean r105 = false;
    L11:
        if (r104.hasNext() == false) goto L45;
        ServiceInfo r106 = r104.next().serviceInfo;
        String r107 = r106.packageName;
        String r108 = r106.name;
        String r109 = "";
        if (r108.indexOf(r107) < 0) goto L16;
        r109 = r108.replace(r107, "");
    L16:
        if (isAccessibilitySettingsOn(r100, r107 + HTTP.URL_DEFAULT + r108) == false) goto L18;
    L21:
        boolean r110 = true;
    L22:
        r105 = r105 | r110;
        goto L11
    L18:
        if (isAccessibilitySettingsOn(r100, r107 + HTTP.URL_DEFAULT + r109) == true) goto L21;
        r110 = false;
        goto L22
    L45:
        return r105;
    L23:
        ArrayList r111 = new ArrayList();
        Iterator<ActivityManager.RunningServiceInfo> r112 = ((ActivityManager) r100.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE).iterator();
    L25:
        if (r112.hasNext() == false) goto L27;
        r111.add(r112.next().service.getPackageName());
        goto L25
    L27:
        Iterator<ResolveInfo> r113 = r103.iterator();
    L29:
        if (r113.hasNext() == false) goto L34;
        if (r111.contains(r113.next().serviceInfo.packageName) == false) goto L29;
        r102 = r102 | true;
        goto L29
    L34:
        return r102;
    }

    public static void addContentDescriptionAsBtn(View r100, final String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewCompat.setAccessibilityDelegate(r100, new AnonymousClass2(r101));
    }

    private static String androidx_core_app_LifeAccessibilityUtil_android_provider_Settings$Secure_getString(ContentResolver r110, String r111) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r110, r111};
        f06.b r112 = new f06.b();
        d r113 = r100.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, "java.lang.String", r112);
        if (r113.f474982a == false) goto L6;
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, null, r112, false);
        return (String) r113.f474983b;
    L6:
        String r114 = Settings.Secure.getString(r110, r111);
        r100.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r101, r114, r112, true);
        return r114;
    }

    private static boolean isAccessibilitySettingsOn(Context r100, String r101) {
        TextUtils.SimpleStringSplitter r102 = new TextUtils.SimpleStringSplitter(':');
        String r103 = androidx_core_app_LifeAccessibilityUtil_android_provider_Settings$Secure_getString(r100.getApplicationContext().getContentResolver(), "enabled_accessibility_services");
        if (r103 == null) goto L11;
        r102.setString(r103);
    L6:
        if (r102.hasNext() == false) goto L16;
        if (r102.next().equalsIgnoreCase(r101) == false) goto L6;
        return true;
    L16:
        return false;
    L11:
        return false;
    }

    public static void setAccessibilityDelegate(View r100, final AccessibilityDelegateCallBack r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        ViewCompat.setAccessibilityDelegate(r100, new AnonymousClass1(r101));
    }

    private static Cursor androidx_core_app_LifeAccessibilityUtil_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
