package b78;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f17964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final buc.c f17965b;

    public final boolean a() {
        if (this.f17965b.b() < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        this.f17964a = r100;
        this.f17965b = buc.b.b();
    }

    public final void b(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "caller");
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        int r103 = this.f17965b.b();
        com.larus.audio.call.util.e.f289645a.i(this.f17964a, "[emitStateChange] target " + r102 + ", current " + r103 + ", from " + r101 + '.');
        if (r103 != r102) goto L9;
        return;
    L9:
        buc.c r104 = this.f17965b;
        r104.getClass();
        if (buc.c.f20768b.compareAndSet(r104, r103, r102) == false) goto L15;
        buc.f r105 = r104.f20769a;
        if (r105 == buc.f.a.f20774a) goto L16;
        r105.getClass();
        buc.f.a("CAS(" + r103 + ", " + r102 + ')');
        return;
    L16:
        return;
    L15:
        return;
    L5:
        r102 = -1;
        goto L6
    }
}
