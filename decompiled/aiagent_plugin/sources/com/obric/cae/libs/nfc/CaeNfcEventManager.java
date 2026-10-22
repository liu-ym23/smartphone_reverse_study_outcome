package com.obric.cae.libs.nfc;

import android.os.Bundle;
import android.os.RemoteException;
import com.obric.cae.libs.utils.LogUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public class CaeNfcEventManager {
    public static final int TRANSIT_AID_TYPE_ALL = 0;
    public static final int TRANSIT_AID_TYPE_BANK_CARD = 4;
    public static final int TRANSIT_AID_TYPE_CAR_KEY = 1;
    public static final int TRANSIT_AID_TYPE_TRANSIT_CARD = 2;
    public static final int TRANSIT_EVENT_SOURCE_BINDER = 2;
    public static final int TRANSIT_EVENT_SOURCE_BROADCAST = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ICaeNfcEventManager f31760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f31761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f31762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f31763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ConcurrentHashMap f31764e;
    public final ConcurrentHashMap f;
    public final ConcurrentHashMap g;

    public static class DndConfigCallbackWrapper extends ICaeNfcDndConfigCallback.Stub {
        private final CaeNfcDndConfigCallback mCallback;

        public DndConfigCallbackWrapper(CaeNfcDndConfigCallback r3) {
            this.mCallback = (CaeNfcDndConfigCallback) ZeusTransformUtils.wrapperContextForParams(r3, CaeNfcDndConfigCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcDndConfigCallback
        public void onDndConfigChanged(boolean r1, int r2) {
            this.mCallback.onDndConfigChanged(r1, r2);
        }
    }

    public static class ForceFwCallbackWrapper extends ICaeNfcForceFwEventCallback.Stub {
        private final CaeNfcForceFwEventCallback mCallback;

        public ForceFwCallbackWrapper(CaeNfcForceFwEventCallback r3) {
            this.mCallback = (CaeNfcForceFwEventCallback) ZeusTransformUtils.wrapperContextForParams(r3, CaeNfcForceFwEventCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcForceFwEventCallback
        public void onForceFwDownload() {
            this.mCallback.onForceFwDownload();
        }
    }

    public static class PaymentChangeCallbackWrapper extends ICaeNfcPaymentChangeCallback.Stub {
        private final CaeNfcPaymentChangeCallback mCallback;

        public PaymentChangeCallbackWrapper(CaeNfcPaymentChangeCallback r3) {
            this.mCallback = (CaeNfcPaymentChangeCallback) ZeusTransformUtils.wrapperContextForParams(r3, CaeNfcPaymentChangeCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcPaymentChangeCallback
        public void onPaymentChanged(String r1) {
            this.mCallback.onPaymentChanged(r1);
        }
    }

    public static class TransitCallbackWrapper extends ICaeNfcTransitEventCallback.Stub {
        private final CaeNfcTransitEventCallback mCallback;

        public TransitCallbackWrapper(CaeNfcTransitEventCallback r3) {
            this.mCallback = (CaeNfcTransitEventCallback) ZeusTransformUtils.wrapperContextForParams(r3, CaeNfcTransitEventCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcTransitEventCallback
        public void onTransitEvent(Bundle r1) {
            this.mCallback.onTransitEvent(r1);
        }
    }

    public static class VendorNciCallbackWrapper extends ICaeNfcVendorNciEventCallback.Stub {
        private final CaeNfcVendorNciEventCallback mCallback;

        public VendorNciCallbackWrapper(CaeNfcVendorNciEventCallback r3) {
            this.mCallback = (CaeNfcVendorNciEventCallback) ZeusTransformUtils.wrapperContextForParams(r3, CaeNfcVendorNciEventCallback.class, "com.obric.aiagent.plugin");
        }

        @Override // com.obric.cae.libs.nfc.ICaeNfcVendorNciEventCallback
        public void onVendorNciEvent(Bundle r1) {
            this.mCallback.onVendorNciEvent(r1);
        }
    }

    public CaeNfcEventManager(ICaeNfcEventManager r3) {
        ICaeNfcEventManager r4 = (ICaeNfcEventManager) ZeusTransformUtils.wrapperContextForParams(r3, ICaeNfcEventManager.class, "com.obric.aiagent.plugin");
        this.f31761b = new ConcurrentHashMap();
        this.f31762c = new ConcurrentHashMap();
        this.f31763d = new ConcurrentHashMap();
        this.f31764e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap();
        this.g = new ConcurrentHashMap();
        this.f31760a = r4;
    }

    public int getTransitEventAllowedAidTypes() {
        ICaeNfcEventManager r3 = this.f31760a;
        if (r3 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventAllowedAidTypes: service is null");
        return 0;
    L11:
        return r3.getTransitEventAllowedAidTypes();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 0;
    }

    public int getTransitEventSource() {
        ICaeNfcEventManager r3 = this.f31760a;
        if (r3 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "getTransitEventSource: service is null");
        return 1;
    L11:
        return r3.getTransitEventSource();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return 1;
    }

    public boolean isTransitEventFilterEnabled() {
        ICaeNfcEventManager r3 = this.f31760a;
        if (r3 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "isTransitEventFilterEnabled: service is null");
        return true;
    L11:
        return r3.isTransitEventFilterEnabled();
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return true;
    }

    public boolean notifyTransitEvent(Bundle r3) {
        ICaeNfcEventManager r2 = this.f31760a;
        if (r2 != null) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "notifyTransitEvent: service is null");
        return false;
    L12:
        r2.notifyTransitEvent(r3);     // Catch: RemoteException -> L9
        return true;
    L9:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerCloudConfigCallback(ICaeNfcCloudConfigCallback r6) {
        ICaeNfcCloudConfigCallback r7 = (ICaeNfcCloudConfigCallback) ZeusTransformUtils.wrapperContextForParams(r6, ICaeNfcCloudConfigCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r1 = (ICaeNfcCloudConfigCallback) ZeusTransformUtils.preCheckCast(this.f31761b.get(r7), ICaeNfcCloudConfigCallback.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L13;
        this.f31761b.put(r7, r7);
    L20:
        this.f31760a.registerCloudConfigCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L13:
        r7 = r1;
        goto L20
    }

    public boolean registerDndConfigCallback(CaeNfcDndConfigCallback r6) {
        CaeNfcDndConfigCallback r7 = (CaeNfcDndConfigCallback) ZeusTransformUtils.wrapperContextForParams(r6, CaeNfcDndConfigCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r1 = (ICaeNfcDndConfigCallback) ZeusTransformUtils.preCheckCast(this.f31762c.get(r7), ICaeNfcDndConfigCallback.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        r1 = new DndConfigCallbackWrapper(r7);
        this.f31762c.put(r7, r1);
    L19:
        this.f31760a.registerDndConfigCallback(r1);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerForceFwCallback(CaeNfcForceFwEventCallback r6) {
        CaeNfcForceFwEventCallback r7 = (CaeNfcForceFwEventCallback) ZeusTransformUtils.wrapperContextForParams(r6, CaeNfcForceFwEventCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r1 = (ICaeNfcForceFwEventCallback) ZeusTransformUtils.preCheckCast(this.f31763d.get(r7), ICaeNfcForceFwEventCallback.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        r1 = new ForceFwCallbackWrapper(r7);
        this.f31763d.put(r7, r1);
    L19:
        this.f31760a.registerForceFwEventCallback(r1);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerPaymentChangeCallback(CaeNfcPaymentChangeCallback r6) {
        CaeNfcPaymentChangeCallback r7 = (CaeNfcPaymentChangeCallback) ZeusTransformUtils.wrapperContextForParams(r6, CaeNfcPaymentChangeCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r1 = (ICaeNfcPaymentChangeCallback) ZeusTransformUtils.preCheckCast(this.g.get(r7), ICaeNfcPaymentChangeCallback.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        r1 = new PaymentChangeCallbackWrapper(r7);
        this.g.put(r7, r1);
    L19:
        this.f31760a.registerPaymentChangeCallback(r1);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerTransitCallback(CaeNfcTransitEventCallback r6) {
        CaeNfcTransitEventCallback r7 = (CaeNfcTransitEventCallback) ZeusTransformUtils.wrapperContextForParams(r6, CaeNfcTransitEventCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r1 = (ICaeNfcTransitEventCallback) ZeusTransformUtils.preCheckCast(this.f31764e.get(r7), ICaeNfcTransitEventCallback.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        r1 = new TransitCallbackWrapper(r7);
        this.f31764e.put(r7, r1);
    L19:
        this.f31760a.registerTransitEventCallback(r1);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean registerVendorNciCallback(CaeNfcVendorNciEventCallback r6) {
        CaeNfcVendorNciEventCallback r7 = (CaeNfcVendorNciEventCallback) ZeusTransformUtils.wrapperContextForParams(r6, CaeNfcVendorNciEventCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "registerVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r1 = (ICaeNfcVendorNciEventCallback) ZeusTransformUtils.preCheckCast(this.f.get(r7), ICaeNfcVendorNciEventCallback.class, "com.obric.aiagent.plugin");
        if (r1 != null) goto L19;
        r1 = new VendorNciCallbackWrapper(r7);
        this.f.put(r7, r1);
    L19:
        this.f31760a.registerVendorNciEventCallback(r1);     // Catch: RemoteException -> L16
        return true;
    L16:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventAllowedAidTypes(int r4) {
        if (r4 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: invalid mask " + r4);
        return false;
    L12:
        ICaeNfcEventManager r3 = this.f31760a;
        if (r3 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventAllowedAidTypes: service is null");
        return false;
    L21:
        return r3.setTransitEventAllowedAidTypes(r4);
    L18:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    L5:
        if ((r4 & (-8)) != 0) goto L7;
        r1 = true;
        goto L9
    }

    public boolean setTransitEventFilterEnabled(boolean r3) {
        ICaeNfcEventManager r2 = this.f31760a;
        if (r2 != null) goto L11;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventFilterEnabled: service is null");
        return false;
    L11:
        return r2.setTransitEventFilterEnabled(r3);
    L8:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean setTransitEventSource(int r4) {
        boolean r0 = true;
        if (r4 == 1) goto L9;
        if (r4 == 2) goto L9;
        r0 = false;
    L9:
        if (r0 == true) goto L12;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: invalid source " + r4);
        return false;
    L12:
        ICaeNfcEventManager r3 = this.f31760a;
        if (r3 != null) goto L21;
        LogUtil.e("NFC:CaeNfcEventManager", "setTransitEventSource: service is null");
        return false;
    L21:
        return r3.setTransitEventSource(r4);
    L18:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterCloudConfigCallback(ICaeNfcCloudConfigCallback r5) {
        ICaeNfcCloudConfigCallback r6 = (ICaeNfcCloudConfigCallback) ZeusTransformUtils.wrapperContextForParams(r5, ICaeNfcCloudConfigCallback.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcCloudConfigCallback r7 = (ICaeNfcCloudConfigCallback) ZeusTransformUtils.preCheckCast(this.f31761b.remove(r6), ICaeNfcCloudConfigCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterCloudConfigCallback: callback not found");
        return false;
    L20:
        this.f31760a.unregisterCloudConfigCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterDndConfigCallback(CaeNfcDndConfigCallback r5) {
        CaeNfcDndConfigCallback r6 = (CaeNfcDndConfigCallback) ZeusTransformUtils.wrapperContextForParams(r5, CaeNfcDndConfigCallback.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: service is null");
        return false;
    L10:
        ICaeNfcDndConfigCallback r7 = (ICaeNfcDndConfigCallback) ZeusTransformUtils.preCheckCast(this.f31762c.remove(r6), ICaeNfcDndConfigCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterDndConfigCallback: callback not found");
        return false;
    L20:
        this.f31760a.unregisterDndConfigCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterForceFwCallback(CaeNfcForceFwEventCallback r5) {
        CaeNfcForceFwEventCallback r6 = (CaeNfcForceFwEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, CaeNfcForceFwEventCallback.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: service is null");
        return false;
    L10:
        ICaeNfcForceFwEventCallback r7 = (ICaeNfcForceFwEventCallback) ZeusTransformUtils.preCheckCast(this.f31763d.remove(r6), ICaeNfcForceFwEventCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterForceFwCallback: callback not found");
        return false;
    L20:
        this.f31760a.unregisterForceFwEventCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterPaymentChangeCallback(CaeNfcPaymentChangeCallback r5) {
        CaeNfcPaymentChangeCallback r6 = (CaeNfcPaymentChangeCallback) ZeusTransformUtils.wrapperContextForParams(r5, CaeNfcPaymentChangeCallback.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: service is null");
        return false;
    L10:
        ICaeNfcPaymentChangeCallback r7 = (ICaeNfcPaymentChangeCallback) ZeusTransformUtils.preCheckCast(this.g.remove(r6), ICaeNfcPaymentChangeCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterPaymentChangeCallback: callback not found");
        return false;
    L20:
        this.f31760a.unregisterPaymentChangeCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterTransitCallback(CaeNfcTransitEventCallback r5) {
        CaeNfcTransitEventCallback r6 = (CaeNfcTransitEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, CaeNfcTransitEventCallback.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: service is null");
        return false;
    L10:
        ICaeNfcTransitEventCallback r7 = (ICaeNfcTransitEventCallback) ZeusTransformUtils.preCheckCast(this.f31764e.remove(r6), ICaeNfcTransitEventCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterTransitCallback: callback not found");
        return false;
    L20:
        this.f31760a.unregisterTransitEventCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }

    public boolean unregisterVendorNciCallback(CaeNfcVendorNciEventCallback r5) {
        CaeNfcVendorNciEventCallback r6 = (CaeNfcVendorNciEventCallback) ZeusTransformUtils.wrapperContextForParams(r5, CaeNfcVendorNciEventCallback.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L7;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback is null");
        return false;
    L7:
        if (this.f31760a != null) goto L10;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: service is null");
        return false;
    L10:
        ICaeNfcVendorNciEventCallback r7 = (ICaeNfcVendorNciEventCallback) ZeusTransformUtils.preCheckCast(this.f.remove(r6), ICaeNfcVendorNciEventCallback.class, "com.obric.aiagent.plugin");
        if (r7 != null) goto L20;
        LogUtil.e("NFC:CaeNfcEventManager", "unregisterVendorNciCallback: callback not found");
        return false;
    L20:
        this.f31760a.unregisterVendorNciEventCallback(r7);     // Catch: RemoteException -> L17
        return true;
    L17:
        e = move-exception;
        a.a("RemoteException: ", e, "NFC:CaeNfcEventManager");
        return false;
    }
}
