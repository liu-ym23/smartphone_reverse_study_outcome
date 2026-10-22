package com.stepos.core.ability.speech;

import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public /* synthetic */ class AsrAbility$localStreamManager$1 extends FunctionReferenceImpl implements zb.a<e7.a> {
    public AsrAbility$localStreamManager$1(Object obj) {
        super(0, obj, AsrAbility.class, "requireAudioProtocol", "requireAudioProtocol()Lcom/stepos/base/protocol/AudioProtocol;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // zb.a
    public final e7.a invoke() {
        return ((AsrAbility) this.receiver).requireAudioProtocol();
    }
}
