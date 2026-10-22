package androidx.datastore.preferences.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f460a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f461b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final int f462c;
    public final /* synthetic */ Object d;

    public d(g gVar) {
        this.d = gVar;
        this.f462c = gVar.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f460a) {
            case 0:
                if (this.f461b < this.f462c) {
                }
                break;
            default:
                if (this.f461b < this.f462c) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f460a) {
            case 0:
                int i8 = this.f461b;
                if (i8 >= this.f462c) {
                    throw new NoSuchElementException();
                }
                this.f461b = i8 + 1;
                return Byte.valueOf(((g) this.d).k(i8));
            default:
                int i9 = this.f461b;
                if (i9 >= this.f462c) {
                    throw new NoSuchElementException();
                }
                this.f461b = i9 + 1;
                return Byte.valueOf(((com.google.crypto.tink.shaded.protobuf.h) this.d).l(i9));
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f460a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public d(com.google.crypto.tink.shaded.protobuf.h hVar) {
        this.d = hVar;
        this.f462c = hVar.size();
    }
}
