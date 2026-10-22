package bo6;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lbo6/f;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Lbo6/c;", "lifePendantBizData", "Lbo6/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lbo6/c;", "Lbo6/d;", "lifePendantInfo", "Lbo6/d;", "b", "()Lbo6/d;", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class f extends BaseResponse {

    @SerializedName("life_pendant_biz_data")
    private final c lifePendantBizData;

    @SerializedName("life_pendant_info")
    private final d lifePendantInfo;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.lifePendantBizData, r101.lifePendantBizData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.lifePendantInfo, r101.lifePendantInfo) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        c r100 = this.lifePendantBizData;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        d r104 = this.lifePendantInfo;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    @Override // com.bytedance.locallife.model.response.BaseResponse
    public final String toString() {
        return "PendantData(lifePendantBizData=" + this.lifePendantBizData + ", lifePendantInfo=" + this.lifePendantInfo + ')';
    }

    public f() {
        this.lifePendantBizData = null;
        this.lifePendantInfo = null;
    }

    public final c a() {
        return this.lifePendantBizData;
    }

    public final d b() {
        return this.lifePendantInfo;
    }
}
