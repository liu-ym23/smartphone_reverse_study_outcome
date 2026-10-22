package com.obric.autogui.platforms.tools.internal;

import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: ReflectiveFieldHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final String TAG = "ReflectiveFieldHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f30342a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Class<?> f30343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Field f30345d;

    /* JADX INFO: compiled from: ReflectiveFieldHelper.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        f30342a = new a(null);
    }

    public b(Class<?> r2, String r3) {
        o.e(r2, "clazz");
        o.e(r3, "fieldName");
        this.f30343b = r2;
        this.f30344c = r3;
    }

    public final <T> T a(Object r5) {
        Field r0 = a();
        if (r0 != null) goto L15;
        return null;
    L15:
    L12:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to get field: " + this.f30344c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return null;
    L6:
        if (r0.isAccessible() == true) goto L8;
        r0.setAccessible(true);     // Catch: Exception -> L12
    L8:
        T r4 = (T) r0.get(r5);
        if (r4 != null) goto L17;
        return null;
    L17:
        return r4;
    }

    public final void a(Object r3, Object r4) {
        Field r0 = a();
        if (r0 != null) goto L13;
        return;
    L13:
    L10:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Failed to set field: " + this.f30344c, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));
        return;
    L6:
        if (r0.isAccessible() == true) goto L8;
        r0.setAccessible(true);     // Catch: Exception -> L10
    L8:
        r0.set(r3, r4);     // Catch: Exception -> L10
    }

    private final synchronized Field a() {
        monitor-enter(this);
        Field r0 = this.f30345d;     // Catch: Throwable -> L19
        if (r0 == null) goto L7;
        monitor-exit(this);
        return r0;
    L7:
        Class<?> r1 = this.f30343b;     // Catch: Throwable -> L19
    L8:
        if (r1 == null) goto L15;
        Field r2 = r1.getDeclaredField(this.f30344c);     // Catch: Exception -> L12 NoSuchFieldException -> L14 Throwable -> L19
        this.f30345d = r2;     // Catch: Exception -> L12 NoSuchFieldException -> L14 Throwable -> L19
    L10:
        monitor-exit(this);
        return r2;
    L14:
        r1 = r1.getSuperclass();     // Catch: Throwable -> L19
    L12:
        e = move-exception;
        Loog.INSTANCE.e(TAG, "Error looking up field: " + this.f30344c + " in " + r1.getName(), (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L19
    L15:
        Loog.INSTANCE.e(TAG, "Field not found: " + this.f30344c + " in hierarchy of " + this.f30343b.getName());     // Catch: Throwable -> L19
        monitor-exit(this);
        return null;
    L19:
        th = move-exception;
        throw th;
    }
}
