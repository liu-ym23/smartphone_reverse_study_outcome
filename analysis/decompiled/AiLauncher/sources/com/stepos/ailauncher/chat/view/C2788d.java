package com.stepos.ailauncher.chat.view;

import Z8.C1172u;
import Z8.C1173v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.R$color;
import com.stepos.ailauncher.chat.R$drawable;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import io.ktor.http.LinkHeader;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001aW\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u000eH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001aE\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u0019\u0010\u001a\u001aM\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/ailauncher/chat/view/s8;", "agent", "", "Lcom/stepos/ailauncher/chat/view/AgentAction;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/chat/view/s8;)Ljava/util/List;", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "rawX", "rawY", "Lkotlin/Function0;", "LY8/t;", "onDismiss", "Lkotlin/Function1;", "onAction", "Landroid/widget/PopupWindow;", "c", "(Landroid/view/View;Lcom/stepos/ailauncher/chat/view/s8;FFLp9/a;Lp9/l;)Landroid/widget/PopupWindow;", "Landroid/content/Context;", "context", "", "ownerKey", "onConfirm", "onCancel", "e", "(Landroid/content/Context;Ljava/lang/Object;Lp9/a;Lp9/a;)Lp9/a;", "", "agentName", "f", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/String;Lp9/a;Lp9/a;)Lp9/a;", "AGENT_MENU_CORNER_DP", "F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2788d {
    private static final float AGENT_MENU_CORNER_DP = 16.0f;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.d$a */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AgentAction.values().length];
            try {
                iArr[AgentAction.Disconnect.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AgentAction.Uninstall.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final List<AgentAction> b(SidebarAgentItem agent) {
        kotlin.jvm.internal.p.i(agent, "agent");
        if (agent.getIsPrimary()) {
            return C1173v.m();
        }
        return C1172u.e(agent.getInstalled() ? AgentAction.Uninstall : AgentAction.Disconnect);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.widget.PopupWindow] */
    public static final PopupWindow c(View anchor, SidebarAgentItem agent, float f10, float f11, InterfaceC5063a<Y8.t> interfaceC5063a, final InterfaceC5074l<? super AgentAction, Y8.t> onAction) {
        int i10;
        int i11;
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(agent, "agent");
        kotlin.jvm.internal.p.i(onAction, "onAction");
        List<AgentAction> listB = b(agent);
        if (listB.isEmpty()) {
            return null;
        }
        Context context = anchor.getContext();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        View viewInflate = layoutInflaterFrom.inflate(R$layout.popup_agent_actions, (ViewGroup) null);
        kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        ViewGroup viewGroup = (LinearLayout) viewInflate;
        int iC = androidx.core.content.a.c(context, R$color.popup_rename_item_text);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        for (final AgentAction agentAction : listB) {
            View viewInflate2 = layoutInflaterFrom.inflate(R$layout.item_agent_action, viewGroup, false);
            kotlin.jvm.internal.p.g(viewInflate2, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) viewInflate2;
            int[] iArr = a.$EnumSwitchMapping$0;
            int i12 = iArr[agentAction.ordinal()];
            if (i12 == 1) {
                i10 = R$drawable.ic_history_agent_disconnect;
            } else {
                if (i12 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i10 = R$drawable.ic_history_agent_uninstall_1;
            }
            int i13 = iArr[agentAction.ordinal()];
            if (i13 == 1) {
                i11 = R$string.sidebar_agent_action_disconnect;
            } else {
                if (i13 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i11 = R$string.sidebar_agent_action_uninstall;
            }
            textView.setText(i11);
            textView.setTextColor(iC);
            textView.setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C2788d.d(ref$ObjectRef, onAction, agentAction, view);
                }
            });
            viewGroup.addView(textView);
        }
        ?? K10 = R5.k(anchor, viewGroup, 16.0f, f10, f11, false, false, interfaceC5063a, 96, null);
        ref$ObjectRef.f34820a = K10;
        if (K10 != 0) {
            return K10;
        }
        kotlin.jvm.internal.p.A("popup");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(Ref$ObjectRef ref$ObjectRef, InterfaceC5074l interfaceC5074l, AgentAction agentAction, View view) {
        PopupWindow popupWindow;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("popup");
            popupWindow = null;
        } else {
            popupWindow = (PopupWindow) t10;
        }
        popupWindow.dismiss();
        interfaceC5074l.invoke(agentAction);
    }

    public static final InterfaceC5063a<Y8.t> e(Context context, Object ownerKey, InterfaceC5063a<Y8.t> onConfirm, InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        return X8.q(context, R$layout.dialog_agent_disconnect, null, null, null, onConfirm, interfaceC5063a, ownerKey, 28, null);
    }

    public static final InterfaceC5063a<Y8.t> f(Context context, Object ownerKey, String agentName, InterfaceC5063a<Y8.t> onConfirm, InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(agentName, "agentName");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        return X8.p(context, R$layout.dialog_agent_disconnect, context.getString(R$string.sidebar_agent_uninstall_dialog_title), context.getString(R$string.sidebar_agent_uninstall_dialog_desc, agentName), context.getString(R$string.sidebar_agent_uninstall_dialog_confirm), onConfirm, interfaceC5063a, ownerKey);
    }
}
