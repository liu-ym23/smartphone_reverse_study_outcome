package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.TextView;
import com.stepos.agentframework.chatui.panelui.PanelHomePolicy;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.container.C3209b;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$BooleanRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0004\u001as\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0001\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001aU\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\t0\u00122\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001aU\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00102\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u001b\u0010\u001c\"\u0014\u0010\u001d\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e\"\u0014\u0010\u001f\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010 \"\u0014\u0010!\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010 \"\u0014\u0010\"\u001a\u00020\u00108\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010 \"\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010&\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010%¨\u0006'"}, d2 = {"Landroid/content/Context;", "context", "", "layoutRes", "", "title", "message", "confirmText", "Lkotlin/Function0;", "LY8/t;", "onConfirm", "onCancel", "", "ownerKey", "p", "(Landroid/content/Context;ILjava/lang/CharSequence;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Lp9/a;Lp9/a;Ljava/lang/Object;)Lp9/a;", "", "initialTitle", "Lkotlin/Function1;", "onDismissed", "x", "(Landroid/content/Context;Ljava/lang/Object;Ljava/lang/String;Lp9/l;Lp9/a;)Lp9/a;", "Landroid/view/View;", "contentView", "layerName", "softInputMode", "onDisposed", "k", "(Landroid/content/Context;Landroid/view/View;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Lp9/a;)Lp9/a;", "TAG_SIDEBAR_LAYER_ID", "I", "TAG", "Ljava/lang/String;", "LAYER_CONFIRM", "LAYER_RENAME", "", "MENU_ELEVATION", "F", "MENU_CORNER_RADIUS_DP", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class X8 {
    private static final String LAYER_CONFIRM = "sidebar_confirm";
    private static final String LAYER_RENAME = "sidebar_rename";
    private static final float MENU_CORNER_RADIUS_DP = 16.0f;
    private static final float MENU_ELEVATION = 16.0f;
    private static final String TAG = "SidebarPopupHost";
    private static final int TAG_SIDEBAR_LAYER_ID = 85843969;

    public static final InterfaceC5063a<Y8.t> k(Context context, final View view, Object obj, final String str, final Integer num, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        Object systemService = context.getSystemService("window");
        kotlin.jvm.internal.p.g(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        final WindowManager windowManager = (WindowManager) systemService;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-1, -1, 2038, 768, -3);
        if (num != null) {
            layoutParams.softInputMode = num.intValue();
        }
        com.stepos.ailauncher.chat.panelui.i iVar = com.stepos.ailauncher.chat.panelui.i.INSTANCE;
        final String strC = iVar.c(str);
        final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
        final InterfaceC5063a<Y8.t> interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.U8
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return X8.m(ref$BooleanRef, strC, num, view, windowManager, str, interfaceC5063a);
            }
        };
        try {
            windowManager.addView(view, layoutParams);
            ref$BooleanRef.f34815a = true;
            try {
                iVar.e(strC, PanelHomePolicy.DISMISS_TOP_ONLY, obj, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.V8
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return Boolean.valueOf(X8.n(ref$BooleanRef));
                    }
                }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.W8
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return X8.o(interfaceC5063a2);
                    }
                }, new com.stepos.ailauncher.chat.panelui.f(windowManager, view, layoutParams));
                return interfaceC5063a2;
            } catch (Exception e10) {
                Log.w(TAG, str + ": 登记弹层失败，HOME 管不到它", e10);
                return interfaceC5063a2;
            }
        } catch (Exception e11) {
            Log.e(TAG, str + ": 添加窗口失败", e11);
            return null;
        }
    }

    public static /* synthetic */ InterfaceC5063a l(Context context, View view, Object obj, String str, Integer num, InterfaceC5063a interfaceC5063a, int i10, Object obj2) {
        if ((i10 & 16) != 0) {
            num = null;
        }
        if ((i10 & 32) != 0) {
            interfaceC5063a = null;
        }
        return k(context, view, obj, str, num, interfaceC5063a);
    }

    public static final Y8.t m(Ref$BooleanRef ref$BooleanRef, String str, Integer num, View view, WindowManager windowManager, String str2, InterfaceC5063a interfaceC5063a) {
        WindowInsetsController windowInsetsController;
        if (ref$BooleanRef.f34815a) {
            ref$BooleanRef.f34815a = false;
            com.stepos.ailauncher.chat.panelui.i.INSTANCE.d(str);
            if (num != null && (windowInsetsController = view.getWindowInsetsController()) != null) {
                windowInsetsController.hide(WindowInsets.Type.ime());
            }
            try {
                windowManager.removeView(view);
            } catch (Exception e10) {
                Log.w(TAG, str2 + ": 移除窗口失败", e10);
            }
            if (interfaceC5063a != null) {
                interfaceC5063a.invoke();
            }
        }
        return Y8.t.f7040a;
    }

    public static final boolean n(Ref$BooleanRef ref$BooleanRef) {
        return ref$BooleanRef.f34815a;
    }

    public static final Y8.t o(InterfaceC5063a interfaceC5063a) {
        interfaceC5063a.invoke();
        return Y8.t.f7040a;
    }

    public static final InterfaceC5063a<Y8.t> p(Context context, int i10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, final InterfaceC5063a<Y8.t> onConfirm, final InterfaceC5063a<Y8.t> interfaceC5063a, Object ownerKey) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        View viewInflate = LayoutInflater.from(context).inflate(i10, (ViewGroup) null);
        if (charSequence != null && (textView3 = (TextView) viewInflate.findViewById(R$id.tv_dialog_title)) != null) {
            textView3.setText(charSequence);
        }
        if (charSequence2 != null && (textView2 = (TextView) viewInflate.findViewById(R$id.tv_dialog_message)) != null) {
            textView2.setText(charSequence2);
        }
        if (charSequence3 != null && (textView = (TextView) viewInflate.findViewById(R$id.tv_confirm)) != null) {
            textView.setText(charSequence3);
        }
        kotlin.jvm.internal.p.f(viewInflate);
        final InterfaceC5063a<Y8.t> interfaceC5063aL = l(context, viewInflate, ownerKey, LAYER_CONFIRM, null, null, 48, null);
        if (interfaceC5063aL == null) {
            return new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.N8
                @Override // p9.InterfaceC5063a
                public final Object invoke() {
                    return X8.r();
                }
            };
        }
        final InterfaceC5063a interfaceC5063a2 = new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.O8
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return X8.s(interfaceC5063a, interfaceC5063aL);
            }
        };
        View viewFindViewById = viewInflate.findViewById(R$id.fl_overlay);
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.P8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    X8.t(interfaceC5063a2, view);
                }
            });
        }
        View viewFindViewById2 = viewInflate.findViewById(R$id.ll_dialog_card);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.Q8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    X8.u(view);
                }
            });
        }
        View viewFindViewById3 = viewInflate.findViewById(R$id.tv_cancel);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.R8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    X8.v(interfaceC5063a2, view);
                }
            });
        }
        View viewFindViewById4 = viewInflate.findViewById(R$id.tv_confirm);
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.S8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    X8.w(interfaceC5063aL, onConfirm, view);
                }
            });
        }
        return interfaceC5063aL;
    }

    public static /* synthetic */ InterfaceC5063a q(Context context, int i10, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, Object obj, int i11, Object obj2) {
        if ((i11 & 4) != 0) {
            charSequence = null;
        }
        if ((i11 & 8) != 0) {
            charSequence2 = null;
        }
        if ((i11 & 16) != 0) {
            charSequence3 = null;
        }
        if ((i11 & 64) != 0) {
            interfaceC5063a2 = null;
        }
        return p(context, i10, charSequence, charSequence2, charSequence3, interfaceC5063a, interfaceC5063a2, obj);
    }

    public static final Y8.t r() {
        return Y8.t.f7040a;
    }

    public static final Y8.t s(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2) {
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        interfaceC5063a2.invoke();
        return Y8.t.f7040a;
    }

    public static final void t(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void u(View view) {
    }

    public static final void v(InterfaceC5063a interfaceC5063a, View view) {
        interfaceC5063a.invoke();
    }

    public static final void w(InterfaceC5063a interfaceC5063a, InterfaceC5063a interfaceC5063a2, View view) {
        interfaceC5063a.invoke();
        interfaceC5063a2.invoke();
    }

    public static final InterfaceC5063a<Y8.t> x(Context context, Object ownerKey, String initialTitle, InterfaceC5074l<? super String, Y8.t> onConfirm, final InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(initialTitle, "initialTitle");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.dialog_rename_title, (ViewGroup) null);
        kotlin.jvm.internal.p.f(viewInflate);
        InterfaceC5063a<Y8.t> interfaceC5063aK = k(context, viewInflate, ownerKey, LAYER_RENAME, 52, new InterfaceC5063a() { // from class: com.stepos.ailauncher.chat.view.T8
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return X8.y(interfaceC5063a);
            }
        });
        if (interfaceC5063aK == null) {
            return null;
        }
        C2971t7.h(viewInflate, initialTitle, onConfirm, interfaceC5063aK);
        C3209b.INSTANCE.c();
        C2971t7.n(viewInflate);
        return interfaceC5063aK;
    }

    public static final Y8.t y(InterfaceC5063a interfaceC5063a) {
        C3209b.INSTANCE.d();
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
        return Y8.t.f7040a;
    }
}
