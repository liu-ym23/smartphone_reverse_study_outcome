package kotlin.reflect.jvm;

import C7.d;
import D8.j;
import F8.f;
import F8.g;
import F8.i;
import H8.AbstractC0241b;
import H8.C0245f;
import H8.h;
import b8.C0832E;
import b8.C0843d;
import b8.v0;
import java.io.ByteArrayInputStream;
import k8.K;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.UninitializedMessageException;

/* loaded from: classes.dex */
public abstract class a {
    public static final C0832E a(d dVar) {
        Metadata metadata = (Metadata) dVar.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] strArrD1 = metadata.d1();
            if (strArrD1.length == 0) {
                strArrD1 = null;
            }
            if (strArrD1 != null) {
                String[] strings = metadata.d2();
                h hVar = i.f596a;
                k.f(strings, "strings");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(F8.a.a(strArrD1));
                h hVar2 = i.f596a;
                g gVarG = i.g(byteArrayInputStream, strings);
                h hVar3 = i.f596a;
                B8.a aVar = ProtoBuf$Function.f5047v;
                aVar.getClass();
                C0245f c0245f = new C0245f(byteArrayInputStream);
                AbstractC0241b abstractC0241b = (AbstractC0241b) aVar.a(c0245f, hVar3);
                try {
                    c0245f.a(0);
                    if (!abstractC0241b.isInitialized()) {
                        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(new UninitializedMessageException().getMessage());
                        invalidProtocolBufferException.f5100a = abstractC0241b;
                        throw invalidProtocolBufferException;
                    }
                    ProtoBuf$Function protoBuf$Function = (ProtoBuf$Function) abstractC0241b;
                    f fVar = new f((metadata.xi() & 8) != 0, metadata.mv());
                    Class<?> cls = dVar.getClass();
                    ProtoBuf$TypeTable protoBuf$TypeTable = protoBuf$Function.p;
                    k.e(protoBuf$TypeTable, "getTypeTable(...)");
                    return new C0832E(C0843d.b, (K) v0.f(cls, protoBuf$Function, gVarG, new j(protoBuf$TypeTable), fVar, ReflectLambdaKt$reflect$descriptor$1.f4936a));
                } catch (InvalidProtocolBufferException e) {
                    e.f5100a = abstractC0241b;
                    throw e;
                }
            }
        }
        return null;
    }
}
