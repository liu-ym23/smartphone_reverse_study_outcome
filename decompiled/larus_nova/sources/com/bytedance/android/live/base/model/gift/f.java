package com.bytedance.android.live.base.model.gift;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.gift.ExhibitionStarInfo")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/live/base/model/gift/f;", "", "", "groupId", "J", "getGroupId", "()J", "", com.heytap.mcssdk.constant.b.f276354d, "Ljava/lang/String;", "getTaskID", "()Ljava/lang/String;", "threshold", "getThreshold", "currentCount", "getCurrentCount", "", "hasReward", "Z", "getHasReward", "()Z", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f implements vh7.h {

    @SerializedName("current_count")
    protected long currentCount;

    @SerializedName("group_id")
    protected long groupId;

    @SerializedName("has_reward")
    protected boolean hasReward;

    @SerializedName("task_id")
    protected String taskID;

    @SerializedName("threshold")
    protected long threshold;

    public f() {
        this.groupId = 0;
        this.taskID = "";
        this.threshold = 0;
        this.currentCount = 0;
        this.hasReward = false;
    }

    public f(am3.g r100) {
        long r101 = r100.c();
        int r102 = 0;
    L3:
        int r103 = r100.f();
        if (r103 == (-1)) goto L21;
        if (r103 != 1) goto L8;
        this.groupId = r100.j();
        r102 = r102 | 1;
        goto L3
    L8:
        if (r103 != 2) goto L10;
        this.taskID = am3.h.c(r100);
        goto L3
    L10:
        if (r103 != 3) goto L12;
        this.threshold = r100.j();
        r102 = r102 | 2;
        goto L3
    L12:
        if (r103 != 4) goto L14;
        this.currentCount = r100.j();
        r102 = r102 | 4;
        goto L3
    L14:
        if (r103 != 5) goto L15;
        this.hasReward = am3.h.a(r100);
        r102 = r102 | 8;
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
        if ((r102 & 1) != 0) goto L25;
        this.groupId = 0;
    L25:
        if (this.taskID != null) goto L28;
        this.taskID = "";
    L28:
        if ((r102 & 2) != 0) goto L31;
        this.threshold = 0;
    L31:
        if ((r102 & 4) != 0) goto L34;
        this.currentCount = 0;
    L34:
        if ((r102 & 8) != 0) goto L55;
        this.hasReward = false;
        return;
    }
}
