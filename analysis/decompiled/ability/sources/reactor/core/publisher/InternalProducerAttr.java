package reactor.core.publisher;

import reactor.core.Scannable;

/* loaded from: classes4.dex */
class InternalProducerAttr extends Scannable.Attr<Boolean> {
    static final InternalProducerAttr INSTANCE = new InternalProducerAttr(Boolean.TRUE);

    private InternalProducerAttr(Boolean bool) {
        super(bool);
    }
}
