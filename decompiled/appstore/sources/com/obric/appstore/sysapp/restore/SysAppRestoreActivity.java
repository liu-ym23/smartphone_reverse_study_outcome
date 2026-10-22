package com.obric.appstore.sysapp.restore;

import android.os.Bundle;
import androidx.activity.i;
import androidx.fragment.app.FragmentActivity;
import com.obric.appstore.R;
import com.smt.obric.appstore.domain.sysapp.LoadSysAppUseCase;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/obric/appstore/sysapp/restore/SysAppRestoreActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_sysapp_updateRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SysAppRestoreActivity extends FragmentActivity {
    public SysAppRestoreActivity() {
        super(R.layout.activity_sysapp_manage);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle r10) {
        super.onCreate(r10);
        i.b(this, null, null, 3, null);
        SysAppSettingReporterKt.a(this);
        if (r10 != null) goto L6;
        getSupportFragmentManager().o().a(R.id.fragment_container, SysAppManageFragment.f10988d.a(false, R.string.appns_restore_sysapp, LoadSysAppUseCase.Filter.SysAppRecovery)).j();
        return;
    }
}
