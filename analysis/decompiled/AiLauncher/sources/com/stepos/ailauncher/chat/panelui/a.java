package com.stepos.ailauncher.chat.panelui;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010 \u001a\u00020\u001f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u0004\u0018\u00010$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/stepos/ailauncher/chat/panelui/a;", "Lcom/stepos/ailauncher/chat/panelui/e;", "Lcom/stepos/agentframework/chatui/panelui/b;", "handle", "<init>", "(Lcom/stepos/agentframework/chatui/panelui/b;)V", "", "isShowing", "()Z", "", "transitionId", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;", "phase", "c", "(JLcom/stepos/ailauncher/chat/panelui/PanelLayerRecentsPhase;)Z", "expectedPhase", Const.INTENT_KEY_UMID, "f", "Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;", "reason", "e", "(Lcom/stepos/ailauncher/chat/panelui/PanelLayerDismissReason;)Z", "Lcom/stepos/agentframework/chatui/panelui/b;", "Lcom/stepos/ailauncher/chat/panelui/n;", "recents", "Lcom/stepos/ailauncher/chat/panelui/n;", "", "layerId", "Ljava/lang/String;", "getLayerId", "()Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "homePolicy", "Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatui/panelui/PanelHomePolicy;", "", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Object;", "ownerKey", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements e {
    private final com.stepos.agentframework.chatui.panelui.b handle;
    private final PanelHomePolicy homePolicy;
    private final String layerId;
    private final n recents;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.panelui.a$a, reason: collision with other inner class name */
    public static final /* synthetic */ class C0291a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PanelLayerDismissReason.values().length];
            try {
                iArr[PanelLayerDismissReason.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PanelLayerDismissReason.OVERVIEW.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PanelLayerDismissReason.OWNER_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PanelLayerDismissReason.FACTORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PanelLayerDismissReason.WAKE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PanelLayerDismissReason.USER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/stepos/ailauncher/chat/panelui/a$b", "Lcom/stepos/ailauncher/chat/panelui/t;", "", Const.INTENT_KEY_APIKEY, "()Z", "resume", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b implements t {
        public b() {
        }

        @Override // com.stepos.ailauncher.chat.panelui.t
        public boolean a() {
            return a.this.handle.c();
        }

        @Override // com.stepos.ailauncher.chat.panelui.t
        public boolean resume() {
            return a.this.handle.e();
        }
    }

    public a(com.stepos.agentframework.chatui.panelui.b handle) {
        kotlin.jvm.internal.p.i(handle, "handle");
        this.handle = handle;
        this.recents = new n(new b());
        this.layerId = handle.getLayerId();
        this.homePolicy = handle.getHomePolicy();
    }

    @Override // com.stepos.ailauncher.chat.panelui.e
    public Object a() {
        return this.handle.a();
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
        kotlin.jvm.internal.p.i(reason, "reason");
        switch (C0291a.$EnumSwitchMapping$0[reason.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return this.handle.d();
            default:
                throw new NoWhenBranchMatchedException();
        }
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
        return this.handle.isShowing();
    }
}
