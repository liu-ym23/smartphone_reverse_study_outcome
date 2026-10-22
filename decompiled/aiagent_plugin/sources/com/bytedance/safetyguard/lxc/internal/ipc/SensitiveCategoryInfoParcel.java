package com.bytedance.safetyguard.lxc.internal.ipc;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ProxyIpcModels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SensitiveCategoryInfoParcel implements Parcelable {
    public static final Parcelable.Creator<SensitiveCategoryInfoParcel> CREATOR = null;
    private final String categoryDesc;
    private final String sensitiveCategory;

    /* JADX INFO: compiled from: ProxyIpcModels.kt */
    public static final class Creator implements Parcelable.Creator<SensitiveCategoryInfoParcel> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SensitiveCategoryInfoParcel createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            return new SensitiveCategoryInfoParcel(r2.readString(), r2.readString());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SensitiveCategoryInfoParcel createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SensitiveCategoryInfoParcel[] newArray(int r1) {
            return new SensitiveCategoryInfoParcel[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SensitiveCategoryInfoParcel[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ SensitiveCategoryInfoParcel copy$default(SensitiveCategoryInfoParcel r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.sensitiveCategory;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.categoryDesc;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.sensitiveCategory;
    }

    public final String component2() {
        return this.categoryDesc;
    }

    public final SensitiveCategoryInfoParcel copy(String r1, String r2) {
        o.e(r1, "sensitiveCategory");
        return new SensitiveCategoryInfoParcel(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SensitiveCategoryInfoParcel.class) == true) goto L8;
        return false;
    L8:
        SensitiveCategoryInfoParcel r6 = (SensitiveCategoryInfoParcel) ZeusTransformUtils.preCheckCast(r5, SensitiveCategoryInfoParcel.class, "com.obric.aiagent.plugin");
        if (o.a(this.sensitiveCategory, r6.sensitiveCategory) == true) goto L12;
        return false;
    L12:
        if (o.a(this.categoryDesc, r6.categoryDesc) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.sensitiveCategory.hashCode() * 31;
        String r1 = this.categoryDesc;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "SensitiveCategoryInfoParcel(sensitiveCategory=" + this.sensitiveCategory + ", categoryDesc=" + this.categoryDesc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "out");
        r1.writeString(this.sensitiveCategory);
        r1.writeString(this.categoryDesc);
    }

    public SensitiveCategoryInfoParcel(String r2, String r3) {
        o.e(r2, "sensitiveCategory");
        this.sensitiveCategory = r2;
        this.categoryDesc = r3;
    }

    public final String getSensitiveCategory() {
        return this.sensitiveCategory;
    }

    public final String getCategoryDesc() {
        return this.categoryDesc;
    }
}
