package com.stepos.familyguard.ui.limit;

import H2.B;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.stepos.familyguard.R;
import com.stepos.minor.WhitelistApp;
import j2.C0784a;
import x2.g;

/* loaded from: classes.dex */
public class GlobalLimitActivity extends com.stepos.familyguard.ui.base.a {

    /* renamed from: c, reason: collision with root package name */
    private C0784a f14852c;

    private Bundle W(Intent intent) {
        return intent.getExtras();
    }

    public static Intent X(Context context, long j5, int i5) {
        Intent intent = new Intent();
        intent.setClass(context, GlobalLimitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("proxy", 0);
        bundle.putLong(WhitelistApp.COLUMN_MINOR_ID, j5);
        bundle.putInt("minor_age_range", i5);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        getOnBackPressedDispatcher().k();
    }

    public static void Z(Context context, long j5, int i5) {
        context.startActivity(X(context, j5, i5));
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        B b6 = new B();
        b6.G1(W(getIntent()));
        getSupportFragmentManager().m().s(R.id.fragment_container, b6).j();
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0784a c0784aC = C0784a.c(getLayoutInflater());
        this.f14852c = c0784aC;
        return c0784aC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws Resources.NotFoundException {
        super.y(view, bundle);
        g.e(this.f14852c.f17675c, getTitle(), new View.OnClickListener() { // from class: t2.O
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f22519a.Y(view2);
            }
        });
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        g.d(this);
    }
}
