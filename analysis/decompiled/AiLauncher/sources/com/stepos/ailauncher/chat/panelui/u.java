package com.stepos.ailauncher.chat.panelui;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Landroid/widget/PopupWindow;", "popup", "Lkotlin/Function1;", "Landroid/view/WindowManager$LayoutParams;", "LY8/t;", "transform", "", Const.INTENT_KEY_PKGNAME, "(Landroid/widget/PopupWindow;Lp9/l;)Z", "", "TAG", "Ljava/lang/String;", "chat_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class u {
    private static final String TAG = "PanelLayerVisibility";

    public static final boolean b(PopupWindow popupWindow, InterfaceC5074l<? super WindowManager.LayoutParams, Y8.t> interfaceC5074l) {
        View rootView;
        View contentView = popupWindow.getContentView();
        if (contentView == null || (rootView = contentView.getRootView()) == null) {
            return false;
        }
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return false;
        }
        Object systemService = rootView.getContext().getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager == null) {
            return false;
        }
        interfaceC5074l.invoke(layoutParams2);
        windowManager.updateViewLayout(rootView, layoutParams2);
        return true;
    }
}
