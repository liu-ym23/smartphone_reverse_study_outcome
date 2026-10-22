package o2;

import android.text.TextUtils;
import com.apm.insight.CrashType;
import com.apm.insight.f;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import n2.d;
import w2.l;
import y2.e;

/* renamed from: o2.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC1757b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StackTraceElement[] f5417a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ Map e;

    public RunnableC1757b(StackTraceElement[] stackTraceElementArr, int i, String str, String str2, Map map) {
        this.f5417a = stackTraceElementArr;
        this.b = i;
        this.c = str;
        this.d = str2;
        this.e = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StackTraceElement stackTraceElement;
        String string;
        StackTraceElement[] stackTraceElementArr = this.f5417a;
        int i = this.b;
        String str = this.c;
        String str2 = this.d;
        Map map = this.e;
        if (stackTraceElementArr != null) {
            try {
                if (stackTraceElementArr.length > i + 1 && (stackTraceElement = stackTraceElementArr[i]) != null) {
                    if (stackTraceElementArr.length <= 0) {
                        string = null;
                    } else {
                        StringBuilder sb = new StringBuilder();
                        while (i < stackTraceElementArr.length) {
                            e.g(stackTraceElementArr[i], sb);
                            i++;
                        }
                        string = sb.toString();
                    }
                    if (TextUtils.isEmpty(string)) {
                        return;
                    }
                    d dVarV = d.v(stackTraceElement, string, str, Thread.currentThread().getName(), str2);
                    S0.b.T(map, dVarV);
                    u1.d.s().p(CrashType.ENSURE, dVarV);
                    ConcurrentHashMap concurrentHashMap = l.d;
                    l.b(f.b, dVarV);
                    S0.b.t0("[report] " + str);
                }
            } catch (Throwable th) {
                S0.b.p0(th);
            }
        }
    }
}
