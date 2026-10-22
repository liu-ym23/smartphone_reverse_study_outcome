package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomActivityTag")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/LivePlayTagInfo;", "", "()V", "mExtra", "", "getMExtra", "()Ljava/lang/String;", "setMExtra", "(Ljava/lang/String;)V", "mName", "getMName", "setMName", "mPlayTagType", "", "getMPlayTagType", "()I", "setMPlayTagType", "(I)V", "mUrl", "getMUrl", "setMUrl", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePlayTagInfo implements h {

    @SerializedName("extra")
    protected String mExtra;

    @SerializedName("name")
    protected String mName;

    @IgnoreProtoFieldCheck
    @SerializedName(alternate = {a.KEY_ACTIVITY_TYPE}, value = "type")
    private int mPlayTagType;

    @SerializedName("url")
    protected String mUrl;

    public LivePlayTagInfo() {
    }

    public LivePlayTagInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 2) goto L8;
        this.mName = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 3) goto L10;
        this.mUrl = am3.h.c(r100);
        goto L3
    L10:
        if (r102 != 4) goto L11;
        this.mExtra = am3.h.c(r100);
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final String getMExtra() {
        return this.mExtra;
    }

    public final String getMName() {
        return this.mName;
    }

    public final int getMPlayTagType() {
        return this.mPlayTagType;
    }

    public final String getMUrl() {
        return this.mUrl;
    }

    public final void setMExtra(String r100) {
        this.mExtra = r100;
    }

    public final void setMName(String r100) {
        this.mName = r100;
    }

    public final void setMPlayTagType(int r100) {
        this.mPlayTagType = r100;
    }

    public final void setMUrl(String r100) {
        this.mUrl = r100;
    }
}
