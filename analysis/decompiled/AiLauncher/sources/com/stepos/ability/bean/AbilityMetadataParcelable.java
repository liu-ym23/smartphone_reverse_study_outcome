package com.stepos.ability.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b$\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0014¨\u0006("}, d2 = {"Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "Landroid/os/Parcelable;", "", "toolName", "description", "packageName", "inputSchema", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", ChatTracker.CLICK_COPY, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToolName", "getDescription", "getPackageName", "getInputSchema", "CREATOR", Const.INTENT_KEY_APIKEY, "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class AbilityMetadataParcelable implements Parcelable {

    /* renamed from: CREATOR, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String description;
    private final String inputSchema;
    private final String packageName;
    private final String toolName;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/ability/bean/AbilityMetadataParcelable$a;", "Landroid/os/Parcelable$Creator;", "Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "<init>", "()V", "Landroid/os/Parcel;", "parcel", Const.INTENT_KEY_APIKEY, "(Landroid/os/Parcel;)Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "", ContentDisposition.Parameters.Size, "", Const.INTENT_KEY_PKGNAME, "(I)[Lcom/stepos/ability/bean/AbilityMetadataParcelable;", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ability.bean.AbilityMetadataParcelable$a, reason: from kotlin metadata */
    public static final class Companion implements Parcelable.Creator<AbilityMetadataParcelable> {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbilityMetadataParcelable createFromParcel(Parcel parcel) {
            p.i(parcel, "parcel");
            return new AbilityMetadataParcelable(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AbilityMetadataParcelable[] newArray(int size) {
            return new AbilityMetadataParcelable[size];
        }

        public Companion() {
        }
    }

    public AbilityMetadataParcelable(String toolName, String description, String packageName, String inputSchema) {
        p.i(toolName, "toolName");
        p.i(description, "description");
        p.i(packageName, "packageName");
        p.i(inputSchema, "inputSchema");
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

    /* renamed from: component1, reason: from getter */
    public final String getToolName() {
        return this.toolName;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getInputSchema() {
        return this.inputSchema;
    }

    public final AbilityMetadataParcelable copy(String toolName, String description, String packageName, String inputSchema) {
        p.i(toolName, "toolName");
        p.i(description, "description");
        p.i(packageName, "packageName");
        p.i(inputSchema, "inputSchema");
        return new AbilityMetadataParcelable(toolName, description, packageName, inputSchema);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityMetadataParcelable)) {
            return false;
        }
        AbilityMetadataParcelable abilityMetadataParcelable = (AbilityMetadataParcelable) other;
        return p.d(this.toolName, abilityMetadataParcelable.toolName) && p.d(this.description, abilityMetadataParcelable.description) && p.d(this.packageName, abilityMetadataParcelable.packageName) && p.d(this.inputSchema, abilityMetadataParcelable.inputSchema);
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
        return (((((this.toolName.hashCode() * 31) + this.description.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.inputSchema.hashCode();
    }

    public String toString() {
        return "AbilityMetadataParcelable(toolName=" + this.toolName + ", description=" + this.description + ", packageName=" + this.packageName + ", inputSchema=" + this.inputSchema + ")";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        p.i(parcel, "parcel");
        parcel.writeString(this.toolName);
        parcel.writeString(this.description);
        parcel.writeString(this.packageName);
        parcel.writeString(this.inputSchema);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityMetadataParcelable(Parcel parcel) {
        p.i(parcel, "parcel");
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
