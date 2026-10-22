package com.bytedance.android.livesdk.jsbridge.methods;

import bolts.Continuation;
import bolts.Task;
import com.bytedance.android.live.browser.jsbridge.base.OpenMultiSelectPhotoLibraryResultModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class z2<TTaskResult, TContinuationResult> implements Continuation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w2 f142259a;

    public z2(w2 r100) {
        this.f142259a = r100;
    }

    @Override // bolts.Continuation
    public final Object then(Task r100) {
        Iterator r101 = ((List) r100.getResult()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((OpenMultiSelectPhotoLibraryResultModel.b) r101.next()).a();
        goto L4
    L6:
        w2 r102 = this.f142259a;
        OpenMultiSelectPhotoLibraryResultModel r103 = new OpenMultiSelectPhotoLibraryResultModel();
        OpenMultiSelectPhotoLibraryResultModel.a r104 = new OpenMultiSelectPhotoLibraryResultModel.a();
        r104.a((List) r100.getResult());
        Unit r105 = Unit.INSTANCE;
        r103.a(r104);
        r102.finishWithResult(r103);
        return Unit.INSTANCE;
    }
}
