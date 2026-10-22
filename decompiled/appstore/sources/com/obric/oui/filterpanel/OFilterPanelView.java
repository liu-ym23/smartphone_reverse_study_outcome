package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R$id;
import com.obric.common.oui.R$layout;
import com.obric.oui.button.OButton;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0013\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010!\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001eR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006("}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "count", "", "setMaxSelectCount", "(I)V", "Lcom/obric/oui/button/OButton;", "getResetBtn", "()Lcom/obric/oui/button/OButton;", "getConfirmBtn", "", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "getFilterGroupViewSet", "()Ljava/util/Set;", "Landroid/widget/LinearLayout;", "getFilterGroupContainer", "()Landroid/widget/LinearLayout;", "a", "Landroid/widget/LinearLayout;", "filterGroupContainer", "b", "btnContainer", "c", "Lcom/obric/oui/button/OButton;", "btnReset", "d", "btnConfirm", "e", "Ljava/util/Set;", "filterGroupViewList", "f", "I", "maxSelectCount", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f14560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f14561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OButton f14562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OButton f14563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f14564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f14565f;

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public OFilterPanelView(@NotNull Context r10) {
        q.g(r10, "context");
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    @NotNull
    public final OButton getConfirmBtn() {
        return this.f14563d;
    }

    @NotNull
    public final LinearLayout getFilterGroupContainer() {
        return this.f14560a;
    }

    @NotNull
    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.f14564e;
    }

    @NotNull
    public final OButton getResetBtn() {
        return this.f14562c;
    }

    public final void setMaxSelectCount(int r10) {
        this.f14565f = r10;
    }

    public /* synthetic */ OFilterPanelView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public OFilterPanelView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f14564e = new LinkedHashSet();
        this.f14565f = 1;
        ViewGroup.inflate(r10, R$layout.o_layout_filter_panel_view, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, f.r(this, 400)));
        View r12 = findViewById(R$id.filter_group_container);
        q.f(r12, "findViewById(R.id.filter_group_container)");
        this.f14560a = (LinearLayout) r12;
        View r13 = findViewById(R$id.btn_container);
        q.f(r13, "findViewById(R.id.btn_container)");
        this.f14561b = (LinearLayout) r13;
        View r14 = findViewById(R$id.btn_reset);
        q.f(r14, "findViewById(R.id.btn_reset)");
        this.f14562c = (OButton) r14;
        View r15 = findViewById(R$id.btn_confirm);
        q.f(r15, "findViewById(R.id.btn_confirm)");
        this.f14563d = (OButton) r15;
    }
}
