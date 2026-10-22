package com.zyql.ability.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.foundation.b;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import i7.a;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0017JN\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b!\u0010\u0015J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u001bR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b-\u0010\u001bR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b.\u0010\u0017¨\u00061"}, d2 = {"Lcom/zyql/ability/service/model/AbilityCallerParcelable;", "Landroid/os/Parcelable;", "", "packageName", "signatureHash", "versionName", "", "versionCode", "timestamp", "idempotentKey", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "()J", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;)Lcom/zyql/ability/service/model/AbilityCallerParcelable;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPackageName", "getSignatureHash", "getVersionName", "J", "getVersionCode", "getTimestamp", "getIdempotentKey", "CREATOR", "i7/a", "aidl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityCallerParcelable implements Parcelable {
    public static final a CREATOR = new a();
    private final String idempotentKey;
    private final String packageName;
    private final String signatureHash;
    private final long timestamp;
    private final long versionCode;
    private final String versionName;

    public AbilityCallerParcelable(String packageName, String signatureHash, String str, long j5, long j6, String idempotentKey) {
        k.f(packageName, "packageName");
        k.f(signatureHash, "signatureHash");
        k.f(idempotentKey, "idempotentKey");
        this.packageName = packageName;
        this.signatureHash = signatureHash;
        this.versionName = str;
        this.versionCode = j5;
        this.timestamp = j6;
        this.idempotentKey = idempotentKey;
    }

    public static /* synthetic */ AbilityCallerParcelable copy$default(AbilityCallerParcelable abilityCallerParcelable, String str, String str2, String str3, long j5, long j6, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = abilityCallerParcelable.packageName;
        }
        if ((i & 2) != 0) {
            str2 = abilityCallerParcelable.signatureHash;
        }
        if ((i & 4) != 0) {
            str3 = abilityCallerParcelable.versionName;
        }
        if ((i & 8) != 0) {
            j5 = abilityCallerParcelable.versionCode;
        }
        if ((i & 16) != 0) {
            j6 = abilityCallerParcelable.timestamp;
        }
        if ((i & 32) != 0) {
            str4 = abilityCallerParcelable.idempotentKey;
        }
        String str5 = str4;
        long j10 = j6;
        String str6 = str3;
        return abilityCallerParcelable.copy(str, str2, str6, j5, j10, str5);
    }

    /* renamed from: component1, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getSignatureHash() {
        return this.signatureHash;
    }

    /* renamed from: component3, reason: from getter */
    public final String getVersionName() {
        return this.versionName;
    }

    /* renamed from: component4, reason: from getter */
    public final long getVersionCode() {
        return this.versionCode;
    }

    /* renamed from: component5, reason: from getter */
    public final long getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component6, reason: from getter */
    public final String getIdempotentKey() {
        return this.idempotentKey;
    }

    public final AbilityCallerParcelable copy(String packageName, String signatureHash, String versionName, long versionCode, long timestamp, String idempotentKey) {
        k.f(packageName, "packageName");
        k.f(signatureHash, "signatureHash");
        k.f(idempotentKey, "idempotentKey");
        return new AbilityCallerParcelable(packageName, signatureHash, versionName, versionCode, timestamp, idempotentKey);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityCallerParcelable)) {
            return false;
        }
        AbilityCallerParcelable abilityCallerParcelable = (AbilityCallerParcelable) other;
        return k.b(this.packageName, abilityCallerParcelable.packageName) && k.b(this.signatureHash, abilityCallerParcelable.signatureHash) && k.b(this.versionName, abilityCallerParcelable.versionName) && this.versionCode == abilityCallerParcelable.versionCode && this.timestamp == abilityCallerParcelable.timestamp && k.b(this.idempotentKey, abilityCallerParcelable.idempotentKey);
    }

    public final String getIdempotentKey() {
        return this.idempotentKey;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSignatureHash() {
        return this.signatureHash;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public int hashCode() {
        int iC = B7.a.c(this.packageName.hashCode() * 31, 31, this.signatureHash);
        String str = this.versionName;
        return this.idempotentKey.hashCode() + androidx.appfunctions.metadata.a.c(androidx.appfunctions.metadata.a.c((iC + (str == null ? 0 : str.hashCode())) * 31, 31, this.versionCode), 31, this.timestamp);
    }

    public String toString() {
        String str = this.packageName;
        String str2 = this.signatureHash;
        String str3 = this.versionName;
        long j5 = this.versionCode;
        long j6 = this.timestamp;
        String str4 = this.idempotentKey;
        StringBuilder sbW = B7.a.w("AbilityCallerParcelable(packageName=", str, ", signatureHash=", str2, ", versionName=");
        B7.a.y(j5, str3, ", versionCode=", sbW);
        b.y(j6, ", timestamp=", ", idempotentKey=", sbW);
        return B7.a.q(sbW, str4, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.packageName);
        parcel.writeString(this.signatureHash);
        parcel.writeString(this.versionName);
        parcel.writeLong(this.versionCode);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.idempotentKey);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ AbilityCallerParcelable(String str, String str2, String str3, long j5, long j6, String str4, int i, e eVar) {
        String str5;
        long jCurrentTimeMillis = (i & 16) != 0 ? System.currentTimeMillis() : j6;
        if ((i & 32) != 0) {
            String string = UUID.randomUUID().toString();
            k.e(string, "toString(...)");
            str5 = string;
        } else {
            str5 = str4;
        }
        this(str, str2, str3, j5, jCurrentTimeMillis, str5);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityCallerParcelable(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        long j5 = parcel.readLong();
        long j6 = parcel.readLong();
        String string4 = parcel.readString();
        this(str, str2, string3, j5, j6, string4 == null ? "" : string4);
    }
}
