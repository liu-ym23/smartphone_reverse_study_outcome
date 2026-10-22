package com.bytedance.ai.bridge.method.system;

import android.app.Activity;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.service.OnPermissionGrantCallback;
import f3.h;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import r4.k;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements OnPermissionGrantCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Activity f35943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h<AbsGetLocationMethodIDL.b> f35944b;

    /* JADX INFO: renamed from: com.bytedance.ai.bridge.method.system.a$a, reason: collision with other inner class name */
    public static final class C0700a implements r4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h<AbsGetLocationMethodIDL.b> f35945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f35946b;

        @Override // r4.c
        public final void b(r4.d r100) {
            Intrinsics.checkNotNullParameter(r100, "locationResult");
            h<AbsGetLocationMethodIDL.b> r101 = this.f35945a;
            Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
            BaseModel r102 = k3.c.a(AbsGetLocationMethodIDL.b.class);
            AbsGetLocationMethodIDL.b r103 = (AbsGetLocationMethodIDL.b) r102;
            r103.setEnable(Boolean.valueOf(this.f35946b));
            r103.setLongitude(Double.valueOf(r100.f535993b));
            r103.setLatitude(Double.valueOf(r100.f535992a));
            h.a.b(r101, (ResultModel) r102);
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            h<AbsGetLocationMethodIDL.b> r101 = this.f35945a;
            Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
            BaseModel r102 = k3.c.a(AbsGetLocationMethodIDL.b.class);
            AbsGetLocationMethodIDL.b r103 = (AbsGetLocationMethodIDL.b) r102;
            r103.setEnable(Boolean.valueOf(this.f35946b));
            r103.setLongitude(null);
            r103.setLatitude(null);
            Unit r104 = Unit.INSTANCE;
            h.a.a(r101, r100, null, r103.toJson(), 6);
        }

        public C0700a(h<AbsGetLocationMethodIDL.b> r100, boolean r101) {
            this.f35945a = r100;
            this.f35946b = r101;
        }

        @Override // r4.c
        public final void a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            c(r100);
        }
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onAllGranted() {
        Activity r100 = this.f35943a;
        h<AbsGetLocationMethodIDL.b> r101 = this.f35944b;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L9
        boolean r103 = g4.a.b(r100);     // Catch: Throwable -> L9
        k r104 = r4.a.f535984k;     // Catch: Throwable -> L9
        if (r104 != null) goto L7;
        h.a.a(r101, "HostSystemActionDepend is null", null, null, 14);     // Catch: Throwable -> L9
        return;
    L7:
        r104.d(r100, null, null, null, null, new C0700a(r101, r103), null, null);     // Catch: Throwable -> L9
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        h<AbsGetLocationMethodIDL.b> r106 = this.f35944b;
        Throwable r107 = Result.m9452exceptionOrNullimpl(r105);
        if (r107 == null) goto L16;
        h.a.a(r106, "get location err:" + r107.getMessage(), null, null, 14);
        return;
    L16:
        return;
    L9:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.bytedance.ai.bridge.service.OnPermissionGrantCallback
    public final void onNotGranted() {
        h<AbsGetLocationMethodIDL.b> r100 = this.f35944b;
        Intrinsics.checkNotNullParameter(AbsGetLocationMethodIDL.b.class, "<this>");
        AbsGetLocationMethodIDL.b r101 = (AbsGetLocationMethodIDL.b) k3.c.a(AbsGetLocationMethodIDL.b.class);
        r101.setEnable(Boolean.FALSE);
        r101.setLongitude(null);
        r101.setLatitude(null);
        Unit r102 = Unit.INSTANCE;
        h.a.a(r100, "no location permission", null, r101.toJson(), 6);
    }

    public a(Activity r100, h<AbsGetLocationMethodIDL.b> r101) {
        this.f35943a = r100;
        this.f35944b = r101;
    }
}
