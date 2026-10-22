package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.versionedparcelable.VersionedParcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", "Landroid/os/Parcelable;", "packageName", "", "implClassName", "(Ljava/lang/String;Ljava/lang/String;)V", "getImplClassName", "()Ljava/lang/String;", "getPackageName", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class AppIntentImplInfo implements Parcelable {

    @NotNull
    public static final Parcelable.Creator<AppIntentImplInfo> CREATOR = null;

    @NotNull
    private final String implClassName;

    @NotNull
    private final String packageName;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<AppIntentImplInfo> {
        public a() {
        }

        @NotNull
        public final AppIntentImplInfo a(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            AppIntentImplInfo r12 = new AppIntentImplInfo(r10.readString(), r10.readString());
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = a.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            be.a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentImplInfo createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppIntentImplInfo[] newArray(int r10) {
            return a(r10);
        }

        @NotNull
        public final AppIntentImplInfo[] a(int r10) {
            return new AppIntentImplInfo[r10];
        }
    }

    static {
        CREATOR = new a();
    }

    public AppIntentImplInfo(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "packageName");
        q.g(r11, "implClassName");
        this.packageName = r10;
        this.implClassName = r11;
    }

    public static /* synthetic */ AppIntentImplInfo copy$default(AppIntentImplInfo r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.packageName;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.implClassName;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final String component1() {
        return this.packageName;
    }

    @NotNull
    public final String component2() {
        return this.implClassName;
    }

    @NotNull
    public final AppIntentImplInfo copy(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "packageName");
        q.g(r11, "implClassName");
        return new AppIntentImplInfo(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof AppIntentImplInfo) == true) goto L8;
        return false;
    L8:
        AppIntentImplInfo r11 = (AppIntentImplInfo) r10;
        if (q.b(this.packageName, r11.packageName) == true) goto L12;
        return false;
    L12:
        if (q.b(this.implClassName, r11.implClassName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getImplClassName() {
        return this.implClassName;
    }

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.implClassName.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppIntentImplInfo(packageName=" + this.packageName + ", implClassName=" + this.implClassName + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.packageName);
        r10.writeString(this.implClassName);
    }
}
