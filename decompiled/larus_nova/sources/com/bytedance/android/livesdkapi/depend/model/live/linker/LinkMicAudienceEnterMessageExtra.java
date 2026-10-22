package com.bytedance.android.livesdkapi.depend.model.live.linker;

import am3.g;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.LinkmicAudienceEnterMessageExtra")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra;", "", "()V", "enterUser", "Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra$UserInfo;", "getEnterUser", "()Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra$UserInfo;", "setEnterUser", "(Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra$UserInfo;)V", "toString", "", "UserInfo", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkMicAudienceEnterMessageExtra implements h {

    @SerializedName("enter_user")
    protected UserInfo enterUser;

    @ProtoMessage("webcast.data.LinkmicAudienceEnterMessageExtra.UserInfo")
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/linker/LinkMicAudienceEnterMessageExtra$UserInfo;", "", "()V", "fanTicket", "", "getFanTicket", "()J", "setFanTicket", "(J)V", "userId", "getUserId", "setUserId", "toString", "", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class UserInfo implements h {

        @SerializedName("fan_ticket")
        protected long fanTicket;

        @SerializedName("user_id")
        protected long userId;

        public UserInfo() {
        }

        public String toString() {
            return "UserInfo{userId=" + this.userId + ", fanTicket=" + this.fanTicket + '}';
        }

        public final long getFanTicket() {
            return this.fanTicket;
        }

        public final long getUserId() {
            return this.userId;
        }

        public UserInfo(g r100) {
            long r101 = r100.c();
        L3:
            int r102 = r100.f();
            if (r102 == (-1)) goto L12;
            if (r102 != 1) goto L8;
            this.userId = r100.j();
            goto L3
        L8:
            if (r102 != 2) goto L9;
            this.fanTicket = r100.j();
            goto L3
        L9:
            am3.h.e(r100);
            goto L3
        L12:
            r100.d(r101);
        }

        public final void setFanTicket(long r100) {
            this.fanTicket = r100;
        }

        public final void setUserId(long r100) {
            this.userId = r100;
        }
    }

    public LinkMicAudienceEnterMessageExtra() {
    }

    public LinkMicAudienceEnterMessageExtra(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L9;
        if (r102 != 1) goto L7;
        this.enterUser = new UserInfo(r100);
        goto L3
    L7:
        am3.h.e(r100);
        goto L3
    L9:
        r100.d(r101);
    }

    public String toString() {
        return "Extra{enterUser=" + this.enterUser + '}';
    }

    public final UserInfo getEnterUser() {
        return this.enterUser;
    }

    public final void setEnterUser(UserInfo r100) {
        this.enterUser = r100;
    }
}
