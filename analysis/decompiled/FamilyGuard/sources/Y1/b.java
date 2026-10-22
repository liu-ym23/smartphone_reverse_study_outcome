package Y1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;
import x3.AbstractC1286b;

/* loaded from: classes.dex */
public class b extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, Intent intent) {
        if (T1.b.f(context) || p2.g.x(context)) {
            final String schemeSpecificPart = intent.getData().getSchemeSpecificPart();
            int intExtra = intent.getIntExtra("android.intent.extra.user_handle", 0);
            R1.a.a("OUPCR", "action = " + intent.getAction() + " package = " + schemeSpecificPart + " userId = " + intExtra);
            if (intExtra == 999 && TextUtils.equals(intent.getAction(), "android.intent.action.PACKAGE_ADDED")) {
                AbstractC1286b.b().j(T3.a.c()).g(new D3.a() { // from class: Y1.a
                    @Override // D3.a
                    public final void run() {
                        DigitalWellbeingService.W(context, schemeSpecificPart);
                    }
                });
            }
        }
    }
}
