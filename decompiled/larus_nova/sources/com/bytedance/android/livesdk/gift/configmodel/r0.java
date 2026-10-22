package com.bytedance.android.livesdk.gift.configmodel;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/r0;", "", "", "enable", "Z", "b", "()Z", "setEnable", "(Z)V", "vpLeakEnable", "getVpLeakEnable", "setVpLeakEnable", "vpScrollEnable", "getVpScrollEnable", "setVpScrollEnable", "", "vpScrollType", "I", "getVpScrollType", "()I", "setVpScrollType", "(I)V", "rvScrollEnable", "getRvScrollEnable", "setRvScrollEnable", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class r0 {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("rv_scroll_enable")
    private boolean rvScrollEnable;

    @SerializedName("vp_leak_enable")
    private boolean vpLeakEnable;

    @SerializedName("vp_scroll_enable")
    private boolean vpScrollEnable;

    @SerializedName("vp_leak_type")
    private int vpScrollType;

    public r0() {
    }

    public final boolean c() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.rvScrollEnable == false) goto L7;
        return true;
    }

    public final boolean d() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.vpLeakEnable == false) goto L7;
        return true;
    }

    public final boolean e() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.vpScrollEnable == false) goto L7;
        return true;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean a(int r100) {
        int r101 = this.vpScrollType;
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r100 == 1) goto L12;
        if (r100 != 2) goto L17;
        if (r101 == 2) goto L13;
        if (r101 == 1) goto L13;
        return false;
    L13:
        return true;
    L17:
        return false;
    L12:
        if (r101 == 2) goto L13;
        return false;
    }
}
