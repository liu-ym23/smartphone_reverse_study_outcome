package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import java.util.function.LongConsumer;
import reactor.core.publisher.BaseSubscriber;

/* loaded from: classes2.dex */
public final /* synthetic */ class B implements LongConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4649a;
    public final /* synthetic */ Z9.e b;
    public final /* synthetic */ BaseSubscriber c;

    public /* synthetic */ B(BaseSubscriber baseSubscriber, Z9.e eVar, int i) {
        this.f4649a = i;
        this.c = baseSubscriber;
        this.b = eVar;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j5) {
        switch (this.f4649a) {
            case 0:
                ((ResponseSubscribers.AggregateSubscriber) this.c).lambda$hookOnSubscribe$0(this.b, j5);
                break;
            default:
                ((ResponseSubscribers.BodilessResponseLineSubscriber) this.c).lambda$hookOnSubscribe$0(this.b, j5);
                break;
        }
    }
}
