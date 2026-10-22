package b4;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements RetryPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f5928a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5929b;

    public a(Context r10) {
        this.f5929b = 0;
        this.f5928a = r10;
    }

    public static boolean b(Context r10) {
        NetworkInfo r11 = ((ConnectivityManager) r10.getSystemService("connectivity")).getActiveNetworkInfo();     // Catch: Exception -> L9
        if (r11 == null) goto L12;
        if (r11.isAvailable() == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public long a() {
        if (b(this.f5928a) == true) goto L6;
        return -1;
    L6:
        int r10 = this.f5929b + 1;
        this.f5929b = r10;
        return (long) (Math.min(((long) (1 << r10)) * PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS, 120000) + ((Math.random() * 10.0d) * 1000.0d));
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public long getRandomInterval() {
        return (long) ((Math.random() * 4500.0d) + 500.0d);
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public long getRetryIntervalWithResponse(Response r10) {
        long r11 = a();
        if (r11 != (-1)) goto L5;
        return -1;
    L5:
        if (r10 != null) goto L31;
    L29:
        return r11;
    L31:
    L25:
        e = move-exception;
        e.printStackTrace();
        goto L29
    L7:
        if (r10.k() == true) goto L29;
        int r12 = r10.d();     // Catch: Exception -> L25
        if (r12 != 414) goto L11;
    L14:
        String r13 = r10.f("Handshake-Options");     // Catch: Exception -> L25
        if (r13 == null) goto L29;
        String[] r14 = r13.split(";");     // Catch: Exception -> L25
        int r15 = r14.length;     // Catch: Exception -> L25
        int r16 = 0;
    L17:
        if (r16 >= r15) goto L29;
        String r17 = r14[r16];     // Catch: Exception -> L25
        if (TextUtils.isEmpty(r17) == true) goto L27;
        String[] r18 = r17.split("=");     // Catch: Exception -> L25
        if ("reconnect-interval".equals(r18[0]) == false) goto L27;
        String r19 = r18[1];     // Catch: Exception -> L25
        Logger.d("WsChannelSdk_ok", "override retry interval");     // Catch: Exception -> L25
        r11 = Long.parseLong(r19) * 1000;     // Catch: Exception -> L25 NumberFormatException -> L30
        Logger.d("WsChannelSdk_ok", "read response hand shake option : reconnect-interval:" + r11 + " ms");     // Catch: Exception -> L25 NumberFormatException -> L30
    L27:
        r16 = r16 + 1;
        goto L17
    L11:
        if (r12 == 511) goto L14;
        if (r12 != 512) goto L29;
        goto L14
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.policy.RetryPolicy
    public void reset() {
        this.f5929b = 0;
    }
}
