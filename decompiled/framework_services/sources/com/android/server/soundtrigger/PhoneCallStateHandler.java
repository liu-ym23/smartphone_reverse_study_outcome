package com.android.server.soundtrigger;

import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class PhoneCallStateHandler {
    private final Callback mCallback;
    private final ExecutorService mExecutor;
    private final AtomicBoolean mIsPhoneCallOngoing;
    private final List<MyCallStateListener> mListenerList;
    private final Object mLock;
    private final SubscriptionManager mSubscriptionManager;
    private final TelephonyManager mTelephonyManager;

    public interface Callback {
        void onPhoneCallStateChanged(boolean r1);
    }

    private final class MyCallStateListener extends TelephonyCallback implements TelephonyCallback.CallStateListener {
        final TelephonyManager mTelephonyManagerForSubId;
        final /* synthetic */ PhoneCallStateHandler this$0;

        public static /* synthetic */ void $r8$lambda$DrVKqcxsHpHtoTxMhk8bVNFi_ks(MyCallStateListener r0) {
            r0.lambda$cleanup$0();
        }

        MyCallStateListener(PhoneCallStateHandler r1, TelephonyManager telephonyManager) {
            this.this$0 = r1;
            this.mTelephonyManagerForSubId = telephonyManager;
        }

        private /* synthetic */ void lambda$cleanup$0() {
            this.mTelephonyManagerForSubId.unregisterTelephonyCallback(this);
        }

        void cleanup() {
            PhoneCallStateHandler.m8182$$Nest$fgetmExecutor(this.this$0).execute(new PhoneCallStateHandler$MyCallStateListener$$ExternalSyntheticLambda0(this));
        }

        @Override // android.telephony.TelephonyCallback.CallStateListener
        public void onCallStateChanged(int unused) {
            PhoneCallStateHandler.m8183$$Nest$mupdateCallStatus(this.this$0);
        }
    }

    public static /* synthetic */ boolean $r8$lambda$1NFlBhED3_ICM4Ppo54VxYgjQhM(PhoneCallStateHandler r0, SubscriptionInfo r1) {
        return r0.lambda$checkCallStatus$1(r1);
    }

    public static /* synthetic */ void $r8$lambda$PYES1WIVYNsQutEzliFnI13fLQQ(PhoneCallStateHandler r0, TelephonyManager r1) {
        r0.lambda$updateTelephonyListeners$4(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$VMrqL1t_2WaAtzDQKkOiS44tSvA(SubscriptionInfo r0) {
        return lambda$updateTelephonyListeners$2(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$cmK-0IqP8EB6MJlh1-3ZaCnS9ZM, reason: not valid java name */
    public static /* synthetic */ boolean m8181$r8$lambda$cmK0IqP8EB6MJlh13ZaCnS9ZM(SubscriptionInfo r0) {
        return lambda$checkCallStatus$0(r0);
    }

    public static /* synthetic */ TelephonyManager $r8$lambda$zNtuXxrhf7Rp2sFnW2uoztEiRzk(PhoneCallStateHandler r0, SubscriptionInfo r1) {
        return r0.lambda$updateTelephonyListeners$3(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmExecutor, reason: not valid java name */
    static /* bridge */ /* synthetic */ ExecutorService m8182$$Nest$fgetmExecutor(PhoneCallStateHandler r0) {
        return r0.mExecutor;
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateCallStatus, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8183$$Nest$mupdateCallStatus(PhoneCallStateHandler r0) {
        r0.updateCallStatus();
    }

    /* JADX INFO: renamed from: -$$Nest$mupdateTelephonyListeners, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8184$$Nest$mupdateTelephonyListeners(PhoneCallStateHandler r0) {
        r0.updateTelephonyListeners();
    }

    public PhoneCallStateHandler(SubscriptionManager subscriptionManager, TelephonyManager telephonyManager, Callback callback) {
        this.mLock = new Object();
        this.mListenerList = new ArrayList();
        this.mIsPhoneCallOngoing = new AtomicBoolean(false);
        this.mExecutor = Executors.newSingleThreadExecutor();
        subscriptionManager.getClass();
        this.mSubscriptionManager = subscriptionManager.createForAllUserProfiles();
        telephonyManager.getClass();
        this.mTelephonyManager = telephonyManager;
        callback.getClass();
        this.mCallback = callback;
        this.mSubscriptionManager.addOnSubscriptionsChangedListener(this.mExecutor, new AnonymousClass1(this));
    }

    private void updateCallStatus() {
        boolean callStatus = checkCallStatus();
        if (this.mIsPhoneCallOngoing.compareAndSet(!callStatus, callStatus) == false) goto L6;
        this.mCallback.onPhoneCallStateChanged(callStatus);
        return;
    }

    private boolean checkCallStatus() {
        List<SubscriptionInfo> infoList = this.mSubscriptionManager.getActiveSubscriptionInfoList();
        if (infoList != null) goto L7;
        return false;
    L7:
        return infoList.stream().filter(new PhoneCallStateHandler$$ExternalSyntheticLambda3()).anyMatch(new PhoneCallStateHandler$$ExternalSyntheticLambda4(this));
    }

    private static /* synthetic */ boolean lambda$checkCallStatus$0(SubscriptionInfo s) {
        if (s.getSubscriptionId() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ boolean lambda$checkCallStatus$1(SubscriptionInfo s) {
        return isCallOngoingFromState(this.mTelephonyManager.createForSubscriptionId(s.getSubscriptionId()).getCallStateForSubscription());
    L5:
        return false;
    }

    private void updateTelephonyListeners() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        Iterator<MyCallStateListener> r1 = this.mListenerList.iterator();     // Catch: Throwable -> L8
    L6:
        if (r1.hasNext() == false) goto L10;
        MyCallStateListener listener = r1.next();     // Catch: Throwable -> L8
        listener.cleanup();     // Catch: Throwable -> L8
        goto L6
    L10:
        this.mListenerList.clear();     // Catch: Throwable -> L8
        List<SubscriptionInfo> infoList = this.mSubscriptionManager.getActiveSubscriptionInfoList();     // Catch: Throwable -> L8
        if (infoList != null) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        infoList.stream().filter(new PhoneCallStateHandler$$ExternalSyntheticLambda0()).map(new PhoneCallStateHandler$$ExternalSyntheticLambda1(this)).forEach(new PhoneCallStateHandler$$ExternalSyntheticLambda2(this));     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static /* synthetic */ boolean lambda$updateTelephonyListeners$2(SubscriptionInfo s) {
        if (s.getSubscriptionId() == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    private /* synthetic */ TelephonyManager lambda$updateTelephonyListeners$3(SubscriptionInfo s) {
        return this.mTelephonyManager.createForSubscriptionId(s.getSubscriptionId());
    }

    private /* synthetic */ void lambda$updateTelephonyListeners$4(TelephonyManager manager) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        MyCallStateListener listener = new MyCallStateListener(this, manager);     // Catch: Throwable -> L7
        this.mListenerList.add(listener);     // Catch: Throwable -> L7
        manager.registerTelephonyCallback(this.mExecutor, listener);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static boolean isCallOngoingFromState(int callState) {
        switch(callState) {
            case 0: goto L6;
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return true;
    L6:
        return false;
    L4:
        throw new IllegalStateException("Received unexpected call state from Telephony Manager: " + callState);
    }
}
