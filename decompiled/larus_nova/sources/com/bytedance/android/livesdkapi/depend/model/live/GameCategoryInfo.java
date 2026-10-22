package com.bytedance.android.livesdkapi.depend.model.live;

import com.alipay.sdk.m.x.d;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GameCategoryInfo;", "", "()V", "categoryId", "", "getCategoryId", "()Ljava/lang/Long;", "setCategoryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "packageName", "", "getPackageName", "()Ljava/lang/String;", "setPackageName", "(Ljava/lang/String;)V", "title", "getTitle", d.f25925o, "warningMsg", "getWarningMsg", "setWarningMsg", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GameCategoryInfo {

    @SerializedName("category_id")
    private Long categoryId;

    @SerializedName("package_name")
    private String packageName;

    @SerializedName("title")
    private String title;

    @SerializedName("warning_msg")
    private String warningMsg;

    public GameCategoryInfo() {
    }

    public final Long getCategoryId() {
        return this.categoryId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getWarningMsg() {
        return this.warningMsg;
    }

    public final void setCategoryId(Long r100) {
        this.categoryId = r100;
    }

    public final void setPackageName(String r100) {
        this.packageName = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setWarningMsg(String r100) {
        this.warningMsg = r100;
    }
}
