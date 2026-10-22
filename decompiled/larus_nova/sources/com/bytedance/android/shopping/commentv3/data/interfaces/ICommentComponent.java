package com.bytedance.android.shopping.commentv3.data.interfaces;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/data/interfaces/ICommentComponent;", "Ljava/io/Serializable;", "()V", "componentType", "", "getComponentType", "()Ljava/lang/String;", "setComponentType", "(Ljava/lang/String;)V", "viewType", "getViewType", "setViewType", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ICommentComponent implements Serializable {

    @SerializedName("component_type")
    private String componentType;

    @SerializedName(BytedCertConstant.IntentKey.VIEW_TYPE)
    private String viewType;

    public ICommentComponent() {
    }

    public final String getComponentType() {
        return this.componentType;
    }

    public final String getViewType() {
        return this.viewType;
    }

    public final void setComponentType(String r100) {
        this.componentType = r100;
    }

    public final void setViewType(String r100) {
        this.viewType = r100;
    }
}
