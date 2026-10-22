package u5;

import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.AgentWorkUiEvent;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lu5/b;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "layout", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/AgentChatLayout;)V", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: u5.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5577b {
    public static final C5577b INSTANCE = new C5577b();

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: u5.b$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentWorkUiEvent.values().length];
            try {
                iArr[AgentWorkUiEvent.THINKING_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentWorkUiEvent.THINKING_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AgentWorkUiEvent.EXECUTE_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AgentWorkUiEvent.EXECUTE_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AgentWorkUiEvent.AUTO_TTS_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AgentWorkUiEvent.AUTO_TTS_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AgentWorkUiEvent.AUTO_TTS_INTERRUPTED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final t c(AgentWorkUiEvent event) {
        p.i(event, "event");
        switch (a.$EnumSwitchMapping$0[event.ordinal()]) {
            case 1:
                U5.b.INSTANCE.g();
                break;
            case 2:
                U5.b.INSTANCE.f();
                break;
            case 3:
                U5.b.INSTANCE.c();
                break;
            case 4:
                U5.b.INSTANCE.b();
                break;
            case 5:
                U5.b.INSTANCE.j();
                break;
            case 6:
                U5.b.INSTANCE.h();
                break;
            case 7:
                U5.b.INSTANCE.i();
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return t.f7040a;
    }

    public final void b(AgentChatLayout layout) {
        p.i(layout, "layout");
        layout.setOnAgentWorkUiEvent(new InterfaceC5074l() { // from class: u5.a
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C5577b.c((AgentWorkUiEvent) obj);
            }
        });
    }
}
