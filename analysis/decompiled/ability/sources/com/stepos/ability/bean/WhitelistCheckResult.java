package com.stepos.ability.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 #2\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\nJ.\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u001a\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001e\u001a\u0004\b\u001f\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\u0013R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\"\u0010\n¨\u0006$"}, d2 = {"Lcom/stepos/ability/bean/WhitelistCheckResult;", "Landroid/os/Parcelable;", "", "verdict", "", "resolvedAppName", "manifestVersion", AppAgent.CONSTRUCT, "(ILjava/lang/String;I)V", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "component1", "component2", "()Ljava/lang/String;", "component3", "copy", "(ILjava/lang/String;I)Lcom/stepos/ability/bean/WhitelistCheckResult;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getVerdict", "Ljava/lang/String;", "getResolvedAppName", "getManifestVersion", "Companion", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class WhitelistCheckResult implements Parcelable {
    public static final int ALLOWED = 0;
    public static final int FAILED = 2;
    public static final int REDIRECT = 1;
    private final int manifestVersion;
    private final String resolvedAppName;
    private final int verdict;
    public static final Parcelable.Creator<WhitelistCheckResult> CREATOR = new Creator();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WhitelistCheckResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WhitelistCheckResult createFromParcel(Parcel parcel) {
            k.f(parcel, "parcel");
            return new WhitelistCheckResult(parcel.readInt(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WhitelistCheckResult[] newArray(int i) {
            return new WhitelistCheckResult[i];
        }
    }

    public WhitelistCheckResult(int i, String resolvedAppName, int i6) {
        k.f(resolvedAppName, "resolvedAppName");
        this.verdict = i;
        this.resolvedAppName = resolvedAppName;
        this.manifestVersion = i6;
    }

    public static /* synthetic */ WhitelistCheckResult copy$default(WhitelistCheckResult whitelistCheckResult, int i, String str, int i6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = whitelistCheckResult.verdict;
        }
        if ((i10 & 2) != 0) {
            str = whitelistCheckResult.resolvedAppName;
        }
        if ((i10 & 4) != 0) {
            i6 = whitelistCheckResult.manifestVersion;
        }
        return whitelistCheckResult.copy(i, str, i6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getVerdict() {
        return this.verdict;
    }

    /* renamed from: component2, reason: from getter */
    public final String getResolvedAppName() {
        return this.resolvedAppName;
    }

    /* renamed from: component3, reason: from getter */
    public final int getManifestVersion() {
        return this.manifestVersion;
    }

    public final WhitelistCheckResult copy(int verdict, String resolvedAppName, int manifestVersion) {
        k.f(resolvedAppName, "resolvedAppName");
        return new WhitelistCheckResult(verdict, resolvedAppName, manifestVersion);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WhitelistCheckResult)) {
            return false;
        }
        WhitelistCheckResult whitelistCheckResult = (WhitelistCheckResult) other;
        return this.verdict == whitelistCheckResult.verdict && k.b(this.resolvedAppName, whitelistCheckResult.resolvedAppName) && this.manifestVersion == whitelistCheckResult.manifestVersion;
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
        return Integer.hashCode(this.manifestVersion) + a.c(Integer.hashCode(this.verdict) * 31, 31, this.resolvedAppName);
    }

    public String toString() {
        int i = this.verdict;
        String str = this.resolvedAppName;
        return androidx.appfunctions.metadata.a.o(androidx.constraintlayout.core.dsl.a.k(i, "WhitelistCheckResult(verdict=", ", resolvedAppName=", str, ", manifestVersion="), ")", this.manifestVersion);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeInt(this.verdict);
        dest.writeString(this.resolvedAppName);
        dest.writeInt(this.manifestVersion);
    }
}
