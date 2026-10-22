package kotlin.coroutines;

import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.coroutines.CombinedContext;
import kotlin.coroutines.d;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u00013B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u0013\u001a\u00020\u00122\n\u0010\u0011\u001a\u00060\u000fj\u0002`\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J*\u0010\u0018\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0015*\u00020\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00028\u00002\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010 \u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0016¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\fH\u0096\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\u000bJ\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020#2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0000H\u0002¢\u0006\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/d;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "Lkotlin/coroutines/d$b;", "element", "<init>", "(Lkotlin/coroutines/d;Lkotlin/coroutines/d$b;)V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()I", "", "writeReplace", "()Ljava/lang/Object;", "Ljava/io/ObjectInputStream;", "Lkotlin/internal/ReadObjectParameterType;", "input", "LY8/t;", "readObject", "(Ljava/io/ObjectInputStream;)V", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/d$c;", "key", "get", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d$b;", "R", "initial", "Lkotlin/Function2;", "operation", "fold", "(Ljava/lang/Object;Lp9/p;)Ljava/lang/Object;", "minusKey", "(Lkotlin/coroutines/d$c;)Lkotlin/coroutines/d;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "", "toString", "()Ljava/lang/String;", Const.INTENT_KEY_UMID, "(Lkotlin/coroutines/d$b;)Z", "context", "f", "(Lkotlin/coroutines/CombinedContext;)Z", Const.INTENT_KEY_APIKEY, "Lkotlin/coroutines/d;", Const.INTENT_KEY_PKGNAME, "Lkotlin/coroutines/d$b;", "Serialized", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CombinedContext implements d, Serializable {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final d left;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final d.b element;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000bB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "Lkotlin/coroutines/d;", "elements", "<init>", "([Lkotlin/coroutines/d;)V", "", "readResolve", "()Ljava/lang/Object;", Const.INTENT_KEY_APIKEY, "[Lkotlin/coroutines/d;", "getElements", "()[Lkotlin/coroutines/d;", Const.INTENT_KEY_PKGNAME, "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        public final d[] elements;

        public Serialized(d[] elements) {
            p.i(elements, "elements");
            this.elements = elements;
        }

        private final Object readResolve() {
            d[] dVarArr = this.elements;
            d dVarPlus = EmptyCoroutineContext.f34779a;
            for (d dVar : dVarArr) {
                dVarPlus = dVarPlus.plus(dVar);
            }
            return dVarPlus;
        }
    }

    public CombinedContext(d left, d.b element) {
        p.i(left, "left");
        p.i(element, "element");
        this.left = left;
        this.element = element;
    }

    private final int h() {
        int i10 = 2;
        while (true) {
            d dVar = this.left;
            this = dVar instanceof CombinedContext ? (CombinedContext) dVar : null;
            if (this == null) {
                return i10;
            }
            i10++;
        }
    }

    public static final String j(String acc, d.b element) {
        p.i(acc, "acc");
        p.i(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    public static final t k(d[] dVarArr, Ref$IntRef ref$IntRef, t tVar, d.b element) {
        p.i(tVar, "<unused var>");
        p.i(element, "element");
        int i10 = ref$IntRef.f34818a;
        ref$IntRef.f34818a = i10 + 1;
        dVarArr[i10] = element;
        return t.f7040a;
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    private final Object writeReplace() {
        int iH = h();
        final d[] dVarArr = new d[iH];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        fold(t.f7040a, new p9.p() { // from class: e9.a
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.k(dVarArr, ref$IntRef, (t) obj, (d.b) obj2);
            }
        });
        if (ref$IntRef.f34818a == iH) {
            return new Serialized(dVarArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    public final boolean d(d.b element) {
        return p.d(get(element.getKey()), element);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CombinedContext)) {
            return false;
        }
        CombinedContext combinedContext = (CombinedContext) other;
        return combinedContext.h() == h() && combinedContext.f(this);
    }

    public final boolean f(CombinedContext context) {
        while (d(context.element)) {
            d dVar = context.left;
            if (!(dVar instanceof CombinedContext)) {
                p.g(dVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return d((d.b) dVar);
            }
            context = (CombinedContext) dVar;
        }
        return false;
    }

    @Override // kotlin.coroutines.d
    public <R> R fold(R initial, p9.p<? super R, ? super d.b, ? extends R> operation) {
        p.i(operation, "operation");
        return operation.invoke((Object) this.left.fold(initial, operation), this.element);
    }

    @Override // kotlin.coroutines.d
    public <E extends d.b> E get(d.c<E> key) {
        p.i(key, "key");
        while (true) {
            E e10 = (E) this.element.get(key);
            if (e10 != null) {
                return e10;
            }
            d dVar = this.left;
            if (!(dVar instanceof CombinedContext)) {
                return (E) dVar.get(key);
            }
            this = (CombinedContext) dVar;
        }
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.d
    public d minusKey(d.c<?> key) {
        p.i(key, "key");
        if (this.element.get(key) != null) {
            return this.left;
        }
        d dVarMinusKey = this.left.minusKey(key);
        return dVarMinusKey == this.left ? this : dVarMinusKey == EmptyCoroutineContext.f34779a ? this.element : new CombinedContext(dVarMinusKey, this.element);
    }

    @Override // kotlin.coroutines.d
    public /* bridge */ d plus(d dVar) {
        return d.a.b(this, dVar);
    }

    public String toString() {
        return '[' + ((String) fold("", new p9.p() { // from class: e9.b
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return CombinedContext.j((String) obj, (d.b) obj2);
            }
        })) + ']';
    }
}
