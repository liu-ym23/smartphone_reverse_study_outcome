package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECFloatWindowColumnLayout;", "Ljava/io/Serializable;", "()V", "centerMargin", "", "getCenterMargin", "()I", "setCenterMargin", "(I)V", "leftMargin", "getLeftMargin", "setLeftMargin", "rightMargin", "getRightMargin", "setRightMargin", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECFloatWindowColumnLayout implements Serializable {

    @SerializedName("center_margin")
    private int centerMargin;

    @SerializedName("left_margin")
    private int leftMargin;

    @SerializedName("right_margin")
    private int rightMargin;

    public ECFloatWindowColumnLayout() {
        this.leftMargin = 8;
        this.centerMargin = 6;
        this.rightMargin = 8;
    }

    public final int getCenterMargin() {
        return this.centerMargin;
    }

    public final int getLeftMargin() {
        return this.leftMargin;
    }

    public final int getRightMargin() {
        return this.rightMargin;
    }

    public final void setCenterMargin(int r100) {
        this.centerMargin = r100;
    }

    public final void setLeftMargin(int r100) {
        this.leftMargin = r100;
    }

    public final void setRightMargin(int r100) {
        this.rightMargin = r100;
    }
}
