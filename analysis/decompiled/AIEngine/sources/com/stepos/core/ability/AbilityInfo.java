package com.stepos.core.ability;

import android.os.Parcel;
import android.os.Parcelable;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.Arrays;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityInfo implements Parcelable {
    public static final Parcelable.Creator<AbilityInfo> CREATOR = new Creator();
    private String description;

    /* renamed from: id, reason: collision with root package name */
    private String f7209id;
    private String[] inputTypes;
    private boolean isStreamOutput;
    private int minMemoryMb;
    private String name;
    private String[] outputTypes;
    private String vendor;
    private String version;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class Creator implements Parcelable.Creator<AbilityInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AbilityInfo createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.g.f(parcel, "parcel");
            return new AbilityInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.createStringArray(), parcel.createStringArray(), parcel.readInt() != 0, parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final AbilityInfo[] newArray(int i10) {
            return new AbilityInfo[i10];
        }
    }

    public AbilityInfo() {
        this(null, null, null, null, null, null, false, 0, null, 511, null);
    }

    public static /* synthetic */ AbilityInfo copy$default(AbilityInfo abilityInfo, String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z, int i10, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = abilityInfo.f7209id;
        }
        if ((i11 & 2) != 0) {
            str2 = abilityInfo.name;
        }
        if ((i11 & 4) != 0) {
            str3 = abilityInfo.description;
        }
        if ((i11 & 8) != 0) {
            str4 = abilityInfo.version;
        }
        if ((i11 & 16) != 0) {
            strArr = abilityInfo.inputTypes;
        }
        if ((i11 & 32) != 0) {
            strArr2 = abilityInfo.outputTypes;
        }
        if ((i11 & 64) != 0) {
            z = abilityInfo.isStreamOutput;
        }
        if ((i11 & TraceIdKeys.MAX_LENGTH) != 0) {
            i10 = abilityInfo.minMemoryMb;
        }
        if ((i11 & 256) != 0) {
            str5 = abilityInfo.vendor;
        }
        int i12 = i10;
        String str6 = str5;
        String[] strArr3 = strArr2;
        boolean z3 = z;
        String[] strArr4 = strArr;
        String str7 = str3;
        return abilityInfo.copy(str, str2, str7, str4, strArr4, strArr3, z3, i12, str6);
    }

    public final String component1() {
        return this.f7209id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.description;
    }

    public final String component4() {
        return this.version;
    }

    public final String[] component5() {
        return this.inputTypes;
    }

    public final String[] component6() {
        return this.outputTypes;
    }

    public final boolean component7() {
        return this.isStreamOutput;
    }

    public final int component8() {
        return this.minMemoryMb;
    }

    public final String component9() {
        return this.vendor;
    }

    public final AbilityInfo copy(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z, int i10, String str5) {
        return new AbilityInfo(str, str2, str3, str4, strArr, strArr2, z, i10, str5);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!AbilityInfo.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        kotlin.jvm.internal.g.d(obj, "null cannot be cast to non-null type com.stepos.core.ability.AbilityInfo");
        AbilityInfo abilityInfo = (AbilityInfo) obj;
        if (!kotlin.jvm.internal.g.b(this.f7209id, abilityInfo.f7209id) || !kotlin.jvm.internal.g.b(this.name, abilityInfo.name) || !kotlin.jvm.internal.g.b(this.description, abilityInfo.description) || !kotlin.jvm.internal.g.b(this.version, abilityInfo.version)) {
            return false;
        }
        String[] strArr = this.inputTypes;
        if (strArr != null) {
            String[] strArr2 = abilityInfo.inputTypes;
            if (strArr2 == null || !Arrays.equals(strArr, strArr2)) {
                return false;
            }
        } else if (abilityInfo.inputTypes != null) {
            return false;
        }
        String[] strArr3 = this.outputTypes;
        if (strArr3 != null) {
            String[] strArr4 = abilityInfo.outputTypes;
            if (strArr4 == null || !Arrays.equals(strArr3, strArr4)) {
                return false;
            }
        } else if (abilityInfo.outputTypes != null) {
            return false;
        }
        return this.isStreamOutput == abilityInfo.isStreamOutput && this.minMemoryMb == abilityInfo.minMemoryMb && kotlin.jvm.internal.g.b(this.vendor, abilityInfo.vendor);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.f7209id;
    }

    public final String[] getInputTypes() {
        return this.inputTypes;
    }

    public final int getMinMemoryMb() {
        return this.minMemoryMb;
    }

    public final String getName() {
        return this.name;
    }

    public final String[] getOutputTypes() {
        return this.outputTypes;
    }

    public final String getVendor() {
        return this.vendor;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.f7209id;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.version;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String[] strArr = this.inputTypes;
        int iHashCode5 = (iHashCode4 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.outputTypes;
        int iF = (ai.onnxruntime.a.f((iHashCode5 + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31, 31, this.isStreamOutput) + this.minMemoryMb) * 31;
        String str5 = this.vendor;
        return iF + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isStreamOutput() {
        return this.isStreamOutput;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(String str) {
        this.f7209id = str;
    }

    public final void setInputTypes(String[] strArr) {
        this.inputTypes = strArr;
    }

    public final void setMinMemoryMb(int i10) {
        this.minMemoryMb = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOutputTypes(String[] strArr) {
        this.outputTypes = strArr;
    }

    public final void setStreamOutput(boolean z) {
        this.isStreamOutput = z;
    }

    public final void setVendor(String str) {
        this.vendor = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        String string;
        String str = this.f7209id;
        String str2 = this.name;
        String str3 = this.description;
        String str4 = this.version;
        String[] strArr = this.inputTypes;
        String string2 = null;
        if (strArr != null) {
            string = Arrays.toString(strArr);
            kotlin.jvm.internal.g.e(string, "toString(...)");
        } else {
            string = null;
        }
        String[] strArr2 = this.outputTypes;
        if (strArr2 != null) {
            string2 = Arrays.toString(strArr2);
            kotlin.jvm.internal.g.e(string2, "toString(...)");
        }
        boolean z = this.isStreamOutput;
        int i10 = this.minMemoryMb;
        String str5 = this.vendor;
        StringBuilder sbS = ai.onnxruntime.a.s("AbilityInfo(id='", str, "', name='", str2, "', description='");
        ai.onnxruntime.a.z(sbS, str3, "', version='", str4, "', inputTypes=");
        ai.onnxruntime.a.z(sbS, string, ", outputTypes=", string2, ", isStreamOutput=");
        sbS.append(z);
        sbS.append(", minMemoryMb=");
        sbS.append(i10);
        sbS.append(", vendor='");
        return ai.onnxruntime.a.o(sbS, str5, "')");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i10) {
        kotlin.jvm.internal.g.f(dest, "dest");
        dest.writeString(this.f7209id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.version);
        dest.writeStringArray(this.inputTypes);
        dest.writeStringArray(this.outputTypes);
        dest.writeInt(this.isStreamOutput ? 1 : 0);
        dest.writeInt(this.minMemoryMb);
        dest.writeString(this.vendor);
    }

    public AbilityInfo(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z, int i10, String str5) {
        this.f7209id = str;
        this.name = str2;
        this.description = str3;
        this.version = str4;
        this.inputTypes = strArr;
        this.outputTypes = strArr2;
        this.isStreamOutput = z;
        this.minMemoryMb = i10;
        this.vendor = str5;
    }

    public /* synthetic */ AbilityInfo(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z, int i10, String str5, int i11, kotlin.jvm.internal.e eVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, (i11 & 16) != 0 ? null : strArr, (i11 & 32) != 0 ? null : strArr2, (i11 & 64) != 0 ? false : z, (i11 & TraceIdKeys.MAX_LENGTH) != 0 ? 0 : i10, (i11 & 256) != 0 ? null : str5);
    }
}
