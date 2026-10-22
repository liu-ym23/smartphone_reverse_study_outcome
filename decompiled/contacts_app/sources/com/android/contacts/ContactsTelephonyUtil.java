package com.android.contacts;

import android.content.Context;
import android.os.SystemProperties;
import bytedanceos.util.MultiSimAdapter;
import com.GlobalProxyLancet;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public abstract class ContactsTelephonyUtil {
    protected static final boolean DBG = false;
    public static final int PHONE_COUNT = 0;
    public static final int SLOT1 = 0;
    public static final int SLOT2 = 1;
    private static String TAG = "ContactsTelephonyUtil";
    private static ArrayList<VtCapabilityListener> mVtCapabilityListener;
    protected static ContactsTelephonyUtil sInstance;
    protected Context mContext;
    private boolean[] mVtCapable;

    public interface VtCapabilityListener {
        void onVtCapabilityChanged(int r1, boolean r2);
    }

    protected abstract boolean isVoLteSupportForSlot(int r1);

    protected void startMonitorVtCapabilityChange() {
    }

    static {
        DBG = SystemProperties.get("ro.build.type").equals("userdebug");
        PHONE_COUNT = MultiSimAdapter.getPhoneCount();
        mVtCapabilityListener = new ArrayList();
    }

    protected ContactsTelephonyUtil(Context r2) {
        this.mVtCapable = new boolean[PHONE_COUNT];
        this.mContext = r2;
    }

    public static ContactsTelephonyUtil getInstance() {
        ContactsTelephonyUtil r0 = sInstance;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new RuntimeException("ContactsTelephonyUtil is not initialized!");
    }

    public boolean isDualVolteSupport() {
        if (PHONE_COUNT != 2) goto L15;
        int r0 = 0;
    L6:
        if (r0 >= PHONE_COUNT) goto L12;
        if (isVoLteSupportForSlot(r0) == false) goto L16;
        r0 = r0 + 1;
        goto L6
    L16:
        return false;
    L12:
        return true;
    L15:
        return false;
    }

    public boolean isVoLteSupport() {
        int r0 = 0;
    L4:
        if (r0 >= PHONE_COUNT) goto L9;
        if (isVoLteSupportForSlot(r0) == true) goto L13;
        r0 = r0 + 1;
        goto L4
    L13:
        return true;
    L9:
        return true;
    }

    public boolean isVtCapable() {
        int r1 = 0;
    L4:
        if (r1 >= PHONE_COUNT) goto L12;
        if (isVtCapableForSlot(r1) == true) goto L7;
        r1 = r1 + 1;
        goto L4
    L7:
        return true;
    L12:
        return false;
    }

    public boolean isVtCapableForSlot(int r2) {
        if (MultiSimAdapter.isValidSlotId(r2) == true) goto L7;
        return false;
    L7:
        return this.mVtCapable[r2];
    }

    public void registerVtCapbilityListener(VtCapabilityListener r2) {
        ArrayList<VtCapabilityListener> r1 = mVtCapabilityListener;
        monitor-enter(r1);
        mVtCapabilityListener.add(r2);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unRegisterVtCapbilityListener(VtCapabilityListener r2) {
        ArrayList<VtCapabilityListener> r1 = mVtCapabilityListener;
        monitor-enter(r1);
        mVtCapabilityListener.remove(r2);     // Catch: Throwable -> L7
        monitor-exit(r1);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    protected void notifyVtCapbilityChange(int r3, boolean r4) {
        if (MultiSimAdapter.isValidSlotId(r3) == false) goto L17;
        boolean[] r2 = this.mVtCapable;
        if (r2[r3] == r4) goto L21;
        r2[r3] = r4;
        logi("notifyVtCapbilityChange(), slot=" + r3 + " status=" + r4);
        ArrayList<VtCapabilityListener> r5 = mVtCapabilityListener;
        monitor-enter(r5);
        Iterator<VtCapabilityListener> r0 = mVtCapabilityListener.iterator();     // Catch: Throwable -> L14
    L10:
        if (r0.hasNext() == false) goto L12;
        r0.next().onVtCapabilityChanged(r3, r4);     // Catch: Throwable -> L14
        goto L10
    L12:
        monitor-exit(r5);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    L21:
        return;
    }

    protected static void log(String r1) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r1);
    }

    protected static void logi(String r1) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r1);
    }

    protected static void loge(String r1) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, r1);
    }
}
