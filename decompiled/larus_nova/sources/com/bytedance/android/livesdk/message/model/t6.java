package com.bytedance.android.livesdk.message.model;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\u000e8\u0006X\u0087D¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/t6;", "", "", "withTask", "Z", "getWithTask", "()Z", "", "type", "J", "getType", "()J", "duration", "getDuration", "", SocialConstants.PARAM_APP_DESC, "Ljava/lang/String;", "getDesc", "()Ljava/lang/String;", "sendGiftUserNum", "getSendGiftUserNum", "extra", "getExtra", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class t6 implements vh7.h {

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    protected String desc;

    @SerializedName("duration")
    protected long duration;

    @SerializedName("extra")
    protected String extra;

    @SerializedName("send_gift_user_num")
    protected long sendGiftUserNum;

    @SerializedName("type")
    protected long type;

    @SerializedName("with_task")
    protected boolean withTask;

    public t6() {
        this.extra = "";
    }

    public final long getType() {
        return this.type;
    }

    public t6(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L24;
        if (r102 != 1) goto L8;
        this.withTask = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.type = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.duration = r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.desc = am3.h.c(r100);
        goto L3
    L14:
        if (r102 != 5) goto L16;
        this.sendGiftUserNum = r100.j();
        goto L3
    L16:
        if (r102 != 100) goto L17;
        this.extra = am3.h.c(r100);
        goto L3
    L17:
        am3.h.e(r100);
        goto L3
    L24:
        r100.d(r101);
        if (this.extra != null) goto L49;
        this.extra = "";
        return;
    }
}
