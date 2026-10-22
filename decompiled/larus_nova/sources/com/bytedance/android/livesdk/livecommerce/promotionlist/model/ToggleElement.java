package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/ToggleElement;", "Ljava/io/Serializable;", "()V", "author", "Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/ToggleAuthor;", "getAuthor", "()Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/ToggleAuthor;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "text", "", "getText", "()Ljava/lang/String;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ToggleElement implements Serializable {

    @SerializedName("author")
    private final ToggleAuthor author;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("text")
    private final String text;

    public ToggleElement() {
    }

    public final ToggleAuthor getAuthor() {
        return this.author;
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getText() {
        return this.text;
    }
}
