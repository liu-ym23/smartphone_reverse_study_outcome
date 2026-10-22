package com.stepos.agentframework.chatui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.view.a0;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$style;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import h8.C4148a;
import io.ktor.http.LinkHeader;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Result;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 ,2\u00020\u0001:\u0002-.B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0016\u0010\u0014J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010'\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/i;", "Landroid/app/Dialog;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/agentframework/chatui/dialog/i$b;", "listener", "LY8/t;", "r", "(Lcom/stepos/agentframework/chatui/dialog/i$b;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/View;", LinkHeader.Parameters.Anchor, "s", "(Landroid/view/View;)V", "show", "()V", "l", "t", "y", "ctx", "", "m", "(Landroid/content/Context;)Z", "ownerRoot", "k", "(Landroid/view/View;)Z", "onConfirmListener", "Lcom/stepos/agentframework/chatui/dialog/i$b;", "Ljava/lang/ref/WeakReference;", "ownerRootRef", "Ljava/lang/ref/WeakReference;", "", "panelLayerId", "Ljava/lang/String;", "panelTracked", "Z", "Lcom/stepos/agentframework/chatui/panelui/a;", "recentsVisibility", "Lcom/stepos/agentframework/chatui/panelui/a;", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.agentframework.chatui.dialog.i, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogC1998i extends Dialog {
    private static final String TAG = "DeleteConfirmDialog";
    private b onConfirmListener;
    private WeakReference<View> ownerRootRef;
    private final String panelLayerId;
    private boolean panelTracked;
    private final com.stepos.agentframework.chatui.panelui.a recentsVisibility;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LinkedHashSet<DialogC1998i> activeInstances = new LinkedHashSet<>();

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR$\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/i$a;", "", "<init>", "()V", "Landroid/view/View;", "ownerRoot", "", Const.INTENT_KEY_APIKEY, "(Landroid/view/View;)Z", "", "TAG", "Ljava/lang/String;", "Ljava/util/LinkedHashSet;", "Lcom/stepos/agentframework/chatui/dialog/i;", "Lkotlin/collections/LinkedHashSet;", "activeInstances", "Ljava/util/LinkedHashSet;", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.dialog.i$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final boolean a(View ownerRoot) {
            Object objB;
            boolean z10 = false;
            for (DialogC1998i dialogC1998i : Z8.F.m1(DialogC1998i.activeInstances)) {
                if (dialogC1998i.isShowing() && dialogC1998i.k(ownerRoot)) {
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        dialogC1998i.l();
                        z10 = true;
                        objB = Result.b(Y8.t.f7040a);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objB = Result.b(C4849c.a(th));
                    }
                    Throwable thE = Result.e(objB);
                    if (thE != null) {
                        C4148a.u(DialogC1998i.TAG, "dismissAllShowingForWake failed: " + thE.getMessage(), false, 4, null);
                    }
                }
            }
            return z10;
        }

        public Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/stepos/agentframework/chatui/dialog/i$b;", "", "LY8/t;", Const.INTENT_KEY_APIKEY, "()V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.chatui.dialog.i$b */
    public interface b {
        void a();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC1998i(Context context) {
        super(context, R$style.DeleteConfirmDialogStyle);
        kotlin.jvm.internal.p.i(context, "context");
        this.panelLayerId = "delete_confirm_" + System.identityHashCode(this);
        this.recentsVisibility = new com.stepos.agentframework.chatui.panelui.a(this);
    }

    public static final void n(DialogC1998i dialogC1998i, View view) {
        dialogC1998i.dismiss();
    }

    public static final void o(DialogC1998i dialogC1998i, View view) {
        b bVar = dialogC1998i.onConfirmListener;
        if (bVar != null) {
            bVar.a();
        }
        dialogC1998i.dismiss();
    }

    public static final a0 p(int i10, View view, a0 insets) {
        kotlin.jvm.internal.p.i(view, "view");
        kotlin.jvm.internal.p.i(insets, "insets");
        int i11 = insets.f(a0.o.e()).f41980d;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.bottomMargin = i10 + i11;
            view.setLayoutParams(marginLayoutParams);
        }
        return insets;
    }

    public static final void q(DialogC1998i dialogC1998i, DialogInterface dialogInterface) {
        dialogC1998i.y();
        activeInstances.remove(dialogC1998i);
    }

    public static final boolean u(DialogC1998i dialogC1998i) {
        return dialogC1998i.isShowing();
    }

    public static final Y8.t v(DialogC1998i dialogC1998i) {
        dialogC1998i.dismiss();
        return Y8.t.f7040a;
    }

    public static final boolean w(DialogC1998i dialogC1998i) {
        return dialogC1998i.recentsVisibility.b();
    }

    public static final boolean x(DialogC1998i dialogC1998i) {
        return dialogC1998i.recentsVisibility.a();
    }

    public final boolean k(View ownerRoot) {
        if (ownerRoot == null) {
            return true;
        }
        WeakReference<View> weakReference = this.ownerRootRef;
        View view = weakReference != null ? weakReference.get() : null;
        return view == null || view == ownerRoot;
    }

    public final void l() {
        dismiss();
    }

    public final boolean m(Context ctx) {
        while (ctx instanceof ContextWrapper) {
            if (ctx instanceof Activity) {
                return true;
            }
            ctx = ((ContextWrapper) ctx).getBaseContext();
        }
        return false;
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R$layout.dialog_chat_item_delete_confirm);
        Window window = getWindow();
        if (window != null) {
            Context context = window.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            if (!m(context)) {
                window.setType(2038);
            }
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setDimAmount(0.4f);
            window.addFlags(2);
        }
        AppCompatButton appCompatButton = (AppCompatButton) findViewById(R$id.btn_delete_cancel);
        if (appCompatButton != null) {
            appCompatButton.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.dialog.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogC1998i.n(this.f22895a, view);
                }
            });
        }
        AppCompatButton appCompatButton2 = (AppCompatButton) findViewById(R$id.btn_delete_confirm);
        if (appCompatButton2 != null) {
            appCompatButton2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.dialog.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DialogC1998i.o(this.f22896a, view);
                }
            });
        }
        View viewFindViewById = findViewById(R$id.delete_confirm_root);
        if (viewFindViewById != null) {
            ViewGroup.LayoutParams layoutParams = viewFindViewById.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            final int i10 = marginLayoutParams != null ? marginLayoutParams.bottomMargin : 0;
            androidx.core.view.N.u0(viewFindViewById, new androidx.core.view.A() { // from class: com.stepos.agentframework.chatui.dialog.c
                @Override // androidx.core.view.A
                public final a0 a(View view, a0 a0Var) {
                    return DialogC1998i.p(i10, view, a0Var);
                }
            });
            androidx.core.view.N.e0(viewFindViewById);
        }
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.stepos.agentframework.chatui.dialog.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogC1998i.q(this.f22898a, dialogInterface);
            }
        });
    }

    public final void r(b listener) {
        kotlin.jvm.internal.p.i(listener, "listener");
        this.onConfirmListener = listener;
    }

    public final void s(View anchor) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        this.ownerRootRef = new WeakReference<>(anchor.getRootView());
        show();
    }

    @Override // android.app.Dialog
    public void show() {
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        if (m(context) || Settings.canDrawOverlays(getContext())) {
            super.show();
            if (isShowing()) {
                activeInstances.add(this);
                t();
                return;
            }
            return;
        }
        C4148a.h(TAG, "skip show: no activity token and overlay permission denied, context=" + getContext().getClass().getName(), false, 4, null);
    }

    public final void t() {
        if (this.panelTracked) {
            return;
        }
        this.panelTracked = true;
        com.stepos.agentframework.chatui.panelui.f fVar = com.stepos.agentframework.chatui.panelui.f.INSTANCE;
        String str = this.panelLayerId;
        PanelHomePolicy panelHomePolicy = PanelHomePolicy.DISMISS_TOP_ONLY;
        WeakReference<View> weakReference = this.ownerRootRef;
        fVar.b(str, panelHomePolicy, weakReference != null ? weakReference.get() : null, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DialogC1998i.u(this.f22899a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.f
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return DialogC1998i.v(this.f22900a);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.g
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DialogC1998i.w(this.f22901a));
            }
        }, new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.dialog.h
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(DialogC1998i.x(this.f22902a));
            }
        });
    }

    public final void y() {
        if (this.panelTracked) {
            this.panelTracked = false;
            com.stepos.agentframework.chatui.panelui.f.INSTANCE.c(this.panelLayerId);
        }
    }
}
