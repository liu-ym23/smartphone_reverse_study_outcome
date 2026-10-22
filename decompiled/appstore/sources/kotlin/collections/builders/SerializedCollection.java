package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u001b\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\t\b\u0016¢\u0006\u0004\b\u0006\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0016¨\u0006\u0019"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "", "collection", "", "tag", "<init>", "(Ljava/util/Collection;I)V", "()V", "", "readResolve", "()Ljava/lang/Object;", "Ljava/io/ObjectOutput;", "output", "", "writeExternal", "(Ljava/io/ObjectOutput;)V", "Ljava/io/ObjectInput;", "input", "readExternal", "(Ljava/io/ObjectInput;)V", "Ljava/util/Collection;", "I", "Companion", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nListBuilder.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ListBuilder.kt\nkotlin/collections/builders/SerializedCollection\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,487:1\n1#2:488\n*E\n"})
public final class SerializedCollection implements Externalizable {

    @NotNull
    public static final a Companion = null;
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;

    @NotNull
    private Collection<?> collection;
    private final int tag;

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

    public SerializedCollection(@NotNull Collection<?> r10, int r11) {
        q.g(r10, "collection");
        this.collection = r10;
        this.tag = r11;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Override // java.io.Externalizable
    public void readExternal(@NotNull ObjectInput r10) {
        q.g(r10, "input");
        byte r11 = r10.readByte();
        int r12 = r11 & 1;
        if ((r11 & (-2)) != 0) goto L25;
        int r13 = r10.readInt();
        if (r13 < 0) goto L23;
        int r14 = 0;
        if (r12 != 0) goto L9;
        List r15 = s.d(r13);
    L17:
        if (r14 >= r13) goto L19;
        r15.add(r10.readObject());
        r14 = r14 + 1;
        goto L17
    L19:
        Set r16 = s.a(r15);
    L20:
        this.collection = r16;
        return;
    L9:
        if (r12 != 1) goto L15;
        Set r17 = q0.c(r13);
    L11:
        if (r14 >= r13) goto L13;
        r17.add(r10.readObject());
        r14 = r14 + 1;
        goto L11
    L13:
        r16 = q0.a(r17);
        goto L20
    L15:
        throw new InvalidObjectException("Unsupported collection type tag: " + r12 + '.');
    L23:
        throw new InvalidObjectException("Illegal size value: " + r13 + '.');
    L25:
        throw new InvalidObjectException("Unsupported flags value: " + r11 + '.');
    }

    @Override // java.io.Externalizable
    public void writeExternal(@NotNull ObjectOutput r10) {
        q.g(r10, "output");
        r10.writeByte(this.tag);
        r10.writeInt(this.collection.size());
        Iterator<?> r11 = this.collection.iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        r10.writeObject(r11.next());
        goto L4
    }

    public SerializedCollection() {
        this(t.i(), 0);
    }
}
