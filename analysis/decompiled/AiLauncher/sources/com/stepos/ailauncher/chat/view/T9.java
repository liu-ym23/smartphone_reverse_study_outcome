package com.stepos.ailauncher.chat.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.stepos.ailauncher.chat.R$layout;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\t\u001a3\u0010\f\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "gapDp", "Lkotlin/Function0;", "LY8/t;", "onUninstall", "Landroid/widget/PopupWindow;", "c", "(Landroid/view/View;FLp9/a;)Landroid/widget/PopupWindow;", "rawX", "rawY", "f", "(Landroid/view/View;FFLp9/a;)Landroid/widget/PopupWindow;", "MENU_CORNER_DP", "F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class T9 {
    private static final float MENU_CORNER_DP = 16.0f;

    /* JADX WARN: Type inference failed for: r0v0, types: [T, android.widget.PopupWindow] */
    public static final PopupWindow c(View anchor, float f10, final InterfaceC5063a<Y8.t> onUninstall) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(onUninstall, "onUninstall");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(anchor.getContext());
        int i10 = R$layout.popup_uninstall_menu;
        View rootView = anchor.getRootView();
        View viewInflate = layoutInflaterFrom.inflate(i10, rootView instanceof ViewGroup ? (ViewGroup) rootView : null, false);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.R9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                T9.e(ref$ObjectRef, onUninstall, view);
            }
        });
        kotlin.jvm.internal.p.f(viewInflate);
        ?? I10 = R5.i(anchor, viewInflate, 16.0f, f10, false, false, false, null, 240, null);
        ref$ObjectRef.f34820a = I10;
        if (I10 != 0) {
            return I10;
        }
        kotlin.jvm.internal.p.A("popup");
        return null;
    }

    public static /* synthetic */ PopupWindow d(View view, float f10, InterfaceC5063a interfaceC5063a, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        return c(view, f10, interfaceC5063a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(Ref$ObjectRef ref$ObjectRef, InterfaceC5063a interfaceC5063a, View view) {
        PopupWindow popupWindow;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("popup");
            popupWindow = null;
        } else {
            popupWindow = (PopupWindow) t10;
        }
        popupWindow.dismiss();
        interfaceC5063a.invoke();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.widget.PopupWindow] */
    public static final PopupWindow f(View anchor, float f10, float f11, final InterfaceC5063a<Y8.t> onUninstall) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(onUninstall, "onUninstall");
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(anchor.getContext());
        int i10 = R$layout.popup_uninstall_menu;
        View rootView = anchor.getRootView();
        View viewInflate = layoutInflaterFrom.inflate(i10, rootView instanceof ViewGroup ? (ViewGroup) rootView : null, false);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.S9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                T9.g(ref$ObjectRef, onUninstall, view);
            }
        });
        kotlin.jvm.internal.p.f(viewInflate);
        ?? K10 = R5.k(anchor, viewInflate, 16.0f, f10, f11, false, false, null, 224, null);
        ref$ObjectRef.f34820a = K10;
        if (K10 != 0) {
            return K10;
        }
        kotlin.jvm.internal.p.A("popup");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Ref$ObjectRef ref$ObjectRef, InterfaceC5063a interfaceC5063a, View view) {
        PopupWindow popupWindow;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("popup");
            popupWindow = null;
        } else {
            popupWindow = (PopupWindow) t10;
        }
        popupWindow.dismiss();
        interfaceC5063a.invoke();
    }
}
