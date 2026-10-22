package com.bytedance.android.livesdk.chatroom.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@ProtoMessage("webcast.data.AnchorAudioConf")
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/b;", "", "", "status", "I", "switchWelcome", "switchThanks", "switchCongrats", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b implements vh7.h {

    @SerializedName("status")
    public int status;

    @SerializedName("switcher_congrats")
    public int switchCongrats;

    @SerializedName("switcher_thanks")
    public int switchThanks;

    @SerializedName("switcher_welcome")
    public int switchWelcome;

    public b() {
    }

    public final int hashCode() {
        return (((((this.status * 31) + this.switchWelcome) * 31) + this.switchThanks) * 31) + this.switchCongrats;
    }

    public final String toString() {
        return "AnchorAsrSwitchStatus(status=" + this.status + ", switchWelcome=" + this.switchWelcome + ", switchThanks=" + this.switchThanks + ", switchCongrats=" + this.switchCongrats + ')';
    }

    public b(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L18;
        if (r102 != 1) goto L8;
        this.status = (int) r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.switchWelcome = (int) r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.switchThanks = (int) r100.j();
        goto L3
    L12:
        if (r102 != 4) goto L13;
        this.switchCongrats = (int) r100.j();
        goto L3
    L13:
        am3.h.e(r100);
        goto L3
    L18:
        r100.d(r101);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof b) == false) goto L13;
        b r101 = (b) r100;
        if (this.status != r101.status) goto L13;
        if (this.switchWelcome != r101.switchWelcome) goto L13;
        if (this.switchThanks != r101.switchThanks) goto L13;
        if (this.switchCongrats != r101.switchCongrats) goto L13;
        return true;
    L13:
        return false;
    }
}
