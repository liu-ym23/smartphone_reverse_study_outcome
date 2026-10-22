package com.bytedance.android.ec.core.abtest;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f43638a = null;

    public c() {
    }

    static {
        f43638a = new c();
    }

    public static String a(yf7.j.a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Object r101 = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L43
        Method[] r103 = r100.getClass().getMethods();     // Catch: Throwable -> L43
        int r104 = r103.length;     // Catch: Throwable -> L43
        int r105 = 0;
        int r106 = 0;
    L5:
        if (r106 >= r104) goto L18;
        Method r107 = r103[r106];     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r107.getName(), "getMsgId") == true) goto L9;
    L14:
        boolean r108 = false;
    L15:
        if (r108 == true) goto L19;
        r106 = r106 + 1;     // Catch: Throwable -> L43
    L19:
        if (r107 == null) goto L21;
        Object r109 = r107.invoke(r100, new Object[0]);     // Catch: Throwable -> L43
    L23:
        if ((r109 instanceof String) == false) goto L25;
        String r110 = (String) r109;     // Catch: Throwable -> L43
    L41:
        Object r111 = Result.m9449constructorimpl(r110);     // Catch: Throwable -> L43
    L46:
        if (Result.m9455isFailureimpl(r111) == true) goto L50;
        r101 = r111;
    L50:
        return (String) r101;
    L25:
        Field[] r112 = yf7.j.a.class.getDeclaredFields();     // Catch: Throwable -> L43
        int r113 = r112.length;     // Catch: Throwable -> L43
    L26:
        if (r105 >= r113) goto L31;
        Field r114 = r112[r105];     // Catch: Throwable -> L43
        if (Intrinsics.areEqual(r114.getName(), RemoteMessageConst.MSGID) == true) goto L32;
        r105 = r105 + 1;     // Catch: Throwable -> L43
    L32:
        if (r114 == null) goto L34;
        r114.setAccessible(true);     // Catch: Throwable -> L43
    L34:
        if (r114 == null) goto L36;
        Object r115 = r114.get(r100);     // Catch: Throwable -> L43
    L38:
        if ((r115 instanceof String) == true) goto L40;
        r115 = null;
    L40:
        r110 = (String) r115;     // Catch: Throwable -> L43
        goto L41
    L36:
        r115 = null;
        goto L38
    L31:
        r114 = null;
        goto L32
    L21:
        r109 = null;
        goto L23
    L9:
        if (r107.getParameterTypes().length != 0) goto L11;
        boolean r116 = true;
    L12:
        if (r116 == false) goto L14;
        r108 = true;
        goto L15
    L11:
        r116 = false;
        goto L12
    L18:
        r107 = null;
    L43:
        th = move-exception;
        Result.Companion r117 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L46
    }
}
