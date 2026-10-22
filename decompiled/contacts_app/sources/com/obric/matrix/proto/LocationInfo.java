package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.obric.matrix.platform.sdk.ones.account.AccountInfoBundleKey;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes3.dex */
public final class LocationInfo extends Message<LocationInfo, Builder> {
    public static final ProtoAdapter<LocationInfo> ADAPTER = null;
    public static final String DEFAULT_ADDRESSLINE = "";
    public static final String DEFAULT_ADMINISTRATIVEAREA = "";
    public static final String DEFAULT_CITY = "";
    public static final String DEFAULT_COUNTRY = "";
    public static final String DEFAULT_COUNTRYCODE = "";
    public static final String DEFAULT_DISTRICT = "";
    public static final Double DEFAULT_LATITUDE = null;
    public static final String DEFAULT_LOCALITY = "";
    public static final Double DEFAULT_LONGITUDE = null;
    public static final String DEFAULT_STREET = "";
    public static final String DEFAULT_SUBADMINISTRATIVEAREA = "";
    public static final String DEFAULT_SUBLOCALITY = "";
    public static final String DEFAULT_TOWN = "";
    private static final long serialVersionUID = 0;

    @SerializedName("addressLine")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 13)
    public final String addressLine;

    @SerializedName("administrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 5)
    public final String administrativeArea;

    @SerializedName("city")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 6)
    public final String city;

    @SerializedName("country")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 3)
    public final String country;

    @SerializedName(AccountInfoBundleKey.COUNTRY_CODE)
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 4)
    public final String countryCode;

    @SerializedName("district")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 7)
    public final String district;

    @SerializedName("latitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 2)
    public final Double latitude;

    @SerializedName("locality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 11)
    public final String locality;

    @SerializedName("longitude")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#DOUBLE", tag = 1)
    public final Double longitude;

    @SerializedName("street")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 9)
    public final String street;

    @SerializedName("subAdministrativeArea")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 10)
    public final String subAdministrativeArea;

    @SerializedName("subLocality")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 12)
    public final String subLocality;

    @SerializedName("town")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#STRING", tag = 8)
    public final String town;

    public static final class Builder extends Message.Builder<LocationInfo, Builder> {
        public String addressLine;
        public String administrativeArea;
        public String city;
        public String country;
        public String countryCode;
        public String district;
        public Double latitude;
        public String locality;
        public Double longitude;
        public String street;
        public String subAdministrativeArea;
        public String subLocality;
        public String town;

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder() {
            Double r0 = Double.valueOf(0.0d);
            this.longitude = r0;
            this.latitude = r0;
            this.country = "";
            this.countryCode = "";
            this.administrativeArea = "";
            this.city = "";
            this.district = "";
            this.town = "";
            this.street = "";
            this.subAdministrativeArea = "";
            this.locality = "";
            this.subLocality = "";
            this.addressLine = "";
        }

        public Builder longitude(Double r1) {
            this.longitude = r1;
            return this;
        }

        public Builder latitude(Double r1) {
            this.latitude = r1;
            return this;
        }

        public Builder country(String r1) {
            this.country = r1;
            return this;
        }

        public Builder countryCode(String r1) {
            this.countryCode = r1;
            return this;
        }

        public Builder administrativeArea(String r1) {
            this.administrativeArea = r1;
            return this;
        }

        public Builder city(String r1) {
            this.city = r1;
            return this;
        }

        public Builder district(String r1) {
            this.district = r1;
            return this;
        }

        public Builder town(String r1) {
            this.town = r1;
            return this;
        }

        public Builder street(String r1) {
            this.street = r1;
            return this;
        }

        public Builder subAdministrativeArea(String r1) {
            this.subAdministrativeArea = r1;
            return this;
        }

        public Builder locality(String r1) {
            this.locality = r1;
            return this;
        }

        public Builder subLocality(String r1) {
            this.subLocality = r1;
            return this;
        }

        public Builder addressLine(String r1) {
            this.addressLine = r1;
            return this;
        }

        @Override // com.squareup.wire.Message.Builder
        public LocationInfo build() {
            return new LocationInfo(this.longitude, this.latitude, this.country, this.countryCode, this.administrativeArea, this.city, this.district, this.town, this.street, this.subAdministrativeArea, this.locality, this.subLocality, this.addressLine, super.buildUnknownFields());
        }
    }

    private static final class ProtoAdapter_LocationInfo extends ProtoAdapter<LocationInfo> {
        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo decode(ProtoReader r1) throws IOException {
            return decode(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r1, LocationInfo r2) throws IOException {
            encode2(r1, r2);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(LocationInfo r1) {
            return encodedSize2(r1);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ LocationInfo redact(LocationInfo r1) {
            return redact2(r1);
        }

        public ProtoAdapter_LocationInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, LocationInfo.class);
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(LocationInfo r4) {
            return ((((((((((((ProtoAdapter.DOUBLE.encodedSizeWithTag(1, r4.longitude) + ProtoAdapter.DOUBLE.encodedSizeWithTag(2, r4.latitude)) + ProtoAdapter.STRING.encodedSizeWithTag(3, r4.country)) + ProtoAdapter.STRING.encodedSizeWithTag(4, r4.countryCode)) + ProtoAdapter.STRING.encodedSizeWithTag(5, r4.administrativeArea)) + ProtoAdapter.STRING.encodedSizeWithTag(6, r4.city)) + ProtoAdapter.STRING.encodedSizeWithTag(7, r4.district)) + ProtoAdapter.STRING.encodedSizeWithTag(8, r4.town)) + ProtoAdapter.STRING.encodedSizeWithTag(9, r4.street)) + ProtoAdapter.STRING.encodedSizeWithTag(10, r4.subAdministrativeArea)) + ProtoAdapter.STRING.encodedSizeWithTag(11, r4.locality)) + ProtoAdapter.STRING.encodedSizeWithTag(12, r4.subLocality)) + ProtoAdapter.STRING.encodedSizeWithTag(13, r4.addressLine)) + r4.unknownFields().size();
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r3, LocationInfo r4) throws IOException {
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 1, r4.longitude);
            ProtoAdapter.DOUBLE.encodeWithTag(r3, 2, r4.latitude);
            ProtoAdapter.STRING.encodeWithTag(r3, 3, r4.country);
            ProtoAdapter.STRING.encodeWithTag(r3, 4, r4.countryCode);
            ProtoAdapter.STRING.encodeWithTag(r3, 5, r4.administrativeArea);
            ProtoAdapter.STRING.encodeWithTag(r3, 6, r4.city);
            ProtoAdapter.STRING.encodeWithTag(r3, 7, r4.district);
            ProtoAdapter.STRING.encodeWithTag(r3, 8, r4.town);
            ProtoAdapter.STRING.encodeWithTag(r3, 9, r4.street);
            ProtoAdapter.STRING.encodeWithTag(r3, 10, r4.subAdministrativeArea);
            ProtoAdapter.STRING.encodeWithTag(r3, 11, r4.locality);
            ProtoAdapter.STRING.encodeWithTag(r3, 12, r4.subLocality);
            ProtoAdapter.STRING.encodeWithTag(r3, 13, r4.addressLine);
            r3.writeBytes(r4.unknownFields());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public LocationInfo decode(ProtoReader r6) throws IOException {
            Builder r5 = new Builder();
            long r0 = r6.beginMessage();
        L3:
            int r2 = r6.nextTag();
            if (r2 == (-1)) goto L20;
            switch(r2) {
                case 1: goto L19;
                case 2: goto L18;
                case 3: goto L17;
                case 4: goto L16;
                case 5: goto L15;
                case 6: goto L14;
                case 7: goto L13;
                case 8: goto L12;
                case 9: goto L11;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L7:
            r5.addressLine(ProtoAdapter.STRING.decode(r6));
            goto L3
        L8:
            r5.subLocality(ProtoAdapter.STRING.decode(r6));
            goto L3
        L9:
            r5.locality(ProtoAdapter.STRING.decode(r6));
            goto L3
        L10:
            r5.subAdministrativeArea(ProtoAdapter.STRING.decode(r6));
            goto L3
        L11:
            r5.street(ProtoAdapter.STRING.decode(r6));
            goto L3
        L12:
            r5.town(ProtoAdapter.STRING.decode(r6));
            goto L3
        L13:
            r5.district(ProtoAdapter.STRING.decode(r6));
            goto L3
        L14:
            r5.city(ProtoAdapter.STRING.decode(r6));
            goto L3
        L15:
            r5.administrativeArea(ProtoAdapter.STRING.decode(r6));
            goto L3
        L16:
            r5.countryCode(ProtoAdapter.STRING.decode(r6));
            goto L3
        L17:
            r5.country(ProtoAdapter.STRING.decode(r6));
            goto L3
        L18:
            r5.latitude(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L19:
            r5.longitude(ProtoAdapter.DOUBLE.decode(r6));
            goto L3
        L6:
            FieldEncoding r3 = r6.peekFieldEncoding();
            r5.addUnknownField(r2, r3, r3.rawProtoAdapter().decode(r6));
            goto L3
        L20:
            r6.endMessage(r0);
            return r5.build();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public LocationInfo redact2(LocationInfo r1) {
            Builder r0 = r1.newBuilder();
            r0.clearUnknownFields();
            return r0.build();
        }
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    static {
        ADAPTER = new ProtoAdapter_LocationInfo();
        Double r0 = Double.valueOf(0.0d);
        DEFAULT_LONGITUDE = r0;
        DEFAULT_LATITUDE = r0;
    }

    public LocationInfo(Double r16, Double r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28) {
        this(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, ByteString.EMPTY);
    }

    public LocationInfo(Double r2, Double r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14, ByteString r15) {
        super(ADAPTER, r15);
        this.longitude = r2;
        this.latitude = r3;
        this.country = r4;
        this.countryCode = r5;
        this.administrativeArea = r6;
        this.city = r7;
        this.district = r8;
        this.town = r9;
        this.street = r10;
        this.subAdministrativeArea = r11;
        this.locality = r12;
        this.subLocality = r13;
        this.addressLine = r14;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r0 = new Builder();
        r0.longitude = this.longitude;
        r0.latitude = this.latitude;
        r0.country = this.country;
        r0.countryCode = this.countryCode;
        r0.administrativeArea = this.administrativeArea;
        r0.city = this.city;
        r0.district = this.district;
        r0.town = this.town;
        r0.street = this.street;
        r0.subAdministrativeArea = this.subAdministrativeArea;
        r0.locality = this.locality;
        r0.subLocality = this.subLocality;
        r0.addressLine = this.addressLine;
        r0.addUnknownFields(unknownFields());
        return r0;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof LocationInfo) == true) goto L8;
        return false;
    L8:
        LocationInfo r6 = (LocationInfo) r5;
        if (unknownFields().equals(r6.unknownFields()) == false) goto L38;
        if (Internal.equals(this.longitude, r6.longitude) == false) goto L38;
        if (Internal.equals(this.latitude, r6.latitude) == false) goto L38;
        if (Internal.equals(this.country, r6.country) == false) goto L38;
        if (Internal.equals(this.countryCode, r6.countryCode) == false) goto L38;
        if (Internal.equals(this.administrativeArea, r6.administrativeArea) == false) goto L38;
        if (Internal.equals(this.city, r6.city) == false) goto L38;
        if (Internal.equals(this.district, r6.district) == false) goto L38;
        if (Internal.equals(this.town, r6.town) == false) goto L38;
        if (Internal.equals(this.street, r6.street) == false) goto L38;
        if (Internal.equals(this.subAdministrativeArea, r6.subAdministrativeArea) == false) goto L38;
        if (Internal.equals(this.locality, r6.locality) == false) goto L38;
        if (Internal.equals(this.subLocality, r6.subLocality) == false) goto L38;
        if (Internal.equals(this.addressLine, r6.addressLine) == false) goto L38;
        return true;
    L38:
        return false;
    }

    public int hashCode() {
        int r0 = this.hashCode;
        if (r0 != 0) goto L57;
        int r1 = unknownFields().hashCode() * 37;
        Double r2 = this.longitude;
        int r3 = 0;
        if (r2 == null) goto L7;
        int r4 = r2.hashCode();
    L8:
        int r5 = (r1 + r4) * 37;
        Double r6 = this.latitude;
        if (r6 == null) goto L11;
        int r7 = r6.hashCode();
    L12:
        int r8 = (r5 + r7) * 37;
        String r9 = this.country;
        if (r9 == null) goto L15;
        int r10 = r9.hashCode();
    L16:
        int r11 = (r8 + r10) * 37;
        String r12 = this.countryCode;
        if (r12 == null) goto L19;
        int r13 = r12.hashCode();
    L20:
        int r14 = (r11 + r13) * 37;
        String r15 = this.administrativeArea;
        if (r15 == null) goto L23;
        int r16 = r15.hashCode();
    L24:
        int r17 = (r14 + r16) * 37;
        String r18 = this.city;
        if (r18 == null) goto L27;
        int r19 = r18.hashCode();
    L28:
        int r20 = (r17 + r19) * 37;
        String r21 = this.district;
        if (r21 == null) goto L31;
        int r22 = r21.hashCode();
    L32:
        int r23 = (r20 + r22) * 37;
        String r24 = this.town;
        if (r24 == null) goto L35;
        int r25 = r24.hashCode();
    L36:
        int r26 = (r23 + r25) * 37;
        String r27 = this.street;
        if (r27 == null) goto L39;
        int r28 = r27.hashCode();
    L40:
        int r29 = (r26 + r28) * 37;
        String r30 = this.subAdministrativeArea;
        if (r30 == null) goto L43;
        int r31 = r30.hashCode();
    L44:
        int r32 = (r29 + r31) * 37;
        String r33 = this.locality;
        if (r33 == null) goto L47;
        int r34 = r33.hashCode();
    L48:
        int r35 = (r32 + r34) * 37;
        String r36 = this.subLocality;
        if (r36 == null) goto L51;
        int r37 = r36.hashCode();
    L52:
        int r38 = (r35 + r37) * 37;
        String r39 = this.addressLine;
        if (r39 == null) goto L55;
        r3 = r39.hashCode();
    L55:
        int r40 = r38 + r3;
        this.hashCode = r40;
        return r40;
    L51:
        r37 = 0;
        goto L52
    L47:
        r34 = 0;
        goto L48
    L43:
        r31 = 0;
        goto L44
    L39:
        r28 = 0;
        goto L40
    L35:
        r25 = 0;
        goto L36
    L31:
        r22 = 0;
        goto L32
    L27:
        r19 = 0;
        goto L28
    L23:
        r16 = 0;
        goto L24
    L19:
        r13 = 0;
        goto L20
    L15:
        r10 = 0;
        goto L16
    L11:
        r7 = 0;
        goto L12
    L7:
        r4 = 0;
        goto L8
    L57:
        return r0;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r0 = new StringBuilder();
        if (this.longitude == null) goto L6;
        r0.append(", longitude=").append(this.longitude);
    L6:
        if (this.latitude == null) goto L9;
        r0.append(", latitude=").append(this.latitude);
    L9:
        if (this.country == null) goto L12;
        r0.append(", country=").append(this.country);
    L12:
        if (this.countryCode == null) goto L15;
        r0.append(", countryCode=").append(this.countryCode);
    L15:
        if (this.administrativeArea == null) goto L18;
        r0.append(", administrativeArea=").append(this.administrativeArea);
    L18:
        if (this.city == null) goto L21;
        r0.append(", city=").append(this.city);
    L21:
        if (this.district == null) goto L24;
        r0.append(", district=").append(this.district);
    L24:
        if (this.town == null) goto L27;
        r0.append(", town=").append(this.town);
    L27:
        if (this.street == null) goto L30;
        r0.append(", street=").append(this.street);
    L30:
        if (this.subAdministrativeArea == null) goto L33;
        r0.append(", subAdministrativeArea=").append(this.subAdministrativeArea);
    L33:
        if (this.locality == null) goto L36;
        r0.append(", locality=").append(this.locality);
    L36:
        if (this.subLocality == null) goto L39;
        r0.append(", subLocality=").append(this.subLocality);
    L39:
        if (this.addressLine == null) goto L42;
        r0.append(", addressLine=").append(this.addressLine);
    L42:
        return r0.replace(0, 2, "LocationInfo{").append('}').toString();
    }
}
