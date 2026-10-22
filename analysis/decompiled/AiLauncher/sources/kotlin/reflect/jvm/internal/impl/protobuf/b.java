package kotlin.reflect.jvm.internal.impl.protobuf;

import ia.AbstractC4182b;
import ia.InterfaceC4188h;
import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes5.dex */
public abstract class b<MessageType extends h> implements InterfaceC4188h<MessageType> {

    /* renamed from: a, reason: collision with root package name */
    public static final d f35857a = d.c();

    public final MessageType e(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw f(messagetype).a().i(messagetype);
    }

    public final UninitializedMessageException f(MessageType messagetype) {
        return messagetype instanceof a ? ((a) messagetype).b() : new UninitializedMessageException(messagetype);
    }

    @Override // ia.InterfaceC4188h
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public MessageType d(InputStream inputStream, d dVar) throws InvalidProtocolBufferException {
        return (MessageType) e(j(inputStream, dVar));
    }

    @Override // ia.InterfaceC4188h
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public MessageType b(AbstractC4182b abstractC4182b, d dVar) throws InvalidProtocolBufferException {
        return (MessageType) e(k(abstractC4182b, dVar));
    }

    @Override // ia.InterfaceC4188h
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public MessageType a(InputStream inputStream, d dVar) throws InvalidProtocolBufferException {
        return (MessageType) e(l(inputStream, dVar));
    }

    public MessageType j(InputStream inputStream, d dVar) throws IOException {
        try {
            int i10 = inputStream.read();
            if (i10 == -1) {
                return null;
            }
            return (MessageType) l(new a.AbstractC0449a.C0450a(inputStream, c.B(i10, inputStream)), dVar);
        } catch (IOException e10) {
            throw new InvalidProtocolBufferException(e10.getMessage());
        }
    }

    public MessageType k(AbstractC4182b abstractC4182b, d dVar) throws InvalidProtocolBufferException {
        c cVarR = abstractC4182b.r();
        MessageType messagetypeC = c(cVarR, dVar);
        try {
            cVarR.a(0);
            return messagetypeC;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.i(messagetypeC);
        }
    }

    public MessageType l(InputStream inputStream, d dVar) throws InvalidProtocolBufferException {
        c cVarH = c.h(inputStream);
        MessageType messagetypeC = c(cVarH, dVar);
        try {
            cVarH.a(0);
            return messagetypeC;
        } catch (InvalidProtocolBufferException e10) {
            throw e10.i(messagetypeC);
        }
    }
}
