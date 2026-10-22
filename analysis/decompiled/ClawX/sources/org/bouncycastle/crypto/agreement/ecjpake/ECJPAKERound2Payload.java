package org.bouncycastle.crypto.agreement.ecjpake;

import p7.r;

/* loaded from: classes.dex */
public class ECJPAKERound2Payload {

    /* renamed from: a, reason: collision with root package name */
    private final r f4383a;
    private final ECSchnorrZKP knowledgeProofForX2s;
    private final String participantId;

    public ECJPAKERound2Payload(String str, r rVar, ECSchnorrZKP eCSchnorrZKP) {
        ECJPAKEUtil.validateNotNull(str, "participantId");
        ECJPAKEUtil.validateNotNull(rVar, "a");
        ECJPAKEUtil.validateNotNull(eCSchnorrZKP, "knowledgeProofForX2s");
        this.participantId = str;
        this.f4383a = rVar;
        this.knowledgeProofForX2s = eCSchnorrZKP;
    }

    public r getA() {
        return this.f4383a;
    }

    public ECSchnorrZKP getKnowledgeProofForX2s() {
        return this.knowledgeProofForX2s;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
