package e9;

import android.content.ContentResolver;
import android.os.Handler;
import androidx.lifecycle.l0;
import k0.c1;
import s8.r0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3632c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f3633f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Object f3634g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3635h;
    public /* synthetic */ Object i;

    public /* synthetic */ d(xb.a aVar, kc.t tVar, xb.l lVar, xb.l lVar2) {
        this.f3632c = 2;
        this.f3633f = aVar;
        this.f3634g = tVar;
        this.f3635h = lVar;
        this.i = lVar2;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f3632c) {
            case 0:
                yb.u uVar = (yb.u) this.f3633f;
                ContentResolver contentResolver = (ContentResolver) this.f3634g;
                e eVar = (e) this.f3635h;
                Handler handler = (Handler) this.i;
                Runnable runnable = (Runnable) uVar.f16098c;
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                contentResolver.unregisterContentObserver(eVar);
                break;
            case 1:
                kc.w.u((kc.t) this.f3633f, null, null, new l0((i9.b0) this.f3634g, (xb.a) this.f3635h, (c1) this.i, null, 8), 3);
                break;
            case 2:
                xb.a aVar = (xb.a) this.f3633f;
                kc.t tVar = (kc.t) this.f3634g;
                xb.l lVar = (xb.l) this.f3635h;
                xb.l lVar2 = (xb.l) this.i;
                aVar.invoke();
                kc.w.u(tVar, null, null, new r0(lVar, lVar2, null, 2), 3);
                break;
            default:
                yb.u uVar2 = (yb.u) this.f3633f;
                Handler handler2 = (Handler) this.i;
                ContentResolver contentResolver2 = (ContentResolver) this.f3634g;
                e eVar2 = (e) this.f3635h;
                Runnable runnable2 = (Runnable) uVar2.f16098c;
                if (runnable2 != null) {
                    handler2.removeCallbacks(runnable2);
                }
                try {
                    contentResolver2.unregisterContentObserver(eVar2);
                } catch (Throwable th) {
                    id.c.l(th);
                }
                return jb.v.f6774a;
        }
        return jb.v.f6774a;
    }

    public /* synthetic */ d(int i) {
        this.f3632c = i;
    }
}
