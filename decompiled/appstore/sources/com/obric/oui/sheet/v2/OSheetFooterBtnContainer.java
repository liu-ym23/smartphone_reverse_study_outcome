package com.obric.oui.sheet.v2;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007JI\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0012\u0010\u0013JI\u0010\u0017\u001a\u00020\u00112\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cR$\u0010\"\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010%\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/obric/oui/sheet/v2/OSheetFooterBtnContainer;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "negativeBtnTextResId", "", "negativeIsPrimary", "Landroid/view/View$OnClickListener;", "negativeActionEvent", "positiveBtnTextResId", "positiveIsPrimary", "positiveActionEvent", "", "b", "(Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;Ljava/lang/Integer;ZLandroid/view/View$OnClickListener;)V", "", "negativeBtnText", "positiveBtnText", "c", "(Ljava/lang/String;ZLandroid/view/View$OnClickListener;Ljava/lang/String;ZLandroid/view/View$OnClickListener;)V", "isPrimary", "Lcom/obric/oui/button/OButton;", "a", "(Z)Lcom/obric/oui/button/OButton;", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "setBtnNegative", "(Lcom/obric/oui/button/OButton;)V", "btnNegative", "getBtnPositive", "setBtnPositive", "btnPositive", "Landroid/view/View;", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "setHorizontal_space", "(Landroid/view/View;)V", "horizontal_space", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSheetFooterBtnContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public OButton f16856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public OButton f16857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f16858c;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSheetFooterBtnContainer(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public final OButton a(boolean r10) {
        Context r11 = getContext();
        if (r10 == false) goto L5;
        int r12 = R$layout.oui_widget_panel_primary_btn;
    L6:
        View r13 = LinearLayout.inflate(r11, r12, this);
        if (r13 == null) goto L15;
        ViewGroup r14 = (ViewGroup) r13;
        View r15 = r14.getChildAt(r14.getChildCount() - 1);
        if (r15 == null) goto L13;
        return (OButton) r15;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.button.OButton");
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    L5:
        r12 = R$layout.oui_widget_panel_netural_btn;
        goto L6
    }

    public final void b(Integer r10, boolean r11, View.OnClickListener r12, Integer r13, boolean r14, View.OnClickListener r15) {
        String r16 = null;
        if (r10 == null) goto L5;
        String r17 = getResources().getString(r10.intValue());
    L6:
        if (r13 == null) goto L8;
        r16 = getResources().getString(r13.intValue());
    L8:
        c(r17, r11, r12, r16, r14, r15);
        return;
    L5:
        r17 = null;
        goto L6
    }

    public final void c(String r10, boolean r11, View.OnClickListener r12, String r13, boolean r14, View.OnClickListener r15) {
        if (r10 != null) goto L5;
        char r16 = 0;
    L18:
        if (r16 <= 0) goto L27;
        View r17 = new View(getContext());
        this.f16858c = r17;
        addView(r17);
        View r18 = this.f16858c;
        if (r18 == null) goto L23;
        td.i.e(r18, tc.f.r(this, 12));
    L23:
        View r19 = this.f16858c;
        if (r19 == null) goto L27;
        td.i.c(r19, tc.f.r(this, 1));
    L27:
        if (r13 == null) goto L42;
        setBtnPositive(a(r14));
        OButton r20 = getBtnPositive();
        if (r20 == null) goto L33;
        r20.setId(R$id.btn_positive);
    L33:
        OButton r21 = getBtnPositive();
        if (r21 == null) goto L37;
        r21.setOnClickListener(r15);
    L37:
        OButton r22 = getBtnPositive();
        if (r22 == null) goto L43;
        r22.setText(r13);
        return;
    L43:
        return;
    L42:
        return;
    L5:
        setBtnNegative(a(r11));
        OButton r23 = getBtnNegative();
        if (r23 == null) goto L9;
        r23.setId(R$id.btn_negative);
    L9:
        OButton r24 = getBtnNegative();
        if (r24 == null) goto L13;
        r24.setOnClickListener(r12);
    L13:
        OButton r25 = getBtnNegative();
        if (r25 == null) goto L17;
        r25.setText(r10);
    L17:
        r16 = 1;
        goto L18
    }

    @Nullable
    public final OButton getBtnNegative() {
        return this.f16856a;
    }

    @Nullable
    public final OButton getBtnPositive() {
        return this.f16857b;
    }

    @Nullable
    public final View getHorizontal_space() {
        return this.f16858c;
    }

    public final void setBtnNegative(@Nullable OButton r10) {
        this.f16856a = r10;
    }

    public final void setBtnPositive(@Nullable OButton r10) {
        this.f16857b = r10;
    }

    public final void setHorizontal_space(@Nullable View r10) {
        this.f16858c = r10;
    }

    public /* synthetic */ OSheetFooterBtnContainer(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OSheetFooterBtnContainer(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        setOrientation(0);
        int r12 = getResources().getDimensionPixelSize(R$dimen.oui_p_container_large_1);
        int r13 = tc.f.r(this, 8);
        setPadding(r12, r13, r12, r13);
    }
}
