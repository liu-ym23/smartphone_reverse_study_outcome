package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020&HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\u0012\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010*H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "departName", "", "destName", "slat", "", "slng", "dlat", "dlng", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getDlat", "()Ljava/lang/Double;", "setDlat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDlng", "setDlng", "getSlat", "setSlat", "getSlng", "setSlng", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class MapTakeTaxiParams implements IntentParams, Parcelable {

    @NotNull
    public static final Parcelable.Creator<MapTakeTaxiParams> CREATOR = null;

    @Nullable
    private String departName;

    @Nullable
    private String destName;

    @Nullable
    private Double dlat;

    @Nullable
    private Double dlng;

    @Nullable
    private Double slat;

    @Nullable
    private Double slng;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MapTakeTaxiParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapTakeTaxiParams createFromParcel(@NotNull Parcel r11) {
            int r10 = r11.readInt();
            q.g(r11, "parcel");
            String r12 = r11.readString();
            String r13 = r11.readString();
            if (r11.readInt() != 0) goto L5;
            Double r14 = null;
        L7:
            if (r11.readInt() != 0) goto L9;
            Double r15 = null;
        L11:
            if (r11.readInt() != 0) goto L13;
            Double r16 = null;
        L15:
            if (r11.readInt() != 0) goto L17;
            Double r17 = null;
        L18:
            MapTakeTaxiParams r18 = new MapTakeTaxiParams(r12, r13, r14, r15, r16, r17);
            int r19 = Math.min(r10, 0);
            ClassLoader r20 = Creator.class.getClassLoader();
            int r21 = 1;
        L19:
            if (r21 > r19) goto L21;
            r21 = r21 + 1;
        L21:
            if (r21 > r10) goto L23;
            a.d(r11, r20);
            r21 = r21 + 1;
            goto L21
        L23:
            return r18;
        L17:
            r17 = Double.valueOf(r11.readDouble());
            goto L18
        L13:
            r16 = Double.valueOf(r11.readDouble());
            goto L15
        L9:
            r15 = Double.valueOf(r11.readDouble());
            goto L11
        L5:
            r14 = Double.valueOf(r11.readDouble());
            goto L7
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapTakeTaxiParams[] newArray(int r10) {
            return new MapTakeTaxiParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapTakeTaxiParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapTakeTaxiParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public MapTakeTaxiParams() {
        String r10 = null;
        String r11 = null;
        Double r12 = null;
        Double r13 = null;
        Double r14 = null;
        Double r15 = null;
        this(r10, r11, r12, r13, r14, r15, 63, null);
    }

    public static /* synthetic */ MapTakeTaxiParams copy$default(MapTakeTaxiParams r10, String r11, String r12, Double r13, Double r14, Double r15, Double r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.departName;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.destName;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.slat;
    L11:
        Double r20 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.slng;
    L14:
        Double r21 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.dlat;
    L17:
        Double r22 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.dlng;
    L20:
        String r23 = r11;
        return r10.copy(r23, r19, r20, r21, r22, r16);
    }

    @Nullable
    public final String component1() {
        return this.departName;
    }

    @Nullable
    public final String component2() {
        return this.destName;
    }

    @Nullable
    public final Double component3() {
        return this.slat;
    }

    @Nullable
    public final Double component4() {
        return this.slng;
    }

    @Nullable
    public final Double component5() {
        return this.dlat;
    }

    @Nullable
    public final Double component6() {
        return this.dlng;
    }

    @NotNull
    public final MapTakeTaxiParams copy(@Nullable String r10, @Nullable String r11, @Nullable Double r12, @Nullable Double r13, @Nullable Double r14, @Nullable Double r15) {
        return new MapTakeTaxiParams(r10, r11, r12, r13, r14, r15);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MapTakeTaxiParams) == true) goto L8;
        return false;
    L8:
        MapTakeTaxiParams r11 = (MapTakeTaxiParams) r10;
        if (q.b(this.departName, r11.departName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.destName, r11.destName) == true) goto L15;
        return false;
    L15:
        if (q.b(this.slat, r11.slat) == true) goto L18;
        return false;
    L18:
        if (q.b(this.slng, r11.slng) == true) goto L21;
        return false;
    L21:
        if (q.b(this.dlat, r11.dlat) == true) goto L24;
        return false;
    L24:
        if (q.b(this.dlng, r11.dlng) == true) goto L26;
        return false;
    L26:
        return true;
    }

    @Nullable
    public final String getDepartName() {
        return this.departName;
    }

    @Nullable
    public final String getDestName() {
        return this.destName;
    }

    @Nullable
    public final Double getDlat() {
        return this.dlat;
    }

    @Nullable
    public final Double getDlng() {
        return this.dlng;
    }

    @Nullable
    public final Double getSlat() {
        return this.slat;
    }

    @Nullable
    public final Double getSlng() {
        return this.slng;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public int hashCode() {
        String r10 = this.departName;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.destName;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Double r17 = this.slat;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Double r20 = this.slng;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        Double r23 = this.dlat;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        Double r26 = this.dlng;
        if (r26 == null) goto L27;
        r11 = r26.hashCode();
    L27:
        return r25 + r11;
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof MapTakeTaxiParams) == true) goto L5;
        return this;
    L5:
        String r11 = this.departName;
        if (r11 != null) goto L8;
        r11 = ((MapTakeTaxiParams) r10).departName;
    L8:
        String r12 = r11;
        String r13 = this.destName;
        if (r13 != null) goto L11;
        r13 = ((MapTakeTaxiParams) r10).destName;
    L11:
        String r14 = r13;
        Double r15 = this.slat;
        if (r15 != null) goto L14;
        r15 = ((MapTakeTaxiParams) r10).slat;
    L14:
        Double r16 = r15;
        Double r17 = this.slng;
        if (r17 != null) goto L17;
        r17 = ((MapTakeTaxiParams) r10).slng;
    L17:
        Double r18 = r17;
        Double r19 = this.dlat;
        if (r19 != null) goto L20;
        r19 = ((MapTakeTaxiParams) r10).dlat;
    L20:
        Double r20 = r19;
        Double r21 = this.dlng;
        if (r21 != null) goto L24;
        r21 = ((MapTakeTaxiParams) r10).dlng;
    L24:
        return new MapTakeTaxiParams(r12, r14, r16, r18, r20, r21);
    }

    public final void setDepartName(@Nullable String r10) {
        this.departName = r10;
    }

    public final void setDestName(@Nullable String r10) {
        this.destName = r10;
    }

    public final void setDlat(@Nullable Double r10) {
        this.dlat = r10;
    }

    public final void setDlng(@Nullable Double r10) {
        this.dlng = r10;
    }

    public final void setSlat(@Nullable Double r10) {
        this.slat = r10;
    }

    public final void setSlng(@Nullable Double r10) {
        this.slng = r10;
    }

    @NotNull
    public String toString() {
        return "MapTakeTaxiParams(departName=" + this.departName + ", destName=" + this.destName + ", slat=" + this.slat + ", slng=" + this.slng + ", dlat=" + this.dlat + ", dlng=" + this.dlng + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.departName);
        r10.writeString(this.destName);
        Double r12 = this.slat;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        Double r13 = this.slng;
        if (r13 != null) goto L9;
        r10.writeInt(0);
    L10:
        Double r14 = this.dlat;
        if (r14 != null) goto L13;
        r10.writeInt(0);
    L14:
        Double r15 = this.dlng;
        if (r15 != null) goto L17;
        r10.writeInt(0);
        return;
    L17:
        r10.writeInt(1);
        r10.writeDouble(r15.doubleValue());
        return;
    L13:
        r10.writeInt(1);
        r10.writeDouble(r14.doubleValue());
        goto L14
    L9:
        r10.writeInt(1);
        r10.writeDouble(r13.doubleValue());
        goto L10
    L5:
        r10.writeInt(1);
        r10.writeDouble(r12.doubleValue());
        goto L6
    }

    public MapTakeTaxiParams(@Nullable String r10, @Nullable String r11, @Nullable Double r12, @Nullable Double r13, @Nullable Double r14, @Nullable Double r15) {
        this.departName = r10;
        this.destName = r11;
        this.slat = r12;
        this.slng = r13;
        this.dlat = r14;
        this.dlng = r15;
    }

    public /* synthetic */ MapTakeTaxiParams(String r10, String r11, Double r12, Double r13, Double r14, Double r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r16 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r16 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r16 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r16 & 16) == 0) goto L18;
        r14 = null;
    L18:
        if ((r16 & 32) == 0) goto L20;
        r15 = null;
    L20:
        this(r10, r11, r12, r13, r14, r15);
    }
}
