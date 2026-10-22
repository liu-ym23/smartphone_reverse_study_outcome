package androidx.room.util;

import android.util.Log;
import com.android.contacts.common.SimContactsConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public class StringUtil {
    public static final String[] EMPTY_STRING_ARRAY = null;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public static StringBuilder newStringBuilder() {
        return new StringBuilder();
    }

    public static void appendPlaceholders(StringBuilder builder, int count) {
        int r0 = 0;
    L3:
        if (r0 >= count) goto L8;
        builder.append("?");
        if (r0 >= (count - 1)) goto L7;
        builder.append(SimContactsConstants.EMAIL_SEP);
    L7:
        r0 = r0 + 1;
        goto L3
    }

    public static List<Integer> splitToIntList(String input) {
        if (input != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        StringTokenizer r1 = new StringTokenizer(input, SimContactsConstants.EMAIL_SEP);
    L7:
        if (r1.hasMoreElements() == false) goto L13;
        r0.add(Integer.valueOf(Integer.parseInt(r1.nextToken())));     // Catch: NumberFormatException -> L11
    L11:
        e = move-exception;
        Log.e("ROOM", "Malformed integer list", e);
        goto L7
    L13:
        return r0;
    }

    public static String joinIntoString(List<Integer> input) {
        if (input != null) goto L5;
        return null;
    L5:
        int r0 = input.size();
        if (r0 != 0) goto L9;
        return "";
    L9:
        StringBuilder r1 = new StringBuilder();
        int r2 = 0;
    L10:
        if (r2 >= r0) goto L16;
        r1.append(Integer.toString(input.get(r2).intValue()));
        if (r2 >= (r0 - 1)) goto L14;
        r1.append(SimContactsConstants.EMAIL_SEP);
    L14:
        r2 = r2 + 1;
        goto L10
    L16:
        return r1.toString();
    }

    private StringUtil() {
    }
}
