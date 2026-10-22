package N0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import s.C5423E;

/* loaded from: classes.dex */
public class b {
    public static void a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                C5423E.a(autoCloseable);
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception unused) {
            }
        }
    }

    public static long b(Context context, Uri uri) {
        return c(context, uri, "_size", 0L);
    }

    public static long c(Context context, Uri uri, String str, long j10) {
        ContentResolver contentResolver = context.getContentResolver();
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = contentResolver.query(uri, new String[]{str}, null, null, null);
                if (!cursorQuery.moveToFirst() || cursorQuery.isNull(0)) {
                    a(cursorQuery);
                    return j10;
                }
                long j11 = cursorQuery.getLong(0);
                a(cursorQuery);
                return j11;
            } catch (Exception e10) {
                Log.w("DocumentFile", "Failed query: " + e10);
                a(cursorQuery);
                return j10;
            }
        } catch (Throwable th) {
            a(cursorQuery);
            throw th;
        }
    }
}
