package com.zyql.ability.service.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import i7.b;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u0000 22\u00020\u0001:\u00013B7\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000b\u0010\u000fJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJJ\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\"\u0010\u001aJ\u0010\u0010#\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b#\u0010\u0016J\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010+\u001a\u0004\b-\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010.\u001a\u0004\b/\u0010\u001dR\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u00100\u001a\u0004\b1\u0010\u001f¨\u00064"}, d2 = {"Lcom/zyql/ability/service/model/AbilityExeReqParcelable;", "Landroid/os/Parcelable;", "", "abilityId", "", "params", "extra", "Lcom/zyql/ability/service/model/AbilityMetadataParcelable;", "metaData", "Lcom/zyql/ability/service/model/AbilityCallerParcelable;", "caller", AppAgent.CONSTRUCT, "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/zyql/ability/service/model/AbilityMetadataParcelable;Lcom/zyql/ability/service/model/AbilityCallerParcelable;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/Long;", "component2", "()Ljava/lang/String;", "component3", "component4", "()Lcom/zyql/ability/service/model/AbilityMetadataParcelable;", "component5", "()Lcom/zyql/ability/service/model/AbilityCallerParcelable;", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Lcom/zyql/ability/service/model/AbilityMetadataParcelable;Lcom/zyql/ability/service/model/AbilityCallerParcelable;)Lcom/zyql/ability/service/model/AbilityExeReqParcelable;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Long;", "getAbilityId", "Ljava/lang/String;", "getParams", "getExtra", "Lcom/zyql/ability/service/model/AbilityMetadataParcelable;", "getMetaData", "Lcom/zyql/ability/service/model/AbilityCallerParcelable;", "getCaller", "CREATOR", "i7/b", "aidl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityExeReqParcelable implements Parcelable {
    public static final b CREATOR = new b();
    private final Long abilityId;
    private final AbilityCallerParcelable caller;
    private final String extra;
    private final AbilityMetadataParcelable metaData;
    private final String params;

    public AbilityExeReqParcelable(Long l, String str, String str2, AbilityMetadataParcelable abilityMetadataParcelable, AbilityCallerParcelable caller) {
        k.f(caller, "caller");
        this.abilityId = l;
        this.params = str;
        this.extra = str2;
        this.metaData = abilityMetadataParcelable;
        this.caller = caller;
    }

    public static /* synthetic */ AbilityExeReqParcelable copy$default(AbilityExeReqParcelable abilityExeReqParcelable, Long l, String str, String str2, AbilityMetadataParcelable abilityMetadataParcelable, AbilityCallerParcelable abilityCallerParcelable, int i, Object obj) {
        if ((i & 1) != 0) {
            l = abilityExeReqParcelable.abilityId;
        }
        if ((i & 2) != 0) {
            str = abilityExeReqParcelable.params;
        }
        if ((i & 4) != 0) {
            str2 = abilityExeReqParcelable.extra;
        }
        if ((i & 8) != 0) {
            abilityMetadataParcelable = abilityExeReqParcelable.metaData;
        }
        if ((i & 16) != 0) {
            abilityCallerParcelable = abilityExeReqParcelable.caller;
        }
        AbilityCallerParcelable abilityCallerParcelable2 = abilityCallerParcelable;
        String str3 = str2;
        return abilityExeReqParcelable.copy(l, str, str3, abilityMetadataParcelable, abilityCallerParcelable2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getAbilityId() {
        return this.abilityId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExtra() {
        return this.extra;
    }

    /* renamed from: component4, reason: from getter */
    public final AbilityMetadataParcelable getMetaData() {
        return this.metaData;
    }

    /* renamed from: component5, reason: from getter */
    public final AbilityCallerParcelable getCaller() {
        return this.caller;
    }

    public final AbilityExeReqParcelable copy(Long abilityId, String params, String extra, AbilityMetadataParcelable metaData, AbilityCallerParcelable caller) {
        k.f(caller, "caller");
        return new AbilityExeReqParcelable(abilityId, params, extra, metaData, caller);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityExeReqParcelable)) {
            return false;
        }
        AbilityExeReqParcelable abilityExeReqParcelable = (AbilityExeReqParcelable) other;
        return k.b(this.abilityId, abilityExeReqParcelable.abilityId) && k.b(this.params, abilityExeReqParcelable.params) && k.b(this.extra, abilityExeReqParcelable.extra) && k.b(this.metaData, abilityExeReqParcelable.metaData) && k.b(this.caller, abilityExeReqParcelable.caller);
    }

    public final Long getAbilityId() {
        return this.abilityId;
    }

    public final AbilityCallerParcelable getCaller() {
        return this.caller;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final AbilityMetadataParcelable getMetaData() {
        return this.metaData;
    }

    public final String getParams() {
        return this.params;
    }

    public int hashCode() {
        Long l = this.abilityId;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.params;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.extra;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        AbilityMetadataParcelable abilityMetadataParcelable = this.metaData;
        return this.caller.hashCode() + ((iHashCode3 + (abilityMetadataParcelable != null ? abilityMetadataParcelable.hashCode() : 0)) * 31);
    }

    public String toString() {
        return "AbilityExeReqParcelable(abilityId=" + this.abilityId + ", params=" + this.params + ", extra=" + this.extra + ", metaData=" + this.metaData + ", caller=" + this.caller + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeValue(this.abilityId);
        parcel.writeString(this.params);
        parcel.writeString(this.extra);
        parcel.writeParcelable(this.metaData, flags);
        parcel.writeParcelable(this.caller, flags);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityExeReqParcelable(Parcel parcel) {
        k.f(parcel, "parcel");
        Object value = parcel.readValue(Long.TYPE.getClassLoader());
        Long l = value instanceof Long ? (Long) value : null;
        String string = parcel.readString();
        String string2 = parcel.readString();
        AbilityMetadataParcelable abilityMetadataParcelable = (AbilityMetadataParcelable) parcel.readParcelable(AbilityMetadataParcelable.class.getClassLoader());
        AbilityMetadataParcelable abilityMetadataParcelable2 = abilityMetadataParcelable == null ? new AbilityMetadataParcelable("", "", "", "", "", "", "") : abilityMetadataParcelable;
        AbilityCallerParcelable abilityCallerParcelable = (AbilityCallerParcelable) parcel.readParcelable(AbilityCallerParcelable.class.getClassLoader());
        this(l, string, string2, abilityMetadataParcelable2, abilityCallerParcelable == null ? new AbilityCallerParcelable("", "", null, 0L, 0L, "") : abilityCallerParcelable);
    }
}
