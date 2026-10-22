package com.bytedance.android.livesdk.livecommerce.skin.model;

import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB)\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J+\u0010\n\u001a\u00020\u00002\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00042\b\b\u0002\u0010\t\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\u0004\u0018\u0001`\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinBorderElement;", "Ljava/io/Serializable;", "", "", "Lcom/bytedance/android/livesdk/livecommerce/skin/model/ECLiveSkinColors;", "component1", "", "component2", "color", "borderWidth", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/util/List;", "getColor", "()Ljava/util/List;", FaceService.girlLabel, "getBorderWidth", "()F", "<init>", "(Ljava/util/List;F)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLiveSkinBorderElement implements Serializable {
    public static final a Companion = null;

    @SerializedName("border_width")
    private final float borderWidth;

    @SerializedName("color")
    private final List<String> color;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECLiveSkinBorderElement() {
        List r100 = null;
        this(r100, 0.0f, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ECLiveSkinBorderElement copy$default(ECLiveSkinBorderElement r100, List r101, float r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.color;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.borderWidth;
    L9:
        return r100.copy(r101, r102);
    }

    public final List<String> component1() {
        return this.color;
    }

    public final float component2() {
        return this.borderWidth;
    }

    public final ECLiveSkinBorderElement copy(List<String> r100, float r101) {
        return new ECLiveSkinBorderElement(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECLiveSkinBorderElement) == false) goto L10;
        ECLiveSkinBorderElement r101 = (ECLiveSkinBorderElement) r100;
        if (Intrinsics.areEqual(this.color, r101.color) == true) goto L8;
        return false;
    L8:
        if (Float.compare(this.borderWidth, r101.borderWidth) == 0) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        List<String> r100 = this.color;
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L7:
        return (r101 * 31) + Float.floatToIntBits(this.borderWidth);
    L5:
        r101 = 0;
        goto L7
    }

    public String toString() {
        return "ECLiveSkinBorderElement(color=" + this.color + ", borderWidth=" + this.borderWidth + ")";
    }

    public final float getBorderWidth() {
        return this.borderWidth;
    }

    public final List<String> getColor() {
        return this.color;
    }

    public ECLiveSkinBorderElement(List<String> r100, float r101) {
        this.color = r100;
        this.borderWidth = r101;
    }

    public /* synthetic */ ECLiveSkinBorderElement(List r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0.3f;
    L8:
        this(r100, r101);
    }
}
