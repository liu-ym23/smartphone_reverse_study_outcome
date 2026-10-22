package com.android.server.security;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.security.attestationverification.AttestationProfile;
import android.security.attestationverification.IVerificationResult;
import android.text.TextUtils;
import android.util.IndentingPrintWriter;
import android.util.Slog;
import android.util.TimeUtils;
import com.android.internal.infra.AndroidFuture;
import com.android.server.SystemService;
import java.util.ArrayDeque;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class AttestationVerificationManagerService extends SystemService {
    private static final int DUMP_EVENT_LOG_SIZE = 10;
    private static final String TAG = "AVF";
    private final DumpLogger mDumpLogger;
    private final AttestationVerificationPeerDeviceVerifier mPeerDeviceVerifier;
    private final IBinder mService;

    static abstract class DumpData {
        protected int mEventNumber;
        protected long mEventTimeMs;

        abstract void dumpTo(IndentingPrintWriter r1);

        DumpData() {
            this.mEventNumber = -1;
            this.mEventTimeMs = -1;
        }
    }

    static class DumpLogger {
        private final ArrayDeque<DumpData> mData;
        private int mEventsLogged;

        DumpLogger() {
            this.mData = new ArrayDeque(10);
            this.mEventsLogged = 0;
        }

        void logAttempt(DumpData data) {
            ArrayDeque<DumpData> r0 = this.mData;
            monitor-enter(r0);
        L7:
            th = move-exception;
            throw th;
        L5:
            if (this.mData.size() != 10) goto L9;
            this.mData.removeFirst();     // Catch: Throwable -> L7
        L9:
            this.mEventsLogged++;     // Catch: Throwable -> L7
            data.mEventNumber = this.mEventsLogged;     // Catch: Throwable -> L7
            data.mEventTimeMs = System.currentTimeMillis();     // Catch: Throwable -> L7
            this.mData.add(data);     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
        }

        void dumpTo(IndentingPrintWriter writer) {
            ArrayDeque<DumpData> r0 = this.mData;
            monitor-enter(r0);
            Iterator r1 = this.mData.reversed().iterator();     // Catch: Throwable -> L8
        L6:
            if (r1.hasNext() == false) goto L10;
            DumpData data = (DumpData) r1.next();     // Catch: Throwable -> L8
            writer.println(TextUtils.formatSimple("Verification #%d [%s]", new Object[]{Integer.valueOf(data.mEventNumber), TimeUtils.formatForLogging(data.mEventTimeMs)}));     // Catch: Throwable -> L8
            writer.increaseIndent();     // Catch: Throwable -> L8
            data.dumpTo(writer);     // Catch: Throwable -> L8
            writer.decreaseIndent();     // Catch: Throwable -> L8
            goto L6
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDumpLogger, reason: not valid java name */
    static /* bridge */ /* synthetic */ DumpLogger m8023$$Nest$fgetmDumpLogger(AttestationVerificationManagerService r0) {
        return r0.mDumpLogger;
    }

    /* JADX INFO: renamed from: -$$Nest$mverifyAttestationForAllVerifiers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m8024$$Nest$mverifyAttestationForAllVerifiers(AttestationVerificationManagerService r0, AttestationProfile r1, int r2, Bundle r3, byte[] r4, AndroidFuture r5) {
        r0.verifyAttestationForAllVerifiers(r1, r2, r3, r4, r5);
    }

    public AttestationVerificationManagerService(Context context) throws Exception {
        super(context);
        this.mDumpLogger = new DumpLogger();
        this.mService = new AnonymousClass1(this);
        this.mPeerDeviceVerifier = new AttestationVerificationPeerDeviceVerifier(context, this.mDumpLogger);
    }

    private void verifyAttestationForAllVerifiers(AttestationProfile profile, int localBindingType, Bundle requirements, byte[] attestation, AndroidFuture<IVerificationResult> resultCallback) {
        IVerificationResult result = new IVerificationResult();
        result.token = null;
        int profileId = profile.getAttestationProfileId();
        switch(profileId) {
            case 2: goto L6;
            case 3: goto L5;
            default: goto L4;
        };
    L4:
        Slog.e(TAG, "Profile [" + profileId + "] is not supported.");
        result.resultCode = 2;
    L11:
        resultCallback.complete(result);
        return;
    L5:
        Slog.d(TAG, "Verifying Peer Device profile.");
        result.resultCode = this.mPeerDeviceVerifier.verifyAttestation(localBindingType, requirements, attestation);
        goto L11
    L6:
        Slog.d(TAG, "Verifying Self Trusted profile.");
        result.resultCode = AttestationVerificationSelfTrustedVerifierForTesting.getInstance().verifyAttestation(localBindingType, requirements, attestation);     // Catch: Throwable -> L9
    L10:
        result.resultCode = 4;
        goto L11
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        Slog.d(TAG, "Started");
        publishBinderService("attestation_verification", this.mService);
    }
}
