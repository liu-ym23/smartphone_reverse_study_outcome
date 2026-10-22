package com.stepos.familyguard.ui.usage;

import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.MenuItem;

/* loaded from: classes.dex */
public class WeekDigitalWellbeingActivity extends DigitalWellbeingActivity {
    @Override // com.stepos.familyguard.ui.usage.DigitalWellbeingActivity, com.stepos.familyguard.ui.base.a
    protected void I() {
        B2.b.b();
    }

    @Override // com.stepos.familyguard.ui.usage.DigitalWellbeingActivity
    protected AbstractViewOnTouchListenerC0592a N0(D2.r<String, Drawable> rVar) {
        return new V(this, rVar);
    }

    @Override // com.stepos.familyguard.ui.usage.DigitalWellbeingActivity
    protected int V0() {
        return 0;
    }

    @Override // com.stepos.familyguard.ui.usage.DigitalWellbeingActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    @Override // com.stepos.familyguard.ui.usage.DigitalWellbeingActivity, com.stepos.familyguard.ui.base.a, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // com.stepos.familyguard.ui.usage.DigitalWellbeingActivity, com.stepos.familyguard.ui.base.a, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
