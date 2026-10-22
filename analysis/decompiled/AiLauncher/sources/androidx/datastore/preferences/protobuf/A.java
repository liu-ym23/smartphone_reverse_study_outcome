package androidx.datastore.preferences.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface A extends List {
    void F(ByteString byteString);

    Object getRaw(int i10);

    List<?> getUnderlyingElements();

    A getUnmodifiableView();
}
