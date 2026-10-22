package com.stepos.ailauncher.chat.panelui;

import android.os.Looper;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001)B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007JM\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u001d\u001a\u00020\u001c2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u00182\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ%\u0010#\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J%\u0010&\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010%\u001a\u00020!¢\u0006\u0004\b&\u0010$J\u0015\u0010'\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u000fH\u0002¢\u0006\u0004\b)\u0010\u0003R\u0014\u0010*\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/i;", "", "<init>", "()V", "", "prefix", "c", "(Ljava/lang/String;)Ljava/lang/String;", "layerId", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "homePolicy", "ownerKey", "Lkotlin/Function0;", "", "isShowing", "LY8/t;", "dismissAction", "Lcom/stepos/ailauncher/chat/panelui/t;", "visibility", "Lcom/stepos/ailauncher/chat/panelui/m;", "e", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;Ljava/lang/Object;Lp9/a;Lp9/a;Lcom/stepos/ailauncher/chat/panelui/t;)Lcom/stepos/ailauncher/chat/panelui/m;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)V", "", "ownerKeys", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;", "reason", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/Collection;Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;)I", "", "transitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/Object;JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)I", "expectedPhase", "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/Object;)I", Const.INTENT_KEY_APIKEY, "TAG", "Ljava/lang/String;", "Ljava/util/concurrent/atomic/AtomicInteger;", "idSeq", "Ljava/util/concurrent/atomic/AtomicInteger;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class i {
    private static final String TAG = "PanelLayerFactory";
    public static final i INSTANCE = new i();
    private static final AtomicInteger idSeq = new AtomicInteger(1);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/i$a;", "Lcom/stepos/ailauncher/chat/panelui/m;", "", "layerId", "<init>", "(Ljava/lang/String;)V", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "", "active", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements m {
        private volatile boolean active;
        private final String layerId;

        public a(String layerId) {
            kotlin.jvm.internal.p.i(layerId, "layerId");
            this.layerId = layerId;
            this.active = true;
        }
    }

    public final void a() {
        if (!kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            throw new IllegalStateException("PanelLayerFactory must run on main thread");
        }
    }

    public final int b(Collection<? extends Object> ownerKeys, PanelLayerDismissReason reason) {
        kotlin.jvm.internal.p.i(ownerKeys, "ownerKeys");
        kotlin.jvm.internal.p.i(reason, "reason");
        return s.INSTANCE.f(ownerKeys, reason);
    }

    public final String c(String prefix) {
        kotlin.jvm.internal.p.i(prefix, "prefix");
        return prefix + "_" + idSeq.getAndIncrement();
    }

    public final void d(String layerId) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        a();
        s.INSTANCE.s(layerId);
    }

    public final m e(String layerId, PanelHomePolicy homePolicy, Object ownerKey, InterfaceC5063a<Boolean> isShowing, InterfaceC5063a<Y8.t> dismissAction, t visibility) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        kotlin.jvm.internal.p.i(homePolicy, "homePolicy");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(isShowing, "isShowing");
        kotlin.jvm.internal.p.i(dismissAction, "dismissAction");
        kotlin.jvm.internal.p.i(visibility, "visibility");
        a();
        s.INSTANCE.m(new b(layerId, homePolicy, ownerKey, isShowing, dismissAction, visibility));
        return new a(layerId);
    }

    public final int f(Object ownerKey, long transitionId, PanelLayerRecentsPhase expectedPhase) {
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(expectedPhase, "expectedPhase");
        return s.INSTANCE.n(ownerKey, transitionId, expectedPhase);
    }

    public final int g(Object ownerKey) {
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        return s.INSTANCE.o(ownerKey);
    }

    public final int h(Object ownerKey, long transitionId, PanelLayerRecentsPhase phase) {
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(phase, "phase");
        return s.INSTANCE.q(ownerKey, transitionId, phase);
    }
}
