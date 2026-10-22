package com.bytedance.ai.bridge.method.system.location;

import androidx.core.location.LocationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.JsonObject;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r4.m;
import r4.n;

/* JADX INFO: loaded from: classes43.dex */
public final class g implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LocationUpdateManager f36018a;

    public g(LocationUpdateManager r100) {
        this.f36018a = r100;
    }

    @Override // r4.m
    public final void a(n r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        LocationUpdateManager r101 = this.f36018a;
        Object r102 = r101.f35988c;
        monitor-enter(r102);
    L42:
        th = move-exception;
        throw th;
    L5:
        if (r101.f35989d != LocationUpdateManager.UpdateState.STARTED) goto L9;
        if (r101.f35991f == true) goto L9;
        boolean r103 = true;
    L10:
        monitor-exit(r102);
        if (r103 == false) goto L48;
        e3.d r104 = r101.f35986a.get();
        if (r104 == null) goto L47;
        JsonObject r105 = new JsonObject();
        Double r106 = r100.f536002a;
        if (r106 == null) goto L18;
        r105.addProperty("latitude", Double.valueOf(r106.doubleValue()));
    L18:
        Double r107 = r100.f536003b;
        if (r107 == null) goto L21;
        r105.addProperty("longitude", Double.valueOf(r107.doubleValue()));
    L21:
        Float r108 = r100.f536004c;
        if (r108 == null) goto L24;
        r105.addProperty("speed", Float.valueOf(r108.floatValue()));
    L24:
        Float r109 = r100.f536005d;
        if (r109 == null) goto L27;
        r105.addProperty(LocationMonitorConst.ACCURACY, Float.valueOf(r109.floatValue()));
    L27:
        Double r110 = r100.f536006e;
        if (r110 == null) goto L30;
        r105.addProperty("altitude", Double.valueOf(r110.doubleValue()));
    L30:
        Float r111 = r100.f536007f;
        float r112 = 0.0f;
        if (r111 == null) goto L33;
        float r113 = r111.floatValue();
    L34:
        r105.addProperty(LocationCompat.EXTRA_VERTICAL_ACCURACY, Float.valueOf(r113));
        Float r114 = r100.f536008g;
        if (r114 == null) goto L37;
        r112 = r114.floatValue();
    L37:
        r105.addProperty("horizontalAccuracy", Float.valueOf(r112));
        String r115 = r100.f536009h;
        if (r115 == null) goto L40;
        r105.addProperty("city", r115);
    L40:
        Unit r116 = Unit.INSTANCE;
        r104.a("doubao.onLocationChange", r105);
        return;
    L33:
        r113 = 0.0f;
        goto L34
    L47:
        return;
    L48:
        return;
    L9:
        r103 = false;
        goto L10
    }

    @Override // r4.m
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        LocationUpdateManager r101 = this.f36018a;
        Object r102 = r101.f35988c;
        monitor-enter(r102);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (r101.f35989d != LocationUpdateManager.UpdateState.STARTED) goto L9;
        if (r101.f35991f == true) goto L9;
        boolean r103 = true;
    L10:
        monitor-exit(r102);
        if (r103 == false) goto L23;
        e3.d r104 = r101.f35986a.get();
        if (r104 == null) goto L22;
        int r105 = LocationAuthorization.f35985a;
        r104.a("doubao.onLocationChangeError", LocationAuthorization.b(r100, 0));
        return;
    L22:
        return;
    L23:
        return;
    L9:
        r103 = false;
        goto L10
    }
}
