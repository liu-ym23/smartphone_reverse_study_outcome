package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/format/model/t;", "", "", "chapterContent", "Ljava/lang/String;", "getChapterContent", "()Ljava/lang/String;", "setChapterContent", "(Ljava/lang/String;)V", "chapterGoCond", "getChapterGoCond", "setChapterGoCond", "Lcom/bytedance/android/format/model/o0;", "imageMedia", "Lcom/bytedance/android/format/model/o0;", "getImageMedia", "()Lcom/bytedance/android/format/model/o0;", "setImageMedia", "(Lcom/bytedance/android/format/model/o0;)V", "songMedia", "getSongMedia", "setSongMedia", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("brief_content")
    private String chapterContent;

    @SerializedName("brief_go_cond")
    private String chapterGoCond;

    @SerializedName("image_media")
    private o0 imageMedia;

    @SerializedName("song_media")
    private o0 songMedia;

    public t() {
    }
}
