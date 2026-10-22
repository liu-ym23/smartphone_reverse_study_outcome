package com.stepos.agentframework.chatui.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.chatui.U1;
import com.stepos.agentframework.util.u;
import com.stepos.ailauncher.agent.receiver.SystemDeleteBroadcastReceiver;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/M;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "startPos", "", "", SystemDeleteBroadcastReceiver.EXTRA_SOURCES, "o", "(ILjava/util/List;)V", "Landroid/widget/LinearLayout;", "llImageContainer", "Landroid/widget/LinearLayout;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class M extends AbstractC2106k {
    private final LinearLayout llImageContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(View itemView, U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.ll_image_container);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.llImageContainer = (LinearLayout) viewFindViewById;
    }

    public static final void m(M m10, List list, View view) {
        m10.o(0, list);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void n(java.util.List r2, u4.m.ImageMessage r3, com.stepos.agentframework.chatui.viewholder.M r4, android.view.View r5) {
        /*
            boolean r5 = r2.isEmpty()
            if (r5 == 0) goto L7
            return
        L7:
            java.lang.String r5 = r3.getLocalPath()
            r0 = 0
            if (r5 == 0) goto L1d
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L1a
            goto L1b
        L1a:
            r5 = r0
        L1b:
            if (r5 != 0) goto L34
        L1d:
            java.lang.String r5 = r3.getUrl()
            if (r5 != 0) goto L34
            android.net.Uri r3 = r3.getUri()
            if (r3 == 0) goto L2f
            java.lang.String r3 = r3.toString()
            r5 = r3
            goto L30
        L2f:
            r5 = r0
        L30:
            if (r5 != 0) goto L34
            java.lang.String r5 = ""
        L34:
            int r3 = r2.indexOf(r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r5 = r3.intValue()
            if (r5 < 0) goto L43
            r0 = r3
        L43:
            if (r0 == 0) goto L4a
            int r3 = r0.intValue()
            goto L4b
        L4a:
            r3 = 0
        L4b:
            r4.o(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.M.n(java.util.List, u4.m$e, com.stepos.agentframework.chatui.viewholder.M, android.view.View):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01bc  */
    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(com.stepos.agentframework.chatui.S1 r17, int r18) {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.chatui.viewholder.M.e(com.stepos.agentframework.chatui.S1, int):void");
    }

    public final void o(int startPos, List<String> sources) {
        u.Companion companion = com.stepos.agentframework.util.u.INSTANCE;
        View itemView = this.itemView;
        kotlin.jvm.internal.p.h(itemView, "itemView");
        u.Companion.j(companion, itemView, sources, startPos, false, 8, null);
    }
}
