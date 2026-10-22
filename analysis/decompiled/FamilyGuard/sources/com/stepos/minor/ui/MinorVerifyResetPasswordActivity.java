package com.stepos.minor.ui;

import H2.C0333p0;
import H2.O0;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.U;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.i;

/* loaded from: classes.dex */
public class MinorVerifyResetPasswordActivity extends O0 {
    public static void T0(Activity activity, int i5) {
        activity.startActivityForResult(new Intent(activity, (Class<?>) MinorVerifyResetPasswordActivity.class), i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.stepos.familyguard.ui.base.f
    /* renamed from: S0, reason: merged with bridge method [inline-methods] */
    public void O0(boolean z5, String str, String str2, Long l5) {
        if (z5) {
            Intent intent = new Intent();
            intent.putExtra("reset", true);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.stepos.familyguard.ui.base.f
    protected i<String, Long> n0() {
        return (i) new U(this).a(C0333p0.class);
    }

    @Override // com.stepos.familyguard.ui.base.f, com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // H2.O0, com.stepos.familyguard.ui.base.f, i2.AbstractActivityC0758a
    public void y(View view, Bundle bundle) {
        super.y(view, bundle);
        this.f2748f.f17708e.setText(R.string.mm_verify_parent_phone);
        this.f2748f.f17707d.setText((CharSequence) null);
        this.f2748f.f17710g.setText(R.string.mm_verify);
        this.f2748f.f17705b.getEditText().setHint(R.string.mm_phone_number);
        this.f2748f.f17706c.getEditText().setHint(R.string.mm_verify_code);
    }
}
