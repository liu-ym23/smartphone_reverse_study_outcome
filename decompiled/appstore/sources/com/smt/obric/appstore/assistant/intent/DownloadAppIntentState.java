package com.smt.obric.appstore.assistant.intent;

import com.bytedanceos.common.toolbox.j;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.obric.capabilitykit.common.intent.IntentResult;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.y;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.e;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: loaded from: classes4.dex */
public final class DownloadAppIntentState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DownloadAppIntentState f17875a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Mutex f17876b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map f17877c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map f17878d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f17879e;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f17880a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static long f17881b;

        static {
            f17880a = new a();
        }

        public a() {
        }

        public final String a() {
            f17881b++;
            StringBuilder r10 = new StringBuilder();
            r10.append(f17881b);
            r10.append('_');
            r10.append(System.currentTimeMillis());
            return r10.toString();
        }
    }

    static {
        f17875a = new DownloadAppIntentState();
        f17876b = MutexKt.b(false, 1, null);
        f17877c = new LinkedHashMap();
        f17878d = new LinkedHashMap();
    }

    public DownloadAppIntentState() {
    }

    public final Object a(String r10, Continuation r11) {
        if ((r11 instanceof DownloadAppIntentState$confirmDownload$1) == false) goto L7;
        DownloadAppIntentState$confirmDownload$1 r12 = (DownloadAppIntentState$confirmDownload$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Mutex r17 = (Mutex) r12.L$1;
        String r18 = (String) r12.L$0;
        c.b(r14);
        Mutex r19 = r17;
        r10 = r18;
    L29:
        DispatchContext r20 = (DispatchContext) f17877c.get(r10);     // Catch: Throwable -> L22
        if (r20 != null) goto L24;
        j.b("[AI_Intent] [DownloadApp] confirmDownload: dispatchContext is null for sid=" + r10);     // Catch: Throwable -> L22
        Unit r21 = Unit.f21064a;     // Catch: Throwable -> L22
        r19.unlock(null);
        return r21;
    L24:
        f17875a.b(r10, r20);     // Catch: Throwable -> L22
        Unit r22 = Unit.f21064a;     // Catch: Throwable -> L22
        r19.unlock(null);
        return Unit.f21064a;
    L22:
        th = move-exception;
        r19.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        r19 = f17876b;
        r12.L$0 = r10;
        r12.L$1 = r19;
        r12.label = 1;
        if (r19.lock(null, r12) != r15) goto L29;
        return r15;
    L7:
        r12 = new DownloadAppIntentState$confirmDownload$1(this, r11);
        goto L8
    }

    public final void b(String r14, DispatchContext r15) {
        j.n("[AI_Intent] [MultiRound] [DownloadApp][updateIntentResult] confirmDownload sid=" + r14 + ", dispatchContext.questionId=" + r15.getQuestionId());
        AtomicCapabilitySdk r13 = AtomicCapabilitySdk.INSTANCE;
        ConcurrentHashMap r10 = new ConcurrentHashMap();
        r10.put(Ext.KEY_CONTINUE_DOWNLOAD_CONFIRMED, "1");
        Unit r16 = Unit.f21064a;
        r13.updateIntentResult(new IntentResult(0, null, null, null, false, false, 0, null, null, r10, 510, null), r15, false);
    }

    public final Object c(Continuation r10) {
        if ((r10 instanceof DownloadAppIntentState$currentSessionId$1) == false) goto L7;
        DownloadAppIntentState$currentSessionId$1 r11 = (DownloadAppIntentState$currentSessionId$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        Mutex r16 = (Mutex) r11.L$0;
        c.b(r13);
    L24:
        String r17 = f17879e;     // Catch: Throwable -> L21
        r16.unlock(null);
        return r17;
    L21:
        th = move-exception;
        r16.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r13);
        Mutex r18 = f17876b;
        r11.L$0 = r18;
        r11.label = 1;
        if (r18.lock(null, r11) != r14) goto L17;
        return r14;
    L17:
        r16 = r18;
    L7:
        r11 = new DownloadAppIntentState$currentSessionId$1(this, r10);
        goto L8
    }

    public final Object d(String r10, Continuation r11) {
        if ((r11 instanceof DownloadAppIntentState$endSession$1) == false) goto L7;
        DownloadAppIntentState$endSession$1 r12 = (DownloadAppIntentState$endSession$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Mutex r17 = (Mutex) r12.L$1;
        String r18 = (String) r12.L$0;
        c.b(r14);
        Mutex r19 = r17;
        r10 = r18;
    L23:
        f17875a.e(r10);     // Catch: Throwable -> L20
        Unit r20 = Unit.f21064a;     // Catch: Throwable -> L20
        r19.unlock(null);
        return Unit.f21064a;
    L20:
        th = move-exception;
        r19.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        r19 = f17876b;
        r12.L$0 = r10;
        r12.L$1 = r19;
        r12.label = 1;
        if (r19.lock(null, r12) != r15) goto L23;
        return r15;
    L7:
        r12 = new DownloadAppIntentState$endSession$1(this, r11);
        goto L8
    }

    public final void e(String r10) {
        j.n("[AI_Intent] [DownloadApp] endSessionLocked sid=" + r10);
        if (r10 != null) goto L9;
        f17879e = null;
        f17877c.clear();
        Iterator r11 = f17878d.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L8;
        ReceiveChannel.DefaultImpls.a((Channel) ((Map.Entry) r11.next()).getValue(), null, 1, null);
        goto L6
    L8:
        f17878d.clear();
        return;
    L9:
        y.d(f17877c).remove(r10);
        Channel r12 = (Channel) y.d(f17878d).remove(r10);
        if (r12 == null) goto L15;
        ReceiveChannel.DefaultImpls.a(r12, null, 1, null);
        return;
    }

    public final Object f(String r10, Continuation r11) {
        if ((r11 instanceof DownloadAppIntentState$getResultChBySessionId$1) == false) goto L7;
        DownloadAppIntentState$getResultChBySessionId$1 r12 = (DownloadAppIntentState$getResultChBySessionId$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Mutex r17 = (Mutex) r12.L$1;
        String r18 = (String) r12.L$0;
        c.b(r14);
        Mutex r19 = r17;
        r10 = r18;
    L23:
        Channel r20 = (Channel) f17878d.get(r10);     // Catch: Throwable -> L20
        r19.unlock(null);
        return r20;
    L20:
        th = move-exception;
        r19.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        r19 = f17876b;
        r12.L$0 = r10;
        r12.L$1 = r19;
        r12.label = 1;
        if (r19.lock(null, r12) != r15) goto L23;
        return r15;
    L7:
        r12 = new DownloadAppIntentState$getResultChBySessionId$1(this, r11);
        goto L8
    }

    public final Object g(DispatchContext r10, Continuation r11) {
        if ((r11 instanceof DownloadAppIntentState$newSession$1) == false) goto L7;
        DownloadAppIntentState$newSession$1 r12 = (DownloadAppIntentState$newSession$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        Mutex r17 = (Mutex) r12.L$1;
        DispatchContext r18 = (DispatchContext) r12.L$0;
        c.b(r14);
        Mutex r19 = r17;
        r10 = r18;
    L23:
        f17875a.e(null);     // Catch: Throwable -> L20
        String r20 = a.f17880a.a();     // Catch: Throwable -> L20
        f17879e = r20;     // Catch: Throwable -> L20
        f17877c.put(r20, r10);     // Catch: Throwable -> L20
        f17878d.put(r20, e.b(Channel.UNLIMITED, null, null, 6, null));     // Catch: Throwable -> L20
        j.n("[AI_Intent] [DownloadApp] newSession sessionId=" + r20);     // Catch: Throwable -> L20
        r19.unlock(null);
        return r20;
    L20:
        th = move-exception;
        r19.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        c.b(r14);
        r19 = f17876b;
        r12.L$0 = r10;
        r12.L$1 = r19;
        r12.label = 1;
        if (r19.lock(null, r12) != r15) goto L23;
        return r15;
    L7:
        r12 = new DownloadAppIntentState$newSession$1(this, r11);
        goto L8
    }
}
