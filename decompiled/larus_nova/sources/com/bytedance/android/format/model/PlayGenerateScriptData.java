package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/bytedance/android/format/model/PlayGenerateScriptData;", "", "", "scriptId", "Ljava/lang/String;", "getScriptId", "()Ljava/lang/String;", "setScriptId", "(Ljava/lang/String;)V", "playId", "getPlayId", "setPlayId", "openVideoVid", "getOpenVideoVid", "setOpenVideoVid", "openText", "getOpenText", "setOpenText", "Lcom/bytedance/android/format/model/o0;", "bgm", "Lcom/bytedance/android/format/model/o0;", "getBgm", "()Lcom/bytedance/android/format/model/o0;", "setBgm", "(Lcom/bytedance/android/format/model/o0;)V", "", "Lcom/bytedance/android/format/model/t;", "chapterList", "Ljava/util/List;", "getChapterList", "()Ljava/util/List;", "setChapterList", "(Ljava/util/List;)V", "", "rewrite", "Ljava/lang/Boolean;", "getRewrite", "()Ljava/lang/Boolean;", "setRewrite", "(Ljava/lang/Boolean;)V", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlayGenerateScriptData {

    @SerializedName("bgm")
    private o0 bgm;

    @SerializedName("chapter_list")
    private List<t> chapterList;

    @SerializedName("open_text")
    private String openText;

    @SerializedName("open_video_vid")
    private String openVideoVid;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private String playId;

    @SerializedName("rewrite")
    private Boolean rewrite;

    @SerializedName("script_id")
    private String scriptId;

    public PlayGenerateScriptData() {
    }

    public final o0 getBgm() {
        return this.bgm;
    }

    public final List<t> getChapterList() {
        return this.chapterList;
    }

    public final String getOpenText() {
        return this.openText;
    }

    public final String getOpenVideoVid() {
        return this.openVideoVid;
    }

    public final String getPlayId() {
        return this.playId;
    }

    public final Boolean getRewrite() {
        return this.rewrite;
    }

    public final String getScriptId() {
        return this.scriptId;
    }

    public final void setBgm(o0 r100) {
        this.bgm = r100;
    }

    public final void setChapterList(List<t> r100) {
        this.chapterList = r100;
    }

    public final void setOpenText(String r100) {
        this.openText = r100;
    }

    public final void setOpenVideoVid(String r100) {
        this.openVideoVid = r100;
    }

    public final void setPlayId(String r100) {
        this.playId = r100;
    }

    public final void setRewrite(Boolean r100) {
        this.rewrite = r100;
    }

    public final void setScriptId(String r100) {
        this.scriptId = r100;
    }
}
