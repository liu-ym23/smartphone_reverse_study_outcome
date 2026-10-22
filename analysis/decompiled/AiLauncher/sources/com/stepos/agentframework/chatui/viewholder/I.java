package com.stepos.agentframework.chatui.viewholder;

import android.view.View;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.session.ReconnectReason;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.k2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/I;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Landroid/widget/TextView;", "promptText", "Landroid/widget/TextView;", "retryText", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class I extends AbstractC2106k {
    private final TextView promptText;
    private final TextView retryText;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class b {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ReconnectReason.values().length];
            try {
                iArr[ReconnectReason.AGENT_OFFLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ReconnectReason.AI_TIMEOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public I(View itemView, U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.tv_reconnect_prompt);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.promptText = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tv_reconnect_retry);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.retryText = (TextView) viewFindViewById2;
    }

    public static final void m(I i10, View view) {
        i10.getChatView().p();
    }

    public static final void n(I i10, View view) {
        i10.getChatView().o();
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
        k2 k2Var = item instanceof k2 ? (k2) item : null;
        ReconnectReason reason = k2Var != null ? k2Var.getReason() : null;
        TextView textView = this.promptText;
        int i10 = reason == null ? -1 : b.$EnumSwitchMapping$0[reason.ordinal()];
        textView.setText(i10 != 1 ? i10 != 2 ? R$string.chat_reconnect_prompt : R$string.chat_reconnect_prompt_timeout : R$string.chat_reconnect_prompt_agent_offline);
        if (reason == ReconnectReason.AGENT_OFFLINE) {
            this.retryText.setText(R$string.chat_reconnect_retry_reconnect);
            this.retryText.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.G
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    I.m(this.f23172a, view);
                }
            });
        } else {
            this.retryText.setText(R$string.chat_reconnect_retry);
            this.retryText.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.H
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    I.n(this.f23173a, view);
                }
            });
        }
    }
}
