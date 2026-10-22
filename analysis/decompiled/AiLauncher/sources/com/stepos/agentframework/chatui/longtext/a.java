package com.stepos.agentframework.chatui.longtext;

import Z8.C1172u;
import Z8.C1173v;
import Z8.F;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatcore.session.AgentRole;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.longtext.ChatRenderRow;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import u4.m;
import z4.i;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u000e2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J3\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH\u0002¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatui/longtext/a;", "", "<init>", "()V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "index", "Lcom/stepos/agentframework/chatui/longtext/LongTextDocument;", "document", "", "preparing", "allowImageSlices", "bodyPartIndex", "", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/agentframework/chatui/S1;ILcom/stepos/agentframework/chatui/longtext/LongTextDocument;ZZI)Ljava/util/List;", "", Const.INTENT_KEY_APIKEY, "(Lcom/stepos/agentframework/chatui/S1;)Ljava/util/List;", "Lcom/stepos/agentframework/chatui/N1;", "message", "slices", "c", "(Lcom/stepos/agentframework/chatui/N1;ILjava/util/List;)Ljava/util/List;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class a {
    public static final a INSTANCE = new a();

    public final List<String> a(S1 item) {
        DisplayChatMessage displayChatMessage;
        String text;
        DisplayMessage displayMessage = item instanceof DisplayMessage ? (DisplayMessage) item : null;
        if (displayMessage == null || displayMessage.getRole() != AgentRole.ASSISTANT || !displayMessage.getStatus().isTerminal() || (displayChatMessage = (DisplayChatMessage) F.E0(displayMessage.m())) == null || displayChatMessage.getType() != AgentMessageType.TEXT) {
            return null;
        }
        m content = displayChatMessage.getContent();
        m.TextMessage textMessage = content instanceof m.TextMessage ? (m.TextMessage) content : null;
        if (textMessage != null && (text = textMessage.getText()) != null) {
            return i.INSTANCE.b(text);
        }
        return null;
    }

    public final List<ChatRenderRow> b(S1 item, int index, LongTextDocument document, boolean preparing, boolean allowImageSlices, int bodyPartIndex) {
        List<String> listA;
        p.i(item, "item");
        if (preparing) {
            return C1172u.e(new ChatRenderRow(item, index, ChatRenderRow.Kind.PREPARING, null, 0, false, false, 0, null, 0, 1016, null));
        }
        if (document == null) {
            return (!allowImageSlices || (listA = a(item)) == null) ? C1172u.e(new ChatRenderRow(item, index, null, null, 0, false, false, 0, null, 0, 1020, null)) : c((DisplayMessage) item, index, listA);
        }
        DisplayMessage displayMessage = (DisplayMessage) item;
        List listC = C1172u.c();
        boolean z10 = bodyPartIndex < C1173v.o(displayMessage.m());
        if (z10) {
            listC.add(new ChatRenderRow(displayMessage, index, ChatRenderRow.Kind.ATTACHMENTS, null, 0, false, false, 0, null, bodyPartIndex, 472, null));
        }
        int size = document.a().size() - 1;
        if (size >= 0) {
            int i10 = size;
            while (true) {
                int i11 = i10 - 1;
                listC.add(new ChatRenderRow(displayMessage, index, ChatRenderRow.Kind.BLOCK, document, i10, false, !z10 && i10 == C1173v.o(document.a()), 0, null, bodyPartIndex, b.BLOCK_CHARS, null));
                if (i11 < 0) {
                    break;
                }
                i10 = i11;
            }
        }
        listC.add(new ChatRenderRow(displayMessage, index, ChatRenderRow.Kind.HEADER, document, 0, true, false, 0, null, bodyPartIndex, Const.I_TILE_TINY, null));
        return C1172u.a(listC);
    }

    public final List<ChatRenderRow> c(DisplayMessage message, int index, List<String> slices) {
        List listP1 = F.p1(message.m());
        listP1.set(C1173v.o(listP1), DisplayChatMessage.b((DisplayChatMessage) F.C0(listP1), null, null, new m.TextMessage("", null, 2, null), null, false, 27, null));
        boolean zO = DisplayMessage.e(message, null, null, null, null, null, null, listP1, 0L, null, null, null, 0, null, false, 0, null, null, null, null, null, null, null, 0L, null, 0, 0, null, false, 266338239, null).O();
        List listC = C1172u.c();
        int size = slices.size() - 1;
        if (size >= 0) {
            int i10 = size;
            while (true) {
                int i11 = i10 - 1;
                listC.add(new ChatRenderRow(message, index, ChatRenderRow.Kind.SLICE, null, 0, zO && i10 == 0, i10 == C1173v.o(slices), i10, slices.get(i10), 0, 536, null));
                if (i11 < 0) {
                    break;
                }
                i10 = i11;
            }
        }
        if (!zO) {
            listC.add(new ChatRenderRow(message, index, ChatRenderRow.Kind.HEADER, null, 0, true, false, 0, null, 0, 920, null));
        }
        return C1172u.a(listC);
    }
}
