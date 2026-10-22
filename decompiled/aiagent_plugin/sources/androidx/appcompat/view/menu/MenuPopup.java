package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
abstract class MenuPopup implements AdapterView.OnItemClickListener, d, f {
    private Rect mEpicenterBounds;

    public abstract void addMenu(MenuBuilder r1);

    public boolean closeMenuOnSubMenuOpened() {
        return true;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean collapseItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public boolean expandItemActionView(MenuBuilder r1, MenuItemImpl r2) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.d
    public int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.d
    public void initForMenu(Context r1, MenuBuilder r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
    }

    public abstract void setAnchorView(View r1);

    public abstract void setForceShowIcon(boolean r1);

    public abstract void setGravity(int r1);

    public abstract void setHorizontalOffset(int r1);

    public abstract void setOnDismissListener(PopupWindow.OnDismissListener r1);

    public abstract void setShowTitle(boolean r1);

    public abstract void setVerticalOffset(int r1);

    MenuPopup() {
    }

    public void setEpicenterBounds(Rect r1) {
        this.mEpicenterBounds = r1;
    }

    public Rect getEpicenterBounds() {
        return this.mEpicenterBounds;
    }

    public e getMenuView(ViewGroup r1) {
        throw new UnsupportedOperationException("MenuPopups manage their own views");
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r1, View r2, int r3, long r4) {
        ListAdapter r5 = (ListAdapter) ZeusTransformUtils.preCheckCast(r1.getAdapter(), ListAdapter.class, "com.obric.aiagent.plugin");
        MenuBuilder r6 = toMenuAdapter(r5).mAdapterMenu;
        MenuItem r7 = (MenuItem) ZeusTransformUtils.preCheckCast(r5.getItem(r3), MenuItem.class, "com.obric.aiagent.plugin");
        if (closeMenuOnSubMenuOpened() == false) goto L5;
        int r8 = 0;
    L6:
        r6.performItemAction(r7, this, r8);
        return;
    L5:
        r8 = 4;
        goto L6
    }

    public static int measureIndividualMenuWidth(ListAdapter r9, ViewGroup r10, Context r11, int r12) {
        ListAdapter r13 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r9, ListAdapter.class, "com.obric.aiagent.plugin");
        Context r14 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        int r0 = 0;
        int r1 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int r3 = r13.getCount();
        int r5 = 0;
        int r6 = 0;
        View r7 = null;
    L3:
        if (r0 >= r3) goto L15;
        int r8 = r13.getItemViewType(r0);
        if (r8 == r6) goto L7;
        r7 = null;
        r6 = r8;
    L7:
        if (r10 != null) goto L9;
        r10 = new FrameLayout(r14);
    L9:
        r7 = r13.getView(r0, r7, r10);
        r7.measure(r1, r2);
        int r15 = r7.getMeasuredWidth();
        if (r15 >= r12) goto L11;
        if (r15 <= r5) goto L14;
        r5 = r15;
    L14:
        r0 = r0 + 1;
        goto L3
    L11:
        return r12;
    L15:
        return r5;
    }

    public static MenuAdapter toMenuAdapter(ListAdapter r2) {
        ListAdapter r3 = (ListAdapter) ZeusTransformUtils.wrapperContextForParams(r2, ListAdapter.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r3, HeaderViewListAdapter.class) == false) goto L7;
        return (MenuAdapter) ZeusTransformUtils.preCheckCast(((HeaderViewListAdapter) ZeusTransformUtils.preCheckCast(r3, HeaderViewListAdapter.class, "com.obric.aiagent.plugin")).getWrappedAdapter(), MenuAdapter.class, "com.obric.aiagent.plugin");
    L7:
        return (MenuAdapter) ZeusTransformUtils.preCheckCast(r3, MenuAdapter.class, "com.obric.aiagent.plugin");
    }

    public static boolean shouldPreserveIconSpacing(MenuBuilder r5) {
        int r0 = r5.size();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L15;
        MenuItem r3 = r5.getItem(r2);
        if (r3.isVisible() == false) goto L9;
        if (r3.getIcon() == null) goto L9;
        return true;
    L9:
        r2 = r2 + 1;
        goto L3
    L15:
        return false;
    }
}
