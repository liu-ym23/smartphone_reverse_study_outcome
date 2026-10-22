package com.obric.memorydata.sdk.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: SearchModel.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ParamItem implements Parcelable {
    public static final CREATOR CREATOR = null;
    private final Object value;

    /* JADX INFO: compiled from: SearchModel.kt */
    public static final class CREATOR implements Parcelable.Creator<ParamItem> {
        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ParamItem createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ParamItem[] newArray(int r1) {
            return newArray(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParamItem createFromParcel(Parcel r1) {
            o.e(r1, "parcel");
            return new ParamItem(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParamItem[] newArray(int r1) {
            return new ParamItem[r1];
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ ParamItem copy$default(ParamItem r0, Object r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        return r0.copy(r1);
    }

    public final Object component1() {
        return this.value;
    }

    public final ParamItem copy(Object r1) {
        o.e(r1, "value");
        return new ParamItem(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ParamItem.class) == true) goto L8;
        return false;
    L8:
        ParamItem r6 = (ParamItem) ZeusTransformUtils.preCheckCast(r5, ParamItem.class, "com.obric.aiagent.plugin");
        if (o.a(this.value, r6.value) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return "ParamItem(value=" + this.value + ')';
    }

    public ParamItem(Object r2) {
        o.e(r2, "value");
        this.value = r2;
    }

    public final Object getValue() {
        return this.value;
    }

    public ParamItem(Parcel r2) {
        o.e(r2, "parcel");
        Object r3 = r2.readValue(ParamItem.class.getClassLoader());
        o.a(r3);
        this(r3);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        r1.writeValue(this.value);
    }
}
