package o3;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f13806a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f13807b;

    static {
        new c(null, null, null);
    }

    public c(Throwable th, String str, Object[] objArr) {
        this.f13806a = str;
        if (th == null) {
            this.f13807b = objArr;
            return;
        }
        if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.f13807b = objArr2;
    }
}
