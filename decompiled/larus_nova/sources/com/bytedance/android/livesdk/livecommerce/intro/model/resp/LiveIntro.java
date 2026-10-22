package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0016R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/LiveIntro;", "", "", "introType", "I", "c", "()I", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t0;", "product", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t0;", "d", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/t0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q0;", "auction", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q0;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/q0;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "control", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "b", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/s0;", "Companion", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveIntro {

    @SerializedName("auction")
    private final q0 auction;

    @SerializedName("control")
    private final s0 control;

    @SerializedName("intro_type")
    private final int introType;

    @SerializedName("product")
    private final t0 product;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/LiveIntro$Companion$IntroType;", "", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface IntroType {
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof LiveIntro) == false) goto L14;
        LiveIntro r101 = (LiveIntro) r100;
        if (this.introType == r101.introType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.product, r101.product) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.auction, r101.auction) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.control, r101.control) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        int r100 = this.introType * 31;
        t0 r101 = this.product;
        int r102 = 0;
        if (r101 == null) goto L5;
        int r103 = r101.hashCode();
    L6:
        int r104 = (r100 + r103) * 31;
        q0 r105 = this.auction;
        if (r105 == null) goto L9;
        int r106 = r105.hashCode();
    L10:
        int r107 = (r104 + r106) * 31;
        s0 r108 = this.control;
        if (r108 == null) goto L14;
        r102 = r108.hashCode();
    L14:
        return r107 + r102;
    L9:
        r106 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L6
    }

    public final String toString() {
        return "LiveIntro(introType=" + this.introType + ", product=" + this.product + ", auction=" + this.auction + ", control=" + this.control + ")";
    }

    public LiveIntro() {
        this.introType = 1;
        this.product = null;
        this.auction = null;
        this.control = null;
    }

    public final q0 a() {
        return this.auction;
    }

    public final s0 b() {
        return this.control;
    }

    public final int c() {
        return this.introType;
    }

    public final t0 d() {
        return this.product;
    }
}
