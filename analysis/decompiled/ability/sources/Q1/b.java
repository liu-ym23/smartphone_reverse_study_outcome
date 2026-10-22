package Q1;

import C5.e;
import H.h;
import H.i;
import L0.f;
import Z6.k;
import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.apm.insight.runtime.ConfigManager;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.services.slardar.config.IConfigManager;
import h2.d;
import java.net.URL;
import java.util.List;

/* loaded from: classes2.dex */
public final class b extends i implements C.b {
    public Context b;
    public e c;
    public boolean d;

    @Override // H.i
    public final void a(Context context) {
        this.b = context;
        a.h = true;
        a.e = context.getApplicationContext();
        a.b();
        if (h.b) {
            Log.d("ApmInsight", U7.a.e(new String[]{"CloudMessageManager Init."}));
        }
        ((IConfigManager) L2.a.a(IConfigManager.class)).registerResponseConfigListener(this);
        ActivityLifeObserver.getInstance().register(this);
        IConfigManager iConfigManager = (IConfigManager) L2.a.a(IConfigManager.class);
        if (iConfigManager != null) {
            iConfigManager.registerConfigListener(this);
        }
    }

    @Override // H.i
    public final void b(d dVar) {
        List list = (List) dVar.f4555a;
        if (list == null || list.isEmpty()) {
            return;
        }
        String str = (String) ((List) dVar.f4555a).get(0);
        try {
            if (!TextUtils.isEmpty(h.f713q)) {
                U1.a.f1265a = k.f + h.f713q + ConfigManager.ALOG_URL_SUFFIX;
                return;
            }
            URL url = new URL(str);
            U1.a.f1265a = url.getProtocol() + "://" + url.getHost() + ConfigManager.ALOG_URL_SUFFIX;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // B.c
    public final void f(Activity activity) {
        if ((this.f721a == null || TextUtils.isEmpty("close_cloud_request") || this.f721a.optInt("close_cloud_request") != 1) && h.g()) {
            f fVar = L0.d.f925a;
            A1.a aVar = new A1.a(11);
            if (fVar.c) {
                L0.h hVar = fVar.b;
                hVar.c(Message.obtain(hVar.d, aVar), 2000L);
            }
        }
    }

    @Override // H.i, C.a
    public final void onReady() {
        if (this.d) {
            return;
        }
        this.d = true;
        if ((this.f721a == null || TextUtils.isEmpty("close_cloud_request") || this.f721a.optInt("close_cloud_request") != 1) && h.g()) {
            this.c = new e(1);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            this.b.registerReceiver(this.c, intentFilter);
            L0.d.f925a.b(new A1.a(10));
        }
    }
}
