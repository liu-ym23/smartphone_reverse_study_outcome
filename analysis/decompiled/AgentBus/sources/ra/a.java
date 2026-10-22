package ra;

/* loaded from: classes.dex */
public abstract class a {
    @c7.a
    public static /* synthetic */ void getOnLock$annotations() {
    }

    public static /* synthetic */ Object lock$default(b bVar, Object obj, g7.d dVar, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lock");
        }
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return ((d) bVar).c(dVar, obj);
    }

    public static /* synthetic */ boolean tryLock$default(b bVar, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryLock");
        }
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return ((d) bVar).d(obj);
    }

    public static /* synthetic */ void unlock$default(b bVar, Object obj, int i2, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unlock");
        }
        if ((i2 & 1) != 0) {
            obj = null;
        }
        ((d) bVar).e(obj);
    }
}
