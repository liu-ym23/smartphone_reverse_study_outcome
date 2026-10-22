package stepos.support.v7.app;

import Ic.j;
import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import java.lang.reflect.Field;
import stepos.support.v7.app.g;
import stepos.support.v7.widget.FitsWindowsContentLayout;

/* loaded from: classes5.dex */
public class i extends h {

    /* renamed from: V, reason: collision with root package name */
    public static s f40515V;

    /* renamed from: R, reason: collision with root package name */
    public int f40516R;

    /* renamed from: S, reason: collision with root package name */
    public boolean f40517S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f40518T;

    /* renamed from: U, reason: collision with root package name */
    public FitsWindowsContentLayout.a f40519U;

    public class a implements FitsWindowsContentLayout.a {
        public a() {
        }

        @Override // stepos.support.v7.widget.FitsWindowsContentLayout.a
        @TargetApi(23)
        public ActionMode a(ActionMode.Callback callback, int i10) {
            return i.this.f40500e.onWindowStartingActionMode(callback, i10);
        }
    }

    public class b extends g.c {
        public b(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode b(ActionMode.Callback callback) {
            j.a aVar = new j.a(i.this.f40497b, callback);
            Ic.b bVarG = i.this.P0(callback) ? i.this.G(aVar) : null;
            if (bVarG == null) {
                bVarG = i.this.H(aVar);
            }
            if (bVarG != null) {
                return aVar.e(bVarG);
            }
            return null;
        }
    }

    public i(Context context, Window window, e eVar) {
        super(context, window, eVar);
        this.f40516R = -100;
        this.f40518T = true;
        this.f40519U = new a();
    }

    @Override // stepos.support.v7.app.AppCompatDelegateImplV7
    public void E0(ViewGroup viewGroup) {
        super.E0(viewGroup);
        View viewFindViewById = viewGroup.findViewById(R.id.content);
        if (viewFindViewById == null || !(viewFindViewById instanceof FitsWindowsContentLayout)) {
            return;
        }
        ((FitsWindowsContentLayout) viewFindViewById).setOnStartActionModeListener(this.f40519U);
    }

    public final boolean P0(ActionMode.Callback callback) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
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
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return name.equals("android.widget.AbsListView$MultiChoiceModeWrapper") || name.equals("stepos.support.v7.widget.StepOSRecyclerView$MultiChoiceModeWrapper");
    }

    public final s Q0() {
        if (f40515V == null) {
            f40515V = new s(this.f40497b.getApplicationContext());
        }
        return f40515V;
    }

    public boolean R0() {
        return this.f40518T;
    }

    public int S0(int i10) {
        if (i10 != -100) {
            return i10 != 0 ? i10 : Q0().b() ? 2 : 1;
        }
        return -1;
    }

    public final boolean T0(int i10) {
        Resources resources = this.f40497b.getResources();
        Configuration configuration = resources.getConfiguration();
        int i11 = configuration.uiMode & 48;
        int i12 = i10 == 2 ? 32 : 16;
        if (i11 == i12) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i12 | (configuration2.uiMode & (-49));
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    @Override // stepos.support.v7.app.g, stepos.support.v7.app.f
    public boolean d() {
        this.f40517S = true;
        int i10 = this.f40516R;
        if (i10 == -100) {
            i10 = f.i();
        }
        int iS0 = S0(i10);
        if (iS0 != -1) {
            return T0(iS0);
        }
        return false;
    }

    @Override // stepos.support.v7.app.AppCompatDelegateImplV7, stepos.support.v7.app.f
    public void q(Bundle bundle) {
        super.q(bundle);
        if (bundle == null || this.f40516R != -100) {
            return;
        }
        this.f40516R = bundle.getInt("appcompat:local_night_mode", -100);
    }

    @Override // stepos.support.v7.app.g, stepos.support.v7.app.f
    public void u(Bundle bundle) {
        super.u(bundle);
        int i10 = this.f40516R;
        if (i10 != -100) {
            bundle.putInt("appcompat:local_night_mode", i10);
        }
    }
}
