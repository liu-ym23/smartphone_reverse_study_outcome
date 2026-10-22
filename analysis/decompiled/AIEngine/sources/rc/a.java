package rc;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.EmptyList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11769a;

    /* renamed from: b, reason: collision with root package name */
    public List<? extends Annotation> f11770b = EmptyList.f10001a;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11771c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final HashSet f11772d = new HashSet();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f11773e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f11774f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f11775g = new ArrayList();

    public a(String str) {
        this.f11769a = str;
    }

    public static void a(a aVar, String str, uc.j jVar) {
        EmptyList annotations = EmptyList.f10001a;
        aVar.getClass();
        kotlin.jvm.internal.g.f(annotations, "annotations");
        if (!aVar.f11772d.add(str)) {
            StringBuilder sbQ = a0.a.q("Element with name '", str, "' is already registered in ");
            sbQ.append(aVar.f11769a);
            throw new IllegalArgumentException(sbQ.toString().toString());
        }
        aVar.f11771c.add(str);
        aVar.f11773e.add(jVar);
        aVar.f11774f.add(annotations);
        aVar.f11775g.add(false);
    }
}
