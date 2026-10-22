package com.stepos.ailauncher.chat.fragment;

import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.SessionHandler;
import com.stepos.ailauncher.chat.view.AskUserRequest;
import com.stepos.ailauncher.chat.view.LauncherChatLayout;
import com.stepos.ailauncher.chat.view.ToolApprovalRequest;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.model.SessionArtifact;
import com.stepos.ailauncher.sheet.SheetSettleState;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u0001sB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\u0003J\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0014J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011¢\u0006\u0004\b\u0018\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u0011¢\u0006\u0004\b\u001e\u0010\u0014J\u0015\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b#\u0010$J\u0015\u0010'\u001a\u00020\b2\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\b¢\u0006\u0004\b)\u0010\u0003J\u0015\u0010+\u001a\u00020\b2\u0006\u0010&\u001a\u00020*¢\u0006\u0004\b+\u0010,J\r\u0010-\u001a\u00020\b¢\u0006\u0004\b-\u0010\u0003J\u0017\u0010/\u001a\u00020\b2\b\u0010.\u001a\u0004\u0018\u00010\u001f¢\u0006\u0004\b/\u0010\"J\r\u00100\u001a\u00020\b¢\u0006\u0004\b0\u0010\u0003J\r\u00101\u001a\u00020\b¢\u0006\u0004\b1\u0010\u0003J\u0015\u00103\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0011¢\u0006\u0004\b3\u0010\u0014J\u0017\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107R\u001c\u0010:\u001a\n\u0012\u0006\u0012\u0004\u0018\u000109088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u001f\u0010=\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001090<8\u0006¢\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u001a\u0010A\u001a\b\u0012\u0004\u0012\u00020\f088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010;R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\f0<8\u0006¢\u0006\f\n\u0004\bB\u0010>\u001a\u0004\bC\u0010@R\u001a\u0010D\u001a\b\u0012\u0004\u0012\u00020\f088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010;R\u001d\u0010E\u001a\b\u0012\u0004\u0012\u00020\f0<8\u0006¢\u0006\f\n\u0004\bE\u0010>\u001a\u0004\bF\u0010@R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010;R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0006¢\u0006\f\n\u0004\bH\u0010>\u001a\u0004\bI\u0010@R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bJ\u0010;R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0006¢\u0006\f\n\u0004\bK\u0010>\u001a\u0004\bL\u0010@R\u001a\u0010M\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bM\u0010;R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0006¢\u0006\f\n\u0004\bN\u0010>\u001a\u0004\bO\u0010@R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u0019088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bP\u0010;R\u001d\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00190<8\u0006¢\u0006\f\n\u0004\bQ\u0010>\u001a\u0004\bR\u0010@R\u0018\u0010S\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u001a\u0010U\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bU\u0010;R\u001d\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0006¢\u0006\f\n\u0004\bV\u0010>\u001a\u0004\bW\u0010@R\u001c\u0010X\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bX\u0010;R\u001f\u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010%0<8\u0006¢\u0006\f\n\u0004\bY\u0010>\u001a\u0004\bZ\u0010@R\u001c\u0010[\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b[\u0010;R\u001f\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010*0<8\u0006¢\u0006\f\n\u0004\b\\\u0010>\u001a\u0004\b]\u0010@R\u001c\u0010_\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0^8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u001f\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0a8\u0006¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u001a\u0010g\u001a\b\u0012\u0004\u0012\u00020f088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010;R\u001d\u0010h\u001a\b\u0012\u0004\u0012\u00020f0<8\u0006¢\u0006\f\n\u0004\bh\u0010>\u001a\u0004\bi\u0010@R\u001a\u0010j\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010;R\u001d\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0006¢\u0006\f\n\u0004\bk\u0010>\u001a\u0004\bl\u0010@R\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\u0011088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010;R\u001d\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00110<8\u0006¢\u0006\f\n\u0004\bn\u0010>\u001a\u0004\bo\u0010@R\u001c\u0010p\u001a\n\u0012\u0006\u0012\u0004\u0018\u000104088\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bp\u0010;R\u001f\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001040<8\u0006¢\u0006\f\n\u0004\bq\u0010>\u001a\u0004\br\u0010@¨\u0006t"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/I0;", "Landroidx/lifecycle/Q;", "<init>", "()V", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatLayout", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "LY8/t;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "e", "", "fraction", "J", "(F)V", "H", "", "hidden", "M", "(Z)V", "empty", "F", "external", "G", "Lcom/stepos/ailauncher/sheet/SheetSettleState;", VoiceWakeupReceiver.EXTRA_STATE, "L", "(Lcom/stepos/ailauncher/sheet/SheetSettleState;)V", "active", "K", "", "text", "C", "(Ljava/lang/String;)V", Const.INTENT_KEY_BACKGROUND_COMMAND, "()Ljava/lang/String;", "Lcom/stepos/ailauncher/chat/view/X;", "request", "B", "(Lcom/stepos/ailauncher/chat/view/X;)V", "f", "Lcom/stepos/ailauncher/chat/view/g9;", "D", "(Lcom/stepos/ailauncher/chat/view/g9;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "sessionId", "y", "x", "z", "shown", "I", "Lcom/stepos/ailauncher/contract/model/SessionArtifact;", "artifact", ExifInterface.LONGITUDE_EAST, "(Lcom/stepos/ailauncher/contract/model/SessionArtifact;)V", "LXa/k;", "Lcom/stepos/ailauncher/chat/fragment/I0$a;", "_core", "LXa/k;", "LXa/t;", "core", "LXa/t;", "l", "()LXa/t;", "_pagerFraction", "pagerFraction", "p", "_homeCollapseFraction", "homeCollapseFraction", "n", "_wakeFloatingContentHidden", "wakeFloatingContentHidden", "w", "_conversationEmpty", "conversationEmpty", "k", "_externalSession", "externalSession", "m", "_settleState", "settleState", "t", "pendingInitialPrompt", "Ljava/lang/String;", "_searchMode", "searchMode", "q", "_askUser", "askUser", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "_toolApproval", "toolApproval", "v", "LXa/j;", "_sessionSettled", "LXa/j;", "LXa/o;", "sessionSettled", "LXa/o;", "s", "()LXa/o;", "", "_sendInitiated", "sendInitiated", "r", "_stopInitiated", "stopInitiated", "u", "_inquiryCardShown", "inquiryCardShown", "o", "_activeArtifact", "activeArtifact", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class I0 extends android.view.Q {
    private final Xa.k<SessionArtifact> _activeArtifact;
    private final Xa.k<AskUserRequest> _askUser;
    private final Xa.k<Boolean> _conversationEmpty;
    private final Xa.k<ChatCoreHandle> _core;
    private final Xa.k<Boolean> _externalSession;
    private final Xa.k<Float> _homeCollapseFraction;
    private final Xa.k<Boolean> _inquiryCardShown;
    private final Xa.k<Float> _pagerFraction;
    private final Xa.k<Boolean> _searchMode;
    private final Xa.k<Integer> _sendInitiated;
    private final Xa.j<String> _sessionSettled;
    private final Xa.k<SheetSettleState> _settleState;
    private final Xa.k<Boolean> _stopInitiated;
    private final Xa.k<ToolApprovalRequest> _toolApproval;
    private final Xa.k<Boolean> _wakeFloatingContentHidden;
    private final Xa.t<SessionArtifact> activeArtifact;
    private final Xa.t<AskUserRequest> askUser;
    private final Xa.t<Boolean> conversationEmpty;
    private final Xa.t<ChatCoreHandle> core;
    private final Xa.t<Boolean> externalSession;
    private final Xa.t<Float> homeCollapseFraction;
    private final Xa.t<Boolean> inquiryCardShown;
    private final Xa.t<Float> pagerFraction;
    private String pendingInitialPrompt;
    private final Xa.t<Boolean> searchMode;
    private final Xa.t<Integer> sendInitiated;
    private final Xa.o<String> sessionSettled;
    private final Xa.t<SheetSettleState> settleState;
    private final Xa.t<Boolean> stopInitiated;
    private final Xa.t<ToolApprovalRequest> toolApproval;
    private final Xa.t<Boolean> wakeFloatingContentHidden;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/chat/fragment/I0$a;", "", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "chatLayout", "Lcom/stepos/agentframework/chatcore/SessionHandler;", "handler", "<init>", "(Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;Lcom/stepos/agentframework/chatcore/SessionHandler;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "Lcom/stepos/agentframework/chatcore/SessionHandler;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/agentframework/chatcore/SessionHandler;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.fragment.I0$a, reason: from toString */
    public static final /* data */ class ChatCoreHandle {
        private final LauncherChatLayout chatLayout;
        private final SessionHandler handler;

        public ChatCoreHandle(LauncherChatLayout chatLayout, SessionHandler handler) {
            kotlin.jvm.internal.p.i(chatLayout, "chatLayout");
            kotlin.jvm.internal.p.i(handler, "handler");
            this.chatLayout = chatLayout;
            this.handler = handler;
        }

        /* renamed from: a, reason: from getter */
        public final LauncherChatLayout getChatLayout() {
            return this.chatLayout;
        }

        /* renamed from: b, reason: from getter */
        public final SessionHandler getHandler() {
            return this.handler;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChatCoreHandle)) {
                return false;
            }
            ChatCoreHandle chatCoreHandle = (ChatCoreHandle) other;
            return kotlin.jvm.internal.p.d(this.chatLayout, chatCoreHandle.chatLayout) && kotlin.jvm.internal.p.d(this.handler, chatCoreHandle.handler);
        }

        public int hashCode() {
            return (this.chatLayout.hashCode() * 31) + this.handler.hashCode();
        }

        public String toString() {
            return "ChatCoreHandle(chatLayout=" + this.chatLayout + ", handler=" + this.handler + ")";
        }
    }

    public I0() {
        Xa.k<ChatCoreHandle> kVarA = Xa.u.a(null);
        this._core = kVarA;
        this.core = Xa.d.c(kVarA);
        Float fValueOf = Float.valueOf(1.0f);
        Xa.k<Float> kVarA2 = Xa.u.a(fValueOf);
        this._pagerFraction = kVarA2;
        this.pagerFraction = Xa.d.c(kVarA2);
        Xa.k<Float> kVarA3 = Xa.u.a(fValueOf);
        this._homeCollapseFraction = kVarA3;
        this.homeCollapseFraction = Xa.d.c(kVarA3);
        Boolean bool = Boolean.FALSE;
        Xa.k<Boolean> kVarA4 = Xa.u.a(bool);
        this._wakeFloatingContentHidden = kVarA4;
        this.wakeFloatingContentHidden = Xa.d.c(kVarA4);
        Xa.k<Boolean> kVarA5 = Xa.u.a(Boolean.TRUE);
        this._conversationEmpty = kVarA5;
        this.conversationEmpty = Xa.d.c(kVarA5);
        Xa.k<Boolean> kVarA6 = Xa.u.a(bool);
        this._externalSession = kVarA6;
        this.externalSession = Xa.d.c(kVarA6);
        Xa.k<SheetSettleState> kVarA7 = Xa.u.a(SheetSettleState.HIDDEN);
        this._settleState = kVarA7;
        this.settleState = Xa.d.c(kVarA7);
        Xa.k<Boolean> kVarA8 = Xa.u.a(bool);
        this._searchMode = kVarA8;
        this.searchMode = Xa.d.c(kVarA8);
        Xa.k<AskUserRequest> kVarA9 = Xa.u.a(null);
        this._askUser = kVarA9;
        this.askUser = Xa.d.c(kVarA9);
        Xa.k<ToolApprovalRequest> kVarA10 = Xa.u.a(null);
        this._toolApproval = kVarA10;
        this.toolApproval = Xa.d.c(kVarA10);
        Xa.j<String> jVarB = Xa.p.b(0, 1, null, 5, null);
        this._sessionSettled = jVarB;
        this.sessionSettled = Xa.d.b(jVarB);
        Xa.k<Integer> kVarA11 = Xa.u.a(0);
        this._sendInitiated = kVarA11;
        this.sendInitiated = Xa.d.c(kVarA11);
        Xa.k<Boolean> kVarA12 = Xa.u.a(bool);
        this._stopInitiated = kVarA12;
        this.stopInitiated = Xa.d.c(kVarA12);
        Xa.k<Boolean> kVarA13 = Xa.u.a(bool);
        this._inquiryCardShown = kVarA13;
        this.inquiryCardShown = Xa.d.c(kVarA13);
        Xa.k<SessionArtifact> kVarA14 = Xa.u.a(null);
        this._activeArtifact = kVarA14;
        this.activeArtifact = Xa.d.c(kVarA14);
    }

    public final void A(LauncherChatLayout chatLayout, SessionHandler handler) {
        kotlin.jvm.internal.p.i(chatLayout, "chatLayout");
        kotlin.jvm.internal.p.i(handler, "handler");
        this._core.setValue(new ChatCoreHandle(chatLayout, handler));
    }

    public final void B(AskUserRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        this._askUser.setValue(request);
    }

    public final void C(String text) {
        kotlin.jvm.internal.p.i(text, "text");
        this.pendingInitialPrompt = text;
    }

    public final void D(ToolApprovalRequest request) {
        kotlin.jvm.internal.p.i(request, "request");
        this._toolApproval.setValue(request);
    }

    public final void E(SessionArtifact artifact) {
        this._activeArtifact.setValue(artifact);
    }

    public final void F(boolean empty) {
        this._conversationEmpty.setValue(Boolean.valueOf(empty));
    }

    public final void G(boolean external) {
        this._externalSession.setValue(Boolean.valueOf(external));
    }

    public final void H(float fraction) {
        this._homeCollapseFraction.setValue(Float.valueOf(C5685n.m(fraction, 0.0f, 1.0f)));
    }

    public final void I(boolean shown) {
        this._inquiryCardShown.setValue(Boolean.valueOf(shown));
    }

    public final void J(float fraction) {
        this._pagerFraction.setValue(Float.valueOf(C5685n.m(fraction, 0.0f, 1.0f)));
    }

    public final void K(boolean active) {
        this._searchMode.setValue(Boolean.valueOf(active));
    }

    public final void L(SheetSettleState state) {
        kotlin.jvm.internal.p.i(state, "state");
        this._settleState.setValue(state);
    }

    public final void M(boolean hidden) {
        this._wakeFloatingContentHidden.setValue(Boolean.valueOf(hidden));
    }

    public final void e() {
        this._core.setValue(null);
    }

    public final void f() {
        this._askUser.setValue(null);
    }

    public final String g() {
        String str = this.pendingInitialPrompt;
        if (str == null) {
            return null;
        }
        this.pendingInitialPrompt = null;
        return str;
    }

    public final void h() {
        this._toolApproval.setValue(null);
    }

    public final Xa.t<SessionArtifact> i() {
        return this.activeArtifact;
    }

    public final Xa.t<AskUserRequest> j() {
        return this.askUser;
    }

    public final Xa.t<Boolean> k() {
        return this.conversationEmpty;
    }

    public final Xa.t<ChatCoreHandle> l() {
        return this.core;
    }

    public final Xa.t<Boolean> m() {
        return this.externalSession;
    }

    public final Xa.t<Float> n() {
        return this.homeCollapseFraction;
    }

    public final Xa.t<Boolean> o() {
        return this.inquiryCardShown;
    }

    public final Xa.t<Float> p() {
        return this.pagerFraction;
    }

    public final Xa.t<Boolean> q() {
        return this.searchMode;
    }

    public final Xa.t<Integer> r() {
        return this.sendInitiated;
    }

    public final Xa.o<String> s() {
        return this.sessionSettled;
    }

    public final Xa.t<SheetSettleState> t() {
        return this.settleState;
    }

    public final Xa.t<Boolean> u() {
        return this.stopInitiated;
    }

    public final Xa.t<ToolApprovalRequest> v() {
        return this.toolApproval;
    }

    public final Xa.t<Boolean> w() {
        return this.wakeFloatingContentHidden;
    }

    public final void x() {
        this._stopInitiated.setValue(Boolean.FALSE);
        Xa.k<Integer> kVar = this._sendInitiated;
        kVar.setValue(Integer.valueOf(kVar.getValue().intValue() + 1));
    }

    public final void y(String sessionId) {
        this._sessionSettled.a(sessionId);
    }

    public final void z() {
        this._stopInitiated.setValue(Boolean.TRUE);
    }
}
