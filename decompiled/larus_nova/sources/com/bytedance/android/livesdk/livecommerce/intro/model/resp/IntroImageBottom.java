package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroImageBottom;", "", "", "bottomType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/v;", "banner", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/v;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/v;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroImageBottom {

    @SerializedName("banner")
    private final v banner;

    @SerializedName("bottom_type")
    private final Integer bottomType;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroImageBottom$Companion$IntroImageBottomType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroImageBottomType {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IntroImageBottom) == false) goto L10;
        IntroImageBottom r101 = (IntroImageBottom) r100;
        if (Intrinsics.areEqual(this.bottomType, r101.bottomType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.banner, r101.banner) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.bottomType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        v r104 = this.banner;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroImageBottom(bottomType=" + this.bottomType + ", banner=" + this.banner + ")";
    }

    public IntroImageBottom() {
        this.bottomType = null;
        this.banner = null;
    }

    public final v a() {
        return this.banner;
    }

    public final Integer b() {
        return this.bottomType;
    }
}
