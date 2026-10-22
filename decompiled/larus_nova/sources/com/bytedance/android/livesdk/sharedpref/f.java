package com.bytedance.android.livesdk.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdkapi.depend.prefs.Property;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.google.gson.Gson;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SharedPreferences f158359a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, Object> f158360b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Gson f158361c = null;

    static {
        f158359a = getContext().getSharedPreferences("live_sdk_core", 0);
        f158360b = new HashMap();
        Gson r100 = x60.b.f562576a;
        f158361c = x60.b.f562576a;
    }

    public static Context getContext() {
        return jc1.a.b();
    }

    public static <T> T b(Property<T> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (getContext() != null) goto L8;
        return null;
    L8:
        Map<String, Object> r101 = f158360b;
        if (((HashMap) r101).containsKey(r100.getName()) == false) goto L13;
        return (T) ((HashMap) r101).get(r100.getName());
    L13:
        if (f158359a.contains(r100.getName()) == false) goto L15;
        rm0.a r102 = om0.c.e();
        if (r102 != null) goto L19;
    L21:
        boolean r103 = false;
    L22:
        pm0.a r104 = om0.c.c();
        if (r104 == null) goto L32;
        if (r103 == false) goto L32;
        if (ThreadMethodProxy.currentThread() != ThreadMethodProxy.getLooperThread(Looper.getMainLooper())) goto L32;
        r104.w("WatchDog", "Access PluginProperty on UI thread but cache missed: " + r100.getName());
    L32:
        return (T) c(r100);
    L31:
        return (T) a(r100.getName(), r100.getType(), r100.getDefaultValue());
    L19:
        if (r102.isLocalTest() == false) goto L21;
        r103 = true;
        goto L22
    L15:
        return r100.getDefaultValue();
    }

    public static <T> T c(Property<T> r100) {
        boolean r101 = false;
        int r102 = 0;
        if (r100.getType() == Boolean.class) goto L106;
        if (r100.getType() == Boolean.TYPE) goto L106;
        if (r100.getType() == Integer.class) goto L92;
        if (r100.getType() == Short.class) goto L92;
        if (r100.getType() == Integer.TYPE) goto L92;
        if (r100.getType() == Short.TYPE) goto L92;
        if (r100.getType() == Float.class) goto L78;
        if (r100.getType() == Float.TYPE) goto L78;
        if (r100.getType() == Long.class) goto L64;
        if (r100.getType() == Long.TYPE) goto L64;
        if (r100.getType() == Double.class) goto L44;
        if (r100.getType() == Double.TYPE) goto L44;
        if (r100.getType() != String.class) goto L42;
        String r103 = r100.getName();
        String r104 = (T) ((String) r100.getDefaultValue());
        Object r105 = r104;
        if (getContext() == null) goto L37;
        r105 = (T) f158359a.getString(r103, r104);
    L37:
        if (r105 != null) goto L39;
        Map<String, Object> r106 = f158360b;
        HashMap r107 = (HashMap) r106;
        r107.remove(r100.getName());
    L40:
        return (T) r105;
    L39:
        Map<String, Object> r108 = f158360b;
        HashMap r109 = (HashMap) r108;
        r109.put(r100.getName(), r105);
        goto L40
    L42:
        return (T) a(r100.getName(), r100.getType(), r100.getDefaultValue());
    L44:
        if (r100.getDefaultValue() != null) goto L53;
        String r110 = r100.getName();
        Context r111 = getContext();
        double r112 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (r111 != null) goto L119;
    L52:
        T r113 = (T) Double.valueOf(r112);
    L61:
        Map<String, Object> r114 = f158360b;
        HashMap r115 = (HashMap) r114;
        r115.put(r100.getName(), r113);
        return r113;
    L119:
        r112 = CastDoubleProtector.parseDouble(f158359a.getString(r110, String.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)));     // Catch: Exception -> L50
    L50:
        e = move-exception;
        e.printStackTrace();
        goto L52
    L53:
        String r116 = r100.getName();
        double r117 = ((Double) r100.getDefaultValue()).doubleValue();
        if (getContext() != null) goto L121;
    L60:
        r113 = (T) Double.valueOf(r117);
        goto L61
    L121:
        r117 = CastDoubleProtector.parseDouble(f158359a.getString(r116, String.valueOf(r117)));     // Catch: Exception -> L58
    L58:
        e = move-exception;
        e.printStackTrace();
    L64:
        if (r100.getDefaultValue() != null) goto L70;
        String r118 = r100.getName();
        long r119 = 0;
        if (getContext() == null) goto L69;
        r119 = f158359a.getLong(r118, 0);
    L69:
        T r120 = (T) Long.valueOf(r119);
    L75:
        Map<String, Object> r121 = f158360b;
        HashMap r122 = (HashMap) r121;
        r122.put(r100.getName(), r120);
        return r120;
    L70:
        String r123 = r100.getName();
        long r124 = ((Long) r100.getDefaultValue()).longValue();
        if (getContext() == null) goto L74;
        r124 = f158359a.getLong(r123, r124);
    L74:
        r120 = (T) Long.valueOf(r124);
    L78:
        if (r100.getDefaultValue() != null) goto L84;
        String r125 = r100.getName();
        float r126 = 0.0f;
        if (getContext() == null) goto L83;
        r126 = f158359a.getFloat(r125, 0.0f);
    L83:
        T r127 = (T) Float.valueOf(r126);
    L89:
        Map<String, Object> r128 = f158360b;
        HashMap r129 = (HashMap) r128;
        r129.put(r100.getName(), r127);
        return r127;
    L84:
        String r130 = r100.getName();
        float r131 = ((Float) r100.getDefaultValue()).floatValue();
        if (getContext() == null) goto L88;
        r131 = f158359a.getFloat(r130, r131);
    L88:
        r127 = (T) Float.valueOf(r131);
    L92:
        if (r100.getDefaultValue() != null) goto L98;
        String r132 = r100.getName();
        if (getContext() == null) goto L97;
        r102 = f158359a.getInt(r132, 0);
    L97:
        T r133 = (T) Integer.valueOf(r102);
    L103:
        Map<String, Object> r134 = f158360b;
        HashMap r135 = (HashMap) r134;
        r135.put(r100.getName(), r133);
        return r133;
    L98:
        String r136 = r100.getName();
        int r137 = ((Integer) r100.getDefaultValue()).intValue();
        if (getContext() == null) goto L102;
        r137 = f158359a.getInt(r136, r137);
    L102:
        r133 = (T) Integer.valueOf(r137);
    L106:
        if (r100.getDefaultValue() != null) goto L112;
        String r138 = r100.getName();
        if (getContext() == null) goto L111;
        r101 = f158359a.getBoolean(r138, false);
    L111:
        T r139 = (T) Boolean.valueOf(r101);
    L117:
        Map<String, Object> r140 = f158360b;
        HashMap r141 = (HashMap) r140;
        r141.put(r100.getName(), r139);
        return r139;
    L112:
        String r142 = r100.getName();
        boolean r143 = ((Boolean) r100.getDefaultValue()).booleanValue();
        if (getContext() == null) goto L116;
        r143 = f158359a.getBoolean(r142, r143);
    L116:
        r139 = (T) Boolean.valueOf(r143);
        goto L117
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void d(Property r100, T r101) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (getContext() != null) goto L7;
        return;
    L7:
        if (r101 != 0) goto L10;
        Map<String, Object> r102 = f158360b;
        HashMap r103 = (HashMap) r102;
        r103.remove(r100.getName());
        f158359a.edit().remove(r100.getName()).apply();
        return;
    L10:
        Map<String, Object> r104 = f158360b;
        HashMap r105 = (HashMap) r104;
        r105.put(r100.getName(), r101);
        if (r100.getType() != Boolean.class) goto L13;
    L49:
        f158359a.edit().putBoolean(r100.getName(), ((Boolean) r101).booleanValue()).apply();
        return;
    L13:
        if (r100.getType() == Boolean.TYPE) goto L49;
        if (r100.getType() != Integer.class) goto L18;
    L47:
        f158359a.edit().putInt(r100.getName(), ((Integer) r101).intValue()).apply();
        return;
    L18:
        if (r100.getType() == Integer.TYPE) goto L47;
        if (r100.getType() != Float.class) goto L23;
    L45:
        f158359a.edit().putFloat(r100.getName(), ((Float) r101).floatValue()).apply();
        return;
    L23:
        if (r100.getType() == Float.TYPE) goto L45;
        if (r100.getType() != Long.class) goto L28;
    L43:
        f158359a.edit().putLong(r100.getName(), ((Long) r101).longValue()).apply();
        return;
    L28:
        if (r100.getType() == Long.TYPE) goto L43;
        if (r100.getType() != Double.class) goto L33;
    L41:
        f158359a.edit().putString(r100.getName(), r101.toString()).apply();
        return;
    L33:
        if (r100.getType() == Double.TYPE) goto L41;
        if (r100.getType() != String.class) goto L39;
        f158359a.edit().putString(r100.getName(), (String) r101).apply();
        return;
    L39:
        f158359a.edit().putString(r100.getName(), GsonProtectorUtils.toJson(f158361c, r101)).apply();
    }

    public static <T> T a(String r100, Type r101, T r102) {
        Map<String, Object> r103 = f158360b;     // Catch: Exception -> L11
        if (((HashMap) r103).containsKey(r100) == true) goto L5;
        String r104 = f158359a.getString(r100, "");     // Catch: Exception -> L11
        T r105 = (T) f158361c.fromJson(r104, r101);
        if (r105 != null) goto L9;
        ((HashMap) r103).remove(r100);     // Catch: Exception -> L11
    L10:
        return r105;
    L9:
        ((HashMap) r103).put(r100, r105);     // Catch: Exception -> L11
        goto L10
    L5:
        return (T) ((HashMap) r103).get(r100);
    L11:
        e = move-exception;
        e.printStackTrace();
        ((HashMap) f158360b).remove(r100);
        return r102;
    }
}
