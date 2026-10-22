package com.bytedance.bdtracker;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.applog.log.LoggerImpl;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class h5 {
    public static volatile String a;

    public static class a implements Callable<String> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ u1 b;

        public a(Context context, u1 u1Var) {
            this.a = context;
            this.b = u1Var;
        }

        @Override // java.util.concurrent.Callable
        public String call() {
            AdvertisingIdClient.Info advertisingIdInfo;
            if (TextUtils.isEmpty(h5.a)) {
                synchronized (h5.class) {
                    if (!TextUtils.isEmpty(h5.a)) {
                        return h5.a;
                    }
                    try {
                        advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.a);
                    } catch (Throwable th) {
                        if (!(th instanceof ClassNotFoundException) && !(th instanceof NoClassDefFoundError)) {
                            LoggerImpl.global().error("Query Gaid failed", th, new Object[0]);
                        }
                    }
                    String id = advertisingIdInfo != null ? advertisingIdInfo.getId() : null;
                    if (TextUtils.isEmpty(id)) {
                        id = this.b.f.getString("google_aid", null);
                    } else if (!TextUtils.equals(this.b.f.getString("google_aid", null), id)) {
                        u1 u1Var = this.b;
                        if (!TextUtils.isEmpty(id) && u1Var != null) {
                            u1Var.f.putString("google_aid", id);
                        }
                    }
                    h5.a = id;
                }
            }
            return h5.a;
        }
    }

    public static String a(Context context, u1 u1Var) {
        return (String) x.a.submit(new a(context, u1Var)).get(u1Var.c.getGaidTimeOutMilliSeconds(), TimeUnit.MILLISECONDS);
    }
}
