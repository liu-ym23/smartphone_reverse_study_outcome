package com.obric.oui.dialog.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.common.primitives.Ints;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0014¨\u0006\r"}, d2 = {"Lcom/obric/oui/dialog/base/DialogRootView;", "Lcom/obric/oui/dialog/alert/view/RadiusLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogRootView extends RadiusLayout {
    @JvmOverloads
    public DialogRootView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        int r12 = 0;
        this(r10, r11, r12, 6, null);
    }

    @Override // com.obric.oui.dialog.alert.view.RadiusLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int r10, int r11) {
        Context r12 = getContext();
        q.f(r12, "context");
        int r13 = (int) (((double) tc.f.m(r12)) * 0.9d);
        int r14 = View.MeasureSpec.getSize(r11);
        int r15 = View.MeasureSpec.getMode(r11);
        if (r15 == Integer.MIN_VALUE) goto L7;
        if (r15 == 0) goto L6;
        int r16 = View.MeasureSpec.makeMeasureSpec(Math.min(r14, r13), Ints.MAX_POWER_OF_TWO);
    L9:
        if (View.MeasureSpec.getMode(r10) != Integer.MIN_VALUE) goto L11;
        Context r17 = getContext();
        q.f(r17, "context");
        r10 = View.MeasureSpec.makeMeasureSpec(tc.f.n(r17), Ints.MAX_POWER_OF_TWO);
    L11:
        super.onMeasure(r10, r16);
        return;
    L6:
        r16 = View.MeasureSpec.makeMeasureSpec(r13, Integer.MIN_VALUE);
        goto L9
    L7:
        r16 = View.MeasureSpec.makeMeasureSpec(Math.min(r14, r13), Integer.MIN_VALUE);
        goto L9
    }

    @JvmOverloads
    public DialogRootView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        int r12 = 0;
        this(r10, r11, r12, 4, null);
    }

    public /* synthetic */ DialogRootView(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    @JvmOverloads
    public DialogRootView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }
}
