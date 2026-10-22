package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.facebook.keyframes.model.KFAnimation;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/e0;", "", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "value", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e0 {

    @SerializedName(KFAnimation.PROPERTY_TYPE_JSON_FIELD)
    private final String property;

    @SerializedName("value")
    private final String value;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof e0) == false) goto L10;
        e0 r101 = (e0) r100;
        if (Intrinsics.areEqual(this.property, r101.property) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.value, r101.value) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        String r100 = this.property;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.value;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroProductProperty(property=" + this.property + ", value=" + this.value + ")";
    }

    public e0() {
        this.property = null;
        this.value = null;
    }

    public final String a() {
        return this.property;
    }

    public final String b() {
        return this.value;
    }
}
