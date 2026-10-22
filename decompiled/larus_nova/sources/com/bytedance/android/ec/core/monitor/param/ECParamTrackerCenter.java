package com.bytedance.android.ec.core.monitor.param;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.core.utils.b2;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class ECParamTrackerCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, ECParamTracker> f45189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f45190b = null;

    public static ParamReportConfigSetting b() {
        return (ParamReportConfigSetting) f45190b.getValue();
    }

    static {
        f45189a = new ConcurrentHashMap();
        f45190b = LazyKt.lazy(ECParamTrackerCenter$configSettings$2.INSTANCE);
    }

    public static void a(final String r100) {
        if (b().getEnable() == false) goto L14;
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == true) goto L15;
        b2.b(new ECParamTrackerCenter$destroyTracker$1(r100));
        return;
    L15:
        return;
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
        goto L10
    }

    public static a c(String r100) {
        if (b().getEnable() == false) goto L14;
        if (r100 != null) goto L6;
    L9:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        return null;
    L13:
        return (a) ((ConcurrentHashMap) f45189a).get(r100);
    L6:
        if (r100.length() == 0) goto L9;
        r101 = false;
        goto L10
    L14:
        return null;
    }

    public static void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "pageName");
        if (b().getEnable() == false) goto L23;
        if (r101 == null) goto L24;
        ConcurrentHashMap r102 = (ConcurrentHashMap) f45189a;
        ECParamTracker r103 = (ECParamTracker) r102.get(r101);
        if (r103 == null) goto L16;
        String r104 = r103.f45186e;
        if (r104 == null) goto L16;
        String r105 = a2.d(r104);
        if (r105 == null) goto L16;
        if (Intrinsics.areEqual(r105, r100) == false) goto L16;
        a r106 = (a) r102.get(r101);
        return;
    L16:
        r102.put(r101, new ECParamTracker(r100, r101, b()));
        if (b().getEnableSchemaDiff() == false) goto L21;
        ECParamTracker r107 = (ECParamTracker) r102.get(r101);
        if (r107 == null) goto L21;
        kh.b r108 = new kh.b(r100);
        Intrinsics.checkNotNullParameter(r108, "listener");
        ((ArrayList) r107.f45185d).add(r108);
    L21:
        a r109 = (a) r102.get(r101);
        return;
    L24:
        return;
    }
}
