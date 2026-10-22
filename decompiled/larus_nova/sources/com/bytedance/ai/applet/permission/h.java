package com.bytedance.ai.applet.permission;

import com.bytedance.ai.utils.l;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f34952a = 0;

    static {
    }

    public static String a(String r100) {
        if (r100 != null) goto L4;
    L7:
        boolean r101 = true;
    L8:
        if (r101 == false) goto L11;
        return "权限名称异常，请重试";
    L11:
        if (r100 == null) goto L56;
        switch(r100.hashCode()) {
            case -1750762604: goto L50;
            case -653473286: goto L44;
            case -21617665: goto L38;
            case 411225387: goto L32;
            case 421939912: goto L29;
            case 934308869: goto L23;
            case 1403059833: goto L19;
            case 2106603706: goto L16;
            default: goto L56;
        };
    L16:
        if (r100.equals("scope.userFuzzyLocation") == false) goto L56;
    L46:
        String r102 = l.e(l.f37675a, "larus_appEntry_chatCard_desc_accessLoc");
        if (r102 != null) goto L64;
        return "申请获取你的位置信息";
    L64:
        return r102;
    L19:
        if (r100.equals("scope.addPhoneContact") == false) goto L56;
        return "申请获取你的通讯录读写权限";
    L23:
        if (r100.equals("scope.addPhoneCalendar") == false) goto L56;
        String r103 = l.e(l.f37675a, "larus_appEntry_chatCard_desc_accessCalendar");
        if (r103 != null) goto L58;
        return "申请获取你的日历读写权限";
    L58:
        return r103;
    L29:
        if (r100.equals("scope.userLocationBackground") == false) goto L56;
    L32:
        if (r100.equals("scope.record") == false) goto L56;
        String r104 = l.e(l.f37675a, "larus_appEntry_chatCard_desc_accessMic");
        if (r104 != null) goto L60;
        return "申请获取你的麦克风权限";
    L60:
        return r104;
    L38:
        if (r100.equals("scope.camera") == false) goto L56;
        String r105 = l.e(l.f37675a, "larus_appEntry_chatCard_desc_accessCamera");
        if (r105 != null) goto L62;
        return "申请获取你的相机权限";
    L62:
        return r105;
    L44:
        if (r100.equals("scope.userLocation") == true) goto L46;
    L50:
        if (r100.equals("scope.bluetooth") == false) goto L56;
        String r106 = l.e(l.f37675a, "larus_appEntry_chatCard_desc_accessBluetooth");
        if (r106 != null) goto L66;
        return "申请获取你的蓝牙权限";
    L66:
        return r106;
    L56:
        return "申请你的" + StringsKt.removePrefix(r100, "scope.") + "权限";
    L4:
        if (r100.length() == 0) goto L7;
        r101 = false;
        goto L8
    }

    public static String b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "scopeValue");
        switch(r100.hashCode()) {
            case -1750762604: goto L34;
            case -653473286: goto L30;
            case -21617665: goto L26;
            case 411225387: goto L22;
            case 421939912: goto L18;
            case 934308869: goto L14;
            case 1403059833: goto L10;
            case 2106603706: goto L6;
            default: goto L37;
        };
    L37:
        return null;
    L6:
        if (r100.equals("scope.userFuzzyLocation") == false) goto L37;
        return "android.permission.ACCESS_COARSE_LOCATION";
    L10:
        if (r100.equals("scope.addPhoneContact") == false) goto L37;
        return "android.permission.WRITE_CONTACTS";
    L14:
        if (r100.equals("scope.addPhoneCalendar") == false) goto L37;
        return "android.permission.WRITE_CALENDAR";
    L18:
        if (r100.equals("scope.userLocationBackground") == false) goto L37;
        return "android.permission.ACCESS_BACKGROUND_LOCATION";
    L22:
        if (r100.equals("scope.record") == false) goto L37;
        return "android.permission.RECORD_AUDIO";
    L26:
        if (r100.equals("scope.camera") == false) goto L37;
        return "android.permission.CAMERA";
    L30:
        if (r100.equals("scope.userLocation") == false) goto L37;
        return "android.permission.ACCESS_FINE_LOCATION";
    L34:
        if (r100.equals("scope.bluetooth") == false) goto L37;
        return "android.permission.BLUETOOTH";
    }
}
