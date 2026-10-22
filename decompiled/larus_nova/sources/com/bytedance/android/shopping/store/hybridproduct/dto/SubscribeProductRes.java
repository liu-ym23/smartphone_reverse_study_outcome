package com.bytedance.android.shopping.store.hybridproduct.dto;

import com.bytedance.android.ec.model.api.CommerceBaseResponse;
import com.google.gson.annotations.SerializedName;
import dj3.i;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/hybridproduct/dto/SubscribeProductRes;", "Lcom/bytedance/android/ec/model/api/CommerceBaseResponse;", "", "buttonDisplay", "Ljava/lang/String;", "getButtonDisplay", "()Ljava/lang/String;", "toastDisplay", "getToastDisplay", "", "Ldj3/i;", "successRes", "Ljava/util/Map;", "getSuccessRes", "()Ljava/util/Map;", "failRes", "getFailRes", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SubscribeProductRes extends CommerceBaseResponse {

    @SerializedName("button_display")
    private final String buttonDisplay;

    @SerializedName("fail_res")
    private final Map<String, String> failRes;

    @SerializedName("success_res")
    private final Map<String, i> successRes;

    @SerializedName("toast_display")
    private final String toastDisplay;

    public SubscribeProductRes() {
    }

    public final String getButtonDisplay() {
        return this.buttonDisplay;
    }

    public final Map<String, String> getFailRes() {
        return this.failRes;
    }

    public final Map<String, i> getSuccessRes() {
        return this.successRes;
    }

    public final String getToastDisplay() {
        return this.toastDisplay;
    }
}
