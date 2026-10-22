package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdk/config/a41;", "", "", "enable", "Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Z", "setEnable", "(Z)V", "", "duration", "I", "getDuration", "()I", "setDuration", "(I)V", "", "text", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a41 {

    @SerializedName("duration")
    private int duration;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("text")
    private final String text;

    public a41() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a41) == false) goto L12;
        a41 r101 = (a41) r100;
        if (this.enable == r101.enable) goto L8;
        return false;
    L8:
        if (this.duration == r101.duration) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public final int hashCode() {
        boolean r100 = this.enable;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((r101 * 31) + this.duration) * 31;
        String r103 = this.text;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "LiveHistoryPopConfig(enable=" + this.enable + ", duration=" + this.duration + ", text=" + this.text + ")";
    }

    public final boolean a() {
        return this.enable;
    }

    public final String b() {
        return this.text;
    }

    public a41(int r100) {
        this.enable = false;
        this.duration = 5;
        this.text = "直播观看记录在这里";
    }
}
