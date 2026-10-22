package e0;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import io.ktor.http.ContentDisposition;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0001\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B/\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ7\u0010\r\u001a\u00020\f2\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u0017\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Le0/m;", ExifInterface.LONGITUDE_EAST, "Le0/a;", "", "", Parameters.ROOT, "", "index", ContentDisposition.Parameters.Size, "height", "<init>", "([Ljava/lang/Object;III)V", "LY8/t;", "l", "next", "()Ljava/lang/Object;", "previous", "startLevel", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(II)V", "indexPredicate", "k", "(I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "c", "I", Const.INTENT_KEY_UMID, "[Ljava/lang/Object;", "path", "", "e", "Z", "isInRightEdge", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class m<E> extends AbstractC3970a<E> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public int height;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public Object[] path;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean isInRightEdge;

    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    public m(Object[] objArr, int i10, int i11, int i12) {
        super(i10, i11);
        this.height = i12;
        Object[] objArr2 = new Object[i12];
        this.path = objArr2;
        ?? r52 = i10 == i11 ? 1 : 0;
        this.isInRightEdge = r52;
        objArr2[0] = objArr;
        j(i10 - r52, 1);
    }

    public final E i() {
        int index = getIndex() & 31;
        Object obj = this.path[this.height - 1];
        p.g(obj, "null cannot be cast to non-null type kotlin.Array<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.TrieIterator>");
        return (E) ((Object[]) obj)[index];
    }

    public final void j(int index, int startLevel) {
        int i10 = (this.height - startLevel) * 5;
        while (startLevel < this.height) {
            Object[] objArr = this.path;
            Object obj = objArr[startLevel - 1];
            p.g(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr[startLevel] = ((Object[]) obj)[n.a(index, i10)];
            i10 -= 5;
            startLevel++;
        }
    }

    public final void k(int indexPredicate) {
        int i10 = 0;
        while (n.a(getIndex(), i10) == indexPredicate) {
            i10 += 5;
        }
        if (i10 > 0) {
            j(getIndex(), ((this.height - 1) - (i10 / 5)) + 1);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    public final void l(Object[] root, int index, int size, int height) {
        f(index);
        g(size);
        this.height = height;
        if (this.path.length < height) {
            this.path = new Object[height];
        }
        this.path[0] = root;
        ?? r02 = index == size ? 1 : 0;
        this.isInRightEdge = r02;
        j(index - r02, 1);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E eI = i();
        f(getIndex() + 1);
        if (getIndex() == getSize()) {
            this.isInRightEdge = true;
            return eI;
        }
        k(0);
        return eI;
    }

    @Override // java.util.ListIterator
    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        f(getIndex() - 1);
        if (this.isInRightEdge) {
            this.isInRightEdge = false;
            return i();
        }
        k(31);
        return i();
    }
}
