package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.RoomExtra")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ExtraInfo;", "", "()V", "isSandbox", "", "()Z", "setSandbox", "(Z)V", "xiguaUid", "", "getXiguaUid", "()J", "setXiguaUid", "(J)V", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ExtraInfo implements h {

    @SerializedName("is_sandbox")
    protected boolean isSandbox;

    @SerializedName("xigua_uid")
    protected long xiguaUid;

    public ExtraInfo() {
    }

    public final long getXiguaUid() {
        return this.xiguaUid;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public ExtraInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.isSandbox = am3.h.a(r100);
        goto L3
    L8:
        if (r102 != 5) goto L9;
        this.xiguaUid = r100.j();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setSandbox(boolean r100) {
        this.isSandbox = r100;
    }

    public final void setXiguaUid(long r100) {
        this.xiguaUid = r100;
    }
}
