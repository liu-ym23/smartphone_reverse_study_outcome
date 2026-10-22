package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b;\u0010<R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR$\u0010!\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0019\u001a\u0004\b\"\u0010\u001b\"\u0004\b#\u0010\u001dR$\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R\"\u00102\u001a\u0002018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R*\u00108\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u000f\u001a\u0004\b9\u0010\u0011\"\u0004\b:\u0010\u0013¨\u0006="}, d2 = {"Lcom/bytedance/android/format/model/AiPlayDramaBriefResultResponseData;", "Ljava/io/Serializable;", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "setPlayId", "(Ljava/lang/String;)V", "openMessage", "getOpenMessage", "setOpenMessage", "", "Lcom/bytedance/android/format/model/t;", "chapterList", "Ljava/util/List;", "getChapterList", "()Ljava/util/List;", "setChapterList", "(Ljava/util/List;)V", "scriptTagList", "getScriptTagList", "setScriptTagList", "Lcom/bytedance/android/format/model/o0;", "openVideo", "Lcom/bytedance/android/format/model/o0;", "getOpenVideo", "()Lcom/bytedance/android/format/model/o0;", "setOpenVideo", "(Lcom/bytedance/android/format/model/o0;)V", "openVideoFirstFrame", "getOpenVideoFirstFrame", "setOpenVideoFirstFrame", "aiOpenVideo", "getAiOpenVideo", "setAiOpenVideo", "aiOpenVideoFirstFrame", "getAiOpenVideoFirstFrame", "setAiOpenVideoFirstFrame", "", "generateStatus", "Ljava/lang/Integer;", "getGenerateStatus", "()Ljava/lang/Integer;", "setGenerateStatus", "(Ljava/lang/Integer;)V", "nextReqWaitInterval", "getNextReqWaitInterval", "setNextReqWaitInterval", "", "hasModified", "Z", "getHasModified", "()Z", "setHasModified", "(Z)V", "candidateOpenVideoList", "getCandidateOpenVideoList", "setCandidateOpenVideoList", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AiPlayDramaBriefResultResponseData implements Serializable {

    @SerializedName("ai_open_video")
    private o0 aiOpenVideo;

    @SerializedName("ai_open_video_first_frame")
    private o0 aiOpenVideoFirstFrame;
    private List<o0> candidateOpenVideoList;

    @SerializedName("chapter_list")
    private List<t> chapterList;

    @SerializedName("drama_edit_status")
    private Integer generateStatus;
    private boolean hasModified;

    @SerializedName("next_req_wait_time_s")
    private Integer nextReqWaitInterval;

    @SerializedName("open")
    private String openMessage;

    @SerializedName("open_video")
    private o0 openVideo;

    @SerializedName("open_video_first_frame")
    private o0 openVideoFirstFrame;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private String playId;

    @SerializedName("script_tag_list")
    private List<String> scriptTagList;

    public AiPlayDramaBriefResultResponseData() {
        this.candidateOpenVideoList = new ArrayList();
    }

    public final o0 getAiOpenVideo() {
        return this.aiOpenVideo;
    }

    public final o0 getAiOpenVideoFirstFrame() {
        return this.aiOpenVideoFirstFrame;
    }

    public final List<o0> getCandidateOpenVideoList() {
        return this.candidateOpenVideoList;
    }

    public final List<t> getChapterList() {
        return this.chapterList;
    }

    public final Integer getGenerateStatus() {
        return this.generateStatus;
    }

    public final boolean getHasModified() {
        return this.hasModified;
    }

    public final Integer getNextReqWaitInterval() {
        return this.nextReqWaitInterval;
    }

    public final String getOpenMessage() {
        return this.openMessage;
    }

    public final o0 getOpenVideo() {
        return this.openVideo;
    }

    public final o0 getOpenVideoFirstFrame() {
        return this.openVideoFirstFrame;
    }

    public final String getPlayId() {
        return this.playId;
    }

    public final List<String> getScriptTagList() {
        return this.scriptTagList;
    }

    public final void setAiOpenVideo(o0 r100) {
        this.aiOpenVideo = r100;
    }

    public final void setAiOpenVideoFirstFrame(o0 r100) {
        this.aiOpenVideoFirstFrame = r100;
    }

    public final void setCandidateOpenVideoList(List<o0> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.candidateOpenVideoList = r100;
    }

    public final void setChapterList(List<t> r100) {
        this.chapterList = r100;
    }

    public final void setGenerateStatus(Integer r100) {
        this.generateStatus = r100;
    }

    public final void setHasModified(boolean r100) {
        this.hasModified = r100;
    }

    public final void setNextReqWaitInterval(Integer r100) {
        this.nextReqWaitInterval = r100;
    }

    public final void setOpenMessage(String r100) {
        this.openMessage = r100;
    }

    public final void setOpenVideo(o0 r100) {
        this.openVideo = r100;
    }

    public final void setOpenVideoFirstFrame(o0 r100) {
        this.openVideoFirstFrame = r100;
    }

    public final void setPlayId(String r100) {
        this.playId = r100;
    }

    public final void setScriptTagList(List<String> r100) {
        this.scriptTagList = r100;
    }
}
