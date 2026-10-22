package w0;

import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: w0.o, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2094o extends AbstractC2080a {
    public static final int h = Runtime.getRuntime().availableProcessors();
    public static boolean i = false;

    /* renamed from: j, reason: collision with root package name */
    public static int f6828j = 300;
    public static boolean k = false;
    public static boolean l = false;
    public long g;

    public static JSONObject l(int i6, int i10, String str) {
        JSONObject jSONObject = new JSONObject();
        if (i6 > 0) {
            try {
                jSONObject.put("total_thread_count", i6);
            } catch (JSONException e) {
                e.printStackTrace();
                return jSONObject;
            }
        }
        jSONObject.put("java_thread_count", i10);
        if (!TextUtils.isEmpty(null)) {
            jSONObject.put("scene", (Object) null);
        }
        if (!TextUtils.isEmpty(str)) {
            jSONObject.put("thread_detail", str);
        }
        jSONObject.put("is_main_process", H.h.g());
        jSONObject.put("cpu_count", h);
        jSONObject.put("process_name", H.h.c());
        return jSONObject;
    }

    @Override // w0.AbstractC2080a
    public final void b(JSONObject jSONObject) {
        k = jSONObject.optInt("enable_thread_collect", 0) == 1;
        l = jSONObject.optInt("enable_upload", 0) == 1;
        f6828j = jSONObject.optInt("thread_count_threshold", 300);
        this.g = jSONObject.optLong("collect_interval", 10L) * 60000;
    }

    @Override // w0.AbstractC2080a
    public final boolean h() {
        return true;
    }

    @Override // w0.AbstractC2080a
    public final void j() {
        int length;
        if (k && l && System.currentTimeMillis() - H.h.l > 1200000) {
            try {
                length = new File("/proc/self/task/").listFiles().length;
            } catch (Throwable unused) {
                length = 0;
            }
            if (length == 0) {
                return;
            }
            ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            int iActiveCount = threadGroup.activeCount();
            try {
                if (iActiveCount < f6828j || !i) {
                    O.a.g().c(new P.e("thread", "", "", null, null, l(length, iActiveCount, null)));
                } else {
                    Thread[] threadArr = new Thread[(iActiveCount / 2) + iActiveCount];
                    int iEnumerate = threadGroup.enumerate(threadArr);
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < iEnumerate; i6++) {
                        String name = threadArr[i6].getName();
                        if (!TextUtils.isEmpty(name)) {
                            sb.append(name);
                            sb.append(",");
                        }
                    }
                    O.a.g().c(new P.e("thread", "", "", null, null, l(length, iEnumerate, sb.toString())));
                }
            } catch (Exception unused2) {
            }
        }
    }

    @Override // w0.AbstractC2080a
    public final long k() {
        return this.g;
    }

    @Override // w0.AbstractC2080a, C.a
    public final void onReady() {
        super.onReady();
        i = true;
    }
}
