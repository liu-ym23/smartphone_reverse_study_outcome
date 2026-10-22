package com.bytedance.android.accessibilityLib_Core.tool;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f38311a = 0;

    static {
    }

    public static boolean a(Context r100) {
        if (r100 != null) goto L39;
        return false;
    L39:
        Object r101 = r100.getSystemService("accessibility");     // Catch: Exception -> L24
        if ((r101 instanceof AccessibilityManager) == true) goto L8;
        r101 = null;
    L8:
        AccessibilityManager r102 = (AccessibilityManager) r101;     // Catch: Exception -> L24
        if (r102 == null) goto L23;
        boolean r103 = r102.isTouchExplorationEnabled();     // Catch: Exception -> L24
        if (("isTouchExplorationEnable = " + r103) == null) goto L13;
        Context r104 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L24
    L13:
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;     // Catch: Exception -> L24
        if (r102.isEnabled() == false) goto L17;
        if (r103 == false) goto L17;
        boolean r106 = true;
    L18:
        List<AccessibilityServiceInfo> r107 = r102.getEnabledAccessibilityServiceList(1);     // Catch: Exception -> L24
        String r108 = "accessibilityServices:" + r107.size() + ",packageName = " + r100.getPackageName();     // Catch: Exception -> L24
        boolean r109 = !r107.isEmpty();     // Catch: Exception -> L24
        if (r109 == true) goto L21;
        r109 = b(r100);     // Catch: Exception -> L24
    L21:
        Unit r110 = Unit.INSTANCE;     // Catch: Exception -> L24
    L33:
        if (("isAccessibilityEnable:" + r106 + ",isScreenReaderable:" + r109) == null) goto L35;
        Context r111 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L35:
        if (r106 == false) goto L42;
        if (r109 == false) goto L43;
        return true;
    L43:
        return false;
    L42:
        return false;
    L17:
        r106 = false;
        goto L18
    L23:
        return false;
    L24:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L29;
        Context r112 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L29:
        if (("isAccessibilityEnabled exception occur: " + e.getMessage()) == null) goto L31;
        Context r113 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L31:
        Unit r114 = Unit.INSTANCE;
        r106 = false;
        r109 = false;
        goto L33
    }

    public static boolean b(Context r210) {
        Intent r100 = new Intent("android.accessibilityservice.AccessibilityService");
        r100.addCategory("android.accessibilityservice.category.FEEDBACK_SPOKEN");
        PackageManager r101 = r210.getPackageManager();
        if (r101 == null) goto L5;
        List<ResolveInfo> r102 = r101.queryIntentServices(r100, 0);
    L6:
        if (r102 != null) goto L8;
        return false;
    L8:
        if (r102.size() > 0) goto L10;
        return false;
    L10:
        Iterator<ResolveInfo> r103 = r102.iterator();
        boolean r104 = false;
    L12:
        if (r103.hasNext() == false) goto L53;
        ResolveInfo r105 = r103.next();
        String r106 = r105.serviceInfo.packageName;
        if (TextUtils.isEmpty(r106) == false) goto L17;
        r106 = "";
    L17:
        if (r104 == true) goto L50;
        String r107 = (r106 + HTTP.URL_DEFAULT) + StringsKt.removePrefix(r105.serviceInfo.name, r106);
        if (("accessibilityScreenReaderService:" + r107) == null) goto L21;
        Context r108 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L21:
        TextUtils.SimpleStringSplitter r109 = new TextUtils.SimpleStringSplitter(':');
        ContentResolver r110 = r210.getApplicationContext().getContentResolver();
        f06.c r111 = new f06.c();
        int r112 = 2;
        Object[] r113 = {r110, "enabled_accessibility_services"};
        f06.b r114 = new f06.b();
        f06.d r115 = r111.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r113, "java.lang.String", r114);
        if (r115.f474982a == false) goto L24;
        r111.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r113, null, r114, false);
        String r116 = (String) r115.f474983b;
    L26:
        if (("settingValue = " + r116) == null) goto L28;
        Context r117 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L28:
        if (r116 == null) goto L46;
        r109.setString(r116);
    L31:
        if (r109.hasNext() == false) goto L46;
        String r118 = r109.next();
        if (("accessibilityService = " + r118) == null) goto L35;
        Context r119 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L35:
        List r120 = StringsKt.split$default(r118, new String[]{HTTP.URL_DEFAULT}, false, 0, 6, null);
        if (r120.size() < r112) goto L41;
        String r121 = StringsKt.replace$default((String) ListProtector.get(r120, 1), r106, HTTP.URL_DEFAULT, false, 4, null);
        if (Intrinsics.areEqual(r107, ((String) ListProtector.get(r120, 0)) + r121) == true) goto L44;
        String r122 = r118;
    L43:
        if (StringsKt.equals(r122, r107, true) == true) goto L44;
        r112 = 2;
    L44:
        boolean r123 = true;
    L47:
        if (r123 == true) goto L50;
        r104 = false;
    L51:
        if (r104 == false) goto L12;
        return true;
    L41:
        r122 = r118;
    L46:
        r123 = false;
        goto L47
    L24:
        r116 = Settings.Secure.getString(r110, "enabled_accessibility_services");
        r111.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r113, r116, r114, true);
    L50:
        r104 = true;
        goto L51
    L53:
        return r104;
    L5:
        r102 = null;
        goto L6
    }

    public static void c(Context r100, AccessibilityManager.AccessibilityStateChangeListener r101, AccessibilityManager.TouchExplorationStateChangeListener r102) {
        Object r103 = r100.getSystemService("accessibility");     // Catch: Exception -> L11
        if ((r103 instanceof AccessibilityManager) == true) goto L5;
        r103 = null;
    L5:
        AccessibilityManager r104 = (AccessibilityManager) r103;     // Catch: Exception -> L11
        if (r104 == null) goto L8;
        r104.addAccessibilityStateChangeListener(r101);     // Catch: Exception -> L11
    L8:
        if (r104 == null) goto L22;
        r104.addTouchExplorationStateChangeListener(r102);     // Catch: Exception -> L11
        return;
    L22:
        return;
    L11:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L16;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L16:
        if (("observerAccessibilityServiceState exception occur " + e.getMessage()) == null) goto L18;
        Context r106 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L18:
        Unit r107 = Unit.INSTANCE;
    }
}
