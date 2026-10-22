package com.stepos.familyguard.ui.usage;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.familyguard.ui.ReopenDigitalWellbeingActivity;
import e2.C0684b;
import f2.C0702g;

/* loaded from: classes.dex */
public class UsageDirectActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private static long f14943a;

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C0702g.b("UsageDirectActivity", "onCreate() called with: savedInstanceState = [" + bundle + "]");
        long longExtra = getIntent().getLongExtra("operator_id", -1L);
        if (T1.b.h()) {
            finish();
            return;
        }
        boolean z5 = false;
        if (C0684b.A()) {
            DigitalWellbeingService.d0(this);
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j5 = f14943a;
            if (j5 != 0 && jElapsedRealtime - j5 < 800) {
                z5 = true;
            }
            f14943a = jElapsedRealtime;
            if (!p2.g.x(this) || Y1.l.c1()) {
                DigitalWellbeingActivity.M1(this, longExtra);
                if (z5) {
                    C0702g.b("UsageDirectActivity", "onCreate() debounced but still delivered start for list reset");
                }
            } else if (!z5) {
                ReopenDigitalWellbeingActivity.Z(this);
            }
        } else {
            UsageActivity.c0(this, 0, longExtra);
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        T1.b.h();
    }
}
