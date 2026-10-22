package com.bytedance.android.livesdk.dslservice.lynxair;

import com.bytedance.android.livesdk.dsl.api.DSLType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import yt1.m;

/* JADX INFO: loaded from: classes8.dex */
public final class LynxAirDSLProcess$wrapCallback$1 implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f122858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f122859b;

    @Override // yt1.m
    public final void onFetchSuccess() {
    }

    public LynxAirDSLProcess$wrapCallback$1(String r100, m r101) {
        this.f122858a = r100;
        this.f122859b = r101;
    }

    @Override // yt1.m
    public final void a(com.bytedance.android.livesdk.dslservice.a r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "loadFrom");
        if (r102.length() != 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        String r104 = "UnKnown";
    L9:
        com.bytedance.android.livesdk.dslservice.util.m r105 = com.bytedance.android.livesdk.dslservice.util.m.f123003h;
        r105.d(new LynxAirDSLProcess$wrapCallback$1$onLoadSuccess$1(this));
        String r106 = this.f122858a;
        Intrinsics.checkNotNullParameter(r106, "id");
        Intrinsics.checkNotNullParameter(r104, "loadType");
        r105.f(DSLType.LynxAir, 1, r104, r106);
        m r107 = this.f122859b;
        if (r107 == null) goto L13;
        r107.a(r100, r101, r102);
        return;
    L13:
        return;
    L8:
        r104 = r102;
        goto L9
    L5:
        r103 = false;
        goto L6
    }

    @Override // yt1.m
    public final void b(String r100, final String r101, final Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r101, "reason");
        com.bytedance.android.livesdk.dslservice.util.m r103 = com.bytedance.android.livesdk.dslservice.util.m.f123003h;
        Function1<com.bytedance.android.livesdk.dslservice.util.f, Unit> r104 = new LynxAirDSLProcess$wrapCallback$1$onFailed$1(this, r101, r102);
        r103.getClass();
        Intrinsics.checkNotNullParameter(r104, "initBlock");
        r103.e(2, r104);
        String r105 = this.f122858a;
        Intrinsics.checkNotNullParameter(r105, "id");
        Intrinsics.checkNotNullParameter("", "loadType");
        r103.f(DSLType.LynxAir, 0, "", r105);
        m r106 = this.f122859b;
        if (r106 == null) goto L6;
        r106.b(r100, r101, r102);
        return;
    }
}
