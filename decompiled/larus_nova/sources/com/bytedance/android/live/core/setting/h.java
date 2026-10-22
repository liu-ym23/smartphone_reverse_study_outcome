package com.bytedance.android.live.core.setting;

import android.content.SharedPreferences;
import com.bytedance.android.livesdkapi.setting.HostSettingKey;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SharedPreferences f65310a;

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final <T> T a(HostSettingKey r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "defaultValue");
        if (f65310a == null) goto L5;
    L7:
        SharedPreferences r102 = f65310a;
        if (r102 == null) goto L33;
        String r103 = r100.getKey();
        if ((r101 instanceof Boolean) == false) goto L15;
        return (T) Boolean.valueOf(r102.getBoolean(r103, ((Boolean) r101).booleanValue()));
    L15:
        if ((r101 instanceof Integer) == false) goto L19;
        return (T) Integer.valueOf(r102.getInt(r103, ((Integer) r101).intValue()));
    L19:
        if ((r101 instanceof Long) == false) goto L23;
        return (T) Long.valueOf(r102.getLong(r103, ((Long) r101).longValue()));
    L23:
        if ((r101 instanceof Float) == false) goto L27;
        return (T) Float.valueOf(r102.getFloat(r103, ((Float) r101).floatValue()));
    L27:
        if ((r101 instanceof String) == false) goto L33;
        T r104 = (T) r102.getString(r103, (String) r101);
        if (r104 == null) goto L32;
        return r104;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Exception -> L34
    L33:
        return r101;
    L5:
        if (jc1.a.b() == null) goto L7;
        f65310a = jc1.a.b().getSharedPreferences("ttlive_open_sdk_shared_pref_cache_host", 0);
        goto L7
    }
}
