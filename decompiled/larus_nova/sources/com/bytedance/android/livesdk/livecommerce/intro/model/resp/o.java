package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/o;", "", "", "price", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "setPrice", "(J)V", "", "showStrikeThrough", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setShowStrikeThrough", "(Ljava/lang/Boolean;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    @SerializedName("price")
    private long price;

    @SerializedName("show_strike_through")
    private Boolean showStrikeThrough;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L10;
        o r101 = (o) r100;
        if (this.price == r101.price) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.showStrikeThrough, r101.showStrikeThrough) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        long r100 = this.price;
        int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
        Boolean r102 = this.showStrikeThrough;
        if (r102 == null) goto L5;
        int r103 = r102.hashCode();
    L7:
        return r101 + r103;
    L5:
        r103 = 0;
        goto L7
    }

    public final String toString() {
        return "IntroDescriptionRegularPrice(price=" + this.price + ", showStrikeThrough=" + this.showStrikeThrough + ")";
    }

    public o() {
        this.price = 0;
        this.showStrikeThrough = null;
    }

    public final long a() {
        return this.price;
    }

    public final Boolean b() {
        return this.showStrikeThrough;
    }
}
