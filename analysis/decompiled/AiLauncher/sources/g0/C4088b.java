package g0;

import Z8.AbstractC1163k;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import d0.f;
import h0.C4120c;
import io.ktor.http.ContentDisposition;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0005\b\u0001\u0018\u0000 +*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001,B/\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0016\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010\u001f\u001a\u0004\b#\u0010!R&\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u00078\u0000X\u0080\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010)¨\u0006-"}, d2 = {"Lg0/b;", ExifInterface.LONGITUDE_EAST, "LZ8/k;", "Ld0/f;", "", "firstElement", "lastElement", "Lf0/d;", "Lg0/a;", "hashMap", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Lf0/d;)V", "element", "", "contains", "(Ljava/lang/Object;)Z", "add", "(Ljava/lang/Object;)Ld0/f;", "", "elements", "addAll", "(Ljava/util/Collection;)Ld0/f;", "remove", "removeAll", "", "iterator", "()Ljava/util/Iterator;", "Ld0/f$a;", "builder", "()Ld0/f$a;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Object;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Ljava/lang/Object;", "c", "k", Const.INTENT_KEY_UMID, "Lf0/d;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lf0/d;", "", "()I", ContentDisposition.Parameters.Size, "e", Const.INTENT_KEY_APIKEY, "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: g0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4088b<E> extends AbstractC1163k<E> implements f<E> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f32673f = 8;

    /* renamed from: g, reason: collision with root package name */
    public static final C4088b f32674g;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Object firstElement;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final Object lastElement;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final f0.d<E, C4087a> hashMap;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\"\u0004\b\u0001\u0010\u0004H\u0000¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lg0/b$a;", "", "<init>", "()V", ExifInterface.LONGITUDE_EAST, "Ld0/f;", Const.INTENT_KEY_APIKEY, "()Ld0/f;", "Lg0/b;", "", "EMPTY", "Lg0/b;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    /* renamed from: g0.b$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final <E> f<E> a() {
            return C4088b.f32674g;
        }

        public Companion() {
        }
    }

    static {
        C4120c c4120c = C4120c.f32881a;
        f32674g = new C4088b(c4120c, c4120c, f0.d.INSTANCE.a());
    }

    public C4088b(Object obj, Object obj2, f0.d<E, C4087a> dVar) {
        this.firstElement = obj;
        this.lastElement = obj2;
        this.hashMap = dVar;
    }

    @Override // java.util.Collection, java.util.Set, d0.f
    public f<E> add(E element) {
        if (this.hashMap.containsKey(element)) {
            return this;
        }
        if (isEmpty()) {
            return new C4088b(element, element, this.hashMap.u(element, new C4087a()));
        }
        Object obj = this.lastElement;
        C4087a c4087a = this.hashMap.get(obj);
        p.f(c4087a);
        return new C4088b(this.firstElement, element, this.hashMap.u(obj, c4087a.e(element)).u(element, new C4087a(obj)));
    }

    @Override // java.util.Collection, java.util.Set, d0.f
    public f<E> addAll(Collection<? extends E> elements) {
        f.a<E> aVarBuilder = builder();
        aVarBuilder.addAll(elements);
        return aVarBuilder.build();
    }

    @Override // d0.f
    public f.a<E> builder() {
        return new C4089c(this);
    }

    @Override // Z8.AbstractC1154b
    /* renamed from: c */
    public int get_size() {
        return this.hashMap.size();
    }

    @Override // Z8.AbstractC1154b, java.util.Collection, java.util.List
    public boolean contains(Object element) {
        return this.hashMap.containsKey(element);
    }

    /* renamed from: i, reason: from getter */
    public final Object getFirstElement() {
        return this.firstElement;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new d(this.firstElement, this.hashMap);
    }

    public final f0.d<E, C4087a> j() {
        return this.hashMap;
    }

    /* renamed from: k, reason: from getter */
    public final Object getLastElement() {
        return this.lastElement;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Collection, java.util.Set, d0.f
    public f<E> remove(E element) {
        C4087a c4087a = this.hashMap.get(element);
        if (c4087a == null) {
            return this;
        }
        f0.d dVarV = this.hashMap.v(element);
        if (c4087a.b()) {
            V v10 = dVarV.get(c4087a.getPrevious());
            p.f(v10);
            dVarV = dVarV.u(c4087a.getPrevious(), ((C4087a) v10).e(c4087a.getNext()));
        }
        if (c4087a.a()) {
            V v11 = dVarV.get(c4087a.getNext());
            p.f(v11);
            dVarV = dVarV.u(c4087a.getNext(), ((C4087a) v11).f(c4087a.getPrevious()));
        }
        return new C4088b(!c4087a.b() ? c4087a.getNext() : this.firstElement, !c4087a.a() ? c4087a.getPrevious() : this.lastElement, dVarV);
    }

    @Override // java.util.Collection, java.util.Set, d0.f
    public f<E> removeAll(Collection<? extends E> elements) {
        f.a<E> aVarBuilder = builder();
        aVarBuilder.removeAll(elements);
        return aVarBuilder.build();
    }
}
