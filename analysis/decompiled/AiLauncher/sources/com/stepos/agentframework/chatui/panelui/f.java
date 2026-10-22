package com.stepos.agentframework.chatui.panelui;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.provider.c;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007Ja\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Lcom/stepos/agentframework/chatui/panelui/f;", "", "<init>", "()V", "", "prefix", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Ljava/lang/String;", "layerId", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "homePolicy", "ownerKey", "Lkotlin/Function0;", "", "isShowing", "LY8/t;", DidiCardProvider.ACTION_DISMISS, "suspendForRecents", "resumeAfterRecents", "Lcom/stepos/agentframework/chatui/panelui/b;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;Ljava/lang/Object;Lp9/a;Lp9/a;Lp9/a;Lp9/a;)Lcom/stepos/agentframework/chatui/panelui/b;", "c", "(Ljava/lang/String;)V", "Ljava/util/concurrent/atomic/AtomicInteger;", c.a.COL_SEQ, "Ljava/util/concurrent/atomic/AtomicInteger;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class f {
    public static final f INSTANCE = new f();
    private static final AtomicInteger seq = new AtomicInteger(1);

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"com/stepos/agentframework/chatui/panelui/f$a", "Lcom/stepos/agentframework/chatui/panelui/b;", "", "isShowing", "()Z", "c", "e", Const.INTENT_KEY_UMID, "", "layerId", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "homePolicy", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "ownerKey", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements b {
        final /* synthetic */ InterfaceC5063a<t> $dismissCheck;
        final /* synthetic */ InterfaceC5063a<Boolean> $isShowing;
        final /* synthetic */ WeakReference<Object> $ownerRef;
        final /* synthetic */ InterfaceC5063a<Boolean> $resumeCheck;
        final /* synthetic */ InterfaceC5063a<Boolean> $showingCheck;
        final /* synthetic */ InterfaceC5063a<Boolean> $suspendCheck;
        private final PanelHomePolicy homePolicy;
        private final String layerId;

        public a(String str, PanelHomePolicy panelHomePolicy, WeakReference<Object> weakReference, InterfaceC5063a<Boolean> interfaceC5063a, InterfaceC5063a<Boolean> interfaceC5063a2, InterfaceC5063a<Boolean> interfaceC5063a3, InterfaceC5063a<Boolean> interfaceC5063a4, InterfaceC5063a<t> interfaceC5063a5) {
            this.$ownerRef = weakReference;
            this.$showingCheck = interfaceC5063a;
            this.$suspendCheck = interfaceC5063a2;
            this.$resumeCheck = interfaceC5063a3;
            this.$isShowing = interfaceC5063a4;
            this.$dismissCheck = interfaceC5063a5;
            this.layerId = str;
            this.homePolicy = panelHomePolicy;
        }

        @Override // com.stepos.agentframework.chatui.panelui.b
        public Object a() {
            WeakReference<Object> weakReference = this.$ownerRef;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Override // com.stepos.agentframework.chatui.panelui.b
        /* renamed from: b, reason: from getter */
        public PanelHomePolicy getHomePolicy() {
            return this.homePolicy;
        }

        @Override // com.stepos.agentframework.chatui.panelui.b
        public boolean c() {
            Object objB;
            InterfaceC5063a<Boolean> interfaceC5063a = this.$suspendCheck;
            try {
                Result.Companion companion = Result.INSTANCE;
                Boolean boolInvoke = interfaceC5063a.invoke();
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

        @Override // com.stepos.agentframework.chatui.panelui.b
        public boolean d() {
            Object objB;
            if (!this.$isShowing.invoke().booleanValue()) {
                return false;
            }
            InterfaceC5063a<t> interfaceC5063a = this.$dismissCheck;
            try {
                Result.Companion companion = Result.INSTANCE;
                interfaceC5063a.invoke();
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

        @Override // com.stepos.agentframework.chatui.panelui.b
        public boolean e() {
            Object objB;
            InterfaceC5063a<Boolean> interfaceC5063a = this.$resumeCheck;
            try {
                Result.Companion companion = Result.INSTANCE;
                Boolean boolInvoke = interfaceC5063a.invoke();
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

        @Override // com.stepos.agentframework.chatui.panelui.b
        public String getLayerId() {
            return this.layerId;
        }

        @Override // com.stepos.agentframework.chatui.panelui.b
        public boolean isShowing() {
            Object objB;
            InterfaceC5063a<Boolean> interfaceC5063a = this.$showingCheck;
            try {
                Result.Companion companion = Result.INSTANCE;
                Boolean boolInvoke = interfaceC5063a.invoke();
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

    public final String a(String prefix) {
        p.i(prefix, "prefix");
        return prefix + "_" + seq.getAndIncrement();
    }

    public final b b(String layerId, PanelHomePolicy homePolicy, Object ownerKey, InterfaceC5063a<Boolean> isShowing, InterfaceC5063a<t> dismiss, InterfaceC5063a<Boolean> suspendForRecents, InterfaceC5063a<Boolean> resumeAfterRecents) {
        p.i(layerId, "layerId");
        p.i(homePolicy, "homePolicy");
        p.i(isShowing, "isShowing");
        p.i(dismiss, "dismiss");
        p.i(suspendForRecents, "suspendForRecents");
        p.i(resumeAfterRecents, "resumeAfterRecents");
        a aVar = new a(layerId, homePolicy, ownerKey != null ? new WeakReference(ownerKey) : null, isShowing, suspendForRecents, resumeAfterRecents, isShowing, dismiss);
        c.INSTANCE.b(aVar);
        return aVar;
    }

    public final void c(String layerId) {
        p.i(layerId, "layerId");
        c.INSTANCE.a(layerId);
    }
}
