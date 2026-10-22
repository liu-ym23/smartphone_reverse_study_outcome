package com.stepos.ailauncher.chat.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.stepos.ailauncher.chat.R$id;
import com.stepos.ailauncher.chat.R$layout;
import com.stepos.ailauncher.chat.R$string;
import io.ktor.http.LinkHeader;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u001aM\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0000¢\u0006\u0004\b\f\u0010\r\u001aE\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0014\u0010\u0016\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Landroid/view/View;", LinkHeader.Parameters.Anchor, "", "rawX", "rawY", "Lkotlin/Function0;", "LY8/t;", "onDismiss", "Lkotlin/Function1;", "Lcom/stepos/ailauncher/chat/view/SessionAction;", "onAction", "Landroid/widget/PopupWindow;", "c", "(Landroid/view/View;FFLp9/a;Lp9/l;)Landroid/widget/PopupWindow;", "Landroid/content/Context;", "context", "", "ownerKey", "onConfirm", "onCancel", "f", "(Landroid/content/Context;Ljava/lang/Object;Lp9/a;Lp9/a;)Lp9/a;", "SESSION_MENU_CORNER_DP", "F", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class O7 {
    private static final float SESSION_MENU_CORNER_DP = 16.0f;

    /* JADX WARN: Type inference failed for: r0v1, types: [T, android.widget.PopupWindow] */
    public static final PopupWindow c(View anchor, float f10, float f11, InterfaceC5063a<Y8.t> interfaceC5063a, final InterfaceC5074l<? super SessionAction, Y8.t> onAction) {
        kotlin.jvm.internal.p.i(anchor, "anchor");
        kotlin.jvm.internal.p.i(onAction, "onAction");
        View viewInflate = LayoutInflater.from(anchor.getContext()).inflate(R$layout.popup_rename_title, (ViewGroup) null);
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ((TextView) viewInflate.findViewById(R$id.tv_rename_title)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.M7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O7.d(ref$ObjectRef, onAction, view);
            }
        });
        ((TextView) viewInflate.findViewById(R$id.tv_delete)).setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.chat.view.N7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                O7.e(ref$ObjectRef, onAction, view);
            }
        });
        kotlin.jvm.internal.p.f(viewInflate);
        ?? K10 = R5.k(anchor, viewInflate, 16.0f, f10, f11, false, false, interfaceC5063a, 96, null);
        ref$ObjectRef.f34820a = K10;
        if (K10 != 0) {
            return K10;
        }
        kotlin.jvm.internal.p.A("popup");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void d(Ref$ObjectRef ref$ObjectRef, InterfaceC5074l interfaceC5074l, View view) {
        PopupWindow popupWindow;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("popup");
            popupWindow = null;
        } else {
            popupWindow = (PopupWindow) t10;
        }
        popupWindow.dismiss();
        interfaceC5074l.invoke(SessionAction.Rename);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void e(Ref$ObjectRef ref$ObjectRef, InterfaceC5074l interfaceC5074l, View view) {
        PopupWindow popupWindow;
        T t10 = ref$ObjectRef.f34820a;
        if (t10 == 0) {
            kotlin.jvm.internal.p.A("popup");
            popupWindow = null;
        } else {
            popupWindow = (PopupWindow) t10;
        }
        popupWindow.dismiss();
        interfaceC5074l.invoke(SessionAction.Delete);
    }

    public static final InterfaceC5063a<Y8.t> f(Context context, Object ownerKey, InterfaceC5063a<Y8.t> onConfirm, InterfaceC5063a<Y8.t> interfaceC5063a) {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(ownerKey, "ownerKey");
        kotlin.jvm.internal.p.i(onConfirm, "onConfirm");
        return X8.p(context, R$layout.dialog_delete_confirm, context.getString(R$string.delete_chat), context.getString(R$string.delete_confirm_message), context.getString(R$string.common_confirm_delete), onConfirm, interfaceC5063a, ownerKey);
    }
}
