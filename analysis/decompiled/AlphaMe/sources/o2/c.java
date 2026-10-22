package o2;

import B0.g;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("openIdNotifyFlag", 0);
        if (intExtra == 1) {
            if (!TextUtils.equals(intent.getStringExtra("openIdPackage"), context.getPackageName())) {
                return;
            }
        } else if (intExtra == 2) {
            ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("openIdPackageList");
            if (stringArrayListExtra == null || !stringArrayListExtra.contains(context.getPackageName())) {
                return;
            }
        } else if (intExtra != 0) {
            return;
        }
        String stringExtra = intent.getStringExtra("openIdType");
        d dVarC = d.c();
        dVarC.getClass();
        C0808a c0808a = "oaid".equals(stringExtra) ? (C0808a) dVarC.f13797b : "vaid".equals(stringExtra) ? (C0808a) dVarC.f13799d : "aaid".equals(stringExtra) ? (C0808a) dVarC.f13798c : "udid".equals(stringExtra) ? (C0808a) dVarC.f13796a : null;
        if (c0808a != null) {
            c0808a.f13789b = 0L;
        }
        if ("oaid".equals(stringExtra)) {
            d dVarC2 = d.c();
            synchronized (dVarC2) {
                g.y(dVarC2.f13803h);
            }
        }
    }
}
