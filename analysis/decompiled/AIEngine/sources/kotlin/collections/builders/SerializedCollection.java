package kotlin.collections.builders;

import androidx.datastore.preferences.protobuf.b1;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import mb.y;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SerializedCollection implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public Collection<?> f10046a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10047b;

    public SerializedCollection() {
        this(0, EmptyList.f10001a);
    }

    private final Object readResolve() {
        return this.f10046a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        Collection<?> collectionI;
        g.f(input, "input");
        byte b10 = input.readByte();
        int i10 = b10 & 1;
        if ((b10 & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b10) + '.');
        }
        int i11 = input.readInt();
        if (i11 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i11 + '.');
        }
        int i12 = 0;
        if (i10 == 0) {
            ListBuilder listBuilder = new ListBuilder(i11);
            while (i12 < i11) {
                listBuilder.add(input.readObject());
                i12++;
            }
            collectionI = b1.i(listBuilder);
        } else {
            if (i10 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i10 + '.');
            }
            SetBuilder setBuilder = new SetBuilder(new MapBuilder(i11));
            while (i12 < i11) {
                setBuilder.add(input.readObject());
                i12++;
            }
            collectionI = y.j(setBuilder);
        }
        this.f10046a = collectionI;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        g.f(output, "output");
        output.writeByte(this.f10047b);
        output.writeInt(this.f10046a.size());
        Iterator<?> it = this.f10046a.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public SerializedCollection(int i10, Collection collection) {
        g.f(collection, "collection");
        this.f10046a = collection;
        this.f10047b = i10;
    }
}
