package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.S;

/* renamed from: androidx.datastore.preferences.protobuf.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0482b<MessageType extends S> implements a0<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    private static final C0496p f9981a = C0496p.b();

    private MessageType c(MessageType messagetype) throws B {
        if (messagetype == null || messagetype.k()) {
            return messagetype;
        }
        throw d(messagetype).a().i(messagetype);
    }

    private n0 d(MessageType messagetype) {
        return messagetype instanceof AbstractC0481a ? ((AbstractC0481a) messagetype).n() : new n0(messagetype);
    }

    @Override // androidx.datastore.preferences.protobuf.a0
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageType a(AbstractC0488h abstractC0488h, C0496p c0496p) {
        return (MessageType) c(f(abstractC0488h, c0496p));
    }

    public MessageType f(AbstractC0488h abstractC0488h, C0496p c0496p) throws B {
        AbstractC0489i abstractC0489iT = abstractC0488h.t();
        MessageType messagetypeB = b(abstractC0489iT, c0496p);
        try {
            abstractC0489iT.a(0);
            return messagetypeB;
        } catch (B e6) {
            throw e6.i(messagetypeB);
        }
    }
}
