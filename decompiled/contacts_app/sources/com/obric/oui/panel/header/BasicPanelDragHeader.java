package com.obric.oui.panel.header;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BasicPanelHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/oui/panel/header/BasicPanelDragHeader;", "Lcom/obric/oui/panel/header/BasicPanelHeader;", "context", "Landroid/content/Context;", "useAutoSwitchTheme", "", "(Landroid/content/Context;Z)V", "rootView", "Landroid/view/View;", "getView", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BasicPanelDragHeader extends BasicPanelHeader {
    private final View rootView;

    public BasicPanelDragHeader(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r2 = false;
        this(r4, r2, 2, null);
    }

    public /* synthetic */ BasicPanelDragHeader(Context r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = false;
    L5:
        this(r1, r2);
    }

    public BasicPanelDragHeader(Context r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        super(r8, r9, 0, 4, null);
        View r10 = View.inflate(BasicPanelHeader.generateThemedContext$default(this, r8, false, 2, null), R.layout.o_basic_panel_drag_header, null);
        Intrinsics.checkNotNullExpressionValue(r10, "inflate(generateThemedCo…_panel_drag_header, null)");
        this.rootView = r10;
        r10.setLayoutParams(new ViewGroup.LayoutParams(-1, OAttributes.INSTANCE.resolveDimension(getThemedContext(), R.attr.oui_PanelDragHeaderHeight, R.dimen.oui_panel_drag_header_height)));
        r10.setBackgroundColor(0);
    }

    @Override // com.obric.oui.panel.header.BasicPanelHeader
    public View getView() {
        return this.rootView;
    }
}
