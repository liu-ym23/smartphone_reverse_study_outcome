package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.MakePhoneCallResultModel;

/* JADX INFO: loaded from: classes43.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f38871a;

    public final void a() {
        a1 r100 = this.f38871a;
        MakePhoneCallResultModel r101 = new MakePhoneCallResultModel();
        r101.a(MakePhoneCallResultModel.Code.Failed);
        r101.b("phoneNumber is null");
        r100.finishWithResult(r101);
    }

    public final void b() {
        a1 r100 = this.f38871a;
        MakePhoneCallResultModel r101 = new MakePhoneCallResultModel();
        r101.a(MakePhoneCallResultModel.Code.Success);
        r101.b("Call Success!");
        r100.finishWithResult(r101);
    }

    public z0(a1 r100) {
        this.f38871a = r100;
    }
}
