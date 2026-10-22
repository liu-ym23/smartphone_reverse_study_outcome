package e9;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3638a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Handler f3639b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yb.u f3640c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f3641d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(yb.u uVar, Handler handler, mc.r rVar, Handler handler2) {
        super(handler2);
        this.f3640c = uVar;
        this.f3639b = handler;
        this.f3641d = rVar;
    }

    public void a() {
        yb.u uVar = this.f3640c;
        Runnable runnable = (Runnable) uVar.f16098c;
        Handler handler = this.f3639b;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        ab.e eVar = (ab.e) this.f3641d;
        a4.t tVar = new a4.t(29);
        tVar.f200f = eVar;
        VarHandle.storeStoreFence();
        uVar.f16098c = tVar;
        handler.postDelayed(tVar, 200L);
    }

    public void b() {
        yb.u uVar = this.f3640c;
        Runnable runnable = (Runnable) uVar.f16098c;
        Handler handler = this.f3639b;
        if (runnable != null) {
            handler.removeCallbacks(runnable);
        }
        mc.r rVar = (mc.r) this.f3641d;
        a4.t tVar = new a4.t(11);
        tVar.f200f = rVar;
        VarHandle.storeStoreFence();
        uVar.f16098c = tVar;
        handler.postDelayed(tVar, 200L);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10) {
        switch (this.f3638a) {
            case 0:
                b();
                break;
            default:
                a();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Handler handler, yb.u uVar, ab.e eVar) {
        super(handler);
        this.f3639b = handler;
        this.f3640c = uVar;
        this.f3641d = eVar;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z10, Uri uri) {
        switch (this.f3638a) {
            case 0:
                b();
                break;
            default:
                a();
                break;
        }
    }
}
