package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomFeedData.StreamCutPosition")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0011\u001a\u00020\n8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/StreamCutPosition;", "", "()V", "sourceHeight", "", "getSourceHeight", "()I", "sourceWidth", "getSourceWidth", "x1", "", "getX1", "()D", "x2", "getX2", "y1", "getY1", "y2", "getY2", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class StreamCutPosition implements h {

    @SerializedName("source_height")
    protected int sourceHeight;

    @SerializedName("source_width")
    protected int sourceWidth;

    /* JADX INFO: renamed from: x1, reason: collision with root package name */
    @SerializedName("x1")
    protected double f162605x1;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    @SerializedName("x2")
    protected double f162606x2;

    /* JADX INFO: renamed from: y1, reason: collision with root package name */
    @SerializedName("y1")
    protected double f162607y1;

    /* JADX INFO: renamed from: y2, reason: collision with root package name */
    @SerializedName("y2")
    protected double f162608y2;

    public StreamCutPosition() {
    }

    public final int getSourceHeight() {
        return this.sourceHeight;
    }

    public final int getSourceWidth() {
        return this.sourceWidth;
    }

    public final double getX1() {
        return this.f162605x1;
    }

    public final double getX2() {
        return this.f162606x2;
    }

    public final double getY1() {
        return this.f162607y1;
    }

    public final double getY2() {
        return this.f162608y2;
    }

    public StreamCutPosition(g r100) {
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
        this.sourceHeight = r100.i();
        goto L3
    L8:
        this.sourceWidth = r100.i();
        goto L3
    L9:
        this.f162608y2 = Double.longBitsToDouble(r100.h());
        goto L3
    L10:
        this.f162606x2 = Double.longBitsToDouble(r100.h());
        goto L3
    L11:
        this.f162607y1 = Double.longBitsToDouble(r100.h());
        goto L3
    L12:
        this.f162605x1 = Double.longBitsToDouble(r100.h());
        goto L3
    L6:
        am3.h.e(r100);
        goto L3
    L13:
        r100.d(r101);
    }
}
