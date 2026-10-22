package stepos.support.v7.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.a0;
import stepos.support.v7.view.menu.d;

/* loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements d.b, i, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f21224c = {R.attr.background, R.attr.divider};

    /* renamed from: a, reason: collision with root package name */
    private d f21225a;

    /* renamed from: b, reason: collision with root package name */
    private int f21226b;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // stepos.support.v7.view.menu.i
    public void b(d dVar) {
        this.f21225a = dVar;
    }

    @Override // stepos.support.v7.view.menu.d.b
    public boolean d(f fVar) {
        return this.f21225a.K(fVar, 0);
    }

    public int getWindowAnimations() {
        return this.f21226b;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        d((f) getAdapter().getItem(i5));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        a0 a0VarV = a0.v(context, attributeSet, f21224c, i5, 0);
        if (a0VarV.s(0)) {
            setBackgroundDrawable(a0VarV.g(0));
        }
        if (a0VarV.s(1)) {
            setDivider(a0VarV.g(1));
        }
        a0VarV.x();
    }
}
