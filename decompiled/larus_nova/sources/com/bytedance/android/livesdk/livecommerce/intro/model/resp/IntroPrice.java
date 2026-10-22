package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001bR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice;", "", "", "priceType", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "showPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "c", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m;", "countDown", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/m;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n0;", "showText", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n0;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/n0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "breathingLightPrice", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "getBreathingLightPrice", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/j;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class IntroPrice {

    @SerializedName("breathing_light_price")
    private final j breathingLightPrice;

    @SerializedName("count_down")
    private final m countDown;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_PRICE_TYPE)
    private final Integer priceType;

    @SerializedName("show_price")
    private final m0 showPrice;

    @SerializedName("show_text")
    private final n0 showText;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPrice$Companion$IntroPriceType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroPriceType {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof IntroPrice) == false) goto L16;
        IntroPrice r101 = (IntroPrice) r100;
        if (Intrinsics.areEqual(this.priceType, r101.priceType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showPrice, r101.showPrice) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.countDown, r101.countDown) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.showText, r101.showText) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.breathingLightPrice, r101.breathingLightPrice) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        Integer r100 = this.priceType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        m0 r104 = this.showPrice;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        m r107 = this.countDown;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        n0 r110 = this.showText;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        j r113 = this.breathingLightPrice;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
    L17:
        r111 = 0;
        goto L18
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
        return "IntroPrice(priceType=" + this.priceType + ", showPrice=" + this.showPrice + ", countDown=" + this.countDown + ", showText=" + this.showText + ", breathingLightPrice=" + this.breathingLightPrice + ")";
    }

    public IntroPrice() {
        this.priceType = null;
        this.showPrice = null;
        this.countDown = null;
        this.showText = null;
        this.breathingLightPrice = null;
    }

    public final m a() {
        return this.countDown;
    }

    public final Integer b() {
        return this.priceType;
    }

    public final m0 c() {
        return this.showPrice;
    }

    public final n0 d() {
        return this.showText;
    }
}
