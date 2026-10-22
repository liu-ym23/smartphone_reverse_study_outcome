package com.stepos.ailauncher.chat.wake;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.chat.wake.ChatSnapshotState;
import h8.C4148a;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import o6.C5009a;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J=\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00142\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0018\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\rH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\u001e\u0010\tJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001f\u0010\u0003J\r\u0010 \u001a\u00020\u0019¢\u0006\u0004\b \u0010\u0003R\u0014\u0010!\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\"R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\"R\u0014\u0010'\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\"R\u0014\u0010(\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\"R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/stepos/ailauncher/chat/wake/w;", "", "<init>", "()V", "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "m", "()Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$a;", "sessionId", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$b;", "source", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "c", "(Ljava/lang/String;Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$b;)Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;", "use", "", "e", "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;)Z", "", "position", "offset", "messageId", "displayOffset", "LY8/t;", Const.INTENT_KEY_UMID, "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;IILjava/lang/String;I)V", "k", "(Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState$c;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "f", Const.INTENT_KEY_BACKGROUND_COMMAND, "MMKV_ID", "Ljava/lang/String;", "KEY_SESSION_ID", "KEY_SCROLL_POSITION", "KEY_SCROLL_OFFSET", "KEY_MESSAGE_ID", "KEY_DISPLAY_OFFSET", "TAG", "Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState;", "state$delegate", "LY8/h;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/chat/wake/ChatSnapshotState;", VoiceWakeupReceiver.EXTRA_STATE, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.wake.w, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3172w {
    private static final String KEY_DISPLAY_OFFSET = "scroll_display_offset";
    private static final String KEY_MESSAGE_ID = "scroll_message_id";
    private static final String KEY_SCROLL_OFFSET = "scroll_offset";
    private static final String KEY_SCROLL_POSITION = "scroll_position";
    private static final String KEY_SESSION_ID = "session_id";
    private static final String MMKV_ID = "last_chat_session";
    private static final String TAG = "RestoreTrace";
    public static final C3172w INSTANCE = new C3172w();

    /* renamed from: state$delegate, reason: from kotlin metadata */
    private static final Y8.h state = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.wake.u
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return C3172w.n();
        }
    });

    public static final boolean l(ChatSnapshotState.Snapshot snapshot) {
        Object objB;
        C5009a c5009a;
        boolean zC;
        boolean zC2;
        String sessionId;
        kotlin.jvm.internal.p.i(snapshot, "snapshot");
        try {
            Result.Companion companion = Result.INSTANCE;
            c5009a = C5009a.INSTANCE;
            zC = c5009a.C(MMKV_ID, KEY_SCROLL_POSITION, snapshot.getPosition());
            zC2 = c5009a.C(MMKV_ID, KEY_SCROLL_OFFSET, snapshot.getOffset());
            sessionId = snapshot.getSessionId();
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (sessionId == null) {
            throw new IllegalArgumentException("Required value was null.");
        }
        boolean zH = c5009a.H(MMKV_ID, "session_id", sessionId);
        String messageId = snapshot.getMessageId();
        if (messageId == null) {
            messageId = "";
        }
        objB = Result.b(Boolean.valueOf(zC && zC2 && zH && c5009a.H(MMKV_ID, KEY_MESSAGE_ID, messageId) && c5009a.C(MMKV_ID, KEY_DISPLAY_OFFSET, snapshot.getDisplayOffset())));
        Boolean bool = Boolean.FALSE;
        if (Result.g(objB)) {
            objB = bool;
        }
        return ((Boolean) objB).booleanValue();
    }

    public static final ChatSnapshotState n() {
        C5009a c5009a = C5009a.INSTANCE;
        String strV = C5009a.v(c5009a, MMKV_ID, "session_id", null, 4, null);
        String str = !La.H.x0(strV) ? strV : null;
        int iL = c5009a.l(MMKV_ID, KEY_SCROLL_POSITION, -1);
        int iM = C5009a.m(c5009a, MMKV_ID, KEY_SCROLL_OFFSET, 0, 4, null);
        String strV2 = C5009a.v(c5009a, MMKV_ID, KEY_MESSAGE_ID, null, 4, null);
        return new ChatSnapshotState(new ChatSnapshotState.Snapshot(str, iL, iM, La.H.x0(strV2) ? null : strV2, c5009a.l(MMKV_ID, KEY_DISPLAY_OFFSET, -1)));
    }

    public final synchronized ChatSnapshotState.c c(String sessionId, ChatSnapshotState.b source) {
        ChatSnapshotState.c cVarA;
        kotlin.jvm.internal.p.i(sessionId, "sessionId");
        kotlin.jvm.internal.p.i(source, "source");
        cVarA = i().a(sessionId, source);
        C4148a.k(TAG, "begin snapshot use session=" + sessionId + " activation=" + cVarA.getActivationId(), false, 4, null);
        return cVarA;
    }

    public final synchronized void d(ChatSnapshotState.c use, int position, int offset, String messageId, int displayOffset) {
        kotlin.jvm.internal.p.i(use, "use");
        i().b(use, position, offset, messageId, displayOffset);
    }

    public final synchronized boolean e(ChatSnapshotState.c use) {
        kotlin.jvm.internal.p.i(use, "use");
        return i().c(use);
    }

    public final synchronized void f() {
        i().d();
    }

    public final synchronized void g() {
        i().e();
        C5009a c5009a = C5009a.INSTANCE;
        c5009a.J(MMKV_ID, "session_id");
        c5009a.J(MMKV_ID, KEY_SCROLL_POSITION);
        c5009a.J(MMKV_ID, KEY_SCROLL_OFFSET);
        c5009a.J(MMKV_ID, KEY_MESSAGE_ID);
        c5009a.J(MMKV_ID, KEY_DISPLAY_OFFSET);
    }

    public final synchronized String h() {
        return i().getSnapshot().getSessionId();
    }

    public final ChatSnapshotState i() {
        return (ChatSnapshotState) state.getValue();
    }

    public final synchronized ChatSnapshotState.Snapshot j() {
        return i().g();
    }

    public final synchronized void k(ChatSnapshotState.c use) {
        kotlin.jvm.internal.p.i(use, "use");
        ChatSnapshotState.SaveResult saveResultH = i().h(use, new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.wake.v
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(C3172w.l((ChatSnapshotState.Snapshot) obj));
            }
        });
        C4148a.k(TAG, "save snapshot session=" + use.getSessionId() + " activation=" + use.getActivationId() + " result=" + saveResultH, false, 4, null);
    }

    public final synchronized ChatSnapshotState.Snapshot m() {
        return i().getSnapshot();
    }
}
