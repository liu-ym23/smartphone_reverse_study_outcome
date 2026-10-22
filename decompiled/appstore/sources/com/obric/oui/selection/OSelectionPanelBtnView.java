package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "This class has been deprecated. ")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\r\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0016\u001a\u00020\u00118\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lcom/obric/oui/button/OButton;", "a", "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "btnNegative", "b", "getBtnPositive", "btnPositive", "Landroid/view/View;", "c", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "horizontal_space", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OSelectionPanelBtnView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OButton f16731a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f16732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f16733c;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OSelectionPanelBtnView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final OButton getBtnNegative() {
        return this.f16731a;
    }

    @NotNull
    public final OButton getBtnPositive() {
        return this.f16732b;
    }

    @NotNull
    public final View getHorizontal_space() {
        return this.f16733c;
    }

    public /* synthetic */ OSelectionPanelBtnView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OSelectionPanelBtnView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        ViewGroup.inflate(r10, R$layout.o_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        View r12 = findViewById(R$id.btn_negative);
        q.f(r12, "findViewById(R.id.btn_negative)");
        this.f16731a = (OButton) r12;
        View r13 = findViewById(R$id.btn_positive);
        q.f(r13, "findViewById(R.id.btn_positive)");
        this.f16732b = (OButton) r13;
        View r14 = findViewById(R$id.horizontal_space);
        q.f(r14, "findViewById(R.id.horizontal_space)");
        this.f16733c = r14;
    }
}
