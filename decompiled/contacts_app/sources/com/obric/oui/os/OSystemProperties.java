package com.obric.oui.os;

import com.GlobalProxyLancet;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSystemProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/os/OSystemProperties;", "", "()V", "TAG", "", "sGetBooleanMethod", "Ljava/lang/reflect/Method;", "sGetIntMethod", "sGetLongMethod", "sGetMethod", "get", "key", "def", "getBoolean", "", "getInt", "", "getLong", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSystemProperties {
    public static final OSystemProperties INSTANCE = null;
    private static final String TAG = "OSystemProperties";
    private static Method sGetBooleanMethod;
    private static Method sGetIntMethod;
    private static Method sGetLongMethod;
    private static Method sGetMethod;

    @JvmStatic
    public static final String get(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        return get$default(r2, null, 2, null);
    }

    private OSystemProperties() {
    }

    static {
        INSTANCE = new OSystemProperties();
        Class<?> r0 = Class.forName("android.os.SystemProperties");     // Catch: Exception -> L5
        sGetMethod = r0.getMethod("get", new Class[]{String.class, String.class});     // Catch: Exception -> L5
        sGetIntMethod = r0.getMethod("getInt", new Class[]{String.class, Integer.TYPE});     // Catch: Exception -> L5
        sGetLongMethod = r0.getMethod("getLong", new Class[]{String.class, Long.TYPE});     // Catch: Exception -> L5
        sGetBooleanMethod = r0.getMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Failed to initialize SystemProperties reflection", e);
    }

    public static /* synthetic */ String get$default(String r0, String r1, int r2, Object r3) {
        if ((r2 & 2) == 0) goto L6;
        r1 = "";
    L6:
        return get(r0, r1);
    }

    @JvmStatic
    public static final String get(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "def");
        Method r0 = sGetMethod;     // Catch: Exception -> L14
        String r1 = null;
        if (r0 != null) goto L6;
        Object r6 = null;
    L8:
        if ((r6 instanceof String) == false) goto L10;
        r1 = (String) r6;     // Catch: Exception -> L14
    L10:
        if (r1 != null) goto L13;
        return r5;
    L13:
        return r1;
    L6:
        r6 = r0.invoke(null, new Object[]{r4, r5});     // Catch: Exception -> L14
    L18:
        return r5;
    }

    @JvmStatic
    public static final int getInt(String r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Method r0 = sGetIntMethod;     // Catch: Exception -> L15
        Integer r1 = null;
        if (r0 != null) goto L6;
        Object r6 = null;
    L8:
        if ((r6 instanceof Integer) == false) goto L10;
        r1 = (Integer) r6;     // Catch: Exception -> L15
    L10:
        if (r1 == null) goto L18;
        return r1.intValue();
    L18:
        return r5;
    L6:
        r6 = r0.invoke(null, new Object[]{r4, Integer.valueOf(r5)});     // Catch: Exception -> L15
    L19:
        return r5;
    }

    @JvmStatic
    public static final long getLong(String r4, long r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Method r0 = sGetLongMethod;     // Catch: Exception -> L15
        Long r1 = null;
        if (r0 != null) goto L6;
        Object r6 = null;
    L8:
        if ((r6 instanceof Long) == false) goto L10;
        r1 = (Long) r6;     // Catch: Exception -> L15
    L10:
        if (r1 == null) goto L18;
        return r1.longValue();
    L18:
        return r5;
    L6:
        r6 = r0.invoke(null, new Object[]{r4, Long.valueOf(r5)});     // Catch: Exception -> L15
    L19:
        return r5;
    }

    @JvmStatic
    public static final boolean getBoolean(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Method r0 = sGetBooleanMethod;     // Catch: Exception -> L15
        Boolean r1 = null;
        if (r0 != null) goto L6;
        Object r6 = null;
    L8:
        if ((r6 instanceof Boolean) == false) goto L10;
        r1 = (Boolean) r6;     // Catch: Exception -> L15
    L10:
        if (r1 == null) goto L18;
        return r1.booleanValue();
    L18:
        return r5;
    L6:
        r6 = r0.invoke(null, new Object[]{r4, Boolean.valueOf(r5)});     // Catch: Exception -> L15
    L19:
        return r5;
    }
}
