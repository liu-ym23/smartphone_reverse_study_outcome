package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KProperty[] f88427a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final vh7.i f88428b = null;

    static {
        KMutableProperty1 r100 = Reflection.mutableProperty1(new MutablePropertyReference1Impl(e.class, "expire", "getExpire(Lcom/bytedance/android/live/profit/privilege/model/touch/FreqCtrlParams;)Ljava/lang/Long;", 1));
        f88427a = new KProperty[]{r100};
        int r101 = vh7.a.f554979a;
        f88428b = new vh7.i(new vh7.a.b(r100.getName()));
    }

    public static final Long a(d r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$expire");
        vh7.i r101 = f88428b;
        KProperty r102 = f88427a[0];
        boolean r103 = r100 instanceof FlexModelBase;
        Object r104 = null;
        Object r105 = r100;
        if (r103 == true) goto L5;
        r105 = null;
    L5:
        FlexModelBase r106 = (FlexModelBase) r105;
        if (r106 == null) goto L9;
        r104 = r106.get(r101.f554986a);
    L9:
        return (Long) r104;
    }

    public static final void b(d r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$expire");
        vh7.i r102 = f88428b;
        KProperty r103 = f88427a[0];
        boolean r104 = r100 instanceof FlexModelBase;
        Object r105 = r100;
        if (r104 == true) goto L5;
        r105 = null;
    L5:
        FlexModelBase r106 = (FlexModelBase) r105;
        if (r106 == null) goto L9;
        r106.set(r102.f554986a, r101);
        return;
    }
}
