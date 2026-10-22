package com.bytedance.android.livesdk.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdk/model/XTCategory;", "Ljava/io/Serializable;", "()V", "mCategoryId", "", "getMCategoryId", "()Ljava/lang/String;", "setMCategoryId", "(Ljava/lang/String;)V", "mCategoryName", "getMCategoryName", "setMCategoryName", "mGameCategoryId", "getMGameCategoryId", "setMGameCategoryId", "mGameCategoryName", "getMGameCategoryName", "setMGameCategoryName", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class XTCategory implements Serializable {

    @SerializedName("category_id")
    private String mCategoryId;

    @SerializedName("category_name")
    private String mCategoryName;

    @SerializedName("game_category_id")
    private String mGameCategoryId;

    @SerializedName("game_category_name")
    private String mGameCategoryName;

    public XTCategory() {
    }

    public final String getMCategoryId() {
        return this.mCategoryId;
    }

    public final String getMCategoryName() {
        return this.mCategoryName;
    }

    public final String getMGameCategoryId() {
        return this.mGameCategoryId;
    }

    public final String getMGameCategoryName() {
        return this.mGameCategoryName;
    }

    public final void setMCategoryId(String r100) {
        this.mCategoryId = r100;
    }

    public final void setMCategoryName(String r100) {
        this.mCategoryName = r100;
    }

    public final void setMGameCategoryId(String r100) {
        this.mGameCategoryId = r100;
    }

    public final void setMGameCategoryName(String r100) {
        this.mGameCategoryName = r100;
    }
}
