package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/WindowPromotionSearchSuggestWord;", "Ljava/io/Serializable;", "()V", "params", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowSearchSuggestWordParams;", "getParams", "()Lcom/bytedance/android/ec/window/base/repository/vo/WindowSearchSuggestWordParams;", "source", "", "getSource", "()Ljava/lang/String;", "type", "getType", BitableAnalytic.LocationClickType.WORDS, "", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowSearchSuggestWord;", "getWords", "()Ljava/util/List;", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowPromotionSearchSuggestWord implements Serializable {

    @SerializedName("params")
    private final WindowSearchSuggestWordParams params;

    @SerializedName("source")
    private final String source;

    @SerializedName("type")
    private final String type;

    @SerializedName(BitableAnalytic.LocationClickType.WORDS)
    private final List<WindowSearchSuggestWord> words;

    public WindowPromotionSearchSuggestWord() {
    }

    public final WindowSearchSuggestWordParams getParams() {
        return this.params;
    }

    public final String getSource() {
        return this.source;
    }

    public final String getType() {
        return this.type;
    }

    public final List<WindowSearchSuggestWord> getWords() {
        return this.words;
    }
}
