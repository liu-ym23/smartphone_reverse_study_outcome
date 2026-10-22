package g0;

import H.h;
import H.k;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;
import w0.C2085f;

/* loaded from: classes2.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4461a;
    public final /* synthetic */ g b;

    public /* synthetic */ f(g gVar, int i) {
        this.f4461a = i;
        this.b = gVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4461a) {
            case 0:
                g gVar = this.b;
                StringBuilder sb = gVar.f;
                if (gVar.h != null) {
                    try {
                        StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                        if (stackTrace[0].getClassName().startsWith(gVar.e)) {
                            break;
                        } else {
                            gVar.h.f = System.currentTimeMillis();
                            gVar.h.h = stackTrace;
                            if (h.b) {
                                TimeoutException timeoutException = new TimeoutException("main thread task execute more than " + gVar.c + "ms");
                                timeoutException.setStackTrace(stackTrace);
                                Log.e("StackThread", "block detected", timeoutException);
                            }
                            sb.setLength(0);
                            int i = 0;
                            for (StackTraceElement stackTraceElement : stackTrace) {
                                i++;
                                sb.append("\tat " + stackTraceElement.getClassName());
                                sb.append(".");
                                sb.append(stackTraceElement.getMethodName());
                                sb.append("(");
                                sb.append(stackTraceElement.getFileName());
                                sb.append(":");
                                sb.append(stackTraceElement.getLineNumber());
                                sb.append(")\n");
                                if (i > 40) {
                                    gVar.h.f4458j = sb.toString();
                                    break;
                                }
                            }
                            gVar.h.f4458j = sb.toString();
                        }
                    } catch (Throwable th) {
                        k.f723a.z("block_deal_exception", th);
                        return;
                    }
                }
                break;
            default:
                g gVar2 = this.b;
                try {
                    if (gVar2.h == null) {
                        break;
                    } else {
                        StackTraceElement[] stackTrace2 = Looper.getMainLooper().getThread().getStackTrace();
                        if (stackTrace2[0].getClassName().startsWith(gVar2.e)) {
                            break;
                        } else {
                            gVar2.h.g = System.currentTimeMillis();
                            c cVar = gVar2.h;
                            cVar.i = stackTrace2;
                            C2085f.f().getClass();
                            JSONObject jSONObject = new JSONObject();
                            try {
                                jSONObject.put("process_usage", -1.0d);
                                jSONObject.put("stat_speed", -1.0d);
                            } catch (JSONException unused) {
                                jSONObject = new JSONObject();
                            }
                            cVar.l = jSONObject;
                            gVar2.h.m = g.a(gVar2);
                            gVar2.h.e = true;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    k.f723a.z("serious_block_deal_exception", th2);
                }
        }
    }
}
