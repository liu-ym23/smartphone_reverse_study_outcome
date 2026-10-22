package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.versionedparcelable.ParcelUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", "Landroid/os/Parcelable;", "packageName", "", "implClassName", "(Ljava/lang/String;Ljava/lang/String;)V", "getImplClassName", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AppIntentImplInfo implements Parcelable {
    public static final Parcelable.Creator<AppIntentImplInfo> CREATOR = null;
    private final String implClassName;
    private final String packageName;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<AppIntentImplInfo> {
        public a() {
        }

        public final AppIntentImplInfo a(Parcel r5) {
            int r4 = r5.readInt();
            Intrinsics.checkNotNullParameter(r5, "parcel");
            AppIntentImplInfo r0 = new AppIntentImplInfo(r5.readString(), r5.readString());
            int r1 = Math.min(r4, 0);
            ClassLoader r2 = a.class.getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r1) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r4) goto L7;
            ParcelUtils.skipValueSafely(r5, r2);
            r3 = r3 + 1;
            goto L5
        L7:
            return r0;
        }

        public final AppIntentImplInfo[] a(int r1) {
            return new AppIntentImplInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentImplInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentImplInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public AppIntentImplInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "packageName");
        Intrinsics.checkNotNullParameter(r3, "implClassName");
        this.packageName = r2;
        this.implClassName = r3;
    }

    public static /* synthetic */ AppIntentImplInfo copy$default(AppIntentImplInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.packageName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.implClassName;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.packageName;
    }

    public final String component2() {
        return this.implClassName;
    }

    public final AppIntentImplInfo copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "packageName");
        Intrinsics.checkNotNullParameter(r2, "implClassName");
        return new AppIntentImplInfo(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AppIntentImplInfo) == true) goto L8;
        return false;
    L8:
        AppIntentImplInfo r6 = (AppIntentImplInfo) r5;
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.implClassName, r6.implClassName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getImplClassName() {
        return this.implClassName;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.implClassName.hashCode();
    }

    public String toString() {
        return "AppIntentImplInfo(packageName=" + this.packageName + ", implClassName=" + this.implClassName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.packageName);
        r1.writeString(this.implClassName);
    }
}
