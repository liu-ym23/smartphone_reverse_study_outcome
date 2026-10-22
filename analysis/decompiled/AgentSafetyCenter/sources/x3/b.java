package x3;

import android.content.Context;
import java.util.List;
import kc.t;
import t.n;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b implements bc.a {

    /* renamed from: a, reason: collision with root package name */
    public String f15568a;

    /* renamed from: b, reason: collision with root package name */
    public l f15569b;

    /* renamed from: c, reason: collision with root package name */
    public t f15570c;

    /* renamed from: d, reason: collision with root package name */
    public Object f15571d;

    /* renamed from: e, reason: collision with root package name */
    public volatile stepos.support.v7.app.f f15572e;

    public final stepos.support.v7.app.f a(Object obj, fc.c cVar) {
        stepos.support.v7.app.f fVar;
        Context context = (Context) obj;
        context.getClass();
        cVar.getClass();
        stepos.support.v7.app.f fVar2 = this.f15572e;
        if (fVar2 != null) {
            return fVar2;
        }
        synchronized (this.f15571d) {
            try {
                if (this.f15572e == null) {
                    Context applicationContext = context.getApplicationContext();
                    l lVar = this.f15569b;
                    applicationContext.getClass();
                    this.f15572e = n.g((List) lVar.invoke(applicationContext), this.f15570c, new a1.b(16, applicationContext, this));
                }
                fVar = this.f15572e;
                fVar.getClass();
            } catch (Throwable th) {
                throw th;
            }
        }
        return fVar;
    }
}
