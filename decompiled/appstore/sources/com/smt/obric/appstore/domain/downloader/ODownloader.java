package com.smt.obric.appstore.domain.downloader;

import android.content.Context;
import com.bytedanceos.common.toolbox.ServerElements;
import com.bytedanceos.common.toolbox.j;
import com.obric.download.BindCallback;
import com.obric.download.DownloadListener;
import com.obric.download.base.DownloadInfo;
import com.obric.download.base.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.b0;
import kotlin.collections.u;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.f1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes4.dex */
public final class ODownloader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ODownloader f18038a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Context f18039b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CoroutineDispatcher f18040c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final MutableStateFlow f18041d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final StateFlow f18042e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final com.smt.obric.appstore.domain.downloader.a f18043f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static DownloadListener f18044g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f18045h = null;

    public static final class a implements BindCallback {
        public a() {
        }

        @Override // com.obric.download.BindCallback
        public void onServiceConnected() {
            j.n("[ODownloader] onServiceConnected");
            ODownloader.f(ODownloader.f18038a);
            ODownloader.e().setValue(Boolean.TRUE);
        }

        @Override // com.obric.download.BindCallback
        public void onServiceDisconnected() {
            j.p("[ODownloader] onServiceDisconnected, sdk will rebind service ...");
            ODownloader.e().setValue(Boolean.FALSE);
        }
    }

    public static final class b implements DownloadListener {
        public b() {
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadCancel(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            j.n("[AppStatus][ODownloader][Callback] onDownloadCancel " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onDownloadCancel(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadFailed(DownloadInfo r10, int r11, String r12) {
            q.g(r10, ServerElements.INFO);
            q.g(r12, "errorMsg");
            j.n("[AppStatus][ODownloader][Callback] onDownloadFailed " + c.a(r10) + " errorCode=" + r11 + ", errorMsg=" + r12);
            DownloadListener r13 = ODownloader.c();
            if (r13 != null) goto L5;
            q.y("listener");
            r13 = null;
        L5:
            r13.onDownloadFailed(r10, r11, r12);
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadFinish(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            j.n("[AppStatus][ODownloader][Callback] onDownloadFinish " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onDownloadFinish(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadPause(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            j.n("[AppStatus][ODownloader][Callback] onDownloadPause " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onDownloadPause(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadPending(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            j.n("[AppStatus][ODownloader][Callback] onDownloadPending " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onDownloadPending(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloadStart(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            j.n("[AppStatus][ODownloader][Callback] onDownloadStart " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onDownloadStart(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onDownloading(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            com.smt.obric.appstore.domain.downloader.a r11 = ODownloader.d();
            String r12 = String.valueOf(r10.getId());
            if (r11.d(r12, !com.smt.obric.appstore.domain.app.j.a()) == false) goto L5;
            j.n("[AppStatus][ODownloader][Callback] onDownloading, skipped=" + r11.b(r12) + ", " + c.a(r10) + ", speed=" + r10.getSpeed());
            r11.c(r12);
        L5:
            DownloadListener r13 = ODownloader.c();
            if (r13 != null) goto L8;
            q.y("listener");
            r13 = null;
        L8:
            r13.onDownloading(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onExtraInfoUpdate(DownloadInfo r10) {
            q.g(r10, ServerElements.INFO);
            j.n("[AppStatus][ODownloader][Callback] onExtraInfoUpdate " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onExtraInfoUpdate(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onFirstStart(DownloadInfo r10) {
            q.g(r10, "entity");
            j.n("[AppStatus][ODownloader][Callback] onFirstStart " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onFirstStart(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onFirstSuccess(DownloadInfo r10) {
            q.g(r10, "entity");
            j.n("[AppStatus][ODownloader][Callback] onFirstSuccess " + c.a(r10));
            DownloadListener r11 = ODownloader.c();
            if (r11 != null) goto L5;
            q.y("listener");
            r11 = null;
        L5:
            r11.onFirstSuccess(r10);
        }

        @Override // com.obric.download.DownloadListener
        public void onRetry(DownloadInfo r10, int r11, String r12) {
            q.g(r10, "entity");
            q.g(r12, "errorMsg");
            j.n("[AppStatus][ODownloader][Callback] onRetry " + c.a(r10) + " errorCode=" + r11 + ", errorMsg=" + r12);
            DownloadListener r13 = ODownloader.c();
            if (r13 != null) goto L5;
            q.y("listener");
            r13 = null;
        L5:
            r13.onRetry(r10, r11, r12);
        }

        @Override // com.obric.download.DownloadListener
        public void onRetryDelay(DownloadInfo r10, int r11, String r12) {
            q.g(r10, "entity");
            q.g(r12, "errorMsg");
            j.n("[AppStatus][ODownloader][Callback] onRetryDelay " + c.a(r10) + " errorCode=" + r11 + ", errorMsg=" + r12);
            DownloadListener r13 = ODownloader.c();
            if (r13 != null) goto L5;
            q.y("listener");
            r13 = null;
        L5:
            r13.onRetryDelay(r10, r11, r12);
        }
    }

    static {
        f18038a = new ODownloader();
        f18040c = l0.b();
        MutableStateFlow r10 = f1.a(Boolean.FALSE);
        f18041d = r10;
        f18042e = kotlinx.coroutines.flow.c.b(r10);
        f18043f = new com.smt.obric.appstore.domain.downloader.a();
        f18045h = new b();
    }

    public ODownloader() {
    }

    public static final /* synthetic */ Object a(ODownloader r10, Continuation r11) {
        return r10.g(r11);
    }

    public static final /* synthetic */ Context b() {
        return f18039b;
    }

    public static final /* synthetic */ DownloadListener c() {
        return f18044g;
    }

    public static final /* synthetic */ com.smt.obric.appstore.domain.downloader.a d() {
        return f18043f;
    }

    public static final /* synthetic */ MutableStateFlow e() {
        return f18041d;
    }

    public static final /* synthetic */ void f(ODownloader r10) {
        r10.t();
    }

    public static /* synthetic */ Object l(ODownloader r10, String r11, Continuation r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = null;
    L6:
        return r10.k(r11, r12);
    }

    public static final void n(Context r10, DownloadListener r11) {
        q.g(r10, "ctx");
        q.g(r11, "listener");
        f18039b = r10;
        String r12 = ODownloaderReceiver.class.getName();
        j.o("[ODownloader] init. receiverName=" + r12);
        yb.b.a r13 = new yb.b.a();
        String r14 = r10.getPackageName();
        q.f(r14, "getPackageName(...)");
        yb.b.a r15 = r13.d(r14);
        String r16 = r10.getPackageName();
        q.f(r16, "getPackageName(...)");
        yb.b.a r17 = r15.b(r16).f(100003070).g("1.0.3").c(2);
        q.d(r12);
        yb.b r18 = r17.e(r12).a();
        f18044g = r11;
        yb.c.f26207r.b(r10, r18);
        f18038a.j();
    }

    public final Object A(DownloadTask r10, Continuation r11) {
        return h.g(f18040c, new ODownloader$submitTask$2(r10, null), r11);
    }

    public final Object B(long r10, String r11, Continuation r12) {
        return h.g(f18040c, new ODownloader$updateExtraInfo$2(r10, r11, null), r12);
    }

    public final Object C(List r10, List r11, Continuation r12) {
        return i("updateExtraInfo", r10, new ODownloader$updateExtraInfos$2(r11, null), r12);
    }

    public final Object g(Continuation r10) {
        if ((r10 instanceof ODownloader$awaitServiceBound$1) == false) goto L7;
        ODownloader$awaitServiceBound$1 r11 = (ODownloader$awaitServiceBound$1) r10;
        int r12 = r11.label;
        if ((r12 & Integer.MIN_VALUE) == 0) goto L7;
        r11.label = r12 - Integer.MIN_VALUE;
    L8:
        Object r13 = r11.result;
        Object r14 = kotlin.coroutines.intrinsics.a.d();
        int r15 = r11.label;
        if (r15 == 0) goto L14;
        if (r15 != 1) goto L13;
        kotlin.c.b(r13);
    L21:
        j.n("[ODownloader] awaitServiceBound X");
        return Unit.f21064a;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r13);
        StateFlow r16 = f18042e;
        if (((Boolean) r16.getValue()).booleanValue() == true) goto L17;
        j.n("[ODownloader] awaitServiceBound E");
        ODownloader$awaitServiceBound$2 r17 = new ODownloader$awaitServiceBound$2(null);
        r11.label = 1;
        if (kotlinx.coroutines.flow.c.v(r16, r17, r11) != r14) goto L21;
        return r14;
    L17:
        return Unit.f21064a;
    L7:
        r11 = new ODownloader$awaitServiceBound$1(this, r10);
        goto L8
    }

    public final Object h(String r10, List r11, Function2 r12, Continuation r13) {
        return h.g(f18040c, new ODownloader$batchByIds$2(r10, r11, r12, null), r13);
    }

    public final Object i(String r10, List r11, Function3 r12, Continuation r13) {
        return h.g(f18040c, new ODownloader$batchByIdsIndexed$2(r10, r11, r12, null), r13);
    }

    public final void j() {
        j.n("[ODownloader] bindService");
        a r10 = new a();
        yb.c.f26207r.a().u(r10);
    }

    public final Object k(String r10, Continuation r11) {
        return h.g(f18040c, new ODownloader$getAllDownloadInfo$2(r10, null), r11);
    }

    public final Object m(String r10, List r11, Continuation r12) {
        return h.g(f18040c, new ODownloader$getDownloadInfoListByStateList$2(r10, r11, null), r12);
    }

    public final void o(DownloadInfo r10) {
        q.g(r10, ServerElements.INFO);
        j.n("[ODownloader] invokeDownloadCompleteCancelled " + c.a(r10));
        DownloadListener r11 = f18044g;
        if (r11 != null) goto L5;
        q.y("listener");
        r11 = null;
    L5:
        r11.onDownloadCancel(r10);
    }

    public final void p(DownloadInfo r10) {
        q.g(r10, ServerElements.INFO);
        j.n("[ODownloader] invokeDownloadCompleteFailed " + c.a(r10));
        DownloadListener r11 = f18044g;
        if (r11 != null) goto L5;
        q.y("listener");
        r11 = null;
    L5:
        Integer r12 = r10.getErrorCode();
        if (r12 == null) goto L8;
        int r13 = r12.intValue();
    L9:
        String r14 = r10.getErrorMsg();
        if (r14 != null) goto L12;
        r14 = "NULL_NULL_NULL";
    L12:
        r11.onDownloadFailed(r10, r13, r14);
        return;
    L8:
        r13 = -9999999;
        goto L9
    }

    public final void q(DownloadInfo r10) {
        q.g(r10, ServerElements.INFO);
        j.n("[ODownloader] invokeDownloadCompleteSucc " + c.a(r10));
        DownloadListener r11 = f18044g;
        if (r11 != null) goto L5;
        q.y("listener");
        r11 = null;
    L5:
        r11.onDownloadFinish(r10);
    }

    public final Object r(long r10, Continuation r11) {
        return h.g(f18040c, new ODownloader$pauseTask$2(r10, null), r11);
    }

    public final Object s(List r10, Continuation r11) {
        return h("pauseTasks", r10, new ODownloader$pauseTasks$2(this), r11);
    }

    public final void t() {
        j.n("[ODownloader] E: registerDownloadListener");
        yb.c.f26207r.a().D(f18045h);
        j.n("[ODownloader] X: registerDownloadListener");
    }

    public final Object u(List r10, Continuation r11) {
        if ((r11 instanceof ODownloader$removeDownloadTasks$1) == false) goto L7;
        ODownloader$removeDownloadTasks$1 r12 = (ODownloader$removeDownloadTasks$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = kotlin.coroutines.intrinsics.a.d();
        int r16 = r12.label;
        if (r16 == 0) goto L14;
        if (r16 != 1) goto L13;
        r10 = (List) r12.L$0;
        kotlin.c.b(r14);
    L17:
        j.n("[AppStatus][ODownloader][Action] E: removeDownloadTasks ids=" + r10);
        yb.c r17 = yb.c.f26207r.a();
        ArrayList r18 = new ArrayList(u.r(r10, 10));
        Iterator r19 = r10.iterator();
    L19:
        if (r19.hasNext() == false) goto L21;
        r18.add(tf.a.c((int) ((Number) r19.next()).longValue()));
        goto L19
    L21:
        r17.x(b0.w0(r18));
        j.n("[AppStatus][ODownloader][Action] X: removeDownloadTasks ids=" + r10);
        return tf.a.c(r10.size());
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        kotlin.c.b(r14);
        r12.L$0 = r10;
        r12.label = 1;
        if (g(r12) != r15) goto L17;
        return r15;
    L7:
        r12 = new ODownloader$removeDownloadTasks$1(this, r11);
        goto L8
    }

    public final Object v(long r10, Continuation r11) {
        return h.g(f18040c, new ODownloader$removeTask$2(r10, null), r11);
    }

    public final Object w(long r10, Continuation r11) {
        return h.g(f18040c, new ODownloader$restartTask$2(r10, null), r11);
    }

    public final Object x(long r10, Continuation r11) {
        return h.g(f18040c, new ODownloader$resumeTask$2(r10, null), r11);
    }

    public final Object y(List r10, Continuation r11) {
        return h("resumeTasks", r10, new ODownloader$resumeTasks$2(this), r11);
    }

    public final Object z(long r10, boolean r11, Continuation r12) {
        return h.g(f18040c, new ODownloader$setWiFiOnly$2(r10, r11, null), r12);
    }
}
