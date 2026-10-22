package com.bytedance.android.live.soloktv.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k extends e {
    public k() {
    }

    public final void b(c<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        Intrinsics.checkNotNullParameter(r100, "handler");
        this.f101043c.add(r100);
        c.f101039a.getClass();
        Intrinsics.checkNotNullParameter(r100, "$this$getActionType");
        Type r101 = r100.getClass().getGenericSuperclass();     // Catch: Exception -> L31
        if ((r101 instanceof ParameterizedType) == true) goto L6;
        r101 = null;
    L6:
        ParameterizedType r102 = (ParameterizedType) r101;     // Catch: Exception -> L31
        if (r102 == null) goto L11;
        Type[] r103 = r102.getActualTypeArguments();     // Catch: Exception -> L31
        if (r103 == null) goto L11;
        Type r104 = (Type) ArraysKt.firstOrNull(r103);     // Catch: Exception -> L31
    L13:
        if ((r104 instanceof Class) == true) goto L15;
        r104 = null;
    L15:
        Class<? extends l> r105 = (Class) r104;     // Catch: Exception -> L31
        if (r105 != null) goto L32;
        Type r106 = r100.getClass().getGenericInterfaces()[0];     // Catch: Exception -> L31
        if ((r106 instanceof ParameterizedType) == true) goto L20;
        r106 = null;
    L20:
        ParameterizedType r107 = (ParameterizedType) r106;     // Catch: Exception -> L31
        if (r107 == null) goto L25;
        Type[] r108 = r107.getActualTypeArguments();     // Catch: Exception -> L31
        if (r108 == null) goto L25;
        Type r109 = r108[0];     // Catch: Exception -> L31
    L27:
        if ((r109 instanceof Class) == true) goto L29;
        r109 = null;
    L29:
        r105 = (Class) r109;     // Catch: Exception -> L31
    L25:
        r109 = null;
    L32:
        if (r105 == null) goto L38;
        ArrayList<c<? extends l>> r110 = this.f101042b.get(r105);
        if (r110 != null) goto L36;
        r110 = new ArrayList();
    L36:
        r110.add(r100);
        this.f101042b.put(r105, r110);
    L38:
        if ((r100 instanceof h) == false) goto L53;
        List<Class<? extends l>> r111 = ((h) r100).b();
        if (r111 == null) goto L53;
        Iterator<T> r112 = r111.iterator();
    L43:
        if (r112.hasNext() == false) goto L53;
        Class<? extends l> r113 = (Class) r112.next();
        if ((r113 instanceof Class) == true) goto L47;
        r113 = null;
    L47:
        if (r113 == null) goto L43;
        ArrayList<c<? extends l>> r114 = this.f101042b.get(r113);
        if (r114 != null) goto L51;
        r114 = new ArrayList();
    L51:
        r114.add(r100);
        this.f101042b.put(r113, r114);
    L53:
        if ((r100 instanceof b) == false) goto L56;
        b r115 = (b) r100;
        r115.f101036c = this;
        r115.b();
    L56:
        if ((r100 instanceof a) == false) goto L66;
        a r116 = (a) r100;
        r116.f101032c = this;
        r116.c();
        return;
    L66:
        return;
    L11:
        r104 = null;
    L31:
        r105 = null;
        goto L32
    }
}
