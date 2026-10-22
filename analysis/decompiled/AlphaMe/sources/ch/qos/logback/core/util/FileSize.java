package ch.qos.logback.core.util;

import B0.g;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class FileSize {
    private static final int DOUBLE_GROUP = 1;
    private static final Pattern FILE_SIZE_PATTERN = Pattern.compile("([0-9]+)\\s*(|kb|mb|gb)s?", 2);
    static final long GB_COEFFICIENT = 1073741824;
    static final long KB_COEFFICIENT = 1024;
    private static final String LENGTH_PART = "([0-9]+)";
    static final long MB_COEFFICIENT = 1048576;
    private static final int UNIT_GROUP = 2;
    private static final String UNIT_PART = "(|kb|mb|gb)s?";
    final long size;

    public FileSize(long j4) {
        this.size = j4;
    }

    public static FileSize valueOf(String str) {
        long j4;
        Matcher matcher = FILE_SIZE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(g.n("String value [", str, "] is not in the expected format."));
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        long jLongValue = Long.valueOf(strGroup).longValue();
        if (strGroup2.equalsIgnoreCase("")) {
            j4 = 1;
        } else if (strGroup2.equalsIgnoreCase("kb")) {
            j4 = 1024;
        } else if (strGroup2.equalsIgnoreCase("mb")) {
            j4 = MB_COEFFICIENT;
        } else {
            if (!strGroup2.equalsIgnoreCase("gb")) {
                throw new IllegalStateException("Unexpected ".concat(strGroup2));
            }
            j4 = GB_COEFFICIENT;
        }
        return new FileSize(jLongValue * j4);
    }

    public long getSize() {
        return this.size;
    }
}
