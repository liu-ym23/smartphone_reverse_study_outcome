package vc;

import java.util.ArrayList;
import java.util.HashSet;
import kb.s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f14867a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f14868b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final HashSet f14869c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f14870d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f14871e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14872f = new ArrayList();

    public a(String str) {
        this.f14867a = str;
    }

    public static void a(a aVar, String str, e eVar) {
        aVar.getClass();
        eVar.getClass();
        if (!aVar.f14869c.add(str)) {
            StringBuilder sbO = androidx.activity.b.o("Element with name '", str, "' is already registered in ");
            sbO.append(aVar.f14867a);
            throw new IllegalArgumentException(sbO.toString().toString());
        }
        aVar.f14868b.add(str);
        aVar.f14870d.add(eVar);
        aVar.f14871e.add(s.f7404c);
        aVar.f14872f.add(false);
    }
}
