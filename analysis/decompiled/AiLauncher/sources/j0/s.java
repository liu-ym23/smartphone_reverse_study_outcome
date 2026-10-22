package j0;

import androidx.compose.runtime.snapshots.SnapshotStateSet;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0012\u0010\u000bR\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u001e\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u001dR*\u0010\u000f\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b\u001f\u0010\u001a\u0012\u0004\b\"\u0010\u000b\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u001dR\"\u0010*\u001a\u00020#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lj0/s;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "set", "", "iterator", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateSet;Ljava/util/Iterator;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "", "hasNext", "()Z", "next", "()Ljava/lang/Object;", "remove", Const.INTENT_KEY_APIKEY, "Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "getSet", "()Landroidx/compose/runtime/snapshots/SnapshotStateSet;", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "c", "Ljava/lang/Object;", "getCurrent", "setCurrent", "(Ljava/lang/Object;)V", "current", Const.INTENT_KEY_UMID, "getNext", "setNext", "getNext$annotations", "", "e", "I", "getModification", "()I", "setModification", "(I)V", "modification", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class s<T> implements Iterator<T>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SnapshotStateSet<T> set;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Iterator<T> iterator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public T current;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public T next;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int modification;

    /* JADX WARN: Multi-variable type inference failed */
    public s(SnapshotStateSet<T> snapshotStateSet, Iterator<? extends T> it) {
        this.set = snapshotStateSet;
        this.iterator = it;
        this.modification = androidx.compose.runtime.snapshots.e.c(snapshotStateSet);
        a();
    }

    private final void b() {
        if (androidx.compose.runtime.snapshots.e.c(this.set) != this.modification) {
            throw new ConcurrentModificationException();
        }
    }

    public final void a() {
        this.current = this.next;
        this.next = this.iterator.hasNext() ? this.iterator.next() : null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.next != null;
    }

    @Override // java.util.Iterator
    public T next() {
        b();
        a();
        T t10 = this.current;
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException();
    }

    @Override // java.util.Iterator
    public void remove() {
        b();
        T t10 = this.current;
        if (t10 == null) {
            throw new IllegalStateException();
        }
        this.set.remove(t10);
        this.current = null;
        Y8.t tVar = Y8.t.f7040a;
        this.modification = androidx.compose.runtime.snapshots.e.c(this.set);
    }
}
