package com.bytedance.android.annie.bridge.method;

import com.bytedance.android.annie.bridge.method.abs.PreloadResourceResultModel;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes43.dex */
public final class i1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n1 f38664a;

    public i1(n1 r100) {
        this.f38664a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 != null) goto L6;
    L8:
        if (r101 != null) goto L11;
    L13:
        if (r101 != null) goto L16;
    L18:
        n1 r102 = this.f38664a;
        PreloadResourceResultModel r103 = new PreloadResourceResultModel();
        r103.a(PreloadResourceResultModel.Code.Failed);
        r103.b("unknown case");
        r102.finishWithResult(r103);
        return;
    L16:
        if (r101.intValue() != 0) goto L18;
        n1 r104 = this.f38664a;
        PreloadResourceResultModel r105 = new PreloadResourceResultModel();
        r105.a(PreloadResourceResultModel.Code.Success);
        r104.finishWithResult(r105);
        return;
    L11:
        if (r101.intValue() != (-1)) goto L13;
        n1 r106 = this.f38664a;
        PreloadResourceResultModel r107 = new PreloadResourceResultModel();
        r107.a(PreloadResourceResultModel.Code.Failed);
        r107.b("forest not init");
        r106.finishWithResult(r107);
        return;
    L6:
        if (r101.intValue() != 302) goto L8;
        n1 r108 = this.f38664a;
        PreloadResourceResultModel r109 = new PreloadResourceResultModel();
        r109.a(PreloadResourceResultModel.Code.InvalidParam);
        r109.b("invalid json config");
        r108.finishWithResult(r109);
    }
}
