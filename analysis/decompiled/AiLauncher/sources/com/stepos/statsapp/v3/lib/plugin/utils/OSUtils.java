package com.stepos.statsapp.v3.lib.plugin.utils;

import android.os.Build;
import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes2.dex */
public class OSUtils {

    public enum ROM {
        HUAWEI(Const.BRAND_HUAWEI, "EMUI"),
        XIAOMI(Const.BRAND_XIAOMI, "MIUI"),
        OPPO("oppo", "ColorOS"),
        VIVO(Const.BRAND_VIVO, "FuntouchOS"),
        GOOGLE("google", "Google"),
        SAMSUNG("samsung", "SamSung"),
        SMARTISAN("smartisan", "SmartisanOS"),
        LETV("letv", "EUI"),
        HTC("htc", "Sense"),
        ZTE("zte", "MiFavor"),
        ONEPLUS("oneplus", "H2OS"),
        YULONG("yulong", "YuLong"),
        SONY("sony", "Sony"),
        LENOVO("lenovo", "Lenovo"),
        LG("lg", "LG"),
        REALME("realme", "realme"),
        UNISOC("chinatelecom", "Ruiwei"),
        OTHER("other", "UNKNOWN");

        private String brand;
        private String os;

        ROM(String str, String str2) {
            this.os = str2;
            this.brand = str;
        }
    }

    public static String getOtherBrandOs() {
        String lowerCase = Build.MANUFACTURER.toLowerCase();
        ROM rom = ROM.HUAWEI;
        if (lowerCase.contains(rom.brand)) {
            return rom.os;
        }
        ROM rom2 = ROM.XIAOMI;
        if (lowerCase.contains(rom2.brand)) {
            return rom2.os;
        }
        ROM rom3 = ROM.OPPO;
        if (lowerCase.contains(rom3.brand)) {
            return rom3.os;
        }
        ROM rom4 = ROM.VIVO;
        if (lowerCase.contains(rom4.brand)) {
            return rom4.os;
        }
        ROM rom5 = ROM.SAMSUNG;
        if (lowerCase.contains(rom5.brand)) {
            return rom5.os;
        }
        ROM rom6 = ROM.SMARTISAN;
        if (lowerCase.contains(rom6.brand)) {
            return rom6.os;
        }
        ROM rom7 = ROM.LG;
        if (lowerCase.contains(rom7.brand)) {
            return rom7.os;
        }
        ROM rom8 = ROM.LETV;
        if (lowerCase.contains(rom8.brand)) {
            return rom8.os;
        }
        ROM rom9 = ROM.ZTE;
        if (lowerCase.contains(rom9.brand)) {
            return rom9.os;
        }
        ROM rom10 = ROM.YULONG;
        if (lowerCase.contains(rom10.brand)) {
            return rom10.os;
        }
        ROM rom11 = ROM.LENOVO;
        if (lowerCase.contains(rom11.brand)) {
            return rom11.os;
        }
        ROM rom12 = ROM.SONY;
        if (lowerCase.contains(rom12.brand)) {
            return rom12.os;
        }
        ROM rom13 = ROM.GOOGLE;
        if (lowerCase.contains(rom13.brand)) {
            return rom13.os;
        }
        ROM rom14 = ROM.ONEPLUS;
        if (lowerCase.contains(rom14.brand)) {
            return rom14.os;
        }
        ROM rom15 = ROM.HTC;
        if (lowerCase.contains(rom15.brand)) {
            return rom15.os;
        }
        ROM rom16 = ROM.REALME;
        if (lowerCase.contains(rom16.brand)) {
            return rom16.os;
        }
        ROM rom17 = ROM.UNISOC;
        return lowerCase.contains(rom17.brand) ? rom17.os : ROM.OTHER.os;
    }
}
