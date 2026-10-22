package d0;

import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f1757a;

    /* renamed from: b, reason: collision with root package name */
    public int f1758b;

    public b(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f1757a = new Object[i8];
    }

    public Object a() {
        int i8 = this.f1758b;
        if (i8 <= 0) {
            return null;
        }
        int i9 = i8 - 1;
        Object[] objArr = this.f1757a;
        Object obj = objArr[i9];
        p.c(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        objArr[i9] = null;
        this.f1758b--;
        return obj;
    }

    public void b(m.b bVar) {
        int i8 = this.f1758b;
        Object[] objArr = this.f1757a;
        if (i8 < objArr.length) {
            objArr[i8] = bVar;
            this.f1758b = i8 + 1;
        }
    }

    public boolean c(Object instance) {
        Object[] objArr;
        boolean z;
        p.e(instance, "instance");
        int i8 = this.f1758b;
        int i9 = 0;
        while (true) {
            objArr = this.f1757a;
            if (i9 >= i8) {
                z = false;
                break;
            }
            if (objArr[i9] == instance) {
                z = true;
                break;
            }
            i9++;
        }
        if (z) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i10 = this.f1758b;
        if (i10 >= objArr.length) {
            return false;
        }
        objArr[i10] = instance;
        this.f1758b = i10 + 1;
        return true;
    }

    public b() {
        this.f1757a = new Object[256];
    }
}
