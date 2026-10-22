package org.bouncycastle.crypto.agreement.ecjpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Exceptions;
import p7.d;
import p7.r;

/* loaded from: classes.dex */
public class ECJPAKEParticipant {
    public static final int STATE_INITIALIZED = 0;
    public static final int STATE_KEY_CALCULATED = 50;
    public static final int STATE_ROUND_1_CREATED = 10;
    public static final int STATE_ROUND_1_VALIDATED = 20;
    public static final int STATE_ROUND_2_CREATED = 30;
    public static final int STATE_ROUND_2_VALIDATED = 40;
    public static final int STATE_ROUND_3_CREATED = 60;
    public static final int STATE_ROUND_3_VALIDATED = 70;

    /* renamed from: b, reason: collision with root package name */
    private r f4376b;
    private final Digest digest;
    private d ecCurve;

    /* renamed from: g, reason: collision with root package name */
    private r f4377g;
    private r gx1;
    private r gx2;
    private r gx3;
    private r gx4;

    /* renamed from: h, reason: collision with root package name */
    private BigInteger f4378h;

    /* renamed from: n, reason: collision with root package name */
    private BigInteger f4379n;
    private final String participantId;
    private String partnerParticipantId;
    private char[] password;

    /* renamed from: q, reason: collision with root package name */
    private BigInteger f4380q;
    private final SecureRandom random;
    private int state;

    /* renamed from: x1, reason: collision with root package name */
    private BigInteger f4381x1;

    /* renamed from: x2, reason: collision with root package name */
    private BigInteger f4382x2;

    public ECJPAKEParticipant(String str, char[] cArr) {
        this(str, cArr, ECJPAKECurves.NIST_P256);
    }

    private BigInteger calculateS() {
        try {
            return ECJPAKEUtil.calculateS(this.f4379n, this.password);
        } catch (CryptoException e9) {
            throw Exceptions.illegalStateException(e9.getMessage(), e9);
        }
    }

    public BigInteger calculateKeyingMaterial() {
        int i8 = this.state;
        if (i8 >= 50) {
            throw new IllegalStateException("Key already calculated for " + this.participantId);
        }
        if (i8 < 40) {
            throw new IllegalStateException("Round2 payload must be validated prior to creating key for " + this.participantId);
        }
        BigInteger bigIntegerCalculateS = calculateS();
        Arrays.fill(this.password, (char) 0);
        this.password = null;
        BigInteger bigIntegerCalculateKeyingMaterial = ECJPAKEUtil.calculateKeyingMaterial(this.f4379n, this.gx4, this.f4382x2, bigIntegerCalculateS, this.f4376b);
        this.f4381x1 = null;
        this.f4382x2 = null;
        this.f4376b = null;
        this.state = 50;
        return bigIntegerCalculateKeyingMaterial;
    }

    public ECJPAKERound1Payload createRound1PayloadToSend() {
        if (this.state >= 10) {
            throw new IllegalStateException("Round1 payload already created for " + this.participantId);
        }
        this.f4381x1 = ECJPAKEUtil.generateX1(this.f4379n, this.random);
        this.f4382x2 = ECJPAKEUtil.generateX1(this.f4379n, this.random);
        this.gx1 = ECJPAKEUtil.calculateGx(this.f4377g, this.f4381x1);
        this.gx2 = ECJPAKEUtil.calculateGx(this.f4377g, this.f4382x2);
        ECSchnorrZKP eCSchnorrZKPCalculateZeroKnowledgeProof = ECJPAKEUtil.calculateZeroKnowledgeProof(this.f4377g, this.f4379n, this.f4381x1, this.gx1, this.digest, this.participantId, this.random);
        ECSchnorrZKP eCSchnorrZKPCalculateZeroKnowledgeProof2 = ECJPAKEUtil.calculateZeroKnowledgeProof(this.f4377g, this.f4379n, this.f4382x2, this.gx2, this.digest, this.participantId, this.random);
        this.state = 10;
        return new ECJPAKERound1Payload(this.participantId, this.gx1, this.gx2, eCSchnorrZKPCalculateZeroKnowledgeProof, eCSchnorrZKPCalculateZeroKnowledgeProof2);
    }

    public ECJPAKERound2Payload createRound2PayloadToSend() {
        int i8 = this.state;
        if (i8 >= 30) {
            throw new IllegalStateException("Round2 payload already created for " + this.participantId);
        }
        if (i8 < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to creating Round2 payload for " + this.participantId);
        }
        r rVarCalculateGA = ECJPAKEUtil.calculateGA(this.gx1, this.gx3, this.gx4);
        BigInteger bigIntegerCalculateX2s = ECJPAKEUtil.calculateX2s(this.f4379n, this.f4382x2, calculateS());
        r rVarCalculateA = ECJPAKEUtil.calculateA(rVarCalculateGA, bigIntegerCalculateX2s);
        ECSchnorrZKP eCSchnorrZKPCalculateZeroKnowledgeProof = ECJPAKEUtil.calculateZeroKnowledgeProof(rVarCalculateGA, this.f4379n, bigIntegerCalculateX2s, rVarCalculateA, this.digest, this.participantId, this.random);
        this.state = 30;
        return new ECJPAKERound2Payload(this.participantId, rVarCalculateA, eCSchnorrZKPCalculateZeroKnowledgeProof);
    }

    public ECJPAKERound3Payload createRound3PayloadToSend(BigInteger bigInteger) {
        int i8 = this.state;
        if (i8 >= 60) {
            throw new IllegalStateException("Round3 payload already created for " + this.participantId);
        }
        if (i8 >= 50) {
            BigInteger bigIntegerCalculateMacTag = ECJPAKEUtil.calculateMacTag(this.participantId, this.partnerParticipantId, this.gx1, this.gx2, this.gx3, this.gx4, bigInteger, this.digest);
            this.state = 60;
            return new ECJPAKERound3Payload(this.participantId, bigIntegerCalculateMacTag);
        }
        throw new IllegalStateException("Keying material must be calculated prior to creating Round3 payload for " + this.participantId);
    }

    public int getState() {
        return this.state;
    }

    public void validateRound1PayloadReceived(ECJPAKERound1Payload eCJPAKERound1Payload) throws CryptoException {
        if (this.state >= 20) {
            throw new IllegalStateException("Validation already attempted for round1 payload for" + this.participantId);
        }
        this.partnerParticipantId = eCJPAKERound1Payload.getParticipantId();
        this.gx3 = eCJPAKERound1Payload.getGx1();
        this.gx4 = eCJPAKERound1Payload.getGx2();
        ECSchnorrZKP knowledgeProofForX1 = eCJPAKERound1Payload.getKnowledgeProofForX1();
        ECSchnorrZKP knowledgeProofForX2 = eCJPAKERound1Payload.getKnowledgeProofForX2();
        ECJPAKEUtil.validateParticipantIdsDiffer(this.participantId, eCJPAKERound1Payload.getParticipantId());
        ECJPAKEUtil.validateZeroKnowledgeProof(this.f4377g, this.gx3, knowledgeProofForX1, this.f4380q, this.f4379n, this.ecCurve, this.f4378h, eCJPAKERound1Payload.getParticipantId(), this.digest);
        ECJPAKEUtil.validateZeroKnowledgeProof(this.f4377g, this.gx4, knowledgeProofForX2, this.f4380q, this.f4379n, this.ecCurve, this.f4378h, eCJPAKERound1Payload.getParticipantId(), this.digest);
        this.state = 20;
    }

    public void validateRound2PayloadReceived(ECJPAKERound2Payload eCJPAKERound2Payload) throws CryptoException {
        int i8 = this.state;
        if (i8 >= 40) {
            throw new IllegalStateException("Validation already attempted for round2 payload for" + this.participantId);
        }
        if (i8 < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to validating Round2 payload for " + this.participantId);
        }
        r rVarCalculateGA = ECJPAKEUtil.calculateGA(this.gx3, this.gx1, this.gx2);
        this.f4376b = eCJPAKERound2Payload.getA();
        ECSchnorrZKP knowledgeProofForX2s = eCJPAKERound2Payload.getKnowledgeProofForX2s();
        ECJPAKEUtil.validateParticipantIdsDiffer(this.participantId, eCJPAKERound2Payload.getParticipantId());
        ECJPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, eCJPAKERound2Payload.getParticipantId());
        ECJPAKEUtil.validateZeroKnowledgeProof(rVarCalculateGA, this.f4376b, knowledgeProofForX2s, this.f4380q, this.f4379n, this.ecCurve, this.f4378h, eCJPAKERound2Payload.getParticipantId(), this.digest);
        this.state = 40;
    }

    public void validateRound3PayloadReceived(ECJPAKERound3Payload eCJPAKERound3Payload, BigInteger bigInteger) throws CryptoException {
        int i8 = this.state;
        if (i8 >= 70) {
            throw new IllegalStateException("Validation already attempted for round3 payload for" + this.participantId);
        }
        if (i8 < 50) {
            throw new IllegalStateException("Keying material must be calculated validated prior to validating Round3 payload for " + this.participantId);
        }
        ECJPAKEUtil.validateParticipantIdsDiffer(this.participantId, eCJPAKERound3Payload.getParticipantId());
        ECJPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, eCJPAKERound3Payload.getParticipantId());
        ECJPAKEUtil.validateMacTag(this.participantId, this.partnerParticipantId, this.gx1, this.gx2, this.gx3, this.gx4, bigInteger, this.digest, eCJPAKERound3Payload.getMacTag());
        this.gx1 = null;
        this.gx2 = null;
        this.gx3 = null;
        this.gx4 = null;
        this.state = 70;
    }

    public ECJPAKEParticipant(String str, char[] cArr, ECJPAKECurve eCJPAKECurve) {
        this(str, cArr, eCJPAKECurve, SHA256Digest.newInstance(), CryptoServicesRegistrar.getSecureRandom());
    }

    public ECJPAKEParticipant(String str, char[] cArr, ECJPAKECurve eCJPAKECurve, Digest digest, SecureRandom secureRandom) {
        ECJPAKEUtil.validateNotNull(str, "participantId");
        ECJPAKEUtil.validateNotNull(cArr, "password");
        ECJPAKEUtil.validateNotNull(eCJPAKECurve, "curve params");
        ECJPAKEUtil.validateNotNull(digest, "digest");
        ECJPAKEUtil.validateNotNull(secureRandom, "random");
        if (cArr.length == 0) {
            throw new IllegalArgumentException("Password must not be empty.");
        }
        this.participantId = str;
        this.password = Arrays.copyOf(cArr, cArr.length);
        this.ecCurve = eCJPAKECurve.getCurve();
        this.f4377g = eCJPAKECurve.getG();
        this.f4378h = eCJPAKECurve.getH();
        this.f4379n = eCJPAKECurve.getN();
        this.f4380q = eCJPAKECurve.getQ();
        this.digest = digest;
        this.random = secureRandom;
        this.state = 0;
    }
}
