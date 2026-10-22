package com.bytedance.applet.aibridge.navi;

import com.larus.platform.model.GeoLocationInfo;
import com.larus.platform.model.LocationResult;
import com.larus.utils.t0;
import hq9.a3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import rv3.r;
import rv3.s;
import rv3.x;

/* JADX INFO: loaded from: classes14.dex */
public final class a implements a3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<sv3.a, Unit> f191247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbsOpenNavigationMapIDL.a f191248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1<String, Unit> f191249c;

    public a(r r100, AbsOpenNavigationMapIDL.a r101, s r102) {
        this.f191247a = r100;
        this.f191248b = r101;
        this.f191249c = r102;
    }

    @Override // hq9.a3
    public final void a(final LocationResult r100, final Integer r110, final GeoLocationInfo r111) {
        Intrinsics.checkNotNullParameter(r100, "code");
        final Function1<sv3.a, Unit> r101 = this.f191247a;
        final AbsOpenNavigationMapIDL.a r102 = this.f191248b;
        final Function1<String, Unit> r103 = this.f191249c;
        t0.e(new x(r100, r111, r101, r102, r103, r110));
    }
}
