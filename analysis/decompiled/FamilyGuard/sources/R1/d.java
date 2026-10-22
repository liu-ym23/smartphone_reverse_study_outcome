package R1;

import android.text.TextUtils;
import android.util.Log;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
final class d implements b {
    d() {
    }

    private void b(int i5, String str, String str2) {
        switch (i5) {
            case 2:
                Log.v(str, str2);
                break;
            case 3:
                Log.d(str, str2);
                break;
            case 4:
                Log.i(str, str2);
                break;
            case 5:
                Log.w(str, str2);
                break;
            case 6:
                Log.e(str, str2);
                break;
            case 7:
                Log.wtf(str, str2);
                break;
        }
    }

    private void c(int i5, String str, String str2, Throwable th) {
        switch (i5) {
            case 2:
                Log.v(str, str2, th);
                break;
            case 3:
                Log.d(str, str2, th);
                break;
            case 4:
                Log.i(str, str2, th);
                break;
            case 5:
                Log.w(str, str2, th);
                break;
            case 6:
                Log.e(str, str2, th);
                break;
            case 7:
                Log.wtf(str, str2, th);
                break;
        }
    }

    @Override // R1.b
    public void a(int i5, String str, String str2, Throwable th) {
        if (TextUtils.isEmpty(str2)) {
            c(i5, str, BuildConfig.FLAVOR, th);
        } else if (th != null) {
            c(i5, str, str2, th);
        } else {
            b(i5, str, str2);
        }
    }
}
