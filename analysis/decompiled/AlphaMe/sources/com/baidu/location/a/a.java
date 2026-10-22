package com.baidu.location.a;

import android.content.Context;
import ch.qos.logback.core.spi.AbstractComponentTracker;
import com.baidu.lbsapi.auth.LBSAuthManager;
import com.baidu.lbsapi.auth.LBSAuthManagerListener;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements LBSAuthManagerListener {

    /* renamed from: b, reason: collision with root package name */
    private static Object f5070b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static a f5071c;

    /* renamed from: d, reason: collision with root package name */
    private int f5073d = 0;

    /* renamed from: e, reason: collision with root package name */
    private Context f5074e = null;

    /* renamed from: f, reason: collision with root package name */
    private long f5075f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f5076g = null;

    /* renamed from: a, reason: collision with root package name */
    public int f5072a = 0;

    public static a a() {
        a aVar;
        synchronized (f5070b) {
            try {
                if (f5071c == null) {
                    f5071c = new a();
                }
                aVar = f5071c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    public static String c(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getMCode();
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public String b() {
        return this.f5076g;
    }

    public synchronized void d() {
        try {
            wait(150L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
    }

    public synchronized void e() {
        notifyAll();
    }

    @Override // com.baidu.lbsapi.auth.LBSAuthManagerListener
    public void onAuthResult(int i4, String str) {
        this.f5073d = i4;
        e();
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token") && jSONObject.getString("token") != null) {
                    this.f5076g = jSONObject.getString("token");
                }
                if (!jSONObject.has("ak_permission") || jSONObject.getInt("ak_permission") == 0) {
                    return;
                }
                this.f5072a = jSONObject.getInt("ak_permission");
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public static String b(Context context) {
        try {
            return LBSAuthManager.getInstance(context).getPublicKey(context);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void a(Context context) {
        this.f5074e = context;
        LBSAuthManager.getInstance(context).authenticate(false, "lbs_locsdk", null, this);
        this.f5075f = System.currentTimeMillis();
    }

    public boolean c() {
        int i4 = this.f5073d;
        boolean z4 = i4 == 0 || i4 == 602 || i4 == 601 || i4 == -10 || i4 == -11;
        if (this.f5074e != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f5075f;
            if (!z4 ? jCurrentTimeMillis < 0 || jCurrentTimeMillis > AbstractComponentTracker.LINGERING_TIMEOUT : jCurrentTimeMillis > 86400000) {
                LBSAuthManager.getInstance(this.f5074e).authenticate(false, "lbs_locsdk", null, this);
                this.f5075f = System.currentTimeMillis();
            }
        }
        return z4;
    }

    public void a(Context context, String str) {
        LBSAuthManager.getInstance(context).setKey(str);
    }
}
