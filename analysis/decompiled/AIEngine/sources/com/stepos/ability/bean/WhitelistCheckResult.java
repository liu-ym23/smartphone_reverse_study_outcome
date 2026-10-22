package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import h0.e;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class WhitelistCheckResult implements Parcelable {
    public static final int ALLOWED = 0;
    public static final int FAILED = 2;
    public static final int REDIRECT = 1;
    private final int manifestVersion;
    private final String resolvedAppName;
    private final int verdict;
    public static final a Companion = new a();
    public static final Parcelable.Creator<WhitelistCheckResult> CREATOR = new b();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b implements Parcelable.Creator<WhitelistCheckResult> {
        @Override // android.os.Parcelable.Creator
        public final WhitelistCheckResult createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new WhitelistCheckResult(parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final WhitelistCheckResult[] newArray(int i10) {
            return new WhitelistCheckResult[i10];
        }
    }

    public WhitelistCheckResult(int i10, String resolvedAppName, int i11) {
        g.f(resolvedAppName, "resolvedAppName");
        this.verdict = i10;
        this.resolvedAppName = resolvedAppName;
        this.manifestVersion = i11;
    }

    public static /* synthetic */ WhitelistCheckResult copy$default(WhitelistCheckResult whitelistCheckResult, int i10, String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i10 = whitelistCheckResult.verdict;
        }
        if ((i12 & 2) != 0) {
            str = whitelistCheckResult.resolvedAppName;
        }
        if ((i12 & 4) != 0) {
            i11 = whitelistCheckResult.manifestVersion;
        }
        return whitelistCheckResult.copy(i10, str, i11);
    }

    public final int component1() {
        return this.verdict;
    }

    public final String component2() {
        return this.resolvedAppName;
    }

    public final int component3() {
        return this.manifestVersion;
    }

    public final WhitelistCheckResult copy(int i10, String resolvedAppName, int i11) {
        g.f(resolvedAppName, "resolvedAppName");
        return new WhitelistCheckResult(i10, resolvedAppName, i11);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WhitelistCheckResult)) {
            return false;
        }
        WhitelistCheckResult whitelistCheckResult = (WhitelistCheckResult) obj;
        return this.verdict == whitelistCheckResult.verdict && g.b(this.resolvedAppName, whitelistCheckResult.resolvedAppName) && this.manifestVersion == whitelistCheckResult.manifestVersion;
    }

    public final int getManifestVersion() {
        return this.manifestVersion;
    }

    public final String getResolvedAppName() {
        return this.resolvedAppName;
    }

    public final int getVerdict() {
        return this.verdict;
    }

    public int hashCode() {
        return Integer.hashCode(this.manifestVersion) + d.a(Integer.hashCode(this.verdict) * 31, 31, this.resolvedAppName);
    }

    public String toString() {
        return ai.onnxruntime.a.j(")", this.manifestVersion, e.e("WhitelistCheckResult(verdict=", this.verdict, ", resolvedAppName=", this.resolvedAppName, ", manifestVersion="));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        g.f(dest, "dest");
        dest.writeInt(this.verdict);
        dest.writeString(this.resolvedAppName);
        dest.writeInt(this.manifestVersion);
    }
}
