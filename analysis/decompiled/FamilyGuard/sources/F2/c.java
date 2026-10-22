package F2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.stepos.digitalwellbeing.server.DigitalWellbeingService;

/* loaded from: classes.dex */
public class c extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null && TextUtils.isEmpty(intent.getAction())) {
            return;
        }
        Log.d("LocalChangedReceiver", "onReceive.");
        I2.c.l(context);
        DigitalWellbeingService.Y(context);
    }
}
