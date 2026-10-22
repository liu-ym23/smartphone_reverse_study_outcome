package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.U;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, j, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f8530c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public e f8531a;

    /* renamed from: b, reason: collision with root package name */
    public int f8532b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(e eVar) {
        this.f8531a = eVar;
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean f(g gVar) {
        return this.f8531a.O(gVar, 0);
    }

    public int getWindowAnimations() {
        return this.f8532b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        f((g) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        U uV = U.v(context, attributeSet, f8530c, i10, 0);
        if (uV.s(0)) {
            setBackgroundDrawable(uV.g(0));
        }
        if (uV.s(1)) {
            setDivider(uV.g(1));
        }
        uV.x();
    }
}
