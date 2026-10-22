package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.jmsl.C1568j1;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.security.Encrypt;
import com.autonavi.aps.amapapi.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public abstract class AgeEstimator<T> {

    /* renamed from: a, reason: collision with root package name */
    private File f18258a;

    /* renamed from: d, reason: collision with root package name */
    private Handler f18261d;

    /* renamed from: e, reason: collision with root package name */
    private String f18262e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18263f;
    public String mTag;

    /* renamed from: b, reason: collision with root package name */
    private boolean f18259b = false;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, SignalAge> f18260c = new ConcurrentHashMap();

    /* renamed from: g, reason: collision with root package name */
    private Runnable f18264g = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.AgeEstimator.2
        @Override // java.lang.Runnable
        public void run() throws IOException {
            if (AgeEstimator.this.f18259b) {
                if (AgeEstimator.this.f18263f) {
                    AgeEstimator.d(AgeEstimator.this);
                    AgeEstimator.this.f18263f = false;
                }
                if (AgeEstimator.this.f18261d != null) {
                    AgeEstimator.this.f18261d.postDelayed(AgeEstimator.this.f18264g, 60000L);
                }
            }
        }
    };

    public static class SignalAge {

        /* renamed from: a, reason: collision with root package name */
        int f18267a;

        /* renamed from: b, reason: collision with root package name */
        long f18268b;

        /* renamed from: c, reason: collision with root package name */
        long f18269c;

        public SignalAge(int i10, long j10, long j11) {
            this.f18267a = i10;
            this.f18268b = j10;
            this.f18269c = j11;
        }
    }

    public AgeEstimator(Context context, String str, Handler handler) {
        this.f18262e = null;
        if (context == null) {
            return;
        }
        this.f18261d = handler;
        this.mTag = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f18262e = Utils.getPackageNameMD5(context);
        try {
            this.f18258a = new File(context.getFilesDir().getPath(), this.mTag);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    public static int compare(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    public static void d(AgeEstimator ageEstimator) throws IOException {
        if (ageEstimator.a() > 0) {
            ageEstimator.f18260c.size();
            if (ageEstimator.b() > 0) {
                long timeBoot = Utils.getTimeBoot();
                Iterator<Map.Entry<String, SignalAge>> it = ageEstimator.f18260c.entrySet().iterator();
                while (it.hasNext()) {
                    if (timeBoot - ageEstimator.f18260c.get(it.next().getKey()).f18269c > ageEstimator.b()) {
                        it.remove();
                    }
                }
            }
            if (ageEstimator.f18260c.size() > ageEstimator.a()) {
                ArrayList arrayList = new ArrayList(ageEstimator.f18260c.keySet());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.AgeEstimator.1
                    @Override // java.util.Comparator
                    public int compare(String str, String str2) {
                        return AgeEstimator.compare(((SignalAge) AgeEstimator.this.f18260c.get(str2)).f18269c, ((SignalAge) AgeEstimator.this.f18260c.get(str)).f18269c);
                    }
                });
                for (int iA = (int) ageEstimator.a(); iA < arrayList.size(); iA++) {
                    ageEstimator.f18260c.remove(arrayList.get(iA));
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, SignalAge> entry : ageEstimator.f18260c.entrySet()) {
            try {
                sb2.append(C1568j1.g(Encrypt.aesEncrypt((entry.getKey() + Const.STR_MART_COMMA + entry.getValue().f18267a + Const.STR_MART_COMMA + entry.getValue().f18268b + Const.STR_MART_COMMA + entry.getValue().f18269c).getBytes("UTF-8"), ageEstimator.f18262e)) + "\n");
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        String string = sb2.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Utils.writeStringToFile(ageEstimator.f18258a, string, false);
    }

    public abstract int a(T t10);

    public abstract long a();

    public abstract void a(T t10, long j10);

    public abstract long b();

    public abstract long b(T t10);

    public void destroy(boolean z10) {
        Handler handler = this.f18261d;
        if (handler != null) {
            handler.removeCallbacks(this.f18264g);
        }
        if (!z10) {
            this.f18264g.run();
        }
        this.f18259b = false;
    }

    public long getAge(T t10) {
        return (Utils.getTimeBoot() - b((AgeEstimator<T>) t10)) / 1000;
    }

    public abstract String getKey(T t10);

    public void start() {
        Handler handler;
        if (!this.f18259b && (handler = this.f18261d) != null) {
            handler.removeCallbacks(this.f18264g);
            this.f18261d.postDelayed(this.f18264g, 60000L);
        }
        this.f18259b = true;
    }

    public void update(T t10) {
        b(t10, Utils.getTimeBoot());
    }

    private void b(T t10, long j10) {
        if (t10 == null || b((AgeEstimator<T>) t10) < 0) {
            return;
        }
        String key = getKey(t10);
        SignalAge signalAge = this.f18260c.get(key);
        if (signalAge == null) {
            a((AgeEstimator<T>) t10, j10);
            this.f18260c.put(key, new SignalAge(a((AgeEstimator<T>) t10), b((AgeEstimator<T>) t10), j10));
            this.f18263f = true;
            return;
        }
        signalAge.f18269c = j10;
        if (signalAge.f18267a == a((AgeEstimator<T>) t10)) {
            a((AgeEstimator<T>) t10, signalAge.f18268b);
            return;
        }
        a((AgeEstimator<T>) t10, j10);
        signalAge.f18267a = a((AgeEstimator<T>) t10);
        signalAge.f18268b = b((AgeEstimator<T>) t10);
        this.f18263f = true;
    }

    private void c() {
        try {
            Iterator<String> it = Utils.readLines(this.f18258a).iterator();
            while (it.hasNext()) {
                try {
                    String[] strArrSplit = new String(Encrypt.aesDecrypt(C1568j1.b(it.next()), this.f18262e), "UTF-8").split(Const.STR_MART_COMMA);
                    this.f18260c.put(strArrSplit[0], new SignalAge(Integer.parseInt(strArrSplit[1]), Long.parseLong(strArrSplit[2]), strArrSplit.length >= 4 ? Long.parseLong(strArrSplit[3]) : Utils.getTimeBoot()));
                } catch (Throwable th) {
                    if (this.f18258a.exists()) {
                        this.f18258a.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void update(List<T> list) {
        long timeBoot = Utils.getTimeBoot();
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            b(it.next(), timeBoot);
        }
        if (this.f18260c.size() >= list.size()) {
            this.f18263f = true;
        }
        if (this.f18260c.size() > 16384 || a() <= 0) {
            this.f18260c.clear();
            for (T t10 : list) {
                this.f18260c.put(getKey(t10), new SignalAge(a((AgeEstimator<T>) t10), b((AgeEstimator<T>) t10), timeBoot));
            }
        }
    }
}
