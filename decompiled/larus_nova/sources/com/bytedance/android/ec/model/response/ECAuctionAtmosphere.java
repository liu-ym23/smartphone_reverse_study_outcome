package com.bytedance.android.ec.model.response;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/ec/model/response/ECAuctionAtmosphere;", "Ljava/io/Serializable;", "Lcom/bytedance/android/ec/model/response/ECAuctionCountdownAtmosphere;", "component1", "Lcom/bytedance/android/ec/model/response/ECAuctionDigitalAtmosphere;", "component2", "countDown", ECAuctionAtmosphere.TYPE_DIGITAL, "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/bytedance/android/ec/model/response/ECAuctionCountdownAtmosphere;", "getCountDown", "()Lcom/bytedance/android/ec/model/response/ECAuctionCountdownAtmosphere;", "Lcom/bytedance/android/ec/model/response/ECAuctionDigitalAtmosphere;", "getDigital", "()Lcom/bytedance/android/ec/model/response/ECAuctionDigitalAtmosphere;", "<init>", "(Lcom/bytedance/android/ec/model/response/ECAuctionCountdownAtmosphere;Lcom/bytedance/android/ec/model/response/ECAuctionDigitalAtmosphere;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-model_release"}, k = 1, mv = {1, 4, 3})
public final class ECAuctionAtmosphere implements Serializable {
    public static final a Companion = null;
    public static final String TYPE_COUNT_DOWN = "count_down";
    public static final String TYPE_DIGITAL = "digital";

    @SerializedName("count_down")
    private final ECAuctionCountdownAtmosphere countDown;

    @SerializedName(TYPE_DIGITAL)
    private final ECAuctionDigitalAtmosphere digital;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ECAuctionAtmosphere() {
        Object[] r100 = 0 == true ? 1 : 0;
        this(null, r100, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ECAuctionAtmosphere copy$default(ECAuctionAtmosphere r100, ECAuctionCountdownAtmosphere r101, ECAuctionDigitalAtmosphere r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.countDown;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.digital;
    L9:
        return r100.copy(r101, r102);
    }

    public final ECAuctionCountdownAtmosphere component1() {
        return this.countDown;
    }

    public final ECAuctionDigitalAtmosphere component2() {
        return this.digital;
    }

    public final ECAuctionAtmosphere copy(ECAuctionCountdownAtmosphere r100, ECAuctionDigitalAtmosphere r101) {
        return new ECAuctionAtmosphere(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECAuctionAtmosphere) == false) goto L10;
        ECAuctionAtmosphere r101 = (ECAuctionAtmosphere) r100;
        if (Intrinsics.areEqual(this.countDown, r101.countDown) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.digital, r101.digital) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        ECAuctionCountdownAtmosphere r100 = this.countDown;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECAuctionDigitalAtmosphere r104 = this.digital;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "ECAuctionAtmosphere(countDown=" + this.countDown + ", digital=" + this.digital + ")";
    }

    public final ECAuctionCountdownAtmosphere getCountDown() {
        return this.countDown;
    }

    public final ECAuctionDigitalAtmosphere getDigital() {
        return this.digital;
    }

    public ECAuctionAtmosphere(ECAuctionCountdownAtmosphere r100, ECAuctionDigitalAtmosphere r101) {
        this.countDown = r100;
        this.digital = r101;
    }

    public /* synthetic */ ECAuctionAtmosphere(ECAuctionCountdownAtmosphere r100, ECAuctionDigitalAtmosphere r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this(r100, r101);
    }
}
