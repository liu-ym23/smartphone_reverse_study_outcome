package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.TopFan")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0010J\b\u0010\u0013\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\nR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/TopFanTicket;", "", "()V", "_fanTicket", "", "get_fanTicket", "()J", "set_fanTicket", "(J)V", "_user", "Lcom/bytedance/android/live/base/model/user/User;", "get_user", "()Lcom/bytedance/android/live/base/model/user/User;", "set_user", "(Lcom/bytedance/android/live/base/model/user/User;)V", "rank", "", "getFanTicket", "getRank", "getUser", "setFanTicket", "", "fanTicket", "setRank", "setUser", "user", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TopFanTicket implements h {

    @SerializedName("fan_ticket")
    protected long _fanTicket;

    @SerializedName("user")
    protected User _user;
    private int rank;

    public TopFanTicket() {
    }

    public final long getFanTicket() {
        return this._fanTicket;
    }

    public final int getRank() {
        return this.rank;
    }

    public final User getUser() {
        return this._user;
    }

    public final long get_fanTicket() {
        return this._fanTicket;
    }

    public final User get_user() {
        return this._user;
    }

    public TopFanTicket(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this._fanTicket = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this._user = new User(r100);
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public final void setFanTicket(long r100) {
        this._fanTicket = r100;
    }

    public final void setRank(int r100) {
        this.rank = r100;
    }

    public final void setUser(User r100) {
        this._user = r100;
    }

    public final void set_fanTicket(long r100) {
        this._fanTicket = r100;
    }

    public final void set_user(User r100) {
        this._user = r100;
    }
}
