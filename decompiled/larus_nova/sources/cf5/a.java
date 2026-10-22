package cf5;

import gf5.b;
import gf5.c;
import gf5.e;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.TreeSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f23508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hf5.a f23509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public gf5.a f23510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f23511d;

    /* JADX INFO: renamed from: cf5.a$a, reason: collision with other inner class name */
    public static final class C0440a {
    }

    static {
    }

    public final gf5.a a() {
        gf5.a r100 = this.f23510c;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("addinContext");
        return null;
    L6:
        return r100;
    }

    public a() {
        this.f23508a = new ArrayList();
        this.f23509b = new hf5.a();
    }

    public final void b(Class r100, ff5.a r101) {
        Intrinsics.checkNotNullParameter(r100, "actionClass");
        Intrinsics.checkNotNullParameter(r101, "handler");
        if (this.f23511d == false) goto L6;
        tt5.a.k("Comment#CommentAddinHost", "can not register handler after host is destroyed!");
        return;
    L6:
        hf5.a r102 = this.f23509b;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "eventClass");
        Intrinsics.checkNotNullParameter(r101, "handler");
        tt5.a.b("Comment#OrderedEventManager", "registerHandler()... eventClass = " + r100 + ", handler = " + r101);
        TreeSet<e<c>> r103 = (TreeSet) ((LinkedHashMap) r102.f484923a).get(r100);
        if (r103 != null) goto L9;
        r103 = new TreeSet(hf5.b.f484924a);
        r102.f484923a.put(r100, r103);
    L9:
        r103.add(r101);
    }
}
