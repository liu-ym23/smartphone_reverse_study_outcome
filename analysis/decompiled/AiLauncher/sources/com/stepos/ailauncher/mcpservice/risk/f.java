package com.stepos.ailauncher.mcpservice.risk;

import Y8.t;
import Z8.C1174w;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import h8.C4148a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ1\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u001b\u0010\rR\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR,\u0010\u001f\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00060\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010!\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00170\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010 R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/mcpservice/risk/f;", "", "<init>", "()V", "", "requestId", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/mcpservice/risk/q;", "LY8/t;", "callback", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Lp9/l;)V", "l", "(Ljava/lang/String;)V", "Landroid/content/Context;", "context", "Lcom/stepos/ailauncher/mcpservice/risk/p;", "params", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/content/Context;Lcom/stepos/ailauncher/mcpservice/risk/p;Lp9/l;)V", "result", Const.INTENT_KEY_UMID, "(Ljava/lang/String;Lcom/stepos/ailauncher/mcpservice/risk/q;)V", "Lkotlin/Function0;", DidiCardProvider.ACTION_DISMISS, Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;Lp9/a;)V", "e", "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "callbacks", "Ljava/util/concurrent/ConcurrentHashMap;", "overlayDismissers", "Landroid/os/Handler;", "mainHandler", "Landroid/os/Handler;", "mcpservice_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    private static final String TAG = "RiskStatementBridge";
    public static final f INSTANCE = new f();
    private static final ConcurrentHashMap<String, InterfaceC5074l<q, t>> callbacks = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, InterfaceC5063a<t>> overlayDismissers = new ConcurrentHashMap<>();
    private static final Handler mainHandler = new Handler(Looper.getMainLooper());

    public static final void f(String str) {
        InterfaceC5063a<t> interfaceC5063aRemove = overlayDismissers.remove(str);
        if (interfaceC5063aRemove != null) {
            interfaceC5063aRemove.invoke();
            return;
        }
        C4148a.d(TAG, "dismissOverlayForRequest skipped | requestId=" + str, false, 4, null);
    }

    public static final void j(Context context, final RiskStatementParams riskStatementParams) {
        InterfaceC5074l<? super q, t> interfaceC5074l = new InterfaceC5074l() { // from class: com.stepos.ailauncher.mcpservice.risk.e
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return f.k(riskStatementParams, (q) obj);
            }
        };
        kotlin.jvm.internal.p.f(context);
        new o(context, riskStatementParams).Y(interfaceC5074l);
    }

    public static final t k(RiskStatementParams riskStatementParams, q result) {
        kotlin.jvm.internal.p.i(result, "result");
        C4148a.d(TAG, "popup onResult | requestId=" + riskStatementParams.getRequestId() + ", result=" + result, false, 4, null);
        INSTANCE.d(riskStatementParams.getRequestId(), result);
        return t.f7040a;
    }

    public final void d(String requestId, q result) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(result, "result");
        ConcurrentHashMap<String, InterfaceC5074l<q, t>> concurrentHashMap = callbacks;
        InterfaceC5074l<q, t> interfaceC5074lRemove = concurrentHashMap.remove(requestId);
        if (interfaceC5074lRemove == null) {
            C4148a.u(TAG, "deliverResult missed | requestId=" + requestId + ", result=" + result + ", reason=no callback (duplicate or expired)", false, 4, null);
            return;
        }
        C4148a.k(TAG, "deliverResult | requestId=" + requestId + ", result=" + result + ", remainingCallbacks=" + concurrentHashMap.size(), false, 4, null);
        interfaceC5074lRemove.invoke(result);
    }

    public final void e(final String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.c
            @Override // java.lang.Runnable
            public final void run() {
                f.f(requestId);
            }
        });
    }

    public final void g(String requestId, InterfaceC5074l<? super q, t> callback) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(callback, "callback");
        ConcurrentHashMap<String, InterfaceC5074l<q, t>> concurrentHashMap = callbacks;
        concurrentHashMap.put(requestId, callback);
        C4148a.d(TAG, "register | requestId=" + requestId + ", pendingCallbacks=" + concurrentHashMap.size(), false, 4, null);
    }

    public final void h(String requestId, InterfaceC5063a<t> dismiss) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(dismiss, "dismiss");
        overlayDismissers.put(requestId, dismiss);
        C4148a.d(TAG, "registerOverlayDismisser | requestId=" + requestId, false, 4, null);
    }

    public final void i(Context context, final RiskStatementParams params, InterfaceC5074l<? super q, t> callback) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(params, "params");
        kotlin.jvm.internal.p.i(callback, "callback");
        g(params.getRequestId(), callback);
        String requestId = params.getRequestId();
        String scene = params.getScene();
        String title = params.getTitle();
        String riskLevel = params.getRiskLevel();
        List<RiskStatementButton> listB = params.b();
        ArrayList arrayList = new ArrayList(C1174w.x(listB, 10));
        Iterator<T> it = listB.iterator();
        while (it.hasNext()) {
            arrayList.add(((RiskStatementButton) it.next()).getId());
        }
        C4148a.k(TAG, "showPopup | requestId=" + requestId + ", scene=" + scene + ", title=" + title + ", level=" + riskLevel + ", buttons=" + arrayList, false, 4, null);
        final Context applicationContext = context.getApplicationContext();
        mainHandler.post(new Runnable() { // from class: com.stepos.ailauncher.mcpservice.risk.d
            @Override // java.lang.Runnable
            public final void run() {
                f.j(applicationContext, params);
            }
        });
    }

    public final void l(String requestId) {
        kotlin.jvm.internal.p.i(requestId, "requestId");
        ConcurrentHashMap<String, InterfaceC5074l<q, t>> concurrentHashMap = callbacks;
        boolean z10 = concurrentHashMap.remove(requestId) != null;
        C4148a.d(TAG, "unregister | requestId=" + requestId + ", hit=" + z10 + ", remaining=" + concurrentHashMap.size(), false, 4, null);
    }
}
