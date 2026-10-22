package p8;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.toolbox.d;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public static void a(Context r10, String r11) {
        File r12 = new File(r10.getFilesDir() + LibrarianImpl.Constants.SEPARATOR + r11);
        if (r12.exists() == false) goto L6;
        r12.delete();
        return;
    }

    public static String b() {
        Date r10 = new Date(Calendar.getInstance().getTimeInMillis());
        return new SimpleDateFormat("EE, ", Locale.ENGLISH).format(r10) + j(r10);
    }

    public static String c(Context r10) {
        return r10.getFilesDir().getAbsolutePath();
    }

    public static String d(String r10) {
        return "";
    }

    public static String e(String r10) {
        return SystemProperties.get(r10, "unknown");
    }

    public static String f() {
        return "SYNC Client/0.2.1 (Android; " + d.f10009a + "; " + e("ro.os.ota.version") + ")";
    }

    public static void g(Context r10, View r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        ((InputMethodManager) r10.getSystemService("input_method")).hideSoftInputFromWindow(r11.getWindowToken(), 0);
    }

    public static boolean h(Context r10, boolean r11) {
        if (r10 != null) goto L5;
        return false;
    L5:
        ConnectivityManager r12 = (ConnectivityManager) r10.getSystemService("connectivity");
        NetworkInfo.State r13 = null;
        NetworkInfo.State r14 = r12.getNetworkInfo(0).getState();     // Catch: Exception -> L11
        r13 = r12.getNetworkInfo(1).getState();     // Catch: Exception -> L9
    L14:
        NetworkInfo.State r15 = NetworkInfo.State.CONNECTED;
        if (r13 != r15) goto L17;
        char r16 = 2;
    L20:
        if (r11 == false) goto L23;
        if (r16 != 2) goto L23;
        return true;
    L23:
        if (r11 == true) goto L26;
        if (r16 == 0) goto L26;
        return true;
    L26:
        return false;
    L17:
        if (r14 != r15) goto L19;
        r16 = 1;
        goto L20
    L19:
        r16 = 0;
    L9:
        e = e;
    L13:
        e.printStackTrace();
    L11:
        e = e;
        r14 = null;
        goto L13
    }

    public static void i(String r10, String r11) {
        TextUtils.isEmpty(r11);
    }

    public static String j(Date r10) {
        SimpleDateFormat r11 = new SimpleDateFormat("dd MMM y HH:mm:ss 'GMT'", Locale.US);
        TimeZone r12 = TimeZone.getTimeZone("GMT");
        r11.setTimeZone(r12);
        new GregorianCalendar(r12).setTimeInMillis(r10.getTime());
        return r11.format(r10);
    }

    public static boolean k(String r10) {
        return Patterns.EMAIL_ADDRESS.matcher(r10.trim()).matches();
    }

    public static boolean l(String r10) {
        if (r10.length() >= 6) goto L5;
    L7:
        return false;
    L5:
        if (r10.length() > 16) goto L7;
        return true;
    }
}
