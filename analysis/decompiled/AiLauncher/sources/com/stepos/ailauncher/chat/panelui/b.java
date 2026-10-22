package com.stepos.ailauncher.chat.panelui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import java.lang.ref.WeakReference;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010\u0012J\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010 \u001a\u0004\b!\u0010\"R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010%R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010&R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010&R$\u0010)\u001a\u0012\u0012\f\u0012\n (*\u0004\u0018\u00010\u00060\u0006\u0018\u00010'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/b;", "Lcom/stepos/ailauncher/chat/panelui/e;", "", "layerId", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "homePolicy", "", "ownerKey", "Lkotlin/Function0;", "", "showingCheck", "LY8/t;", "dismissAction", "Lcom/stepos/ailauncher/chat/panelui/t;", "visibility", "<init>", "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;Ljava/lang/Object;Lp9/a;Lp9/a;Lcom/stepos/ailauncher/chat/panelui/t;)V", "isShowing", "()Z", "", "transitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", "c", "(JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)Z", "expectedPhase", Const.INTENT_KEY_UMID, "f", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;", "reason", "e", "(Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;)Z", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "Lp9/a;", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "ownerRef", "Ljava/lang/ref/WeakReference;", "Lcom/stepos/ailauncher/chat/panelui/n;", "recents", "Lcom/stepos/ailauncher/chat/panelui/n;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements e {
    private final InterfaceC5063a<Y8.t> dismissAction;
    private final PanelHomePolicy homePolicy;
    private final String layerId;
    private final WeakReference<Object> ownerRef;
    private final n recents;
    private final InterfaceC5063a<Boolean> showingCheck;

    public b(String layerId, PanelHomePolicy homePolicy, Object obj, InterfaceC5063a<Boolean> showingCheck, InterfaceC5063a<Y8.t> dismissAction, t visibility) {
        kotlin.jvm.internal.p.i(layerId, "layerId");
        kotlin.jvm.internal.p.i(homePolicy, "homePolicy");
        kotlin.jvm.internal.p.i(showingCheck, "showingCheck");
        kotlin.jvm.internal.p.i(dismissAction, "dismissAction");
        kotlin.jvm.internal.p.i(visibility, "visibility");
        this.layerId = layerId;
        this.homePolicy = homePolicy;
        this.showingCheck = showingCheck;
        this.dismissAction = dismissAction;
        this.ownerRef = obj != null ? new WeakReference<>(obj) : null;
        this.recents = new n(visibility);
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public Object a() {
        WeakReference<Object> weakReference = this.ownerRef;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    /* renamed from: b, reason: from getter */
    public PanelHomePolicy getHomePolicy() {
        return this.homePolicy;
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public boolean c(long transitionId, PanelLayerRecentsPhase phase) {
        kotlin.jvm.internal.p.i(phase, "phase");
        return this.recents.c(transitionId, phase, isShowing() || this.recents.a());
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public boolean d(long transitionId, PanelLayerRecentsPhase expectedPhase) {
        kotlin.jvm.internal.p.i(expectedPhase, "expectedPhase");
        return this.recents.b(transitionId, expectedPhase, isShowing() || this.recents.a());
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public boolean e(PanelLayerDismissReason reason) {
        Object objB;
        kotlin.jvm.internal.p.i(reason, "reason");
        if (!isShowing()) {
            return false;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            this.dismissAction.invoke();
            objB = Result.b(Boolean.TRUE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public boolean f() {
        return this.recents.a();
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public String getLayerId() {
        return this.layerId;
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public boolean isShowing() {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            Boolean boolInvoke = this.showingCheck.invoke();
            boolInvoke.booleanValue();
            objB = Result.b(boolInvoke);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }
}
