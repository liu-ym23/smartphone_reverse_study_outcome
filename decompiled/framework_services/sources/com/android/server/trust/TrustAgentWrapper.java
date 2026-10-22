package com.android.server.trust;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.hardware.audio.common.V2_0.AudioFormat;
import android.net.Uri;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PersistableBundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.service.trust.GrantTrustResult;
import android.service.trust.ITrustAgentService;
import android.service.trust.ITrustAgentServiceCallback;
import android.util.Log;
import android.util.Pair;
import android.util.Slog;
import com.android.internal.infra.AndroidFuture;
import com.android.server.am.HostingRecord;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class TrustAgentWrapper {
    private static final String DATA_DURATION = "duration";
    private static final String DATA_ESCROW_TOKEN = "escrow_token";
    private static final String DATA_HANDLE = "handle";
    private static final String DATA_MESSAGE = "message";
    private static final String DATA_USER_ID = "user_id";
    private static final boolean DEBUG = false;
    private static final String EXTRA_COMPONENT_NAME = "componentName";
    private static final int MSG_ADD_ESCROW_TOKEN = 7;
    private static final int MSG_ESCROW_TOKEN_STATE = 9;
    private static final int MSG_GRANT_TRUST = 1;
    private static final int MSG_LOCK_USER = 12;
    private static final int MSG_MANAGING_TRUST = 6;
    private static final int MSG_REMOVE_ESCROW_TOKEN = 8;
    private static final int MSG_RESTART_TIMEOUT = 4;
    private static final int MSG_REVOKE_TRUST = 2;
    private static final int MSG_SET_TRUST_AGENT_FEATURES_COMPLETED = 5;
    private static final int MSG_SHOW_KEYGUARD_ERROR_MESSAGE = 11;
    private static final int MSG_TRUST_TIMEOUT = 3;
    private static final int MSG_UNLOCK_USER = 10;
    private static final String PERMISSION = "android.permission.PROVIDE_TRUST_AGENT";
    private static final long RESTART_TIMEOUT_MILLIS = 300000;
    private static final String TAG = "TrustAgentWrapper";
    private static final String TRUST_EXPIRED_ACTION = "android.server.trust.TRUST_EXPIRED_ACTION";
    private final Intent mAlarmIntent;
    private AlarmManager mAlarmManager;
    private PendingIntent mAlarmPendingIntent;
    private boolean mBound;
    private final BroadcastReceiver mBroadcastReceiver;
    private ITrustAgentServiceCallback mCallback;
    private final ServiceConnection mConnection;
    private final Context mContext;
    private boolean mDisplayTrustGrantedMessage;
    private final Handler mHandler;
    private boolean mManagingTrust;
    private long mMaximumTimeToLock;
    private CharSequence mMessage;
    private final ComponentName mName;
    private boolean mPendingSuccessfulUnlock;
    private long mScheduledRestartUptimeMillis;
    private IBinder mSetTrustAgentFeaturesToken;
    private ITrustAgentService mTrustAgentService;
    private boolean mTrustDisabledByDpm;
    private final TrustManagerService mTrustManagerService;
    private boolean mTrustable;
    private final BroadcastReceiver mTrustableDowngradeReceiver;
    private boolean mTrusted;
    private final int mUserId;
    private boolean mWaitingForTrustableDowngrade;
    private boolean mWithinSecurityLockdownWindow;

    /* JADX INFO: renamed from: com.android.server.trust.TrustAgentWrapper$3, reason: invalid class name */
    class AnonymousClass3 extends Handler {
        final /* synthetic */ TrustAgentWrapper this$0;

        public static /* synthetic */ void $r8$lambda$HDqz9V2YUFxU5k82UDiihJxnkw8(AnonymousClass3 r0, GrantTrustResult r1) {
            r0.lambda$handleMessage$0(r1);
        }

        AnonymousClass3(TrustAgentWrapper this$0) {
            this.this$0 = this$0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r19) {
            char r9 = 1;
            int r10 = 1;
            boolean r11 = true;
            switch(r19.what) {
                case 1: goto L75;
                case 2: goto L70;
                case 3: goto L67;
                case 4: goto L65;
                case 5: goto L49;
                case 6: goto L41;
                case 7: goto L30;
                case 8: goto L21;
                case 9: goto L8;
                case 10: goto L7;
                case 11: goto L6;
                case 12: goto L5;
                default: goto L122;
            };
        L5:
            TrustAgentWrapper.m8665$$Nest$fputmTrusted(this.this$0, false);
            TrustAgentWrapper.m8664$$Nest$fputmTrustable(this.this$0, false);
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).updateTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), 0);
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).lockUser(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0));
            return;
        L6:
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).showKeyguardErrorMessage(r19.getData().getCharSequence(TrustAgentWrapper.DATA_MESSAGE));
            return;
        L7:
            long r5 = r19.getData().getLong(TrustAgentWrapper.DATA_HANDLE);
            int r0 = r19.getData().getInt(TrustAgentWrapper.DATA_USER_ID);
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).unlockUserWithToken(r5, r19.getData().getByteArray(TrustAgentWrapper.DATA_ESCROW_TOKEN), r0);
            return;
        L8:
            long r3 = r19.getData().getLong(TrustAgentWrapper.DATA_HANDLE);
            boolean r6 = TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).isEscrowTokenActive(r3, r19.getData().getInt(TrustAgentWrapper.DATA_USER_ID));
        L17:
            e = move-exception;
            TrustAgentWrapper.m8668$$Nest$monError(this.this$0, e);
            return;
        L10:
            if (TrustAgentWrapper.m8651$$Nest$fgetmTrustAgentService(this.this$0) == null) goto L123;
            ITrustAgentService r1 = TrustAgentWrapper.m8651$$Nest$fgetmTrustAgentService(this.this$0);     // Catch: RemoteException -> L17
            if (r6 == true) goto L15;
            r10 = 0;
        L15:
            r1.onTokenStateReceived(r3, r10);     // Catch: RemoteException -> L17
            return;
        L123:
            return;
        L21:
            long r4 = r19.getData().getLong(TrustAgentWrapper.DATA_HANDLE);
            boolean r7 = TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).removeEscrowToken(r4, r19.getData().getInt(TrustAgentWrapper.DATA_USER_ID));
        L26:
            e = move-exception;
            TrustAgentWrapper.m8668$$Nest$monError(this.this$0, e);
            return;
        L23:
            if (TrustAgentWrapper.m8651$$Nest$fgetmTrustAgentService(this.this$0) == null) goto L125;
            TrustAgentWrapper.m8651$$Nest$fgetmTrustAgentService(this.this$0).onEscrowTokenRemoved(r4, r7);     // Catch: RemoteException -> L26
            return;
        L125:
            return;
        L30:
            byte[] r8 = r19.getData().getByteArray(TrustAgentWrapper.DATA_ESCROW_TOKEN);
            int r12 = r19.getData().getInt(TrustAgentWrapper.DATA_USER_ID);
            long r13 = TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).addEscrowToken(r8, r12);
            boolean r14 = false;
        L35:
            e = move-exception;
            TrustAgentWrapper.m8668$$Nest$monError(this.this$0, e);
        L39:
            if (r14 == true) goto L112;
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).removeEscrowToken(r13, r12);
            return;
        L112:
            return;
        L32:
            if (TrustAgentWrapper.m8651$$Nest$fgetmTrustAgentService(this.this$0) == null) goto L39;
            TrustAgentWrapper.m8651$$Nest$fgetmTrustAgentService(this.this$0).onEscrowTokenAdded(r8, r13, UserHandle.of(r12));     // Catch: RemoteException -> L35
            r14 = true;
            goto L39
        L41:
            TrustAgentWrapper r2 = this.this$0;
            if (r19.arg1 != 0) goto L45;
            r11 = false;
        L45:
            TrustAgentWrapper.m8658$$Nest$fputmManagingTrust(r2, r11);
            if (TrustAgentWrapper.m8645$$Nest$fgetmManagingTrust(this.this$0) == true) goto L48;
            TrustAgentWrapper.m8665$$Nest$fputmTrusted(this.this$0, false);
            TrustAgentWrapper.m8657$$Nest$fputmDisplayTrustGrantedMessage(this.this$0, false);
            TrustAgentWrapper.m8659$$Nest$fputmMessage(this.this$0, null);
        L48:
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).mArchive.logManagingTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0), TrustAgentWrapper.m8645$$Nest$fgetmManagingTrust(this.this$0));
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).updateTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), 0);
            return;
        L49:
            IBinder r15 = (IBinder) r19.obj;
            if (r19.arg1 != 0) goto L54;
            r9 = 0;
        L54:
            if (TrustAgentWrapper.m8650$$Nest$fgetmSetTrustAgentFeaturesToken(this.this$0) != r15) goto L63;
            TrustAgentWrapper.m8661$$Nest$fputmSetTrustAgentFeaturesToken(this.this$0, null);
            if (TrustAgentWrapper.m8652$$Nest$fgetmTrustDisabledByDpm(this.this$0) == false) goto L115;
            if (r9 != 0) goto L59;
            return;
        L59:
            if (TrustAgentWrapper.m8673$$Nest$sfgetDEBUG() == false) goto L61;
            Slog.d(TrustAgentWrapper.TAG, "Re-enabling agent because it acknowledged enabled features: " + TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0).flattenToShortString());
        L61:
            TrustAgentWrapper.m8663$$Nest$fputmTrustDisabledByDpm(this.this$0, false);
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).updateTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), 0);
            return;
        L115:
            return;
        L63:
            if (TrustAgentWrapper.m8673$$Nest$sfgetDEBUG() == false) goto L118;
            Slog.w(TrustAgentWrapper.TAG, "Ignoring MSG_SET_TRUST_AGENT_FEATURES_COMPLETED with obsolete token: " + TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0).flattenToShortString());
            return;
        L118:
            return;
        L65:
            Slog.w(TrustAgentWrapper.TAG, "Connection attempt to agent " + TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0).flattenToShortString() + " timed out, rebinding");
            this.this$0.destroy();
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).resetAgent(TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0), TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0));
            return;
        L70:
            TrustAgentWrapper.m8665$$Nest$fputmTrusted(this.this$0, false);
            TrustAgentWrapper.m8664$$Nest$fputmTrustable(this.this$0, false);
            TrustAgentWrapper.m8666$$Nest$fputmWaitingForTrustableDowngrade(this.this$0, false);
            TrustAgentWrapper.m8657$$Nest$fputmDisplayTrustGrantedMessage(this.this$0, false);
            TrustAgentWrapper.m8659$$Nest$fputmMessage(this.this$0, null);
            TrustAgentWrapper.m8644$$Nest$fgetmHandler(this.this$0).removeMessages(3);
            if (r19.what != 2) goto L73;
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).mArchive.logRevokeTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0));
        L73:
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).updateTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), 0);
            return;
        L122:
            return;
        L67:
            if (TrustAgentWrapper.m8673$$Nest$sfgetDEBUG() == false) goto L69;
            Slog.d(TrustAgentWrapper.TAG, "Trust timed out : " + TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0).flattenToShortString());
        L69:
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).mArchive.logTrustTimeout(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0));
            TrustAgentWrapper.m8669$$Nest$monTrustTimeout(this.this$0);
            goto L70
        L75:
            if (this.this$0.isConnected() == true) goto L78;
            Log.w(TrustAgentWrapper.TAG, "Agent is not connected, cannot grant trust: " + TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0).flattenToShortString());
            return;
        L78:
            TrustAgentWrapper.m8665$$Nest$fputmTrusted(this.this$0, true);
            TrustAgentWrapper.m8664$$Nest$fputmTrustable(this.this$0, false);
            Pair r16 = (Pair) r19.obj;
            TrustAgentWrapper.m8659$$Nest$fputmMessage(this.this$0, (CharSequence) r16.first);
            AndroidFuture<GrantTrustResult> r17 = (AndroidFuture) r16.second;
            int r18 = r19.arg1;
            TrustAgentWrapper r20 = this.this$0;
            if ((r18 & 8) == 0) goto L81;
            boolean r110 = true;
        L82:
            TrustAgentWrapper.m8657$$Nest$fputmDisplayTrustGrantedMessage(r20, r110);
            if ((r18 & 4) == 0) goto L85;
            TrustAgentWrapper.m8666$$Nest$fputmWaitingForTrustableDowngrade(this.this$0, true);
            r17.thenAccept(new TrustAgentWrapper$3$$ExternalSyntheticLambda0(this));
        L86:
            long r111 = r19.getData().getLong("duration");
            if (r111 > 0) goto L89;
        L95:
            TrustArchive r21 = TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).mArchive;
            int r22 = TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0);
            ComponentName r112 = TrustAgentWrapper.m8648$$Nest$fgetmName(this.this$0);
            if (TrustAgentWrapper.m8647$$Nest$fgetmMessage(this.this$0) == null) goto L98;
            String r113 = TrustAgentWrapper.m8647$$Nest$fgetmMessage(this.this$0).toString();
        L99:
            r21.logGrantTrust(r22, r112, r113, r111, r18);
            TrustAgentWrapper.m8653$$Nest$fgetmTrustManagerService(this.this$0).updateTrust(TrustAgentWrapper.m8654$$Nest$fgetmUserId(this.this$0), r18, r17);
            return;
        L98:
            r113 = null;
            goto L99
        L89:
            if (TrustAgentWrapper.m8646$$Nest$fgetmMaximumTimeToLock(this.this$0) == 0) goto L93;
            long r114 = Math.min(r111, TrustAgentWrapper.m8646$$Nest$fgetmMaximumTimeToLock(this.this$0));
            if (TrustAgentWrapper.m8673$$Nest$sfgetDEBUG() == false) goto L94;
            Slog.d(TrustAgentWrapper.TAG, "DPM lock timeout in effect. Timeout adjusted from " + r111 + " to " + r114);
        L94:
            long r23 = SystemClock.elapsedRealtime() + r114;
            TrustAgentWrapper.m8656$$Nest$fputmAlarmPendingIntent(this.this$0, PendingIntent.getBroadcast(TrustAgentWrapper.m8643$$Nest$fgetmContext(this.this$0), 0, TrustAgentWrapper.m8638$$Nest$fgetmAlarmIntent(this.this$0), AudioFormat.EVRCWB));
            TrustAgentWrapper.m8639$$Nest$fgetmAlarmManager(this.this$0).set(2, r23, TrustAgentWrapper.m8640$$Nest$fgetmAlarmPendingIntent(this.this$0));
            goto L95
        L93:
            r114 = r111;
            goto L94
        L85:
            TrustAgentWrapper.m8666$$Nest$fputmWaitingForTrustableDowngrade(this.this$0, false);
            goto L86
        L81:
            r110 = false;
            goto L82
        }

        private /* synthetic */ void lambda$handleMessage$0(GrantTrustResult result) {
            if (result.getStatus() != 1) goto L6;
            TrustAgentWrapper.m8672$$Nest$msetSecurityWindowTimer(this.this$0);
            return;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ Intent m8638$$Nest$fgetmAlarmIntent(TrustAgentWrapper r0) {
        return r0.mAlarmIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmManager, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlarmManager m8639$$Nest$fgetmAlarmManager(TrustAgentWrapper r0) {
        return r0.mAlarmManager;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmAlarmPendingIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ PendingIntent m8640$$Nest$fgetmAlarmPendingIntent(TrustAgentWrapper r0) {
        return r0.mAlarmPendingIntent;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmBound, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8641$$Nest$fgetmBound(TrustAgentWrapper r0) {
        return r0.mBound;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITrustAgentServiceCallback m8642$$Nest$fgetmCallback(TrustAgentWrapper r0) {
        return r0.mCallback;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8643$$Nest$fgetmContext(TrustAgentWrapper r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8644$$Nest$fgetmHandler(TrustAgentWrapper r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmManagingTrust, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8645$$Nest$fgetmManagingTrust(TrustAgentWrapper r0) {
        return r0.mManagingTrust;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMaximumTimeToLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m8646$$Nest$fgetmMaximumTimeToLock(TrustAgentWrapper r2) {
        return r2.mMaximumTimeToLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ CharSequence m8647$$Nest$fgetmMessage(TrustAgentWrapper r0) {
        return r0.mMessage;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmName, reason: not valid java name */
    static /* bridge */ /* synthetic */ ComponentName m8648$$Nest$fgetmName(TrustAgentWrapper r0) {
        return r0.mName;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmPendingSuccessfulUnlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8649$$Nest$fgetmPendingSuccessfulUnlock(TrustAgentWrapper r0) {
        return r0.mPendingSuccessfulUnlock;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmSetTrustAgentFeaturesToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ IBinder m8650$$Nest$fgetmSetTrustAgentFeaturesToken(TrustAgentWrapper r0) {
        return r0.mSetTrustAgentFeaturesToken;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustAgentService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ITrustAgentService m8651$$Nest$fgetmTrustAgentService(TrustAgentWrapper r0) {
        return r0.mTrustAgentService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustDisabledByDpm, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8652$$Nest$fgetmTrustDisabledByDpm(TrustAgentWrapper r0) {
        return r0.mTrustDisabledByDpm;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmTrustManagerService, reason: not valid java name */
    static /* bridge */ /* synthetic */ TrustManagerService m8653$$Nest$fgetmTrustManagerService(TrustAgentWrapper r0) {
        return r0.mTrustManagerService;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
    static /* bridge */ /* synthetic */ int m8654$$Nest$fgetmUserId(TrustAgentWrapper r0) {
        return r0.mUserId;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmWithinSecurityLockdownWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8655$$Nest$fgetmWithinSecurityLockdownWindow(TrustAgentWrapper r0) {
        return r0.mWithinSecurityLockdownWindow;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmAlarmPendingIntent, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8656$$Nest$fputmAlarmPendingIntent(TrustAgentWrapper r0, PendingIntent r1) {
        r0.mAlarmPendingIntent = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDisplayTrustGrantedMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8657$$Nest$fputmDisplayTrustGrantedMessage(TrustAgentWrapper r0, boolean r1) {
        r0.mDisplayTrustGrantedMessage = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmManagingTrust, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8658$$Nest$fputmManagingTrust(TrustAgentWrapper r0, boolean r1) {
        r0.mManagingTrust = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmMessage, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8659$$Nest$fputmMessage(TrustAgentWrapper r0, CharSequence r1) {
        r0.mMessage = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmPendingSuccessfulUnlock, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8660$$Nest$fputmPendingSuccessfulUnlock(TrustAgentWrapper r0, boolean r1) {
        r0.mPendingSuccessfulUnlock = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmSetTrustAgentFeaturesToken, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8661$$Nest$fputmSetTrustAgentFeaturesToken(TrustAgentWrapper r0, IBinder r1) {
        r0.mSetTrustAgentFeaturesToken = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTrustAgentService, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8662$$Nest$fputmTrustAgentService(TrustAgentWrapper r0, ITrustAgentService r1) {
        r0.mTrustAgentService = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTrustDisabledByDpm, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8663$$Nest$fputmTrustDisabledByDpm(TrustAgentWrapper r0, boolean r1) {
        r0.mTrustDisabledByDpm = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTrustable, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8664$$Nest$fputmTrustable(TrustAgentWrapper r0, boolean r1) {
        r0.mTrustable = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmTrusted, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8665$$Nest$fputmTrusted(TrustAgentWrapper r0, boolean r1) {
        r0.mTrusted = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWaitingForTrustableDowngrade, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8666$$Nest$fputmWaitingForTrustableDowngrade(TrustAgentWrapper r0, boolean r1) {
        r0.mWaitingForTrustableDowngrade = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmWithinSecurityLockdownWindow, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8667$$Nest$fputmWithinSecurityLockdownWindow(TrustAgentWrapper r0, boolean r1) {
        r0.mWithinSecurityLockdownWindow = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$monError, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8668$$Nest$monError(TrustAgentWrapper r0, Exception r1) {
        r0.onError(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monTrustTimeout, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8669$$Nest$monTrustTimeout(TrustAgentWrapper r0) {
        r0.onTrustTimeout();
    }

    /* JADX INFO: renamed from: -$$Nest$mscheduleRestart, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8670$$Nest$mscheduleRestart(TrustAgentWrapper r0) {
        r0.scheduleRestart();
    }

    /* JADX INFO: renamed from: -$$Nest$msetCallback, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8671$$Nest$msetCallback(TrustAgentWrapper r0, ITrustAgentServiceCallback r1) {
        r0.setCallback(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$msetSecurityWindowTimer, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8672$$Nest$msetSecurityWindowTimer(TrustAgentWrapper r0) {
        r0.setSecurityWindowTimer();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetDEBUG, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m8673$$Nest$sfgetDEBUG() {
        return DEBUG;
    }

    static {
        DEBUG = TrustManagerService.DEBUG;
    }

    public TrustAgentWrapper(Context context, TrustManagerService trustManagerService, Intent intent, UserHandle user) {
        this.mPendingSuccessfulUnlock = false;
        this.mWaitingForTrustableDowngrade = false;
        this.mWithinSecurityLockdownWindow = false;
        this.mTrustableDowngradeReceiver = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mHandler = new AnonymousClass3(this);
        this.mCallback = new AnonymousClass4(this);
        this.mConnection = new AnonymousClass5(this);
        this.mContext = context;
        this.mTrustManagerService = trustManagerService;
        this.mAlarmManager = (AlarmManager) this.mContext.getSystemService(HostingRecord.TRIGGER_TYPE_ALARM);
        this.mUserId = user.getIdentifier();
        this.mName = intent.getComponent();
        this.mAlarmIntent = new Intent(TRUST_EXPIRED_ACTION).putExtra(EXTRA_COMPONENT_NAME, this.mName);
        this.mAlarmIntent.setData(Uri.parse(this.mAlarmIntent.toUri(1)));
        this.mAlarmIntent.setPackage(context.getPackageName());
        IntentFilter alarmFilter = new IntentFilter(TRUST_EXPIRED_ACTION);
        alarmFilter.addDataScheme(this.mAlarmIntent.getScheme());
        String pathUri = this.mAlarmIntent.toUri(1);
        alarmFilter.addDataPath(pathUri, 0);
        IntentFilter trustableFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
        scheduleRestart();
        this.mBound = context.bindServiceAsUser(intent, this.mConnection, AudioFormat.AAC_MAIN, user);
        if (this.mBound == false) goto L5;
        this.mContext.registerReceiver(this.mBroadcastReceiver, alarmFilter, PERMISSION, null, 2);
        this.mContext.registerReceiver(this.mTrustableDowngradeReceiver, trustableFilter);
        return;
    L5:
        Log.e(TAG, "Can't bind to TrustAgent " + this.mName.flattenToShortString());
    }

    private void onError(Exception e) {
        Slog.w(TAG, "Exception ", e);
    }

    private void onTrustTimeout() {
    L6:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L13;
        this.mTrustAgentService.onTrustTimeout();     // Catch: RemoteException -> L6
        return;
    }

    public void onUnlockAttempt(boolean successful) {
    L5:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L7;
        this.mTrustAgentService.onUnlockAttempt(successful);     // Catch: RemoteException -> L5
    L11:
        return;
    L7:
        this.mPendingSuccessfulUnlock = successful;     // Catch: RemoteException -> L5
        goto L11
    }

    public void onUserRequestedUnlock(boolean dismissKeyguard) {
    L6:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L13;
        this.mTrustAgentService.onUserRequestedUnlock(dismissKeyguard);     // Catch: RemoteException -> L6
        return;
    }

    public void onUserMayRequestUnlock() {
    L6:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L13;
        this.mTrustAgentService.onUserMayRequestUnlock();     // Catch: RemoteException -> L6
        return;
    }

    public void onUnlockLockout(int timeoutMs) {
    L6:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L13;
        this.mTrustAgentService.onUnlockLockout(timeoutMs);     // Catch: RemoteException -> L6
        return;
    }

    public void onDeviceLocked() {
        this.mWithinSecurityLockdownWindow = false;
    L7:
        e = move-exception;
        onError(e);
        return;
    L4:
        if (this.mTrustAgentService == null) goto L14;
        this.mTrustAgentService.onDeviceLocked();     // Catch: RemoteException -> L7
        return;
    }

    public void onDeviceUnlocked() {
    L6:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L13;
        this.mTrustAgentService.onDeviceUnlocked();     // Catch: RemoteException -> L6
        return;
    }

    public void onEscrowTokenActivated(long handle, int userId) {
        if (DEBUG == false) goto L6;
        Slog.d(TAG, "onEscrowTokenActivated: " + handle + " user: " + userId);
    L6:
        if (this.mTrustAgentService == null) goto L14;
        this.mTrustAgentService.onTokenStateReceived(handle, 1);     // Catch: RemoteException -> L9
        return;
    L9:
        e = move-exception;
        onError(e);
        return;
    }

    private void setCallback(ITrustAgentServiceCallback callback) {
    L6:
        e = move-exception;
        onError(e);
        return;
    L3:
        if (this.mTrustAgentService == null) goto L13;
        this.mTrustAgentService.setCallback(callback);     // Catch: RemoteException -> L6
        return;
    }

    boolean updateDevicePolicyFeatures() {
        boolean trustDisabled = false;
        if (DEBUG == false) goto L34;
        Slog.d(TAG, "updateDevicePolicyFeatures(" + this.mName + ")");
    L34:
    L12:
        e = move-exception;
        onError(e);
    L31:
        if (this.mTrustDisabledByDpm == trustDisabled) goto L33;
        this.mTrustDisabledByDpm = trustDisabled;
        this.mTrustManagerService.updateTrust(this.mUserId, 0);
    L33:
        return trustDisabled;
    L6:
        if (this.mTrustAgentService == null) goto L31;
        DevicePolicyManager dpm = (DevicePolicyManager) this.mContext.getSystemService("device_policy");     // Catch: RemoteException -> L12
        if ((dpm.getKeyguardDisabledFeatures(null, this.mUserId) & 16) == 0) goto L22;
        List<PersistableBundle> config = dpm.getTrustAgentConfiguration(null, this.mName, this.mUserId);     // Catch: RemoteException -> L12
        trustDisabled = true;
        if (DEBUG == false) goto L14;
        Slog.d(TAG, "Detected trust agents disabled. Config = " + config);     // Catch: RemoteException -> L12
    L14:
        if (config == null) goto L23;
        if (config.size() <= 0) goto L23;
        if (DEBUG == false) goto L20;
        Slog.d(TAG, "TrustAgent " + this.mName.flattenToShortString() + " disabled until it acknowledges " + config);     // Catch: RemoteException -> L12
    L20:
        this.mSetTrustAgentFeaturesToken = new Binder();     // Catch: RemoteException -> L12
        this.mTrustAgentService.onConfigure(config, this.mSetTrustAgentFeaturesToken);     // Catch: RemoteException -> L12
    L23:
        long maxTimeToLock = dpm.getMaximumTimeToLock(null, this.mUserId);     // Catch: RemoteException -> L12
        if (maxTimeToLock == this.mMaximumTimeToLock) goto L31;
        this.mMaximumTimeToLock = maxTimeToLock;     // Catch: RemoteException -> L12
        if (this.mAlarmPendingIntent == null) goto L31;
        this.mAlarmManager.cancel(this.mAlarmPendingIntent);     // Catch: RemoteException -> L12
        this.mAlarmPendingIntent = null;     // Catch: RemoteException -> L12
        this.mHandler.sendEmptyMessage(3);     // Catch: RemoteException -> L12
        goto L31
    L22:
        this.mTrustAgentService.onConfigure(Collections.EMPTY_LIST, null);     // Catch: RemoteException -> L12
        goto L23
    }

    public boolean isTrusted() {
        if (this.mTrusted == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mManagingTrust == false) goto L9;
        if (this.mTrustDisabledByDpm == true) goto L9;
        return true;
    }

    public boolean isTrustable() {
        if (this.mTrustable == true) goto L5;
    L9:
        return false;
    L5:
        if (this.mManagingTrust == false) goto L9;
        if (this.mTrustDisabledByDpm == true) goto L9;
        return true;
    }

    public boolean isTrustableOrWaitingForDowngrade() {
        if (this.mWaitingForTrustableDowngrade == false) goto L5;
    L8:
        return true;
    L5:
        if (isTrustable() == true) goto L8;
        return false;
    }

    public void setUntrustable() {
        this.mTrustable = false;
    }

    public void downgradeToTrustable() {
        if (this.mWaitingForTrustableDowngrade == false) goto L6;
        this.mWaitingForTrustableDowngrade = false;
        this.mTrusted = false;
        this.mTrustable = true;
        this.mTrustManagerService.updateTrust(this.mUserId, 0);
        return;
    }

    private void setSecurityWindowTimer() {
        this.mWithinSecurityLockdownWindow = true;
        long expiration = SystemClock.elapsedRealtime() + 15000;
        this.mAlarmManager.setExact(2, expiration, TAG, new AnonymousClass6(this), Handler.getMain());
    }

    public boolean isManagingTrust() {
        if (this.mManagingTrust == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mTrustDisabledByDpm == true) goto L7;
        return true;
    }

    public CharSequence getMessage() {
        return this.mMessage;
    }

    public boolean shouldDisplayTrustGrantedMessage() {
        return this.mDisplayTrustGrantedMessage;
    }

    public void destroy() {
        this.mHandler.removeMessages(4);
        if (this.mBound == true) goto L6;
        return;
    L6:
        if (DEBUG == false) goto L8;
        Slog.d(TAG, "TrustAgent unbound : " + this.mName.flattenToShortString());
    L8:
        this.mTrustManagerService.mArchive.logAgentStopped(this.mUserId, this.mName);
        this.mContext.unbindService(this.mConnection);
        this.mBound = false;
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        this.mContext.unregisterReceiver(this.mTrustableDowngradeReceiver);
        this.mTrustAgentService = null;
        this.mSetTrustAgentFeaturesToken = null;
        this.mHandler.sendEmptyMessage(2);
    }

    public boolean isConnected() {
        if (this.mTrustAgentService == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isBound() {
        return this.mBound;
    }

    public long getScheduledRestartUptimeMillis() {
        return this.mScheduledRestartUptimeMillis;
    }

    private void scheduleRestart() {
        this.mHandler.removeMessages(4);
        this.mScheduledRestartUptimeMillis = SystemClock.uptimeMillis() + 300000;
        this.mHandler.sendEmptyMessageAtTime(4, this.mScheduledRestartUptimeMillis);
    }
}
