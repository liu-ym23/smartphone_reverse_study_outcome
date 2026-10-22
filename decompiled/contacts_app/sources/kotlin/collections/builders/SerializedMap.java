package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", "", "(Ljava/util/Map;)V", "readExternal", "", "input", "Ljava/io/ObjectInput;", "readResolve", "", "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SerializedMap implements Externalizable {
    public static final Companion Companion = null;
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/SerializedMap$Companion;", "", "()V", "serialVersionUID", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public SerializedMap(Map<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "map");
        this.map = r2;
    }

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput r3) {
        Intrinsics.checkNotNullParameter(r3, "output");
        r3.writeByte(0);
        r3.writeInt(this.map.size());
        Iterator<Map.Entry<?, ?>> r2 = this.map.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry<?, ?> r0 = r2.next();
        r3.writeObject(r0.getKey());
        r3.writeObject(r0.getValue());
        goto L4
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        byte r0 = r6.readByte();
        if (r0 != 0) goto L14;
        int r1 = r6.readInt();
        if (r1 < 0) goto L12;
        Map r2 = MapsKt.createMapBuilder(r1);
        int r3 = 0;
    L7:
        if (r3 >= r1) goto L9;
        r2.put(r6.readObject(), r6.readObject());
        r3 = r3 + 1;
        goto L7
    L9:
        this.map = MapsKt.build(r2);
        return;
    L12:
        throw new InvalidObjectException("Illegal size value: " + r1 + '.');
    L14:
        throw new InvalidObjectException("Unsupported flags value: " + r0);
    }

    private final Object readResolve() {
        return this.map;
    }
}
