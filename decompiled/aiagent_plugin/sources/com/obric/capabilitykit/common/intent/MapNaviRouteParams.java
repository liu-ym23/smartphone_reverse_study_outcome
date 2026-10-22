package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MapNaviRouteParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MapNaviRouteParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MapNaviRouteParams> CREATOR = null;
    private String departName;
    private String destName;
    private Integer transportMode;

    /* JADX INFO: compiled from: MapNaviRouteParams.kt */
    public static final class Creator implements Parcelable.Creator<MapNaviRouteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapNaviRouteParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
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
            a.a(r6, r7);
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
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
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
        if (ZeusTransformUtils.instanceOf(r5, MapNaviRouteParams.class) == true) goto L8;
        return false;
    L8:
        MapNaviRouteParams r6 = (MapNaviRouteParams) ZeusTransformUtils.preCheckCast(r5, MapNaviRouteParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.destName, r6.destName) == true) goto L12;
        return false;
    L12:
        if (o.a(this.departName, r6.departName) == true) goto L15;
        return false;
    L15:
        if (o.a(this.transportMode, r6.transportMode) == true) goto L17;
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
        o.e(r2, "out");
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
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ MapNaviRouteParams(String r2, String r3, Integer r4, int r5, h r6) {
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
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, MapNaviRouteParams.class) == false) goto L5;
        String r1 = this.destName;
        if (r1 != null) goto L9;
        r1 = ((MapNaviRouteParams) ZeusTransformUtils.preCheckCast(r5, MapNaviRouteParams.class, "com.obric.aiagent.plugin")).destName;
    L9:
        String r3 = this.departName;
        if (r3 != null) goto L12;
        r3 = ((MapNaviRouteParams) ZeusTransformUtils.preCheckCast(r5, MapNaviRouteParams.class, "com.obric.aiagent.plugin")).departName;
    L12:
        Integer r4 = this.transportMode;
        if (r4 != null) goto L16;
        r4 = ((MapNaviRouteParams) ZeusTransformUtils.preCheckCast(r5, MapNaviRouteParams.class, "com.obric.aiagent.plugin")).transportMode;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new MapNaviRouteParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
