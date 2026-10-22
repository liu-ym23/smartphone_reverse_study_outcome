package com.stepos.familyguard.ui.limit;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.stepos.familyguard.R;
import j2.C0784a;
import x2.g;

/* loaded from: classes.dex */
public class CategoryLimitActivity extends com.stepos.familyguard.ui.base.a {

    /* renamed from: c, reason: collision with root package name */
    private C0784a f14833c;

    private Bundle W(Intent intent) {
        return intent.getExtras();
    }

    public static Intent X(Context context, int i5, int i6, String str, long j5) {
        Intent intent = new Intent();
        intent.setClass(context, CategoryLimitActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("categoryId", i6);
        bundle.putString("category_label", str);
        bundle.putInt("proxy", i5);
        bundle.putLong("operator_id", j5);
        intent.putExtras(bundle);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        getOnBackPressedDispatcher().k();
    }

    public static void Z(Context context, int i5, int i6, String str, long j5) {
        context.startActivity(X(context, i5, i6, str, j5));
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            CategoryLimitFragment categoryLimitFragment = new CategoryLimitFragment();
            categoryLimitFragment.G1(W(getIntent()));
            getSupportFragmentManager().m().s(R.id.fragment_container, categoryLimitFragment).j();
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
        C0784a c0784aC = C0784a.c(getLayoutInflater());
        this.f14833c = c0784aC;
        return c0784aC.b();
    }

    @Override // i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) throws Resources.NotFoundException {
        super.y(view, bundle);
        Bundle extras = getIntent().getExtras();
        g.e(this.f14833c.f17675c, extras != null ? extras.getString("category_label", null) : null, new View.OnClickListener() { // from class: t2.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.f22600a.Y(view2);
            }
        });
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        g.d(this);
    }
}
