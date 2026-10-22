package org.bouncycastle.crypto.agreement.ecjpake;

import p7.r;

/* loaded from: classes.dex */
public class ECJPAKERound1Payload {
    private final r gx1;
    private final r gx2;
    private final ECSchnorrZKP knowledgeProofForX1;
    private final ECSchnorrZKP knowledgeProofForX2;
    private final String participantId;

    public ECJPAKERound1Payload(String str, r rVar, r rVar2, ECSchnorrZKP eCSchnorrZKP, ECSchnorrZKP eCSchnorrZKP2) {
        ECJPAKEUtil.validateNotNull(str, "participantId");
        ECJPAKEUtil.validateNotNull(rVar, "gx1");
        ECJPAKEUtil.validateNotNull(rVar2, "gx2");
        ECJPAKEUtil.validateNotNull(eCSchnorrZKP, "knowledgeProofForX1");
        ECJPAKEUtil.validateNotNull(eCSchnorrZKP2, "knowledgeProofForX2");
        this.participantId = str;
        this.gx1 = rVar;
        this.gx2 = rVar2;
        this.knowledgeProofForX1 = eCSchnorrZKP;
        this.knowledgeProofForX2 = eCSchnorrZKP2;
    }

    public r getGx1() {
        return this.gx1;
    }

    public r getGx2() {
        return this.gx2;
    }

    public ECSchnorrZKP getKnowledgeProofForX1() {
        return this.knowledgeProofForX1;
    }

    public ECSchnorrZKP getKnowledgeProofForX2() {
        return this.knowledgeProofForX2;
    }

    public String getParticipantId() {
        return this.participantId;
    }
}
