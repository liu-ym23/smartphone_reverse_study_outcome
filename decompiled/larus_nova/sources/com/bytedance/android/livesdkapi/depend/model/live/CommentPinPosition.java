package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.CommentWallPosition")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/CommentPinPosition;", "", "()V", "eventTime", "", "getEventTime", "()J", "setEventTime", "(J)V", "positionX", "", "getPositionX", "()D", "setPositionX", "(D)V", "positionY", "getPositionY", "setPositionY", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentPinPosition implements h {

    @SerializedName("event_time")
    protected long eventTime;

    @SerializedName("x")
    protected double positionX;

    @SerializedName("y")
    protected double positionY;

    public CommentPinPosition() {
    }

    public final long getEventTime() {
        return this.eventTime;
    }

    public final double getPositionX() {
        return this.positionX;
    }

    public final double getPositionY() {
        return this.positionY;
    }

    public CommentPinPosition(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L15;
        if (r102 != 1) goto L8;
        this.positionX = Double.longBitsToDouble(r100.h());
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.positionY = Double.longBitsToDouble(r100.h());
        goto L3
    L10:
        if (r102 != 3) goto L11;
        this.eventTime = r100.j();
        goto L3
    L11:
        am3.h.e(r100);
        goto L3
    L15:
        r100.d(r101);
    }

    public final void setEventTime(long r100) {
        this.eventTime = r100;
    }

    public final void setPositionX(double r100) {
        this.positionX = r100;
    }

    public final void setPositionY(double r100) {
        this.positionY = r100;
    }
}
