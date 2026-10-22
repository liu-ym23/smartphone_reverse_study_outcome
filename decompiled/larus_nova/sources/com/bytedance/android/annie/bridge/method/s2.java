package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.UploadFileResultModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class s2 implements q2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t2 f38820a;

    public s2(t2 r100) {
        this.f38820a = r100;
    }

    @Override // com.bytedance.android.annie.bridge.method.q2
    public final void a(UploadFileResultModel r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "msg");
        t2 r102 = this.f38820a;
        r100.b(UploadFileResultModel.Code.Success);
        r100.d(r101);
        r102.finishWithResult(r100);
    }

    @Override // com.bytedance.android.annie.bridge.method.q2
    public final void b(UploadFileResultModel.Code r100, String r101, UploadFileResultModel r102) {
        Intrinsics.checkNotNullParameter(r100, "code");
        Intrinsics.checkNotNullParameter(r101, "msg");
        t2 r103 = this.f38820a;
        if (r102 != null) goto L5;
        r102 = new UploadFileResultModel();
    L5:
        r102.b(r100);
        r102.d(r101);
        r103.finishWithResult(r102);
    }
}
