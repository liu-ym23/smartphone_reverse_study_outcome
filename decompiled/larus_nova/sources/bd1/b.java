package bd1;

import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.wallet.model.MinorExtraJson;
import com.bytedance.android.live.wallet.model.d;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class b<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18641a = null;

    static {
        f18641a = new b();
    }

    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        Intrinsics.checkNotNullParameter(r101, "resp");
        MinorExtraJson r102 = (MinorExtraJson) r101.extra;
        if (r102 == null) goto L5;
        String r103 = r102.getTwoFactorAuthInfo();
    L6:
        if (r103 != null) goto L8;
    L11:
        boolean r104 = true;
    L12:
        if (r104 == true) goto L14;
        ApiServerException r105 = new ApiServerException(-666666);
        r105.setExtra(((MinorExtraJson) r101.extra).getTwoFactorAuthInfo());
        throw r105;
    L14:
        return (d) r101.data;
    L8:
        if (r103.length() == 0) goto L11;
        r104 = false;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
