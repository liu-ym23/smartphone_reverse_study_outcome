package com.bytedance.android.ec.model.live;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/live/i;", "", "", "", "loopText", "Ljava/util/List;", "c", "()Ljava/util/List;", "textColor", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "textSize", "I", "e", "()I", "", CommodityText.BOLD, "Z", "b", "()Z", "", "animGap", "J", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()J", "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("anim_gap")
    private final long animGap;

    @SerializedName(CommodityText.BOLD)
    private final boolean bold;

    @SerializedName("texts")
    private final List<String> loopText;

    @SerializedName("color")
    private final String textColor;

    @SerializedName("size")
    private final int textSize;

    public i() {
        this(null, null, 12, false, 200);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof i) == false) goto L16;
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.loopText, r101.loopText) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.textColor, r101.textColor) == true) goto L10;
        return false;
    L10:
        if (this.textSize == r101.textSize) goto L12;
        return false;
    L12:
        if (this.bold == r101.bold) goto L14;
        return false;
    L14:
        if (this.animGap == r101.animGap) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        List<String> r100 = this.loopText;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.textColor;
        if (r104 == null) goto L9;
        r101 = r104.hashCode();
    L9:
        int r105 = (((r103 + r101) * 31) + this.textSize) * 31;
        boolean r106 = this.bold;
        ?? r107 = r106;
        if (r106 == false) goto L12;
        r107 = 1;
    L12:
        int r108 = (r105 + r107) * 31;
        long r109 = this.animGap;
        return r108 + ((int) (r109 ^ (r109 >>> 32)));
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECElementLoopText(loopText=" + this.loopText + ", textColor=" + this.textColor + ", textSize=" + this.textSize + ", bold=" + this.bold + ", animGap=" + this.animGap + ")";
    }

    public final long a() {
        return this.animGap;
    }

    public final boolean b() {
        return this.bold;
    }

    public final List<String> c() {
        return this.loopText;
    }

    public final String d() {
        return this.textColor;
    }

    public final int e() {
        return this.textSize;
    }

    public i(List<String> r100, String r101, int r102, boolean r103, long r104) {
        this.loopText = r100;
        this.textColor = r101;
        this.textSize = r102;
        this.bold = r103;
        this.animGap = r104;
    }
}
