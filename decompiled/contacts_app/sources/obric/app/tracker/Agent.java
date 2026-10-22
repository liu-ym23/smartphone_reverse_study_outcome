package obric.app.tracker;

import android.app.Application;
import com.GlobalProxyLancet;

/* JADX INFO: loaded from: classes5.dex */
public class Agent {
    private static Agent instance;
    private String TAG;

    private Agent() {
        this.TAG = "ContactsAgent";
    }

    public synchronized void init(Application r2) {
        monitor-enter(this);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent init");     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public static Agent getInstance() {
        if (instance != null) goto L6;
        instance = new Agent();
    L6:
        return instance;
    }

    public void onClick(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onClick");
    }

    public void onAttach(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onAttach");
    }

    public void onAttach(String r1) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onAttach one");
    }

    public void flush() {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent flush");
    }

    public void onEvent(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onEvent");
    }

    public void onStatus(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onStatus");
    }

    public void onStatusDataChanged(String r1, String r2, String r3) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onStatusDataChanged");
    }

    public void onLaunch() throws Exception {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onLaunch");
    }

    public void onLongClick(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onLongClick");
    }

    public void onDetach(String r1) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onDetach");
    }

    public void onDetach(String r1, String r2) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(this.TAG, "contacts Agent onDetach2");
    }
}
