package C9;

import kotlin.C4848b;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* loaded from: classes5.dex */
public final class g extends j {

    /* renamed from: h, reason: collision with root package name */
    public static final a f1776h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final Y8.h<g> f1777i = C4848b.b(f.f1775a);

    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final g a() {
            return (g) g.f1777i.getValue();
        }

        public a() {
        }
    }

    public g() {
        this(false, 1, null);
    }

    public static final g G0() {
        return new g(false, 1, null);
    }

    public g(boolean z10) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z10) {
            f(false);
        }
    }

    public /* synthetic */ g(boolean z10, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
