package com.stepos.familyguard.ui.limit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.stepos.familyguard.R;
import j2.C0791h;
import x2.g;

/* loaded from: classes.dex */
public class PackageLimitActivity extends com.stepos.familyguard.ui.base.a {

    /* renamed from: c, reason: collision with root package name */
    private C0791h f14853c;

    private Bundle W(Intent intent) {
        return intent.getExtras();
    }

    public static Intent X(Context context, int i5, String str, String str2, long j5) {
        Intent intent = new Intent();
        intent.setClass(context, PackageLimitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("packageName", str);
        bundle.putString("app_label", str2);
        bundle.putInt("proxy", i5);
        bundle.putLong("operator_id", j5);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        getOnBackPressedDispatcher().k();
    }

    public static void Z(Context context, int i5, String str, String str2, long j5) {
        context.startActivity(X(context, i5, str, str2, j5));
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            PackageLimitFragment packageLimitFragment = new PackageLimitFragment();
            packageLimitFragment.G1(W(getIntent()));
            getSupportFragmentManager().m().s(R.id.fragment_container, packageLimitFragment).j();
        }
    }

    @Override // com.stepos.familyguard.ui.base.a, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332) {
            return false;
        }
        onBackPressed();
        return true;
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a
    public View x() {
        C0791h c0791hC = C0791h.c(getLayoutInflater());
        this.f14853c = c0791hC;
        return c0791hC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws Resources.NotFoundException {
        super.y(view, bundle);
        Bundle extras = getIntent().getExtras();
        g.e(this.f14853c.f17715c, extras != null ? extras.getString("app_label", null) : null, new View.OnClickListener() { // from class: t2.Z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f22551a.Y(view2);
            }
        });
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        g.d(this);
    }
}
