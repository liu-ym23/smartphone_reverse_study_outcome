package androidx.datastore.preferences.protobuf;

/* renamed from: androidx.datastore.preferences.protobuf.y, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1361y {

    /* renamed from: e, reason: collision with root package name */
    public static final C1351n f13650e = C1351n.b();

    /* renamed from: a, reason: collision with root package name */
    public ByteString f13651a;

    /* renamed from: b, reason: collision with root package name */
    public C1351n f13652b;

    /* renamed from: c, reason: collision with root package name */
    public volatile K f13653c;

    /* renamed from: d, reason: collision with root package name */
    public volatile ByteString f13654d;

    public void a(K k10) {
        if (this.f13653c != null) {
            return;
        }
        synchronized (this) {
            if (this.f13653c != null) {
                return;
            }
            try {
                if (this.f13651a != null) {
                    this.f13653c = k10.getParserForType().a(this.f13651a, this.f13652b);
                    this.f13654d = this.f13651a;
                } else {
                    this.f13653c = k10;
                    this.f13654d = ByteString.f13407b;
                }
            } catch (InvalidProtocolBufferException unused) {
                this.f13653c = k10;
                this.f13654d = ByteString.f13407b;
            }
        }
    }

    public int b() {
        if (this.f13654d != null) {
            return this.f13654d.size();
        }
        ByteString byteString = this.f13651a;
        if (byteString != null) {
            return byteString.size();
        }
        if (this.f13653c != null) {
            return this.f13653c.getSerializedSize();
        }
        return 0;
    }

    public K c(K k10) {
        a(k10);
        return this.f13653c;
    }

    public K d(K k10) {
        K k11 = this.f13653c;
        this.f13651a = null;
        this.f13654d = null;
        this.f13653c = k10;
        return k11;
    }

    public ByteString e() {
        if (this.f13654d != null) {
            return this.f13654d;
        }
        ByteString byteString = this.f13651a;
        if (byteString != null) {
            return byteString;
        }
        synchronized (this) {
            try {
                if (this.f13654d != null) {
                    return this.f13654d;
                }
                if (this.f13653c == null) {
                    this.f13654d = ByteString.f13407b;
                } else {
                    this.f13654d = this.f13653c.toByteString();
                }
                return this.f13654d;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1361y)) {
            return false;
        }
        C1361y c1361y = (C1361y) obj;
        K k10 = this.f13653c;
        K k11 = c1361y.f13653c;
        return (k10 == null && k11 == null) ? e().equals(c1361y.e()) : (k10 == null || k11 == null) ? k10 != null ? k10.equals(c1361y.c(k10.getDefaultInstanceForType())) : c(k11.getDefaultInstanceForType()).equals(k11) : k10.equals(k11);
    }

    public int hashCode() {
        return 1;
    }
}
