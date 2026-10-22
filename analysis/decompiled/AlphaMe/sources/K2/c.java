package K2;

import T2.d;
import android.content.Context;
import android.content.IntentFilter;
import androidx.appcompat.app.A;
import com.stepos.alphame.bluetooth.VehicleBluetoothManager;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static c f1044d;

    /* renamed from: e, reason: collision with root package name */
    public static final Object f1045e = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f1048c = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final a f1046a = new a(this, 30000, 0);

    /* renamed from: b, reason: collision with root package name */
    public final a f1047b = new a(this, VehicleBluetoothManager.FAIL_RETRY_TIMEOUT, 1);

    public c(Context context) {
        A a4 = new A(this);
        try {
            context.unregisterReceiver(a4);
        } catch (Exception unused) {
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            context.registerReceiver(a4, intentFilter);
        } catch (Exception e4) {
            d.f("EnvironmentReceiver", "Exception: " + e4.toString() + " - Cause: " + e4.getCause());
        }
    }
}
