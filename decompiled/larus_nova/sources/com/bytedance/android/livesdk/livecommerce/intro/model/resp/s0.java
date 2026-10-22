package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "", "", "duration", "J", "c", "()J", "", "showStyle", "I", "d", "()I", "commentHeight", "b", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", "action", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s0 {

    @SerializedName("action")
    private final r0 action;

    @SerializedName("comment_height")
    private final int commentHeight;

    @SerializedName("duration")
    private final long duration;

    @SerializedName("show_style")
    private final int showStyle;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s0) == false) goto L14;
        s0 r101 = (s0) r100;
        if (this.duration == r101.duration) goto L8;
        return false;
    L8:
        if (this.showStyle == r101.showStyle) goto L10;
        return false;
    L10:
        if (this.commentHeight == r101.commentHeight) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.action, r101.action) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        long r100 = this.duration;
        int r101 = ((((((int) (r100 ^ (r100 >>> 32))) * 31) + this.showStyle) * 31) + this.commentHeight) * 31;
        r0 r102 = this.action;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "LiveIntroControlStrategy(duration=" + this.duration + ", showStyle=" + this.showStyle + ", commentHeight=" + this.commentHeight + ", action=" + this.action + ")";
    }

    public s0() {
        this.duration = 0;
        this.showStyle = 0;
        this.commentHeight = 0;
        this.action = null;
    }

    public final r0 a() {
        return this.action;
    }

    public final int b() {
        return this.commentHeight;
    }

    public final long c() {
        return this.duration;
    }

    public final int d() {
        return this.showStyle;
    }
}
