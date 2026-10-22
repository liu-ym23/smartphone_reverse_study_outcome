package com.obric.capabilitykit.entity.meta;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedanceos.common.model.AppInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087\b\u0018\u0000 ;2\u00020\u0001:\u0001;B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0085\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010!\u001a\u00020\u0010HÆ\u0003J\t\u0010\"\u001a\u00020\u0010HÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0089\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J'\u00102\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u000201H\u0010¢\u0006\u0002\b7J\t\u00108\u001a\u00020\u0006HÖ\u0001J\u0018\u00109\u001a\u0002032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010:\u001a\u000201H\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0014¨\u0006<"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "country", "", "stateOrProvince", "administrativeArea", "locality", "subLocality", "thoroughfare", "subThoroughfare", "namedLocation", "fullAddress", "longitude", "", "latitude", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DD)V", "getAdministrativeArea", "()Ljava/lang/String;", "getCountry", "getFullAddress", "getLatitude", "()D", "getLocality", "getLongitude", "getNamedLocation", "getStateOrProvince", "getSubLocality", "getSubThoroughfare", "getThoroughfare", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "hashCode", "", "onReadMetaValueExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "onReadMetaValueExtensionField$capabilitykitcommon_release", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MetaLocation extends MetaValue {

    @NotNull
    public static final CREATOR CREATOR = null;
    public static final int VERSION = 0;

    @Nullable
    private final String administrativeArea;

    @Nullable
    private final String country;

    @Nullable
    private final String fullAddress;
    private final double latitude;

    @Nullable
    private final String locality;
    private final double longitude;

    @Nullable
    private final String namedLocation;

    @Nullable
    private final String stateOrProvince;

    @Nullable
    private final String subLocality;

    @Nullable
    private final String subThoroughfare;

    @Nullable
    private final String thoroughfare;

    @Keep
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001d\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/capabilitykit/entity/meta/MetaLocation$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "()V", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MetaLocation> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaLocation createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            return new MetaLocation(r10);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MetaLocation[] newArray(int r10) {
            return new MetaLocation[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaLocation createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MetaLocation[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MetaLocation() {
        String r10 = null;
        String r11 = null;
        String r12 = null;
        String r13 = null;
        String r14 = null;
        String r15 = null;
        String r16 = null;
        String r17 = null;
        String r18 = null;
        double r19 = 0.0d;
        double r110 = 0.0d;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r110, 2047, null);
    }

    public static /* synthetic */ MetaLocation copy$default(MetaLocation r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, double r25, double r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        String r10 = r15.country;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r11 = r15.stateOrProvince;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r12 = r15.administrativeArea;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r13 = r15.locality;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r14 = r15.subLocality;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r26 = r15.thoroughfare;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r28 = r15.subThoroughfare;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r31 = r15.namedLocation;
    L35:
        if ((r29 & 256) == 0) goto L37;
        String r110 = r15.fullAddress;
    L39:
        if ((r29 & 512) == 0) goto L41;
        double r111 = r15.longitude;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        double r112 = r15.latitude;
    L47:
        return r15.copy(r10, r11, r12, r13, r14, r26, r28, r31, r110, r111, r112);
    L45:
        r112 = r27;
        goto L47
    L41:
        r111 = r25;
        goto L43
    L37:
        r110 = r24;
        goto L39
    L33:
        r31 = r23;
        goto L35
    L29:
        r28 = r22;
        goto L31
    L25:
        r26 = r21;
        goto L27
    L21:
        r14 = r20;
        goto L23
    L17:
        r13 = r19;
        goto L19
    L13:
        r12 = r18;
        goto L15
    L9:
        r11 = r17;
        goto L11
    L5:
        r10 = r16;
        goto L7
    }

    @Nullable
    public final String component1() {
        return this.country;
    }

    public final double component10() {
        return this.longitude;
    }

    public final double component11() {
        return this.latitude;
    }

    @Nullable
    public final String component2() {
        return this.stateOrProvince;
    }

    @Nullable
    public final String component3() {
        return this.administrativeArea;
    }

    @Nullable
    public final String component4() {
        return this.locality;
    }

    @Nullable
    public final String component5() {
        return this.subLocality;
    }

    @Nullable
    public final String component6() {
        return this.thoroughfare;
    }

    @Nullable
    public final String component7() {
        return this.subThoroughfare;
    }

    @Nullable
    public final String component8() {
        return this.namedLocation;
    }

    @Nullable
    public final String component9() {
        return this.fullAddress;
    }

    @NotNull
    public final MetaLocation copy(@Nullable String r16, @Nullable String r17, @Nullable String r18, @Nullable String r19, @Nullable String r20, @Nullable String r21, @Nullable String r22, @Nullable String r23, @Nullable String r24, double r25, double r27) {
        return new MetaLocation(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r27);
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MetaLocation) == true) goto L8;
        return false;
    L8:
        MetaLocation r11 = (MetaLocation) r10;
        if (q.b(this.country, r11.country) == true) goto L12;
        return false;
    L12:
        if (q.b(this.stateOrProvince, r11.stateOrProvince) == true) goto L15;
        return false;
    L15:
        if (q.b(this.administrativeArea, r11.administrativeArea) == true) goto L18;
        return false;
    L18:
        if (q.b(this.locality, r11.locality) == true) goto L21;
        return false;
    L21:
        if (q.b(this.subLocality, r11.subLocality) == true) goto L24;
        return false;
    L24:
        if (q.b(this.thoroughfare, r11.thoroughfare) == true) goto L27;
        return false;
    L27:
        if (q.b(this.subThoroughfare, r11.subThoroughfare) == true) goto L30;
        return false;
    L30:
        if (q.b(this.namedLocation, r11.namedLocation) == true) goto L33;
        return false;
    L33:
        if (q.b(this.fullAddress, r11.fullAddress) == true) goto L36;
        return false;
    L36:
        if (Double.compare(this.longitude, r11.longitude) == 0) goto L39;
        return false;
    L39:
        if (Double.compare(this.latitude, r11.latitude) == 0) goto L41;
        return false;
    L41:
        return true;
    }

    @Nullable
    public final String getAdministrativeArea() {
        return this.administrativeArea;
    }

    @Nullable
    public final String getCountry() {
        return this.country;
    }

    @Nullable
    public final String getFullAddress() {
        return this.fullAddress;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final String getLocality() {
        return this.locality;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @Nullable
    public final String getNamedLocation() {
        return this.namedLocation;
    }

    @Nullable
    public final String getStateOrProvince() {
        return this.stateOrProvince;
    }

    @Nullable
    public final String getSubLocality() {
        return this.subLocality;
    }

    @Nullable
    public final String getSubThoroughfare() {
        return this.subThoroughfare;
    }

    @Nullable
    public final String getThoroughfare() {
        return this.thoroughfare;
    }

    public int hashCode() {
        String r10 = this.country;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        String r14 = this.stateOrProvince;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        String r17 = this.administrativeArea;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        String r20 = this.locality;
        if (r20 != null) goto L17;
        int r21 = 0;
    L18:
        int r22 = (r19 + r21) * 31;
        String r23 = this.subLocality;
        if (r23 != null) goto L21;
        int r24 = 0;
    L22:
        int r25 = (r22 + r24) * 31;
        String r26 = this.thoroughfare;
        if (r26 != null) goto L25;
        int r27 = 0;
    L26:
        int r28 = (r25 + r27) * 31;
        String r29 = this.subThoroughfare;
        if (r29 != null) goto L29;
        int r30 = 0;
    L30:
        int r31 = (r28 + r30) * 31;
        String r32 = this.namedLocation;
        if (r32 != null) goto L33;
        int r33 = 0;
    L34:
        int r34 = (r31 + r33) * 31;
        String r35 = this.fullAddress;
        if (r35 == null) goto L39;
        r11 = r35.hashCode();
    L39:
        return ((((r34 + r11) * 31) + Double.hashCode(this.longitude)) * 31) + Double.hashCode(this.latitude);
    L33:
        r33 = r32.hashCode();
        goto L34
    L29:
        r30 = r29.hashCode();
        goto L30
    L25:
        r27 = r26.hashCode();
        goto L26
    L21:
        r24 = r23.hashCode();
        goto L22
    L17:
        r21 = r20.hashCode();
        goto L18
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    public void onReadMetaValueExtensionField$capabilitykitcommon_release(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue
    @NotNull
    public String toString() {
        return "MetaLocation(country=" + this.country + ", stateOrProvince=" + this.stateOrProvince + ", administrativeArea=" + this.administrativeArea + ", locality=" + this.locality + ", subLocality=" + this.subLocality + ", thoroughfare=" + this.thoroughfare + ", subThoroughfare=" + this.subThoroughfare + ", namedLocation=" + this.namedLocation + ", fullAddress=" + this.fullAddress + ", longitude=" + this.longitude + ", latitude=" + this.latitude + ')';
    }

    @Override // com.obric.capabilitykit.entity.meta.MetaValue, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        r10.writeString(this.country);
        r10.writeString(this.stateOrProvince);
        r10.writeString(this.administrativeArea);
        r10.writeString(this.locality);
        r10.writeString(this.subLocality);
        r10.writeString(this.thoroughfare);
        r10.writeString(this.subThoroughfare);
        r10.writeString(this.namedLocation);
        r10.writeString(this.fullAddress);
        r10.writeDouble(this.longitude);
        r10.writeDouble(this.latitude);
        r10.writeInt(0);
    }

    public MetaLocation(@NotNull Parcel r17) {
        q.g(r17, "parcel");
        this(r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readString(), r17.readDouble(), r17.readDouble());
        readMetaValueExtensionField$capabilitykitcommon_release(r17, 0, r17.readInt());
    }

    public MetaLocation(@Nullable String r10, @Nullable String r11, @Nullable String r12, @Nullable String r13, @Nullable String r14, @Nullable String r15, @Nullable String r16, @Nullable String r17, @Nullable String r18, double r19, double r110) {
        super(MetaType.LOCATION);
        this.country = r10;
        this.stateOrProvince = r11;
        this.administrativeArea = r12;
        this.locality = r13;
        this.subLocality = r14;
        this.thoroughfare = r15;
        this.subThoroughfare = r16;
        this.namedLocation = r17;
        this.fullAddress = r18;
        this.longitude = r19;
        this.latitude = r110;
    }

    public /* synthetic */ MetaLocation(String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, double r25, double r27, int r29, DefaultConstructorMarker r30) {
        String r10 = null;
        if ((r29 & 1) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r29 & 8) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r15 = null;
    L23:
        if ((r29 & 32) == 0) goto L25;
        String r26 = null;
    L27:
        if ((r29 & 64) == 0) goto L29;
        String r28 = null;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r31 = null;
    L35:
        if ((r29 & 256) != 0) goto L38;
        r10 = r24;
    L38:
        double r110 = 0.0d;
        if ((r29 & 512) == 0) goto L41;
        double r111 = 0.0d;
    L43:
        if ((r29 & 1024) != 0) goto L46;
        r110 = r27;
    L46:
        this(r11, r12, r13, r14, r15, r26, r28, r31, r10, r111, r110);
        return;
    L41:
        r111 = r25;
        goto L43
    L33:
        r31 = r23;
        goto L35
    L29:
        r28 = r22;
        goto L31
    L25:
        r26 = r21;
        goto L27
    L21:
        r15 = r20;
        goto L23
    L17:
        r14 = r19;
        goto L19
    L13:
        r13 = r18;
        goto L15
    L9:
        r12 = r17;
        goto L11
    L5:
        r11 = r16;
        goto L7
    }
}
