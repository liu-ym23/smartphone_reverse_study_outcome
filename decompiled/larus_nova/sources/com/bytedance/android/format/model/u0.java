package com.bytedance.android.format.model;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.google.gson.annotations.SerializedName;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/format/model/u0;", "", "", "playId", "Ljava/lang/String;", "getPlayId", "()Ljava/lang/String;", "", "taskType", "I", "getTaskType", "()I", "Lcom/bytedance/android/format/model/o0;", "bgm", "Lcom/bytedance/android/format/model/o0;", "getBgm", "()Lcom/bytedance/android/format/model/o0;", "bgImage", "getBgImage", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("bg_image")
    private final o0 bgImage;

    @SerializedName("bgm")
    private final o0 bgm;

    @SerializedName(InstantPlayContext.PLAY_ID)
    private final String playId;

    @SerializedName(AiProactiveTaskViewModel.PARAM_TASK_TYPE)
    private final int taskType;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof u0) == false) goto L14;
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.playId, r101.playId) == true) goto L8;
        return false;
    L8:
        if (this.taskType == r101.taskType) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bgm, r101.bgm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bgImage, r101.bgImage) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.playId;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.taskType) * 31;
        o0 r104 = this.bgm;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        o0 r107 = this.bgImage;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PublishInteractPlayRequest(playId=" + this.playId + ", taskType=" + this.taskType + ", bgm=" + this.bgm + ", bgImage=" + this.bgImage + ")";
    }
}
