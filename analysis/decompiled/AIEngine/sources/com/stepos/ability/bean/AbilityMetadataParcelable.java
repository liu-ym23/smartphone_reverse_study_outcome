package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.g;
import v1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class AbilityMetadataParcelable implements Parcelable {
    public static final a CREATOR = new a();
    private final String description;
    private final String inputSchema;
    private final String packageName;
    private final String toolName;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Parcelable.Creator<AbilityMetadataParcelable> {
        @Override // android.os.Parcelable.Creator
        public final AbilityMetadataParcelable createFromParcel(Parcel parcel) {
            g.f(parcel, "parcel");
            return new AbilityMetadataParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final AbilityMetadataParcelable[] newArray(int i10) {
            return new AbilityMetadataParcelable[i10];
        }
    }

    public AbilityMetadataParcelable(String toolName, String description, String packageName, String inputSchema) {
        g.f(toolName, "toolName");
        g.f(description, "description");
        g.f(packageName, "packageName");
        g.f(inputSchema, "inputSchema");
        this.toolName = toolName;
        this.description = description;
        this.packageName = packageName;
        this.inputSchema = inputSchema;
    }

    public static /* synthetic */ AbilityMetadataParcelable copy$default(AbilityMetadataParcelable abilityMetadataParcelable, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = abilityMetadataParcelable.toolName;
        }
        if ((i10 & 2) != 0) {
            str2 = abilityMetadataParcelable.description;
        }
        if ((i10 & 4) != 0) {
            str3 = abilityMetadataParcelable.packageName;
        }
        if ((i10 & 8) != 0) {
            str4 = abilityMetadataParcelable.inputSchema;
        }
        return abilityMetadataParcelable.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.toolName;
    }

    public final String component2() {
        return this.description;
    }

    public final String component3() {
        return this.packageName;
    }

    public final String component4() {
        return this.inputSchema;
    }

    public final AbilityMetadataParcelable copy(String toolName, String description, String packageName, String inputSchema) {
        g.f(toolName, "toolName");
        g.f(description, "description");
        g.f(packageName, "packageName");
        g.f(inputSchema, "inputSchema");
        return new AbilityMetadataParcelable(toolName, description, packageName, inputSchema);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbilityMetadataParcelable)) {
            return false;
        }
        AbilityMetadataParcelable abilityMetadataParcelable = (AbilityMetadataParcelable) obj;
        return g.b(this.toolName, abilityMetadataParcelable.toolName) && g.b(this.description, abilityMetadataParcelable.description) && g.b(this.packageName, abilityMetadataParcelable.packageName) && g.b(this.inputSchema, abilityMetadataParcelable.inputSchema);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getInputSchema() {
        return this.inputSchema;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getToolName() {
        return this.toolName;
    }

    public int hashCode() {
        return this.inputSchema.hashCode() + d.a(d.a(this.toolName.hashCode() * 31, 31, this.description), 31, this.packageName);
    }

    public String toString() {
        String str = this.toolName;
        String str2 = this.description;
        return com.stepos.core.ota.d.j(ai.onnxruntime.a.s("AbilityMetadataParcelable(toolName=", str, ", description=", str2, ", packageName="), this.packageName, ", inputSchema=", this.inputSchema, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        g.f(parcel, "parcel");
        parcel.writeString(this.toolName);
        parcel.writeString(this.description);
        parcel.writeString(this.packageName);
        parcel.writeString(this.inputSchema);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityMetadataParcelable(Parcel parcel) {
        g.f(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str = string3 != null ? string3 : "";
        String string4 = parcel.readString();
        this(string, string2, str, string4 == null ? "{}" : string4);
    }
}
