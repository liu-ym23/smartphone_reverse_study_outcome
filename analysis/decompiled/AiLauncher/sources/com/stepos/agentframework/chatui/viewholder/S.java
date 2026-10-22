package com.stepos.agentframework.chatui.viewholder;

import android.view.View;
import android.widget.TextView;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.chatui.t2;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/S;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "Landroid/widget/TextView;", "hintText", "Landroid/widget/TextView;", "actionText", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class S extends AbstractC2106k {
    private final TextView actionText;
    private final TextView hintText;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public S(View itemView, U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.tv_top_notice_hint);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.hintText = (TextView) viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.tv_top_notice_action);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.actionText = (TextView) viewFindViewById2;
    }

    public static final void l(S s10, View view) {
        s10.getChatView().y();
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
        t2 t2Var = item instanceof t2 ? (t2) item : null;
        if (t2Var == null) {
            return;
        }
        this.hintText.setText(t2Var.getHint());
        this.actionText.setText(t2Var.getAction());
        this.actionText.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.viewholder.Q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                S.l(this.f23181a, view);
            }
        });
    }
}
