package com.bytedance.android.live.liveinteract;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<ss1.e> f72793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f72794b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<SettingKey<?>, Object> f72795c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, String> f72796d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<Integer, Integer> f72797e = null;

    static {
        SettingKey<ss1.e> r100 = new SettingKey("live_interactivity_opt_config", "互动体验优化配置", new ss1.e(), new ss1.e());
        f72793a = r100;
        f72794b = r100.getValue().c();
        f72795c = new HashMap();
        f72796d = new HashMap();
        f72797e = new HashMap();
        new HashMap();
        new HashMap();
    }

    @JvmStatic
    public static final <T> T b(SettingKey<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "setting");
        if (f72794b == false) goto L12;
        Map<SettingKey<?>, Object> r101 = f72795c;
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
    public static final int a(int r100, Function0<Integer> r101) {
        Intrinsics.checkNotNullParameter(r101, "func");
        Integer r102 = Integer.valueOf(r100);
        Map<Integer, Integer> r103 = f72797e;
        if (f72794b == true) goto L5;
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
