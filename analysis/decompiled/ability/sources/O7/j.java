package O7;

import D7.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.k;

/* loaded from: classes3.dex */
public final class j implements Iterator, T7.a {

    /* renamed from: a, reason: collision with root package name */
    public String f1041a;
    public boolean b;
    public final /* synthetic */ t c;

    public j(t tVar) {
        this.c = tVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.f1041a == null && !this.b) {
            String line = ((BufferedReader) this.c.b).readLine();
            this.f1041a = line;
            if (line == null) {
                this.b = true;
            }
        }
        return this.f1041a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f1041a;
        this.f1041a = null;
        k.c(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
