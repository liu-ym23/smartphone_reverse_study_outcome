package com.stepos.stepclaw.memory.embedding;

import com.stepos.stepclaw.memory.embedding.EmbeddingQueue;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1578a;

    public /* synthetic */ a(int i8) {
        this.f1578a = i8;
    }

    @Override // p5.a
    public final Object invoke() {
        switch (this.f1578a) {
            case 0:
                return EmbedResponse._childSerializers$_anonymous_();
            case 1:
                return EmbedResponseItem._childSerializers$_anonymous_();
            default:
                return EmbeddingQueue.C00421.invokeSuspend$lambda$0();
        }
    }
}
