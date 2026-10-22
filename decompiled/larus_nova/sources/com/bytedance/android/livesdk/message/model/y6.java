package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006R\u001a\u0010\u0015\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u000e\u001a\u0004\b\u001a\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/y6;", "", "", DBDefinition.TASK_ID, "J", "getTaskId", "()J", "", "type", "I", "getType", "()I", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "duration", "getDuration", "guestNum", "getGuestNum", "totalScore", "getTotalScore", "guestScore", "getGuestScore", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class y6 implements vh7.h {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String desc;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("guest_num")
    protected long guestNum;

    @SerializedName("guest_score")
    protected long guestScore;

    @SerializedName("task_id")
    protected long taskId;

    @SerializedName("total_score")
    protected long totalScore;

    @SerializedName("type")
    protected int type;

    public y6() {
        this.extra = "";
    }

    public final int getType() {
        return this.type;
    }

    public y6(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L17;
        if (r102 != 100) goto L7;
        this.extra = am3.h.c(r100);
        goto L3
    L7:
        switch(r102) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            default: goto L8;
        };
    L9:
        this.guestScore = r100.j();
        goto L3
    L10:
        this.totalScore = r100.j();
        goto L3
    L11:
        this.guestNum = r100.j();
        goto L3
    L12:
        this.duration = r100.j();
        goto L3
    L13:
        this.desc = am3.h.c(r100);
        goto L3
    L14:
        this.type = r100.i();
        goto L3
    L15:
        this.taskId = r100.j();
        goto L3
    L8:
        am3.h.e(r100);
        goto L3
    L17:
        r100.d(r101);
        if (this.extra != null) goto L42;
        this.extra = "";
        return;
    }
}
