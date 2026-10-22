package A8;

import ca.AbstractC0897f;
import java.security.AccessControlException;
import java.util.HashMap;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader$Kind;
import m8.C1681a;
import q8.u;
import z8.n;
import z8.p;

/* loaded from: classes4.dex */
public final class f implements p {
    public static final boolean i;

    /* renamed from: j, reason: collision with root package name */
    public static final HashMap f162j;

    /* renamed from: a, reason: collision with root package name */
    public int[] f163a;
    public String b;
    public int c;
    public String[] d;
    public String[] e;
    public String[] f;
    public KotlinClassHeader$Kind g;
    public String[] h;

    static {
        try {
            i = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        } catch (AccessControlException unused) {
            i = false;
        }
        HashMap map = new HashMap();
        f162j = map;
        map.put(AbstractC0897f.N(new G8.c("kotlin.jvm.internal.KotlinClass")), KotlinClassHeader$Kind.e);
        map.put(AbstractC0897f.N(new G8.c("kotlin.jvm.internal.KotlinFileFacade")), KotlinClassHeader$Kind.f);
        map.put(AbstractC0897f.N(new G8.c("kotlin.jvm.internal.KotlinMultifileClass")), KotlinClassHeader$Kind.h);
        map.put(AbstractC0897f.N(new G8.c("kotlin.jvm.internal.KotlinMultifileClassPart")), KotlinClassHeader$Kind.i);
        map.put(AbstractC0897f.N(new G8.c("kotlin.jvm.internal.KotlinSyntheticClass")), KotlinClassHeader$Kind.g);
    }

    @Override // z8.p
    public final n c(G8.b bVar, C1681a c1681a) {
        KotlinClassHeader$Kind kotlinClassHeader$Kind;
        G8.c cVarA = bVar.a();
        if (cVarA.equals(u.f5611a)) {
            return new d(this, 0);
        }
        if (cVarA.equals(u.o)) {
            return new Z0.a(this);
        }
        if (i || this.g != null || (kotlinClassHeader$Kind = (KotlinClassHeader$Kind) f162j.get(bVar)) == null) {
            return null;
        }
        this.g = kotlinClassHeader$Kind;
        return new a5.d(this, 1);
    }
}
