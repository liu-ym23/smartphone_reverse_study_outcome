package com.bytedance.android.ec.window.base.repository.vo;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/ec/window/base/repository/vo/WindowSearchSuggestWord;", "Ljava/io/Serializable;", "()V", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getIcon", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "id", "", "getId", "()Ljava/lang/String;", "index", "", "getIndex", "()I", "setIndex", "(I)V", "params", "Lcom/bytedance/android/ec/window/base/repository/vo/WindowSuggestWordParams;", "getParams", "()Lcom/bytedance/android/ec/window/base/repository/vo/WindowSuggestWordParams;", "trimWord", "getTrimWord", "setTrimWord", "(Ljava/lang/String;)V", EffectConfiguration.KEY_SEARCH_WORD, "getWord", "wordsType", "getWordsType", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class WindowSearchSuggestWord implements Serializable {

    @SerializedName("words_icon")
    private final ECUrlModel icon;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f49459id;
    private int index;

    @SerializedName("params")
    private final WindowSuggestWordParams params;
    private String trimWord;

    @SerializedName(EffectConfiguration.KEY_SEARCH_WORD)
    private final String word;

    @SerializedName("words_type")
    private final String wordsType;

    public WindowSearchSuggestWord() {
    }

    public final ECUrlModel getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.f49459id;
    }

    public final int getIndex() {
        return this.index;
    }

    public final WindowSuggestWordParams getParams() {
        return this.params;
    }

    public final String getTrimWord() {
        return this.trimWord;
    }

    public final String getWord() {
        return this.word;
    }

    public final String getWordsType() {
        return this.wordsType;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setTrimWord(String r100) {
        this.trimWord = r100;
    }
}
