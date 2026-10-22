package kotlin.collections.builders;

import D7.N;
import H4.o;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.AbstractCollection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "", "readResolve", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SerializedCollection implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public AbstractCollection f4902a;
    public final int b;

    public SerializedCollection(AbstractCollection abstractCollection, int i) {
        this.f4902a = abstractCollection;
        this.b = i;
    }

    private final Object readResolve() {
        return this.f4902a;
    }

    @Override // java.io.Externalizable
    public final void readExternal(ObjectInput input) throws IOException {
        AbstractCollection abstractCollectionQ;
        k.f(input, "input");
        byte b = input.readByte();
        int i = b & 1;
        if ((b & (-2)) != 0) {
            throw new InvalidObjectException(androidx.appfunctions.metadata.a.k("Unsupported flags value: ", b, '.'));
        }
        int i6 = input.readInt();
        if (i6 < 0) {
            throw new InvalidObjectException(androidx.appfunctions.metadata.a.k("Illegal size value: ", i6, '.'));
        }
        int i10 = 0;
        if (i == 0) {
            ListBuilder listBuilder = new ListBuilder(i6);
            while (i10 < i6) {
                listBuilder.add(input.readObject());
                i10++;
            }
            abstractCollectionQ = o.q(listBuilder);
        } else {
            if (i != 1) {
                throw new InvalidObjectException(androidx.appfunctions.metadata.a.k("Unsupported collection type tag: ", i, '.'));
            }
            SetBuilder setBuilder = new SetBuilder(new MapBuilder(i6));
            while (i10 < i6) {
                setBuilder.add(input.readObject());
                i10++;
            }
            abstractCollectionQ = N.m(setBuilder);
        }
        this.f4902a = abstractCollectionQ;
    }

    @Override // java.io.Externalizable
    public final void writeExternal(ObjectOutput output) throws IOException {
        k.f(output, "output");
        output.writeByte(this.b);
        output.writeInt(this.f4902a.size());
        Iterator it = this.f4902a.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }
}
