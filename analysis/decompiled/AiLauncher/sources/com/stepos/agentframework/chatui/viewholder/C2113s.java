package com.stepos.agentframework.chatui.viewholder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.view.MessageContentContainer;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/s;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/ViewGroup;", "parent", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/ViewGroup;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;", "row", "k", "(Lcom/stepos/agentframework/chatui/longtext/ChatRenderRow;)V", "Landroid/widget/LinearLayout;", Parameters.ROOT, "Landroid/widget/LinearLayout;", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "markdown", "Lcom/stepos/agentframework/uikit/AIMDTextView;", "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "Lcom/stepos/agentframework/chatui/view/MessageContentContainer;", "", "boundMarkdown", "Ljava/lang/String;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.viewholder.s, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2113s extends AbstractC2106k {
    private String boundMarkdown;
    private final AIMDTextView markdown;
    private final LinearLayout root;
    private final MessageContentContainer sources;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2113s(ViewGroup parent, U1 chatView) {
        super(new LinearLayout(parent.getContext()), chatView);
        kotlin.jvm.internal.p.i(parent, "parent");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View view = this.itemView;
        kotlin.jvm.internal.p.g(view, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) view;
        this.root = linearLayout;
        Context context = parent.getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        AIMDTextView aIMDTextView = new AIMDTextView(context, null, 0, 6, null);
        this.markdown = aIMDTextView;
        Context context2 = parent.getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        MessageContentContainer messageContentContainer = new MessageContentContainer(context2, null);
        this.sources = messageContentContainer;
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        linearLayout.addView(aIMDTextView, new LinearLayout.LayoutParams(-1, -2));
        linearLayout.addView(messageContentContainer, new LinearLayout.LayoutParams(-1, -2));
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(com.stepos.agentframework.chatui.longtext.ChatRenderRow r10) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.C2113s.k(com.stepos.agentframework.chatui.longtext.ChatRenderRow):void");
    }
}
