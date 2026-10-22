package kotlin.reflect.jvm.internal.impl.builtins.jvm;

import C9.j;
import G9.c;
import kotlin.jvm.internal.i;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* loaded from: classes5.dex */
public final class b extends j {

    /* renamed from: h, reason: collision with root package name */
    public static final a f34999h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final j f35000i = new b();

    public static final class a {
        public /* synthetic */ a(i iVar) {
            this();
        }

        public final j a() {
            return b.f35000i;
        }

        public a() {
        }
    }

    public b() {
        super(new LockBasedStorageManager("FallbackBuiltIns"));
        f(true);
    }

    @Override // C9.j
    /* renamed from: H0, reason: merged with bridge method [inline-methods] */
    public c.a N() {
        return c.a.f2868a;
    }
}
