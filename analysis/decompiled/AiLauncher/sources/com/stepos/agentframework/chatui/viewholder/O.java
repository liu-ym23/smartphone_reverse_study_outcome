package com.stepos.agentframework.chatui.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.SendState;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.task.view.C2054d;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import u4.m;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001%B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/O;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/N1;", "displayMessage", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Lcom/stepos/agentframework/chatui/N1;I)V", "Lcom/stepos/agentframework/chatui/SendState;", VoiceWakeupReceiver.EXTRA_STATE, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/agentframework/chatui/SendState;)V", "message", "n", "(Lcom/stepos/agentframework/chatui/N1;)V", "m", "Landroid/widget/TextView;", "tvSentText", "Landroid/widget/TextView;", "contentWrapper", "Landroid/view/View;", "sendingDots", "Landroid/widget/ImageView;", "ivSendFailed", "Landroid/widget/ImageView;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class O extends AbstractC2106k {
    private final View contentWrapper;
    private final ImageView ivSendFailed;
    private final View sendingDots;
    private final TextView tvSentText;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SendState.values().length];
            try {
                iArr[SendState.SENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SendState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SendState.SENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O(View itemView, final U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.tvSentMessage);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById;
        this.tvSentText = textView;
        View viewFindViewById2 = itemView.findViewById(R$id.ll_content);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.contentWrapper = viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.sendingDots);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.sendingDots = viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.ivSendFailed);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        ImageView imageView = (ImageView) viewFindViewById4;
        this.ivSendFailed = imageView;
        AgentUIConfig agentUiConfig = chatView.getAgentUiConfig();
        if (agentUiConfig != null) {
            if (agentUiConfig.getSendItemBg() != -1) {
                viewFindViewById2.setBackgroundResource(agentUiConfig.getSendItemBg());
            }
            com.stepos.agentframework.a.a(textView, agentUiConfig.getMessageTextStyle().getSent());
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.N
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O.l(this.f23179a, chatView, view);
            }
        });
    }

    public static final void l(O o10, U1 u12, View view) {
        int iD = o10.d();
        if (iD != -1) {
            u12.J(iD);
        }
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
        n((DisplayMessage) item);
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void h(DisplayMessage displayMessage, int position) {
        kotlin.jvm.internal.p.i(displayMessage, "displayMessage");
        n(displayMessage);
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void j(SendState state) {
        kotlin.jvm.internal.p.i(state, "state");
        m(state);
    }

    public final void m(SendState state) {
        int i10 = b.$EnumSwitchMapping$0[state.ordinal()];
        if (i10 == 1) {
            this.sendingDots.setVisibility(0);
            this.ivSendFailed.setVisibility(8);
        } else if (i10 == 2) {
            this.sendingDots.setVisibility(8);
            this.ivSendFailed.setVisibility(0);
        } else {
            if (i10 != 3) {
                throw new NoWhenBranchMatchedException();
            }
            this.sendingDots.setVisibility(8);
            this.ivSendFailed.setVisibility(8);
        }
    }

    public final void n(DisplayMessage message) {
        DisplayChatMessage displayChatMessage = (DisplayChatMessage) Z8.F.s0(message.m());
        u4.m content = displayChatMessage != null ? displayChatMessage.getContent() : null;
        m.TextMessage textMessage = content instanceof m.TextMessage ? (m.TextMessage) content : null;
        TextView textView = this.tvSentText;
        O6.f fVar = O6.f.INSTANCE;
        String text = textMessage != null ? textMessage.getText() : null;
        if (text == null) {
            text = "";
        }
        textView.setText(fVar.b(text));
        m(message.getSendState());
        C2054d.Companion.f(C2054d.INSTANCE, this.tvSentText, 1, message, getChatView(), 0, 16, null);
    }
}
