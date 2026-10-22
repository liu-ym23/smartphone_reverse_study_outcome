package androidx.lifecycle.a;

import androidx.lifecycle.aj;
import androidx.lifecycle.am;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: InitializerViewModelFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b implements am.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e<?>[] f1968a;

    public b(e<?>... r2) {
        o.e(r2, "initializers");
        this.f1968a = r2;
    }

    @Override // androidx.lifecycle.am.b
    public <T extends aj> T a(Class<T> r7, a r8) {
        o.e(r7, "modelClass");
        o.e(r8, "extras");
        e<?>[] r6 = this.f1968a;
        int r0 = r6.length;
        int r2 = 0;
        T r3 = null;
    L3:
        if (r2 >= r0) goto L11;
        e<?> r4 = r6[r2];
        if (o.a(r4.a(), r7) == false) goto L10;
        T r5 = r4.b().invoke(r8);
        if (ZeusTransformUtils.instanceOf(r5, aj.class) == false) goto L9;
        r3 = (T) ZeusTransformUtils.preCheckCast(r5, aj.class, "com.obric.aiagent.plugin");
        goto L10
    L9:
        r3 = null;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        if (r3 == null) goto L14;
        return r3;
    L14:
        throw new IllegalArgumentException("No initializer set for given class " + r7.getName());
    }
}
