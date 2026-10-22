package com.bytedance.android.ec.model.live;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/ec/model/live/d;", "", "", "width", "I", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()I", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("width")
    private final int width;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == true) goto L6;
        return false;
    L6:
        if (this.width == ((d) r100).width) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.width;
    }

    public final String toString() {
        return "ECElementBlank(width=" + this.width + ")";
    }

    public final int a() {
        return this.width;
    }

    public d(int r100) {
        this.width = r100;
    }
}
