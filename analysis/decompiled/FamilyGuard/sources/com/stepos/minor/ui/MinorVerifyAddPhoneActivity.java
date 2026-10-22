package com.stepos.minor.ui;

import H2.C0302a;
import H2.O0;
import T1.h;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.U;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.i;
import f2.C0702g;

/* loaded from: classes.dex */
public class MinorVerifyAddPhoneActivity extends O0 {
    public static void T0(Activity activity, int i5) {
        Intent intent = new Intent(activity, (Class<?>) MinorVerifyAddPhoneActivity.class);
        intent.addFlags(536870912);
        activity.startActivityForResult(intent, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.stepos.familyguard.ui.base.f
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public void O0(boolean z5, String str, String str2, Long l5) {
        C0702g.b("MinorVerifyAddPhoneActivity", "onVerify() called with: success = [" + z5 + "], phone = [" + str + "], code = [" + str2 + "], verifyResult = [" + l5 + "]");
        if (z5) {
            setResult(-1);
            finish();
        }
    }

    @Override // com.stepos.familyguard.ui.base.f
    protected i<String, Long> n0() {
        return (i) new U(this).a(C0302a.class);
    }

    @Override // com.stepos.familyguard.ui.base.f, com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0702g.b("MinorVerifyAddPhoneActivity", "onCreate() called with: savedInstanceState = [" + bundle + "]");
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        C0702g.b("MinorVerifyAddPhoneActivity", "onDestroy() called");
    }

    @Override // H2.O0, com.stepos.familyguard.ui.base.f, i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        this.f2748f.f17708e.setText(R.string.mm_add_parent_phone);
        this.f2748f.f17707d.setText(R.string.mm_add_parent_phone_des);
        this.f2748f.f17710g.setText(R.string.mm_verify);
        this.f2748f.f17705b.getEditText().setHint(R.string.mm_phone_number);
        this.f2748f.f17706c.getEditText().setHint(R.string.mm_verify_code);
        int iA = h.a(this, R.attr.colorSurface);
        this.f2748f.b().setBackgroundColor(iA);
        getWindow().setStatusBarColor(iA);
        this.f2748f.f17709f.setBackgroundColor(0);
        this.f2748f.f17709f.setGlassEnabled(true);
        this.f2748f.f17709f.setIndividualActionGlassEnabled(true);
    }
}
