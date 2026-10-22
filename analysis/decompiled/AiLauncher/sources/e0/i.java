package e0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B=\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Le0/i;", ExifInterface.GPS_DIRECTION_TRUE, "Le0/a;", "", "", Parameters.ROOT, "tail", "", "index", ContentDisposition.Parameters.Size, "trieHeight", "<init>", "([Ljava/lang/Object;[Ljava/lang/Object;III)V", "next", "()Ljava/lang/Object;", "previous", "c", "[Ljava/lang/Object;", "Le0/m;", Const.INTENT_KEY_UMID, "Le0/m;", "trieIterator", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class i<T> extends AbstractC3970a<T> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final T[] tail;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final m<T> trieIterator;

    public i(Object[] objArr, T[] tArr, int i10, int i11, int i12) {
        super(i10, i11);
        this.tail = tArr;
        int iD = n.d(i11);
        this.trieIterator = new m<>(objArr, C5685n.j(i10, iD), iD, i12);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        a();
        if (this.trieIterator.hasNext()) {
            f(getIndex() + 1);
            return this.trieIterator.next();
        }
        T[] tArr = this.tail;
        int index = getIndex();
        f(index + 1);
        return tArr[index - this.trieIterator.getSize()];
    }

    @Override // java.util.ListIterator
    public T previous() {
        b();
        if (getIndex() <= this.trieIterator.getSize()) {
            f(getIndex() - 1);
            return this.trieIterator.previous();
        }
        T[] tArr = this.tail;
        f(getIndex() - 1);
        return tArr[getIndex() - this.trieIterator.getSize()];
    }
}
