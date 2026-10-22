package com.bytedance.android.livesdk.livecommerce.intro.model.resp;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/z;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/IntroPriceDescription;", "descriptions", "Ljava/util/List;", "getDescriptions", "()Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/w;", "flips", "getFlips", "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", GXTemplateKey.GAIAX_TRACK, "Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "getTrack", "()Lcom/bytedance/android/livesdk/livecommerce/intro/model/resp/b0;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class z {

    @SerializedName("descriptions")
    private final List<IntroPriceDescription> descriptions;

    @SerializedName("flips")
    private final List<w> flips;

    @SerializedName(GXTemplateKey.GAIAX_TRACK)
    private final b0 track;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof z) == false) goto L12;
        z r101 = (z) r100;
        if (Intrinsics.areEqual(this.descriptions, r101.descriptions) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.flips, r101.flips) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.track, r101.track) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        List<IntroPriceDescription> r100 = this.descriptions;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<w> r104 = this.flips;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        b0 r107 = this.track;
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
        return "IntroOpenPriceAnimationPrice(descriptions=" + this.descriptions + ", flips=" + this.flips + ", track=" + this.track + ")";
    }

    public z() {
        this.descriptions = null;
        this.flips = null;
        this.track = null;
    }
}
