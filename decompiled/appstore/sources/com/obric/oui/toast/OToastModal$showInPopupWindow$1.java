package com.obric.oui.toast;

import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInPopupWindow$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ PopupWindow $popupWindow;
    final /* synthetic */ d this$0;

    public OToastModal$showInPopupWindow$1(PopupWindow r10, d r11) {
        this.$popupWindow = r10;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @Nullable
    public final ViewGroup invoke() {
        PopupWindow r10 = this.$popupWindow;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isShowing() != true) goto L12;
        View r11 = this.$popupWindow.getContentView();
        if (r11 != null) goto L11;
        return null;
    L11:
        return d.a(null, r11);
    L12:
        return null;
    }
}
