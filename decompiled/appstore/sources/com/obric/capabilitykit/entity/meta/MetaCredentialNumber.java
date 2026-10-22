package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "credentialNumber", "", "credentialType", "(Ljava/lang/String;Ljava/lang/String;)V", "getCredentialNumber", "()Ljava/lang/String;", "getCredentialType", "component1", "component2", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaCredentialNumber extends MetaValue {

    @NotNull
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;

    @NotNull
    private final String credentialNumber;

    @NotNull
    private final String credentialType;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaCredentialNumber;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaCredentialNumber> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaCredentialNumber createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new MetaCredentialNumber(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaCredentialNumber[] newArray(int r10) {
            return new MetaCredentialNumber[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaCredentialNumber createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaCredentialNumber[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaCredentialNumber(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10), EntityExtKt.f(r10));
        readMetaValueExtensionField$capabilitykitcommon_release(r10, 0, r10.readInt());
    }

    public static /* synthetic */ MetaCredentialNumber copy$default(MetaCredentialNumber r10, String r11, String r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.credentialNumber;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.credentialType;
    L9:
        return r10.copy(r11, r12);
    }

    @NotNull
    public final String component1() {
        return this.credentialNumber;
    }

    @NotNull
    public final String component2() {
        return this.credentialType;
    }

    @NotNull
    public final MetaCredentialNumber copy(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "credentialNumber");
        q.g(r11, "credentialType");
        return new MetaCredentialNumber(r10, r11);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MetaCredentialNumber) == true) goto L8;
        return false;
    L8:
        MetaCredentialNumber r11 = (MetaCredentialNumber) r10;
        if (q.b(this.credentialNumber, r11.credentialNumber) == true) goto L12;
        return false;
    L12:
        if (q.b(this.credentialType, r11.credentialType) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @NotNull
    public final String getCredentialNumber() {
        return this.credentialNumber;
    }

    @NotNull
    public final String getCredentialType() {
        return this.credentialType;
    }

    public int hashCode() {
        return (this.credentialNumber.hashCode() * 31) + this.credentialType.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    @NotNull
    public String toString() {
        return "MetaCredentialNumber(credentialNumber=" + this.credentialNumber + ", credentialType=" + this.credentialType + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.credentialNumber);
        r10.writeString(this.credentialType);
        r10.writeInt(0);
    }

    public MetaCredentialNumber(@NotNull String r10, @NotNull String r11) {
        q.g(r10, "credentialNumber");
        q.g(r11, "credentialType");
        super(MetaType.CREDENTIAL_NUMBER);
        this.credentialNumber = r10;
        this.credentialType = r11;
    }
}
