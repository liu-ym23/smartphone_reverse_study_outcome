package d.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ReadWrite.kt */
/* JADX INFO: loaded from: classes4.dex */
final class p implements d.n.j<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BufferedReader f38468a;

    /* JADX INFO: compiled from: ReadWrite.kt */
    public static final class a implements d.h.b.a.a, Iterator<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f38469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f38470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f38471c;

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        a(p r1) {
            this.f38469a = r1;
        }

        @Override // java.util.Iterator
        public /* synthetic */ String next() {
            return a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f38470b != null) goto L10;
            if (this.f38471c == true) goto L10;
            String r0 = p.a(this.f38469a).readLine();
            this.f38470b = r0;
            if (r0 != null) goto L10;
            this.f38471c = true;
        L10:
            if (this.f38470b != null) goto L14;
            return false;
        L14:
            return true;
        }

        public String a() {
            if (hasNext() == false) goto L7;
            String r0 = this.f38470b;
            this.f38470b = null;
            d.h.b.o.a(r0);
            return r0;
        L7:
            throw new NoSuchElementException();
        }
    }

    public p(BufferedReader r2) {
        d.h.b.o.e(r2, "reader");
        this.f38468a = r2;
    }

    public static final /* synthetic */ BufferedReader a(p r0) {
        return r0.f38468a;
    }

    @Override // d.n.j
    public Iterator<String> a() {
        return (Iterator) ZeusTransformUtils.preCheckCast(new a(this), Iterator.class, "com.obric.aiagent.plugin");
    }
}
