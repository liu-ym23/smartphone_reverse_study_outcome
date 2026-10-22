package com.stepos.core.ability.speech;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsOrchestrator implements h7.d {
    private final /* synthetic */ SpeechCloudOrchestrator $$delegate_0;

    public TtsOrchestrator(boolean z, boolean z3, zb.a<Boolean> isLoggedIn) {
        kotlin.jvm.internal.g.f(isLoggedIn, "isLoggedIn");
        this.$$delegate_0 = new SpeechCloudOrchestrator(z, z3, "TtsOrchestrator", "TTS", isLoggedIn, null, 32, null);
    }

    @Override // h7.d
    public <T> Object makeDecision(T t8, String str, h7.b bVar, qb.b<? super h7.e> bVar2) {
        return this.$$delegate_0.makeDecision(t8, str, bVar, bVar2);
    }
}
