package ad2;

import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class w<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3002a;

    public w(t r100) {
        this.f3002a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UploadMediaResultModel r101 = new UploadMediaResultModel();
        UploadMediaResultModel.a r102 = new UploadMediaResultModel.a();
        r102.d(CollectionsKt.listOf((com.bytedance.android.livesdk.jsbridge.methods.upload.models.e) r100));
        r101.b(r102);
        r101.a(UploadMediaResultModel.Code.Success);
        this.f3002a.finishWithResult(r101);
    }
}
