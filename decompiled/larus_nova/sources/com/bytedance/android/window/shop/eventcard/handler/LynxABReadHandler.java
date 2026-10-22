package com.bytedance.android.window.shop.eventcard.handler;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class LynxABReadHandler implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LynxABReadHandler f187788a = null;

    public LynxABReadHandler() {
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final void release() {
    }

    static {
        f187788a = new LynxABReadHandler();
    }

    @Override // com.bytedance.android.window.shop.eventcard.handler.a
    public final Map<String, Object> a(int r100, Map<String, ? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r101, "params");
        Object r102 = r101.get("ab_type");
        if ((r102 instanceof String) == true) goto L5;
        r102 = null;
    L5:
        String r103 = (String) r102;
        if (r103 == null) goto L8;
        Object r104 = r101.get("ab_keys");
        if (r104 == null) goto L47;
        List r105 = (List) r104;
        if (r105.isEmpty() == true) goto L45;
        List r106 = r105;
        boolean r107 = false;
        if ((r106 instanceof Collection) == true) goto L16;
    L18:
        Iterator r108 = r106.iterator();
    L20:
        if (r108.hasNext() == false) goto L24;
        if ((!(r108.next() instanceof String)) == false) goto L20;
        r107 = true;
    L24:
        if (r107 == true) goto L45;
        int r109 = r103.hashCode();
        if (r109 == (-344460952)) goto L35;
        if (r109 == 3208616) goto L32;
    L42:
        ECExceptionMonitor.e(new Exception("abType " + r103 + " not expected"));
        return MapsKt.emptyMap();
    L32:
        if (r103.equals("host") == false) goto L42;
        Function1 r110 = new LynxABReadHandler$handleEvent$reader$1(dp3.a.f469586a);
    L37:
        LinkedHashMap r111 = new LinkedHashMap();
        Iterator r112 = r106.iterator();
    L39:
        if (r112.hasNext() == false) goto L41;
        String r113 = (String) r112.next();
        r111.put(r113, r110.invoke(r113));
        goto L39
    L41:
        return r111;
    L35:
        if (r103.equals("shopping") == false) goto L42;
        r110 = new LynxABReadHandler$handleEvent$reader$2(dp3.a.f469586a);
        goto L37
    L16:
        if (r106.isEmpty() == false) goto L18;
    L45:
        return MapsKt.emptyMap();
    L47:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
    L8:
        return MapsKt.emptyMap();
    }
}
