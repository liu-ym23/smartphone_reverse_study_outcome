package com.bytedance.android.monitorV2.util;

import com.bytedance.android.monitorV2.event.HybridEvent;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f163236a = 0;

    static {
    }

    public static boolean d() {
        if (kz2.a.f506727a.f506729a == true) goto L13;
        Map<String, Map<Class<?>, Object>> r100 = x26.a.f562251a;
        w26.g r101 = (w26.g) x26.a.a(w26.g.class);
        if (r101 == null) goto L11;
        w26.h r102 = (w26.h) r101.n0(w26.h.class);
        if (r102 == null) goto L11;
        w26.h.b r103 = r102.g();
        if (r103 == null) goto L11;
        boolean r104 = r103.c();
    L12:
        if (r104 == true) goto L13;
        return false;
    L11:
        r104 = false;
    L13:
        return true;
    }

    public static boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventType");
        if (d() == true) goto L5;
        return false;
    L5:
        kz2.a.C6634a r101 = kz2.a.f506727a;
        if (r101.f506730b.isEmpty() == false) goto L11;
        if (com.bytedance.ies.bullet.service.base.h.v0().isEmpty() == false) goto L11;
        return true;
    L11:
        if (r101.f506730b.contains(r100) == false) goto L13;
    L16:
        return false;
    L13:
        if (com.bytedance.ies.bullet.service.base.h.v0().contains(r100) == true) goto L16;
        return true;
    }

    public static boolean b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        if (d() == true) goto L5;
        return false;
    L5:
        kz2.a.C6634a r101 = kz2.a.f506727a;
        if (r101.f506731c.isEmpty() == false) goto L11;
        if (com.bytedance.ies.bullet.service.base.h.w0().isEmpty() == false) goto L11;
        return true;
    L11:
        if (r101.f506731c.contains(r100) == false) goto L13;
    L16:
        return false;
    L13:
        if (com.bytedance.ies.bullet.service.base.h.w0().contains(r100) == true) goto L16;
        return true;
    }

    public static boolean c(HybridEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof com.bytedance.android.monitorV2.event.b) == false) goto L9;
        String r101 = ((com.bytedance.android.monitorV2.event.b) r100).f163022m.f501103c;
        if (r101 != null) goto L13;
        r101 = "";
    L13:
        return b(r101);
    L9:
        if ((r100 instanceof com.bytedance.android.monitorV2.event.a) == true) goto L14;
        return false;
    L14:
        return a(r100.f163001a);
    }
}
