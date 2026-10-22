package com.stepos.agentframework.chatui.viewholder;

import Z8.C1173v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.chatcore.session.AgentMessageType;
import com.stepos.agentframework.chatui.DisplayChatMessage;
import com.stepos.agentframework.chatui.DisplayMessage;
import com.stepos.agentframework.chatui.Q1;
import com.stepos.agentframework.chatui.S1;
import com.stepos.agentframework.chatui.U1;
import com.stepos.ame.sdk.SkillStoreKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import u4.m;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/stepos/agentframework/chatui/viewholder/J;", "Lcom/stepos/agentframework/chatui/viewholder/k;", "Landroid/view/View;", "itemView", "Lcom/stepos/agentframework/chatui/U1;", "chatView", "<init>", "(Landroid/view/View;Lcom/stepos/agentframework/chatui/U1;)V", "Lcom/stepos/agentframework/chatui/S1;", "item", "", "position", "LY8/t;", "e", "(Lcom/stepos/agentframework/chatui/S1;I)V", "fileView", "Lu4/m$c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "k", "(Landroid/view/View;Lu4/m$c;)V", "Landroid/widget/LinearLayout;", "llFileContainer", "Landroid/widget/LinearLayout;", "Companion", Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class J extends AbstractC2106k {
    private final LinearLayout llFileContainer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(View itemView, U1 chatView) {
        super(itemView, chatView);
        kotlin.jvm.internal.p.i(itemView, "itemView");
        kotlin.jvm.internal.p.i(chatView, "chatView");
        View viewFindViewById = itemView.findViewById(R$id.ll_file_container);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.llFileContainer = (LinearLayout) viewFindViewById;
    }

    @Override // com.stepos.agentframework.chatui.viewholder.AbstractC2106k
    public void e(S1 item, int position) {
        kotlin.jvm.internal.p.i(item, "item");
        List<DisplayChatMessage> listM = ((DisplayMessage) item).m();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listM) {
            if (((DisplayChatMessage) obj).getType() == AgentMessageType.FILE) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            u4.m content = ((DisplayChatMessage) it.next()).getContent();
            m.FileMessage fileMessage = content instanceof m.FileMessage ? (m.FileMessage) content : null;
            if (fileMessage != null) {
                arrayList2.add(fileMessage);
            }
        }
        if (arrayList2.isEmpty()) {
            return;
        }
        this.llFileContainer.removeAllViews();
        int i10 = 0;
        for (Object obj2 : arrayList2) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            View viewInflate = LayoutInflater.from(this.itemView.getContext()).inflate(R$layout.item_sent_file_single, (ViewGroup) this.llFileContainer, false);
            kotlin.jvm.internal.p.f(viewInflate);
            k(viewInflate, (m.FileMessage) obj2);
            if (i10 > 0) {
                ViewGroup.LayoutParams layoutParams = viewInflate.getLayoutParams();
                LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
                if (layoutParams2 == null) {
                    layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                }
                O6.d dVar = O6.d.INSTANCE;
                Context context = this.itemView.getContext();
                kotlin.jvm.internal.p.h(context, "getContext(...)");
                layoutParams2.setMarginStart(dVar.a(context, 8.0f));
                viewInflate.setLayoutParams(layoutParams2);
            }
            this.llFileContainer.addView(viewInflate);
            i10 = i11;
        }
    }

    public final void k(View fileView, m.FileMessage content) {
        String str;
        String fileSize;
        Long lY;
        ImageView imageView = (ImageView) fileView.findViewById(R$id.iv_file_icon);
        TextView textView = (TextView) fileView.findViewById(R$id.tv_file_name);
        TextView textView2 = (TextView) fileView.findViewById(R$id.tv_file_type);
        TextView textView3 = (TextView) fileView.findViewById(R$id.tv_file_size);
        imageView.setImageResource(Q1.INSTANCE.b(content.getFileType()));
        textView.setText(content.getFileName());
        switch (content.getFileType()) {
            case 2:
                str = "VIDEO";
                break;
            case 3:
            case 8:
                str = "DOC";
                break;
            case 4:
                str = "PDF";
                break;
            case 5:
            case 6:
            default:
                str = "FILE";
                break;
            case 7:
                str = "PPT";
                break;
            case 9:
                str = "XLS";
                break;
            case 10:
                str = "TXT";
                break;
            case 11:
                str = "MD";
                break;
        }
        textView2.setText(str);
        String fileSize2 = content.getFileSize();
        if (fileSize2 == null || (lY = La.C.y(fileSize2)) == null || (fileSize = com.stepos.agentframework.chatcore.utils.h.a(lY.longValue())) == null) {
            fileSize = content.getFileSize();
        }
        textView3.setText(fileSize);
    }
}
