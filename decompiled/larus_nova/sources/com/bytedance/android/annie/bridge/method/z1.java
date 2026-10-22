package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.ScanCodeResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class z1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a2 f38872a;

    public final void a() {
        Intrinsics.checkNotNullParameter("DefaultScanCodeService默认返回", "result");
        a2 r100 = this.f38872a;
        ScanCodeResultModel r101 = new ScanCodeResultModel();
        r101.a(ScanCodeResultModel.Code.Success);
        r101.b("Scan Success !");
        r101.setResult("DefaultScanCodeService默认返回");
        r100.finishWithResult(r101);
    }

    public z1(a2 r100) {
        this.f38872a = r100;
    }
}
