package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.ShortTouchAuth")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/ShortTouchAuth;", "", "()V", "commerceLottery", "", "getCommerceLottery", "()I", "setCommerceLottery", "(I)V", "hasCommerceLottery", "", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ShortTouchAuth implements h {

    @SerializedName("commerce_lottery")
    protected int commerceLottery;

    public ShortTouchAuth() {
    }

    public final boolean hasCommerceLottery() {
        if (this.commerceLottery == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final int getCommerceLottery() {
        return this.commerceLottery;
    }

    public ShortTouchAuth(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.commerceLottery = r100.i();
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public final void setCommerceLottery(int r100) {
        this.commerceLottery = r100;
    }
}
