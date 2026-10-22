package ce1;

import com.bytedance.android.livehostapi.business.depend.livead.model.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lce1/a;", "Lcom/bytedance/android/livehostapi/business/depend/livead/model/BaseResponse;", "", "isSigned", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a extends BaseResponse {

    @SerializedName("is_signed")
    private final boolean isSigned;

    public a() {
    }

    public final boolean a() {
        return this.isSigned;
    }
}
