package com.obric.oui.toast;

import android.app.Dialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInDialog$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ Dialog $dialog;

    public OToastModal$showInDialog$1(Dialog r10) {
        this.$dialog = r10;
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
        Dialog r10 = this.$dialog;
        if (r10 != null) goto L6;
        return null;
    L6:
        if (r10.isShowing() != true) goto L15;
        Window r11 = this.$dialog.getWindow();
        if (r11 != null) goto L10;
        View r12 = null;
    L12:
        if ((r12 instanceof ViewGroup) == true) goto L14;
        return null;
    L14:
        return (ViewGroup) r12;
    L10:
        r12 = r11.getDecorView();
        goto L12
    L15:
        return null;
    }
}
