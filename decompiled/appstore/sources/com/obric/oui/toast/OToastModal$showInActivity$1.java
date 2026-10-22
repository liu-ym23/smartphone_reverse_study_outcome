package com.obric.oui.toast;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInActivity$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ Activity $activity;

    public OToastModal$showInActivity$1(Activity r10) {
        this.$activity = r10;
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
        Activity r10 = this.$activity;
        if (r10 != null) goto L5;
        return null;
    L5:
        if (r10.isFinishing() == false) goto L7;
        return null;
    L7:
        if (this.$activity.isDestroyed() == true) goto L20;
        Window r11 = this.$activity.getWindow();
        if (r11 != null) goto L12;
        View r12 = null;
    L14:
        if ((r12 instanceof ViewGroup) == true) goto L16;
        return null;
    L16:
        return (ViewGroup) r12;
    L12:
        r12 = r11.getDecorView();
        goto L14
    L20:
        return null;
    }
}
