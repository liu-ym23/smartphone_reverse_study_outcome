package com.stepos.minor.ui;

import H2.K0;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.core.content.res.h;
import com.stepos.familyguard.R;
import java.lang.reflect.InvocationTargetException;
import r2.c;
import stepos.support.v7.app.a;

/* loaded from: classes.dex */
public class MinorSelectActivity extends c {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(a.InterfaceC0240a interfaceC0240a) {
        interfaceC0240a.setVisible(true);
        interfaceC0240a.a(R.id.us_menu_cancel);
        interfaceC0240a.b(getResources().getString(R.string.fg_common_cancel));
    }

    private void J() {
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            return;
        }
        supportActionBar.P(w() ? R.string.mm_title_select_minor : R.string.mm_title_select_minor_popup);
        supportActionBar.E(!w());
        supportActionBar.i(new a.b() { // from class: H2.v0
            @Override // stepos.support.v7.app.a.b
            public final void a(a.InterfaceC0240a interfaceC0240a) {
                this.f2821a.I(interfaceC0240a);
            }
        });
        Drawable drawableF = h.f(getResources(), R.drawable.stepos_lite_popup_title_bar_bg, null);
        if (drawableF != null) {
            drawableF.setTint(T1.h.a(this, R.attr.colorSurface));
            supportActionBar.y(drawableF);
        }
    }

    public static void K(Activity activity, int i5) {
        Intent intent = new Intent(activity, (Class<?>) MinorSelectActivity.class);
        intent.putExtra("select", i5);
        activity.startActivity(intent);
    }

    @Override // r2.c, stepos.support.v7.app.n, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        setContentView(R.layout.activity_select_minor);
        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        K0 k02 = new K0();
        k02.G1(extras);
        getSupportFragmentManager().m().b(R.id.fragment_container, k02).j();
        J();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.us_menu_cancel) {
            return false;
        }
        u(true);
        return true;
    }
}
