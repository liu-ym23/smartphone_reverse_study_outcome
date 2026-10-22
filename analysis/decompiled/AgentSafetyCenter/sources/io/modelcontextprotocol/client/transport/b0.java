package io.modelcontextprotocol.client.transport;

import io.modelcontextprotocol.client.transport.ResponseSubscribers;
import java.util.function.LongConsumer;
import reactor.core.publisher.BaseSubscriber;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class b0 implements LongConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6158a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ qd.e f6159b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ BaseSubscriber f6160c;

    public /* synthetic */ b0(int i) {
        this.f6158a = i;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j10) {
        switch (this.f6158a) {
            case 0:
                ((ResponseSubscribers.AggregateSubscriber) this.f6160c).lambda$hookOnSubscribe$0(this.f6159b, j10);
                break;
            default:
                ((ResponseSubscribers.BodilessResponseLineSubscriber) this.f6160c).lambda$hookOnSubscribe$0(this.f6159b, j10);
                break;
        }
    }
}
