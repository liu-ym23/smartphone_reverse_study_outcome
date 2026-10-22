package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/config/j5;", "", "", "titleVisible", "Ljava/lang/Integer;", "guideVisible", "smallCardPreviewTime", "disableSubmitButton", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j5 {

    @SerializedName("disable_submit_button")
    public Integer disableSubmitButton;

    @SerializedName("slide_guide_visible")
    public Integer guideVisible;

    @SerializedName("small_card_preview_time")
    public Integer smallCardPreviewTime;

    @SerializedName("feedback_title_visible")
    public Integer titleVisible;

    public j5() {
        this.titleVisible = 1;
        this.guideVisible = 1;
        this.smallCardPreviewTime = 5;
        this.disableSubmitButton = 1;
    }
}
