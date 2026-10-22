package com.zyql.ability.service.model;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import i7.c;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u00010B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\n\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0017J\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0017JV\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0017J\u0010\u0010!\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b!\u0010\u0015J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b+\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b,\u0010\u0017R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b-\u0010\u0017R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b.\u0010\u0017¨\u00061"}, d2 = {"Lcom/zyql/ability/service/model/AbilityMetadataParcelable;", "Landroid/os/Parcelable;", "", HintConstants.AUTOFILL_HINT_NAME, "description", "icon", "version", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "packageName", "pkgSign", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/ability/service/model/AbilityMetadataParcelable;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "getDescription", "getIcon", "getVersion", "getMethod", "getPackageName", "getPkgSign", "CREATOR", "i7/c", "aidl_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityMetadataParcelable implements Parcelable {
    public static final c CREATOR = new c();
    private final String description;
    private final String icon;
    private final String method;
    private final String name;
    private final String packageName;
    private final String pkgSign;
    private final String version;

    public AbilityMetadataParcelable(String name, String description, String icon, String version, String method, String packageName, String pkgSign) {
        k.f(name, "name");
        k.f(description, "description");
        k.f(icon, "icon");
        k.f(version, "version");
        k.f(method, "method");
        k.f(packageName, "packageName");
        k.f(pkgSign, "pkgSign");
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.version = version;
        this.method = method;
        this.packageName = packageName;
        this.pkgSign = pkgSign;
    }

    public static /* synthetic */ AbilityMetadataParcelable copy$default(AbilityMetadataParcelable abilityMetadataParcelable, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = abilityMetadataParcelable.name;
        }
        if ((i & 2) != 0) {
            str2 = abilityMetadataParcelable.description;
        }
        if ((i & 4) != 0) {
            str3 = abilityMetadataParcelable.icon;
        }
        if ((i & 8) != 0) {
            str4 = abilityMetadataParcelable.version;
        }
        if ((i & 16) != 0) {
            str5 = abilityMetadataParcelable.method;
        }
        if ((i & 32) != 0) {
            str6 = abilityMetadataParcelable.packageName;
        }
        if ((i & 64) != 0) {
            str7 = abilityMetadataParcelable.pkgSign;
        }
        String str8 = str6;
        String str9 = str7;
        String str10 = str5;
        String str11 = str3;
        return abilityMetadataParcelable.copy(str, str2, str11, str4, str10, str8, str9);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component3, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component5, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPkgSign() {
        return this.pkgSign;
    }

    public final AbilityMetadataParcelable copy(String name, String description, String icon, String version, String method, String packageName, String pkgSign) {
        k.f(name, "name");
        k.f(description, "description");
        k.f(icon, "icon");
        k.f(version, "version");
        k.f(method, "method");
        k.f(packageName, "packageName");
        k.f(pkgSign, "pkgSign");
        return new AbilityMetadataParcelable(name, description, icon, version, method, packageName, pkgSign);
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
        return k.b(this.name, abilityMetadataParcelable.name) && k.b(this.description, abilityMetadataParcelable.description) && k.b(this.icon, abilityMetadataParcelable.icon) && k.b(this.version, abilityMetadataParcelable.version) && k.b(this.method, abilityMetadataParcelable.method) && k.b(this.packageName, abilityMetadataParcelable.packageName) && k.b(this.pkgSign, abilityMetadataParcelable.pkgSign);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getPkgSign() {
        return this.pkgSign;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.pkgSign.hashCode() + a.c(a.c(a.c(a.c(a.c(this.name.hashCode() * 31, 31, this.description), 31, this.icon), 31, this.version), 31, this.method), 31, this.packageName);
    }

    public String toString() {
        String str = this.name;
        String str2 = this.description;
        String str3 = this.icon;
        String str4 = this.version;
        String str5 = this.method;
        String str6 = this.packageName;
        String str7 = this.pkgSign;
        StringBuilder sbW = a.w("AbilityMetadataParcelable(name=", str, ", description=", str2, ", icon=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str3, ", version=", str4, ", method=");
        androidx.constraintlayout.core.dsl.a.A(sbW, str5, ", packageName=", str6, ", pkgSign=");
        return a.q(sbW, str7, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeString(this.icon);
        parcel.writeString(this.version);
        parcel.writeString(this.method);
        parcel.writeString(this.packageName);
        parcel.writeString(this.pkgSign);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityMetadataParcelable(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        String str = string == null ? "" : string;
        String string2 = parcel.readString();
        String str2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        String str3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        String str4 = string4 == null ? "" : string4;
        String string5 = parcel.readString();
        String str5 = string5 == null ? "" : string5;
        String string6 = parcel.readString();
        String str6 = string6 == null ? "" : string6;
        String string7 = parcel.readString();
        this(str, str2, str3, str4, str5, str6, string7 == null ? "" : string7);
    }
}
