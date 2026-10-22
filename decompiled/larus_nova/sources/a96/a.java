package a96;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.sync.SyncMsgModel;
import kotlin.Result;
import kotlin.ResultKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2280a = 0;

    static {
    }

    public static void a(SyncMsgModel r100, boolean r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        JSONObject r103 = new JSONObject();     // Catch: Throwable -> L8
        r103.put("sync_task_id", r100.getSyncTaskId());     // Catch: Throwable -> L8
        r103.put("sync_task_type", r100.getMsgType());     // Catch: Throwable -> L8
        if (r101 == false) goto L5;
        int r104 = 1;
    L6:
        r103.put("sync_stats_type", r104);     // Catch: Throwable -> L8
        Object r105 = Result.m9449constructorimpl(r103);     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r105) == false) goto L14;
        y86.a.c("geckosdk_bytesync_stats", (JSONObject) r105);
    L14:
        if (Result.m9452exceptionOrNullimpl(r105) == null) goto L19;
        GeckoLogger.d("upload sync event failed: " + r100.getSyncTaskId() + ", " + r100.getMsgType() + ", " + r101);
        return;
    L19:
        return;
    L5:
        r104 = 2;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }
}
