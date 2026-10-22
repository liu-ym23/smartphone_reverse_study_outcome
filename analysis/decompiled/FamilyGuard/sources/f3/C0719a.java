package f3;

import android.content.Context;
import android.util.Log;
import h3.C0752c;
import java.io.Closeable;
import java.io.IOException;
import org.libpag.BuildConfig;

/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0719a {
    public static void a(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e6) {
                Log.e("CommonUtils", "closeQuietly error " + e6.getMessage());
            }
        }
    }

    public static boolean b(Context context) {
        try {
            String strB = C0752c.b("persist.stepos.usagestats.debug", BuildConfig.FLAVOR);
            if (strB == null) {
                return false;
            }
            if (strB.equals("all")) {
                return true;
            }
            return strB.equals(context.getPackageName());
        } catch (Exception e6) {
            Log.e("CommonUtils", "isDebugMode error " + e6.getMessage());
            return false;
        }
    }

    public static boolean c() {
        try {
            String strB = C0752c.b("persist.stepos.usagestats.log", "false");
            if (strB != null) {
                return strB.equals("true");
            }
            return false;
        } catch (Exception e6) {
            Log.e("CommonUtils", "isPrintLog error " + e6.getMessage());
            return false;
        }
    }
}
