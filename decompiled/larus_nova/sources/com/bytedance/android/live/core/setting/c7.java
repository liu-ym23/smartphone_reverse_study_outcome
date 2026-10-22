package com.bytedance.android.live.core.setting;

import android.app.Application;
import android.content.Context;
import com.bytedance.android.live.core.setting.v2.update.SettingIncStrategy;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import io.reactivex.subjects.PublishSubject;
import java.lang.reflect.Type;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public final class c7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f65275a = 0;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.app.ActivityThread");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.app.ActivityThread");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.app.ActivityThread");
    }

    public static Context getContext() {
        if (d6.b() != null) goto L11;
        return (Application) a().getMethod("currentApplication", new Class[0]).invoke(null, null);
    L7:
        e = move-exception;
        d7.a("reflection application failed", e);
        return null;
    L11:
        return d6.b();
    }

    static {
        PublishSubject.create();
    }

    public static String c(SettingKey r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        v60.a r101 = v60.a.f553369a;
        Object r102 = v60.a.h(r100.getName(), r100.getDefaultValue(), r100.getType());
        if (r102 != null) goto L8;
        return null;
    L8:
        return GsonProtectorUtils.toJson(t6.f65418a, r102);
    }

    public static Object d(String r100) {
        if (SettingUtil.isLocalTest() == false) goto L8;
        v60.a r101 = v60.a.f553369a;
        Intrinsics.checkNotNullParameter(r100, "key");
        if (SettingIncStrategy.f65434a.a(r100) == false) goto L8;
        return b(v60.a.g(r100), r100);
    L8:
        v60.a r102 = v60.a.f553369a;
        return b(v60.a.e(r100), r100);
    }

    public static Object b(Object r100, String r101) {
        v60.a r102 = v60.a.f553369a;     // Catch: Exception -> L16
        Object r103 = v60.a.e("__origin_Type__" + r101);     // Catch: Exception -> L16
        if ((r103 instanceof Integer) == true) goto L6;
    L15:
        return r100;
    L6:
        if ((r100 instanceof String) == false) goto L15;
        int r104 = ((Integer) r103).intValue();     // Catch: Exception -> L16
        if (r104 != 0) goto L12;
        return new JSONObject(String.valueOf(r100));
    L12:
        if (r104 != 1) goto L15;
        return new JSONArray(String.valueOf(r100));
    L16:
        e = move-exception;
        d6.a("SettingCache", e);
        return r100;
    }

    public static Object e(String r100, Type r101, Object r102, boolean r110, boolean r111) {
        if (r111 == false) goto L5;
        v60.a r103 = v60.a.f553369a;
        int r104 = d6.f65283a;
        return v60.a.i(r100, r101, wa1.d.f558804b);
    L5:
        v60.a r105 = v60.a.f553369a;
        int r112 = d6.f65283a;
        return r105.k(r100, r102, r101, r110, wa1.d.f558804b, false);
    }
}
