package ia;

/* loaded from: classes.dex */
public abstract class j {
    public static /* synthetic */ boolean cancel$default(k kVar, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
        if ((i2 & 1) != 0) {
            th = null;
        }
        return kVar.a(th);
    }

    public static /* synthetic */ Object tryResume$default(k kVar, Object obj, Object obj2, int i2, Object obj3) {
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
        if ((i2 & 2) != 0) {
            obj2 = null;
        }
        return kVar.f(obj, obj2);
    }
}
