package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"LKa/z;", ExifInterface.GPS_DIRECTION_TRUE, "LKa/j;", "sequence", "Lkotlin/Function1;", "", "predicate", "<init>", "(LKa/j;Lp9/l;)V", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "LKa/j;", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class z<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final j<T> sequence;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<T, Boolean> predicate;

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\b\u0010\tR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u00018\u0006¢\u0006\f\n\u0004\b\u0003\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001b\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Ka/z$a", "", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", "", Const.INTENT_KEY_PKGNAME, "I", "getNextState", "()I", "setNextState", "(I)V", "nextState", "c", "Ljava/lang/Object;", "getNextItem", "setNextItem", "(Ljava/lang/Object;)V", "nextItem", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Iterator<T>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Iterator<T> iterator;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public int nextState = -1;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public T nextItem;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ z<T> f4255d;

        public a(z<T> zVar) {
            this.f4255d = zVar;
            this.iterator = zVar.sequence.iterator();
        }

        private final void a() {
            if (this.iterator.hasNext()) {
                T next = this.iterator.next();
                if (((Boolean) this.f4255d.predicate.invoke(next)).booleanValue()) {
                    this.nextState = 1;
                    this.nextItem = next;
                    return;
                }
            }
            this.nextState = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.nextState == -1) {
                a();
            }
            return this.nextState == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.nextState == -1) {
                a();
            }
            if (this.nextState == 0) {
                throw new NoSuchElementException();
            }
            T t10 = this.nextItem;
            this.nextItem = null;
            this.nextState = -1;
            return t10;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public z(j<? extends T> sequence, InterfaceC5074l<? super T, Boolean> predicate) {
        kotlin.jvm.internal.p.i(sequence, "sequence");
        kotlin.jvm.internal.p.i(predicate, "predicate");
        this.sequence = sequence;
        this.predicate = predicate;
    }

    @Override // Ka.j
    public Iterator<T> iterator() {
        return new a(this);
    }
}
