package ea;

import android.app.Application;
import android.os.Process;
import android.text.TextUtils;
import androidx.datastore.preferences.protobuf.b1;
import com.stepos.statsapp.v3.SdkVer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import la.c;
import ra.a;
import ta.b;
import ta.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f8623c;

    /* renamed from: a, reason: collision with root package name */
    public Application f8624a;

    /* renamed from: b, reason: collision with root package name */
    public String f8625b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: ea.a$a, reason: collision with other inner class name */
    public static class C0077a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f8626a = new a();
    }

    public static void a(Application application) {
        File externalFilesDir;
        if (f8623c) {
            return;
        }
        boolean z = true;
        f8623c = true;
        if (TextUtils.isEmpty("20014622")) {
            throw new IllegalArgumentException("appId is null!");
        }
        a aVar = C0077a.f8626a;
        aVar.f8624a = application;
        aVar.f8625b = "20014622";
        if (c.f12951c && (externalFilesDir = application.getExternalFilesDir(null)) != null) {
            String absolutePath = externalFilesDir.getAbsolutePath();
            b bVar = new b();
            bVar.f12944a = absolutePath;
            File file = new File(absolutePath);
            if (!file.exists() || !file.isDirectory()) {
                file.mkdirs();
            }
            bVar.f12945b = new File(absolutePath, "usage_logs_v2.txt");
            ta.a aVar2 = new ta.a();
            int i10 = 0;
            aVar2.f12943c = 0;
            aVar2.f12941a = new char[64];
            aVar2.f12943c = "copyright".charAt(0) % '\r';
            while (true) {
                char[] cArr = ta.a.f12937d;
                if (i10 >= 64) {
                    break;
                }
                aVar2.f12941a[i10] = cArr[(aVar2.f12943c + i10) % 64];
                i10++;
            }
            aVar2.f12942b = aVar2.f12941a;
            bVar.f12946c = aVar2;
            bVar.f12947d = new SimpleDateFormat("MM-dd HH:mm:ss.SSS");
            bVar.f12948e = Process.myPid();
            c.f12949a = bVar;
        }
        la.c cVar = c.a.f10391a;
        Application application2 = aVar.f8624a;
        String str = aVar.f8625b;
        StringBuilder sbQ = a0.a.q("SDKInstanceImpl, pkgType: 0, appId: ", str, ", channel: StepOS, initConfig: ");
        sbQ.append(new a4.a(12));
        sbQ.append(", sdkVersion: ");
        sbQ.append(SdkVer.verName);
        ta.c.d("SDKInstanceImpl", sbQ.toString());
        cVar.f10383a = application2;
        cVar.f10384b = str;
        cVar.f10385c = "StepOS";
        b1.f1791n = "6KAIUyh8oTuWsB0JiE9";
        b1.f1787j = "http://uxip.zyql.com/api/v3/event/";
        b1.f1788k = "http://uxip-config.zyql.com/api/v3/umid/privacy";
        b1.f1789l = "http://uxip-res.zyql.com/resource/v3/config/";
        b1.f1790m = "http://uxip-res.zyql.com/resource/v3/config/rpk/";
        cVar.f10387e = new la.a(str);
        cVar.f10388f = new na.b(application2);
        new LinkedList();
        ta.c.a("PageController", "PageController init");
        cVar.f10389g = new ha.c();
        a.C0133a.f11759a.f11758a.execute(new e9.a(z, 1, cVar));
        ta.c.a("UsageStatsProxy3", "UsageStatsProxy3 init complete");
    }
}
