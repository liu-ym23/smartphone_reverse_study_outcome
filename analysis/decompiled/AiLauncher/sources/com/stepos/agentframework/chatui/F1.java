package com.stepos.agentframework.chatui;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatui.longtext.ChatRenderRow;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J)\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010!\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010\"\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002¢\u0006\u0004\b\"\u0010\u001fJ\u001f\u0010#\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0002¢\u0006\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010'R\u0014\u0010)\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010*\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010'R\u0014\u0010+\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010,\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010'R\u0014\u0010-\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010'¨\u0006."}, d2 = {"Lcom/stepos/agentframework/chatui/F1;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "Lcom/stepos/agentframework/chatui/ChatMessageAdapter;", "adapter", "", "pos", "", Const.INTENT_KEY_UMID, "(Lcom/stepos/agentframework/chatui/ChatMessageAdapter;I)Z", "step", "Lcom/stepos/agentframework/chatui/N1;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/ChatMessageAdapter;II)Lcom/stepos/agentframework/chatui/N1;", "current", "older", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/N1;)I", "newer", Const.INTENT_KEY_APIKEY, "c", "e", "(Lcom/stepos/agentframework/chatui/N1;Lcom/stepos/agentframework/chatui/N1;)Z", "f", "userMessageBottomGapPx", "I", "halfGapBetweenMessagesPx", "halfGapBetweenUserSendPartsPx", "halfGapBetweenReplyAndTaskCardPx", "thinkingBubbleTopGapPx", "reconnectPromptGapPx", "listBottomPaddingPx", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class F1 extends RecyclerView.ItemDecoration {
    private final int halfGapBetweenMessagesPx;
    private final int halfGapBetweenReplyAndTaskCardPx;
    private final int halfGapBetweenUserSendPartsPx;
    private final int listBottomPaddingPx;
    private final int reconnectPromptGapPx;
    private final int thinkingBubbleTopGapPx;
    private final int userMessageBottomGapPx;

    public F1(Context context) {
        kotlin.jvm.internal.p.i(context, "context");
        O6.d dVar = O6.d.INSTANCE;
        int iA = dVar.a(context, 16.0f);
        this.userMessageBottomGapPx = iA;
        this.halfGapBetweenMessagesPx = dVar.a(context, 12.0f);
        this.halfGapBetweenUserSendPartsPx = dVar.a(context, 8.0f);
        this.halfGapBetweenReplyAndTaskCardPx = dVar.a(context, 10.0f);
        this.thinkingBubbleTopGapPx = iA * 2;
        this.reconnectPromptGapPx = dVar.a(context, 8.0f);
        this.listBottomPaddingPx = dVar.a(context, 32.0f);
    }

    public final int a(DisplayMessage current, DisplayMessage newer) {
        return c(current, newer);
    }

    public final DisplayMessage b(ChatMessageAdapter adapter, int pos, int step) {
        DisplayMessage displayMessage;
        do {
            pos += step;
            S1 s12 = (S1) Z8.F.t0(adapter.G(), pos);
            if (s12 == null) {
                return null;
            }
            displayMessage = s12 instanceof DisplayMessage ? (DisplayMessage) s12 : null;
            if (displayMessage == null) {
                return null;
            }
        } while (displayMessage.O());
        return displayMessage;
    }

    public final int c(DisplayMessage older, DisplayMessage newer) {
        return e(older, newer) ? this.halfGapBetweenReplyAndTaskCardPx : f(older, newer) ? this.halfGapBetweenUserSendPartsPx : older.getRole() == AgentRole.USER ? this.userMessageBottomGapPx : this.halfGapBetweenMessagesPx;
    }

    public final boolean d(ChatMessageAdapter adapter, int pos) {
        for (int i10 = pos - 1; -1 < i10; i10--) {
            Object objT0 = Z8.F.t0(adapter.G(), i10);
            DisplayMessage displayMessage = objT0 instanceof DisplayMessage ? (DisplayMessage) objT0 : null;
            if (displayMessage == null || !displayMessage.O()) {
                return false;
            }
        }
        return true;
    }

    public final boolean e(DisplayMessage older, DisplayMessage newer) {
        AgentRole role = older.getRole();
        AgentRole agentRole = AgentRole.ASSISTANT;
        return role == agentRole && newer.getRole() == agentRole && newer.m().size() == 1 && ((DisplayChatMessage) Z8.F.q0(newer.m())).getType() == AgentMessageType.TASK;
    }

    public final boolean f(DisplayMessage older, DisplayMessage newer) {
        AgentRole role = older.getRole();
        AgentRole agentRole = AgentRole.USER;
        if (role != agentRole || newer.getRole() != agentRole || older.getPairId().length() == 0 || newer.getPairId().length() == 0) {
            return false;
        }
        return kotlin.jvm.internal.p.d(older.getPairId(), newer.getPairId());
    }

    public final int g(DisplayMessage current, DisplayMessage older) {
        return c(older, current);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        ChatRenderRow chatRenderRowG0;
        kotlin.jvm.internal.p.i(outRect, "outRect");
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        RecyclerView.Adapter adapter = parent.getAdapter();
        ChatMessageAdapter chatMessageAdapter = adapter instanceof ChatMessageAdapter ? (ChatMessageAdapter) adapter : null;
        if (chatMessageAdapter == null || (chatRenderRowG0 = chatMessageAdapter.G0((childAdapterPosition = parent.getChildAdapterPosition(view)))) == null) {
            return;
        }
        int logicalIndex = chatRenderRowG0.getLogicalIndex();
        S1 s12 = (S1) Z8.F.t0(chatMessageAdapter.G(), logicalIndex);
        if (s12 == null) {
            return;
        }
        if (s12.a() != 0) {
            U1 chatView = chatMessageAdapter.getChatView();
            AgentChatLayout agentChatLayout = chatView instanceof AgentChatLayout ? (AgentChatLayout) chatView : null;
            int messageHorizontalContentInsetPx = agentChatLayout != null ? agentChatLayout.getMessageHorizontalContentInsetPx() : 0;
            outRect.left = messageHorizontalContentInsetPx;
            outRect.right = messageHorizontalContentInsetPx;
        }
        if (childAdapterPosition == 0) {
            outRect.bottom = this.listBottomPaddingPx;
        }
        if (s12 instanceof h2) {
            DisplayMessage displayMessageB = b(chatMessageAdapter, logicalIndex, 1);
            outRect.top = G1.a(displayMessageB != null ? displayMessageB.getRole() : null, this.userMessageBottomGapPx, this.halfGapBetweenMessagesPx);
            return;
        }
        if (s12 instanceof q2) {
            outRect.top = this.thinkingBubbleTopGapPx;
            return;
        }
        if (s12 instanceof k2) {
            int i10 = this.reconnectPromptGapPx;
            outRect.top = i10;
            if (logicalIndex == 0) {
                outRect.bottom = i10;
                return;
            }
            return;
        }
        Object objT0 = Z8.F.t0(chatMessageAdapter.G(), logicalIndex);
        DisplayMessage displayMessage = objT0 instanceof DisplayMessage ? (DisplayMessage) objT0 : null;
        if (displayMessage == null) {
            return;
        }
        if (displayMessage.O()) {
            outRect.setEmpty();
            return;
        }
        DisplayMessage displayMessageB2 = b(chatMessageAdapter, logicalIndex, 1);
        DisplayMessage displayMessageB3 = b(chatMessageAdapter, logicalIndex, -1);
        outRect.top = displayMessageB2 != null ? g(displayMessage, displayMessageB2) : 0;
        if (displayMessageB3 != null) {
            outRect.bottom = a(displayMessage, displayMessageB3);
        } else if (logicalIndex != 0 && d(chatMessageAdapter, logicalIndex)) {
            outRect.bottom = this.listBottomPaddingPx;
        }
        if (!chatRenderRowG0.getTopOfMessage()) {
            outRect.top = 0;
        }
        if (chatRenderRowG0.getBottomOfMessage()) {
            return;
        }
        outRect.bottom = 0;
    }
}
