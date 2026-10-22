package ad2;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdk.jsbridge.methods.upload.UploadMediaResultModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
public final class a0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t f2943a;

    public a0(t r100) {
        this.f2943a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        UploadMediaResultModel r101 = new UploadMediaResultModel();
        UploadMediaResultModel.a r102 = new UploadMediaResultModel.a();
        List r103 = (List) r100;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L4:
        if (r105.hasNext() == false) goto L15;
        ImageModel r106 = (ImageModel) r105.next();
        UploadMediaResultModel.b r107 = new UploadMediaResultModel.b();
        String r108 = null;
        if (r106 == null) goto L10;
        List<String> r109 = r106.mUrls;
        if (r109 == null) goto L10;
        String r110 = (String) ListProtector.get(r109, 0);
    L11:
        r107.b(r110);
        if (r106 == null) goto L14;
        r108 = r106.mUri;
    L14:
        r107.a(r108);
        r104.add(r107);
    L10:
        r110 = null;
        goto L11
    L15:
        r102.a(r104);
        Unit r111 = Unit.INSTANCE;
        r101.b(r102);
        this.f2943a.finishWithResult(r101);
    }
}
