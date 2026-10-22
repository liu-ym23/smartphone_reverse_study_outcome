package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPriceDescription;", "", "", "descriptionType", "Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d0;", "text", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d0;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/d0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o;", "regularPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/c0;", "exclusive", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/c0;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/c0;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroPriceDescription {

    @SerializedName("description_type")
    private final Integer descriptionType;

    @SerializedName("exclusive")
    private final c0 exclusive;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_REGULAR_PRICE)
    private final o regularPrice;

    @SerializedName("text")
    private final d0 text;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPriceDescription$Companion$IntroPriceDescriptionType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroPriceDescriptionType {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IntroPriceDescription) == false) goto L14;
        IntroPriceDescription r101 = (IntroPriceDescription) r100;
        if (Intrinsics.areEqual(this.descriptionType, r101.descriptionType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.regularPrice, r101.regularPrice) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.exclusive, r101.exclusive) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.descriptionType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        d0 r104 = this.text;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        o r107 = this.regularPrice;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        c0 r110 = this.exclusive;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "IntroPriceDescription(descriptionType=" + this.descriptionType + ", text=" + this.text + ", regularPrice=" + this.regularPrice + ", exclusive=" + this.exclusive + ")";
    }

    public IntroPriceDescription() {
        this.descriptionType = null;
        this.text = null;
        this.regularPrice = null;
        this.exclusive = null;
    }

    public final Integer a() {
        return this.descriptionType;
    }

    public final c0 b() {
        return this.exclusive;
    }

    public final o c() {
        return this.regularPrice;
    }

    public final d0 d() {
        return this.text;
    }
}
