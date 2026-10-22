package com.android.server.companion.securechannel;

import android.content.Context;
import android.os.Bundle;
import android.security.attestationverification.AttestationProfile;
import android.security.attestationverification.AttestationVerificationManager;
import android.security.attestationverification.VerificationToken;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

/* JADX INFO: loaded from: classes.dex */
public class AttestationVerifier {
    private static final long ATTESTATION_VERIFICATION_TIMEOUT_SECONDS = 10;
    private static final int EXTENDED_PATCH_LEVEL_DIFF_MONTHS = 24;
    private static final String PARAM_OWNED_BY_SYSTEM = "android.key_owned_by_system";
    private final Context mContext;
    private final int mFlags;

    /* JADX INFO: renamed from: $r8$lambda$SWA86q1x1-gVSEC7t4whGdO3b5k, reason: not valid java name */
    public static /* synthetic */ void m2969$r8$lambda$SWA86q1x1gVSEC7t4whGdO3b5k(AtomicInteger r0, CountDownLatch r1, Integer r2, VerificationToken r3) {
        lambda$verifyAttestation$0(r0, r1, r2, r3);
    }

    AttestationVerifier(Context context, int flags) {
        this.mContext = context;
        this.mFlags = flags;
    }

    public int verifyAttestation(byte[] remoteAttestation, byte[] attestationChallenge) throws SecureChannelException {
        Bundle requirements = new Bundle();
        requirements.putByteArray("localbinding.challenge", attestationChallenge);
        requirements.putBoolean(PARAM_OWNED_BY_SYSTEM, true);
        updateRequirements(requirements);
        final AtomicInteger verificationResult = new AtomicInteger(0);
        final CountDownLatch verificationFinished = new CountDownLatch(1);
        BiConsumer<Integer, VerificationToken> onVerificationResult = new AttestationVerifier$$ExternalSyntheticLambda0(verificationResult, verificationFinished);
        ((AttestationVerificationManager) this.mContext.getSystemService(AttestationVerificationManager.class)).verifyAttestation(new AttestationProfile(3), 3, requirements, remoteAttestation, new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), onVerificationResult);
        boolean finished = verificationFinished.await(ATTESTATION_VERIFICATION_TIMEOUT_SECONDS, TimeUnit.SECONDS);     // Catch: InterruptedException -> L9
        if (finished == false) goto L8;
        return verificationResult.get();
    L8:
        throw new SecureChannelException("Attestation verification timed out.");
    L9:
        e = move-exception;
        throw new SecureChannelException("Attestation verification was interrupted", e);
    }

    private static /* synthetic */ void lambda$verifyAttestation$0(AtomicInteger verificationResult, CountDownLatch verificationFinished, Integer result, VerificationToken token) {
        verificationResult.set(result.intValue());
        verificationFinished.countDown();
    }

    private void updateRequirements(Bundle requirements) {
        if (this.mFlags != 0) goto L6;
        return;
    L6:
        if ((this.mFlags & 1) <= 0) goto L9;
        requirements.putInt("param_max_patch_level_diff_months", 24);
        return;
    }
}
