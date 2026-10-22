package Z;

import Z.g;
import android.content.Context;
import d0.InterfaceC0648c;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0648c.InterfaceC0205c f6531a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f6532b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6533c;

    /* renamed from: d, reason: collision with root package name */
    public final g.d f6534d;

    /* renamed from: e, reason: collision with root package name */
    public final List<g.b> f6535e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f6536f;

    /* renamed from: g, reason: collision with root package name */
    public final g.c f6537g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f6538h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f6539i;

    /* renamed from: j, reason: collision with root package name */
    private final Set<Integer> f6540j;

    public a(Context context, String str, InterfaceC0648c.InterfaceC0205c interfaceC0205c, g.d dVar, List<g.b> list, boolean z5, g.c cVar, Executor executor, boolean z6, Set<Integer> set) {
        this.f6531a = interfaceC0205c;
        this.f6532b = context;
        this.f6533c = str;
        this.f6534d = dVar;
        this.f6535e = list;
        this.f6536f = z5;
        this.f6537g = cVar;
        this.f6538h = executor;
        this.f6539i = z6;
        this.f6540j = set;
    }

    public boolean a(int i5) {
        if (!this.f6539i) {
            return false;
        }
        Set<Integer> set = this.f6540j;
        return set == null || !set.contains(Integer.valueOf(i5));
    }
}
