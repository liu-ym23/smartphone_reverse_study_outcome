package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
final class SerializedMap implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public Object f10048a = kotlin.collections.b.d0();

    private final Object readResolve() {
        return this.f10048a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        g.f(input, "input");
        byte b10 = input.readByte();
        if (b10 != 0) {
            throw new InvalidObjectException(ai.onnxruntime.providers.a.a(b10, "Unsupported flags value: "));
        }
        int i10 = input.readInt();
        if (i10 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i10 + '.');
        }
        MapBuilder mapBuilder = new MapBuilder(i10);
        for (int i11 = 0; i11 < i10; i11++) {
            mapBuilder.put(input.readObject(), input.readObject());
        }
        this.f10048a = mapBuilder.b();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.util.Map] */
    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        g.f(output, "output");
        output.writeByte(0);
        output.writeInt(this.f10048a.size());
        for (Map.Entry entry : this.f10048a.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }
}
