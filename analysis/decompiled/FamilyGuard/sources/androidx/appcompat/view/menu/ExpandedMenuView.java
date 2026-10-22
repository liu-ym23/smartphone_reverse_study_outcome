package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.a0;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements e.b, k, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f7791c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    private e f7792a;

    /* renamed from: b, reason: collision with root package name */
    private int f7793b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.e.b
    public boolean a(g gVar) {
        return this.f7792a.M(gVar, 0);
    }

    @Override // androidx.appcompat.view.menu.k
    public void e(e eVar) {
        this.f7792a = eVar;
    }

    public int getWindowAnimations() {
        return this.f7793b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        a((g) getAdapter().getItem(i5));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        a0 a0VarV = a0.v(context, attributeSet, f7791c, i5, 0);
        if (a0VarV.s(0)) {
            setBackgroundDrawable(a0VarV.g(0));
        }
        if (a0VarV.s(1)) {
            setDivider(a0VarV.g(1));
        }
        a0VarV.x();
    }
}
