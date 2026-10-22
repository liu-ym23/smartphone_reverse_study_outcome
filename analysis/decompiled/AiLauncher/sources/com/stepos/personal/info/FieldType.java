package com.stepos.personal.info;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class FieldType {
    public static final int FIELD_AAID = 4;
    public static final int FIELD_ADVERTISING_ID = 18;
    public static final int FIELD_ANDROID_ID = 17;
    public static final int FIELD_ENCRYPT_IMEI = 19;
    public static final int FIELD_ENCRYPT_SN = 20;
    public static final int FIELD_IMEI = 10;
    public static final int FIELD_IMSI1 = 7;
    public static final int FIELD_IMSI2 = 8;
    public static final int FIELD_IS_ROOT = 21;
    public static final int FIELD_LOCATION_LATITUDE = 12;
    public static final int FIELD_LOCATION_LONGITUDE = 11;
    public static final int FIELD_LOCATION_TIME = 13;
    public static final int FIELD_MAC_ADDRESS = 5;
    public static final int FIELD_OAID = 2;
    public static final int FIELD_OPERATOR = 6;
    public static final int FIELD_SN = 14;
    public static final int FIELD_SN1 = 15;
    public static final int FIELD_SN2 = 16;
    public static final int FIELD_STEPOS_UID = 9;
    public static final int FIELD_UDID = 1;
    public static final int FIELD_VAID = 3;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FieldTypeDef {
    }
}
