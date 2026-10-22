package kotlin.reflect.jvm.internal.impl.protobuf;

import ia.InterfaceC4187g;
import ia.InterfaceC4188h;
import java.io.IOException;

/* loaded from: classes5.dex */
public interface h extends InterfaceC4187g {

    public interface a extends Cloneable, InterfaceC4187g {
        h build();

        a m(c cVar, d dVar) throws IOException;
    }

    void a(CodedOutputStream codedOutputStream) throws IOException;

    InterfaceC4188h<? extends h> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();
}
