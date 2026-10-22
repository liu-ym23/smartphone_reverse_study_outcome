package r2;

import android.content.Context;
import android.os.Bundle;
import android.view.WindowInsetsController;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public abstract class c extends stepos.support.v7.app.n {

    /* renamed from: f, reason: collision with root package name */
    private final int f19964f = -1;

    protected void F() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        boolean z5 = (getResources().getConfiguration().uiMode & 48) == 32;
        boolean z6 = !z5;
        WindowInsetsController insetsController = getWindow().getInsetsController();
        if (insetsController != null) {
            insetsController.setSystemBarsAppearance(z5 ? 0 : 24, 24);
        }
        N1.f.b(getWindow(), z6, true);
        T1.a.d(this, z6);
        T1.a.e(this, z6);
        T1.a.f(this, z6, true);
    }

    protected void G(Context context) {
    }

    @Override // stepos.support.v7.app.n, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        G(this);
        F();
        stepos.support.v7.app.m mVarV = v();
        if (mVarV != null) {
            mVarV.a(2);
            mVarV.b(true);
        }
    }

    @Override // stepos.support.v7.app.n, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onResume() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onResume();
        F();
    }

    @Override // stepos.support.v7.app.d
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
