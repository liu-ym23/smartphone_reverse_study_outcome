package com.bytedance.android.shopping.anchorv3.detail.vo;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/shopping/anchorv3/detail/vo/AuthorizationDialogImageInfo;", "Ljava/io/Serializable;", "()V", "values", "Lcom/bytedance/android/shopping/anchorv3/detail/vo/DialogImageInfo;", "getValues", "()Lcom/bytedance/android/shopping/anchorv3/detail/vo/DialogImageInfo;", "setValues", "(Lcom/bytedance/android/shopping/anchorv3/detail/vo/DialogImageInfo;)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AuthorizationDialogImageInfo implements Serializable {

    @SerializedName("images")
    private DialogImageInfo values;

    public AuthorizationDialogImageInfo() {
    }

    public final DialogImageInfo getValues() {
        return this.values;
    }

    public final void setValues(DialogImageInfo r100) {
        this.values = r100;
    }
}
