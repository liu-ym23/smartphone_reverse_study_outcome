package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.E;
import java.util.Map;

/* loaded from: classes.dex */
public interface F {
    Map<?, ?> forMapData(Object obj);

    E.a<?, ?> forMapMetadata(Object obj);

    Map<?, ?> forMutableMapData(Object obj);

    int getSerializedSize(int i10, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
