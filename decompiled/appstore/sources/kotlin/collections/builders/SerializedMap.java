package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.j0;
import kotlin.collections.k0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\t\b\u0016¢\u0006\u0004\b\u0004\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0013¨\u0006\u0016"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "", "map", "<init>", "(Ljava/util/Map;)V", "()V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", "output", "", "writeExternal", "(Ljava/io/ObjectOutput;)V", "Ljava/io/ObjectInput;", "input", "readExternal", "(Ljava/io/ObjectInput;)V", "Ljava/util/Map;", "Companion", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SerializedMap implements Externalizable {

    @NotNull
    public static final a Companion = null;
    private static final long serialVersionUID = 0;

    @NotNull
    private Map<?, ?> map;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }

        public a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public SerializedMap(@NotNull Map<?, ?> r10) {
        q.g(r10, "map");
        this.map = r10;
    }

    private final Object readResolve() {
        return this.map;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput r10) {
        q.g(r10, "input");
        byte r11 = r10.readByte();
        if (r11 != 0) goto L14;
        int r12 = r10.readInt();
        if (r12 < 0) goto L12;
        Map r13 = j0.d(r12);
        int r14 = 0;
    L7:
        if (r14 >= r12) goto L9;
        r13.put(r10.readObject(), r10.readObject());
        r14 = r14 + 1;
        goto L7
    L9:
        this.map = j0.b(r13);
        return;
    L12:
        throw new InvalidObjectException("Illegal size value: " + r12 + '.');
    L14:
        throw new InvalidObjectException("Unsupported flags value: " + r11);
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput r10) {
        q.g(r10, "output");
        r10.writeByte(0);
        r10.writeInt(this.map.size());
        Iterator<Map.Entry<?, ?>> r11 = this.map.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        Map.Entry<?, ?> r12 = r11.next();
        r10.writeObject(r12.getKey());
        r10.writeObject(r12.getValue());
        goto L4
    }

    public SerializedMap() {
        this(k0.h());
    }
}
