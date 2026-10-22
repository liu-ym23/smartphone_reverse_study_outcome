package com.bytedance.android.ec.window.base.repository.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/dto/h;", "", "Lcom/bytedance/android/ec/window/base/repository/dto/g;", "feedbackEntranceParams", "Lcom/bytedance/android/ec/window/base/repository/dto/g;", "getFeedbackEntranceParams", "()Lcom/bytedance/android/ec/window/base/repository/dto/g;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class h {

    @SerializedName("feedback_entrance_params")
    private final g feedbackEntranceParams;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof h) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.feedbackEntranceParams, ((h) r100).feedbackEntranceParams) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        g r100 = this.feedbackEntranceParams;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "GlobalDoodleConfig(feedbackEntranceParams=" + this.feedbackEntranceParams + ")";
    }
}
