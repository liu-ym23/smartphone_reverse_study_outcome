package kotlin;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h implements Collection, KMappedMarker {

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f21128a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f21129b;

        public a(int[] r10) {
            q.g(r10, "array");
            this.f21128a = r10;
        }

        public int a() {
            int r10 = this.f21129b;
            int[] r11 = this.f21128a;
            if (r10 >= r11.length) goto L7;
            this.f21129b = r10 + 1;
            return g.b(r11[r10]);
        L7:
            throw new NoSuchElementException(String.valueOf(this.f21129b));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f21129b >= this.f21128a.length) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return g.a(a());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static Iterator a(int[] r10) {
        return new a(r10);
    }
}
