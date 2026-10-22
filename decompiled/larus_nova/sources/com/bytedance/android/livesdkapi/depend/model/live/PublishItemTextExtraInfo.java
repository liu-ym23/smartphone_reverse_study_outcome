package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.im.TextExtraItem")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/PublishItemTextExtraInfo;", "", "()V", "start", "", "getStart", "()I", "setStart", "(I)V", "stop", "getStop", "setStop", "type", "getType", "setType", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PublishItemTextExtraInfo implements h {

    @SerializedName("start")
    protected int start;

    @SerializedName("stop")
    protected int stop;

    @SerializedName("type")
    protected int type;

    @SerializedName("user_id")
    protected String userId;

    public PublishItemTextExtraInfo() {
    }

    public final int getStart() {
        return this.start;
    }

    public final int getStop() {
        return this.stop;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public PublishItemTextExtraInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.start = r100.i();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.stop = r100.i();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.type = r100.i();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.userId = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setStart(int r100) {
        this.start = r100;
    }

    public final void setStop(int r100) {
        this.stop = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
