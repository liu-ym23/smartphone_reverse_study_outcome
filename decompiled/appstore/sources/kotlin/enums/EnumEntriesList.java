package kotlin.enums;

import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.io.Serializable;
import java.lang.Enum;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.collections.b;
import kotlin.collections.n;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
@SinceKotlin(version = "1.8")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u00042\u00060\u0005j\u0002`\u0006B\u0015\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lkotlin/enums/EnumEntriesList;", "", "T", "Lkotlin/enums/EnumEntries;", "Lkotlin/collections/b;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "entries", "<init>", "([Ljava/lang/Enum;)V", "", "writeReplace", "()Ljava/lang/Object;", "", SlideCard.KEY_INDEX, "get", "(I)Ljava/lang/Enum;", "element", "", "contains", "(Ljava/lang/Enum;)Z", "indexOf", "(Ljava/lang/Enum;)I", "lastIndexOf", "[Ljava/lang/Enum;", "getSize", "()I", "size", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class EnumEntriesList<T extends Enum<T>> extends b implements EnumEntries<T>, Serializable {

    @NotNull
    private final T[] entries;

    public EnumEntriesList(@NotNull T[] r10) {
        q.g(r10, "entries");
        this.entries = r10;
    }

    private final Object writeReplace() {
        return new EnumEntriesSerializationProxy(this.entries);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object r10) {
        if ((r10 instanceof Enum) == true) goto L7;
        return false;
    L7:
        return contains((Enum) r10);
    }

    @Override // kotlin.collections.b, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r10) {
        return get(r10);
    }

    @Override // kotlin.collections.AbstractCollection
    public int getSize() {
        return this.entries.length;
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int indexOf(Object r10) {
        if ((r10 instanceof Enum) == true) goto L7;
        return -1;
    L7:
        return indexOf((Enum) r10);
    }

    @Override // kotlin.collections.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object r10) {
        if ((r10 instanceof Enum) == true) goto L7;
        return -1;
    L7:
        return lastIndexOf((Enum) r10);
    }

    public boolean contains(@NotNull T r10) {
        q.g(r10, "element");
        if (((Enum) n.u(this.entries, r10.ordinal())) != r10) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // kotlin.collections.b, java.util.List
    @NotNull
    public T get(int r10) {
        b.Companion.a(r10, this.entries.length);
        return this.entries[r10];
    }

    public int indexOf(@NotNull T r10) {
        q.g(r10, "element");
        int r11 = r10.ordinal();
        if (((Enum) n.u(this.entries, r11)) == r10) goto L7;
        return -1;
    L7:
        return r11;
    }

    public int lastIndexOf(@NotNull T r10) {
        q.g(r10, "element");
        return indexOf(r10);
    }
}
