package com.bytedance.android.live.browser.jsbridge.upload;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.GetPictureResultModel;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class w<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ x f64093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f64094b;

    public w(x r100, String r101) {
        this.f64093a = r100;
        this.f64094b = r101;
    }

    @Override // bolts.Continuation
    public final Object then(Task r100) {
        x r101 = this.f64093a;
        GetPictureResultModel r102 = new GetPictureResultModel();
        GetPictureResultModel.a r103 = new GetPictureResultModel.a();
        r103.b(MSkiaImageRegionDecoder.FILE_PREFIX + this.f64094b);
        r103.a("data:image/png;base64," + ((String) r100.getResult()));
        Unit r104 = Unit.INSTANCE;
        r102.a(r103);
        r101.finishWithResult(r102);
        return Unit.INSTANCE;
    }
}
