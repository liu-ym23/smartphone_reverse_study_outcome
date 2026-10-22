package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b \u0010!R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006¨\u0006\""}, d2 = {"Lcom/bytedance/android/format/model/z0;", "", "Lcom/bytedance/android/format/model/j;", "backgroundImageVideo", "Lcom/bytedance/android/format/model/j;", "getBackgroundImageVideo", "()Lcom/bytedance/android/format/model/j;", "setBackgroundImageVideo", "(Lcom/bytedance/android/format/model/j;)V", "Lcom/bytedance/android/format/model/o0;", "backgroundBgm", "Lcom/bytedance/android/format/model/o0;", "getBackgroundBgm", "()Lcom/bytedance/android/format/model/o0;", "setBackgroundBgm", "(Lcom/bytedance/android/format/model/o0;)V", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "topicMessage", "Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;", "setTopicMessage", "(Lcom/bytedance/android/format/model/FormatLivePlayInfo$TextData;)V", "Lcom/bytedance/android/format/model/k;", "candidateImageVideo", "Lcom/bytedance/android/format/model/k;", "getCandidateImageVideo", "()Lcom/bytedance/android/format/model/k;", "setCandidateImageVideo", "(Lcom/bytedance/android/format/model/k;)V", "backupImageVideo", "getBackupImageVideo", "<init>", "()V", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z0 {

    @SerializedName("bgm")
    private o0 backgroundBgm;

    @SerializedName("background_image_video")
    private j backgroundImageVideo;

    @SerializedName("backup_image_video")
    private final j backupImageVideo;

    @SerializedName("candidate_image_video")
    private k candidateImageVideo;

    @SerializedName("title_message")
    private FormatLivePlayInfo.TextData topicMessage;

    public z0() {
    }

    public final FormatLivePlayInfo.TextData a() {
        return this.topicMessage;
    }
}
