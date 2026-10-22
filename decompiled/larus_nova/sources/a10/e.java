package a10;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"La10/e;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "La10/a;", "data", "La10/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()La10/a;", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class e {

    @SerializedName("data")
    private final a data;

    @SerializedName("type")
    private final String type;

    public e() {
        this("", null);
    }

    public final a a() {
        return this.data;
    }

    public final String getType() {
        return this.type;
    }

    public e(String r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.data = r101;
    }
}
