package Ka;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import p9.InterfaceC5074l;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\n\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u00028\u00020\u0004BC\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\bH\u0096\u0002¢\u0006\u0004\b\t\u0010\fR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R&\u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"LKa/h;", ExifInterface.GPS_DIRECTION_TRUE, "R", ExifInterface.LONGITUDE_EAST, "LKa/j;", "sequence", "Lkotlin/Function1;", "transformer", "", "iterator", "<init>", "(LKa/j;Lp9/l;Lp9/l;)V", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "LKa/j;", Const.INTENT_KEY_PKGNAME, "Lp9/l;", "c", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class h<T, R, E> implements j<E> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final j<T> sequence;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<T, R> transformer;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final InterfaceC5074l<R, Iterator<E>> iterator;

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0010\u0010\u0002\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00018\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Ka/h$a", "", "next", "()Ljava/lang/Object;", "", "hasNext", "()Z", Const.INTENT_KEY_APIKEY, "Ljava/util/Iterator;", "getIterator", "()Ljava/util/Iterator;", "iterator", Const.INTENT_KEY_PKGNAME, "getItemIterator", "setItemIterator", "(Ljava/util/Iterator;)V", "itemIterator", "", "c", "I", "getState", "()I", "setState", "(I)V", VoiceWakeupReceiver.EXTRA_STATE, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements Iterator<E>, InterfaceC5162a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final Iterator<T> iterator;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        public Iterator<? extends E> itemIterator;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        public int state;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h<T, R, E> f4223d;

        public a(h<T, R, E> hVar) {
            this.f4223d = hVar;
            this.iterator = hVar.sequence.iterator();
        }

        public final boolean a() {
            Iterator<? extends E> it = this.itemIterator;
            if (it != null && it.hasNext()) {
                this.state = 1;
                return true;
            }
            while (this.iterator.hasNext()) {
                Iterator<? extends E> it2 = (Iterator) this.f4223d.iterator.invoke(this.f4223d.transformer.invoke(this.iterator.next()));
                if (it2.hasNext()) {
                    this.itemIterator = it2;
                    this.state = 1;
                    return true;
                }
            }
            this.state = 2;
            this.itemIterator = null;
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i10 = this.state;
            if (i10 == 1) {
                return true;
            }
            if (i10 == 2) {
                return false;
            }
            return a();
        }

        @Override // java.util.Iterator
        public E next() {
            int i10 = this.state;
            if (i10 == 2) {
                throw new NoSuchElementException();
            }
            if (i10 == 0 && !a()) {
                throw new NoSuchElementException();
            }
            this.state = 0;
            Iterator<? extends E> it = this.itemIterator;
            kotlin.jvm.internal.p.f(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(j<? extends T> sequence, InterfaceC5074l<? super T, ? extends R> transformer, InterfaceC5074l<? super R, ? extends Iterator<? extends E>> iterator) {
        kotlin.jvm.internal.p.i(sequence, "sequence");
        kotlin.jvm.internal.p.i(transformer, "transformer");
        kotlin.jvm.internal.p.i(iterator, "iterator");
        this.sequence = sequence;
        this.transformer = transformer;
        this.iterator = iterator;
    }

    @Override // Ka.j
    public Iterator<E> iterator() {
        return new a(this);
    }
}
