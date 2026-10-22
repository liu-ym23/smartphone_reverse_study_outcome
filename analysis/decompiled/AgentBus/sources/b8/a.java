package b8;

import d7.s;
import e9.b;
import e9.c;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import o8.x;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final LinkedHashSet f1547a;

    /* renamed from: b, reason: collision with root package name */
    public static final b f1548b;

    static {
        List listU0 = s.u0(x.f7858a, x.f7865h, x.f7866i, x.f7860c, x.f7861d, x.f7863f);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listU0.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(b.j((c) it.next()));
        }
        f1547a = linkedHashSet;
        f1548b = b.j(x.f7864g);
    }
}
