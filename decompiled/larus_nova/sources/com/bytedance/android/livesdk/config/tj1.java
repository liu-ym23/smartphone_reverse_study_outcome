package com.bytedance.android.livesdk.config;

import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes8.dex */
public final class tj1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f121305a = 0;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int a(int r100, int r101, boolean r102) {
        ReadOnlyProperty r103 = vm2.e.f556044d0;
        KProperty<?>[] r104 = vm2.e.f556037a;
        boolean r105 = false;
        if (((Boolean) r103.getValue(null, r104[54])).booleanValue() == false) goto L19;
        if (r102 == false) goto L16;
        if (r101 != 1) goto L7;
    L13:
        boolean r106 = true;
    L14:
        if (r106 == false) goto L16;
        boolean r107 = true;
    L17:
        if (r107 == false) goto L19;
        boolean r108 = true;
    L20:
        if (r108 == false) goto L33;
        com.bytedance.tools.kcp.spongepreference.runtime.a r109 = com.bytedance.android.livesdk.sharedpref.d.f158357y;
        KProperty<?>[] r110 = com.bytedance.android.livesdk.sharedpref.d.f158327a;
        if (((Boolean) r109.getValue(null, r110[23])).booleanValue() == true) goto L24;
    L30:
        if (r100 != 1) goto L35;
        return 2;
    L35:
        return r100;
    L24:
        if (((Boolean) com.bytedance.android.livesdk.sharedpref.d.f158351s.getValue(null, r110[17])).booleanValue() == false) goto L30;
        if (((Number) vm2.e.f556042c0.getValue(null, r104[53])).intValue() != 2) goto L28;
        r105 = true;
    L28:
        if (r105 == false) goto L30;
        return 1;
    L33:
        return r100;
    L7:
        if (r101 == 8) goto L13;
        if (r101 == 12) goto L13;
        if (r101 == 16) goto L13;
        r106 = false;
    L16:
        r107 = false;
    L19:
        r108 = false;
        goto L20
    }
}
