package stepos.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import stepos.support.v7.app.i;

/* loaded from: classes5.dex */
public class j extends i {

    /* renamed from: W, reason: collision with root package name */
    public final UiModeManager f40522W;

    public class a extends i.b {
        public a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // i.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i10) {
            return (j.this.R0() && i10 == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i10);
        }
    }

    public j(Context context, Window window, e eVar) {
        super(context, window, eVar);
        this.f40522W = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
    }

    @Override // stepos.support.v7.app.i
    public int S0(int i10) {
        if (i10 == 0 && this.f40522W.getNightMode() == 0) {
            return -1;
        }
        return super.S0(i10);
    }

    @Override // stepos.support.v7.app.g
    public Window.Callback T(Window.Callback callback) {
        return new a(callback);
    }
}
