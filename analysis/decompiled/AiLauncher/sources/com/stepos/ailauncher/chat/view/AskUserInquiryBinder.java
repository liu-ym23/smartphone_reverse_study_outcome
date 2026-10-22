package com.stepos.ailauncher.chat.view;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import w4.ChatMessage;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\u000f\u0010\fJ%\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0014J;\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00152\u0014\u0010\u0018\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ5\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00072\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ3\u0010#\u001a\u0004\u0018\u00010\u00162\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/stepos/ailauncher/chat/view/AskUserInquiryBinder;", "", "<init>", "()V", "Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;", "layout", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/view/X;", "", "onInquiry", "LY8/t;", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;Lp9/l;)V", "Lcom/stepos/ailauncher/chat/view/g9;", "onApproval", "e", "Lcom/stepos/ailauncher/chat/view/BaseInputView;", "input", "request", "l", "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;Lcom/stepos/ailauncher/chat/view/g9;)Z", "Lkotlin/Function0;", "", "liveSessionId", "onSettled", "n", "(Lcom/stepos/ailauncher/chat/view/LauncherChatLayout;Lp9/a;Lp9/l;)V", "onShownChanged", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/chat/view/BaseInputView;Lcom/stepos/ailauncher/chat/view/X;Lp9/l;)Z", "Lw4/e;", "title", "", "Lw4/c;", "messages", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lw4/e;Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AskUserInquiryBinder {
    public static final AskUserInquiryBinder INSTANCE = new AskUserInquiryBinder();

    public static final boolean f(InterfaceC5074l interfaceC5074l, String sid, String requestId, String messageId, String title, String str) {
        kotlin.jvm.internal.p.i(sid, "sid");
        kotlin.jvm.internal.p.i(requestId, "requestId");
        kotlin.jvm.internal.p.i(messageId, "messageId");
        kotlin.jvm.internal.p.i(title, "title");
        return ((Boolean) interfaceC5074l.invoke(new ToolApprovalRequest(sid, requestId, messageId, title, str))).booleanValue();
    }

    public static final boolean h(InterfaceC5074l interfaceC5074l, String sid, String inqId, List inquiries, String askUserMessageId) {
        kotlin.jvm.internal.p.i(sid, "sid");
        kotlin.jvm.internal.p.i(inqId, "inqId");
        kotlin.jvm.internal.p.i(inquiries, "inquiries");
        kotlin.jvm.internal.p.i(askUserMessageId, "askUserMessageId");
        return ((Boolean) interfaceC5074l.invoke(new AskUserRequest(sid, inqId, inquiries, askUserMessageId))).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean k(AskUserInquiryBinder askUserInquiryBinder, BaseInputView baseInputView, AskUserRequest askUserRequest, InterfaceC5074l interfaceC5074l, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            interfaceC5074l = null;
        }
        return askUserInquiryBinder.j(baseInputView, askUserRequest, interfaceC5074l);
    }

    public static final Y8.t m(LauncherChatLayout launcherChatLayout, ToolApprovalRequest toolApprovalRequest, String action) {
        kotlin.jvm.internal.p.i(action, "action");
        launcherChatLayout.q7(toolApprovalRequest.getSessionId(), toolApprovalRequest.getRequestId(), toolApprovalRequest.getMessageId(), action);
        return Y8.t.f7040a;
    }

    public static final Y8.t o(p9.p pVar, InterfaceC5074l interfaceC5074l, InterfaceC5063a interfaceC5063a, w4.e eVar, List messages) {
        kotlin.jvm.internal.p.i(messages, "messages");
        if (pVar != null) {
            pVar.invoke(eVar, messages);
        }
        interfaceC5074l.invoke(INSTANCE.i(eVar, messages, (String) interfaceC5063a.invoke()));
        return Y8.t.f7040a;
    }

    public final void e(LauncherChatLayout layout, final InterfaceC5074l<? super ToolApprovalRequest, Boolean> onApproval) {
        kotlin.jvm.internal.p.i(layout, "layout");
        kotlin.jvm.internal.p.i(onApproval, "onApproval");
        layout.setOnToolApproval(new p9.s() { // from class: com.stepos.ailauncher.chat.view.V
            @Override // p9.s
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
                return Boolean.valueOf(AskUserInquiryBinder.f(onApproval, (String) obj, (String) obj2, (String) obj3, (String) obj4, (String) obj5));
            }
        });
    }

    public final void g(LauncherChatLayout layout, final InterfaceC5074l<? super AskUserRequest, Boolean> onInquiry) {
        kotlin.jvm.internal.p.i(layout, "layout");
        kotlin.jvm.internal.p.i(onInquiry, "onInquiry");
        layout.setOnAskUserInquiry(new p9.r() { // from class: com.stepos.ailauncher.chat.view.U
            @Override // p9.r
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return Boolean.valueOf(AskUserInquiryBinder.h(onInquiry, (String) obj, (String) obj2, (List) obj3, (String) obj4));
            }
        });
    }

    public final String i(w4.e title, List<ChatMessage> messages, String liveSessionId) {
        String sessionId;
        Object obj = null;
        if (title != null && (sessionId = title.getSessionId()) != null) {
            if (sessionId.length() <= 0) {
                sessionId = null;
            }
            if (sessionId != null) {
                return sessionId;
            }
        }
        Iterator<T> it = messages.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((ChatMessage) next).getSessionId().length() > 0) {
                obj = next;
                break;
            }
        }
        ChatMessage chatMessage = (ChatMessage) obj;
        return chatMessage != null ? chatMessage.getSessionId() : liveSessionId;
    }

    public final boolean j(BaseInputView input, AskUserRequest request, InterfaceC5074l<? super Boolean, Y8.t> onShownChanged) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(request, "request");
        boolean zZb = input.Zb(request.getSessionId(), request.getInquiryId(), request.b(), "chatview", new AskUserInquiryBinder$show$shown$1(input, request, onShownChanged, null));
        if (zZb && onShownChanged != null) {
            onShownChanged.invoke(Boolean.TRUE);
        }
        return zZb;
    }

    public final boolean l(BaseInputView input, final LauncherChatLayout layout, final ToolApprovalRequest request) {
        kotlin.jvm.internal.p.i(input, "input");
        kotlin.jvm.internal.p.i(layout, "layout");
        kotlin.jvm.internal.p.i(request, "request");
        return input.Gb(request.getSessionId(), request.getRequestId(), request.getTitle(), request.getBody(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.W
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AskUserInquiryBinder.m(layout, request, (String) obj);
            }
        });
    }

    public final void n(LauncherChatLayout layout, final InterfaceC5063a<String> liveSessionId, final InterfaceC5074l<? super String, Y8.t> onSettled) {
        kotlin.jvm.internal.p.i(layout, "layout");
        kotlin.jvm.internal.p.i(liveSessionId, "liveSessionId");
        kotlin.jvm.internal.p.i(onSettled, "onSettled");
        final p9.p<w4.e, List<ChatMessage>, Y8.t> onCurrentConversationChanged = layout.getOnCurrentConversationChanged();
        layout.setOnCurrentConversationChanged(new p9.p() { // from class: com.stepos.ailauncher.chat.view.T
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return AskUserInquiryBinder.o(onCurrentConversationChanged, onSettled, liveSessionId, (w4.e) obj, (List) obj2);
            }
        });
    }
}
