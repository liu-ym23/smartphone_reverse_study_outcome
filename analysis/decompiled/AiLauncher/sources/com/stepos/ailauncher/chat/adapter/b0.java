package com.stepos.ailauncher.chat.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.view.C2765a9;
import com.stepos.ailauncher.chat.view.IndeterminateSpinnerView;
import com.stepos.ailauncher.chat.view.SidebarAgentItem;
import kotlin.Metadata;
import v5.C5659a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ-\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0015¨\u0006 "}, d2 = {"Lcom/stepos/ailauncher/chat/adapter/b0;", "", "<init>", "()V", "Landroid/content/Context;", "context", "", "rows", "c", "(Landroid/content/Context;I)I", "Landroid/view/View;", "row", "Lcom/stepos/ailauncher/chat/view/s8;", "agent", "", "selected", "uninstalling", "LY8/t;", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/s8;ZZ)V", "LAYOUT", "I", Const.INTENT_KEY_PKGNAME, "()I", "COLOR_NAME_ONLINE", "COLOR_NAME_OFFLINE", "UNINSTALLING_SPINNER_COLOR", "", "UNINSTALLING_ALPHA", "F", "ROW_HEIGHT_DP", "ROW_GAP_DP", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class b0 {
    private static final int COLOR_NAME_OFFLINE = 1728053247;
    private static final int COLOR_NAME_ONLINE = -436207617;
    public static final b0 INSTANCE = new b0();
    private static final int LAYOUT = R$layout.item_chat_history_agent_device;
    private static final int ROW_GAP_DP = 1;
    private static final int ROW_HEIGHT_DP = 44;
    private static final float UNINSTALLING_ALPHA = 0.4f;
    private static final int UNINSTALLING_SPINNER_COLOR = -1711276033;

    public final void a(View row, SidebarAgentItem agent, boolean selected, boolean uninstalling) {
        kotlin.jvm.internal.p.i(row, "row");
        kotlin.jvm.internal.p.i(agent, "agent");
        TextView textView = (TextView) row.findViewById(R$id.tv_device_name);
        if (textView != null) {
            textView.setText(agent.getDisplayName());
            textView.setTextColor((agent.getIsPrimary() || agent.getOnline()) ? COLOR_NAME_ONLINE : COLOR_NAME_OFFLINE);
        }
        ImageView imageView = (ImageView) row.findViewById(R$id.iv_agent_icon);
        if (imageView != null) {
            imageView.setVisibility(0);
            C2765a9.c(imageView, agent.getIcon(), R$drawable.ic_session_amoo_agent, false, 8, null);
        }
        IndeterminateSpinnerView indeterminateSpinnerView = (IndeterminateSpinnerView) row.findViewById(R$id.spinner_agent_uninstalling);
        TextView textView2 = (TextView) row.findViewById(R$id.tv_last_message_time);
        if (uninstalling) {
            if (indeterminateSpinnerView != null) {
                indeterminateSpinnerView.setColor(UNINSTALLING_SPINNER_COLOR);
                indeterminateSpinnerView.setVisibility(0);
            }
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            row.setAlpha(0.4f);
            row.setSelected(false);
            return;
        }
        if (indeterminateSpinnerView != null) {
            indeterminateSpinnerView.setVisibility(8);
        }
        row.setAlpha(1.0f);
        if (textView2 != null) {
            com.stepos.ailauncher.chat.util.s sVar = com.stepos.ailauncher.chat.util.s.INSTANCE;
            Context context = row.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            textView2.setText(com.stepos.ailauncher.chat.util.s.c(sVar, context, agent.g(), 0L, 4, null));
            textView2.setVisibility(agent.g() <= 0 ? 8 : 0);
        }
        row.setSelected(selected);
    }

    public final int b() {
        return LAYOUT;
    }

    public final int c(Context context, int rows) {
        kotlin.jvm.internal.p.i(context, "context");
        return C5659a.INSTANCE.a(context, rows * 45);
    }
}
