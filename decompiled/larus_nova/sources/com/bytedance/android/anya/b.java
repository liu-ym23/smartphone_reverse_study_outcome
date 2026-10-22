package com.bytedance.android.anya;

import com.bytedance.android.anya.internal.MVIBindingImpl;
import com.bytedance.android.livesdk.gift.framework.base.GiftMVITraceListener;
import com.google.common.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b {
    public b() {
    }

    public abstract Collection<BaseMVIViewModel<?, ?>> d();

    public abstract <STATE extends MVIState<?>, ACTION extends p> BaseMVIViewModel<STATE, ACTION> f(Class<? extends BaseMVIViewModel<STATE, ACTION>> r100);

    public final <ACTION extends p> void a(ACTION r110) {
        Iterator<T> r100 = d().iterator();
    L4:
        if (r100.hasNext() == false) goto L20;
        BaseMVIViewModel r101 = (BaseMVIViewModel) r100.next();
        if ((r101 instanceof b0) == true) goto L4;
        Map<com.bytedance.android.anya.internal.a.C0765a, Boolean> r102 = com.bytedance.android.anya.internal.a.f41638a;
        Class<?> r103 = r101.getClass();
        Class<?> r104 = r110.getClass();
        com.bytedance.android.anya.internal.a.C0765a r105 = new com.bytedance.android.anya.internal.a.C0765a(r103, r104);
        LinkedHashMap r106 = (LinkedHashMap) com.bytedance.android.anya.internal.a.f41638a;
        Object r107 = r106.get(r105);
        if (r107 != null) goto L14;
        LinkedHashMap r108 = (LinkedHashMap) com.bytedance.android.anya.internal.a.f41639b;
        Object r109 = r108.get(r103);
        if (r109 != null) goto L12;
        r109 = TypeToken.of(r103).getSupertype(BaseMVIViewModel.class).resolveType(BaseMVIViewModel.class.getTypeParameters()[1]).getRawType();
        r108.put(r103, r109);
    L12:
        r107 = Boolean.valueOf(((Class) r109).isAssignableFrom(r104));
        r106.put(r105, r107);
    L14:
        if (((Boolean) r107).booleanValue() == false) goto L4;
        mb.c r111 = mb.a.f512756a;
        String r112 = "broadcastAction " + r110;
        mb.c r113 = mb.a.f512756a;
        if (r113 == null) goto L19;
        r113.logW("ttlive_anya", r112);
    L19:
        r101.b0(r110);
        goto L4
    }

    public final MVIBindingImpl c(BaseMVIView r100, Class r101) {
        BaseMVIViewModel r102 = f(r101);
        if (r102 == null) goto L5;
        MVIBindingImpl r103 = new MVIBindingImpl(r100, r102);
    L6:
        if (r103 == null) goto L14;
        Collection r104 = lb.c.f508283b.f508289a;
        ArrayList r105 = new ArrayList();
        Iterator r106 = r104.iterator();
    L9:
        if (r106.hasNext() == false) goto L13;
        GiftMVITraceListener r107 = ((lb.d) r106.next()).a(this, r103);
        if (r107 == null) goto L9;
        r105.add(r107);
        goto L9
    L13:
        r103.f41628d = new lb.a(r102, r105);
    L14:
        return r103;
    L5:
        r103 = null;
        goto L6
    }
}
