package androidx.datastore.preferences;

import L0.c;
import androidx.datastore.preferences.protobuf.AbstractC1338a;
import androidx.datastore.preferences.protobuf.C1359w;
import androidx.datastore.preferences.protobuf.GeneratedMessageLite;
import androidx.datastore.preferences.protobuf.L;
import androidx.datastore.preferences.protobuf.T;
import java.util.List;

/* loaded from: classes.dex */
public final class a extends GeneratedMessageLite<a, C0163a> implements L {
    private static final a DEFAULT_INSTANCE;
    private static volatile T<a> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private C1359w.i<String> strings_ = GeneratedMessageLite.p();

    /* renamed from: androidx.datastore.preferences.a$a, reason: collision with other inner class name */
    public static final class C0163a extends GeneratedMessageLite.a<a, C0163a> implements L {
        public /* synthetic */ C0163a(c cVar) {
            this();
        }

        public C0163a t(Iterable<String> iterable) {
            o();
            ((a) this.f13448b).E(iterable);
            return this;
        }

        public C0163a() {
            super(a.DEFAULT_INSTANCE);
        }
    }

    static {
        a aVar = new a();
        DEFAULT_INSTANCE = aVar;
        GeneratedMessageLite.A(a.class, aVar);
    }

    public static a G() {
        return DEFAULT_INSTANCE;
    }

    public static C0163a I() {
        return DEFAULT_INSTANCE.k();
    }

    public final void E(Iterable<String> iterable) {
        F();
        AbstractC1338a.b(iterable, this.strings_);
    }

    public final void F() {
        if (this.strings_.isModifiable()) {
            return;
        }
        this.strings_ = GeneratedMessageLite.v(this.strings_);
    }

    public List<String> H() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.GeneratedMessageLite
    public final Object o(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        T bVar;
        int i10 = c.f4259a[methodToInvoke.ordinal()];
        c cVar = null;
        switch (i10) {
            case 1:
                return new a();
            case 2:
                return new C0163a(cVar);
            case 3:
                return GeneratedMessageLite.x(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                T<a> t10 = PARSER;
                if (t10 != null) {
                    return t10;
                }
                synchronized (a.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new GeneratedMessageLite.b(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
