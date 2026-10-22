package I6;

import G1.d;
import J6.e;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.util.Log;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.Feature;
import com.stepos.appcenter.appcentersdk.data.ResultValue;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import tb.C5528A;
import tb.C5551r;
import tb.z;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    public static volatile b f3377e;

    /* renamed from: a, reason: collision with root package name */
    public final String f3378a = "ad-stats";

    /* renamed from: b, reason: collision with root package name */
    public ExecutorService f3379b = Executors.newSingleThreadExecutor();

    /* renamed from: c, reason: collision with root package name */
    public z f3380c = H6.a.a();

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f3381d = new HashMap();

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ I6.a f3382a;

        /* renamed from: I6.b$a$a, reason: collision with other inner class name */
        public class C0055a extends d<ResultValue<String>> {
            public C0055a() {
            }
        }

        public a(I6.a aVar) {
            this.f3382a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() throws SecurityException, IllegalArgumentException {
            Process.setThreadPriority(10);
            Map<String, String> mapH = this.f3382a.h();
            mapH.putAll(b.this.c());
            C5551r.a aVar = new C5551r.a();
            if (mapH.size() > 0) {
                for (Map.Entry<String, String> entry : mapH.entrySet()) {
                    aVar.a(entry.getKey(), entry.getValue());
                }
            }
            try {
                try {
                    ResultValue resultValue = (ResultValue) G1.a.x(b.this.f3380c.a(new C5528A.a().t("").o(aVar.c()).b()).execute().getBody().A(), new C0055a(), new Feature[0]);
                    if (resultValue.getCode() != 200) {
                        Log.w("ad-stats", "upload stats fail , response = " + resultValue.toString() + " | data = " + aVar.toString());
                    } else if (Log.isLoggable("ad-stats", 3)) {
                        Log.d("ad-stats", "upload stats success : " + G1.a.N(mapH));
                    }
                } catch (JSONException e10) {
                    Log.e("ad-stats", "upload stats result : " + e10.getLocalizedMessage());
                }
            } catch (IOException e11) {
                Log.e("ad-stats", "upload stats result : " + e11.getLocalizedMessage());
            }
        }
    }

    public b(Context context) throws PackageManager.NameNotFoundException {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            this.f3381d.put("v", e.a(packageInfo.versionName));
            this.f3381d.put("vc", e.a(String.valueOf(packageInfo.versionCode)));
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("ad-stats", "get packageinfo occurs : " + e10.getLocalizedMessage());
        }
        this.f3381d.put("source", "2");
        this.f3381d.put("cp", e.a(context.getPackageName()));
        this.f3381d.put(Parameters.IMEI, "unknown");
    }

    public static b d(Context context) {
        if (f3377e == null) {
            synchronized (b.class) {
                try {
                    if (f3377e == null) {
                        f3377e = new b(context);
                    }
                } finally {
                }
            }
        }
        return f3377e;
    }

    public final Map<String, String> c() {
        return this.f3381d;
    }

    public void e(I6.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f3379b.execute(new a(aVar));
    }
}
