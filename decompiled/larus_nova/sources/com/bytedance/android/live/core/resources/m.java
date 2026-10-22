package com.bytedance.android.live.core.resources;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f65199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vh7.i f65200b = null;

    static {
        KMutableProperty1 r100 = Reflection.mutableProperty1(new MutablePropertyReference1Impl(m.class, "mCdnDomainOpt", "getMCdnDomainOpt(Lcom/bytedance/android/live/core/resources/ResourceModel;)Ljava/lang/Boolean;", 1));
        f65199a = new KProperty[]{r100};
        int r101 = vh7.a.f554979a;
        f65200b = new vh7.i(new vh7.a.b(r100.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.bytedance.android.live.core.resources.l, java.lang.Object] */
    public static final List<String> a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$getUrlList");
        Intrinsics.checkNotNullParameter(r100, "$this$mCdnDomainOpt");
        vh7.i r101 = f65200b;
        KProperty r102 = f65199a[0];
        vh7.c r103 = (vh7.c) r100;
        ?? r104 = 0;
        if ((r103 instanceof FlexModelBase) == true) goto L5;
        r103 = null;
    L5:
        FlexModelBase r105 = (FlexModelBase) r103;
        if (r105 == null) goto L8;
        Object r106 = r105.get(r101.f554986a);
    L10:
        if (Intrinsics.areEqual((Boolean) r106, Boolean.TRUE) == false) goto L56;
        if (r100.getUrlList().isEmpty() == false) goto L56;
        List<String> r107 = w12.a.f557890a;
        String r108 = r100.getUri();
        List<String> r109 = r100.getUrlList();
        if (TypeIntrinsics.isMutableList(r109) == false) goto L18;
        r104 = r109;
    L18:
        if (w12.a.f557894e == true) goto L35;
        if (w12.a.f557892c == null) goto L33;
        if (r108 == null) goto L33;
        List<String> r110 = w12.a.f557890a;
        if (((ArrayList) r110).isEmpty() == false) goto L26;
        w12.a.a();
    L26:
        ArrayList r111 = new ArrayList();
        if (r110 == null) goto L32;
        Iterator r112 = ((ArrayList) r110).iterator();
    L30:
        if (r112.hasNext() == false) goto L32;
        r111.add(((String) r112.next()) + r108);
    L32:
        r104 = r111;
    L54:
        r100.setUrlList(r104);
    L33:
        r104 = new ArrayList();
        goto L54
    L35:
        if (w12.a.f557892c == null) goto L53;
        if (r108 == null) goto L53;
        List<String> r113 = w12.a.f557890a;
        if (((ArrayList) r113).isEmpty() == false) goto L41;
        w12.a.a();
    L41:
        if (r104 == 0) goto L47;
        if (r113 == null) goto L54;
        Iterator r114 = ((ArrayList) r113).iterator();
    L45:
        if (r114.hasNext() == false) goto L54;
        r104.add(((String) r114.next()) + r108);
        goto L45
    L47:
        r104 = new ArrayList();
        if (r113 == null) goto L54;
        Iterator r115 = ((ArrayList) r113).iterator();
    L51:
        if (r115.hasNext() == false) goto L54;
        r104.add(((String) r115.next()) + r108);
    L53:
        r104 = new ArrayList();
    L56:
        return r100.getUrlList();
    L8:
        r106 = null;
        goto L10
    }

    public static final void b(l r100, Boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$mCdnDomainOpt");
        vh7.i r102 = f65200b;
        KProperty r103 = f65199a[0];
        l r104 = r100;
        if ((r104 instanceof FlexModelBase) == true) goto L5;
        r104 = null;
    L5:
        FlexModelBase r105 = (FlexModelBase) r104;
        if (r105 == null) goto L9;
        r105.set(r102.f554986a, r101);
        return;
    }
}
