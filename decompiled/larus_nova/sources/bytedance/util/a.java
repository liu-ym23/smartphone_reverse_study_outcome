package bytedance.util;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes28.dex */
public final class a {
    public static boolean d() {
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return true;
    L5:
        return false;
    }

    public static void a(InputStream r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    public static void b(OutputStream r100) {
        if (r100 != null) goto L7;
        return;
    L7:
        r100.close();     // Catch: IOException -> L6
        return;
    }

    public static String e(String r100) {
        int r101 = r100.length();
        char[] r102 = r100.toCharArray();
        int r103 = 0;
        char r104 = 0;
        int r105 = 0;
    L4:
        if (r103 >= r101) goto L10;
        char r106 = r102[r103];
        if (r106 != '/') goto L8;
        if (r104 != '/') goto L8;
    L9:
        r103 = r103 + 1;
        r104 = r106;
    L8:
        r102[r105] = r106;
        r105 = r105 + 1;
        goto L9
    L10:
        if (r104 == '/') goto L12;
    L14:
        if (r105 != r101) goto L16;
        return r100;
    L16:
        return new String(r102, 0, r105);
    L12:
        if (r101 <= 1) goto L14;
        r105 = r105 - 1;
        goto L14
    }

    public static Bundle c(String r100, String[] r101, int r102, int r103, String r104) {
        Bundle r105 = new Bundle();
        if (d() == false) goto L12;
        r105.putString("android:query-arg-sql-selection", r100);
        r105.putStringArray("android:query-arg-sql-selection-args", r101);
        if (TextUtils.isEmpty(r104) == false) goto L7;
        r105.putString("android:query-arg-sql-sort-order", "_id DESC");
    L9:
        if (d() == false) goto L12;
        if (r102 <= 0) goto L12;
        r105.putString("android:query-arg-sql-limit", r102 + " offset " + r103);
        goto L12
    L7:
        r105.putString("android:query-arg-sql-sort-order", r104);
    L12:
        return r105;
    }
}
