package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MainDisplayTopAppHistory implements Parcelable {
    public static final Parcelable.Creator<MainDisplayTopAppHistory> CREATOR = new a();
    private final long baselineAt;
    private final String baselinePackage;
    private final boolean changed;
    private final String chatSessionId;
    private final String currentPackage;
    private final long lastChangeAt;
    private final boolean watching;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<MainDisplayTopAppHistory> {
        @Override // android.os.Parcelable.Creator
        public final MainDisplayTopAppHistory createFromParcel(Parcel parcel) {
            boolean z;
            g.f(parcel, "parcel");
            boolean z3 = false;
            if (parcel.readInt() != 0) {
                z = false;
                z3 = true;
            } else {
                z = false;
            }
            return new MainDisplayTopAppHistory(z3, parcel.readInt() == 0 ? z : true, parcel.readString(), parcel.readString(), parcel.readLong(), parcel.readLong(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MainDisplayTopAppHistory[] newArray(int i10) {
            return new MainDisplayTopAppHistory[i10];
        }
    }

    public MainDisplayTopAppHistory(boolean z, boolean z3, String baselinePackage, String currentPackage, long j10, long j11, String chatSessionId) {
        g.f(baselinePackage, "baselinePackage");
        g.f(currentPackage, "currentPackage");
        g.f(chatSessionId, "chatSessionId");
        this.watching = z;
        this.changed = z3;
        this.baselinePackage = baselinePackage;
        this.currentPackage = currentPackage;
        this.baselineAt = j10;
        this.lastChangeAt = j11;
        this.chatSessionId = chatSessionId;
    }

    public static /* synthetic */ MainDisplayTopAppHistory copy$default(MainDisplayTopAppHistory mainDisplayTopAppHistory, boolean z, boolean z3, String str, String str2, long j10, long j11, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z = mainDisplayTopAppHistory.watching;
        }
        if ((i10 & 2) != 0) {
            z3 = mainDisplayTopAppHistory.changed;
        }
        if ((i10 & 4) != 0) {
            str = mainDisplayTopAppHistory.baselinePackage;
        }
        if ((i10 & 8) != 0) {
            str2 = mainDisplayTopAppHistory.currentPackage;
        }
        if ((i10 & 16) != 0) {
            j10 = mainDisplayTopAppHistory.baselineAt;
        }
        if ((i10 & 32) != 0) {
            j11 = mainDisplayTopAppHistory.lastChangeAt;
        }
        if ((i10 & 64) != 0) {
            str3 = mainDisplayTopAppHistory.chatSessionId;
        }
        String str4 = str3;
        long j12 = j11;
        long j13 = j10;
        return mainDisplayTopAppHistory.copy(z, z3, str, str2, j13, j12, str4);
    }

    public final boolean component1() {
        return this.watching;
    }

    public final boolean component2() {
        return this.changed;
    }

    public final String component3() {
        return this.baselinePackage;
    }

    public final String component4() {
        return this.currentPackage;
    }

    public final long component5() {
        return this.baselineAt;
    }

    public final long component6() {
        return this.lastChangeAt;
    }

    public final String component7() {
        return this.chatSessionId;
    }

    public final MainDisplayTopAppHistory copy(boolean z, boolean z3, String baselinePackage, String currentPackage, long j10, long j11, String chatSessionId) {
        g.f(baselinePackage, "baselinePackage");
        g.f(currentPackage, "currentPackage");
        g.f(chatSessionId, "chatSessionId");
        return new MainDisplayTopAppHistory(z, z3, baselinePackage, currentPackage, j10, j11, chatSessionId);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MainDisplayTopAppHistory)) {
            return false;
        }
        MainDisplayTopAppHistory mainDisplayTopAppHistory = (MainDisplayTopAppHistory) obj;
        return this.watching == mainDisplayTopAppHistory.watching && this.changed == mainDisplayTopAppHistory.changed && g.b(this.baselinePackage, mainDisplayTopAppHistory.baselinePackage) && g.b(this.currentPackage, mainDisplayTopAppHistory.currentPackage) && this.baselineAt == mainDisplayTopAppHistory.baselineAt && this.lastChangeAt == mainDisplayTopAppHistory.lastChangeAt && g.b(this.chatSessionId, mainDisplayTopAppHistory.chatSessionId);
    }

    public final long getBaselineAt() {
        return this.baselineAt;
    }

    public final String getBaselinePackage() {
        return this.baselinePackage;
    }

    public final boolean getChanged() {
        return this.changed;
    }

    public final String getChatSessionId() {
        return this.chatSessionId;
    }

    public final String getCurrentPackage() {
        return this.currentPackage;
    }

    public final long getLastChangeAt() {
        return this.lastChangeAt;
    }

    public final boolean getWatching() {
        return this.watching;
    }

    public int hashCode() {
        return this.chatSessionId.hashCode() + a0.a.c(a0.a.c(d.a(d.a(ai.onnxruntime.a.f(Boolean.hashCode(this.watching) * 31, 31, this.changed), 31, this.baselinePackage), 31, this.currentPackage), this.baselineAt, 31), this.lastChangeAt, 31);
    }

    public String toString() {
        boolean z = this.watching;
        boolean z3 = this.changed;
        String str = this.baselinePackage;
        String str2 = this.currentPackage;
        long j10 = this.baselineAt;
        long j11 = this.lastChangeAt;
        String str3 = this.chatSessionId;
        StringBuilder sb2 = new StringBuilder("MainDisplayTopAppHistory(watching=");
        sb2.append(z);
        sb2.append(", changed=");
        sb2.append(z3);
        sb2.append(", baselinePackage=");
        ai.onnxruntime.a.z(sb2, str, ", currentPackage=", str2, ", baselineAt=");
        sb2.append(j10);
        a0.a.s(j11, ", lastChangeAt=", ", chatSessionId=", sb2);
        return ai.onnxruntime.a.o(sb2, str3, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.watching ? 1 : 0);
        dest.writeInt(this.changed ? 1 : 0);
        dest.writeString(this.baselinePackage);
        dest.writeString(this.currentPackage);
        dest.writeLong(this.baselineAt);
        dest.writeLong(this.lastChangeAt);
        dest.writeString(this.chatSessionId);
    }

    public /* synthetic */ MainDisplayTopAppHistory(boolean z, boolean z3, String str, String str2, long j10, long j11, String str3, int i10, e eVar) {
        this(z, z3, str, str2, j10, j11, (i10 & 64) != 0 ? "" : str3);
    }
}
