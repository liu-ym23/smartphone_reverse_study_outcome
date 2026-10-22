package ma;

import E9.InterfaceC0819y;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;

/* loaded from: classes5.dex */
public abstract class l extends AbstractC4927g<Y8.t> {

    /* renamed from: b, reason: collision with root package name */
    public static final a f37198b = new a(null);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final l a(String message) {
            kotlin.jvm.internal.p.i(message, "message");
            return new b(message);
        }

        public a() {
        }
    }

    public static final class b extends l {

        /* renamed from: c, reason: collision with root package name */
        public final String f37199c;

        public b(String message) {
            kotlin.jvm.internal.p.i(message, "message");
            this.f37199c = message;
        }

        @Override // ma.AbstractC4927g
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Aa.g a(InterfaceC0819y module) {
            kotlin.jvm.internal.p.i(module, "module");
            return Aa.i.d(ErrorTypeKind.ERROR_CONSTANT_VALUE, this.f37199c);
        }

        @Override // ma.AbstractC4927g
        public String toString() {
            return this.f37199c;
        }
    }

    public l() {
        super(Y8.t.f7040a);
    }

    @Override // ma.AbstractC4927g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Y8.t b() {
        throw new UnsupportedOperationException();
    }
}
