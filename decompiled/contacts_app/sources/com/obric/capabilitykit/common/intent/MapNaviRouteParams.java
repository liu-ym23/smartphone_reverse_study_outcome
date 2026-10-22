package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapNaviRouteParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "destName", "", "departName", "transportMode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getTransportMode", "()Ljava/lang/Integer;", "setTransportMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapNaviRouteParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MapNaviRouteParams> CREATOR = null;
    private String departName;
    private String destName;
    private Integer transportMode;

    /* JADX INFO: compiled from: MapNaviRouteParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MapNaviRouteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapNaviRouteParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            String r2 = r6.readString();
            String r3 = r6.readString();
            if (r6.readInt() != 0) goto L5;
            Integer r4 = null;
        L6:
            MapNaviRouteParams r1 = new MapNaviRouteParams(r2, r3, r4);
            int r5 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r8 = 1;
        L7:
            if (r8 > r5) goto L9;
            r8 = r8 + 1;
        L9:
            if (r8 > r0) goto L11;
            ParcelUtils.skipValueSafely(r6, r7);
            r8 = r8 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r4 = Integer.valueOf(r6.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapNaviRouteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapNaviRouteParams[] newArray(int r1) {
            return new MapNaviRouteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapNaviRouteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public MapNaviRouteParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MapNaviRouteParams copy$default(MapNaviRouteParams r0, String r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.destName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.departName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.transportMode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.destName;
    }

    public final String component2() {
        return this.departName;
    }

    public final Integer component3() {
        return this.transportMode;
    }

    public final MapNaviRouteParams copy(String r1, String r2, Integer r3) {
        return new MapNaviRouteParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MapNaviRouteParams) == true) goto L8;
        return false;
    L8:
        MapNaviRouteParams r6 = (MapNaviRouteParams) r5;
        if (Intrinsics.areEqual(this.destName, r6.destName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.departName, r6.departName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transportMode, r6.transportMode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.destName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.departName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.transportMode;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MapNaviRouteParams(destName=" + this.destName + ", departName=" + this.departName + ", transportMode=" + this.transportMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.destName);
        r2.writeString(this.departName);
        Integer r1 = this.transportMode;
        if (r1 != null) goto L5;
        r2.writeInt(0);
        return;
    L5:
        r2.writeInt(1);
        r2.writeInt(r1.intValue());
    }

    public MapNaviRouteParams(String r1, String r2, Integer r3) {
        this.destName = r1;
        this.departName = r2;
        this.transportMode = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ MapNaviRouteParams(String r2, String r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final String getDestName() {
        return this.destName;
    }

    public final void setDestName(String r1) {
        this.destName = r1;
    }

    public final String getDepartName() {
        return this.departName;
    }

    public final void setDepartName(String r1) {
        this.departName = r1;
    }

    public final Integer getTransportMode() {
        return this.transportMode;
    }

    public final void setTransportMode(Integer r1) {
        this.transportMode = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof MapNaviRouteParams) == false) goto L5;
        String r0 = this.destName;
        if (r0 != null) goto L9;
        r0 = ((MapNaviRouteParams) r3).destName;
    L9:
        String r1 = this.departName;
        if (r1 != null) goto L12;
        r1 = ((MapNaviRouteParams) r3).departName;
    L12:
        Integer r2 = this.transportMode;
        if (r2 != null) goto L16;
        r2 = ((MapNaviRouteParams) r3).transportMode;
    L16:
        return new MapNaviRouteParams(r0, r1, r2);
    L5:
        return this;
    }
}
