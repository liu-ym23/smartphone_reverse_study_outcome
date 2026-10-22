package com.bytedance.vmsdk.jsbridge;

import com.bytedance.vmsdk.jsbridge.utils.Callback;
import com.bytedance.vmsdk.jsbridge.utils.ReadableArray;
import com.bytedance.vmsdk.jsbridge.utils.ReadableMap;
import com.bytedance.vmsdk.jsbridge.utils.WritableArray;
import com.bytedance.vmsdk.jsbridge.utils.WritableMap;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: JSMethodWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static androidx.b.a<Class, Character> f11752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f11753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Class[] f11754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f11755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f11756e;

    static {
    }

    private static char a(Class r3) {
        char r0 = c(r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (r3 != Callback.class) goto L10;
        return 'X';
    L10:
        if (r3 != Promise.class) goto L14;
        return 'P';
    L14:
        if (r3 != ReadableMap.class) goto L18;
        return 'M';
    L18:
        if (r3 != ReadableArray.class) goto L22;
        return 'A';
    L22:
        if (r3 != com.bytedance.vmsdk.jsbridge.utils.b.class) goto L26;
        return 'Y';
    L26:
        if (r3 != byte[].class) goto L30;
        return 'a';
    L30:
        throw new RuntimeException("Got unknown param class: " + r3.getSimpleName());
    }

    private static char b(Class r3) {
        char r0 = c(r3);
        if (r0 == 0) goto L6;
        return r0;
    L6:
        if (r3 != Void.TYPE) goto L10;
        return 'v';
    L10:
        if (r3 != WritableMap.class) goto L14;
        return 'M';
    L14:
        if (r3 != WritableArray.class) goto L18;
        return 'A';
    L18:
        if (r3 != byte[].class) goto L22;
        return 'a';
    L22:
        throw new RuntimeException("Got unknown return class: " + r3.getSimpleName());
    }

    private static char c(Class r3) {
        if (f11752a != null) goto L6;
        androidx.b.a<Class, Character> r0 = new androidx.b.a();
        f11752a = r0;
        r0.put(Byte.TYPE, 'b');
        f11752a.put(Byte.class, 'B');
        f11752a.put(Short.TYPE, 's');
        f11752a.put(Short.class, 'S');
        f11752a.put(Long.TYPE, 'l');
        f11752a.put(Long.class, 'L');
        f11752a.put(Character.TYPE, 'c');
        f11752a.put(Character.class, 'C');
        f11752a.put(Boolean.TYPE, 'z');
        f11752a.put(Boolean.class, 'Z');
        f11752a.put(Integer.TYPE, 'i');
        f11752a.put(Integer.class, 'I');
        f11752a.put(Double.TYPE, 'd');
        f11752a.put(Double.class, 'D');
        f11752a.put(Float.TYPE, 'f');
        f11752a.put(Float.class, 'F');
        f11752a.put(String.class, 'T');
    L6:
        if (f11752a.containsKey(r3) == true) goto L8;
        return 0;
    L8:
        return ((Character) ZeusTransformUtils.preCheckCast(f11752a.get(r3), Character.class, "com.obric.aiagent.plugin")).charValue();
    }

    c(Method r2) {
        this.f11755d = false;
        this.f11753b = r2;
        r2.setAccessible(true);
        this.f11754c = r2.getParameterTypes();
    }

    private void b() {
        if (this.f11755d == false) goto L5;
        return;
    L5:
        this.f11755d = true;
        this.f11756e = a(this.f11753b, this.f11754c);
    }

    public String a() {
        if (this.f11755d == true) goto L6;
        b();
    L6:
        return (String) ZeusTransformUtils.preCheckCast(com.bytedance.vmsdk.jsbridge.utils.a.a(this.f11756e), String.class, "com.obric.aiagent.plugin");
    }

    private String a(Method r5, Class[] r6) {
        StringBuilder r4 = new StringBuilder(r6.length + 2);
        r4.append(b(r5.getReturnType()));
        r4.append('.');
        int r0 = 0;
    L4:
        if (r0 >= r6.length) goto L14;
        Class r1 = r6[r0];
        if (r1 != Promise.class) goto L12;
        boolean r3 = true;
        if (r0 == (r6.length - 1)) goto L11;
        r3 = false;
    L11:
        com.bytedance.vmsdk.jsbridge.utils.a.a(r3, "Promise must be used as last parameter only");
    L12:
        r4.append(a(r1));
        r0 = r0 + 1;
        goto L4
    L14:
        return r4.toString();
    }
}
