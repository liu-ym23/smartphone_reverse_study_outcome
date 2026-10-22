package coil.request;

import A1.h;
import A1.r;
import A1.s;
import F1.j;
import Ua.C1060i;
import Ua.C1073o0;
import Ua.Q;
import Ua.Y;
import android.view.View;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlinx.coroutines.g;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0015\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0016R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcoil/request/ViewTargetRequestManager;", "Landroid/view/View$OnAttachStateChangeListener;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "LUa/Q;", "LA1/h;", "job", "LA1/r;", Const.INTENT_KEY_PKGNAME, "(LUa/Q;)LA1/r;", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "LA1/s;", "request", "c", "(LA1/s;)V", "v", "onViewAttachedToWindow", "onViewDetachedFromWindow", "Landroid/view/View;", "LA1/r;", "currentDisposable", "Lkotlinx/coroutines/g;", "Lkotlinx/coroutines/g;", "pendingClear", Const.INTENT_KEY_UMID, "LA1/s;", "currentRequest", "", "e", "Z", "isRestart", "coil-base_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ViewTargetRequestManager implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final View view;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public r currentDisposable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public g pendingClear;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public s currentRequest;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public boolean isRestart;

    public ViewTargetRequestManager(View view) {
        this.view = view;
    }

    public final synchronized void a() {
        try {
            g gVar = this.pendingClear;
            if (gVar != null) {
                g.Y0(gVar, null, 1, null);
            }
            this.pendingClear = C1060i.d(C1073o0.f6391a, Y.c().getImmediate(), null, new ViewTargetRequestManager$dispose$1(this, null), 2, null);
            this.currentDisposable = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized r b(Q<? extends h> job) {
        r rVar = this.currentDisposable;
        if (rVar != null && j.r() && this.isRestart) {
            this.isRestart = false;
            rVar.a(job);
            return rVar;
        }
        g gVar = this.pendingClear;
        if (gVar != null) {
            g.Y0(gVar, null, 1, null);
        }
        this.pendingClear = null;
        r rVar2 = new r(this.view, job);
        this.currentDisposable = rVar2;
        return rVar2;
    }

    public final void c(s request) {
        s sVar = this.currentRequest;
        if (sVar != null) {
            sVar.a();
        }
        this.currentRequest = request;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View v10) {
        s sVar = this.currentRequest;
        if (sVar == null) {
            return;
        }
        this.isRestart = true;
        sVar.c();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View v10) {
        s sVar = this.currentRequest;
        if (sVar != null) {
            sVar.a();
        }
    }
}
