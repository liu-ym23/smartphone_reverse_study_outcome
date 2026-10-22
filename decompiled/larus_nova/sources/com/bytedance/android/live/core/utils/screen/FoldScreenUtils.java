package com.bytedance.android.live.core.utils.screen;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import j40.s3;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import r80.l;

/* JADX INFO: loaded from: classes45.dex */
public final class FoldScreenUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static IMiddleWareHostContext f66393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f66394b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Boolean f66395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f66396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Boolean f66397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, b> f66398f = null;

    static {
        f66393a = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
        f66394b = new l();
        f66395c = null;
        f66396d = false;
        f66397e = null;
        f66398f = new AnonymousClass1();
    }

    public static String d() {
        return Build.MANUFACTURER.toUpperCase().trim();
    }

    public static boolean f() {
        Boolean r100 = f66397e;
        if (r100 == Boolean.TRUE) goto L5;
    L10:
        if (r100 != null) goto L13;
        f66397e = s3.f497298a.getValue();
    L13:
        if (f66396d == false) goto L17;
        ALogger.i("FoldScreenUtils", "New API:Is fold screen " + f66395c);
        return f66395c.booleanValue();
    L17:
        if (f66393a != null) goto L19;
        f66393a = (IMiddleWareHostContext) k.f(IMiddleWareHostContext.class);
    L19:
        IMiddleWareHostContext r101 = f66393a;
        if (r101 == null) goto L23;
        f66395c = Boolean.valueOf(r101.isFoldDevice());
        f66396d = true;
        ALogger.i("FoldScreenUtils", "New API:Is fold screen " + f66395c);
        return f66395c.booleanValue();
    L23:
        String r102 = Build.MANUFACTURER.toUpperCase().trim();
        Map<String, b> r103 = f66398f;
        b r104 = (b) ((HashMap) r103).get(r102);
        if (r104 != null) goto L26;
        r104 = (b) ((HashMap) r103).get("default_manufacture");
    L26:
        if (r104 != null) goto L30;
        return false;
    L30:
        return r104.isFoldScreen();
    L5:
        if (f66396d == false) goto L10;
        Boolean r105 = f66395c;
        if (r105 == null) goto L10;
        return r105.booleanValue();
    }

    public static int a() {
        Resources r100 = s1.getResources();
        if (r100 != null) goto L7;
        return -1;
    L7:
        return b(s1.getContext(), r100.getConfiguration());
    }

    public static boolean e() {
        if (f() == true) goto L5;
    L7:
        return false;
    L5:
        if (a() != 0) goto L7;
        return true;
    }

    public static int c(Configuration r100) {
        if (r100 != null) goto L6;
        return a();
    L6:
        return b(s1.getContext(), r100);
    }

    public static int b(Context r100, Configuration r101) {
        if (f66397e == Boolean.TRUE) goto L5;
    L7:
        l r102 = f66394b;
        if (r102 != null) goto L10;
        String r103 = Build.MANUFACTURER.toUpperCase().trim();
        HashMap r104 = (HashMap) f66398f;
        b r105 = (b) r104.get(r103);
        if (r105 != null) goto L14;
        r105 = (b) r104.get("default_manufacture");
    L14:
        if (r105 != null) goto L17;
        return -1;
    L17:
        return r105.a(r101);
    L10:
        return r102.a(r101);
    L5:
        if (f() == true) goto L7;
        return -1;
    }
}
