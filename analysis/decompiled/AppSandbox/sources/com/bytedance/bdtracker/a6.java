package com.bytedance.bdtracker;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.e0;
import com.bytedance.dr.OaidApi;
import com.bytedance.dr.OaidFactory;
import com.bytedance.dr.impl.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a6 {
    public static final String h = "a6#";
    public static final String i = "a6#";
    public static final List<IOaidObserver> j = new ArrayList();
    public static g k;
    public static String l;
    public static Map<String, String> m;
    public final OaidApi b;
    public final boolean c;
    public final c6 d;
    public final Context e;
    public Long g;
    public final ReentrantLock a = new ReentrantLock();
    public final AtomicBoolean f = new AtomicBoolean(false);

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoggerImpl.global().debug(1, "Oaid#init switch thread", new Object[0]);
            a6.this.b();
        }
    }

    public a6(Context context) {
        this.e = context.getApplicationContext();
        OaidApi oaidApiCreateOaidImpl = OaidFactory.createOaidImpl(context);
        this.b = oaidApiCreateOaidImpl;
        if (oaidApiCreateOaidImpl != null) {
            this.c = oaidApiCreateOaidImpl.support(context);
        } else {
            this.c = false;
        }
        this.d = new c6(context);
    }

    public static void a(IOaidObserver.Oaid oaid, Object[] objArr) {
        if (oaid == null || objArr == null) {
            return;
        }
        for (Object obj : objArr) {
            ((IOaidObserver) obj).onOaidLoaded(oaid);
        }
    }

    public static void a(IOaidObserver iOaidObserver) {
        g gVar;
        List<IOaidObserver> list = j;
        synchronized (list) {
            list.add(iOaidObserver);
        }
        String str = l;
        if (str != null) {
            a(new IOaidObserver.Oaid(str), new Object[]{iOaidObserver});
        }
        Map<String, String> map = m;
        if (map == null || (gVar = k) == null) {
            return;
        }
        ((e0.b) gVar).a(map);
    }

    public static <K, V> void a(Map<K, V> map, K k2, V v) {
        if (k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (Throwable th) {
            LoggerImpl.global().error(1, "Oaid#JSON put failed", th, new Object[0]);
        }
    }

    public static void b(IOaidObserver iOaidObserver) {
        List<IOaidObserver> list = j;
        synchronized (list) {
            list.remove(iOaidObserver);
        }
    }

    public static Object[] c() {
        Object[] array;
        List<IOaidObserver> list = j;
        synchronized (list) {
            array = list.size() > 0 ? list.toArray() : null;
        }
        return array;
    }

    public void a() {
        LoggerImpl.global().debug(1, "Oaid#init", new Object[0]);
        if (this.f.compareAndSet(false, true)) {
            a aVar = new a();
            String str = i + "-query";
            if (TextUtils.isEmpty(str)) {
                str = "TrackerDr";
            }
            new Thread(new z5(aVar, str), str).start();
        }
    }

    public final void b() {
        String str;
        Boolean boolValueOf;
        int iIntValue;
        OaidApi.a oaid;
        LoggerImpl.global().debug(1, "Oaid#initOaid", new Object[0]);
        try {
            this.a.lock();
            LoggerImpl.global().debug(1, "Oaid#initOaid exec", new Object[0]);
            b6 b6VarA = this.d.a();
            LoggerImpl.global().debug(1, "Oaid#initOaid fetch={}", b6VarA);
            if (b6VarA != null) {
                l = b6VarA.a;
                m = b6VarA.a();
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            Context context = this.e;
            OaidApi oaidApi = this.b;
            b6 b6Var = null;
            String string = null;
            if (oaidApi == null || (oaid = oaidApi.getOaid(context)) == null) {
                str = null;
                boolValueOf = null;
            } else {
                str = oaid.a;
                boolValueOf = Boolean.valueOf(oaid.b);
                if (oaid instanceof e.b) {
                    this.g = Long.valueOf(((e.b) oaid).c);
                }
            }
            Pair pair = new Pair(str, boolValueOf);
            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
            if (pair.first != null) {
                if (b6VarA != null) {
                    string = b6VarA.b;
                    iIntValue = b6VarA.f.intValue() + 1;
                } else {
                    iIntValue = -1;
                }
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                }
                if (iIntValue <= 0) {
                    iIntValue = 1;
                }
                b6 b6Var2 = new b6((String) pair.first, string, (Boolean) pair.second, Long.valueOf(jElapsedRealtime2), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(iIntValue), this.g);
                this.d.a(b6Var2);
                b6Var = b6Var2;
            }
            if (b6Var != null) {
                l = b6Var.a;
                m = b6Var.a();
            }
            LoggerImpl.global().debug(1, "Oaid#initOaid oaidModel={}", b6Var);
        } finally {
            this.a.unlock();
            a(new IOaidObserver.Oaid(l), c());
            g gVar = k;
            if (gVar != null) {
                ((e0.b) gVar).a(m);
            }
        }
    }
}
