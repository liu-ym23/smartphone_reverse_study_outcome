package com.obric.memorydata.sdk.awareness;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: PersistentAwarenessModels.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AwarenessEventData implements Parcelable {
    public static final Parcelable.Creator<AwarenessEventData> CREATOR = null;
    private static final a Companion = null;
    private final Bundle extras;
    private final String key;
    private final long timestamp;
    private final Object value;

    /* JADX INFO: compiled from: PersistentAwarenessModels.kt */
    public static final class Creator implements Parcelable.Creator<AwarenessEventData> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessEventData createFromParcel(Parcel r7) {
            o.e(r7, "parcel");
            return new AwarenessEventData(r7.readString(), r7.readValue(AwarenessEventData.class.getClassLoader()), r7.readLong(), r7.readBundle(AwarenessEventData.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessEventData createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AwarenessEventData[] newArray(int r1) {
            return new AwarenessEventData[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AwarenessEventData[] newArray(int r1) {
            return newArray(r1);
        }
    }

    /* JADX INFO: compiled from: PersistentAwarenessModels.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }

        public final boolean a(Object r1) {
            o.e(r1, "value");
            if (ZeusTransformUtils.instanceOf(r1, Boolean.class) == false) goto L5;
        L22:
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r1, Byte.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Character.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Short.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Integer.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Long.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Float.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, Double.class) == true) goto L22;
            if (ZeusTransformUtils.instanceOf(r1, String.class) == true) goto L22;
            return false;
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ AwarenessEventData copy$default(AwarenessEventData r3, String r4, Object r5, long r6, Bundle r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.key;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.value;
    L8:
        Object r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.timestamp;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.extras;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.key;
    }

    public final Object component2() {
        return this.value;
    }

    public final long component3() {
        return this.timestamp;
    }

    public final Bundle component4() {
        return this.extras;
    }

    public final AwarenessEventData copy(String r7, Object r8, long r9, Bundle r11) {
        o.e(r7, "key");
        o.e(r8, "value");
        o.e(r11, "extras");
        return new AwarenessEventData(r7, r8, r9, r11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AwarenessEventData.class) == true) goto L8;
        return false;
    L8:
        AwarenessEventData r10 = (AwarenessEventData) ZeusTransformUtils.preCheckCast(r9, AwarenessEventData.class, "com.obric.aiagent.plugin");
        if (o.a(this.key, r10.key) == true) goto L12;
        return false;
    L12:
        if (o.a(this.value, r10.value) == true) goto L15;
        return false;
    L15:
        if (this.timestamp == r10.timestamp) goto L18;
        return false;
    L18:
        if (o.a(this.extras, r10.extras) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.key.hashCode() * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + this.extras.hashCode();
    }

    public String toString() {
        return "AwarenessEventData(key=" + this.key + ", value=" + this.value + ", timestamp=" + this.timestamp + ", extras=" + this.extras + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "dest");
        r3.writeString(this.key);
        r3.writeValue(this.value);
        r3.writeLong(this.timestamp);
        r3.writeBundle(this.extras);
    }

    public AwarenessEventData(String r2, Object r3, long r4, Bundle r6) {
        o.e(r2, "key");
        o.e(r3, "value");
        o.e(r6, "extras");
        this.key = r2;
        this.value = r3;
        this.timestamp = r4;
        this.extras = r6;
        if (Companion.a(r3) == false) goto L6;
        return;
    L6:
        throw new IllegalArgumentException("AwarenessEventData.value 仅支持基础类型和 String".toString());
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public /* synthetic */ AwarenessEventData(String r7, Object r8, long r9, Bundle r11, int r12, h r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = Bundle.EMPTY;
    L5:
        this(r7, r8, r9, r11);
    }

    public final Bundle getExtras() {
        return this.extras;
    }
}
