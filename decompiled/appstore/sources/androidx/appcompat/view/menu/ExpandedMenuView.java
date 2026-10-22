package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.b0;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ExpandedMenuView extends ListView implements MenuBuilder.ItemInvoker, MenuView, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f492c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MenuBuilder f493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f494b;

    static {
        f492c = new int[]{R.attr.background, R.attr.divider};
    }

    public ExpandedMenuView(Context r10, AttributeSet r11) {
        this(r10, r11, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return this.f494b;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder r10) {
        this.f493a = r10;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public boolean invokeItem(g r10) {
        return this.f493a.performItemAction(r10, 0);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView r10, View r11, int r12, long r13) {
        invokeItem((g) getAdapter().getItem(r12));
    }

    public ExpandedMenuView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11);
        setOnItemClickListener(this);
        b0 r13 = b0.v(r10, r11, f492c, r12, 0);
        if (r13.s(0) == false) goto L6;
        setBackgroundDrawable(r13.g(0));
    L6:
        if (r13.s(1) == false) goto L8;
        setDivider(r13.g(1));
    L8:
        r13.w();
    }
}
