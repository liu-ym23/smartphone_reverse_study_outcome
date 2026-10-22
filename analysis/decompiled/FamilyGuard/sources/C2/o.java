package C2;

import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class o {
    public static String a(Editable editable) {
        String strStripSeparators = PhoneNumberUtils.stripSeparators(editable == null ? BuildConfig.FLAVOR : editable.toString());
        if (b(strStripSeparators)) {
            return strStripSeparators;
        }
        return null;
    }

    public static boolean b(String str) {
        return str != null && str.matches("[1][3-9]\\d{9}");
    }
}
