package reactor.core.publisher;

import reactor.core.Scannable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class InternalProducerAttr extends Scannable.Attr<Boolean> {
    static final InternalProducerAttr INSTANCE = new InternalProducerAttr(Boolean.TRUE);

    private InternalProducerAttr(Boolean bool) {
        super(bool);
    }
}
