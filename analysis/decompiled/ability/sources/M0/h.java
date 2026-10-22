package M0;

import D9.n;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.stepos.ability.env.config.IEnvConfig;
import f6.AbstractC1436a;
import j0.AbstractC1591a;
import java.util.List;
import kotlin.NotImplementedError;
import z2.o;

/* loaded from: classes2.dex */
public final class h implements G0.a, P4.a, IEnvConfig, T9.a, x.j, o {
    public static final x.d b = new x.d(2);

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f954a;

    public /* synthetic */ h(int i) {
        this.f954a = i;
    }

    @Override // G0.a
    public int a() {
        return 4;
    }

    @Override // G0.a
    public boolean b() {
        return false;
    }

    @Override // G0.a
    public int c() {
        return 15;
    }

    @Override // G0.a
    public long d() {
        return 600L;
    }

    @Override // P4.a
    public String e() {
        return "https://biz-gw.zyql.com/dictionary/";
    }

    @Override // z2.o
    public boolean f(Object obj, Runnable runnable) {
        Message message;
        switch (this.f954a) {
            case 3:
                L0.g gVar = (L0.g) obj;
                if (gVar == null || (message = gVar.f927a) == null || !runnable.equals(message.getCallback())) {
                }
                break;
            default:
                Message message2 = (Message) obj;
                if (message2 == null || !runnable.equals(message2.getCallback())) {
                }
                break;
        }
        return false;
    }

    @Override // x.j
    public boolean g(Context context) {
        if (context == null) {
            return false;
        }
        return ((Boolean) b.b(context)).booleanValue();
    }

    @Override // com.stepos.ability.env.config.IEnvConfig
    public String getBaseUrl() {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    public com.stepos.ability.manager.cache.c h(Context context) {
        com.stepos.ability.manager.cache.c cVar;
        kotlin.jvm.internal.k.f(context, "context");
        com.stepos.ability.manager.cache.c cVar2 = com.stepos.ability.manager.cache.c.c;
        if (cVar2 != null) {
            return cVar2;
        }
        synchronized (this) {
            cVar = com.stepos.ability.manager.cache.c.c;
            if (cVar == null) {
                Context applicationContext = context.getApplicationContext();
                kotlin.jvm.internal.k.e(applicationContext, "getApplicationContext(...)");
                cVar = new com.stepos.ability.manager.cache.c(applicationContext);
                com.stepos.ability.manager.cache.c.c = cVar;
            }
        }
        return cVar;
    }

    @Override // P4.a
    public String i() {
        return "wss://connection-socket.zyql.com/ws";
    }

    @Override // P4.a
    public String j() {
        return "https://biz-gw.zyql.com/";
    }

    @Override // T9.a
    public void log(String message) {
        kotlin.jvm.internal.k.f(message, "message");
        AbstractC1436a.a("ExperienceClient", message, true);
    }

    @Override // G0.a
    public List a(String str) {
        return AbstractC1591a.c;
    }

    @Override // x.j
    public n c(Context context) {
        x.g gVar = new x.g();
        gVar.c = 0L;
        try {
            String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
            String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
            if (!TextUtils.isEmpty(string)) {
                gVar.f443a = string;
                gVar.b = Boolean.parseBoolean(string2);
                gVar.c = 202003021704L;
                return gVar;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        Pair pair = (Pair) new u1.d(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage("com.huawei.hwid"), new ca.da.da.a()).j();
        if (pair != null) {
            gVar.f443a = (String) pair.first;
            gVar.b = ((Boolean) pair.second).booleanValue();
            int i = 0;
            try {
                PackageInfo packageInfoB = D2.c.b(context, "com.huawei.hwid", 0);
                if (packageInfoB != null) {
                    i = packageInfoB.versionCode;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            gVar.c = i;
        }
        return gVar;
    }
}
