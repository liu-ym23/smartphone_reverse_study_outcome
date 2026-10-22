package com.obric.oui.selection;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.apm.constant.CommonKey;
import com.obric.common.oui.R$dimen;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.layout.OUIConstraintLayout;
import com.obric.oui.radio.ORadio;
import com.obric.oui.text.OTextView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.l;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\rJ\u0015\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\rJ\r\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001f\u0010\u000fR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\rR\"\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010!\u001a\u0004\b&\u0010#\"\u0004\b'\u0010\rR\u0014\u0010*\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010-\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00106\u001a\u0002048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u00105R\u0016\u00107\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010!R$\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b9\u0010#\"\u0004\b:\u0010\r¨\u0006<"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelItemView;", "Lcom/obric/oui/layout/OUIConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "isMultiSelect", "showDivider", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ZZ)V", "", "setDividerMode", "(Z)V", "h", "()V", "show", "k", "setSelectMode", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "Lcom/obric/oui/text/OTextView;", "getTextView", "()Lcom/obric/oui/text/OTextView;", "Lcom/obric/oui/radio/ORadio;", "getRadioView", "()Lcom/obric/oui/radio/ORadio;", "Lcom/obric/oui/checkbox/OCheckBox;", "getCheckBox", "()Lcom/obric/oui/checkbox/OCheckBox;", "g", "a", "Z", "j", "()Z", "setMultiSelect", "b", "getShowDivider", "setShowDivider", "c", "Landroid/widget/ImageView;", "ivIcon", "d", "Lcom/obric/oui/text/OTextView;", "tvText", "e", "Lcom/obric/oui/radio/ORadio;", "radio", "f", "Lcom/obric/oui/checkbox/OCheckBox;", "checkbox", "Landroid/view/View;", "Landroid/view/View;", "divider", "showSelectLabel", CommonKey.KEY_VALUE, "i", "setItemSelected", "isItemSelected", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelItemView extends OUIConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f16735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f16736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OTextView f16737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ORadio f16738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final OCheckBox f16739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f16740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f16741h;

    public static final class a extends androidx.core.view.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OSelectionPanelItemView f16742a;

        public a(OSelectionPanelItemView r10) {
            this.f16742a = r10;
        }

        @Override // androidx.core.view.a
        public void onInitializeAccessibilityNodeInfo(View r10, AccessibilityNodeInfoCompat r11) {
            super.onInitializeAccessibilityNodeInfo(r10, r11);
            if (this.f16742a.j() == true) goto L5;
            return;
        L5:
            if (this.f16742a.i() == false) goto L11;
            if (r10 == null) goto L12;
            r10.setSelected(true);
            return;
        L12:
            return;
        }
    }

    @JvmOverloads
    public OSelectionPanelItemView(@NotNull Context r10) {
        q.g(r10, "context");
        AttributeSet r11 = null;
        boolean r12 = false;
        boolean r13 = false;
        this(r10, r11, r12, r13, 14, null);
    }

    private final void setDividerMode(boolean r10) {
        if (r10 == false) goto L4;
        l.m(this.f16740g);
        return;
    L4:
        l.k(this.f16740g);
    }

    public final void g() {
        ViewCompat.p0(this, new a(this));
    }

    @NotNull
    public final OCheckBox getCheckBox() {
        return this.f16739f;
    }

    @NotNull
    public final ImageView getIconView() {
        return this.f16736c;
    }

    @NotNull
    public final ORadio getRadioView() {
        return this.f16738e;
    }

    public final boolean getShowDivider() {
        return this.f16735b;
    }

    @NotNull
    public final OTextView getTextView() {
        return this.f16737d;
    }

    public final void h() {
        l.k(this.f16740g);
    }

    public final boolean i() {
        if (this.f16734a == false) goto L6;
        return this.f16739f.isChecked();
    L6:
        return this.f16738e.isChecked();
    }

    public final boolean j() {
        return this.f16734a;
    }

    public final void k(boolean r10) {
        this.f16741h = r10;
        if (r10 == false) goto L5;
        setSelectMode(this.f16734a);
        return;
    L5:
        l.k(this.f16739f);
        l.k(this.f16738e);
    }

    public final void setItemSelected(boolean r10) {
        if (this.f16734a == false) goto L5;
        this.f16739f.setChecked(r10);
    L7:
        if (this.f16741h == true) goto L10;
        l.l(this.f16738e);
        return;
    L10:
        return;
    L5:
        this.f16738e.setChecked(r10);
        goto L7
    }

    public final void setMultiSelect(boolean r10) {
        this.f16734a = r10;
    }

    public final void setSelectMode(boolean r10) {
        this.f16734a = r10;
        if (r10 == false) goto L5;
        l.m(this.f16739f);
        l.k(this.f16738e);
    L6:
        setItemSelected(i());
        return;
    L5:
        l.k(this.f16739f);
        l.m(this.f16738e);
        goto L6
    }

    public final void setShowDivider(boolean r10) {
        this.f16735b = r10;
    }

    @JvmOverloads
    public OSelectionPanelItemView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        boolean r12 = false;
        boolean r13 = false;
        this(r10, r11, r12, r13, 12, null);
    }

    public /* synthetic */ OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = false;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        this(r10, r11, r12, r13);
    }

    public OSelectionPanelItemView(Context r10, AttributeSet r11, boolean r12, boolean r13) {
        q.g(r10, "context");
        super(r10, r11, 0, null, 12, null);
        this.f16734a = r12;
        this.f16735b = r13;
        this.f16741h = true;
        ViewGroup.inflate(r10, R$layout.o_view_selection_item, this);
        setMinHeight((int) getResources().getDimension(R$dimen.oui_h_l2));
        View r14 = findViewById(R$id.iv_icon);
        q.f(r14, "findViewById(R.id.iv_icon)");
        this.f16736c = (ImageView) r14;
        View r15 = findViewById(R$id.tv_text);
        q.f(r15, "findViewById(R.id.tv_text)");
        this.f16737d = (OTextView) r15;
        View r16 = findViewById(R$id.radio);
        q.f(r16, "findViewById(R.id.radio)");
        this.f16738e = (ORadio) r16;
        View r17 = findViewById(R$id.checkbox);
        q.f(r17, "findViewById(R.id.checkbox)");
        OCheckBox r18 = (OCheckBox) r17;
        this.f16739f = r18;
        View r19 = findViewById(R$id.divider);
        q.f(r19, "findViewById(R.id.divider)");
        this.f16740g = r19;
        r18.setClickable(false);
        setRadius((int) getResources().getDimension(R$dimen.oui_r_l3_rect));
        setSelectMode(this.f16734a);
        setDividerMode(this.f16735b);
        Resources r20 = getResources();
        int r110 = R$dimen.oui_p_list_item_2;
        setPadding(r20.getDimensionPixelSize(r110), getPaddingTop(), getResources().getDimensionPixelSize(r110), getPaddingBottom());
        g();
    }
}
