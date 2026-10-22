package com.stepos.taskrobot.llmapi.stepfun.internal;

import C7.f;
import I4.l;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.OperationCanceledException;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import f6.AbstractC1436a;
import j9.m;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.a;
import kotlin.b;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\fR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/internal/ChatActiveQuery;", "", AppAgent.CONSTRUCT, "()V", "Landroid/content/Context;", "context", "", "sessionId", "", "isActive", "(Landroid/content/Context;Ljava/lang/String;)Z", "TAG", "Ljava/lang/String;", "AUTHORITY", "PATH", "PARAM_SESSION_ID", "COL_ACTIVE", "", "QUERY_TIMEOUT_MS", "J", "Landroid/os/Handler;", "timeoutHandler$delegate", "LC7/f;", "getTimeoutHandler", "()Landroid/os/Handler;", "timeoutHandler", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ChatActiveQuery {
    private static final String AUTHORITY = "com.stepos.ailauncher.state.provider";
    private static final String COL_ACTIVE = "active";
    private static final String PARAM_SESSION_ID = "session_id";
    private static final String PATH = "chat_active";
    private static final long QUERY_TIMEOUT_MS = 1000;
    private static final String TAG = "ChatActiveQuery";
    public static final ChatActiveQuery INSTANCE = new ChatActiveQuery();

    /* renamed from: timeoutHandler$delegate, reason: from kotlin metadata */
    private static final f timeoutHandler = a.a(new com.uxsense.parse.a(22));

    private ChatActiveQuery() {
    }

    private final Handler getTimeoutHandler() {
        return (Handler) timeoutHandler.getF4884a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void isActive$lambda$0(CancellationSignal cancellationSignal, String str) {
        cancellationSignal.cancel();
        AbstractC1436a.e(TAG, "query timeout(1000ms) cancelled, sid=" + str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler timeoutHandler_delegate$lambda$0() {
        HandlerThread handlerThread = new HandlerThread("ChatActiveQuery-Timeout");
        handlerThread.start();
        return new Handler(handlerThread.getLooper());
    }

    public final boolean isActive(Context context, String sessionId) {
        Object objA;
        k.f(context, "context");
        k.f(sessionId, "sessionId");
        boolean z10 = false;
        if (m.s0(sessionId)) {
            return false;
        }
        Uri uriBuild = Uri.parse("content://com.stepos.ailauncher.state.provider/chat_active").buildUpon().appendQueryParameter("session_id", sessionId).build();
        CancellationSignal cancellationSignal = new CancellationSignal();
        l lVar = new l(20, cancellationSignal, sessionId);
        getTimeoutHandler().postDelayed(lVar, 1000L);
        try {
            Cursor cursorQuery = context.getContentResolver().query(uriBuild, null, null, null, null, cancellationSignal);
            if (cursorQuery == null) {
                AbstractC1436a.e(TAG, "query returned null cursor (provider invisible or absent), sid=".concat(sessionId), true);
            } else {
                Cursor cursor = cursorQuery;
                try {
                    Cursor cursor2 = cursor;
                    if (cursor2.moveToFirst()) {
                        if (cursor2.getInt(cursor2.getColumnIndexOrThrow(COL_ACTIVE)) == 1) {
                            z10 = true;
                        }
                    }
                    cursor.close();
                } finally {
                }
            }
            objA = Boolean.valueOf(z10);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            if (!(thA instanceof OperationCanceledException)) {
                AbstractC1436a.e(TAG, B7.a.n("query failed sid=", sessionId, ": ", thA.getMessage()), true);
            }
            objA = Boolean.FALSE;
        }
        INSTANCE.getTimeoutHandler().removeCallbacks(lVar);
        return ((Boolean) objA).booleanValue();
    }
}
