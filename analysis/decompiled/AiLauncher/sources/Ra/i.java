package Ra;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.z;
import q9.InterfaceC5162a;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\b\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u0003B%\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u0010H\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0015\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0016R&\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\u001e\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0016\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010#R\"\u0010)\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010#\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"LRa/i;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "LRa/a;", "", "nextKey", "LRa/d;", "builder", "<init>", "(Ljava/lang/Object;LRa/d;)V", "LY8/t;", Const.INTENT_KEY_PKGNAME, "()V", "c", Const.INTENT_KEY_APIKEY, "", "hasNext", "()Z", Const.INTENT_KEY_BACKGROUND_COMMAND, "()LRa/a;", "remove", "Ljava/lang/Object;", "LRa/d;", "e", "()LRa/d;", "f", "()Ljava/lang/Object;", "setLastIteratedKey$kotlinx_collections_immutable", "(Ljava/lang/Object;)V", "lastIteratedKey", Const.INTENT_KEY_UMID, "Z", "nextWasInvoked", "", "I", "expectedModCount", "getIndex$kotlinx_collections_immutable", "()I", "setIndex$kotlinx_collections_immutable", "(I)V", "index", "kotlinx-collections-immutable"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class i<K, V> implements Iterator<a<V>>, InterfaceC5162a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public Object nextKey;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final d<K, V> builder;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Object lastIteratedKey;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public boolean nextWasInvoked;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public int expectedModCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public int index;

    public i(Object obj, d<K, V> builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        this.nextKey = obj;
        this.builder = builder;
        this.lastIteratedKey = Ta.c.f5919a;
        this.expectedModCount = builder.j().getModCount();
    }

    private final void a() {
        if (this.builder.j().getModCount() != this.expectedModCount) {
            throw new ConcurrentModificationException();
        }
    }

    private final void b() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
    }

    private final void c() {
        if (!this.nextWasInvoked) {
            throw new IllegalStateException();
        }
    }

    public final d<K, V> e() {
        return this.builder;
    }

    /* renamed from: f, reason: from getter */
    public final Object getLastIteratedKey() {
        return this.lastIteratedKey;
    }

    @Override // java.util.Iterator
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a<V> next() {
        a();
        b();
        this.lastIteratedKey = this.nextKey;
        this.nextWasInvoked = true;
        this.index++;
        a<V> aVar = this.builder.j().get(this.nextKey);
        if (aVar != null) {
            a<V> aVar2 = aVar;
            this.nextKey = aVar2.getNext();
            return aVar2;
        }
        throw new ConcurrentModificationException("Hash code of a key (" + this.nextKey + ") has changed after it was added to the persistent map.");
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.builder.size();
    }

    @Override // java.util.Iterator
    public void remove() {
        c();
        z.d(this.builder).remove(this.lastIteratedKey);
        this.lastIteratedKey = null;
        this.nextWasInvoked = false;
        this.expectedModCount = this.builder.j().getModCount();
        this.index--;
    }
}
