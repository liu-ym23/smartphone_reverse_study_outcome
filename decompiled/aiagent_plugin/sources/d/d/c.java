package d.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.h.b.o;
import java.io.Serializable;
import java.lang.Enum;

/* JADX INFO: compiled from: EnumEntries.kt */
/* JADX INFO: loaded from: classes4.dex */
final class c<T extends Enum<T>> extends d.a.c<T> implements a<T>, Serializable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final T[] f38427b;

    @Override // d.a.a, java.util.Collection
    public final boolean contains(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Enum.class) == true) goto L7;
        return false;
    L7:
        return a((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.a.c, java.util.List
    public /* synthetic */ Object get(int r1) {
        return a(r1);
    }

    @Override // d.a.c, java.util.List
    public final int indexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Enum.class) == true) goto L7;
        return -1;
    L7:
        return b((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin"));
    }

    @Override // d.a.c, java.util.List
    public final int lastIndexOf(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, Enum.class) == true) goto L7;
        return -1;
    L7:
        return c((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.aiagent.plugin"));
    }

    public c(T[] r2) {
        o.e(r2, "entries");
        this.f38427b = r2;
    }

    @Override // d.a.a
    public int a() {
        return this.f38427b.length;
    }

    public T a(int r3) {
        d.a.c.f38373a.a(r3, this.f38427b.length);
        return this.f38427b[r3];
    }

    public boolean a(T r3) {
        o.e(r3, "element");
        if (((Enum) ZeusTransformUtils.preCheckCast(i.b(this.f38427b, r3.ordinal()), Enum.class, "com.obric.aiagent.plugin")) != r3) goto L5;
        return true;
    L5:
        return false;
    }

    public int b(T r4) {
        o.e(r4, "element");
        int r0 = r4.ordinal();
        if (((Enum) ZeusTransformUtils.preCheckCast(i.b(this.f38427b, r0), Enum.class, "com.obric.aiagent.plugin")) == r4) goto L7;
        return -1;
    L7:
        return r0;
    }

    public int c(T r2) {
        o.e(r2, "element");
        return indexOf(r2);
    }
}
