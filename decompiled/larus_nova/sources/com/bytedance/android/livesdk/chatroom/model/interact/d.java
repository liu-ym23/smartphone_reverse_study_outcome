package com.bytedance.android.livesdk.chatroom.model.interact;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u000e\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/model/interact/d;", "", "", "callDuration", "J", "getCallDuration", "()J", "setCallDuration", "(J)V", "linkThreshold", "getLinkThreshold", "setLinkThreshold", "", "isAutoOpen", "Z", "()Z", "setAutoOpen", "(Z)V", "isOpen", "b", "setOpen", "enableSetting", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setEnableSetting", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class d implements vh7.h {

    @SerializedName("call_duration")
    protected long callDuration;

    @SerializedName("enable_setting")
    protected boolean enableSetting;

    @SerializedName("auto_open")
    protected boolean isAutoOpen;

    @SerializedName("is_open")
    protected boolean isOpen;

    @SerializedName("link_threshold")
    protected long linkThreshold;

    public d() {
    }

    public final String toString() {
        return "GuestLinkContent(callDuration=" + this.callDuration + ", linkThreshold=" + this.linkThreshold + ", isAutoOpen=" + this.isAutoOpen + ", isOpen=" + this.isOpen + ", enableSetting=" + this.enableSetting + ')';
    }

    public final boolean a() {
        return this.enableSetting;
    }

    public final boolean b() {
        return this.isOpen;
    }

    public d(am3.g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L21;
        if (r102 != 1) goto L8;
        this.linkThreshold = r100.j();
        goto L3
    L8:
        if (r102 != 2) goto L10;
        this.callDuration = r100.j();
        goto L3
    L10:
        if (r102 != 3) goto L12;
        this.isAutoOpen = am3.h.a(r100);
        goto L3
    L12:
        if (r102 != 4) goto L14;
        this.isOpen = am3.h.a(r100);
        goto L3
    L14:
        if (r102 != 5) goto L15;
        this.enableSetting = am3.h.a(r100);
        goto L3
    L15:
        am3.h.e(r100);
        goto L3
    L21:
        r100.d(r101);
    }
}
