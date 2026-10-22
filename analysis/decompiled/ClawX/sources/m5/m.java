package m5;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m implements Iterator, q5.a {

    /* renamed from: a, reason: collision with root package name */
    public String f3926a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f3927b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c5.k f3928c;

    public m(c5.k kVar) {
        this.f3928c = kVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() throws IOException {
        if (this.f3926a == null && !this.f3927b) {
            String line = ((BufferedReader) this.f3928c.f1090b).readLine();
            this.f3926a = line;
            if (line == null) {
                this.f3927b = true;
            }
        }
        return this.f3926a != null;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        String str = this.f3926a;
        this.f3926a = null;
        p.b(str);
        return str;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
