package com.stepos.ability.tracelogger;

import C7.r;
import J7.c;
import O7.i;
import S7.n;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import androidx.autofill.HintConstants;
import androidx.core.app.NotificationCompat;
import androidx.core.os.EnvironmentCompat;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.commoninternal.Key;
import dagger.hilt.android.qualifiers.ApplicationContext;
import j9.AbstractC1607a;
import j9.t;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.k;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.InterfaceC1733z;
import org.json.JSONObject;
import u9.d;

@Singleton
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ \u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0082@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/stepos/ability/tracelogger/TraceLogger;", "Lcom/stepos/ability/tracelogger/ITraceLogger;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "", "isBeachMarkEnabled", "()Z", "", "sessionId", "Lorg/json/JSONObject;", "logJson", "LC7/r;", "writeLogEntry", "(Ljava/lang/String;Lorg/json/JSONObject;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/ability/tracelogger/TraceLogEntry;", "logEntry", "log", "(Lcom/stepos/ability/tracelogger/TraceLogEntry;LH7/c;)Ljava/lang/Object;", "Landroid/content/Context;", "Companion", "tracelogger_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TraceLogger implements ITraceLogger {
    private static final String BASE_DIR = "/sdcard/Documents/clawbench";
    private static final String BEACH_MARK_KEY = "beach_mark";
    private static final String FILE_NAME = "ability.txt";
    private static final String TAG = "TraceLogger";
    private final Context context;

    @c(c = "com.stepos.ability.tracelogger.TraceLogger$log$2", f = "TraceLogger.kt", l = {81}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.tracelogger.TraceLogger$log$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        final /* synthetic */ TraceLogEntry $logEntry;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ TraceLogger this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(TraceLogEntry traceLogEntry, TraceLogger traceLogger, H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$logEntry = traceLogEntry;
            this.this$0 = traceLogger;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new AnonymousClass2(this.$logEntry, this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            try {
                if (i == 0) {
                    b.b(obj);
                    String sessionId = this.$logEntry.getSessionId();
                    if (sessionId.length() <= 0) {
                        sessionId = null;
                    }
                    if (sessionId == null) {
                        sessionId = EnvironmentCompat.MEDIA_UNKNOWN;
                    }
                    Log.d(TraceLogger.TAG, "TraceLogger logging: sessionId=" + sessionId + ", event=" + this.$logEntry.getEvent() + ", name=" + this.$logEntry.getName());
                    JSONObject jSONObject = new JSONObject();
                    TraceLogEntry traceLogEntry = this.$logEntry;
                    jSONObject.put(NotificationCompat.CATEGORY_EVENT, traceLogEntry.getEvent());
                    jSONObject.put(HintConstants.AUTOFILL_HINT_NAME, traceLogEntry.getName());
                    jSONObject.put("time", traceLogEntry.getTime());
                    jSONObject.put("session_id", sessionId);
                    String traceId = traceLogEntry.getTraceId();
                    if (traceId != null && traceId.length() > 0) {
                        jSONObject.put(Key.KEY_TRACE_ID, traceId);
                    }
                    jSONObject.put("payload", traceLogEntry.getPayload());
                    if (this.this$0.isBeachMarkEnabled()) {
                        Log.d(TraceLogger.TAG, "trace log:" + jSONObject);
                        TraceLogger traceLogger = this.this$0;
                        this.L$0 = null;
                        this.L$1 = null;
                        this.label = 1;
                        if (traceLogger.writeLogEntry(sessionId, jSONObject, this) == coroutineSingletons) {
                            return coroutineSingletons;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    b.b(obj);
                }
                return r.f317a;
            } catch (Exception e) {
                return new Integer(Log.e(TraceLogger.TAG, "Failed to log entry", e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<Object> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.ability.tracelogger.TraceLogger$writeLogEntry$2", f = "TraceLogger.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Ljava/lang/Object;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.ability.tracelogger.TraceLogger$writeLogEntry$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10342 extends SuspendLambda implements n {
        final /* synthetic */ JSONObject $logJson;
        final /* synthetic */ String $sessionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10342(String str, JSONObject jSONObject, H7.c<? super C10342> cVar) {
            super(2, cVar);
            this.$sessionId = str;
            this.$logJson = jSONObject;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C10342(this.$sessionId, this.$logJson, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws IOException {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            b.b(obj);
            try {
                File file = new File(TraceLogger.BASE_DIR, t.b0(this.$sessionId, ':', '_'));
                if (!file.exists()) {
                    file.mkdirs();
                }
                File file2 = new File(file, TraceLogger.FILE_NAME);
                String text = this.$logJson.toString() + "\n";
                Charset charset = AbstractC1607a.f4778a;
                k.f(text, "text");
                k.f(charset, "charset");
                FileOutputStream fileOutputStream = new FileOutputStream(file2, true);
                try {
                    i.Z(fileOutputStream, text, charset);
                    fileOutputStream.close();
                    return r.f317a;
                } finally {
                }
            } catch (Exception e) {
                return new Integer(Log.e(TraceLogger.TAG, "Failed to write log entry", e));
            }
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<Object> cVar) {
            return ((C10342) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @Inject
    public TraceLogger(@ApplicationContext Context context) {
        k.f(context, "context");
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBeachMarkEnabled() {
        try {
            ContentResolver contentResolver = this.context.getContentResolver();
            if (contentResolver == null) {
                return false;
            }
            return k.b(Settings.Secure.getString(contentResolver, BEACH_MARK_KEY), "1");
        } catch (Throwable th) {
            Log.e(TAG, "isBeachMarkEnabled error: " + Log.getStackTraceString(th));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeLogEntry(String str, JSONObject jSONObject, H7.c<? super r> cVar) throws Throwable {
        d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new C10342(str, jSONObject, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }

    @Override // com.stepos.ability.tracelogger.ITraceLogger
    public Object log(TraceLogEntry traceLogEntry, H7.c<? super r> cVar) throws Throwable {
        d dVar = AbstractC1691I.f5315a;
        Object objW = AbstractC1683A.w(u9.c.f6743a, new AnonymousClass2(traceLogEntry, this, null), cVar);
        return objW == CoroutineSingletons.f4909a ? objW : r.f317a;
    }
}
