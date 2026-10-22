package com.bytedance.platform.godzilla.b;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: FieldUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<String, Field> f9065a = null;

    static {
        f9065a = new HashMap();
    }

    private static String b(Class<?> r2, String r3) {
        StringBuilder r0 = new StringBuilder();
        r0.append(r2.toString()).append("#").append(r3);
        return r0.toString();
    }

    public static Field a(Class<?> r6, String r7) {
        Class<?> r8 = (Class) ZeusTransformUtils.preCheckCast(f.a(r6, "The class must not be null"), Class.class, "com.obric.aiagent.plugin");
        f.a(!TextUtils.isEmpty(r7), "The field name must not be blank");
        String r0 = b(r8, r7);
        Map<String, Field> r2 = f9065a;
        monitor-enter(r2);
        Field r3 = (Field) ZeusTransformUtils.preCheckCast(r2.get(r0), Field.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L36
        monitor-exit(r2);     // Catch: Throwable -> L36
        if (r3 != null) goto L8;
    L11:
        if (r8 == null) goto L34;
    L33:
        r8 = r8.getSuperclass();
        goto L11
    L13:
        if (e.a() == true) goto L15;
    L19:
        Field r4 = r8.getDeclaredField(r7);     // Catch: NoSuchFieldException -> L33
    L20:
        if (r4 == null) goto L32;
        if (r4.isAccessible() == true) goto L24;
        r4.setAccessible(true);     // Catch: NoSuchFieldException -> L33
    L24:
        Map<String, Field> r5 = f9065a;     // Catch: NoSuchFieldException -> L33
        monitor-enter(r5);     // Catch: NoSuchFieldException -> L33
        r5.put(r0, r4);     // Catch: Throwable -> L29
        monitor-exit(r5);     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: NoSuchFieldException -> L33
    L32:
        return r4;
    L15:
        if (c.a() == null) goto L19;
        r4 = c.a().a(r8, r7);     // Catch: NoSuchFieldException -> L33
        if (r4 != null) goto L20;
        r4 = r8.getDeclaredField(r7);     // Catch: NoSuchFieldException -> L33
        goto L20
    L34:
        return null;
    L8:
        if (r3.isAccessible() == true) goto L10;
        r3.setAccessible(true);
    L10:
        return r3;
    L36:
        th = move-exception;
        throw th;
    }
}
