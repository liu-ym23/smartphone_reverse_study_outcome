package l6;

import android.app.ActivityManager;
import android.app.ApplicationExitInfo;
import android.content.Context;
import com.stepos.aiengine.AIEngineApplication;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.LogModule;
import com.stepos.core.model.manifest.ModelManifest;
import com.tencent.mmkv.MMKV;
import gc.n;
import gc.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.b;
import kotlin.c;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.g;
import lb.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10342a;

    /* renamed from: b, reason: collision with root package name */
    public final d f10343b = b.b(new com.stepos.cpuset.b(9));

    public a(AIEngineApplication aIEngineApplication) {
        this.f10342a = aIEngineApplication.getApplicationContext();
    }

    public static void c(a aVar) {
        Object objA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MMKV mmkv = (MMKV) aVar.f10343b.getValue();
        if (mmkv == null) {
            return;
        }
        try {
            mmkv.putString("restart_wall_ms", kotlin.collections.a.z0(kotlin.collections.a.K0(5, kotlin.collections.a.E0(aVar.b(), Long.valueOf(jCurrentTimeMillis))), ",", null, null, null, 62));
            objA = mmkv;
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            AIEngineLogger.w(LogModule.SERVICE, "RestartLedger", "recordRestart failed: " + thB);
        }
    }

    public final String a() {
        Object objA;
        ApplicationExitInfo applicationExitInfo;
        Context context = this.f10342a;
        try {
            Object systemService = context.getSystemService("activity");
            g.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            List<ApplicationExitInfo> historicalProcessExitReasons = ((ActivityManager) systemService).getHistoricalProcessExitReasons(context.getPackageName(), 0, 1);
            g.e(historicalProcessExitReasons, "getHistoricalProcessExitReasons(...)");
            applicationExitInfo = (ApplicationExitInfo) kotlin.collections.a.v0(historicalProcessExitReasons);
        } catch (Throwable th) {
            objA = c.a(th);
        }
        if (applicationExitInfo == null) {
            return ModelManifest.BACKEND_NONE;
        }
        int reason = applicationExitInfo.getReason();
        if (reason != 10) {
            switch (reason) {
                case 1:
                    objA = "exit_self";
                    break;
                case 2:
                    objA = "signaled(" + applicationExitInfo.getStatus() + ")";
                    break;
                case 3:
                    objA = "lmk";
                    break;
                case 4:
                    objA = "crash";
                    break;
                case 5:
                    objA = "native_crash";
                    break;
                case 6:
                    objA = "anr";
                    break;
                default:
                    objA = "other(" + applicationExitInfo.getReason() + ")";
                    break;
            }
        } else {
            objA = "user_requested";
        }
        Throwable thB = Result.b(objA);
        if (thB != null) {
            objA = a0.a.k("unknown(", thB.getClass().getSimpleName(), ")");
        }
        return (String) objA;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.Result$Failure] */
    /* JADX WARN: Type inference failed for: r0v6, types: [kotlin.collections.EmptyList] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.ArrayList] */
    public final List<Long> b() {
        Object objA;
        MMKV mmkv = (MMKV) this.f10343b.getValue();
        if (mmkv == null) {
            return EmptyList.f10001a;
        }
        try {
            String strG = mmkv.g("restart_wall_ms");
            if (strG != null) {
                List listE0 = q.E0(strG, new char[]{','});
                objA = new ArrayList();
                Iterator it = listE0.iterator();
                while (it.hasNext()) {
                    Long lD0 = n.d0((String) it.next());
                    if (lD0 != null) {
                        objA.add(lD0);
                    }
                }
            } else {
                objA = EmptyList.f10001a;
            }
        } catch (Throwable th) {
            objA = c.a(th);
        }
        Throwable thB = Result.b(objA);
        EmptyList emptyList = objA;
        if (thB != null) {
            emptyList = EmptyList.f10001a;
        }
        return emptyList;
    }
}
