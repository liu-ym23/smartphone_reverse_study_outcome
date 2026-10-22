package com.obric.oui.dialog.alert.view;

import ad.a;
import ad.b;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.checkbox.OCheckBox;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "only for o demo")
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0014¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/obric/oui/dialog/alert/view/DialogConfirmView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "Landroid/widget/TextView;", "getNormalTextView", "()Landroid/widget/TextView;", "getLinkTextView", "", "onAttachedToWindow", "()V", "a", "Lcom/obric/oui/checkbox/OCheckBox;", "checkBox", "b", "Landroid/widget/TextView;", "tvNormal", "c", "tvLink", "Landroid/widget/RelativeLayout;", "d", "Landroid/widget/RelativeLayout;", "linkContainer", "Landroid/view/ViewGroup;", "e", "Landroid/view/ViewGroup;", "clickContainer", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DialogConfirmView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OCheckBox f14322a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f14323b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f14324c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout f14325d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ViewGroup f14326e;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public DialogConfirmView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ void g(DialogConfirmView r10, View r11) {
        i(r10, r11);
    }

    public static /* synthetic */ void h(DialogConfirmView r10, View r11) {
        j(r10, r11);
    }

    public static final void i(DialogConfirmView r10, View r11) {
        q.g(r10, "this$0");
        r10.f14324c.performClick();
    }

    public static final void j(DialogConfirmView r10, View r11) {
        q.g(r10, "this$0");
        r10.getCheckBox().performClick();
    }

    @NotNull
    public final OCheckBox getCheckBox() {
        return this.f14322a;
    }

    @NotNull
    public final TextView getLinkTextView() {
        return this.f14324c;
    }

    @NotNull
    public final TextView getNormalTextView() {
        return this.f14323b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() != null) goto L5;
        return;
    L5:
        if ((getParent() instanceof ViewGroup) == false) goto L12;
        ViewParent r10 = getParent();
        if (r10 == null) goto L10;
        ViewGroup r11 = (ViewGroup) r10;
        this.f14325d.setPadding(0, r11.getPaddingTop(), 0, r11.getPaddingBottom());
        this.f14325d.setOnClickListener(new a(this));
        r11.setPadding(r11.getPaddingLeft(), 0, r11.getPaddingRight(), 0);
        this.f14326e.setOnClickListener(new b(this));
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public /* synthetic */ DialogConfirmView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public DialogConfirmView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_layout_dialog_options, this);
        int r12 = f.r(this, 5);
        setPadding(r12, r12, r12, 0);
        View r13 = findViewById(R$id.radio);
        q.f(r13, "findViewById(R.id.radio)");
        this.f14322a = (OCheckBox) r13;
        View r14 = findViewById(R$id.tv_normal);
        q.f(r14, "findViewById(R.id.tv_normal)");
        this.f14323b = (TextView) r14;
        View r15 = findViewById(R$id.tv_link);
        q.f(r15, "findViewById(R.id.tv_link)");
        this.f14324c = (TextView) r15;
        View r16 = findViewById(R$id.link_text_container);
        q.f(r16, "findViewById(R.id.link_text_container)");
        this.f14325d = (RelativeLayout) r16;
        View r17 = findViewById(R$id.click_container);
        q.f(r17, "findViewById(R.id.click_container)");
        this.f14326e = (ViewGroup) r17;
    }
}
