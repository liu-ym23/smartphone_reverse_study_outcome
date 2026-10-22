package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* loaded from: classes.dex */
public interface K extends L {

    public interface a extends L, Cloneable {
        K build();

        K buildPartial();

        a l(K k10);
    }

    void a(CodedOutputStream codedOutputStream) throws IOException;

    T<? extends K> getParserForType();

    int getSerializedSize();

    a newBuilderForType();

    a toBuilder();

    ByteString toByteString();
}
