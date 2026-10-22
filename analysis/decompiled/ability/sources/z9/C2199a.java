package z9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.collections.EmptyList;

/* renamed from: z9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2199a {

    /* renamed from: a, reason: collision with root package name */
    public final String f6992a;
    public List b;
    public final ArrayList c;
    public final HashSet d;
    public final ArrayList e;
    public final ArrayList f;
    public final ArrayList g;

    public C2199a(String serialName) {
        kotlin.jvm.internal.k.f(serialName, "serialName");
        this.f6992a = serialName;
        this.b = EmptyList.f4893a;
        this.c = new ArrayList();
        this.d = new HashSet();
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
    }

    public static void a(C2199a c2199a, String elementName, g descriptor) {
        EmptyList annotations = EmptyList.f4893a;
        c2199a.getClass();
        kotlin.jvm.internal.k.f(elementName, "elementName");
        kotlin.jvm.internal.k.f(descriptor, "descriptor");
        kotlin.jvm.internal.k.f(annotations, "annotations");
        if (!c2199a.d.add(elementName)) {
            StringBuilder sbV = B7.a.v("Element with name '", elementName, "' is already registered in ");
            sbV.append(c2199a.f6992a);
            throw new IllegalArgumentException(sbV.toString().toString());
        }
        c2199a.c.add(elementName);
        c2199a.e.add(descriptor);
        c2199a.f.add(annotations);
        c2199a.g.add(false);
    }
}
