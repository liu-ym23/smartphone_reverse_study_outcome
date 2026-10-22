package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: WeatherSearchParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WeatherSearchParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<WeatherSearchParams> CREATOR = null;
    private String endTime;
    private String location;
    private String startTime;
    private String time;
    private String type;

    /* JADX INFO: compiled from: WeatherSearchParams.kt */
    public static final class Creator implements Parcelable.Creator<WeatherSearchParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WeatherSearchParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            WeatherSearchParams r1 = new WeatherSearchParams(r9.readString(), r9.readString(), r9.readString(), r9.readString(), r9.readString());
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r9, r8);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WeatherSearchParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WeatherSearchParams[] newArray(int r1) {
            return new WeatherSearchParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WeatherSearchParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public WeatherSearchParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ WeatherSearchParams copy$default(WeatherSearchParams r3, String r4, String r5, String r6, String r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.location;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.time;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.startTime;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.endTime;
    L14:
        String r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.type;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final String component1() {
        return this.location;
    }

    public final String component2() {
        return this.time;
    }

    public final String component3() {
        return this.startTime;
    }

    public final String component4() {
        return this.endTime;
    }

    public final String component5() {
        return this.type;
    }

    public final WeatherSearchParams copy(String r7, String r8, String r9, String r10, String r11) {
        return new WeatherSearchParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, WeatherSearchParams.class) == true) goto L8;
        return false;
    L8:
        WeatherSearchParams r6 = (WeatherSearchParams) ZeusTransformUtils.preCheckCast(r5, WeatherSearchParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.location, r6.location) == true) goto L12;
        return false;
    L12:
        if (o.a(this.time, r6.time) == true) goto L15;
        return false;
    L15:
        if (o.a(this.startTime, r6.startTime) == true) goto L18;
        return false;
    L18:
        if (o.a(this.endTime, r6.endTime) == true) goto L21;
        return false;
    L21:
        if (o.a(this.type, r6.type) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.location;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.time;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.startTime;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.endTime;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.type;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
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
        return "WeatherSearchParams(location=" + this.location + ", time=" + this.time + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        o.e(r1, "out");
        r1.writeString(this.location);
        r1.writeString(this.time);
        r1.writeString(this.startTime);
        r1.writeString(this.endTime);
        r1.writeString(this.type);
    }

    public WeatherSearchParams(String r1, String r2, String r3, String r4, String r5) {
        this.location = r1;
        this.time = r2;
        this.startTime = r3;
        this.endTime = r4;
        this.type = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ WeatherSearchParams(String r2, String r3, String r4, String r5, String r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getLocation() {
        return this.location;
    }

    public final void setLocation(String r1) {
        this.location = r1;
    }

    public final String getTime() {
        return this.time;
    }

    public final void setTime(String r1) {
        this.time = r1;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final void setStartTime(String r1) {
        this.startTime = r1;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final String getType() {
        return this.type;
    }

    public final void setType(String r1) {
        this.type = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, WeatherSearchParams.class) == false) goto L5;
        String r1 = this.location;
        if (r1 != null) goto L9;
        r1 = ((WeatherSearchParams) ZeusTransformUtils.preCheckCast(r10, WeatherSearchParams.class, "com.obric.aiagent.plugin")).location;
    L9:
        String r4 = r1;
        String r2 = this.time;
        if (r2 != null) goto L12;
        r2 = ((WeatherSearchParams) ZeusTransformUtils.preCheckCast(r10, WeatherSearchParams.class, "com.obric.aiagent.plugin")).time;
    L12:
        String r5 = r2;
        String r3 = this.startTime;
        if (r3 != null) goto L15;
        r3 = ((WeatherSearchParams) ZeusTransformUtils.preCheckCast(r10, WeatherSearchParams.class, "com.obric.aiagent.plugin")).startTime;
    L15:
        String r6 = r3;
        String r7 = this.endTime;
        if (r7 != null) goto L18;
        r7 = ((WeatherSearchParams) ZeusTransformUtils.preCheckCast(r10, WeatherSearchParams.class, "com.obric.aiagent.plugin")).endTime;
    L18:
        String r8 = r7;
        String r9 = this.type;
        if (r9 != null) goto L22;
        r9 = ((WeatherSearchParams) ZeusTransformUtils.preCheckCast(r10, WeatherSearchParams.class, "com.obric.aiagent.plugin")).type;
    L22:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new WeatherSearchParams(r4, r5, r6, r8, r9), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
