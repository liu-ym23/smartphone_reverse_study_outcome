package com.stepos.familyguard.ui;

import T1.g;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import com.stepos.digitalwellbeing.appwidget.AppWidgetManagerService;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import com.stepos.digitalwellbeing.server.IDigitalWellbeingInterface;
import com.stepos.familyguard.R;
import com.stepos.familyguard.ui.usage.DigitalWellbeingActivity;
import j2.j;

/* loaded from: classes.dex */
public class ReopenDigitalWellbeingActivity extends com.stepos.familyguard.ui.base.a {

    /* renamed from: c, reason: collision with root package name */
    private IDigitalWellbeingInterface f14780c;

    /* renamed from: d, reason: collision with root package name */
    private j f14781d;

    /* renamed from: e, reason: collision with root package name */
    private final ServiceConnection f14782e = new a();

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            ReopenDigitalWellbeingActivity.this.f14780c = IDigitalWellbeingInterface.Stub.asInterface(iBinder);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            ReopenDigitalWellbeingActivity.this.f14780c = null;
        }
    }

    private void X() {
        g.e(1.44f, this.f14781d.b());
        this.f14781d.f17720c.f17663d.setText(R.string.us_screen_usage_state);
        this.f14781d.f17720c.f17661b.setText(R.string.us_reopen_activity_des1);
        this.f14781d.f17720c.f17662c.setImageResource(R.drawable.us_screen_usage);
        this.f14781d.f17721d.f17663d.setText(R.string.us_prevent_addiction);
        this.f14781d.f17721d.f17661b.setText(R.string.us_reopen_activity_des2);
        this.f14781d.f17721d.f17662c.setImageResource(R.drawable.us_prevent_addiction);
        this.f14781d.f17722e.f17663d.setText(R.string.us_more_statistics);
        this.f14781d.f17722e.f17661b.setText(R.string.us_reopen_activity_des3);
        this.f14781d.f17722e.f17662c.setImageResource(R.drawable.us_more_statics);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(View view) {
        try {
            IDigitalWellbeingInterface iDigitalWellbeingInterface = this.f14780c;
            if (iDigitalWellbeingInterface != null) {
                iDigitalWellbeingInterface.setEnable(true);
            }
        } catch (RemoteException e6) {
            e6.printStackTrace();
        }
        DigitalWellbeingActivity.M1(this, -1L);
        finish();
    }

    public static void Z(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) ReopenDigitalWellbeingActivity.class));
    }

    @Override // com.stepos.familyguard.ui.base.a, i2.AbstractActivityC0758a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, androidx.activity.h, androidx.core.app.f, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        j jVarC = j.c(getLayoutInflater());
        this.f14781d = jVarC;
        setContentView(jVarC.b());
        X();
        bindService(new Intent(this, (Class<?>) DigitalWellbeingService.class), this.f14782e, 1);
        this.f14781d.f17719b.setOnClickListener(new View.OnClickListener() { // from class: q2.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f19921a.Y(view);
            }
        });
    }

    @Override // com.stepos.familyguard.ui.base.a, stepos.support.v7.app.d, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        unbindService(this.f14782e);
    }

    @Override // com.stepos.familyguard.ui.base.a, androidx.fragment.app.ActivityC0516k, android.app.Activity
    protected void onStart() {
        super.onStart();
        AppWidgetManagerService.n(this);
    }

    @Override // i2.AbstractActivityC0758a
    protected void z() {
        S();
        stepos.support.v7.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.E(false);
        }
    }
}
