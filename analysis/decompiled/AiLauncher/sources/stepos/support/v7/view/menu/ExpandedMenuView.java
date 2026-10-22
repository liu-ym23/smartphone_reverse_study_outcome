package stepos.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.U;
import stepos.support.v7.view.menu.c;

/* loaded from: classes5.dex */
public final class ExpandedMenuView extends ListView implements c.b, h, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f40888c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    public c f40889a;

    /* renamed from: b, reason: collision with root package name */
    public int f40890b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // stepos.support.v7.view.menu.h
    public void a(c cVar) {
        this.f40889a = cVar;
    }

    @Override // stepos.support.v7.view.menu.c.b
    public boolean b(e eVar) {
        return this.f40889a.K(eVar, 0);
    }

    public int getWindowAnimations() {
        return this.f40890b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        b((e) getAdapter().getItem(i10));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        U uV = U.v(context, attributeSet, f40888c, i10, 0);
        if (uV.s(0)) {
            setBackgroundDrawable(uV.g(0));
        }
        if (uV.s(1)) {
            setDivider(uV.g(1));
        }
        uV.x();
    }
}
