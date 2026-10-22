package com.bytedance.android.livesdkapi.depend.model.live;

import am3.g;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@ProtoMessage("webcast.data.UnionLiveInfo.GuestAnchor")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\bR\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GuestAnchor;", "", "()V", "state", "", "user", "Lcom/bytedance/android/live/base/model/user/User;", "equals", "", "other", "hashCode", "isUnionStarted", "Companion", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuestAnchor implements h {
    public static final Companion Companion = null;
    public static final int STATE_ACCEPT_INVITED = 1;
    public static final int STATE_STATE_UNION = 0;

    @SerializedName("status")
    public int state;

    @SerializedName("user")
    public User user;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/GuestAnchor$Companion;", "", "()V", "STATE_ACCEPT_INVITED", "", "STATE_STATE_UNION", "livebase-model_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GuestAnchor() {
    }

    public int hashCode() {
        User r100 = this.user;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + this.state;
    L5:
        r101 = 0;
        goto L7
    }

    public final boolean isUnionStarted() {
        if (this.state != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public GuestAnchor(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.user = new User(r100);
        goto L3
    L8:
        if (r102 != 3) goto L9;
        this.state = r100.i();
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if ((!Intrinsics.areEqual(GuestAnchor.class, r101)) == false) goto L12;
        return false;
    L12:
        if (r100 == null) goto L21;
        GuestAnchor r102 = (GuestAnchor) r100;
        if ((!Intrinsics.areEqual(this.user, r102.user)) == false) goto L17;
        return false;
    L17:
        if (this.state == r102.state) goto L19;
        return false;
    L19:
        return true;
    L21:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdkapi.depend.model.live.GuestAnchor");
    L8:
        r101 = null;
        goto L10
    }
}
