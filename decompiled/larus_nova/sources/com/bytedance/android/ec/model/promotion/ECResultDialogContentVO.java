package com.bytedance.android.ec.model.promotion;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/ec/model/promotion/ECResultDialogContentVO;", "Ljava/io/Serializable;", "()V", "cancel", "", "getCancel", "()Ljava/lang/String;", "confirm", "getConfirm", "content", "getContent", "title", "getTitle", "url", "getUrl", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECResultDialogContentVO implements Serializable {

    @SerializedName("cancel")
    private final String cancel;

    @SerializedName("confirm")
    private final String confirm;

    @SerializedName("content")
    private final String content;

    @SerializedName("title")
    private final String title;

    @SerializedName("url")
    private final String url;

    public ECResultDialogContentVO() {
    }

    public final String getCancel() {
        return this.cancel;
    }

    public final String getConfirm() {
        return this.confirm;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }
}
