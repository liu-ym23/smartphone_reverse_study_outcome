package g9;

import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes.dex */
public enum h {
    VISIBILITY(true),
    MODALITY(true),
    OVERRIDE(true),
    ANNOTATIONS(false),
    INNER(true),
    MEMBER_KIND(true),
    DATA(true),
    INLINE(true),
    EXPECT(true),
    ACTUAL(true),
    CONST(true),
    LATEINIT(true),
    FUN(true),
    VALUE(true);


    /* renamed from: g, reason: collision with root package name */
    public static final Set f3944g;

    /* renamed from: h, reason: collision with root package name */
    public static final Set f3945h;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f3961f;

    static {
        h[] hVarArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (h hVar : hVarArrValues) {
            if (hVar.f3961f) {
                arrayList.add(hVar);
            }
        }
        f3944g = d7.r.q1(arrayList);
        f3945h = d7.n.x0(values());
    }

    h(boolean z4) {
        this.f3961f = z4;
    }
}
