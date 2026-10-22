package D6;

import Y8.j;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.perfbinder.client.PerfBinderClient;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ/\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0013R\u0014\u0010\u0019\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0013¨\u0006\u001a"}, d2 = {"LD6/a;", "", "<init>", "()V", "", "taskId", "", "sessionId", "", a.KEY_TASK_STATUS, "", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;JI)Z", "c", "(Ljava/lang/String;J)Z", "trace", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;JILjava/lang/String;)Z", "AUTHORITY", "Ljava/lang/String;", "SERVICE_NAME", "METHOD_NAME", "KEY_TASK_ID", "KEY_SESSION_ID", "KEY_TASK_STATUS", "KEY_ERROR_CODE", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final String AUTHORITY = "com.stepos.common.ability.proxy";
    public static final a INSTANCE = new a();
    public static final String KEY_ERROR_CODE = "errorCode";
    public static final String KEY_SESSION_ID = "SESSION_ID";
    public static final String KEY_TASK_ID = "taskId";
    public static final String KEY_TASK_STATUS = "taskStatus";
    public static final String METHOD_NAME = "onAmooMessage";
    public static final String SERVICE_NAME = "com.stepos.common.ability.proxy.ipc.AmooMessageReceiver";

    public final boolean a(String taskId, long sessionId, int taskStatus, String trace) {
        Object objB;
        Object obj;
        Bundle bundle = new Bundle(3);
        bundle.putString("taskId", taskId);
        bundle.putLong(KEY_SESSION_ID, sessionId);
        bundle.putInt(KEY_TASK_STATUS, taskStatus);
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(PerfBinderClient.INSTANCE.safeIpcRequest(AUTHORITY, SERVICE_NAME, METHOD_NAME, bundle));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            obj = objB;
            R5.b.INSTANCE.h(trace + ".ipc.fail", j.a("taskId", taskId), j.a("sessionId", Long.valueOf(sessionId)), j.a(KEY_TASK_STATUS, Integer.valueOf(taskStatus)), j.a("exception", thE.getClass().getSimpleName()), j.a("message", thE.getMessage()));
        } else {
            obj = objB;
        }
        Bundle bundle2 = (Bundle) (Result.g(obj) ? null : obj);
        if (bundle2 == null) {
            return false;
        }
        int i10 = bundle2.getInt("errorCode", -1);
        boolean z10 = i10 == 0;
        if (z10) {
            R5.b.INSTANCE.c(trace + ".ipc.ok", j.a("taskId", taskId), j.a("sessionId", Long.valueOf(sessionId)), j.a(KEY_TASK_STATUS, Integer.valueOf(taskStatus)));
        } else {
            R5.b.INSTANCE.h(trace + ".ipc.error", j.a("taskId", taskId), j.a("sessionId", Long.valueOf(sessionId)), j.a(KEY_TASK_STATUS, Integer.valueOf(taskStatus)), j.a("errorCode", Integer.valueOf(i10)));
        }
        return z10;
    }

    public final boolean b(String taskId, long sessionId, int taskStatus) {
        p.i(taskId, "taskId");
        return a(taskId, sessionId, taskStatus, "alipay.cancel");
    }

    public final boolean c(String taskId, long sessionId) {
        p.i(taskId, "taskId");
        return a(taskId, sessionId, 8, "alipay.view");
    }
}
