package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.PublicScreenBottomInfo.BottomCard")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/BottomCard;", "", "()V", "bizParams", "", "getBizParams", "()Ljava/lang/String;", "setBizParams", "(Ljava/lang/String;)V", "duration", "", "getDuration", "()Ljava/lang/Long;", "setDuration", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "name", "getName", "setName", "priority", "getPriority", "setPriority", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BottomCard implements h {

    @SerializedName("biz_params")
    protected String bizParams;

    @SerializedName("duration")
    protected Long duration;

    @SerializedName("name")
    protected String name;

    @SerializedName("priority")
    protected Long priority;

    public BottomCard() {
    }

    public final String getBizParams() {
        return this.bizParams;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getName() {
        return this.name;
    }

    public final Long getPriority() {
        return this.priority;
    }

    public BottomCard(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.name = am3.h.c(r100);
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.priority = Long.valueOf(r100.j());
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.duration = Long.valueOf(r100.j());
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.bizParams = am3.h.c(r100);
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final void setBizParams(String r100) {
        this.bizParams = r100;
    }

    public final void setDuration(Long r100) {
        this.duration = r100;
    }

    public final void setName(String r100) {
        this.name = r100;
    }

    public final void setPriority(Long r100) {
        this.priority = r100;
    }
}
