package com.android.contacts;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.telephony.ims.ImsMmTelManager;
import com.android.ims.FeatureConnector;
import com.android.ims.FeatureUpdates;
import com.android.ims.ImsException;
import com.android.ims.ImsManager;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class ContactsTelephonyUtilImpl extends ContactsTelephonyUtil {
    private static final int DEFAULT_SOLID_NUMBER = 2;
    private static final String TAG = "ContactsTelephonyUtilImpl";
    private final ExecutorService mExecutor;
    private final FeatureConnector<ImsManager>[] mImsManagerConnector;
    private final FeatureConnector.Listener<ImsManager>[] mImsManagerConnectorListener;

    private class FeatureConnectorListener implements FeatureConnector.Listener<ImsManager> {
        private ImsMmTelManager.RegistrationCallback mCallback;
        private int solId;
        final /* synthetic */ ContactsTelephonyUtilImpl this$0;

        static /* synthetic */ int access$000(FeatureConnectorListener r0) {
            return r0.solId;
        }

        public /* bridge */ /* synthetic */ void connectionReady(FeatureUpdates r1, int r2) throws ImsException {
            connectionReady((ImsManager) r1, r2);
        }

        public FeatureConnectorListener(final ContactsTelephonyUtilImpl r1, int r2) {
            this.this$0 = r1;
            this.solId = r2;
            this.mCallback = new AnonymousClass1(this, r1);
        }

        public void connectionReady(ImsManager r3, int r4) {
            if (ContactsTelephonyUtil.DBG == false) goto L10;
            ContactsTelephonyUtil.log("connectionReady(), slotId:" + r4);
        L10:
            ImsManager.getInstance(this.this$0.mContext, this.solId).addRegistrationCallback(this.mCallback, ContactsTelephonyUtilImpl.access$100(this.this$0));     // Catch: ImsException -> L7
            return;
        L7:
            e = move-exception;
            ContactsTelephonyUtil.loge("registerImsListener(), e=" + e.getCause());
            this.this$0.notifyVtCapbilityChange(r4, false);
        }

        public void connectionUnavailable(int r3) {
            if (ContactsTelephonyUtil.DBG == false) goto L10;
            ContactsTelephonyUtil.log("connectionUnavailable(), slotId:" + r3);
        L10:
            ImsManager.getInstance(this.this$0.mContext, this.solId).removeRegistrationListener(this.mCallback);     // Catch: Exception -> L7
            return;
        L7:
            e = move-exception;
            ContactsTelephonyUtil.loge("removeRegistrationListener(), e=" + e.getCause());
        }
    }

    static /* synthetic */ ExecutorService access$100(ContactsTelephonyUtilImpl r0) {
        return r0.mExecutor;
    }

    private ContactsTelephonyUtilImpl(Context r2) {
        super(r2);
        this.mImsManagerConnector = new FeatureConnector[2];
        this.mImsManagerConnectorListener = new FeatureConnector.Listener[2];
        this.mExecutor = Executors.newSingleThreadExecutor();
        startMonitorVtCapabilityChange();
    }

    public static synchronized void init(Context r2) {
        monitor-enter(ContactsTelephonyUtilImpl.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new ContactsTelephonyUtilImpl(r2);     // Catch: Throwable -> L9
    L7:
        monitor-exit(ContactsTelephonyUtilImpl.class);
    }

    public static synchronized void onSimChanged(Context r1) {
        monitor-enter(ContactsTelephonyUtilImpl.class);
        init(r1);     // Catch: Throwable -> L7
        sInstance.startMonitorVtCapabilityChange();     // Catch: Throwable -> L7
        monitor-exit(ContactsTelephonyUtilImpl.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.contacts.ContactsTelephonyUtil
    protected void startMonitorVtCapabilityChange() {
        TelephonyManager r1 = (TelephonyManager) this.mContext.getSystemService("phone");
        int r3 = 0;
    L4:
        if (r3 >= PHONE_COUNT) goto L18;
        boolean r4 = true;
        if (r1.getImsRegistration(r3, 1).getRegistrationTechnology() == 0) goto L11;
        r4 = false;
    L11:
        if (DBG == false) goto L13;
        log("query slot for slot " + r3 + " done, regStatus=" + r4);     // Catch: Exception -> L15
    L13:
        notifyVtCapbilityChange(r3, r4);     // Catch: Exception -> L15
    L17:
        registerImsListener(r3);
        r3 = r3 + 1;
    L15:
        e = move-exception;
        loge("query slot for slot " + r3 + " error, ex=" + e);
        goto L17
    }

    private void registerImsListener(int r6) {
        FeatureConnector.Listener<ImsManager>[] r0 = this.mImsManagerConnectorListener;
        if (r0[r6] != null) goto L5;
        r0[r6] = new FeatureConnectorListener(this, r6);
    L5:
        FeatureConnector<ImsManager> r1 = this.mImsManagerConnector[r6];
        if (r1 == null) goto L8;
        r1.disconnect();
    L8:
        this.mImsManagerConnector[r6] = ImsManager.getConnector(this.mContext, r6, TAG, this.mImsManagerConnectorListener[r6], this.mExecutor);
        this.mImsManagerConnector[r6].connect();
    }

    @Override // com.android.contacts.ContactsTelephonyUtil
    public boolean isVoLteSupportForSlot(int r3) {
        ImsManager r2 = ImsManager.getInstance(this.mContext, r3);
        if (r2 == null) goto L5;
        boolean r4 = r2.isVolteEnabledByPlatform();
    L7:
        if (DBG == false) goto L9;
        log("isVoLteSupportForSlot(), slotId=" + r3 + " result=" + r4);
    L9:
        return r4;
    L5:
        r4 = false;
        goto L7
    }
}
