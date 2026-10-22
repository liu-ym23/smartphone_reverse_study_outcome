package stepos.support.v7.app;

import android.view.ActionMode;
import android.view.Window;

/* renamed from: stepos.support.v7.app.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0874t extends r {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0875u f14588d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0874t(C0875u c0875u, Window.Callback callback) {
        super(c0875u, callback);
        this.f14588d = c0875u;
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i4) {
        return (this.f14588d.f14586R && i4 == 0) ? a(callback) : j.n.b(this.f13116a, callback, i4);
    }
}
