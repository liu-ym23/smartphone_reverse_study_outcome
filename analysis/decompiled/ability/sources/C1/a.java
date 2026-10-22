package C1;

import H.h;
import H1.c;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static List f281a = new ArrayList();
    public static List b = new ArrayList();
    public static final String c;
    public static volatile long d;
    public static volatile boolean e;

    static {
        new ArrayList();
        c = "hprof_force_upload";
        d = 0L;
        e = false;
    }

    public static void a() {
        if (!h.f719x) {
            if (h.b) {
                Log.d("ApmInsight", U7.a.e(new String[]{"can not report,memory upload file return"}));
            }
        } else {
            synchronized (a.class) {
                if (!e && !TextUtils.isEmpty(c.d().e().getString("latestFilePath", ""))) {
                    e = true;
                    E1.a.b.execute(new A1.a(2));
                }
            }
        }
    }
}
