package N;

import androidx.datastore.preferences.protobuf.A;
import androidx.datastore.preferences.protobuf.AbstractC0481a;
import androidx.datastore.preferences.protobuf.AbstractC0504y;
import androidx.datastore.preferences.protobuf.T;
import androidx.datastore.preferences.protobuf.a0;
import java.util.List;

/* loaded from: classes.dex */
public final class g extends AbstractC0504y<g, a> implements T {
    private static final g DEFAULT_INSTANCE;
    private static volatile a0<g> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private A.i<String> strings_ = AbstractC0504y.x();

    public static final class a extends AbstractC0504y.a<g, a> implements T {
        /* synthetic */ a(e eVar) {
            this();
        }

        public a B(Iterable<String> iterable) {
            w();
            ((g) this.f10264b).M(iterable);
            return this;
        }

        private a() {
            super(g.DEFAULT_INSTANCE);
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        AbstractC0504y.I(g.class, gVar);
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(Iterable<String> iterable) {
        N();
        AbstractC0481a.a(iterable, this.strings_);
    }

    private void N() {
        if (this.strings_.l()) {
            return;
        }
        this.strings_ = AbstractC0504y.D(this.strings_);
    }

    public static g O() {
        return DEFAULT_INSTANCE;
    }

    public static a Q() {
        return DEFAULT_INSTANCE.t();
    }

    public List<String> P() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractC0504y
    protected final Object w(AbstractC0504y.f fVar, Object obj, Object obj2) {
        a0 bVar;
        int i5 = e.f4171a[fVar.ordinal()];
        e eVar = null;
        switch (i5) {
            case 1:
                return new g();
            case 2:
                return new a(eVar);
            case 3:
                return AbstractC0504y.F(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                a0<g> a0Var = PARSER;
                if (a0Var != null) {
                    return a0Var;
                }
                synchronized (g.class) {
                    try {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new AbstractC0504y.b(DEFAULT_INSTANCE);
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
