package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements Iterator, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public State f21066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f21067b;

    /* JADX INFO: renamed from: kotlin.collections.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0291a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21068a = null;

        static {
            int[] r10 = new int[State.values().length];
            r10[State.Done.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r10[State.Ready.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f21068a = r10;
        }
    }

    public a() {
        this.f21066a = State.NotReady;
    }

    public abstract void a();

    public final void b() {
        this.f21066a = State.Done;
    }

    public final void c(Object r10) {
        this.f21067b = r10;
        this.f21066a = State.Ready;
    }

    public final boolean d() {
        this.f21066a = State.Failed;
        a();
        if (this.f21066a != State.Ready) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State r10 = this.f21066a;
        if (r10 == State.Failed) goto L12;
        int r11 = C0291a.f21068a[r10.ordinal()];
        if (r11 != 1) goto L7;
        return false;
    L7:
        if (r11 != 2) goto L14;
        return true;
    L14:
        return d();
    L12:
        throw new IllegalArgumentException("Failed requirement.");
    }

    @Override // java.util.Iterator
    public Object next() {
        if (hasNext() == false) goto L7;
        this.f21066a = State.NotReady;
        return this.f21067b;
    L7:
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
