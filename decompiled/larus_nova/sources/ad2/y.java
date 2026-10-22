package ad2;

import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class y<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3004a;

    public y(t r100) {
        this.f3004a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.jsbridge.methods.upload.models.d r101 = (com.bytedance.android.livesdk.jsbridge.methods.upload.models.d) r100;
        UploadMediaResultModel r102 = new UploadMediaResultModel();
        UploadMediaResultModel.a r103 = new UploadMediaResultModel.a();
        UploadMediaResultModel.c r104 = new UploadMediaResultModel.c();
        r104.b(r101.f142217a);
        r104.a(r101.f142218b);
        r104.c(r101.f142219c);
        r103.c(CollectionsKt.listOf(r104));
        r102.b(r103);
        this.f3004a.finishWithResult(r102);
    }
}
