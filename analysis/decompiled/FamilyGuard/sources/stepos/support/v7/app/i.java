package stepos.support.v7.app;

import android.R;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import b5.j;
import java.lang.reflect.Field;
import stepos.support.v7.app.g;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* loaded from: classes.dex */
class i extends h {

    /* renamed from: Y, reason: collision with root package name */
    private static u f20779Y;

    /* renamed from: U, reason: collision with root package name */
    private int f20780U;

    /* renamed from: V, reason: collision with root package name */
    private boolean f20781V;

    /* renamed from: W, reason: collision with root package name */
    private boolean f20782W;

    /* renamed from: X, reason: collision with root package name */
    private FitsWindowsContentLayout.a f20783X;

    class a implements FitsWindowsContentLayout.a {
        a() {
        }

        @Override // stepos.support.v7.widget.FitsWindowsContentLayout.a
        public ActionMode a(ActionMode.Callback callback, int i5) {
            return i.this.f20764e.onWindowStartingActionMode(callback, i5);
        }
    }

    class b extends g.c {
        b(Window.Callback callback) {
            super(callback);
        }

        final ActionMode b(ActionMode.Callback callback) {
            j.a aVar = new j.a(i.this.f20761b, callback);
            b5.b bVarG = i.this.P0(callback) ? i.this.G(aVar) : null;
            if (bVarG == null) {
                bVarG = i.this.H(aVar);
            }
            if (bVarG != null) {
                return aVar.e(bVarG);
            }
            return null;
        }
    }

    i(Context context, Window window, e eVar) {
        super(context, window, eVar);
        this.f20780U = -100;
        this.f20782W = true;
        this.f20783X = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P0(ActionMode.Callback callback) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (callback == null) {
            return false;
        }
        String name = callback.getClass().getName();
        if (name.equals("com.android.internal.policy.impl.PhoneWindow$DecorView$ActionModeCallbackWrapper") || name.equals("com.android.internal.policy.PhoneWindow$DecorView$ActionModeCallback2Wrapper")) {
            try {
                Field declaredField = callback.getClass().getDeclaredField("mWrapped");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(callback);
                if (obj != null) {
                    name = obj.getClass().getName();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
        return name.equals("android.widget.AbsListView$MultiChoiceModeWrapper") || name.equals("stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper");
    }

    private u Q0() {
        if (f20779Y == null) {
            f20779Y = new u(this.f20761b.getApplicationContext());
        }
        return f20779Y;
    }

    private boolean T0(int i5) {
        Resources resources = this.f20761b.getResources();
        Configuration configuration = resources.getConfiguration();
        int i6 = configuration.uiMode & 48;
        int i7 = i5 == 2 ? 32 : 16;
        if (i6 == i7) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i7 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    @Override // stepos.support.v7.app.k
    void E0(ViewGroup viewGroup) {
        super.E0(viewGroup);
        View viewFindViewById = viewGroup.findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof FitsWindowsContentLayout)) {
            return;
        }
        ((FitsWindowsContentLayout) viewFindViewById).setOnStartActionModeListener(this.f20783X);
    }

    public boolean R0() {
        return this.f20782W;
    }

    int S0(int i5) {
        if (i5 != -100) {
            return i5 != 0 ? i5 : Q0().b() ? 2 : 1;
        }
        return -1;
    }

    @Override // stepos.support.v7.app.g, stepos.support.v7.app.f
    public boolean b() {
        this.f20781V = true;
        int i5 = this.f20780U;
        if (i5 == -100) {
            i5 = f.i();
        }
        int iS0 = S0(i5);
        if (iS0 != -1) {
            return T0(iS0);
        }
        return false;
    }

    @Override // stepos.support.v7.app.k, stepos.support.v7.app.f
    public void q(Bundle bundle) {
        super.q(bundle);
        if (bundle == null || this.f20780U != -100) {
            return;
        }
        this.f20780U = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // stepos.support.v7.app.g, stepos.support.v7.app.f
    public void u(Bundle bundle) {
        super.u(bundle);
        int i5 = this.f20780U;
        if (i5 != -100) {
            bundle.putInt("appcompat:local_night_mode", i5);
        }
    }
}
