package n7;

import d7.q;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class n implements Iterator, r7.a {

    /* renamed from: f, reason: collision with root package name */
    public String f6872f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f6873g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ q f6874h;

    public n(q qVar) {
        this.f6874h = qVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.f6872f == null && !this.f6873g) {
            String line = ((BufferedReader) this.f6874h.f2976b).readLine();
            this.f6872f = line;
            if (line == null) {
                this.f6873g = true;
            }
        }
        return this.f6872f != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f6872f;
        this.f6872f = null;
        q7.k.b(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
