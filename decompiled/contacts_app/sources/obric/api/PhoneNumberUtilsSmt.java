package obric.api;

import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.util.Singleton;

/* JADX INFO: loaded from: classes5.dex */
public class PhoneNumberUtilsSmt {
    static final String TAG = "PhoneNumberUtilsSmt";
    static final Singleton<PhoneNumberUtilsSmt> sPhoneNumberUtilsSmt = null;

    /* synthetic */ PhoneNumberUtilsSmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sPhoneNumberUtilsSmt = new AnonymousClass1();
    }

    public static PhoneNumberUtilsSmt getInstance() {
        return (PhoneNumberUtilsSmt) sPhoneNumberUtilsSmt.get();
    }

    private PhoneNumberUtilsSmt() {
    }

    public String formatNumberToLite(Context r1, String r2, String r3) {
        return PhoneNumberUtils.formatNumber(r2, r3);
    }
}
