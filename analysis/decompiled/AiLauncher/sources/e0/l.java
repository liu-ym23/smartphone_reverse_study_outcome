package e0;

import Z8.C1168p;
import Z8.r;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import d0.e;
import h0.C4118a;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010*\n\u0002\b\u000e\b\u0001\u0018\u0000 ,*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001.B\u0017\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00120\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000b\u0010\u0018J\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00162\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00162\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b \u0010\u001fJ\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\u0096\u0002¢\u0006\u0004\b$\u0010%J%\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010\u0018J\u001f\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u0006\u0010'\u001a\u00020\u0016H\u0002¢\u0006\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010'\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Le0/l;", ExifInterface.LONGITUDE_EAST, "Ld0/c;", "Le0/c;", "", "", "buffer", "<init>", "([Ljava/lang/Object;)V", "element", "Ld0/e;", "add", "(Ljava/lang/Object;)Ld0/e;", "", "elements", "addAll", "(Ljava/util/Collection;)Ld0/e;", "Lkotlin/Function1;", "", "predicate", "M", "(Lp9/l;)Ld0/e;", "", "index", "(ILjava/lang/Object;)Ld0/e;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(I)Ld0/e;", "Ld0/e$a;", "builder", "()Ld0/e$a;", "indexOf", "(Ljava/lang/Object;)I", "lastIndexOf", "", "listIterator", "(I)Ljava/util/ListIterator;", "get", "(I)Ljava/lang/Object;", "set", ContentDisposition.Parameters.Size, "k", "(I)[Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "[Ljava/lang/Object;", "c", "()I", Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class l<E> extends c<E> implements d0.c<E> {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    public static final int f32205d = 8;

    /* renamed from: e, reason: collision with root package name */
    public static final l f32206e = new l(new Object[0]);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object[] buffer;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Le0/l$a;", "", "<init>", "()V", "Le0/l;", "", "EMPTY", "Le0/l;", Const.INTENT_KEY_APIKEY, "()Le0/l;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: e0.l$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final l a() {
            return l.f32206e;
        }

        public Companion() {
        }
    }

    public l(Object[] objArr) {
        this.buffer = objArr;
        C4118a.a(objArr.length <= 32);
    }

    @Override // d0.e
    public d0.e<E> M(InterfaceC5074l<? super E, Boolean> predicate) {
        Object[] objArrCopyOf = this.buffer;
        int size = size();
        int size2 = size();
        boolean z10 = false;
        for (int i10 = 0; i10 < size2; i10++) {
            Object obj = this.buffer[i10];
            if (predicate.invoke(obj).booleanValue()) {
                if (!z10) {
                    Object[] objArr = this.buffer;
                    objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                    p.h(objArrCopyOf, "copyOf(...)");
                    z10 = true;
                    size = i10;
                }
            } else if (z10) {
                objArrCopyOf[size] = obj;
                size++;
            }
        }
        return size == size() ? this : size == 0 ? f32206e : new l(C1168p.q(objArrCopyOf, 0, size));
    }

    @Override // java.util.Collection, java.util.List, d0.e
    public d0.e<E> add(E element) {
        if (size() >= 32) {
            return new f(this.buffer, n.c(element), size() + 1, 0);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() + 1);
        p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[size()] = element;
        return new l(objArrCopyOf);
    }

    @Override // e0.c, java.util.Collection, java.util.List, d0.e
    public d0.e<E> addAll(Collection<? extends E> elements) {
        if (size() + elements.size() > 32) {
            e.a<E> aVarBuilder = builder();
            aVarBuilder.addAll(elements);
            return aVarBuilder.build();
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() + elements.size());
        p.h(objArrCopyOf, "copyOf(...)");
        int size = size();
        Iterator<? extends E> it = elements.iterator();
        while (it.hasNext()) {
            objArrCopyOf[size] = it.next();
            size++;
        }
        return new l(objArrCopyOf);
    }

    @Override // d0.e
    public e.a<E> builder() {
        return new h(this, null, this.buffer, 0);
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c */
    public int getSize() {
        return this.buffer.length;
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public E get(int index) {
        h0.d.a(index, size());
        return (E) this.buffer[index];
    }

    @Override // d0.e
    public d0.e<E> h(int index) {
        h0.d.a(index, size());
        if (size() == 1) {
            return f32206e;
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.buffer, size() - 1);
        p.h(objArrCopyOf, "copyOf(...)");
        C1168p.i(this.buffer, objArrCopyOf, index, index + 1, size());
        return new l(objArrCopyOf);
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public int indexOf(Object element) {
        return r.o0(this.buffer, element);
    }

    public final Object[] k(int size) {
        return new Object[size];
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public int lastIndexOf(Object element) {
        return r.A0(this.buffer, element);
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public ListIterator<E> listIterator(int index) {
        h0.d.b(index, size());
        return new d(this.buffer, index, size());
    }

    @Override // Z8.AbstractC1156d, java.util.List
    public d0.e<E> set(int index, E element) {
        h0.d.a(index, size());
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        p.h(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[index] = element;
        return new l(objArrCopyOf);
    }

    @Override // java.util.List, d0.e
    public d0.e<E> add(int index, E element) {
        h0.d.b(index, size());
        if (index == size()) {
            return add((l<E>) element);
        }
        if (size() < 32) {
            Object[] objArrK = k(size() + 1);
            C1168p.n(this.buffer, objArrK, 0, 0, index, 6, null);
            C1168p.i(this.buffer, objArrK, index + 1, index, size());
            objArrK[index] = element;
            return new l(objArrK);
        }
        Object[] objArr = this.buffer;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        p.h(objArrCopyOf, "copyOf(...)");
        C1168p.i(this.buffer, objArrCopyOf, index + 1, index, size() - 1);
        objArrCopyOf[index] = element;
        return new f(objArrCopyOf, n.c(this.buffer[31]), size() + 1, 0);
    }
}
