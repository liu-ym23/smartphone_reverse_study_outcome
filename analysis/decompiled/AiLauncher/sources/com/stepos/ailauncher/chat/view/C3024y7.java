package com.stepos.ailauncher.chat.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$style;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.container.C3209b;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0003J\u000f\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u001b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/stepos/ailauncher/chat/view/y7;", "Landroidx/fragment/app/l;", "<init>", "()V", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "LY8/t;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", UxipConstants.f30640D, "onStop", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "onDismiss", "(Landroid/content/DialogInterface;)V", "Lkotlin/Function1;", "", "onConfirm", "Lp9/l;", "getOnConfirm", "()Lp9/l;", "x", "(Lp9/l;)V", "panelLayerId", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "initialTitle", "Companion", Const.INTENT_KEY_APIKEY, "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.chat.view.y7, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C3024y7 extends DialogInterfaceOnCancelListenerC1374l {
    private static final String ARG_INITIAL_TITLE = "initial_title";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String TAG = "RenameDialogFragment";
    private InterfaceC5074l<? super String, Y8.t> onConfirm;
    private String panelLayerId;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/chat/view/y7$a;", "", "<init>", "()V", "", "initialTitle", "Lcom/stepos/ailauncher/chat/view/y7;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)Lcom/stepos/ailauncher/chat/view/y7;", "TAG", "Ljava/lang/String;", "ARG_INITIAL_TITLE", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.chat.view.y7$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final C3024y7 a(String initialTitle) {
            kotlin.jvm.internal.p.i(initialTitle, "initialTitle");
            C3024y7 c3024y7 = new C3024y7();
            Bundle bundle = new Bundle();
            bundle.putString(C3024y7.ARG_INITIAL_TITLE, initialTitle);
            c3024y7.setArguments(bundle);
            return c3024y7;
        }

        public Companion() {
        }
    }

    public static final boolean t(C3024y7 c3024y7) {
        Dialog dialog = c3024y7.getDialog();
        return dialog != null && dialog.isShowing();
    }

    public static final Y8.t u(C3024y7 c3024y7) {
        c3024y7.dismissAllowingStateLoss();
        return Y8.t.f7040a;
    }

    public static final Y8.t v(C3024y7 c3024y7, String newTitle) {
        kotlin.jvm.internal.p.i(newTitle, "newTitle");
        InterfaceC5074l<? super String, Y8.t> interfaceC5074l = c3024y7.onConfirm;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(newTitle);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t w(C3024y7 c3024y7) {
        c3024y7.dismissAllowingStateLoss();
        return Y8.t.f7040a;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = new Dialog(requireContext(), R$style.ChatRenameDialogTheme);
        Window window = dialog.getWindow();
        if (window != null) {
            Window window2 = requireActivity().getWindow();
            kotlin.jvm.internal.p.h(window2, "getWindow(...)");
            C3034z7.b(window, window2);
        }
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(inflater, "inflater");
        View viewInflate = inflater.inflate(R$layout.dialog_rename_title, container, false);
        kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        kotlin.jvm.internal.p.i(dialog, "dialog");
        String str = this.panelLayerId;
        if (str != null) {
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
            this.panelLayerId = null;
        }
        super.onDismiss(dialog);
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setLayout(-1, -1);
        if (this.panelLayerId == null) {
            com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
            String strC = iVar.c("rename_dialog");
            this.panelLayerId = strC;
            PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
            View rootView = requireActivity().getWindow().getDecorView().getRootView();
            kotlin.jvm.internal.p.h(rootView, "getRootView(...)");
            InterfaceC5063a<Boolean> interfaceC5063a = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.u7
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return Boolean.valueOf(C3024y7.t(this.f26381a));
                }
            };
            InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.v7
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return C3024y7.u(this.f26396a);
                }
            };
            Dialog dialog2 = getDialog();
            if (dialog2 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            iVar.e(strC, panelHomePolicy, rootView, interfaceC5063a, interfaceC5063a2, new com.stepos.ailauncher.chat.panelui.c(dialog2));
        }
        C3209b.INSTANCE.c();
        View view = getView();
        if (view != null) {
            C2971t7.n(view);
        }
    }

    @Override // androidx.fragment.app.DialogInterfaceOnCancelListenerC1374l, androidx.fragment.app.Fragment
    public void onStop() {
        C3209b.INSTANCE.d();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        kotlin.jvm.internal.p.i(view, "view");
        super.onViewCreated(view, savedInstanceState);
        C2971t7.h(view, s(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.chat.view.w7
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return C3024y7.v(this.f26405a, (String) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.x7
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return C3024y7.w(this.f26417a);
            }
        });
    }

    public final String s() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(ARG_INITIAL_TITLE) : null;
        return string == null ? "" : string;
    }

    public final void x(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onConfirm = interfaceC5074l;
    }
}
