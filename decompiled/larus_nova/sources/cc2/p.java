package cc2;

import cc2.o;
import com.bytedance.android.live.core.log.ALogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class p<T extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<T> f23221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<T> f23222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23224d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final n<T> f23225e;

    public static final class a {
    }

    static {
    }

    public abstract Set<T> b();

    public abstract Set<T> c();

    public final void d() {
        this.f23221a.clear();
        this.f23222b.clear();
        a(null, null);
    }

    public p(boolean r100, n<T> r101) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        this.f23224d = r100;
        this.f23225e = r101;
        this.f23221a = new LinkedHashSet();
        this.f23222b = new LinkedHashSet();
        this.f23223c = r100;
    }

    public final void a(T r100, Boolean r101) {
        boolean r102 = true;
        if ((!this.f23222b.isEmpty()) == false) goto L6;
        r102 = false;
    L10:
        if (r102 == this.f23223c) goto L23;
        this.f23223c = r102;
        StringBuilder r103 = new StringBuilder();
        String r104 = null;
        if (r100 == null) goto L14;
        String r105 = r100.a();
    L15:
        r103.append(r105);
        r103.append("'s visibility turn to ");
        r103.append(r102);
        r103.append(", cause ");
        if (r100 == null) goto L18;
        r104 = r100.b();
    L18:
        r103.append(r104);
        r103.append(" status turn to ");
        r103.append(r101);
        ALogger.i("VisibilityHelperLogger", r103.toString());
        if (r102 == false) goto L21;
        this.f23225e.a(r100, r101);
        return;
    L21:
        this.f23225e.b(r100, r101);
        return;
    L14:
        r105 = null;
        goto L15
    L23:
        return;
    L6:
        if ((!this.f23221a.isEmpty()) == true) goto L10;
        r102 = this.f23224d;
        goto L10
    }

    public final void e(T r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "factor");
        if (b().contains(r100) == false) goto L6;
        Set<T> r102 = this.f23222b;
    L8:
        if (r101 == false) goto L10;
        r102.add(r100);
    L11:
        a(r100, Boolean.valueOf(r101));
        return;
    L10:
        r102.remove(r100);
        goto L11
    L6:
        if (c().contains(r100) == false) goto L13;
        r102 = this.f23221a;
        goto L8
    }
}
