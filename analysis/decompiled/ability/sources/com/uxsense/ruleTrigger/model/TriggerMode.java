package com.uxsense.ruleTrigger.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class TriggerMode {
    public static final int ALL = 1;
    public static final int ANY = 0;
    public static final int SEQUENCE = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private TriggerMode() {
    }

    public static int fromName(String str) {
        if (str == null) {
            return 0;
        }
        String upperCase = str.toUpperCase();
        upperCase.getClass();
        if (upperCase.equals("ALL")) {
            return 1;
        }
        return !upperCase.equals("SEQUENCE") ? 0 : 2;
    }

    public static String getName(int i) {
        return i != 0 ? i != 1 ? i != 2 ? "UNKNOWN" : "SEQUENCE" : "ALL" : "ANY";
    }
}
