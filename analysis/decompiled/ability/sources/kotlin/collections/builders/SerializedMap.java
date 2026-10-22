package kotlin.collections.builders;

import E7.d;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SerializedMap implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public MapBuilder f4903a;

    private final Object readResolve() {
        return this.f4903a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        k.f(input, "input");
        byte b = input.readByte();
        if (b != 0) {
            throw new InvalidObjectException(B7.a.h(b, "Unsupported flags value: "));
        }
        int i = input.readInt();
        if (i < 0) {
            throw new InvalidObjectException(androidx.appfunctions.metadata.a.k("Illegal size value: ", i, '.'));
        }
        MapBuilder mapBuilder = new MapBuilder(i);
        for (int i6 = 0; i6 < i; i6++) {
            mapBuilder.put(input.readObject(), input.readObject());
        }
        this.f4903a = mapBuilder.b();
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        k.f(output, "output");
        output.writeByte(0);
        output.writeInt(this.f4903a.i);
        Iterator it = ((d) this.f4903a.entrySet()).iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
