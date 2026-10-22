package com.bytedance.android.live.effect.sticker.api;

import com.bytedance.android.live.base.model.ImageModel;
import com.google.gson.annotations.SerializedName;
import com.heytap.mcssdk.constant.b;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.ugc.effectmanager.MobConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001e\u0010\u001f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\b¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/effect/sticker/api/AigcBackgroundImageGenerateTask;", "", "()V", "effectID", "", "getEffectID", "()J", "setEffectID", "(J)V", "finishType", "", "getFinishType", "()I", "setFinishType", "(I)V", "imageList", "", "Lcom/bytedance/android/live/base/model/ImageModel;", "getImageList", "()Ljava/util/List;", "setImageList", "(Ljava/util/List;)V", "keyWord", "", "getKeyWord", "()Ljava/lang/String;", "setKeyWord", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", b.f276354d, "getTaskID", "setTaskID", "liveeffect_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AigcBackgroundImageGenerateTask {

    @SerializedName(MobConstants.EFFECT_ID)
    private long effectID;

    @SerializedName("finish_reason")
    private int finishType;

    @SerializedName("aigc_background")
    private List<ImageModel> imageList;

    @SerializedName(EventConstant.Key.RETAIN_PROMPT)
    private String keyWord;

    @SerializedName("status")
    private int status;

    @SerializedName("task_id")
    private long taskID;

    public AigcBackgroundImageGenerateTask() {
        this.keyWord = "";
        this.imageList = new ArrayList();
    }

    public final long getEffectID() {
        return this.effectID;
    }

    public final int getFinishType() {
        return this.finishType;
    }

    public final List<ImageModel> getImageList() {
        return this.imageList;
    }

    public final String getKeyWord() {
        return this.keyWord;
    }

    public final int getStatus() {
        return this.status;
    }

    public final long getTaskID() {
        return this.taskID;
    }

    public final void setEffectID(long r100) {
        this.effectID = r100;
    }

    public final void setFinishType(int r100) {
        this.finishType = r100;
    }

    public final void setImageList(List<ImageModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.imageList = r100;
    }

    public final void setKeyWord(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.keyWord = r100;
    }

    public final void setStatus(int r100) {
        this.status = r100;
    }

    public final void setTaskID(long r100) {
        this.taskID = r100;
    }
}
