package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.common.TeaEventTrack;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMutableIterator;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010)\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0004H$¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u0004H$J\t\u0010\u000f\u001a\u00020\nH\u0096\u0002J\u000e\u0010\u0010\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Landroidx/collection/IndexBasedArrayIterator;", ExifInterface.GPS_DIRECTION_TRUE, "", "startingSize", "", "<init>", "(I)V", "size", "index", "canRemove", "", "elementAt", "(I)Ljava/lang/Object;", "removeAt", "", "hasNext", TeaEventTrack.ACTION_DRAMA_NEXT, "()Ljava/lang/Object;", "remove", "collection"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class IndexBasedArrayIterator<T> implements Iterator<T>, KMutableIterator {
    private boolean canRemove;
    private int index;
    private int size;

    public abstract T elementAt(int r100);

    public abstract void removeAt(int r100);

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.index >= this.size) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.canRemove == true) goto L5;
        RuntimeHelpersKt.throwIllegalStateException("Call next() before removing an element.");
    L5:
        int r100 = this.index - 1;
        this.index = r100;
        removeAt(r100);
        this.size--;
        this.canRemove = false;
    }

    @Override // java.util.Iterator
    public T next() {
        if (hasNext() == false) goto L7;
        T r100 = elementAt(this.index);
        this.index++;
        this.canRemove = true;
        return r100;
    L7:
        throw new NoSuchElementException();
    }

    public IndexBasedArrayIterator(int r100) {
        this.size = r100;
    }
}
