package com.zyql.agentfront.bean;

import B7.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import k7.C1627a;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u0000 &2\u00020\u0001:\u0001'B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0014J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0014J8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u0010\u0010\u001b\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0012J\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010!\u001a\u0004\b\"\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010!\u001a\u0004\b#\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010!\u001a\u0004\b$\u0010\u0014R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b%\u0010\u0014¨\u0006("}, d2 = {"Lcom/zyql/agentfront/bean/AbilityMetadata;", "Landroid/os/Parcelable;", "", "description", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "packageName", "params", AppAgent.CONSTRUCT, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "", "flags", "LC7/r;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/zyql/agentfront/bean/AbilityMetadata;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getDescription", "getMethod", "getPackageName", "getParams", "CREATOR", "k7/a", "bean_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class AbilityMetadata implements Parcelable {
    public static final C1627a CREATOR = new C1627a();
    private final String description;
    private final String method;
    private final String packageName;
    private final String params;

    public AbilityMetadata(String description, String method, String packageName, String params) {
        k.f(description, "description");
        k.f(method, "method");
        k.f(packageName, "packageName");
        k.f(params, "params");
        this.description = description;
        this.method = method;
        this.packageName = packageName;
        this.params = params;
    }

    public static /* synthetic */ AbilityMetadata copy$default(AbilityMetadata abilityMetadata, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = abilityMetadata.description;
        }
        if ((i & 2) != 0) {
            str2 = abilityMetadata.method;
        }
        if ((i & 4) != 0) {
            str3 = abilityMetadata.packageName;
        }
        if ((i & 8) != 0) {
            str4 = abilityMetadata.params;
        }
        return abilityMetadata.copy(str, str2, str3, str4);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMethod() {
        return this.method;
    }

    /* renamed from: component3, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    /* renamed from: component4, reason: from getter */
    public final String getParams() {
        return this.params;
    }

    public final AbilityMetadata copy(String description, String method, String packageName, String params) {
        k.f(description, "description");
        k.f(method, "method");
        k.f(packageName, "packageName");
        k.f(params, "params");
        return new AbilityMetadata(description, method, packageName, params);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AbilityMetadata)) {
            return false;
        }
        AbilityMetadata abilityMetadata = (AbilityMetadata) other;
        return k.b(this.description, abilityMetadata.description) && k.b(this.method, abilityMetadata.method) && k.b(this.packageName, abilityMetadata.packageName) && k.b(this.params, abilityMetadata.params);
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getMethod() {
        return this.method;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getParams() {
        return this.params;
    }

    public int hashCode() {
        return this.params.hashCode() + a.c(a.c(this.description.hashCode() * 31, 31, this.method), 31, this.packageName);
    }

    public String toString() {
        String str = this.description;
        String str2 = this.method;
        return androidx.appfunctions.metadata.a.p(a.w("AbilityMetadata(description=", str, ", method=", str2, ", packageName="), this.packageName, ", params=", this.params, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        k.f(parcel, "parcel");
        parcel.writeString(this.description);
        parcel.writeString(this.method);
        parcel.writeString(this.packageName);
        parcel.writeString(this.params);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbilityMetadata(Parcel parcel) {
        k.f(parcel, "parcel");
        String string = parcel.readString();
        string = string == null ? "" : string;
        String string2 = parcel.readString();
        string2 = string2 == null ? "" : string2;
        String string3 = parcel.readString();
        string3 = string3 == null ? "" : string3;
        String string4 = parcel.readString();
        this(string, string2, string3, string4 != null ? string4 : "");
    }
}
