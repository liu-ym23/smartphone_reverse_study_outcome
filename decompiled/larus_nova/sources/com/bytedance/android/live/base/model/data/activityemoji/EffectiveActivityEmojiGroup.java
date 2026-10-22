package com.bytedance.android.live.base.model.data.activityemoji;

import am3.g;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.google.gson.annotations.SerializedName;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/data/activityemoji/EffectiveActivityEmojiGroup;", "", "()V", "emojiGroup", "Lcom/bytedance/android/live/base/model/data/activityemoji/ActivityEmojiGroup;", "getEmojiGroup", "()Lcom/bytedance/android/live/base/model/data/activityemoji/ActivityEmojiGroup;", "setEmojiGroup", "(Lcom/bytedance/android/live/base/model/data/activityemoji/ActivityEmojiGroup;)V", "endTime", "", "getEndTime", "()J", "setEndTime", "(J)V", DyPayConstant.KEY_START_TIME, "getStartTime", "setStartTime", "live-business-message-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class EffectiveActivityEmojiGroup implements h {

    @SerializedName("emoji_group")
    protected ActivityEmojiGroup emojiGroup;

    @SerializedName("end_time")
    protected long endTime;

    @SerializedName(ILoadStallMonitor.START_TIME)
    protected long startTime;

    public EffectiveActivityEmojiGroup() {
    }

    public final ActivityEmojiGroup getEmojiGroup() {
        return this.emojiGroup;
    }

    public final long getEndTime() {
        return this.endTime;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public EffectiveActivityEmojiGroup(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.emojiGroup = new ActivityEmojiGroup(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.startTime = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.endTime = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setEmojiGroup(ActivityEmojiGroup r100) {
        this.emojiGroup = r100;
    }

    public final void setEndTime(long r100) {
        this.endTime = r100;
    }

    public final void setStartTime(long r100) {
        this.startTime = r100;
    }
}
