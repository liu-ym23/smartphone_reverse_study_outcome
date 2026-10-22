package m3;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import g5.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f8194a;

    /* renamed from: b, reason: collision with root package name */
    public int f8195b;

    public c(int i) {
        if (i > 0) {
            this.f8194a = new Object[i];
        } else {
            f.s("The max pool size must be > 0");
            throw null;
        }
    }

    @Override // m3.b
    public boolean a(Object obj) {
        obj.getClass();
        int i = this.f8195b;
        int i3 = 0;
        while (true) {
            Object[] objArr = this.f8194a;
            if (i3 >= i) {
                int i10 = this.f8195b;
                if (i10 >= objArr.length) {
                    return false;
                }
                objArr[i10] = obj;
                this.f8195b = i10 + 1;
                return true;
            }
            if (objArr[i3] == obj) {
                od.f.e("Already in the pool!");
                return false;
            }
            i3++;
        }
    }

    @Override // m3.b
    public Object b() {
        int i = this.f8195b;
        if (i <= 0) {
            return null;
        }
        int i3 = i - 1;
        Object[] objArr = this.f8194a;
        Object obj = objArr[i3];
        obj.getClass();
        objArr[i3] = null;
        this.f8195b--;
        return obj;
    }

    public void c(u2.b bVar) {
        int i = this.f8195b;
        Object[] objArr = this.f8194a;
        if (i < objArr.length) {
            objArr[i] = bVar;
            this.f8195b = i + 1;
        }
    }

    public c() {
        this.f8194a = new Object[ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH];
    }
}
