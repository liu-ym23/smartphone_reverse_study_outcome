package com.stepos.agentframework.chatui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.agentframework.AgentUIConfig;
import com.stepos.agentframework.chatui.AgentChatLayout;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.longtext.ChatRenderRow;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import com.stepos.ame.sdk.SkillStoreKt;
import kotlin.Metadata;
import z4.LongTextCandidate;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/m;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/ViewGroup;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "row", "k", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;)V", "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.viewholder.m, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2108m extends AbstractC2106k {
    private final MessageContentContainer content;

    /* JADX WARN: Illegal instructions before constructor call */
    public C2108m(ViewGroup parent, U1 chatView) {
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        Context context = parent.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        super(new MessageContentContainer(context, null), chatView);
        View view = this.itemView;
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type com.stepos.agentframework.chatui.view.MessageContentContainer");
        MessageContentContainer messageContentContainer = (MessageContentContainer) view;
        this.content = messageContentContainer;
        messageContentContainer.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        messageContentContainer.setAllowTextSelection(false);
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
    }

    public final void k(ChatRenderRow row) {
        kotlin.jvm.internal.p.i(row, "row");
        S1 item = row.getItem();
        kotlin.jvm.internal.p.g(item, "null cannot be cast to non-null type com.stepos.agentframework.chatui.DisplayMessage");
        DisplayMessage displayMessage = (DisplayMessage) item;
        AgentUIConfig agentUiConfig = getChatView().getAgentUiConfig();
        MessageContentContainer messageContentContainer = this.content;
        U1 chatView = getChatView();
        AgentChatLayout agentChatLayout = chatView instanceof AgentChatLayout ? (AgentChatLayout) chatView : null;
        messageContentContainer.setHorizontalContentInsetPx(agentChatLayout != null ? agentChatLayout.getMessageHorizontalContentInsetPx() : 0);
        if (agentUiConfig == null || agentUiConfig.getReceiveItemBg() == -1) {
            this.content.setBackground(null);
        } else {
            this.content.setBackgroundResource(agentUiConfig.getReceiveItemBg());
        }
        float f10 = this.content.getResources().getDisplayMetrics().density;
        this.content.setPadding(0, (int) (12 * f10), 0, (int) (4 * f10));
        this.content.setMessage(LongTextCandidate.INSTANCE.d(displayMessage, row.getBodyPartIndex()));
    }
}
