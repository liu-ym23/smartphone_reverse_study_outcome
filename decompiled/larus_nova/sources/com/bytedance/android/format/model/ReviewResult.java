package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000e\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/format/model/ReviewResult;", "Ljava/io/Serializable;", "()V", "image", "Lcom/bytedance/android/format/model/ReviewResult$ItemReviewResult;", "getImage", "()Lcom/bytedance/android/format/model/ReviewResult$ItemReviewResult;", "setImage", "(Lcom/bytedance/android/format/model/ReviewResult$ItemReviewResult;)V", "isPass", "", "()Ljava/lang/Boolean;", "setPass", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "text", "getText", "setText", "video", "getVideo", "setVideo", "ItemReviewResult", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ReviewResult implements Serializable {

    @SerializedName("image")
    private ItemReviewResult image;

    @SerializedName("is_pass")
    private Boolean isPass;

    @SerializedName("text")
    private ItemReviewResult text;

    @SerializedName("video")
    private ItemReviewResult video;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/format/model/ReviewResult$ItemReviewResult;", "Ljava/io/Serializable;", "()V", "isPass", "", "()Ljava/lang/Boolean;", "setPass", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "notPassMessage", "", "getNotPassMessage", "()Ljava/lang/String;", "setNotPassMessage", "(Ljava/lang/String;)V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class ItemReviewResult implements Serializable {

        @SerializedName("is_pass")
        private Boolean isPass;

        @SerializedName("not_pass_message")
        private String notPassMessage;

        public ItemReviewResult() {
        }

        public final String getNotPassMessage() {
            return this.notPassMessage;
        }

        public final Boolean isPass() {
            return this.isPass;
        }

        public final void setNotPassMessage(String r100) {
            this.notPassMessage = r100;
        }

        public final void setPass(Boolean r100) {
            this.isPass = r100;
        }
    }

    public ReviewResult() {
    }

    public final ItemReviewResult getImage() {
        return this.image;
    }

    public final ItemReviewResult getText() {
        return this.text;
    }

    public final ItemReviewResult getVideo() {
        return this.video;
    }

    public final Boolean isPass() {
        return this.isPass;
    }

    public final void setImage(ItemReviewResult r100) {
        this.image = r100;
    }

    public final void setPass(Boolean r100) {
        this.isPass = r100;
    }

    public final void setText(ItemReviewResult r100) {
        this.text = r100;
    }

    public final void setVideo(ItemReviewResult r100) {
        this.video = r100;
    }
}
