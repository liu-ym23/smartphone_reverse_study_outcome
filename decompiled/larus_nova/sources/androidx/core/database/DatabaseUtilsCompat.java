package androidx.core.database;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes17.dex */
public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    public static String[] appendSelectionArgs(String[] r100, String[] r101) {
        if (r100 != null) goto L4;
    L8:
        return r101;
    L4:
        if (r100.length == 0) goto L8;
        String[] r102 = new String[r100.length + r101.length];
        System.arraycopy(r100, 0, r102, 0, r100.length);
        System.arraycopy(r101, 0, r102, r100.length, r101.length);
        return r102;
    }

    public static String concatenateWhere(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r101;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return r100;
    L9:
        return "(" + r100 + ") AND (" + r101 + ")";
    }
}
