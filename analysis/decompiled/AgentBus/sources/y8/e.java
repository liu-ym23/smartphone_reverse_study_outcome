package y8;

import java.util.HashMap;
import o8.x;
import x8.k;
import x8.m;

/* loaded from: classes.dex */
public final class e implements m {

    /* renamed from: n, reason: collision with root package name */
    public static final boolean f11713n = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));

    /* renamed from: o, reason: collision with root package name */
    public static final HashMap f11714o;

    /* renamed from: f, reason: collision with root package name */
    public int[] f11715f;

    /* renamed from: g, reason: collision with root package name */
    public String f11716g;

    /* renamed from: h, reason: collision with root package name */
    public int f11717h;

    /* renamed from: i, reason: collision with root package name */
    public String[] f11718i;

    /* renamed from: j, reason: collision with root package name */
    public String[] f11719j;

    /* renamed from: k, reason: collision with root package name */
    public String[] f11720k;

    /* renamed from: l, reason: collision with root package name */
    public a f11721l;

    /* renamed from: m, reason: collision with root package name */
    public String[] f11722m;

    static {
        HashMap map = new HashMap();
        f11714o = map;
        map.put(e9.b.j(new e9.c("kotlin.jvm.internal.KotlinClass")), a.CLASS);
        map.put(e9.b.j(new e9.c("kotlin.jvm.internal.KotlinFileFacade")), a.FILE_FACADE);
        map.put(e9.b.j(new e9.c("kotlin.jvm.internal.KotlinMultifileClass")), a.MULTIFILE_CLASS);
        map.put(e9.b.j(new e9.c("kotlin.jvm.internal.KotlinMultifileClassPart")), a.MULTIFILE_CLASS_PART);
        map.put(e9.b.j(new e9.c("kotlin.jvm.internal.KotlinSyntheticClass")), a.SYNTHETIC_CLASS);
    }

    @Override // x8.m
    public final k n(e9.b bVar, k8.a aVar) {
        a aVar2;
        e9.c cVarB = bVar.b();
        if (cVarB.equals(x.f7858a)) {
            return new c(this, 0);
        }
        if (cVarB.equals(x.f7872o)) {
            return new c(this, 1);
        }
        if (f11713n || this.f11721l != null || (aVar2 = (a) f11714o.get(bVar)) == null) {
            return null;
        }
        this.f11721l = aVar2;
        return new c(this, 2);
    }
}
