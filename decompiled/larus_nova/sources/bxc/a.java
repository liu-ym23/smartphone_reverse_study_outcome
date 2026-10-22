package bxc;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.ss.android.downloadlib.addownload.compliance.ComplianceResult;
import pub.devrel.easypermissions.RationaleDialogFragment;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends e<Activity> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // bxc.e
    public Context getContext() {
        return (Context) this.f21384a;
    }

    public a(Activity r100) {
        super(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bxc.e
    public final boolean e(String r100) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.f21384a, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bxc.e
    public final void a(int r100, String... r101) {
        ActivityCompat.requestPermissions((Activity) this.f21384a, r101, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // bxc.e
    public final void f(String r100, String r101, String r102, int r103, int r110, String... r111) {
        FragmentManager r104 = ((Activity) this.f21384a).getFragmentManager();
        if ((r104.findFragmentByTag("RationaleDialogFragment") instanceof RationaleDialogFragment) == false) goto L5;
        return;
    L5:
        RationaleDialogFragment r105 = new RationaleDialogFragment();
        Bundle r106 = new Bundle();
        r106.putString("positiveButton", r101);
        r106.putString("negativeButton", r102);
        r106.putString("rationaleMsg", r100);
        r106.putInt("theme", r103);
        r106.putInt("requestCode", r110);
        r106.putStringArray(ComplianceResult.JsonKey.PERMISSIONS, r111);
        r105.setArguments(r106);
        if (Build.VERSION.SDK_INT < 26) goto L11;
        if (r104.isStateSaved() == false) goto L11;
        return;
    L11:
        if (r105.f530775c == true) goto L16;
        r105.show(r104, "RationaleDialogFragment");
        return;
    }
}
