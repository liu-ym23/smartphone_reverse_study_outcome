package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: classes2.dex */
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {
    private static final int[] TINT_ATTRS = null;
    private int mAnimations;
    private MenuBuilder mMenu;

    static {
        TINT_ATTRS = new int[]{R.attr.background, R.attr.divider};
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return this.mAnimations;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r100) {
        this.mMenu = r100;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(MenuItemImpl r100) {
        return this.mMenu.performItemAction(r100, 0);
    }

    public ExpandedMenuView(Context r100, AttributeSet r101) {
        this(r100, r101, R.attr.listViewStyle);
    }

    public ExpandedMenuView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101);
        setOnItemClickListener(this);
        TintTypedArray r103 = TintTypedArray.obtainStyledAttributes(r100, r101, TINT_ATTRS, r102, 0);
        if (r103.hasValue(0) == false) goto L6;
        setBackgroundDrawable(r103.getDrawable(0));
    L6:
        if (r103.hasValue(1) == false) goto L8;
        setDivider(r103.getDrawable(1));
    L8:
        r103.recycle();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r100, View r101, int r102, long r103) {
        invokeItem((MenuItemImpl) getAdapter().getItem(r102));
    }
}
