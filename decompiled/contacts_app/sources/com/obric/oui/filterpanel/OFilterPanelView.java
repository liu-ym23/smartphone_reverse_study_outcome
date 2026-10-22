package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.obric.common.oui.R;
import com.obric.oui.button.OButton;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OFilterPanelView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\u0006\u0010\u0019\u001a\u00020\nJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u001b\u001a\u00020\bJ\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "btnConfirm", "Lcom/obric/oui/button/OButton;", "btnContainer", "Landroid/widget/LinearLayout;", "btnReset", "filterGroupContainer", "filterGroupViewList", "", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "filterStyle", "", "maxSelectCount", "addFilterGroup", "", "view", "config", "Lcom/obric/oui/filterpanel/OFilterGroupView$Config;", "getConfirmBtn", "getFilterGroupContainer", "getFilterGroupViewSet", "getResetBtn", "setFilterStyle", "isAlwaysLight", "", "setMaxSelectCount", "count", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OFilterPanelView extends ConstraintLayout {
    private final OButton btnConfirm;
    private final LinearLayout btnContainer;
    private final OButton btnReset;
    private final LinearLayout filterGroupContainer;
    private final Set<OFilterGroupView> filterGroupViewList;
    private int filterStyle;
    private int maxSelectCount;

    /* JADX WARN: Multi-variable type inference failed */
    public OFilterPanelView(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ OFilterPanelView(Context r1, AttributeSet r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public OFilterPanelView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.filterGroupViewList = new LinkedHashSet();
        this.maxSelectCount = 1;
        ConstraintLayout.inflate(r2, R.layout.o_layout_filter_panel_view, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, OUnitExtensionKt.vdp(this, 400)));
        View r4 = findViewById(R.id.filter_group_container);
        Intrinsics.checkNotNullExpressionValue(r4, "findViewById(R.id.filter_group_container)");
        this.filterGroupContainer = (LinearLayout) r4;
        View r5 = findViewById(R.id.btn_container);
        Intrinsics.checkNotNullExpressionValue(r5, "findViewById(R.id.btn_container)");
        this.btnContainer = (LinearLayout) r5;
        View r6 = findViewById(R.id.btn_reset);
        Intrinsics.checkNotNullExpressionValue(r6, "findViewById(R.id.btn_reset)");
        this.btnReset = (OButton) r6;
        View r7 = findViewById(R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(r7, "findViewById(R.id.btn_confirm)");
        this.btnConfirm = (OButton) r7;
    }

    public final void addFilterGroup(OFilterGroupView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        this.filterGroupContainer.addView(r3);
        this.filterGroupViewList.add(r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final OFilterGroupView addFilterGroup(OFilterGroupView.Config r6) {
        Intrinsics.checkNotNullParameter(r6, "config");
        Context r1 = getContext();
        Intrinsics.checkNotNullExpressionValue(r1, "context");
        OFilterGroupView r0 = new OFilterGroupView(r1, null, 2, 0 == true ? 1 : 0);
        Integer r2 = r6.getFilterStyle();
        if (r2 != null) goto L5;
        int r3 = this.filterStyle;
    L6:
        OFilterGroupView.setFilterStyle$default(r0, r3, false, 2, null);
        r0.setTitle(r6.getTitle());
        Integer r4 = r6.getMaxSelectCount();
        if (r4 != null) goto L9;
        int r5 = this.maxSelectCount;
    L10:
        r0.setMaxSelectCount(r5);
        ArrayList r7 = r6.getFilterItems();
        if (r7 != null) goto L13;
        r7 = new ArrayList();
    L13:
        r0.setFilterItems(r7, r6.getColumnCount(), r6.getInitRowCount());
        if (r6.getDefaultSelectIndex() == null) goto L16;
        Integer r8 = r6.getDefaultSelectIndex();
        Intrinsics.checkNotNull(r8);
        r0.select(r8.intValue());
    L16:
        r0.setEnableClickWhenSelected(r6.getEnableClickWhenSelected());
        addFilterGroup(r0);
        return r0;
    L9:
        r5 = r4.intValue();
        goto L10
    L5:
        r3 = r2.intValue();
        goto L6
    }

    public static /* synthetic */ void setFilterStyle$default(OFilterPanelView r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = true;
    L5:
        r0.setFilterStyle(r1, r2);
    }

    public final void setFilterStyle(int r2, boolean r3) {
        this.filterStyle = r2;
        Iterator<T> r1 = this.filterGroupViewList.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        ((OFilterGroupView) r1.next()).setFilterStyle(r2, r3);
        goto L4
    }

    public final void setMaxSelectCount(int r1) {
        this.maxSelectCount = r1;
    }

    public final OButton getResetBtn() {
        return this.btnReset;
    }

    public final OButton getConfirmBtn() {
        return this.btnConfirm;
    }

    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.filterGroupViewList;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.filterGroupContainer;
    }
}
