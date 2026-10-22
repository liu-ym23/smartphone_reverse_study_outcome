package com.stepos.familyguard.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentContainerView;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.base.a;
import com.stepos.familyguard.ui.usage.DigitalWellbeingActivity;
import j2.i;
import java.util.Objects;
import p2.g;

/* loaded from: classes.dex */
public class PrivacySettingsActivity extends a {
    protected void V(Bundle bundle) {
        FragmentContainerView fragmentContainerViewB = i.c(getLayoutInflater()).b();
        super.y(fragmentContainerViewB, bundle);
        setContentView(fragmentContainerViewB);
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int intExtra = getIntent().getIntExtra("from", 1);
        if (g.x(this) || intExtra != 2) {
            V(bundle);
        } else {
            startActivity(new Intent(this, (Class<?>) DigitalWellbeingActivity.class));
            finish();
        }
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        super.z();
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        Objects.requireNonNull(supportActionBar);
        supportActionBar.P(R.string.fg_privacy_settings_title);
        stepos.support.v7.app.a supportActionBar2 = getSupportActionBar();
        Objects.requireNonNull(supportActionBar2);
        supportActionBar2.E(true);
    }
}
