package Y1;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class r {

    /* renamed from: c, reason: collision with root package name */
    private static r f6464c;

    /* renamed from: a, reason: collision with root package name */
    private Handler f6465a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, List<String>> f6466b = new HashMap();

    private class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            synchronized (r.this) {
                try {
                    if (message == null) {
                        return;
                    }
                    if (message.what != 666) {
                        return;
                    }
                    for (String str : r.this.f6466b.keySet()) {
                        if (TextUtils.equals(str, "Cancel")) {
                            List list = (List) r.this.f6466b.get(str);
                            if (list != null) {
                                u.f((String[]) list.toArray(new String[list.size()]), false, "Cancel");
                            }
                        } else {
                            List list2 = (List) r.this.f6466b.get(str);
                            u.f((String[]) list2.toArray(new String[list2.size()]), true, str);
                        }
                    }
                    r.this.f6466b.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private class b extends Thread {
        b(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Looper.prepare();
            r.this.f6465a = r.this.new a(Looper.myLooper());
            Looper.loop();
        }
    }

    private r() {
        new b("SuspendManager-WorkThread").start();
    }

    public static synchronized r c() {
        try {
            if (f6464c == null) {
                f6464c = new r();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6464c;
    }

    public void d() {
    }
}
