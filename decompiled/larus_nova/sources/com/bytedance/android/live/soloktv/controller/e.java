package com.bytedance.android.live.soloktv.controller;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.v;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<d> f101041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<Class<? extends l>, ArrayList<c<? extends l>>> f101042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<c<?>> f101043c;

    public static final class a {
    }

    static {
    }

    public e() {
        this.f101041a = new ArrayList();
        this.f101042b = new HashMap();
        this.f101043c = new HashSet();
    }

    public final void a(l r110) {
        Intrinsics.checkNotNullParameter(r110, "action");
        Iterator<T> r100 = this.f101041a.iterator();
    L3:
        boolean r101 = false;
    L5:
        if (r100.hasNext() == false) goto L10;
        if (((d) r100.next()).a(r110) == true) goto L9;
        if (r101 == false) goto L3;
    L9:
        r101 = true;
        goto L5
    L10:
        if (r101 == false) goto L12;
        ALogger.i("BaseMusicActionController", "intercept action :" + r110);
        return;
    L12:
        Class<?> r102 = r110.getClass();
        ArrayList<c<? extends l>> r103 = this.f101042b.get(r102);
        if (r103 == null) goto L78;
        Iterator<T> r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L79;
        c r105 = (c) r104.next();
        if ((r105 instanceof b) == true) goto L20;
        if ((r105 instanceof h) == true) goto L23;
        if ((r105 instanceof h) == true) goto L27;
        Method r106 = r105.getClass().getDeclaredMethod("handle", new Class[]{r102});     // Catch: Exception -> L46
        if (r106 == null) goto L16;
        r106.invoke(r105, new Object[]{r110});     // Catch: Exception -> L46
        goto L16
    L27:
        Method[] r107 = ((h) r105).getClass().getDeclaredMethods();     // Catch: Exception -> L46
        ArrayList r108 = new ArrayList();     // Catch: Exception -> L46
        int r109 = r107.length;     // Catch: Exception -> L46
        int r111 = 0;
    L28:
        if (r111 >= r109) goto L38;
        Method r112 = r107[r111];     // Catch: Exception -> L46
        if (Intrinsics.areEqual(r112.getName(), "handle") == true) goto L32;
    L34:
        boolean r113 = false;
    L35:
        if (r113 == false) goto L37;
        r108.add(r112);     // Catch: Exception -> L46
    L37:
        r111 = r111 + 1;     // Catch: Exception -> L46
        goto L28
    L32:
        if (r112.getGenericParameterTypes().length != 1) goto L34;
        r113 = true;
        goto L35
    L38:
        Iterator r114 = r108.iterator();     // Catch: Exception -> L46
    L40:
        if (r114.hasNext() == false) goto L16;
        ((Method) r114.next()).invoke(r105, new Object[]{r110});     // Catch: Exception -> L46
        goto L40
    L23:
        h r115 = (h) r105;     // Catch: Exception -> L46
        r115.getClass();     // Catch: Exception -> L46
        Intrinsics.checkNotNullParameter(r110, "action");     // Catch: Exception -> L46
        r115.a(r110);     // Catch: Exception -> L46
        goto L16
    L20:
        b r116 = (b) r105;     // Catch: Exception -> L46
        r116.getClass();     // Catch: Exception -> L46
        Intrinsics.checkNotNullParameter(r110, "action");     // Catch: Exception -> L46
        r116.a(r110);     // Catch: Exception -> L46
    L46:
        e = move-exception;
        if (v.a() == false) goto L16;
        throw e;
    L79:
        return;
    }
}
