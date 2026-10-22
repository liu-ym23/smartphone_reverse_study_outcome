package com.bytedance.android.ec.core.imagex;

import com.facebook.imagepipeline.image.CloseableImage;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class x0 implements InvocationHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function3 f45083a;

    public x0(Function3 r100) {
        this.f45083a = r100;
    }

    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object r100, Method r101, Object[] r102) {
        String r103 = r101.getName();
        boolean r104 = true;
        Object r105 = null;
        switch(r103.hashCode()) {
            case -2043700309: goto L20;
            case -1776922004: goto L17;
            case -1295482945: goto L9;
            case 147696667: goto L6;
            default: goto L51;
        };
    L51:
        return null;
    L6:
        if (r103.equals("hashCode") == true) goto L45;
        return null;
    L45:
        return Integer.valueOf(System.identityHashCode(r100));
    L9:
        if (r103.equals("equals") == false) goto L46;
        if (r102 == null) goto L12;
        r105 = ArraysKt.getOrNull(r102, 0);
    L12:
        if (r100 == r105) goto L47;
        r104 = false;
    L47:
        return Boolean.valueOf(r104);
    L46:
        return null;
    L17:
        if (r103.equals("toString") == false) goto L48;
        return "SimpleDecodeCallBackProxy";
    L48:
        return null;
    L20:
        if (r103.equals("decodeResult") == false) goto L50;
        Function3 r106 = this.f45083a;
        if (r102 == null) goto L24;
        Object r107 = ArraysKt.getOrNull(r102, 0);
    L26:
        if ((r107 instanceof Boolean) == true) goto L28;
        r107 = null;
    L28:
        Boolean r108 = Boolean.valueOf(Intrinsics.areEqual((Boolean) r107, Boolean.TRUE));
        if (r102 == null) goto L31;
        Object r109 = ArraysKt.getOrNull(r102, 1);
    L33:
        if ((r109 instanceof CloseableImage) == true) goto L35;
        r109 = null;
    L35:
        CloseableImage r110 = (CloseableImage) r109;
        if (r102 == null) goto L38;
        Object r111 = ArraysKt.getOrNull(r102, 2);
    L40:
        if ((r111 instanceof String) == true) goto L42;
        r111 = null;
    L42:
        r106.invoke(r108, r110, (String) r111);
        return null;
    L38:
        r111 = null;
        goto L40
    L31:
        r109 = null;
        goto L33
    L24:
        r107 = null;
        goto L26
    L50:
        return null;
    }
}
