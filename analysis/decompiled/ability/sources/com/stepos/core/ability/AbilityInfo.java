package com.stepos.core.ability;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appfunctions.metadata.a;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\f¢\u0006\u0004\b\u001f\u0010\u0018J\u0012\u0010 \u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b \u0010\u0012J\u0012\u0010!\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u0012J\u0012\u0010\"\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\"\u0010\u0012J\u0012\u0010#\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b#\u0010\u0012J\u0018\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b&\u0010%J\u0010\u0010'\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b'\u0010(J\u0010\u0010)\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b)\u0010\u0018J\u0012\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b*\u0010\u0012J\u0084\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b+\u0010,R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010-\u001a\u0004\b.\u0010\u0012\"\u0004\b/\u00100R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010-\u001a\u0004\b1\u0010\u0012\"\u0004\b2\u00100R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010-\u001a\u0004\b3\u0010\u0012\"\u0004\b4\u00100R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010-\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u00100R*\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u00107\u001a\u0004\b8\u0010%\"\u0004\b9\u0010:R*\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00107\u001a\u0004\b;\u0010%\"\u0004\b<\u0010:R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010=\u001a\u0004\b\u000b\u0010(\"\u0004\b>\u0010?R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010@\u001a\u0004\bA\u0010\u0018\"\u0004\bB\u0010CR$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010-\u001a\u0004\bD\u0010\u0012\"\u0004\bE\u00100¨\u0006F"}, d2 = {"Lcom/stepos/core/ability/AbilityInfo;", "Landroid/os/Parcelable;", "", "id", HintConstants.AUTOFILL_HINT_NAME, "description", "version", "", "inputTypes", "outputTypes", "", "isStreamOutput", "", "minMemoryMb", "vendor", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;ZILjava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Landroid/os/Parcel;", "dest", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "component1", "component2", "component3", "component4", "component5", "()[Ljava/lang/String;", "component6", "component7", "()Z", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;ZILjava/lang/String;)Lcom/stepos/core/ability/AbilityInfo;", "Ljava/lang/String;", "getId", "setId", "(Ljava/lang/String;)V", "getName", "setName", "getDescription", "setDescription", "getVersion", "setVersion", "[Ljava/lang/String;", "getInputTypes", "setInputTypes", "([Ljava/lang/String;)V", "getOutputTypes", "setOutputTypes", "Z", "setStreamOutput", "(Z)V", "I", "getMinMemoryMb", "setMinMemoryMb", "(I)V", "getVendor", "setVendor", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityInfo implements Parcelable {
    public static final Parcelable.Creator<AbilityInfo> CREATOR = new g(6);
    private String description;
    private String id;
    private String[] inputTypes;
    private boolean isStreamOutput;
    private int minMemoryMb;
    private String name;
    private String[] outputTypes;
    private String vendor;
    private String version;

    public AbilityInfo() {
        this(null, null, null, null, null, null, false, 0, null, 511, null);
    }

    public static /* synthetic */ AbilityInfo copy$default(AbilityInfo abilityInfo, String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z10, int i, String str5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            str = abilityInfo.id;
        }
        if ((i6 & 2) != 0) {
            str2 = abilityInfo.name;
        }
        if ((i6 & 4) != 0) {
            str3 = abilityInfo.description;
        }
        if ((i6 & 8) != 0) {
            str4 = abilityInfo.version;
        }
        if ((i6 & 16) != 0) {
            strArr = abilityInfo.inputTypes;
        }
        if ((i6 & 32) != 0) {
            strArr2 = abilityInfo.outputTypes;
        }
        if ((i6 & 64) != 0) {
            z10 = abilityInfo.isStreamOutput;
        }
        if ((i6 & 128) != 0) {
            i = abilityInfo.minMemoryMb;
        }
        if ((i6 & 256) != 0) {
            str5 = abilityInfo.vendor;
        }
        int i10 = i;
        String str6 = str5;
        String[] strArr3 = strArr2;
        boolean z11 = z10;
        String[] strArr4 = strArr;
        String str7 = str3;
        return abilityInfo.copy(str, str2, str7, str4, strArr4, strArr3, z11, i10, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component5, reason: from getter */
    public final String[] getInputTypes() {
        return this.inputTypes;
    }

    /* renamed from: component6, reason: from getter */
    public final String[] getOutputTypes() {
        return this.outputTypes;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsStreamOutput() {
        return this.isStreamOutput;
    }

    /* renamed from: component8, reason: from getter */
    public final int getMinMemoryMb() {
        return this.minMemoryMb;
    }

    /* renamed from: component9, reason: from getter */
    public final String getVendor() {
        return this.vendor;
    }

    public final AbilityInfo copy(String id, String name, String description, String version, String[] inputTypes, String[] outputTypes, boolean isStreamOutput, int minMemoryMb, String vendor) {
        return new AbilityInfo(id, name, description, version, inputTypes, outputTypes, isStreamOutput, minMemoryMb, vendor);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!AbilityInfo.class.equals(other != null ? other.getClass() : null)) {
            return false;
        }
        k.d(other, "null cannot be cast to non-null type com.stepos.core.ability.AbilityInfo");
        AbilityInfo abilityInfo = (AbilityInfo) other;
        if (!k.b(this.id, abilityInfo.id) || !k.b(this.name, abilityInfo.name) || !k.b(this.description, abilityInfo.description) || !k.b(this.version, abilityInfo.version)) {
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
        return this.isStreamOutput == abilityInfo.isStreamOutput && this.minMemoryMb == abilityInfo.minMemoryMb && k.b(this.vendor, abilityInfo.vendor);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getId() {
        return this.id;
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
        String str = this.id;
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
        int iD = (a.d((iHashCode5 + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31, 31, this.isStreamOutput) + this.minMemoryMb) * 31;
        String str5 = this.vendor;
        return iD + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isStreamOutput() {
        return this.isStreamOutput;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setInputTypes(String[] strArr) {
        this.inputTypes = strArr;
    }

    public final void setMinMemoryMb(int i) {
        this.minMemoryMb = i;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setOutputTypes(String[] strArr) {
        this.outputTypes = strArr;
    }

    public final void setStreamOutput(boolean z10) {
        this.isStreamOutput = z10;
    }

    public final void setVendor(String str) {
        this.vendor = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        String string;
        String str = this.id;
        String str2 = this.name;
        String str3 = this.description;
        String str4 = this.version;
        String[] strArr = this.inputTypes;
        String string2 = null;
        if (strArr != null) {
            string = Arrays.toString(strArr);
            k.e(string, "toString(...)");
        } else {
            string = null;
        }
        String[] strArr2 = this.outputTypes;
        if (strArr2 != null) {
            string2 = Arrays.toString(strArr2);
            k.e(string2, "toString(...)");
        }
        boolean z10 = this.isStreamOutput;
        int i = this.minMemoryMb;
        String str5 = this.vendor;
        StringBuilder sbW = B7.a.w("AbilityInfo(id='", str, "', name='", str2, "', description='");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, "', version='", str4, "', inputTypes=");
        androidx.constraintlayout.core.dsl.a.A(sbW, string, ", outputTypes=", string2, ", isStreamOutput=");
        sbW.append(z10);
        sbW.append(", minMemoryMb=");
        sbW.append(i);
        sbW.append(", vendor='");
        return B7.a.q(sbW, str5, "')");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int flags) {
        k.f(dest, "dest");
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.version);
        dest.writeStringArray(this.inputTypes);
        dest.writeStringArray(this.outputTypes);
        dest.writeInt(this.isStreamOutput ? 1 : 0);
        dest.writeInt(this.minMemoryMb);
        dest.writeString(this.vendor);
    }

    public AbilityInfo(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z10, int i, String str5) {
        this.id = str;
        this.name = str2;
        this.description = str3;
        this.version = str4;
        this.inputTypes = strArr;
        this.outputTypes = strArr2;
        this.isStreamOutput = z10;
        this.minMemoryMb = i;
        this.vendor = str5;
    }

    public /* synthetic */ AbilityInfo(String str, String str2, String str3, String str4, String[] strArr, String[] strArr2, boolean z10, int i, String str5, int i6, e eVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? null : str2, (i6 & 4) != 0 ? null : str3, (i6 & 8) != 0 ? null : str4, (i6 & 16) != 0 ? null : strArr, (i6 & 32) != 0 ? null : strArr2, (i6 & 64) != 0 ? false : z10, (i6 & 128) != 0 ? 0 : i, (i6 & 256) != 0 ? null : str5);
    }
}
