package com.bytedance.android.live.v3;

import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f102583b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f102584a;

    public static final class a {
    }

    static {
        f102583b = new Regex("\\s");
    }

    public d() {
        this.f102584a = new ConcurrentHashMap();
    }

    public final String a(String r110) {
        Intrinsics.checkNotNullParameter(r110, "str");
        String r100 = this.f102584a.get(r110);
        if (r100 == null) goto L5;
        return r100;
    L5:
        System.nanoTime();
        StringBuilder r101 = new StringBuilder(r110.length());
        char[] r102 = new char[r110.length()];
        int r103 = r110.length();
        int r104 = -1;
        int r105 = 0;
        boolean r106 = false;
    L6:
        if (r105 >= r103) goto L37;
        if (r106 == false) goto L9;
        r106 = false;
    L36:
        r105 = r105 + 1;
        goto L6
    L9:
        char r107 = r110.charAt(r105);
        if (r107 == '&') goto L28;
        if (r107 == '|') goto L22;
        if (r107 != '(') goto L14;
        r104 = r104 + 1;
        r102[r104] = r107;
        goto L36
    L14:
        if (r107 == ')') goto L16;
        r101.append(r107);
    L16:
        if (r104 < 0) goto L36;
        int r108 = r104 - 1;
        char r109 = r102[r104];
        if (r109 == '(') goto L19;
        r101.append(r109);
        r104 = r108;
        goto L16
    L19:
        r104 = r108;
    L22:
        if (r104 < 0) goto L27;
        int r111 = r104 - 1;
        char r112 = r102[r104];
        if (r112 == '(') goto L25;
        r101.append(r112);
        r104 = r111;
        goto L22
    L25:
        int r113 = r111 + 1;
        r102[r113] = r112;
        r104 = r113;
    L27:
        r104 = r104 + 1;
        r102[r104] = r107;
    L35:
        r106 = true;
    L28:
        if (r104 < 0) goto L34;
        char r114 = r102[r104];
        if (r114 == '(') goto L34;
        if (r114 == '|') goto L34;
        r104 = r104 - 1;
        r101.append(r114);
    L34:
        r104 = r104 + 1;
        r102[r104] = r107;
    L37:
        if (r104 < 0) goto L39;
        r101.append(r102[r104]);
        r104 = r104 - 1;
        goto L37
    L39:
        String r115 = f102583b.replace(r101.toString(), "");
        this.f102584a.put(r110, r115);
        return r115;
    }

    public static boolean b(String r100, Function1 r110) {
        Intrinsics.checkNotNullParameter(r100, "suffix");
        Intrinsics.checkNotNullParameter(r110, NotificationCompat.CATEGORY_CALL);
        boolean[] r101 = new boolean[r100.length()];
        HashMap r102 = new HashMap(16);
        int r103 = r100.length();
        int r104 = -1;
        int r105 = 0;
    L3:
        if (r105 >= r103) goto L31;
        char r106 = r100.charAt(r105);
        if (r106 != '&') goto L7;
        if (r104 < 1) goto L22;
        int r107 = r104 - 1;
        boolean r108 = r101[r104];
        int r109 = r107 - 1;
        if (r101[r107] == false) goto L27;
        if (r108 == false) goto L27;
        boolean r111 = true;
    L28:
        int r112 = r109 + 1;
        r101[r112] = r111;
    L29:
        r104 = r112;
    L30:
        r105 = r105 + 1;
    L27:
        r111 = false;
        goto L28
    L22:
        return false;
    L7:
        if (r106 == '|') goto L12;
        Boolean r113 = (Boolean) r102.get(Character.valueOf(r106));
        if (r113 != null) goto L11;
        boolean r114 = ((Boolean) r110.invoke(String.valueOf(r106))).booleanValue();
        r102.put(Character.valueOf(r106), Boolean.valueOf(r114));
        r113 = Boolean.valueOf(r114);
    L11:
        r104 = r104 + 1;
        r101[r104] = r113.booleanValue();
        goto L30
    L12:
        if (r104 < 1) goto L13;
        int r115 = r104 - 1;
        boolean r116 = r101[r104];
        int r117 = r115 - 1;
        if (r101[r115] == true) goto L19;
        if (r116 == true) goto L19;
        boolean r118 = false;
    L20:
        r112 = r117 + 1;
        r101[r112] = r118;
    L19:
        r118 = true;
        goto L20
    L13:
        return false;
    L31:
        if (r104 == 0) goto L33;
        return false;
    L33:
        return r101[0];
    }
}
