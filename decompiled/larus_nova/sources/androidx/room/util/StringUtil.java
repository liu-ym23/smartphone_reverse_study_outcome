package androidx.room.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes6.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    private StringUtil() {
    }

    public static String joinIntoString(List<Integer> r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.size();
        if (r101 != 0) goto L9;
        return "";
    L9:
        StringBuilder r102 = new StringBuilder();
        int r103 = 0;
    L10:
        if (r103 >= r101) goto L16;
        r102.append(Integer.toString(((Integer) ListProtector.get(r100, r103)).intValue()));
        if (r103 >= (r101 - 1)) goto L14;
        r102.append(",");
    L14:
        r103 = r103 + 1;
        goto L10
    L16:
        return r102.toString();
    }

    public static List<Integer> splitToIntList(String r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        StringTokenizer r102 = new StringTokenizer(r100, ",");
    L7:
        if (r102.hasMoreElements() == false) goto L12;
        r101.add(Integer.valueOf(CastIntegerProtector.parseInt(r102.nextToken())));     // Catch: NumberFormatException -> L11
        goto L7
    L12:
        return r101;
    }

    public static void appendPlaceholders(StringBuilder r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        r100.append("?");
        if (r102 >= (r101 - 1)) goto L7;
        r100.append(",");
    L7:
        r102 = r102 + 1;
        goto L3
    }
}
