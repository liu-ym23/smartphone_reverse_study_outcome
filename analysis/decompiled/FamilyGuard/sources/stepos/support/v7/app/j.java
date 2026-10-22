package stepos.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.Window;
import stepos.support.v7.app.i;

/* loaded from: classes.dex */
class j extends i {

    /* renamed from: Z, reason: collision with root package name */
    private final UiModeManager f20786Z;

    class a extends i.b {
        a(Window.Callback callback) {
            super(callback);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.i, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i5) {
            return (j.this.R0() && i5 == 0) ? b(callback) : super.onWindowStartingActionMode(callback, i5);
        }
    }

    j(Context context, Window window, e eVar) {
        super(context, window, eVar);
        this.f20786Z = (UiModeManager) context.getApplicationContext().getSystemService("uimode");
    }

    @Override // stepos.support.v7.app.i
    int S0(int i5) {
        if (i5 == 0 && this.f20786Z.getNightMode() == 0) {
            return -1;
        }
        return super.S0(i5);
    }

    @Override // stepos.support.v7.app.g
    Window.Callback T(Window.Callback callback) {
        return new a(callback);
    }
}
