package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import kotlin.Metadata;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010(\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0011¨\u0006\u0012"}, d2 = {"LKa/d;", ExifInterface.GPS_DIRECTION_TRUE, "LKa/j;", "LKa/e;", "sequence", "", "count", "<init>", "(LKa/j;I)V", "n", Const.INTENT_KEY_APIKEY, "(I)LKa/j;", Const.INTENT_KEY_PKGNAME, "", "iterator", "()Ljava/util/Iterator;", "LKa/j;", "I", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class d<T> implements j<T>, e<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final j<T> sequence;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final int count;

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\b\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Ka/d$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", Const.INTENT_KEY_PKGNAME, "I", "getLeft", "()I", "setLeft", "(I)V", "left", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Iterator<T> iterator;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int left;

        public a(d<T> dVar) {
            this.iterator = dVar.sequence.iterator();
            this.left = dVar.count;
        }

        public final void a() {
            while (this.left > 0 && this.iterator.hasNext()) {
                this.iterator.next();
                this.left--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            a();
            return this.iterator.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(j<? extends T> sequence, int i10) {
        kotlin.jvm.internal.p.i(sequence, "sequence");
        this.sequence = sequence;
        this.count = i10;
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i10 + '.').toString());
    }

    @Override // Ka.e
    public j<T> a(int n10) {
        int i10 = this.count + n10;
        return i10 < 0 ? new d(this, n10) : new d(this.sequence, i10);
    }

    @Override // Ka.e
    public j<T> b(int n10) {
        int i10 = this.count;
        int i11 = i10 + n10;
        return i11 < 0 ? new y(this, n10) : new x(this.sequence, i10, i11);
    }

    @Override // Ka.j
    public Iterator<T> iterator() {
        return new a(this);
    }
}
