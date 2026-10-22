package com.stepos.taskrobot.common.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0015J.\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0015J\u0010\u0010\u001a\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u000bJ\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b\"\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b#\u0010\u0015¨\u0006$"}, d2 = {"Lcom/stepos/taskrobot/common/bean/AppOccupationResult;", "Landroid/os/Parcelable;", "", "occupied", "", "occupierTaskId", "packageName", AppAgent.CONSTRUCT, "(ZLjava/lang/String;Ljava/lang/String;)V", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "()Z", "component2", "()Ljava/lang/String;", "component3", "copy", "(ZLjava/lang/String;Ljava/lang/String;)Lcom/stepos/taskrobot/common/bean/AppOccupationResult;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getOccupied", "Ljava/lang/String;", "getOccupierTaskId", "getPackageName", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AppOccupationResult implements Parcelable {
    public static final Parcelable.Creator<AppOccupationResult> CREATOR = new Creator();
    private final boolean occupied;
    private final String occupierTaskId;
    private final String packageName;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<AppOccupationResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppOccupationResult createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new AppOccupationResult(parcel.readInt() != 0, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AppOccupationResult[] newArray(int i) {
            return new AppOccupationResult[i];
        }
    }

    public AppOccupationResult(boolean z10, String occupierTaskId, String packageName) {
        k.f(occupierTaskId, "occupierTaskId");
        k.f(packageName, "packageName");
        this.occupied = z10;
        this.occupierTaskId = occupierTaskId;
        this.packageName = packageName;
    }

    public static /* synthetic */ AppOccupationResult copy$default(AppOccupationResult appOccupationResult, boolean z10, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            z10 = appOccupationResult.occupied;
        }
        if ((i & 2) != 0) {
            str = appOccupationResult.occupierTaskId;
        }
        if ((i & 4) != 0) {
            str2 = appOccupationResult.packageName;
        }
        return appOccupationResult.copy(z10, str, str2);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getOccupied() {
        return this.occupied;
    }

    /* renamed from: component2, reason: from getter */
    public final String getOccupierTaskId() {
        return this.occupierTaskId;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    public final AppOccupationResult copy(boolean occupied, String occupierTaskId, String packageName) {
        k.f(occupierTaskId, "occupierTaskId");
        k.f(packageName, "packageName");
        return new AppOccupationResult(occupied, occupierTaskId, packageName);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppOccupationResult)) {
            return false;
        }
        AppOccupationResult appOccupationResult = (AppOccupationResult) other;
        return this.occupied == appOccupationResult.occupied && k.b(this.occupierTaskId, appOccupationResult.occupierTaskId) && k.b(this.packageName, appOccupationResult.packageName);
    }

    public final boolean getOccupied() {
        return this.occupied;
    }

    public final String getOccupierTaskId() {
        return this.occupierTaskId;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return this.packageName.hashCode() + a.c(Boolean.hashCode(this.occupied) * 31, 31, this.occupierTaskId);
    }

    public String toString() {
        boolean z10 = this.occupied;
        String str = this.occupierTaskId;
        String str2 = this.packageName;
        StringBuilder sb = new StringBuilder("AppOccupationResult(occupied=");
        sb.append(z10);
        sb.append(", occupierTaskId=");
        sb.append(str);
        sb.append(", packageName=");
        return a.q(sb, str2, ")");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.occupied ? 1 : 0);
        dest.writeString(this.occupierTaskId);
        dest.writeString(this.packageName);
    }
}
