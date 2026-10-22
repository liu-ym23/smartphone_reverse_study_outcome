package R5;

import La.D;
import La.H;
import Y8.j;
import android.os.SystemClock;
import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010#\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ5\u0010\u000f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010J)\u0010\u0014\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0019\u001a\u00020\u0004¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001d\u0010\u001bJ\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010#R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010#R \u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010)\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010 ¨\u0006*"}, d2 = {"LR5/a;", "", "<init>", "()V", "", "chainId", "task", "target", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "tripartiteRpcToolCallId", "method", "cloudSessionId", "taskId", "e", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "path", "", "elapsedMs", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "viewCls", "f", "(Ljava/lang/String;Ljava/lang/String;)V", "rpcToolCallId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "parameter", Const.INTENT_KEY_PKGNAME, "c", "USER_QUERY_PREFIX_HINT", "Ljava/lang/String;", "", "seenCloudReq", "Ljava/util/Set;", "seenCloudResp", "seenUserClickChainIds", "", "taskIdToChainId", "Ljava/util/Map;", "TRIPARTITE_METHOD", "foundation_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String TRIPARTITE_METHOD = "ailauncher_load_tripartite_common_card";
    private static final String USER_QUERY_PREFIX_HINT = "chatcmpl-tool-";
    private static final Set<String> seenCloudReq;
    private static final Set<String> seenCloudResp;
    private static final Set<String> seenUserClickChainIds;
    private static final Map<String, String> taskIdToChainId;

    static {
        ConcurrentHashMap.KeySetView keySetViewNewKeySet = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet, "newKeySet(...)");
        seenCloudReq = keySetViewNewKeySet;
        ConcurrentHashMap.KeySetView keySetViewNewKeySet2 = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet2, "newKeySet(...)");
        seenCloudResp = keySetViewNewKeySet2;
        ConcurrentHashMap.KeySetView keySetViewNewKeySet3 = ConcurrentHashMap.newKeySet();
        p.h(keySetViewNewKeySet3, "newKeySet(...)");
        seenUserClickChainIds = keySetViewNewKeySet3;
        taskIdToChainId = new ConcurrentHashMap();
    }

    public final String a(String rpcToolCallId) {
        p.i(rpcToolCallId, "rpcToolCallId");
        if (!D.X(rpcToolCallId, "rpc-", false, 2, null)) {
            return null;
        }
        String strSubstring = rpcToolCallId.substring(4);
        p.h(strSubstring, "substring(...)");
        int iT0 = H.t0(strSubstring, ':', 0, false, 6, null);
        if (iT0 <= 0) {
            return null;
        }
        String strSubstring2 = strSubstring.substring(0, iT0);
        p.h(strSubstring2, "substring(...)");
        if (D.X(strSubstring2, USER_QUERY_PREFIX_HINT, false, 2, null)) {
            return strSubstring2;
        }
        return null;
    }

    public final String b(String parameter) {
        Object objB;
        if (parameter == null || H.x0(parameter)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            String strOptString = new JSONObject(parameter).optString("session_id");
            p.f(strOptString);
            if (strOptString.length() <= 0) {
                strOptString = null;
            }
            objB = Result.b(strOptString);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        return (String) (Result.g(objB) ? null : objB);
    }

    public final String c(String parameter) {
        Object objB;
        String strOptString;
        if (parameter == null || H.x0(parameter)) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            strOptString = new JSONObject(parameter).optString("invokeParamsJson");
            p.f(strOptString);
            if (strOptString.length() <= 0) {
                strOptString = null;
            }
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (strOptString == null) {
            return null;
        }
        String strOptString2 = new JSONObject(strOptString).optString("method");
        p.f(strOptString2);
        if (strOptString2.length() <= 0) {
            strOptString2 = null;
        }
        objB = Result.b(strOptString2);
        return (String) (Result.g(objB) ? null : objB);
    }

    public final void d(String taskId, String path, Long elapsedMs) {
        p.i(path, "path");
        if (taskId == null || H.x0(taskId)) {
            return;
        }
        b bVar = b.INSTANCE;
        String str = taskIdToChainId.get(taskId);
        if (str == null) {
            str = "unknown";
        }
        bVar.c("chain.ability", j.a("chainId", str), j.a("taskId", taskId), j.a("path", path), j.a("elapsedMs", elapsedMs), j.a("ts", Long.valueOf(SystemClock.elapsedRealtime())));
    }

    public final void e(String tripartiteRpcToolCallId, String method, String cloudSessionId, String taskId) {
        if (tripartiteRpcToolCallId == null || H.x0(tripartiteRpcToolCallId) || method == null || H.x0(method)) {
            return;
        }
        String strA = a(tripartiteRpcToolCallId);
        boolean zD = p.d(method, "ailauncher_load_tripartite_common_card");
        if ((zD ? seenCloudResp : seenCloudReq).add(tripartiteRpcToolCallId)) {
            if (zD && taskId != null && !H.x0(taskId) && strA != null && !H.x0(strA)) {
                taskIdToChainId.put(taskId, strA);
            }
            b bVar = b.INSTANCE;
            String str = zD ? "chain.cloudResp" : "chain.cloudReq";
            if (strA == null) {
                strA = "null";
            }
            bVar.c(str, j.a("chainId", strA), j.a("method", method), j.a("rpcToolCallId", tripartiteRpcToolCallId), j.a("cloudSessionId", cloudSessionId), j.a("taskId", taskId), j.a("ts", Long.valueOf(SystemClock.elapsedRealtime())));
        }
    }

    public final void f(String taskId, String viewCls) {
        if (taskId == null || H.x0(taskId)) {
            return;
        }
        b bVar = b.INSTANCE;
        String str = taskIdToChainId.get(taskId);
        if (str == null) {
            str = "unknown";
        }
        bVar.c("chain.render", j.a("chainId", str), j.a("taskId", taskId), j.a("viewCls", viewCls), j.a("ts", Long.valueOf(SystemClock.elapsedRealtime())));
    }

    public final void g(String chainId, String task, String target) {
        if (chainId == null || H.x0(chainId) || !seenUserClickChainIds.add(chainId)) {
            return;
        }
        b.INSTANCE.c("chain.userClick", j.a("chainId", chainId), j.a("task", task), j.a("target", target), j.a("ts", Long.valueOf(SystemClock.elapsedRealtime())));
    }
}
