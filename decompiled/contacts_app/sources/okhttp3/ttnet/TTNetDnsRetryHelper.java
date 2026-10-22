package okhttp3.ttnet;

import android.text.TextUtils;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Request;

/* JADX INFO: loaded from: classes5.dex */
public class TTNetDnsRetryHelper {
    private static volatile TTNetDnsRetryHelper sInstance;
    private final CopyOnWriteArrayList<String> mRetryForceHttpDnsHostList;

    public TTNetDnsRetryHelper() {
        this.mRetryForceHttpDnsHostList = new CopyOnWriteArrayList();
    }

    public static TTNetDnsRetryHelper inst() {
        if (sInstance != null) goto L15;
        monitor-enter(TTNetDnsRetryHelper.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new TTNetDnsRetryHelper();     // Catch: Throwable -> L11
    L9:
        monitor-exit(TTNetDnsRetryHelper.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public void setForceHttpDns(Request r2, boolean r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.url() != null) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r2.url().host()) == true) goto L16;
        String r4 = r2.url().host();
        if (r3 == false) goto L11;
        this.mRetryForceHttpDnsHostList.add(r4);
        return;
    L11:
        this.mRetryForceHttpDnsHostList.remove(r4);
        return;
    }

    public boolean checkForceHttpDns(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L7;
        return false;
    L7:
        return this.mRetryForceHttpDnsHostList.contains(r2);
    }
}
