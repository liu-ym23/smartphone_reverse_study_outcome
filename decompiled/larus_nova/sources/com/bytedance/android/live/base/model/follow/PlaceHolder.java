package com.bytedance.android.live.base.model.follow;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes45.dex */
@ProtoMessage("webcast.api.feed.Placeholder")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/base/model/follow/PlaceHolder;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaceHolder implements h {

    @SerializedName("msg")
    protected String msg;

    @SerializedName("type")
    protected int type;

    public PlaceHolder() {
        this.msg = "";
    }

    public final String getMsg() {
        return this.msg;
    }

    public final int getType() {
        return this.type;
    }

    public PlaceHolder(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.type = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.msg = am3.h.c(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.msg != null) goto L25;
        this.msg = "";
        return;
    }

    public final void setMsg(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.msg = r100;
    }

    public final void setType(int r100) {
        this.type = r100;
    }
}
