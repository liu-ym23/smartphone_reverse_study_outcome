package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tc.f;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "b", "()Z", "", "a", "()V", "Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "listener", "registerItemSelectListener", "(Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;)V", "getSelectedItem", "()I", "OnItemSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSingleSelectionPanelView extends OSelectionPanelView {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "", "onItemSelected", "", "view", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnItemSelectListener {
        void onItemSelected(@NotNull OSelectionPanelItemView r10, int r11);
    }

    public OSingleSelectionPanelView(@NotNull Context r10, @Nullable AttributeSet r11, int r12) {
        q.g(r10, "context");
        super(r10, r11, r12);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void a() {
        if (getContext().getResources().getConfiguration().orientation != 2) goto L9;
        if (getItemViews().size() <= 2) goto L7;
        setScrollViewHeight(f.r(this, 112));
        return;
    L7:
        setScrollViewHeight(-2);
        return;
    L9:
        if (getItemViews().size() <= 7) goto L11;
        setScrollViewHeight(f.r(this, 424));
        return;
    L11:
        setScrollViewHeight(-2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public boolean b() {
        return false;
    }

    public final int getSelectedItem() {
        Iterator<T> r10 = getItemViews().iterator();
        int r11 = 0;
    L4:
        if (r10.hasNext() == false) goto L12;
        Object r12 = r10.next();
        int r13 = r11 + 1;
        if (r11 >= 0) goto L9;
        t.q();
    L9:
        if (((OSelectionPanelItemView) r12).i() == true) goto L10;
        r11 = r13;
        goto L4
    L10:
        return r11;
    L12:
        return -1;
    }

    public final void registerItemSelectListener(@NotNull OnItemSelectListener r10) {
        q.g(r10, "listener");
        setOnItemSelectListener(r10);
    }
}
