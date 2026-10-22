package com.bytedance.applet.impl;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import hq9.z2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class r implements z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r4.m f191998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f191999b;

    public r(com.bytedance.ai.bridge.method.system.location.g r100, q r101) {
        this.f191998a = r100;
        this.f191999b = r101;
    }

    @Override // hq9.z2
    public final void a(LocationResult r110, GeoLocationInfo r111) {
        Intrinsics.checkNotNullParameter(r110, "code");
        Intrinsics.checkNotNullParameter(r111, "location");
        r4.m r112 = this.f191998a;
        this.f191999b.getClass();
        Float r100 = Float.valueOf(r111.getNaviAccuracy());
        float r101 = r100.floatValue();
        Float r113 = Float.valueOf(0.0f);
        if (r101 <= 0.0f) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L9;
        r100 = null;
    L9:
        if (r100 == null) goto L11;
        float r103 = r100.floatValue();
    L12:
        double r104 = r111.getLatitude();
        double r105 = r111.getLongitude();
        float r106 = r111.getSpeed();
        double r107 = r111.getAltitude();
        String r114 = r111.getCity();
        r112.a(new r4.n(Double.valueOf(r104), Double.valueOf(r105), Float.valueOf(r106), Float.valueOf(r103), Double.valueOf(r107), r113, r113, r114));
        return;
    L11:
        r103 = r111.getRadius();
        goto L12
    L5:
        r102 = false;
        goto L6
    }

    @Override // hq9.z2
    public final void onError(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        r4.m r102 = this.f191998a;
        if (StringsKt.isBlank(r101) == true) goto L6;
        r100 = r101;
    L6:
        r102.b(r100);
    }
}
