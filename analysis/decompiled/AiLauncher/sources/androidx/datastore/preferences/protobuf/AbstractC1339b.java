package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.K;

/* renamed from: androidx.datastore.preferences.protobuf.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1339b<MessageType extends K> implements T<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    public static final C1351n f13503a = C1351n.b();

    public final MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).a().i(messagetype);
    }

    public final UninitializedMessageException d(MessageType messagetype) {
        return messagetype instanceof AbstractC1338a ? ((AbstractC1338a) messagetype).f() : new UninitializedMessageException(messagetype);
    }

    @Override // androidx.datastore.preferences.protobuf.T
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public MessageType a(ByteString byteString, C1351n c1351n) throws InvalidProtocolBufferException {
        return (MessageType) c(f(byteString, c1351n));
    }

    public MessageType f(ByteString byteString, C1351n c1351n) throws InvalidProtocolBufferException {
        AbstractC1345h abstractC1345hV = byteString.v();
        MessageType messagetypeB = b(abstractC1345hV, c1351n);
        try {
            abstractC1345hV.a(0);
            return messagetypeB;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.i(messagetypeB);
        }
    }
}
