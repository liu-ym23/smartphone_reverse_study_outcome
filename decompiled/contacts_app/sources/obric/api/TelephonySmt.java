package obric.api;

import android.os.RemoteException;
import android.util.Singleton;
import com.android.internal.telephony.ITelephony;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class TelephonySmt {
    public static final String DEFAULT_NOTIFICATION_PACKAGE_NAME = "com.android.phone";
    public static final String MISSED_CALL_NOTIFICATION_PACKAGE_NAME = "com.android.server.telecom";
    public static final int NOTIFICATION_TYPE_MISSED_CALL = 0;
    static final int PHONE_TYPE_SM_VOIP = 7;
    static final String TAG = "TelephonySmt";
    static final Singleton<TelephonySmt> sTelephonySmt = null;

    /* synthetic */ TelephonySmt(AnonymousClass1 r1) {
        this();
    }

    static {
        sTelephonySmt = new AnonymousClass1();
    }

    public static TelephonySmt getInstance() {
        return (TelephonySmt) sTelephonySmt.get();
    }

    private TelephonySmt() {
    }

    public List<String> getActiveNumbers(ITelephony r1) throws RemoteException {
        return Collections.emptyList();
    }
}
