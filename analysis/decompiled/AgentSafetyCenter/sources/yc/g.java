package yc;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f16106c;

    public /* synthetic */ g(int i) {
        this.f16106c = i;
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, jb.d] */
    @Override // xb.a
    public final Object invoke() {
        Class<?> returnType;
        switch (this.f16106c) {
            case 0:
                return p.f16118a;
            case 1:
                return k.f16111a;
            case 2:
                return j.f16110a;
            case 3:
                return o.f16117b;
            case 4:
                return d.f16105a;
            case 5:
                try {
                    Method declaredMethod = SQLiteDatabase.class.getDeclaredMethod("getThreadSession", null);
                    declaredMethod.setAccessible(true);
                    return declaredMethod;
                } catch (Throwable unused) {
                    return null;
                }
            default:
                try {
                    Method method = (Method) z4.c.f16384h.getValue();
                    if (method != null && (returnType = method.getReturnType()) != null) {
                        Class cls = Integer.TYPE;
                        return returnType.getDeclaredMethod("beginTransaction", cls, SQLiteTransactionListener.class, cls, CancellationSignal.class);
                    }
                } catch (Throwable unused2) {
                }
                return null;
        }
    }
}
