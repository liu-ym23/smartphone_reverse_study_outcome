package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HourWeatherInfo implements Parcelable {
    public static final Parcelable.Creator<HourWeatherInfo> CREATOR = null;
    private final Integer temp;
    private final String time;
    private final String weatherCode;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<HourWeatherInfo> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HourWeatherInfo createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            String r2 = r6.readString();
            if (r6.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            HourWeatherInfo r1 = new HourWeatherInfo(r2, r3, r6.readString());
            int r4 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            a.a(r6, r5);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r6.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HourWeatherInfo createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final HourWeatherInfo[] newArray(int r1) {
            return new HourWeatherInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ HourWeatherInfo[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public HourWeatherInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ HourWeatherInfo copy$default(HourWeatherInfo r0, String r1, Integer r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.time;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.temp;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.weatherCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.time;
    }

    public final Integer component2() {
        return this.temp;
    }

    public final String component3() {
        return this.weatherCode;
    }

    public final HourWeatherInfo copy(String r1, Integer r2, String r3) {
        return new HourWeatherInfo(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, HourWeatherInfo.class) == true) goto L8;
        return false;
    L8:
        HourWeatherInfo r6 = (HourWeatherInfo) ZeusTransformUtils.preCheckCast(r5, HourWeatherInfo.class, "com.obric.aiagent.plugin");
        if (o.a(this.time, r6.time) == true) goto L12;
        return false;
    L12:
        if (o.a(this.temp, r6.temp) == true) goto L15;
        return false;
    L15:
        if (o.a(this.weatherCode, r6.weatherCode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.time;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.temp;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.weatherCode;
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
        return "HourWeatherInfo(time=" + this.time + ", temp=" + this.temp + ", weatherCode=" + this.weatherCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        o.e(r2, "out");
        r2.writeString(this.time);
        Integer r0 = this.temp;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
        r2.writeString(this.weatherCode);
    }

    public HourWeatherInfo(String r1, Integer r2, String r3) {
        this.time = r1;
        this.temp = r2;
        this.weatherCode = r3;
    }

    public /* synthetic */ HourWeatherInfo(String r2, Integer r3, String r4, int r5, h r6) {
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

    public final String getTime() {
        return this.time;
    }

    public final Integer getTemp() {
        return this.temp;
    }

    public final String getWeatherCode() {
        return this.weatherCode;
    }
}
