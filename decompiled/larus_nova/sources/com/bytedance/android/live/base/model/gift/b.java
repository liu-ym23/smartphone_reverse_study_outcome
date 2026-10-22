package com.bytedance.android.live.base.model.gift;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.gift.ExhibitionAdvancedTask")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/b;", "", "", "groupId", "J", "getGroupId", "()J", "", com.heytap.mcssdk.constant.b.f276354d, "Ljava/lang/String;", "getTaskID", "()Ljava/lang/String;", "threshold", "getThreshold", "currentCount", "getCurrentCount", "reward_star_count", "getReward_star_count", "", "isFinished", "Z", "()Z", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("current_count")
    protected long currentCount;

    @SerializedName("group_id")
    protected long groupId;

    @SerializedName("is_finished")
    protected boolean isFinished;

    @SerializedName("reward_star_count")
    protected long reward_star_count;

    @SerializedName("task_id")
    protected String taskID;

    @SerializedName("threshold")
    protected long threshold;

    public b() {
        this.groupId = 0;
        this.taskID = "";
        this.threshold = 0;
        this.currentCount = 0;
        this.reward_star_count = 0;
        this.isFinished = false;
    }

    public b(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L13;
        switch(r103) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.isFinished = am3.h.a(r100);
        r102 = r102 | 16;
        goto L3
    L8:
        this.reward_star_count = r100.j();
        r102 = r102 | 8;
        goto L3
    L9:
        this.currentCount = r100.j();
        r102 = r102 | 4;
        goto L3
    L10:
        this.threshold = r100.j();
        r102 = r102 | 2;
        goto L3
    L11:
        this.taskID = am3.h.c(r100);
        goto L3
    L12:
        this.groupId = r100.j();
        r102 = r102 | 1;
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L17;
        this.groupId = 0;
    L17:
        if (this.taskID != null) goto L20;
        this.taskID = "";
    L20:
        if ((r102 & 2) != 0) goto L23;
        this.threshold = 0;
    L23:
        if ((r102 & 4) != 0) goto L26;
        this.currentCount = 0;
    L26:
        if ((r102 & 8) != 0) goto L29;
        this.reward_star_count = 0;
    L29:
        if ((r102 & 16) != 0) goto L48;
        this.isFinished = false;
        return;
    }
}
