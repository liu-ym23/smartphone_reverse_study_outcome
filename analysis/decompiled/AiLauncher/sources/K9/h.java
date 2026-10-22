package K9;

import Z9.InterfaceC1179b;
import java.lang.annotation.Annotation;

/* loaded from: classes5.dex */
public abstract class h implements InterfaceC1179b {

    /* renamed from: b, reason: collision with root package name */
    public static final a f4176b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final ga.e f4177a;

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final h a(Object value, ga.e eVar) {
            kotlin.jvm.internal.p.i(value, "value");
            return C0925f.l(value.getClass()) ? new u(eVar, (Enum) value) : value instanceof Annotation ? new i(eVar, (Annotation) value) : value instanceof Object[] ? new l(eVar, (Object[]) value) : value instanceof Class ? new q(eVar, (Class) value) : new w(eVar, value);
        }

        public a() {
        }
    }

    public /* synthetic */ h(ga.e eVar, kotlin.jvm.internal.i iVar) {
        this(eVar);
    }

    @Override // Z9.InterfaceC1179b
    public ga.e getName() {
        return this.f4177a;
    }

    public h(ga.e eVar) {
        this.f4177a = eVar;
    }
}
