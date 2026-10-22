package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.EntityExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\t\u0010\f\u001a\u00020\u0006HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J'\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0014H\u0010¢\u0006\u0002\b\u001aJ\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0014H\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "instantMessagingType", "", "instantMessagingAccount", "(Ljava/lang/String;Ljava/lang/String;)V", "getInstantMessagingAccount", "()Ljava/lang/String;", "getInstantMessagingType", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaInstantMessaging extends MetaValue {
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;
    private final String instantMessagingAccount;
    private final String instantMessagingType;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "()V", VCardConstants.PROPERTY_VERSION, "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/meta/MetaInstantMessaging;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaInstantMessaging> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaInstantMessaging createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            return new MetaInstantMessaging(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaInstantMessaging createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MetaInstantMessaging[] newArray(int r1) {
            return new MetaInstantMessaging[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaInstantMessaging[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaInstantMessaging(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        this(EntityExtKt.readStringOrEmpty(r3), EntityExtKt.readStringOrEmpty(r3));
        readMetaValueExtensionField$capabilitykitcommon_release(r3, 0, r3.readInt());
    }

    public MetaInstantMessaging(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "instantMessagingType");
        Intrinsics.checkNotNullParameter(r3, "instantMessagingAccount");
        super(MetaType.INSTANT_MESSAGING);
        this.instantMessagingType = r2;
        this.instantMessagingAccount = r3;
    }

    public static /* synthetic */ MetaInstantMessaging copy$default(MetaInstantMessaging r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.instantMessagingType;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.instantMessagingAccount;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.instantMessagingType;
    }

    public final String component2() {
        return this.instantMessagingAccount;
    }

    public final MetaInstantMessaging copy(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "instantMessagingType");
        Intrinsics.checkNotNullParameter(r2, "instantMessagingAccount");
        return new MetaInstantMessaging(r1, r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MetaInstantMessaging) == true) goto L8;
        return false;
    L8:
        MetaInstantMessaging r6 = (MetaInstantMessaging) r5;
        if (Intrinsics.areEqual(this.instantMessagingType, r6.instantMessagingType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.instantMessagingAccount, r6.instantMessagingAccount) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getInstantMessagingAccount() {
        return this.instantMessagingAccount;
    }

    public final String getInstantMessagingType() {
        return this.instantMessagingType;
    }

    public int hashCode() {
        return (this.instantMessagingType.hashCode() * 31) + this.instantMessagingAccount.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public String toString() {
        return "MetaInstantMessaging(instantMessagingType=" + this.instantMessagingType + ", instantMessagingAccount=" + this.instantMessagingAccount + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(this.instantMessagingType);
        r1.writeString(this.instantMessagingAccount);
        r1.writeInt(0);
    }
}
