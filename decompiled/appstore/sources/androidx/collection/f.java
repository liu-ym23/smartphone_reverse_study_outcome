package androidx.collection;

import java.util.Iterator;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static final class a implements Iterator, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f1228b;

        public a(e r10) {
            this.f1228b = r10;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f1227a >= this.f1228b.n()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            e r10 = this.f1228b;
            int r11 = this.f1227a;
            this.f1227a = r11 + 1;
            return r10.o(r11);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final Iterator a(e r10) {
        q.h(r10, "receiver$0");
        return new a(r10);
    }
}
