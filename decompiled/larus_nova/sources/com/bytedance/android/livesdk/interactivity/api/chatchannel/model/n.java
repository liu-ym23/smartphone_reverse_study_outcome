package com.bytedance.android.livesdk.interactivity.api.chatchannel.model;

import com.bytedance.android.live.base.annotation.ForMain;
import com.bytedance.android.live.base.model.user.User;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@ForMain
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0019\u0010\r\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/api/chatchannel/model/n;", "", "", RemoteMessageConst.MSGID, "J", "getMsgId", "()J", "", "content", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "getContent$annotations", "()V", "eventTime", "getEventTime", "fromUid", "getFromUid", "toUid", "getToUid", "Lcom/bytedance/android/live/base/model/user/User;", "user", "Lcom/bytedance/android/live/base/model/user/User;", "b", "()Lcom/bytedance/android/live/base/model/user/User;", "getUser$annotations", "<init>", "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class n implements vh7.h {

    @SerializedName("content")
    protected String content;

    @SerializedName("event_time")
    protected long eventTime;

    @SerializedName("from_uid")
    protected long fromUid;

    @SerializedName("msg_id")
    protected long msgId;

    @SerializedName("to_uid")
    protected long toUid;

    @SerializedName("user")
    protected User user;

    public n() {
    }

    public final String a() {
        return this.content;
    }

    public final User b() {
        return this.user;
    }

    public n(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L13;
        switch(r102) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L6;
        };
    L7:
        this.user = new User(r100);
        goto L3
    L8:
        this.toUid = r100.j();
        goto L3
    L9:
        this.fromUid = r100.j();
        goto L3
    L10:
        this.eventTime = r100.j();
        goto L3
    L11:
        this.content = am3.h.c(r100);
        goto L3
    L12:
        this.msgId = r100.j();
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
