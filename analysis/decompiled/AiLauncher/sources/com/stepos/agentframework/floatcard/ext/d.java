package com.stepos.agentframework.floatcard.ext;

import E4.FloatCardRequest;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.floatcard.view.FloatCardActivity;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0015R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/stepos/agentframework/floatcard/ext/d;", "", "<init>", "()V", "", "cardId", "LE4/k;", "e", "(Ljava/lang/String;)LE4/k;", "LE4/d;", "event", "LY8/t;", "c", "(Ljava/lang/String;LE4/d;)V", "Lcom/stepos/agentframework/floatcard/view/FloatCardActivity;", "activity", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Lcom/stepos/agentframework/floatcard/view/FloatCardActivity;)V", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/floatcard/view/FloatCardActivity;)V", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/stepos/agentframework/floatcard/ext/d$a;", "entries", "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/lang/ref/WeakReference;", "live", "Ljava/lang/ref/WeakReference;", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class d {
    public static final d INSTANCE = new d();
    private static final ConcurrentHashMap<String, a> entries = new ConcurrentHashMap<>();
    private static WeakReference<FloatCardActivity> live;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R#\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/agentframework/floatcard/ext/d$a;", "", "LE4/k;", "request", "LE4/k;", Const.INTENT_KEY_UMID, "()LE4/k;", "Lkotlin/Function1;", "LE4/d;", "LY8/t;", "onEvent", "Lp9/l;", "c", "()Lp9/l;", "Lkotlin/Function0;", "onDismiss", "Lp9/a;", Const.INTENT_KEY_PKGNAME, "()Lp9/a;", "setOnDismiss", "(Lp9/a;)V", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/agentframework/floatcard/view/FloatCardActivity;", "activity", "Ljava/lang/ref/WeakReference;", "getActivity", "()Ljava/lang/ref/WeakReference;", "e", "(Ljava/lang/ref/WeakReference;)V", "", "dismissNotified", "Z", Const.INTENT_KEY_APIKEY, "()Z", "f", "(Z)V", "floatcard_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a {
        private WeakReference<FloatCardActivity> activity;
        private boolean dismissNotified;
        private InterfaceC5063a<t> onDismiss;
        private final InterfaceC5074l<E4.d, t> onEvent;
        private final FloatCardRequest request;

        /* renamed from: a, reason: from getter */
        public final boolean getDismissNotified() {
            return this.dismissNotified;
        }

        public final InterfaceC5063a<t> b() {
            return this.onDismiss;
        }

        public final InterfaceC5074l<E4.d, t> c() {
            return this.onEvent;
        }

        /* renamed from: d, reason: from getter */
        public final FloatCardRequest getRequest() {
            return this.request;
        }

        public final void e(WeakReference<FloatCardActivity> weakReference) {
            this.activity = weakReference;
        }

        public final void f(boolean z10) {
            this.dismissNotified = z10;
        }
    }

    public final void a(String cardId, FloatCardActivity activity) {
        p.i(cardId, "cardId");
        p.i(activity, "activity");
        a aVar = entries.get(cardId);
        if (aVar != null) {
            aVar.e(new WeakReference<>(activity));
        }
        live = new WeakReference<>(activity);
    }

    public final void b(FloatCardActivity activity) {
        p.i(activity, "activity");
        WeakReference<FloatCardActivity> weakReference = live;
        if ((weakReference != null ? weakReference.get() : null) == activity) {
            live = null;
        }
    }

    public final void c(String cardId, E4.d event) {
        InterfaceC5074l<E4.d, t> interfaceC5074lC;
        p.i(cardId, "cardId");
        p.i(event, "event");
        a aVar = entries.get(cardId);
        if (aVar == null || (interfaceC5074lC = aVar.c()) == null) {
            return;
        }
        interfaceC5074lC.invoke(event);
    }

    public final void d(String cardId) {
        p.i(cardId, "cardId");
        a aVarRemove = entries.remove(cardId);
        if (aVarRemove == null || aVarRemove.getDismissNotified()) {
            return;
        }
        aVarRemove.f(true);
        InterfaceC5063a<t> interfaceC5063aB = aVarRemove.b();
        if (interfaceC5063aB != null) {
            interfaceC5063aB.invoke();
        }
    }

    public final FloatCardRequest e(String cardId) {
        p.i(cardId, "cardId");
        a aVar = entries.get(cardId);
        if (aVar != null) {
            return aVar.getRequest();
        }
        return null;
    }
}
