package com.ttnet.org.chromium.net;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f18489b = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f18490a;

    static {
    }

    public d(Context r10) {
        if (r10 == null) goto L7;
        this.f18490a = r10;
        return;
    L7:
        throw new IllegalArgumentException("Context must not be null");
    }

    public static boolean a(Context r10, String r11, Set r12, boolean r13) {
        r12.add((d) r10.getClassLoader().loadClass(r11).asSubclass(d.class).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{r10}));     // Catch: ClassNotFoundException -> L6 IllegalAccessException -> L8 NoSuchMethodException -> L10 InvocationTargetException -> L12 InstantiationException -> L14
        return true;
    L6:
        e = move-exception;
        g(r11, r13, e);
        return false;
    L8:
        e = move-exception;
        g(r11, r13, e);
        return false;
    L14:
        e = move-exception;
        g(r11, r13, e);
        return false;
    L10:
        e = move-exception;
        g(r11, r13, e);
        return false;
    L12:
        e = move-exception;
        g(r11, r13, e);
        return false;
    }

    public static List c(Context r10) {
        LinkedHashSet r11 = new LinkedHashSet();
        a(r10, "com.google.android.gms.net.PlayServicesCronetProvider", r11, false);
        a(r10, "com.google.android.gms.net.GmsCoreCronetProvider", r11, false);
        a(r10, "com.ttnet.org.chromium.net.impl.NativeCronetProvider", r11, false);
        a(r10, "com.ttnet.org.chromium.net.impl.JavaCronetProvider", r11, false);
        return Collections.unmodifiableList(new ArrayList(r11));
    }

    public static void g(String r10, boolean r11, Exception r12) {
        if (r11 == false) goto L4;
        Log.e(f18489b, "Unable to load provider class: " + r10, r12);
        return;
    L4:
        String r13 = f18489b;
        if (Log.isLoggable(r13, 3) == false) goto L9;
        Log.d(r13, "Tried to load " + r10 + " provider class but it wasn't included in the app classpath");
        return;
    }

    public abstract c.a b();

    public abstract String d();

    public abstract String e();

    public abstract boolean f();

    public String toString() {
        return "[class=" + getClass().getName() + ", name=" + d() + ", version=" + e() + ", enabled=" + f() + "]";
    }
}
