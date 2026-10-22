package com.bytedance.android.ec.core.utils;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f45549a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.utils.a$a, reason: collision with other inner class name */
    public interface InterfaceC0810a {
        void a(AccessibilityNodeInfoCompat r100);
    }

    public static boolean c() {
        Context r100 = ECAppInfoService.f48114e.getApplicationContext();
        if (r100 != null) goto L15;
        return false;
    L15:
        Object r101 = r100.getSystemService("accessibility");     // Catch: Throwable -> L14
        if (r101 == null) goto L12;
        boolean r102 = ((AccessibilityManager) r101).isEnabled();     // Catch: Throwable -> L14
        boolean r103 = e(r100);     // Catch: Throwable -> L14
        if (r102 == false) goto L13;
        if (r103 == true) goto L17;
        return false;
    L17:
        return true;
    L13:
        return false;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");     // Catch: Throwable -> L14
    L18:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        switch(r100.hashCode()) {
            case -1377687758: goto L15;
            case 3556653: goto L12;
            case 100313435: goto L9;
            case 100358090: goto L6;
            default: goto L17;
        };
    L17:
        return null;
    L6:
        if (r100.equals("input") == false) goto L17;
        return AndroidComposeViewAccessibilityDelegateCompat.TextFieldClassName;
    L9:
        if (r100.equals("image") == false) goto L17;
        return "android.widget.ImageView";
    L12:
        if (r100.equals("text") == false) goto L17;
        return AndroidComposeViewAccessibilityDelegateCompat.TextClassName;
    L15:
        if (r100.equals("button") == false) goto L17;
        return "android.widget.Button";
    }

    public static boolean e(Context r110) {
        Intent r100 = new Intent("android.accessibilityservice.AccessibilityService");
        r100.addCategory("android.accessibilityservice.category.FEEDBACK_SPOKEN");
        boolean r101 = false;
        List<ResolveInfo> r102 = r110.getPackageManager().queryIntentServices(r100, 0);
        if (r102 != null) goto L5;
    L40:
        return false;
    L5:
        if (r102.size() <= 0) goto L40;
        if (Build.VERSION.SDK_INT < 26) goto L24;
        Iterator<ResolveInfo> r103 = r102.iterator();
        boolean r104 = false;
    L11:
        if (r103.hasNext() == false) goto L50;
        ServiceInfo r105 = r103.next().serviceInfo;
        String r111 = r105.packageName;
        String r106 = r105.name;
        if (StringsKt.indexOf$default(r106, r111, 0, false, 6, null) < 0) goto L15;
        String r107 = StringsKt.replace$default(r106, r111, "", false, 4, null);
    L17:
        if (d(r110, r111 + '/' + r106) == false) goto L19;
    L22:
        boolean r108 = true;
    L23:
        r104 = r104 | r108;
        goto L11
    L19:
        if (d(r110, r111 + '/' + r107) == true) goto L22;
        r108 = false;
        goto L23
    L15:
        r107 = "";
        goto L17
    L50:
        return r104;
    L24:
        ArrayList r109 = new ArrayList();
        Object r112 = r110.getSystemService("activity");
        if (r112 == null) goto L39;
        Iterator<ActivityManager.RunningServiceInfo> r113 = ((ActivityManager) r112).getRunningServices(Integer.MAX_VALUE).iterator();
    L28:
        if (r113.hasNext() == false) goto L30;
        r109.add(r113.next().service.getPackageName());
        goto L28
    L30:
        Iterator<ResolveInfo> r114 = r102.iterator();
    L32:
        if (r114.hasNext() == false) goto L37;
        if (r109.contains(r114.next().serviceInfo.packageName) == false) goto L32;
        r101 = r101 | true;
        goto L32
    L37:
        return r101;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @JvmStatic
    public static final void f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        r100.setFocusable(0);
        r100.setImportantForAccessibility(2);
        return;
    }

    @JvmStatic
    public static final void a(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$enableViewAccessibility");
        if (r101 == false) goto L6;
        r100.setImportantForAccessibility(1);
    L10:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        r100.setFocusable(r101 ? 1 : 0);
        return;
    L13:
        return;
    L6:
        if ((r100 instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r100).setImportantForAccessibility(4);
        goto L10
    L8:
        r100.setImportantForAccessibility(2);
        goto L10
    }

    public static boolean d(Context r110, String r111) {
        TextUtils.SimpleStringSplitter r100 = new TextUtils.SimpleStringSplitter(':');
        ContentResolver r101 = r110.getApplicationContext().getContentResolver();
        f06.c r112 = new f06.c();
        Object[] r113 = {r101, "enabled_accessibility_services"};
        f06.b r114 = new f06.b();
        f06.d r102 = r112.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r113, "java.lang.String", r114);
        if (r102.f474982a == false) goto L5;
        r112.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r113, null, r114, false);
        String r103 = (String) r102.f474983b;
    L6:
        if (r103 == null) goto L13;
        r100.setString(r103);
    L9:
        if (r100.hasNext() == false) goto L13;
        if (StringsKt.equals(r100.next(), r111, true) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        r103 = Settings.Secure.getString(r101, "enabled_accessibility_services");
        r112.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r113, r103, r114, true);
        goto L6
    }
}
