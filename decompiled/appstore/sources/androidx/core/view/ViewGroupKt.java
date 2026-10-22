package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.sequences.Sequence;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewGroupKt {

    public static final class a implements Sequence {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2700a;

        public a(ViewGroup r10) {
            this.f2700a = r10;
        }

        @Override // kotlin.sequences.Sequence
        public Iterator iterator() {
            return ViewGroupKt.c(this.f2700a);
        }
    }

    public static final class b implements Iterator, KMutableIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f2701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ViewGroup f2702b;

        public b(ViewGroup r10) {
            this.f2702b = r10;
        }

        public View a() {
            ViewGroup r10 = this.f2702b;
            int r11 = this.f2701a;
            this.f2701a = r11 + 1;
            View r12 = r10.getChildAt(r11);
            if (r12 == null) goto L6;
            return r12;
        L6:
            throw new IndexOutOfBoundsException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f2701a >= this.f2702b.getChildCount()) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ Object next() {
            return a();
        }

        @Override // java.util.Iterator
        public void remove() {
            ViewGroup r10 = this.f2702b;
            int r11 = this.f2701a - 1;
            this.f2701a = r11;
            r10.removeViewAt(r11);
        }
    }

    public static final Sequence a(ViewGroup r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new a(r10);
    }

    public static final Sequence b(ViewGroup r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return kotlin.sequences.h.b(new ViewGroupKt$descendants$1(r10, null));
    }

    public static final Iterator c(ViewGroup r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return new b(r10);
    }
}
