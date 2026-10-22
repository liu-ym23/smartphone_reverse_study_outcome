package com.stepos.ailauncher.chat.tts;

import La.H;
import Y8.t;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.T1;
import com.stepos.ailauncher.chat.trace.g;
import com.stepos.ailauncher.common.utils.MicConflictPolicy;
import com.stepos.ailauncher.contract.api.speech.ISpeechService;
import com.stepos.ailauncher.contract.api.speech.TtsListener;
import com.stepos.ailauncher.contract.api.speech.TtsStreamSession;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import h8.C4148a;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.p;
import u5.C5577b;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\u0003J\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J\r\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\u0003J'\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u001b\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u001d\u0010\u0016J\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u0016J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0003J\u000f\u0010#\u001a\u00020\u0011H\u0002¢\u0006\u0004\b#\u0010\u0018R\u0014\u0010$\u001a\u00020\u000f8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010.\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/¨\u00060"}, d2 = {"Lcom/stepos/ailauncher/chat/tts/a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/AgentChatLayout;", "layout", "LY8/t;", "n", "(Lcom/stepos/agentframework/chatui/AgentChatLayout;)V", "x", "q", "w", Const.INTENT_KEY_APIKEY, "Lcom/stepos/ailauncher/chat/tts/a$a;", "player", "", "text", "", "isStream", "r", "(Lcom/stepos/ailauncher/chat/tts/a$a;Ljava/lang/String;Z)V", "u", "(Lcom/stepos/ailauncher/chat/tts/a$a;)V", "o", "()Z", "s", "(Lcom/stepos/ailauncher/chat/tts/a$a;Ljava/lang/String;)V", "t", "m", "y", "Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "k", "()Lcom/stepos/ailauncher/contract/api/speech/ISpeechService;", "p", "v", "l", "TAG", "Ljava/lang/String;", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "streamSession", "Lcom/stepos/ailauncher/contract/api/speech/TtsStreamSession;", "activePlayer", "Lcom/stepos/ailauncher/chat/tts/a$a;", "", "streamTextLength", "I", "roundAborted", "Z", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    public static final a INSTANCE = new a();
    private static final String TAG = "AgentChatTtsBridge";
    private static C0292a activePlayer;
    private static boolean roundAborted;
    private static TtsStreamSession streamSession;
    private static int streamTextLength;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/stepos/ailauncher/chat/tts/a$a;", "Lcom/stepos/agentframework/chatui/T1;", "<init>", "()V", "", "text", "", "isStream", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Ljava/lang/String;Z)V", "e", g.ACTION_STOP, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_UMID, "c", "()Z", "Lcom/stepos/agentframework/chatui/T1$a;", "listener", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/T1$a;)V", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "()Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", UxipConstants.f30680s, "Lcom/stepos/agentframework/chatui/T1$a;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Lcom/stepos/agentframework/chatui/T1$a;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.tts.a$a, reason: collision with other inner class name */
    public static final class C0292a implements T1 {
        private T1.a listener;

        @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0004¨\u0006\n"}, d2 = {"com/stepos/ailauncher/chat/tts/a$a$a", "Lcom/stepos/ailauncher/contract/api/speech/TtsListener;", "LY8/t;", "onPlayStarted", "()V", "", "reason", "onStreamInterrupted", "(Ljava/lang/String;)V", "onPlayStopped", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.chat.tts.a$a$a, reason: collision with other inner class name */
        public static final class C0293a implements TtsListener {
            public C0293a() {
            }

            @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
            public void onPlayStarted() {
                T1.a listener = C0292a.this.getListener();
                if (listener != null) {
                    listener.onPlayStarted();
                }
            }

            @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
            public void onPlayStopped() {
                if (a.activePlayer == C0292a.this) {
                    a.INSTANCE.v();
                }
                T1.a listener = C0292a.this.getListener();
                if (listener != null) {
                    listener.onPlayStopped();
                }
            }

            @Override // com.stepos.ailauncher.contract.api.speech.TtsListener
            public void onStreamInterrupted(String reason) {
                p.i(reason, "reason");
                C4148a.u(a.TAG, "stream interrupted reason=" + reason, false, 4, null);
                if (a.activePlayer == C0292a.this) {
                    a.INSTANCE.v();
                }
                T1.a listener = C0292a.this.getListener();
                if (listener != null) {
                    listener.b(reason);
                }
            }
        }

        @Override // com.stepos.agentframework.chatui.T1
        public void a(T1.a listener) {
            this.listener = listener;
        }

        @Override // com.stepos.agentframework.chatui.T1
        public void b(String text, boolean isStream) {
            p.i(text, "text");
            a.INSTANCE.r(this, text, isStream);
        }

        @Override // com.stepos.agentframework.chatui.T1
        public boolean c() {
            return a.INSTANCE.o();
        }

        @Override // com.stepos.agentframework.chatui.T1
        public void d() {
            a.INSTANCE.u(this);
        }

        @Override // com.stepos.agentframework.chatui.T1
        public void e() {
            a.INSTANCE.m(this);
        }

        @Override // com.stepos.agentframework.chatui.T1
        public void g() {
            if (a.roundAborted) {
                C4148a.k(a.TAG, "resetRoundGuard: unlatch for new round", false, 4, null);
            }
            a.roundAborted = false;
        }

        /* renamed from: h, reason: from getter */
        public final T1.a getListener() {
            return this.listener;
        }

        public final TtsListener i() {
            return new C0293a();
        }

        @Override // com.stepos.agentframework.chatui.T1
        public void stop() {
            a.INSTANCE.y(this);
        }
    }

    public final void a() {
        if (!roundAborted) {
            C4148a.k(TAG, "abortCurrentRound: latch round, refuse reopening stream", false, 4, null);
        }
        roundAborted = true;
        x();
    }

    public final ISpeechService k() {
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService == null || !iSpeechService.isTtsAvailable()) {
            return null;
        }
        return iSpeechService;
    }

    public final boolean l() {
        if (!MicConflictPolicy.INSTANCE.e()) {
            return true;
        }
        C4148a.d(TAG, "tts suppressed: concurrent mic occupancy", false, 4, null);
        return false;
    }

    public final void m(C0292a player) {
        TtsStreamSession ttsStreamSession;
        Object objB;
        if (activePlayer == player && (ttsStreamSession = streamSession) != null) {
            streamSession = null;
            C4148a.d(TAG, "end streaming text totalLen=" + streamTextLength + " ready=" + ttsStreamSession.isReadyToClose(), false, 4, null);
            try {
                Result.Companion companion = Result.INSTANCE;
                ttsStreamSession.close();
                objB = Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                objB = Result.b(C4849c.a(th));
            }
            Throwable thE = Result.e(objB);
            if (thE != null) {
                C4148a.g(TAG, "close stream failed", thE, false, 8, null);
                INSTANCE.v();
                T1.a listener = player.getListener();
                if (listener != null) {
                    String message = thE.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    listener.a("1999", message);
                }
                T1.a listener2 = player.getListener();
                if (listener2 != null) {
                    listener2.onPlayStopped();
                }
            }
        }
    }

    public final void n(AgentChatLayout layout) {
        p.i(layout, "layout");
        layout.setTtsPlayer(new C0292a());
        C5577b.INSTANCE.b(layout);
    }

    public final boolean o() {
        TtsStreamSession ttsStreamSession = streamSession;
        return ttsStreamSession != null && streamTextLength == 0 && ttsStreamSession.isOpen();
    }

    public final void p(C0292a player) {
        C4148a.u(TAG, "ISpeechService TTS unavailable", false, 4, null);
        T1.a listener = player.getListener();
        if (listener != null) {
            listener.a("1001", "TTS unavailable");
        }
        T1.a listener2 = player.getListener();
        if (listener2 != null) {
            listener2.onPlayStopped();
        }
    }

    public final void q() {
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService != null) {
            iSpeechService.pauseSpeak();
        }
    }

    public final void r(C0292a player, String text, boolean isStream) {
        if (H.x0(text)) {
            return;
        }
        if ((isStream && streamSession != null && activePlayer == player) || l()) {
            if (isStream) {
                s(player, text);
                return;
            } else {
                t(player, text);
                return;
            }
        }
        T1.a listener = player.getListener();
        if (listener != null) {
            listener.onPlayStopped();
        }
    }

    public final void s(C0292a player, String text) {
        TtsStreamSession ttsStreamSessionStartStreamSpeak = streamSession;
        if (ttsStreamSessionStartStreamSpeak != null && activePlayer == player && streamTextLength == 0 && !ttsStreamSessionStartStreamSpeak.isOpen()) {
            C4148a.u(TAG, "idle prewarm closed before text, reopen", false, 4, null);
            streamSession = null;
            activePlayer = null;
            try {
                Result.Companion companion = Result.INSTANCE;
                ttsStreamSessionStartStreamSpeak.cancel();
                Result.b(t.f7040a);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                Result.b(C4849c.a(th));
            }
            ttsStreamSessionStartStreamSpeak = null;
        }
        if (ttsStreamSessionStartStreamSpeak == null || activePlayer != player) {
            if (roundAborted) {
                C4148a.k(TAG, "playStreaming skipped: round aborted, drop " + text.length() + " chars", false, 4, null);
                return;
            }
            if (activePlayer != null) {
                x();
            }
            ISpeechService iSpeechServiceK = k();
            if (iSpeechServiceK == null) {
                p(player);
                return;
            }
            activePlayer = player;
            streamTextLength = 0;
            ttsStreamSessionStartStreamSpeak = iSpeechServiceK.startStreamSpeak(player.i());
            streamSession = ttsStreamSessionStartStreamSpeak;
            if (ttsStreamSessionStartStreamSpeak == null) {
                v();
                p(player);
                return;
            }
            C4148a.d(TAG, "start stream speak", false, 4, null);
        }
        int iFeedText = ttsStreamSessionStartStreamSpeak.feedText(text);
        if (iFeedText <= 0) {
            C4148a.u(TAG, "stream text rejected length=" + text.length(), false, 4, null);
            return;
        }
        streamTextLength += iFeedText;
        C4148a.d(TAG, "play streaming text rawLen=" + text.length() + " accepted=" + iFeedText + " totalLen=" + streamTextLength, false, 4, null);
    }

    public final void t(C0292a player, String text) {
        x();
        roundAborted = false;
        ISpeechService iSpeechServiceK = k();
        if (iSpeechServiceK == null) {
            p(player);
            return;
        }
        activePlayer = player;
        C4148a.d(TAG, "play whole text length=" + text.length(), false, 4, null);
        iSpeechServiceK.speak(text, player.i());
    }

    public final void u(C0292a player) {
        ISpeechService iSpeechServiceK;
        if (!roundAborted && l()) {
            TtsStreamSession ttsStreamSession = streamSession;
            if (!(ttsStreamSession != null && activePlayer == player && streamTextLength == 0 && ttsStreamSession.isOpen()) && ttsStreamSession == null && activePlayer == null && (iSpeechServiceK = k()) != null) {
                activePlayer = player;
                streamTextLength = 0;
                TtsStreamSession ttsStreamSessionStartStreamSpeak = iSpeechServiceK.startStreamSpeak(player.i());
                if (ttsStreamSessionStartStreamSpeak == null) {
                    v();
                } else {
                    streamSession = ttsStreamSessionStartStreamSpeak;
                    C4148a.k(TAG, "prewarm stream speak", false, 4, null);
                }
            }
        }
    }

    public final void v() {
        streamSession = null;
        activePlayer = null;
        streamTextLength = 0;
    }

    public final void w() {
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService != null) {
            iSpeechService.resumeSpeak();
        }
    }

    public final void x() {
        Object objB;
        T1.a listener;
        C0292a c0292a = activePlayer;
        TtsStreamSession ttsStreamSession = streamSession;
        t tVar = null;
        if (c0292a != null) {
            C4148a.k(TAG, "stop: interrupt active playback", false, 4, null);
            T1.a listener2 = c0292a.getListener();
            if (listener2 != null) {
                listener2.b(g.ACTION_STOP);
            }
        }
        v();
        try {
            Result.Companion companion = Result.INSTANCE;
            if (ttsStreamSession != null) {
                ttsStreamSession.cancel();
                tVar = t.f7040a;
            }
            objB = Result.b(tVar);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t(TAG, "cancel stream failed", thE, false, 8, null);
        }
        ISpeechService iSpeechService = (ISpeechService) D5.a.INSTANCE.a(ISpeechService.class);
        if (iSpeechService != null) {
            iSpeechService.stopSpeak();
        }
        if (c0292a == null || (listener = c0292a.getListener()) == null) {
            return;
        }
        listener.onPlayStopped();
    }

    public final void y(C0292a player) {
        if (activePlayer == player) {
            x();
        }
    }
}
