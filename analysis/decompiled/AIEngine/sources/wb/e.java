package wb;

import fc.i;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e implements i<String> {

    /* renamed from: a, reason: collision with root package name */
    public final BufferedReader f13671a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a implements Iterator<String>, ac.a {

        /* renamed from: a, reason: collision with root package name */
        public String f13672a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f13673b;

        public a() {
        }

        @Override // java.util.Iterator
        public final boolean hasNext() throws IOException {
            if (this.f13672a == null && !this.f13673b) {
                String line = e.this.f13671a.readLine();
                this.f13672a = line;
                if (line == null) {
                    this.f13673b = true;
                }
            }
            return this.f13672a != null;
        }

        @Override // java.util.Iterator
        public final String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String str = this.f13672a;
            this.f13672a = null;
            g.c(str);
            return str;
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public e(BufferedReader bufferedReader) {
        this.f13671a = bufferedReader;
    }

    @Override // fc.i
    public final Iterator<String> iterator() {
        return new a();
    }
}
