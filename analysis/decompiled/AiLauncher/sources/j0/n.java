package j0;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\rJ\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u000bJ\u0010\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u0014J\u000f\u0010\u001a\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u0018R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001f¨\u0006%"}, d2 = {"Lj0/n;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "list", "", "offset", "<init>", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;I)V", "", "hasPrevious", "()Z", "nextIndex", "()I", "previous", "()Ljava/lang/Object;", "previousIndex", "element", "LY8/t;", "add", "(Ljava/lang/Object;)V", "hasNext", "next", "remove", "()V", "set", Const.INTENT_KEY_APIKEY, "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", Const.INTENT_KEY_PKGNAME, "I", "index", "c", "lastRequested", Const.INTENT_KEY_UMID, "structure", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class n<T> implements ListIterator<T>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final SnapshotStateList<T> list;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public int index;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int lastRequested = -1;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public int structure;

    public n(SnapshotStateList<T> snapshotStateList, int i10) {
        this.list = snapshotStateList;
        this.index = i10 - 1;
        this.structure = C4753k.h(snapshotStateList);
    }

    public final void a() {
        if (C4753k.h(this.list) != this.structure) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator
    public void add(T element) {
        a();
        this.list.add(this.index + 1, element);
        this.lastRequested = -1;
        this.index++;
        this.structure = C4753k.h(this.list);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.index < this.list.size() - 1;
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.index >= 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        a();
        int i10 = this.index + 1;
        this.lastRequested = i10;
        C4753k.m(i10, this.list.size());
        T t10 = this.list.get(i10);
        this.index = i10;
        return t10;
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.index + 1;
    }

    @Override // java.util.ListIterator
    public T previous() {
        a();
        C4753k.m(this.index, this.list.size());
        int i10 = this.index;
        this.lastRequested = i10;
        this.index--;
        return this.list.get(i10);
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.index;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        a();
        this.list.remove(this.lastRequested);
        this.index--;
        this.lastRequested = -1;
        this.structure = C4753k.h(this.list);
    }

    @Override // java.util.ListIterator
    public void set(T element) {
        a();
        int i10 = this.lastRequested;
        if (i10 < 0) {
            C4753k.i();
            throw new KotlinNothingValueException();
        }
        this.list.set(i10, element);
        this.structure = C4753k.h(this.list);
    }
}
