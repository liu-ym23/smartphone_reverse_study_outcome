package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MapTakeTaxiParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MapTakeTaxiParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MapTakeTaxiParams> CREATOR = null;
    private String departName;
    private String destName;
    private Double dlat;
    private Double dlng;
    private Double slat;
    private Double slng;

    /* JADX INFO: compiled from: MapTakeTaxiParams.kt */
    public static final class Creator implements Parcelable.Creator<MapTakeTaxiParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapTakeTaxiParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            o.e(r12, "parcel");
            String r3 = r12.readString();
            String r4 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Double r6 = null;
        L7:
            if (r12.readInt() != 0) goto L9;
            Double r7 = null;
        L11:
            if (r12.readInt() != 0) goto L13;
            Double r8 = null;
        L15:
            if (r12.readInt() != 0) goto L17;
            Double r9 = null;
        L18:
            MapTakeTaxiParams r1 = new MapTakeTaxiParams(r3, r4, r6, r7, r8, r9);
            int r2 = Math.min(r0, 0);
            ClassLoader r11 = getClass().getClassLoader();
            int r5 = 1;
        L19:
            if (r5 > r2) goto L21;
            r5 = r5 + 1;
        L21:
            if (r5 > r0) goto L23;
            a.a(r12, r11);
            r5 = r5 + 1;
            goto L21
        L23:
            return r1;
        L17:
            r9 = Double.valueOf(r12.readDouble());
            goto L18
        L13:
            r8 = Double.valueOf(r12.readDouble());
            goto L15
        L9:
            r7 = Double.valueOf(r12.readDouble());
            goto L11
        L5:
            r6 = Double.valueOf(r12.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapTakeTaxiParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapTakeTaxiParams[] newArray(int r1) {
            return new MapTakeTaxiParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapTakeTaxiParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public MapTakeTaxiParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MapTakeTaxiParams copy$default(MapTakeTaxiParams r4, String r5, String r6, Double r7, Double r8, Double r9, Double r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.departName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.destName;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.slat;
    L11:
        Double r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.slng;
    L14:
        Double r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.dlat;
    L17:
        Double r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.dlng;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.departName;
    }

    public final String component2() {
        return this.destName;
    }

    public final Double component3() {
        return this.slat;
    }

    public final Double component4() {
        return this.slng;
    }

    public final Double component5() {
        return this.dlat;
    }

    public final Double component6() {
        return this.dlng;
    }

    public final MapTakeTaxiParams copy(String r8, String r9, Double r10, Double r11, Double r12, Double r13) {
        return new MapTakeTaxiParams(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MapTakeTaxiParams.class) == true) goto L8;
        return false;
    L8:
        MapTakeTaxiParams r6 = (MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r5, MapTakeTaxiParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.departName, r6.departName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.destName, r6.destName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.slat, r6.slat) == true) goto L18;
        return false;
    L18:
        if (o.a(this.slng, r6.slng) == true) goto L21;
        return false;
    L21:
        if (o.a(this.dlat, r6.dlat) == true) goto L24;
        return false;
    L24:
        if (o.a(this.dlng, r6.dlng) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        String r0 = this.departName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.destName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.slat;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.slng;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.dlat;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Double r16 = this.dlng;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MapTakeTaxiParams(departName=" + this.departName + ", destName=" + this.destName + ", slat=" + this.slat + ", slng=" + this.slng + ", dlat=" + this.dlat + ", dlng=" + this.dlng + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeString(this.departName);
        r5.writeString(this.destName);
        Double r0 = this.slat;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Double r1 = this.slng;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        Double r2 = this.dlat;
        if (r2 != null) goto L13;
        r5.writeInt(0);
    L14:
        Double r4 = this.dlng;
        if (r4 != null) goto L17;
        r5.writeInt(0);
        return;
    L17:
        r5.writeInt(1);
        r5.writeDouble(r4.doubleValue());
        return;
    L13:
        r5.writeInt(1);
        r5.writeDouble(r2.doubleValue());
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeDouble(r1.doubleValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeDouble(r0.doubleValue());
        goto L6
    }

    public MapTakeTaxiParams(String r1, String r2, Double r3, Double r4, Double r5, Double r6) {
        this.departName = r1;
        this.destName = r2;
        this.slat = r3;
        this.slng = r4;
        this.dlat = r5;
        this.dlng = r6;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ MapTakeTaxiParams(String r2, String r3, Double r4, Double r5, Double r6, Double r7, int r8, h r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
    }

    public final String getDepartName() {
        return this.departName;
    }

    public final void setDepartName(String r1) {
        this.departName = r1;
    }

    public final String getDestName() {
        return this.destName;
    }

    public final void setDestName(String r1) {
        this.destName = r1;
    }

    public final Double getSlat() {
        return this.slat;
    }

    public final void setSlat(Double r1) {
        this.slat = r1;
    }

    public final Double getSlng() {
        return this.slng;
    }

    public final void setSlng(Double r1) {
        this.slng = r1;
    }

    public final Double getDlat() {
        return this.dlat;
    }

    public final void setDlat(Double r1) {
        this.dlat = r1;
    }

    public final Double getDlng() {
        return this.dlng;
    }

    public final void setDlng(Double r1) {
        this.dlng = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r11) {
        if (ZeusTransformUtils.instanceOf(r11, MapTakeTaxiParams.class) == false) goto L5;
        String r1 = this.departName;
        if (r1 != null) goto L9;
        r1 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.aiagent.plugin")).departName;
    L9:
        String r4 = r1;
        String r2 = this.destName;
        if (r2 != null) goto L12;
        r2 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.aiagent.plugin")).destName;
    L12:
        String r5 = r2;
        Double r3 = this.slat;
        if (r3 != null) goto L15;
        r3 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.aiagent.plugin")).slat;
    L15:
        Double r6 = r3;
        Double r7 = this.slng;
        if (r7 != null) goto L18;
        r7 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.aiagent.plugin")).slng;
    L18:
        Double r8 = r7;
        Double r9 = this.dlat;
        if (r9 != null) goto L21;
        r9 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.aiagent.plugin")).dlat;
    L21:
        Double r10 = r9;
        Double r12 = this.dlng;
        if (r12 != null) goto L25;
        r12 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.aiagent.plugin")).dlng;
    L25:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new MapTakeTaxiParams(r4, r5, r6, r8, r10, r12), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
