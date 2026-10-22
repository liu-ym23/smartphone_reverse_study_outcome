package com.obric.oui.popover.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.obric.common.oui.R$drawable;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.popover.PopoverLinearLayout;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\r\u0010\fR\u0017\u0010\u0013\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/popover/view/GuidePopoverView;", "Lcom/obric/oui/popover/PopoverLinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "charSequence", "", "setStatusText", "(Ljava/lang/CharSequence;)V", "setGuideText", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getTvStatus", "()Landroid/widget/TextView;", "tvStatus", "b", "getTvGuide", "tvGuide", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuidePopoverView extends PopoverLinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f16356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f16357b;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public GuidePopoverView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final TextView getTvGuide() {
        return this.f16357b;
    }

    @NotNull
    public final TextView getTvStatus() {
        return this.f16356a;
    }

    public final void setGuideText(@NotNull CharSequence r10) {
        q.g(r10, "charSequence");
        this.f16357b.setText(r10);
    }

    public final void setStatusText(@NotNull CharSequence r10) {
        q.g(r10, "charSequence");
        this.f16356a.setText(r10);
    }

    public /* synthetic */ GuidePopoverView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public GuidePopoverView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        LinearLayout.inflate(r10, R$layout.o_popover_guide_view, this);
        setOrientation(0);
        int r12 = f.r(this, 12);
        setPadding(r12, r12, r12, r12);
        setBackground(ContextCompat.d(r10, R$drawable.o_popover_view_bg));
        View r13 = findViewById(R$id.tv_status_text);
        q.f(r13, "findViewById(R.id.tv_status_text)");
        this.f16356a = (TextView) r13;
        View r14 = findViewById(R$id.tv_guide_text);
        q.f(r14, "findViewById(R.id.tv_guide_text)");
        this.f16357b = (TextView) r14;
    }
}
