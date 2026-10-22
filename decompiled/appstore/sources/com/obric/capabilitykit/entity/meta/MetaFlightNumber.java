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
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\n\u001a\u00020\u0006HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0011H\u0010¢\u0006\u0002\b\u0017J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0011H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001c"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaFlightNumber;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "flightNumber", "", "(Ljava/lang/String;)V", "getFlightNumber", "()Ljava/lang/String;", "component1", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaFlightNumber extends MetaValue {

    @NotNull
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;

    @NotNull
    private final String flightNumber;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaFlightNumber$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaFlightNumber;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaFlightNumber;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaFlightNumber> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaFlightNumber createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new MetaFlightNumber(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaFlightNumber[] newArray(int r10) {
            return new MetaFlightNumber[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaFlightNumber createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaFlightNumber[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaFlightNumber(@NotNull Parcel r10) {
        q.g(r10, "parcel");
        this(EntityExtKt.f(r10));
        readMetaValueExtensionField$capabilitykitcommon_release(r10, 0, r10.readInt());
    }

    public static /* synthetic */ MetaFlightNumber copy$default(MetaFlightNumber r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = r10.flightNumber;
    L6:
        return r10.copy(r11);
    }

    @NotNull
    public final String component1() {
        return this.flightNumber;
    }

    @NotNull
    public final MetaFlightNumber copy(@NotNull String r10) {
        q.g(r10, "flightNumber");
        return new MetaFlightNumber(r10);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MetaFlightNumber) == true) goto L9;
        return false;
    L9:
        if (q.b(this.flightNumber, ((MetaFlightNumber) r10).flightNumber) == true) goto L11;
        return false;
    L11:
        return true;
    }

    @NotNull
    public final String getFlightNumber() {
        return this.flightNumber;
    }

    public int hashCode() {
        return this.flightNumber.hashCode();
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    @NotNull
    public String toString() {
        return "MetaFlightNumber(flightNumber=" + this.flightNumber + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.flightNumber);
        r10.writeInt(0);
    }

    public MetaFlightNumber(@NotNull String r10) {
        q.g(r10, "flightNumber");
        super(MetaType.FLIGHT_NUMBER);
        this.flightNumber = r10;
    }
}
