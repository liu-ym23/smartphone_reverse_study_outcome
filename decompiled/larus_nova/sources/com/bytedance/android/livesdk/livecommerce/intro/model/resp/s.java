package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.bytedance.android.ec.model.response.t1;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s;", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q;", "content", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q;", "Lcom/bytedance/android/ec/model/response/t1;", "leftIcon", "Lcom/bytedance/android/ec/model/response/t1;", "c", "()Lcom/bytedance/android/ec/model/response/t1;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r;", "countdown", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/r;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class s {

    @SerializedName("content")
    private final q content;

    @SerializedName("count_down")
    private final r countdown;

    @SerializedName("left_icon")
    private final t1 leftIcon;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof s) == false) goto L12;
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.leftIcon, r101.leftIcon) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.countdown, r101.countdown) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        q r100 = this.content;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        t1 r104 = this.leftIcon;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        r r107 = this.countdown;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroElasticTitleData(content=" + this.content + ", leftIcon=" + this.leftIcon + ", countdown=" + this.countdown + ")";
    }

    public s() {
        this.content = null;
        this.leftIcon = null;
        this.countdown = null;
    }

    public final q a() {
        return this.content;
    }

    public final r b() {
        return this.countdown;
    }

    public final t1 c() {
        return this.leftIcon;
    }
}
