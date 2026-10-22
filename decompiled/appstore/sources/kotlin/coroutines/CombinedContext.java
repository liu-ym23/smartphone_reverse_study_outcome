package kotlin.coroutines;

import com.bytedanceos.common.model.AppInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@SinceKotlin(version = "1.3")
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001!B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0000H\u0002J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J5\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\u0011\u001a\u0002H\u00102\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u0002H\u00100\u0013H\u0016¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\b\b\u0000\u0010\u0016*\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00160\u0018H\u0096\u0002¢\u0006\u0002\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u00012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lkotlin/coroutines/CombinedContext;", "Lkotlin/coroutines/CoroutineContext;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "left", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)V", "contains", "", "containsAll", "context", "equals", AppInfo.SEARCH_SOURCE_EXTENAL, "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "hashCode", "", "minusKey", "size", "toString", "", "writeReplace", "Serialized", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,196:1\n1#2:197\n*E\n"})
public final class CombinedContext implements CoroutineContext, Serializable {

    @NotNull
    private final CoroutineContext.Element element;

    @NotNull
    private final CoroutineContext left;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000fB\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lkotlin/coroutines/CombinedContext$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "Lkotlin/coroutines/CoroutineContext;", "elements", "<init>", "([Lkotlin/coroutines/CoroutineContext;)V", "", "readResolve", "()Ljava/lang/Object;", "[Lkotlin/coroutines/CoroutineContext;", "getElements", "()[Lkotlin/coroutines/CoroutineContext;", "Companion", "a", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @SourceDebugExtension({"SMAP\nCoroutineContextImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,196:1\n12720#2,3:197\n*S KotlinDebug\n*F\n+ 1 CoroutineContextImpl.kt\nkotlin/coroutines/CombinedContext$Serialized\n*L\n193#1:197,3\n*E\n"})
    public static final class Serialized implements Serializable {

        @NotNull
        public static final a Companion = null;
        private static final long serialVersionUID = 0;

        @NotNull
        private final CoroutineContext[] elements;

        public static final class a {
            public /* synthetic */ a(DefaultConstructorMarker r10) {
                this();
            }

            public a() {
            }
        }

        static {
            Companion = new a(null);
        }

        public Serialized(@NotNull CoroutineContext[] r10) {
            q.g(r10, "elements");
            this.elements = r10;
        }

        private final Object readResolve() {
            CoroutineContext[] r10 = this.elements;
            CoroutineContext r11 = EmptyCoroutineContext.INSTANCE;
            int r12 = r10.length;
            int r13 = 0;
        L3:
            if (r13 >= r12) goto L5;
            r11 = r11.plus(r10[r13]);
            r13 = r13 + 1;
            goto L3
        L5:
            return r11;
        }

        @NotNull
        public final CoroutineContext[] getElements() {
            return this.elements;
        }
    }

    public CombinedContext(@NotNull CoroutineContext r10, @NotNull CoroutineContext.Element r11) {
        q.g(r10, "left");
        q.g(r11, "element");
        this.left = r10;
        this.element = r11;
    }

    private final boolean contains(CoroutineContext.Element r10) {
        return q.b(get(r10.getKey()), r10);
    }

    private final boolean containsAll(CombinedContext r10) {
    L3:
        if (contains(r10.element) == false) goto L4;
        CoroutineContext r11 = r10.left;
        if ((r11 instanceof CombinedContext) == false) goto L9;
        r10 = (CombinedContext) r11;
        goto L3
    L9:
        q.e(r11, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
        return contains((CoroutineContext.Element) r11);
    L4:
        return false;
    }

    private final int size() {
        int r10 = 2;
    L3:
        CoroutineContext r11 = this.left;
        if ((r11 instanceof CombinedContext) == false) goto L6;
        CombinedContext this = (CombinedContext) r11;
    L7:
        if (this == null) goto L8;
        r10 = r10 + 1;
        goto L3
    L8:
        return r10;
    L6:
        this = null;
        goto L7
    }

    private final Object writeReplace() {
        int r10 = size();
        final CoroutineContext[] r11 = new CoroutineContext[r10];
        final Ref$IntRef r12 = new Ref$IntRef();
        fold(Unit.f21064a, new C04531(r11, r12));
        if (r12.element != r10) goto L7;
        return new Serialized(r11);
    L7:
        throw new IllegalStateException("Check failed.");
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L4;
    L11:
        return true;
    L4:
        if ((r10 instanceof CombinedContext) == false) goto L10;
        CombinedContext r11 = (CombinedContext) r10;
        if (r11.size() != size()) goto L10;
        if (r11.containsAll(this) == true) goto L11;
    L10:
        return false;
    }

    @Override // kotlin.coroutines.CoroutineContext
    public <R> R fold(R r10, @NotNull Function2<? super R, ? super CoroutineContext.Element, ? extends R> r11) {
        q.g(r11, "operation");
        return r11.mo0invoke((Object) this.left.fold(r10, r11), this.element);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.Element> E get(@NotNull CoroutineContext.Key<E> r10) {
        q.g(r10, "key");
    L3:
        E r11 = (E) this.element.get(r10);
        if (r11 != null) goto L5;
        CoroutineContext r12 = this.left;
        if ((r12 instanceof CombinedContext) == false) goto L10;
        CombinedContext this = (CombinedContext) r12;
        goto L3
    L10:
        return (E) r12.get(r10);
    L5:
        return r11;
    }

    public int hashCode() {
        return this.left.hashCode() + this.element.hashCode();
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.Key<?> r10) {
        q.g(r10, "key");
        if (this.element.get(r10) != null) goto L5;
        CoroutineContext r11 = this.left.minusKey(r10);
        if (r11 != this.left) goto L10;
        return this;
    L10:
        if (r11 != EmptyCoroutineContext.INSTANCE) goto L13;
        return this.element;
    L13:
        return new CombinedContext(r11, this.element);
    L5:
        return this.left;
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext r10) {
        return CoroutineContext.DefaultImpls.a(this, r10);
    }

    @NotNull
    public String toString() {
        return '[' + ((String) fold("", AnonymousClass1.INSTANCE)) + ']';
    }
}
