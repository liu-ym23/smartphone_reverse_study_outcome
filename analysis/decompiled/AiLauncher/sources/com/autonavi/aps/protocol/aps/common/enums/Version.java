package com.autonavi.aps.protocol.aps.common.enums;

import com.autonavi.aps.amapapi.config.Const;
import com.caverock.androidsvg.BuildConfig;

/* loaded from: classes.dex */
public enum Version {
    UNKNOWN(Const.INDOOR_LOCATION_TYPE),
    INVALID("0.0"),
    V10(BuildConfig.VERSION_NAME),
    V20("2.0"),
    V30("3.0"),
    V40("4.0"),
    V41("4.1"),
    V42("4.2"),
    V43("4.3"),
    V44("4.4"),
    V45("4.5"),
    V46("4.6"),
    V47("4.7"),
    V48("4.8"),
    V49("4.9"),
    V50("5.0"),
    V51("5.1"),
    V52("5.2"),
    V53("5.3"),
    V54("5.4"),
    V55("5.5"),
    V56("5.6"),
    V57("5.7");


    /* renamed from: a, reason: collision with root package name */
    private String f18531a;

    /* renamed from: b, reason: collision with root package name */
    private float f18532b;

    Version(String str) {
        this.f18532b = 0.0f;
        this.f18531a = str;
        this.f18532b = Float.parseFloat(str);
    }

    public static Version fromString(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        if (str.startsWith(BuildConfig.VERSION_NAME)) {
            return V10;
        }
        if (str.startsWith("2.0")) {
            return V20;
        }
        if (str.startsWith("3.0")) {
            return V30;
        }
        if (str.startsWith("4.0")) {
            return V40;
        }
        if (str.startsWith("4.1")) {
            return V41;
        }
        if (str.startsWith("4.2")) {
            return V42;
        }
        if (str.startsWith("4.3")) {
            return V43;
        }
        if (str.startsWith("4.4")) {
            return V44;
        }
        if (str.startsWith("4.5")) {
            return V45;
        }
        if (str.startsWith("4.6")) {
            return V46;
        }
        if (str.startsWith("4.7")) {
            return V47;
        }
        if (str.startsWith("4.8")) {
            return V48;
        }
        if (str.startsWith("4.9")) {
            return V49;
        }
        if (str.startsWith("5.0")) {
            return V50;
        }
        if (str.startsWith("5.1")) {
            return V51;
        }
        if (str.startsWith("5.2")) {
            return V52;
        }
        if (str.startsWith("5.3")) {
            return V53;
        }
        if (str.startsWith("5.4")) {
            return V54;
        }
        if (str.startsWith("5.5")) {
            return V55;
        }
        if (str.startsWith("5.6")) {
            return V56;
        }
        if (str.startsWith("5.7")) {
            return V57;
        }
        Version version = INVALID;
        version.f18531a = str;
        try {
            version.f18532b = Float.parseFloat(str);
        } catch (Exception unused) {
        }
        return version;
    }

    public float toFloat() {
        return this.f18532b;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f18531a;
    }
}
