package com.bytedance.android.livesdk.interactivity.api.base.utils;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.liveinteract.f;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ss1.e;

/* JADX INFO: loaded from: classes9.dex */
public final class InteractivityOpt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f132908a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f132909b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final boolean f132910c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<SettingKey<?>, Object> f132911d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, Integer> f132912e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<Float, Integer> f132913f = null;

    static {
        e r100 = f.f72793a.getValue();
        boolean r101 = r100.c();
        f132908a = r101;
        boolean r102 = false;
        if (r101 == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        f132909b = r103;
        if (r101 == true) goto L11;
    L13:
        f132910c = r102;
        f132911d = new HashMap();
        new HashMap();
        f132912e = new HashMap();
        new HashMap();
        f132913f = new HashMap();
        return;
    L11:
        if (r100.a() == false) goto L13;
        r102 = true;
        goto L13
    L5:
        if (r100.b() == false) goto L7;
        r103 = true;
        goto L8
    }

    @JvmStatic
    public static final int a(final float r100) {
        Float r101 = Float.valueOf(r100);
        Function0<Integer> r102 = new InteractivityOpt$cachedDp2Px$1(r100);
        Map<Float, Integer> r103 = f132913f;
        if (f132908a == true) goto L5;
        Object r104 = r102.invoke();
    L10:
        return ((Number) r104).intValue();
    L5:
        HashMap r105 = (HashMap) r103;
        Object r106 = r105.get(r101);
        if (r106 != null) goto L8;
        Integer r107 = r102.invoke();
        r105.put(r101, r107);
        r104 = r107;
        goto L10
    L8:
        r104 = r106;
        goto L10
    }

    @JvmStatic
    public static final <T> T c(SettingKey<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "setting");
        if (f132908a == false) goto L12;
        Map<SettingKey<?>, Object> r101 = f132911d;
        Object r102 = ((HashMap) r101).get(r100);
        if ((r102 instanceof Object) == true) goto L8;
        r102 = null;
    L8:
        if (r102 != null) goto L11;
        r102 = r100.getValue();
        ((HashMap) r101).put(r100, r102);
    L11:
        return (T) r102;
    L12:
        return r100.getValue();
    }

    @JvmStatic
    public static final int b(int r100, Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r101, "func");
        Integer r102 = Integer.valueOf(r100);
        Map<Integer, Integer> r103 = f132912e;
        if (f132908a == true) goto L5;
        Object r104 = r101.invoke();
    L10:
        return ((Number) r104).intValue();
    L5:
        HashMap r105 = (HashMap) r103;
        Object r106 = r105.get(r102);
        if (r106 != null) goto L8;
        Integer r107 = r101.invoke();
        r105.put(r102, r107);
        r104 = r107;
        goto L10
    L8:
        r104 = r106;
        goto L10
    }
}
