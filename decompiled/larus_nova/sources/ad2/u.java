package ad2;

import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f3000a;

    public u(t r100) {
        this.f3000a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UploadMediaResultModel r101 = new UploadMediaResultModel();
        UploadMediaResultModel.a r102 = new UploadMediaResultModel.a();
        r102.b((List) r100);
        r101.b(r102);
        r101.a(UploadMediaResultModel.Code.Success);
        this.f3000a.finishWithResult(r101);
    }
}
