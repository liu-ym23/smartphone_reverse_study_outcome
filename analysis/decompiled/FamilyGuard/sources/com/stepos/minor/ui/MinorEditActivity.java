package com.stepos.minor.ui;

import H2.C0349z;
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
public class MinorEditActivity extends c {

    /* renamed from: g, reason: collision with root package name */
    private int f15383g;

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
        if (this.f15383g == 1) {
            supportActionBar.P(R.string.mm_title_add_minor);
        } else {
            supportActionBar.P(R.string.mm_title_edit_minor);
        }
        supportActionBar.i(new a.b() { // from class: H2.c
            @Override // stepos.support.v7.app.a.b
            public final void a(a.InterfaceC0240a interfaceC0240a) {
                this.f2770a.I(interfaceC0240a);
            }
        });
        Drawable drawableF = h.f(getResources(), R.drawable.stepos_lite_popup_title_bar_bg, null);
        if (drawableF != null) {
            drawableF.setTint(T1.h.a(this, R.attr.colorSurfaceBright));
            supportActionBar.y(drawableF);
        }
    }

    public static void K(Activity activity, String str, int i5) {
        Intent intent = new Intent();
        intent.setClass(activity, MinorEditActivity.class);
        intent.putExtra("edit_minor_action", 1);
        intent.putExtra("edit_minor_name", str);
        intent.putExtra("edit_minor_state", i5);
        activity.startActivity(intent);
    }

    public static void L(Activity activity, long j5) {
        Intent intent = new Intent();
        intent.setClass(activity, MinorEditActivity.class);
        intent.putExtra("edit_minor_action", 2);
        intent.putExtra("edit_minor_id", j5);
        activity.startActivity(intent);
    }

    @Override // r2.c, stepos.support.v7.app.n, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f15383g = intent.getIntExtra("edit_minor_action", 1);
        J();
        setContentView(R.layout.minor_edit_activity);
        Bundle extras = intent.getExtras();
        C0349z c0349z = new C0349z();
        c0349z.G1(extras);
        getSupportFragmentManager().m().b(R.id.fragment_container, c0349z).j();
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
