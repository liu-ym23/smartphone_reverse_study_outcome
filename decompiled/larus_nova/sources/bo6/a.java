package bo6;

import com.bytedance.locallife.model.response.BaseResponse;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lbo6/a;", "Lcom/bytedance/locallife/model/response/BaseResponse;", "Lcom/google/gson/JsonObject;", "ugExtendArea", "Lcom/google/gson/JsonObject;", "getUgExtendArea", "()Lcom/google/gson/JsonObject;", "toast", "getToast", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final class a extends BaseResponse {

    @SerializedName("toast")
    private final JsonObject toast;

    @SerializedName("ug_extend_area")
    private final JsonObject ugExtendArea;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.ugExtendArea, r101.ugExtendArea) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.toast, r101.toast) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        JsonObject r100 = this.ugExtendArea;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        JsonObject r104 = this.toast;
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
        return "AccomplishTaskData(ugExtendArea=" + this.ugExtendArea + ", toast=" + this.toast + ')';
    }

    public a() {
        this.ugExtendArea = null;
        this.toast = null;
    }
}
