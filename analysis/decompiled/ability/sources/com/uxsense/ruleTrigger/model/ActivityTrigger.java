package com.uxsense.ruleTrigger.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public final class ActivityTrigger {
    public static final int ANY = 999;
    public static final int FIRST_TRAVERSALS = 20;
    public static final int ON_CONFIGURATION_CHANGED = 7;
    public static final int ON_CREATE = 0;
    public static final int ON_DESTROY = 5;
    public static final int ON_PAUSE = 3;
    public static final int ON_RESUME = 2;
    public static final int ON_START = 1;
    public static final int ON_STOP = 4;
    public static final int ON_TOP_RESUMED_GAINED = 8;
    public static final int ON_TOP_RESUMED_LOST = 9;
    public static final int ON_WINDOW_FOCUS_CHANGED = 6;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ActivityTrigger() {
    }

    public static int fromName(String str) {
        if (str == null) {
            return 999;
        }
        String upperCase = str.toUpperCase();
        upperCase.getClass();
        switch (upperCase) {
        }
        return 999;
    }

    public static String getName(int i) {
        if (i == 20) {
            return "FIRST_TRAVERSALS";
        }
        if (i == 999) {
            return "ANY";
        }
        switch (i) {
            case 0:
                return "ON_CREATE";
            case 1:
                return "ON_START";
            case 2:
                return "ON_RESUME";
            case 3:
                return "ON_PAUSE";
            case 4:
                return "ON_STOP";
            case 5:
                return "ON_DESTROY";
            case 6:
                return "ON_WINDOW_FOCUS_CHANGED";
            case 7:
                return "ON_CONFIGURATION_CHANGED";
            case 8:
                return "ON_TOP_RESUMED_GAINED";
            case 9:
                return "ON_TOP_RESUMED_LOST";
            default:
                return "UNKNOWN";
        }
    }
}
