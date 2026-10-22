package com.bytedance.android.livesdk.message.model.ag;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes11.dex */
@ProtoMessage("webcast.im.VideoCardSize")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/ag/VideoCardSize;", "", "()V", "height", "", "getHeight", "()J", "setHeight", "(J)V", "width", "getWidth", "setWidth", "livemessage-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoCardSize implements h {

    @SerializedName("height")
    protected long height;

    @SerializedName("width")
    protected long width;

    public VideoCardSize() {
    }

    public final long getHeight() {
        return this.height;
    }

    public final long getWidth() {
        return this.width;
    }

    public VideoCardSize(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.height = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.width = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setHeight(long r100) {
        this.height = r100;
    }

    public final void setWidth(long r100) {
        this.width = r100;
    }
}
