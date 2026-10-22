package n5;

import android.content.Context;
import androidx.room.a0;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashSet;
import java.util.List;
import kb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public final p5.i f8765a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f8766b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f8767c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f8768d;

    /* renamed from: e, reason: collision with root package name */
    public Object f8769e;

    public e(Context context, p5.i iVar) {
        this.f8765a = iVar;
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.f8766b = applicationContext;
        this.f8767c = new Object();
        this.f8768d = new LinkedHashSet();
    }

    public abstract Object a();

    public final void b(Object obj) {
        synchronized (this.f8767c) {
            Object obj2 = this.f8769e;
            if (obj2 == null || !obj2.equals(obj)) {
                this.f8769e = obj;
                List listL0 = l.L0(this.f8768d);
                r5.a aVar = (r5.a) this.f8765a.f9733h;
                a0 a0Var = new a0(6);
                a0Var.f1506f = listL0;
                a0Var.f1507g = this;
                VarHandle.storeStoreFence();
                aVar.execute(a0Var);
            }
        }
    }

    public abstract void c();

    public abstract void d();
}
