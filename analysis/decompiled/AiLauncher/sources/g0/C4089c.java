package g0;

import Z8.AbstractC1162j;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import d0.f;
import h0.C4118a;
import h0.C4120c;
import io.ktor.http.ContentDisposition;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010)\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H\u0096\u0002¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR&\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020#0\"8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010*¨\u0006,"}, d2 = {"Lg0/c;", ExifInterface.LONGITUDE_EAST, "LZ8/j;", "Ld0/f$a;", "Lg0/b;", "set", "<init>", "(Lg0/b;)V", "Ld0/f;", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "()Ld0/f;", "element", "", "contains", "(Ljava/lang/Object;)Z", "add", "remove", "LY8/t;", "clear", "()V", "", "iterator", "()Ljava/util/Iterator;", Const.INTENT_KEY_APIKEY, "Lg0/b;", "", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", "c", "()Ljava/lang/Object;", "setFirstElement$runtime", "(Ljava/lang/Object;)V", "firstElement", "lastElement", "Lf0/f;", "Lg0/a;", Const.INTENT_KEY_UMID, "Lf0/f;", "e", "()Lf0/f;", "hashMapBuilder", "", "()I", ContentDisposition.Parameters.Size, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: g0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4089c<E> extends AbstractC1162j<E> implements f.a<E> {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public C4088b<E> set;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public Object firstElement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public Object lastElement;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f0.f<E, C4087a> hashMapBuilder;

    public C4089c(C4088b<E> c4088b) {
        this.set = c4088b;
        this.firstElement = c4088b.getFirstElement();
        this.lastElement = this.set.getLastElement();
        this.hashMapBuilder = this.set.j().p();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(E element) {
        if (this.hashMapBuilder.containsKey(element)) {
            return false;
        }
        if (isEmpty()) {
            this.firstElement = element;
            this.lastElement = element;
            this.hashMapBuilder.put(element, new C4087a());
            return true;
        }
        C4087a c4087a = this.hashMapBuilder.get(this.lastElement);
        p.f(c4087a);
        this.hashMapBuilder.put(this.lastElement, c4087a.e(element));
        this.hashMapBuilder.put(element, new C4087a(this.lastElement));
        this.lastElement = element;
        return true;
    }

    @Override // Z8.AbstractC1162j
    public int b() {
        return this.hashMapBuilder.size();
    }

    @Override // d0.f.a
    public f<E> build() {
        C4088b<E> c4088b;
        f0.d<E, C4087a> dVarI = this.hashMapBuilder.i();
        if (dVarI == this.set.j()) {
            C4118a.a(this.firstElement == this.set.getFirstElement());
            C4118a.a(this.lastElement == this.set.getLastElement());
            c4088b = this.set;
        } else {
            c4088b = new C4088b<>(this.firstElement, this.lastElement, dVarI);
        }
        this.set = c4088b;
        return c4088b;
    }

    /* renamed from: c, reason: from getter */
    public final Object getFirstElement() {
        return this.firstElement;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.hashMapBuilder.clear();
        C4120c c4120c = C4120c.f32881a;
        this.firstElement = c4120c;
        this.lastElement = c4120c;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object element) {
        return this.hashMapBuilder.containsKey(element);
    }

    public final f0.f<E, C4087a> e() {
        return this.hashMapBuilder;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new e(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object element) {
        C4087a c4087aRemove = this.hashMapBuilder.remove(element);
        if (c4087aRemove == null) {
            return false;
        }
        if (c4087aRemove.b()) {
            C4087a c4087a = this.hashMapBuilder.get(c4087aRemove.getPrevious());
            p.f(c4087a);
            this.hashMapBuilder.put(c4087aRemove.getPrevious(), c4087a.e(c4087aRemove.getNext()));
        } else {
            this.firstElement = c4087aRemove.getNext();
        }
        if (!c4087aRemove.a()) {
            this.lastElement = c4087aRemove.getPrevious();
            return true;
        }
        C4087a c4087a2 = this.hashMapBuilder.get(c4087aRemove.getNext());
        p.f(c4087a2);
        this.hashMapBuilder.put(c4087aRemove.getNext(), c4087a2.f(c4087aRemove.getPrevious()));
        return true;
    }
}
