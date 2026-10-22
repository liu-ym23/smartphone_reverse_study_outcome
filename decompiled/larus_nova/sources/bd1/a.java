package bd1;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.wallet.model.d;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.GsonBuilder;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18640a = null;

    static {
        f18640a = new a();
    }

    public a() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        if (r101.statusCode == 0) goto L8;
        ApiServerException r102 = new ApiServerException(r101.statusCode);
        r102.setExtra(GsonProtectorUtils.toJson(new GsonBuilder().create(), r101.extra));
        T r103 = r101.data;
        if (r103 == null) goto L9;
        r102.setErrorMsg(((d) r103).a());
        r102.setPrompt(((d) r101.data).a());
        throw r102;
    L9:
        throw r102;
    }
}
