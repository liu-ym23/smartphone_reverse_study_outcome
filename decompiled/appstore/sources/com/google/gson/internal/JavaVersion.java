package com.google.gson.internal;

/* JADX INFO: loaded from: classes3.dex */
public final class JavaVersion {
    private static final int majorJavaVersion = 0;

    static {
        majorJavaVersion = determineMajorJavaVersion();
    }

    private JavaVersion() {
    }

    private static int determineMajorJavaVersion() {
        return getMajorJavaVersion(System.getProperty("java.version"));
    }

    private static int extractBeginningInt(String r10) {
        StringBuilder r11 = new StringBuilder();     // Catch: NumberFormatException -> L10
        int r12 = 0;
    L4:
        if (r12 >= r10.length()) goto L8;
        char r13 = r10.charAt(r12);     // Catch: NumberFormatException -> L10
        if (Character.isDigit(r13) == false) goto L8;
        r11.append(r13);     // Catch: NumberFormatException -> L10
        r12 = r12 + 1;     // Catch: NumberFormatException -> L10
    L8:
        return Integer.parseInt(r11.toString());
    L10:
        return -1;
    }

    public static int getMajorJavaVersion(String r10) {
        int r11 = parseDotted(r10);
        if (r11 != (-1)) goto L5;
        r11 = extractBeginningInt(r10);
    L5:
        if (r11 != (-1)) goto L8;
        return 6;
    L8:
        return r11;
    }

    public static boolean isJava9OrLater() {
        if (majorJavaVersion < 9) goto L5;
        return true;
    L5:
        return false;
    }

    private static int parseDotted(String r10) {
        String[] r11 = r10.split("[._]");     // Catch: NumberFormatException -> L9
        int r12 = Integer.parseInt(r11[0]);     // Catch: NumberFormatException -> L9
        if (r12 == 1) goto L5;
    L8:
        return r12;
    L5:
        if (r11.length <= 1) goto L8;
        return Integer.parseInt(r11[1]);
    L9:
        return -1;
    }

    public static int getMajorJavaVersion() {
        return majorJavaVersion;
    }
}
